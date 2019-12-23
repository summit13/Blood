package com.example.blooddonor.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.blooddonor.Model.ViewDonors;
import com.example.blooddonor.R;

import java.util.ArrayList;

public class DonorsAdapter extends BaseAdapter {
    Context context;
    ArrayList<ViewDonors> arrayList;

    public DonorsAdapter(Context context, ArrayList<ViewDonors> arrayList)
    {
        this.context = context;
        this.arrayList = arrayList;
    }

    @Override
    public int getCount() {
        return this.arrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return arrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = inflater.inflate(R.layout.donors_list_view, null);
        TextView name = convertView.findViewById(R.id.name);
        TextView address = convertView.findViewById(R.id.address);
        TextView phone = convertView.findViewById(R.id.phone);
        TextView bloodGroup = convertView.findViewById(R.id.bloodGroup);

        ViewDonors viewDonors = arrayList.get(position);
        name.setText(viewDonors.getName());
        address.setText(viewDonors.getAddress());
        phone.setText(viewDonors.getPhone());
        bloodGroup.setText(viewDonors.getBloodgroup());
        return convertView;
    }
}
