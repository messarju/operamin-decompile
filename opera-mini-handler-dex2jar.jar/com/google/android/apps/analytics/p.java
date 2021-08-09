// 
// Decompiled by Procyon v0.6-prerelease
// 

package com.google.android.apps.analytics;

import android.database.Cursor;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.net.URLDecoder;
import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.util.Log;
import android.content.Context;
import java.util.Random;

final class p implements h
{
    private static final String e;
    private static final String f;
    private static final String g;
    private static final String h;
    private static final String i;
    private static final String j;
    private static final String k;
    private long B;
    private int C;
    private q Code;
    private int I;
    private long J;
    private long Z;
    private volatile int a;
    private boolean b;
    private Random c;
    private J d;
    
    static {
        e = "CREATE TABLE events (" + String.format(" '%s' INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,", "event_id") + String.format(" '%s' INTEGER NOT NULL,", "user_id") + String.format(" '%s' CHAR(256) NOT NULL,", "account_id") + String.format(" '%s' INTEGER NOT NULL,", "random_val") + String.format(" '%s' INTEGER NOT NULL,", "timestamp_first") + String.format(" '%s' INTEGER NOT NULL,", "timestamp_previous") + String.format(" '%s' INTEGER NOT NULL,", "timestamp_current") + String.format(" '%s' INTEGER NOT NULL,", "visits") + String.format(" '%s' CHAR(256) NOT NULL,", "category") + String.format(" '%s' CHAR(256) NOT NULL,", "action") + String.format(" '%s' CHAR(256), ", "label") + String.format(" '%s' INTEGER,", "value") + String.format(" '%s' INTEGER,", "screen_width") + String.format(" '%s' INTEGER);", "screen_height");
        f = "CREATE TABLE IF NOT EXISTS session (" + String.format(" '%s' INTEGER PRIMARY KEY,", "timestamp_first") + String.format(" '%s' INTEGER NOT NULL,", "timestamp_previous") + String.format(" '%s' INTEGER NOT NULL,", "timestamp_current") + String.format(" '%s' INTEGER NOT NULL,", "visits") + String.format(" '%s' INTEGER NOT NULL);", "store_id");
        g = "CREATE TABLE custom_variables (" + String.format(" '%s' INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,", "cv_id") + String.format(" '%s' INTEGER NOT NULL,", "event_id") + String.format(" '%s' INTEGER NOT NULL,", "cv_index") + String.format(" '%s' CHAR(64) NOT NULL,", "cv_name") + String.format(" '%s' CHAR(64) NOT NULL,", "cv_value") + String.format(" '%s' INTEGER NOT NULL);", "cv_scope");
        h = "CREATE TABLE IF NOT EXISTS custom_var_cache (" + String.format(" '%s' INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,", "cv_id") + String.format(" '%s' INTEGER NOT NULL,", "event_id") + String.format(" '%s' INTEGER NOT NULL,", "cv_index") + String.format(" '%s' CHAR(64) NOT NULL,", "cv_name") + String.format(" '%s' CHAR(64) NOT NULL,", "cv_value") + String.format(" '%s' INTEGER NOT NULL);", "cv_scope");
        i = "CREATE TABLE transaction_events (" + String.format(" '%s' INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,", "tran_id") + String.format(" '%s' INTEGER NOT NULL,", "event_id") + String.format(" '%s' TEXT NOT NULL,", "order_id") + String.format(" '%s' TEXT,", "tran_storename") + String.format(" '%s' TEXT NOT NULL,", "tran_totalcost") + String.format(" '%s' TEXT,", "tran_totaltax") + String.format(" '%s' TEXT);", "tran_shippingcost");
        j = "CREATE TABLE item_events (" + String.format(" '%s' INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,", "item_id") + String.format(" '%s' INTEGER NOT NULL,", "event_id") + String.format(" '%s' TEXT NOT NULL,", "order_id") + String.format(" '%s' TEXT NOT NULL,", "item_sku") + String.format(" '%s' TEXT,", "item_name") + String.format(" '%s' TEXT,", "item_category") + String.format(" '%s' TEXT NOT NULL,", "item_price") + String.format(" '%s' TEXT NOT NULL);", "item_count");
        k = "CREATE TABLE IF NOT EXISTS hits (" + String.format(" '%s' INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,", "hit_id") + String.format(" '%s' TEXT NOT NULL,", "hit_string") + String.format(" '%s' INTEGER NOT NULL);", "hit_time");
    }
    
    p(final Context context) {
        this(context, "google_analytics.db");
    }
    
    private p(final Context context, final String s) {
        this.c = new Random();
        this.Code = new q(context, s, this);
        while (true) {
            try {
                this.I(this.Code.getWritableDatabase());
                this.d = this.f();
            }
            catch (SQLiteException ex) {
                Log.e("GoogleAnalyticsTracker", ex.toString());
                continue;
            }
            break;
        }
    }
    
    private static t B(final SQLiteDatabase p0) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: ldc             "referrer"
        //     3: iconst_4       
        //     4: anewarray       Ljava/lang/String;
        //     7: dup            
        //     8: iconst_0       
        //     9: ldc             "referrer"
        //    11: aastore        
        //    12: dup            
        //    13: iconst_1       
        //    14: ldc             "timestamp_referrer"
        //    16: aastore        
        //    17: dup            
        //    18: iconst_2       
        //    19: ldc             "referrer_visit"
        //    21: aastore        
        //    22: dup            
        //    23: iconst_3       
        //    24: ldc             "referrer_index"
        //    26: aastore        
        //    27: aconst_null    
        //    28: aconst_null    
        //    29: aconst_null    
        //    30: aconst_null    
        //    31: aconst_null    
        //    32: invokevirtual   android/database/sqlite/SQLiteDatabase.query:(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
        //    35: astore_0       
        //    36: aload_0        
        //    37: invokeinterface android/database/Cursor.moveToFirst:()Z
        //    42: ifeq            188
        //    45: aload_0        
        //    46: aload_0        
        //    47: ldc             "timestamp_referrer"
        //    49: invokeinterface android/database/Cursor.getColumnIndex:(Ljava/lang/String;)I
        //    54: invokeinterface android/database/Cursor.getLong:(I)J
        //    59: lstore_3       
        //    60: aload_0        
        //    61: aload_0        
        //    62: ldc             "referrer_visit"
        //    64: invokeinterface android/database/Cursor.getColumnIndex:(Ljava/lang/String;)I
        //    69: invokeinterface android/database/Cursor.getInt:(I)I
        //    74: istore_1       
        //    75: aload_0        
        //    76: aload_0        
        //    77: ldc             "referrer_index"
        //    79: invokeinterface android/database/Cursor.getColumnIndex:(Ljava/lang/String;)I
        //    84: invokeinterface android/database/Cursor.getInt:(I)I
        //    89: istore_2       
        //    90: new             Lcom/google/android/apps/analytics/t;
        //    93: dup            
        //    94: aload_0        
        //    95: aload_0        
        //    96: ldc             "referrer"
        //    98: invokeinterface android/database/Cursor.getColumnIndex:(Ljava/lang/String;)I
        //   103: invokeinterface android/database/Cursor.getString:(I)Ljava/lang/String;
        //   108: lload_3        
        //   109: iload_1        
        //   110: iload_2        
        //   111: invokespecial   com/google/android/apps/analytics/t.<init>:(Ljava/lang/String;JII)V
        //   114: astore          5
        //   116: aload_0        
        //   117: ifnull          126
        //   120: aload_0        
        //   121: invokeinterface android/database/Cursor.close:()V
        //   126: aload           5
        //   128: areturn        
        //   129: astore          5
        //   131: aconst_null    
        //   132: astore_0       
        //   133: ldc             "GoogleAnalyticsTracker"
        //   135: aload           5
        //   137: invokevirtual   android/database/sqlite/SQLiteException.toString:()Ljava/lang/String;
        //   140: invokestatic    android/util/Log.e:(Ljava/lang/String;Ljava/lang/String;)I
        //   143: pop            
        //   144: aload_0        
        //   145: ifnull          154
        //   148: aload_0        
        //   149: invokeinterface android/database/Cursor.close:()V
        //   154: aconst_null    
        //   155: areturn        
        //   156: astore          5
        //   158: aconst_null    
        //   159: astore_0       
        //   160: aload_0        
        //   161: ifnull          170
        //   164: aload_0        
        //   165: invokeinterface android/database/Cursor.close:()V
        //   170: aload           5
        //   172: athrow         
        //   173: astore          5
        //   175: goto            160
        //   178: astore          5
        //   180: goto            160
        //   183: astore          5
        //   185: goto            133
        //   188: aconst_null    
        //   189: astore          5
        //   191: goto            116
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                                     
        //  -----  -----  -----  -----  -----------------------------------------
        //  0      36     129    133    Landroid/database/sqlite/SQLiteException;
        //  0      36     156    160    Any
        //  36     116    183    188    Landroid/database/sqlite/SQLiteException;
        //  36     116    173    178    Any
        //  133    144    178    183    Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IndexOutOfBoundsException: Index: 98, Size: 98
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
    
