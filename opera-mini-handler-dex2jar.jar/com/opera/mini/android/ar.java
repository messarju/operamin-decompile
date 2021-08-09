// 
// Decompiled by Procyon v0.6-prerelease
// 

package com.opera.mini.android;

import java.io.InputStream;
import java.io.DataInputStream;
import java.io.ByteArrayInputStream;
import android.database.sqlite.SQLiteDoneException;
import java.io.IOException;
import android.content.ContentValues;
import java.io.File;
import android.database.sqlite.SQLiteDatabase$CursorFactory;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.content.Context;
import android.database.sqlite.SQLiteStatement;

public final class ar extends bs
{
    private static final String b;
    private SQLiteStatement B;
    private Context C;
    private SQLiteDatabase I;
    private SQLiteStatement J;
    private SQLiteStatement Z;
    private boolean a;
    
    static {
        b = u.a(13);
    }
    
    private ar(final Context c) {
        this.a = false;
        this.C = c;
    }
    
    private int B(final String s, final String s2) {
        while (true) {
            Cursor rawQuery = null;
            while (true) {
                int n;
                try {
                    final Cursor cursor = rawQuery = this.I.rawQuery("SELECT record_id, record FROM rms WHERE store = ? AND record NOT NULL", new String[] { s });
                    final int count = cursor.getCount();
                    n = 0;
                    if (n >= count) {
                        return -1;
                    }
                    rawQuery = cursor;
                    cursor.moveToNext();
                    rawQuery = cursor;
                    final int int1 = cursor.getInt(0);
                    rawQuery = cursor;
                    final byte[] blob = cursor.getBlob(1);
                    rawQuery = cursor;
                    if (!u.I(blob)) {
                        rawQuery = cursor;
                        this.Z(s, int1);
                    }
                    else {
                        rawQuery = cursor;
                        if (u.Code(blob, u.Code(blob)).equals(s2)) {
                            return int1;
                        }
                    }
                }
                finally {
                    if (rawQuery != null) {
                        rawQuery.close();
                    }
                }
                ++n;
                continue;
            }
        }
    }
    
    public static ar Code(final Context context) {
        if (ar.Code == null) {
            I(context);
        }
        return (ar)ar.Code;
    }
    
    private void I() {
        while (true) {
            boolean a = true;
            monitorenter(this);
            while (true) {
                try {
                    final File databasePath = this.C.getDatabasePath("operamini.db");
                    databasePath.getParentFile().mkdir();
                    (this.I = SQLiteDatabase.openDatabase(databasePath.getAbsolutePath(), (SQLiteDatabase$CursorFactory)null, 268435472)).setLockingEnabled(true);
                    if (d.a(this.C.getFilesDir().getAbsolutePath()) > databasePath.length()) {
                        this.I.execSQL("VACUUM");
                    }
                    final int version = this.I.getVersion();
                    Label_0129: {
                        if (version == 3) {
                            break Label_0129;
                        }
                        this.I.beginTransaction();
                        Label_0137: {
                            if (version != 0) {
                                break Label_0137;
                            }
                            try {
                                this.I.execSQL("CREATE TABLE rms (store TEXT, record_id INTEGER,record BLOB, PRIMARY KEY (store, record_id));");
                                this.I.setVersion(3);
                                this.I.setTransactionSuccessful();
                                this.I.endTransaction();
                                final SQLiteDatabase i = this.I;
                                monitorexit(this);
                                return;
                                final SQLiteDatabase j = this.I;
                                this.I.execSQL("DROP TABLE IF EXISTS android_metadata;");
                                iftrue(Label_0201:)(version > 2);
                                this.a = a;
                            }
                            finally {
                                this.I.endTransaction();
                            }
                        }
                    }
                }
                finally {
                    try {
                        if (this.I != null) {
                            this.I.close();
                            this.I = null;
                        }
                    }
                    finally {
                        monitorexit(this);
                    }
                }
                Label_0201: {
                    a = false;
                }
                continue;
            }
        }
    }
    
    public static void I(final Context context) {
        final ar code = new ar(context);
        code.I();
        code.Z = code.I.compileStatement("SELECT MAX(record_id) FROM rms WHERE store=?");
        code.J = code.I.compileStatement("SELECT MIN(record_id) FROM rms WHERE store=? AND record NOT NULL");
        code.B = code.I.compileStatement("SELECT COUNT(record_id) FROM rms WHERE store=?");
        ar.Code = code;
    }
    
    private void Z(final String s, final int n) {
        final ContentValues contentValues = new ContentValues();
        contentValues.put("store", s);
        contentValues.put("record_id", new Integer(n));
        contentValues.putNull("record");
        this.I.replace("rms", "record", contentValues);
    }
    
    @Override
    public final int Code(final String s, final byte[] array) {
        synchronized (this) {
            this.Z.bindString(1, s);
            final int n = (int)this.Z.simpleQueryForLong();
            this.Z.clearBindings();
            final int n2 = n + 1;
            final ContentValues contentValues = new ContentValues();
            contentValues.put("store", s);
            contentValues.put("record_id", new Integer(n2));
            contentValues.put("record", array);
            this.I.insert("rms", "record", contentValues);
            return n2;
        }
    }
    
    public final void Code() {
        if (this.I != null) {
            this.I.close();
            this.I = null;
        }
    }
    
