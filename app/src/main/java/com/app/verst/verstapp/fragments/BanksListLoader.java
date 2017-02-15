package com.app.verst.verstapp.fragments;

import android.content.AsyncTaskLoader;
import android.content.Context;

import com.app.verst.verstapp.models.Models_Impl.BankOffice;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Random;


public class BanksListLoader extends AsyncTaskLoader<ArrayList<BankOffice>> {

    private ArrayList<BankOffice> mBanks;


    public BanksListLoader(Context context) {
        super(context);
    }



    @Override
    public ArrayList<BankOffice> loadInBackground() {

        mBanks=new ArrayList<>();

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

                mBanks.add(new BankOffice("Спортивная, " + new Random().nextInt(100),
                        "Банк №" + i,
                        Float.valueOf(value.format(new Random().nextFloat())),
                        mWorkTime,
                        "88002000600", 0));
            }
        return mBanks;
    }


}
