// 
// Decompiled by Procyon v0.6-prerelease
// 

package com.admarvel.android.ads;

import android.content.SharedPreferences$Editor;
import android.content.SharedPreferences;
import com.admarvel.android.util.c;
import com.admarvel.android.util.d;
import java.util.HashMap;
import android.os.Handler;
import android.os.Looper;
import com.admarvel.android.util.e;
import android.widget.RelativeLayout$LayoutParams;
import android.widget.FrameLayout$LayoutParams;
import java.util.Map;
import android.content.pm.PackageManager$NameNotFoundException;
import android.util.Log;
import java.util.Date;
import java.text.DateFormat;
import android.view.ViewGroup$LayoutParams;
import android.widget.LinearLayout$LayoutParams;
import android.app.Activity;
import android.view.animation.AlphaAnimation;
import com.admarvel.android.util.a.b;
import android.widget.FrameLayout;
import android.view.animation.Animation;
import android.view.animation.Animation$AnimationListener;
import android.view.animation.Interpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.View;
import com.admarvel.android.util.Logging;
import java.util.UUID;
import android.util.AttributeSet;
import android.content.Context;
import java.util.concurrent.atomic.AtomicLong;
import java.lang.ref.WeakReference;
import android.widget.LinearLayout;

public class AdMarvelView extends LinearLayout
{
    public static boolean a;
    protected static boolean c;
    private static boolean n;
    private static WeakReference u;
    final String b;
    private int d;
    private int e;
    private int f;
    private int g;
    private final l h;
    private boolean i;
    private boolean j;
    private final AtomicLong k;
    private boolean l;
    private int m;
    private boolean o;
    private final AdMarvelView$h p;
    private final AdMarvelView$i q;
    private boolean r;
    private boolean s;
    private boolean t;
    private AdMarvelAd v;
    private boolean w;
    private boolean x;
    
    static {
        AdMarvelView.n = true;
        AdMarvelView.c = true;
    }
    
    public AdMarvelView(final Context context) {
        this(context, null);
    }
    
    public AdMarvelView(final Context context, final AttributeSet set) {
        super(context, set);
        this.i = false;
        this.l = true;
        this.m = -1;
        this.o = false;
        this.r = true;
        this.s = false;
        this.t = false;
        this.w = false;
        this.x = false;
        this.h = new l();
        this.r = true;
        AdMarvelAdapterInstances.buildAdMarvelAdapterInstances(this.b = UUID.randomUUID().toString());
        Logging.log(Version.getVersionDump());
        this.setFocusable(true);
        this.setDescendantFocusability(262144);
        this.setClickable(true);
        final String string = "http://schemas.android.com/apk/res/" + context.getPackageName();
        if (set != null) {
            if (set.getAttributeValue(string, "backgroundColor") != null) {
                if ("0".equals(set.getAttributeValue(string, "backgroundColor"))) {
                    this.d = 0;
                }
                else {
                    this.d = Integer.parseInt(set.getAttributeValue(string, "backgroundColor").replace("#", ""), 16);
                }
            }
            if (set.getAttributeValue(string, "textBackgroundColor") != null) {
                this.e = Integer.parseInt(set.getAttributeValue(string, "textBackgroundColor").replace("#", ""), 16);
            }
            if (set.getAttributeValue(string, "textFontColor") != null) {
                this.f = Integer.parseInt(set.getAttributeValue(string, "textFontColor").replace("#", ""), 16);
            }
            if (set.getAttributeValue(string, "textBorderColor") != null) {
                this.g = Integer.parseInt(set.getAttributeValue(string, "textBorderColor").replace("#", ""), 16);
            }
            if (set.getAttributeValue(string, "disableAnimation") != null) {
                this.j = Boolean.parseBoolean(set.getAttributeValue(string, "disableAnimation"));
            }
            if (set.getAttributeValue(string, "enableClickRedirect") != null) {
                this.l = Boolean.parseBoolean(set.getAttributeValue(string, "enableClickRedirect"));
            }
            this.setAdMarvelBackgroundColor(this.d);
        }
        this.k = new AtomicLong(0L);
        this.p = new AdMarvelView$h(this);
        this.q = new AdMarvelView$i(this);
    }
    
