// 
// Decompiled by Procyon v0.6-prerelease
// 

package com.admarvel.android.ads;

import android.widget.FrameLayout;
import android.webkit.WebChromeClient;
import com.admarvel.android.util.e;
import android.webkit.WebView;
import com.admarvel.android.util.Logging;
import android.util.Log;
import android.view.View;
import android.webkit.WebViewClient;
import android.os.Handler;
import android.os.Looper;
import android.view.ViewGroup;
import android.view.ViewGroup$LayoutParams;
import android.widget.RelativeLayout$LayoutParams;
import android.widget.LinearLayout;
import android.app.Activity;
import java.util.UUID;
import android.content.Context;
import java.util.concurrent.ConcurrentHashMap;
import java.lang.ref.WeakReference;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.Map;
import android.annotation.SuppressLint;
import android.widget.RelativeLayout;

@SuppressLint({ "ViewConstructor", "SimpleDateFormat", "DefaultLocale" })
public class m extends RelativeLayout
{
    private static String T;
    private static String U;
    private static String V;
    private static String W;
    private static String Z;
    private static String aa;
    private static String ab;
    private static final Map ae;
    int A;
    int B;
    int C;
    int D;
    int E;
    String F;
    String G;
    String H;
    String I;
    String J;
    String K;
    String L;
    String M;
    String N;
    m$ac O;
    boolean P;
    final boolean Q;
    final boolean R;
    final boolean S;
    public final AtomicBoolean a;
    private String ac;
    private String ad;
    private boolean af;
    private boolean ag;
    private final String ah;
    private WeakReference ai;
    private m$c aj;
    private d ak;
    private WeakReference al;
    private AdMarvelAd am;
    private boolean an;
    final AtomicBoolean b;
    int c;
    final boolean d;
    final boolean e;
    boolean f;
    boolean g;
    boolean h;
    boolean i;
    String j;
    m$u k;
    String l;
    String m;
    boolean n;
    String o;
    final AtomicBoolean p;
    final AtomicBoolean q;
    final AtomicBoolean r;
    final String s;
    int t;
    int u;
    public int v;
    boolean w;
    boolean x;
    boolean y;
    String z;
    
    static {
        m.T = "<style>* {-webkit-tap-highlight-color: rgba(0,0,0,0.0);} body {background-color:transparent;margin:0px;padding:0px;}</style>";
        m.U = "<style>* {-webkit-tap-highlight-color: rgba(0,0,0,0.0);} body {background-color:transparent;margin:0px;padding:0px;}</style><script type='text/javascript' src='http://admarvel.s3.amazonaws.com/js/admarvel_compete_v1.1.js'></script>";
        m.V = "<html><head>%s</head><body><div align=\"center\">%s</div></body></html>";
        m.W = "<style>* {-webkit-tap-highlight-color: rgba(0,0,0,0.0);} body {background-color:transparent;margin:0;padding:0;} .bl span{display:table-cell;vertical-align:middle;height:38px;text-align:center;width:500px;} .bl {margin:2px;padding: 2px 15px;display:block;vertical-align:middle;text-align:center;line-height: 15px;font-size:12px;font-family: Helvetica;font-weight: bold;text-decoration: none;color:rgb(%d,%d,%d);text-shadow: #222222 0px 1px 2px; background-color:rgb(%d,%d,%d);background-image: url('http://admarvel.s3.amazonaws.com/btn_bg_trns.png');border: 2px rgb(%d, %d, %d) solid;-webkit-border-radius: 10px;}</style>";
        m.Z = "<html><head>%s</head><body><div class=\"bl\"><a href=\"%s\" style=\"text-decoration: none; color: #000;\" ><span>%s</span></a></div>";
        m.aa = "<meta name=\"viewport\" content=\"initial-scale=1.0,maximum-scale=1.0,target-densitydpi=device-dpi, width=device-width\" />";
        m.ab = "<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0, maximum-scale=1.0\" />";
        ae = new ConcurrentHashMap();
    }
    
