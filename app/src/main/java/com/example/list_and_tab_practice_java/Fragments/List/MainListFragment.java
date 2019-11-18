package com.example.list_and_tab_practice_java.Fragments.List;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.list_and_tab_practice_java.Fragments.List.Holder.MainListWithHolderAdapter;
import com.example.list_and_tab_practice_java.Fragments.List.Normal.MainListAdapter;
import com.example.list_and_tab_practice_java.R;
import com.example.list_and_tab_practice_java.SubActivity;

import java.util.Arrays;
import java.util.List;

public class MainListFragment extends Fragment implements AdapterView.OnItemClickListener {

    private static List<String> titles = Arrays.asList(new String[]{
            "hoge", "huga", "zozo", "hoge", "huga", "zozo", "hoge", "huga", "zozo"
    });

    private Integer row;

    public MainListFragment(Integer row) {
        this.row = row;
    }

    // MARK: Fragment

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.main_page_fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        BaseAdapter adapter = new MainListAdapter(this.getContext(), titles); // default

        switch (row) {
            case 0:
                adapter = new MainListAdapter(this.getContext(), titles);
                break;
            case 1:
                adapter = new MainListWithHolderAdapter(this.getContext(), titles);
                break;
            case 2:
                break;
            default:
                break;
        }

        ListView listView = view.findViewById(R.id.main_page_fragment_list);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(this);
    }

    // MARK: AdapterView.OnItemClickListener

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Log.d("debug", "row: "+ String.valueOf(position));

        Intent intent = new Intent(this.getContext(), SubActivity.class);
        intent.putExtra(
            "MainPageFragmentOnItemClick",
            "row: " +  String.valueOf(position)
        );
        startActivity(intent);
    }
}
