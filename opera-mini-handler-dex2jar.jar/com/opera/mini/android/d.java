// 
// Decompiled by Procyon v0.6-prerelease
// 

package com.opera.mini.android;

import android.net.Uri;
import android.os.Environment;
import java.io.IOException;
import java.io.File;
import android.os.StatFs;
import android.content.Context;
import android.media.MediaScannerConnection;
import android.media.MediaScannerConnection$MediaScannerConnectionClient;

public final class d implements MediaScannerConnection$MediaScannerConnectionClient, as
{
    static MediaScannerConnection Code;
    private Context I;
    
    d() {
        this.I = Browser.Z.getApplicationContext();
        if (d.Code == null) {
            (d.Code = new MediaScannerConnection(this.I, (MediaScannerConnection$MediaScannerConnectionClient)this)).connect();
        }
    }
    
    static long a(final String s) {
        final StatFs statFs = new StatFs(b(s));
        return statFs.getBlockSize() * (long)statFs.getAvailableBlocks();
    }
    
    static String b(final String s) {
        String substring;
        if (s.startsWith("file://")) {
            substring = s.substring(7);
        }
        else {
            substring = s;
            if (s.startsWith("file:")) {
                return s.substring(5);
            }
        }
        return substring;
    }
    
    public final boolean B(final String s) {
        final File file = new File(b(s));
        return !file.exists() || file.delete();
    }
    
    public final int[] B() {
        final int n = 0;
        final String[] fileList = this.I.fileList();
        int i = 0;
        int n2 = 0;
        while (i < fileList.length) {
            int n3 = n2;
            if (ap.c(fileList[i]) != 0) {
                final ap c = u.c;
                n3 = n2;
                if (ap.d(fileList[i]) != 0) {
                    n3 = n2 + 2;
                }
            }
            ++i;
            n2 = n3;
        }
        final int[] array = new int[n2];
        int n4 = n2;
        int n5;
        for (int j = n; j < fileList.length; ++j, n4 = n5) {
            final int c2 = ap.c(fileList[j]);
            n5 = n4;
            if (c2 != 0) {
                final ap c3 = u.c;
                final int d = ap.d(fileList[j]);
                n5 = n4;
                if (d != 0) {
                    final int n6 = n4 - 1;
                    array[n6] = c2;
                    n5 = n6 - 1;
                    array[n5] = d;
                }
            }
        }
        return array;
    }
    
    public final boolean C(final String s) {
        return new File(b(s)).mkdirs();
    }
    
