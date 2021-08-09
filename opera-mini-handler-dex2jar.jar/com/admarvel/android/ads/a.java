// 
// Decompiled by Procyon v0.6-prerelease
// 

package com.admarvel.android.ads;

import android.view.MotionEvent;
import android.annotation.SuppressLint;
import android.view.ViewGroup$LayoutParams;
import android.widget.RelativeLayout$LayoutParams;
import java.security.NoSuchAlgorithmException;
import java.security.MessageDigest;
import android.os.AsyncTask;
import android.util.Log;
import java.io.File;
import com.admarvel.android.util.Logging;
import android.media.MediaPlayer;
import android.net.Uri;
import android.media.MediaPlayer$OnPreparedListener;
import android.media.MediaPlayer$OnVideoSizeChangedListener;
import android.view.Surface;
import android.graphics.SurfaceTexture;
import android.media.MediaPlayer$OnBufferingUpdateListener;
import android.media.MediaPlayer$OnErrorListener;
import android.media.MediaPlayer$OnSeekCompleteListener;
import android.media.MediaPlayer$OnCompletionListener;
import java.lang.ref.WeakReference;
import android.content.Context;
import android.annotation.TargetApi;
import android.widget.MediaController$MediaPlayerControl;
import android.view.TextureView$SurfaceTextureListener;
import android.view.TextureView;

@TargetApi(14)
class a extends TextureView implements TextureView$SurfaceTextureListener, MediaController$MediaPlayerControl
{
    private static long I;
    private Context A;
    private int B;
    private final WeakReference C;
    private final boolean D;
    private int E;
    private boolean F;
    private boolean G;
    private boolean H;
    private a$c J;
    private MediaPlayer$OnCompletionListener K;
    private MediaPlayer$OnSeekCompleteListener L;
    private MediaPlayer$OnErrorListener M;
    private MediaPlayer$OnBufferingUpdateListener N;
    public SurfaceTexture a;
    public Surface b;
    public int c;
    public int d;
    public a$b e;
    public a$a f;
    MediaPlayer$OnVideoSizeChangedListener g;
    MediaPlayer$OnPreparedListener h;
    private int i;
    private Uri j;
    private final Uri k;
    private int l;
    private boolean m;
    private int n;
    private int o;
    private MediaPlayer p;
    private int q;
    private int r;
    private MediaPlayer$OnCompletionListener s;
    private MediaPlayer$OnPreparedListener t;
    private int u;
    private MediaPlayer$OnErrorListener v;
    private int w;
    private boolean x;
    private boolean y;
    private boolean z;
    
    static {
        a.I = 600000L;
    }
    
    public a(final Context a, final boolean d, final String s) {
        super(a);
        this.i = 0;
        this.m = true;
        this.n = 0;
        this.o = 0;
        this.a = null;
        this.b = null;
        this.p = null;
        this.B = 0;
        this.E = 0;
        this.F = false;
        this.G = false;
        this.H = false;
        this.g = (MediaPlayer$OnVideoSizeChangedListener)new a$e(this);
        this.h = (MediaPlayer$OnPreparedListener)new a$d(this);
        this.K = (MediaPlayer$OnCompletionListener)new MediaPlayer$OnCompletionListener() {
            public void onCompletion(final MediaPlayer mediaPlayer) {
                com.admarvel.android.ads.a.this.n = 5;
                com.admarvel.android.ads.a.this.o = 5;
                com.admarvel.android.ads.a.this.m = false;
                if (com.admarvel.android.ads.a.this.s != null) {
                    com.admarvel.android.ads.a.this.s.onCompletion(com.admarvel.android.ads.a.this.p);
                }
            }
        };
        this.L = (MediaPlayer$OnSeekCompleteListener)new MediaPlayer$OnSeekCompleteListener() {
            public void onSeekComplete(final MediaPlayer mediaPlayer) {
                if (com.admarvel.android.ads.a.this.e != null) {
                    com.admarvel.android.ads.a.this.e.d();
                }
            }
        };
        this.M = (MediaPlayer$OnErrorListener)new MediaPlayer$OnErrorListener() {
            public boolean onError(final MediaPlayer mediaPlayer, final int n, final int n2) {
                com.admarvel.android.ads.a.this.n = -1;
                com.admarvel.android.ads.a.this.o = -1;
                com.admarvel.android.ads.a.this.m = false;
                if (com.admarvel.android.ads.a.this.e != null) {
                    com.admarvel.android.ads.a.this.e.d();
                }
                if (!com.admarvel.android.ads.a.this.D) {
                    com.admarvel.android.ads.a.this.c();
                }
                if (com.admarvel.android.ads.a.this.v == null || com.admarvel.android.ads.a.this.v.onError(com.admarvel.android.ads.a.this.p, n, n2)) {}
                return true;
            }
        };
        this.N = (MediaPlayer$OnBufferingUpdateListener)new MediaPlayer$OnBufferingUpdateListener() {
            public void onBufferingUpdate(final MediaPlayer mediaPlayer, final int n) {
                com.admarvel.android.ads.a.this.u = n;
            }
        };
        this.A = a;
        this.C = null;
        this.D = d;
        this.j();
        this.k = Uri.parse(s);
        this.j = Uri.parse(s);
    }
    