    m(final Context context, final boolean d, final boolean e, final String ah, final AdMarvelAd am, final boolean q, final boolean r, final boolean s) {
        super(context);
        this.f = false;
        this.g = false;
        this.h = false;
        this.i = false;
        this.j = "top-right";
        this.n = false;
        this.o = null;
        this.ag = false;
        this.t = -1;
        this.u = Integer.MIN_VALUE;
        this.v = Integer.MIN_VALUE;
        this.w = false;
        this.x = false;
        this.y = false;
        this.am = null;
        this.an = false;
        this.z = null;
        this.A = -1;
        this.B = -1;
        this.C = -1;
        this.D = -1;
        this.E = -1;
        this.F = null;
        this.G = null;
        this.H = null;
        this.I = null;
        this.J = null;
        this.K = null;
        this.L = null;
        this.M = null;
        this.N = null;
        this.O = null;
        this.P = true;
        this.Q = q;
        this.R = r;
        this.ah = ah;
        this.d = d;
        this.e = e;
        this.s = UUID.randomUUID().toString();
        this.a = new AtomicBoolean(false);
        this.b = new AtomicBoolean(false);
        this.p = new AtomicBoolean(false);
        this.q = new AtomicBoolean(false);
        this.r = new AtomicBoolean(false);
        this.aj = new m$c(this);
        if (context instanceof Activity) {
            this.t = ((Activity)context).getRequestedOrientation();
        }
        this.ai = new WeakReference((T)this.aj);
        this.am = am;
        this.S = s;
    }
    
    public static n a(final String s) {
        return m.ae.get(s);
    }
    
    public static void a(final String s, final n n) {
        synchronized (m.class) {
            m.ae.put(s, n);
        }
    }
    
