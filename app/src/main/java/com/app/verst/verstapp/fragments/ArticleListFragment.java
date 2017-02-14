package com.app.verst.verstapp.fragments;

import android.app.Fragment;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.app.verst.verstapp.R;
import com.app.verst.verstapp.models.Models_Impl.BankOffice;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Random;

public class ArticleListFragment extends Fragment {

    BankOfficeAdapterForFragments mAdapterForFragments;
    private OnTouchBankOffice mCallback;
    float mRateValue;

    ArrayList<BankOffice> mBanksList=new ArrayList<BankOffice>();
    String[] mWorkTime=new String[7];

    public interface OnTouchBankOffice{
         void touchOnItem(BankOffice bankOffice);
    }


   private class InitAsyncTask extends AsyncTask<ArrayList<BankOffice>,Void,ArrayList<BankOffice>> {
       @Override
       protected ArrayList<BankOffice> doInBackground(ArrayList<BankOffice>... params) {
           initializationBanks(params[0]);
           return params[0];
       }

       @Override
       protected void onPostExecute(ArrayList<BankOffice> bankOffices) {
           mBanksList=bankOffices;
       }
   }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        InitAsyncTask asyncTask=new InitAsyncTask();
        asyncTask.execute(mBanksList);
        
        // initializationBanks();
        mCallback=(OnTouchBankOffice) getActivity();
        mAdapterForFragments = new BankOfficeAdapterForFragments(mBanksList,mCallback);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view=inflater.inflate(R.layout.bank_office_list_fragment, container, false);

        RecyclerView mRecyclerViewForBanks = (RecyclerView) view.findViewById(R.id.recycler_view_for_list_of_banks_fragment);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());

        mRecyclerViewForBanks.setLayoutManager(linearLayoutManager);

        mRecyclerViewForBanks.setAdapter(mAdapterForFragments);

        return view;
    }

    private void initializationBanks(ArrayList<BankOffice> banks){

        mWorkTime[0]="09:00-18:00";
        mWorkTime[1]="09:00-18:00";
        mWorkTime[2]="09:00-18:00";
        mWorkTime[3]="09:00-18:00";
        mWorkTime[4]="09:00-18:00";
        mWorkTime[5]="День счастья";
        mWorkTime[6]="Выходной";

        for (int i = 0; i < 100; i++) {

            NumberFormat value=new DecimalFormat("#0.00");

            banks.add(new BankOffice("Спортивная, "+ new Random().nextInt(100),
                    "Банк №"+i,
                    Float.valueOf(value.format(new Random().nextFloat())),
                    mWorkTime,
                    "88002000600",0));
        }
    }

    public float getRateValue() {
        return mRateValue;
    }

    public void setRateValue(float rateValue) {
        mRateValue = rateValue;
    }





}
