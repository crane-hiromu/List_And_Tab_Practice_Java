package com.example.list_and_tab_practice_java.Fragments.Recycle;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.list_and_tab_practice_java.R;
import com.example.list_and_tab_practice_java.SubActivity;

import java.util.Arrays;
import java.util.List;

public class MainRecycleFragment extends Fragment implements MainRecycleOnClickListener {

    private static List<String> titles = Arrays.asList(new String[]{
            "hoge", "huga", "zozo", "hoge", "huga", "zozo", "hoge", "huga", "zozo"
    });

    public MainRecycleFragment() {

    }

    // MARK: Fragment

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.main_page_recycle_fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        RecyclerView recycler = view.findViewById(R.id.main_page_recycle_fragment_list);
        recycler.setHasFixedSize(true);

        LinearLayoutManager layout = new LinearLayoutManager(this.getActivity());
        recycler.setLayoutManager(layout);

        MainRecycleAdapter adapter = new MainRecycleAdapter(this.getContext(), titles, this); // default
        recycler.setAdapter(adapter);
    }

    // MARK: MainRecycleOnClickListener

    @Override
    public void onRecycleClicked(View v, int position) {
        Log.d("debug", "row: "+ String.valueOf(position));

        Intent intent = new Intent(this.getContext(), SubActivity.class);
        intent.putExtra(
                "MainRecycleFragmentOnRecycleClicked",
                "row: " +  String.valueOf(position)
        );
        startActivity(intent);
    }
}
