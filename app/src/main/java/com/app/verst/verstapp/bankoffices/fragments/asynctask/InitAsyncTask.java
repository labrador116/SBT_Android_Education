package com.app.verst.verstapp.bankoffices.fragments.asynctask;

import android.os.AsyncTask;

import com.app.verst.verstapp.bankoffices.fragments.adapter.BankOfficeAdapter;
import com.app.verst.verstapp.bankoffices.fragments.models.Models_Impl.BankOffice;

import java.util.ArrayList;

public class InitAsyncTask extends AsyncTask<ArrayList<BankOffice>,Void,ArrayList<BankOffice>> {

    private BankOfficeAdapter mAdapterForFragments;

    public InitAsyncTask(BankOfficeAdapter AdapterForFragments) {
        mAdapterForFragments=AdapterForFragments;
    }

    @Override
    protected ArrayList<BankOffice> doInBackground(ArrayList<BankOffice>... params) {
       // params[0]=GetDataByModel.getData();
        return params[0];
    }

       @Override
       protected void onPostExecute(ArrayList<BankOffice> bankOffices) {
           mAdapterForFragments.update(bankOffices);
       }
   }