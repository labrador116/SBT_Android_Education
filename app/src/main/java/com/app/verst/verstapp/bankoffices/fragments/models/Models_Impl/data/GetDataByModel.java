package com.app.verst.verstapp.bankoffices.fragments.models.Models_Impl.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;

import com.app.verst.verstapp.bankoffices.fragments.models.Models_Impl.BankOffice;
import com.app.verst.verstapp.database.BankOfficesBaseHelper;
import com.app.verst.verstapp.database.BankOfficesDBSchema.bankOfficesTable;
import com.app.verst.verstapp.database.BankOfficesDBSchema.bankOfficesTable.Columns;
import com.app.verst.verstapp.database.cursor_wrapper.BankOfficesCursorWrapper;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Random;

import static com.app.verst.verstapp.database.BankOfficesDBSchema.BankOfficesWorkTime;

public class GetDataByModel {
    private Context mContext;
    private SQLiteDatabase mDatabase;

    public GetDataByModel(Context context){
        mContext=context.getApplicationContext();
        mDatabase = new BankOfficesBaseHelper(mContext).getWritableDatabase();
    }

    public ArrayList<BankOffice> loadDataFromDB(){
        BankOfficesCursorWrapper cursorWrapper = queryBankOffices(mContext);
        ArrayList<BankOffice> bankOffices = new ArrayList<>();
        String[] workTime = getWorkTime();

        try {
            cursorWrapper.moveToFirst();

            while (!cursorWrapper.isAfterLast()){
                BankOffice bankOffice=cursorWrapper.getBankOffice();
                bankOffice.setWorkTime(workTime);
                bankOffices.add(bankOffice);
                cursorWrapper.moveToNext();
            }
        }finally {
            cursorWrapper.close();
        }
        return bankOffices;
    }

    public  void getData(){
        String[] mWorkTime = new String[7];
        mWorkTime[0] = "09:00-18:00";
        mWorkTime[1] = "09:00-18:00";
        mWorkTime[2] = "09:00-18:00";
        mWorkTime[3] = "09:00-18:00";
        mWorkTime[4] = "09:00-18:00";
        mWorkTime[5] = "День счастья";
        mWorkTime[6] = "Выходной";

        addWorkTime(mWorkTime);

        for (int i = 0; i < 100; i++) {

            NumberFormat value = new DecimalFormat("#0.00");
            addBankOffice(new BankOffice("Спортивная, " + new Random().nextInt(100),
                    "Банк №" + i,
                    Float.valueOf(value.format(new Random().nextFloat())),
                    "88002000600", 0));
        }

    }

    private BankOfficesCursorWrapper queryBankOffices(Context context){
        Cursor cursor = context.getContentResolver().query(
                Uri.parse("content://com.app.verst.verstapp.provider"),
                 null,
                null,
                null,
                null
        );

        return new BankOfficesCursorWrapper(cursor);
    }

    private BankOfficesCursorWrapper queryWortTime(String whereClause, String[] whereArgs){
        Cursor cursor = mDatabase.query(
                BankOfficesWorkTime.WORKTIME,
                null,
                whereClause,
                whereArgs,
                null,
                null,
                null
        );
        return new BankOfficesCursorWrapper(cursor);
    }

    private String[] getWorkTime(){
        BankOfficesCursorWrapper cursorWrapper = queryWortTime(null,null);
        String[] workTime;
        try{
            cursorWrapper.moveToFirst();
            workTime = cursorWrapper.getWorkTime();
        }finally {
            cursorWrapper.close();
        }
        return workTime;
    }

    public static ContentValues getContentValues (BankOffice bankOffice){
        ContentValues contentValues = new ContentValues();
        contentValues.put(Columns.NAME, bankOffice.getName());
        contentValues.put(Columns.ADDRESS, bankOffice.getAddress());
        contentValues.put(Columns.DISTANCE, bankOffice.getDistance());
        contentValues.put(Columns.PHONE_NUMBER, bankOffice.getPhoneNumber());
        return contentValues;
    }
    public void addBankOffice(BankOffice bankOffice){
        ContentValues values = getContentValues(bankOffice);
        mDatabase.insert(bankOfficesTable.NAME,null,values);
    }

    public static ContentValues getContentValues(String[] workTime){
        ContentValues contentValues = new ContentValues();
        contentValues.put(BankOfficesWorkTime.Columns.MONDAY, workTime[0]);
        contentValues.put(BankOfficesWorkTime.Columns.TUESDAY, workTime[1]);
        contentValues.put(BankOfficesWorkTime.Columns.WEDNESDAY, workTime[2]);
        contentValues.put(BankOfficesWorkTime.Columns.THURSDAY, workTime[3]);
        contentValues.put(BankOfficesWorkTime.Columns.FRIDAY, workTime[4]);
        contentValues.put(BankOfficesWorkTime.Columns.SATURDAY, workTime[5]);
        contentValues.put(BankOfficesWorkTime.Columns.SUNDAY, workTime[6]);
        return contentValues;
    }
    public void addWorkTime(String[] workTime){
        ContentValues values = getContentValues(workTime);
        mDatabase.insert(BankOfficesWorkTime.WORKTIME, null, values);
    }

}
