package com.example.blooddonor;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddEvents extends Fragment {

    DatabaseHelper myDb;
    EditText eventTitle, eventDescription, eventDate, eventTime;
    String title, description, date, time;
    Button addEventButton;

    public AddEvents() {
        // Required empty public constructor


    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_add_events, container, false);
        eventTitle = view.findViewById(R.id.eventTitleField);
        eventDescription = view.findViewById(R.id.eventDescriptionField);
        eventDate = view.findViewById(R.id.eventDateField);
        eventTime = view.findViewById(R.id.eventTimeField);
        addEventButton = view.findViewById(R.id.addEventButton);
        addEventButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e("Line 48", "This is before add event method");
                addEvent();
            }
        });
        return view;
    }

    public void addEvent()
    {
        Log.e("Line 57","This is add event");
        getValue();
        Log.e("Line 59","This is before add event");
        Log.e("Title",title);
        Log.e("Description",description);
        Log.e("Date",date);
        Log.e("Time",time);
        DatabaseHelper myDb = new DatabaseHelper(getContext());
        boolean isInserted = myDb.addEvent(title, description, date, time);
        Log.e("Line 48","This is after isInserted statement");
        if(isInserted==true)
        {
            Toast.makeText(getActivity(), "Event Added", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(getActivity(), "Failed to add event", Toast.LENGTH_SHORT).show();
        }
    }

    public void getValue()
    {
        title = eventTitle.getText().toString();
        description = eventDescription.getText().toString();
        date = eventDate.getText().toString();
        time = eventTime.getText().toString();
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
