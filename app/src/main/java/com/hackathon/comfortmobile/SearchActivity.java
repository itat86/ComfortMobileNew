package com.hackathon.comfortmobile;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.SearchView;

import java.util.ArrayList;

public class SearchActivity extends AppCompatActivity {

    private SearchView searchView;
    private ListView patientListView;
    private ArrayList<DummyPatient> patients;
    private static PatientAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        searchView = (SearchView) findViewById(R.id.searchView);
        patientListView = (ListView) findViewById(R.id.listViewPatients);

        DummyPatient patientOne = new DummyPatient("Hans Kunz","17.11.1988","P");
        DummyPatient patientTwo = new DummyPatient("Maria Meiereder","13.03.1950","K");
        DummyPatient patientThree = new DummyPatient("Thomas Heidrich","02.04.1990","P");

        patients = new ArrayList<DummyPatient>();
        patients.add(patientOne);
        patients.add(patientTwo);
        patients.add(patientThree);

        adapter = new PatientAdapter(getApplicationContext(), patients);
        patientListView.setAdapter(adapter);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                Log.d("suche", "Suche bestätigt");
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                //Log.d(TAG, "Query: " + newText);
                return false;
            }
        });
    }
}
