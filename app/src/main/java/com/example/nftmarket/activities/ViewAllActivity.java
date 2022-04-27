package com.example.nftmarket.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.nftmarket.R;

public class ViewAllActivity extends AppCompatActivity {
    
    FirebaseFireStore firestore;
    RecyclerView recyclerView;
    ViewAllAdapter viewAllAdapter;
    List<ViewAllModel> viewAllModelList;
    Toolbar toolbar;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_all);
    }
}
