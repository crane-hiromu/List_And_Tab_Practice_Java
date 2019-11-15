package com.example.list_and_tab_practice_java;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static List<String> titles = Arrays.asList(new String[]{
            "hoge", "huga", "zozo", "hoge", "huga", "zozo", "hoge", "huga", "zozo"
    });

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MainListAdapter adapter = new MainListAdapter(this, titles);

        ListView listView = findViewById(R.id.listview);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(adapter);
    }
}

class MainListAdapter extends BaseAdapter implements AdapterView.OnItemClickListener {

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

    // MARK: AdapterView.OnItemClickListener

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Log.d("debug", "row: "+ String.valueOf(position));

    }
}
