// 
// Decompiled by Procyon v0.6-prerelease
// 

package com.admarvel.android.ads;

import android.annotation.TargetApi;
import android.net.Uri;
import android.database.Cursor;
import android.content.ContentResolver;
import java.util.TimeZone;
import android.provider.CalendarContract$Reminders;
import android.provider.CalendarContract$Events;
import android.content.ContentValues;
import android.provider.CalendarContract$Calendars;
import android.content.Context;
import java.lang.ref.WeakReference;
import java.text.SimpleDateFormat;

class r$e implements Runnable
{
    SimpleDateFormat a;
    Long b;
    Long c;
    String d;
    String e;
    String f;
    String g;
    String h;
    String i;
    String j;
    String k;
    int l;
    int m;
    int n;
    private final WeakReference o;
    private final WeakReference p;
    
    public r$e(final d d, final Context context, final String s, final String d2, final String e) {
        this.a = new SimpleDateFormat("yyyyMMddhhmm");
        this.b = null;
        this.c = null;
        this.l = 1;
        this.m = 0;
        this.n = 0;
        this.o = new WeakReference((T)context);
        this.p = new WeakReference((T)d);
        Label_0110: {
            if (s == null) {
                break Label_0110;
            }
            try {
                this.b = this.a.parse(s).getTime();
                this.c = this.a.parse(s).getTime() + 3600000L;
                this.d = d2;
                this.e = e;
            }
            catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
    
    public r$e(final d d, final Context context, final String s, final String d2, final String e, final String f, final String g, final String s2, final int n) {
        this.a = new SimpleDateFormat("yyyyMMddhhmm");
        this.b = null;
        this.c = null;
        this.l = 1;
        this.m = 0;
        this.n = 0;
        this.o = new WeakReference((T)context);
        this.p = new WeakReference((T)d);
        while (true) {
            if (s != null) {
                try {
                    this.b = this.a.parse(s).getTime();
                    if (s2 != null) {
                        this.c = this.a.parse(s2).getTime();
                    }
                    else {
                        this.c = this.a.parse(s).getTime() + 3600000L;
                    }
                    this.d = d2;
                    this.e = e;
                    this.f = f;
                    this.g = g;
                    if (n <= 0) {
                        this.l = n / 60;
                    }
                }
                catch (Exception ex) {
                    ex.printStackTrace();
                }
                return;
            }
            continue;
        }
    }
    
    public r$e(final d p0, final Context p1, final String p2, final String p3, final String p4, final String p5, final String p6, final String p7, final int p8, final String p9, final String p10, final String p11, final String p12, final int p13, final int p14, final String p15) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: invokespecial   java/lang/Object.<init>:()V
        //     4: aload_0        
        //     5: new             Ljava/text/SimpleDateFormat;
        //     8: dup            
        //     9: ldc             "yyyyMMddhhmm"
        //    11: invokespecial   java/text/SimpleDateFormat.<init>:(Ljava/lang/String;)V
        //    14: putfield        com/admarvel/android/ads/r$e.a:Ljava/text/SimpleDateFormat;
        //    17: aload_0        
        //    18: aconst_null    
        //    19: putfield        com/admarvel/android/ads/r$e.b:Ljava/lang/Long;
        //    22: aload_0        
        //    23: aconst_null    
        //    24: putfield        com/admarvel/android/ads/r$e.c:Ljava/lang/Long;
        //    27: aload_0        
        //    28: iconst_1       
        //    29: putfield        com/admarvel/android/ads/r$e.l:I
        //    32: aload_0        
        //    33: iconst_0       
        //    34: putfield        com/admarvel/android/ads/r$e.m:I
        //    37: aload_0        
        //    38: iconst_0       
        //    39: putfield        com/admarvel/android/ads/r$e.n:I
        //    42: aload_0        
        //    43: new             Ljava/lang/ref/WeakReference;
        //    46: dup            
        //    47: aload_2        
        //    48: invokespecial   java/lang/ref/WeakReference.<init>:(Ljava/lang/Object;)V
        //    51: putfield        com/admarvel/android/ads/r$e.o:Ljava/lang/ref/WeakReference;
        //    54: aload_0        
        //    55: new             Ljava/lang/ref/WeakReference;
        //    58: dup            
        //    59: aload_1        
        //    60: invokespecial   java/lang/ref/WeakReference.<init>:(Ljava/lang/Object;)V
        //    63: putfield        com/admarvel/android/ads/r$e.p:Ljava/lang/ref/WeakReference;
        //    66: aload_3        
        //    67: ifnull          88
        //    70: aload_0        
        //    71: aload_0        
        //    72: getfield        com/admarvel/android/ads/r$e.a:Ljava/text/SimpleDateFormat;
        //    75: aload_3        
        //    76: invokevirtual   java/text/SimpleDateFormat.parse:(Ljava/lang/String;)Ljava/util/Date;
        //    79: invokevirtual   java/util/Date.getTime:()J
        //    82: invokestatic    java/lang/Long.valueOf:(J)Ljava/lang/Long;
        //    85: putfield        com/admarvel/android/ads/r$e.b:Ljava/lang/Long;
        //    88: aload           8
        //    90: ifnull          277
        //    93: aload_0        
        //    94: aload_0        
        //    95: getfield        com/admarvel/android/ads/r$e.a:Ljava/text/SimpleDateFormat;
        //    98: aload           8
        //   100: invokevirtual   java/text/SimpleDateFormat.parse:(Ljava/lang/String;)Ljava/util/Date;
        //   103: invokevirtual   java/util/Date.getTime:()J
        //   106: invokestatic    java/lang/Long.valueOf:(J)Ljava/lang/Long;
        //   109: putfield        com/admarvel/android/ads/r$e.c:Ljava/lang/Long;
        //   112: aload_0        
        //   113: aload           4
        //   115: putfield        com/admarvel/android/ads/r$e.d:Ljava/lang/String;
        //   118: aload_0        
        //   119: aload           5
        //   121: putfield        com/admarvel/android/ads/r$e.e:Ljava/lang/String;
        //   124: aload_0        
        //   125: aload           6
        //   127: putfield        com/admarvel/android/ads/r$e.f:Ljava/lang/String;
        //   130: aload_0        
        //   131: aload           7
        //   133: putfield        com/admarvel/android/ads/r$e.g:Ljava/lang/String;
        //   136: iload           9
        //   138: ifgt            150
        //   141: aload_0        
        //   142: iload           9
        //   144: bipush          60
        //   146: idiv           
        //   147: putfield        com/admarvel/android/ads/r$e.l:I
        //   150: aload           10
        //   152: ifnull          246
        //   155: aload           10
        //   157: invokevirtual   java/lang/String.length:()I
        //   160: istore          9
        //   162: iload           9
        //   164: ifle            246
        //   167: iconst_0       
        //   168: istore          17
        //   170: aload           10
        //   172: ldc             ":"
        //   174: invokevirtual   java/lang/String.split:(Ljava/lang/String;)[Ljava/lang/String;
        //   177: astore_1       
        //   178: aload_1        
        //   179: arraylength    
        //   180: iconst_2       
        //   181: if_icmpne       350
        //   184: aload_1        
        //   185: iconst_0       
        //   186: aaload         
        //   187: ldc             "+"
        //   189: invokevirtual   java/lang/String.startsWith:(Ljava/lang/String;)Z
        //   192: ifeq            308
        //   195: aload_1        
        //   196: iconst_0       
        //   197: aaload         
        //   198: iconst_1       
        //   199: invokevirtual   java/lang/String.substring:(I)Ljava/lang/String;
        //   202: invokestatic    java/lang/Integer.parseInt:(Ljava/lang/String;)I
        //   205: bipush          60
        //   207: imul           
        //   208: aload_1        
        //   209: iconst_1       
        //   210: aaload         
        //   211: invokestatic    java/lang/Integer.parseInt:(Ljava/lang/String;)I
        //   214: iadd           
        //   215: istore          9
        //   217: iload           9
        //   219: bipush          60
        //   221: imul           
        //   222: sipush          1000
        //   225: imul           
        //   226: invokestatic    java/util/TimeZone.getAvailableIDs:(I)[Ljava/lang/String;
        //   229: astore_1       
        //   230: aload_1        
        //   231: ifnull          246
        //   234: aload_1        
        //   235: arraylength    
        //   236: ifle            246
        //   239: aload_0        
        //   240: aload_1        
        //   241: iconst_0       
        //   242: aaload         
        //   243: putfield        com/admarvel/android/ads/r$e.h:Ljava/lang/String;
        //   246: aload_0        
        //   247: aload           12
        //   249: putfield        com/admarvel/android/ads/r$e.i:Ljava/lang/String;
        //   252: aload_0        
        //   253: aload           13
        //   255: putfield        com/admarvel/android/ads/r$e.j:Ljava/lang/String;
        //   258: aload_0        
        //   259: aload           16
        //   261: putfield        com/admarvel/android/ads/r$e.k:Ljava/lang/String;
        //   264: aload_0        
        //   265: iload           14
        //   267: putfield        com/admarvel/android/ads/r$e.m:I
        //   270: aload_0        
        //   271: iload           15
        //   273: putfield        com/admarvel/android/ads/r$e.n:I
        //   276: return         
        //   277: aload_0        
        //   278: aload_0        
        //   279: getfield        com/admarvel/android/ads/r$e.a:Ljava/text/SimpleDateFormat;
        //   282: aload_3        
        //   283: invokevirtual   java/text/SimpleDateFormat.parse:(Ljava/lang/String;)Ljava/util/Date;
        //   286: invokevirtual   java/util/Date.getTime:()J
        //   289: ldc2_w          3600000
        //   292: ladd           
        //   293: invokestatic    java/lang/Long.valueOf:(J)Ljava/lang/Long;
        //   296: putfield        com/admarvel/android/ads/r$e.c:Ljava/lang/Long;
        //   299: goto            112
        //   302: astore_1       
        //   303: aload_1        
        //   304: invokevirtual   java/lang/Exception.printStackTrace:()V
        //   307: return         
        //   308: iload           17
        //   310: istore          9
        //   312: aload_1        
        //   313: iconst_0       
        //   314: aaload         
        //   315: ldc             "-"
        //   317: invokevirtual   java/lang/String.startsWith:(Ljava/lang/String;)Z
        //   320: ifeq            217
        //   323: aload_1        
        //   324: iconst_0       
        //   325: aaload         
        //   326: iconst_1       
        //   327: invokevirtual   java/lang/String.substring:(I)Ljava/lang/String;
        //   330: invokestatic    java/lang/Integer.parseInt:(Ljava/lang/String;)I
        //   333: bipush          60
        //   335: imul           
        //   336: aload_1        
        //   337: iconst_1       
        //   338: aaload         
        //   339: invokestatic    java/lang/Integer.parseInt:(Ljava/lang/String;)I
        //   342: iadd           
        //   343: iconst_m1      
        //   344: imul           
        //   345: istore          9
        //   347: goto            217
        //   350: iload           17
        //   352: istore          9
        //   354: aload_1        
        //   355: arraylength    
        //   356: iconst_1       
        //   357: if_icmpne       217
        //   360: aload_1        
        //   361: iconst_0       
        //   362: aaload         
        //   363: ldc             "+"
        //   365: invokevirtual   java/lang/String.startsWith:(Ljava/lang/String;)Z
        //   368: ifeq            389
        //   371: aload_1        
        //   372: iconst_0       
        //   373: aaload         
        //   374: iconst_1       
        //   375: invokevirtual   java/lang/String.substring:(I)Ljava/lang/String;
        //   378: invokestatic    java/lang/Integer.parseInt:(Ljava/lang/String;)I
        //   381: bipush          60
        //   383: imul           
        //   384: istore          9
        //   386: goto            217
        //   389: iload           17
        //   391: istore          9
        //   393: aload_1        
        //   394: iconst_0       
        //   395: aaload         
        //   396: ldc             "-"
        //   398: invokevirtual   java/lang/String.startsWith:(Ljava/lang/String;)Z
        //   401: ifeq            217
        //   404: aload_1        
        //   405: iconst_0       
        //   406: aaload         
        //   407: iconst_1       
        //   408: invokevirtual   java/lang/String.substring:(I)Ljava/lang/String;
        //   411: invokestatic    java/lang/Integer.parseInt:(Ljava/lang/String;)I
        //   414: istore          9
        //   416: iload           9
        //   418: bipush          60
        //   420: imul           
        //   421: iconst_m1      
        //   422: imul           
        //   423: istore          9
        //   425: goto            217
        //   428: astore_1       
        //   429: aload_1        
        //   430: invokevirtual   java/lang/Exception.printStackTrace:()V
        //   433: goto            246
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                 
        //  -----  -----  -----  -----  ---------------------
        //  70     88     302    308    Ljava/lang/Exception;
        //  93     112    302    308    Ljava/lang/Exception;
        //  112    136    302    308    Ljava/lang/Exception;
        //  141    150    302    308    Ljava/lang/Exception;
        //  155    162    302    308    Ljava/lang/Exception;
        //  170    217    428    436    Ljava/lang/Exception;
        //  217    230    428    436    Ljava/lang/Exception;
        //  234    246    428    436    Ljava/lang/Exception;
        //  246    276    302    308    Ljava/lang/Exception;
        //  277    299    302    308    Ljava/lang/Exception;
        //  312    347    428    436    Ljava/lang/Exception;
        //  354    386    428    436    Ljava/lang/Exception;
        //  393    416    428    436    Ljava/lang/Exception;
        //  429    433    302    308    Ljava/lang/Exception;
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0217:
        //     at com.strobel.decompiler.ast.Error.expressionLinkedFromMultipleLocations(Error.java:27)
        //     at com.strobel.decompiler.ast.AstOptimizer.mergeDisparateObjectInitializations(AstOptimizer.java:2604)
        //     at com.strobel.decompiler.ast.AstOptimizer.optimize(AstOptimizer.java:235)
        //     at com.strobel.decompiler.ast.AstOptimizer.optimize(AstOptimizer.java:42)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:209)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:94)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethodBody(AstBuilder.java:840)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createConstructor(AstBuilder.java:771)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addTypeMembers(AstBuilder.java:607)
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
    
    @TargetApi(14)
    @Override
    public void run() {
        final Context context = (Context)this.o.get();
        final d d = (d)this.p.get();
        if (context != null && d != null) {
            final ContentResolver contentResolver = context.getContentResolver();
            while (true) {
                try {
                    Cursor query = contentResolver.query(CalendarContract$Calendars.CONTENT_URI, new String[] { "_id", "calendar_displayName" }, (String)null, (String[])null, (String)null);
                    Object o;
                    String[] array;
                    int[] array2;
                    int n;
                    ContentValues contentValues;
                    Uri insert;
                    ContentValues contentValues2;
                    Block_36_Outer:Block_35_Outer:
                    while (true) {
                        Label_0837: {
                            if (query == null) {
                                break Label_0837;
                            }
                            o = query;
                            Label_0764: {
                                try {
                                    if (query.moveToFirst()) {
                                        o = query;
                                        array = new String[query.getCount()];
                                        o = query;
                                        array2 = new int[query.getCount()];
                                        n = 0;
                                        while (true) {
                                            o = query;
                                            if (n >= array.length) {
                                                break;
                                            }
                                            o = query;
                                            array2[n] = query.getInt(0);
                                            o = query;
                                            array[n] = query.getString(1);
                                            o = query;
                                            query.moveToNext();
                                            ++n;
                                        }
                                        o = query;
                                        contentValues = new ContentValues();
                                        o = query;
                                        contentValues.put("calendar_id", Integer.valueOf(array2[0]));
                                        o = query;
                                        if (this.d != null) {
                                            o = query;
                                            contentValues.put("title", this.d);
                                        }
                                        o = query;
                                        if (this.e != null) {
                                            o = query;
                                            contentValues.put("description", this.e);
                                        }
                                        o = query;
                                        if (this.f != null) {
                                            o = query;
                                            contentValues.put("eventLocation", this.f);
                                        }
                                        o = query;
                                        if (this.b != null) {
                                            o = query;
                                            contentValues.put("dtstart", this.b);
                                        }
                                        o = query;
                                        if (this.c != null) {
                                            o = query;
                                            contentValues.put("dtend", this.c);
                                        }
                                        o = query;
                                        Label_0351: {
                                            if (this.g != null) {
                                                o = query;
                                                if (!this.g.toLowerCase().equals("true")) {
                                                    o = query;
                                                    if (!this.g.toLowerCase().equals("yes")) {
                                                        break Label_0351;
                                                    }
                                                }
                                                o = query;
                                                contentValues.put("allDay", Integer.valueOf(1));
                                            }
                                        }
                                        o = query;
                                        if (this.l <= 0) {
                                            o = query;
                                            contentValues.put("hasAlarm", Integer.valueOf(1));
                                        }
                                        o = query;
                                        while (true) {
                                            Label_0675: {
                                                if (this.h == null) {
                                                    break Label_0675;
                                                }
                                                o = query;
                                                if (this.h.length() <= 0) {
                                                    break Label_0675;
                                                }
                                                o = query;
                                                contentValues.put("eventTimezone", this.h);
                                                o = query;
                                                if (this.i != null) {
                                                    o = query;
                                                    if (this.i.length() > 0) {
                                                        o = query;
                                                        contentValues.put("rrule", this.i);
                                                    }
                                                }
                                                o = query;
                                                if (this.j != null) {
                                                    o = query;
                                                    if (this.j.length() > 0) {
                                                        o = query;
                                                        contentValues.put("exdate", this.j);
                                                    }
                                                }
                                                o = query;
                                                contentValues.put("eventStatus", Integer.valueOf(this.m));
                                                o = query;
                                                contentValues.put("availability", Integer.valueOf(this.n));
                                                o = query;
                                                insert = contentResolver.insert(CalendarContract$Events.CONTENT_URI, contentValues);
                                                if (insert == null) {
                                                    break Label_0764;
                                                }
                                                o = query;
                                                if (this.l <= 0) {
                                                    o = query;
                                                    contentValues2 = new ContentValues();
                                                    o = query;
                                                    contentValues2.put("event_id", Long.valueOf(Long.parseLong(insert.getLastPathSegment())));
                                                    o = query;
                                                    contentValues2.put("method", Integer.valueOf(1));
                                                    o = query;
                                                    contentValues2.put("minutes", Integer.valueOf(Math.abs(this.l)));
                                                    o = query;
                                                    contentResolver.insert(CalendarContract$Reminders.CONTENT_URI, contentValues2);
                                                }
                                                o = query;
                                                if (this.k != null) {
                                                    o = query;
                                                    if (this.k.length() > 0) {
                                                        o = query;
                                                        d.e(this.k + "(\"YES\")");
                                                    }
                                                }
                                                if (query != null) {
                                                    query.close();
                                                    return;
                                                }
                                                return;
                                            }
                                            o = query;
                                            contentValues.put("eventTimezone", TimeZone.getDefault().getID());
                                            continue;
                                        }
                                    }
                                    break Label_0837;
                                }
                                catch (Exception ex) {
                                    o = query;
                                    ((Throwable)contentResolver).printStackTrace();
                                    o = query;
                                    if (this.k != null) {
                                        o = query;
                                        if (this.k.length() > 0) {
                                            o = query;
                                            d.e(this.k + "(\"NO\")");
                                        }
                                    }
                                    if (query != null) {
                                        query.close();
                                        return;
                                    }
                                    return;
                                    while (true) {
                                        while (true) {
                                            o = query;
                                            d.e(this.k + "(\"NO\")");
                                            continue Block_36_Outer;
                                            o = query;
                                            iftrue(Label_0664:)(this.k.length() <= 0);
                                            continue Block_35_Outer;
                                        }
                                        o = query;
                                        iftrue(Label_0664:)(this.k == null);
                                        continue;
                                    }
                                }
                                finally {
                                    query = (Cursor)o;
                                    o = contentResolver;
                                }
                            }
                            if (query != null) {
                                query.close();
                            }
                            throw o;
                        }
                        o = query;
                        if (this.k == null) {
                            continue;
                        }
                        o = query;
                        if (this.k.length() > 0) {
                            o = query;
                            d.e(this.k + "(\"NO\")");
                            continue;
                        }
                        continue;
                    }
                }
                catch (Exception contentResolver) {}
                finally {
                    final Cursor query = null;
                    continue;
                }
                break;
            }
        }
    }
}
