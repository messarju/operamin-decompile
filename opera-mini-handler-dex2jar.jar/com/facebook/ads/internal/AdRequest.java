// 
// Decompiled by Procyon v0.6-prerelease
// 

package com.facebook.ads.internal;

import android.os.AsyncTask;
import java.io.Writer;
import java.io.BufferedWriter;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.BufferedOutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import com.facebook.ads.AdSettings;
import java.util.HashMap;
import java.util.Iterator;
import java.net.URLEncoder;
import com.facebook.ads.AdError;
import org.json.JSONObject;
import org.json.JSONTokener;
import java.io.InputStream;
import android.content.pm.PackageInfo;
import android.util.DisplayMetrics;
import android.content.pm.PackageManager$NameNotFoundException;
import java.util.Locale;
import android.os.Build$VERSION;
import java.util.Map;
import android.content.Context;
import com.facebook.ads.AdSize;

public class AdRequest
{
    private static final String ADS_ENDPOINT = "network_ads";
    private static final int AD_REQUEST_TIMEOUT_MS = 30000;
    private static final String AD_TYPE_PARAM = "ad_type";
    private static final String APP_BUILD_PARAM = "app_build";
    private static final String APP_VERSION_PARAM = "app_version";
    private static final String ATTRIBUTION_ID_PARAM = "attribution_id";
    private static final String CHILD_DIRECTED_PARAM = "child_directed";
    private static final String CLIENT_EVENTS_PARAM = "events";
    private static final String DEFAULT_ENCODING = "utf-8";
    private static final String DEVICE_ID_PARAM = "device_id";
    private static final String DEVICE_ID_TRACKING_ENABLED_PARAM = "tracking_enabled";
    private static final String GRAPH_URL_BASE = "https://graph.facebook.com";
    private static final String GRAPH_URL_BASE_PREFIX_FORMAT = "http://graph.%s.facebook.com";
    private static final String HEIGHT_PARAM = "height";
    private static final String LOCALE_PARAM = "locale";
    private static final String NATIVE_ADS_ENDPOINT = "network_ads_native";
    private static final String OS = "Android";
    private static final String OS_PARAM = "os";
    private static final String OS_VERSION_PARAM = "os_version";
    private static final String PACKAGE_NAME_PARAM = "package_name";
    private static final String PLACEMENT_ID_PARAM = "placement_id";
    private static final String SCREEN_HEIGHT_PARAM = "screen_height";
    private static final String SCREEN_WIDTH_PARAM = "screen_width";
    private static final String SDK_CAPABILITIES_PARAM = "sdk_capabilities";
    private static final String SDK_VERSION = "sdk_version";
    private static final String TAG;
    private static final String TEST_MODE_PARAM = "test_mode";
    private static final String WIDTH_PARAM = "width";
    private final AdSize adSize;
    private final AdType adType;
    private final AdRequest$Callback callback;
    private final Context context;
    private final String placementId;
    private final boolean testMode;
    private final String userAgentString;
    
    static {
        TAG = AdRequest.class.getSimpleName();
    }
    
    public AdRequest(final Context context, final String placementId, final AdSize adSize, final AdType adType, final boolean testMode, final AdRequest$Callback callback) {
        if (placementId == null || placementId.length() <= 0) {
            throw new IllegalArgumentException("placementId");
        }
        if (adSize == null) {
            throw new IllegalArgumentException("adSize");
        }
        if (callback == null) {
            throw new IllegalArgumentException("callback");
        }
        this.context = context;
        this.placementId = placementId;
        this.adSize = adSize;
        this.userAgentString = AdWebViewUtils.getUserAgentString(context, adType);
        this.adType = adType;
        this.testMode = testMode;
        this.callback = callback;
    }
    
    private void addAdvertisingInfoParams(final Map map, final AdUtilities$Fb4aData adUtilities$Fb4aData) {
        boolean b = true;
        final AdvertisingIdInfo advertisingIdInfo = AdvertisingIdInfo.getAdvertisingIdInfo(this.context, adUtilities$Fb4aData);
        if (advertisingIdInfo == null) {
            map.put("tracking_enabled", true);
        }
        else {
            if (advertisingIdInfo.isLimitAdTrackingEnabled()) {
                b = false;
            }
            map.put("tracking_enabled", b);
            if (!advertisingIdInfo.isLimitAdTrackingEnabled()) {
                map.put("device_id", advertisingIdInfo.getId());
            }
        }
    }
    
