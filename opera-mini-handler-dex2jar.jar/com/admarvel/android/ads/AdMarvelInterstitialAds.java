// 
// Decompiled by Procyon v0.6-prerelease
// 

package com.admarvel.android.ads;

import android.content.SharedPreferences;
import android.os.Looper;
import android.content.SharedPreferences$Editor;
import android.content.pm.PackageManager$NameNotFoundException;
import android.util.Log;
import com.admarvel.android.util.Logging;
import java.util.Date;
import java.text.DateFormat;
import android.app.Activity;
import java.io.IOException;
import java.io.OutputStream;
import java.io.ObjectOutputStream;
import java.io.ByteArrayOutputStream;
import android.content.Intent;
import android.os.Handler;
import com.admarvel.android.util.a.b;
import android.content.Context;
import java.util.UUID;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;
import java.lang.ref.WeakReference;
import java.util.HashMap;

public class AdMarvelInterstitialAds
{
    private static String DEFAULT_IMAGE_WEB_VIEW_CSS;
    private static String DEFAULT_IMAGE_WEB_VIEW_HTML_FORMAT;
    private static String DEFAULT_WEB_VIEW_CSS;
    private static String DEFAULT_WEB_VIEW_HTML_FORMAT;
    private static String DEFAULT_WEB_VIEW_VIEWPORT;
    protected static final String GUID;
    private static String IMAGE_AD_AUTOSCALED_WEB_VIEW_VIEWPORT;
    private static String ORMMA_WEB_VIEW_CSS;
    private static boolean enableClickRedirect;
    public static boolean enableOfflineSDK;
    private static final e listener;
    private final HashMap admarvelInterstitialAds;
    private final int backgroundColor;
    WeakReference contextReference;
    private boolean enableAutoScaling;
    private final AdMarvelInterstitialAds$d internalAdMarvelInterstitialAdapterListener;
    private final AtomicLong lockTimestamp;
    private Map optionalFlags;
    private final int textBackgroundColor;
    private final int textBorderColor;
    private final int textFontColor;
    
    static {
        AdMarvelInterstitialAds.DEFAULT_WEB_VIEW_CSS = "<style>* {-webkit-tap-highlight-color: rgba(0,0,0,0.0);} body {background-color:transparent;margin:0px;padding:0px;}</style>";
        AdMarvelInterstitialAds.DEFAULT_IMAGE_WEB_VIEW_CSS = "<style>#u2nfwuKbaKzVwGmUNmk7wFVXHwzy7S{display:table;height:100%;width:100%;margin:0;padding:0;background-color:transparent;}#u2nfwuKbaKzVwGmUNmk7wFVXHwzy7S>div{display:table-cell;vertical-align:middle;text-align:center;}</style>";
        AdMarvelInterstitialAds.ORMMA_WEB_VIEW_CSS = "<style>* {-webkit-tap-highlight-color: rgba(0,0,0,0.0);} body {background-color:transparent;margin:0px;padding:0px;}</style><script type='text/javascript' src='http://admarvel.s3.amazonaws.com/js/admarvel_compete_v1.1.js'></script>";
        AdMarvelInterstitialAds.DEFAULT_WEB_VIEW_HTML_FORMAT = "<html><head>%s</head><body><div align=\"center\">%s</div></body></html>";
        AdMarvelInterstitialAds.DEFAULT_IMAGE_WEB_VIEW_HTML_FORMAT = "<html><head>%s</head><body id=\"u2nfwuKbaKzVwGmUNmk7wFVXHwzy7S\"><div>%s</div></body></html>";
        AdMarvelInterstitialAds.DEFAULT_WEB_VIEW_VIEWPORT = "<meta name=\"viewport\" content=\"initial-scale=1.0,maximum-scale=1.0,target-densitydpi=device-dpi, width=device-width\" />";
        AdMarvelInterstitialAds.IMAGE_AD_AUTOSCALED_WEB_VIEW_VIEWPORT = "<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0, maximum-scale=1.0\" />";
        listener = new e();
        AdMarvelInterstitialAds.enableClickRedirect = true;
        GUID = UUID.randomUUID().toString();
    }
    
