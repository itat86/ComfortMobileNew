package com.hackathon.comfortmobile;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by praxis on 01.02.2018.
 */

public class PatientAdapter extends BaseAdapter implements ListAdapter{

    private Context context;
    private ArrayList<DummyPatient> adapterData;
    private LayoutInflater inflater;

    /**
     * Adapter constructor -> Sets class variables
     * @param context application context
     * @param adapterData JSONArray of notes
     */
    public PatientAdapter(Context context, ArrayList adapterData) {
        this.context = context;
        this.adapterData = adapterData;
        this.inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        if (this.adapterData != null)
            return this.adapterData.size();

        else
            return 0;
    }

    @Override
    public DummyPatient getItem(int position) {
        if (this.adapterData != null)
            return this.adapterData.get(position);

        else
            return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        if (convertView == null)
            convertView = this.inflater.inflate(R.layout.list_view_patient, parent, false);

        //RelativeLayout relativeLayout = (RelativeLayout) convertView.findViewById(R.id.relativeLayout);

        TextView nameView = (TextView) convertView.findViewById(R.id.patientName);
        TextView birthdayView = (TextView) convertView.findViewById(R.id.patientBirthday);
        TextView statusView = (TextView) convertView.findViewById(R.id.patientStatus);

        final DummyPatient dummyPatient = getItem(position);

        if (dummyPatient != null) {

            nameView.setText(dummyPatient.getName());
            birthdayView.setText(dummyPatient.getBirthday());
            statusView.setText(dummyPatient.getStatus());

            //birthdayView.setVisibility(View.VISIBLE);
            //birthdayView.setText(body);
            //birthdayView.setTextSize(TypedValue.COMPLEX_UNIT_SP, fontSize);

        }
        return convertView;
    }
}
