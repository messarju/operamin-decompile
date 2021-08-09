// 
// Decompiled by Procyon v0.6-prerelease
// 

package com.opera.mini.android;

import android.content.SharedPreferences;
import android.webkit.WebView;
import android.os.Build;
import java.io.FileInputStream;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager$NameNotFoundException;
import java.security.cert.CertificateException;
import java.security.NoSuchAlgorithmException;
import java.math.BigInteger;
import java.io.ByteArrayInputStream;
import java.security.cert.Certificate;
import java.security.MessageDigest;
import java.security.cert.CertificateFactory;
import java.io.OutputStream;
import java.io.InputStream;
import java.io.IOException;
import java.io.Closeable;
import android.content.Intent;
import android.app.ActivityManager$MemoryInfo;
import android.app.ActivityManager;
import java.util.Locale;
import java.security.SecureRandom;
import android.content.SharedPreferences$Editor;
import java.io.File;
import android.content.Context;
import android.os.Build$VERSION;
import android.util.DisplayMetrics;

public class x extends cg
{
    public static DisplayMetrics ag;
    public static String ah;
    public static String ai;
    public static long aj;
    public static int ak;
    public static boolean al;
    public static boolean am;
    private static long an;
    private static float ao;
    private static float ap;
    private static String aq;
    private static String ar;
    private static String as;
    private static String at;
    private static String au;
    private static String av;
    private static Object aw;
    
    static {
        boolean b;
        boolean al;
        boolean am;
        Label_0048_Outer:Label_0062_Outer:
        while (true) {
            b = true;
            x.ao = 0.0f;
            x.ap = 0.0f;
            x.aq = null;
            x.ar = null;
            x.as = null;
            x.at = null;
            x.au = null;
            while (true) {
            Label_0090:
                while (true) {
                    while (true) {
                        try {
                            x.ak = Integer.parseInt(Build$VERSION.SDK);
                            if (x.ak >= 4) {
                                al = true;
                                x.al = al;
                                if (x.ak >= 9) {
                                    am = b;
                                    x.am = am;
                                    x.aw = new Object();
                                    return;
                                }
                                break Label_0090;
                            }
                        }
                        catch (Throwable t) {
                            x.ak = 3;
                            continue Label_0048_Outer;
                        }
                        break;
                    }
                    al = false;
                    continue Label_0062_Outer;
                }
                am = false;
                continue;
            }
        }
    }
    
    private static boolean B(final Context context) {
        try {
            if (I(context) != null) {
                return true;
            }
        }
        catch (Exception ex) {}
        return false;
    }
    