    private void a(final View view) {
        if (view != null && view instanceof m) {
            final m m = (m)view;
            m.e();
            m.d();
        }
    }
    
    private void a(final View view, final AdMarvelAd adMarvelAd) {
        if (this.j) {
            return;
        }
        this.setVisibility(8);
        this.setVisibility(0);
        final com.admarvel.android.util.m m = new com.admarvel.android.util.m(0.0f, -90.0f, this.getWidth() / 2.0f, this.getHeight() / 2.0f, -0.3f * this.getWidth(), true);
        m.setDuration(700L);
        m.setFillAfter(true);
        m.setInterpolator((Interpolator)new AccelerateInterpolator());
        m.setAnimationListener((Animation$AnimationListener)new Animation$AnimationListener() {
            public void onAnimationEnd(final Animation animation) {
                AdMarvelView.this.post((Runnable)new AdMarvelView$k(view, AdMarvelView.this, adMarvelAd));
            }
            
            public void onAnimationRepeat(final Animation animation) {
            }
            
            public void onAnimationStart(final Animation animation) {
            }
        });
        this.startAnimation((Animation)m);
    }
    
    public static boolean a() {
        return AdMarvelView.n;
    }
    
    private void b(final View view) {
        View child = null;
        if (view instanceof FrameLayout) {
            child = ((FrameLayout)view).getChildAt(0);
        }
        while (true) {
            try {
                AdMarvelAdapterInstances.getInstance(this.b, "com.admarvel.android.admarvelgoogleplayadapter.AdMarvelGooglePlayAdapter").cleanupView(child);
                try {
                    AdMarvelAdapterInstances.getInstance(this.b, "com.admarvel.android.admarvelrhythmadapter.AdMarvelRhythmAdapter").cleanupView(child);
                    try {
                        AdMarvelAdapterInstances.getInstance(this.b, "com.admarvel.android.admarvelmillennialadapter.AdMarvelMillennialAdapter").cleanupView(child);
                        try {
                            AdMarvelAdapterInstances.getInstance(this.b, "com.admarvel.android.admarvelamazonadapter.AdMarvelAmazonAdapter").cleanupView(child);
                            try {
                                AdMarvelAdapterInstances.getInstance(this.b, "com.admarvel.android.admarveladcolonyadapter.AdMarvelAdColonyAdapter").cleanupView(child);
                                try {
                                    AdMarvelAdapterInstances.getInstance(this.b, "com.admarvel.android.admarvelpulse3dadapter.AdMarvelPulse3dAdapter").cleanupView(child);
                                    try {
                                        AdMarvelAdapterInstances.getInstance(this.b, "com.admarvel.android.admarvelfacebookadapter.AdMarvelFacebookAdapter").cleanupView(child);
                                        try {
                                            AdMarvelAdapterInstances.getInstance(this.b, "com.admarvel.android.admarvelinmobiadapter.AdMarvelInmobiAdapter").cleanupView(child);
                                            try {
                                                AdMarvelAdapterInstances.getInstance(this.b, "com.admarvel.android.admarvelheyzapadapter.AdMarvelHeyzapAdapter").cleanupView(child);
                                            }
                                            catch (Exception ex) {}
                                        }
                                        catch (Exception ex2) {}
                                    }
                                    catch (Exception ex3) {}
                                }
                                catch (Exception ex4) {}
                            }
                            catch (Exception ex5) {}
                        }
                        catch (Exception ex6) {}
                    }
                    catch (Exception ex7) {}
                }
                catch (Exception ex8) {}
            }
            catch (Exception ex9) {
                continue;
            }
            break;
        }
    }
    
