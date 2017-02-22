package com.app.verst.verstapp.bankoffices.fragments.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.app.verst.verstapp.R;
import com.app.verst.verstapp.bankoffices.fragments.fragments.list.BanksListFragment;
import com.app.verst.verstapp.bankoffices.fragments.adapter.holder.BanksViewHolderForBankOfficeAdapter;
import com.app.verst.verstapp.bankoffices.fragments.models.Models_Impl.BankOffice;
import java.util.List;

public class BankOfficeAdapter extends RecyclerView.Adapter<BanksViewHolderForBankOfficeAdapter> {

    private List<BankOffice> mBankOffices;
    private BanksListFragment.OnTouchBankOfficeCallback mTouchCallback;

    public BankOfficeAdapter(BanksListFragment.OnTouchBankOfficeCallback touchCallback) {
        mTouchCallback = touchCallback;
    }

    @Override
    public int getItemCount() {
        if(mBankOffices!=null){
            return mBankOffices.size();
        }
        else
            return 0;
    }

    @Override
    public BanksViewHolderForBankOfficeAdapter onCreateViewHolder(ViewGroup viewGroup, int viewType) {

        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.bank_office_item,viewGroup,false);

        BanksViewHolderForBankOfficeAdapter mBanksViewHolder=new BanksViewHolderForBankOfficeAdapter(v);
        return mBanksViewHolder;
    }

    @Override
    public void onBindViewHolder(final BanksViewHolderForBankOfficeAdapter holder, final int position) {
        holder.getBankAddress().setText(mBankOffices.get(position).getAddress());
        holder.getBankName().setText(mBankOffices.get(position).getName());
        holder.getBankDistance().setText(((String.valueOf(mBankOffices
                .get(position).getDistance())+" км.")));

        holder.getCardView().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mTouchCallback.touchOnItem(mBankOffices.get(position));
            }
        });
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    public void update (List<BankOffice> updateList){
        mBankOffices=updateList;
        notifyDataSetChanged();
    }

    public interface OnSelectedRateListener {
        void onRateSelected(float buttonIndex);
    }
}
