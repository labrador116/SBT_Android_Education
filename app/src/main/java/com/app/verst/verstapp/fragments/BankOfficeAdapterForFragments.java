package com.app.verst.verstapp.fragments;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.app.verst.verstapp.R;
import com.app.verst.verstapp.models.Models_Impl.BankOffice;
import java.util.List;

public class BankOfficeAdapterForFragments extends RecyclerView.Adapter<BanksViewHolderForFragments> {

    List<BankOffice> mBankOffices;
    ArticleListFragment.OnTouchBankOffice mCallback;

    public BankOfficeAdapterForFragments(List<BankOffice> bankOffices, ArticleListFragment.OnTouchBankOffice callback) {
        mBankOffices = bankOffices;
        mCallback=callback;
    }

    public void update (List<BankOffice> updateList){
        mBankOffices=updateList;
        notifyDataSetChanged();
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
    public void onBindViewHolder(final BanksViewHolderForFragments holder, final int position) {
        holder.getBankAddress().setText(mBankOffices.get(position).getAddress());
        holder.getBankName().setText(mBankOffices.get(position).getName());
        holder.getBankDistance().setText(((String.valueOf(mBankOffices.get(position).getDistance())+" км.")));

        holder.getCardView().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCallback.touchOnItem(mBankOffices.get(position));
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