    private static void b(final LinearLayout linearLayout, final RelativeLayout$LayoutParams layoutParams, final String s, int n, int n2, int rightMargin, int rightMargin2, final int n3, final int n4, final int n5) {
        layoutParams.rightMargin = 0;
        layoutParams.leftMargin = 0;
        layoutParams.topMargin = 0;
        layoutParams.bottomMargin = 0;
        int n6 = rightMargin;
        if (rightMargin == -1) {
            n6 = n3;
        }
        if ((rightMargin = rightMargin2) == -1) {
            rightMargin = n4;
        }
        if (s != null && s.length() > 0) {
            if ("top-right".equals(s)) {
                layoutParams.addRule(10);
                layoutParams.addRule(11);
                rightMargin = n + n6 - n3;
                if (n == 0 && rightMargin > 0) {
                    layoutParams.rightMargin = rightMargin / 2;
                }
                else if (rightMargin > 0) {
                    layoutParams.rightMargin = rightMargin;
                }
                else {
                    layoutParams.rightMargin = 0;
                }
                if (n2 < 0) {
                    layoutParams.topMargin = Math.abs(n2);
                }
                else {
                    layoutParams.topMargin = 0;
                }
            }
            else if ("top-left".equals(s)) {
                layoutParams.addRule(9);
                layoutParams.addRule(10);
                if (n < 0) {
                    layoutParams.leftMargin = Math.abs(n);
                }
                else if (n == 0) {
                    n = (n6 - n3) / 2;
                    if (n > 0) {
                        layoutParams.leftMargin = n;
                    }
                }
                else {
                    layoutParams.leftMargin = 0;
                }
                if (n2 < 0) {
                    layoutParams.topMargin = Math.abs(n2);
                }
                else {
                    layoutParams.topMargin = 0;
                }
            }
            else if ("bottom-right".equals(s)) {
                layoutParams.addRule(11);
                layoutParams.addRule(12);
                rightMargin2 = n + n6 - n3;
                if (n == 0 && rightMargin2 > 0) {
                    layoutParams.rightMargin = rightMargin2 / 2;
                }
                else if (rightMargin2 > 0) {
                    layoutParams.rightMargin = rightMargin2;
                }
                else {
                    layoutParams.rightMargin = 0;
                }
                n = n4 - (n2 + rightMargin);
                if (n < 0) {
                    layoutParams.bottomMargin = Math.abs(n);
                }
                else {
                    layoutParams.bottomMargin = 0;
                }
            }
            else if ("bottom-left".equals(s)) {
                layoutParams.addRule(9);
                layoutParams.addRule(12);
                if (n < 0) {
                    layoutParams.leftMargin = Math.abs(n);
                }
                else if (n == 0) {
                    n = (n6 - n3) / 2;
                    if (n > 0) {
                        layoutParams.leftMargin = n;
                    }
                }
                else {
                    layoutParams.leftMargin = 0;
                }
                n = n4 - (n2 + rightMargin);
                if (n < 0) {
                    layoutParams.bottomMargin = Math.abs(n);
                }
                else {
                    layoutParams.bottomMargin = 0;
                }
            }
            else if ("center".equals(s)) {
                if (n + n6 <= n3) {
                    if (n <= 0) {
                        layoutParams.leftMargin = (n + n6) / 2 + Math.abs(n) - n5 / 2;
                    }
                    else {
                        layoutParams.leftMargin = n6 / 2 - n5 / 2;
                    }
                }
                else if (n <= 0) {
                    layoutParams.leftMargin = n3 / 2 + Math.abs(n) - n5 / 2;
                }
                else {
                    layoutParams.leftMargin = (n3 - n) / 2 - n5 / 2;
                }
                layoutParams.addRule(15);
                if (n2 < 0) {
                    n = rightMargin / 2 + n2;
                    if (n < 0) {
                        layoutParams.topMargin = Math.abs(n) + rightMargin / 2;
                        layoutParams.addRule(10);
                    }
                    else {
                        layoutParams.topMargin = 0;
                        layoutParams.addRule(15);
                    }
                }
                else {
                    n = n4 - (rightMargin / 2 + n2);
                    if (n < 0) {
                        layoutParams.bottomMargin = Math.abs(n) + rightMargin / 2;
                        layoutParams.addRule(12);
                    }
                    else {
                        layoutParams.bottomMargin = 0;
                        layoutParams.addRule(15);
                    }
                }
            }
            else if ("bottom-center".equals(s)) {
                n2 = n4 - (n2 + rightMargin);
                if (n2 < 0) {
                    layoutParams.bottomMargin = Math.abs(n2);
                }
                else {
                    layoutParams.bottomMargin = 0;
                }
                layoutParams.addRule(9);
                layoutParams.addRule(12);
                if (n + n6 <= n3) {
                    if (n <= 0) {
                        layoutParams.leftMargin = (n + n6) / 2 + Math.abs(n) - n5 / 2;
                    }
                    else {
                        layoutParams.leftMargin = n6 / 2 - n5 / 2;
                    }
                }
                else if (n <= 0) {
                    layoutParams.leftMargin = n3 / 2 + Math.abs(n) - n5 / 2;
                }
                else {
                    layoutParams.leftMargin = (n3 - n) / 2 - n5 / 2;
                }
            }
            else if ("top-center".equals(s)) {
                layoutParams.addRule(14);
                if (n2 < 0) {
                    layoutParams.topMargin = Math.abs(n2);
                }
                else {
                    layoutParams.topMargin = 0;
                }
                if (n + n6 <= n3) {
                    if (n <= 0) {
                        layoutParams.leftMargin = (n + n6) / 2 + Math.abs(n) - n5 / 2;
                    }
                    else {
                        layoutParams.leftMargin = n6 / 2 - n5 / 2;
                    }
                }
                else if (n <= 0) {
                    layoutParams.leftMargin = n3 / 2 + Math.abs(n) - n5 / 2;
                }
                else {
                    layoutParams.leftMargin = (n3 - n) / 2 - n5 / 2;
                }
            }
            else {
                layoutParams.addRule(11);
                layoutParams.addRule(10);
                n = n + n6 - n3;
                if (n > 0) {
                    layoutParams.rightMargin = n;
                }
                else {
                    layoutParams.rightMargin = 0;
                }
                if (n2 < 0) {
                    layoutParams.topMargin = Math.abs(n2);
                }
                else {
                    layoutParams.topMargin = 0;
                }
            }
        }
        else {
            layoutParams.addRule(11);
            layoutParams.addRule(10);
            n = n + n6 - n3;
            if (n > 0) {
                layoutParams.rightMargin = n;
            }
            else {
                layoutParams.rightMargin = 0;
            }
            if (n2 < 0) {
                layoutParams.topMargin = Math.abs(n2);
            }
            else {
                layoutParams.topMargin = 0;
            }
        }
        linearLayout.setLayoutParams((ViewGroup$LayoutParams)layoutParams);
    }
    
