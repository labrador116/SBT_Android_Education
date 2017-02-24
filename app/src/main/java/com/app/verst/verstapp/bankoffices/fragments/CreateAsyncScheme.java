package com.app.verst.verstapp.bankoffices.fragments;

import android.app.Activity;
import android.content.Loader;
import android.os.Bundle;

import com.app.verst.verstapp.bankoffices.fragments.adapter.BankOfficeAdapter;
import com.app.verst.verstapp.bankoffices.fragments.asynctask.InitAsyncTask;
import com.app.verst.verstapp.bankoffices.fragments.loader.BanksListLoader;
import com.app.verst.verstapp.bankoffices.fragments.models.Models_Impl.BankOffice;
import java.util.ArrayList;

public class CreateAsyncScheme implements android.app.LoaderManager.LoaderCallbacks<ArrayList<BankOffice>> {

    private Activity mActivity;
    private BankOfficeAdapter mAdapterForFragments;

    public CreateAsyncScheme(BankOfficeAdapter adapterForFragments) {
        mAdapterForFragments = adapterForFragments;
    }

    public CreateAsyncScheme (Activity activity,BankOfficeAdapter adapterForFragments){
        mActivity=activity;
        mAdapterForFragments = adapterForFragments;
    }

    @Override
    public void onLoaderReset(Loader<ArrayList<BankOffice>> loader) {

    }

    @Override
    public void onLoadFinished(Loader<ArrayList<BankOffice>> loader, ArrayList<BankOffice> data) {
        mAdapterForFragments.update(data);
    }

    @Override
    public Loader<ArrayList<BankOffice>> onCreateLoader(int id, Bundle args) {
        return new BanksListLoader(mActivity);
    }

    public void startLoaderManager(){
        if(mActivity!=null && mAdapterForFragments!=null) {
            mActivity.getLoaderManager().initLoader(1, null, this);
        } else {
            throw new RuntimeException("One of fields has null pointer");
        }
    }

    public void startAsyncTask()
    {
        if (mAdapterForFragments != null){
            createAsyncTaskScheme();
        } else{
            throw new RuntimeException("One of fields has null pointer");
        }
    }
    private void createAsyncTaskScheme(){
        InitAsyncTask mAsyncTask=new InitAsyncTask(mAdapterForFragments);
        mAsyncTask.execute(new ArrayList<BankOffice>());
    }
}
