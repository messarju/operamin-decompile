// 
// Decompiled by Procyon v0.6-prerelease
// 

package com.admarvel.android.ads;

import android.webkit.WebView;
import android.view.KeyEvent;
import android.util.Log;
import android.view.ViewGroup$LayoutParams;
import android.os.Build;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ByteArrayInputStream;
import android.os.Bundle;
import android.content.SharedPreferences;
import android.webkit.URLUtil;
import android.view.View;
import android.content.Context;
import android.widget.RelativeLayout;
import android.os.Message;
import com.admarvel.android.util.Logging;
import java.lang.ref.WeakReference;
import android.os.Handler;
import android.annotation.SuppressLint;
import android.app.Activity;

@SuppressLint({ "NewApi", "HandlerLeak", "DefaultLocale", "SimpleDateFormat" })
public class AdMarvelActivity extends Activity
{
    static int b;
    private boolean A;
    private boolean B;
    private String C;
    private AdMarvelAd D;
    private AdMarvelActivity$t E;
    private String F;
    private boolean G;
    private boolean H;
    private boolean I;
    private String J;
    private Handler K;
    private Handler L;
    WeakReference a;
    boolean c;
    boolean d;
    Runnable e;
    Runnable f;
    final Handler g;
    String h;
    public boolean i;
    public boolean j;
    String k;
    String l;
    String m;
    String n;
    String o;
    String p;
    String q;
    public String r;
    public String s;
    boolean t;
    private AdMarvelActivity$b u;
    private int v;
    private String w;
    private String x;
    private String y;
    private int z;
    
    static {
        AdMarvelActivity.b = 103422;
    }
    