    private void j() {
        this.setSurfaceTextureListener((TextureView$SurfaceTextureListener)this);
        this.setWillNotDraw(false);
        this.c = 0;
        this.d = 0;
        this.setFocusable(true);
        this.setFocusableInTouchMode(true);
        this.requestFocus();
        this.n = 0;
        this.o = 0;
    }
    
    private void k() {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     2: invokestatic    com/admarvel/android/util/Logging.log:(Ljava/lang/String;)V
        //     5: aload_0        
        //     6: getfield        com/admarvel/android/ads/a.j:Landroid/net/Uri;
        //     9: ifnull          19
        //    12: aload_0        
        //    13: getfield        com/admarvel/android/ads/a.a:Landroid/graphics/SurfaceTexture;
        //    16: ifnonnull       20
        //    19: return         
        //    20: aload_0        
        //    21: getfield        com/admarvel/android/ads/a.A:Landroid/content/Context;
        //    24: invokestatic    com/admarvel/android/ads/r.k:(Landroid/content/Context;)Z
        //    27: ifne            47
        //    30: aload_0        
        //    31: getfield        com/admarvel/android/ads/a.e:Lcom/admarvel/android/ads/a$b;
        //    34: ifnull          19
        //    37: aload_0        
        //    38: getfield        com/admarvel/android/ads/a.e:Lcom/admarvel/android/ads/a$b;
        //    41: invokeinterface com/admarvel/android/ads/a$b.f:()V
        //    46: return         
        //    47: aload_0        
        //    48: iconst_0       
        //    49: invokevirtual   com/admarvel/android/ads/a.a:(Z)V
        //    52: aload_0        
        //    53: new             Landroid/media/MediaPlayer;
        //    56: dup            
        //    57: invokespecial   android/media/MediaPlayer.<init>:()V
        //    60: putfield        com/admarvel/android/ads/a.p:Landroid/media/MediaPlayer;
        //    63: aload_0        
        //    64: getfield        com/admarvel/android/ads/a.p:Landroid/media/MediaPlayer;
        //    67: aload_0        
        //    68: getfield        com/admarvel/android/ads/a.h:Landroid/media/MediaPlayer$OnPreparedListener;
        //    71: invokevirtual   android/media/MediaPlayer.setOnPreparedListener:(Landroid/media/MediaPlayer$OnPreparedListener;)V
        //    74: aload_0        
        //    75: getfield        com/admarvel/android/ads/a.p:Landroid/media/MediaPlayer;
        //    78: aload_0        
        //    79: getfield        com/admarvel/android/ads/a.g:Landroid/media/MediaPlayer$OnVideoSizeChangedListener;
        //    82: invokevirtual   android/media/MediaPlayer.setOnVideoSizeChangedListener:(Landroid/media/MediaPlayer$OnVideoSizeChangedListener;)V
        //    85: aload_0        
        //    86: iconst_m1      
        //    87: putfield        com/admarvel/android/ads/a.l:I
        //    90: aload_0        
        //    91: getfield        com/admarvel/android/ads/a.p:Landroid/media/MediaPlayer;
        //    94: aload_0        
        //    95: getfield        com/admarvel/android/ads/a.K:Landroid/media/MediaPlayer$OnCompletionListener;
        //    98: invokevirtual   android/media/MediaPlayer.setOnCompletionListener:(Landroid/media/MediaPlayer$OnCompletionListener;)V
        //   101: aload_0        
        //   102: getfield        com/admarvel/android/ads/a.p:Landroid/media/MediaPlayer;
        //   105: aload_0        
        //   106: getfield        com/admarvel/android/ads/a.M:Landroid/media/MediaPlayer$OnErrorListener;
        //   109: invokevirtual   android/media/MediaPlayer.setOnErrorListener:(Landroid/media/MediaPlayer$OnErrorListener;)V
        //   112: aload_0        
        //   113: getfield        com/admarvel/android/ads/a.p:Landroid/media/MediaPlayer;
        //   116: aload_0        
        //   117: getfield        com/admarvel/android/ads/a.N:Landroid/media/MediaPlayer$OnBufferingUpdateListener;
        //   120: invokevirtual   android/media/MediaPlayer.setOnBufferingUpdateListener:(Landroid/media/MediaPlayer$OnBufferingUpdateListener;)V
        //   123: aload_0        
        //   124: getfield        com/admarvel/android/ads/a.p:Landroid/media/MediaPlayer;
        //   127: aload_0        
        //   128: getfield        com/admarvel/android/ads/a.L:Landroid/media/MediaPlayer$OnSeekCompleteListener;
        //   131: invokevirtual   android/media/MediaPlayer.setOnSeekCompleteListener:(Landroid/media/MediaPlayer$OnSeekCompleteListener;)V
        //   134: aload_0        
        //   135: iconst_0       
        //   136: putfield        com/admarvel/android/ads/a.u:I
        //   139: aload_0        
        //   140: getfield        com/admarvel/android/ads/a.j:Landroid/net/Uri;
        //   143: invokevirtual   android/net/Uri.toString:()Ljava/lang/String;
        //   146: ldc_w           "/"
        //   149: invokevirtual   java/lang/String.startsWith:(Ljava/lang/String;)Z
        //   152: istore_1       
        //   153: iload_1        
        //   154: ifeq            324
        //   157: new             Ljava/io/FileInputStream;
        //   160: dup            
        //   161: new             Ljava/io/File;
        //   164: dup            
        //   165: aload_0        
        //   166: getfield        com/admarvel/android/ads/a.j:Landroid/net/Uri;
        //   169: invokevirtual   android/net/Uri.toString:()Ljava/lang/String;
        //   172: invokespecial   java/io/File.<init>:(Ljava/lang/String;)V
        //   175: invokespecial   java/io/FileInputStream.<init>:(Ljava/io/File;)V
        //   178: astore_3       
        //   179: aload_0        
        //   180: getfield        com/admarvel/android/ads/a.p:Landroid/media/MediaPlayer;
        //   183: aload_3        
        //   184: invokevirtual   java/io/FileInputStream.getFD:()Ljava/io/FileDescriptor;
        //   187: invokevirtual   android/media/MediaPlayer.setDataSource:(Ljava/io/FileDescriptor;)V
        //   190: aload_3        
        //   191: invokevirtual   java/io/FileInputStream.close:()V
        //   194: aload_0        
        //   195: new             Landroid/view/Surface;
        //   198: dup            
        //   199: aload_0        
        //   200: getfield        com/admarvel/android/ads/a.a:Landroid/graphics/SurfaceTexture;
        //   203: invokespecial   android/view/Surface.<init>:(Landroid/graphics/SurfaceTexture;)V
        //   206: putfield        com/admarvel/android/ads/a.b:Landroid/view/Surface;
        //   209: aload_0        
        //   210: getfield        com/admarvel/android/ads/a.p:Landroid/media/MediaPlayer;
        //   213: aload_0        
        //   214: getfield        com/admarvel/android/ads/a.b:Landroid/view/Surface;
        //   217: invokevirtual   android/media/MediaPlayer.setSurface:(Landroid/view/Surface;)V
        //   220: aload_0        
        //   221: getfield        com/admarvel/android/ads/a.p:Landroid/media/MediaPlayer;
        //   224: iconst_3       
        //   225: invokevirtual   android/media/MediaPlayer.setAudioStreamType:(I)V
        //   228: aload_0        
        //   229: getfield        com/admarvel/android/ads/a.p:Landroid/media/MediaPlayer;
        //   232: invokevirtual   android/media/MediaPlayer.prepareAsync:()V
        //   235: aload_0        
        //   236: iconst_1       
        //   237: putfield        com/admarvel/android/ads/a.n:I
        //   240: return         
        //   241: astore_2       
        //   242: aload_2        
        //   243: invokestatic    android/util/Log.getStackTraceString:(Ljava/lang/Throwable;)Ljava/lang/String;
        //   246: invokestatic    com/admarvel/android/util/Logging.log:(Ljava/lang/String;)V
        //   249: aload_0        
        //   250: iconst_m1      
        //   251: putfield        com/admarvel/android/ads/a.n:I
        //   254: aload_0        
        //   255: iconst_m1      
        //   256: putfield        com/admarvel/android/ads/a.o:I
        //   259: aload_0        
        //   260: getfield        com/admarvel/android/ads/a.M:Landroid/media/MediaPlayer$OnErrorListener;
        //   263: aload_0        
        //   264: getfield        com/admarvel/android/ads/a.p:Landroid/media/MediaPlayer;
        //   267: iconst_1       
        //   268: iconst_0       
        //   269: invokeinterface android/media/MediaPlayer$OnErrorListener.onError:(Landroid/media/MediaPlayer;II)Z
        //   274: pop            
        //   275: return         
        //   276: astore_2       
        //   277: aconst_null    
        //   278: astore_3       
        //   279: aload_3        
        //   280: ifnull          287
        //   283: aload_3        
        //   284: invokevirtual   java/io/FileInputStream.close:()V
        //   287: aload_2        
        //   288: athrow         
        //   289: astore_2       
        //   290: aload_2        
        //   291: invokestatic    android/util/Log.getStackTraceString:(Ljava/lang/Throwable;)Ljava/lang/String;
        //   294: invokestatic    com/admarvel/android/util/Logging.log:(Ljava/lang/String;)V
        //   297: aload_0        
        //   298: iconst_m1      
        //   299: putfield        com/admarvel/android/ads/a.n:I
        //   302: aload_0        
        //   303: iconst_m1      
        //   304: putfield        com/admarvel/android/ads/a.o:I
        //   307: aload_0        
        //   308: getfield        com/admarvel/android/ads/a.M:Landroid/media/MediaPlayer$OnErrorListener;
        //   311: aload_0        
        //   312: getfield        com/admarvel/android/ads/a.p:Landroid/media/MediaPlayer;
        //   315: iconst_1       
        //   316: iconst_0       
        //   317: invokeinterface android/media/MediaPlayer$OnErrorListener.onError:(Landroid/media/MediaPlayer;II)Z
        //   322: pop            
        //   323: return         
        //   324: aload_0        
        //   325: getfield        com/admarvel/android/ads/a.p:Landroid/media/MediaPlayer;
        //   328: aload_0        
        //   329: getfield        com/admarvel/android/ads/a.A:Landroid/content/Context;
        //   332: aload_0        
        //   333: getfield        com/admarvel/android/ads/a.j:Landroid/net/Uri;
        //   336: invokevirtual   android/media/MediaPlayer.setDataSource:(Landroid/content/Context;Landroid/net/Uri;)V
        //   339: goto            194
        //   342: astore_2       
        //   343: goto            279
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                                
        //  -----  -----  -----  -----  ------------------------------------
        //  52     153    241    276    Ljava/io/IOException;
        //  52     153    289    324    Ljava/lang/IllegalArgumentException;
        //  157    179    276    279    Any
        //  179    190    342    346    Any
        //  190    194    241    276    Ljava/io/IOException;
        //  190    194    289    324    Ljava/lang/IllegalArgumentException;
        //  194    240    241    276    Ljava/io/IOException;
        //  194    240    289    324    Ljava/lang/IllegalArgumentException;
        //  283    287    241    276    Ljava/io/IOException;
        //  283    287    289    324    Ljava/lang/IllegalArgumentException;
        //  287    289    241    276    Ljava/io/IOException;
        //  287    289    289    324    Ljava/lang/IllegalArgumentException;
        //  324    339    241    276    Ljava/io/IOException;
        //  324    339    289    324    Ljava/lang/IllegalArgumentException;
        // 
        // The error that occurred was:
        // 
        // java.lang.IndexOutOfBoundsException: Index: 169, Size: 169
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
    
    private boolean l() {
        return this.p != null && this.n != -1 && this.n != 0 && this.n != 1;
    }
    
    public Uri a() {
        return this.k;
    }
    
    String a(final String s) {
        Logging.log("#### getCachedVideoUriPath url: " + s);
        final File file = new File(this.getContext().getDir("adm_cache_files", 0).getAbsolutePath() + "/" + this.d(s));
        if (file.exists() && System.currentTimeMillis() - file.lastModified() < com.admarvel.android.ads.a.I) {
            Logging.log("## getCachedVideoUriPath cached: " + file.getPath());
            return file.getPath();
        }
        return null;
    }
    
    public void a(final int c, final int d, final int q, final int r) {
        this.c = c;
        this.d = d;
        this.q = q;
        this.r = r;
    }
    
    public void a(final MediaPlayer$OnCompletionListener s) {
        this.s = s;
    }
    
    public void a(final MediaPlayer$OnErrorListener v) {
        this.v = v;
    }
    
    public void a(final MediaPlayer$OnPreparedListener t) {
        this.t = t;
    }
    
    public void a(final Uri j) {
        try {
            if (this.p != null) {
                this.p.reset();
                this.p.release();
                this.p = null;
            }
            this.j = j;
            this.w = 0;
            this.k();
            this.requestLayout();
            this.invalidate();
        }
        catch (Exception ex) {
            if (this.e != null) {
                this.e.g();
            }
            Logging.log(Log.getStackTraceString((Throwable)ex));
        }
    }
    
    public void a(final Uri j, final Boolean b) {
        try {
            this.j = j;
            this.w = 0;
            Logging.log("### setVideoURIForMrec");
            this.k();
            this.requestLayout();
            this.invalidate();
        }
        catch (Exception ex) {
            if (this.e != null) {
                this.e.g();
            }
            Logging.log(Log.getStackTraceString((Throwable)ex));
        }
    }
    
    public void a(final a$a f) {
        this.f = f;
    }
    
    public void a(final String s, final int n) {
        if (this.E <= 5) {
            ++this.E;
            if (!this.b(s) && !this.c(s)) {
                final String string = this.getContext().getDir("adm_cache_files", 0).getAbsolutePath() + "/" + this.d(s);
                Logging.log("#### tempPath " + string);
                if (Version.getAndroidSDKVersion() >= 11) {
                    (this.J = new a$c(s, string, n)).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, (Object[])new Void[0]);
                    return;
                }
                (this.J = new a$c(s, string, n)).execute((Object[])new Void[0]);
            }
        }
    }
    
