// 
// Decompiled by Procyon v0.6-prerelease
// 

package com.google.analytics.tracking.android;

import android.database.Cursor;
import java.util.HashSet;
import android.os.Build$VERSION;
import java.io.File;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase$CursorFactory;
import android.content.Context;
import android.database.sqlite.SQLiteOpenHelper;

final class ak extends SQLiteOpenHelper
{
    private boolean Code;
    private long I;
    private /* synthetic */ ad Z;
    
    ak(final ad z, final Context context, final String s) {
        this.Z = z;
        super(context, s, (SQLiteDatabase$CursorFactory)null, 1);
        this.I = 0L;
    }
    
    private static boolean Code(final String p0, final SQLiteDatabase p1) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: astore_3       
        //     2: aload_1        
        //     3: ldc             "SQLITE_MASTER"
        //     5: iconst_1       
        //     6: anewarray       Ljava/lang/String;
        //     9: dup            
        //    10: iconst_0       
        //    11: ldc             "name"
        //    13: aastore        
        //    14: ldc             "name=?"
        //    16: iconst_1       
        //    17: anewarray       Ljava/lang/String;
        //    20: dup            
        //    21: iconst_0       
        //    22: aload_0        
        //    23: aastore        
        //    24: aconst_null    
        //    25: aconst_null    
        //    26: aconst_null    
        //    27: invokevirtual   android/database/sqlite/SQLiteDatabase.query:(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
        //    30: astore_1       
        //    31: aload_1        
        //    32: invokeinterface android/database/Cursor.moveToFirst:()Z
        //    37: istore_2       
        //    38: aload_1        
        //    39: ifnull          48
        //    42: aload_1        
        //    43: invokeinterface android/database/Cursor.close:()V
        //    48: iload_2        
        //    49: ireturn        
        //    50: astore_1       
        //    51: aconst_null    
        //    52: astore_1       
        //    53: new             Ljava/lang/StringBuilder;
        //    56: dup            
        //    57: ldc             "error querying for table "
        //    59: invokespecial   java/lang/StringBuilder.<init>:(Ljava/lang/String;)V
        //    62: aload_0        
        //    63: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //    66: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //    69: invokestatic    com/google/analytics/tracking/android/ae.C:(Ljava/lang/String;)I
        //    72: pop            
        //    73: aload_1        
        //    74: ifnull          83
        //    77: aload_1        
        //    78: invokeinterface android/database/Cursor.close:()V
        //    83: iconst_0       
        //    84: ireturn        
        //    85: astore_0       
        //    86: aload_3        
        //    87: astore_1       
        //    88: aload_1        
        //    89: ifnull          98
        //    92: aload_1        
        //    93: invokeinterface android/database/Cursor.close:()V
        //    98: aload_0        
        //    99: athrow         
        //   100: astore_0       
        //   101: goto            88
        //   104: astore_0       
        //   105: goto            88
        //   108: astore_3       
        //   109: goto            53
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                                     
        //  -----  -----  -----  -----  -----------------------------------------
        //  2      31     50     53     Landroid/database/sqlite/SQLiteException;
        //  2      31     85     88     Any
        //  31     38     108    112    Landroid/database/sqlite/SQLiteException;
        //  31     38     100    104    Any
        //  53     73     104    108    Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IndexOutOfBoundsException: Index: 64, Size: 64
        //     at java.util.ArrayList.rangeCheck(ArrayList.java:659)
        //     at java.util.ArrayList.get(ArrayList.java:435)
        //     at com.strobel.decompiler.ast.AstBuilder.convertToAst(AstBuilder.java:3379)
        //     at com.strobel.decompiler.ast.AstBuilder.build(AstBuilder.java:113)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:206)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:94)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethodBody(AstBuilder.java:840)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethod(AstBuilder.java:733)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addTypeMembers(AstBuilder.java:610)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeCore(AstBuilder.java:577)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeNoCache(AstBuilder.java:193)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createType(AstBuilder.java:160)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addType(AstBuilder.java:135)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.buildAst(JavaLanguage.java:71)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.decompileType(JavaLanguage.java:59)
        //     at com.strobel.decompiler.DecompilerDriver.decompileType(DecompilerDriver.java:333)
        //     at com.strobel.decompiler.DecompilerDriver.decompileJar(DecompilerDriver.java:254)
        //     at com.strobel.decompiler.DecompilerDriver.main(DecompilerDriver.java:144)
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    public final SQLiteDatabase getWritableDatabase() {
        if (this.Code && this.I + 3600000L > this.Z.b.Code()) {
            throw new SQLiteException("Database creation failed");
        }
        SQLiteDatabase writableDatabase = null;
        this.Code = true;
        this.I = this.Z.b.Code();
        while (true) {
            try {
                writableDatabase = super.getWritableDatabase();
                SQLiteDatabase writableDatabase2 = writableDatabase;
                if (writableDatabase == null) {
                    writableDatabase2 = super.getWritableDatabase();
                }
                this.Code = false;
                return writableDatabase2;
            }
            catch (SQLiteException ex) {
                this.Z.B.getDatabasePath(this.Z.C).delete();
                continue;
            }
            break;
        }
    }
    
    public final void onCreate(final SQLiteDatabase sqLiteDatabase) {
        final String path = sqLiteDatabase.getPath();
        if (q.Code() >= 9) {
            final File file = new File(path);
            file.setReadable(false, false);
            file.setWritable(false, false);
            file.setReadable(true, true);
            file.setWritable(true, true);
        }
    }
    
    public final void onOpen(final SQLiteDatabase sqLiteDatabase) {
        final int n = 0;
        Label_0034: {
            if (Build$VERSION.SDK_INT >= 15) {
                break Label_0034;
            }
            while (true) {
                Cursor cursor = sqLiteDatabase.rawQuery("PRAGMA journal_mode=memory", (String[])null);
                try {
                    cursor.moveToFirst();
                    cursor.close();
                    if (!Code("hits2", sqLiteDatabase)) {
                        sqLiteDatabase.execSQL(ad.Code);
                        return;
                    }
                }
                finally {
                    cursor.close();
                }
                final SQLiteDatabase sqLiteDatabase2;
                cursor = sqLiteDatabase2.rawQuery("SELECT * FROM hits2 WHERE 0", (String[])null);
                final HashSet set = new HashSet();
                try {
                    final String[] columnNames = cursor.getColumnNames();
                    for (int i = 0; i < columnNames.length; ++i) {
                        set.add(columnNames[i]);
                    }
                    cursor.close();
                    if (!set.remove("hit_id") || !set.remove("hit_url") || !set.remove("hit_string") || !set.remove("hit_time")) {
                        throw new SQLiteException("Database column missing");
                    }
                }
                finally {
                    cursor.close();
                }
                int n2 = n;
                if (!set.remove("hit_app_id")) {
                    n2 = 1;
                }
                if (!set.isEmpty()) {
                    throw new SQLiteException("Database has extra columns");
                }
                if (n2 != 0) {
                    final SQLiteDatabase sqLiteDatabase3;
                    sqLiteDatabase3.execSQL("ALTER TABLE hits2 ADD COLUMN hit_app_id");
                }
            }
        }
    }
    
    public final void onUpgrade(final SQLiteDatabase sqLiteDatabase, final int n, final int n2) {
    }
}