    public final int Code(final byte[] p0, final String p1) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: astore          4
        //     3: aconst_null    
        //     4: astore          5
        //     6: aload_2        
        //     7: invokestatic    com/opera/mini/android/d.b:(Ljava/lang/String;)Ljava/lang/String;
        //    10: astore          6
        //    12: aload_1        
        //    13: ifnull          144
        //    16: aload           4
        //    18: astore_2       
        //    19: new             Ljava/io/DataOutputStream;
        //    22: dup            
        //    23: new             Ljava/io/FileOutputStream;
        //    26: dup            
        //    27: aload           6
        //    29: invokespecial   java/io/FileOutputStream.<init>:(Ljava/lang/String;)V
        //    32: invokespecial   java/io/DataOutputStream.<init>:(Ljava/io/OutputStream;)V
        //    35: astore          4
        //    37: aload           4
        //    39: ldc             47404304
        //    41: invokevirtual   java/io/DataOutputStream.writeInt:(I)V
        //    44: aload           4
        //    46: aload_1        
        //    47: arraylength    
        //    48: bipush          16
        //    50: ishr           
        //    51: invokevirtual   java/io/DataOutputStream.writeByte:(I)V
        //    54: aload           4
        //    56: aload_1        
        //    57: arraylength    
        //    58: invokevirtual   java/io/DataOutputStream.writeShort:(I)V
        //    61: aload           4
        //    63: aload_1        
        //    64: invokevirtual   java/io/DataOutputStream.write:([B)V
        //    67: aload           4
        //    69: invokevirtual   java/io/DataOutputStream.flush:()V
        //    72: aload           4
        //    74: invokestatic    cg.Code:(Ljava/io/OutputStream;)V
        //    77: iconst_0       
        //    78: ireturn        
        //    79: astore          4
        //    81: aload           5
        //    83: astore_1       
        //    84: aload_1        
        //    85: astore_2       
        //    86: aload           4
        //    88: instanceof      Ljava/lang/SecurityException;
        //    91: istore_3       
        //    92: iload_3        
        //    93: ifeq            102
        //    96: aload_1        
        //    97: invokestatic    cg.Code:(Ljava/io/OutputStream;)V
        //   100: iconst_2       
        //   101: ireturn        
        //   102: aload_1        
        //   103: astore_2       
        //   104: aload_0        
        //   105: getfield        com/opera/mini/android/d.I:Landroid/content/Context;
        //   108: aload           6
        //   110: invokevirtual   android/content/Context.deleteFile:(Ljava/lang/String;)Z
        //   113: pop            
        //   114: aload_1        
        //   115: invokestatic    cg.Code:(Ljava/io/OutputStream;)V
        //   118: iconst_1       
        //   119: ireturn        
        //   120: astore_1       
        //   121: aload_2        
        //   122: invokestatic    cg.Code:(Ljava/io/OutputStream;)V
        //   125: aload_1        
        //   126: athrow         
        //   127: astore_1       
        //   128: aload           4
        //   130: astore_2       
        //   131: goto            121
        //   134: astore_2       
        //   135: aload           4
        //   137: astore_1       
        //   138: aload_2        
        //   139: astore          4
        //   141: goto            84
        //   144: aconst_null    
        //   145: astore          4
        //   147: goto            72
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                 
        //  -----  -----  -----  -----  ---------------------
        //  19     37     79     84     Ljava/lang/Throwable;
        //  19     37     120    121    Any
        //  37     72     134    144    Ljava/lang/Throwable;
        //  37     72     127    134    Any
        //  86     92     120    121    Any
        //  104    114    120    121    Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0072:
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
    
    public final ar Code(final String s, final boolean b, final int n) {
        final File file = new File(b(s));
        if (b && !file.exists() && !file.createNewFile()) {
            throw new IOException();
        }
        if ((n & 0x1) != 0x0 && !file.canRead()) {
            throw new IOException();
        }
        if ((n & 0x2) != 0x0 && !file.canWrite()) {
            throw new IOException();
        }
        return new e(this, file);
    }
    
    public final void Code() {
        final String absolutePath = Environment.getExternalStorageDirectory().getAbsolutePath();
        String s;
        if (absolutePath.indexOf("sdcard") != -1) {
            s = "SD Card";
        }
        else {
            s = absolutePath;
        }
        if (Environment.getExternalStorageState().equals("mounted") && u.c.b(absolutePath) == null) {
            u.c.Code(s, absolutePath);
        }
    }
    
    public final boolean Code(final String s) {
        return new File(b(s)).exists();
    }
    
    public final long I(final String s) {
        return new File(b(s)).length();
    }
    
    public final String I() {
        final File file = new File(Environment.getExternalStorageDirectory(), "download");
        if (Environment.getExternalStorageState().equals("mounted") && !file.exists()) {
            file.mkdir();
        }
        return file.getAbsolutePath();
    }
    
    public final String J() {
        return this.I.getCacheDir().getAbsolutePath();
    }
    