    @Override
    public final void Code(final String s, final int n, final byte[] array) {
        final ContentValues contentValues = new ContentValues();
        contentValues.put("store", s);
        contentValues.put("record_id", new Integer(n));
        contentValues.put("record", array);
        if (this.I.replace("rms", "record", contentValues) == -1L) {
            throw new IOException("An error occurred in setRecord");
        }
    }
    
    @Override
    public final void Code(final String s, final String s2, final byte[] array, final int n) {
        final int b = this.B(s, s2);
        if (b > 0) {
            this.Code(s, b, u.Code(s2, array, n));
            if (this.a && s.equals(ar.b)) {
                this.I.execSQL("VACUUM");
                this.a = false;
            }
            return;
        }
        this.Code(s, u.Code(s2, array, n));
    }
    
    @Override
    public final boolean Code(final String s) {
        boolean b = true;
        synchronized (this) {
            try {
                this.B.bindString(1, s);
                if (this.B.simpleQueryForLong() <= 0L) {
                    b = false;
                }
                return b;
            }
            catch (SQLiteDoneException ex) {
                b = false;
                return b;
            }
        }
    }
    
    @Override
    public final boolean Code(final String s, final String s2) {
        return this.B(s, s2) > 0;
    }
    
    @Override
    public final byte[] Code(final String s, final int n) {
        Cursor rawQuery = null;
        try {
            final Cursor cursor = rawQuery = this.I.rawQuery("SELECT record FROM rms WHERE store = ? AND record_id = ?", new String[] { s, String.valueOf(n) });
            if (cursor.getCount() == 0) {
                rawQuery = cursor;
                throw new IOException();
            }
        }
        finally {
            if (rawQuery != null) {
                rawQuery.close();
            }
        }
        final Cursor cursor2;
        cursor2.moveToFirst();
        final byte[] blob = cursor2.getBlob(0);
        if (cursor2 != null) {
            cursor2.close();
        }
        return blob;
    }
    
    @Override
    public final void I(final String s, final int n) {
        while (true) {
            int n2 = 0;
            Cursor rawQuery = null;
            while (true) {
                try {
                    final Cursor cursor = rawQuery = this.I.rawQuery("SELECT record_id, record FROM rms WHERE store=? AND record NOT NULL", new String[] { s });
                    final int count = cursor.getCount();
                    if (n2 >= count) {
                        return;
                    }
                    rawQuery = cursor;
                    cursor.moveToNext();
                    rawQuery = cursor;
                    final int int1 = cursor.getInt(0);
                    rawQuery = cursor;
                    final byte[] blob = cursor.getBlob(1);
                    rawQuery = cursor;
                    if (!u.I(blob)) {
                        rawQuery = cursor;
                        this.Z(s, int1);
                    }
                    else {
                        rawQuery = cursor;
                        if (u.J(u.Code(blob, u.Code(blob))) == n) {
                            rawQuery = cursor;
                            this.Z(s, int1);
                            return;
                        }
                    }
                }
                finally {
                    if (rawQuery != null) {
                        rawQuery.close();
                    }
                }
                ++n2;
                continue;
            }
        }
    }
    
    @Override
    public final void I(final String s, final String s2) {
        final int b = this.B(s, s2);
        if (b != -1) {
            this.Z(s, b);
        }
    }
    
    @Override
    public final byte[] I(final String s) {
        monitorenter(this);
        Cursor cursor2;
        final Cursor cursor = cursor2 = null;
        try {
            this.J.bindString(1, s);
            cursor2 = cursor;
            this.B.bindString(1, s);
            cursor2 = cursor;
            final long simpleQueryForLong = this.B.simpleQueryForLong();
            cursor2 = cursor;
            this.B.clearBindings();
            if (simpleQueryForLong == 0L) {
                cursor2 = cursor;
                throw new IOException("Record not found");
            }
        }
        finally {
            if (cursor2 != null) {
                cursor2.close();
            }
            try {}
            finally {
                monitorexit(this);
            }
        }
        final String simpleQueryForString = this.J.simpleQueryForString();
        this.J.clearBindings();
        if (simpleQueryForString == null) {
            throw new IOException("Record not found");
        }
        final String s2;
        final Cursor rawQuery = this.I.rawQuery("SELECT record FROM rms WHERE store=? AND record_id=?", new String[] { s2, simpleQueryForString });
        if (rawQuery.getCount() == 0) {
            throw new IOException();
        }
        rawQuery.moveToFirst();
        final byte[] blob = rawQuery.getBlob(0);
        if (rawQuery != null) {
            rawQuery.close();
        }
        monitorexit(this);
        return blob;
    }
    
    @Override
    public final ab J(final String s, final String s2) {
        final ab ab = null;
        final int b = this.B(s, s2);
        ab ab2 = ab;
        if (b > 0) {
            final byte[] code = this.Code(s, b);
            final int code2 = u.Code(code);
            final byte[] array = new byte[code2];
            ab2 = new ab();
            System.arraycopy(code, 0, array, 0, code2);
            ab2.Code = new DataInputStream(new ByteArrayInputStream(array));
            ab2.I = code2;
        }
        return ab2;
    }
    
    @Override
    public final void Z(final String s) {
        try {
            this.I.delete("rms", "store='" + s + "'", (String[])null);
        }
        catch (IOException ex) {}
    }
    
    @Override
    public final byte[] Z(final String s, final String s2) {
        final int b = this.B(s, s2);
        if (b > 0) {
            return this.Code(s, b);
        }
        return null;
    }
}
