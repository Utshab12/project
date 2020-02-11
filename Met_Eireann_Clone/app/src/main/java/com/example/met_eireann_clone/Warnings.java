package com.example.met_eireann_clone;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import java.util.ArrayList;
import java.util.List;

//NAME
//STUDENT NUMBER

public class Warnings extends AppCompatActivity {

    RecyclerView warningsR;
    ResetWarningsAdapter resetWarningsAdapter;
    public static List<Warning> warningsL =new ArrayList<>();


    Button addNewMywarning;

    @Override
    public boolean onSupportNavigateUp() {
        //back screen btn
        this.startActivity(new Intent(this, Main.class));
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.warnings);

        //back arrow
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        addNewMywarning=findViewById(R.id.addWarningB);

        warningsR =findViewById(R.id.recycleview_warnings);

        resetWarningsAdapter =new ResetWarningsAdapter(this, warningsL);
        warningsR.setLayoutManager(new LinearLayoutManager(this));
        warningsR.setItemAnimator(new DefaultItemAnimator());
        warningsR.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));


        warningsR.setAdapter(resetWarningsAdapter);
        resetWarningsAdapter.notifyDataSetChanged();

        addNewMywarning.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //new screen
                startActivity(new Intent(getApplicationContext(), CreateWarning.class));
            }
        });




    }
}
