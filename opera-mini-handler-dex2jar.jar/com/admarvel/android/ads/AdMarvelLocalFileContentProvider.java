// 
// Decompiled by Procyon v0.6-prerelease
// 

package com.admarvel.android.ads;

import android.database.Cursor;
import android.os.ParcelFileDescriptor;
import android.content.ContentValues;
import android.net.Uri;
import android.content.ContentProvider;

public class AdMarvelLocalFileContentProvider extends ContentProvider
{
    public int delete(final Uri uri, final String s, final String[] array) {
        throw new UnsupportedOperationException("Not supported by this provider");
    }
    
    public String getType(final Uri uri) {
        throw new UnsupportedOperationException("Not supported by this provider");
    }
    
    public Uri insert(final Uri uri, final ContentValues contentValues) {
        throw new UnsupportedOperationException("Not supported by this provider");
    }
    
    public boolean onCreate() {
        return true;
    }
    
    public ParcelFileDescriptor openFile(final Uri p0, final String p1) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: istore          5
        //     3: aload_1        
        //     4: invokevirtual   android/net/Uri.getPath:()Ljava/lang/String;
        //     7: new             Ljava/lang/StringBuilder;
        //    10: dup            
        //    11: ldc             "content://"
        //    13: invokespecial   java/lang/StringBuilder.<init>:(Ljava/lang/String;)V
        //    16: aload_0        
        //    17: invokevirtual   com/admarvel/android/ads/AdMarvelLocalFileContentProvider.getContext:()Landroid/content/Context;
        //    20: invokevirtual   android/content/Context.getPackageName:()Ljava/lang/String;
        //    23: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //    26: ldc             ".AdMarvelLocalFileContentProvider"
        //    28: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //    31: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //    34: ldc             ""
        //    36: invokevirtual   java/lang/String.replace:(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
        //    39: astore_1       
        //    40: aload_1        
        //    41: ifnull          147
        //    44: aload_1        
        //    45: ldc             "/mraid.js"
        //    47: invokevirtual   java/lang/String.equals:(Ljava/lang/Object;)Z
        //    50: ifne            62
        //    53: aload_1        
        //    54: ldc             "mraid.js"
        //    56: invokevirtual   java/lang/String.equals:(Ljava/lang/Object;)Z
        //    59: ifeq            147
        //    62: aload_0        
        //    63: invokevirtual   com/admarvel/android/ads/AdMarvelLocalFileContentProvider.getContext:()Landroid/content/Context;
        //    66: ldc             "adm_mraid_file"
        //    68: iconst_0       
        //    69: invokevirtual   android/content/Context.getDir:(Ljava/lang/String;I)Ljava/io/File;
        //    72: astore_1       
        //    73: aload_1        
        //    74: ifnull          580
        //    77: aload_1        
        //    78: invokevirtual   java/io/File.isDirectory:()Z
        //    81: ifeq            580
        //    84: new             Ljava/io/File;
        //    87: dup            
        //    88: new             Ljava/lang/StringBuilder;
        //    91: dup            
        //    92: invokespecial   java/lang/StringBuilder.<init>:()V
        //    95: aload_1        
        //    96: invokevirtual   java/io/File.getAbsolutePath:()Ljava/lang/String;
        //    99: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   102: ldc             "/mraid.js"
        //   104: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   107: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   110: invokespecial   java/io/File.<init>:(Ljava/lang/String;)V
        //   113: astore_1       
        //   114: aload_1        
        //   115: ifnull          149
        //   118: aload_1        
        //   119: invokevirtual   java/io/File.exists:()Z
        //   122: ifeq            149
        //   125: ldc             "Mraid loading from client"
        //   127: invokestatic    com/admarvel/android/util/Logging.log:(Ljava/lang/String;)V
        //   130: aload_1        
        //   131: ldc             268435456
        //   133: invokestatic    android/os/ParcelFileDescriptor.open:(Ljava/io/File;I)Landroid/os/ParcelFileDescriptor;
        //   136: astore_1       
        //   137: aload_1        
        //   138: areturn        
        //   139: astore_1       
        //   140: aload_1        
        //   141: invokestatic    android/util/Log.getStackTraceString:(Ljava/lang/Throwable;)Ljava/lang/String;
        //   144: invokestatic    com/admarvel/android/util/Logging.log:(Ljava/lang/String;)V
        //   147: aconst_null    
        //   148: areturn        
        //   149: new             Ljava/net/URL;
        //   152: dup            
        //   153: ldc             "http://admarvel.s3.amazonaws.com/js/admarvel_mraid_v2_complete.js"
        //   155: invokespecial   java/net/URL.<init>:(Ljava/lang/String;)V
        //   158: invokevirtual   java/net/URL.openConnection:()Ljava/net/URLConnection;
        //   161: checkcast       Ljava/net/HttpURLConnection;
        //   164: astore_2       
        //   165: aload_2        
        //   166: ldc             "GET"
        //   168: invokevirtual   java/net/HttpURLConnection.setRequestMethod:(Ljava/lang/String;)V
        //   171: aload_2        
        //   172: iconst_0       
        //   173: invokevirtual   java/net/HttpURLConnection.setDoOutput:(Z)V
        //   176: aload_2        
        //   177: iconst_1       
        //   178: invokevirtual   java/net/HttpURLConnection.setDoInput:(Z)V
        //   181: aload_2        
        //   182: iconst_0       
        //   183: invokevirtual   java/net/HttpURLConnection.setUseCaches:(Z)V
        //   186: aload_2        
        //   187: ldc             "Content-Type"
        //   189: ldc             "application/x-www-form-urlencoded"
        //   191: invokevirtual   java/net/HttpURLConnection.setRequestProperty:(Ljava/lang/String;Ljava/lang/String;)V
        //   194: aload_2        
        //   195: ldc             "Content-Length"
        //   197: ldc             "0"
        //   199: invokevirtual   java/net/HttpURLConnection.setRequestProperty:(Ljava/lang/String;Ljava/lang/String;)V
        //   202: aload_2        
        //   203: sipush          2000
        //   206: invokevirtual   java/net/HttpURLConnection.setConnectTimeout:(I)V
        //   209: aload_2        
        //   210: sipush          10000
        //   213: invokevirtual   java/net/HttpURLConnection.setReadTimeout:(I)V
        //   216: aload_2        
        //   217: invokevirtual   java/net/HttpURLConnection.getResponseCode:()I
        //   220: istore_3       
        //   221: aload_2        
        //   222: invokevirtual   java/net/HttpURLConnection.getContentLength:()I
        //   225: istore          4
        //   227: new             Ljava/lang/StringBuilder;
        //   230: dup            
        //   231: ldc             "Mraid Connection Status Code: "
        //   233: invokespecial   java/lang/StringBuilder.<init>:(Ljava/lang/String;)V
        //   236: iload_3        
        //   237: invokevirtual   java/lang/StringBuilder.append:(I)Ljava/lang/StringBuilder;
        //   240: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   243: invokestatic    com/admarvel/android/util/Logging.log:(Ljava/lang/String;)V
        //   246: new             Ljava/lang/StringBuilder;
        //   249: dup            
        //   250: ldc             "Mraid Content Length: "
        //   252: invokespecial   java/lang/StringBuilder.<init>:(Ljava/lang/String;)V
        //   255: iload           4
        //   257: invokevirtual   java/lang/StringBuilder.append:(I)Ljava/lang/StringBuilder;
        //   260: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   263: invokestatic    com/admarvel/android/util/Logging.log:(Ljava/lang/String;)V
        //   266: iload_3        
        //   267: sipush          200
        //   270: if_icmpne       147
        //   273: aload_2        
        //   274: invokevirtual   java/net/HttpURLConnection.getContent:()Ljava/lang/Object;
        //   277: checkcast       Ljava/io/InputStream;
        //   280: astore_1       
        //   281: ldc             "gzip"
        //   283: aload_2        
        //   284: invokevirtual   java/net/HttpURLConnection.getContentEncoding:()Ljava/lang/String;
        //   287: invokevirtual   java/lang/String.equals:(Ljava/lang/Object;)Z
        //   290: ifeq            577
        //   293: invokestatic    com/admarvel/android/ads/Version.getAndroidSDKVersion:()I
        //   296: bipush          9
        //   298: if_icmpge       577
        //   301: new             Ljava/util/zip/GZIPInputStream;
        //   304: dup            
        //   305: aload_1        
        //   306: invokespecial   java/util/zip/GZIPInputStream.<init>:(Ljava/io/InputStream;)V
        //   309: astore_1       
        //   310: new             Ljava/util/ArrayList;
        //   313: dup            
        //   314: invokespecial   java/util/ArrayList.<init>:()V
        //   317: astore_2       
        //   318: iconst_0       
        //   319: istore          4
        //   321: sipush          8192
        //   324: istore_3       
        //   325: iload_3        
        //   326: iconst_m1      
        //   327: if_icmpeq       411
        //   330: sipush          8192
        //   333: newarray        B
        //   335: astore          7
        //   337: aload_1        
        //   338: aload           7
        //   340: iconst_0       
        //   341: sipush          8192
        //   344: invokevirtual   java/io/InputStream.read:([BII)I
        //   347: istore          6
        //   349: iload           6
        //   351: istore_3       
        //   352: iload           6
        //   354: ifle            325
        //   357: new             Lcom/admarvel/android/ads/AdMarvelLocalFileContentProvider$a;
        //   360: dup            
        //   361: aconst_null    
        //   362: invokespecial   com/admarvel/android/ads/AdMarvelLocalFileContentProvider$a.<init>:(Lcom/admarvel/android/ads/AdMarvelLocalFileContentProvider$1;)V
        //   365: astore          8
        //   367: aload           8
        //   369: aload           7
        //   371: putfield        com/admarvel/android/ads/AdMarvelLocalFileContentProvider$a.a:[B
        //   374: aload           8
        //   376: iload           6
        //   378: putfield        com/admarvel/android/ads/AdMarvelLocalFileContentProvider$a.b:I
        //   381: iload           4
        //   383: iload           6
        //   385: iadd           
        //   386: istore          4
        //   388: aload_2        
        //   389: aload           8
        //   391: invokeinterface java/util/List.add:(Ljava/lang/Object;)Z
        //   396: pop            
        //   397: iload           6
        //   399: istore_3       
        //   400: goto            325
        //   403: astore_1       
        //   404: aload_1        
        //   405: invokevirtual   java/io/IOException.printStackTrace:()V
        //   408: goto            147
        //   411: aload_1        
        //   412: invokevirtual   java/io/InputStream.close:()V
        //   415: iload           4
        //   417: ifle            571
        //   420: iload           4
        //   422: newarray        B
        //   424: astore_1       
        //   425: iconst_0       
        //   426: istore_3       
        //   427: iload           5
        //   429: istore          4
        //   431: iload_3        
        //   432: aload_2        
        //   433: invokeinterface java/util/List.size:()I
        //   438: if_icmpge       487
        //   441: aload_2        
        //   442: iload_3        
        //   443: invokeinterface java/util/List.get:(I)Ljava/lang/Object;
        //   448: checkcast       Lcom/admarvel/android/ads/AdMarvelLocalFileContentProvider$a;
        //   451: astore          7
        //   453: aload           7
        //   455: getfield        com/admarvel/android/ads/AdMarvelLocalFileContentProvider$a.a:[B
        //   458: iconst_0       
        //   459: aload_1        
        //   460: iload           4
        //   462: aload           7
        //   464: getfield        com/admarvel/android/ads/AdMarvelLocalFileContentProvider$a.b:I
        //   467: invokestatic    java/lang/System.arraycopy:(Ljava/lang/Object;ILjava/lang/Object;II)V
        //   470: iload           4
        //   472: aload           7
        //   474: getfield        com/admarvel/android/ads/AdMarvelLocalFileContentProvider$a.b:I
        //   477: iadd           
        //   478: istore          4
        //   480: iload_3        
        //   481: iconst_1       
        //   482: iadd           
        //   483: istore_3       
        //   484: goto            431
        //   487: new             Ljava/lang/String;
        //   490: dup            
        //   491: aload_1        
        //   492: invokespecial   java/lang/String.<init>:([B)V
        //   495: astore_1       
        //   496: aload_0        
        //   497: invokevirtual   com/admarvel/android/ads/AdMarvelLocalFileContentProvider.getContext:()Landroid/content/Context;
        //   500: ldc             "admarvel_mraid.js"
        //   502: iconst_0       
        //   503: invokevirtual   android/content/Context.openFileOutput:(Ljava/lang/String;I)Ljava/io/FileOutputStream;
        //   506: astore_2       
        //   507: aload_2        
        //   508: aload_1        
        //   509: invokevirtual   java/lang/String.getBytes:()[B
        //   512: invokevirtual   java/io/FileOutputStream.write:([B)V
        //   515: aload_2        
        //   516: invokevirtual   java/io/FileOutputStream.close:()V
        //   519: new             Ljava/io/File;
        //   522: dup            
        //   523: new             Ljava/lang/StringBuilder;
        //   526: dup            
        //   527: ldc_w           "/data/data/"
        //   530: invokespecial   java/lang/StringBuilder.<init>:(Ljava/lang/String;)V
        //   533: aload_0        
        //   534: invokevirtual   com/admarvel/android/ads/AdMarvelLocalFileContentProvider.getContext:()Landroid/content/Context;
        //   537: invokevirtual   android/content/Context.getPackageName:()Ljava/lang/String;
        //   540: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   543: ldc_w           "/files"
        //   546: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   549: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   552: ldc             "admarvel_mraid.js"
        //   554: invokespecial   java/io/File.<init>:(Ljava/lang/String;Ljava/lang/String;)V
        //   557: ldc             268435456
        //   559: invokestatic    android/os/ParcelFileDescriptor.open:(Ljava/io/File;I)Landroid/os/ParcelFileDescriptor;
        //   562: areturn        
        //   563: astore_1       
        //   564: aload_1        
        //   565: invokevirtual   java/io/IOException.printStackTrace:()V
        //   568: goto            519
        //   571: ldc             ""
        //   573: astore_1       
        //   574: goto            496
        //   577: goto            310
        //   580: aconst_null    
        //   581: astore_1       
        //   582: goto            114
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                 
        //  -----  -----  -----  -----  ---------------------
        //  125    137    139    147    Ljava/lang/Exception;
        //  149    266    403    411    Ljava/io/IOException;
        //  273    310    403    411    Ljava/io/IOException;
        //  310    318    403    411    Ljava/io/IOException;
        //  330    349    403    411    Ljava/io/IOException;
        //  357    381    403    411    Ljava/io/IOException;
        //  388    397    403    411    Ljava/io/IOException;
        //  411    415    403    411    Ljava/io/IOException;
        //  420    425    403    411    Ljava/io/IOException;
        //  431    480    403    411    Ljava/io/IOException;
        //  487    496    403    411    Ljava/io/IOException;
        //  496    507    403    411    Ljava/io/IOException;
        //  507    519    563    571    Ljava/io/IOException;
        //  519    563    403    411    Ljava/io/IOException;
        //  564    568    403    411    Ljava/io/IOException;
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0519:
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
    
    public Cursor query(final Uri uri, final String[] array, final String s, final String[] array2, final String s2) {
        throw new UnsupportedOperationException("Not supported by this provider");
    }
    
    public int update(final Uri uri, final ContentValues contentValues, final String s, final String[] array) {
        throw new UnsupportedOperationException("Not supported by this provider");
    }
}
