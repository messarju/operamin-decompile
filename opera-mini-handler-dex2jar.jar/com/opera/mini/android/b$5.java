// 
// Decompiled by Procyon v0.6-prerelease
// 

package com.opera.mini.android;

import android.database.ContentObserver;
import java.util.Map;
import android.database.sqlite.SQLiteQueryBuilder;
import android.database.Cursor;
import android.database.SQLException;
import android.content.ContentUris;
import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.content.UriMatcher;
import java.util.HashMap;
import android.content.ContentProvider;

public class b$5 extends ContentProvider
{
    private static HashMap<String, String> notesProjectionMap;
    public static boolean notifyStat = false;
    private static final UriMatcher sUriMatcher;
    public static final String t = "com.opera.mini.android.b$4";
    private static final String u = "hui";
    private static final int v = 1;
    private b$3 HUIDb;
    
    static {
        b$5.notifyStat = false;
        (sUriMatcher = new UriMatcher(-1)).addURI("com.opera.mini.android.xy", "hui", 1);
        (b$5.notesProjectionMap = new HashMap<String, String>()).put("no", "no");
        b$5.notesProjectionMap.put("isi", "isi");
    }
    
    @Override
    public int delete(final Uri uri, final String s, final String[] array) {
        final SQLiteDatabase writableDatabase = this.HUIDb.getWritableDatabase();
        switch (b$5.sUriMatcher.match(uri)) {
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Unknown URI").append(uri).toString());
            }
            case 1: {
                final int delete = writableDatabase.delete("hui", s, array);
                b$5.notifyStat = true;
                return delete;
            }
        }
    }
    
    @Override
    public String getType(final Uri uri) {
        switch (b$5.sUriMatcher.match(uri)) {
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Unknown URI").append(uri).toString());
            }
            case 1: {
                return "vnd.android.cursor.dir/vnd.handler.hui";
            }
        }
    }
    
    @Override
    public Uri insert(Uri withAppendedId, ContentValues contentValues) {
        if (b$5.sUriMatcher.match(withAppendedId) != 1) {
            throw new IllegalArgumentException(new StringBuffer().append("Unknown URI ").append(withAppendedId).toString());
        }
        if (contentValues != null) {
            contentValues = new ContentValues(contentValues);
        }
        else {
            contentValues = new ContentValues();
        }
        final long insert = this.HUIDb.getWritableDatabase().insert("hui", (String)null, contentValues);
        if (insert > 0) {
            withAppendedId = ContentUris.withAppendedId(b$2.c, insert);
            b$5.notifyStat = true;
            return withAppendedId;
        }
        throw new SQLException(new StringBuffer().append("Failed to insert row into ").append(withAppendedId).toString());
    }
    
    @Override
    public boolean onCreate() {
        this.HUIDb = new b$3(this.getContext());
        return true;
    }
    
    @Override
    public Cursor query(final Uri uri, final String[] array, final String s, final String[] array2, final String s2) {
        final SQLiteQueryBuilder sqLiteQueryBuilder = new SQLiteQueryBuilder();
        switch (b$5.sUriMatcher.match(uri)) {
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Unknown URI ").append(uri).toString());
            }
            case 1: {
                sqLiteQueryBuilder.setTables("hui");
                sqLiteQueryBuilder.setProjectionMap((Map)b$5.notesProjectionMap);
                final Cursor query = sqLiteQueryBuilder.query(this.HUIDb.getReadableDatabase(), array, s, array2, (String)null, (String)null, s2);
                query.setNotificationUri(this.getContext().getContentResolver(), uri);
                return query;
            }
        }
    }
    
    @Override
    public int update(final Uri uri, final ContentValues contentValues, final String s, final String[] array) {
        final SQLiteDatabase writableDatabase = this.HUIDb.getWritableDatabase();
        switch (b$5.sUriMatcher.match(uri)) {
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Unknown URI").append(uri).toString());
            }
            case 1: {
                final int update = writableDatabase.update("hui", contentValues, s, array);
                this.getContext().getContentResolver().notifyChange(uri, (ContentObserver)null);
                return update;
            }
        }
    }
}