    public static y Code(final String p0, final String p1, final File p2) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: astore          4
        //     3: aconst_null    
        //     4: astore_3       
        //     5: new             Ljava/util/zip/ZipFile;
        //     8: dup            
        //     9: aload_0        
        //    10: invokespecial   java/util/zip/ZipFile.<init>:(Ljava/lang/String;)V
        //    13: astore_0       
        //    14: aload_0        
        //    15: aload_1        
        //    16: invokevirtual   java/util/zip/ZipFile.getEntry:(Ljava/lang/String;)Ljava/util/zip/ZipEntry;
        //    19: astore_1       
        //    20: aload_2        
        //    21: invokevirtual   java/io/File.getParentFile:()Ljava/io/File;
        //    24: astore          5
        //    26: aload_1        
        //    27: invokevirtual   java/util/zip/ZipEntry.getSize:()J
        //    30: aload           5
        //    32: invokevirtual   java/io/File.getPath:()Ljava/lang/String;
        //    35: invokestatic    com/opera/mini/android/d.a:(Ljava/lang/String;)J
        //    38: lcmp           
        //    39: ifle            60
        //    42: getstatic       com/opera/mini/android/y.Z:Lcom/opera/mini/android/y;
        //    45: astore_1       
        //    46: aconst_null    
        //    47: invokestatic    com/opera/mini/android/x.Code:(Ljava/io/Closeable;)V
        //    50: aconst_null    
        //    51: invokestatic    com/opera/mini/android/x.Code:(Ljava/io/Closeable;)V
        //    54: aload_0        
        //    55: invokevirtual   java/util/zip/ZipFile.close:()V
        //    58: aload_1        
        //    59: areturn        
        //    60: aload_2        
        //    61: invokevirtual   java/io/File.createNewFile:()Z
        //    64: pop            
        //    65: aload_0        
        //    66: aload_1        
        //    67: invokevirtual   java/util/zip/ZipFile.getInputStream:(Ljava/util/zip/ZipEntry;)Ljava/io/InputStream;
        //    70: astore_1       
        //    71: new             Ljava/io/FileOutputStream;
        //    74: dup            
        //    75: aload_2        
        //    76: invokespecial   java/io/FileOutputStream.<init>:(Ljava/io/File;)V
        //    79: astore_2       
        //    80: aload_1        
        //    81: aload_2        
        //    82: invokestatic    com/opera/mini/android/x.Code:(Ljava/io/InputStream;Ljava/io/OutputStream;)V
        //    85: getstatic       com/opera/mini/android/y.Code:Lcom/opera/mini/android/y;
        //    88: astore_3       
        //    89: aload_1        
        //    90: invokestatic    com/opera/mini/android/x.Code:(Ljava/io/Closeable;)V
        //    93: aload_2        
        //    94: invokestatic    com/opera/mini/android/x.Code:(Ljava/io/Closeable;)V
        //    97: aload_0        
        //    98: invokevirtual   java/util/zip/ZipFile.close:()V
        //   101: aload_3        
        //   102: areturn        
        //   103: astore_0       
        //   104: aload_3        
        //   105: areturn        
        //   106: astore_0       
        //   107: aconst_null    
        //   108: astore_0       
        //   109: aconst_null    
        //   110: astore_1       
        //   111: aload_3        
        //   112: astore_2       
        //   113: aload_1        
        //   114: invokestatic    com/opera/mini/android/x.Code:(Ljava/io/Closeable;)V
        //   117: aload_2        
        //   118: invokestatic    com/opera/mini/android/x.Code:(Ljava/io/Closeable;)V
        //   121: aload_0        
        //   122: ifnull          129
        //   125: aload_0        
        //   126: invokevirtual   java/util/zip/ZipFile.close:()V
        //   129: getstatic       com/opera/mini/android/y.I:Lcom/opera/mini/android/y;
        //   132: areturn        
        //   133: astore_2       
        //   134: aconst_null    
        //   135: astore_0       
        //   136: aconst_null    
        //   137: astore_1       
        //   138: aload           4
        //   140: astore_3       
        //   141: aload_1        
        //   142: invokestatic    com/opera/mini/android/x.Code:(Ljava/io/Closeable;)V
        //   145: aload_3        
        //   146: invokestatic    com/opera/mini/android/x.Code:(Ljava/io/Closeable;)V
        //   149: aload_0        
        //   150: ifnull          157
        //   153: aload_0        
        //   154: invokevirtual   java/util/zip/ZipFile.close:()V
        //   157: aload_2        
        //   158: athrow         
        //   159: astore_0       
        //   160: aload_1        
        //   161: areturn        
        //   162: astore_0       
        //   163: goto            129
        //   166: astore_0       
        //   167: goto            157
        //   170: astore_2       
        //   171: aconst_null    
        //   172: astore_1       
        //   173: aload           4
        //   175: astore_3       
        //   176: goto            141
        //   179: astore_2       
        //   180: aload           4
        //   182: astore_3       
        //   183: goto            141
        //   186: astore          4
        //   188: aload_2        
        //   189: astore_3       
        //   190: aload           4
        //   192: astore_2       
        //   193: goto            141
        //   196: astore_1       
        //   197: aconst_null    
        //   198: astore_1       
        //   199: aload_3        
        //   200: astore_2       
        //   201: goto            113
        //   204: astore_2       
        //   205: aload_3        
        //   206: astore_2       
        //   207: goto            113
        //   210: astore_3       
        //   211: goto            113
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                 
        //  -----  -----  -----  -----  ---------------------
        //  5      14     106    113    Ljava/io/IOException;
        //  5      14     133    141    Any
        //  14     46     196    204    Ljava/io/IOException;
        //  14     46     170    179    Any
        //  54     58     159    162    Ljava/io/IOException;
        //  60     71     196    204    Ljava/io/IOException;
        //  60     71     170    179    Any
        //  71     80     204    210    Ljava/io/IOException;
        //  71     80     179    186    Any
        //  80     89     210    214    Ljava/io/IOException;
        //  80     89     186    196    Any
        //  97     101    103    106    Ljava/io/IOException;
        //  125    129    162    166    Ljava/io/IOException;
        //  153    157    166    170    Ljava/io/IOException;
        // 
        // The error that occurred was:
        // 
        // java.lang.IndexOutOfBoundsException: Index: 130, Size: 130
        //     at java.util.ArrayList.rangeCheck(ArrayList.java:659)
        //     at java.util.ArrayList.get(ArrayList.java:435)
        //     at com.strobel.decompiler.ast.AstBuilder.convertToAst(AstBuilder.java:3379)
        //     at com.strobel.decompiler.ast.AstBuilder.convertToAst(AstBuilder.java:3493)
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
    
