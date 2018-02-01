package com.hackathon.comfortmobile;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;

import java.util.ArrayList;

public class SearchActivity extends AppCompatActivity implements HttpRequestCompleted{

    private SearchView searchView;
    private ListView patientListView;
    private ArrayList<PatientSuchResult> patients;
    private static PatientAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        searchView = (SearchView) findViewById(R.id.searchView);
        patientListView = (ListView) findViewById(R.id.listViewPatients);

        final Context context = getApplicationContext();

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                doSearch(query);
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                //Log.d(TAG, "Query: " + newText);
                return false;
            }
        });
    }

    public void onTaskCompleteSuccess(String response){
        if(response != null && response.length() > 0){
            JSONParser parser = new JSONParser();
            patients = parser.ParsePateintSuche(response);
            adapter = new PatientAdapter(getApplicationContext(), patients);
            patientListView.setAdapter(adapter);
        }
    }

    public void onTaskCompleteError(String position, String message, String callstack){

    }

    private void doSearch(String query){
        HttpHandler handler = new HttpHandler(this, getApplicationContext());
        handler.RequestPatientenByNr(query);
    }
}
