package com.hackathon.comfortmobile;

/**
 * Created by knoblachm on 01.02.2018.
 */

public class PatientSuchResult {
    public String getPatientNr() {
        return patientNr;
    }

    public void setPatientNr(String patientNr) {
        this.patientNr = patientNr;
    }

    private String patientNr;

    public String getNachname() {
        return nachname;
    }

    public void setNachname(String nachname) {
        this.nachname = nachname;
    }

    public String getVorname() {
        return vorname;
    }

    public void setVorname(String vorname) {
        this.vorname = vorname;
    }

    public String getGeburstdatum() {
        return geburstdatum;
    }

    public void setGeburstdatum(String geburstdatum) {
        this.geburstdatum = geburstdatum;
    }

    public String getGeschlecht() {
        return geschlecht;
    }

    public void setGeschlecht(String geschlecht) {
        this.geschlecht = geschlecht;
    }

    public String getVersichertenArt() {
        return versichertenArt;
    }

    public void setVersichertenArt(String versichertenArt) {
        this.versichertenArt = versichertenArt;
    }

    public String getAnzeigeName(){
        String anzeige = vorname + " " + nachname;
        return anzeige;
    }

    private String nachname;
    private String vorname;
    private String geburstdatum;
    private String geschlecht;
    private String versichertenArt;
}