    public static void b(final String s) {
        m.ae.remove(s);
    }
    
    private void d(final String s) {
        if (this.b.compareAndSet(true, false) && a(this.s) != null) {
            a(this.s).a(this, this.am, 308, com.admarvel.android.ads.r.a(308));
        }
    }
    
    void a() {
        d d2;
        final d d = d2 = (d)this.findViewWithTag((Object)(this.s + "INTERNAL"));
        if (d == null) {
            d2 = d;
            if (this.x) {
                final Context context = this.getContext();
                d2 = d;
                if (context != null) {
                    d2 = d;
                    if (context instanceof Activity) {
                        d2 = (d)((ViewGroup)((Activity)context).getWindow().findViewById(16908290)).findViewWithTag((Object)(this.s + "INTERNAL"));
                    }
                }
            }
        }
        if (d2 == null) {
            return;
        }
        d2.f();
    }
    
    void a(final int width, final int height) {
        final ViewGroup$LayoutParams layoutParams = this.getLayoutParams();
        layoutParams.width = width;
        layoutParams.height = height;
        this.requestLayout();
    }
    
    void a(int n, int n2, int imageHeight, final int n3, final AdMarvelView adMarvelView) {
        if (this.am == null) {
            if (a(this.s) != null) {
                a(this.s).a(this, this.am, 305, com.admarvel.android.ads.r.a(305));
            }
        }
        else {
            if (this.am != null && this.am.getSource() != null) {
                this.ad = this.am.getSource();
            }
        Label_0269_Outer:
            while (true) {
                while (true) {
                    Label_1083: {
                        Label_1031: {
                            Label_0767: {
                                Label_0488: {
                                    while (true) {
                                        try {
                                            if (!this.am.getAdType().equals(AdMarvelAd$AdType.IMAGE) || !this.am.hasImage()) {
                                                break Label_1083;
                                            }
                                            if (this.am.getImageWidth() <= 0 || this.am.getImageHeight() <= 0) {
                                                break Label_1031;
                                            }
                                            if (Version.getAndroidSDKVersion() < 7) {
                                                break Label_0767;
                                            }
                                            if (AdMarvelUtils.isTabletDevice(this.getContext()) && !this.e) {
                                                break Label_0488;
                                            }
                                            if (adMarvelView.getAdContainerWidth() > 0) {
                                                final float n4 = adMarvelView.getAdContainerWidth() / com.admarvel.android.ads.r.i(this.getContext());
                                                this.ac = String.format(com.admarvel.android.ads.m.V, com.admarvel.android.ads.m.T + com.admarvel.android.ads.m.ab, "<a href=\"" + this.am.getClickURL() + "\"><img src=\"" + this.am.getImageURL() + "\" width=\"" + n4 + "\"\" /></a>");
                                                (this.ak = new d(this.getContext(), false, this.ah, this.s, adMarvelView, null, this.am)).setTag((Object)(this.s + "INTERNAL"));
                                                new Handler(Looper.getMainLooper()).post((Runnable)new Runnable() {
                                                    @Override
                                                    public void run() {
                                                        com.admarvel.android.ads.m.this.ak.setFocusable(true);
                                                        com.admarvel.android.ads.m.this.ak.setClickable(true);
                                                        com.admarvel.android.ads.m.this.ak.setBackgroundColor(n3);
                                                        com.admarvel.android.ads.m.this.ak.setScrollContainer(false);
                                                        com.admarvel.android.ads.m.this.ak.setVerticalScrollBarEnabled(false);
                                                        com.admarvel.android.ads.m.this.ak.setHorizontalScrollBarEnabled(false);
                                                        com.admarvel.android.ads.m.this.ak.setLayoutParamsForBanner(com.admarvel.android.ads.m.this.S);
                                                        if (Version.getAndroidSDKVersion() < 11) {
                                                            com.admarvel.android.ads.m.this.ak.setWebViewClient((WebViewClient)new WeakReference<WebViewClient>(new m$b(com.admarvel.android.ads.m.this)).get());
                                                        }
                                                        else {
                                                            com.admarvel.android.ads.m.this.ak.setWebViewClient((WebViewClient)new WeakReference<WebViewClient>(new m$a(com.admarvel.android.ads.m.this)).get());
                                                        }
                                                        com.admarvel.android.ads.m.this.al = new WeakReference((T)com.admarvel.android.ads.m.this.ak);
                                                        com.admarvel.android.ads.m.this.addView((View)com.admarvel.android.ads.m.this.al.get());
                                                        com.admarvel.android.ads.m.this.ak.addJavascriptInterface(new WeakReference<Object>(new AdMarvelWebViewJSInterface((d)com.admarvel.android.ads.m.this.al.get(), com.admarvel.android.ads.m.this.am, com.admarvel.android.ads.m.this, com.admarvel.android.ads.m.this.getContext())).get(), "ADMARVEL");
                                                        if (AdMarvelView.a) {
                                                            com.admarvel.android.ads.m.this.ak.loadDataWithBaseURL(com.admarvel.android.ads.m.this.am.getOfflineBaseUrl() + "/", com.admarvel.android.ads.m.this.ac, "text/html", "utf-8", (String)null);
                                                            return;
                                                        }
                                                        if (Version.getAndroidSDKVersion() < 11) {
                                                            com.admarvel.android.ads.m.this.ak.loadDataWithBaseURL("content://" + com.admarvel.android.ads.m.this.getContext().getPackageName() + ".AdMarvelLocalFileContentProvider", com.admarvel.android.ads.m.this.ac, "text/html", "utf-8", (String)null);
                                                            return;
                                                        }
                                                        com.admarvel.android.ads.m.this.ak.loadDataWithBaseURL("http://baseurl.admarvel.com", com.admarvel.android.ads.m.this.ac, "text/html", "utf-8", (String)null);
                                                    }
                                                });
                                                this.b.set(true);
                                                return;
                                            }
                                        }
                                        catch (Exception ex) {
                                            Logging.log(Log.getStackTraceString((Throwable)ex));
                                            if (a(this.s) != null) {
                                                a(this.s).a(this, this.am, 305, com.admarvel.android.ads.r.a(305));
                                                return;
                                            }
                                            break;
                                        }
                                        if (adMarvelView.getWidth() > 0) {
                                            final float n4 = adMarvelView.getWidth() / com.admarvel.android.ads.r.i(this.getContext());
                                            continue Label_0269_Outer;
                                        }
                                        if (com.admarvel.android.ads.r.g(this.getContext()) < com.admarvel.android.ads.r.h(this.getContext())) {
                                            n = com.admarvel.android.ads.r.g(this.getContext());
                                        }
                                        else {
                                            n = com.admarvel.android.ads.r.h(this.getContext());
                                        }
                                        final float n4 = n / com.admarvel.android.ads.r.i(this.getContext());
                                        continue Label_0269_Outer;
                                    }
                                }
                                final float n5 = (float)this.am.getImageWidth();
                                float n7;
                                final float n6 = n7 = (float)this.am.getImageHeight();
                                float n8 = n5;
                                if (Version.getAndroidSDKVersion() >= 19) {
                                    if (com.admarvel.android.ads.r.g(this.getContext()) < com.admarvel.android.ads.r.h(this.getContext())) {
                                        n = com.admarvel.android.ads.r.g(this.getContext());
                                    }
                                    else {
                                        n = com.admarvel.android.ads.r.h(this.getContext());
                                    }
                                    final float n9 = n / com.admarvel.android.ads.r.i(this.getContext());
                                    Logging.log("Device Relative Screen Width :" + n9);
                                    n7 = n6;
                                    n8 = n5;
                                    if (n5 > n9) {
                                        final float n10 = n9 / n5;
                                        Logging.log("Device Image Ad Scaling factpr :" + n10);
                                        n8 = n5 * n10;
                                        n7 = n6 * n10;
                                    }
                                }
                                this.ac = String.format(com.admarvel.android.ads.m.V, com.admarvel.android.ads.m.T + com.admarvel.android.ads.m.aa, "<a href=\"" + this.am.getClickURL() + "\"><img src=\"" + this.am.getImageURL() + "\" width=\"" + n8 + "\" height=\"" + n7 + "\" /></a>");
                                continue;
                            }
                            if (com.admarvel.android.ads.r.d(this.getContext()) == 2) {
                                n2 = com.admarvel.android.ads.r.h(this.getContext());
                            }
                            else {
                                n2 = com.admarvel.android.ads.r.g(this.getContext());
                            }
                            if (com.admarvel.android.ads.r.d(this.getContext()) == 1) {
                                n = com.admarvel.android.ads.r.h(this.getContext());
                            }
                            else {
                                n = com.admarvel.android.ads.r.g(this.getContext());
                            }
                            if (this.d) {
                                imageHeight = (int)(this.am.getImageWidth() * com.admarvel.android.ads.r.a(this.getContext(), n2, this.am.getImageWidth()));
                                final int n11 = (int)(this.am.getImageHeight() * com.admarvel.android.ads.r.a(this.getContext(), n2, this.am.getImageWidth()));
                                n2 = imageHeight;
                                imageHeight = n11;
                            }
                            else {
                                n2 = this.am.getImageWidth();
                                imageHeight = this.am.getImageHeight();
                            }
                            n = Math.min(imageHeight, n);
                            this.ac = String.format(com.admarvel.android.ads.m.V, com.admarvel.android.ads.m.T + com.admarvel.android.ads.m.aa, "<a href=\"" + this.am.getClickURL() + "\"><img src=\"" + this.am.getImageURL() + "\" width=\"" + n2 + "\" height=\"" + n + "\" /></a>");
                            continue;
                        }
                        this.ac = String.format(com.admarvel.android.ads.m.V, com.admarvel.android.ads.m.T + com.admarvel.android.ads.m.aa, this.am.getXhtml());
                        continue;
                    }
                    if (this.am.getAdType().equals(AdMarvelAd$AdType.TEXT) && this.am.getText() != null && this.am.getText().length() > 0) {
                        this.ac = String.format(com.admarvel.android.ads.m.Z, String.format(com.admarvel.android.ads.m.W, n >> 16 & 0xFF, n >> 8 & 0xFF, n & 0xFF, imageHeight >> 16 & 0xFF, imageHeight >> 8 & 0xFF, imageHeight & 0xFF, n2 >> 16 & 0xFF, n2 >> 8 & 0xFF, n2 & 0xFF), this.am.getClickURL(), this.am.getText());
                        continue;
                    }
                    if (this.am.getXhtml().contains("ORMMA_API")) {
                        this.ac = String.format(com.admarvel.android.ads.m.V, com.admarvel.android.ads.m.U, this.am.getXHTML());
                        continue;
                    }
                    this.ac = String.format(com.admarvel.android.ads.m.V, com.admarvel.android.ads.m.T, this.am.getXHTML() + com.admarvel.android.ads.r.a);
                    continue;
                }
            }
        }
    }
    
