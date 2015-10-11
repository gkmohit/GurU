package com.unknown.gkmohit.guru;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import com.reimaginebanking.api.java.NessieClient;
import com.reimaginebanking.api.java.NessieException;
import com.reimaginebanking.api.java.NessieResultsListener;
import com.reimaginebanking.api.java.models.Customer;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

public class DashboardActivity extends AppCompatActivity {

    public static String TAG = DashboardActivity.class.getSimpleName();
    @Bind(R.id.nameTextView)
    TextView mNameTV;
    @Bind(R.id.addressTextView)
    TextView mAddressTV;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        ButterKnife.bind(this);
        NessieClient nessieClient = NessieClient.getInstance();
        nessieClient.setAPIKey("aaac90dbd742db8c24cb199b92a5f345");
        nessieClient.getCustomers(new NessieResultsListener() {
            @Override
            public void onSuccess(Object result, NessieException e) {
                if (e == null) {
                    //There is no error, do whatever you need here.
                    // Cast the result object to the type that you are requesting and you are good to go
                    ArrayList<Customer> customers = (ArrayList<Customer>) result;
                    mNameTV.setText("Hello " + customers.get(0).getFirst_name() + customers.get(0).getLast_name());
                    String address = customers.get(0).getAddress().toString();
//                    try {
//                        JSONObject jsonAddress = new JSONObject(address);
//                        String blah = jsonAddress.getString("Address");
//                        mAddressTV.setText(address);
//                    } catch (JSONException e1) {
//                        e1.printStackTrace();
//                    }
                    mAddressTV.setText(customers.get(0).toString());
                } else {
                    //There was an error. Handle it here
                    Log.e("Error", e.toString());
                }
            }
        });
    }

}