    public AdMarvelActivity() {
        this.c = false;
        this.d = false;
        this.v = 0;
        this.e = new Runnable() {
            @Override
            public void run() {
                try {
                    AdMarvelActivity.this.c = false;
                    AdMarvelActivity$e adMarvelActivity$e;
                    if (AdMarvelActivity.this.a != null) {
                        adMarvelActivity$e = (AdMarvelActivity$e)AdMarvelActivity.this.a.get();
                    }
                    else {
                        adMarvelActivity$e = null;
                    }
                    if (adMarvelActivity$e != null) {
                        adMarvelActivity$e.setCancelable(true);
                    }
                }
                catch (Exception ex) {
                    Logging.log("Exception in disable Back press button " + ex.getMessage());
                }
            }
        };
        this.f = new Runnable() {
            @Override
            public void run() {
                AdMarvelActivity.this.d = false;
            }
        };
        this.A = false;
        this.B = false;
        this.g = new Handler();
        this.i = false;
        this.j = false;
        this.t = false;
        this.G = false;
        this.H = false;
        this.I = false;
        this.K = new Handler() {
            public void handleMessage(final Message message) {
                while (true) {
                    while (true) {
                        Label_0231: {
                            try {
                                if (AdMarvelActivity.this.a == null) {
                                    break Label_0231;
                                }
                                final AdMarvelActivity$e adMarvelActivity$e = (AdMarvelActivity$e)AdMarvelActivity.this.a.get();
                                if (adMarvelActivity$e != null) {
                                    adMarvelActivity$e.a();
                                    adMarvelActivity$e.c();
                                }
                                if (!AdMarvelActivity.this.A) {
                                    AdMarvelActivity.this.finish();
                                    return;
                                }
                                AdMarvelActivity.this.v++;
                                if (!AdMarvelInterstitialAds.getListener().b()) {
                                    AdMarvelActivity.this.finish();
                                }
                                if (AdMarvelActivity.this.r != null && AdMarvelActivity.this.r.length() > 0) {
                                    final RelativeLayout relativeLayout = (RelativeLayout)AdMarvelActivity.this.findViewById(AdMarvelActivity.b);
                                    if (relativeLayout != null) {
                                        final d d = (d)relativeLayout.findViewWithTag((Object)(AdMarvelActivity.this.h + "WEBVIEW"));
                                        if (d != null) {
                                            d.loadUrl("javascript:" + AdMarvelActivity.this.r + "()");
                                        }
                                    }
                                }
                                if (AdMarvelActivity.this.v > 2) {
                                    AdMarvelActivity.this.finish();
                                    return;
                                }
                            }
                            catch (NullPointerException ex) {
                                Logging.log("Nullpointer exception occured in close" + ex.getMessage());
                            }
                            break;
                        }
                        final AdMarvelActivity$e adMarvelActivity$e = null;
                        continue;
                    }
                }
            }
        };
        this.L = new Handler() {
            public void handleMessage(final Message message) {
                final RelativeLayout relativeLayout = (RelativeLayout)AdMarvelActivity.this.findViewById(AdMarvelActivity.b);
                final d d = new d((Context)AdMarvelActivity.this, !AdMarvelActivity.this.A, AdMarvelActivity.this.C, AdMarvelActivity.this.h, null, null, AdMarvelActivity.this.D);
                d.setTag((Object)(AdMarvelActivity.this.h + "WEBVIEW"));
                d.l();
                d.j();
                d.addJavascriptInterface((Object)new AdMarvelWebViewJSInterface(d, AdMarvelActivity.this.D, AdMarvelActivity.this), "ADMARVEL");
                d.addJavascriptInterface((Object)new AdMarvelActivity$c(d, AdMarvelActivity.this), "AndroidBridge");
                relativeLayout.addView((View)d);
                if (!AdMarvelActivity.this.A && !AdMarvelActivity.this.G) {
                    final o o = new o(AdMarvelActivity.this, AdMarvelActivity.this.getApplicationContext(), AdMarvelActivity.this.h);
                    o.setTag((Object)(AdMarvelActivity.this.h + "CONTROLS"));
                    relativeLayout.addView((View)o);
                }
                if (AdMarvelActivity.this.A) {
                    com.admarvel.android.ads.d.a(AdMarvelActivity.this.h, AdMarvelActivity.this.u);
                }
                if (AdMarvelActivity.this.w != null && AdMarvelActivity.this.w.length() > 0) {
                    d.loadUrl(AdMarvelActivity.this.w);
                }
                else if (AdMarvelActivity.this.e() && AdMarvelActivity.this.F != null && AdMarvelActivity.this.F.length() > 0) {
                    if (AdMarvelInterstitialAds.enableOfflineSDK) {
                        if (URLUtil.isNetworkUrl(AdMarvelActivity.this.F) && com.admarvel.android.ads.r.f((Context)AdMarvelActivity.this)) {
                            d.loadUrl(AdMarvelActivity.this.F);
                        }
                        if (!URLUtil.isNetworkUrl(AdMarvelActivity.this.F)) {
                            final SharedPreferences sharedPreferences = AdMarvelActivity.this.getSharedPreferences("admarvel_preferences", 0);
                            final String string = sharedPreferences.getString("childDirectory", "NULL") + "/" + sharedPreferences.getString("banner_folder", "NULL");
                            if (string != null) {
                                AdMarvelActivity.this.y = com.admarvel.android.util.a.b.a(string, AdMarvelActivity.this.F);
                                Logging.log("Offline SDK:Admarvel XML Response:" + AdMarvelActivity.this.C);
                            }
                            d.loadDataWithBaseURL(AdMarvelActivity.this.D.getOfflineBaseUrl() + "/", AdMarvelActivity.this.y, "text/html", "utf-8", (String)null);
                        }
                    }
                    else {
                        d.loadUrl(AdMarvelActivity.this.F);
                    }
                    if (!AdMarvelActivity.this.H) {
                        d.a(AdMarvelActivity.this.I);
                    }
                    if (AdMarvelActivity.this.J != null && AdMarvelActivity.this.J.length() > 0) {
                        AdMarvelActivity.this.a(AdMarvelActivity.this.J);
                    }
                }
                else {
                    d.setBackgroundColor(AdMarvelActivity.this.z);
                    final String string2 = "content://" + AdMarvelActivity.this.getPackageName() + ".AdMarvelLocalFileContentProvider";
                    if (AdMarvelInterstitialAds.enableOfflineSDK) {
                        d.loadDataWithBaseURL(AdMarvelActivity.this.D.getOfflineBaseUrl() + "/", AdMarvelActivity.this.y, "text/html", "utf-8", (String)null);
                        return;
                    }
                    if (Version.getAndroidSDKVersion() < 11) {
                        d.loadDataWithBaseURL(string2, AdMarvelActivity.this.y, "text/html", "utf-8", (String)null);
                        return;
                    }
                    d.loadDataWithBaseURL("http://baseurl.admarvel.com", AdMarvelActivity.this.y, "text/html", "utf-8", (String)null);
                }
            }
        };
    }
    
