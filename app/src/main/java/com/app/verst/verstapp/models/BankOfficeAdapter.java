package com.app.verst.verstapp.models;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.app.verst.verstapp.BanksViewHolder;
import com.app.verst.verstapp.InformationAboutBank;
import com.app.verst.verstapp.models.Models_Impl.BankOffice;
import com.app.verst.verstapp.R;

import java.util.List;


/**
 * Created by magaz on 07.02.2017.
 */

public class BankOfficeAdapter extends RecyclerView.Adapter<BanksViewHolder> {

    List<BankOffice> mBankOffices;
    Activity mActivity;

    public BankOfficeAdapter(List<BankOffice> bankOffices, Activity activity) {

        mBankOffices = bankOffices;
        mActivity=activity;
    }

    @Override
    public int getItemCount() {
        return mBankOffices.size();
    }

    @Override
    public BanksViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {

        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.bank_office_item,viewGroup,false);
        BanksViewHolder mBanksViewHolder=new BanksViewHolder(v);
        return mBanksViewHolder;
    }

    @Override
    public void onBindViewHolder(BanksViewHolder holder, final int position) {
        holder.getBankAddress().setText(mBankOffices.get(position).getAddress());
        holder.getBankName().setText(mBankOffices.get(position).getName());
        holder.getBankDistance().setText(((String.valueOf(mBankOffices.get(position).getDistance())+" км.")));

        holder.getCardView().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                InformationAboutBank.starBankOfficeDetailActivity(mActivity,v, position);
            }
        });
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }
}
