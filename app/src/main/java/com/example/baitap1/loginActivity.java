package com.example.baitap1;

import android.app.Application;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class loginActivity extends AppCompatActivity {
    EditText username;
    EditText password;
    Button register;
    Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        setupUI();
        setupListeners();
    }

    void checkUsername() {
        boolean isValid = true;
        if(isEmpty(username)) {
            username.setError("You must enter username to login!");
            isValid = false;
        } else {
            if(!isEmail(username)) {
                username.setError("Enter valid email!");
                isValid = false;
            }
        }

        if(isValid) {
            String usernameValue = username.getText().toString();
            String passwordValue = password.getText().toString();
            if(usernameValue.equals("duongdh@gmail.com") && passwordValue.equals("123456")) {
                // everything checked, open new activity
                Intent intent = new Intent(loginActivity.this, firstActivity.class);
                startActivity(intent);
                //ve close this activity
                this.finish();
            } else {
                Toast toast = Toast.makeText(this, "Wrong email or password", Toast.LENGTH_SHORT);
                toast.show();
            }
        }
    }

    boolean isEmpty(EditText text) {
        CharSequence str = text.getText().toString();
        return TextUtils.isEmpty(str);
    }

    boolean isEmail(EditText text) {
        CharSequence str = text.getText().toString();
        return (!isEmpty(text) && Patterns.EMAIL_ADDRESS.matcher(str).matches());
    }

    private void setupUI() {
        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        register = findViewById(R.id.register);
        login = findViewById(R.id.login);
    }

    private void setupListeners() {
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkUsername();
            }
        });

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(loginActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
