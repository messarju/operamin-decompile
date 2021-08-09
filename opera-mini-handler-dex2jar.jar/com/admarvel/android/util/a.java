// 
// Decompiled by Procyon v0.6-prerelease
// 

package com.admarvel.android.util;

import java.io.UnsupportedEncodingException;
import android.view.View;
import java.io.FileNotFoundException;
import java.io.OutputStream;
import android.graphics.Bitmap$CompressFormat;
import java.io.FileOutputStream;
import android.app.Activity;
import com.admarvel.android.ads.AdMarvelUtils;
import java.util.UUID;
import android.content.SharedPreferences;
import android.os.Build$VERSION;
import java.util.regex.Matcher;
import java.io.IOException;
import java.util.regex.Pattern;
import java.io.RandomAccessFile;
import android.content.SharedPreferences$Editor;
import java.io.FilenameFilter;
import android.content.Context;
import java.io.File;
import java.io.PrintWriter;
import java.lang.ref.WeakReference;

public class a
{
    private static volatile a b;
    private static WeakReference f;
    PrintWriter a;
    private int c;
    private File d;
    private File e;
    private String g;
    
    private a(Context listFiles) {
        this.c = 20;
        this.g = "admarvel_adHistory";
        this.a = null;
        if (listFiles == null) {
            com.admarvel.android.util.a.f = null;
        }
        else {
            listFiles = (com.admarvel.android.util.a.f = new WeakReference((T)listFiles)).get();
            while (true) {
                try {
                    this.d = ((Context)listFiles).getDir("Admarvel", 0);
                    this.e = new File(this.d, this.g);
                    if (this.e != null) {
                        if (this.e.mkdir()) {
                            this.a((Context)listFiles, 0);
                        }
                        listFiles = this.e.listFiles(new FilenameFilter() {
                            @Override
                            public boolean accept(final File file, final String s) {
                                return s.toLowerCase().endsWith(".zip");
                            }
                        });
                        if (listFiles != null && listFiles.length > 0) {
                            for (int length = listFiles.length, i = 0; i < length; ++i) {
                                listFiles[i].delete();
                            }
                        }
                    }
                }
                catch (Exception ex) {
                    ex.printStackTrace();
                    continue;
                }
                break;
            }
        }
    }
    
    private void a(final Context context, final int n) {
        synchronized (this) {
            final SharedPreferences$Editor edit = context.getSharedPreferences("Ad_history_counter", 0).edit();
            edit.putInt("ad_dump_count", n);
            edit.commit();
        }
    }
    
    private void a(final String p0, final String p1) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     3: dup            
        //     4: aload_2        
        //     5: invokespecial   java/io/File.<init>:(Ljava/lang/String;)V
        //     8: astore_3       
        //     9: aload_3        
        //    10: astore_2       
        //    11: new             Lcom/admarvel/android/util/k;
        //    14: dup            
        //    15: aload_1        
        //    16: ldc             "utf-8"
        //    18: invokespecial   com/admarvel/android/util/k.<init>:(Ljava/lang/String;Ljava/lang/String;)V
        //    21: astore_1       
        //    22: aload_3        
        //    23: astore_2       
        //    24: aload_1        
        //    25: ldc             "fileUpload"
        //    27: aload_3        
        //    28: invokevirtual   com/admarvel/android/util/k.a:(Ljava/lang/String;Ljava/io/File;)V
        //    31: aload_3        
        //    32: astore_2       
        //    33: aload_1        
        //    34: invokevirtual   com/admarvel/android/util/k.a:()Ljava/util/List;
        //    37: pop            
        //    38: aload_3        
        //    39: invokevirtual   java/io/File.delete:()Z
        //    42: ifne            50
        //    45: ldc             "Unable to delete AdHistory zip file"
        //    47: invokestatic    com/admarvel/android/util/Logging.log:(Ljava/lang/String;)V
        //    50: return         
        //    51: astore          4
        //    53: aconst_null    
        //    54: astore_1       
        //    55: aload_1        
        //    56: astore_2       
        //    57: aload           4
        //    59: invokestatic    android/util/Log.getStackTraceString:(Ljava/lang/Throwable;)Ljava/lang/String;
        //    62: invokestatic    com/admarvel/android/util/Logging.log:(Ljava/lang/String;)V
        //    65: aload_1        
        //    66: ifnull          50
        //    69: aload_1        
        //    70: invokevirtual   java/io/File.delete:()Z
        //    73: ifne            50
        //    76: ldc             "Unable to delete AdHistory zip file"
        //    78: invokestatic    com/admarvel/android/util/Logging.log:(Ljava/lang/String;)V
        //    81: return         
        //    82: astore_1       
        //    83: aconst_null    
        //    84: astore_2       
        //    85: aload_2        
        //    86: ifnull          101
        //    89: aload_2        
        //    90: invokevirtual   java/io/File.delete:()Z
        //    93: ifne            101
        //    96: ldc             "Unable to delete AdHistory zip file"
        //    98: invokestatic    com/admarvel/android/util/Logging.log:(Ljava/lang/String;)V
        //   101: aload_1        
        //   102: athrow         
        //   103: astore_1       
        //   104: goto            85
        //   107: astore          4
        //   109: aload_3        
        //   110: astore_1       
        //   111: goto            55
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                 
        //  -----  -----  -----  -----  ---------------------
        //  0      9      51     55     Ljava/lang/Exception;
        //  0      9      82     85     Any
        //  11     22     107    114    Ljava/lang/Exception;
        //  11     22     103    107    Any
        //  24     31     107    114    Ljava/lang/Exception;
        //  24     31     103    107    Any
        //  33     38     107    114    Ljava/lang/Exception;
        //  33     38     103    107    Any
        //  57     65     103    107    Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0050:
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
    