    public static String Code(final Context p0) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: astore          5
        //     3: aconst_null    
        //     4: astore          6
        //     6: getstatic       com/opera/mini/android/x.aq:Ljava/lang/String;
        //     9: ifnull          16
        //    12: getstatic       com/opera/mini/android/x.aq:Ljava/lang/String;
        //    15: areturn        
        //    16: aload_0        
        //    17: invokestatic    com/opera/mini/android/x.B:(Landroid/content/Context;)Z
        //    20: ifeq            185
        //    23: ldc             "content://com.opera.branding.BrandingProvider/branding/1"
        //    25: invokestatic    android/net/Uri.parse:(Ljava/lang/String;)Landroid/net/Uri;
        //    28: astore          4
        //    30: aload_0        
        //    31: invokevirtual   android/content/Context.getContentResolver:()Landroid/content/ContentResolver;
        //    34: aload           4
        //    36: aconst_null    
        //    37: aconst_null    
        //    38: aconst_null    
        //    39: aconst_null    
        //    40: invokevirtual   android/content/ContentResolver.query:(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
        //    43: astore          4
        //    45: aload           4
        //    47: ifnull          185
        //    50: aload           4
        //    52: invokeinterface android/database/Cursor.moveToFirst:()Z
        //    57: ifeq            178
        //    60: iconst_0       
        //    61: istore_2       
        //    62: iload_2        
        //    63: istore_1       
        //    64: aload           4
        //    66: aload           4
        //    68: ldc             "Branding"
        //    70: invokeinterface android/database/Cursor.getColumnIndexOrThrow:(Ljava/lang/String;)I
        //    75: invokeinterface android/database/Cursor.getString:(I)Ljava/lang/String;
        //    80: putstatic       com/opera/mini/android/x.aq:Ljava/lang/String;
        //    83: iload_2        
        //    84: istore_1       
        //    85: aload           4
        //    87: aload           4
        //    89: ldc             "Signature"
        //    91: invokeinterface android/database/Cursor.getColumnIndexOrThrow:(Ljava/lang/String;)I
        //    96: invokeinterface android/database/Cursor.getString:(I)Ljava/lang/String;
        //   101: putstatic       com/opera/mini/android/x.ar:Ljava/lang/String;
        //   104: iconst_1       
        //   105: istore_2       
        //   106: iload_2        
        //   107: istore_1       
        //   108: aload           4
        //   110: aload           4
        //   112: ldc             "HomescreenTitle"
        //   114: invokeinterface android/database/Cursor.getColumnIndexOrThrow:(Ljava/lang/String;)I
        //   119: invokeinterface android/database/Cursor.getString:(I)Ljava/lang/String;
        //   124: putstatic       com/opera/mini/android/x.as:Ljava/lang/String;
        //   127: iload_2        
        //   128: istore_1       
        //   129: aload           4
        //   131: aload           4
        //   133: ldc             "HomescreenUrl"
        //   135: invokeinterface android/database/Cursor.getColumnIndexOrThrow:(Ljava/lang/String;)I
        //   140: invokeinterface android/database/Cursor.getString:(I)Ljava/lang/String;
        //   145: putstatic       com/opera/mini/android/x.at:Ljava/lang/String;
        //   148: iload_2        
        //   149: istore_1       
        //   150: aload           4
        //   152: ldc             "ChannelID"
        //   154: invokeinterface android/database/Cursor.getColumnIndex:(Ljava/lang/String;)I
        //   159: istore_3       
        //   160: iload_3        
        //   161: iconst_m1      
        //   162: if_icmpeq       178
        //   165: iload_2        
        //   166: istore_1       
        //   167: aload           4
        //   169: iload_3        
        //   170: invokeinterface android/database/Cursor.getString:(I)Ljava/lang/String;
        //   175: putstatic       com/opera/mini/android/x.au:Ljava/lang/String;
        //   178: aload           4
        //   180: invokeinterface android/database/Cursor.close:()V
        //   185: getstatic       com/opera/mini/android/x.aq:Ljava/lang/String;
        //   188: ifnonnull       325
        //   191: aload_0        
        //   192: invokestatic    com/opera/mini/android/x.J:(Landroid/content/Context;)[B
        //   195: astore          4
        //   197: aload           4
        //   199: ifnull          325
        //   202: new             Lorg/json/JSONTokener;
        //   205: dup            
        //   206: new             Ljava/lang/String;
        //   209: dup            
        //   210: aload           4
        //   212: invokespecial   java/lang/String.<init>:([B)V
        //   215: invokespecial   org/json/JSONTokener.<init>:(Ljava/lang/String;)V
        //   218: invokevirtual   org/json/JSONTokener.nextValue:()Ljava/lang/Object;
        //   221: checkcast       Lorg/json/JSONObject;
        //   224: astore          7
        //   226: aload           7
        //   228: ifnull          325
        //   231: aload           7
        //   233: ldc             "Branding"
        //   235: invokevirtual   org/json/JSONObject.getString:(Ljava/lang/String;)Ljava/lang/String;
        //   238: astore          4
        //   240: aload           4
        //   242: putstatic       com/opera/mini/android/x.aq:Ljava/lang/String;
        //   245: aload           4
        //   247: ldc             ""
        //   249: invokevirtual   java/lang/String.equals:(Ljava/lang/Object;)Z
        //   252: ifeq            623
        //   255: aconst_null    
        //   256: astore          4
        //   258: aload           4
        //   260: putstatic       com/opera/mini/android/x.aq:Ljava/lang/String;
        //   263: aload           7
        //   265: ldc             "Signature"
        //   267: invokevirtual   org/json/JSONObject.getString:(Ljava/lang/String;)Ljava/lang/String;
        //   270: putstatic       com/opera/mini/android/x.ar:Ljava/lang/String;
        //   273: aload           7
        //   275: ldc             "HomescreenTitle"
        //   277: invokevirtual   org/json/JSONObject.getString:(Ljava/lang/String;)Ljava/lang/String;
        //   280: putstatic       com/opera/mini/android/x.as:Ljava/lang/String;
        //   283: aload           7
        //   285: ldc             "HomescreenUrl"
        //   287: invokevirtual   org/json/JSONObject.getString:(Ljava/lang/String;)Ljava/lang/String;
        //   290: putstatic       com/opera/mini/android/x.at:Ljava/lang/String;
        //   293: aload           7
        //   295: ldc             "ChannelID"
        //   297: invokevirtual   org/json/JSONObject.getString:(Ljava/lang/String;)Ljava/lang/String;
        //   300: astore          4
        //   302: aload           4
        //   304: putstatic       com/opera/mini/android/x.au:Ljava/lang/String;
        //   307: aload           4
        //   309: ldc             ""
        //   311: invokevirtual   java/lang/String.equals:(Ljava/lang/Object;)Z
        //   314: ifeq            631
        //   317: aconst_null    
        //   318: astore          4
        //   320: aload           4
        //   322: putstatic       com/opera/mini/android/x.au:Ljava/lang/String;
        //   325: getstatic       com/opera/mini/android/x.aq:Ljava/lang/String;
        //   328: ifnull          648
        //   331: aload_0        
        //   332: invokestatic    com/opera/mini/android/ar.Code:(Landroid/content/Context;)Lcom/opera/mini/android/ar;
        //   335: astore          4
        //   337: getstatic       com/opera/mini/android/x.aq:Ljava/lang/String;
        //   340: ifnull          377
        //   343: getstatic       com/opera/mini/android/x.aq:Ljava/lang/String;
        //   346: ldc             ""
        //   348: invokevirtual   java/lang/String.equals:(Ljava/lang/Object;)Z
        //   351: ifne            377
        //   354: aload           4
        //   356: ldc             "Branding"
        //   358: invokevirtual   com/opera/mini/android/ar.Z:(Ljava/lang/String;)V
        //   361: aload           4
        //   363: ldc             "Branding"
        //   365: getstatic       com/opera/mini/android/x.aq:Ljava/lang/String;
        //   368: ldc             "utf-8"
        //   370: invokevirtual   java/lang/String.getBytes:(Ljava/lang/String;)[B
        //   373: invokevirtual   com/opera/mini/android/ar.Code:(Ljava/lang/String;[B)I
        //   376: pop            
        //   377: getstatic       com/opera/mini/android/x.ar:Ljava/lang/String;
        //   380: ifnull          417
        //   383: getstatic       com/opera/mini/android/x.ar:Ljava/lang/String;
        //   386: ldc             ""
        //   388: invokevirtual   java/lang/String.equals:(Ljava/lang/Object;)Z
        //   391: ifne            417
        //   394: aload           4
        //   396: ldc             "Signature"
        //   398: invokevirtual   com/opera/mini/android/ar.Z:(Ljava/lang/String;)V
        //   401: aload           4
        //   403: ldc             "Signature"
        //   405: getstatic       com/opera/mini/android/x.ar:Ljava/lang/String;
        //   408: ldc             "utf-8"
        //   410: invokevirtual   java/lang/String.getBytes:(Ljava/lang/String;)[B
        //   413: invokevirtual   com/opera/mini/android/ar.Code:(Ljava/lang/String;[B)I
        //   416: pop            
        //   417: getstatic       com/opera/mini/android/x.as:Ljava/lang/String;
        //   420: ifnull          457
        //   423: getstatic       com/opera/mini/android/x.as:Ljava/lang/String;
        //   426: ldc             ""
        //   428: invokevirtual   java/lang/String.equals:(Ljava/lang/Object;)Z
        //   431: ifne            457
        //   434: aload           4
        //   436: ldc             "HomescreenTitle"
        //   438: invokevirtual   com/opera/mini/android/ar.Z:(Ljava/lang/String;)V
        //   441: aload           4
        //   443: ldc             "HomescreenTitle"
        //   445: getstatic       com/opera/mini/android/x.as:Ljava/lang/String;
        //   448: ldc             "utf-8"
        //   450: invokevirtual   java/lang/String.getBytes:(Ljava/lang/String;)[B
        //   453: invokevirtual   com/opera/mini/android/ar.Code:(Ljava/lang/String;[B)I
        //   456: pop            
        //   457: getstatic       com/opera/mini/android/x.at:Ljava/lang/String;
        //   460: ifnull          497
        //   463: getstatic       com/opera/mini/android/x.at:Ljava/lang/String;
        //   466: ldc             ""
        //   468: invokevirtual   java/lang/String.equals:(Ljava/lang/Object;)Z
        //   471: ifne            497
        //   474: aload           4
        //   476: ldc             "HomescreenUrl"
        //   478: invokevirtual   com/opera/mini/android/ar.Z:(Ljava/lang/String;)V
        //   481: aload           4
        //   483: ldc             "HomescreenUrl"
        //   485: getstatic       com/opera/mini/android/x.at:Ljava/lang/String;
        //   488: ldc             "utf-8"
        //   490: invokevirtual   java/lang/String.getBytes:(Ljava/lang/String;)[B
        //   493: invokevirtual   com/opera/mini/android/ar.Code:(Ljava/lang/String;[B)I
        //   496: pop            
        //   497: getstatic       com/opera/mini/android/x.au:Ljava/lang/String;
        //   500: ifnull          537
        //   503: getstatic       com/opera/mini/android/x.au:Ljava/lang/String;
        //   506: ldc             ""
        //   508: invokevirtual   java/lang/String.equals:(Ljava/lang/Object;)Z
        //   511: ifne            537
        //   514: aload           4
        //   516: ldc             "ChannelID"
        //   518: invokevirtual   com/opera/mini/android/ar.Z:(Ljava/lang/String;)V
        //   521: aload           4
        //   523: ldc             "ChannelID"
        //   525: getstatic       com/opera/mini/android/x.au:Ljava/lang/String;
        //   528: ldc             "utf-8"
        //   530: invokevirtual   java/lang/String.getBytes:(Ljava/lang/String;)[B
        //   533: invokevirtual   com/opera/mini/android/ar.Code:(Ljava/lang/String;[B)I
        //   536: pop            
        //   537: getstatic       com/opera/mini/android/x.aq:Ljava/lang/String;
        //   540: ifnull          600
        //   543: getstatic       com/opera/mini/android/x.ar:Ljava/lang/String;
        //   546: ifnull          600
        //   549: aload           6
        //   551: astore          4
        //   553: aload_0        
        //   554: invokevirtual   android/content/Context.getAssets:()Landroid/content/res/AssetManager;
        //   557: ldc             "pub_key"
        //   559: invokevirtual   android/content/res/AssetManager.open:(Ljava/lang/String;)Ljava/io/InputStream;
        //   562: astore_0       
        //   563: aload_0        
        //   564: astore          4
        //   566: aload_0        
        //   567: astore          5
        //   569: aload_0        
        //   570: getstatic       com/opera/mini/android/x.aq:Ljava/lang/String;
        //   573: getstatic       com/opera/mini/android/x.ar:Ljava/lang/String;
        //   576: invokestatic    com/opera/mini/android/bu.Code:(Ljava/io/InputStream;Ljava/lang/String;Ljava/lang/String;)Z
        //   579: ifne            592
        //   582: aload_0        
        //   583: astore          4
        //   585: aload_0        
        //   586: astore          5
        //   588: aconst_null    
        //   589: putstatic       com/opera/mini/android/x.aq:Ljava/lang/String;
        //   592: aload_0        
        //   593: ifnull          600
        //   596: aload_0        
        //   597: invokevirtual   java/io/InputStream.close:()V
        //   600: getstatic       com/opera/mini/android/x.aq:Ljava/lang/String;
        //   603: ifnull          902
        //   606: getstatic       com/opera/mini/android/x.aq:Ljava/lang/String;
        //   609: areturn        
        //   610: astore          7
        //   612: iload_1        
        //   613: ifne            178
        //   616: aconst_null    
        //   617: putstatic       com/opera/mini/android/x.aq:Ljava/lang/String;
        //   620: goto            178
        //   623: getstatic       com/opera/mini/android/x.aq:Ljava/lang/String;
        //   626: astore          4
        //   628: goto            258
        //   631: getstatic       com/opera/mini/android/x.au:Ljava/lang/String;
        //   634: astore          4
        //   636: goto            320
        //   639: astore          4
        //   641: aconst_null    
        //   642: putstatic       com/opera/mini/android/x.aq:Ljava/lang/String;
        //   645: goto            325
        //   648: aload_0        
        //   649: invokestatic    com/opera/mini/android/ar.Code:(Landroid/content/Context;)Lcom/opera/mini/android/ar;
        //   652: astore          7
        //   654: aload           7
        //   656: ldc             "Branding"
        //   658: invokevirtual   com/opera/mini/android/ar.Code:(Ljava/lang/String;)Z
        //   661: ifeq            832
        //   664: new             Ljava/lang/String;
        //   667: dup            
        //   668: aload           7
        //   670: ldc             "Branding"
        //   672: invokevirtual   com/opera/mini/android/ar.I:(Ljava/lang/String;)[B
        //   675: ldc             "utf-8"
        //   677: invokespecial   java/lang/String.<init>:([BLjava/lang/String;)V
        //   680: astore          4
        //   682: aload           4
        //   684: putstatic       com/opera/mini/android/x.aq:Ljava/lang/String;
        //   687: aload           7
        //   689: ldc             "Signature"
        //   691: invokevirtual   com/opera/mini/android/ar.Code:(Ljava/lang/String;)Z
        //   694: ifeq            838
        //   697: new             Ljava/lang/String;
        //   700: dup            
        //   701: aload           7
        //   703: ldc             "Signature"
        //   705: invokevirtual   com/opera/mini/android/ar.I:(Ljava/lang/String;)[B
        //   708: ldc             "utf-8"
        //   710: invokespecial   java/lang/String.<init>:([BLjava/lang/String;)V
        //   713: astore          4
        //   715: aload           4
        //   717: putstatic       com/opera/mini/android/x.ar:Ljava/lang/String;
        //   720: aload           7
        //   722: ldc             "HomescreenTitle"
        //   724: invokevirtual   com/opera/mini/android/ar.Code:(Ljava/lang/String;)Z
        //   727: ifeq            844
        //   730: new             Ljava/lang/String;
        //   733: dup            
        //   734: aload           7
        //   736: ldc             "HomescreenTitle"
        //   738: invokevirtual   com/opera/mini/android/ar.I:(Ljava/lang/String;)[B
        //   741: ldc             "utf-8"
        //   743: invokespecial   java/lang/String.<init>:([BLjava/lang/String;)V
        //   746: astore          4
        //   748: aload           4
        //   750: putstatic       com/opera/mini/android/x.as:Ljava/lang/String;
        //   753: aload           7
        //   755: ldc             "HomescreenUrl"
        //   757: invokevirtual   com/opera/mini/android/ar.Code:(Ljava/lang/String;)Z
        //   760: ifeq            850
        //   763: new             Ljava/lang/String;
        //   766: dup            
        //   767: aload           7
        //   769: ldc             "HomescreenUrl"
        //   771: invokevirtual   com/opera/mini/android/ar.I:(Ljava/lang/String;)[B
        //   774: ldc             "utf-8"
        //   776: invokespecial   java/lang/String.<init>:([BLjava/lang/String;)V
        //   779: astore          4
        //   781: aload           4
        //   783: putstatic       com/opera/mini/android/x.at:Ljava/lang/String;
        //   786: aload           7
        //   788: ldc_w           "ChannelID "
        //   791: invokevirtual   com/opera/mini/android/ar.Code:(Ljava/lang/String;)Z
        //   794: ifeq            856
        //   797: new             Ljava/lang/String;
        //   800: dup            
        //   801: aload           7
        //   803: ldc             "ChannelID"
        //   805: invokevirtual   com/opera/mini/android/ar.I:(Ljava/lang/String;)[B
        //   808: ldc             "utf-8"
        //   810: invokespecial   java/lang/String.<init>:([BLjava/lang/String;)V
        //   813: astore          4
        //   815: aload           4
        //   817: putstatic       com/opera/mini/android/x.au:Ljava/lang/String;
        //   820: goto            537
        //   823: astore          4
        //   825: aconst_null    
        //   826: putstatic       com/opera/mini/android/x.aq:Ljava/lang/String;
        //   829: goto            537
        //   832: aconst_null    
        //   833: astore          4
        //   835: goto            682
        //   838: aconst_null    
        //   839: astore          4
        //   841: goto            715
        //   844: aconst_null    
        //   845: astore          4
        //   847: goto            748
        //   850: aconst_null    
        //   851: astore          4
        //   853: goto            781
        //   856: aconst_null    
        //   857: astore          4
        //   859: goto            815
        //   862: astore          4
        //   864: aconst_null    
        //   865: putstatic       com/opera/mini/android/x.aq:Ljava/lang/String;
        //   868: goto            537
        //   871: astore_0       
        //   872: aload           4
        //   874: ifnull          600
        //   877: aload           4
        //   879: invokevirtual   java/io/InputStream.close:()V
        //   882: goto            600
        //   885: astore_0       
        //   886: goto            600
        //   889: astore_0       
        //   890: aload           5
        //   892: ifnull          900
        //   895: aload           5
        //   897: invokevirtual   java/io/InputStream.close:()V
        //   900: aload_0        
        //   901: athrow         
        //   902: ldc_w           "ginko"
        //   905: areturn        
        //   906: astore_0       
        //   907: goto            600
        //   910: astore          4
        //   912: goto            900
        //   915: astore          4
        //   917: goto            537
        //   920: astore          4
        //   922: goto            537
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                           
        //  -----  -----  -----  -----  -------------------------------
        //  64     83     610    623    Ljava/lang/Exception;
        //  85     104    610    623    Ljava/lang/Exception;
        //  108    127    610    623    Ljava/lang/Exception;
        //  129    148    610    623    Ljava/lang/Exception;
        //  150    160    610    623    Ljava/lang/Exception;
        //  167    178    610    623    Ljava/lang/Exception;
        //  202    226    639    648    Lorg/json/JSONException;
        //  231    255    639    648    Lorg/json/JSONException;
        //  258    317    639    648    Lorg/json/JSONException;
        //  320    325    639    648    Lorg/json/JSONException;
        //  331    377    920    925    Ljava/io/IOException;
        //  331    377    915    920    Landroid/database/SQLException;
        //  377    417    920    925    Ljava/io/IOException;
        //  377    417    915    920    Landroid/database/SQLException;
        //  417    457    920    925    Ljava/io/IOException;
        //  417    457    915    920    Landroid/database/SQLException;
        //  457    497    920    925    Ljava/io/IOException;
        //  457    497    915    920    Landroid/database/SQLException;
        //  497    537    920    925    Ljava/io/IOException;
        //  497    537    915    920    Landroid/database/SQLException;
        //  553    563    871    889    Ljava/io/IOException;
        //  553    563    889    902    Any
        //  569    582    871    889    Ljava/io/IOException;
        //  569    582    889    902    Any
        //  588    592    871    889    Ljava/io/IOException;
        //  588    592    889    902    Any
        //  596    600    906    910    Ljava/io/IOException;
        //  623    628    639    648    Lorg/json/JSONException;
        //  631    636    639    648    Lorg/json/JSONException;
        //  648    682    823    832    Ljava/io/IOException;
        //  648    682    862    871    Landroid/database/SQLException;
        //  682    715    823    832    Ljava/io/IOException;
        //  682    715    862    871    Landroid/database/SQLException;
        //  715    748    823    832    Ljava/io/IOException;
        //  715    748    862    871    Landroid/database/SQLException;
        //  748    781    823    832    Ljava/io/IOException;
        //  748    781    862    871    Landroid/database/SQLException;
        //  781    815    823    832    Ljava/io/IOException;
        //  781    815    862    871    Landroid/database/SQLException;
        //  815    820    823    832    Ljava/io/IOException;
        //  815    820    862    871    Landroid/database/SQLException;
        //  877    882    885    889    Ljava/io/IOException;
        //  895    900    910    915    Ljava/io/IOException;
        // 
        // The error that occurred was:
        // 
        // java.lang.IndexOutOfBoundsException: Index: 397, Size: 397
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
    
