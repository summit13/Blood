package com.example.blooddonor;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.blooddonor.Adapters.DonorsAdapter;
import com.example.blooddonor.Adapters.EventsAdapter;
import com.example.blooddonor.Model.ViewDonors;
import com.example.blooddonor.Model.ViewEvents;

import java.util.ArrayList;

public class DonorList extends Fragment {

    DatabaseHelper databaseHelper;
    ListView donorsListView;
    ArrayList<ViewDonors> arrayList;
    DonorsAdapter donorsAdapter;

    public DonorList() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        databaseHelper = new DatabaseHelper(getContext());
        arrayList = new ArrayList<>();
    }

    private void loadDataInListView() {
        arrayList = databaseHelper.viewAllDonors();
        donorsAdapter = new DonorsAdapter(getContext(),arrayList);
        donorsListView.setAdapter(donorsAdapter);
        donorsAdapter.notifyDataSetChanged();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =inflater.inflate(R.layout.fragment_donor_list, container, false);
        donorsListView = view.findViewById(R.id.donorsListView);
        loadDataInListView();
        return view;
    }
}
