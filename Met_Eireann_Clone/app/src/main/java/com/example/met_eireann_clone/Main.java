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

public class Main extends AppCompatActivity {


    RecyclerView weatherR;
    ResetWeathersAdapter resetWeathersAdapter;
    List<Weather> weatherL =new ArrayList<>();

    Button myWarningsBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        weatherR =findViewById(R.id.recycleview_weather_object);

        //adapter creation with weatherL
        resetWeathersAdapter =new ResetWeathersAdapter(this, weatherL);

        //weather view layout and decorations
        weatherR.setLayoutManager(new LinearLayoutManager(this));
        weatherR.setItemAnimator(new DefaultItemAnimator());
        weatherR.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));

        //linking view with adapter
        weatherR.setAdapter(resetWeathersAdapter);

        //list creation
        weatherL.add(new Weather("Monday",4));
        weatherL.add(new Weather("Tuesday",9));
        weatherL.add(new Weather("Wednesday",0));
        weatherL.add(new Weather("Thursday",-2));
        weatherL.add(new Weather("Friday",3));
        weatherL.add(new Weather("Saturday",5));
        weatherL.add(new Weather("Sunday",8));

        //update view
        resetWeathersAdapter.notifyDataSetChanged();
        myWarningsBtn=findViewById(R.id.warningsB);

        myWarningsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //new screen
                startActivity(new Intent(getApplicationContext(), Warnings.class));
            }
        });
    }
}