    public void a(final String s, final Boolean b) {
        this.a(Uri.parse(s), b);
    }
    
    public void a(final boolean b) {
        try {
            if (this.p != null) {
                this.p.reset();
                this.p.release();
                this.p = null;
                this.n = 0;
                if (b) {
                    this.o = 0;
                }
            }
            if (this.b != null) {
                this.b.release();
                this.b = null;
            }
        }
        catch (Exception ex) {
            if (this.e != null) {
                this.e.g();
            }
            Logging.log(Log.getStackTraceString((Throwable)ex));
        }
    }
    
    void b() {
        if (this.J != null) {
            this.J.cancel(true);
            this.J = null;
            Logging.log("### " + this.J + " thread interuped ");
        }
    }
    
    public boolean b(final String s) {
        final boolean b = false;
        Logging.log("#### isVideoUriCached url: " + s);
        final File file = new File(this.getContext().getDir("adm_cache_files", 0).getAbsolutePath() + "/" + this.d(s));
        boolean b2 = b;
        if (file.exists()) {
            b2 = b;
            if (System.currentTimeMillis() - file.lastModified() < com.admarvel.android.ads.a.I) {
                Logging.log("## file cached: " + file.getPath());
                b2 = true;
            }
        }
        return b2;
    }
    
    public void c() {
        try {
            if (this.p != null) {
                this.p.reset();
                this.p.release();
                this.p = null;
                this.n = 0;
                this.o = 0;
                if (this.e != null) {
                    this.e.b();
                }
            }
        }
        catch (Exception ex) {
            if (this.e != null) {
                this.e.g();
            }
            Logging.log(Log.getStackTraceString((Throwable)ex));
        }
    }
    
