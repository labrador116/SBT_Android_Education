package com.app.verst.verstapp.bankoffices.fragments.loader;

import android.content.AsyncTaskLoader;
import android.content.Context;

import com.app.verst.verstapp.bankoffices.fragments.models.Models_Impl.BankOffice;
import com.app.verst.verstapp.bankoffices.fragments.models.Models_Impl.data.GetDataByModel;

import java.util.ArrayList;


public class BanksListLoader extends AsyncTaskLoader<ArrayList<BankOffice>> {

    private ArrayList<BankOffice> mBanks;

    public BanksListLoader(Context context) {
        super(context);
    }

    @Override
    protected void onStartLoading() {
        super.onStartLoading();
        forceLoad();
    }

    @Override
    public ArrayList<BankOffice> loadInBackground() {
        GetDataByModel dataByModel = new GetDataByModel(getContext());
        mBanks= dataByModel.loadDataFromDB();
        return mBanks;
    }


}
