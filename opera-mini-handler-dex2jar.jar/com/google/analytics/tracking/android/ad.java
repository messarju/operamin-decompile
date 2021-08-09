// 
// Decompiled by Procyon v0.6-prerelease
// 

package com.google.analytics.tracking.android;

import android.content.ContentValues;
import android.database.Cursor;
import java.util.Collections;
import java.util.Collection;
import java.util.List;
import java.util.Iterator;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Map;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteDatabase;
import android.content.Context;

final class ad implements d
{
    private static final String Code;
    private final Context B;
    private final String C;
    private final ak I;
    private final e.e$Code J;
    private volatile k Z;
    private long a;
    private h b;
    
    static {
        Code = String.format("CREATE TABLE IF NOT EXISTS %s ( '%s' INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, '%s' INTEGER NOT NULL, '%s' TEXT NOT NULL, '%s' TEXT NOT NULL, '%s' INTEGER);", "hits2", "hit_id", "hit_time", "hit_url", "hit_string", "hit_app_id");
    }
    
    ad(final e.e$Code object, final Context context) {
        this(object, context, "google_analytics_v2.db");
    }
    
    private ad(final e.e$Code j, final Context context, final String c) {
        this.B = context.getApplicationContext();
        this.C = c;
        this.J = j;
        this.b = new h() {
            @Override
            public final long Code() {
                return System.currentTimeMillis();
            }
        };
        this.I = new ak(this, this.B, this.C);
        this.Z = new k(new Object() {}, this.B);
        this.a = 0L;
    }
    
    private SQLiteDatabase Code(final String s) {
        try {
            return this.I.getWritableDatabase();
        }
        catch (SQLiteException ex) {
            ae.C(s);
            return null;
        }
    }
    
    private static String Code(final Map map) {
        final ArrayList list = new ArrayList(map.size());
        for (final Map.Entry<String, V> entry : map.entrySet()) {
            list.add(entry.getKey() + "=" + ac.Code((String)entry.getValue()));
        }
        return TextUtils.join((CharSequence)"&", (Iterable)list);
    }
    