    public boolean c(final String s) {
        final boolean b = false;
        Logging.log("#### isVideoUriProcessing url: " + s);
        final File file = new File(this.getContext().getDir("adm_cache_files", 0).getAbsolutePath() + "/" + this.d(s) + ".PROCESSING");
        boolean b2 = b;
        if (file.exists()) {
            b2 = b;
            if (System.currentTimeMillis() - file.lastModified() < com.admarvel.android.ads.a.I) {
                Logging.log("## file processing: " + file.getPath());
                b2 = true;
            }
        }
        return b2;
    }
    
    public boolean canPause() {
        return this.x;
    }
    
    public boolean canSeekBackward() {
        return this.y;
    }
    
    public boolean canSeekForward() {
        return this.z;
    }
    
    public String d(String string) {
        try {
            final MessageDigest instance = MessageDigest.getInstance("MD5");
            instance.update(string.getBytes());
            final byte[] digest = instance.digest();
            final StringBuffer sb = new StringBuffer();
            for (int i = 0; i < digest.length; ++i) {
                sb.append(Integer.toHexString(digest[i] & 0xFF));
            }
            string = sb.toString();
            return string;
        }
        catch (NoSuchAlgorithmException ex) {
            ex.printStackTrace();
            return "";
        }
    }
    
    public void d() {
        if (this.l()) {
            this.p.setVolume(0.0f, 0.0f);
        }
    }
    
