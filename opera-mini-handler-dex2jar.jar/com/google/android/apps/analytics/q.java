// 
// Decompiled by Procyon v0.6-prerelease
// 

package com.google.android.apps.analytics;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase$CursorFactory;
import android.content.Context;
import android.database.sqlite.SQLiteOpenHelper;

final class q extends SQLiteOpenHelper
{
    private final p Code;
    
    q(final Context context, final String s, final p code) {
        super(context, s, (SQLiteDatabase$CursorFactory)null, 5);
        this.Code = code;
    }
    
    private static void Code(final SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS custom_variables;");
        sqLiteDatabase.execSQL(p.g);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS custom_var_cache;");
        sqLiteDatabase.execSQL(p.h);
        for (int i = 1; i <= 5; ++i) {
            final ContentValues contentValues = new ContentValues();
            contentValues.put("event_id", Integer.valueOf(0));
            contentValues.put("cv_index", Integer.valueOf(i));
            contentValues.put("cv_name", "");
            contentValues.put("cv_scope", Integer.valueOf(3));
            contentValues.put("cv_value", "");
            sqLiteDatabase.insert("custom_var_cache", "event_id", contentValues);
        }
    }
    
    private static void I(final SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS transaction_events;");
        sqLiteDatabase.execSQL(p.i);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS item_events;");
        sqLiteDatabase.execSQL(p.j);
    }
    
    private static void J(final SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS referrer;");
        sqLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS referrer (referrer TEXT PRIMARY KEY NOT NULL,timestamp_referrer INTEGER NOT NULL,referrer_visit INTEGER NOT NULL DEFAULT 1,referrer_index INTEGER NOT NULL DEFAULT 1);");
    }
    
    private static void Z(final SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS hits;");
        sqLiteDatabase.execSQL(p.k);
    }
    
    public final void onCreate(final SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS events;");
        sqLiteDatabase.execSQL(p.e);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS install_referrer;");
        sqLiteDatabase.execSQL("CREATE TABLE install_referrer (referrer TEXT PRIMARY KEY NOT NULL);");
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS session;");
        sqLiteDatabase.execSQL(p.f);
        Code(sqLiteDatabase);
        I(sqLiteDatabase);
        Z(sqLiteDatabase);
        J(sqLiteDatabase);
    }
    