    public static void disableNetworkActivity() {
        synchronized (AdMarvelView.class) {
            b.a();
        }
    }
    
    private void e() {
        if (this.j) {
            return;
        }
        final AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        alphaAnimation.setDuration(233L);
        alphaAnimation.startNow();
        alphaAnimation.setFillAfter(true);
        alphaAnimation.setInterpolator((Interpolator)new AccelerateInterpolator());
        this.startAnimation((Animation)alphaAnimation);
    }
    
    public static void enableNetworkActivity(final Activity activity, final String s) {
        synchronized (AdMarvelView.class) {
            b.b(activity, s);
        }
    }
    
    private void h(AdMarvelView child) {
        final View viewWithTag = ((AdMarvelView)child).findViewWithTag((Object)"CURRENT");
        if (viewWithTag == null) {
            return;
        }
        while (true) {
            Label_0196: {
                if (!(viewWithTag instanceof FrameLayout)) {
                    break Label_0196;
                }
                child = (Exception)((FrameLayout)viewWithTag).getChildAt(0);
                Logging.log("destroyAdapterView");
                while (true) {
                    try {
                        AdMarvelAdapterInstances.getInstance(this.b, "com.admarvel.android.admarvelgoogleplayadapter.AdMarvelGooglePlayAdapter").destroy((View)child);
                        try {
                            AdMarvelAdapterInstances.getInstance(this.b, "com.admarvel.android.admarvelrhythmadapter.AdMarvelRhythmAdapter").destroy((View)child);
                            try {
                                AdMarvelAdapterInstances.getInstance(this.b, "com.admarvel.android.admarvelmillennialadapter.AdMarvelMillennialAdapter").destroy((View)child);
                                try {
                                    AdMarvelAdapterInstances.getInstance(this.b, "com.admarvel.android.admarvelamazonadapter.AdMarvelAmazonAdapter").destroy((View)child);
                                    try {
                                        AdMarvelAdapterInstances.getInstance(this.b, "com.admarvel.android.admarveladcolonyadapter.AdMarvelAdColonyAdapter").destroy((View)child);
                                        try {
                                            AdMarvelAdapterInstances.getInstance(this.b, "com.admarvel.android.admarvelpulse3dadapter.AdMarvelPulse3dAdapter").destroy((View)child);
                                            try {
                                                AdMarvelAdapterInstances.getInstance(this.b, "com.admarvel.android.admarvelfacebookadapter.AdMarvelFacebookAdapter").destroy((View)child);
                                                try {
                                                    AdMarvelAdapterInstances.getInstance(this.b, "com.admarvel.android.admarvelinmobiadapter.AdMarvelInmobiAdapter").destroy((View)child);
                                                    try {
                                                        AdMarvelAdapterInstances.getInstance(this.b, "com.admarvel.android.admarvelheyzapadapter.AdMarvelHeyzapAdapter").destroy((View)child);
                                                        return;
                                                    }
                                                    catch (Exception child) {
                                                        return;
                                                    }
                                                }
                                                catch (Exception ex) {}
                                            }
                                            catch (Exception ex2) {}
                                        }
                                        catch (Exception ex3) {}
                                    }
                                    catch (Exception ex4) {}
                                }
                                catch (Exception ex5) {}
                            }
                            catch (Exception ex6) {}
                        }
                        catch (Exception ex7) {}
                    }
                    catch (Exception ex8) {
                        continue;
                    }
                    break;
                }
            }
            child = null;
            continue;
        }
    }
    
    public static void initializeOfflineSDK(final Activity activity, final String s) {
        AdMarvelView.a = true;
        b.a(activity, s);
    }
    
    public static void setEnableHardwareAcceleration(final boolean n) {
        AdMarvelView.n = n;
    }
    