    void b() {
        d d2;
        final d d = d2 = (d)this.findViewWithTag((Object)(this.s + "INTERNAL"));
        if (d == null) {
            d2 = d;
            if (this.x) {
                final Context context = this.getContext();
                d2 = d;
                if (context != null) {
                    d2 = d;
                    if (context instanceof Activity) {
                        d2 = (d)((ViewGroup)((Activity)context).getWindow().findViewById(16908290)).findViewWithTag((Object)(this.s + "INTERNAL"));
                    }
                }
            }
        }
        if (d2 == null) {
            return;
        }
        d2.g();
        if (d2 instanceof d) {
            d2.a(this);
        }
        if (Version.getAndroidSDKVersion() >= 11) {
            com.admarvel.android.ads.aa.a(d2);
            return;
        }
        com.admarvel.android.ads.ab.a(d2);
    }
    
    public void c() {
    }
    
    void c(final String s) {
        if (s == null) {
            return;
        }
        try {
            if (s.length() > 0) {
                com.admarvel.android.util.e.a().b().execute(new AdMarvelRedirectRunnable(s, this.getContext(), this.am, "banner", this.s, this.af, AdMarvelView.a, this.R));
            }
        }
        catch (Exception ex) {
            Logging.log(Log.getStackTraceString((Throwable)ex));
        }
    }
    