    public int a() {
        return this.v;
    }
    
    void a(final String s) {
        Logging.log("DisableActivityOrientation");
        int orientation;
        if (Version.getAndroidSDKVersion() < 9) {
            orientation = this.getResources().getConfiguration().orientation;
        }
        else {
            final AdMarvelActivity$k adMarvelActivity$k = new AdMarvelActivity$k(this);
            adMarvelActivity$k.run();
            int a = Integer.MIN_VALUE;
            while (true) {
                orientation = a;
                if (a != Integer.MIN_VALUE) {
                    break;
                }
                a = adMarvelActivity$k.a();
            }
        }
        if (s != null) {
            if (Version.getAndroidSDKVersion() < 9) {
                if (s.equalsIgnoreCase("Portrait")) {
                    this.setRequestedOrientation(1);
                }
                else {
                    if (s.equalsIgnoreCase("LandscapeLeft")) {
                        this.setRequestedOrientation(0);
                        return;
                    }
                    if (s.equalsIgnoreCase("Current")) {
                        if (orientation == 1) {
                            this.setRequestedOrientation(1);
                            return;
                        }
                        if (orientation == 2) {
                            this.setRequestedOrientation(0);
                        }
                    }
                }
            }
            else {
                if (s.equalsIgnoreCase("Portrait")) {
                    this.setRequestedOrientation(1);
                    return;
                }
                if (s.equalsIgnoreCase("LandscapeLeft")) {
                    this.setRequestedOrientation(0);
                    return;
                }
                if (!s.equalsIgnoreCase("Current")) {
                    this.g.post((Runnable)new AdMarvelActivity$r(this, s));
                    return;
                }
                if (orientation == 0) {
                    this.g.post((Runnable)new AdMarvelActivity$r(this, "Portrait"));
                    return;
                }
                if (orientation == 1) {
                    this.g.post((Runnable)new AdMarvelActivity$r(this, "LandscapeLeft"));
                    return;
                }
                this.g.post((Runnable)new AdMarvelActivity$r(this, "none"));
            }
        }
    }
    
    public void b() {
        ++this.v;
    }
    
    boolean c() {
        return this.A;
    }
    
    boolean d() {
        return this.B;
    }
    
    boolean e() {
        return this.G;
    }
    
    String f() {
        return this.x;
    }
    
    void g() {
        this.K.sendEmptyMessage(0);
    }
    
    public void h() {
        this.g.postDelayed((Runnable)new AdMarvelActivity$f(this.D, (Context)this), 1000L);
    }
    
    public void i() {
        this.g.postDelayed((Runnable)new AdMarvelActivity$g(this.D, (Context)this), 3000L);
    }
    
