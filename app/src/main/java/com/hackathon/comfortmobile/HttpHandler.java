package com.hackathon.comfortmobile;

import android.content.Context;

/**
 * Created by knoblachm on 01.02.2018.
 */

public class HttpHandler {

    private HttpRequestCompleted _callback = null;

    private Context _context = null;


    public HttpHandler(HttpRequestCompleted callback, Context context){
        _callback = callback;
        _context = context;
    }

    public void RequestPatientenByNr(String patientNr) {
        if(patientNr.endsWith("*") == false){
            patientNr += "*";
        }

        String requestURL = String.format("http://10.1.2.169:8899/decmobile/SuchPatientenNr?PatientNr=%s", patientNr);
        makeServiceCall(requestURL);
    }

    private void makeServiceCall(String requestUrl){
        ServiceCallTask asyncTask = new ServiceCallTask(_callback, _context, requestUrl);
        asyncTask.execute("");
    }

}
