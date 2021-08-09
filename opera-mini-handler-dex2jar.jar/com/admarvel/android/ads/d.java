// 
// Decompiled by Procyon v0.6-prerelease
// 

package com.admarvel.android.ads;

import android.view.MotionEvent;
import android.webkit.WebViewClient;
import android.view.ViewParent;
import com.admarvel.android.util.e;
import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.TimeUnit;
import android.widget.RelativeLayout$LayoutParams;
import android.webkit.WebSettings;
import com.admarvel.android.util.Logging;
import java.io.IOException;
import java.io.OutputStream;
import java.io.ObjectOutputStream;
import java.io.ByteArrayOutputStream;
import android.net.Uri;
import android.content.Intent;
import android.webkit.WebChromeClient;
import android.view.View;
import android.view.ViewGroup$LayoutParams;
import android.widget.LinearLayout$LayoutParams;
import android.widget.LinearLayout;
import android.view.ViewGroup;
import android.view.GestureDetector$OnGestureListener;
import android.app.Activity;
import android.widget.RelativeLayout;
import android.content.Context;
import java.util.concurrent.ConcurrentHashMap;
import android.view.GestureDetector;
import java.lang.ref.WeakReference;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.Map;
import android.view.View$OnTouchListener;
import android.webkit.WebView;

public class d extends WebView implements View$OnTouchListener
{
    private static final Map W;
    private static final Map Z;
    static int a;
    static String b;
    private d$m A;
    private ScheduledThreadPoolExecutor B;
    private boolean C;
    private boolean D;
    private boolean E;
    private boolean F;
    private int G;
    private int H;
    private int I;
    private int J;
    private final AtomicBoolean K;
    private final String L;
    private volatile boolean M;
    private volatile boolean N;
    private final WeakReference O;
    private final AdMarvelAd P;
    private boolean Q;
    private boolean R;
    private boolean S;
    private boolean T;
    private boolean U;
    private boolean V;
    public boolean c;
    final WeakReference d;
    final WeakReference e;
    public boolean f;
    public boolean g;
    public int h;
    public int i;
    public String j;
    public boolean k;
    public boolean l;
    public boolean m;
    public String n;
    public String o;
    public String p;
    public String q;
    public String r;
    final String s;
    public GestureDetector t;
    public String u;
    private final AtomicBoolean v;
    private final AtomicBoolean w;
    private final AtomicBoolean x;
    private final AtomicBoolean y;
    private final AtomicBoolean z;
    
    static {
        d.a = 100002;
        d.b = "admarvel_internal_webview_" + d.a;
        W = new ConcurrentHashMap();
        Z = new ConcurrentHashMap();
    }
    