    static J Code(final SQLiteDatabase p0) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     3: dup            
        //     4: invokespecial   com/google/android/apps/analytics/J.<init>:()V
        //     7: astore_3       
        //     8: aload_0        
        //     9: ldc_w           "custom_var_cache"
        //    12: aconst_null    
        //    13: ldc_w           "cv_scope= ?"
        //    16: iconst_1       
        //    17: anewarray       Ljava/lang/String;
        //    20: dup            
        //    21: iconst_0       
        //    22: iconst_1       
        //    23: invokestatic    java/lang/Integer.toString:(I)Ljava/lang/String;
        //    26: aastore        
        //    27: aconst_null    
        //    28: aconst_null    
        //    29: aconst_null    
        //    30: invokevirtual   android/database/sqlite/SQLiteDatabase.query:(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
        //    33: astore_1       
        //    34: aload_1        
        //    35: astore_0       
        //    36: aload_1        
        //    37: invokeinterface android/database/Cursor.moveToNext:()Z
        //    42: ifeq            142
        //    45: aload_1        
        //    46: astore_0       
        //    47: aload_3        
        //    48: new             Lcom/google/android/apps/analytics/Z;
        //    51: dup            
        //    52: aload_1        
        //    53: aload_1        
        //    54: ldc             "cv_index"
        //    56: invokeinterface android/database/Cursor.getColumnIndex:(Ljava/lang/String;)I
        //    61: invokeinterface android/database/Cursor.getInt:(I)I
        //    66: aload_1        
        //    67: aload_1        
        //    68: ldc             "cv_name"
        //    70: invokeinterface android/database/Cursor.getColumnIndex:(Ljava/lang/String;)I
        //    75: invokeinterface android/database/Cursor.getString:(I)Ljava/lang/String;
        //    80: aload_1        
        //    81: aload_1        
        //    82: ldc             "cv_value"
        //    84: invokeinterface android/database/Cursor.getColumnIndex:(Ljava/lang/String;)I
        //    89: invokeinterface android/database/Cursor.getString:(I)Ljava/lang/String;
        //    94: aload_1        
        //    95: aload_1        
        //    96: ldc             "cv_scope"
        //    98: invokeinterface android/database/Cursor.getColumnIndex:(Ljava/lang/String;)I
        //   103: invokeinterface android/database/Cursor.getInt:(I)I
        //   108: invokespecial   com/google/android/apps/analytics/Z.<init>:(ILjava/lang/String;Ljava/lang/String;I)V
        //   111: invokevirtual   com/google/android/apps/analytics/J.Code:(Lcom/google/android/apps/analytics/Z;)V
        //   114: goto            34
        //   117: astore_2       
        //   118: aload_1        
        //   119: astore_0       
        //   120: ldc             "GoogleAnalyticsTracker"
        //   122: aload_2        
        //   123: invokevirtual   android/database/sqlite/SQLiteException.toString:()Ljava/lang/String;
        //   126: invokestatic    android/util/Log.e:(Ljava/lang/String;Ljava/lang/String;)I
        //   129: pop            
        //   130: aload_1        
        //   131: ifnull          140
        //   134: aload_1        
        //   135: invokeinterface android/database/Cursor.close:()V
        //   140: aload_3        
        //   141: areturn        
        //   142: aload_1        
        //   143: ifnull          140
        //   146: aload_1        
        //   147: invokeinterface android/database/Cursor.close:()V
        //   152: aload_3        
        //   153: areturn        
        //   154: astore_1       
        //   155: aconst_null    
        //   156: astore_0       
        //   157: aload_0        
        //   158: ifnull          167
        //   161: aload_0        
        //   162: invokeinterface android/database/Cursor.close:()V
        //   167: aload_1        
        //   168: athrow         
        //   169: astore_1       
        //   170: goto            157
        //   173: astore_2       
        //   174: aconst_null    
        //   175: astore_1       
        //   176: goto            118
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                                     
        //  -----  -----  -----  -----  -----------------------------------------
        //  8      34     173    179    Landroid/database/sqlite/SQLiteException;
        //  8      34     154    157    Any
        //  36     45     117    118    Landroid/database/sqlite/SQLiteException;
        //  36     45     169    173    Any
        //  47     114    117    118    Landroid/database/sqlite/SQLiteException;
        //  47     114    169    173    Any
        //  120    130    169    173    Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0118:
        //     at com.strobel.decompiler.ast.Error.expressionLinkedFromMultipleLocations(Error.java:27)
        //     at com.strobel.decompiler.ast.AstOptimizer.mergeDisparateObjectInitializations(AstOptimizer.java:2604)
        //     at com.strobel.decompiler.ast.AstOptimizer.optimize(AstOptimizer.java:235)
        //     at com.strobel.decompiler.ast.AstOptimizer.optimize(AstOptimizer.java:42)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:209)
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
    