    private List Code(final int p0) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: ldc             "Error opening database for peekHits"
        //     3: invokespecial   com/google/analytics/tracking/android/ad.Code:(Ljava/lang/String;)Landroid/database/sqlite/SQLiteDatabase;
        //     6: astore          6
        //     8: aload           6
        //    10: ifnonnull       25
        //    13: new             Ljava/util/ArrayList;
        //    16: dup            
        //    17: invokespecial   java/util/ArrayList.<init>:()V
        //    20: astore          5
        //    22: aload           5
        //    24: areturn        
        //    25: aconst_null    
        //    26: astore          5
        //    28: new             Ljava/util/ArrayList;
        //    31: dup            
        //    32: invokespecial   java/util/ArrayList.<init>:()V
        //    35: pop            
        //    36: ldc             "%s ASC, %s ASC"
        //    38: iconst_2       
        //    39: anewarray       Ljava/lang/Object;
        //    42: dup            
        //    43: iconst_0       
        //    44: ldc             "hit_url"
        //    46: aastore        
        //    47: dup            
        //    48: iconst_1       
        //    49: ldc             "hit_id"
        //    51: aastore        
        //    52: invokestatic    java/lang/String.format:(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
        //    55: astore          4
        //    57: iload_1        
        //    58: invokestatic    java/lang/Integer.toString:(I)Ljava/lang/String;
        //    61: astore          7
        //    63: aload           6
        //    65: ldc             "hits2"
        //    67: iconst_3       
        //    68: anewarray       Ljava/lang/String;
        //    71: dup            
        //    72: iconst_0       
        //    73: ldc             "hit_id"
        //    75: aastore        
        //    76: dup            
        //    77: iconst_1       
        //    78: ldc             "hit_time"
        //    80: aastore        
        //    81: dup            
        //    82: iconst_2       
        //    83: ldc             "hit_url"
        //    85: aastore        
        //    86: aconst_null    
        //    87: aconst_null    
        //    88: aconst_null    
        //    89: aconst_null    
        //    90: aload           4
        //    92: aload           7
        //    94: invokevirtual   android/database/sqlite/SQLiteDatabase.query:(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
        //    97: astore          4
        //    99: new             Ljava/util/ArrayList;
        //   102: dup            
        //   103: invokespecial   java/util/ArrayList.<init>:()V
        //   106: astore          7
        //   108: aload           4
        //   110: invokeinterface android/database/Cursor.moveToFirst:()Z
        //   115: ifeq            178
        //   118: new             Lcom/google/analytics/tracking/android/ab;
        //   121: dup            
        //   122: aload           4
        //   124: iconst_0       
        //   125: invokeinterface android/database/Cursor.getLong:(I)J
        //   130: aload           4
        //   132: iconst_1       
        //   133: invokeinterface android/database/Cursor.getLong:(I)J
        //   138: invokespecial   com/google/analytics/tracking/android/ab.<init>:(JJ)V
        //   141: astore          5
        //   143: aload           5
        //   145: aload           4
        //   147: iconst_2       
        //   148: invokeinterface android/database/Cursor.getString:(I)Ljava/lang/String;
        //   153: invokevirtual   com/google/analytics/tracking/android/ab.I:(Ljava/lang/String;)V
        //   156: aload           7
        //   158: aload           5
        //   160: invokeinterface java/util/List.add:(Ljava/lang/Object;)Z
        //   165: pop            
        //   166: aload           4
        //   168: invokeinterface android/database/Cursor.moveToNext:()Z
        //   173: istore_3       
        //   174: iload_3        
        //   175: ifne            118
        //   178: aload           4
        //   180: ifnull          190
        //   183: aload           4
        //   185: invokeinterface android/database/Cursor.close:()V
        //   190: aload           4
        //   192: astore          5
        //   194: ldc             "%s ASC"
        //   196: iconst_1       
        //   197: anewarray       Ljava/lang/Object;
        //   200: dup            
        //   201: iconst_0       
        //   202: ldc             "hit_id"
        //   204: aastore        
        //   205: invokestatic    java/lang/String.format:(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
        //   208: astore          8
        //   210: aload           4
        //   212: astore          5
        //   214: iload_1        
        //   215: invokestatic    java/lang/Integer.toString:(I)Ljava/lang/String;
        //   218: astore          9
        //   220: aload           4
        //   222: astore          5
        //   224: aload           6
        //   226: ldc             "hits2"
        //   228: iconst_2       
        //   229: anewarray       Ljava/lang/String;
        //   232: dup            
        //   233: iconst_0       
        //   234: ldc             "hit_id"
        //   236: aastore        
        //   237: dup            
        //   238: iconst_1       
        //   239: ldc             "hit_string"
        //   241: aastore        
        //   242: aconst_null    
        //   243: aconst_null    
        //   244: aconst_null    
        //   245: aconst_null    
        //   246: aload           8
        //   248: aload           9
        //   250: invokevirtual   android/database/sqlite/SQLiteDatabase.query:(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
        //   253: astore          6
        //   255: aload           6
        //   257: invokeinterface android/database/Cursor.moveToFirst:()Z
        //   262: ifeq            339
        //   265: iconst_0       
        //   266: istore_1       
        //   267: aload           6
        //   269: instanceof      Landroid/database/sqlite/SQLiteCursor;
        //   272: ifeq            428
        //   275: aload           6
        //   277: checkcast       Landroid/database/sqlite/SQLiteCursor;
        //   280: invokevirtual   android/database/sqlite/SQLiteCursor.getWindow:()Landroid/database/CursorWindow;
        //   283: invokevirtual   android/database/CursorWindow.getNumRows:()I
        //   286: ifgt            428
        //   289: new             Ljava/lang/StringBuilder;
        //   292: dup            
        //   293: ldc             "hitString for hitId "
        //   295: invokespecial   java/lang/StringBuilder.<init>:(Ljava/lang/String;)V
        //   298: aload           7
        //   300: iload_1        
        //   301: invokeinterface java/util/List.get:(I)Ljava/lang/Object;
        //   306: checkcast       Lcom/google/analytics/tracking/android/ab;
        //   309: invokevirtual   com/google/analytics/tracking/android/ab.I:()J
        //   312: invokevirtual   java/lang/StringBuilder.append:(J)Ljava/lang/StringBuilder;
        //   315: ldc             " too large.  Hit will be deleted."
        //   317: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   320: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   323: invokestatic    com/google/analytics/tracking/android/ae.C:(Ljava/lang/String;)I
        //   326: pop            
        //   327: aload           6
        //   329: invokeinterface android/database/Cursor.moveToNext:()Z
        //   334: istore_3       
        //   335: iload_3        
        //   336: ifne            669
        //   339: aload           6
        //   341: ifnull          351
        //   344: aload           6
        //   346: invokeinterface android/database/Cursor.close:()V
        //   351: aload           7
        //   353: areturn        
        //   354: astore          5
        //   356: aconst_null    
        //   357: astore          4
        //   359: new             Ljava/lang/StringBuilder;
        //   362: dup            
        //   363: ldc             "error in peekHits fetching hitIds: "
        //   365: invokespecial   java/lang/StringBuilder.<init>:(Ljava/lang/String;)V
        //   368: aload           5
        //   370: invokevirtual   android/database/sqlite/SQLiteException.getMessage:()Ljava/lang/String;
        //   373: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   376: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   379: invokestatic    com/google/analytics/tracking/android/ae.C:(Ljava/lang/String;)I
        //   382: pop            
        //   383: new             Ljava/util/ArrayList;
        //   386: dup            
        //   387: invokespecial   java/util/ArrayList.<init>:()V
        //   390: astore          6
        //   392: aload           6
        //   394: astore          5
        //   396: aload           4
        //   398: ifnull          22
        //   401: aload           4
        //   403: invokeinterface android/database/Cursor.close:()V
        //   408: aload           6
        //   410: areturn        
        //   411: astore          4
        //   413: aload           5
        //   415: ifnull          425
        //   418: aload           5
        //   420: invokeinterface android/database/Cursor.close:()V
        //   425: aload           4
        //   427: athrow         
        //   428: aload           7
        //   430: iload_1        
        //   431: invokeinterface java/util/List.get:(I)Ljava/lang/Object;
        //   436: checkcast       Lcom/google/analytics/tracking/android/ab;
        //   439: aload           6
        //   441: iconst_1       
        //   442: invokeinterface android/database/Cursor.getString:(I)Ljava/lang/String;
        //   447: invokevirtual   com/google/analytics/tracking/android/ab.Code:(Ljava/lang/String;)V
        //   450: goto            327
        //   453: astore          5
        //   455: aload           6
        //   457: astore          4
        //   459: aload           5
        //   461: astore          6
        //   463: aload           4
        //   465: astore          5
        //   467: new             Ljava/lang/StringBuilder;
        //   470: dup            
        //   471: ldc_w           "error in peekHits fetching hitString: "
        //   474: invokespecial   java/lang/StringBuilder.<init>:(Ljava/lang/String;)V
        //   477: aload           6
        //   479: invokevirtual   android/database/sqlite/SQLiteException.getMessage:()Ljava/lang/String;
        //   482: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   485: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   488: invokestatic    com/google/analytics/tracking/android/ae.C:(Ljava/lang/String;)I
        //   491: pop            
        //   492: aload           4
        //   494: astore          5
        //   496: new             Ljava/util/ArrayList;
        //   499: dup            
        //   500: invokespecial   java/util/ArrayList.<init>:()V
        //   503: astore          6
        //   505: aload           4
        //   507: astore          5
        //   509: aload           7
        //   511: invokeinterface java/util/List.iterator:()Ljava/util/Iterator;
        //   516: astore          7
        //   518: iconst_0       
        //   519: istore_1       
        //   520: aload           4
        //   522: astore          5
        //   524: aload           7
        //   526: invokeinterface java/util/Iterator.hasNext:()Z
        //   531: ifeq            609
        //   534: aload           4
        //   536: astore          5
        //   538: aload           7
        //   540: invokeinterface java/util/Iterator.next:()Ljava/lang/Object;
        //   545: checkcast       Lcom/google/analytics/tracking/android/ab;
        //   548: astore          8
        //   550: iload_1        
        //   551: istore_2       
        //   552: aload           4
        //   554: astore          5
        //   556: aload           8
        //   558: invokevirtual   com/google/analytics/tracking/android/ab.Code:()Ljava/lang/String;
        //   561: invokestatic    android/text/TextUtils.isEmpty:(Ljava/lang/CharSequence;)Z
        //   564: ifeq            573
        //   567: iload_1        
        //   568: ifne            609
        //   571: iconst_1       
        //   572: istore_2       
        //   573: aload           4
        //   575: astore          5
        //   577: aload           6
        //   579: aload           8
        //   581: invokeinterface java/util/List.add:(Ljava/lang/Object;)Z
        //   586: pop            
        //   587: iload_2        
        //   588: istore_1       
        //   589: goto            520
        //   592: astore          4
        //   594: aload           5
        //   596: ifnull          606
        //   599: aload           5
        //   601: invokeinterface android/database/Cursor.close:()V
        //   606: aload           4
        //   608: athrow         
        //   609: aload           4
        //   611: ifnull          621
        //   614: aload           4
        //   616: invokeinterface android/database/Cursor.close:()V
        //   621: aload           6
        //   623: areturn        
        //   624: astore          4
        //   626: aload           6
        //   628: astore          5
        //   630: goto            594
        //   633: astore          6
        //   635: goto            463
        //   638: astore          6
        //   640: aload           4
        //   642: astore          5
        //   644: aload           6
        //   646: astore          4
        //   648: goto            413
        //   651: astore          6
        //   653: aload           4
        //   655: astore          5
        //   657: aload           6
        //   659: astore          4
        //   661: goto            413
        //   664: astore          5
        //   666: goto            359
        //   669: iload_1        
        //   670: iconst_1       
        //   671: iadd           
        //   672: istore_1       
        //   673: goto            267
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                                     
        //  -----  -----  -----  -----  -----------------------------------------
        //  36     99     354    359    Landroid/database/sqlite/SQLiteException;
        //  36     99     411    413    Any
        //  99     118    664    669    Landroid/database/sqlite/SQLiteException;
        //  99     118    638    651    Any
        //  118    174    664    669    Landroid/database/sqlite/SQLiteException;
        //  118    174    638    651    Any
        //  194    210    633    638    Landroid/database/sqlite/SQLiteException;
        //  194    210    592    594    Any
        //  214    220    633    638    Landroid/database/sqlite/SQLiteException;
        //  214    220    592    594    Any
        //  224    255    633    638    Landroid/database/sqlite/SQLiteException;
        //  224    255    592    594    Any
        //  255    265    453    463    Landroid/database/sqlite/SQLiteException;
        //  255    265    624    633    Any
        //  267    327    453    463    Landroid/database/sqlite/SQLiteException;
        //  267    327    624    633    Any
        //  327    335    453    463    Landroid/database/sqlite/SQLiteException;
        //  327    335    624    633    Any
        //  359    392    651    664    Any
        //  428    450    453    463    Landroid/database/sqlite/SQLiteException;
        //  428    450    624    633    Any
        //  467    492    592    594    Any
        //  496    505    592    594    Any
        //  509    518    592    594    Any
        //  524    534    592    594    Any
        //  538    550    592    594    Any
        //  556    567    592    594    Any
        //  577    587    592    594    Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IndexOutOfBoundsException: Index: 311, Size: 311
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
    
