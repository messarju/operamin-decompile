// 
// Decompiled by Procyon v0.6-prerelease
// 

package com.admarvel.android.util;

import com.admarvel.android.ads.AdMarvelUtils;
import android.graphics.Bitmap;
import java.io.OutputStream;
import android.graphics.Bitmap$CompressFormat;
import java.io.ByteArrayOutputStream;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.content.Context;

public class AdMarvelBitmapDrawableUtils
{
    public static final String ADMARVEL_CUSTOM_BACK_BUTTON = "rd2KvT4Zi0NK9A0CejrW35pciQ002l";
    public static final String ADMARVEL_CUSTOM_BACK_DISABLE_BUTTON = "MKlWddpjgeIrBuZxnd37tVjz7OM7fu";
    public static final String ADMARVEL_CUSTOM_CLOSE_BUTTON = "OCkD4Sjg8bN0h8bDad6gWa5t51Zy5I";
    public static final String ADMARVEL_CUSTOM_DONE_BUTTON = "USuSmQSCwrDx1CXCp4oqplFBGTQAZM";
    public static final String ADMARVEL_CUSTOM_MUTE_BUTTON = "u2nfwuKbaKzVwGmUNmk7wFVXHwzy7S";
    public static final String ADMARVEL_CUSTOM_OPEN_URL_BUTTON = "nRdOcYYrMLotmPFqlTcjFIf7isxM5t";
    public static final String ADMARVEL_CUSTOM_OPEN_URL_DISABLED_BUTTON = "H2GFZHEOwlzVJk4cBatArzxlb2XOJH";
    public static final String ADMARVEL_CUSTOM_PAUSE_BUTTON = "d2UpTWfkssmtbKnAqIR6WGdcMl4Gg8";
    public static final String ADMARVEL_CUSTOM_PLAY_BUTTON = "aSrZSorTa7PztrNZ4FuMvViHEaGfDV";
    public static final String ADMARVEL_CUSTOM_REPLAY_BUTTON = "ej5yqIooDTRYYsXEJuN4eJOh7buHJI";
    public static final String ADMARVEL_CUSTOM_RESUME_BUTTON = "UPuOOqinUE2sqnnpe8MYG7PzHVVl5p";
    public static final String ADMARVEL_CUSTOM_RESUME_DISABLE_BUTTON = "NCLuZlSXjDualh2uti1kSm8vWlELL9";
    public static final String ADMARVEL_CUSTOM_STOP_BUTTON = "yz6T5xsau00Hqg556ez5NwTY2IsOW1";
    public static final String ADMARVEL_CUSTOM_TIME_BUTTON = "I9Kg1IJB4gtPeHhlB0pvKW5yqcRf2o";
    public static final String ADMARVEL_CUSTOM_UNMUTE_BUTTON = "kOy0RFIzirRqTweJUasQ2qaqYyPhm4";
    
    private AdMarvelBitmapDrawableUtils() {
    }
    