    void d() {
        d d2;
        final d d = d2 = (d)this.findViewWithTag((Object)(this.s + "INTERNAL"));
        if (d == null) {
            d2 = d;
            if (this.x) {
                final Context context = this.getContext();
                d2 = d;
                if (context != null) {
                    d2 = d;
                    if (context instanceof Activity) {
                        d2 = (d)((ViewGroup)((Activity)context).getWindow().findViewById(16908290)).findViewWithTag((Object)(this.s + "INTERNAL"));
                    }
                }
            }
        }
        com.admarvel.android.ads.d.b(this.s);
        com.admarvel.android.ads.d.a(this.s);
        b(this.s);
        if (d2 != null) {
            if (Version.getAndroidSDKVersion() >= 14) {
                new Handler(Looper.getMainLooper()).post((Runnable)new m$f(this));
            }
            if (Version.getAndroidSDKVersion() >= 15) {
                d2.setWebChromeClient((WebChromeClient)null);
            }
            d2.setWebViewClient((WebViewClient)null);
            d2.a();
            if (this.al != null) {
                this.al.clear();
            }
            this.am = null;
            if (this.aj != null) {
                this.aj.b();
                this.aj = null;
                this.ai = null;
            }
        }
    }
    
    void e() {
        while (true) {
            int n = 0;
            while (true) {
                try {
                    if (this.k != null) {
                        this.k.disable();
                    }
                    final Context context = this.getContext();
                    if (context instanceof Activity) {
                        final Activity activity = (Activity)context;
                        if (this.w && this.y && !this.n && activity != null) {
                            activity.setRequestedOrientation(this.t);
                            this.w = false;
                        }
                        if (this.a.compareAndSet(true, false) && activity != null) {
                            final ViewGroup viewGroup = (ViewGroup)activity.getWindow().findViewById(16908290);
                            final d d = (d)viewGroup.findViewWithTag((Object)(this.s + "INTERNAL"));
                            if (d != null) {
                                d.g = true;
                            }
                            final FrameLayout frameLayout = (FrameLayout)viewGroup.findViewWithTag((Object)(this.s + "EXPAND_BG"));
                            final RelativeLayout relativeLayout = (RelativeLayout)viewGroup.findViewWithTag((Object)(this.s + "EXPAND_LAYOUT"));
                            if (this.f) {
                                final LinearLayout linearLayout = (LinearLayout)viewGroup.findViewWithTag((Object)(this.s + "BTN_CLOSE"));
                                if (linearLayout != null) {
                                    relativeLayout.removeView((View)linearLayout);
                                }
                                this.f = false;
                            }
                            if (frameLayout != null && d != null) {
                                FrameLayout frameLayout2;
                                for (frameLayout2 = (FrameLayout)this.findViewWithTag((Object)(this.s + "EXPAND_PLACE_HOLDER")); n < this.getChildCount() && this.getChildAt(n) != frameLayout2; ++n) {}
                                relativeLayout.removeView((View)d);
                                frameLayout.removeView((View)relativeLayout);
                                viewGroup.removeView((View)frameLayout);
                                viewGroup.invalidate();
                                viewGroup.requestLayout();
                                this.removeAllViews();
                                this.addView((View)d, n);
                                this.removeView((View)frameLayout2);
                                d.i();
                                this.x = false;
                                this.ag = false;
                            }
                            this.invalidate();
                            this.requestLayout();
                            if (a(this.s) != null) {
                                a(this.s).b();
                            }
                            if (d != null) {
                                if (this.l != null) {
                                    d.loadUrl("javascript:" + this.l + "()");
                                }
                                d.g = false;
                            }
                        }
                        return;
                    }
                }
                catch (Exception ex) {
                    Logging.log(Log.getStackTraceString((Throwable)ex));
                    return;
                }
                final Activity activity = null;
                continue;
            }
        }
    }
    
    void f() {
        final View viewWithTag = this.findViewWithTag((Object)(this.s + "INTERNAL"));
        if (viewWithTag != null && viewWithTag instanceof d && !viewWithTag.hasFocus()) {
            viewWithTag.requestFocus();
        }
    }
    
    public AdMarvelAd getAdMarvelAd() {
        return this.am;
    }
    
    public void setEnableClickRedirect(final boolean af) {
        this.af = af;
    }
}
