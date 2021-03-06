package com.app.verst.verstapp.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.app.verst.verstapp.bankoffices.fragments.models.Models_Impl.data.GetDataByModel;
import com.app.verst.verstapp.database.BankOfficesDBSchema.BankOfficesWorkTime;
import com.app.verst.verstapp.database.BankOfficesDBSchema.bankOfficesTable;

public class BankOfficesBaseHelper extends SQLiteOpenHelper {
    public static final String NAME = "bankOffices.db";
    public static final int VERSION = 1;
    private Context mContext;


    public BankOfficesBaseHelper(Context context) {
        super(context, NAME, null, VERSION);
        mContext=context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table "+ bankOfficesTable.NAME+
        "("+
                " _id integer primary key autoincrement, "+
                bankOfficesTable.Columns.NAME + ", "+
                bankOfficesTable.Columns.ADDRESS+ ", " +
                bankOfficesTable.Columns.DISTANCE+ ", " +
                bankOfficesTable.Columns.PHONE_NUMBER+
        ")"
        );

        db.execSQL("create table "+ BankOfficesWorkTime.WORKTIME +
                "("+
                BankOfficesWorkTime.Columns.MONDAY +", "+
                BankOfficesWorkTime.Columns.TUESDAY +", "+
                BankOfficesWorkTime.Columns.WEDNESDAY+", "+
                BankOfficesWorkTime.Columns.THURSDAY+", "+
                BankOfficesWorkTime.Columns.FRIDAY+", "+
                BankOfficesWorkTime.Columns.SATURDAY+", "+
                BankOfficesWorkTime.Columns.SUNDAY +
                ")"
        );

        GetDataByModel dataByModel = new GetDataByModel(mContext);
        dataByModel.getData();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
