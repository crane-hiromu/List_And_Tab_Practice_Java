package com.example.list_and_tab_practice_java.fragments.recycle;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.list_and_tab_practice_java.R;

import java.util.List;

public class MainRecycleAdapter extends RecyclerView.Adapter<MainListRecycleViewHolder> {

    private LayoutInflater inflater;
    private List<String> data;
    private MainRecycleOnClickListener listener;

    public MainRecycleAdapter(Context context, List<String> data, MainRecycleOnClickListener listener) {
        super();

        this.inflater = LayoutInflater.from(context);
        this.data = data;
        this.listener = listener;
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
    public void onBindViewHolder(@NonNull MainListRecycleViewHolder holder, final int position) {
        if (data.get(position) != null) {
            holder.textOfRow.setText(data.get(position));
        }

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onRecycleClicked(v, position);
            }
        });
    }
}
