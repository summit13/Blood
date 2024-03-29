package com.example.blooddonor;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import com.example.blooddonor.Adapters.EventsAdapter;
import com.example.blooddonor.Model.ViewEvents;

import java.util.ArrayList;

public class Events extends Fragment
{

    DatabaseHelper databaseHelper;
    ListView eventsListView;
    ArrayList<ViewEvents> arrayList;
    EventsAdapter eventsAdapter;

    public Events() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        databaseHelper = new DatabaseHelper(getContext());
        arrayList = new ArrayList<>();
    }

    private void loadDataInListView() {
        arrayList = databaseHelper.viewAllEvents();
        eventsAdapter = new EventsAdapter(getContext(),arrayList);
        eventsListView.setAdapter(eventsAdapter);
        eventsAdapter.notifyDataSetChanged();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_events, container, false);
        eventsListView = view.findViewById(R.id.eventsListView);
        loadDataInListView();
        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

//    private void display() {
//        Cursor cursor = databaseHelper.viewAllEvents();
//        if(cursor.getCount()==0)
//        {
//            Toast.makeText(getContext(), "No events to view", Toast.LENGTH_LONG).show();
//        }
//
//        StringBuffer stringBuffer = new StringBuffer();
//        while (cursor.moveToNext())
//        {
//            stringBuffer.append("Event Title:" + cursor.getString(1)+ "\n");
//            stringBuffer.append("Event Description:" + cursor.getString(2)+ "\n");
//            stringBuffer.append("Event Date:" + cursor.getString(3)+ "\n");
//            stringBuffer.append("Event Time:" + cursor.getString(4)+ "\n");
//        }
//        Toast.makeText(getContext(), stringBuffer.toString(),Toast.LENGTH_LONG).show();
//    }

}
