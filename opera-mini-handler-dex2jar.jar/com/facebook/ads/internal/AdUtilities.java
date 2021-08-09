// 
// Decompiled by Procyon v0.6-prerelease
// 

package com.facebook.ads.internal;

import org.json.JSONException;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONTokener;
import org.json.JSONObject;
import java.lang.reflect.Method;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.conn.scheme.SocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.ProtocolVersion;
import org.apache.http.params.HttpParams;
import org.apache.http.params.HttpProtocolParams;
import org.apache.http.HttpVersion;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.conn.ssl.SSLSocketFactory;
import java.io.InputStream;
import java.security.KeyStore;
import org.apache.http.client.HttpClient;
import android.content.ContentResolver;
import android.util.Log;
import com.facebook.ads.AdSettings;
import android.content.Context;
import java.io.IOException;
import java.io.Closeable;
import android.net.Uri;

public class AdUtilities
{
    private static final String ADVERTISING_ID_COLUMN_NAME = "androidid";
    private static final String ATTRIBUTION_ID_COLUMN_NAME = "aid";
    private static final Uri ATTRIBUTION_ID_CONTENT_URI;
    private static final String LIMIT_TRACKING_COLUMN_NAME = "limit_tracking";
    
    static {
        ATTRIBUTION_ID_CONTENT_URI = Uri.parse("content://com.facebook.katana.provider.AttributionIdProvider");
    }
    
    public static void closeQuietly(final Closeable closeable) {
        if (closeable == null) {
            return;
        }
        try {
            closeable.close();
        }
        catch (IOException ex) {}
    }
    
    public static void displayDebugMessage(final Context context, final String s) {
        if (AdSettings.isTestMode(context)) {
            Log.d("FBAudienceNetworkLog", s + " (displayed for test ads only)");
        }
    }
    
