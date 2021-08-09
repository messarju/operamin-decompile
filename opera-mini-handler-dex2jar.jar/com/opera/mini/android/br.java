// 
// Decompiled by Procyon v0.6-prerelease
// 

package com.opera.mini.android;

import android.net.NetworkInfo;
import java.net.ProxySelector;
import java.net.SocketAddress;
import java.net.InetSocketAddress;
import android.text.TextUtils;
import android.net.ConnectivityManager;
import java.net.Proxy;
import org.apache.http.HttpHost;
import java.net.URI;
import android.content.Context;

public final class br
{
    public static HttpHost Code(final Context p0, final URI p1) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: astore          4
        //     3: aload_0        
        //     4: aload_1        
        //     5: invokestatic    com/opera/mini/android/br.I:(Landroid/content/Context;Ljava/net/URI;)Ljava/net/Proxy;
        //     8: astore_0       
        //     9: aload_0        
        //    10: ifnull          117
        //    13: aload_0        
        //    14: invokevirtual   java/net/Proxy.type:()Ljava/net/Proxy$Type;
        //    17: getstatic       java/net/Proxy$Type.HTTP:Ljava/net/Proxy$Type;
        //    20: if_acmpne       117
        //    23: aload_0        
        //    24: invokevirtual   java/net/Proxy.address:()Ljava/net/SocketAddress;
        //    27: instanceof      Ljava/net/InetSocketAddress;
        //    30: ifeq            117
        //    33: aload_0        
        //    34: invokevirtual   java/net/Proxy.address:()Ljava/net/SocketAddress;
        //    37: checkcast       Ljava/net/InetSocketAddress;
        //    40: astore_1       
        //    41: aload_1        
        //    42: invokevirtual   java/net/InetSocketAddress.isUnresolved:()Z
        //    45: ifeq            94
        //    48: aload_1        
        //    49: invokevirtual   java/net/InetSocketAddress.getHostName:()Ljava/lang/String;
        //    52: astore_0       
        //    53: aload_1        
        //    54: invokevirtual   java/net/InetSocketAddress.getPort:()I
        //    57: istore_2       
        //    58: aload           4
        //    60: astore_1       
        //    61: aload_0        
        //    62: invokestatic    android/text/TextUtils.isEmpty:(Ljava/lang/CharSequence;)Z
        //    65: ifne            92
        //    68: iload_2        
        //    69: iconst_m1      
        //    70: if_icmpeq       79
        //    73: iload_2        
        //    74: istore_3       
        //    75: iload_2        
        //    76: ifne            82
        //    79: bipush          80
        //    81: istore_3       
        //    82: new             Lorg/apache/http/HttpHost;
        //    85: dup            
        //    86: aload_0        
        //    87: iload_3        
        //    88: invokespecial   org/apache/http/HttpHost.<init>:(Ljava/lang/String;I)V
        //    91: astore_1       
        //    92: aload_1        
        //    93: areturn        
        //    94: aload_1        
        //    95: invokevirtual   java/net/InetSocketAddress.getAddress:()Ljava/net/InetAddress;
        //    98: invokevirtual   java/net/InetAddress.getHostAddress:()Ljava/lang/String;
        //   101: astore_0       
        //   102: goto            53
        //   105: astore_0       
        //   106: aconst_null    
        //   107: astore_0       
        //   108: iconst_m1      
        //   109: istore_2       
        //   110: goto            58
        //   113: astore_1       
        //   114: goto            108
        //   117: iconst_m1      
        //   118: istore_2       
        //   119: aconst_null    
        //   120: astore_0       
        //   121: goto            58
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                 
        //  -----  -----  -----  -----  ---------------------
        //  3      9      105    108    Ljava/lang/Exception;
        //  13     53     105    108    Ljava/lang/Exception;
        //  53     58     113    117    Ljava/lang/Exception;
        //  94     102    105    108    Ljava/lang/Exception;
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0053:
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
    
    private static Proxy I(final Context context, final URI uri) {
        final Proxy no_PROXY = Proxy.NO_PROXY;
        final NetworkInfo activeNetworkInfo = ((ConnectivityManager)context.getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo != null && activeNetworkInfo.getType() == 0 && x.ak < 11) {
            final String host = android.net.Proxy.getHost(context);
            int port = android.net.Proxy.getPort(context);
            if (port == -1) {
                port = 80;
            }
            if (!TextUtils.isEmpty((CharSequence)host)) {
                return new Proxy(Proxy.Type.HTTP, InetSocketAddress.createUnresolved(host, port));
            }
        }
        else {
            try {
                return ProxySelector.getDefault().select(uri).get(0);
            }
            catch (IllegalArgumentException ex) {}
        }
        return no_PROXY;
    }
}
