package com.hackathon.comfortmobile;

import android.widget.ArrayAdapter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by knoblachm on 01.02.2018.
 */

public class JSONParser {

    ArrayList<PatientSuchResult> ParsePateintSuche(String response){

        ArrayList<PatientSuchResult> result = new ArrayList<PatientSuchResult>();

        if(response != null && response.length() > 0) {
            try{
                JSONObject jsonResponse = new JSONObject(response);

                JSONArray patienten = jsonResponse.getJSONArray("");

                for(int patient = 0; patient < patienten.length(); patient++ ){
                    JSONObject resultPatient = patienten.getJSONObject(patient);
                    PatientSuchResult pat = new PatientSuchResult();
                    pat.setPatientNr(resultPatient.getString("PatientNr"));
                    pat.setNachname(resultPatient.getString("Nachname"));
                    pat.setVorname(resultPatient.getString("Vorname"));
                    pat.setGeburstdatum(resultPatient.getString("Geburtsdatum"));
                    pat.setGeschlecht(resultPatient.getString("Geschlecht"));
                    pat.setVersichertenArt(resultPatient.getString("VersichertenTyp"));

                    result.add(pat);
                }
            }
            catch(final JSONException e) {

            }
        }




        return result;
    }
}
