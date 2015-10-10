package com.unknown.gkmohit.guru;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import butterknife.Bind;

public class SignActivity extends AppCompatActivity {

    public static final String TAG = SignActivity.class.getSimpleName();
    public static final String SIGN_UP_URL = new String("\"http://guru.mybluemix.net/sign_up.html\"");

    @Bind(R.id.signInButton)
    Button mSignInButton;
    @Bind(R.id.registerButton) Button mRegisterButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign);
        if(isNetworkAvailable()){
            Toast.makeText(SignActivity.this, "Yay", Toast.LENGTH_LONG).show();

            mSignInButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    
                }
            });
        }
        else{
            Toast.makeText(SignActivity.this, "Dude we need internet here...", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_sign, menu);
        return true;
    }

    private boolean isNetworkAvailable() {

        boolean isAvailable = false;
        ConnectivityManager manager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = manager.getActiveNetworkInfo();
        if( networkInfo != null && networkInfo.isConnected() ){
            isAvailable = true;
        }
        return isAvailable;

    }
}
