package com.app.verst.verstapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.telephony.PhoneNumberUtils;

import com.app.verst.verstapp.Models.Models_Impl.BankOffice;
import com.app.verst.verstapp.Models.RVAdapterForBanks;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<BankOffice> mBanksList;
    String[] mWorkTime=new String[7];
    RecyclerView mRecyclerViewForBanks = (RecyclerView) findViewById(R.id.recycler_view_for_list_of_banks);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        mRecyclerViewForBanks.setLayoutManager(linearLayoutManager);

        RVAdapterForBanks adapterForBanks = new RVAdapterForBanks(mBanksList);
        mRecyclerViewForBanks.setAdapter(adapterForBanks);

    }


    private void initializationBanks(){

        mWorkTime[0]="09:00-18:00";
        mWorkTime[1]="09:00-18:00";
        mWorkTime[2]="09:00-18:00";
        mWorkTime[3]="09:00-18:00";
        mWorkTime[4]="09:00-18:00";
        mWorkTime[5]="Выходной";
        mWorkTime[6]="Выходной";

        mBanksList.add(new BankOffice("Спортивная, 5","Банк №1", 1.3f, mWorkTime,
                PhoneNumberUtils.formatNumber("8917000000","Ru"), 0));
        mBanksList.add(new BankOffice("Спортивная, 5","Банк №2", 3.6f, mWorkTime,
                PhoneNumberUtils.formatNumber("8917000000","Ru"), 0));
        mBanksList.add(new BankOffice("Спортивная, 5","Банк №3", 8.9f, mWorkTime,
                PhoneNumberUtils.formatNumber("8917000000","Ru"), 0));
        mBanksList.add(new BankOffice("Спортивная, 5","Банк №4", 18.2f, mWorkTime,
                PhoneNumberUtils.formatNumber("8917000000","Ru"), 0));
        mBanksList.add(new BankOffice("Спортивная, 5","Банк №5", 24.6f, mWorkTime,
                PhoneNumberUtils.formatNumber("8917000000","Ru"), 0));
    }
}
