package com.app.verst.verstapp.Models;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.support.v7.app.AppCompatActivity;
import com.app.verst.verstapp.BanksViewHolder;
import com.app.verst.verstapp.InformationAboutBank;
import com.app.verst.verstapp.MainActivity;
import com.app.verst.verstapp.Models.Models_Impl.BankOffice;
import com.app.verst.verstapp.R;

import java.util.List;


/**
 * Created by magaz on 07.02.2017.
 */

public class RVAdapterForBanks extends RecyclerView.Adapter<BanksViewHolder> {

    List<BankOffice> mBankOffices;
    Activity mActivity;

    public RVAdapterForBanks(List<BankOffice> bankOffices,Activity activity) {

        mBankOffices = bankOffices;
        mActivity=activity;
    }

    @Override
    public int getItemCount() {
        return mBankOffices.size();
    }

    @Override
    public BanksViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.relative_layout_view_for_recycle_view,viewGroup,false);
        v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mActivity, InformationAboutBank.class);
                mActivity.startActivity(intent);
            }
        });
        BanksViewHolder mBanksViewHolder=new BanksViewHolder(v);
        return mBanksViewHolder;
    }

    @Override
    public void onBindViewHolder(BanksViewHolder holder, int position) {
        holder.getBankAddress().setText(mBankOffices.get(position).getAddress());
        holder.getBankName().setText(mBankOffices.get(position).getName());
        holder.getBankDistance().setText(((String.valueOf(mBankOffices.get(position).getDistance())+" км.")));
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }
}
