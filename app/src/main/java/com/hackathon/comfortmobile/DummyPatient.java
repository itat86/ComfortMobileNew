package com.hackathon.comfortmobile;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by praxis on 01.02.2018. gaga
 */

public class DummyPatient implements Parcelable{

    private String name;
    private String birthday;
    private String status;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    private String id;

    public DummyPatient(String name, String birthday, String status, String id)
    {
        this.name = name;
        this.birthday = birthday;
        this.status = status;
        this.id = id;
    }

    protected DummyPatient(Parcel in) {
        name = in.readString();
        birthday = in.readString();
        status = in.readString();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeStringArray(new String[]{
                this.name,
                this.birthday,
                this.status
        });
    }

    public static final Creator<DummyPatient> CREATOR = new Creator<DummyPatient>() {
        @Override
        public DummyPatient createFromParcel(Parcel in) {
            return new DummyPatient(in);
        }

        @Override
        public DummyPatient[] newArray(int size) {
            return new DummyPatient[size];
        }
    };
}
