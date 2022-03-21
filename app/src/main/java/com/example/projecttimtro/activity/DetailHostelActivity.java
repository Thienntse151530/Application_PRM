package com.example.projecttimtro.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.example.projecttimtro.R;

public class DetailHostelActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_hostel);
        Intent fromIntent = getIntent();
        String name = fromIntent.getStringExtra("idHostel");
        Toast.makeText(DetailHostelActivity.this, name, Toast.LENGTH_SHORT).show();
    }

}