package com.example.vebdentalcare;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import android.widget.ListView;

import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public class PatientDetails extends Activity {
    private ListView listViewPatients;
    private PatientAdapter adapter;
    private List<Patient> patientsList;
    private SQLiteDatabase mDatabase;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.patientlayout);
        listViewPatients = (ListView) findViewById(R.id.listViewPatients);
        patientsList = new ArrayList<>();

        //opening the database
        mDatabase = openOrCreateDatabase("veb_database", MODE_PRIVATE, null);

        //this method will display the employees in the list
        showPatientsFromDatabase();
    }
    private void showPatientsFromDatabase() {

        //we used rawQuery(sql, selectionargs) for fetching all the employees
        Cursor cursorPatients = mDatabase.rawQuery("SELECT * FROM VEB_CASE_HISTORY", null);

        //if the cursor has some data
        if (cursorPatients.moveToFirst()) {
            //looping through all the records
            do {
                //pushing each record in the patient list
                patientsList.add(new Patient(
                        cursorPatients .getString(1),
                        cursorPatients .getString(2),
                        cursorPatients .getString(3),
                        cursorPatients.getLong(4),
                        cursorPatients .getString(5),
                        cursorPatients .getString(6)
                                 ));
            } while (cursorPatients.moveToNext());
        }



        //creating the adapter object
        adapter = new PatientAdapter(this, R.layout.patient_listlayout, patientsList,mDatabase);

        //adding the adapter to listview
        listViewPatients.setAdapter(adapter);

        //closing the cursor
         cursorPatients.close();
    }

    @Override
    public void onBackPressed()
    {
        startActivity(new Intent(PatientDetails.this, MainActivity.class));
        finish();
        super.onBackPressed();
    }
}