    protected void onCreate(Bundle extras) {
        super.onCreate((Bundle)extras);
        if (AdMarvelUtils.getAdmarvelActivityOrientationInfo((Context)this) != null) {
            this.setRequestedOrientation((int)AdMarvelUtils.getAdmarvelActivityOrientationInfo((Context)this));
        }
        if (Version.getAndroidSDKVersion() >= 11) {
            AdMarvelActivity$l.a(this);
        }
        extras = this.getIntent().getExtras();
        Label_0240: {
            if (extras == null) {
                break Label_0240;
            }
            this.w = ((Bundle)extras).getString("url");
            this.x = ((Bundle)extras).getString("source");
            this.y = ((Bundle)extras).getString("html");
            this.C = ((Bundle)extras).getString("xml");
            this.A = ((Bundle)extras).getBoolean("isInterstitial", false);
            this.B = ((Bundle)extras).getBoolean("isInterstitialClick", false);
            this.h = ((Bundle)extras).getString("GUID");
            final byte[] byteArray = ((Bundle)extras).getByteArray("serialized_admarvelad");
        Label_0163:
            while (true) {
                if (byteArray == null) {
                    break Label_0163;
                }
            Label_0400_Outer:
                while (true) {
                    while (true) {
                    Label_0474:
                        while (true) {
                            try {
                                this.D = (AdMarvelAd)new ObjectInputStream(new ByteArrayInputStream(byteArray)).readObject();
                                this.z = ((Bundle)extras).getInt("backgroundcolor");
                                this.F = ((Bundle)extras).getString("expand_url");
                                if (this.F != null && this.F.length() > 0) {
                                    this.G = true;
                                    this.H = ((Bundle)extras).getBoolean("closeBtnEnabled");
                                    this.I = ((Bundle)extras).getBoolean("closeAreaEnabled");
                                    this.J = ((Bundle)extras).getString("orientationState");
                                }
                                if (AdMarvelUtils.isNotificationBarInFullScreenLaunchEnabled() || (!this.A && (Build.MODEL.contains("Kindle") || Build.PRODUCT.contains("Kindle")))) {
                                    this.getWindow().addFlags(256);
                                    this.getWindow().clearFlags(1024);
                                    this.u = new AdMarvelActivity$b(this);
                                    extras = new RelativeLayout((Context)this);
                                    ((RelativeLayout)extras).setId(AdMarvelActivity.b);
                                    ((RelativeLayout)extras).setLayoutParams(new ViewGroup$LayoutParams(-1, -1));
                                    ((RelativeLayout)extras).setBackgroundColor(-16777216);
                                    this.setContentView((View)extras);
                                    if (this.A && this instanceof AdMarvelActivity) {
                                        AdMarvelInterstitialAds.getListener().a(this);
                                    }
                                    if (Version.getAndroidSDKVersion() >= 11) {
                                        this.g.post((Runnable)new AdMarvelActivity$h(this, this.D));
                                        if (this.A) {
                                            extras = new AdMarvelActivity$e(this, (Context)this);
                                            ((AdMarvelActivity$e)extras).setTag((Object)"ADM_DIALOG");
                                            this.addContentView((View)extras, ((AdMarvelActivity$e)extras).getLayoutParams());
                                            this.a = new WeakReference((T)extras);
                                        }
                                        return;
                                    }
                                    break Label_0474;
                                }
                            }
                            catch (Exception ex) {
                                Logging.log(Log.getStackTraceString((Throwable)ex));
                                continue Label_0163;
                            }
                            this.getWindow().setFlags(512, 512);
                            continue Label_0400_Outer;
                        }
                        new AdMarvelActivity$a(this, this.D).execute(new Object[0]);
                        continue;
                    }
                }
                break;
            }
        }
    }
    
    protected void onDestroy() {
        AdMarvelActivity$e adMarvelActivity$e;
        if (this.a != null) {
            adMarvelActivity$e = (AdMarvelActivity$e)this.a.get();
        }
        else {
            adMarvelActivity$e = null;
        }
        if (adMarvelActivity$e != null) {
            adMarvelActivity$e.a();
            adMarvelActivity$e.c();
            adMarvelActivity$e.b();
            this.a.clear();
        }
        final com.admarvel.android.util.d a = com.admarvel.android.util.d.a();
        if (a.b()) {
            a.c();
        }
        this.g.post((Runnable)new AdMarvelActivity$d(this));
        final RelativeLayout relativeLayout = (RelativeLayout)this.findViewById(AdMarvelActivity.b);
        if (this.e() && com.admarvel.android.ads.d.c(this.h) != null) {
            com.admarvel.android.ads.d.c(this.h).a();
        }
        if (relativeLayout != null) {
            final d d = (d)relativeLayout.findViewWithTag((Object)(this.h + "WEBVIEW"));
            if (d != null && d.j != null && d.j.length() > 0 && d.k) {
                d.e(d.j + "(false)");
                d.k = false;
            }
        }
        if (relativeLayout != null) {
            final d d2 = (d)relativeLayout.findViewWithTag((Object)(this.h + "WEBVIEW"));
            if (d2 != null) {
                relativeLayout.removeView((View)d2);
                d2.loadUrl("");
                d2.a();
            }
        }
        if (this.A) {
            com.admarvel.android.ads.d.b(this.h);
        }
        if (!AdMarvelUtils.isLogDumpEnabled()) {
            com.admarvel.android.ads.r.m((Context)this);
        }
        super.onDestroy();
    }
    