    public static void Code(int a, int n) {
        n = (a = a * n * 3 * x.b / 1024);
        if (x.Code) {
            a = n * 12 / 10;
        }
        x.a = a;
        a = (x.d = (int)((x.an - x.a * 1024) * 2L / 3072L));
        x.e = a / 5;
    }
    
    public static void Code(final SharedPreferences$Editor sharedPreferences$Editor) {
        if (x.ak >= 9) {
            com.opera.mini.android.aj.Code(sharedPreferences$Editor);
            return;
        }
        sharedPreferences$Editor.commit();
    }
    
    public static void Code(final Browser browser) {
        x.q = 2;
        x.y = true;
        x.h = true;
        x.Z = bj.Code((Context)browser);
        x.g = 1;
        x.f = 0;
        x.i = t();
        final SecureRandom secureRandom = new SecureRandom();
        cg.Z(secureRandom.nextInt());
        cg.Z(secureRandom.nextInt());
        cg.Z(secureRandom.nextInt());
        cg.E = Math.max(cg.E, 160);
        x.k = 2;
        x.ag = new DisplayMetrics();
        browser.getWindowManager().getDefaultDisplay().getMetrics(x.ag);
        x.n = (int)((l() + k()) / 2.0f);
        x.j = 20;
        x.o = true;
        x.p = true;
        x.w = '\u2022';
        final Locale default1 = Locale.getDefault();
        if ((x.ah = default1.getLanguage()).equals("no")) {
            x.ah = "nb";
        }
        else if (x.ah.equals("iw")) {
            x.ah = "he";
        }
        else if (x.ah.equals("in")) {
            x.ah = "id";
        }
        x.ai = default1.getCountry().toLowerCase();
        x.x = true;
        x.v = true;
        final ActivityManager activityManager = (ActivityManager)browser.getSystemService("activity");
        final ActivityManager$MemoryInfo activityManager$MemoryInfo = new ActivityManager$MemoryInfo();
        activityManager.getMemoryInfo(activityManager$MemoryInfo);
        x.aj = activityManager$MemoryInfo.availMem;
        x.B = Math.min(x.an = Runtime.getRuntime().maxMemory() - Runtime.getRuntime().totalMemory() + Runtime.getRuntime().freeMemory(), 5242880L);
        x.u = 4;
        if (Runtime.getRuntime().maxMemory() <= 16777216L) {
            x.u = 3;
        }
        Runtime.getRuntime().maxMemory();
        x.J = (((Context)browser).getPackageManager().queryBroadcastReceivers(new Intent("com.android.launcher.action.INSTALL_SHORTCUT"), 0).size() > 0);
        x.A = 32768;
    }
    
