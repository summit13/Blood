package com.example.blooddonor;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class Register extends AppCompatActivity {

    EditText nameField, addressField, dobField, phoneField, emailField, passwordField, confirmPasswordField;
    Spinner bloodGroupField;
    Button registerButton;
    String name, address, dob, phone, email, password, confirmPassword, bloodGroup;

    DatabaseHelper myDb;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        init();

        myDb = new DatabaseHelper(this); //call constructor of DatabaseHelper class
        addUser();

    }

    private void init()
    {
        nameField = findViewById(R.id.nameField);
        addressField = findViewById(R.id.addressField);
        dobField = findViewById(R.id.dobField);
        phoneField = findViewById(R.id.phoneField);
        emailField = findViewById(R.id.emailField);
        passwordField = findViewById(R.id.passwordField);
        confirmPasswordField = findViewById(R.id.confirmPasswordField);
        registerButton = findViewById(R.id.registerButton);
        bloodGroupField = findViewById(R.id.bloodGroup);
    }

    public void getValue()
    {
        name = nameField.getText().toString();
        address = addressField.getText().toString();
        dob = dobField.getText().toString();
        phone = phoneField.getText().toString();
        email = emailField.getText().toString();
        password = passwordField.getText().toString();
        confirmPassword = confirmPasswordField.getText().toString();
        bloodGroup = bloodGroupField.getSelectedItem().toString();
    }

    public void addUser()
    {
        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getValue();
                if(name.equals("")||address.equals("")||dob.equals("")||phone.equals("")||email.equals("")||password.equals("")||confirmPassword.equals(""))
                {
                    Toast.makeText(getApplicationContext(), "Fields are empty.",Toast.LENGTH_LONG).show();
                }
                else{
                    if(password.equals(confirmPassword))
                    {
                        Boolean checkEmail = myDb.checkEmail(email);
                        if (checkEmail==true)
                        {
                            boolean isInserted = myDb.addUser(name, address, dob, phone, email, password, bloodGroup);
                            if(isInserted==true)
                            {
                                Toast.makeText(Register.this, "Registration Success", Toast.LENGTH_SHORT).show();
                            } else {
                                Toast.makeText(Register.this, "Registration Failed", Toast.LENGTH_SHORT).show();
                            }
                        }
                        else {
                            Toast.makeText(getApplicationContext(), "Email Already Exists!",Toast.LENGTH_SHORT).show();
                        }
                    }
                    Toast.makeText(getApplicationContext(),"Passwords do not match",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
