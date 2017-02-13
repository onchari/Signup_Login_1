package com.example.oncha.signup_login_1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
Button login;
    Button signup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        login = (Button) findViewById(R.id.login);
        login.setOnClickListener(this);

        signup = (Button) findViewById(R.id.signup);
        signup.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.login:
                login();
                break;

            case R.id.signup:
                signup();
                break;

            default:

                break;
        }

    }

    private void signup() {
        Intent signup_intent = new Intent(this, Signup.class);
        startActivity(signup_intent);
    }

    private void login() {
        Intent login_intent = new Intent(this, Login.class );
        startActivity(login_intent);
    }
}
