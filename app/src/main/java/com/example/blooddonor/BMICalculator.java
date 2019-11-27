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


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link BMICalculator.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link BMICalculator#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BMICalculator extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    EditText weight, height;
    float weight1, height1;
    TextView result, convert_result;
    Spinner feet, inch;
    Button calculate, calculatemeters;

    private OnFragmentInteractionListener mListener;

    public BMICalculator() {
        // Required empty public constructor
    }

    public static BMICalculator newInstance(String param1, String param2) {
        BMICalculator fragment = new BMICalculator();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
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



    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
