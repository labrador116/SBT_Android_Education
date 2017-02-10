package com.app.verst.verstapp.fragments;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.app.verst.verstapp.R;
import com.app.verst.verstapp.models.Models_Impl.BankOffice;

import java.util.ArrayList;

public class ArticleListFragment extends Fragment {

    BankOfficeAdapterForFragments mAdapterForFragments;
    float mRateValue;


    ArrayList<BankOffice> mBanksList=new ArrayList<BankOffice>();
    String[] mWorkTime=new String[7];

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initializationBanks();
        mAdapterForFragments = new BankOfficeAdapterForFragments(mBanksList,ArticleListFragment.this);
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view=inflater.inflate(R.layout.bank_office_list_fragment, container, false);

        RecyclerView mRecyclerViewForBanks = (RecyclerView) view.findViewById(R.id.recycler_view_for_list_of_banks_fragment);

       // mRecyclerViewForBanks.addOnItemTouchListener(new Rec);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());

        mRecyclerViewForBanks.setLayoutManager(linearLayoutManager);

        mRecyclerViewForBanks.setAdapter(mAdapterForFragments);

        return view;
    }


    private void initializationBanks(){

        mWorkTime[0]="09:00-18:00";
        mWorkTime[1]="09:00-18:00";
        mWorkTime[2]="09:00-18:00";
        mWorkTime[3]="09:00-18:00";
        mWorkTime[4]="09:00-18:00";
        mWorkTime[5]="День счастья";
        mWorkTime[6]="Выходной";

        mBanksList.add(new BankOffice("Спортивная, 5","Банк №1", 1.3f, mWorkTime,
                "8917000000", 0));
        mBanksList.add(new BankOffice("Спортивная, 6","Банк №2", 3.6f, mWorkTime,
                "8917000000", 0));
        mBanksList.add(new BankOffice("Спортивная, 7","Банк №3", 8.9f, mWorkTime,
                "8917000000", 0));
        mBanksList.add(new BankOffice("Спортивная, 8","Банк №4", 18.2f, mWorkTime,
                "8917000000", 0));
        mBanksList.add(new BankOffice("Спортивная, 9","Банк №5", 24.6f, mWorkTime,
                "8917000000", 0));
    }


    public void starBankOfficeDetailActivity(BankOffice bankOffice){
        InformationAboutBankFragment informationAboutBank = new InformationAboutBankFragment();
        Bundle args = new Bundle();

        args.putParcelable(InformationAboutBankFragment.EXTRA_ADDRESS_FOR_SECOND_ACTIVITY,bankOffice);
        informationAboutBank.setArguments(args);

        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fragment_detail_container,informationAboutBank);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    public float getRateValue() {
        return mRateValue;
    }

    public void setRateValue(float rateValue) {
        mRateValue = rateValue;
    }


}