    public void e() {
        if (this.l()) {
            this.p.setVolume(1.0f, 1.0f);
        }
    }
    
    public void e(final String s) {
        this.m = true;
        if (this.b(s)) {
            Logging.log("##### playWithCacheOrLoad  using cached path: " + this.a(s));
            this.a(this.a(s), true);
            this.start();
            return;
        }
        Logging.log("##### playWithCacheOrLoad: call start to make video play after loading");
        this.a(s, true);
        this.start();
        this.a(s, 1);
    }
    
    public void f() {
        this.m = true;
        if (this.b(this.k.toString())) {
            this.a(this.a(this.k.toString()), false);
            this.start();
            return;
        }
        this.a(this.k, false);
        this.start();
        this.a(this.k.toString(), 1);
    }
    
    public void g() {
        Logging.log("### ResumeVideoIfPaused");
        if (this.B > 0) {
            if (this.b(this.k.toString()) && this.m) {
                this.a(this.a(this.k.toString()), false);
                this.seekTo(this.B);
                this.o = 3;
            }
            else if (this.m) {
                this.a(this.k, false);
                this.start();
                this.a(this.k.toString(), 1);
            }
            if (this.e != null) {
                this.e.c();
            }
            return;
        }
        if (this.b(this.k.toString())) {
            this.a(this.a(this.k.toString()), false);
        }
        else {
            this.a(this.k);
        }
        this.start();
    }
    