    public AdMarvelInterstitialAds(final Context context, final int n, final int n2, final int textFontColor, final int textBorderColor) {
        this.enableAutoScaling = true;
        this.lockTimestamp = new AtomicLong(0L);
        this.contextReference = new WeakReference((T)context);
        this.internalAdMarvelInterstitialAdapterListener = new AdMarvelInterstitialAds$d(this);
        this.admarvelInterstitialAds = new HashMap();
        if (n == 0) {
            this.backgroundColor = 0;
        }
        else {
            this.backgroundColor = (0xFF000000 | n);
        }
        if (n2 == 0) {
            this.textBackgroundColor = 0;
        }
        else {
            this.textBackgroundColor = (0xFF000000 | n2);
        }
        this.textFontColor = textFontColor;
        this.textBorderColor = textBorderColor;
    }
    
    public static void disableNetworkActivity() {
        synchronized (AdMarvelInterstitialAds.class) {
            b.a();
        }
    }
    
    private void displayPendingAdMarvelAd(String string, final AdMarvelAd adMarvelAd) {
        final String s = this.admarvelInterstitialAds.get(string);
        if (s != null && s.length() > 0) {
            final Context context = (Context)this.contextReference.get();
            string = (String)string + "|custom";
            if (context != null) {
                if (AdMarvelInterstitialAds.enableOfflineSDK) {
                    new b().a(adMarvelAd, context, new Handler());
                }
                else if (!AdMarvelInterstitialAds.enableOfflineSDK) {
                    new r(context).a(adMarvelAd);
                }
                final String s2 = this.admarvelInterstitialAds.get(string);
                if (s2 != null && s2.equals("custom")) {
                    this.admarvelInterstitialAds.remove(string);
                    final Intent intent = new Intent(context, (Class)AdMarvelVideoActivity.class);
                    intent.addFlags(268435456);
                    intent.putExtra("html", s);
                    intent.putExtra("GUID", AdMarvelInterstitialAds.GUID);
                    context.startActivity(intent);
                }
                else {
                    string = new Intent(context, (Class)AdMarvelActivity.class);
                    ((Intent)string).addFlags(268435456);
                    ((Intent)string).putExtra("source", "campaign");
                    ((Intent)string).putExtra("html", s);
                    ((Intent)string).putExtra("xml", adMarvelAd.getXml());
                    ((Intent)string).putExtra("backgroundcolor", this.backgroundColor);
                    ((Intent)string).putExtra("isInterstitial", true);
                    ((Intent)string).putExtra("isInterstitialClick", false);
                    ((Intent)string).putExtra("GUID", AdMarvelInterstitialAds.GUID);
                    adMarvelAd.removeNonStringEntriesTargetParam();
                    while (true) {
                        try {
                            final ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                            final ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
                            objectOutputStream.writeObject(adMarvelAd);
                            objectOutputStream.close();
                            ((Intent)string).putExtra("serialized_admarvelad", byteArrayOutputStream.toByteArray());
                            context.startActivity((Intent)string);
                        }
                        catch (IOException ex) {
                            ex.printStackTrace();
                            continue;
                        }
                        break;
                    }
                }
            }
        }
    }
    
    public static void enableNetworkActivity(final Activity activity, final String s) {
        synchronized (AdMarvelInterstitialAds.class) {
            b.b(activity, s);
        }
    }
    
    public static boolean getEnableClickRedirect() {
        return AdMarvelInterstitialAds.enableClickRedirect;
    }
    
    public static e getListener() {
        return AdMarvelInterstitialAds.listener;
    }
    
    public static void initializeOfflineSDK(final Activity activity, final String s) {
        AdMarvelInterstitialAds.enableOfflineSDK = true;
        b.a(activity, s);
    }
    
    public static void setEnableClickRedirect(final boolean enableClickRedirect) {
        AdMarvelInterstitialAds.enableClickRedirect = enableClickRedirect;
    }
    
    public static void setListener(final AdMarvelInterstitialAds$AdMarvelInterstitialAdListener adMarvelInterstitialAds$AdMarvelInterstitialAdListener) {
        AdMarvelInterstitialAds.listener.a(adMarvelInterstitialAds$AdMarvelInterstitialAdListener);
    }
    
