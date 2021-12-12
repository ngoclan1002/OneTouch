package com.example.onetouch;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {
    EditText usernameEditText, passwordEditText;
    Button loginButton;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        usernameEditText = (EditText) findViewById(R.id.username);
        passwordEditText = (EditText) findViewById(R.id.password);
        loginButton = (Button) findViewById(R.id.login);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               login(usernameEditText.getText().toString(), passwordEditText.getText().toString());
//                Intent intent_main = new Intent(LoginActivity.this, MainActivity.class);
//                startActivity(intent_main);
//                finish();
            }
        });
    }

    public void login(String username, String password){
        if( username.equals("lan")  && password.equals("123")){
            Toast.makeText(getApplicationContext(), "Wellcome!",Toast.LENGTH_SHORT).show();
            Intent intent_main = new Intent(LoginActivity.this, MainActivity.class);
            startActivity(intent_main);
            finish();
        }else{
            Toast.makeText(getApplicationContext(), "Username or Password is incorrect",Toast.LENGTH_SHORT).show();
        }
    }
}