    private static void Code(final Closeable closeable) {
        if (closeable == null) {
            return;
        }
        try {
            closeable.close();
        }
        catch (IOException ex) {}
    }
    
    private static void Code(final InputStream inputStream, final OutputStream outputStream) {
        final byte[] array = new byte[4096];
        while (true) {
            final int read = inputStream.read(array);
            if (read == -1) {
                break;
            }
            outputStream.write(array, 0, read);
        }
    }
    
    public static boolean Code(final Context context, final String s, final String s2) {
        while (true) {
            while (true) {
                Label_0182: {
                    try {
                        final PackageInfo packageInfo = context.getPackageManager().getPackageInfo(s, 64);
                        if (packageInfo != null) {
                            final Signature[] signatures = packageInfo.signatures;
                            Block_5: {
                                for (int length = signatures.length, i = 0; i < length; ++i) {
                                    final Signature signature = signatures[i];
                                    final CertificateFactory instance = CertificateFactory.getInstance("X509");
                                    final MessageDigest instance2 = MessageDigest.getInstance("SHA1");
                                    if (instance == null) {
                                        break Label_0182;
                                    }
                                    if (instance2 == null) {
                                        break Block_5;
                                    }
                                    final byte[] digest = instance2.digest(instance.generateCertificate(new ByteArrayInputStream(signature.toByteArray())).getPublicKey().getEncoded());
                                    final String format = String.format(Locale.US, "%0" + digest.length * 2 + "x", new BigInteger(1, digest));
                                    if (s2.equalsIgnoreCase(format)) {
                                        return true;
                                    }
                                }
                                goto Label_0172;
                            }
                            break Label_0182;
                        }
                        goto Label_0172;
                    }
                    catch (NoSuchAlgorithmException ex) {}
                    catch (CertificateException ex2) {
                        goto Label_0172;
                    }
                    catch (PackageManager$NameNotFoundException ex3) {
                        goto Label_0172;
                    }
                }
                final String format = null;
                continue;
            }
        }
    }
    