    private static u Code(final long p0, final SQLiteDatabase p1) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: ldc_w           "transaction_events"
        //     4: aconst_null    
        //     5: ldc_w           "event_id= ?"
        //     8: iconst_1       
        //     9: anewarray       Ljava/lang/String;
        //    12: dup            
        //    13: iconst_0       
        //    14: lload_0        
        //    15: invokestatic    java/lang/Long.toString:(J)Ljava/lang/String;
        //    18: aastore        
        //    19: aconst_null    
        //    20: aconst_null    
        //    21: aconst_null    
        //    22: invokevirtual   android/database/sqlite/SQLiteDatabase.query:(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
        //    25: astore_3       
        //    26: aload_3        
        //    27: astore_2       
        //    28: aload_3        
        //    29: invokeinterface android/database/Cursor.moveToFirst:()Z
        //    34: ifeq            148
        //    37: aload_3        
        //    38: astore_2       
        //    39: new             Lcom/google/android/apps/analytics/u;
        //    42: dup            
        //    43: new             Lcom/google/android/apps/analytics/v;
        //    46: dup            
        //    47: aload_3        
        //    48: aload_3        
        //    49: ldc             "order_id"
        //    51: invokeinterface android/database/Cursor.getColumnIndex:(Ljava/lang/String;)I
        //    56: invokeinterface android/database/Cursor.getString:(I)Ljava/lang/String;
        //    61: aload_3        
        //    62: aload_3        
        //    63: ldc             "tran_totalcost"
        //    65: invokeinterface android/database/Cursor.getColumnIndex:(Ljava/lang/String;)I
        //    70: invokeinterface android/database/Cursor.getDouble:(I)D
        //    75: invokespecial   com/google/android/apps/analytics/v.<init>:(Ljava/lang/String;D)V
        //    78: aload_3        
        //    79: aload_3        
        //    80: ldc             "tran_storename"
        //    82: invokeinterface android/database/Cursor.getColumnIndex:(Ljava/lang/String;)I
        //    87: invokeinterface android/database/Cursor.getString:(I)Ljava/lang/String;
        //    92: invokevirtual   com/google/android/apps/analytics/v.Code:(Ljava/lang/String;)Lcom/google/android/apps/analytics/v;
        //    95: aload_3        
        //    96: aload_3        
        //    97: ldc             "tran_totaltax"
        //    99: invokeinterface android/database/Cursor.getColumnIndex:(Ljava/lang/String;)I
        //   104: invokeinterface android/database/Cursor.getDouble:(I)D
        //   109: invokevirtual   com/google/android/apps/analytics/v.Code:(D)Lcom/google/android/apps/analytics/v;
        //   112: aload_3        
        //   113: aload_3        
        //   114: ldc             "tran_shippingcost"
        //   116: invokeinterface android/database/Cursor.getColumnIndex:(Ljava/lang/String;)I
        //   121: invokeinterface android/database/Cursor.getDouble:(I)D
        //   126: invokevirtual   com/google/android/apps/analytics/v.I:(D)Lcom/google/android/apps/analytics/v;
        //   129: iconst_0       
        //   130: invokespecial   com/google/android/apps/analytics/u.<init>:(Lcom/google/android/apps/analytics/v;B)V
        //   133: astore          4
        //   135: aload_3        
        //   136: ifnull          145
        //   139: aload_3        
        //   140: invokeinterface android/database/Cursor.close:()V
        //   145: aload           4
        //   147: areturn        
        //   148: aload_3        
        //   149: ifnull          158
        //   152: aload_3        
        //   153: invokeinterface android/database/Cursor.close:()V
        //   158: aconst_null    
        //   159: areturn        
        //   160: astore          4
        //   162: aconst_null    
        //   163: astore_3       
        //   164: aload_3        
        //   165: astore_2       
        //   166: ldc             "GoogleAnalyticsTracker"
        //   168: aload           4
        //   170: invokevirtual   android/database/sqlite/SQLiteException.toString:()Ljava/lang/String;
        //   173: invokestatic    android/util/Log.e:(Ljava/lang/String;Ljava/lang/String;)I
        //   176: pop            
        //   177: aload_3        
        //   178: ifnull          158
        //   181: aload_3        
        //   182: invokeinterface android/database/Cursor.close:()V
        //   187: goto            158
        //   190: astore_3       
        //   191: aconst_null    
        //   192: astore_2       
        //   193: aload_2        
        //   194: ifnull          203
        //   197: aload_2        
        //   198: invokeinterface android/database/Cursor.close:()V
        //   203: aload_3        
        //   204: athrow         
        //   205: astore_3       
        //   206: goto            193
        //   209: astore          4
        //   211: goto            164
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                                     
        //  -----  -----  -----  -----  -----------------------------------------
        //  0      26     160    164    Landroid/database/sqlite/SQLiteException;
        //  0      26     190    193    Any
        //  28     37     209    214    Landroid/database/sqlite/SQLiteException;
        //  28     37     205    209    Any
        //  39     135    209    214    Landroid/database/sqlite/SQLiteException;
        //  39     135    205    209    Any
        //  166    177    205    209    Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0145:
        //     at com.strobel.decompiler.ast.Error.expressionLinkedFromMultipleLocations(Error.java:27)
        //     at com.strobel.decompiler.ast.AstOptimizer.mergeDisparateObjectInitializations(AstOptimizer.java:2604)
        //     at com.strobel.decompiler.ast.AstOptimizer.optimize(AstOptimizer.java:235)
        //     at com.strobel.decompiler.ast.AstOptimizer.optimize(AstOptimizer.java:42)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:209)
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
    
    private void Code(final a a, final t t, final SQLiteDatabase sqLiteDatabase) {
        final ContentValues contentValues = new ContentValues();
        contentValues.put("hit_string", com.google.android.apps.analytics.g.Code(a, t));
        contentValues.put("hit_time", Long.valueOf(0L));
        sqLiteDatabase.insert("hits", (String)null, contentValues);
        ++this.a;
    }
    
    private static boolean Code(final SQLiteDatabase sqLiteDatabase, final ContentValues contentValues) {
        try {
            sqLiteDatabase.beginTransaction();
            sqLiteDatabase.delete("referrer", (String)null, (String[])null);
            sqLiteDatabase.insert("referrer", (String)null, contentValues);
            sqLiteDatabase.setTransactionSuccessful();
            if (sqLiteDatabase.inTransaction() && !J(sqLiteDatabase)) {
                return false;
            }
        }
        catch (SQLiteException ex) {
            Log.e("GoogleAnalyticsTracker", ex.toString());
            if (sqLiteDatabase.inTransaction() && !J(sqLiteDatabase)) {
                return false;
            }
            return false;
        }
        finally {
            if (sqLiteDatabase.inTransaction() && !J(sqLiteDatabase)) {
                return false;
            }
        }
        return true;
    }
    