    public boolean onKeyDown(final int n, final KeyEvent keyEvent) {
        if (keyEvent.getAction() == 0) {
            switch (n) {
                case 4: {
                    if (this.c || this.d) {
                        return false;
                    }
                    this.g();
                    if (!this.c() && com.admarvel.android.ads.d.d(this.h) != null) {
                        com.admarvel.android.ads.d.d(this.h).a(this.h);
                    }
                    return true;
                }
            }
        }
        return super.onKeyDown(n, keyEvent);
    }
    
    protected void onPause() {
        final RelativeLayout relativeLayout = (RelativeLayout)this.findViewById(AdMarvelActivity.b);
        if (relativeLayout != null) {
            final d d = (d)relativeLayout.findViewWithTag((Object)(this.h + "WEBVIEW"));
            if (d != null) {
                d.f();
            }
        }
        if (!this.isFinishing() && this.s != null && this.s.length() > 0) {
            final RelativeLayout relativeLayout2 = (RelativeLayout)this.findViewById(AdMarvelActivity.b);
            if (relativeLayout2 != null) {
                final d d2 = (d)relativeLayout2.findViewWithTag((Object)(this.h + "WEBVIEW"));
                if (d2 != null) {
                    d2.loadUrl("javascript:" + this.s + "()");
                }
            }
        }
        while (true) {
            if (!this.c()) {
                break Label_0175;
            }
            try {
                AdMarvelAnalyticsAdapterInstances.getInstance("com.admarvel.android.admarvelmologiqadapter.AdMarvelMologiqAdapter", (Context)this).pause();
                super.onPause();
            }
            catch (Exception ex) {
                continue;
            }
            break;
        }
    }
    
    protected void onResume() {
        super.onResume();
        final RelativeLayout relativeLayout = (RelativeLayout)this.findViewById(AdMarvelActivity.b);
        Label_0088: {
            while (true) {
                Label_0070: {
                    if (relativeLayout == null) {
                        break Label_0070;
                    }
                    final d d = (d)relativeLayout.findViewWithTag((Object)(this.h + "WEBVIEW"));
                    if (d == null) {
                        break Label_0070;
                    }
                    if (Version.getAndroidSDKVersion() < 11) {
                        break Label_0088;
                    }
                    aa.a(d);
                    d.g();
                }
                if (!this.c()) {
                    return;
                }
                try {
                    AdMarvelAnalyticsAdapterInstances.getInstance("com.admarvel.android.admarvelmologiqadapter.AdMarvelMologiqAdapter", (Context)this).resume();
                    return;
                    final d d;
                    ab.a(d);
                    continue;
                }
                catch (Exception ex) {}
                break;
            }
        }
    }
    
    protected void onStart() {
        while (true) {
            if (!this.c()) {
                break Label_0017;
            }
            try {
                AdMarvelAnalyticsAdapterInstances.getInstance("com.admarvel.android.admarvelmologiqadapter.AdMarvelMologiqAdapter", (Context)this).start();
                super.onStart();
            }
            catch (Exception ex) {
                continue;
            }
            break;
        }
    }
    
    protected void onStop() {
        if (Version.getAndroidSDKVersion() >= 7) {
            this.g.post((Runnable)new AdMarvelActivity$i(this, null));
        }
        while (true) {
            if (!this.c()) {
                break Label_0042;
            }
            try {
                AdMarvelAnalyticsAdapterInstances.getInstance("com.admarvel.android.admarvelmologiqadapter.AdMarvelMologiqAdapter", (Context)this).stop();
                super.onStop();
            }
            catch (Exception ex) {
                continue;
            }
            break;
        }
    }
}
