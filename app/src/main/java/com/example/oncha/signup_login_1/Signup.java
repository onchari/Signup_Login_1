package com.example.oncha.signup_login_1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Signup extends AppCompatActivity implements View.OnClickListener {
    EditText username;
    EditText password;
    EditText confirm_password;
    Button btn_signup;
    LoginDataBaseAdapter loginDataBaseAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup_activity);

        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);
        btn_signup = (Button) findViewById(R.id.btn_signup);
        btn_signup.setOnClickListener(this);

      loginDataBaseAdapter = new LoginDataBaseAdapter(this);
        loginDataBaseAdapter = loginDataBaseAdapter.open();
    }

    @Override
    public void onClick(View v) {
        String userName = username.getText().toString();
        String passWord = password.getText().toString();


        if(userName.equals("") || passWord.equals("")){
            Toast.makeText(getApplicationContext(), "Fill all the fields.", Toast.LENGTH_LONG).show();
        }

        else{
            boolean successs = loginDataBaseAdapter.insertEntry(userName,passWord);
            if(successs == true){
                Toast.makeText(getApplicationContext(), "Sucessfully registered", Toast.LENGTH_LONG).show();
            }else {
                Toast.makeText(getApplicationContext(), "Failed to register.", Toast.LENGTH_LONG).show();
            }
        }

    }
}
