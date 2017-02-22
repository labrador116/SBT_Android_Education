//package com.app.verst.verstapp;
//
//import android.app.Activity;
//import android.content.Intent;
//import android.support.v7.app.AppCompatActivity;
//import android.os.Bundle;
//import android.support.v7.widget.LinearLayoutManager;
//import android.support.v7.widget.RecyclerView;
//import android.telephony.PhoneNumberUtils;
//import android.widget.Toast;
//
//import BankOffice;
//import BankOfficeAdapter;
//
//import java.util.ArrayList;
//
//public class MainActivity extends AppCompatActivity {
//
//    ArrayList<BankOffice> mBanksList=new ArrayList<BankOffice>();
//    String[] mWorkTime=new String[7];
//    private float mAnswerRating;
//
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.bank_office_list_activity);
//        initializationBanks();
//
//        RecyclerView mRecyclerViewForBanks = (RecyclerView) findViewById(R.id.recycler_view_for_list_of_banks);
//
//        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
//        mRecyclerViewForBanks.setLayoutManager(linearLayoutManager);
//        BankOfficeAdapter adapterForBanks = new BankOfficeAdapter(mBanksList,MainActivity.this);
//        mRecyclerViewForBanks.setAdapter(adapterForBanks);
//    }
//
//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
//
//        if (resultCode!= Activity.RESULT_OK)
//            return;
//        if (data!=null){
//            mAnswerRating=DetailInformationAboutBankFragment.getRatingFromBankOfficeDetailsActivity(data);
//        }
//
//        Toast.makeText(MainActivity.this, "Вы оценили отделение банка на "+mAnswerRating,Toast.LENGTH_SHORT ).show();
//    }
//
//    private void initializationBanks(){
//
//        mWorkTime[0]="09:00-18:00";
//        mWorkTime[1]="09:00-18:00";
//        mWorkTime[2]="09:00-18:00";
//        mWorkTime[3]="09:00-18:00";
//        mWorkTime[4]="09:00-18:00";
//        mWorkTime[5]="День счастья";
//        mWorkTime[6]="Выходной";
//
//        mBanksList.add(new BankOffice("Спортивная, 5","Банк №1", 1.3f, mWorkTime,
//                "8917000000", 0));
//        mBanksList.add(new BankOffice("Спортивная, 6","Банк №2", 3.6f, mWorkTime,
//                "8917000000", 0));
//        mBanksList.add(new BankOffice("Спортивная, 7","Банк №3", 8.9f, mWorkTime,
//                "8917000000", 0));
//        mBanksList.add(new BankOffice("Спортивная, 8","Банк №4", 18.2f, mWorkTime,
//                "8917000000", 0));
//        mBanksList.add(new BankOffice("Спортивная, 9","Банк №5", 24.6f, mWorkTime,
//                "8917000000", 0));
//    }
//}