    public static AdUtilities$Fb4aData getFb4aData(final ContentResolver p0) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: getstatic       com/facebook/ads/internal/AdUtilities.ATTRIBUTION_ID_CONTENT_URI:Landroid/net/Uri;
        //     4: iconst_3       
        //     5: anewarray       Ljava/lang/String;
        //     8: dup            
        //     9: iconst_0       
        //    10: ldc             "aid"
        //    12: aastore        
        //    13: dup            
        //    14: iconst_1       
        //    15: ldc             "androidid"
        //    17: aastore        
        //    18: dup            
        //    19: iconst_2       
        //    20: ldc             "limit_tracking"
        //    22: aastore        
        //    23: aconst_null    
        //    24: aconst_null    
        //    25: aconst_null    
        //    26: invokevirtual   android/content/ContentResolver.query:(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
        //    29: astore_1       
        //    30: aload_1        
        //    31: ifnull          45
        //    34: aload_1        
        //    35: astore_0       
        //    36: aload_1        
        //    37: invokeinterface android/database/Cursor.moveToFirst:()Z
        //    42: ifne            74
        //    45: aload_1        
        //    46: astore_0       
        //    47: new             Lcom/facebook/ads/internal/AdUtilities$Fb4aData;
        //    50: dup            
        //    51: aconst_null    
        //    52: aconst_null    
        //    53: iconst_0       
        //    54: invokespecial   com/facebook/ads/internal/AdUtilities$Fb4aData.<init>:(Ljava/lang/String;Ljava/lang/String;Z)V
        //    57: astore_2       
        //    58: aload_2        
        //    59: astore_0       
        //    60: aload_1        
        //    61: ifnull          72
        //    64: aload_1        
        //    65: invokeinterface android/database/Cursor.close:()V
        //    70: aload_2        
        //    71: astore_0       
        //    72: aload_0        
        //    73: areturn        
        //    74: aload_1        
        //    75: astore_0       
        //    76: new             Lcom/facebook/ads/internal/AdUtilities$Fb4aData;
        //    79: dup            
        //    80: aload_1        
        //    81: aload_1        
        //    82: ldc             "aid"
        //    84: invokeinterface android/database/Cursor.getColumnIndex:(Ljava/lang/String;)I
        //    89: invokeinterface android/database/Cursor.getString:(I)Ljava/lang/String;
        //    94: aload_1        
        //    95: aload_1        
        //    96: ldc             "androidid"
        //    98: invokeinterface android/database/Cursor.getColumnIndex:(Ljava/lang/String;)I
        //   103: invokeinterface android/database/Cursor.getString:(I)Ljava/lang/String;
        //   108: aload_1        
        //   109: aload_1        
        //   110: ldc             "limit_tracking"
        //   112: invokeinterface android/database/Cursor.getColumnIndex:(Ljava/lang/String;)I
        //   117: invokeinterface android/database/Cursor.getString:(I)Ljava/lang/String;
        //   122: invokestatic    java/lang/Boolean.valueOf:(Ljava/lang/String;)Ljava/lang/Boolean;
        //   125: invokevirtual   java/lang/Boolean.booleanValue:()Z
        //   128: invokespecial   com/facebook/ads/internal/AdUtilities$Fb4aData.<init>:(Ljava/lang/String;Ljava/lang/String;Z)V
        //   131: astore_2       
        //   132: aload_2        
        //   133: astore_0       
        //   134: aload_1        
        //   135: ifnull          72
        //   138: aload_1        
        //   139: invokeinterface android/database/Cursor.close:()V
        //   144: aload_2        
        //   145: areturn        
        //   146: astore_0       
        //   147: aconst_null    
        //   148: astore_1       
        //   149: aload_1        
        //   150: astore_0       
        //   151: new             Lcom/facebook/ads/internal/AdUtilities$Fb4aData;
        //   154: dup            
        //   155: aconst_null    
        //   156: aconst_null    
        //   157: iconst_0       
        //   158: invokespecial   com/facebook/ads/internal/AdUtilities$Fb4aData.<init>:(Ljava/lang/String;Ljava/lang/String;Z)V
        //   161: astore_2       
        //   162: aload_2        
        //   163: astore_0       
        //   164: aload_1        
        //   165: ifnull          72
        //   168: aload_1        
        //   169: invokeinterface android/database/Cursor.close:()V
        //   174: aload_2        
        //   175: areturn        
        //   176: astore_1       
        //   177: aconst_null    
        //   178: astore_0       
        //   179: aload_0        
        //   180: ifnull          189
        //   183: aload_0        
        //   184: invokeinterface android/database/Cursor.close:()V
        //   189: aload_1        
        //   190: athrow         
        //   191: astore_1       
        //   192: goto            179
        //   195: astore_0       
        //   196: goto            149
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                 
        //  -----  -----  -----  -----  ---------------------
        //  0      30     146    149    Ljava/lang/Exception;
        //  0      30     176    179    Any
        //  36     45     195    199    Ljava/lang/Exception;
        //  36     45     191    195    Any
        //  47     58     195    199    Ljava/lang/Exception;
        //  47     58     191    195    Any
        //  76     132    195    199    Ljava/lang/Exception;
        //  76     132    191    195    Any
        //  151    162    191    195    Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0045:
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
    
    public static HttpClient getHttpClient() {
        if (isSandboxUrl()) {
            try {
                final KeyStore instance = KeyStore.getInstance(KeyStore.getDefaultType());
                instance.load(null, null);
                final SandboxSSLSocketFactory sandboxSSLSocketFactory = new SandboxSSLSocketFactory(instance);
                sandboxSSLSocketFactory.setHostnameVerifier(SSLSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER);
                final BasicHttpParams basicHttpParams = new BasicHttpParams();
                HttpProtocolParams.setVersion((HttpParams)basicHttpParams, (ProtocolVersion)HttpVersion.HTTP_1_1);
                HttpProtocolParams.setContentCharset((HttpParams)basicHttpParams, "UTF-8");
                final SchemeRegistry schemeRegistry = new SchemeRegistry();
                schemeRegistry.register(new Scheme("http", (SocketFactory)PlainSocketFactory.getSocketFactory(), 80));
                schemeRegistry.register(new Scheme("https", (SocketFactory)sandboxSSLSocketFactory, 443));
                return (HttpClient)new DefaultHttpClient((ClientConnectionManager)new ThreadSafeClientConnManager((HttpParams)basicHttpParams, schemeRegistry), (HttpParams)basicHttpParams);
            }
            catch (Exception ex) {}
        }
        return (HttpClient)new DefaultHttpClient();
    }
    
    public static Method getMethod(final Class clazz, final String s, final Class... array) {
        try {
            return clazz.getMethod(s, (Class[])array);
        }
        catch (NoSuchMethodException ex) {
            return null;
        }
    }
    
    public static Method getMethod(final String s, final String s2, final Class... array) {
        try {
            return getMethod(Class.forName(s), s2, array);
        }
        catch (ClassNotFoundException ex) {
            return null;
        }
    }
    
