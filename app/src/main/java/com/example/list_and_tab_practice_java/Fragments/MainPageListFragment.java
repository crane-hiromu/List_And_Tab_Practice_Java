package com.example.list_and_tab_practice_java.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.list_and_tab_practice_java.R;
import com.example.list_and_tab_practice_java.SubActivity;

import java.util.Arrays;
import java.util.List;

public class MainPageListFragment extends Fragment implements AdapterView.OnItemClickListener {

    private static List<String> titles = Arrays.asList(new String[]{
            "hoge", "huga", "zozo", "hoge", "huga", "zozo", "hoge", "huga", "zozo"
    });

    public MainPageListFragment() {

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

        MainListAdapter adapter = new MainListAdapter(this.getContext(), titles);

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