    private double b() {
        try {
            final RandomAccessFile randomAccessFile = new RandomAccessFile("/proc/meminfo", "r");
            final Matcher matcher = Pattern.compile("(\\d+)").matcher(randomAccessFile.readLine());
            String group = "";
            while (matcher.find()) {
                group = matcher.group(1);
            }
            randomAccessFile.close();
            return Double.parseDouble(group);
        }
        catch (IOException ex) {
            ex.printStackTrace();
            return 0.0;
        }
        catch (Exception ex2) {
            ex2.printStackTrace();
            return 0.0;
        }
    }
    
    public static a b(final Context context) {
        if (a.b == null && context != null) {
            a.b = new a(context);
        }
        a.f = new WeakReference((T)context);
        return a.b;
    }
    
    private void b(final int n) {
        try {
            final StringBuilder sb = new StringBuilder();
            sb.append("/sse_");
            sb.append(n);
            sb.append(".jpg");
            final File file = new File(this.e.getAbsolutePath() + (Object)sb);
            if (file.exists()) {
                file.delete();
            }
            final StringBuilder sb2 = new StringBuilder();
            sb2.append("/ssr_");
            sb2.append(n);
            sb2.append(".jpg");
            final File file2 = new File(this.e.getAbsolutePath() + (Object)sb2);
            if (file2.exists()) {
                file2.delete();
            }
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    private int c(final Context context) {
        synchronized (this) {
            return context.getSharedPreferences("Ad_history_counter", 0).getInt("ad_dump_count", 0);
        }
    }
    
    private boolean d(final Context context) {
        while (true) {
            while (true) {
                try {
                    final double b = this.b();
                    if (b > 0.0) {
                        final double n = b / 1024.0;
                        if (n != -1.0 && n < 450.0) {
                            return true;
                        }
                        break;
                    }
                }
                catch (Exception ex) {
                    ex.printStackTrace();
                }
                final double n = -1.0;
                continue;
            }
        }
        return false;
    }
    
    private boolean e(final Context context) {
        return Build$VERSION.SDK_INT < 10 || this.d(context);
    }
    
    public int a(final Context context) {
        synchronized (this) {
            final SharedPreferences sharedPreferences = context.getSharedPreferences("Ad_history_counter", 0);
            final int n = sharedPreferences.getInt("ad_dump_count", 0) % this.c + 1;
            final SharedPreferences$Editor edit = sharedPreferences.edit();
            edit.putInt("ad_dump_count", n);
            edit.commit();
            return n;
        }
    }
    
    public String a(final int n) {
        final String string = UUID.randomUUID().toString();
        if (AdMarvelUtils.getAndroidSDKVersion() >= 11) {
            com.admarvel.android.util.e.a().b().execute(new a$a(this, string, n));
            return string;
        }
        new a$b(this, string).execute((Object[])new Integer[] { n });
        return string;
    }
    
    public void a(final String s) {
        monitorenter(this);
        try {
            final Context context = (Context)com.admarvel.android.util.a.f.get();
            if (context instanceof Activity) {
                if (this.e(context)) {
                    Logging.log("AdHistory Capture: Screen Dump discarded");
                }
                else {
                    try {
                        final View rootView = ((Activity)context).getWindow().getDecorView().findViewById(16908290).findViewById(16908290).getRootView();
                        if (rootView == null) {
                            return;
                        }
                        final boolean drawingCacheEnabled = rootView.isDrawingCacheEnabled();
                        rootView.setDrawingCacheEnabled(true);
                        final FileOutputStream fileOutputStream = new FileOutputStream(this.e.getAbsolutePath() + s);
                        if (((Activity)context).getResources().getDisplayMetrics().density <= 1.0f) {
                            goto Label_0199;
                        }
                        if (!rootView.getDrawingCache().compress(Bitmap$CompressFormat.JPEG, 15, (OutputStream)fileOutputStream)) {
                            Logging.log("AdHistory Capture: Screen Dump failed");
                        }
                        fileOutputStream.flush();
                        fileOutputStream.close();
                        if (!(boolean)drawingCacheEnabled) {
                            rootView.setDrawingCacheEnabled(false);
                        }
                    }
                    catch (FileNotFoundException ex) {
                        Logging.log(ex.getMessage());
                    }
                    catch (IOException ex2) {
                        Logging.log(ex2.getMessage());
                    }
                    catch (Exception ex3) {
                        ex3.printStackTrace();
                    }
                    catch (OutOfMemoryError outOfMemoryError) {
                        outOfMemoryError.printStackTrace();
                        AdMarvelUtils.disableLogDump();
                    }
                }
            }
        }
        finally {}
    }
    
    public void a(String s, final int n) {
        if (com.admarvel.android.util.a.f == null || com.admarvel.android.util.a.f.get() == null) {
            return;
        }
        final StringBuilder sb = new StringBuilder();
        sb.append("/log_");
        sb.append(n);
        sb.append(".txt");
        while (true) {
            try {
                this.a = new PrintWriter(this.e.getAbsolutePath() + sb.toString(), "UTF-8");
                if (this.a != null) {
                    this.a.print(s);
                    this.a.close();
                }
                s = (String)new StringBuilder();
                ((StringBuilder)s).append("/ss_");
                ((StringBuilder)s).append(n);
                ((StringBuilder)s).append(".jpg");
                this.a(((StringBuilder)s).toString());
                this.b(n);
            }
            catch (FileNotFoundException ex) {
                ex.printStackTrace();
                continue;
            }
            catch (UnsupportedEncodingException ex2) {
                ex2.printStackTrace();
                continue;
            }
            break;
        }
    }
}