    public int getBufferPercentage() {
        if (this.p != null) {
            return this.u;
        }
        return 0;
    }
    
    public int getCurrentPosition() {
        if (this.l()) {
            return this.i = this.p.getCurrentPosition();
        }
        return 0;
    }
    
    public int getDuration() {
        if (!this.l()) {
            return this.l = -1;
        }
        if (this.l > 0) {
            return this.l;
        }
        return this.l = this.p.getDuration();
    }
    
    public int h() {
        if (this.l()) {
            this.i = this.p.getCurrentPosition();
            this.B = this.i;
            return this.i;
        }
        return this.B;
    }
    
    public void i() {
        final float density = this.getContext().getResources().getDisplayMetrics().density;
        RelativeLayout$LayoutParams layoutParams;
        if (this.c > 0 && this.d > 0) {
            layoutParams = new RelativeLayout$LayoutParams((int)(this.c * density), (int)(this.d * density));
        }
        else {
            layoutParams = new RelativeLayout$LayoutParams(-2, -2);
        }
        if (this.q >= 0) {
            if (this.r >= 0) {
                layoutParams.leftMargin = (int)(this.q * density);
                layoutParams.topMargin = (int)(density * this.r);
            }
            else {
                layoutParams.leftMargin = (int)(density * this.q);
                layoutParams.addRule(15);
            }
        }
        else if (this.r >= 0) {
            layoutParams.topMargin = (int)(density * this.r);
            layoutParams.addRule(14);
        }
        else {
            layoutParams.addRule(13);
        }
        this.setLayoutParams((ViewGroup$LayoutParams)layoutParams);
    }
    
