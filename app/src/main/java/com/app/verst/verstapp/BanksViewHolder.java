package com.app.verst.verstapp;

import android.app.Activity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

/**
 * Created by magaz on 07.02.2017.
 */

public class BanksViewHolder extends RecyclerView.ViewHolder {
    private CardView mCardView;
    private TextView mBankAddress;
    private TextView mBankName;
    private TextView mBankDistance;
    //private TextView[] mBankWorkTime;
    //private String mBankPhoneNumber;
    //private int mBankRatingQualityOfWork;

    public BanksViewHolder(View itemView) {
        super(itemView);
        mCardView=(CardView) itemView.findViewById(R.id.list_of_banks_card_view);
        mBankAddress = (TextView) itemView.findViewById(R.id.address_text_view);
        mBankName = (TextView) itemView.findViewById(R.id.bank_name_text_view);
        mBankDistance = (TextView) itemView.findViewById(R.id.distance_view_text_view);
    }

    public CardView getCardView() {
        return mCardView;
    }

    public TextView getBankAddress() {
        return mBankAddress;
    }

    public TextView getBankName() {
        return mBankName;
    }

    public TextView getBankDistance() {
        return mBankDistance;
    }
}