    public static Object getStringPropertyAsJSON(final JSONObject jsonObject, final String s) {
        Object o2;
        final Object o = o2 = jsonObject.opt(s);
        if (o != null) {
            o2 = o;
            if (o instanceof String) {
                o2 = new JSONTokener((String)o).nextValue();
            }
        }
        if (o2 != null && !(o2 instanceof JSONObject) && !(o2 instanceof JSONArray)) {
            throw new IllegalArgumentException(s);
        }
        return o2;
    }
    
    public static Object invokeMethod(Object invoke, final Method method, final Object... array) {
        try {
            invoke = method.invoke(invoke, array);
            return invoke;
        }
        catch (Exception ex) {
            return null;
        }
    }
    
    public static boolean isSandboxUrl() {
        final String urlPrefix = AdSettings.getUrlPrefix();
        return !StringUtils.isNullOrEmpty(urlPrefix) && urlPrefix.endsWith(".sb");
    }
    
    public static String jsonEncode(Map iterator) {
        final JSONObject jsonObject = new JSONObject();
        iterator = ((Map)iterator).entrySet().iterator();
        while (iterator.hasNext()) {
            final Map.Entry entry = (Map.Entry)iterator.next();
            try {
                jsonObject.put((String)entry.getKey(), entry.getValue());
            }
            catch (JSONException ex) {
                ex.printStackTrace();
            }
        }
        return jsonObject.toString();
    }
    
    public static String readStreamToString(final InputStream p0) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: astore_3       
        //     2: new             Ljava/io/BufferedInputStream;
        //     5: dup            
        //     6: aload_0        
        //     7: invokespecial   java/io/BufferedInputStream.<init>:(Ljava/io/InputStream;)V
        //    10: astore_0       
        //    11: new             Ljava/io/InputStreamReader;
        //    14: dup            
        //    15: aload_0        
        //    16: invokespecial   java/io/InputStreamReader.<init>:(Ljava/io/InputStream;)V
        //    19: astore_2       
        //    20: new             Ljava/lang/StringBuilder;
        //    23: dup            
        //    24: invokespecial   java/lang/StringBuilder.<init>:()V
        //    27: astore_3       
        //    28: sipush          2048
        //    31: newarray        C
        //    33: astore          4
        //    35: aload_2        
        //    36: aload           4
        //    38: invokevirtual   java/io/InputStreamReader.read:([C)I
        //    41: istore_1       
        //    42: iload_1        
        //    43: iconst_m1      
        //    44: if_icmpeq       76
        //    47: aload_3        
        //    48: aload           4
        //    50: iconst_0       
        //    51: iload_1        
        //    52: invokevirtual   java/lang/StringBuilder.append:([CII)Ljava/lang/StringBuilder;
        //    55: pop            
        //    56: goto            35
        //    59: astore          4
        //    61: aload_0        
        //    62: astore_3       
        //    63: aload           4
        //    65: astore_0       
        //    66: aload_3        
        //    67: invokestatic    com/facebook/ads/internal/AdUtilities.closeQuietly:(Ljava/io/Closeable;)V
        //    70: aload_2        
        //    71: invokestatic    com/facebook/ads/internal/AdUtilities.closeQuietly:(Ljava/io/Closeable;)V
        //    74: aload_0        
        //    75: athrow         
        //    76: aload_3        
        //    77: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //    80: astore_3       
        //    81: aload_0        
        //    82: invokestatic    com/facebook/ads/internal/AdUtilities.closeQuietly:(Ljava/io/Closeable;)V
        //    85: aload_2        
        //    86: invokestatic    com/facebook/ads/internal/AdUtilities.closeQuietly:(Ljava/io/Closeable;)V
        //    89: aload_3        
        //    90: areturn        
        //    91: astore_0       
        //    92: aconst_null    
        //    93: astore_2       
        //    94: goto            66
        //    97: astore          4
        //    99: aconst_null    
        //   100: astore_2       
        //   101: aload_0        
        //   102: astore_3       
        //   103: aload           4
        //   105: astore_0       
        //   106: goto            66
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type
        //  -----  -----  -----  -----  ----
        //  2      11     91     97     Any
        //  11     20     97     109    Any
        //  20     35     59     66     Any
        //  35     42     59     66     Any
        //  47     56     59     66     Any
        //  76     81     59     66     Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0035:
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
