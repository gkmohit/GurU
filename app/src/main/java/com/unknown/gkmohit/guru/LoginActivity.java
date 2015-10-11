package com.unknown.gkmohit.guru;

import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;
import com.unknown.gkmohit.guru.Model.InIn;

import java.io.IOException;

import butterknife.Bind;
import butterknife.ButterKnife;

public class LoginActivity extends AppCompatActivity {

    private String TAG = LoginActivity.class.getSimpleName();
    @Bind(R.id.emailEditText)
    EditText mEmailET;
    @Bind(R.id.passwordEditText)
    EditText mPasswordET;
    @Bind(R.id.logInButton)
    Button mLogInButton;
    @Bind(R.id.forgotPasswordButton) Button mForgotPassowrdButton;
    @Bind(R.id.signUpButton) Button mSignUpButton;
    private InIn mInIn = new InIn();
    private final String POST_URL = new String("http://guru.myBlumix.net/login");
    public static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        ButterKnife.bind(this);
        if (android.os.Build.VERSION.SDK_INT > 9) {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }
        mSignUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //create an intent like
                Intent registrationActivity = new Intent(LoginActivity.this, RegistrationActivity.class);
                startActivity(registrationActivity);
                //add extras to intent if needed
                LoginActivity.this.finish();
            }
        });

        mLogInButton.setOnClickListener(new View.OnClickListener() {
            OkHttpClient httpClient = new OkHttpClient();
            @Override
            public void onClick(View view) {

                //Request request = new Request().
                try {
                    Toast.makeText(LoginActivity.this, "in try loop", Toast.LENGTH_SHORT).show();
                    //if(mEmailET.getText().toString().trim().length() > 0 && mPasswordET.getText().toString().trim().length() > 0){
                        Toast.makeText(LoginActivity.this, "In if statement", Toast.LENGTH_LONG).show();
                        String email = getInIn().getEmail();
                        String password = getInIn().getPassword();
                        String json = "{ email : " + email + " , " + "password : " + password + "}";
                        Toast.makeText(LoginActivity.this, post(POST_URL, json), Toast.LENGTH_SHORT).show();
                    //}

                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    Toast.makeText(LoginActivity.this, "IN THE CATCH", Toast.LENGTH_SHORT).show();
                    e.printStackTrace();
                }

            }

            private String post(String url, String json) throws IOException {
                RequestBody body = RequestBody.create(JSON, json);
                Request request = new Request.Builder()
                        .url(url)
                        .post(body)
                        .build();
                Response response = httpClient.newCall(request).execute();
                String returnVal = new String(response.body().string());
                Log.i(TAG, returnVal);
                return returnVal;
            }
        });
    }

    public InIn getInIn() {
        return mInIn;
    }

    public void setInIn(InIn inIn) {
        mInIn = inIn;
    }



}
