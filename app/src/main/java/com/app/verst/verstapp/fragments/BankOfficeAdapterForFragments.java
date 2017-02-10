package com.app.verst.verstapp.fragments;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.app.verst.verstapp.R;
import com.app.verst.verstapp.models.Models_Impl.BankOffice;

import java.util.List;


/**
 * Created by magaz on 07.02.2017.
 */

public class BankOfficeAdapterForFragments extends RecyclerView.Adapter<BanksViewHolderForFragments> {

    List<BankOffice> mBankOffices;
    ArticleListFragment mFragment;


    public BankOfficeAdapterForFragments(List<BankOffice> bankOffices, ArticleListFragment fragment) {

        mBankOffices = bankOffices;
        mFragment=fragment;
    }

    @Override
    public int getItemCount() {
        return mBankOffices.size();
    }

    @Override
    public BanksViewHolderForFragments onCreateViewHolder(ViewGroup viewGroup, int viewType) {

        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.bank_office_item,viewGroup,false);
        BanksViewHolderForFragments mBanksViewHolder=new BanksViewHolderForFragments(v);
        return mBanksViewHolder;
    }

    @Override
    public void onBindViewHolder(BanksViewHolderForFragments holder, final int position) {
        holder.getBankAddress().setText(mBankOffices.get(position).getAddress());
        holder.getBankName().setText(mBankOffices.get(position).getName());
        holder.getBankDistance().setText(((String.valueOf(mBankOffices.get(position).getDistance())+" км.")));

        holder.getCardView().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                InformationAboutBankFragment informationAboutBank = new InformationAboutBankFragment();
                Bundle args = new Bundle();

                args.putParcelable(InformationAboutBankFragment.EXTRA_ADDRESS_FOR_SECOND_ACTIVITY,mBankOffices.get(position));
                informationAboutBank.setArguments(args);

                FragmentTransaction fragmentTransaction = mFragment.getFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.bank_office_activity_for_fragment,informationAboutBank);
                fragmentTransaction.addToBackStack("move_in_detail_card");
                fragmentTransaction.commit();
            }
        });
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    public interface OnSelectedRateListener {
        void onRateSelected(float buttonIndex);
    }
}
