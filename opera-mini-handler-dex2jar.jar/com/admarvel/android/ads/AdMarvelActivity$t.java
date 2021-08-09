// 
// Decompiled by Procyon v0.6-prerelease
// 

package com.admarvel.android.ads;

import java.lang.ref.WeakReference;

class AdMarvelActivity$t implements Runnable
{
    private final WeakReference a;
    private final WeakReference b;
    
    public AdMarvelActivity$t(final AdMarvelActivity adMarvelActivity, final d d) {
        this.a = new WeakReference((T)adMarvelActivity);
        this.b = new WeakReference((T)d);
    }
    
    @Override
    public void run() {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: getfield        com/admarvel/android/ads/AdMarvelActivity$t.a:Ljava/lang/ref/WeakReference;
        //     4: invokevirtual   java/lang/ref/WeakReference.get:()Ljava/lang/Object;
        //     7: checkcast       Lcom/admarvel/android/ads/AdMarvelActivity;
        //    10: astore_1       
        //    11: aload_0        
        //    12: getfield        com/admarvel/android/ads/AdMarvelActivity$t.b:Ljava/lang/ref/WeakReference;
        //    15: invokevirtual   java/lang/ref/WeakReference.get:()Ljava/lang/Object;
        //    18: checkcast       Lcom/admarvel/android/ads/d;
        //    21: astore_2       
        //    22: aload_1        
        //    23: ifnull          214
        //    26: aload_2        
        //    27: ifnonnull       31
        //    30: return         
        //    31: aload_1        
        //    32: getstatic       com/admarvel/android/ads/AdMarvelActivity.b:I
        //    35: invokevirtual   com/admarvel/android/ads/AdMarvelActivity.findViewById:(I)Landroid/view/View;
        //    38: checkcast       Landroid/widget/RelativeLayout;
        //    41: new             Ljava/lang/StringBuilder;
        //    44: dup            
        //    45: invokespecial   java/lang/StringBuilder.<init>:()V
        //    48: aload_1        
        //    49: getfield        com/admarvel/android/ads/AdMarvelActivity.h:Ljava/lang/String;
        //    52: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //    55: ldc             "BR_VIDEO"
        //    57: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //    60: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //    63: invokevirtual   android/widget/RelativeLayout.findViewWithTag:(Ljava/lang/Object;)Landroid/view/View;
        //    66: checkcast       Lcom/admarvel/android/ads/j;
        //    69: astore_3       
        //    70: aload_2        
        //    71: ifnull          146
        //    74: aload_3        
        //    75: ifnull          146
        //    78: aload_1        
        //    79: getfield        com/admarvel/android/ads/AdMarvelActivity.j:Z
        //    82: ifeq            171
        //    85: aload_1        
        //    86: getfield        com/admarvel/android/ads/AdMarvelActivity.n:Ljava/lang/String;
        //    89: ifnull          146
        //    92: aload_1        
        //    93: getfield        com/admarvel/android/ads/AdMarvelActivity.n:Ljava/lang/String;
        //    96: invokevirtual   java/lang/String.length:()I
        //    99: ifle            146
        //   102: aload_2        
        //   103: new             Ljava/lang/StringBuilder;
        //   106: dup            
        //   107: ldc             "javascript:"
        //   109: invokespecial   java/lang/StringBuilder.<init>:(Ljava/lang/String;)V
        //   112: aload_1        
        //   113: getfield        com/admarvel/android/ads/AdMarvelActivity.n:Ljava/lang/String;
        //   116: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   119: ldc             "("
        //   121: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   124: aload_3        
        //   125: invokevirtual   com/admarvel/android/ads/j.getCurrentPosition:()I
        //   128: i2f            
        //   129: ldc             1000.0
        //   131: fdiv           
        //   132: invokevirtual   java/lang/StringBuilder.append:(F)Ljava/lang/StringBuilder;
        //   135: ldc             ")"
        //   137: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   140: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   143: invokevirtual   com/admarvel/android/ads/d.loadUrl:(Ljava/lang/String;)V
        //   146: aload_1        
        //   147: getfield        com/admarvel/android/ads/AdMarvelActivity.g:Landroid/os/Handler;
        //   150: aload_1        
        //   151: invokestatic    com/admarvel/android/ads/AdMarvelActivity.q:(Lcom/admarvel/android/ads/AdMarvelActivity;)Lcom/admarvel/android/ads/AdMarvelActivity$t;
        //   154: ldc2_w          1000
        //   157: invokevirtual   android/os/Handler.postDelayed:(Ljava/lang/Runnable;J)Z
        //   160: pop            
        //   161: return         
        //   162: astore_1       
        //   163: aload_1        
        //   164: invokestatic    android/util/Log.getStackTraceString:(Ljava/lang/Throwable;)Ljava/lang/String;
        //   167: invokestatic    com/admarvel/android/util/Logging.log:(Ljava/lang/String;)V
        //   170: return         
        //   171: aload_2        
        //   172: new             Ljava/lang/StringBuilder;
        //   175: dup            
        //   176: ldc             "javascript:AdApp.videoView().setCurrentTime("
        //   178: invokespecial   java/lang/StringBuilder.<init>:(Ljava/lang/String;)V
        //   181: aload_3        
        //   182: invokevirtual   com/admarvel/android/ads/j.getCurrentPosition:()I
        //   185: sipush          1000
        //   188: idiv           
        //   189: invokevirtual   java/lang/StringBuilder.append:(I)Ljava/lang/StringBuilder;
        //   192: ldc             ")"
        //   194: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   197: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   200: invokevirtual   com/admarvel/android/ads/d.loadUrl:(Ljava/lang/String;)V
        //   203: goto            146
        //   206: astore_2       
        //   207: aload_2        
        //   208: invokevirtual   java/lang/Exception.printStackTrace:()V
        //   211: goto            146
        //   214: return         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                 
        //  -----  -----  -----  -----  ---------------------
        //  0      22     162    171    Ljava/lang/Exception;
        //  31     70     162    171    Ljava/lang/Exception;
        //  78     146    206    214    Ljava/lang/Exception;
        //  146    161    162    171    Ljava/lang/Exception;
        //  171    203    206    214    Ljava/lang/Exception;
        //  207    211    162    171    Ljava/lang/Exception;
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0146:
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