    public boolean isPlaying() {
        return this.l() && this.p.isPlaying();
    }
    
    protected void onAttachedToWindow() {
        Logging.log("#### VideoView - onAttachedToWindow");
        this.F = false;
        super.onAttachedToWindow();
    }
    
    protected void onDetachedFromWindow() {
        this.F = true;
        super.onDetachedFromWindow();
    }
    
    public void onSurfaceTextureAvailable(final SurfaceTexture a, final int n, final int n2) {
        Logging.log("#### VideoView - onSurfaceTextureAvailable: " + this.isAvailable());
        this.G = true;
        this.a = a;
        if (this.n != 0) {
            this.k();
        }
    }
    
    public boolean onSurfaceTextureDestroyed(final SurfaceTexture surfaceTexture) {
        Logging.log("#### VideoView - onSurfaceTextureDestroyed");
        this.G = false;
        this.H = false;
        return true;
    }
    
    @SuppressLint({ "NewApi" })
    public void onSurfaceTextureSizeChanged(final SurfaceTexture surfaceTexture, final int n, final int n2) {
        Logging.log("#### VideoView - onSurfaceTextureSizeChanged");
    }
    
    public void onSurfaceTextureUpdated(final SurfaceTexture surfaceTexture) {
    }
    
    public boolean onTouchEvent(final MotionEvent motionEvent) {
        if (this.e != null) {
            this.e.e();
        }
        return false;
    }
    
    public boolean onTrackballEvent(final MotionEvent motionEvent) {
        return false;
    }
    
    public void pause() {
        try {
            this.n = 4;
            this.B = this.getCurrentPosition();
            if (this.l() && this.p.isPlaying()) {
                if (this.D) {
                    this.p.pause();
                }
                else {
                    this.c();
                }
                if (this.e != null) {
                    this.e.a();
                }
            }
            this.o = 4;
        }
        catch (IllegalStateException ex) {
            if (this.e != null) {
                this.e.g();
            }
            Logging.log(Log.getStackTraceString((Throwable)ex));
        }
    }
    
    public void seekTo(final int w) {
        if (!com.admarvel.android.ads.r.k(this.A)) {
            if (this.e != null) {
                this.e.f();
            }
            return;
        }
        if (this.l()) {
            this.p.seekTo(w);
            this.w = 0;
            return;
        }
        this.w = w;
    }
    
    public void start() {
        try {
            if (this.l()) {
                this.p.start();
                this.n = 3;
            }
            this.o = 3;
            this.B = 0;
        }
        catch (IllegalStateException ex) {
            if (this.e != null) {
                this.e.g();
            }
            Logging.log(Log.getStackTraceString((Throwable)ex));
        }
    }
}
