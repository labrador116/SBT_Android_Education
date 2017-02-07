package com.app.verst.verstapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.PhoneNumberUtils;

import com.app.verst.verstapp.Models.Models_Impl.BankOffice;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    BankOffice[] mBanksList=new BankOffice[5];
    String[] mWorkTime=new String[7];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    private void initializiationBanks(){

        mWorkTime[0]="09:00-18:00";
        mWorkTime[1]="09:00-18:00";
        mWorkTime[2]="09:00-18:00";
        mWorkTime[3]="09:00-18:00";
        mWorkTime[4]="09:00-18:00";
        mWorkTime[5]="Выходной";
        mWorkTime[6]="Выходной";

        mBanksList[0]=new BankOffice("Спортивная, 5","Банк №1", 1.3f, mWorkTime, PhoneNumberUtils.formatNumber("8917000000","Ru"), 0);
        mBanksList[1]=new BankOffice("Спортивная, 5","Банк №2", 3.6f, mWorkTime, PhoneNumberUtils.formatNumber("8917000000","Ru"), 0);
        mBanksList[2]=new BankOffice("Спортивная, 5","Банк №3", 8.9f, mWorkTime, PhoneNumberUtils.formatNumber("8917000000","Ru"), 0);
        mBanksList[3]=new BankOffice("Спортивная, 5","Банк №4", 18.2f, mWorkTime, PhoneNumberUtils.formatNumber("8917000000","Ru"), 0);
        mBanksList[4]=new BankOffice("Спортивная, 5","Банк №5", 24.6f, mWorkTime, PhoneNumberUtils.formatNumber("8917000000","Ru"), 0);




    }
}
