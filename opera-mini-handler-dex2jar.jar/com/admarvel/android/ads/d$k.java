// 
// Decompiled by Procyon v0.6-prerelease
// 

package com.admarvel.android.ads;

import android.content.Context;
import java.lang.ref.WeakReference;

class d$k implements Runnable
{
    private final WeakReference a;
    private final WeakReference b;
    
    public d$k(final d d, final Context context) {
        this.a = new WeakReference((T)context);
        this.b = new WeakReference((T)d);
    }
    
    @Override
    public void run() {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: getfield        com/admarvel/android/ads/d$k.b:Ljava/lang/ref/WeakReference;
        //     4: ifnull          466
        //     7: aload_0        
        //     8: getfield        com/admarvel/android/ads/d$k.b:Ljava/lang/ref/WeakReference;
        //    11: invokevirtual   java/lang/ref/WeakReference.get:()Ljava/lang/Object;
        //    14: checkcast       Lcom/admarvel/android/ads/d;
        //    17: astore_1       
        //    18: goto            461
        //    21: aload_1        
        //    22: invokestatic    com/admarvel/android/ads/d.a:(Lcom/admarvel/android/ads/d;)Z
        //    25: ifne            465
        //    28: aload_0        
        //    29: getfield        com/admarvel/android/ads/d$k.a:Ljava/lang/ref/WeakReference;
        //    32: ifnull          368
        //    35: aload_0        
        //    36: getfield        com/admarvel/android/ads/d$k.a:Ljava/lang/ref/WeakReference;
        //    39: invokevirtual   java/lang/ref/WeakReference.get:()Ljava/lang/Object;
        //    42: checkcast       Landroid/content/Context;
        //    45: astore_2       
        //    46: aload_2        
        //    47: ifnull          465
        //    50: aload_2        
        //    51: instanceof      Landroid/app/Activity;
        //    54: ifeq            465
        //    57: aload_2        
        //    58: checkcast       Landroid/app/Activity;
        //    61: astore_2       
        //    62: aload_2        
        //    63: ifnull          136
        //    66: aload_2        
        //    67: invokevirtual   android/app/Activity.getWindow:()Landroid/view/Window;
        //    70: ldc             16908290
        //    72: invokevirtual   android/view/Window.findViewById:(I)Landroid/view/View;
        //    75: checkcast       Landroid/view/ViewGroup;
        //    78: astore_3       
        //    79: aload_3        
        //    80: new             Ljava/lang/StringBuilder;
        //    83: dup            
        //    84: invokespecial   java/lang/StringBuilder.<init>:()V
        //    87: aload_1        
        //    88: getfield        com/admarvel/android/ads/d.s:Ljava/lang/String;
        //    91: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //    94: ldc             "BTN_CLOSE"
        //    96: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //    99: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   102: invokevirtual   android/view/ViewGroup.findViewWithTag:(Ljava/lang/Object;)Landroid/view/View;
        //   105: checkcast       Landroid/widget/LinearLayout;
        //   108: astore          4
        //   110: aload           4
        //   112: ifnull          136
        //   115: aload_1        
        //   116: invokestatic    com/admarvel/android/ads/d.b:(Lcom/admarvel/android/ads/d;)Z
        //   119: ifeq            421
        //   122: aload_1        
        //   123: invokestatic    com/admarvel/android/ads/d.c:(Lcom/admarvel/android/ads/d;)Z
        //   126: ifne            373
        //   129: aload           4
        //   131: bipush          8
        //   133: invokevirtual   android/widget/LinearLayout.setVisibility:(I)V
        //   136: aload_1        
        //   137: invokestatic    com/admarvel/android/ads/d.d:(Lcom/admarvel/android/ads/d;)Ljava/util/concurrent/atomic/AtomicBoolean;
        //   140: iconst_0       
        //   141: iconst_1       
        //   142: invokevirtual   java/util/concurrent/atomic/AtomicBoolean.compareAndSet:(ZZ)Z
        //   145: ifeq            240
        //   148: aload_2        
        //   149: ifnull          236
        //   152: aload_2        
        //   153: instanceof      Lcom/admarvel/android/ads/AdMarvelActivity;
        //   156: ifeq            236
        //   159: aload_2        
        //   160: checkcast       Lcom/admarvel/android/ads/AdMarvelActivity;
        //   163: astore_3       
        //   164: aload_3        
        //   165: invokevirtual   com/admarvel/android/ads/AdMarvelActivity.c:()Z
        //   168: ifne            178
        //   171: aload_3        
        //   172: invokevirtual   com/admarvel/android/ads/AdMarvelActivity.e:()Z
        //   175: ifeq            430
        //   178: aload_1        
        //   179: invokevirtual   com/admarvel/android/ads/d.k:()V
        //   182: aload_1        
        //   183: iconst_0       
        //   184: invokevirtual   com/admarvel/android/ads/d.setVisibility:(I)V
        //   187: invokestatic    com/admarvel/android/ads/AdMarvelUtils.isLogDumpEnabled:()Z
        //   190: ifeq            206
        //   193: aload_1        
        //   194: ldc             "javascript:window.ADMARVEL.fetchWebViewHtmlContent(document.getElementsByTagName('html')[0].outerHTML);"
        //   196: invokevirtual   com/admarvel/android/ads/d.loadUrl:(Ljava/lang/String;)V
        //   199: aload_2        
        //   200: checkcast       Lcom/admarvel/android/ads/AdMarvelActivity;
        //   203: invokevirtual   com/admarvel/android/ads/AdMarvelActivity.h:()V
        //   206: aload_3        
        //   207: ifnull          236
        //   210: aload_3        
        //   211: getfield        com/admarvel/android/ads/AdMarvelActivity.a:Ljava/lang/ref/WeakReference;
        //   214: ifnull          451
        //   217: aload_3        
        //   218: getfield        com/admarvel/android/ads/AdMarvelActivity.a:Ljava/lang/ref/WeakReference;
        //   221: invokevirtual   java/lang/ref/WeakReference.get:()Ljava/lang/Object;
        //   224: checkcast       Lcom/admarvel/android/ads/AdMarvelActivity$e;
        //   227: astore_2       
        //   228: aload_2        
        //   229: ifnull          236
        //   232: aload_2        
        //   233: invokevirtual   com/admarvel/android/ads/AdMarvelActivity$e.b:()V
        //   236: aload_1        
        //   237: invokevirtual   com/admarvel/android/ads/d.clearHistory:()V
        //   240: aload_1        
        //   241: invokestatic    com/admarvel/android/ads/d.d:(Lcom/admarvel/android/ads/d;)Ljava/util/concurrent/atomic/AtomicBoolean;
        //   244: invokevirtual   java/util/concurrent/atomic/AtomicBoolean.get:()Z
        //   247: iconst_1       
        //   248: if_icmpne       465
        //   251: aload_1        
        //   252: invokevirtual   com/admarvel/android/ads/d.getParent:()Landroid/view/ViewParent;
        //   255: ifnull          456
        //   258: aload_1        
        //   259: invokevirtual   com/admarvel/android/ads/d.getParent:()Landroid/view/ViewParent;
        //   262: instanceof      Landroid/widget/RelativeLayout;
        //   265: ifeq            456
        //   268: aload_1        
        //   269: invokevirtual   com/admarvel/android/ads/d.getParent:()Landroid/view/ViewParent;
        //   272: checkcast       Landroid/widget/RelativeLayout;
        //   275: new             Ljava/lang/StringBuilder;
        //   278: dup            
        //   279: invokespecial   java/lang/StringBuilder.<init>:()V
        //   282: aload_1        
        //   283: getfield        com/admarvel/android/ads/d.s:Ljava/lang/String;
        //   286: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   289: ldc             "CONTROLS"
        //   291: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   294: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   297: invokevirtual   android/widget/RelativeLayout.findViewWithTag:(Ljava/lang/Object;)Landroid/view/View;
        //   300: checkcast       Lcom/admarvel/android/ads/o;
        //   303: astore_2       
        //   304: aload_2        
        //   305: ifnull          465
        //   308: aload_2        
        //   309: invokevirtual   com/admarvel/android/ads/o.a:()V
        //   312: aload_2        
        //   313: new             Ljava/lang/StringBuilder;
        //   316: dup            
        //   317: invokespecial   java/lang/StringBuilder.<init>:()V
        //   320: aload_1        
        //   321: getfield        com/admarvel/android/ads/d.s:Ljava/lang/String;
        //   324: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   327: ldc             "PROGRESS_BAR"
        //   329: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   332: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   335: invokevirtual   com/admarvel/android/ads/o.findViewWithTag:(Ljava/lang/Object;)Landroid/view/View;
        //   338: bipush          8
        //   340: invokevirtual   android/view/View.setVisibility:(I)V
        //   343: return         
        //   344: astore_1       
        //   345: new             Ljava/lang/StringBuilder;
        //   348: dup            
        //   349: ldc             "Exception"
        //   351: invokespecial   java/lang/StringBuilder.<init>:(Ljava/lang/String;)V
        //   354: aload_1        
        //   355: invokevirtual   java/lang/Exception.getMessage:()Ljava/lang/String;
        //   358: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   361: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   364: invokestatic    com/admarvel/android/util/Logging.log:(Ljava/lang/String;)V
        //   367: return         
        //   368: aconst_null    
        //   369: astore_2       
        //   370: goto            46
        //   373: aload           4
        //   375: iconst_0       
        //   376: invokevirtual   android/widget/LinearLayout.setVisibility:(I)V
        //   379: aload_3        
        //   380: new             Ljava/lang/StringBuilder;
        //   383: dup            
        //   384: invokespecial   java/lang/StringBuilder.<init>:()V
        //   387: aload_1        
        //   388: getfield        com/admarvel/android/ads/d.s:Ljava/lang/String;
        //   391: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   394: ldc             "BTN_CLOSE_IMAGE"
        //   396: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   399: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   402: invokevirtual   android/view/ViewGroup.findViewWithTag:(Ljava/lang/Object;)Landroid/view/View;
        //   405: checkcast       Landroid/widget/ImageView;
        //   408: astore_3       
        //   409: aload_3        
        //   410: ifnull          136
        //   413: aload_3        
        //   414: iconst_4       
        //   415: invokevirtual   android/widget/ImageView.setVisibility:(I)V
        //   418: goto            136
        //   421: aload           4
        //   423: iconst_0       
        //   424: invokevirtual   android/widget/LinearLayout.setVisibility:(I)V
        //   427: goto            136
        //   430: aload_1        
        //   431: iconst_0       
        //   432: invokevirtual   com/admarvel/android/ads/d.setVisibility:(I)V
        //   435: invokestatic    com/admarvel/android/ads/AdMarvelUtils.isLogDumpEnabled:()Z
        //   438: ifeq            206
        //   441: aload_2        
        //   442: checkcast       Lcom/admarvel/android/ads/AdMarvelActivity;
        //   445: invokevirtual   com/admarvel/android/ads/AdMarvelActivity.i:()V
        //   448: goto            206
        //   451: aconst_null    
        //   452: astore_2       
        //   453: goto            228
        //   456: aconst_null    
        //   457: astore_2       
        //   458: goto            304
        //   461: aload_1        
        //   462: ifnonnull       21
        //   465: return         
        //   466: aconst_null    
        //   467: astore_1       
        //   468: goto            461
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                 
        //  -----  -----  -----  -----  ---------------------
        //  0      18     344    368    Ljava/lang/Exception;
        //  21     46     344    368    Ljava/lang/Exception;
        //  50     62     344    368    Ljava/lang/Exception;
        //  66     110    344    368    Ljava/lang/Exception;
        //  115    136    344    368    Ljava/lang/Exception;
        //  136    148    344    368    Ljava/lang/Exception;
        //  152    178    344    368    Ljava/lang/Exception;
        //  178    206    344    368    Ljava/lang/Exception;
        //  210    228    344    368    Ljava/lang/Exception;
        //  232    236    344    368    Ljava/lang/Exception;
        //  236    240    344    368    Ljava/lang/Exception;
        //  240    304    344    368    Ljava/lang/Exception;
        //  308    343    344    368    Ljava/lang/Exception;
        //  373    409    344    368    Ljava/lang/Exception;
        //  413    418    344    368    Ljava/lang/Exception;
        //  421    427    344    368    Ljava/lang/Exception;
        //  430    448    344    368    Ljava/lang/Exception;
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: invokestatic:boolean(d::a, var_1_11:d)
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
