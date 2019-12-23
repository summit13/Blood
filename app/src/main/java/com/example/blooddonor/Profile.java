package com.example.blooddonor;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Profile extends Fragment {
    public String userEmail;
    EditText userAddress, userDob, userPhone, userPassword;
    ArrayList<String> arrayList;
    DatabaseHelper db;
    Button update;
    public Profile() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        db = new DatabaseHelper(getContext());
        arrayList = new ArrayList<>();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_profile, container, false);
        userAddress = view.findViewById(R.id.userAddress);
        userDob = view.findViewById(R.id.userDob);
        userPhone = view.findViewById(R.id.userPhone);
        userPassword = view.findViewById(R.id.userPassword);
        update = view.findViewById(R.id.updateButton);
        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                db.updateInfo(userAddress.getText().toString(), userDob.getText().toString(), userPhone.getText().toString(), userPassword.getText().toString());
                Intent intent = new Intent(getContext(),Homepage.class);
                startActivity(intent);

            }
        });

        arrayList=db.viewProfile();
        Log.i("Length of array",String.valueOf(arrayList.size()));
        String address = arrayList.get(0);
        String dob = arrayList.get(1);
        String phone = arrayList.get(2);
        String password = arrayList.get(3);

        userAddress.setText(address);
        userDob.setText(dob);
        userPhone.setText(phone);
        userPassword.setText(password);

        return view;
    }
}