    private void Code(final Collection collection) {
        boolean b = false;
        if (collection == null) {
            throw new NullPointerException("hits cannot be null");
        }
        if (!collection.isEmpty()) {
            final SQLiteDatabase code = this.Code("Error opening database for deleteHit");
            if (code != null) {
                final String[] array = new String[collection.size()];
                final String format = String.format("HIT_ID in (%s)", TextUtils.join((CharSequence)",", (Iterable)Collections.nCopies(array.length, "?")));
                final Iterator iterator = collection.iterator();
                int n = 0;
                while (iterator.hasNext()) {
                    array[n] = Long.toString(((ab)iterator.next()).I());
                    ++n;
                }
                try {
                    code.delete("hits2", format, array);
                    final Object j = this.J;
                    if (this.J() == 0) {
                        b = true;
                    }
                    j.Code(b);
                }
                catch (SQLiteException ex) {
                    ae.C("Error deleting hit " + collection);
                }
            }
        }
    }
    
    private int J() {
        Cursor cursor = null;
        Cursor rawQuery = null;
        int n = 0;
        int n2 = 0;
        final SQLiteDatabase code = this.Code("Error opening database for requestNumHitsPending");
        if (code == null) {
            return n2;
        }
        try {
            final Cursor cursor2 = cursor = (rawQuery = code.rawQuery("SELECT COUNT(*) from hits2", (String[])null));
            if (cursor2.moveToFirst()) {
                rawQuery = cursor2;
                cursor = cursor2;
                n = (int)cursor2.getLong(0);
            }
            n2 = n;
            return n;
        }
        catch (SQLiteException cursor) {
            cursor = rawQuery;
            ae.C("Error getting numStoredHits");
            return 0;
        }
        finally {
            if (cursor != null) {
                cursor.close();
            }
        }
    }
    
