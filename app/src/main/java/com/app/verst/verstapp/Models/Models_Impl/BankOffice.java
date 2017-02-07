package com.app.verst.verstapp.Models.Models_Impl;

import android.telephony.PhoneNumberUtils;

import com.app.verst.verstapp.Models.IModelsBankOffice;

/**
 * Created by magaz on 07.02.2017.
 */

public class BankOffice implements IModelsBankOffice {

    private String mAddress;
    private String mName;
    private float mDistance;
    private String[] mWorkTime;
    private String mPhoneNumber;
    private int mRatingQualityOfWork;

    public BankOffice(String address, String name, float distance, String[] workTime, String phoneNumber, int ratingQualityOfWork) {
        mAddress = address;
        mName = name;
        mDistance = distance;
        mWorkTime = workTime;
        mPhoneNumber = phoneNumber;
        mRatingQualityOfWork = ratingQualityOfWork;
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
