package com.example.blooddonor;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.InputFilter;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class BMI_Calculator extends AppCompatActivity {
EditText weight, height;
float weight1, height1;
TextView result, convert_result;
Spinner feet, inch;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi__calculator);
        init();
    }

    public void init()
    {
        weight = findViewById(R.id.weight);
        height = findViewById(R.id.height);
        result = findViewById(R.id.result);
        feet = findViewById(R.id.feet);
        inch = findViewById(R.id.inch);
        convert_result = findViewById(R.id.convert_result);
    }

    public void checkValue(View view)
    {
        if(Integer.parseInt(weight.getText().toString())==0 || weight.getText().toString()=="" || Integer.parseInt(weight.getText().toString())<=0)
        {
            Toast.makeText(this,"Please enter valid value",Toast.LENGTH_SHORT).show();
        }
        else
        {
            calculateBMI();
        }
    }

    public void calculateBMI()
    {

        weight1 = Float.parseFloat(weight.getText().toString());
        height1 = Float.parseFloat(height.getText().toString());

        float bmi_result = weight1 / (height1 * height1);

        if (bmi_result < 18.5)
        {
            String output = "Your BMI is "+bmi_result+". This is considered UNDERWEIGHT.";
            result.setText(output);
        }
        else if (bmi_result < 25.0)
        {
            String output = "Your BMI is "+bmi_result+". This is considered NORMAL.";
            result.setText(output);
        }
        else if (bmi_result < 30)
        {
            String output = "Your BMI is "+bmi_result+". This is considered PRE-OBESITY.";
            result.setText(output);
        }
        else if (bmi_result < 35)
        {
            String output = "Your BMI is "+bmi_result+". This is considered OBESITY CLASS I.";
            result.setText(output);
        }
        else if (bmi_result < 40)
        {
            String output = "Your BMI is "+bmi_result+". This is considered OBESITY CLASS II.";
            result.setText(output);
        }
        else if (bmi_result >= 40)
        {
            String output = "Your BMI is "+bmi_result+". This is considered OBESITY CLASS III.";
            result.setText(output);
        }
        else
        {
            String output = "Please enter valid value";
            result.setText(output);
        }

    }

    public void convertmeters(View view)
    {
        Float toConvert = Float.parseFloat(feet.getSelectedItem().toString() + "." + inch.getSelectedItem().toString());
        float meters = (float) (toConvert/3.28);
        height.setText(String.valueOf(meters));
    }
}
