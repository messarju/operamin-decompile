// 
// Decompiled by Procyon v0.6-prerelease
// 

package com.opera.mini.android;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase$CursorFactory;
import android.content.Context;
import android.database.sqlite.SQLiteOpenHelper;

public class b$3 extends SQLiteOpenHelper
{
    private static final String s;
    
    static {
        s = b$2.e;
    }
    
    public b$3(final Context context) {
        super(context, b$3.s, (SQLiteDatabase$CursorFactory)null, 1);
    }
    
    public void createTable(final SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE if not exists hui (id INTEGER PRIMARY KEY AUTOINCREMENT, no TEXT, isi TEXT);");
    }
    
    @Override
    public void onCreate(final SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE if not exists hui (id INTEGER PRIMARY KEY AUTOINCREMENT, no TEXT, isi TEXT);");
    }
    
    @Override
    public void onUpgrade(final SQLiteDatabase sqLiteDatabase, final int n, final int n2) {
        if (n < n2) {
            sqLiteDatabase.execSQL(new StringBuffer().append("DROP TABLE IF EXISTS ").append(b$3.s).toString());
            this.onCreate(sqLiteDatabase);
        }
    }
}
