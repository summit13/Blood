package com.example.blooddonor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
{

    TextView register;
    Button intent1;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        register = findViewById(R.id.register);
        register.setPaintFlags(register.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG); //for underline under the text in TextView

        intent1 = findViewById(R.id.intent1);

    }

    public void registerAction(View view)
    {
        Intent intent = new Intent(MainActivity.this,Register.class);
        startActivity(intent);
    }

    public void calculate(View view)
    {
        Intent intent = new Intent(MainActivity.this,BMI_Calculator.class);
        startActivity(intent);
    }

    public void navigate(View view)
    {
        Intent intent = new Intent(MainActivity.this,Homepage.class);
        startActivity(intent);
    }

}