    public static a[] Code(final SQLiteDatabase p0, final int p1) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     3: dup            
        //     4: invokespecial   java/util/ArrayList.<init>:()V
        //     7: astore          6
        //     9: aload_0        
        //    10: ldc_w           "events"
        //    13: aconst_null    
        //    14: aconst_null    
        //    15: aconst_null    
        //    16: aconst_null    
        //    17: aconst_null    
        //    18: ldc             "event_id"
        //    20: sipush          1000
        //    23: invokestatic    java/lang/Integer.toString:(I)Ljava/lang/String;
        //    26: invokevirtual   android/database/sqlite/SQLiteDatabase.query:(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
        //    29: astore          4
        //    31: aload           4
        //    33: invokeinterface android/database/Cursor.moveToNext:()Z
        //    38: ifeq            404
        //    41: new             Lcom/google/android/apps/analytics/a;
        //    44: dup            
        //    45: aload           4
        //    47: iconst_0       
        //    48: invokeinterface android/database/Cursor.getLong:(I)J
        //    53: aload           4
        //    55: iconst_2       
        //    56: invokeinterface android/database/Cursor.getString:(I)Ljava/lang/String;
        //    61: aload           4
        //    63: iconst_3       
        //    64: invokeinterface android/database/Cursor.getInt:(I)I
        //    69: aload           4
        //    71: iconst_4       
        //    72: invokeinterface android/database/Cursor.getInt:(I)I
        //    77: aload           4
        //    79: iconst_5       
        //    80: invokeinterface android/database/Cursor.getInt:(I)I
        //    85: aload           4
        //    87: bipush          6
        //    89: invokeinterface android/database/Cursor.getInt:(I)I
        //    94: aload           4
        //    96: bipush          7
        //    98: invokeinterface android/database/Cursor.getInt:(I)I
        //   103: aload           4
        //   105: bipush          8
        //   107: invokeinterface android/database/Cursor.getString:(I)Ljava/lang/String;
        //   112: aload           4
        //   114: bipush          9
        //   116: invokeinterface android/database/Cursor.getString:(I)Ljava/lang/String;
        //   121: aload           4
        //   123: bipush          10
        //   125: invokeinterface android/database/Cursor.getString:(I)Ljava/lang/String;
        //   130: aload           4
        //   132: bipush          11
        //   134: invokeinterface android/database/Cursor.getInt:(I)I
        //   139: aload           4
        //   141: bipush          12
        //   143: invokeinterface android/database/Cursor.getInt:(I)I
        //   148: aload           4
        //   150: bipush          13
        //   152: invokeinterface android/database/Cursor.getInt:(I)I
        //   157: invokespecial   com/google/android/apps/analytics/a.<init>:(JLjava/lang/String;IIIIILjava/lang/String;Ljava/lang/String;Ljava/lang/String;III)V
        //   160: astore          7
        //   162: aload           7
        //   164: aload           4
        //   166: iconst_1       
        //   167: invokeinterface android/database/Cursor.getInt:(I)I
        //   172: invokevirtual   com/google/android/apps/analytics/a.C:(I)V
        //   175: aload           4
        //   177: aload           4
        //   179: ldc             "event_id"
        //   181: invokeinterface android/database/Cursor.getColumnIndex:(Ljava/lang/String;)I
        //   186: invokeinterface android/database/Cursor.getLong:(I)J
        //   191: lstore_2       
        //   192: ldc_w           "__##GOOGLETRANSACTION##__"
        //   195: aload           7
        //   197: getfield        com/google/android/apps/analytics/a.I:Ljava/lang/String;
        //   200: invokevirtual   java/lang/String.equals:(Ljava/lang/Object;)Z
        //   203: ifeq            296
        //   206: lload_2        
        //   207: aload_0        
        //   208: invokestatic    com/google/android/apps/analytics/p.Code:(JLandroid/database/sqlite/SQLiteDatabase;)Lcom/google/android/apps/analytics/u;
        //   211: astore          5
        //   213: aload           5
        //   215: ifnonnull       241
        //   218: ldc             "GoogleAnalyticsTracker"
        //   220: new             Ljava/lang/StringBuilder;
        //   223: dup            
        //   224: ldc_w           "missing expected transaction for event "
        //   227: invokespecial   java/lang/StringBuilder.<init>:(Ljava/lang/String;)V
        //   230: lload_2        
        //   231: invokevirtual   java/lang/StringBuilder.append:(J)Ljava/lang/StringBuilder;
        //   234: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   237: invokestatic    android/util/Log.w:(Ljava/lang/String;Ljava/lang/String;)I
        //   240: pop            
        //   241: aload           7
        //   243: aload           5
        //   245: invokevirtual   com/google/android/apps/analytics/a.Code:(Lcom/google/android/apps/analytics/u;)V
        //   248: aload           6
        //   250: aload           7
        //   252: invokeinterface java/util/List.add:(Ljava/lang/Object;)Z
        //   257: pop            
        //   258: goto            31
        //   261: astore          5
        //   263: aload           4
        //   265: astore_0       
        //   266: aload           5
        //   268: astore          4
        //   270: ldc             "GoogleAnalyticsTracker"
        //   272: aload           4
        //   274: invokevirtual   android/database/sqlite/SQLiteException.toString:()Ljava/lang/String;
        //   277: invokestatic    android/util/Log.e:(Ljava/lang/String;Ljava/lang/String;)I
        //   280: pop            
        //   281: aload_0        
        //   282: ifnull          291
        //   285: aload_0        
        //   286: invokeinterface android/database/Cursor.close:()V
        //   291: iconst_0       
        //   292: anewarray       Lcom/google/android/apps/analytics/a;
        //   295: areturn        
        //   296: ldc_w           "__##GOOGLEITEM##__"
        //   299: aload           7
        //   301: getfield        com/google/android/apps/analytics/a.I:Ljava/lang/String;
        //   304: invokevirtual   java/lang/String.equals:(Ljava/lang/Object;)Z
        //   307: ifeq            370
        //   310: lload_2        
        //   311: aload_0        
        //   312: invokestatic    com/google/android/apps/analytics/p.I:(JLandroid/database/sqlite/SQLiteDatabase;)Lcom/google/android/apps/analytics/k;
        //   315: astore          5
        //   317: aload           5
        //   319: ifnonnull       345
        //   322: ldc             "GoogleAnalyticsTracker"
        //   324: new             Ljava/lang/StringBuilder;
        //   327: dup            
        //   328: ldc_w           "missing expected item for event "
        //   331: invokespecial   java/lang/StringBuilder.<init>:(Ljava/lang/String;)V
        //   334: lload_2        
        //   335: invokevirtual   java/lang/StringBuilder.append:(J)Ljava/lang/StringBuilder;
        //   338: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   341: invokestatic    android/util/Log.w:(Ljava/lang/String;Ljava/lang/String;)I
        //   344: pop            
        //   345: aload           7
        //   347: aload           5
        //   349: invokevirtual   com/google/android/apps/analytics/a.Code:(Lcom/google/android/apps/analytics/k;)V
        //   352: goto            248
        //   355: astore_0       
        //   356: aload           4
        //   358: ifnull          368
        //   361: aload           4
        //   363: invokeinterface android/database/Cursor.close:()V
        //   368: aload_0        
        //   369: athrow         
        //   370: iload_1        
        //   371: iconst_1       
        //   372: if_icmple       392
        //   375: lload_2        
        //   376: aload_0        
        //   377: invokestatic    com/google/android/apps/analytics/p.Z:(JLandroid/database/sqlite/SQLiteDatabase;)Lcom/google/android/apps/analytics/J;
        //   380: astore          5
        //   382: aload           7
        //   384: aload           5
        //   386: putfield        com/google/android/apps/analytics/a.b:Lcom/google/android/apps/analytics/J;
        //   389: goto            248
        //   392: new             Lcom/google/android/apps/analytics/J;
        //   395: dup            
        //   396: invokespecial   com/google/android/apps/analytics/J.<init>:()V
        //   399: astore          5
        //   401: goto            382
        //   404: aload           4
        //   406: ifnull          416
        //   409: aload           4
        //   411: invokeinterface android/database/Cursor.close:()V
        //   416: aload           6
        //   418: aload           6
        //   420: invokeinterface java/util/List.size:()I
        //   425: anewarray       Lcom/google/android/apps/analytics/a;
        //   428: invokeinterface java/util/List.toArray:([Ljava/lang/Object;)[Ljava/lang/Object;
        //   433: checkcast       [Lcom/google/android/apps/analytics/a;
        //   436: areturn        
        //   437: astore_0       
        //   438: aconst_null    
        //   439: astore          4
        //   441: goto            356
        //   444: astore          5
        //   446: aload_0        
        //   447: astore          4
        //   449: aload           5
        //   451: astore_0       
        //   452: goto            356
        //   455: astore          4
        //   457: aconst_null    
        //   458: astore_0       
        //   459: goto            270
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                                     
        //  -----  -----  -----  -----  -----------------------------------------
        //  9      31     455    462    Landroid/database/sqlite/SQLiteException;
        //  9      31     437    444    Any
        //  31     213    261    270    Landroid/database/sqlite/SQLiteException;
        //  31     213    355    356    Any
        //  218    241    261    270    Landroid/database/sqlite/SQLiteException;
        //  218    241    355    356    Any
        //  241    248    261    270    Landroid/database/sqlite/SQLiteException;
        //  241    248    355    356    Any
        //  248    258    261    270    Landroid/database/sqlite/SQLiteException;
        //  248    258    355    356    Any
        //  270    281    444    455    Any
        //  296    317    261    270    Landroid/database/sqlite/SQLiteException;
        //  296    317    355    356    Any
        //  322    345    261    270    Landroid/database/sqlite/SQLiteException;
        //  322    345    355    356    Any
        //  345    352    261    270    Landroid/database/sqlite/SQLiteException;
        //  345    352    355    356    Any
        //  375    382    261    270    Landroid/database/sqlite/SQLiteException;
        //  375    382    355    356    Any
        //  382    389    261    270    Landroid/database/sqlite/SQLiteException;
        //  382    389    355    356    Any
        //  392    401    261    270    Landroid/database/sqlite/SQLiteException;
        //  392    401    355    356    Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0270:
        //     at com.strobel.decompiler.ast.Error.expressionLinkedFromMultipleLocations(Error.java:27)
        //     at com.strobel.decompiler.ast.AstOptimizer.mergeDisparateObjectInitializations(AstOptimizer.java:2604)
        //     at com.strobel.decompiler.ast.AstOptimizer.optimize(AstOptimizer.java:235)
        //     at com.strobel.decompiler.ast.AstOptimizer.optimize(AstOptimizer.java:42)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:209)
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
    