    protected void disableAdRequest(String format, final AdMarvelAd adMarvelAd, final Context context) {
        if (context == null) {
            return;
        }
        while (true) {
            while (true) {
                try {
                    final String versionName = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
                    final int versionCode = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
                    String s;
                    if (versionName != null) {
                        s = "duration" + versionName + versionCode + AdMarvelUtils.getSDKVersion();
                    }
                    else {
                        s = "duration" + versionCode + AdMarvelUtils.getSDKVersion();
                    }
                    if (s != null) {
                        final SharedPreferences$Editor edit = context.getSharedPreferences(r.d("admarvel"), 0).edit();
                        format = DateFormat.getDateTimeInstance().format(new Date(System.currentTimeMillis() + Integer.parseInt(format) * 1000));
                        edit.putString(r.d(s), format);
                        edit.commit();
                        Logging.log("requestNewAd: AD REQUEST BLOCKED, IGNORING REQUEST");
                        AdMarvelInterstitialAds.listener.a(context, null, null, 304, r.a(304), adMarvelAd.getSiteId(), adMarvelAd.getId(), adMarvelAd.getTargetParams(), adMarvelAd.getIpAddress());
                    }
                    return;
                }
                catch (PackageManager$NameNotFoundException ex) {
                    Logging.log(Log.getStackTraceString((Throwable)ex));
                    final String s = null;
                    continue;
                }
                continue;
            }
        }
    }
    