    protected void a(final AdMarvelAd v) {
        if (v != null) {
            this.v = v;
            int n;
            if (this.getAdContainerWidth() > 0) {
                n = this.getAdContainerWidth();
            }
            else if (this.getWidth() > 0) {
                n = this.getWidth();
            }
            else if (com.admarvel.android.ads.r.g(this.getContext()) < com.admarvel.android.ads.r.h(this.getContext())) {
                n = com.admarvel.android.ads.r.g(this.getContext());
            }
            else {
                n = com.admarvel.android.ads.r.h(this.getContext());
            }
            v.setAdMarvelViewWidth(n / com.admarvel.android.ads.r.i(this.getContext()));
        }
        boolean b = false;
        final View viewWithTag = this.findViewWithTag((Object)"CURRENT");
        if (viewWithTag != null) {
            final boolean b2 = b = true;
            if (viewWithTag instanceof m) {
                ((m)viewWithTag).e();
                b = b2;
            }
        }
        m m;
        if (AdMarvelView.u != null && AdMarvelView.u.get() != null) {
            m = new m((Context)AdMarvelView.u.get(), this.r, this.s, v.getXml(), v, this.w, this.x, b);
        }
        else {
            m = new m(this.getContext(), this.r, this.s, v.getXml(), v, this.w, this.x, b);
        }
        m.setLayoutParams((ViewGroup$LayoutParams)new LinearLayout$LayoutParams(-2, -2));
        m.setBackgroundColor(this.d);
        m.setEnableClickRedirect(this.l);
        com.admarvel.android.ads.m.a(m.s, this.q);
        m.setTag((Object)"PENDING");
        if (b) {
            m.setVisibility(8);
        }
        m.a(this.getTextFontColor(), this.getTextBorderColor(), this.getTextBackgroundColor(), this.getAdMarvelBackgroundColor(), this);
        while (true) {
            final View viewWithTag2 = this.findViewWithTag((Object)"PENDING");
            if (viewWithTag2 == null) {
                break;
            }
            this.removeView(viewWithTag2);
        }
        this.addView((View)m);
    }
    