    private static k I(final long p0, final SQLiteDatabase p1) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: ldc_w           "item_events"
        //     4: aconst_null    
        //     5: ldc_w           "event_id= ?"
        //     8: iconst_1       
        //     9: anewarray       Ljava/lang/String;
        //    12: dup            
        //    13: iconst_0       
        //    14: lload_0        
        //    15: invokestatic    java/lang/Long.toString:(J)Ljava/lang/String;
        //    18: aastore        
        //    19: aconst_null    
        //    20: aconst_null    
        //    21: aconst_null    
        //    22: invokevirtual   android/database/sqlite/SQLiteDatabase.query:(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
        //    25: astore_2       
        //    26: aload_2        
        //    27: invokeinterface android/database/Cursor.moveToFirst:()Z
        //    32: ifeq            153
        //    35: new             Lcom/google/android/apps/analytics/k;
        //    38: dup            
        //    39: new             Lcom/google/android/apps/analytics/l;
        //    42: dup            
        //    43: aload_2        
        //    44: aload_2        
        //    45: ldc             "order_id"
        //    47: invokeinterface android/database/Cursor.getColumnIndex:(Ljava/lang/String;)I
        //    52: invokeinterface android/database/Cursor.getString:(I)Ljava/lang/String;
        //    57: aload_2        
        //    58: aload_2        
        //    59: ldc             "item_sku"
        //    61: invokeinterface android/database/Cursor.getColumnIndex:(Ljava/lang/String;)I
        //    66: invokeinterface android/database/Cursor.getString:(I)Ljava/lang/String;
        //    71: aload_2        
        //    72: aload_2        
        //    73: ldc             "item_price"
        //    75: invokeinterface android/database/Cursor.getColumnIndex:(Ljava/lang/String;)I
        //    80: invokeinterface android/database/Cursor.getDouble:(I)D
        //    85: aload_2        
        //    86: aload_2        
        //    87: ldc             "item_count"
        //    89: invokeinterface android/database/Cursor.getColumnIndex:(Ljava/lang/String;)I
        //    94: invokeinterface android/database/Cursor.getLong:(I)J
        //    99: invokespecial   com/google/android/apps/analytics/l.<init>:(Ljava/lang/String;Ljava/lang/String;DJ)V
        //   102: aload_2        
        //   103: aload_2        
        //   104: ldc             "item_name"
        //   106: invokeinterface android/database/Cursor.getColumnIndex:(Ljava/lang/String;)I
        //   111: invokeinterface android/database/Cursor.getString:(I)Ljava/lang/String;
        //   116: invokevirtual   com/google/android/apps/analytics/l.Code:(Ljava/lang/String;)Lcom/google/android/apps/analytics/l;
        //   119: aload_2        
        //   120: aload_2        
        //   121: ldc             "item_category"
        //   123: invokeinterface android/database/Cursor.getColumnIndex:(Ljava/lang/String;)I
        //   128: invokeinterface android/database/Cursor.getString:(I)Ljava/lang/String;
        //   133: invokevirtual   com/google/android/apps/analytics/l.I:(Ljava/lang/String;)Lcom/google/android/apps/analytics/l;
        //   136: iconst_0       
        //   137: invokespecial   com/google/android/apps/analytics/k.<init>:(Lcom/google/android/apps/analytics/l;B)V
        //   140: astore_3       
        //   141: aload_2        
        //   142: ifnull          151
        //   145: aload_2        
        //   146: invokeinterface android/database/Cursor.close:()V
        //   151: aload_3        
        //   152: areturn        
        //   153: aload_2        
        //   154: ifnull          163
        //   157: aload_2        
        //   158: invokeinterface android/database/Cursor.close:()V
        //   163: aconst_null    
        //   164: areturn        
        //   165: astore_3       
        //   166: aconst_null    
        //   167: astore_2       
        //   168: ldc             "GoogleAnalyticsTracker"
        //   170: aload_3        
        //   171: invokevirtual   android/database/sqlite/SQLiteException.toString:()Ljava/lang/String;
        //   174: invokestatic    android/util/Log.e:(Ljava/lang/String;Ljava/lang/String;)I
        //   177: pop            
        //   178: aload_2        
        //   179: ifnull          163
        //   182: aload_2        
        //   183: invokeinterface android/database/Cursor.close:()V
        //   188: goto            163
        //   191: astore_3       
        //   192: aconst_null    
        //   193: astore_2       
        //   194: aload_2        
        //   195: ifnull          204
        //   198: aload_2        
        //   199: invokeinterface android/database/Cursor.close:()V
        //   204: aload_3        
        //   205: athrow         
        //   206: astore_3       
        //   207: goto            194
        //   210: astore_3       
        //   211: goto            194
        //   214: astore_3       
        //   215: goto            168
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                                     
        //  -----  -----  -----  -----  -----------------------------------------
        //  0      26     165    168    Landroid/database/sqlite/SQLiteException;
        //  0      26     191    194    Any
        //  26     141    214    218    Landroid/database/sqlite/SQLiteException;
        //  26     141    206    210    Any
        //  168    178    210    214    Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IndexOutOfBoundsException: Index: 99, Size: 99
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
    
