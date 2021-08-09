// 
// Decompiled by Procyon v0.6-prerelease
// 

package com.opera.mini.android;

import android.view.View;
import android.opengl.GLSurfaceView$Renderer;
import android.graphics.Rect;
import android.content.Context;
import android.opengl.GLSurfaceView;

public class ba extends GLSurfaceView implements bi
{
    protected boolean Code;
    private MiniView I;
    private bc Z;
    
    public ba(final Context context, final MiniView i) {
        super(context);
        this.Code = false;
        this.I = i;
        final Rect rect = new Rect();
        this.getWindowVisibleDisplayFrame(rect);
        this.setRenderer((GLSurfaceView$Renderer)(this.Z = new bc(rect.width(), rect.height(), this.I)));
        this.setRenderMode(0);
        this.setFocusableInTouchMode(true);
        if (x.ak >= 11) {
            ad.Code(this, true);
        }
    }
    
    final void B() {
        if (x.ak < 5) {
            this.onDetachedFromWindow();
        }
    }
    
    public void C() {
        this.requestRender();
    }
    
    public View Code() {
        return (View)this;
    }
    
    public void Code(final int n, final int n2, final int n3, final int n4) {
        this.requestRender();
    }
    
    public bi I() {
        return this;
    }
    
    public void J() {
        if (this.Z != null) {
            this.Z.Z();
        }
    }
    
    public void Z() {
        if (this.Z != null) {
            this.Z.I();
        }
    }
    
    public void a() {
        if (x.ak > 4) {
            this.queueEvent((Runnable)new bb(this, this));
            return;
        }
        this.requestRender();
    }
    
    public boolean b() {
        return this.Z.B();
    }
    
    public final void c() {
        this.Z.J();
    }
    
    public final void d() {
        super.onPause();
    }
    
    public void onPause() {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     3: bipush          7
        //     5: if_icmpge       59
        //     8: aload_0        
        //     9: iconst_0       
        //    10: putfield        com/opera/mini/android/ba.Code:Z
        //    13: aload_0        
        //    14: new             Lcom/opera/mini/android/ba$1;
        //    17: dup            
        //    18: aload_0        
        //    19: invokespecial   com/opera/mini/android/ba$1.<init>:(Lcom/opera/mini/android/ba;)V
        //    22: invokevirtual   com/opera/mini/android/ba.queueEvent:(Ljava/lang/Runnable;)V
        //    25: aload_0        
        //    26: invokevirtual   com/opera/mini/android/ba.requestRender:()V
        //    29: aload_0        
        //    30: monitorenter   
        //    31: aload_0        
        //    32: getfield        com/opera/mini/android/ba.Code:Z
        //    35: istore_1       
        //    36: iload_1        
        //    37: ifne            44
        //    40: aload_0        
        //    41: invokevirtual   java/lang/Object.wait:()V
        //    44: aload_0        
        //    45: monitorexit    
        //    46: aload_0        
        //    47: getfield        com/opera/mini/android/ba.Z:Lcom/opera/mini/android/bc;
        //    50: invokevirtual   com/opera/mini/android/bc.Code:()V
        //    53: return         
        //    54: astore_2       
        //    55: aload_0        
        //    56: monitorexit    
        //    57: aload_2        
        //    58: athrow         
        //    59: aload_0        
        //    60: invokespecial   android/opengl/GLSurfaceView.onPause:()V
        //    63: goto            46
        //    66: astore_2       
        //    67: goto            44
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                            
        //  -----  -----  -----  -----  --------------------------------
        //  31     36     54     59     Any
        //  40     44     66     70     Ljava/lang/InterruptedException;
        //  40     44     54     59     Any
        //  44     46     54     59     Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0044:
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
    
    public void onResume() {
        super.onResume();
    }
    
    public void onSizeChanged(final int n, final int n2, final int n3, final int n4) {
        this.Z.Code(n, n2);
        this.I.I(n, n2, n3, n4);
        this.requestRender();
    }
}
