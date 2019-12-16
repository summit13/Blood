package com.example.blooddonor;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class BMICalculator extends Fragment {
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    EditText weight, height;
    float weight1, height1;
    TextView result, convert_result;
    Spinner feet, inch;
    Button calculate, calculatemeters;

    public BMICalculator() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override //for layout
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_bmicalculator, container, false);

        //initialising components of layout
        weight = view.findViewById(R.id.weight);
        height = view.findViewById(R.id.height);
        calculate = view.findViewById(R.id.calculate);
        result = view.findViewById(R.id.result);
        feet = view.findViewById(R.id.feet);
        inch = view.findViewById(R.id.inch);
        convert_result = view.findViewById(R.id.convert_result);
        calculatemeters = view.findViewById(R.id.calculatemeters);

        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkValue();
            }
        });

        calculatemeters.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                convertmeters();
            }
        });
        return view;


    }

    public void checkValue()
    {
        if(Integer.parseInt(weight.getText().toString())<1 || weight.getText().toString()=="")
        {
            Toast.makeText(getActivity(),"Please enter valid value",Toast.LENGTH_SHORT).show();
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

    public void convertmeters()
    {
        Float toConvert = Float.parseFloat(feet.getSelectedItem().toString() + "." + inch.getSelectedItem().toString());
        float meters = (float) (toConvert/3.28);
        height.setText(String.valueOf(meters));
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

}
