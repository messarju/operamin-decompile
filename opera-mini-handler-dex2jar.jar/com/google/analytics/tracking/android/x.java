// 
// Decompiled by Procyon v0.6-prerelease
// 

package com.google.analytics.tracking.android;

import java.io.File;
import java.util.Iterator;
import java.util.HashMap;
import android.text.TextUtils;
import java.util.UUID;
import java.util.Collection;
import java.util.ArrayList;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.util.Map;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.ByteArrayOutputStream;
import android.content.Context;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.List;

final class x extends Thread implements f
{
    private static x c;
    private volatile List B;
    private volatile af C;
    private final LinkedBlockingQueue Code;
    private volatile boolean I;
    private volatile boolean J;
    private volatile boolean Z;
    private volatile String a;
    private volatile String b;
    private volatile am d;
    private final Context e;
    
    private x(final Context e) {
        super("GAThread");
        this.Code = new LinkedBlockingQueue();
        this.I = false;
        this.Z = false;
        if (e != null) {
            this.e = e.getApplicationContext();
        }
        else {
            this.e = e;
        }
        this.start();
    }
    
    static x Code(final Context context) {
        if (x.c == null) {
            x.c = new x(context);
        }
        return x.c;
    }
    
    private static String Code(final Throwable t) {
        final ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        final PrintStream printStream = new PrintStream(byteArrayOutputStream);
        t.printStackTrace(printStream);
        printStream.flush();
        return new String(byteArrayOutputStream.toByteArray());
    }
    
    static /* synthetic */ void Code(final x p0, final Map p1) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: getfield        com/google/analytics/tracking/android/x.e:Landroid/content/Context;
        //     4: invokevirtual   android/content/Context.getPackageManager:()Landroid/content/pm/PackageManager;
        //     7: astore          6
        //     9: aload_0        
        //    10: getfield        com/google/analytics/tracking/android/x.e:Landroid/content/Context;
        //    13: invokevirtual   android/content/Context.getPackageName:()Ljava/lang/String;
        //    16: astore_2       
        //    17: aload           6
        //    19: aload_2        
        //    20: invokevirtual   android/content/pm/PackageManager.getInstallerPackageName:(Ljava/lang/String;)Ljava/lang/String;
        //    23: astore          5
        //    25: aconst_null    
        //    26: astore_3       
        //    27: aload           6
        //    29: aload_0        
        //    30: getfield        com/google/analytics/tracking/android/x.e:Landroid/content/Context;
        //    33: invokevirtual   android/content/Context.getPackageName:()Ljava/lang/String;
        //    36: iconst_0       
        //    37: invokevirtual   android/content/pm/PackageManager.getPackageInfo:(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;
        //    40: astore          4
        //    42: aload           4
        //    44: ifnull          143
        //    47: aload           6
        //    49: aload           4
        //    51: getfield        android/content/pm/PackageInfo.applicationInfo:Landroid/content/pm/ApplicationInfo;
        //    54: invokevirtual   android/content/pm/PackageManager.getApplicationLabel:(Landroid/content/pm/ApplicationInfo;)Ljava/lang/CharSequence;
        //    57: invokevirtual   java/lang/Object.toString:()Ljava/lang/String;
        //    60: astore_0       
        //    61: aload           4
        //    63: getfield        android/content/pm/PackageInfo.versionName:Ljava/lang/String;
        //    66: astore          4
        //    68: aload           4
        //    70: astore_3       
        //    71: aload_1        
        //    72: ldc             "appName"
        //    74: aload_0        
        //    75: invokestatic    com/google/analytics/tracking/android/x.Code:(Ljava/util/Map;Ljava/lang/String;Ljava/lang/String;)V
        //    78: aload_1        
        //    79: ldc             "appVersion"
        //    81: aload_3        
        //    82: invokestatic    com/google/analytics/tracking/android/x.Code:(Ljava/util/Map;Ljava/lang/String;Ljava/lang/String;)V
        //    85: aload_1        
        //    86: ldc             "appId"
        //    88: aload_2        
        //    89: invokestatic    com/google/analytics/tracking/android/x.Code:(Ljava/util/Map;Ljava/lang/String;Ljava/lang/String;)V
        //    92: aload_1        
        //    93: ldc             "appInstallerId"
        //    95: aload           5
        //    97: invokestatic    com/google/analytics/tracking/android/x.Code:(Ljava/util/Map;Ljava/lang/String;Ljava/lang/String;)V
        //   100: aload_1        
        //   101: ldc             "apiVersion"
        //   103: ldc             "1"
        //   105: invokeinterface java/util/Map.put:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   110: pop            
        //   111: return         
        //   112: astore_0       
        //   113: aload_2        
        //   114: astore_0       
        //   115: new             Ljava/lang/StringBuilder;
        //   118: dup            
        //   119: ldc             "Error retrieving package info: appName set to "
        //   121: invokespecial   java/lang/StringBuilder.<init>:(Ljava/lang/String;)V
        //   124: aload_0        
        //   125: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   128: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   131: invokestatic    com/google/analytics/tracking/android/ae.I:(Ljava/lang/String;)I
        //   134: pop            
        //   135: goto            71
        //   138: astore          4
        //   140: goto            115
        //   143: aload_2        
        //   144: astore_0       
        //   145: goto            71
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                                                     
        //  -----  -----  -----  -----  ---------------------------------------------------------
        //  27     42     112    115    Landroid/content/pm/PackageManager$NameNotFoundException;
        //  47     61     112    115    Landroid/content/pm/PackageManager$NameNotFoundException;
        //  61     68     138    143    Landroid/content/pm/PackageManager$NameNotFoundException;
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0071:
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
    
