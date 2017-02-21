package com.app.verst.verstapp.fragments;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.app.verst.verstapp.R;
import com.app.verst.verstapp.models.Models_Impl.BankOffice;

public class BankOfficeCallbackActivityForFragments extends AppCompatActivity implements BankOfficeAdapter.OnSelectedRateListener,
        BanksListFragment.OnTouchBankOfficeCallback {

    private float mAnswerRating;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bank_office_activity_for_fragment);

        if (getFragmentManager().findFragmentByTag("ArtList")==null) {
            BanksListFragment fragment = new BanksListFragment();
            if (getResources().getConfiguration().ORIENTATION_LANDSCAPE != getResources().getConfiguration().orientation)
                getFragmentManager().beginTransaction().add(R.id.bank_office_activity_for_fragment, fragment, "ArtList")
                        .addToBackStack("ArticleList").commit();
        }
    }


    @Override
    public void onBackPressed() {
        FragmentManager fragmentManager = getFragmentManager();

        if(fragmentManager.getBackStackEntryCount()==1){
            super.onBackPressed();
            this.finish();
        } else {
                if(fragmentManager.getBackStackEntryCount()>0) {
                fragmentManager.popBackStack("move_in_detail_card", FragmentManager.POP_BACK_STACK_INCLUSIVE);
                    if ( mAnswerRating > 0) {
                        Toast.makeText(BankOfficeCallbackActivityForFragments.this, "Вы оценили отделение банка на "
                                + mAnswerRating, Toast.LENGTH_SHORT).show();
                    }
                }
        }
    }

    @Override
    public void onRateSelected(float rate) {
        mAnswerRating=rate;
    }

    @Override
    public void touchOnItem(BankOffice bankOffice) {
        Fragment fragment = DetailInformationAboutBankFragment.createInformationAboutBankFragment(bankOffice);

        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.bank_office_activity_for_fragment,fragment);
        fragmentTransaction.addToBackStack("move_in_detail_card");
        fragmentTransaction.commit();
        mAnswerRating=0;
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {

    }
}
