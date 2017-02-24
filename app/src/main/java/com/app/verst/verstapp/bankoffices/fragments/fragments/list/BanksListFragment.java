package com.app.verst.verstapp.bankoffices.fragments.fragments.list;

import android.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.app.verst.verstapp.R;
import com.app.verst.verstapp.bankoffices.fragments.CreateAsyncScheme;
import com.app.verst.verstapp.bankoffices.fragments.adapter.BankOfficeAdapter;
import com.app.verst.verstapp.bankoffices.fragments.models.Models_Impl.BankOffice;

public class BanksListFragment extends Fragment {

    private BankOfficeAdapter mAdapterForFragments;
    private OnTouchBankOfficeCallback mTouchCallback;
    private CreateAsyncScheme mScheme;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mTouchCallback =(OnTouchBankOfficeCallback) getActivity();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        mAdapterForFragments = new BankOfficeAdapter(mTouchCallback);

        View view=inflater.inflate(R.layout.bank_office_list_fragment, container, false);

        RecyclerView mRecyclerViewForBanks = (RecyclerView) view.findViewById(R.id.recycler_view_for_list_of_banks_fragment);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());

        mRecyclerViewForBanks.setLayoutManager(linearLayoutManager);

        mRecyclerViewForBanks.setAdapter(mAdapterForFragments);

        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
//        mAsyncTask.cancel(true);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mScheme=new CreateAsyncScheme(getActivity(),mAdapterForFragments);
        mScheme.startLoaderManager();
    }

    public interface OnTouchBankOfficeCallback {
        void touchOnItem(BankOffice bankOffice);
    }
}