    private void Code(final Runnable runnable) {
        this.Code.add(runnable);
    }
    
    private static void Code(final Map map, final String s, final String s2) {
        if (!map.containsKey(s)) {
            map.put(s, s2);
        }
    }
    
    private boolean Code(final String s) {
        try {
            final FileOutputStream openFileOutput = this.e.openFileOutput("gaClientId", 0);
            openFileOutput.write(s.getBytes());
            openFileOutput.close();
            return true;
        }
        catch (FileNotFoundException ex) {
            ae.I("Error creating clientId file.");
            return false;
        }
        catch (IOException ex2) {
            ae.I("Error writing to clientId file.");
            return false;
        }
    }
    
    private static String I(final Context context) {
        try {
            final FileInputStream openFileInput = context.openFileInput("gaInstallData");
            final int read = openFileInput.read(new byte[8192], 0, 8192);
            if (openFileInput.available() > 0) {
                ae.I("Too much campaign data, ignoring it.");
                openFileInput.close();
                context.deleteFile("gaInstallData");
                return null;
            }
            openFileInput.close();
            context.deleteFile("gaInstallData");
            if (read <= 0) {
                ae.C("Campaign file is empty.");
                return null;
            }
            goto Label_0081;
        }
        catch (FileNotFoundException ex) {
            ae.Z("No campaign data found.");
            return null;
        }
        catch (IOException ex2) {
            ae.I("Error reading campaign data.");
            context.deleteFile("gaInstallData");
            return null;
        }
    }
    
