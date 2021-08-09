// 
// Decompiled by Procyon v0.6-prerelease
// 

package com.admarvel.android.ads;

import android.view.KeyEvent;
import android.media.MediaPlayer;
import android.media.MediaPlayer$OnErrorListener;
import android.widget.VideoView;
import android.widget.LinearLayout$LayoutParams;
import android.widget.LinearLayout;
import android.view.ViewGroup$LayoutParams;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.WebView;
import android.view.Window;
import android.view.View$OnKeyListener;
import android.view.ViewGroup;
import android.webkit.GeolocationPermissions$Callback;
import android.webkit.ConsoleMessage;
import android.util.AttributeSet;
import android.widget.ProgressBar;
import android.app.Activity;
import android.content.Context;
import java.lang.ref.WeakReference;
import android.widget.FrameLayout;
import android.view.View;
import android.webkit.WebChromeClient$CustomViewCallback;
import android.webkit.WebChromeClient;

class d$a extends WebChromeClient
{
    private WebChromeClient$CustomViewCallback a;
    private View b;
    private FrameLayout c;
    private final WeakReference d;
    private final WeakReference e;
    
    public d$a(final d d, final Context context) {
        this.d = new WeakReference((T)d);
        this.e = new WeakReference((T)context);
    }
    
    void a() {
        this.onHideCustomView();
    }
    
    public View getVideoLoadingProgressView() {
        final d d = (d)this.d.get();
        if (d == null) {
            return super.getVideoLoadingProgressView();
        }
        if (d.M) {
            return super.getVideoLoadingProgressView();
        }
        final Context context = (Context)this.e.get();
        if (context != null && context instanceof Activity) {
            final Activity activity = (Activity)context;
            if (activity != null) {
                final ProgressBar progressBar = new ProgressBar((Context)activity, (AttributeSet)null, 16842871);
                progressBar.setIndeterminate(true);
                return (View)progressBar;
            }
        }
        return super.getVideoLoadingProgressView();
    }
    
    public boolean onConsoleMessage(final ConsoleMessage consoleMessage) {
        final d d = (d)this.d.get();
        return d == null || d.M || super.onConsoleMessage(consoleMessage);
    }
    
    public void onGeolocationPermissionsShowPrompt(final String s, final GeolocationPermissions$Callback geolocationPermissions$Callback) {
        final d d = (d)this.d.get();
        if (d != null && !d.M) {
            geolocationPermissions$Callback.invoke(s, true, false);
        }
    }
    