    private static String I(final String s) {
        if (s == null) {
            return null;
        }
        String decode = s;
        HashMap hashMap = null;
        Label_0038: {
            if (s.contains("=")) {
                break Label_0038;
            }
            if (!s.contains("%3D")) {
                return null;
            }
            while (true) {
                while (true) {
                    String[] split2 = null;
                    Label_0113: {
                        try {
                            decode = URLDecoder.decode(s, "UTF-8");
                            hashMap = new HashMap();
                            final String[] split = decode.split("&");
                            for (int length = split.length, i = 0; i < length; ++i) {
                                split2 = split[i].split("=");
                                if (split2.length <= 1) {
                                    break Label_0113;
                                }
                                hashMap.put(split2[0], split2[1]);
                            }
                            break;
                        }
                        catch (UnsupportedEncodingException ex) {
                            return null;
                        }
                        return null;
                    }
                    if (split2.length == 1) {
                        hashMap.put(split2[0], null);
                        continue;
                    }
                    continue;
                }
            }
        }
        boolean b;
        if (hashMap.get("utm_campaign") != null) {
            b = true;
        }
        else {
            b = false;
        }
        boolean b2;
        if (hashMap.get("utm_medium") != null) {
            b2 = true;
        }
        else {
            b2 = false;
        }
        boolean b3;
        if (hashMap.get("utm_source") != null) {
            b3 = true;
        }
        else {
            b3 = false;
        }
        boolean b4;
        if (hashMap.get("gclid") != null) {
            b4 = true;
        }
        else {
            b4 = false;
        }
        if (!b4 && (!b || !b2 || !b3)) {
            Log.w("GoogleAnalyticsTracker", "Badly formatted referrer missing campaign, medium and source or click ID");
            return null;
        }
        final String[][] array = { { "utmcid", (String)hashMap.get("utm_id") }, { "utmcsr", (String)hashMap.get("utm_source") }, { "utmgclid", (String)hashMap.get("gclid") }, { "utmccn", (String)hashMap.get("utm_campaign") }, { "utmcmd", (String)hashMap.get("utm_medium") }, { "utmctr", (String)hashMap.get("utm_term") }, { "utmcct", (String)hashMap.get("utm_content") } };
        final StringBuilder sb = new StringBuilder();
        int j = 0;
        int n = 1;
        while (j < array.length) {
            int n2 = n;
            if (array[j][1] != null) {
                final String replace = array[j][1].replace("+", "%20").replace(" ", "%20");
                if (n != 0) {
                    n = 0;
                }
                else {
                    sb.append("|");
                }
                sb.append(array[j][0]).append("=").append(replace);
                n2 = n;
            }
            ++j;
            n = n2;
        }
        return sb.toString();
    }
    
    private static boolean J(final SQLiteDatabase sqLiteDatabase) {
        try {
            sqLiteDatabase.endTransaction();
            return true;
        }
        catch (SQLiteException ex) {
            Log.e("GoogleAnalyticsTracker", "exception ending transaction:" + ex.toString());
            return false;
        }
    }
    
    private static J Z(final long p0, final SQLiteDatabase p1) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     3: dup            
        //     4: invokespecial   com/google/android/apps/analytics/J.<init>:()V
        //     7: astore          5
        //     9: aload_2        
        //    10: ldc_w           "custom_variables"
        //    13: aconst_null    
        //    14: ldc_w           "event_id= ?"
        //    17: iconst_1       
        //    18: anewarray       Ljava/lang/String;
        //    21: dup            
        //    22: iconst_0       
        //    23: lload_0        
        //    24: invokestatic    java/lang/Long.toString:(J)Ljava/lang/String;
        //    27: aastore        
        //    28: aconst_null    
        //    29: aconst_null    
        //    30: aconst_null    
        //    31: invokevirtual   android/database/sqlite/SQLiteDatabase.query:(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
        //    34: astore_3       
        //    35: aload_3        
        //    36: astore_2       
        //    37: aload_3        
        //    38: invokeinterface android/database/Cursor.moveToNext:()Z
        //    43: ifeq            147
        //    46: aload_3        
        //    47: astore_2       
        //    48: aload           5
        //    50: new             Lcom/google/android/apps/analytics/Z;
        //    53: dup            
        //    54: aload_3        
        //    55: aload_3        
        //    56: ldc             "cv_index"
        //    58: invokeinterface android/database/Cursor.getColumnIndex:(Ljava/lang/String;)I
        //    63: invokeinterface android/database/Cursor.getInt:(I)I
        //    68: aload_3        
        //    69: aload_3        
        //    70: ldc             "cv_name"
        //    72: invokeinterface android/database/Cursor.getColumnIndex:(Ljava/lang/String;)I
        //    77: invokeinterface android/database/Cursor.getString:(I)Ljava/lang/String;
        //    82: aload_3        
        //    83: aload_3        
        //    84: ldc             "cv_value"
        //    86: invokeinterface android/database/Cursor.getColumnIndex:(Ljava/lang/String;)I
        //    91: invokeinterface android/database/Cursor.getString:(I)Ljava/lang/String;
        //    96: aload_3        
        //    97: aload_3        
        //    98: ldc             "cv_scope"
        //   100: invokeinterface android/database/Cursor.getColumnIndex:(Ljava/lang/String;)I
        //   105: invokeinterface android/database/Cursor.getInt:(I)I
        //   110: invokespecial   com/google/android/apps/analytics/Z.<init>:(ILjava/lang/String;Ljava/lang/String;I)V
        //   113: invokevirtual   com/google/android/apps/analytics/J.Code:(Lcom/google/android/apps/analytics/Z;)V
        //   116: goto            35
        //   119: astore          4
        //   121: aload_3        
        //   122: astore_2       
        //   123: ldc             "GoogleAnalyticsTracker"
        //   125: aload           4
        //   127: invokevirtual   android/database/sqlite/SQLiteException.toString:()Ljava/lang/String;
        //   130: invokestatic    android/util/Log.e:(Ljava/lang/String;Ljava/lang/String;)I
        //   133: pop            
        //   134: aload_3        
        //   135: ifnull          144
        //   138: aload_3        
        //   139: invokeinterface android/database/Cursor.close:()V
        //   144: aload           5
        //   146: areturn        
        //   147: aload_3        
        //   148: ifnull          144
        //   151: aload_3        
        //   152: invokeinterface android/database/Cursor.close:()V
        //   157: aload           5
        //   159: areturn        
        //   160: astore_3       
        //   161: aconst_null    
        //   162: astore_2       
        //   163: aload_2        
        //   164: ifnull          173
        //   167: aload_2        
        //   168: invokeinterface android/database/Cursor.close:()V
        //   173: aload_3        
        //   174: athrow         
        //   175: astore_3       
        //   176: goto            163
        //   179: astore          4
        //   181: aconst_null    
        //   182: astore_3       
        //   183: goto            121
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                                     
        //  -----  -----  -----  -----  -----------------------------------------
        //  9      35     179    186    Landroid/database/sqlite/SQLiteException;
        //  9      35     160    163    Any
        //  37     46     119    121    Landroid/database/sqlite/SQLiteException;
        //  37     46     175    179    Any
        //  48     116    119    121    Landroid/database/sqlite/SQLiteException;
        //  48     116    175    179    Any
        //  123    134    175    179    Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0121:
        //     at com.strobel.decompiler.ast.Error.expressionLinkedFromMultipleLocations(Error.java:27)
        //     at com.strobel.decompiler.ast.AstOptimizer.mergeDisparateObjectInitializations(AstOptimizer.java:2604)
        //     at com.strobel.decompiler.ast.AstOptimizer.optimize(AstOptimizer.java:235)
        //     at com.strobel.decompiler.ast.AstOptimizer.optimize(AstOptimizer.java:42)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:209)
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
    
