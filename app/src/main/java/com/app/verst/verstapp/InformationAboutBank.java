package com.app.verst.verstapp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class InformationAboutBank extends AppCompatActivity {

    private String mAddressOfBank;

    public final static String EXTRA_ADDRESS_FOR_SECOND_ACTIVITY="com.app.verst.verstapp.BanksViewHolder.addressOfBank";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bank_office_item);

        mAddressOfBank=getIntent().getStringExtra(EXTRA_ADDRESS_FOR_SECOND_ACTIVITY);
        TextView addressView = (TextView)findViewById(R.id.third_address_text_view);
        addressView.setText(mAddressOfBank);
    }
}