    d(final Context context, final boolean b, final String l, final String s, final AdMarvelView adMarvelView, final RelativeLayout relativeLayout, final AdMarvelAd p7) {
        super(context);
        this.c = false;
        this.f = false;
        this.g = false;
        this.A = null;
        this.C = true;
        this.D = false;
        this.E = false;
        this.F = false;
        this.h = 0;
        this.i = 0;
        this.j = null;
        this.k = false;
        this.l = false;
        this.m = false;
        this.n = null;
        this.o = null;
        this.p = null;
        this.q = null;
        this.r = null;
        this.I = -1;
        this.J = -1;
        this.Q = false;
        this.t = null;
        this.R = true;
        this.S = true;
        this.T = true;
        this.U = true;
        this.u = null;
        this.V = false;
        this.L = l;
        this.v = new AtomicBoolean(false);
        this.K = new AtomicBoolean(true);
        this.M = false;
        this.N = false;
        this.s = s;
        this.O = new WeakReference((T)context);
        this.w = new AtomicBoolean(false);
        this.x = new AtomicBoolean(false);
        this.y = new AtomicBoolean(false);
        this.z = new AtomicBoolean(false);
        this.P = p7;
        if (context != null && context instanceof Activity) {
            final Activity activity = (Activity)context;
            if (activity != null && activity instanceof AdMarvelActivity) {
                final AdMarvelActivity adMarvelActivity = (AdMarvelActivity)activity;
                if (adMarvelActivity != null) {
                    if (adMarvelActivity.c()) {
                        this.y.set(true);
                    }
                    else if (adMarvelActivity.e()) {
                        this.z.set(true);
                    }
                    else {
                        this.w.set(true);
                    }
                }
            }
            else {
                this.x.set(true);
            }
        }
        else {
            this.x.set(true);
        }
        this.d = new WeakReference((T)adMarvelView);
        this.e = new WeakReference((T)relativeLayout);
        if (this.d != null) {
            final AdMarvelView adMarvelView2 = (AdMarvelView)this.d.get();
            if (adMarvelView2 != null) {
                this.c = adMarvelView2.c();
            }
        }
        this.setOnTouchListener((View$OnTouchListener)this);
        this.t = new GestureDetector(context, (GestureDetector$OnGestureListener)new p());
        if (Version.getAndroidSDKVersion() >= 18) {
            com.admarvel.android.ads.t.a(this, context, this.w, this.c);
        }
        else if (Version.getAndroidSDKVersion() >= 17) {
            com.admarvel.android.ads.x.a(this, context, this.w, this.c);
        }
        else if (Version.getAndroidSDKVersion() >= 16) {
            com.admarvel.android.ads.w.a(this, context, this.w, this.c);
        }
        else if (Version.getAndroidSDKVersion() >= 11) {
            com.admarvel.android.ads.v.a(this, context, this.w, this.c);
        }
        else if (Version.getAndroidSDKVersion() >= 8) {
            com.admarvel.android.ads.u.a(this, context, this.w);
        }
        else if (Version.getAndroidSDKVersion() >= 7) {
            com.admarvel.android.ads.z.a(this, context, this.w);
        }
        else {
            com.admarvel.android.ads.y.a(this, context, this.w);
        }
        if (b) {
            this.setScrollBarStyle(0);
        }
        if (context != null && context instanceof Activity) {
            final Activity activity2 = (Activity)context;
            if (activity2 != null && activity2 instanceof AdMarvelActivity) {
                final AdMarvelActivity adMarvelActivity2 = (AdMarvelActivity)activity2;
                if (adMarvelActivity2 != null && (adMarvelActivity2.c() || adMarvelActivity2.e())) {
                    if (adMarvelActivity2.e()) {
                        this.F = true;
                    }
                    final ViewGroup viewGroup = (ViewGroup)activity2.getWindow().findViewById(16908290);
                    final LinearLayout linearLayout = new LinearLayout(this.getContext());
                    linearLayout.setBackgroundColor(0);
                    linearLayout.setTag((Object)(this.s + "BTN_CLOSE"));
                    linearLayout.setVisibility(4);
                    linearLayout.setGravity(53);
                    linearLayout.setLayoutParams((ViewGroup$LayoutParams)new LinearLayout$LayoutParams(-2, -2));
                    linearLayout.addView((View)new d$i(context, this, null, activity2));
                    viewGroup.addView((View)linearLayout);
                }
            }
        }
        int n;
        if (Version.getAndroidSDKVersion() >= 7) {
            n = 1;
        }
        else {
            n = 0;
        }
        if (n == 0) {
            this.setWebChromeClient((WebChromeClient)new d$b(this, context));
            return;
        }
        this.setWebChromeClient((WebChromeClient)new d$a(this, context));
    }
    
