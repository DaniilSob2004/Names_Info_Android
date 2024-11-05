package com.example.namesfragment_hw.model;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class NameModel implements Parcelable {
    String name;
    String dates;
    String description;


    public NameModel() {}

    public NameModel(String name, String dates, String description) {
        this.name = name;
        this.dates = dates;
        this.description = description;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel parcel, int flags) {
        parcel.writeString(name);
        parcel.writeString(dates);
        parcel.writeString(description);
    }

    // CREATOR для воссоздания объекта из Parcel
    public static final Parcelable.Creator<NameModel> CREATOR = new Parcelable.Creator<NameModel>() {
        @Override
        public NameModel createFromParcel(Parcel parcel) {
            String name = parcel.readString();
            String dates = parcel.readString();
            String description = parcel.readString();
            return new NameModel(name, dates, description);
        }

        @Override
        public NameModel[] newArray(int size) {
            return new NameModel[size];
        }
    };


    public String getName() {
        return name;
    }

    public String getDates() {
        return dates;
    }

    public String getDescription() {
        return description;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDates(String dates) {
        this.dates = dates;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