    public static BitmapDrawable bitmapFromJar(final String p0, final Context p1) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     3: dup            
        //     4: ldc             "admarvel_bitmaps/"
        //     6: invokespecial   java/lang/StringBuilder.<init>:(Ljava/lang/String;)V
        //     9: aload_0        
        //    10: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //    13: ldc             ".png"
        //    15: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //    18: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //    21: astore          4
        //    23: aload_1        
        //    24: ifnonnull       29
        //    27: aconst_null    
        //    28: areturn        
        //    29: aload_1        
        //    30: invokevirtual   android/content/Context.getClassLoader:()Ljava/lang/ClassLoader;
        //    33: aload           4
        //    35: invokevirtual   java/lang/ClassLoader.getResource:(Ljava/lang/String;)Ljava/net/URL;
        //    38: invokevirtual   java/net/URL.getFile:()Ljava/lang/String;
        //    41: astore_3       
        //    42: aload_3        
        //    43: astore_0       
        //    44: aload_3        
        //    45: ldc             "file:"
        //    47: invokevirtual   java/lang/String.startsWith:(Ljava/lang/String;)Z
        //    50: ifeq            59
        //    53: aload_3        
        //    54: iconst_5       
        //    55: invokevirtual   java/lang/String.substring:(I)Ljava/lang/String;
        //    58: astore_0       
        //    59: aload_0        
        //    60: ldc             "!"
        //    62: invokevirtual   java/lang/String.indexOf:(Ljava/lang/String;)I
        //    65: istore_2       
        //    66: aload_0        
        //    67: astore_3       
        //    68: iload_2        
        //    69: ifle            79
        //    72: aload_0        
        //    73: iconst_0       
        //    74: iload_2        
        //    75: invokevirtual   java/lang/String.substring:(II)Ljava/lang/String;
        //    78: astore_3       
        //    79: new             Ljava/util/jar/JarFile;
        //    82: dup            
        //    83: aload_3        
        //    84: invokespecial   java/util/jar/JarFile.<init>:(Ljava/lang/String;)V
        //    87: astore_0       
        //    88: aload_0        
        //    89: aload_0        
        //    90: aload           4
        //    92: invokevirtual   java/util/jar/JarFile.getJarEntry:(Ljava/lang/String;)Ljava/util/jar/JarEntry;
        //    95: invokevirtual   java/util/jar/JarFile.getInputStream:(Ljava/util/zip/ZipEntry;)Ljava/io/InputStream;
        //    98: astore_3       
        //    99: aload_3        
        //   100: astore_0       
        //   101: aload_3        
        //   102: invokestatic    android/graphics/BitmapFactory.decodeStream:(Ljava/io/InputStream;)Landroid/graphics/Bitmap;
        //   105: astore          4
        //   107: aload_3        
        //   108: astore_0       
        //   109: new             Landroid/graphics/drawable/BitmapDrawable;
        //   112: dup            
        //   113: aload_1        
        //   114: invokevirtual   android/content/Context.getResources:()Landroid/content/res/Resources;
        //   117: aload           4
        //   119: invokespecial   android/graphics/drawable/BitmapDrawable.<init>:(Landroid/content/res/Resources;Landroid/graphics/Bitmap;)V
        //   122: astore_1       
        //   123: aload_3        
        //   124: ifnull          131
        //   127: aload_3        
        //   128: invokevirtual   java/io/InputStream.close:()V
        //   131: aload_1        
        //   132: areturn        
        //   133: astore_1       
        //   134: aconst_null    
        //   135: astore_3       
        //   136: aload_3        
        //   137: astore_0       
        //   138: aload_1        
        //   139: invokevirtual   java/lang/Exception.printStackTrace:()V
        //   142: aload_3        
        //   143: ifnull          27
        //   146: aload_3        
        //   147: invokevirtual   java/io/InputStream.close:()V
        //   150: aconst_null    
        //   151: areturn        
        //   152: astore_0       
        //   153: aconst_null    
        //   154: areturn        
        //   155: astore_1       
        //   156: aconst_null    
        //   157: astore_0       
        //   158: aload_0        
        //   159: ifnull          166
        //   162: aload_0        
        //   163: invokevirtual   java/io/InputStream.close:()V
        //   166: aload_1        
        //   167: athrow         
        //   168: astore_0       
        //   169: goto            131
        //   172: astore_0       
        //   173: goto            166
        //   176: astore_1       
        //   177: goto            158
        //   180: astore_1       
        //   181: goto            136
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                 
        //  -----  -----  -----  -----  ---------------------
        //  29     42     133    136    Ljava/lang/Exception;
        //  29     42     155    158    Any
        //  44     59     133    136    Ljava/lang/Exception;
        //  44     59     155    158    Any
        //  59     66     133    136    Ljava/lang/Exception;
        //  59     66     155    158    Any
        //  72     79     133    136    Ljava/lang/Exception;
        //  72     79     155    158    Any
        //  79     99     133    136    Ljava/lang/Exception;
        //  79     99     155    158    Any
        //  101    107    180    184    Ljava/lang/Exception;
        //  101    107    176    180    Any
        //  109    123    180    184    Ljava/lang/Exception;
        //  109    123    176    180    Any
        //  127    131    168    172    Ljava/lang/Exception;
        //  138    142    176    180    Any
        //  146    150    152    155    Ljava/lang/Exception;
        //  162    166    172    176    Ljava/lang/Exception;
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0131:
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
    
