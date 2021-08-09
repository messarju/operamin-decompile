// 
// Decompiled by Procyon v0.6-prerelease
// 

package com.admarvel.android.util;

import android.content.Context;

public class OptionalUtils
{
    public static String getId(final Context p0) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: astore          4
        //     3: iconst_0       
        //     4: istore_1       
        //     5: ldc             "com.admarvel.androidid.FetchAndroidId"
        //     7: invokestatic    java/lang/Class.forName:(Ljava/lang/String;)Ljava/lang/Class;
        //    10: astore_2       
        //    11: aload_2        
        //    12: invokevirtual   java/lang/Class.newInstance:()Ljava/lang/Object;
        //    15: astore_3       
        //    16: iconst_1       
        //    17: istore_1       
        //    18: iload_1        
        //    19: ifeq            99
        //    22: aload_2        
        //    23: ldc             "getId"
        //    25: iconst_1       
        //    26: anewarray       Ljava/lang/Class;
        //    29: dup            
        //    30: iconst_0       
        //    31: ldc             Landroid/content/Context;.class
        //    33: aastore        
        //    34: invokevirtual   java/lang/Class.getDeclaredMethod:(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
        //    37: aload_3        
        //    38: iconst_1       
        //    39: anewarray       Ljava/lang/Object;
        //    42: dup            
        //    43: iconst_0       
        //    44: aload_0        
        //    45: aastore        
        //    46: invokevirtual   java/lang/reflect/Method.invoke:(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
        //    49: checkcast       Ljava/lang/String;
        //    52: astore_0       
        //    53: aload_0        
        //    54: areturn        
        //    55: astore_3       
        //    56: aconst_null    
        //    57: astore_2       
        //    58: aload_3        
        //    59: invokevirtual   java/lang/IllegalAccessException.printStackTrace:()V
        //    62: iconst_1       
        //    63: istore_1       
        //    64: aload           4
        //    66: astore_3       
        //    67: goto            18
        //    70: astore_0       
        //    71: aload_0        
        //    72: invokevirtual   java/lang/NoSuchMethodException.printStackTrace:()V
        //    75: ldc             ""
        //    77: areturn        
        //    78: astore_0       
        //    79: aload_0        
        //    80: invokevirtual   java/lang/IllegalArgumentException.printStackTrace:()V
        //    83: ldc             ""
        //    85: areturn        
        //    86: astore_0       
        //    87: aload_0        
        //    88: invokevirtual   java/lang/IllegalAccessException.printStackTrace:()V
        //    91: ldc             ""
        //    93: areturn        
        //    94: astore_0       
        //    95: aload_0        
        //    96: invokevirtual   java/lang/reflect/InvocationTargetException.printStackTrace:()V
        //    99: ldc             ""
        //   101: areturn        
        //   102: astore_3       
        //   103: goto            58
        //   106: astore_2       
        //   107: aconst_null    
        //   108: astore_2       
        //   109: aload           4
        //   111: astore_3       
        //   112: goto            18
        //   115: astore_3       
        //   116: aload           4
        //   118: astore_3       
        //   119: goto            18
        //   122: astore_2       
        //   123: aconst_null    
        //   124: astore_2       
        //   125: aload           4
        //   127: astore_3       
        //   128: goto            18
        //   131: astore_3       
        //   132: aload           4
        //   134: astore_3       
        //   135: goto            18
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                                         
        //  -----  -----  -----  -----  ---------------------------------------------
        //  5      11     122    131    Ljava/lang/ClassNotFoundException;
        //  5      11     106    115    Ljava/lang/InstantiationException;
        //  5      11     55     58     Ljava/lang/IllegalAccessException;
        //  11     16     131    138    Ljava/lang/ClassNotFoundException;
        //  11     16     115    122    Ljava/lang/InstantiationException;
        //  11     16     102    106    Ljava/lang/IllegalAccessException;
        //  22     53     70     78     Ljava/lang/NoSuchMethodException;
        //  22     53     78     86     Ljava/lang/IllegalArgumentException;
        //  22     53     86     94     Ljava/lang/IllegalAccessException;
        //  22     53     94     99     Ljava/lang/reflect/InvocationTargetException;
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0018:
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