    protected void a(String format, final AdMarvelAd adMarvelAd, Context edit) {
        if (edit == null) {
            return;
        }
        while (true) {
            while (true) {
                try {
                    final String versionName = edit.getPackageManager().getPackageInfo(edit.getPackageName(), 0).versionName;
                    final int versionCode = edit.getPackageManager().getPackageInfo(edit.getPackageName(), 0).versionCode;
                    String s;
                    if (versionName != null) {
                        s = "duration" + versionName + versionCode + AdMarvelUtils.getSDKVersion();
                    }
                    else {
                        s = "duration" + versionCode + AdMarvelUtils.getSDKVersion();
                    }
                    if (s != null) {
                        edit = (Context)edit.getSharedPreferences(com.admarvel.android.ads.r.d("admarvel"), 0).edit();
                        format = DateFormat.getDateTimeInstance().format(new Date(System.currentTimeMillis() + Integer.parseInt(format) * 1000));
                        ((SharedPreferences$Editor)edit).putString(com.admarvel.android.ads.r.d(s), format);
                        ((SharedPreferences$Editor)edit).commit();
                        Logging.log("requestNewAd: AD REQUEST BLOCKED, IGNORING REQUEST");
                        this.h.a(this.getContext(), this, 304, com.admarvel.android.ads.r.a(304), adMarvelAd.getSiteId(), adMarvelAd.getId(), adMarvelAd.getTargetParams(), adMarvelAd.getIpAddress());
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
    
    protected void a(final Map map, final AdMarvelAd v, final String s, final Context context) {
        while (true) {
            if (v != null) {
            Label_0092_Outer:
                while (true) {
                    while (true) {
                        View view = null;
                        Label_0449: {
                            AdMarvelAdapter instance = null;
                        Label_0215:
                            while (true) {
                                Label_0158: {
                                    try {
                                        this.v = v;
                                        if (this.getAdContainerWidth() <= 0) {
                                            break Label_0158;
                                        }
                                        final int n = this.getAdContainerWidth();
                                        v.setAdMarvelViewWidth(n / com.admarvel.android.ads.r.i(this.getContext()));
                                        instance = AdMarvelAdapterInstances.getInstance(this.b, s);
                                        if (AdMarvelView.u != null && AdMarvelView.u.get() != null) {
                                            view = instance.requestNewAd(this.p, (Context)AdMarvelView.u.get(), v, map, this.d, this.f);
                                            break Label_0449;
                                        }
                                        break Label_0215;
                                        while (true) {
                                            final View viewWithTag;
                                            this.removeView(viewWithTag);
                                            viewWithTag = this.findViewWithTag((Object)"PENDING");
                                            iftrue(Label_0239:)(viewWithTag == null);
                                            continue Label_0092_Outer;
                                        }
                                    }
                                    catch (Exception ex) {
                                        Logging.log(Log.getStackTraceString((Throwable)ex));
                                        this.h.a(this.getContext(), this, 304, com.admarvel.android.ads.r.a(304), v.getSiteId(), v.getId(), v.getTargetParams(), v.getIpAddress());
                                    }
                                    break;
                                }
                                if (this.getWidth() > 0) {
                                    final int n = this.getWidth();
                                    continue Label_0092_Outer;
                                }
                                if (com.admarvel.android.ads.r.g(this.getContext()) < com.admarvel.android.ads.r.h(this.getContext())) {
                                    final int n = com.admarvel.android.ads.r.g(this.getContext());
                                    continue Label_0092_Outer;
                                }
                                final int n = com.admarvel.android.ads.r.h(this.getContext());
                                continue Label_0092_Outer;
                            }
                            view = instance.requestNewAd(this.p, context, v, map, this.d, this.f);
                        }
                        if (view != null) {
                            continue;
                        }
                        break;
                    }
                    break;
                }
                return;
                final ViewGroup$LayoutParams layoutParams;
                Label_0239: {
                    layoutParams = this.getLayoutParams();
                }
                if (layoutParams.width < 0) {
                    layoutParams.width = -1;
                    this.setLayoutParams(layoutParams);
                }
                this.setGravity(1);
                final FrameLayout frameLayout = new FrameLayout(context);
                frameLayout.setLayoutParams((ViewGroup$LayoutParams)new FrameLayout$LayoutParams(-2, -2, 1));
                View view = null;
                if (view.getLayoutParams() instanceof LinearLayout$LayoutParams) {
                    final LinearLayout$LayoutParams linearLayout$LayoutParams = (LinearLayout$LayoutParams)view.getLayoutParams();
                    linearLayout$LayoutParams.gravity = 1;
                    frameLayout.addView(view, (ViewGroup$LayoutParams)linearLayout$LayoutParams);
                }
                else if (view.getLayoutParams() instanceof FrameLayout$LayoutParams) {
                    final FrameLayout$LayoutParams frameLayout$LayoutParams = (FrameLayout$LayoutParams)view.getLayoutParams();
                    frameLayout$LayoutParams.gravity = 1;
                    frameLayout.addView(view, (ViewGroup$LayoutParams)frameLayout$LayoutParams);
                }
                else if (view.getLayoutParams() instanceof RelativeLayout$LayoutParams) {
                    final RelativeLayout$LayoutParams relativeLayout$LayoutParams = (RelativeLayout$LayoutParams)view.getLayoutParams();
                    relativeLayout$LayoutParams.addRule(13);
                    frameLayout.addView(view, (ViewGroup$LayoutParams)relativeLayout$LayoutParams);
                }
                else {
                    frameLayout.addView(view, (ViewGroup$LayoutParams)new FrameLayout$LayoutParams(-2, -2, 1));
                }
                frameLayout.setTag((Object)"PENDING");
                if (v.isMustBeVisible()) {
                    frameLayout.setVisibility(0);
                }
                else {
                    frameLayout.setVisibility(8);
                }
                this.addView((View)frameLayout);
                return;
            }
            continue;
        }
    }
    
    public void adMarvelViewDisplayed() {
        com.admarvel.android.util.e.a().b().execute(new AdMarvelView$f(this));
    }
    
    public boolean b() {
        return this.w;
    }
    
    public boolean c() {
        return this.o;
    }
    
    public void destroy() {
        new Handler(Looper.getMainLooper()).post((Runnable)new AdMarvelView$c(this));
    }
    
    public void displayAd(final Context context, final AdMarvelAd v) {
        this.v = v;
        if (v != null && context != null) {
            Label_0126: {
                try {
                    if (v.getAdType() != AdMarvelAd$AdType.SDKCALL) {
                        break Label_0126;
                    }
                    if (v.getSdkNetwork() != null) {
                        this.a(v.getTargetParams(), v, v.getSdkNetwork(), context);
                        return;
                    }
                }
                catch (Exception ex) {
                    Logging.log(Log.getStackTraceString((Throwable)ex));
                    final AdMarvelUtils$ErrorReason a = com.admarvel.android.ads.r.a(303);
                    this.getListenerImpl().a(context, this, com.admarvel.android.ads.r.a(a), a, v.getSiteId(), v.getId(), v.getTargetParams(), v.getIpAddress());
                    return;
                }
                if (v.isDisableAdrequest()) {
                    final String disableAdDuration = v.getDisableAdDuration();
                    if (disableAdDuration != null) {
                        this.a(disableAdDuration, v, context);
                    }
                    return;
                }
            }
            this.a(v);
        }
    }
    
    public void enableAdFetchedModel(final boolean w) {
        this.w = w;
    }
    
    public void fetchNewAd(final Map map, final String s, final String s2) {
        this.enableAdFetchedModel(true);
        this.requestNewAd(map, s, s2);
    }
    
    public void fetchNewAd(final Map map, final String s, final String s2, final Activity activity) {
        this.enableAdFetchedModel(true);
        this.requestNewAd(map, s, s2, activity);
    }
    
    public void focus() {
        new Handler(Looper.getMainLooper()).post((Runnable)new AdMarvelView$g(this));
    }
    
    public int getAdContainerWidth() {
        return this.m;
    }
    
    public int getAdMarvelBackgroundColor() {
        return this.d;
    }
    
    l getListenerImpl() {
        return this.h;
    }
    
    public int getTextBackgroundColor() {
        return this.e;
    }
    
    public int getTextBorderColor() {
        return this.g;
    }
    
    public int getTextFontColor() {
        return this.f;
    }
    
    public void notifyAddedToListView() {
        final View viewWithTag = this.findViewWithTag((Object)"CURRENT");
        if (viewWithTag instanceof m) {
            ((m)viewWithTag).c();
        }
        if (!(viewWithTag instanceof FrameLayout)) {
            return;
        }
        final View child = ((FrameLayout)viewWithTag).getChildAt(0);
        try {
            AdMarvelAdapterInstances.getInstance(this.b, "com.admarvel.android.admarveladcolonyadapter.AdMarvelAdColonyAdapter").notifyAddedToListView(child);
        }
        catch (Exception ex) {}
    }
    
    public void pause(final Activity ex) {
        final View viewWithTag = this.findViewWithTag((Object)"CURRENT");
        if (viewWithTag instanceof m) {
            ((m)viewWithTag).a();
        }
        View child = null;
        Label_0070: {
            if (!(viewWithTag instanceof FrameLayout)) {
                break Label_0070;
            }
            child = ((FrameLayout)viewWithTag).getChildAt(0);
            while (true) {
                try {
                    AdMarvelAdapterInstances.getInstance(this.b, "com.admarvel.android.admarveladcolonyadapter.AdMarvelAdColonyAdapter").pause((Activity)ex, child);
                    try {
                        AdMarvelAdapterInstances.getInstance(this.b, "com.admarvel.android.admarvelgoogleplayadapter.AdMarvelGooglePlayAdapter").pause((Activity)ex, child);
                        try {
                            AdMarvelAdapterInstances.getInstance("ADMARVELGUID", "com.admarvel.android.admarveladcolonyadapter.AdMarvelAdColonyAdapter").pause((Activity)ex, child);
                            try {
                                AdMarvelAnalyticsAdapterInstances.getInstance("com.admarvel.android.admarvelmologiqadapter.AdMarvelMologiqAdapter", (Context)ex).pause();
                            }
                            catch (Exception ex) {}
                        }
                        catch (Exception child) {}
                    }
                    catch (Exception ex2) {}
                }
                catch (Exception ex3) {
                    continue;
                }
                break;
            }
        }
    }
    
    public void requestNewAd(final Map map, String trim, String trim2) {
        Map map2 = null;
        while (true) {
            if (map != null) {
                try {
                    map2 = new HashMap(map);
                    final SharedPreferences sharedPreferences = this.getContext().getSharedPreferences(com.admarvel.android.ads.r.d("admarvel"), 0);
                    final String versionName = this.getContext().getPackageManager().getPackageInfo(this.getContext().getPackageName(), 0).versionName;
                    final int versionCode = this.getContext().getPackageManager().getPackageInfo(this.getContext().getPackageName(), 0).versionCode;
                    String s;
                    if (versionName != null) {
                        s = "duration" + versionName + versionCode + AdMarvelUtils.getSDKVersion();
                    }
                    else {
                        s = "duration" + versionCode + AdMarvelUtils.getSDKVersion();
                    }
                    if (s != null) {
                        final String string = sharedPreferences.getString(com.admarvel.android.ads.r.d(s), (String)null);
                        if (string != null && string.length() > 0 && DateFormat.getDateTimeInstance().parse(DateFormat.getDateTimeInstance().format(new Date(System.currentTimeMillis()))).before(DateFormat.getDateTimeInstance().parse(string))) {
                            Logging.log("requestNewAd: AD REQUEST BLOCKED, IGNORING REQUEST");
                            this.h.a(this.getContext(), this, 304, com.admarvel.android.ads.r.a(304), trim2, 0, map2, "");
                            return;
                        }
                    }
                    trim = trim.trim();
                    trim2 = trim2.trim();
                    final d a = com.admarvel.android.util.d.a();
                    if (a != null && a.b()) {
                        a.c();
                    }
                    final c a2 = com.admarvel.android.util.c.a();
                    if (a2 != null) {
                        a2.a(this.getContext());
                    }
                    if (System.currentTimeMillis() - this.k.getAndSet(System.currentTimeMillis()) > 2000L) {
                        this.h.a(this);
                        String s2 = null;
                        if (map2 != null) {
                            s2 = map2.get("UNIQUE_ID");
                        }
                        new Handler(Looper.getMainLooper()).post((Runnable)new AdMarvelView$a(this.getContext(), map2, trim, trim2, s2, com.admarvel.android.ads.r.d(this.getContext()), com.admarvel.android.ads.r.a(this.getContext()), this, 0, ""));
                        return;
                    }
                }
                catch (Exception ex) {
                    Logging.log(Log.getStackTraceString((Throwable)ex));
                    return;
                }
                Logging.log("requestNewAd: AD REQUEST PENDING, IGNORING REQUEST");
                this.h.a(this.getContext(), this, 304, com.admarvel.android.ads.r.a(304), trim2, 0, map2, "");
                return;
            }
            continue;
        }
    }
    
    public void requestNewAd(final Map map, final String s, final String s2, final Activity activity) {
        AdMarvelView.u = new WeakReference((T)activity);
        this.requestNewAd(map, s, s2);
    }
    
    public void resume(final Activity ex) {
        final View viewWithTag = this.findViewWithTag((Object)"CURRENT");
        if (viewWithTag instanceof m) {
            ((m)viewWithTag).b();
        }
        View child = null;
        Label_0070: {
            if (!(viewWithTag instanceof FrameLayout)) {
                break Label_0070;
            }
            child = ((FrameLayout)viewWithTag).getChildAt(0);
            while (true) {
                try {
                    AdMarvelAdapterInstances.getInstance(this.b, "com.admarvel.android.admarveladcolonyadapter.AdMarvelAdColonyAdapter").resume((Activity)ex, child);
                    try {
                        AdMarvelAdapterInstances.getInstance(this.b, "com.admarvel.android.admarvelgoogleplayadapter.AdMarvelGooglePlayAdapter").resume((Activity)ex, child);
                        try {
                            AdMarvelAdapterInstances.getInstance("ADMARVELGUID", "com.admarvel.android.admarveladcolonyadapter.AdMarvelAdColonyAdapter").resume((Activity)ex, child);
                            try {
                                AdMarvelAnalyticsAdapterInstances.getInstance("com.admarvel.android.admarvelmologiqadapter.AdMarvelMologiqAdapter", (Context)ex).resume();
                            }
                            catch (Exception ex) {}
                        }
                        catch (Exception child) {}
                    }
                    catch (Exception ex2) {}
                }
                catch (Exception ex3) {
                    continue;
                }
                break;
            }
        }
    }
    
    public void setAdContainerWidth(final int m) {
        this.m = m;
    }
    
    public void setAdMarvelBackgroundColor(final int n) {
        if (n == 0) {
            this.d = 0;
        }
        else {
            this.d = (0xFF000000 | n);
        }
        this.setBackgroundColor(this.d);
    }
    
    public void setAdmarvelWebViewAsSoftwareLayer(final boolean o) {
        this.o = o;
    }
    
    public void setDisableAnimation(final boolean j) {
        this.j = j;
    }
    
    public void setDisableSDKImpressionTracking(final boolean t) {
        this.t = t;
    }
    
    public void setEnableAutoScaling(final boolean r) {
        this.r = r;
    }
    
    public void setEnableClickRedirect(final boolean l) {
        this.l = l;
    }
    
    public void setEnableFitToScreenForTablets(final boolean s) {
        this.s = s;
    }
    
    public void setExtendedListener(final AdMarvelView$AdMarvelViewExtendedListener adMarvelView$AdMarvelViewExtendedListener) {
        this.h.a(adMarvelView$AdMarvelViewExtendedListener);
    }
    
    public void setListener(final AdMarvelView$AdMarvelViewListener adMarvelView$AdMarvelViewListener) {
        this.h.a(adMarvelView$AdMarvelViewListener);
    }
    
    public void setPostitialView(final boolean x) {
        this.x = x;
    }
    
    public void setTextBackgroundColor(final int n) {
        this.e = (0xFF000000 | n);
    }
    
    public void setTextBorderColor(final int g) {
        this.g = g;
    }
    
    public void setTextFontColor(final int n) {
        this.f = (0xFF000000 | n);
    }
    
    public void setVisibility(final int n) {
        int visibility = n;
        if (n == 8) {
            visibility = 4;
        }
        super.setVisibility(visibility);
        this.requestLayout();
    }
    
    public void stop(final Activity activity) {
        try {
            AdMarvelAnalyticsAdapterInstances.getInstance("com.admarvel.android.admarvelmologiqadapter.AdMarvelMologiqAdapter", (Context)activity).stop();
        }
        catch (Exception ex) {}
    }
    
    public void updateCurrentActivity(final Activity activity) {
        if (activity != null) {
            AdMarvelView.u = new WeakReference((T)activity);
        }
    }
}
