package com.app.verst.verstapp.bankoffices.fragments.adapter.holder;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import com.app.verst.verstapp.R;

public class BanksViewHolderForBankOfficeAdapter extends RecyclerView.ViewHolder {
    private CardView mCardView;
    private TextView mBankAddress;
    private TextView mBankName;
    private TextView mBankDistance;

    public BanksViewHolderForBankOfficeAdapter(View itemView) {
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