    public final void onDowngrade(final SQLiteDatabase p0, final int p1, final int p2) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     2: new             Ljava/lang/StringBuilder;
        //     5: dup            
        //     6: ldc             "Downgrading database version from "
        //     8: invokespecial   java/lang/StringBuilder.<init>:(Ljava/lang/String;)V
        //    11: iload_2        
        //    12: invokevirtual   java/lang/StringBuilder.append:(I)Ljava/lang/StringBuilder;
        //    15: ldc             " to "
        //    17: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //    20: iload_3        
        //    21: invokevirtual   java/lang/StringBuilder.append:(I)Ljava/lang/StringBuilder;
        //    24: ldc             " not recommended."
        //    26: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //    29: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //    32: invokestatic    android/util/Log.w:(Ljava/lang/String;Ljava/lang/String;)I
        //    35: pop            
        //    36: aload_1        
        //    37: ldc             "CREATE TABLE IF NOT EXISTS referrer (referrer TEXT PRIMARY KEY NOT NULL,timestamp_referrer INTEGER NOT NULL,referrer_visit INTEGER NOT NULL DEFAULT 1,referrer_index INTEGER NOT NULL DEFAULT 1);"
        //    39: invokevirtual   android/database/sqlite/SQLiteDatabase.execSQL:(Ljava/lang/String;)V
        //    42: aload_1        
        //    43: invokestatic    com/google/android/apps/analytics/p.d:()Ljava/lang/String;
        //    46: invokevirtual   android/database/sqlite/SQLiteDatabase.execSQL:(Ljava/lang/String;)V
        //    49: aload_1        
        //    50: invokestatic    com/google/android/apps/analytics/p.a:()Ljava/lang/String;
        //    53: invokevirtual   android/database/sqlite/SQLiteDatabase.execSQL:(Ljava/lang/String;)V
        //    56: aload_1        
        //    57: invokestatic    com/google/android/apps/analytics/p.B:()Ljava/lang/String;
        //    60: invokevirtual   android/database/sqlite/SQLiteDatabase.execSQL:(Ljava/lang/String;)V
        //    63: new             Ljava/util/HashSet;
        //    66: dup            
        //    67: invokespecial   java/util/HashSet.<init>:()V
        //    70: astore          4
        //    72: aload_1        
        //    73: ldc             "custom_var_cache"
        //    75: aconst_null    
        //    76: aconst_null    
        //    77: aconst_null    
        //    78: aconst_null    
        //    79: aconst_null    
        //    80: aconst_null    
        //    81: aconst_null    
        //    82: invokevirtual   android/database/sqlite/SQLiteDatabase.query:(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
        //    85: astore          5
        //    87: aload           5
        //    89: invokeinterface android/database/Cursor.moveToNext:()Z
        //    94: ifeq            261
        //    97: aload           4
        //    99: aload           5
        //   101: aload           5
        //   103: ldc             "cv_index"
        //   105: invokeinterface android/database/Cursor.getColumnIndex:(Ljava/lang/String;)I
        //   110: invokeinterface android/database/Cursor.getInt:(I)I
        //   115: invokestatic    java/lang/Integer.valueOf:(I)Ljava/lang/Integer;
        //   118: invokeinterface java/util/Set.add:(Ljava/lang/Object;)Z
        //   123: pop            
        //   124: goto            87
        //   127: astore          6
        //   129: ldc             "GoogleAnalyticsTracker"
        //   131: new             Ljava/lang/StringBuilder;
        //   134: dup            
        //   135: ldc             "Error on downgrade: "
        //   137: invokespecial   java/lang/StringBuilder.<init>:(Ljava/lang/String;)V
        //   140: aload           6
        //   142: invokevirtual   android/database/sqlite/SQLiteException.toString:()Ljava/lang/String;
        //   145: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   148: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   151: invokestatic    android/util/Log.e:(Ljava/lang/String;Ljava/lang/String;)I
        //   154: pop            
        //   155: aload           5
        //   157: invokeinterface android/database/Cursor.close:()V
        //   162: iconst_1       
        //   163: istore_2       
        //   164: iload_2        
        //   165: iconst_5       
        //   166: if_icmpgt       312
        //   169: aload           4
        //   171: iload_2        
        //   172: invokestatic    java/lang/Integer.valueOf:(I)Ljava/lang/Integer;
        //   175: invokeinterface java/util/Set.contains:(Ljava/lang/Object;)Z
        //   180: ifne            254
        //   183: new             Landroid/content/ContentValues;
        //   186: dup            
        //   187: invokespecial   android/content/ContentValues.<init>:()V
        //   190: astore          5
        //   192: aload           5
        //   194: ldc             "event_id"
        //   196: iconst_0       
        //   197: invokestatic    java/lang/Integer.valueOf:(I)Ljava/lang/Integer;
        //   200: invokevirtual   android/content/ContentValues.put:(Ljava/lang/String;Ljava/lang/Integer;)V
        //   203: aload           5
        //   205: ldc             "cv_index"
        //   207: iload_2        
        //   208: invokestatic    java/lang/Integer.valueOf:(I)Ljava/lang/Integer;
        //   211: invokevirtual   android/content/ContentValues.put:(Ljava/lang/String;Ljava/lang/Integer;)V
        //   214: aload           5
        //   216: ldc             "cv_name"
        //   218: ldc             ""
        //   220: invokevirtual   android/content/ContentValues.put:(Ljava/lang/String;Ljava/lang/String;)V
        //   223: aload           5
        //   225: ldc             "cv_scope"
        //   227: iconst_3       
        //   228: invokestatic    java/lang/Integer.valueOf:(I)Ljava/lang/Integer;
        //   231: invokevirtual   android/content/ContentValues.put:(Ljava/lang/String;Ljava/lang/Integer;)V
        //   234: aload           5
        //   236: ldc             "cv_value"
        //   238: ldc             ""
        //   240: invokevirtual   android/content/ContentValues.put:(Ljava/lang/String;Ljava/lang/String;)V
        //   243: aload_1        
        //   244: ldc             "custom_var_cache"
        //   246: ldc             "event_id"
        //   248: aload           5
        //   250: invokevirtual   android/database/sqlite/SQLiteDatabase.insert:(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J
        //   253: pop2           
        //   254: iload_2        
        //   255: iconst_1       
        //   256: iadd           
        //   257: istore_2       
        //   258: goto            164
        //   261: aload           5
        //   263: invokeinterface android/database/Cursor.close:()V
        //   268: goto            162
        //   271: astore_1       
        //   272: aload           5
        //   274: invokeinterface android/database/Cursor.close:()V
        //   279: aload_1        
        //   280: athrow         
        //   281: astore          5
        //   283: ldc             "GoogleAnalyticsTracker"
        //   285: new             Ljava/lang/StringBuilder;
        //   288: dup            
        //   289: ldc             "Error inserting custom variable on downgrade: "
        //   291: invokespecial   java/lang/StringBuilder.<init>:(Ljava/lang/String;)V
        //   294: aload           5
        //   296: invokevirtual   android/database/sqlite/SQLiteException.toString:()Ljava/lang/String;
        //   299: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   302: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   305: invokestatic    android/util/Log.e:(Ljava/lang/String;Ljava/lang/String;)I
        //   308: pop            
        //   309: goto            254
        //   312: return         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                                     
        //  -----  -----  -----  -----  -----------------------------------------
        //  87     124    127    162    Landroid/database/sqlite/SQLiteException;
        //  87     124    271    281    Any
        //  129    155    271    281    Any
        //  169    254    281    312    Landroid/database/sqlite/SQLiteException;
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0254:
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
    