    public final byte[] J(final String p0) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: istore_3       
        //     2: aload_1        
        //     3: invokestatic    com/opera/mini/android/d.b:(Ljava/lang/String;)Ljava/lang/String;
        //     6: astore_1       
        //     7: new             Ljava/io/DataInputStream;
        //    10: dup            
        //    11: new             Ljava/io/FileInputStream;
        //    14: dup            
        //    15: aload_1        
        //    16: invokespecial   java/io/FileInputStream.<init>:(Ljava/lang/String;)V
        //    19: invokespecial   java/io/DataInputStream.<init>:(Ljava/io/InputStream;)V
        //    22: astore_1       
        //    23: aload_1        
        //    24: invokevirtual   java/io/DataInputStream.readInt:()I
        //    27: istore_2       
        //    28: iload_2        
        //    29: ldc             47404304
        //    31: if_icmpeq       40
        //    34: aload_1        
        //    35: invokestatic    cg.Code:(Ljava/io/InputStream;)V
        //    38: aconst_null    
        //    39: areturn        
        //    40: iconst_3       
        //    41: newarray        B
        //    43: astore          5
        //    45: iconst_0       
        //    46: istore_2       
        //    47: iload_2        
        //    48: iconst_3       
        //    49: if_icmpge       67
        //    52: aload           5
        //    54: iload_2        
        //    55: aload_1        
        //    56: invokevirtual   java/io/DataInputStream.readByte:()B
        //    59: bastore        
        //    60: iload_2        
        //    61: iconst_1       
        //    62: iadd           
        //    63: istore_2       
        //    64: goto            47
        //    67: aload           5
        //    69: iconst_0       
        //    70: baload         
        //    71: istore_2       
        //    72: aload           5
        //    74: iconst_1       
        //    75: baload         
        //    76: istore          4
        //    78: aload           5
        //    80: iconst_2       
        //    81: baload         
        //    82: sipush          255
        //    85: iand           
        //    86: iload_2        
        //    87: sipush          255
        //    90: iand           
        //    91: bipush          16
        //    93: ishl           
        //    94: iload           4
        //    96: sipush          255
        //    99: iand           
        //   100: bipush          8
        //   102: ishl           
        //   103: iadd           
        //   104: iadd           
        //   105: istore          4
        //   107: iload           4
        //   109: newarray        B
        //   111: astore          5
        //   113: iload_3        
        //   114: istore_2       
        //   115: iload_2        
        //   116: iload           4
        //   118: if_icmpge       146
        //   121: aload_1        
        //   122: aload           5
        //   124: iload_2        
        //   125: sipush          1024
        //   128: iload           4
        //   130: iload_2        
        //   131: isub           
        //   132: invokestatic    java/lang/Math.min:(II)I
        //   135: invokevirtual   java/io/DataInputStream.read:([BII)I
        //   138: istore_3       
        //   139: iload_2        
        //   140: iload_3        
        //   141: iadd           
        //   142: istore_2       
        //   143: goto            115
        //   146: aload_1        
        //   147: invokestatic    cg.Code:(Ljava/io/InputStream;)V
        //   150: aload           5
        //   152: areturn        
        //   153: astore_1       
        //   154: aconst_null    
        //   155: astore_1       
        //   156: aload_1        
        //   157: invokestatic    cg.Code:(Ljava/io/InputStream;)V
        //   160: aconst_null    
        //   161: areturn        
        //   162: astore_1       
        //   163: aconst_null    
        //   164: astore          6
        //   166: aload_1        
        //   167: astore          5
        //   169: aload           6
        //   171: invokestatic    cg.Code:(Ljava/io/InputStream;)V
        //   174: aload           5
        //   176: athrow         
        //   177: astore          5
        //   179: aload_1        
        //   180: astore          6
        //   182: goto            169
        //   185: astore          5
        //   187: goto            156
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                 
        //  -----  -----  -----  -----  ---------------------
        //  7      23     153    156    Ljava/io/IOException;
        //  7      23     162    169    Any
        //  23     28     185    190    Ljava/io/IOException;
        //  23     28     177    185    Any
        //  40     45     185    190    Ljava/io/IOException;
        //  40     45     177    185    Any
        //  52     60     185    190    Ljava/io/IOException;
        //  52     60     177    185    Any
        //  107    113    185    190    Ljava/io/IOException;
        //  107    113    177    185    Any
        //  121    139    185    190    Ljava/io/IOException;
        //  121    139    177    185    Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0040:
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
    
    public final long Z(final String s) {
        return a(s);
    }
    
    public final String Z() {
        return this.I.getFilesDir().getAbsolutePath();
    }
    
    public final void onMediaScannerConnected() {
    }
    
    public final void onScanCompleted(final String s, final Uri uri) {
    }
}
