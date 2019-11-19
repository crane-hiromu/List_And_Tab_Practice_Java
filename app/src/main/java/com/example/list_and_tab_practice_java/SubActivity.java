package com.example.list_and_tab_practice_java;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SubActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sub_activity);

        Intent intent = this.getIntent();
        TextView textview = this.findViewById(R.id.sub_row_number);

        /// from list
        if (intent.getStringExtra("MainListFragmentOnItemClick") != null) {
            textview.setText(intent.getStringExtra("MainListFragmentOnItemClick"));
        }

        /// from recycle
        if (intent.getStringExtra("MainRecycleFragmentOnRecycleClicked") != null) {
            textview.setText(intent.getStringExtra("MainRecycleFragmentOnRecycleClicked"));
        }
    }
}
