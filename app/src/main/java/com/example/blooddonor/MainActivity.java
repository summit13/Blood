package com.example.blooddonor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
{
    TextView register;
    EditText emailField, passwordField;
    String email, password;
    Button login;
    DatabaseHelper myDb;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myDb = new DatabaseHelper(this);
        init();

        register.setPaintFlags(register.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG); //for underline under the text in TextView

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                email = emailField.getText().toString();
                password = passwordField.getText().toString();
                Boolean login = myDb.login(email,password);
                if(login == true) {
                    Toast.makeText(getApplicationContext(), "Login Successful", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(MainActivity.this, Homepage.class);
                    intent.putExtra("userEmail",email);
                    startActivity(intent);
                } else {
                    Toast.makeText(getApplicationContext(), "Incorrect email or password", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }

    public void init()
    {
        emailField = findViewById(R.id.emailField);
        passwordField = findViewById(R.id.passwordField);
        login = findViewById(R.id.loginButton);
        register = findViewById(R.id.register);
    }

    public void registerAction(View view)
    {
        Intent intent = new Intent(MainActivity.this,Register.class);
        startActivity(intent);
    }

}