    static /* synthetic */ void I(final x x, final Map map) {
        final String s = map.get("rawException");
        if (s == null) {
            return;
        }
        map.remove("rawException");
        final ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(aq.B(s));
        try {
            final ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);
            final Object object = objectInputStream.readObject();
            objectInputStream.close();
            if (object instanceof Throwable) {
                map.put("exDescription", new o(x.e, new ArrayList()).Code(map.get("exceptionThreadName"), (Throwable)object));
            }
        }
        catch (IOException ex) {
            ae.C("IOException reading exception");
        }
        catch (ClassNotFoundException ex2) {
            ae.C("ClassNotFoundException reading exception");
        }
    }
    
    static /* synthetic */ boolean I(final Map map) {
        if (map.get("sampleRate") != null) {
            final double i = aq.I(map.get("sampleRate"));
            if (i <= 0.0) {
                return true;
            }
            if (i < 100.0) {
                final String s = map.get("clientId");
                if (s != null && Math.abs(s.hashCode()) % 10000 >= i * 100.0) {
                    return true;
                }
            }
        }
        return false;
    }
    
    private String J() {
        final String s = null;
        final String s2 = null;
        String lowerCase = null;
        while (true) {
            FileInputStream openFileInput = null;
            try {
                openFileInput = this.e.openFileInput("gaClientId");
                final byte[] array = new byte[128];
                final int read = openFileInput.read(array, 0, 128);
                if (openFileInput.available() > 0) {
                    ae.I("clientId file seems corrupted, deleting it.");
                    openFileInput.close();
                    this.e.deleteFile("gaInstallData");
                }
                String s3;
                if (read <= 0) {
                    ae.I("clientId file seems empty, deleting it.");
                    openFileInput.close();
                    this.e.deleteFile("gaInstallData");
                    s3 = lowerCase;
                }
                else {
                    s3 = new String(array, 0, read);
                    final FileInputStream fileInputStream = openFileInput;
                    fileInputStream.close();
                }
                lowerCase = s3;
                if (s3 == null && !this.Code(lowerCase = UUID.randomUUID().toString().toLowerCase())) {
                    lowerCase = "0";
                }
                return lowerCase;
            }
            catch (IOException s3) {
                s3 = s;
            }
            catch (NumberFormatException s3) {
                s3 = s2;
            }
            catch (FileNotFoundException ex) {
                final String s3 = lowerCase;
                continue;
            }
            try {
                final FileInputStream fileInputStream = openFileInput;
                fileInputStream.close();
                continue;
            }
            catch (NumberFormatException ex2) {}
            catch (IOException ex3) {}
            catch (FileNotFoundException lowerCase) {
                continue;
            }
            break;
        }
    }
    
    static /* synthetic */ String J(final Map map) {
        String s;
        if ((s = map.get("internalHitUrl")) == null) {
            if (!map.containsKey("useSecure")) {
                return "https://ssl.google-analytics.com/collect";
            }
            if (!aq.Z(map.get("useSecure"))) {
                return "http://www.google-analytics.com/collect";
            }
            s = "https://ssl.google-analytics.com/collect";
        }
        return s;
    }
    
    static /* synthetic */ void Z(final Map map) {
        final String j = aq.J(map.get("campaign"));
        if (!TextUtils.isEmpty((CharSequence)j)) {
            final Map code = aq.Code(j);
            map.put("campaignContent", code.get("utm_content"));
            map.put("campaignMedium", code.get("utm_medium"));
            map.put("campaignName", code.get("utm_campaign"));
            map.put("campaignSource", code.get("utm_source"));
            map.put("campaignKeyword", code.get("utm_term"));
            map.put("campaignId", code.get("utm_id"));
            map.put("gclid", code.get("gclid"));
            map.put("dclid", code.get("dclid"));
            map.put("gmob_t", code.get("gmob_t"));
        }
    }
    
    @Override
    public final void Code() {
        this.Code(new Runnable() {
            @Override
            public final void run() {
                x.this.d.Z();
            }
        });
    }
    
    @Override
    public final void Code(final g.g$Code object) {
        this.Code(new Runnable() {
            @Override
            public final void run() {
                object.Code.B = x.this.b;
            }
        });
    }
    
    @Override
    public final void Code(final g.g$I object) {
        this.Code(new Runnable() {
            @Override
            public final void run() {
                object.Code.C = x.this.J;
            }
        });
    }
    
    @Override
    public final void Code(final Map map) {
        final HashMap hashMap = new HashMap(map);
        final long currentTimeMillis = System.currentTimeMillis();
        hashMap.put("hitTime", Long.toString(currentTimeMillis));
        this.Code(new Runnable() {
            @Override
            public final void run() {
                hashMap.put("clientId", x.this.b);
                if (!x.this.J) {
                    final x z = x.this;
                    if (!x.I(hashMap)) {
                        if (!TextUtils.isEmpty((CharSequence)x.this.a)) {
                            hashMap.put("campaign", x.this.a);
                            x.this.a = null;
                        }
                        x.Code(x.this, hashMap);
                        final x z2 = x.this;
                        x.Z(hashMap);
                        x.I(x.this, hashMap);
                        final af b = x.this.C;
                        final Map code = hashMap;
                        final HashMap hashMap = new HashMap();
                        for (final Map.Entry<String, V> entry : code.entrySet()) {
                            final ah code2 = b.Code(entry.getKey());
                            if (code2 != null) {
                                final String code3 = code2.Code(entry.getKey());
                                if (code3 == null) {
                                    continue;
                                }
                                String code4;
                                final String s = code4 = (String)entry.getValue();
                                if (code2.I() != null) {
                                    code4 = code2.I().Code(s);
                                }
                                if (code4 == null || code4.equals(code2.Code())) {
                                    continue;
                                }
                                hashMap.put(code3, code4);
                            }
                        }
                        final am a = x.this.d;
                        final long i = currentTimeMillis;
                        final x z3 = x.this;
                        a.Code(hashMap, i, x.J(hashMap), x.this.B);
                    }
                }
            }
        });
    }
    
    @Override
    public final void Code(final boolean b) {
        this.Code(new Runnable() {
            @Override
            public final void run() {
                if (x.this.J == b) {
                    return;
                }
                while (true) {
                    Label_0075: {
                        if (!b) {
                            break Label_0075;
                        }
                        final File fileStreamPath = x.this.e.getFileStreamPath("gaOptOut");
                        while (true) {
                            try {
                                fileStreamPath.createNewFile();
                                x.this.d.J();
                                x.this.J = b;
                                return;
                            }
                            catch (IOException ex) {
                                ae.C("Error creating optOut file.");
                                continue;
                            }
                            break;
                        }
                    }
                    x.this.e.deleteFile("gaOptOut");
                    continue;
                }
            }
        });
    }
    
    @Override
    public final LinkedBlockingQueue I() {
        return this.Code;
    }
    
    @Override
    public final Thread Z() {
        return this;
    }
    
    @Override
    public final void run() {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     3: invokestatic    java/lang/Thread.sleep:(J)V
        //     6: aload_0        
        //     7: getfield        com/google/analytics/tracking/android/x.d:Lcom/google/analytics/tracking/android/am;
        //    10: ifnonnull       30
        //    13: aload_0        
        //    14: new             Lcom/google/analytics/tracking/android/r;
        //    17: dup            
        //    18: aload_0        
        //    19: getfield        com/google/analytics/tracking/android/x.e:Landroid/content/Context;
        //    22: aload_0        
        //    23: iconst_0       
        //    24: invokespecial   com/google/analytics/tracking/android/r.<init>:(Landroid/content/Context;Lcom/google/analytics/tracking/android/f;B)V
        //    27: putfield        com/google/analytics/tracking/android/x.d:Lcom/google/analytics/tracking/android/am;
        //    30: aload_0        
        //    31: getfield        com/google/analytics/tracking/android/x.d:Lcom/google/analytics/tracking/android/am;
        //    34: invokeinterface com/google/analytics/tracking/android/am.B:()V
        //    39: aload_0        
        //    40: new             Ljava/util/ArrayList;
        //    43: dup            
        //    44: invokespecial   java/util/ArrayList.<init>:()V
        //    47: putfield        com/google/analytics/tracking/android/x.B:Ljava/util/List;
        //    50: aload_0        
        //    51: getfield        com/google/analytics/tracking/android/x.B:Ljava/util/List;
        //    54: new             LB;
        //    57: dup            
        //    58: ldc_w           "appendVersion"
        //    61: ldc_w           "_v"
        //    64: ldc_w           "ma1b5"
        //    67: invokespecial   B.<init>:(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
        //    70: invokeinterface java/util/List.add:(Ljava/lang/Object;)Z
        //    75: pop            
        //    76: aload_0        
        //    77: getfield        com/google/analytics/tracking/android/x.B:Ljava/util/List;
        //    80: new             LB;
        //    83: dup            
        //    84: ldc_w           "appendQueueTime"
        //    87: ldc_w           "qt"
        //    90: aconst_null    
        //    91: invokespecial   B.<init>:(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
        //    94: invokeinterface java/util/List.add:(Ljava/lang/Object;)Z
        //    99: pop            
        //   100: aload_0        
        //   101: getfield        com/google/analytics/tracking/android/x.B:Ljava/util/List;
        //   104: new             LB;
        //   107: dup            
        //   108: ldc_w           "appendCacheBuster"
        //   111: ldc_w           "z"
        //   114: aconst_null    
        //   115: invokespecial   B.<init>:(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
        //   118: invokeinterface java/util/List.add:(Ljava/lang/Object;)Z
        //   123: pop            
        //   124: aload_0        
        //   125: new             Lcom/google/analytics/tracking/android/af;
        //   128: dup            
        //   129: invokespecial   com/google/analytics/tracking/android/af.<init>:()V
        //   132: putfield        com/google/analytics/tracking/android/x.C:Lcom/google/analytics/tracking/android/af;
        //   135: aload_0        
        //   136: getfield        com/google/analytics/tracking/android/x.C:Lcom/google/analytics/tracking/android/af;
        //   139: invokestatic    com/google/analytics/tracking/android/ai.Code:(Lcom/google/analytics/tracking/android/af;)V
        //   142: aload_0        
        //   143: aload_0        
        //   144: getfield        com/google/analytics/tracking/android/x.e:Landroid/content/Context;
        //   147: ldc_w           "gaOptOut"
        //   150: invokevirtual   android/content/Context.getFileStreamPath:(Ljava/lang/String;)Ljava/io/File;
        //   153: invokevirtual   java/io/File.exists:()Z
        //   156: putfield        com/google/analytics/tracking/android/x.J:Z
        //   159: aload_0        
        //   160: aload_0        
        //   161: invokespecial   com/google/analytics/tracking/android/x.J:()Ljava/lang/String;
        //   164: putfield        com/google/analytics/tracking/android/x.b:Ljava/lang/String;
        //   167: aload_0        
        //   168: aload_0        
        //   169: getfield        com/google/analytics/tracking/android/x.e:Landroid/content/Context;
        //   172: invokestatic    com/google/analytics/tracking/android/x.I:(Landroid/content/Context;)Ljava/lang/String;
        //   175: putfield        com/google/analytics/tracking/android/x.a:Ljava/lang/String;
        //   178: aload_0        
        //   179: getfield        com/google/analytics/tracking/android/x.Code:Ljava/util/concurrent/LinkedBlockingQueue;
        //   182: invokevirtual   java/util/concurrent/LinkedBlockingQueue.take:()Ljava/lang/Object;
        //   185: checkcast       Ljava/lang/Runnable;
        //   188: astore_1       
        //   189: aload_0        
        //   190: getfield        com/google/analytics/tracking/android/x.I:Z
        //   193: ifne            178
        //   196: aload_1        
        //   197: invokeinterface java/lang/Runnable.run:()V
        //   202: goto            178
        //   205: astore_1       
        //   206: aload_1        
        //   207: invokevirtual   java/lang/InterruptedException.toString:()Ljava/lang/String;
        //   210: invokestatic    com/google/analytics/tracking/android/ae.Z:(Ljava/lang/String;)I
        //   213: pop            
        //   214: goto            178
        //   217: astore_1       
        //   218: new             Ljava/lang/StringBuilder;
        //   221: dup            
        //   222: ldc_w           "Error on GAThread: "
        //   225: invokespecial   java/lang/StringBuilder.<init>:(Ljava/lang/String;)V
        //   228: aload_1        
        //   229: invokestatic    com/google/analytics/tracking/android/x.Code:(Ljava/lang/Throwable;)Ljava/lang/String;
        //   232: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   235: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   238: invokestatic    com/google/analytics/tracking/android/ae.I:(Ljava/lang/String;)I
        //   241: pop            
        //   242: ldc_w           "Google Analytics is shutting down."
        //   245: invokestatic    com/google/analytics/tracking/android/ae.I:(Ljava/lang/String;)I
        //   248: pop            
        //   249: aload_0        
        //   250: iconst_1       
        //   251: putfield        com/google/analytics/tracking/android/x.I:Z
        //   254: goto            178
        //   257: astore_1       
        //   258: ldc_w           "sleep interrupted in GAThread initialize"
        //   261: invokestatic    com/google/analytics/tracking/android/ae.C:(Ljava/lang/String;)I
        //   264: pop            
        //   265: goto            6
        //   268: astore_1       
        //   269: new             Ljava/lang/StringBuilder;
        //   272: dup            
        //   273: ldc_w           "Error initializing the GAThread: "
        //   276: invokespecial   java/lang/StringBuilder.<init>:(Ljava/lang/String;)V
        //   279: aload_1        
        //   280: invokestatic    com/google/analytics/tracking/android/x.Code:(Ljava/lang/Throwable;)Ljava/lang/String;
        //   283: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   286: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   289: invokestatic    com/google/analytics/tracking/android/ae.I:(Ljava/lang/String;)I
        //   292: pop            
        //   293: ldc_w           "Google Analytics will not start up."
        //   296: invokestatic    com/google/analytics/tracking/android/ae.I:(Ljava/lang/String;)I
        //   299: pop            
        //   300: aload_0        
        //   301: iconst_1       
        //   302: putfield        com/google/analytics/tracking/android/x.I:Z
        //   305: goto            178
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                            
        //  -----  -----  -----  -----  --------------------------------
        //  0      6      257    268    Ljava/lang/InterruptedException;
        //  142    178    268    308    Ljava/lang/Throwable;
        //  178    202    205    217    Ljava/lang/InterruptedException;
        //  178    202    217    257    Ljava/lang/Throwable;
        //  206    214    217    257    Ljava/lang/Throwable;
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0178:
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
