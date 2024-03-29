package com.example.blooddonor.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.blooddonor.Model.ViewEvents;
import com.example.blooddonor.R;

import java.util.ArrayList;

public class EventsAdapter extends BaseAdapter {

    Context context;
    ArrayList<ViewEvents> arrayList;

    public EventsAdapter(Context context, ArrayList<ViewEvents> arrayList)
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
        convertView = inflater.inflate(R.layout.events_list_view, null);
        TextView title = convertView.findViewById(R.id.event_title);
        TextView description = convertView.findViewById(R.id.event_description);
        TextView date = convertView.findViewById(R.id.event_date);
        TextView time = convertView.findViewById(R.id.event_time);

        ViewEvents viewEvents = arrayList.get(position);
        title.setText(viewEvents.getEventTitle());
        description.setText(viewEvents.getEventDescription());
        date.setText(viewEvents.getEventDate());
        time.setText(viewEvents.getEventTime());

        return convertView;
    }
}