    public final void onOpen(final SQLiteDatabase p0) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: invokevirtual   android/database/sqlite/SQLiteDatabase.isReadOnly:()Z
        //     4: ifeq            16
        //     7: ldc             "GoogleAnalyticsTracker"
        //     9: ldc             "Warning: Need to update database, but it's read only."
        //    11: invokestatic    android/util/Log.w:(Ljava/lang/String;Ljava/lang/String;)I
        //    14: pop            
        //    15: return         
        //    16: aload_1        
        //    17: ldc             "referrer"
        //    19: aconst_null    
        //    20: aconst_null    
        //    21: aconst_null    
        //    22: aconst_null    
        //    23: aconst_null    
        //    24: aconst_null    
        //    25: invokevirtual   android/database/sqlite/SQLiteDatabase.query:(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
        //    28: astore          8
        //    30: aload           8
        //    32: invokeinterface android/database/Cursor.getColumnNames:()[Ljava/lang/String;
        //    37: astore          9
        //    39: iconst_0       
        //    40: istore_2       
        //    41: iconst_0       
        //    42: istore          4
        //    44: iconst_0       
        //    45: istore_3       
        //    46: iload_2        
        //    47: aload           9
        //    49: arraylength    
        //    50: if_icmpge       432
        //    53: aload           9
        //    55: iload_2        
        //    56: aaload         
        //    57: ldc             "referrer_index"
        //    59: invokevirtual   java/lang/String.equals:(Ljava/lang/Object;)Z
        //    62: ifeq            71
        //    65: iconst_1       
        //    66: istore          5
        //    68: goto            422
        //    71: iload_3        
        //    72: istore          5
        //    74: aload           9
        //    76: iload_2        
        //    77: aaload         
        //    78: ldc             "referrer_visit"
        //    80: invokevirtual   java/lang/String.equals:(Ljava/lang/Object;)Z
        //    83: ifeq            422
        //    86: iconst_1       
        //    87: istore          4
        //    89: iload_3        
        //    90: istore          5
        //    92: goto            422
        //    95: aload           8
        //    97: invokeinterface android/database/Cursor.moveToFirst:()Z
        //   102: ifeq            416
        //   105: aload           8
        //   107: ldc             "referrer_visit"
        //   109: invokeinterface android/database/Cursor.getColumnIndex:(Ljava/lang/String;)I
        //   114: istore_2       
        //   115: aload           8
        //   117: ldc             "referrer_index"
        //   119: invokeinterface android/database/Cursor.getColumnIndex:(Ljava/lang/String;)I
        //   124: istore_3       
        //   125: aload           8
        //   127: aload           8
        //   129: ldc             "referrer"
        //   131: invokeinterface android/database/Cursor.getColumnIndex:(Ljava/lang/String;)I
        //   136: invokeinterface android/database/Cursor.getString:(I)Ljava/lang/String;
        //   141: astore          9
        //   143: aload           8
        //   145: aload           8
        //   147: ldc             "timestamp_referrer"
        //   149: invokeinterface android/database/Cursor.getColumnIndex:(Ljava/lang/String;)I
        //   154: invokeinterface android/database/Cursor.getLong:(I)J
        //   159: lstore          6
        //   161: iload_2        
        //   162: iconst_m1      
        //   163: if_icmpne       304
        //   166: iconst_1       
        //   167: istore_2       
        //   168: goto            444
        //   171: new             Lcom/google/android/apps/analytics/t;
        //   174: dup            
        //   175: aload           9
        //   177: lload           6
        //   179: iload_2        
        //   180: iload_3        
        //   181: invokespecial   com/google/android/apps/analytics/t.<init>:(Ljava/lang/String;JII)V
        //   184: astore          9
        //   186: aload_1        
        //   187: invokevirtual   android/database/sqlite/SQLiteDatabase.beginTransaction:()V
        //   190: aload_1        
        //   191: invokestatic    com/google/android/apps/analytics/q.J:(Landroid/database/sqlite/SQLiteDatabase;)V
        //   194: aload           9
        //   196: ifnull          275
        //   199: new             Landroid/content/ContentValues;
        //   202: dup            
        //   203: invokespecial   android/content/ContentValues.<init>:()V
        //   206: astore          10
        //   208: aload           10
        //   210: ldc             "referrer"
        //   212: aload           9
        //   214: invokevirtual   com/google/android/apps/analytics/t.Code:()Ljava/lang/String;
        //   217: invokevirtual   android/content/ContentValues.put:(Ljava/lang/String;Ljava/lang/String;)V
        //   220: aload           10
        //   222: ldc             "timestamp_referrer"
        //   224: aload           9
        //   226: invokevirtual   com/google/android/apps/analytics/t.I:()J
        //   229: invokestatic    java/lang/Long.valueOf:(J)Ljava/lang/Long;
        //   232: invokevirtual   android/content/ContentValues.put:(Ljava/lang/String;Ljava/lang/Long;)V
        //   235: aload           10
        //   237: ldc             "referrer_visit"
        //   239: aload           9
        //   241: invokevirtual   com/google/android/apps/analytics/t.Z:()I
        //   244: invokestatic    java/lang/Integer.valueOf:(I)Ljava/lang/Integer;
        //   247: invokevirtual   android/content/ContentValues.put:(Ljava/lang/String;Ljava/lang/Integer;)V
        //   250: aload           10
        //   252: ldc             "referrer_index"
        //   254: aload           9
        //   256: invokevirtual   com/google/android/apps/analytics/t.J:()I
        //   259: invokestatic    java/lang/Integer.valueOf:(I)Ljava/lang/Integer;
        //   262: invokevirtual   android/content/ContentValues.put:(Ljava/lang/String;Ljava/lang/Integer;)V
        //   265: aload_1        
        //   266: ldc             "referrer"
        //   268: aconst_null    
        //   269: aload           10
        //   271: invokevirtual   android/database/sqlite/SQLiteDatabase.insert:(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J
        //   274: pop2           
        //   275: aload_1        
        //   276: invokevirtual   android/database/sqlite/SQLiteDatabase.setTransactionSuccessful:()V
        //   279: aload           8
        //   281: ifnull          291
        //   284: aload           8
        //   286: invokeinterface android/database/Cursor.close:()V
        //   291: aload_1        
        //   292: invokevirtual   android/database/sqlite/SQLiteDatabase.inTransaction:()Z
        //   295: ifeq            15
        //   298: aload_1        
        //   299: invokestatic    com/google/android/apps/analytics/p.Z:(Landroid/database/sqlite/SQLiteDatabase;)Z
        //   302: pop            
        //   303: return         
        //   304: aload           8
        //   306: iload_2        
        //   307: invokeinterface android/database/Cursor.getInt:(I)I
        //   312: istore_2       
        //   313: goto            444
        //   316: aload           8
        //   318: iload_3        
        //   319: invokeinterface android/database/Cursor.getInt:(I)I
        //   324: istore_3       
        //   325: goto            171
        //   328: astore          9
        //   330: aconst_null    
        //   331: astore          8
        //   333: ldc             "GoogleAnalyticsTracker"
        //   335: aload           9
        //   337: invokevirtual   android/database/sqlite/SQLiteException.toString:()Ljava/lang/String;
        //   340: invokestatic    android/util/Log.e:(Ljava/lang/String;Ljava/lang/String;)I
        //   343: pop            
        //   344: aload           8
        //   346: ifnull          356
        //   349: aload           8
        //   351: invokeinterface android/database/Cursor.close:()V
        //   356: aload_1        
        //   357: invokevirtual   android/database/sqlite/SQLiteDatabase.inTransaction:()Z
        //   360: ifeq            15
        //   363: aload_1        
        //   364: invokestatic    com/google/android/apps/analytics/p.Z:(Landroid/database/sqlite/SQLiteDatabase;)Z
        //   367: pop            
        //   368: return         
        //   369: astore          9
        //   371: aconst_null    
        //   372: astore          8
        //   374: aload           8
        //   376: ifnull          386
        //   379: aload           8
        //   381: invokeinterface android/database/Cursor.close:()V
        //   386: aload_1        
        //   387: invokevirtual   android/database/sqlite/SQLiteDatabase.inTransaction:()Z
        //   390: ifeq            398
        //   393: aload_1        
        //   394: invokestatic    com/google/android/apps/analytics/p.Z:(Landroid/database/sqlite/SQLiteDatabase;)Z
        //   397: pop            
        //   398: aload           9
        //   400: athrow         
        //   401: astore          9
        //   403: goto            374
        //   406: astore          9
        //   408: goto            374
        //   411: astore          9
        //   413: goto            333
        //   416: aconst_null    
        //   417: astore          9
        //   419: goto            186
        //   422: iload_2        
        //   423: iconst_1       
        //   424: iadd           
        //   425: istore_2       
        //   426: iload           5
        //   428: istore_3       
        //   429: goto            46
        //   432: iload_3        
        //   433: ifeq            95
        //   436: iload           4
        //   438: ifne            279
        //   441: goto            95
        //   444: iload_3        
        //   445: iconst_m1      
        //   446: if_icmpne       316
        //   449: iconst_1       
        //   450: istore_3       
        //   451: goto            171
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                                     
        //  -----  -----  -----  -----  -----------------------------------------
        //  16     30     328    333    Landroid/database/sqlite/SQLiteException;
        //  16     30     369    374    Any
        //  30     39     411    416    Landroid/database/sqlite/SQLiteException;
        //  30     39     401    406    Any
        //  46     65     411    416    Landroid/database/sqlite/SQLiteException;
        //  46     65     401    406    Any
        //  74     86     411    416    Landroid/database/sqlite/SQLiteException;
        //  74     86     401    406    Any
        //  95     161    411    416    Landroid/database/sqlite/SQLiteException;
        //  95     161    401    406    Any
        //  171    186    411    416    Landroid/database/sqlite/SQLiteException;
        //  171    186    401    406    Any
        //  186    194    411    416    Landroid/database/sqlite/SQLiteException;
        //  186    194    401    406    Any
        //  199    275    411    416    Landroid/database/sqlite/SQLiteException;
        //  199    275    401    406    Any
        //  275    279    411    416    Landroid/database/sqlite/SQLiteException;
        //  275    279    401    406    Any
        //  304    313    411    416    Landroid/database/sqlite/SQLiteException;
        //  304    313    401    406    Any
        //  316    325    411    416    Landroid/database/sqlite/SQLiteException;
        //  316    325    401    406    Any
        //  333    344    406    411    Any
        // 
        // The error that occurred was:
        // 
        // java.lang.NullPointerException
        //     at com.strobel.assembler.ir.StackMappingVisitor.push(StackMappingVisitor.java:290)
        //     at com.strobel.assembler.ir.StackMappingVisitor$InstructionAnalyzer.execute(StackMappingVisitor.java:833)
        //     at com.strobel.assembler.ir.StackMappingVisitor$InstructionAnalyzer.visit(StackMappingVisitor.java:398)
        //     at com.strobel.decompiler.ast.AstBuilder.performStackAnalysis(AstBuilder.java:2088)
        //     at com.strobel.decompiler.ast.AstBuilder.build(AstBuilder.java:108)
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
    