    public void displayInterstitial(final Activity activity, final AdMarvelUtils$SDKAdNetwork adMarvelUtils$SDKAdNetwork, final String s, final AdMarvelAd adMarvelAd) {
        final AdMarvelAdapter adMarvelAdapter = null;
        Label_0100: {
            if (adMarvelUtils$SDKAdNetwork != AdMarvelUtils$SDKAdNetwork.GOOGLEPLAY) {
                break Label_0100;
            }
        Block_6_Outer:
            while (true) {
                try {
                    AdMarvelAdapter adMarvelAdapter2 = AdMarvelAdapterInstances.getInstance("ADMARVELGUID", "com.admarvel.android.admarvelgoogleplayadapter.AdMarvelGooglePlayAdapter");
                    while (true) {
                        while (adMarvelAdapter2 == null) {
                            Label_0272: {
                                break Label_0272;
                                try {
                                    adMarvelAdapter2 = AdMarvelAdapterInstances.getInstance("ADMARVELGUID", "com.admarvel.android.admarvelrhythmadapter.AdMarvelRhythmAdapter");
                                    continue Block_6_Outer;
                                    Label_0121: {
                                        iftrue(Label_0142:)(adMarvelUtils$SDKAdNetwork != AdMarvelUtils$SDKAdNetwork.MILLENNIAL);
                                    }
                                    try {
                                        adMarvelAdapter2 = AdMarvelAdapterInstances.getInstance("ADMARVELGUID", "com.admarvel.android.admarvelmillennialadapter.AdMarvelMillennialAdapter");
                                        continue Block_6_Outer;
                                        Label_0142:
                                        iftrue(Label_0163:)(adMarvelUtils$SDKAdNetwork != AdMarvelUtils$SDKAdNetwork.AMAZON);
                                        try {
                                            adMarvelAdapter2 = AdMarvelAdapterInstances.getInstance("ADMARVELGUID", "com.admarvel.android.admarvelamazonadapter.AdMarvelAmazonAdapter");
                                            continue Block_6_Outer;
                                            try {
                                                adMarvelAdapter2 = AdMarvelAdapterInstances.getInstance("ADMARVELGUID", "com.admarvel.android.admarveladcolonyadapter.AdMarvelAdColonyAdapter");
                                                continue Block_6_Outer;
                                                try {
                                                    adMarvelAdapter2 = AdMarvelAdapterInstances.getInstance("ADMARVELGUID", "com.admarvel.android.admarvelpulse3dadapter.AdMarvelPulse3dAdapter");
                                                    continue Block_6_Outer;
                                                    Label_0205:
                                                    iftrue(Label_0226:)(adMarvelUtils$SDKAdNetwork != AdMarvelUtils$SDKAdNetwork.FACEBOOK);
                                                    try {
                                                        adMarvelAdapter2 = AdMarvelAdapterInstances.getInstance("ADMARVELGUID", "com.admarvel.android.admarvelfacebookadapter.AdMarvelFacebookAdapter");
                                                        continue Block_6_Outer;
                                                        try {
                                                            adMarvelAdapter2 = AdMarvelAdapterInstances.getInstance("ADMARVELGUID", "com.admarvel.android.admarvelinmobiadapter.AdMarvelInmobiAdapter");
                                                            continue Block_6_Outer;
                                                            try {
                                                                adMarvelAdapter2 = AdMarvelAdapterInstances.getInstance("ADMARVELGUID", "com.admarvel.android.admarvelheyzapadapter.AdMarvelHeyzapAdapter");
                                                                continue Block_6_Outer;
                                                                iftrue(Label_0099:)(adMarvelUtils$SDKAdNetwork != AdMarvelUtils$SDKAdNetwork.ADMARVEL);
                                                                this.displayPendingAdMarvelAd(s, adMarvelAd);
                                                                return;
                                                            }
                                                            catch (Exception ex) {
                                                                adMarvelAdapter2 = adMarvelAdapter;
                                                            }
                                                            Label_0247:
                                                            adMarvelAdapter2 = adMarvelAdapter;
                                                            iftrue(Label_0021:)(adMarvelUtils$SDKAdNetwork != AdMarvelUtils$SDKAdNetwork.HEYZAP);
                                                        }
                                                        catch (Exception ex2) {
                                                            adMarvelAdapter2 = adMarvelAdapter;
                                                        }
                                                        Label_0226:
                                                        iftrue(Label_0247:)(adMarvelUtils$SDKAdNetwork != AdMarvelUtils$SDKAdNetwork.INMOBI);
                                                    }
                                                    catch (Exception ex3) {
                                                        adMarvelAdapter2 = adMarvelAdapter;
                                                    }
                                                }
                                                catch (Exception ex4) {
                                                    adMarvelAdapter2 = adMarvelAdapter;
                                                }
                                                Label_0184:
                                                iftrue(Label_0205:)(adMarvelUtils$SDKAdNetwork != AdMarvelUtils$SDKAdNetwork.PULSE3D);
                                            }
                                            catch (Exception ex5) {
                                                adMarvelAdapter2 = adMarvelAdapter;
                                            }
                                            Label_0163:
                                            iftrue(Label_0184:)(adMarvelUtils$SDKAdNetwork != AdMarvelUtils$SDKAdNetwork.ADCOLONY);
                                        }
                                        catch (Exception ex6) {
                                            adMarvelAdapter2 = adMarvelAdapter;
                                        }
                                    }
                                    catch (Exception ex7) {
                                        adMarvelAdapter2 = adMarvelAdapter;
                                    }
                                }
                                catch (Exception ex8) {
                                    adMarvelAdapter2 = adMarvelAdapter;
                                }
                            }
                            Label_0099: {
                                return;
                            }
                        }
                        adMarvelAdapter2.displayInterstitial(activity, s);
                        new r((Context)activity).a(adMarvelAd);
                        if (this.contextReference != null && this.contextReference.get() != null) {
                            new Handler(Looper.getMainLooper()).postDelayed((Runnable)new AdMarvelInterstitialAds$c(adMarvelAd, (Context)this.contextReference.get()), 3000L);
                            return;
                        }
                        return;
                        iftrue(Label_0121:)(adMarvelUtils$SDKAdNetwork != AdMarvelUtils$SDKAdNetwork.RHYTHM);
                        continue;
                    }
                }
                catch (Exception ex9) {
                    final AdMarvelAdapter adMarvelAdapter2 = adMarvelAdapter;
                    continue;
                }
                break;
            }
        }
    }
    
    public int getAdMarvelBackgroundColor() {
        return this.backgroundColor;
    }
    
    public int getTextBackgroundColor() {
        return this.textBackgroundColor;
    }
    
    public int getTextBorderColor() {
        return this.textBorderColor;
    }
    
    public int getTextFontColor() {
        return this.textFontColor;
    }
    
    public boolean isAutoScalingEnabled() {
        return this.enableAutoScaling;
    }
    
