package com.example.list_and_tab_practice_java.Fragments.Recycle;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.list_and_tab_practice_java.R;

import java.util.List;

public class MainRecycleAdapter extends RecyclerView.Adapter<MainListRecycleViewHolder> {

    private LayoutInflater inflater;
    private List<String> data;

    public MainRecycleAdapter(Context context, List<String> data) {
        super();

        this.inflater = LayoutInflater.from(context);
        this.data = data;
    }

    // MARK: Adapter

    @Override
    public int getItemCount() {
        return data.size();
    }

    @NonNull
    @Override
    public MainListRecycleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MainListRecycleViewHolder(inflater.inflate(R.layout.main_list_row, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull MainListRecycleViewHolder holder, int position) {
        if (data.get(position) != null) {
            holder.textOfRow.setText(data.get(position));
        }
    }
}
