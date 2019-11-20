package com.example.list_and_tab_practice_java.fragments.list.holder;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.example.list_and_tab_practice_java.R;
import java.util.List;

public class MainListWithHolderAdapter extends BaseAdapter {

    private LayoutInflater inflater;
    private List<String> data;

    public MainListWithHolderAdapter(Context context, List<String> data) {
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
        View view = convertView;
        MainListViewHolder viewHolder;
        String title = data.get(position);

        if (view == null) {
            viewHolder = new MainListViewHolder();
            view = inflater.inflate(R.layout.main_list_row, null);
            viewHolder.textOfRow = view.findViewById(R.id.main_list_row_text);
            view.setTag(viewHolder);
        } else {
            viewHolder = (MainListViewHolder) view.getTag();
        }
        viewHolder.textOfRow.setText(title);

        return view;
    }
}