    private void addAppInfoParams(final Map map) {
        map.put("package_name", this.context.getPackageName());
    }
    
    private void addDeviceInfoParams(final Map map) {
        map.put("os", "Android");
        map.put("os_version", Build$VERSION.RELEASE);
        final DisplayMetrics displayMetrics = this.context.getResources().getDisplayMetrics();
        final int n = (int)(displayMetrics.widthPixels / displayMetrics.density);
        final int n2 = (int)(displayMetrics.heightPixels / displayMetrics.density);
        map.put("screen_width", n);
        map.put("screen_height", n2);
        while (true) {
            try {
                final PackageInfo packageInfo = this.context.getPackageManager().getPackageInfo(this.context.getPackageName(), 0);
                map.put("app_build", packageInfo.versionCode);
                map.put("app_version", packageInfo.versionName);
                Locale locale;
                if ((locale = this.context.getResources().getConfiguration().locale) == null) {
                    locale = Locale.getDefault();
                }
                map.put("locale", locale.toString());
            }
            catch (PackageManager$NameNotFoundException ex) {
                map.put("app_version", 0);
                continue;
            }
            break;
        }
    }
    
    private AdRequest$AdRequestResponse createResponsesFromStream(final InputStream inputStream) {
        final AdRequest$AdRequestResponse adRequest$AdRequestResponse = new AdRequest$AdRequestResponse(null);
        while (true) {
            try {
                final Object nextValue = new JSONTokener(AdUtilities.readStreamToString(inputStream)).nextValue();
                if (nextValue instanceof JSONObject) {
                    final JSONObject body = (JSONObject)nextValue;
                    if (body.has("error")) {
                        final JSONObject jsonObject = (JSONObject)AdUtilities.getStringPropertyAsJSON(body, "error");
                        adRequest$AdRequestResponse.error = new AdError(jsonObject.optInt("code", -1), jsonObject.optString("message", (String)null));
                    }
                    else {
                        adRequest$AdRequestResponse.body = body;
                        adRequest$AdRequestResponse.error = null;
                    }
                }
                if (adRequest$AdRequestResponse.body == null && adRequest$AdRequestResponse.error == null) {
                    return null;
                }
                return adRequest$AdRequestResponse;
            }
            catch (Exception ex) {
                adRequest$AdRequestResponse.error = new AdError(-1, ex.getMessage());
                continue;
            }
            continue;
        }
    }
    
    private String getAdsEndpoint() {
        switch (this.adType) {
            default: {
                return "network_ads";
            }
            case NATIVE: {
                return "network_ads_native";
            }
        }
    }
    
    private String getQueryString(final Map map) {
        final StringBuilder sb = new StringBuilder(512);
        final Iterator iterator = map.entrySet().iterator();
        int n = 1;
        while (iterator.hasNext()) {
            final Map.Entry<String, V> entry = (Map.Entry<String, V>)iterator.next();
            if (n != 0) {
                n = 0;
            }
            else {
                sb.append("&");
            }
            sb.append(URLEncoder.encode(entry.getKey(), "utf-8")).append("=").append(URLEncoder.encode(String.valueOf(entry.getValue()), "utf-8"));
        }
        return sb.toString();
    }
    
    private Map getRequestParameters() {
        final HashMap hashMap = new HashMap();
        final AdUtilities$Fb4aData fb4aData = AdUtilities.getFb4aData(this.context.getContentResolver());
        hashMap.put("ad_type", this.adType.getValue());
        hashMap.put("sdk_capabilities", AdSdkCapability.getSupportedCapabilitiesAsJSONString());
        hashMap.put("sdk_version", "3.20.0");
        hashMap.put("placement_id", this.placementId);
        hashMap.put("attribution_id", fb4aData.attributionId);
        hashMap.put("width", this.adSize.getWidth());
        hashMap.put("height", this.adSize.getHeight());
        hashMap.put("test_mode", this.testMode);
        hashMap.put("child_directed", AdSettings.isChildDirected());
        hashMap.put("events", AdClientEventManager.dumpClientEventToJson());
        this.addDeviceInfoParams(hashMap);
        this.addAppInfoParams(hashMap);
        this.addAdvertisingInfoParams(hashMap, fb4aData);
        return hashMap;
    }
    