    public static String convertBitmapTobyteArray(int i, final Context context) {
        final Bitmap decodeResource = BitmapFactory.decodeResource(context.getResources(), i);
        final ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        decodeResource.compress(Bitmap$CompressFormat.PNG, 100, (OutputStream)byteArrayOutputStream);
        final byte[] byteArray = byteArrayOutputStream.toByteArray();
        final StringBuilder sb = new StringBuilder();
        for (i = 0; i < byteArray.length - 1; ++i) {
            sb.append(byteArray[i]);
            sb.append(",");
        }
        sb.append(byteArray[byteArray.length - 1]);
        return sb.toString();
    }
    
    public static String convertBitmapTobyteArray(final Bitmap bitmap) {
        final ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap$CompressFormat.PNG, 100, (OutputStream)byteArrayOutputStream);
        final byte[] byteArray = byteArrayOutputStream.toByteArray();
        final StringBuilder sb = new StringBuilder();
        for (int i = 0; i < byteArray.length - 1; ++i) {
            sb.append(byteArray[i]);
            sb.append(",");
        }
        sb.append(byteArray[byteArray.length - 1]);
        return sb.toString();
    }
    
    private static BitmapDrawable getBackwardDisableDrawable(final Context context) {
        if (AdMarvelUtils.getAdMarvelOptionalFlags() != null && AdMarvelUtils.getAdMarvelOptionalFlags().get("MKlWddpjgeIrBuZxnd37tVjz7OM7fu") != null) {
            try {
                return AdMarvelBitmapDrawableUtils$a.a.a(context, AdMarvelUtils.getAdMarvelOptionalFlags().get("MKlWddpjgeIrBuZxnd37tVjz7OM7fu"));
            }
            catch (Exception ex) {
                Logging.log("Error in setting custom bitmap for back_disable");
                return bitmapFromJar("backward_disable", context);
            }
        }
        return bitmapFromJar("backward_disable", context);
    }
    
    private static BitmapDrawable getBackwardDrawable(final Context context) {
        if (AdMarvelUtils.getAdMarvelOptionalFlags() != null && AdMarvelUtils.getAdMarvelOptionalFlags().get("rd2KvT4Zi0NK9A0CejrW35pciQ002l") != null) {
            try {
                return AdMarvelBitmapDrawableUtils$a.b.a(context, AdMarvelUtils.getAdMarvelOptionalFlags().get("rd2KvT4Zi0NK9A0CejrW35pciQ002l"));
            }
            catch (Exception ex) {
                Logging.log("Error in setting custom bitmap for back ");
                return bitmapFromJar("backward", context);
            }
        }
        return bitmapFromJar("backward", context);
    }
    
    public static BitmapDrawable getBitMapDrawable(final String s, final Context context) {
        if (s.equals("backward_disable")) {
            return getBackwardDisableDrawable(context);
        }
        if (s.equals("backward")) {
            return getBackwardDrawable(context);
        }
        if (s.equals("close")) {
            return getCloseDrawable(context);
        }
        if (s.equals("done")) {
            return getDoneDrawable(context);
        }
        if (s.equals("mute")) {
            return getMuteDrawable(context);
        }
        if (s.equals("open_url_disabled")) {
            return getOpenUrlDisabledDrawable(context);
        }
        if (s.equals("open_url")) {
            return getOpenUrlDrawable(context);
        }
        if (s.equals("pause")) {
            return getPauseDrawable(context);
        }
        if (s.equals("play_movie")) {
            return getPlayDrawable(context);
        }
        if (s.equals("replay")) {
            return getReplayDrawable(context);
        }
        if (s.equals("resume_disable")) {
            return getResumeDisableDrawable(context);
        }
        if (s.equals("resume")) {
            return getResumeDrawable(context);
        }
        if (s.equals("stop")) {
            return getStopDrawable(context);
        }
        if (s.equals("time")) {
            return getTimeDrawable(context);
        }
        if (s.equals("unmute")) {
            return getUnmuteDrawable(context);
        }
        return null;
    }
    
    private static BitmapDrawable getCloseDrawable(final Context context) {
        if (AdMarvelUtils.getAdMarvelOptionalFlags() != null && AdMarvelUtils.getAdMarvelOptionalFlags().get("OCkD4Sjg8bN0h8bDad6gWa5t51Zy5I") != null) {
            try {
                return AdMarvelBitmapDrawableUtils$a.c.a(context, AdMarvelUtils.getAdMarvelOptionalFlags().get("OCkD4Sjg8bN0h8bDad6gWa5t51Zy5I"));
            }
            catch (Exception ex) {
                Logging.log("Error in setting custom bitmap for close ");
                return bitmapFromJar("close", context);
            }
        }
        return bitmapFromJar("close", context);
    }
    
    private static BitmapDrawable getDoneDrawable(final Context context) {
        if (AdMarvelUtils.getAdMarvelOptionalFlags() != null && AdMarvelUtils.getAdMarvelOptionalFlags().get("USuSmQSCwrDx1CXCp4oqplFBGTQAZM") != null) {
            try {
                return AdMarvelBitmapDrawableUtils$a.d.a(context, AdMarvelUtils.getAdMarvelOptionalFlags().get("USuSmQSCwrDx1CXCp4oqplFBGTQAZM"));
            }
            catch (Exception ex) {
                Logging.log("Error in setting custom bitmap for done ");
                return bitmapFromJar("done", context);
            }
        }
        return bitmapFromJar("done", context);
    }
    
    private static BitmapDrawable getMuteDrawable(final Context context) {
        if (AdMarvelUtils.getAdMarvelOptionalFlags() != null && AdMarvelUtils.getAdMarvelOptionalFlags().get("u2nfwuKbaKzVwGmUNmk7wFVXHwzy7S") != null) {
            try {
                return AdMarvelBitmapDrawableUtils$a.e.a(context, AdMarvelUtils.getAdMarvelOptionalFlags().get("u2nfwuKbaKzVwGmUNmk7wFVXHwzy7S"));
            }
            catch (Exception ex) {
                Logging.log("Error in setting custom bitmap for mute ");
                return bitmapFromJar("mute", context);
            }
        }
        return bitmapFromJar("mute", context);
    }
    
    private static BitmapDrawable getOpenUrlDisabledDrawable(final Context context) {
        if (AdMarvelUtils.getAdMarvelOptionalFlags() != null && AdMarvelUtils.getAdMarvelOptionalFlags().get("H2GFZHEOwlzVJk4cBatArzxlb2XOJH") != null) {
            try {
                return AdMarvelBitmapDrawableUtils$a.n.a(context, AdMarvelUtils.getAdMarvelOptionalFlags().get("H2GFZHEOwlzVJk4cBatArzxlb2XOJH"));
            }
            catch (Exception ex) {
                Logging.log("Error in setting custom bitmap for open_url_disabled ");
                return bitmapFromJar("open_url_disabled", context);
            }
        }
        return bitmapFromJar("open_url_disabled", context);
    }
    
    private static BitmapDrawable getOpenUrlDrawable(final Context context) {
        if (AdMarvelUtils.getAdMarvelOptionalFlags() != null && AdMarvelUtils.getAdMarvelOptionalFlags().get("nRdOcYYrMLotmPFqlTcjFIf7isxM5t") != null) {
            try {
                return AdMarvelBitmapDrawableUtils$a.o.a(context, AdMarvelUtils.getAdMarvelOptionalFlags().get("nRdOcYYrMLotmPFqlTcjFIf7isxM5t"));
            }
            catch (Exception ex) {
                Logging.log("Error in setting custom bitmap for open_url  ");
                return bitmapFromJar("open_url", context);
            }
        }
        return bitmapFromJar("open_url", context);
    }
    
    private static BitmapDrawable getPauseDrawable(final Context context) {
        if (AdMarvelUtils.getAdMarvelOptionalFlags() != null && AdMarvelUtils.getAdMarvelOptionalFlags().get("d2UpTWfkssmtbKnAqIR6WGdcMl4Gg8") != null) {
            try {
                return AdMarvelBitmapDrawableUtils$a.f.a(context, AdMarvelUtils.getAdMarvelOptionalFlags().get("d2UpTWfkssmtbKnAqIR6WGdcMl4Gg8"));
            }
            catch (Exception ex) {
                Logging.log("Error in setting custom bitmap for pause  ");
                return bitmapFromJar("pause", context);
            }
        }
        return bitmapFromJar("pause", context);
    }
    
    private static BitmapDrawable getPlayDrawable(final Context context) {
        if (AdMarvelUtils.getAdMarvelOptionalFlags() != null && AdMarvelUtils.getAdMarvelOptionalFlags().get("aSrZSorTa7PztrNZ4FuMvViHEaGfDV") != null) {
            try {
                return AdMarvelBitmapDrawableUtils$a.g.a(context, AdMarvelUtils.getAdMarvelOptionalFlags().get("aSrZSorTa7PztrNZ4FuMvViHEaGfDV"));
            }
            catch (Exception ex) {
                Logging.log("Error in setting custom bitmap for play  ");
                return bitmapFromJar("play_movie", context);
            }
        }
        return bitmapFromJar("play_movie", context);
    }
    
    private static BitmapDrawable getReplayDrawable(final Context context) {
        if (AdMarvelUtils.getAdMarvelOptionalFlags() != null && AdMarvelUtils.getAdMarvelOptionalFlags().get("ej5yqIooDTRYYsXEJuN4eJOh7buHJI") != null) {
            try {
                return AdMarvelBitmapDrawableUtils$a.h.a(context, AdMarvelUtils.getAdMarvelOptionalFlags().get("ej5yqIooDTRYYsXEJuN4eJOh7buHJI"));
            }
            catch (Exception ex) {
                Logging.log("Error in setting custom bitmap for replay  ");
                return bitmapFromJar("replay", context);
            }
        }
        return bitmapFromJar("replay", context);
    }
    
    private static BitmapDrawable getResumeDisableDrawable(final Context context) {
        if (AdMarvelUtils.getAdMarvelOptionalFlags() != null && AdMarvelUtils.getAdMarvelOptionalFlags().get("NCLuZlSXjDualh2uti1kSm8vWlELL9") != null) {
            try {
                return AdMarvelBitmapDrawableUtils$a.i.a(context, AdMarvelUtils.getAdMarvelOptionalFlags().get("NCLuZlSXjDualh2uti1kSm8vWlELL9"));
            }
            catch (Exception ex) {
                Logging.log("Error in setting custom bitmap for resume disable  ");
                return bitmapFromJar("resume_disable", context);
            }
        }
        return bitmapFromJar("resume_disable", context);
    }
    
    private static BitmapDrawable getResumeDrawable(final Context context) {
        if (AdMarvelUtils.getAdMarvelOptionalFlags() != null && AdMarvelUtils.getAdMarvelOptionalFlags().get("UPuOOqinUE2sqnnpe8MYG7PzHVVl5p") != null) {
            try {
                return AdMarvelBitmapDrawableUtils$a.j.a(context, AdMarvelUtils.getAdMarvelOptionalFlags().get("UPuOOqinUE2sqnnpe8MYG7PzHVVl5p"));
            }
            catch (Exception ex) {
                Logging.log("Error in setting custom bitmap for resume  ");
                return bitmapFromJar("resume", context);
            }
        }
        return bitmapFromJar("resume", context);
    }
    
    private static BitmapDrawable getStopDrawable(final Context context) {
        if (AdMarvelUtils.getAdMarvelOptionalFlags() != null && AdMarvelUtils.getAdMarvelOptionalFlags().get("yz6T5xsau00Hqg556ez5NwTY2IsOW1") != null) {
            try {
                return AdMarvelBitmapDrawableUtils$a.k.a(context, AdMarvelUtils.getAdMarvelOptionalFlags().get("yz6T5xsau00Hqg556ez5NwTY2IsOW1"));
            }
            catch (Exception ex) {
                Logging.log("Error in setting custom bitmap for resume  ");
                return bitmapFromJar("stop", context);
            }
        }
        return bitmapFromJar("stop", context);
    }
    
    private static BitmapDrawable getTimeDrawable(final Context context) {
        if (AdMarvelUtils.getAdMarvelOptionalFlags() != null && AdMarvelUtils.getAdMarvelOptionalFlags().get("I9Kg1IJB4gtPeHhlB0pvKW5yqcRf2o") != null) {
            try {
                return AdMarvelBitmapDrawableUtils$a.l.a(context, AdMarvelUtils.getAdMarvelOptionalFlags().get("I9Kg1IJB4gtPeHhlB0pvKW5yqcRf2o"));
            }
            catch (Exception ex) {
                Logging.log("Error in setting custom bitmap for resume  ");
                return bitmapFromJar("time", context);
            }
        }
        return bitmapFromJar("time", context);
    }
    
    private static BitmapDrawable getUnmuteDrawable(final Context context) {
        if (AdMarvelUtils.getAdMarvelOptionalFlags() != null && AdMarvelUtils.getAdMarvelOptionalFlags().get("kOy0RFIzirRqTweJUasQ2qaqYyPhm4") != null) {
            try {
                return AdMarvelBitmapDrawableUtils$a.m.a(context, AdMarvelUtils.getAdMarvelOptionalFlags().get("kOy0RFIzirRqTweJUasQ2qaqYyPhm4"));
            }
            catch (Exception ex) {
                Logging.log("Error in setting custom bitmap for unmute  ");
                return bitmapFromJar("unmute", context);
            }
        }
        return bitmapFromJar("unmute", context);
    }
    
    public static void writeByteArrayFromBitMap(final int p0, final Context p1, final String p2) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: astore_3       
        //     2: aload_1        
        //     3: invokevirtual   android/content/Context.getResources:()Landroid/content/res/Resources;
        //     6: iload_0        
        //     7: invokestatic    android/graphics/BitmapFactory.decodeResource:(Landroid/content/res/Resources;I)Landroid/graphics/Bitmap;
        //    10: astore_1       
        //    11: new             Ljava/io/ByteArrayOutputStream;
        //    14: dup            
        //    15: invokespecial   java/io/ByteArrayOutputStream.<init>:()V
        //    18: astore          4
        //    20: aload_1        
        //    21: getstatic       android/graphics/Bitmap$CompressFormat.PNG:Landroid/graphics/Bitmap$CompressFormat;
        //    24: bipush          100
        //    26: aload           4
        //    28: invokevirtual   android/graphics/Bitmap.compress:(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
        //    31: pop            
        //    32: aload           4
        //    34: invokevirtual   java/io/ByteArrayOutputStream.toByteArray:()[B
        //    37: astore          4
        //    39: new             Ljava/lang/StringBuilder;
        //    42: dup            
        //    43: invokespecial   java/lang/StringBuilder.<init>:()V
        //    46: astore          5
        //    48: new             Ljava/io/File;
        //    51: dup            
        //    52: invokestatic    android/os/Environment.getExternalStorageDirectory:()Ljava/io/File;
        //    55: ldc_w           "AdmBitmapTemp"
        //    58: invokespecial   java/io/File.<init>:(Ljava/io/File;Ljava/lang/String;)V
        //    61: astore_1       
        //    62: aload_1        
        //    63: invokevirtual   java/io/File.exists:()Z
        //    66: ifne            74
        //    69: aload_1        
        //    70: invokevirtual   java/io/File.mkdir:()Z
        //    73: pop            
        //    74: new             Ljava/io/File;
        //    77: dup            
        //    78: aload_1        
        //    79: new             Ljava/lang/StringBuilder;
        //    82: dup            
        //    83: invokespecial   java/lang/StringBuilder.<init>:()V
        //    86: aload_2        
        //    87: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //    90: ldc_w           ".txt"
        //    93: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //    96: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //    99: invokespecial   java/io/File.<init>:(Ljava/io/File;Ljava/lang/String;)V
        //   102: astore_1       
        //   103: aload_1        
        //   104: invokevirtual   java/io/File.createNewFile:()Z
        //   107: pop            
        //   108: aload_1        
        //   109: ifnonnull       167
        //   112: return         
        //   113: astore_2       
        //   114: aconst_null    
        //   115: astore_1       
        //   116: getstatic       java/lang/System.out:Ljava/io/PrintStream;
        //   119: new             Ljava/lang/StringBuilder;
        //   122: dup            
        //   123: ldc_w           "ex: "
        //   126: invokespecial   java/lang/StringBuilder.<init>:(Ljava/lang/String;)V
        //   129: aload_2        
        //   130: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/Object;)Ljava/lang/StringBuilder;
        //   133: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   136: invokevirtual   java/io/PrintStream.println:(Ljava/lang/String;)V
        //   139: goto            108
        //   142: astore_1       
        //   143: getstatic       java/lang/System.out:Ljava/io/PrintStream;
        //   146: new             Ljava/lang/StringBuilder;
        //   149: dup            
        //   150: ldc_w           "e: "
        //   153: invokespecial   java/lang/StringBuilder.<init>:(Ljava/lang/String;)V
        //   156: aload_1        
        //   157: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/Object;)Ljava/lang/StringBuilder;
        //   160: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   163: invokevirtual   java/io/PrintStream.println:(Ljava/lang/String;)V
        //   166: return         
        //   167: new             Ljava/io/PrintWriter;
        //   170: dup            
        //   171: aload_1        
        //   172: invokevirtual   java/io/File.getAbsolutePath:()Ljava/lang/String;
        //   175: ldc_w           "UTF-8"
        //   178: invokespecial   java/io/PrintWriter.<init>:(Ljava/lang/String;Ljava/lang/String;)V
        //   181: astore_1       
        //   182: aload_1        
        //   183: ifnull          112
        //   186: aload           5
        //   188: ldc_w           "{"
        //   191: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   194: pop            
        //   195: aload_1        
        //   196: ldc_w           "{"
        //   199: invokevirtual   java/io/PrintWriter.print:(Ljava/lang/String;)V
        //   202: iconst_0       
        //   203: istore_0       
        //   204: iload_0        
        //   205: aload           4
        //   207: arraylength    
        //   208: if_icmpge       270
        //   211: aload           5
        //   213: aload           4
        //   215: iload_0        
        //   216: baload         
        //   217: invokevirtual   java/lang/StringBuilder.append:(I)Ljava/lang/StringBuilder;
        //   220: pop            
        //   221: aload           5
        //   223: ldc             ","
        //   225: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   228: pop            
        //   229: aload_1        
        //   230: aload           4
        //   232: iload_0        
        //   233: baload         
        //   234: invokevirtual   java/io/PrintWriter.print:(I)V
        //   237: aload_1        
        //   238: ldc             ","
        //   240: invokevirtual   java/io/PrintWriter.print:(Ljava/lang/String;)V
        //   243: iload_0        
        //   244: iconst_1       
        //   245: iadd           
        //   246: istore_0       
        //   247: goto            204
        //   250: astore_1       
        //   251: aload_1        
        //   252: invokevirtual   java/io/FileNotFoundException.printStackTrace:()V
        //   255: aload_3        
        //   256: astore_1       
        //   257: goto            182
        //   260: astore_1       
        //   261: aload_1        
        //   262: invokevirtual   java/io/UnsupportedEncodingException.printStackTrace:()V
        //   265: aload_3        
        //   266: astore_1       
        //   267: goto            182
        //   270: aload_1        
        //   271: ldc_w           "}"
        //   274: invokevirtual   java/io/PrintWriter.print:(Ljava/lang/String;)V
        //   277: aload           5
        //   279: ldc_w           "}"
        //   282: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   285: pop            
        //   286: aload_1        
        //   287: ifnull          112
        //   290: aload_1        
        //   291: invokevirtual   java/io/PrintWriter.close:()V
        //   294: return         
        //   295: astore_2       
        //   296: goto            116
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                                  
        //  -----  -----  -----  -----  --------------------------------------
        //  48     74     142    167    Ljava/lang/Exception;
        //  74     103    113    116    Ljava/lang/Exception;
        //  103    108    295    299    Ljava/lang/Exception;
        //  116    139    142    167    Ljava/lang/Exception;
        //  167    182    250    260    Ljava/io/FileNotFoundException;
        //  167    182    260    270    Ljava/io/UnsupportedEncodingException;
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0108:
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