    public static boolean Code(final String s, final PackageManager packageManager) {
        try {
            packageManager.getPackageInfo(s, 0);
            return true;
        }
        catch (PackageManager$NameNotFoundException ex) {
            return false;
        }
    }
    
    static ApplicationInfo I(final Context context) {
        try {
            return context.getPackageManager().getApplicationInfo(context.getPackageName(), 0);
        }
        catch (PackageManager$NameNotFoundException ex) {
            return null;
        }
    }
    
    private static byte[] J(final Context context) {
        while (true) {
            while (true) {
                try {
                    Object o = new File("/system/lib", "libpreinstallinfo.so");
                    Label_0090: {
                        if (!((File)o).exists()) {
                            break Label_0090;
                        }
                        if (o == null) {
                            break;
                        }
                        Object o2 = new FileInputStream((File)o);
                        try {
                            final int n = (int)((File)o).length();
                            int n2 = 0;
                            if (n > 0) {
                                o = new byte[n];
                                Object o3;
                                while (true) {
                                    o3 = o;
                                    if (n2 >= n) {
                                        break;
                                    }
                                    n2 += ((FileInputStream)o2).read((byte[])o, n2, Math.min(1024, n - n2));
                                }
                                return (byte[])o3;
                            }
                            return null;
                            o2 = (o = new File(I(context).dataDir + "/lib", "libpreinstallinfo.so"));
                            iftrue(Label_0023:)(((File)o2).exists() || (x.ak >= 9 && ((File)(o = new File(com.opera.mini.android.aj.Code(context), "libpreinstallinfo.so"))).exists()));
                        }
                        finally {
                            ((FileInputStream)o2).close();
                        }
                    }
                }
                catch (IOException ex) {
                    return null;
                }
                break;
                Object o = null;
                continue;
            }
            Object o3 = null;
            return (byte[])o3;
        }
        return null;
    }
    
