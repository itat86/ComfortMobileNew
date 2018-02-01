package com.hackathon.comfortmobile;

/**
 * Created by knoblachm on 01.02.2018.
 */

public interface HttpRequestCompleted {

    void onTaskCompleteSuccess(String response);

    void onTaskCompleteError(String position, String message, String callstack);
}
