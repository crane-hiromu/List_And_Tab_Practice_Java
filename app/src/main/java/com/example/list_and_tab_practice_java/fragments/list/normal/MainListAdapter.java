package com.example.list_and_tab_practice_java.fragments.list.normal;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.example.list_and_tab_practice_java.R;
import java.util.List;

public class MainListAdapter extends BaseAdapter {

    private LayoutInflater inflater;
    private List<String> data;

    public MainListAdapter(Context context, List<String> data) {
        super();

        this.inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.data = data;
    }

    // MARK: BaseAdapter

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
        View view = inflater.inflate(R.layout.main_list_row, null);
        String title = data.get(position);
        TextView titleLabel = view.findViewById(R.id.main_list_row_text);
        titleLabel.setText(title);
        return view;
    }
}