    public static String Z(final Context context) {
        if (x.ak >= 9) {
            return com.opera.mini.android.aj.Code(context);
        }
        return I((Context)Browser.Z).dataDir + "/lib/";
    }
    
    public static void f(final String av) {
        synchronized (x.aw) {
            x.av = av;
        }
    }
    
    public static void i() {
    }
    
    public static void j() {
        x.F = null;
        x.ae = com.opera.mini.android.h.Code().Z();
        x.ad = com.opera.mini.android.h.Code;
        x.ac = x.ae.length;
    }
    
    public static float k() {
        if (x.ao < 1.0f) {
            u();
        }
        return x.ao;
    }
    
    public static float l() {
        if (x.ap < 1.0f) {
            u();
        }
        return x.ap;
    }
    
    public static void m() {
        x.ag = new DisplayMetrics();
        Browser.Z.getWindowManager().getDefaultDisplay().getMetrics(x.ag);
    }
    
    public static String n() {
        synchronized (x.aw) {
            return x.av;
        }
    }
    
    public static void o() {
        final String as = x.as;
        final String at = x.at;
        if (!Browser.Z.getPreferences(0).getBoolean("isHomescreenShortcutCreated", false) && as != null && !as.equals("") && at != null && !at.equals("")) {
            u.Code.J(as, at);
            final SharedPreferences$Editor edit = Browser.Z.getPreferences(0).edit();
            edit.putBoolean("isHomescreenShortcutCreated", true);
            edit.commit();
        }
    }
    