    @Override
    public final void Code() {
        boolean b = true;
        final SQLiteDatabase code = this.Code("Error opening database for clearHits");
        if (code != null) {
            if (0L == 0L) {
                code.delete("hits2", (String)null, (String[])null);
            }
            else {
                code.delete("hits2", "hit_app_id = ?", new String[] { Long.valueOf(0L).toString() });
            }
            final Object j = this.J;
            if (this.J() != 0) {
                b = false;
            }
            j.Code(b);
        }
    }
    
    @Override
    public final void Code(final Map map, long long1, final String s, Collection o) {
        boolean b = true;
        final long code = this.b.Code();
        while (true) {
            Label_0389: {
                Object o2 = null;
                String s2 = null;
                Label_0394: {
                Label_0171_Outer:
                    while (true) {
                        Label_0102: {
                            if (code <= this.a + 86400000L) {
                                break Label_0102;
                            }
                            this.a = code;
                            final SQLiteDatabase code2 = this.Code("Error opening database for deleteStaleHits");
                            if (code2 == null) {
                                break Label_0102;
                            }
                            code2.delete("hits2", "HIT_TIME < ?", new String[] { Long.toString(this.b.Code() - 2592000000L) });
                            o2 = this.J;
                            if (this.J() != 0) {
                                break Label_0171_Outer;
                            }
                            ((e.e$Code)o2).Code(b);
                        }
                        o2 = ((Collection<B>)o).iterator();
                    Label_0171:
                        while (true) {
                            Label_0368: {
                                while (((Iterator)o2).hasNext()) {
                                    o = ((Iterator<B>)o2).next();
                                    if (((B)o).Code().equals("appendVersion")) {
                                        final String z = ((B)o).Z();
                                        o2 = ((B)o).I();
                                        if (z == null) {
                                            o = "";
                                            break Label_0171;
                                        }
                                        break Label_0368;
                                    }
                                }
                                Label_0187: {
                                    break Label_0187;
                                    if (o2 != null) {
                                        map.put(o2, o);
                                    }
                                }
                                final int n = this.J() - 2000 + 1;
                                if (n > 0) {
                                    final List code3 = this.Code(n);
                                    ae.a("Store full, deleting " + code3.size() + " hits to make room");
                                    this.Code(code3);
                                }
                                o = this.Code("Error opening database for putHit");
                                if (o == null) {
                                    return;
                                }
                                o2 = new ContentValues();
                                ((ContentValues)o2).put("hit_string", Code(map));
                                ((ContentValues)o2).put("hit_time", Long.valueOf(long1));
                                if (!map.containsKey("AppUID")) {
                                    break Label_0389;
                                }
                                try {
                                    long1 = Long.parseLong(map.get("AppUID"));
                                    ((ContentValues)o2).put("hit_app_id", Long.valueOf(long1));
                                    s2 = s;
                                    if (s == null) {
                                        s2 = "http://www.google-analytics.com/collect";
                                    }
                                    if (s2.length() == 0) {
                                        ae.C("empty path: not sending hit");
                                        return;
                                    }
                                    break Label_0394;
                                    final String z;
                                    o = new StringBuilder().append(z).toString();
                                    continue Label_0171;
                                    b = false;
                                    continue Label_0171_Outer;
                                }
                                catch (NumberFormatException ex) {}
                            }
                            break;
                        }
                        break;
                    }
                    break Label_0389;
                }
                ((ContentValues)o2).put("hit_url", s2);
                try {
                    ((SQLiteDatabase)o).insert("hits2", (String)null, (ContentValues)o2);
                    this.J.Code(false);
                    return;
                }
                catch (SQLiteException ex2) {
                    ae.C("Error storing hit");
                    return;
                }
            }
            long1 = 0L;
            continue;
        }
    }
    
    @Override
    public final void I() {
        ae.B("dispatch running...");
        if (this.Z.Code()) {
            final List code = this.Code(40);
            if (code.isEmpty()) {
                ae.B("...nothing to dispatch");
                this.J.Code(true);
                return;
            }
            final int code2 = this.Z.Code(code);
            ae.B("sent " + code2 + " of " + code.size() + " hits");
            this.Code(code.subList(0, Math.min(code2, code.size())));
            if (code2 == code.size() && this.J() > 0) {
                e.Code().Z();
            }
        }
    }
}
