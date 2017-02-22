package com.app.verst.verstapp.bankoffices.fragments.asynctask;

import android.os.AsyncTask;

import com.app.verst.verstapp.bankoffices.fragments.models.Models_Impl.BankOffice;
import com.app.verst.verstapp.bankoffices.fragments.models.Models_Impl.data.GetDataByModel;

import java.util.ArrayList;

public class InitAsyncTask extends AsyncTask<ArrayList<BankOffice>,Void,ArrayList<BankOffice>> {

    OnAsyncTaskCallback mCallback;

    public InitAsyncTask(OnAsyncTaskCallback callback) {
        mCallback = callback;
    }

    @Override
    protected ArrayList<BankOffice> doInBackground(ArrayList<BankOffice>... params) {
        params[0]= GetDataByModel.getData();
        return params[0];
    }

       @Override
       protected void onPostExecute(ArrayList<BankOffice> bankOffices) {
          mCallback.callbackAsyncTask(bankOffices);
       }

    public interface OnAsyncTaskCallback{
        void callbackAsyncTask(ArrayList<BankOffice> banks);
    }
   }