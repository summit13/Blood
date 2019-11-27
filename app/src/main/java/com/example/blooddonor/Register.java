package com.example.blooddonor;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

public class Register extends AppCompatActivity {

    EditText nameField, addressField, dobField, phoneField, usernameField, passwordField, confirmPasswordField;
    Button getImageButton,registerButton;
    ImageView imageField;
    Spinner bloodGroupField;
    String name, address, dob, phone, username, password, bloodGroup;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        init();

    }

    private void init()
    {
        nameField = findViewById(R.id.nameField);
        addressField = findViewById(R.id.addressField);
        dobField = findViewById(R.id.dobField);
        phoneField = findViewById(R.id.phoneField);
        usernameField = findViewById(R.id.usernameField);
        passwordField = findViewById(R.id.passwordField);
        confirmPasswordField = findViewById(R.id.confirmPasswordField);
        //getImageButton = findViewById(R.id.getImageButton);
        registerButton = findViewById(R.id.registerButton);
        //imageField = findViewById(R.id.imageField);
        bloodGroupField = findViewById(R.id.bloodGroup);
    }

    public void checkEmpty(View view)
    {
        if(nameField.getText().toString().matches(""))
        {
            Toast.makeText(this, "Enter Name",Toast.LENGTH_LONG).show();
        }
        else if(addressField.getText().toString().matches(""))
        {
            Toast.makeText(this, "Enter Address",Toast.LENGTH_LONG).show();
        }
        else if(dobField.getText().toString().matches(""))
        {
            Toast.makeText(this, "Enter DOB",Toast.LENGTH_LONG).show();
        }
        else if(phoneField.getText().toString().matches(""))
        {
            Toast.makeText(this, "Enter Phone Number",Toast.LENGTH_LONG).show();
        }
        else if(usernameField.getText().toString().matches(""))
        {
            Toast.makeText(this, "Enter Username",Toast.LENGTH_LONG).show();
        }
        else if(passwordField.getText().toString().matches(""))
        {
            Toast.makeText(this, "Enter Password",Toast.LENGTH_LONG).show();
        }
        else if(confirmPasswordField.getText().toString().matches(""))
        {
            Toast.makeText(this, "Enter Confirm Password",Toast.LENGTH_LONG).show();
        }
        else
        {
            verifyInfo();
        }

    }

    public void verifyInfo()
    {

        if (phoneField.getText().toString().length()!=10)
        {
            Toast.makeText(this, "Enter Proper Phone Number",Toast.LENGTH_LONG).show();
        }
        else if (passwordField.getText().toString().equals(confirmPasswordField.getText().toString()))
        {
            addUser();
        }
        else
        {
            Toast.makeText(this, "The passwords do not match",Toast.LENGTH_LONG).show();
        }

    }

    public void addUser()
    {
//        connectivity connectivity = new connectivity(this);
//        String result = connectivity.addUser(
//                nameField.getText().toString(),
//                addressField.getText().toString(),
//                dobField.getText().toString(),
//                phoneField.getText().toString(),
//                usernameField.getText().toString(),
//                passwordField.getText().toString(),
//                bloodGroupField.getSelectedItem().toString());
//
//        Toast.makeText(this, result,Toast.LENGTH_LONG).show();
//
//        nameField.setText("");
//        addressField.setText("");
//        phoneField.setText("");
//        dobField.setText("");
//        usernameField.setText("");
//        passwordField.setText("");
//        confirmPasswordField.setText("");

          name = nameField.getText().toString();
          address = addressField.getText().toString();
          dob = dobField.getText().toString();
          phone = phoneField.getText().toString();
          username = usernameField.getText().toString();
          password = passwordField.getText().toString();
          bloodGroup = bloodGroupField.getSelectedItem().toString();

          String method = "register";
          BackgroundTask backgroundTask = new BackgroundTask(this);
          backgroundTask.execute(method, name, address, dob, phone, username, password, bloodGroup);

    }
}
