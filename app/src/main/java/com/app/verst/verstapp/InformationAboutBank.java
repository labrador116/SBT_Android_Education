//package com.app.verst.verstapp;
//
//import android.app.Activity;
//import android.content.Intent;
//import android.os.Bundle;
//import android.support.annotation.Nullable;
//import android.support.v7.app.AppCompatActivity;
//import android.widget.RatingBar;
//import android.widget.TextView;
//
//import com.app.verst.verstapp.bankoffices.fragments.models.Models_Impl.BankOffice;
//
//public class InformationAboutBank extends AppCompatActivity {
//
//    private final static String EXTRA_ADDRESS_FOR_SECOND_ACTIVITY="com.app.verst.verstapp.BanksViewHolderForBankOfficeAdapter.addressOfBank";
//    private final static String EXTRA_ANSWER_WITH_RATING="com.app.verst.verstapp.DetailInformationAboutBankFragment.ratingOfThisBank";
//    private final static int REQUEST_CODE=0;
//
//    private BankOffice mBankoffice;
//    private float mRatingOfThisBankOffice;
//
//
//    @Override
//    protected void onCreate(@Nullable Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.bank_office_detail_activity);
//        fillBankDetailActivity();
//
//
//
//        RatingBar ratingBarOfBank = (RatingBar)findViewById(R.id.rating_in_bank_office_details_activity_rating_bar);
//        ratingBarOfBank.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
//            @Override
//            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
//                mRatingOfThisBankOffice=rating;
//                Intent resultData = new Intent();
//                resultData.putExtra(EXTRA_ANSWER_WITH_RATING,mRatingOfThisBankOffice);
//                setResult(RESULT_OK,resultData);
//            }
//        });
//
//
//
//
//
//    }
//
//    public void fillBankDetailActivity()
//    {
//        mBankoffice = getIntent().getParcelableExtra(EXTRA_ADDRESS_FOR_SECOND_ACTIVITY);
//
//        TextView addressOfBankOffice= (TextView)findViewById(R.id.third_address_text_view);
//        addressOfBankOffice.setText(mBankoffice.getAddress());
//
//        TextView addressView = (TextView)findViewById(R.id.third_address_text_view);
//        addressView.setText(mBankoffice.getAddress());
//        TextView descriptionView = (TextView)findViewById(R.id.third_description_text_view);
//        descriptionView.setText(mBankoffice.getName());
//        TextView distanceView = (TextView)findViewById(R.id.distance_text_view);
//        distanceView.setText(String.valueOf(mBankoffice.getDistance()));
//
//        TextView timeView;
//        String [] workTime=mBankoffice.getWorkTime();
//
//        for(int i =0;i<workTime.length;i++){
//            switch (i){
//                case 0:
//                    timeView=(TextView)findViewById(R.id.hour_1);
//                    timeView.setText(workTime[i]);
//                    break;
//                case 1:
//                    timeView=(TextView)findViewById(R.id.hour_2);
//                    timeView.setText(workTime[i]);
//                    break;
//                case 2:
//                    timeView=(TextView)findViewById(R.id.hour_3);
//                    timeView.setText(workTime[i]);
//                    break;
//                case 3:
//                    timeView=(TextView)findViewById(R.id.hour_4);
//                    timeView.setText(workTime[i]);
//                    break;
//                case 4:
//                    timeView=(TextView)findViewById(R.id.hour_5);
//                    timeView.setText(workTime[i]);
//                    break;
//                case 5:
//                    timeView=(TextView)findViewById(R.id.hour_6);
//                    timeView.setText(workTime[i]);
//                    break;
//                case 6:
//                    timeView=(TextView)findViewById(R.id.hour_7);
//                    timeView.setText(workTime[i]);
//                    break;
//            }
//        }
//        TextView phoneOfBankOffice = (TextView)findViewById(R.id.phone_number_button);
//        phoneOfBankOffice.setText(mBankoffice.getPhoneNumber());
//    }
//
//    public static void starBankOfficeDetailActivity(Activity mActivity,BankOffice bankOffice ){
//        Intent intent = new Intent(mActivity, InformationAboutBank.class);
//        intent.putExtra(InformationAboutBank.EXTRA_ADDRESS_FOR_SECOND_ACTIVITY,bankOffice);
//        mActivity.startActivityForResult(intent, REQUEST_CODE);
//    }
//
//    public static float getRatingFromBankOfficeDetailsActivity(Intent intent){
//        return intent.getFloatExtra(EXTRA_ANSWER_WITH_RATING, 0);
//    }
//}
