package com.app.verst.verstapp.Models.Models_Impl;

import android.telephony.PhoneNumberUtils;

import com.app.verst.verstapp.Models.IModelsBankOffice;

/**
 * Created by magaz on 07.02.2017.
 */

public class BankOffice implements IModelsBankOffice {

    private String mAddress;
    private String mName;
    private int mDistance;
    private String mWorkTime;
    private PhoneNumberUtils mPhoneNumber;
    private int mRatingQualityOfWork;

    public BankOffice(String address, String name, int distance, String workTime, PhoneNumberUtils phoneNumber, int ratingQualityOfWork) {
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

    public int getDistance() {
        return mDistance;
    }

    public void setDistance(int distance) {
        mDistance = distance;
    }

    public String getWorkTime() {
        return mWorkTime;
    }

    public void setWorkTime(String workTime) {
        mWorkTime = workTime;
    }

    public PhoneNumberUtils getPhoneNumber() {
        return mPhoneNumber;
    }

    public void setPhoneNumber(PhoneNumberUtils phoneNumber) {
        mPhoneNumber = phoneNumber;
    }

    public int getRatingQualityOfWork() {
        return mRatingQualityOfWork;
    }

    public void setRatingQualityOfWork(int ratingQualityOfWork) {
        mRatingQualityOfWork = ratingQualityOfWork;
    }
}