    private f[] e() {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     3: dup            
        //     4: invokespecial   java/util/ArrayList.<init>:()V
        //     7: astore_3       
        //     8: aload_0        
        //     9: getfield        com/google/android/apps/analytics/p.Code:Lcom/google/android/apps/analytics/q;
        //    12: invokevirtual   com/google/android/apps/analytics/q.getReadableDatabase:()Landroid/database/sqlite/SQLiteDatabase;
        //    15: ldc_w           "hits"
        //    18: aconst_null    
        //    19: aconst_null    
        //    20: aconst_null    
        //    21: aconst_null    
        //    22: aconst_null    
        //    23: ldc             "hit_id"
        //    25: sipush          1000
        //    28: invokestatic    java/lang/Integer.toString:(I)Ljava/lang/String;
        //    31: invokevirtual   android/database/sqlite/SQLiteDatabase.query:(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
        //    34: astore_2       
        //    35: aload_2        
        //    36: astore_1       
        //    37: aload_2        
        //    38: invokeinterface android/database/Cursor.moveToNext:()Z
        //    43: ifeq            107
        //    46: aload_2        
        //    47: astore_1       
        //    48: aload_3        
        //    49: new             Lcom/google/android/apps/analytics/f;
        //    52: dup            
        //    53: aload_2        
        //    54: iconst_1       
        //    55: invokeinterface android/database/Cursor.getString:(I)Ljava/lang/String;
        //    60: aload_2        
        //    61: iconst_0       
        //    62: invokeinterface android/database/Cursor.getLong:(I)J
        //    67: invokespecial   com/google/android/apps/analytics/f.<init>:(Ljava/lang/String;J)V
        //    70: invokeinterface java/util/List.add:(Ljava/lang/Object;)Z
        //    75: pop            
        //    76: goto            35
        //    79: astore_3       
        //    80: aload_2        
        //    81: astore_1       
        //    82: ldc             "GoogleAnalyticsTracker"
        //    84: aload_3        
        //    85: invokevirtual   android/database/sqlite/SQLiteException.toString:()Ljava/lang/String;
        //    88: invokestatic    android/util/Log.e:(Ljava/lang/String;Ljava/lang/String;)I
        //    91: pop            
        //    92: aload_2        
        //    93: ifnull          102
        //    96: aload_2        
        //    97: invokeinterface android/database/Cursor.close:()V
        //   102: iconst_0       
        //   103: anewarray       Lcom/google/android/apps/analytics/f;
        //   106: areturn        
        //   107: aload_2        
        //   108: ifnull          117
        //   111: aload_2        
        //   112: invokeinterface android/database/Cursor.close:()V
        //   117: aload_3        
        //   118: aload_3        
        //   119: invokeinterface java/util/List.size:()I
        //   124: anewarray       Lcom/google/android/apps/analytics/f;
        //   127: invokeinterface java/util/List.toArray:([Ljava/lang/Object;)[Ljava/lang/Object;
        //   132: checkcast       [Lcom/google/android/apps/analytics/f;
        //   135: areturn        
        //   136: astore_2       
        //   137: aconst_null    
        //   138: astore_1       
        //   139: aload_1        
        //   140: ifnull          149
        //   143: aload_1        
        //   144: invokeinterface android/database/Cursor.close:()V
        //   149: aload_2        
        //   150: athrow         
        //   151: astore_2       
        //   152: goto            139
        //   155: astore_3       
        //   156: aconst_null    
        //   157: astore_2       
        //   158: goto            80
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                                     
        //  -----  -----  -----  -----  -----------------------------------------
        //  8      35     155    161    Landroid/database/sqlite/SQLiteException;
        //  8      35     136    139    Any
        //  37     46     79     80     Landroid/database/sqlite/SQLiteException;
        //  37     46     151    155    Any
        //  48     76     79     80     Landroid/database/sqlite/SQLiteException;
        //  48     76     151    155    Any
        //  82     92     151    155    Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0080:
        //     at com.strobel.decompiler.ast.Error.expressionLinkedFromMultipleLocations(Error.java:27)
        //     at com.strobel.decompiler.ast.AstOptimizer.mergeDisparateObjectInitializations(AstOptimizer.java:2604)
        //     at com.strobel.decompiler.ast.AstOptimizer.optimize(AstOptimizer.java:235)
        //     at com.strobel.decompiler.ast.AstOptimizer.optimize(AstOptimizer.java:42)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:209)
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
    
    private J f() {
        try {
            return Code(this.Code.getReadableDatabase());
        }
        catch (SQLiteException ex) {
            Log.e("GoogleAnalyticsTracker", ex.toString());
            return new J();
        }
    }
    
    private int g() {
        Cursor cursor = null;
        Cursor rawQuery = null;
        int n = 0;
        int n2 = 0;
        try {
            final Cursor cursor2 = cursor = (rawQuery = this.Code.getReadableDatabase().rawQuery("SELECT COUNT(*) from hits", (String[])null));
            if (cursor2.moveToFirst()) {
                rawQuery = cursor2;
                cursor = cursor2;
                n2 = (int)cursor2.getLong(0);
            }
            n = n2;
            if (cursor2 != null) {
                cursor2.close();
                n = n2;
            }
            return n;
        }
        catch (SQLiteException ex) {
            cursor = rawQuery;
            Log.e("GoogleAnalyticsTracker", ex.toString());
            return 0;
        }
        finally {
            if (cursor != null) {
                cursor.close();
            }
        }
    }
    
    @Override
    public final void Code(final long n) {
        synchronized (this) {
            try {
                this.a -= this.Code.getWritableDatabase().delete("hits", "hit_id = ?", new String[] { Long.toString(n) });
            }
            catch (SQLiteException ex) {
                Log.e("GoogleAnalyticsTracker", ex.toString());
            }
        }
    }
    
    @Override
    public final boolean Code(String i) {
        i = I(i);
        if (i == null) {
            return false;
        }
        while (true) {
            while (true) {
                Label_0139: {
                    try {
                        final SQLiteDatabase writableDatabase = this.Code.getWritableDatabase();
                        final t b = B(writableDatabase);
                        final ContentValues contentValues = new ContentValues();
                        contentValues.put("referrer", i);
                        contentValues.put("timestamp_referrer", Long.valueOf(0L));
                        contentValues.put("referrer_visit", Integer.valueOf(0));
                        if (b == null) {
                            break Label_0139;
                        }
                        long n = b.J();
                        if (b.I() > 0L) {
                            ++n;
                        }
                        contentValues.put("referrer_index", Long.valueOf(n));
                        if (Code(writableDatabase, contentValues)) {
                            this.Z();
                            return true;
                        }
                    }
                    catch (SQLiteException ex) {
                        Log.e("GoogleAnalyticsTracker", ex.toString());
                        return false;
                    }
                    break;
                }
                long n = 1L;
                continue;
            }
        }
        return false;
    }
    
    @Override
    public final f[] Code() {
        return this.e();
    }
    
    @Override
    public final int I() {
        return this.a;
    }
    
    public final void I(final SQLiteDatabase p0) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: ldc_w           "session"
        //     4: aconst_null    
        //     5: aconst_null    
        //     6: aconst_null    
        //     7: aconst_null    
        //     8: aconst_null    
        //     9: aconst_null    
        //    10: invokevirtual   android/database/sqlite/SQLiteDatabase.query:(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
        //    13: astore_2       
        //    14: aload_2        
        //    15: astore_3       
        //    16: aload_2        
        //    17: invokeinterface android/database/Cursor.moveToFirst:()Z
        //    22: ifeq            139
        //    25: aload_2        
        //    26: astore_3       
        //    27: aload_0        
        //    28: aload_2        
        //    29: iconst_0       
        //    30: invokeinterface android/database/Cursor.getLong:(I)J
        //    35: putfield        com/google/android/apps/analytics/p.Z:J
        //    38: aload_2        
        //    39: astore_3       
        //    40: aload_0        
        //    41: aload_2        
        //    42: iconst_1       
        //    43: invokeinterface android/database/Cursor.getLong:(I)J
        //    48: putfield        com/google/android/apps/analytics/p.J:J
        //    51: aload_2        
        //    52: astore_3       
        //    53: aload_0        
        //    54: aload_2        
        //    55: iconst_2       
        //    56: invokeinterface android/database/Cursor.getLong:(I)J
        //    61: putfield        com/google/android/apps/analytics/p.B:J
        //    64: aload_2        
        //    65: astore_3       
        //    66: aload_0        
        //    67: aload_2        
        //    68: iconst_3       
        //    69: invokeinterface android/database/Cursor.getInt:(I)I
        //    74: putfield        com/google/android/apps/analytics/p.C:I
        //    77: aload_2        
        //    78: astore_3       
        //    79: aload_0        
        //    80: aload_2        
        //    81: iconst_4       
        //    82: invokeinterface android/database/Cursor.getInt:(I)I
        //    87: putfield        com/google/android/apps/analytics/p.I:I
        //    90: aload_2        
        //    91: astore_3       
        //    92: aload_1        
        //    93: invokestatic    com/google/android/apps/analytics/p.B:(Landroid/database/sqlite/SQLiteDatabase;)Lcom/google/android/apps/analytics/t;
        //    96: astore          4
        //    98: aload_2        
        //    99: astore_1       
        //   100: aload_2        
        //   101: astore_3       
        //   102: aload_0        
        //   103: getfield        com/google/android/apps/analytics/p.Z:J
        //   106: lconst_0       
        //   107: lcmp           
        //   108: ifeq            128
        //   111: aload_2        
        //   112: astore_1       
        //   113: aload           4
        //   115: ifnull          128
        //   118: aload_2        
        //   119: astore_3       
        //   120: aload           4
        //   122: invokevirtual   com/google/android/apps/analytics/t.I:()J
        //   125: pop2           
        //   126: aload_2        
        //   127: astore_1       
        //   128: aload_1        
        //   129: ifnull          138
        //   132: aload_1        
        //   133: invokeinterface android/database/Cursor.close:()V
        //   138: return         
        //   139: aload_2        
        //   140: astore_3       
        //   141: aload_0        
        //   142: iconst_1       
        //   143: putfield        com/google/android/apps/analytics/p.b:Z
        //   146: aload_2        
        //   147: astore_3       
        //   148: aload_0        
        //   149: new             Ljava/security/SecureRandom;
        //   152: dup            
        //   153: invokespecial   java/security/SecureRandom.<init>:()V
        //   156: invokevirtual   java/security/SecureRandom.nextInt:()I
        //   159: ldc_w           2147483647
        //   162: iand           
        //   163: putfield        com/google/android/apps/analytics/p.I:I
        //   166: aload_2        
        //   167: astore_3       
        //   168: aload_2        
        //   169: invokeinterface android/database/Cursor.close:()V
        //   174: new             Landroid/content/ContentValues;
        //   177: dup            
        //   178: invokespecial   android/content/ContentValues.<init>:()V
        //   181: astore_2       
        //   182: aload_2        
        //   183: ldc             "timestamp_first"
        //   185: lconst_0       
        //   186: invokestatic    java/lang/Long.valueOf:(J)Ljava/lang/Long;
        //   189: invokevirtual   android/content/ContentValues.put:(Ljava/lang/String;Ljava/lang/Long;)V
        //   192: aload_2        
        //   193: ldc             "timestamp_previous"
        //   195: lconst_0       
        //   196: invokestatic    java/lang/Long.valueOf:(J)Ljava/lang/Long;
        //   199: invokevirtual   android/content/ContentValues.put:(Ljava/lang/String;Ljava/lang/Long;)V
        //   202: aload_2        
        //   203: ldc             "timestamp_current"
        //   205: lconst_0       
        //   206: invokestatic    java/lang/Long.valueOf:(J)Ljava/lang/Long;
        //   209: invokevirtual   android/content/ContentValues.put:(Ljava/lang/String;Ljava/lang/Long;)V
        //   212: aload_2        
        //   213: ldc             "visits"
        //   215: iconst_0       
        //   216: invokestatic    java/lang/Integer.valueOf:(I)Ljava/lang/Integer;
        //   219: invokevirtual   android/content/ContentValues.put:(Ljava/lang/String;Ljava/lang/Integer;)V
        //   222: aload_2        
        //   223: ldc             "store_id"
        //   225: aload_0        
        //   226: getfield        com/google/android/apps/analytics/p.I:I
        //   229: invokestatic    java/lang/Integer.valueOf:(I)Ljava/lang/Integer;
        //   232: invokevirtual   android/content/ContentValues.put:(Ljava/lang/String;Ljava/lang/Integer;)V
        //   235: aload_1        
        //   236: ldc_w           "session"
        //   239: aconst_null    
        //   240: aload_2        
        //   241: invokevirtual   android/database/sqlite/SQLiteDatabase.insert:(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J
        //   244: pop2           
        //   245: aconst_null    
        //   246: astore_1       
        //   247: goto            128
        //   250: astore_1       
        //   251: aconst_null    
        //   252: astore_2       
        //   253: aload_2        
        //   254: astore_3       
        //   255: ldc             "GoogleAnalyticsTracker"
        //   257: aload_1        
        //   258: invokevirtual   android/database/sqlite/SQLiteException.toString:()Ljava/lang/String;
        //   261: invokestatic    android/util/Log.e:(Ljava/lang/String;Ljava/lang/String;)I
        //   264: pop            
        //   265: aload_2        
        //   266: ifnull          138
        //   269: aload_2        
        //   270: invokeinterface android/database/Cursor.close:()V
        //   275: return         
        //   276: astore_1       
        //   277: aconst_null    
        //   278: astore_3       
        //   279: aload_3        
        //   280: ifnull          289
        //   283: aload_3        
        //   284: invokeinterface android/database/Cursor.close:()V
        //   289: aload_1        
        //   290: athrow         
        //   291: astore_1       
        //   292: goto            279
        //   295: astore_1       
        //   296: goto            253
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                                     
        //  -----  -----  -----  -----  -----------------------------------------
        //  0      14     250    253    Landroid/database/sqlite/SQLiteException;
        //  0      14     276    279    Any
        //  16     25     295    299    Landroid/database/sqlite/SQLiteException;
        //  16     25     291    295    Any
        //  27     38     295    299    Landroid/database/sqlite/SQLiteException;
        //  27     38     291    295    Any
        //  40     51     295    299    Landroid/database/sqlite/SQLiteException;
        //  40     51     291    295    Any
        //  53     64     295    299    Landroid/database/sqlite/SQLiteException;
        //  53     64     291    295    Any
        //  66     77     295    299    Landroid/database/sqlite/SQLiteException;
        //  66     77     291    295    Any
        //  79     90     295    299    Landroid/database/sqlite/SQLiteException;
        //  79     90     291    295    Any
        //  92     98     295    299    Landroid/database/sqlite/SQLiteException;
        //  92     98     291    295    Any
        //  102    111    295    299    Landroid/database/sqlite/SQLiteException;
        //  102    111    291    295    Any
        //  120    126    295    299    Landroid/database/sqlite/SQLiteException;
        //  120    126    291    295    Any
        //  141    146    295    299    Landroid/database/sqlite/SQLiteException;
        //  141    146    291    295    Any
        //  148    166    295    299    Landroid/database/sqlite/SQLiteException;
        //  148    166    291    295    Any
        //  168    174    295    299    Landroid/database/sqlite/SQLiteException;
        //  168    174    291    295    Any
        //  174    245    250    253    Landroid/database/sqlite/SQLiteException;
        //  174    245    276    279    Any
        //  255    265    291    295    Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0128:
        //     at com.strobel.decompiler.ast.Error.expressionLinkedFromMultipleLocations(Error.java:27)
        //     at com.strobel.decompiler.ast.AstOptimizer.mergeDisparateObjectInitializations(AstOptimizer.java:2604)
        //     at com.strobel.decompiler.ast.AstOptimizer.optimize(AstOptimizer.java:235)
        //     at com.strobel.decompiler.ast.AstOptimizer.optimize(AstOptimizer.java:42)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:209)
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
    
    @Override
    public final void Z() {
        synchronized (this) {
            this.b = true;
            this.a = this.g();
        }
    }
}
