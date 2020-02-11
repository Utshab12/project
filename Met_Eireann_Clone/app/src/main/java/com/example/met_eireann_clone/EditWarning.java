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

//change warinigs

public class EditWarning extends AppCompatActivity {

    private Spinner areaS, levelS, typeSpinner;
    private String sArea, sLevel, sType;
    private Button editB, cancelB, deleteB;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edit_warning);

        final int position=getIntent().getIntExtra("position",0);

        Warning oldItem= Warnings.warningsL.get(position);

        //search for view
        areaS =findViewById(R.id.areaSE);
        levelS =findViewById(R.id.levelSE);
        typeSpinner =findViewById(R.id.typeSE);

        editB =findViewById(R.id.editWarningB);
        cancelB =findViewById(R.id.cancelWarningB);
        deleteB =findViewById(R.id.deleteWarningB);

        //Adapter Array
        ArrayAdapter<CharSequence> areaAdapter = ArrayAdapter.createFromResource(this, R.array.area_array, android.R.layout.simple_spinner_item);
        //spinner in drop downs
        areaAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        areaS.setAdapter(areaAdapter);

        //search for view
        int oldAreaPos=areaAdapter.getPosition(oldItem.getAreaS());
        areaS.setSelection(oldAreaPos);

        //add on item selected listerners to spinner
        areaS.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                sArea =parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        //adapter array
        ArrayAdapter<CharSequence> levelAdapter = ArrayAdapter.createFromResource(this, R.array.level_array, android.R.layout.simple_spinner_item);
        //how the spinner will look when it drop downs on click
        levelAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        levelS.setAdapter(levelAdapter);

        //getting previous value of warning item and setting them in spinner
        int oldLevelPos=levelAdapter.getPosition(oldItem.getLevelS());
        levelS.setSelection(oldLevelPos);

        //add on item selected listerners to spinner
        levelS.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                sLevel =parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        //create adapter
        ArrayAdapter<CharSequence> typeAdapter = ArrayAdapter.createFromResource(this, R.array.type_array, android.R.layout.simple_spinner_item);
        //how the spinner will look when it drop downs on click
        typeAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        typeSpinner.setAdapter(typeAdapter);

        //getting previous value of warning item and setting them in spinner
        int oldTypePos=typeAdapter.getPosition(oldItem.getTypeS());
        typeSpinner.setSelection(oldTypePos);
        //add on item selected listerners to spinner
        typeSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                sType =parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        editB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Warning witem=new Warning(sArea, sLevel, sType);
                //editing values of an existing warning item in list
                Warnings.warningsL.set(position,witem);

                startActivity(new Intent(getApplicationContext(), Warnings.class));
            }
        });

        cancelB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), Warnings.class));
            }
        });

        deleteB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //deleting an existing warning item in list
                Warnings.warningsL.remove(position);

                startActivity(new Intent(getApplicationContext(), Warnings.class));
            }
        });


    }
}
