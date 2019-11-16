package com.example.list_and_tab_practice_java;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class MainListAdapter extends BaseAdapter {

    private LayoutInflater inflater;
    private List<String> data;

    MainListAdapter(Context context, List<String> data) {
        super();

        this.inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.data = data;
    }

    // MARK:  BaseAdapter

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        String title = data.get(position);

        View listRow = inflater.inflate(R.layout.main_list_row, null);


        TextView titleLabel = listRow.findViewById(R.id.main_list_row_text);
        titleLabel.setText(title);


        return listRow;
    }

}