    private URL getUrlForRequest() {
        final String urlPrefix = AdSettings.getUrlPrefix();
        String format;
        if (StringUtils.isNullOrEmpty(urlPrefix)) {
            format = "https://graph.facebook.com";
        }
        else {
            format = String.format("http://graph.%s.facebook.com", urlPrefix);
        }
        return new URL(String.format("%s/%s", format, this.getAdsEndpoint()));
    }
    
    private HttpURLConnection makeRequest() {
        final HttpURLConnection httpURLConnection = (HttpURLConnection)this.getUrlForRequest().openConnection();
        httpURLConnection.setRequestProperty("User-Agent", this.userAgentString);
        httpURLConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
        httpURLConnection.setRequestMethod("POST");
        httpURLConnection.setDoOutput(true);
        httpURLConnection.setConnectTimeout(30000);
        httpURLConnection.setReadTimeout(30000);
        final String queryString = this.getQueryString(this.getRequestParameters());
        final BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(httpURLConnection.getOutputStream());
        final BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(bufferedOutputStream, "utf-8"));
        bufferedWriter.write(queryString);
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedOutputStream.close();
        httpURLConnection.connect();
        return httpURLConnection;
    }
    
    public AsyncTask executeAsync() {
        AdAnalogData.startUpdate(this.context);
        return new AsyncTask() {
            protected AdRequest$AdRequestResponse doInBackground(final Void... array) {
                return AdRequest.this.executeConnectionAndWait();
            }
            
            protected void onPostExecute(final AdRequest$AdRequestResponse adRequest$AdRequestResponse) {
                if (adRequest$AdRequestResponse == null) {
                    AdRequest.this.callback.onError(AdError.INTERNAL_ERROR);
                    return;
                }
                if (adRequest$AdRequestResponse.error != null) {
                    AdRequest.this.callback.onError(adRequest$AdRequestResponse.error);
                    return;
                }
                AdRequest.this.callback.onCompleted(AdResponse.parseResponse(AdRequest.this.context, adRequest$AdRequestResponse.body));
            }
        }.execute((Object[])new Void[0]);
    }
    
    public AdRequest$AdRequestResponse executeConnectionAndWait() {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: astore_3       
        //     2: aconst_null    
        //     3: astore          4
        //     5: aconst_null    
        //     6: astore_2       
        //     7: aconst_null    
        //     8: astore          5
        //    10: aconst_null    
        //    11: astore_1       
        //    12: aload_0        
        //    13: invokespecial   com/facebook/ads/internal/AdRequest.makeRequest:()Ljava/net/HttpURLConnection;
        //    16: astore          6
        //    18: aload           6
        //    20: astore_1       
        //    21: aload           5
        //    23: astore          4
        //    25: aload_1        
        //    26: invokevirtual   java/net/HttpURLConnection.getResponseCode:()I
        //    29: sipush          400
        //    32: if_icmplt       80
        //    35: aload           5
        //    37: astore          4
        //    39: aload_1        
        //    40: invokevirtual   java/net/HttpURLConnection.getErrorStream:()Ljava/io/InputStream;
        //    43: astore_2       
        //    44: aload_1        
        //    45: astore_3       
        //    46: aload_2        
        //    47: astore          5
        //    49: aload_2        
        //    50: astore          4
        //    52: aload_0        
        //    53: aload_2        
        //    54: invokespecial   com/facebook/ads/internal/AdRequest.createResponsesFromStream:(Ljava/io/InputStream;)Lcom/facebook/ads/internal/AdRequest$AdRequestResponse;
        //    57: astore          6
        //    59: aload           6
        //    61: astore_3       
        //    62: aload_2        
        //    63: invokestatic    com/facebook/ads/internal/AdUtilities.closeQuietly:(Ljava/io/Closeable;)V
        //    66: aload_3        
        //    67: astore_2       
        //    68: aload_1        
        //    69: ifnull          78
        //    72: aload_1        
        //    73: invokevirtual   java/net/HttpURLConnection.disconnect:()V
        //    76: aload_3        
        //    77: astore_2       
        //    78: aload_2        
        //    79: areturn        
        //    80: aload           5
        //    82: astore          4
        //    84: aload_1        
        //    85: invokevirtual   java/net/HttpURLConnection.getInputStream:()Ljava/io/InputStream;
        //    88: astore_2       
        //    89: goto            44
        //    92: astore          5
        //    94: aconst_null    
        //    95: astore_2       
        //    96: aload_1        
        //    97: astore          4
        //    99: aload_2        
        //   100: astore_3       
        //   101: new             Lcom/facebook/ads/internal/AdRequest$AdRequestResponse;
        //   104: dup            
        //   105: aconst_null    
        //   106: invokespecial   com/facebook/ads/internal/AdRequest$AdRequestResponse.<init>:(Lcom/facebook/ads/internal/AdRequest$1;)V
        //   109: astore          6
        //   111: aload_1        
        //   112: astore          4
        //   114: aload_2        
        //   115: astore_3       
        //   116: aload           6
        //   118: new             Lcom/facebook/ads/AdError;
        //   121: dup            
        //   122: iconst_m1      
        //   123: aload           5
        //   125: invokevirtual   java/net/SocketTimeoutException.getMessage:()Ljava/lang/String;
        //   128: invokespecial   com/facebook/ads/AdError.<init>:(ILjava/lang/String;)V
        //   131: putfield        com/facebook/ads/internal/AdRequest$AdRequestResponse.error:Lcom/facebook/ads/AdError;
        //   134: aload_2        
        //   135: invokestatic    com/facebook/ads/internal/AdUtilities.closeQuietly:(Ljava/io/Closeable;)V
        //   138: aload           6
        //   140: astore_2       
        //   141: aload_1        
        //   142: ifnull          78
        //   145: aload_1        
        //   146: invokevirtual   java/net/HttpURLConnection.disconnect:()V
        //   149: aload           6
        //   151: areturn        
        //   152: astore          5
        //   154: aconst_null    
        //   155: astore_2       
        //   156: aload_3        
        //   157: astore_1       
        //   158: aload_1        
        //   159: astore          4
        //   161: aload_2        
        //   162: astore_3       
        //   163: new             Lcom/facebook/ads/internal/AdRequest$AdRequestResponse;
        //   166: dup            
        //   167: aconst_null    
        //   168: invokespecial   com/facebook/ads/internal/AdRequest$AdRequestResponse.<init>:(Lcom/facebook/ads/internal/AdRequest$1;)V
        //   171: astore          6
        //   173: aload_1        
        //   174: astore          4
        //   176: aload_2        
        //   177: astore_3       
        //   178: aload           6
        //   180: new             Lcom/facebook/ads/AdError;
        //   183: dup            
        //   184: iconst_m1      
        //   185: aload           5
        //   187: invokevirtual   java/io/IOException.getMessage:()Ljava/lang/String;
        //   190: invokespecial   com/facebook/ads/AdError.<init>:(ILjava/lang/String;)V
        //   193: putfield        com/facebook/ads/internal/AdRequest$AdRequestResponse.error:Lcom/facebook/ads/AdError;
        //   196: aload_2        
        //   197: invokestatic    com/facebook/ads/internal/AdUtilities.closeQuietly:(Ljava/io/Closeable;)V
        //   200: aload           6
        //   202: astore_2       
        //   203: aload_1        
        //   204: ifnull          78
        //   207: aload_1        
        //   208: invokevirtual   java/net/HttpURLConnection.disconnect:()V
        //   211: aload           6
        //   213: areturn        
        //   214: astore_2       
        //   215: aconst_null    
        //   216: astore_1       
        //   217: aload_1        
        //   218: astore_3       
        //   219: aload           4
        //   221: astore          5
        //   223: getstatic       com/facebook/ads/internal/AdRequest.TAG:Ljava/lang/String;
        //   226: ldc_w           "Unexpected error"
        //   229: aload_2        
        //   230: invokestatic    android/util/Log.e:(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
        //   233: pop            
        //   234: aload_1        
        //   235: astore_3       
        //   236: aload           4
        //   238: astore          5
        //   240: new             Lcom/facebook/ads/internal/AdRequest$AdRequestResponse;
        //   243: dup            
        //   244: aconst_null    
        //   245: invokespecial   com/facebook/ads/internal/AdRequest$AdRequestResponse.<init>:(Lcom/facebook/ads/internal/AdRequest$1;)V
        //   248: astore          6
        //   250: aload_1        
        //   251: astore_3       
        //   252: aload           4
        //   254: astore          5
        //   256: aload           6
        //   258: getstatic       com/facebook/ads/AdError.INTERNAL_ERROR:Lcom/facebook/ads/AdError;
        //   261: putfield        com/facebook/ads/internal/AdRequest$AdRequestResponse.error:Lcom/facebook/ads/AdError;
        //   264: aload           4
        //   266: invokestatic    com/facebook/ads/internal/AdUtilities.closeQuietly:(Ljava/io/Closeable;)V
        //   269: aload           6
        //   271: astore_2       
        //   272: aload_1        
        //   273: ifnull          78
        //   276: aload_1        
        //   277: invokevirtual   java/net/HttpURLConnection.disconnect:()V
        //   280: aload           6
        //   282: areturn        
        //   283: astore_1       
        //   284: aconst_null    
        //   285: astore_3       
        //   286: aload_3        
        //   287: invokestatic    com/facebook/ads/internal/AdUtilities.closeQuietly:(Ljava/io/Closeable;)V
        //   290: aload_2        
        //   291: ifnull          298
        //   294: aload_2        
        //   295: invokevirtual   java/net/HttpURLConnection.disconnect:()V
        //   298: aload_1        
        //   299: athrow         
        //   300: astore          4
        //   302: aconst_null    
        //   303: astore_3       
        //   304: aload_1        
        //   305: astore_2       
        //   306: aload           4
        //   308: astore_1       
        //   309: goto            286
        //   312: astore_1       
        //   313: aload_3        
        //   314: astore_2       
        //   315: aload           5
        //   317: astore_3       
        //   318: goto            286
        //   321: astore_1       
        //   322: aload           4
        //   324: astore_2       
        //   325: goto            286
        //   328: astore_2       
        //   329: goto            217
        //   332: astore          5
        //   334: aconst_null    
        //   335: astore_2       
        //   336: goto            158
        //   339: astore          5
        //   341: goto            158
        //   344: astore          5
        //   346: aconst_null    
        //   347: astore_2       
        //   348: goto            96
        //   351: astore          5
        //   353: goto            96
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                             
        //  -----  -----  -----  -----  ---------------------------------
        //  12     18     92     96     Ljava/net/SocketTimeoutException;
        //  12     18     152    158    Ljava/io/IOException;
        //  12     18     214    217    Ljava/lang/Exception;
        //  12     18     283    286    Any
        //  25     35     344    351    Ljava/net/SocketTimeoutException;
        //  25     35     332    339    Ljava/io/IOException;
        //  25     35     328    332    Ljava/lang/Exception;
        //  25     35     300    312    Any
        //  39     44     344    351    Ljava/net/SocketTimeoutException;
        //  39     44     332    339    Ljava/io/IOException;
        //  39     44     328    332    Ljava/lang/Exception;
        //  39     44     300    312    Any
        //  52     59     351    356    Ljava/net/SocketTimeoutException;
        //  52     59     339    344    Ljava/io/IOException;
        //  52     59     328    332    Ljava/lang/Exception;
        //  52     59     312    321    Any
        //  84     89     344    351    Ljava/net/SocketTimeoutException;
        //  84     89     332    339    Ljava/io/IOException;
        //  84     89     328    332    Ljava/lang/Exception;
        //  84     89     300    312    Any
        //  101    111    321    328    Any
        //  116    134    321    328    Any
        //  163    173    321    328    Any
        //  178    196    321    328    Any
        //  223    234    312    321    Any
        //  240    250    312    321    Any
        //  256    264    312    321    Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IndexOutOfBoundsException: Index: 207, Size: 207
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
}
