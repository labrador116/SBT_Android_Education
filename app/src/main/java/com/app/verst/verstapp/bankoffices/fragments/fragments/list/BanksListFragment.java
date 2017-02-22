package com.app.verst.verstapp.bankoffices.fragments.fragments.list;

import android.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.app.verst.verstapp.R;
import com.app.verst.verstapp.bankoffices.fragments.adapter.BankOfficeAdapter;
import com.app.verst.verstapp.bankoffices.fragments.asynctask.InitAsyncTask;
import com.app.verst.verstapp.bankoffices.fragments.loader.BanksListLoader;
import com.app.verst.verstapp.bankoffices.fragments.models.Models_Impl.BankOffice;

import java.util.ArrayList;

public class BanksListFragment extends Fragment implements android.app.LoaderManager.LoaderCallbacks<ArrayList<BankOffice>> {

    BankOfficeAdapter mAdapterForFragments;
    private OnTouchBankOfficeCallback mTouchCallback;
    float mRateValue;
    private InitAsyncTask mAsyncTask;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mTouchCallback =(OnTouchBankOfficeCallback) getActivity();
//
//        /****Start with AsyncTAsk***/
//        mAsyncTask=new InitAsyncTask(new InitAsyncTask.OnAsyncTaskCallback() {
//            @Override
//            public void callbackAsyncTask(ArrayList<BankOffice> banks) {
//                mAdapterForFragments.update(banks);
//            }
//        });
//        mAsyncTask.execute(mBanksList);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        mAdapterForFragments = new BankOfficeAdapter(mTouchCallback);

        View view=inflater.inflate(R.layout.bank_office_list_fragment, container, false);

        RecyclerView mRecyclerViewForBanks = (RecyclerView) view.findViewById(R.id.recycler_view_for_list_of_banks_fragment);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());

        mRecyclerViewForBanks.setLayoutManager(linearLayoutManager);

        mRecyclerViewForBanks.setAdapter(mAdapterForFragments);

        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
//        mAsyncTask.cancel(true);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        getLoaderManager().initLoader(1,null,this);
    }

    @Override
    public android.content.Loader<ArrayList<BankOffice>> onCreateLoader(int id, Bundle args) {
        return new BanksListLoader(getActivity());
    }

    @Override
    public void onLoaderReset(android.content.Loader<ArrayList<BankOffice>> loader) {

    }

    @Override
    public void onLoadFinished(android.content.Loader<ArrayList<BankOffice>> loader, ArrayList<BankOffice> data) {
        mAdapterForFragments.update(data);
    }

    public float getRateValue() {
        return mRateValue;
    }

    public void setRateValue(float rateValue) {
        mRateValue = rateValue;
    }


    public interface OnTouchBankOfficeCallback {
        void touchOnItem(BankOffice bankOffice);
    }
}