    public void requestNewInterstitialAd(final Context context, final Map map, String trim, String trim2) {
        Map map2 = null;
        while (true) {
            if (map != null) {
                Label_0396: {
                    String s2;
                    try {
                        map2 = new HashMap(map);
                        this.contextReference = new WeakReference((T)context);
                        final SharedPreferences sharedPreferences = context.getSharedPreferences(r.d("admarvel"), 0);
                        final String versionName = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
                        final int versionCode = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
                        String s;
                        if (versionName != null) {
                            s = "duration" + versionName + versionCode + AdMarvelUtils.getSDKVersion();
                        }
                        else {
                            s = "duration" + versionCode + AdMarvelUtils.getSDKVersion();
                        }
                        if (s != null) {
                            final String string = sharedPreferences.getString(r.d(s), (String)null);
                            if (string != null && string.length() > 0 && DateFormat.getDateTimeInstance().parse(DateFormat.getDateTimeInstance().format(new Date(System.currentTimeMillis()))).before(DateFormat.getDateTimeInstance().parse(string))) {
                                Logging.log("requestNewAd: AD REQUEST BLOCKED, IGNORING REQUEST");
                                AdMarvelInterstitialAds.listener.a(context, null, null, 304, r.a(304), trim2, 0, map2, "");
                                return;
                            }
                        }
                        trim = trim.trim();
                        trim2 = trim2.trim();
                        if (System.currentTimeMillis() - this.lockTimestamp.getAndSet(System.currentTimeMillis()) <= 2000L) {
                            break Label_0396;
                        }
                        AdMarvelInterstitialAds.listener.a();
                        s2 = null;
                        if (map2 != null) {
                            s2 = map2.get("UNIQUE_ID");
                        }
                        if (Version.getAndroidSDKVersion() >= 11) {
                            com.admarvel.android.util.e.a().b().execute(new AdMarvelInterstitialAds$b(map2, trim, trim2, s2, r.d(context), r.a(context), this, 0, "", context));
                            return;
                        }
                    }
                    catch (Exception ex) {
                        Logging.log(Log.getStackTraceString((Throwable)ex));
                        return;
                    }
                    new Handler(Looper.getMainLooper()).post((Runnable)new AdMarvelInterstitialAds$a(map2, trim, trim2, s2, r.d(context), r.a(context), this, 0, "", context));
                    return;
                }
                Logging.log("requestNewAd: AD REQUEST PENDING, IGNORING REQUEST");
                AdMarvelInterstitialAds.listener.a(context, null, null, 304, r.a(304), trim2, 0, map2, "");
                return;
            }
            continue;
        }
    }
    
    public void requestNewInterstitialAd(final Context context, final Map map, final String s, final String s2, final Activity activity) {
        this.requestNewInterstitialAd(context, map, s, s2);
    }
    
