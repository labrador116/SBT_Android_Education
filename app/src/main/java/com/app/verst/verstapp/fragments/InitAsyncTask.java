package com.app.verst.verstapp.fragments;

import android.os.AsyncTask;
import com.app.verst.verstapp.models.Models_Impl.BankOffice;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Random;

public class InitAsyncTask extends AsyncTask<ArrayList<BankOffice>,Void,ArrayList<BankOffice>> {

    OnAsyncTaskCallback mCallback;

    public InitAsyncTask(OnAsyncTaskCallback callback) {
        mCallback = callback;
    }

    @Override
    protected ArrayList<BankOffice> doInBackground(ArrayList<BankOffice>... params) {

        String[] mWorkTime = new String[7];
        mWorkTime[0] = "09:00-18:00";
        mWorkTime[1] = "09:00-18:00";
        mWorkTime[2] = "09:00-18:00";
        mWorkTime[3] = "09:00-18:00";
        mWorkTime[4] = "09:00-18:00";
        mWorkTime[5] = "День счастья";
        mWorkTime[6] = "Выходной";

        for (int i = 0; i < 100; i++) {
            NumberFormat value = new DecimalFormat("#0.00");

            params[0].add(new BankOffice("Спортивная, " + new Random().nextInt(100),
                    "Банк №" + i,
                    Float.valueOf(value.format(new Random().nextFloat())),
                    mWorkTime,
                    "88002000600", 0));
            if(isCancelled()){
                break;
            }
        }
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