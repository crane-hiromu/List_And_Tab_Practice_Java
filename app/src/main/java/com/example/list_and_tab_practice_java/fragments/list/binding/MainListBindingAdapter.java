package com.example.list_and_tab_practice_java.fragments.list.binding;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import androidx.databinding.DataBindingUtil;
import com.example.list_and_tab_practice_java.R;
import com.example.list_and_tab_practice_java.databinding.MainListBindingRowBinding;

import java.util.List;

public class MainListBindingAdapter extends BaseAdapter {

    private LayoutInflater inflater;
    private List<String> data;

    public MainListBindingAdapter(Context context, List<String> data) {
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
        String title = data.get(position);
        MainListModel model = new MainListModel(title); // todo list model

        MainListBindingRowBinding binding = DataBindingUtil.inflate(inflater, R.layout.main_list_binding_row, parent, false);
        binding.setModel(model);
        return binding.getRoot();
    }
}