    protected void requestPendingAdMarvelAd(final AdMarvelAd adMarvelAd, final Context context) {
        if (adMarvelAd == null) {
            if (AdMarvelInterstitialAds.listener != null) {
                AdMarvelInterstitialAds.listener.a(context, AdMarvelUtils$SDKAdNetwork.ADMARVEL, "", 304, r.a(304), "", 0, null, "");
            }
            return;
        }
        String s;
        if (adMarvelAd.getAdType() == AdMarvelAd$AdType.CUSTOM) {
            s = adMarvelAd.getXhtml();
        }
        else if (adMarvelAd.getAdType().equals(AdMarvelAd$AdType.IMAGE) && adMarvelAd.hasImage() && adMarvelAd.getImageWidth() > 0 && adMarvelAd.getImageHeight() > 0) {
            if (Version.getAndroidSDKVersion() >= 7) {
                int n;
                if (r.g(context) < r.h(context)) {
                    n = r.g(context);
                }
                else {
                    n = r.h(context);
                }
                final float n2 = n / r.i(context);
                Logging.log("Device Relative Screen Width :" + n2);
                s = String.format(AdMarvelInterstitialAds.DEFAULT_IMAGE_WEB_VIEW_HTML_FORMAT, AdMarvelInterstitialAds.DEFAULT_IMAGE_WEB_VIEW_CSS + AdMarvelInterstitialAds.IMAGE_AD_AUTOSCALED_WEB_VIEW_VIEWPORT, "<a href=\"" + adMarvelAd.getClickURL() + "\"><img src=\"" + adMarvelAd.getImageURL() + "\" width=\"" + n2 + "\"\" /></a>");
            }
            else if (context != null) {
                int n3;
                if (r.d(context) == 2) {
                    n3 = r.h(context);
                }
                else {
                    n3 = r.g(context);
                }
                int n4;
                if (r.d(context) == 1) {
                    n4 = r.h(context);
                }
                else {
                    n4 = r.g(context);
                }
                int imageWidth;
                int imageHeight;
                if (this.enableAutoScaling) {
                    final int n5 = (int)(adMarvelAd.getImageWidth() * r.a(context, n3, adMarvelAd.getImageWidth()));
                    final int n6 = (int)(r.a(context, n3, adMarvelAd.getImageWidth()) * adMarvelAd.getImageHeight());
                    imageWidth = n5;
                    imageHeight = n6;
                }
                else {
                    imageWidth = adMarvelAd.getImageWidth();
                    imageHeight = adMarvelAd.getImageHeight();
                }
                s = String.format(AdMarvelInterstitialAds.DEFAULT_WEB_VIEW_HTML_FORMAT, AdMarvelInterstitialAds.DEFAULT_WEB_VIEW_CSS + AdMarvelInterstitialAds.DEFAULT_WEB_VIEW_VIEWPORT, "<a href=\"" + adMarvelAd.getClickURL() + "\"><img src=\"" + adMarvelAd.getImageURL() + "\" width=\"" + imageWidth + "\" height=\"" + Math.min(imageHeight, n4) + "\" /></a>");
            }
            else {
                s = String.format(AdMarvelInterstitialAds.DEFAULT_WEB_VIEW_HTML_FORMAT, AdMarvelInterstitialAds.DEFAULT_WEB_VIEW_CSS + AdMarvelInterstitialAds.DEFAULT_WEB_VIEW_VIEWPORT, adMarvelAd.getXHTML());
            }
        }
        else if (adMarvelAd.getXhtml().contains("ORMMA_API")) {
            s = String.format(AdMarvelInterstitialAds.DEFAULT_WEB_VIEW_HTML_FORMAT, AdMarvelInterstitialAds.ORMMA_WEB_VIEW_CSS, adMarvelAd.getXHTML());
        }
        else {
            s = String.format(AdMarvelInterstitialAds.DEFAULT_WEB_VIEW_HTML_FORMAT, AdMarvelInterstitialAds.DEFAULT_WEB_VIEW_CSS, adMarvelAd.getXHTML() + r.a);
        }
        final String string = adMarvelAd.getPartnerId() + "|" + adMarvelAd.getSiteId();
        this.admarvelInterstitialAds.put(string, s);
        if (adMarvelAd.getAdType() == AdMarvelAd$AdType.CUSTOM) {
            this.admarvelInterstitialAds.put(string + "|custom", "custom");
        }
        AdMarvelInterstitialAds.listener.a(context, AdMarvelUtils$SDKAdNetwork.ADMARVEL, string, adMarvelAd, adMarvelAd.getSiteId(), adMarvelAd.getId(), adMarvelAd.getTargetParams(), adMarvelAd.getIpAddress());
    }
    
    void requestPendingAdapterAd(final Map map, final AdMarvelAd adMarvelAd, final String s, final Context context) {
        try {
            final AdMarvelAdapter instance = AdMarvelAdapterInstances.getInstance("ADMARVELGUID", s);
            if (this.internalAdMarvelInterstitialAdapterListener != null) {
                this.internalAdMarvelInterstitialAdapterListener.a(adMarvelAd);
            }
            instance.requestIntersitialNewAd(this.internalAdMarvelInterstitialAdapterListener, context, adMarvelAd, map, this.backgroundColor, this.textFontColor);
        }
        catch (Exception ex) {
            Logging.log(Log.getStackTraceString((Throwable)ex));
            AdMarvelInterstitialAds.listener.a(context, adMarvelAd.getSdkAdNetwork(), adMarvelAd.getPubId(), 304, r.a(304), adMarvelAd.getSiteId(), adMarvelAd.getId(), adMarvelAd.getTargetParams(), adMarvelAd.getIpAddress());
        }
    }
    
    public void setAdMarvelBackgroundColor(final int n) {
    }
    
    public void setEnableAutoScaling(final boolean enableAutoScaling) {
        this.enableAutoScaling = enableAutoScaling;
    }
    
    public void setOptionalFlags(final Map optionalFlags) {
        this.optionalFlags = optionalFlags;
    }
    
    public void setTextBackgroundColor(final int n) {
    }
}