    static String p() {
        if ("".equals(x.au)) {
            return null;
        }
        return x.au;
    }
    
    public static String q() {
        try {
            return Browser.Z.getPackageManager().getPackageInfo(Browser.Z.getPackageName(), 0).versionName;
        }
        catch (PackageManager$NameNotFoundException ex) {
            return "";
        }
    }
    
    public static String r() {
        if ("a".equals("m")) {
            return "amazon";
        }
        return "androidmarket";
    }
    
    public static boolean s() {
        return x.ak >= 7;
    }
    
    private static String t() {
        Object o = Browser.Z.getPreferences(0);
        String s = ((SharedPreferences)o).getString("id_pref", "");
        String s2 = ((SharedPreferences)o).getString("loc_pref", "");
        final String string = Locale.getDefault().toString();
        Label_0151: {
            if (((SharedPreferences)o).contains("ua_pref") && s.compareTo(Build.FINGERPRINT) == 0 && s2.compareTo(string) == 0) {
                break Label_0151;
            }
            final WebView webView = new WebView(Browser.Z.getApplicationContext());
            s = Build.FINGERPRINT;
            s2 = webView.getSettings().getUserAgentString();
            while (true) {
                try {
                    webView.destroy();
                    o = ((SharedPreferences)o).edit();
                    ((SharedPreferences$Editor)o).putString("id_pref", s);
                    ((SharedPreferences$Editor)o).putString("loc_pref", string);
                    ((SharedPreferences$Editor)o).putString("ua_pref", s2);
                    ((SharedPreferences$Editor)o).commit();
                    return s2;
                    return ((SharedPreferences)o).getString("ua_pref", "");
                }
                catch (Throwable t) {
                    continue;
                }
                break;
            }
        }
    }
    
    private static void u() {
        x.ao = 0.0f;
        x.ap = 0.0f;
        final String device = Build.DEVICE;
        final String model = Build.MODEL;
        if (device.equals("qsd8250_surf") || model.equals("Dell Streak")) {
            x.ao = 190.0f;
            x.ap = 190.0f;
            return;
        }
        if (model.equals("VTAB1008")) {
            x.ao = 160.0f;
            x.ap = 160.0f;
            return;
        }
        if (model.equals("Dell Streak 7")) {
            x.ao = 150.0f;
            x.ap = 150.0f;
            return;
        }
        if (model.equals("A1_07")) {
            x.ao = 127.5f;
            x.ap = 100.0f;
            return;
        }
        if (model.startsWith("GT-N710") || model.equalsIgnoreCase("SCH-N719") || model.startsWith("SHV-E250")) {
            x.ao = 267.0f;
            x.ap = 267.0f;
            return;
        }
        if (x.ak >= 4 && (com.opera.mini.android.ah.Code() - x.ag.xdpi >= 79.0 || com.opera.mini.android.ah.Code() - x.ag.ydpi >= 79.0 || Math.abs(x.ag.ydpi - x.ag.xdpi) > 40.0)) {
            x.ao = (float)com.opera.mini.android.ah.Code();
            x.ap = (float)com.opera.mini.android.ah.Code();
            return;
        }
        x.ao = x.ag.xdpi;
        x.ap = x.ag.ydpi;
    }
}