    static void a(final String s) {
        synchronized (d.class) {
            try {
                d.W.remove(s);
            }
            catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
    
    public static void a(final String s, final b b) {
        synchronized (d.class) {
            d.Z.put(s, b);
        }
    }
    
    public static void a(final String s, final i i) {
        synchronized (d.class) {
            d.W.put(s, i);
        }
    }
    
    static void b(final String s) {
        try {
            d.Z.remove(s);
        }
        catch (Exception ex) {}
    }
    
    public static i c(final String s) {
        return d.W.get(s);
    }
    
    public static b d(final String s) {
        return d.Z.get(s);
    }
    
    public static void d() {
        d.Z.clear();
        d.W.clear();
    }
    
    private boolean f(String a) {
        Object o = this.O.get();
        if (o == null || !(o instanceof Activity)) {
            return false;
        }
        o = o;
        if (o == null || !(o instanceof AdMarvelActivity)) {
            return false;
        }
        o = o;
        if (o == null) {
            return false;
        }
        if (com.admarvel.android.ads.r.a(this.getContext(), (String)a, false)) {
            new r(this.getContext()).c(this.L);
            if (!((AdMarvelActivity)o).c()) {
                ((AdMarvelActivity)o).g();
            }
            if (((AdMarvelActivity)o).d() && this.P != null) {
                AdMarvelInterstitialAds.getListener().a((Context)o, (String)a, this.P.getSiteId(), this.P.getId(), this.P.getTargetParams(), this.P.getIpAddress());
            }
            else if (com.admarvel.android.ads.m.a(this.s) != null && this.P != null) {
                com.admarvel.android.ads.m.a(this.s).a(this.P, (String)a);
            }
            return true;
        }
        Label_0927: {
            if (!((AdMarvelActivity)o).c()) {
                if (a != null && com.admarvel.android.ads.r.a((String)a, "admarvelsdk") != r$j.c) {
                    if (((AdMarvelActivity)o).d() && this.P != null) {
                        AdMarvelInterstitialAds.getListener().a((Context)o, com.admarvel.android.ads.r.a((String)a, "admarvelsdk", "", com.admarvel.android.ads.r.a((String)a, "admarvelsdk"), this.getContext()), this.P.getSiteId(), this.P.getId(), this.P.getTargetParams(), this.P.getIpAddress());
                    }
                    else if (com.admarvel.android.ads.m.a(this.s) != null && this.P != null) {
                        com.admarvel.android.ads.m.a(this.s).a(this.P, com.admarvel.android.ads.r.a((String)a, "admarvelsdk", "", com.admarvel.android.ads.r.a((String)a, "admarvelsdk"), this.getContext()));
                    }
                    new r(this.getContext()).c(this.L);
                    ((AdMarvelActivity)o).g();
                    return true;
                }
                if (a != null && com.admarvel.android.ads.r.a((String)a, "admarvelinternal") != r$j.c) {
                    if (((AdMarvelActivity)o).d() && this.P != null) {
                        AdMarvelInterstitialAds.getListener().a((Context)o, com.admarvel.android.ads.r.a((String)a, "admarvelinternal", "", com.admarvel.android.ads.r.a((String)a, "admarvelinternal"), this.getContext()), this.P.getSiteId(), this.P.getId(), this.P.getTargetParams(), this.P.getIpAddress());
                    }
                    else if (com.admarvel.android.ads.m.a(this.s) != null && this.P != null) {
                        com.admarvel.android.ads.m.a(this.s).a(this.P, com.admarvel.android.ads.r.a((String)a, "admarvelinternal", "", com.admarvel.android.ads.r.a((String)a, "admarvelinternal"), this.getContext()));
                    }
                    new r(this.getContext()).c(this.L);
                    ((AdMarvelActivity)o).g();
                    return true;
                }
                if (a != null && com.admarvel.android.ads.r.a((String)a, "admarvelvideo") != r$j.c) {
                    if (((AdMarvelActivity)o).d() && this.P != null) {
                        AdMarvelInterstitialAds.getListener().a((Context)o, (String)a, this.P.getSiteId(), this.P.getId(), this.P.getTargetParams(), this.P.getIpAddress());
                    }
                    else if (com.admarvel.android.ads.m.a(this.s) != null && this.P != null) {
                        com.admarvel.android.ads.m.a(this.s).a(this.P, (String)a);
                    }
                    a = com.admarvel.android.ads.r.a((String)a, "admarvelvideo", "http://", com.admarvel.android.ads.r.a((String)a, "admarvelvideo"), this.getContext());
                    final Intent intent = new Intent("android.intent.action.VIEW");
                    intent.addFlags(268435456);
                    intent.setDataAndType(Uri.parse((String)a), "video/*");
                    this.getContext().startActivity(intent);
                    new r(this.getContext()).c(this.L);
                    ((AdMarvelActivity)o).g();
                    return true;
                }
                if (a == null || com.admarvel.android.ads.r.a((String)a, "admarvelcustomvideo") == r$j.c) {
                    break Label_0927;
                }
                if (!((AdMarvelActivity)o).d() || this.P == null) {
                    break Label_0927;
                }
                AdMarvelInterstitialAds.getListener().a((Context)o, (String)a, this.P.getSiteId(), this.P.getId(), this.P.getTargetParams(), this.P.getIpAddress());
            }
            else {
                if (((AdMarvelActivity)o).c()) {
                    if (AdMarvelInterstitialAds.getEnableClickRedirect()) {
                        if (a != null && com.admarvel.android.ads.r.a((String)a, "admarvelsdk") != r$j.c) {
                            if (this.P != null) {
                                AdMarvelInterstitialAds.getListener().a((Context)o, com.admarvel.android.ads.r.a((String)a, "admarvelsdk", "", com.admarvel.android.ads.r.a((String)a, "admarvelsdk"), this.getContext()), this.P.getSiteId(), this.P.getId(), this.P.getTargetParams(), this.P.getIpAddress());
                            }
                            new r(this.getContext()).c(this.L);
                            return true;
                        }
                        if (a != null && com.admarvel.android.ads.r.a((String)a, "admarvelinternal") != r$j.c) {
                            if (this.P != null) {
                                AdMarvelInterstitialAds.getListener().a((Context)o, com.admarvel.android.ads.r.a((String)a, "admarvelinternal", "", com.admarvel.android.ads.r.a((String)a, "admarvelinternal"), this.getContext()), this.P.getSiteId(), this.P.getId(), this.P.getTargetParams(), this.P.getIpAddress());
                            }
                            new r(this.getContext()).c(this.L);
                            return true;
                        }
                        if (a != null && com.admarvel.android.ads.r.a((String)a, "admarvelvideo") != r$j.c) {
                            if (this.P != null) {
                                AdMarvelInterstitialAds.getListener().a((Context)o, (String)a, this.P.getSiteId(), this.P.getId(), this.P.getTargetParams(), this.P.getIpAddress());
                            }
                            final String a2 = com.admarvel.android.ads.r.a((String)a, "admarvelvideo", "http://", com.admarvel.android.ads.r.a((String)a, "admarvelvideo"), this.getContext());
                            final Intent intent2 = new Intent("android.intent.action.VIEW");
                            intent2.addFlags(268435456);
                            intent2.setDataAndType(Uri.parse(a2), "video/*");
                            if (com.admarvel.android.ads.r.a(this.getContext(), intent2)) {
                                this.getContext().startActivity(intent2);
                            }
                            new r(this.getContext()).c(this.L);
                        }
                        else if (a != null && com.admarvel.android.ads.r.a((String)a, "admarvelcustomvideo") != r$j.c) {
                            if (((AdMarvelActivity)o).d() && this.P != null) {
                                AdMarvelInterstitialAds.getListener().a((Context)o, (String)a, this.P.getSiteId(), this.P.getId(), this.P.getTargetParams(), this.P.getIpAddress());
                            }
                            else if (com.admarvel.android.ads.m.a(this.s) != null && this.P != null) {
                                com.admarvel.android.ads.m.a(this.s).a(this.P, (String)a);
                            }
                            final Intent intent3 = new Intent(this.getContext(), (Class)AdMarvelVideoActivity.class);
                            intent3.addFlags(268435456);
                            intent3.putExtra("url", (String)a);
                            intent3.putExtra("isCustomUrl", true);
                            intent3.putExtra("isInterstitial", false);
                            intent3.putExtra("isInterstitialClick", true);
                            intent3.putExtra("xml", this.L);
                            intent3.putExtra("GUID", this.s);
                            this.getContext().startActivity(intent3);
                            new r(this.getContext()).c(this.L);
                        }
                        else if (a != null && com.admarvel.android.ads.r.a((String)a, "admarvelexternal") != r$j.c) {
                            final Intent intent4 = new Intent("android.intent.action.VIEW", Uri.parse(com.admarvel.android.ads.r.a((String)a, "admarvelexternal", "", com.admarvel.android.ads.r.a((String)a, "admarvelexternal"), this.getContext())));
                            intent4.addFlags(268435456);
                            if (com.admarvel.android.ads.r.a(this.getContext(), intent4)) {
                                this.getContext().startActivity(intent4);
                            }
                            new r(this.getContext()).c(this.L);
                        }
                        else if (this.K.get() && a != null && ((String)a).length() > 0) {
                            final Intent intent5 = new Intent(this.getContext(), (Class)AdMarvelActivity.class);
                            intent5.addFlags(268435456);
                            intent5.putExtra("url", (String)a);
                            intent5.putExtra("isInterstitial", false);
                            intent5.putExtra("isInterstitialClick", true);
                            intent5.putExtra("xml", this.L);
                            intent5.putExtra("GUID", this.s);
                            while (true) {
                                try {
                                    if (this.P != null) {
                                        this.P.removeNonStringEntriesTargetParam();
                                        final ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                                        final ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
                                        objectOutputStream.writeObject(this.P);
                                        objectOutputStream.close();
                                        intent5.putExtra("serialized_admarvelad", byteArrayOutputStream.toByteArray());
                                    }
                                    if (((AdMarvelActivity)o).f() != null) {
                                        intent5.putExtra("source", ((AdMarvelActivity)o).f());
                                    }
                                    this.getContext().startActivity(intent5);
                                    new r(this.getContext()).c(this.L);
                                }
                                catch (IOException ex) {
                                    ex.printStackTrace();
                                    continue;
                                }
                                break;
                            }
                        }
                    }
                    if (this.P != null) {
                        AdMarvelInterstitialAds.getListener().a((Context)o, (String)a, this.P.getSiteId(), this.P.getId(), this.P.getTargetParams(), this.P.getIpAddress());
                    }
                    return true;
                }
                return false;
            }
        Label_0853_Outer:
            while (true) {
                final Intent intent6 = new Intent(this.getContext(), (Class)AdMarvelVideoActivity.class);
                intent6.addFlags(268435456);
                this.P.removeNonStringEntriesTargetParam();
                while (true) {
                    try {
                        final ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
                        final ObjectOutputStream objectOutputStream2 = new ObjectOutputStream(byteArrayOutputStream2);
                        objectOutputStream2.writeObject(this.P);
                        objectOutputStream2.close();
                        intent6.putExtra("serialized_admarvelad", byteArrayOutputStream2.toByteArray());
                        intent6.putExtra("url", (String)a);
                        intent6.putExtra("isCustomUrl", true);
                        intent6.putExtra("xml", this.L);
                        intent6.putExtra("GUID", this.s);
                        this.getContext().startActivity(intent6);
                        new r(this.getContext()).c(this.L);
                        ((AdMarvelActivity)o).g();
                        return false;
                        while (true) {
                            com.admarvel.android.ads.m.a(this.s).a(this.P, (String)a);
                            continue Label_0853_Outer;
                            iftrue(Label_0776:)(com.admarvel.android.ads.m.a(this.s) == null || this.P == null);
                            continue;
                        }
                    }
                    catch (IOException ex2) {
                        ex2.printStackTrace();
                        continue;
                    }
                    break;
                }
                break;
            }
        }
        if (a != null && com.admarvel.android.ads.r.a((String)a, "admarvelexternal") != r$j.c) {
            a = new Intent("android.intent.action.VIEW", Uri.parse(com.admarvel.android.ads.r.a((String)a, "admarvelexternal", "", com.admarvel.android.ads.r.a((String)a, "admarvelexternal"), this.getContext())));
            ((Intent)a).addFlags(268435456);
            if (com.admarvel.android.ads.r.a(this.getContext(), (Intent)a)) {
                this.getContext().startActivity((Intent)a);
            }
            new r(this.getContext()).c(this.L);
            ((AdMarvelActivity)o).g();
            return false;
        }
        return false;
    }
    
    public void a() {
        this.U = true;
        this.e();
        final WebSettings settings = this.getSettings();
        if (settings != null) {
            settings.setJavaScriptEnabled(false);
        }
        this.O.clear();
        this.d.clear();
        this.e.clear();
        this.h();
        this.t = null;
        this.t = null;
        Logging.log("AdMarveInternalWebView:cleanup");
    }
    
    void a(final int n, final int n2, final int n3, final int n4) {
        if (this.M) {
            return;
        }
        this.setLayoutParams((ViewGroup$LayoutParams)new RelativeLayout$LayoutParams(-1, n4));
    }
    
    public void a(final m m) {
        if (!this.M) {
            this.h();
            if (this.j != null) {
                Context context;
                if (this.O != null) {
                    context = (Context)this.O.get();
                }
                else {
                    context = null;
                }
                if (context != null) {
                    this.A = null;
                    this.B = null;
                    this.A = new d$m(this, context, m);
                    (this.B = new ScheduledThreadPoolExecutor(1)).scheduleWithFixedDelay(this.A, 0L, 500L, TimeUnit.MILLISECONDS);
                }
            }
        }
    }
    
    public void a(final boolean e) {
        if (!this.M) {
            this.D = true;
            this.E = e;
            final Context context = (Context)this.O.get();
            if (context != null) {
                new Handler(Looper.getMainLooper()).post((Runnable)new d$f(this, context, true));
            }
        }
    }
    
    public boolean b() {
        return this.M;
    }
    
    public boolean c() {
        return this.V;
    }
    
    public void destroy() {
        this.e();
        this.U = true;
        super.destroy();
        Logging.log("AdMarveInternalWebView:destroy()");
    }
    
    public void e() {
        this.M = true;
    }
    
    public void e(final String s) {
        new Handler(Looper.getMainLooper()).post((Runnable)new d$j(this, this, s));
    }
    
    public void f() {
        this.N = true;
        com.admarvel.android.util.e.a().b().execute(new d$l(this, this));
    }
    
    public void g() {
        final int n = 0;
        this.N = false;
        if (this.y.get() || this.z.get()) {
            if (this.j != null && !this.k) {
                this.e(this.j + "(true)");
                this.k = true;
                if (this.y.get()) {
                    this.m = true;
                }
            }
        }
        else if (this.x.get() && this.j != null) {
            final int[] array2;
            final int[] array = array2 = new int[2];
            array2[1] = (array2[0] = -1);
            this.getLocationInWindow(array);
            int n2;
            if (this.getHeight() > 0) {
                n2 = this.getHeight() / 2;
            }
            else {
                n2 = 0;
            }
            final ViewParent parent = this.getParent();
            while (true) {
                Label_0290: {
                    if (!(parent instanceof m)) {
                        break Label_0290;
                    }
                    final m m = (m)parent;
                    if (m == null) {
                        break Label_0290;
                    }
                    int v;
                    if (m.v != Integer.MIN_VALUE && m.v > 0) {
                        v = m.v;
                    }
                    else {
                        v = 0;
                    }
                    int n3 = n;
                    if (array[1] - v + n2 >= 0) {
                        n3 = n;
                        if (array[1] + n2 < com.admarvel.android.ads.r.h(this.getContext())) {
                            n3 = 1;
                        }
                    }
                    if (this.j != null && !this.k && n3 != 0) {
                        this.e(this.j + "(true)");
                        this.k = true;
                        return;
                    }
                    return;
                }
                int v = 0;
                continue;
            }
        }
    }
    
    public String getBaseUrl() {
        return null;
    }
    
    public AtomicBoolean getEnableAutoDetect() {
        return this.K;
    }
    
    public void h() {
        if (this.A != null && this.j != null && this.B != null) {
            this.B.remove(this.A);
            this.B.shutdown();
            this.B.purge();
            this.A = null;
        }
    }
    
    void i() {
        if (this.M) {
            return;
        }
        final ViewGroup$LayoutParams layoutParams = this.getLayoutParams();
        layoutParams.width = this.H;
        layoutParams.height = this.G;
        this.setVisibility(0);
        final ViewParent parent = this.getParent();
        if (parent instanceof m) {
            ((m)parent).a(this.H, this.G);
        }
        this.requestLayout();
    }
    
    void j() {
        if (this.M) {
            return;
        }
        RelativeLayout$LayoutParams layoutParams;
        if (this.w.get()) {
            layoutParams = new RelativeLayout$LayoutParams(-1, -1);
            layoutParams.addRule(2, com.admarvel.android.ads.o.a);
        }
        else {
            layoutParams = new RelativeLayout$LayoutParams(-1, 1);
        }
        this.setLayoutParams((ViewGroup$LayoutParams)layoutParams);
    }
    
    void k() {
        if (this.M) {
            return;
        }
        this.setLayoutParams((ViewGroup$LayoutParams)new RelativeLayout$LayoutParams(-1, -1));
    }
    
    void l() {
        final Context context = (Context)this.O.get();
        if (context != null && (this.P != null || this.w.get())) {
            if (Version.getAndroidSDKVersion() >= 11) {
                this.setWebViewClient((WebViewClient)new d$c(this, context, this.P));
                return;
            }
            this.setWebViewClient((WebViewClient)new d$d(this, context, this.P));
        }
    }
    
    public void m() {
        if (this.D) {
            final Context context = (Context)this.O.get();
            if (context != null) {
                new Handler(Looper.getMainLooper()).post((Runnable)new d$f(this, context, false));
            }
            this.D = false;
        }
    }
    
    protected void onDetachedFromWindow() {
        try {
            super.onDetachedFromWindow();
        }
        catch (IllegalArgumentException ex) {}
    }
    
    protected void onLayout(final boolean b, int width, int height, final int n, final int n2) {
        super.onLayout(b, width, height, n, n2);
        if (this.M) {
            return;
        }
        final ViewParent parent = this.getParent();
        width = this.getWidth();
        height = this.getHeight();
        if (parent instanceof m && !((m)parent).a.get()) {
            this.G = this.getHeight();
            this.H = this.getWidth();
            if (this.j != null && this.C) {
                this.C = false;
                this.a((m)parent);
            }
        }
        else if (this.y.get() || this.z.get()) {
            if (height == 0) {
                this.m = false;
            }
            else {
                this.m = true;
            }
        }
        if (this.I != -1 && this.J != -1 && (width != this.J || height != this.I) && width > 0 && height > 0 && this.J >= 0 && this.I >= 0 && this.n != null) {
            this.e(this.n + "(" + width + "," + height + ")");
        }
        this.J = width;
        this.I = height;
    }
    
    public boolean onTouch(final View view, final MotionEvent motionEvent) {
        this.V = true;
        switch (motionEvent.getAction()) {
            case 0:
            case 1: {
                if (!view.hasFocus()) {
                    view.requestFocus();
                    break;
                }
                break;
            }
        }
        return !this.w.get() && Version.getAndroidSDKVersion() > 10 && this.t != null && this.t.onTouchEvent(motionEvent);
    }
    
    void setLayoutParamsForBanner(final boolean b) {
        if (this.M) {
            return;
        }
        RelativeLayout$LayoutParams layoutParams;
        if (b) {
            layoutParams = new RelativeLayout$LayoutParams(-1, -2);
        }
        else {
            layoutParams = new RelativeLayout$LayoutParams(-1, 1);
        }
        this.setLayoutParams((ViewGroup$LayoutParams)layoutParams);
    }
}
