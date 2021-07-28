package uz.lifepc.dictionarytest;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;

public class Dbhelper extends SQLiteOpenHelper {

    private Context mContext;
    public static final String DB_NAME="baza1.db";
    public static final int DB_VERSION=1;

    private String DB_PATH="";
    private String DB_LOCATION="";

    private final String main1_TB="main1";

    private final String col_key="key";
    private final String col_value="value";

    SQLiteDatabase mDB;

    public Dbhelper(Context context){
        super(context,DB_NAME,null,DB_VERSION);
        mContext=context;
        DB_LOCATION="/data/data/"+mContext.getPackageName()+"/database/";
        DB_PATH=DB_LOCATION+DB_NAME;

        if (!isExisDB()){
            try {
                File dbLocation=new File(DB_LOCATION);
                dbLocation.mkdirs();

                extraxtATDBD(DB_NAME);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        mDB=SQLiteDatabase.openOrCreateDatabase(DB_PATH,null);
    }

    boolean isExisDB(){
        File file=new File(DB_PATH);
        return file.exists();
    }

    public void extraxtATDBD(String fname) throws IOException {
            int len;
            InputStream is=this.mContext.getAssets().open(fname);
            File dPath=new File(DB_PATH);
            OutputStream os=new FileOutputStream(dPath);

            byte[] buffer=new byte[4096];
            while ((len=is.read(buffer))>0){
                os.write(buffer,0,len);
            }
            is.close();
            os.flush();
            is.close();
        }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public ArrayList<String> getWord(int dictype){
        String tname=getTBname(dictype);
        String sql1="SELECT * FROM "+tname;
        Cursor res = mDB.rawQuery(sql1,null);

        ArrayList<String> src=new ArrayList<>();
        while (res.moveToNext()){
            src.add(res.getString(res.getColumnIndex(col_key)));
        }
        return src;
    }

    public Word getWord(String key,int dictype){
        String tname=getTBname(dictype);
        String sql1="SELECT * FROM "+tname+" WHERE upper([key])=upper(?)";
        Cursor res = mDB.rawQuery(sql1,new String[]{key});

        Word word=new Word();
        while (res.moveToNext()){
            word.key=res.getString(res.getColumnIndex(col_key));
            word.value=res.getString(res.getColumnIndex(col_value));
        }
        return word;
    }

    public String getTBname(int dictype){
        String tname="";
        switch (dictype){
            case 1:tname="main1";break;
            case 2:tname="main2";break;
            case 3:tname="main3";break;
            case 4:tname="main4";break;
            case 5:tname="main5";break;
        }
        return tname;
    }
}

