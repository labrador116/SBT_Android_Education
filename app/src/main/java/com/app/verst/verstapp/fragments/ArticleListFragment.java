package com.app.verst.verstapp.fragments;

        import android.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.app.verst.verstapp.R;
import com.app.verst.verstapp.models.Models_Impl.BankOffice;

import java.util.ArrayList;

public class ArticleListFragment extends Fragment implements android.app.LoaderManager.LoaderCallbacks<ArrayList<BankOffice>> {

    BankOfficeAdapterForFragments mAdapterForFragments;
    private OnTouchBankOffice mCallback;
    float mRateValue;
    private InitAsyncTask mAsyncTask;
    ArrayList<BankOffice> mBanksList=new ArrayList<BankOffice>();
    String[] mWorkTime=new String[7];

    public interface OnTouchBankOffice{
        void touchOnItem(BankOffice bankOffice);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mCallback=(OnTouchBankOffice) getActivity();
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

        mAdapterForFragments = new BankOfficeAdapterForFragments(mBanksList,mCallback);

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
        getLoaderManager().initLoader(1,null,this).forceLoad();
    }

    public float getRateValue() {
        return mRateValue;
    }

    public void setRateValue(float rateValue) {
        mRateValue = rateValue;
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
}