    public final void onUpgrade(final SQLiteDatabase p0, final int p1, final int p2) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: iload_3        
        //     2: if_icmple       13
        //     5: aload_0        
        //     6: aload_1        
        //     7: iload_2        
        //     8: iload_3        
        //     9: invokevirtual   com/google/android/apps/analytics/q.onDowngrade:(Landroid/database/sqlite/SQLiteDatabase;II)V
        //    12: return         
        //    13: iload_2        
        //    14: iconst_2       
        //    15: if_icmpge       27
        //    18: iload_3        
        //    19: iconst_1       
        //    20: if_icmple       27
        //    23: aload_1        
        //    24: invokestatic    com/google/android/apps/analytics/q.Code:(Landroid/database/sqlite/SQLiteDatabase;)V
        //    27: iload_2        
        //    28: iconst_3       
        //    29: if_icmpge       41
        //    32: iload_3        
        //    33: iconst_2       
        //    34: if_icmple       41
        //    37: aload_1        
        //    38: invokestatic    com/google/android/apps/analytics/q.I:(Landroid/database/sqlite/SQLiteDatabase;)V
        //    41: iload_2        
        //    42: iconst_4       
        //    43: if_icmpge       12
        //    46: iload_3        
        //    47: iconst_3       
        //    48: if_icmple       12
        //    51: aload_1        
        //    52: invokestatic    com/google/android/apps/analytics/q.Z:(Landroid/database/sqlite/SQLiteDatabase;)V
        //    55: aload_1        
        //    56: invokestatic    com/google/android/apps/analytics/q.J:(Landroid/database/sqlite/SQLiteDatabase;)V
        //    59: aload_0        
        //    60: getfield        com/google/android/apps/analytics/q.Code:Lcom/google/android/apps/analytics/p;
        //    63: aload_1        
        //    64: invokevirtual   com/google/android/apps/analytics/p.I:(Landroid/database/sqlite/SQLiteDatabase;)V
        //    67: aload_0        
        //    68: getfield        com/google/android/apps/analytics/q.Code:Lcom/google/android/apps/analytics/p;
        //    71: astore          6
        //    73: aload_0        
        //    74: getfield        com/google/android/apps/analytics/q.Code:Lcom/google/android/apps/analytics/p;
        //    77: astore          7
        //    79: aload           6
        //    81: aload_1        
        //    82: invokestatic    com/google/android/apps/analytics/p.Code:(Landroid/database/sqlite/SQLiteDatabase;)Lcom/google/android/apps/analytics/J;
        //    85: invokestatic    com/google/android/apps/analytics/p.Code:(Lcom/google/android/apps/analytics/p;Lcom/google/android/apps/analytics/J;)Lcom/google/android/apps/analytics/J;
        //    88: pop            
        //    89: aload_0        
        //    90: getfield        com/google/android/apps/analytics/q.Code:Lcom/google/android/apps/analytics/p;
        //    93: astore          6
        //    95: aload_1        
        //    96: iload_2        
        //    97: invokestatic    com/google/android/apps/analytics/p.Code:(Landroid/database/sqlite/SQLiteDatabase;I)[Lcom/google/android/apps/analytics/a;
        //   100: astore          6
        //   102: iconst_0       
        //   103: istore_2       
        //   104: iload_2        
        //   105: aload           6
        //   107: arraylength    
        //   108: if_icmpge       130
        //   111: aload_0        
        //   112: getfield        com/google/android/apps/analytics/q.Code:Lcom/google/android/apps/analytics/p;
        //   115: aload           6
        //   117: iload_2        
        //   118: aaload         
        //   119: aload_1        
        //   120: invokestatic    com/google/android/apps/analytics/p.Code:(Lcom/google/android/apps/analytics/p;Lcom/google/android/apps/analytics/a;Landroid/database/sqlite/SQLiteDatabase;)V
        //   123: iload_2        
        //   124: iconst_1       
        //   125: iadd           
        //   126: istore_2       
        //   127: goto            104
        //   130: aload_1        
        //   131: ldc_w           "DELETE from events;"
        //   134: invokevirtual   android/database/sqlite/SQLiteDatabase.execSQL:(Ljava/lang/String;)V
        //   137: aload_1        
        //   138: ldc_w           "DELETE from item_events;"
        //   141: invokevirtual   android/database/sqlite/SQLiteDatabase.execSQL:(Ljava/lang/String;)V
        //   144: aload_1        
        //   145: ldc_w           "DELETE from transaction_events;"
        //   148: invokevirtual   android/database/sqlite/SQLiteDatabase.execSQL:(Ljava/lang/String;)V
        //   151: aload_1        
        //   152: ldc_w           "DELETE from custom_variables;"
        //   155: invokevirtual   android/database/sqlite/SQLiteDatabase.execSQL:(Ljava/lang/String;)V
        //   158: aconst_null    
        //   159: astore          7
        //   161: aload_1        
        //   162: ldc_w           "install_referrer"
        //   165: iconst_1       
        //   166: anewarray       Ljava/lang/String;
        //   169: dup            
        //   170: iconst_0       
        //   171: ldc             "referrer"
        //   173: aastore        
        //   174: aconst_null    
        //   175: aconst_null    
        //   176: aconst_null    
        //   177: aconst_null    
        //   178: aconst_null    
        //   179: invokevirtual   android/database/sqlite/SQLiteDatabase.query:(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
        //   182: astore          6
        //   184: aload           6
        //   186: astore          7
        //   188: aload           6
        //   190: invokeinterface android/database/Cursor.moveToFirst:()Z
        //   195: ifeq            469
        //   198: aload           6
        //   200: astore          7
        //   202: aload           6
        //   204: iconst_0       
        //   205: invokeinterface android/database/Cursor.getString:(I)Ljava/lang/String;
        //   210: astore          9
        //   212: aload           6
        //   214: astore          7
        //   216: aload_1        
        //   217: ldc_w           "session"
        //   220: aconst_null    
        //   221: aconst_null    
        //   222: aconst_null    
        //   223: aconst_null    
        //   224: aconst_null    
        //   225: aconst_null    
        //   226: invokevirtual   android/database/sqlite/SQLiteDatabase.query:(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
        //   229: astore          8
        //   231: aload           8
        //   233: astore          7
        //   235: aload           7
        //   237: invokeinterface android/database/Cursor.moveToFirst:()Z
        //   242: ifeq            463
        //   245: aload           7
        //   247: iconst_0       
        //   248: invokeinterface android/database/Cursor.getLong:(I)J
        //   253: lstore          4
        //   255: new             Landroid/content/ContentValues;
        //   258: dup            
        //   259: invokespecial   android/content/ContentValues.<init>:()V
        //   262: astore          8
        //   264: aload           8
        //   266: ldc             "referrer"
        //   268: aload           9
        //   270: invokevirtual   android/content/ContentValues.put:(Ljava/lang/String;Ljava/lang/String;)V
        //   273: aload           8
        //   275: ldc             "timestamp_referrer"
        //   277: lload           4
        //   279: invokestatic    java/lang/Long.valueOf:(J)Ljava/lang/Long;
        //   282: invokevirtual   android/content/ContentValues.put:(Ljava/lang/String;Ljava/lang/Long;)V
        //   285: aload           8
        //   287: ldc             "referrer_visit"
        //   289: iconst_1       
        //   290: invokestatic    java/lang/Integer.valueOf:(I)Ljava/lang/Integer;
        //   293: invokevirtual   android/content/ContentValues.put:(Ljava/lang/String;Ljava/lang/Integer;)V
        //   296: aload           8
        //   298: ldc             "referrer_index"
        //   300: iconst_1       
        //   301: invokestatic    java/lang/Integer.valueOf:(I)Ljava/lang/Integer;
        //   304: invokevirtual   android/content/ContentValues.put:(Ljava/lang/String;Ljava/lang/Integer;)V
        //   307: aload_1        
        //   308: ldc             "referrer"
        //   310: aconst_null    
        //   311: aload           8
        //   313: invokevirtual   android/database/sqlite/SQLiteDatabase.insert:(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J
        //   316: pop2           
        //   317: aload           6
        //   319: ifnull          329
        //   322: aload           6
        //   324: invokeinterface android/database/Cursor.close:()V
        //   329: aload           7
        //   331: ifnull          12
        //   334: aload           7
        //   336: invokeinterface android/database/Cursor.close:()V
        //   341: return         
        //   342: astore          6
        //   344: aconst_null    
        //   345: astore          7
        //   347: aconst_null    
        //   348: astore_1       
        //   349: ldc             "GoogleAnalyticsTracker"
        //   351: aload           6
        //   353: invokevirtual   android/database/sqlite/SQLiteException.toString:()Ljava/lang/String;
        //   356: invokestatic    android/util/Log.e:(Ljava/lang/String;Ljava/lang/String;)I
        //   359: pop            
        //   360: aload_1        
        //   361: ifnull          370
        //   364: aload_1        
        //   365: invokeinterface android/database/Cursor.close:()V
        //   370: aload           7
        //   372: ifnull          12
        //   375: aload           7
        //   377: invokeinterface android/database/Cursor.close:()V
        //   382: return         
        //   383: astore_1       
        //   384: aconst_null    
        //   385: astore          8
        //   387: aload           7
        //   389: astore          6
        //   391: aload           8
        //   393: astore          7
        //   395: aload           6
        //   397: ifnull          407
        //   400: aload           6
        //   402: invokeinterface android/database/Cursor.close:()V
        //   407: aload           7
        //   409: ifnull          419
        //   412: aload           7
        //   414: invokeinterface android/database/Cursor.close:()V
        //   419: aload_1        
        //   420: athrow         
        //   421: astore_1       
        //   422: goto            395
        //   425: astore          8
        //   427: aload_1        
        //   428: astore          6
        //   430: aload           8
        //   432: astore_1       
        //   433: goto            395
        //   436: astore          8
        //   438: aconst_null    
        //   439: astore          7
        //   441: aload           6
        //   443: astore_1       
        //   444: aload           8
        //   446: astore          6
        //   448: goto            349
        //   451: astore          8
        //   453: aload           6
        //   455: astore_1       
        //   456: aload           8
        //   458: astore          6
        //   460: goto            349
        //   463: lconst_0       
        //   464: lstore          4
        //   466: goto            255
        //   469: aconst_null    
        //   470: astore          7
        //   472: goto            317
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                                     
        //  -----  -----  -----  -----  -----------------------------------------
        //  161    184    342    349    Landroid/database/sqlite/SQLiteException;
        //  161    184    383    395    Any
        //  188    198    436    451    Landroid/database/sqlite/SQLiteException;
        //  188    198    383    395    Any
        //  202    212    436    451    Landroid/database/sqlite/SQLiteException;
        //  202    212    383    395    Any
        //  216    231    436    451    Landroid/database/sqlite/SQLiteException;
        //  216    231    383    395    Any
        //  235    255    451    463    Landroid/database/sqlite/SQLiteException;
        //  235    255    421    425    Any
        //  255    317    451    463    Landroid/database/sqlite/SQLiteException;
        //  255    317    421    425    Any
        //  349    360    425    436    Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0255:
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
}
