package com.app.verst.verstapp.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RatingBar;
import android.widget.TextView;
import com.app.verst.verstapp.R;
import com.app.verst.verstapp.models.Models_Impl.BankOffice;

public class DetailInformationAboutBankFragment extends Fragment {

    private final static String EXTRA_ADDRESS_FOR_SECOND_ACTIVITY=
            "com.app.verst.verstapp.BanksViewHolderForBankOfficeAdapter.addressOfBank";
    private final static String EXTRA_ANSWER_WITH_RATING=
            "com.app.verst.verstapp.DetailInformationAboutBankFragment.ratingOfThisBank";

    private BankOffice mBankoffice;
    private float mRatingOfThisBankOffice;
    private View mView;

    public static DetailInformationAboutBankFragment createInformationAboutBankFragment(BankOffice bankOffice){
        DetailInformationAboutBankFragment informationAboutBank = new DetailInformationAboutBankFragment();
        Bundle args = new Bundle();

        args.putParcelable(DetailInformationAboutBankFragment.EXTRA_ADDRESS_FOR_SECOND_ACTIVITY, bankOffice);
        informationAboutBank.setArguments(args);

        return informationAboutBank;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

             mView= inflater.inflate(R.layout.bank_office_detail_view_for_fragment, container, false);


        fillingDetailInformationAboutBankOffice(mView);

        RatingBar ratingBarOfBank = (RatingBar) mView.findViewById(R.id.rating_in_bank_office_details_activity_rating_bar);
        ratingBarOfBank.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {

            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                mRatingOfThisBankOffice=rating;

                BankOfficeAdapter.OnSelectedRateListener listener = (BankOfficeAdapter.OnSelectedRateListener)getActivity();
                listener.onRateSelected(rating);

                Bundle resultData = new Bundle();
                resultData.putFloat(EXTRA_ANSWER_WITH_RATING,mRatingOfThisBankOffice);
            }
        });
        return mView;
    }

    public void fillingDetailInformationAboutBankOffice(View view) {

        mBankoffice = getArguments().getParcelable(EXTRA_ADDRESS_FOR_SECOND_ACTIVITY);

        TextView addressOfBankOffice= (TextView)view.findViewById(R.id.third_address_text_view);
        addressOfBankOffice.setText(mBankoffice.getAddress());

        TextView addressView = (TextView) view.findViewById(R.id.third_address_text_view);
        addressView.setText(mBankoffice.getAddress());

        TextView descriptionView = (TextView) view.findViewById(R.id.third_description_text_view);
        descriptionView.setText(mBankoffice.getName());

        TextView distanceView = (TextView) view.findViewById(R.id.distance_text_view);
        distanceView.setText(String.valueOf(mBankoffice.getDistance()));

        TextView timeView;
        String [] workTime=mBankoffice.getWorkTime();

        for(int i =0;i<workTime.length;i++){
            switch (i){
                case 0:
                    timeView=(TextView)view.findViewById(R.id.hour_1);
                    timeView.setText(workTime[i]);
                    break;
                case 1:
                    timeView=(TextView)view.findViewById(R.id.hour_2);
                    timeView.setText(workTime[i]);
                    break;
                case 2:
                    timeView=(TextView)view.findViewById(R.id.hour_3);
                    timeView.setText(workTime[i]);
                    break;
                case 3:
                    timeView=(TextView)view.findViewById(R.id.hour_4);
                    timeView.setText(workTime[i]);
                    break;
                case 4:
                    timeView=(TextView)view.findViewById(R.id.hour_5);
                    timeView.setText(workTime[i]);
                    break;
                case 5:
                    timeView=(TextView)view.findViewById(R.id.hour_6);
                    timeView.setText(workTime[i]);
                    break;
                case 6:
                    timeView=(TextView)view.findViewById(R.id.hour_7);
                    timeView.setText(workTime[i]);
                    break;
            }
        }
        TextView phoneOfBankOffice = (TextView)view.findViewById(R.id.phone_number_button);
        phoneOfBankOffice.setText(mBankoffice.getPhoneNumber());
    }
}
