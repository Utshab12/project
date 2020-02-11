package com.example.met_eireann_clone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;


//NAME
//STUDENT NUMBER

//create warnings

public class CreateWarning extends AppCompatActivity{

    private Spinner area, level, type;
    private String selectionArea ="", selectionLevel ="", selectionType ="";
    private Button add, cancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_warnings);


        //search for view
        area =findViewById(R.id.selectionAreaS);
        level =findViewById(R.id.selectionLevelS);
        type =findViewById(R.id.selectionTypeS);

        add =findViewById(R.id.addWarningB);
        cancel =findViewById(R.id.cancelWarningB);

        //Adapter Array
        ArrayAdapter<CharSequence> areaAdapter = ArrayAdapter.createFromResource(this, R.array.area_array, android.R.layout.simple_spinner_item);
        //spinner in drop downs
        areaAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        area.setAdapter(areaAdapter);

        //get listerners to spinner
        area.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                selectionArea =parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        //Adapter Array
        ArrayAdapter<CharSequence> levelAdapter = ArrayAdapter.createFromResource(this, R.array.level_array, android.R.layout.simple_spinner_item);

        levelAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        level.setAdapter(levelAdapter);

        //getting value from spinner
        level.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                selectionLevel =parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        //create adapter array
        ArrayAdapter<CharSequence> typeAdapter = ArrayAdapter.createFromResource(this, R.array.type_array, android.R.layout.simple_spinner_item);

        typeAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        type.setAdapter(typeAdapter);

        type.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                selectionType =parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Warning witem=new Warning(selectionArea, selectionLevel, selectionType);

                //create warning
                Warnings.warningsL.add(witem);

                startActivity(new Intent(getApplicationContext(), Warnings.class));
            }
        });

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), Warnings.class));
            }
        });




    }

}
