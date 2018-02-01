package com.hackathon.comfortmobile;

/**
 * Created by knoblachm on 01.02.2018.
 */

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class ServiceCallTask extends AsyncTask<String, Integer, String> {

    private HttpRequestCompleted _completedCallback = null;

    private String _requestURL = "";

    private String _response = "";

    private String _errorPosition = "";

    private String _errorMessage = "";

    private String _errorCallstack = "";

    private ProgressDialog _progrssDialog = null;

    private Context _context = null;


    public ServiceCallTask(HttpRequestCompleted completedCallback, Context context, String requestURL){
        _completedCallback = completedCallback;
        _context = context;
        _requestURL = requestURL;
    }

    @Override
    protected String doInBackground(String... params){
        String result = "Success";

        try{
            URL url = new URL(_requestURL);
            HttpURLConnection connection = (HttpURLConnection)url.openConnection();
            connection.setRequestMethod("GET");
            connection.setReadTimeout(5000);
            connection.setConnectTimeout(5000);
            connection.connect();
            if(connection.getResponseCode() == HttpURLConnection.HTTP_OK) {
                InputStream inputStream = new BufferedInputStream((connection.getInputStream()));
                _response = convertStreamToString(inputStream);
            }
        }
        catch (Exception e){
            _errorPosition = "ServiceCallTask::doInBackgound";
            _errorMessage = e.getMessage();
            _errorCallstack = e.getStackTrace().toString();
            result = "Error";
        }

        return result;
    }

    @Override
    protected void onPreExecute(){
        //_progrssDialog = ProgressDialog.show(_context, "Daten werden abrufen", "Daten vom Web-Service abrufen...");
    }

    @Override
    protected void onPostExecute(String result){
        if(_completedCallback != null) {
            if (result.equals("Error")) {
                _completedCallback.onTaskCompleteError(_errorPosition, _errorMessage, _errorCallstack);
            }
            else {
                _completedCallback.onTaskCompleteSuccess(_response);
            }
        }
       // _progrssDialog.dismiss();
    }

    private String convertStreamToString(InputStream inputStream){
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        StringBuilder returnString = new StringBuilder();

        String line;
        try{
            line = reader.readLine();
            while(line != null) {
                returnString.append(line);
                returnString.append('\n');

                line = reader.readLine();
            }
        }
        catch (IOException e)
        {
            _errorPosition = "ServiceCallTask::convertStreamToString @1";
            _errorMessage = e.getMessage();
            _errorCallstack = e.getStackTrace().toString();
        }
        finally {
            try {
                inputStream.close();
            }
            catch (IOException e){
                _errorPosition = "ServiceCallTask::convertStreamToString @2";
                _errorMessage = e.getMessage();
                _errorCallstack = e.getStackTrace().toString();
            }
        }

        return returnString.toString();
    }
}