    public void onHideCustomView() {
        super.onHideCustomView();
        final d d = (d)this.d.get();
        if (d != null && !d.M) {
            if (this.c != null) {
                final Context context = (Context)this.e.get();
                if (context != null && context instanceof Activity) {
                    final Activity activity = (Activity)context;
                    if (activity != null) {
                        final Window window = activity.getWindow();
                        final ViewGroup viewGroup = (ViewGroup)window.findViewById(16908290);
                        this.c.removeView(this.b);
                        this.b = null;
                        viewGroup.removeView((View)this.c);
                        this.c = null;
                        if (window.getCurrentFocus() instanceof d) {
                            ((d)window.getCurrentFocus()).setOnKeyListener((View$OnKeyListener)null);
                        }
                    }
                }
            }
            try {
                if (this.a != null) {
                    this.a.onCustomViewHidden();
                }
            }
            catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
    
    public boolean onJsAlert(final WebView webView, final String s, final String s2, final JsResult jsResult) {
        final d d = (d)this.d.get();
        if (d == null) {
            jsResult.cancel();
            return true;
        }
        if (d.M) {
            jsResult.cancel();
            return true;
        }
        if (d.x.get()) {
            jsResult.cancel();
            return true;
        }
        if (this.e.get() != null && this.e.get() instanceof Activity) {
            return super.onJsAlert(webView, s, s2, jsResult);
        }
        jsResult.cancel();
        return true;
    }
    
    public boolean onJsBeforeUnload(final WebView webView, final String s, final String s2, final JsResult jsResult) {
        jsResult.cancel();
        return true;
    }
    
    public boolean onJsConfirm(final WebView webView, final String s, final String s2, final JsResult jsResult) {
        final d d = (d)this.d.get();
        if (d == null) {
            jsResult.cancel();
            return true;
        }
        if (d.M) {
            jsResult.cancel();
            return true;
        }
        if (d.x.get()) {
            jsResult.cancel();
            return true;
        }
        if (this.e.get() != null && this.e.get() instanceof Activity) {
            return super.onJsConfirm(webView, s, s2, jsResult);
        }
        jsResult.cancel();
        return true;
    }
    
    public boolean onJsPrompt(final WebView webView, final String s, final String s2, final String s3, final JsPromptResult jsPromptResult) {
        final d d = (d)this.d.get();
        if (d == null) {
            jsPromptResult.cancel();
            return true;
        }
        if (d.M) {
            jsPromptResult.cancel();
            return true;
        }
        if (d.x.get()) {
            jsPromptResult.cancel();
            return true;
        }
        if (this.e.get() != null && this.e.get() instanceof Activity) {
            return super.onJsPrompt(webView, s, s2, s3, jsPromptResult);
        }
        jsPromptResult.cancel();
        return true;
    }
    
    public void onProgressChanged(final WebView p0, final int p1) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: astore          4
        //     3: aload_0        
        //     4: getfield        com/admarvel/android/ads/d$a.d:Ljava/lang/ref/WeakReference;
        //     7: ifnull          296
        //    10: aload_0        
        //    11: getfield        com/admarvel/android/ads/d$a.d:Ljava/lang/ref/WeakReference;
        //    14: invokevirtual   java/lang/ref/WeakReference.get:()Ljava/lang/Object;
        //    17: checkcast       Lcom/admarvel/android/ads/d;
        //    20: astore_1       
        //    21: goto            291
        //    24: aload_1        
        //    25: invokestatic    com/admarvel/android/ads/d.a:(Lcom/admarvel/android/ads/d;)Z
        //    28: ifne            295
        //    31: aload_1        
        //    32: invokevirtual   com/admarvel/android/ads/d.getParent:()Landroid/view/ViewParent;
        //    35: ifnull          286
        //    38: aload_1        
        //    39: invokevirtual   com/admarvel/android/ads/d.getParent:()Landroid/view/ViewParent;
        //    42: instanceof      Landroid/widget/RelativeLayout;
        //    45: ifeq            286
        //    48: aload_1        
        //    49: invokevirtual   com/admarvel/android/ads/d.getParent:()Landroid/view/ViewParent;
        //    52: checkcast       Landroid/widget/RelativeLayout;
        //    55: new             Ljava/lang/StringBuilder;
        //    58: dup            
        //    59: invokespecial   java/lang/StringBuilder.<init>:()V
        //    62: aload_1        
        //    63: getfield        com/admarvel/android/ads/d.s:Ljava/lang/String;
        //    66: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //    69: ldc             "CONTROLS"
        //    71: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //    74: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //    77: invokevirtual   android/widget/RelativeLayout.findViewWithTag:(Ljava/lang/Object;)Landroid/view/View;
        //    80: checkcast       Lcom/admarvel/android/ads/o;
        //    83: astore_3       
        //    84: aload_3        
        //    85: ifnull          121
        //    88: aload_3        
        //    89: new             Ljava/lang/StringBuilder;
        //    92: dup            
        //    93: invokespecial   java/lang/StringBuilder.<init>:()V
        //    96: aload_1        
        //    97: getfield        com/admarvel/android/ads/d.s:Ljava/lang/String;
        //   100: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   103: ldc             "PROGRESS_BAR"
        //   105: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   108: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   111: invokevirtual   com/admarvel/android/ads/o.findViewWithTag:(Ljava/lang/Object;)Landroid/view/View;
        //   114: checkcast       Landroid/widget/ProgressBar;
        //   117: iload_2        
        //   118: invokevirtual   android/widget/ProgressBar.setProgress:(I)V
        //   121: aload_0        
        //   122: getfield        com/admarvel/android/ads/d$a.e:Ljava/lang/ref/WeakReference;
        //   125: invokevirtual   java/lang/ref/WeakReference.get:()Ljava/lang/Object;
        //   128: checkcast       Landroid/content/Context;
        //   131: astore_3       
        //   132: aload_3        
        //   133: ifnull          295
        //   136: aload_3        
        //   137: instanceof      Landroid/app/Activity;
        //   140: ifeq            295
        //   143: aload_3        
        //   144: checkcast       Landroid/app/Activity;
        //   147: astore_3       
        //   148: aload_3        
        //   149: ifnull          295
        //   152: aload_3        
        //   153: instanceof      Lcom/admarvel/android/ads/AdMarvelActivity;
        //   156: ifeq            295
        //   159: aload_3        
        //   160: checkcast       Lcom/admarvel/android/ads/AdMarvelActivity;
        //   163: astore          5
        //   165: aload           5
        //   167: ifnull          212
        //   170: aload_1        
        //   171: invokestatic    com/admarvel/android/ads/d.h:(Lcom/admarvel/android/ads/d;)Ljava/util/concurrent/atomic/AtomicBoolean;
        //   174: invokevirtual   java/util/concurrent/atomic/AtomicBoolean.get:()Z
        //   177: ifne            212
        //   180: aload           4
        //   182: astore_3       
        //   183: aload           5
        //   185: getfield        com/admarvel/android/ads/AdMarvelActivity.a:Ljava/lang/ref/WeakReference;
        //   188: ifnull          203
        //   191: aload           5
        //   193: getfield        com/admarvel/android/ads/AdMarvelActivity.a:Ljava/lang/ref/WeakReference;
        //   196: invokevirtual   java/lang/ref/WeakReference.get:()Ljava/lang/Object;
        //   199: checkcast       Lcom/admarvel/android/ads/AdMarvelActivity$e;
        //   202: astore_3       
        //   203: aload_3        
        //   204: ifnull          212
        //   207: aload_3        
        //   208: iload_2        
        //   209: invokevirtual   com/admarvel/android/ads/AdMarvelActivity$e.setProgress:(I)V
        //   212: invokestatic    com/admarvel/android/ads/Version.getAndroidSDKVersion:()I
        //   215: bipush          14
        //   217: if_icmplt       295
        //   220: iload_2        
        //   221: bipush          100
        //   223: if_icmpne       295
        //   226: aload_1        
        //   227: invokestatic    com/admarvel/android/ads/d.o:(Lcom/admarvel/android/ads/d;)Z
        //   230: ifne            295
        //   233: aload           5
        //   235: getfield        com/admarvel/android/ads/AdMarvelActivity.i:Z
        //   238: ifeq            295
        //   241: aload           5
        //   243: getfield        com/admarvel/android/ads/AdMarvelActivity.j:Z
        //   246: ifne            295
        //   249: aload_1        
        //   250: iconst_1       
        //   251: invokestatic    com/admarvel/android/ads/d.f:(Lcom/admarvel/android/ads/d;Z)Z
        //   254: pop            
        //   255: aload_1        
        //   256: ldc             "javascript:AdApp.adView().play()"
        //   258: invokevirtual   com/admarvel/android/ads/d.loadUrl:(Ljava/lang/String;)V
        //   261: return         
        //   262: astore_1       
        //   263: new             Ljava/lang/StringBuilder;
        //   266: dup            
        //   267: ldc             "Exception in onProgressChanged "
        //   269: invokespecial   java/lang/StringBuilder.<init>:(Ljava/lang/String;)V
        //   272: aload_1        
        //   273: invokevirtual   java/lang/Exception.getMessage:()Ljava/lang/String;
        //   276: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   279: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   282: invokestatic    com/admarvel/android/util/Logging.log:(Ljava/lang/String;)V
        //   285: return         
        //   286: aconst_null    
        //   287: astore_3       
        //   288: goto            84
        //   291: aload_1        
        //   292: ifnonnull       24
        //   295: return         
        //   296: aconst_null    
        //   297: astore_1       
        //   298: goto            291
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                 
        //  -----  -----  -----  -----  ---------------------
        //  3      21     262    286    Ljava/lang/Exception;
        //  24     84     262    286    Ljava/lang/Exception;
        //  88     121    262    286    Ljava/lang/Exception;
        //  121    132    262    286    Ljava/lang/Exception;
        //  136    148    262    286    Ljava/lang/Exception;
        //  152    165    262    286    Ljava/lang/Exception;
        //  170    180    262    286    Ljava/lang/Exception;
        //  183    203    262    286    Ljava/lang/Exception;
        //  207    212    262    286    Ljava/lang/Exception;
        //  212    220    262    286    Ljava/lang/Exception;
        //  226    261    262    286    Ljava/lang/Exception;
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: invokestatic:boolean(d::a, var_1_14:d)
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
    
    public void onShowCustomView(View focusedChild, final WebChromeClient$CustomViewCallback a) {
        super.onShowCustomView(focusedChild, a);
        final d d = (d)this.d.get();
        if (d != null && !d.M) {
            this.a = a;
            final Context context = (Context)this.e.get();
            if (context != null && context instanceof Activity) {
                final Activity activity = (Activity)context;
                if (activity != null) {
                    if (this.b != null) {
                        a.onCustomViewHidden();
                        return;
                    }
                    this.b = focusedChild;
                    final Window window = activity.getWindow();
                    final ViewGroup viewGroup = (ViewGroup)window.findViewById(16908290);
                    (this.c = new FrameLayout(d.getContext())).setLayoutParams(new ViewGroup$LayoutParams(-1, -1));
                    final LinearLayout linearLayout = new LinearLayout(d.getContext());
                    linearLayout.setBackgroundColor(-1442840576);
                    linearLayout.setGravity(53);
                    final LinearLayout$LayoutParams layoutParams = new LinearLayout$LayoutParams(-1, -2);
                    layoutParams.weight = 40.0f;
                    linearLayout.setLayoutParams((ViewGroup$LayoutParams)layoutParams);
                    linearLayout.addView((View)new d$i(d.getContext(), d, this, activity));
                    this.c.addView(focusedChild);
                    this.c.addView((View)linearLayout);
                    if (focusedChild instanceof FrameLayout) {
                        focusedChild = ((FrameLayout)focusedChild).getFocusedChild();
                        if (focusedChild instanceof VideoView) {
                            ((VideoView)focusedChild).setOnErrorListener((MediaPlayer$OnErrorListener)new MediaPlayer$OnErrorListener() {
                                public boolean onError(final MediaPlayer mediaPlayer, final int n, final int n2) {
                                    d$a.this.a();
                                    return true;
                                }
                            });
                            if (window.getCurrentFocus() instanceof d) {
                                ((d)window.getCurrentFocus()).setOnKeyListener((View$OnKeyListener)new View$OnKeyListener() {
                                    public boolean onKey(final View view, final int n, final KeyEvent keyEvent) {
                                        if (keyEvent.getAction() != 0 || n != 4) {
                                            return false;
                                        }
                                        if (d$a.this.b == null) {
                                            return view.onKeyDown(n, keyEvent);
                                        }
                                        d$a.this.a();
                                        return true;
                                    }
                                });
                            }
                            focusedChild.setOnKeyListener((View$OnKeyListener)new View$OnKeyListener() {
                                public boolean onKey(final View view, final int n, final KeyEvent keyEvent) {
                                    if (keyEvent.getAction() != 0 || n != 4) {
                                        return false;
                                    }
                                    if (d$a.this.b == null) {
                                        return view.onKeyDown(n, keyEvent);
                                    }
                                    d$a.this.a();
                                    return true;
                                }
                            });
                        }
                    }
                    viewGroup.addView((View)this.c);
                }
            }
        }
    }
}
