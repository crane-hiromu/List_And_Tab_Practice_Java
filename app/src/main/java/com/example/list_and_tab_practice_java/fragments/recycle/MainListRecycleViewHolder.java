package com.example.list_and_tab_practice_java.fragments.recycle;

import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.example.list_and_tab_practice_java.R;

public class MainListRecycleViewHolder extends RecyclerView.ViewHolder {
    TextView textOfRow;

    public MainListRecycleViewHolder(View inflate) {
        super(inflate);
        textOfRow = inflate.findViewById(R.id.main_list_row_text);
    }
}