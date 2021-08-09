// 
// Decompiled by Procyon v0.6-prerelease
// 

package com.facebook.ads.internal;

import java.lang.reflect.Constructor;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Method;
import android.os.Build$VERSION;
import android.annotation.TargetApi;
import android.webkit.WebSettings;
import android.content.Context;
import com.facebook.ads.AdSettings;
import android.webkit.WebViewClient;
import android.webkit.WebView;

public class AdWebViewUtils
{
    public static final long DEFAULT_IMPRESSION_DELAY_MS = 1000L;
    public static final String FBAD_SCHEME = "fbad";
    private static final String WEBVIEW_BASE_PREFIX_FORMAT = "https://www.%s.facebook.com";
    private static final String WEBVIEW_BASE_URL = "https://www.facebook.com/";
    private static String browserUserAgentString;
    
    static {
        AdWebViewUtils.browserUserAgentString = null;
    }
    
    public static void config(final WebView webView, final WebViewClient webViewClient, final AdWebViewInterface adWebViewInterface) {
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setSupportZoom(false);
        webView.setHorizontalScrollBarEnabled(false);
        webView.setHorizontalScrollbarOverlay(false);
        webView.setVerticalScrollBarEnabled(false);
        webView.setVerticalScrollbarOverlay(false);
        webView.addJavascriptInterface((Object)adWebViewInterface, "AdControl");
        webView.setWebViewClient(webViewClient);
    }
    
    public static String getBaseUrl() {
        final String urlPrefix = AdSettings.getUrlPrefix();
        if (StringUtils.isNullOrEmpty(urlPrefix)) {
            return "https://www.facebook.com/";
        }
        return String.format("https://www.%s.facebook.com", urlPrefix);
    }
    
    @TargetApi(17)
    private static String getDefaultUserAgentL17(final Context context) {
        return WebSettings.getDefaultUserAgent(context);
    }
    
    public static String getUserAgentString(final Context context, final AdType adType) {
        if (AdType.NATIVE == adType) {
            return System.getProperty("http.agent");
        }
        if (AdWebViewUtils.browserUserAgentString == null) {
            if (Build$VERSION.SDK_INT >= 17) {
                AdWebViewUtils.browserUserAgentString = getDefaultUserAgentL17(context);
            }
            else {
                try {
                    AdWebViewUtils.browserUserAgentString = getUserAgentStringByReflection(context, "android.webkit.WebSettings", "android.webkit.WebView");
                }
                catch (Exception ex) {
                    try {
                        AdWebViewUtils.browserUserAgentString = getUserAgentStringByReflection(context, "android.webkit.WebSettingsClassic", "android.webkit.WebViewClassic");
                    }
                    catch (Exception ex2) {
                        final WebView webView = new WebView(context.getApplicationContext());
                        AdWebViewUtils.browserUserAgentString = webView.getSettings().getUserAgentString();
                        webView.destroy();
                    }
                }
            }
        }
        return AdWebViewUtils.browserUserAgentString;
    }
    
    private static String getUserAgentStringByReflection(final Context context, String declaredConstructor, final String s) {
        final Class<?> forName = Class.forName(declaredConstructor);
        declaredConstructor = (String)forName.getDeclaredConstructor(Context.class, Class.forName(s));
        ((AccessibleObject)declaredConstructor).setAccessible(true);
        final Method method = forName.getMethod("getUserAgentString", (Class[])new Class[0]);
        try {
            return (String)method.invoke(((Constructor<Object>)declaredConstructor).newInstance(context, null), new Object[0]);
        }
        finally {
            ((AccessibleObject)declaredConstructor).setAccessible(false);
        }
    }
}
