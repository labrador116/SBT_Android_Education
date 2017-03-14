package com.app.verst.verstapp.bankoffices.fragments.models.Models_Impl;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by magaz on 07.02.2017.
 */

public class BankOffice implements Parcelable {

    private String mAddress;
    private String mName;
    private float mDistance;
    private String[] mWorkTime;
    private String mPhoneNumber;
    private int mRatingQualityOfWork;

    public BankOffice(){}

    public BankOffice(String address, String name, float distance, String phoneNumber, int ratingQualityOfWork) {
        mAddress = address;
        mName = name;
        mDistance = distance;
        mPhoneNumber = phoneNumber;
        mRatingQualityOfWork = ratingQualityOfWork;
    }

    protected BankOffice(Parcel in) {
        mAddress = in.readString();
        mName = in.readString();
        mDistance = in.readFloat();
        mWorkTime = in.createStringArray();
        mPhoneNumber = in.readString();
        mRatingQualityOfWork = in.readInt();
    }

    public static final Creator<BankOffice> CREATOR = new Creator<BankOffice>() {
        @Override
        public BankOffice createFromParcel(Parcel in) {
            return new BankOffice(in);
        }

        @Override
        public BankOffice[] newArray(int size) {
            return new BankOffice[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(mAddress);
        dest.writeString(mName);
        dest.writeFloat(mDistance);
        dest.writeStringArray(mWorkTime);
        dest.writeString(mPhoneNumber);
        dest.writeInt(mRatingQualityOfWork);
    }

    public String getAddress() {
        return mAddress;
    }

    public void setAddress(String address) {
        mAddress = address;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public float getDistance() {
        return mDistance;
    }

    public void setDistance(float distance) {
        mDistance = distance;
    }

    public String[] getWorkTime() {
        return mWorkTime;
    }

    public void setWorkTime(String[] workTime) {
        mWorkTime = workTime;
    }

    public String getPhoneNumber() {
        return mPhoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        mPhoneNumber = phoneNumber;
    }

    public int getRatingQualityOfWork() {
        return mRatingQualityOfWork;
    }

    public void setRatingQualityOfWork(int ratingQualityOfWork) {
        mRatingQualityOfWork = ratingQualityOfWork;
    }
}
