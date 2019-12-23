package com.example.blooddonor;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;

import com.example.blooddonor.Adapters.DonorsAdapter;
import com.example.blooddonor.Model.ViewDonors;

import java.util.ArrayList;

public class FindDonor extends Fragment {
    DatabaseHelper databaseHelper;
    ListView findDonorsListView;
    ArrayList<ViewDonors> arrayList;
    DonorsAdapter donorsAdapter;
    Button searchDonor;
    Spinner bloodGroup;
    String bg;

    public FindDonor() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        databaseHelper = new DatabaseHelper(getContext());
        arrayList = new ArrayList<>();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_find_donor, container, false);
        findDonorsListView = view.findViewById(R.id.findDonorsListView);
        bloodGroup = view.findViewById(R.id.chooseBG);
        searchDonor = view.findViewById(R.id.searchDonor);
        searchDonor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadDataInListView();
            }
        });
        return view;
    }

    private void loadDataInListView() {
        bg = bloodGroup.getSelectedItem().toString();
        System.out.println(bg);
        arrayList = databaseHelper.viewSelectedDonors(bg);
        donorsAdapter = new DonorsAdapter(getContext(),arrayList);
        findDonorsListView.setAdapter(donorsAdapter);
        donorsAdapter.notifyDataSetChanged();
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
