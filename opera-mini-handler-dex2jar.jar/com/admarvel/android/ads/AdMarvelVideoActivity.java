// 
// Decompiled by Procyon v0.6-prerelease
// 

package com.admarvel.android.ads;

import android.os.PowerManager;
import android.view.KeyEvent;
import android.os.Bundle;
import android.media.MediaPlayer;
import android.widget.Toast;
import java.net.URL;
import java.net.HttpURLConnection;
import android.net.Uri;
import java.util.HashMap;
import java.util.Collections;
import java.util.Comparator;
import android.widget.ViewSwitcher;
import java.util.ArrayList;
import android.graphics.Typeface;
import android.view.ViewGroup$LayoutParams;
import android.widget.RelativeLayout$LayoutParams;
import android.content.Context;
import android.view.animation.Animation;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.AlphaAnimation;
import java.io.Serializable;
import java.util.Iterator;
import android.view.MotionEvent;
import android.view.View;
import com.admarvel.android.util.Logging;
import android.util.Log;
import android.view.View$OnTouchListener;
import android.content.BroadcastReceiver;
import android.widget.LinearLayout;
import android.widget.TextView;
import java.util.List;
import java.util.Map;
import android.os.Handler;
import java.lang.ref.WeakReference;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.media.MediaPlayer$OnPreparedListener;
import android.media.MediaPlayer$OnErrorListener;
import android.media.MediaPlayer$OnCompletionListener;
import android.app.Activity;

public class AdMarvelVideoActivity extends Activity implements MediaPlayer$OnCompletionListener, MediaPlayer$OnErrorListener, MediaPlayer$OnPreparedListener, j$a
{
    static int a;
    static int b;
    static int c;
    private static Activity l;
    private boolean A;
    private boolean B;
    private boolean C;
    private RelativeLayout D;
    private long E;
    private boolean F;
    private boolean G;
    private boolean H;
    private boolean I;
    private String J;
    private ImageView K;
    private j L;
    private WeakReference M;
    private Handler N;
    private r O;
    private String P;
    private Map Q;
    private List R;
    private List S;
    private TextView T;
    private LinearLayout U;
    private AdMarvelVideoActivity$i V;
    private AdMarvelVideoActivity$i W;
    private AdMarvelVideoActivity$i X;
    private AdMarvelVideoActivity$i Y;
    private AdMarvelVideoActivity$i Z;
    private long aa;
    private boolean ab;
    private BroadcastReceiver ac;
    private int ad;
    private Runnable ae;
    private Runnable af;
    private Runnable ag;
    private Runnable ah;
    private Runnable ai;
    private View$OnTouchListener aj;
    private View$OnTouchListener ak;
    public boolean d;
    AdMarvelXMLReader e;
    AdMarvelXMLElement f;
    LinearLayout g;
    WeakReference h;
    public AdMarvelVideoActivity$k i;
    public AdMarvelVideoActivity$m j;
    public int k;
    private WeakReference m;
    private AdMarvelAd n;
    private RelativeLayout o;
    private String p;
    private boolean q;
    private boolean r;
    private boolean s;
    private boolean t;
    private boolean u;
    private boolean v;
    private int w;
    private String x;
    private String y;
    private boolean z;
    
    static {
        AdMarvelVideoActivity.a = 103444;
        AdMarvelVideoActivity.b = 123124;
        AdMarvelVideoActivity.c = 23232;
    }
    
    public AdMarvelVideoActivity() {
        this.q = false;
        this.s = false;
        this.t = false;
        this.u = true;
        this.v = false;
        this.w = -1;
        this.z = false;
        this.A = false;
        this.B = false;
        this.C = false;
        this.D = null;
        this.F = false;
        this.G = false;
        this.H = false;
        this.I = false;
        this.d = false;
        this.j = AdMarvelVideoActivity$m.c;
        this.T = null;
        this.U = null;
        this.k = -1;
        this.ab = false;
        this.ad = 0;
        this.ae = new Runnable() {
            @Override
            public void run() {
                if (AdMarvelVideoActivity.this.L != null && !AdMarvelVideoActivity.this.A) {
                    int n;
                    if (AdMarvelVideoActivity.this.L.getCurrentPosition() == 0) {
                        n = AdMarvelVideoActivity.this.L.f();
                    }
                    else {
                        n = AdMarvelVideoActivity.this.L.getCurrentPosition();
                    }
                    AdMarvelVideoActivity.this.a(AdMarvelVideoActivity.this.k - AdMarvelVideoActivity.this.a((long)n), AdMarvelVideoActivity.this.T);
                    AdMarvelVideoActivity.this.a(AdMarvelVideoActivity.this.a((long)AdMarvelVideoActivity.this.L.getCurrentPosition()));
                    if (!AdMarvelVideoActivity.this.q) {
                        AdMarvelVideoActivity.this.g();
                        AdMarvelVideoActivity.this.q = true;
                    }
                }
            }
        };
        this.af = new Runnable() {
            @Override
            public void run() {
                while (true) {
                    while (true) {
                        int n = 0;
                        Label_0249: {
                            try {
                                if (AdMarvelVideoActivity.this.M != null) {
                                    final s s = (s)AdMarvelVideoActivity.this.M.get();
                                    if (s != null && s instanceof LinearLayout) {
                                        if (s != null && AdMarvelVideoActivity.this.s) {
                                            n = 0;
                                            if (n < s.getChildCount()) {
                                                if (!(s.getChildAt(n) instanceof s$d)) {
                                                    break Label_0249;
                                                }
                                                final s$d s$d = (s$d)s.getChildAt(n);
                                                if (s$d == null || !s$d.c.equalsIgnoreCase("done")) {
                                                    break Label_0249;
                                                }
                                                s$d.setClickable(true);
                                                s$d.setEnabled(true);
                                                if (!(s$d.getChildAt(0) instanceof ImageView)) {
                                                    break Label_0249;
                                                }
                                                if (AdMarvelVideoActivity.this.Z != null && AdMarvelVideoActivity.this.Z.c()) {
                                                    AdMarvelVideoActivity.this.Z.b();
                                                }
                                                final ImageView imageView = (ImageView)s$d.getChildAt(0);
                                                if (imageView.getDrawable() != null) {
                                                    imageView.getDrawable().setAlpha(255);
                                                    imageView.invalidate();
                                                }
                                                break Label_0249;
                                            }
                                        }
                                        AdMarvelVideoActivity.this.v = false;
                                        if (AdMarvelVideoActivity.this.X != null) {
                                            AdMarvelVideoActivity.this.X.b();
                                            AdMarvelVideoActivity.this.C = false;
                                            AdMarvelVideoActivity.this.D.setVisibility(8);
                                            AdMarvelVideoActivity.this.o();
                                        }
                                    }
                                }
                                return;
                            }
                            catch (Exception ex) {
                                Logging.log(Log.getStackTraceString((Throwable)ex));
                                return;
                            }
                        }
                        ++n;
                        continue;
                    }
                }
            }
        };
        this.ag = new Runnable() {
            @Override
            public void run() {
                try {
                    final AdMarvelVideoActivity$b adMarvelVideoActivity$b = (AdMarvelVideoActivity$b)AdMarvelVideoActivity.this.h.get();
                    if (adMarvelVideoActivity$b != null) {
                        adMarvelVideoActivity$b.d();
                    }
                }
                catch (Exception ex) {
                    Logging.log(Log.getStackTraceString((Throwable)ex));
                }
            }
        };
        this.ah = new Runnable() {
            @Override
            public void run() {
                if (!AdMarvelVideoActivity.this.C || AdMarvelVideoActivity.this.D == null) {
                    return;
                }
                while (true) {
                    while (true) {
                        int n;
                        try {
                            AdMarvelVideoActivity.this.D.setVisibility(0);
                            n = AdMarvelVideoActivity.this.w - AdMarvelVideoActivity.this.a(System.currentTimeMillis() - AdMarvelVideoActivity.this.E);
                            if (AdMarvelVideoActivity.this.J != null && AdMarvelVideoActivity.this.J.length() > 0 && AdMarvelVideoActivity.this.J.contains("@seconds")) {
                                final String text = AdMarvelVideoActivity.this.J.replace("@seconds", String.valueOf(n));
                                ((TextView)AdMarvelVideoActivity.this.D.getChildAt(0)).setText((CharSequence)text);
                                return;
                            }
                        }
                        catch (Exception ex) {
                            Logging.log(Log.getStackTraceString((Throwable)ex));
                            return;
                        }
                        final String text = "You Can Skip Ad in " + n + " seconds";
                        continue;
                    }
                }
            }
        };
        this.ai = new Runnable() {
            @Override
            public void run() {
                final LinearLayout linearLayout = (LinearLayout)AdMarvelVideoActivity.this.findViewById(AdMarvelVideoActivity.b);
                if (AdMarvelVideoActivity.this.s && linearLayout != null && linearLayout.getVisibility() == 0 && System.currentTimeMillis() - AdMarvelVideoActivity.this.aa >= 3000L) {
                    AdMarvelVideoActivity.this.b(false);
                }
                AdMarvelVideoActivity.this.Y.b();
            }
        };
        this.aj = (View$OnTouchListener)new View$OnTouchListener() {
            public boolean onTouch(final View view, final MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    AdMarvelVideoActivity.this.onUserInteraction();
                }
                return false;
            }
        };
        this.ak = (View$OnTouchListener)new View$OnTouchListener() {
            public boolean onTouch(final View view, final MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    final LinearLayout linearLayout = (LinearLayout)AdMarvelVideoActivity.this.findViewById(AdMarvelVideoActivity.b);
                    if (AdMarvelVideoActivity.this.s && linearLayout != null && AdMarvelVideoActivity.this.u && AdMarvelVideoActivity.this.i != AdMarvelVideoActivity$k.d && AdMarvelVideoActivity.this.i != AdMarvelVideoActivity$k.e) {
                        AdMarvelVideoActivity.this.onUserInteraction();
                    }
                }
                return false;
            }
        };
    }
    
    private int a(final long n) {
        return (int)n / 1000;
    }
    
    private void a(final int n) {
        if (this.R != null && this.O != null) {
            while (this.R.size() > 0) {
                final int a = this.R.get(0).a;
                if (n != a) {
                    break;
                }
                if (n != a) {
                    continue;
                }
                final List b = this.R.get(0).b;
                if (b == null) {
                    break;
                }
                final Iterator iterator = b.iterator();
                while (iterator.hasNext()) {
                    this.O.b((String)iterator.next());
                }
                this.R.remove(0);
            }
        }
    }
    
    private void a(final int n, final TextView textView) {
        final int n2 = n / 60;
        final int n3 = n % 60;
        String string;
        if (n == 0) {
            string = " 00:00";
        }
        else {
            final StringBuilder sb = new StringBuilder("-");
            Serializable s;
            if (n2 < 10) {
                s = "0" + n2;
            }
            else {
                s = n2;
            }
            final StringBuilder append = sb.append(s).append(":");
            Serializable s2;
            if (n3 < 10) {
                s2 = "0" + n3;
            }
            else {
                s2 = n3;
            }
            string = append.append(s2).toString();
        }
        if (textView != null) {
            if (textView.getVisibility() != 0 || this.U.getVisibility() != 0) {
                textView.setVisibility(0);
                this.U.setVisibility(0);
            }
            textView.setText((CharSequence)string);
        }
    }
    
    private void a(final LinearLayout linearLayout, final boolean b) {
        final AlphaAnimation animation = new AlphaAnimation(0.0f, 1.0f);
        ((Animation)animation).setInterpolator((Interpolator)new DecelerateInterpolator());
        ((Animation)animation).setDuration(800L);
        final AlphaAnimation animation2 = new AlphaAnimation(1.0f, 0.0f);
        ((Animation)animation2).setInterpolator((Interpolator)new AccelerateInterpolator());
        ((Animation)animation2).setDuration(500L);
        if (b) {
            linearLayout.setAnimation((Animation)animation);
            return;
        }
        linearLayout.setAnimation((Animation)animation2);
    }
    
    private void a(final RelativeLayout relativeLayout) {
        this.D = new RelativeLayout((Context)this);
        final RelativeLayout$LayoutParams layoutParams = new RelativeLayout$LayoutParams(-2, -2);
        layoutParams.addRule(10);
        layoutParams.addRule(11);
        this.D.setLayoutParams((ViewGroup$LayoutParams)layoutParams);
        this.D.setBackgroundColor(0);
        final TextView textView = new TextView((Context)this);
        final RelativeLayout$LayoutParams layoutParams2 = new RelativeLayout$LayoutParams(-2, -2);
        layoutParams2.addRule(11);
        textView.setLayoutParams((ViewGroup$LayoutParams)layoutParams2);
        textView.setTypeface(Typeface.DEFAULT_BOLD);
        this.D.addView((View)textView);
        this.D.setVisibility(4);
        relativeLayout.addView((View)this.D);
    }
    
    private void a(final AdMarvelXMLElement adMarvelXMLElement, final AdMarvelVideoActivity$l adMarvelVideoActivity$l) {
        if (this.Q != null && adMarvelXMLElement != null && adMarvelXMLElement.getChildren().containsKey("pixel")) {
            final ArrayList list = adMarvelXMLElement.getChildren().get("pixel");
            final ArrayList list2 = new ArrayList();
            list2.clear();
            for (int i = 0; i < list.size(); ++i) {
                list2.add(((AdMarvelXMLElement)list.get(i)).getData());
            }
            this.Q.put(adMarvelVideoActivity$l, list2);
        }
    }
    
    private void b(final RelativeLayout relativeLayout) {
        this.K = new ImageView((Context)this);
        final RelativeLayout$LayoutParams layoutParams = new RelativeLayout$LayoutParams(-1, -1);
        layoutParams.addRule(13);
        this.K.setLayoutParams((ViewGroup$LayoutParams)layoutParams);
        if (Version.getAndroidSDKVersion() >= 11) {
            this.N.post((Runnable)new AdMarvelVideoActivity$d(this, this.K, this.y));
        }
        else {
            new AdMarvelVideoActivity$c(this, this.K).execute((Object[])new String[] { this.y });
        }
        if (this.S != null && this.S.size() > 0 && !this.S.contains(AdMarvelVideoActivity$k.a)) {
            this.K.setVisibility(4);
        }
        else {
            this.K.setVisibility(0);
        }
        relativeLayout.addView((View)this.K);
    }
    
    private LinearLayout e(final String s) {
        final LinearLayout linearLayout = new LinearLayout((Context)this);
        linearLayout.setId(AdMarvelVideoActivity.b);
        linearLayout.setGravity(80);
        final s s2 = new s(this.L, this, (Context)this, s, this.P);
        this.M = new WeakReference(s2);
        linearLayout.addView((View)s2);
        final RelativeLayout$LayoutParams layoutParams = new RelativeLayout$LayoutParams(-1, -2);
        layoutParams.addRule(12);
        linearLayout.setLayoutParams((ViewGroup$LayoutParams)layoutParams);
        return linearLayout;
    }
    
    private String f(String d) {
        if (d == null || d.length() <= 0) {
            return null;
        }
        final AdMarvelVideoActivity$j adMarvelVideoActivity$j = new AdMarvelVideoActivity$j(this);
        final StringBuffer sb = new StringBuffer();
        sb.append("<videoTrackingEvents>");
        adMarvelVideoActivity$j.a(d);
        final Iterator iterator = adMarvelVideoActivity$j.a().iterator();
        d = null;
        String s = null;
        String s2 = null;
        String s3 = null;
        String s4 = null;
        List b = null;
        while (iterator.hasNext()) {
            final AdMarvelVideoActivity$j$a adMarvelVideoActivity$j$a = (AdMarvelVideoActivity$j$a)iterator.next();
            if ("xml".equalsIgnoreCase(adMarvelVideoActivity$j$a.a)) {
                return (String)adMarvelVideoActivity$j$a.b.get(0);
            }
            if ("video".equalsIgnoreCase(adMarvelVideoActivity$j$a.a)) {
                d = this.d((String)adMarvelVideoActivity$j$a.b.get(0));
            }
            else if ("duration".equalsIgnoreCase(adMarvelVideoActivity$j$a.a)) {
                s = (String)adMarvelVideoActivity$j$a.b.get(0);
            }
            else if ("poster".equalsIgnoreCase(adMarvelVideoActivity$j$a.a)) {
                s3 = (String)adMarvelVideoActivity$j$a.b.get(0);
            }
            else if ("force_quit".equalsIgnoreCase(adMarvelVideoActivity$j$a.a)) {
                s2 = (String)adMarvelVideoActivity$j$a.b.get(0);
            }
            else if ("open_url".equalsIgnoreCase(adMarvelVideoActivity$j$a.a)) {
                s4 = (String)adMarvelVideoActivity$j$a.b.get(0);
            }
            else {
                if (!adMarvelVideoActivity$j$a.a.startsWith("track_")) {
                    continue;
                }
                if (adMarvelVideoActivity$j$a.a.startsWith("track_pr_")) {
                    sb.append("<videoTracking event=\"progress\" offset=\"" + adMarvelVideoActivity$j$a.a.replaceFirst("track_pr_", "") + "\"><pixels>");
                    for (final String s5 : adMarvelVideoActivity$j$a.b) {
                        if (s5 != null && s5.length() > 0) {
                            sb.append("<pixel>" + s5 + "</pixel>");
                        }
                    }
                    sb.append("</pixels></videoTracking>");
                }
                else if ("track_open_url".equalsIgnoreCase(adMarvelVideoActivity$j$a.a)) {
                    new ArrayList();
                    b = adMarvelVideoActivity$j$a.b;
                }
                else {
                    sb.append("<videoTracking event=\"" + adMarvelVideoActivity$j$a.a.replaceFirst("track_", "") + "\" ><pixels>");
                    for (final String s6 : adMarvelVideoActivity$j$a.b) {
                        if (s6 != null && s6.length() > 0) {
                            sb.append("<pixel>" + s6 + "</pixel>");
                        }
                    }
                    sb.append("</pixels></videoTracking>");
                }
            }
        }
        sb.append("</videoTrackingEvents>");
        String string;
        if (s3 != null && s3.length() > 0) {
            string = "<loadingimage>" + s3 + "</loadingimage>";
        }
        else {
            string = "";
        }
        String s8;
        if (s4 != null && s4.length() > 0) {
            final StringBuffer sb2 = new StringBuffer();
            if (b != null && b.size() > 0) {
                sb2.append("<clickTracking><pixels>");
                for (final String s7 : b) {
                    if (s7 != null && s7.length() > 0) {
                        sb2.append("<pixel>" + s7 + "</pixel>");
                    }
                }
                sb2.append("</pixels></clickTracking>");
            }
            if (sb2.length() > 0) {
                s8 = String.format("<toolbar > <item type=\"SystemItem\" ><action type=\"done\"/></item> <item type=\"Toggle\"> <subitem type=\"SystemItem\" > <action type=\"pause\"/> </subitem> <subitem type=\"SystemItem\" > <action type=\"resume\"/> </subitem> </item> <item type=\"SystemItem\" >%s<action type=\"open_url\">%s</action></item> <item type=\"SystemItem\" subtype=\"UIBarButtonSystemItemFlexibleSpace\"  /> <item type=\"SystemItem\" subtype=\"UIBarButtonSystemItemFlexibleSpace\"  /> <item type=\"SystemItem\" subtype=\"UIBarButtonSystemItemFlexibleSpace\"  /> <item type=\"Timer\"/> </toolbar>", sb2.toString(), s4);
            }
            else {
                s8 = String.format("<toolbar > <item type=\"SystemItem\" ><action type=\"done\"/></item> <item type=\"Toggle\"> <subitem type=\"SystemItem\" > <action type=\"pause\"/> </subitem> <subitem type=\"SystemItem\" > <action type=\"resume\"/> </subitem> </item> <item type=\"SystemItem\" >%s<action type=\"open_url\">%s</action></item> <item type=\"SystemItem\" subtype=\"UIBarButtonSystemItemFlexibleSpace\"  /> <item type=\"SystemItem\" subtype=\"UIBarButtonSystemItemFlexibleSpace\"  /> <item type=\"SystemItem\" subtype=\"UIBarButtonSystemItemFlexibleSpace\"  /> <item type=\"Timer\"/> </toolbar>", "", s4);
            }
        }
        else {
            s8 = "<toolbar > <item type=\"SystemItem\" ><action type=\"done\"/></item> <item type=\"Toggle\"> <subitem type=\"SystemItem\" > <action type=\"pause\"/> </subitem> <subitem type=\"SystemItem\" > <action type=\"resume\"/> </subitem> </item> <item type=\"SystemItem\" subtype=\"UIBarButtonSystemItemFlexibleSpace\"  /> <item type=\"SystemItem\" subtype=\"UIBarButtonSystemItemFlexibleSpace\"  /> <item type=\"SystemItem\" subtype=\"UIBarButtonSystemItemFlexibleSpace\"  /> <item type=\"SystemItem\" subtype=\"UIBarButtonSystemItemFlexibleSpace\"  /> <item type=\"Timer\"/> </toolbar>";
        }
        if (s == null) {
            s = "";
        }
        if (s2 == null) {
            s2 = "NO";
        }
        if (d == null) {
            d = "";
        }
        return String.format("<customad type=\"video\"><video duration=\"%s\" forcequit=\"%s\">%s</video>%s%s%s</customad>", s, s2, d, string, s8, sb.toString());
    }
    
    private void o() {
        if (this.o != null) {
            this.o.setVisibility(0);
        }
    }
    
    private void p() {
        if (this.o != null) {
            this.o.setVisibility(8);
        }
    }
    
    private boolean q() {
        boolean b2;
        final boolean b = b2 = false;
        if (this.M != null) {
            final s s = (s)this.M.get();
            b2 = b;
            if (s != null) {
                b2 = b;
                if (s instanceof LinearLayout) {
                    int n = 0;
                    while (true) {
                        b2 = b;
                        if (n >= s.getChildCount()) {
                            return b2;
                        }
                        if (s.getChildAt(n) instanceof ViewSwitcher) {
                            final ViewSwitcher viewSwitcher = (ViewSwitcher)s.getChildAt(n);
                            final s$d s$d = (s$d)viewSwitcher.getCurrentView();
                            final s$d s$d2 = (s$d)viewSwitcher.getNextView();
                            if ((s$d != null && s$d.c.equalsIgnoreCase("unmute")) || (s$d2 != null && s$d2.c.equalsIgnoreCase("unmute"))) {
                                b2 = true;
                                return b2;
                            }
                        }
                        else if (s.getChildAt(n) instanceof s$d) {
                            final s$d s$d3 = (s$d)s.getChildAt(n);
                            if (s$d3 != null && s$d3.c.equalsIgnoreCase("unmute")) {
                                break;
                            }
                        }
                        ++n;
                    }
                    return true;
                }
            }
        }
        return b2;
    }
    
    private void r() {
        if (this.M != null) {
            final s s = (s)this.M.get();
            if (s != null && s instanceof LinearLayout) {
                for (int i = 0; i < s.getChildCount(); ++i) {
                    if (s.getChildAt(i) instanceof ViewSwitcher) {
                        final ViewSwitcher viewSwitcher = (ViewSwitcher)s.getChildAt(i);
                        final s$d s$d = (s$d)viewSwitcher.getCurrentView();
                        final s$d s$d2 = (s$d)viewSwitcher.getNextView();
                        if (s$d != null && s$d.c.equalsIgnoreCase("mute") && s$d2 != null && s$d2.c.equalsIgnoreCase("unmute")) {
                            viewSwitcher.showNext();
                        }
                    }
                }
            }
        }
    }
    
    private void s() {
        if (this.W != null) {
            this.W.b();
        }
        if (this.V != null) {
            this.V.b();
        }
        if (this.Y != null) {
            this.Y.b();
        }
        if (this.X != null) {
            this.X.b();
        }
    }
    
    public Handler a() {
        return this.N;
    }
    
    public void a(final AdMarvelVideoActivity$l adMarvelVideoActivity$l) {
        if (this.Q != null) {
            final List list = this.Q.get(adMarvelVideoActivity$l);
            if (list != null && this.O != null) {
                final Iterator iterator = list.iterator();
                while (iterator.hasNext()) {
                    this.O.b((String)iterator.next());
                }
                if (adMarvelVideoActivity$l == AdMarvelVideoActivity$l.a || adMarvelVideoActivity$l == AdMarvelVideoActivity$l.b) {
                    this.Q.remove(adMarvelVideoActivity$l);
                }
            }
        }
    }
    
    public void a(final j j) {
        if (j.getVisibility() != 0) {
            j.setVisibility(0);
        }
        if (this.z && this.K != null && this.K.getVisibility() == 0) {
            this.K.setVisibility(4);
        }
        if (this.k > 0 && !this.A) {
            final LinearLayout linearLayout = (LinearLayout)this.findViewById(AdMarvelVideoActivity.b);
            if (linearLayout != null && this.s && this.T == null) {
                this.U = (LinearLayout)linearLayout.findViewWithTag((Object)(this.P + "TIMER_BUTTON_LAYOUT"));
                if (this.U != null) {
                    this.T = (TextView)this.U.getChildAt(0);
                }
            }
            if (this.R != null && this.R.size() > 0) {
                Collections.sort((List<Object>)this.R, new Comparator() {
                    public int a(final AdMarvelVideoActivity$g adMarvelVideoActivity$g, final AdMarvelVideoActivity$g adMarvelVideoActivity$g2) {
                        return adMarvelVideoActivity$g.a - adMarvelVideoActivity$g2.a;
                    }
                });
            }
            if (this.W == null) {
                (this.W = new AdMarvelVideoActivity$i(this.N, this.ae, 500)).a();
            }
            else if (!this.W.c()) {
                this.W.a();
            }
        }
        j.start();
        this.i = AdMarvelVideoActivity$k.b;
    }
    
    public void a(final String message) {
        if (this.h == null) {
            final AdMarvelVideoActivity$b adMarvelVideoActivity$b = new AdMarvelVideoActivity$b((Context)this, this);
            adMarvelVideoActivity$b.setMessage(message);
            adMarvelVideoActivity$b.b();
            this.h = new WeakReference(adMarvelVideoActivity$b);
            adMarvelVideoActivity$b.setTag((Object)"ADM__VIDEO_DIALOG");
            this.addContentView((View)adMarvelVideoActivity$b, adMarvelVideoActivity$b.getLayoutParams());
            return;
        }
        final AdMarvelVideoActivity$b adMarvelVideoActivity$b2 = (AdMarvelVideoActivity$b)this.h.get();
        if (adMarvelVideoActivity$b2 != null) {
            adMarvelVideoActivity$b2.setMessage(message);
            adMarvelVideoActivity$b2.b();
            return;
        }
        final AdMarvelVideoActivity$b adMarvelVideoActivity$b3 = new AdMarvelVideoActivity$b((Context)this, this);
        adMarvelVideoActivity$b3.setMessage(message);
        adMarvelVideoActivity$b3.b();
        this.h.clear();
        this.h = new WeakReference(adMarvelVideoActivity$b3);
    }
    
    public void a(final List list) {
        if (list != null && this.O != null) {
            final Iterator iterator = list.iterator();
            while (iterator.hasNext()) {
                this.O.b((String)iterator.next());
            }
        }
    }
    
    public void a(final boolean b) {
        if (this.L == null || this.i != AdMarvelVideoActivity$k.b) {
            return;
        }
        this.L.pause();
        if (b) {
            this.i = AdMarvelVideoActivity$k.f;
            return;
        }
        this.i = AdMarvelVideoActivity$k.c;
    }
    
    public void b(String j) {
        (this.e = new AdMarvelXMLReader()).parseXMLString(j);
        this.f = this.e.getParsedXMLData();
        if (this.f.getChildren().containsKey("video")) {
            final AdMarvelXMLElement adMarvelXMLElement = this.f.getChildren().get("video").get(0);
            if (adMarvelXMLElement != null) {
                this.x = this.d(adMarvelXMLElement.getData());
                final String s = adMarvelXMLElement.getAttributes().get("forcequit");
                if (s != null && s.equalsIgnoreCase("YES")) {
                    this.B = true;
                }
                final String s2 = adMarvelXMLElement.getAttributes().get("duration");
                if (s2 != null && Integer.parseInt(s2) > 0) {
                    this.k = Integer.parseInt(s2);
                }
                final String s3 = adMarvelXMLElement.getAttributes().get("lockOrientation");
                if (s3 != null) {
                    if (s3.equalsIgnoreCase("LandscapeLeft")) {
                        this.setRequestedOrientation(0);
                    }
                    else if (s3.equalsIgnoreCase("Portrait")) {
                        this.setRequestedOrientation(1);
                    }
                    else if (Version.getAndroidSDKVersion() >= 11) {
                        com.admarvel.android.ads.q.a(this, s3);
                    }
                }
                final String s4 = adMarvelXMLElement.getAttributes().get("initialMute");
                if (s4 != null && s4.equalsIgnoreCase("YES")) {
                    this.ab = true;
                }
                final String s5 = adMarvelXMLElement.getAttributes().get("enableVideoPlayOnScreenLock");
                if (s5 != null && s5.equalsIgnoreCase("YES")) {
                    this.H = true;
                }
                j = (String)adMarvelXMLElement.getAttributes().get("quitVideoInBackground");
                if (j != null && j.equalsIgnoreCase("YES")) {
                    this.I = true;
                }
            }
        }
        if (this.f.getChildren().containsKey("loadingimage")) {
            final AdMarvelXMLElement adMarvelXMLElement2 = this.f.getChildren().get("loadingimage").get(0);
            if (adMarvelXMLElement2 != null) {
                this.y = adMarvelXMLElement2.getData();
                this.z = true;
                j = (String)adMarvelXMLElement2.getAttributes().get("displayEvent");
                if (j != null) {
                    final String[] split = j.split(",");
                    if (split != null && split.length > 0) {
                        this.S = new ArrayList();
                        for (int i = 0; i < split.length; ++i) {
                            if (split[i].equalsIgnoreCase("loading")) {
                                this.S.add(AdMarvelVideoActivity$k.a);
                            }
                            else if (split[i].equalsIgnoreCase("complete")) {
                                this.S.add(AdMarvelVideoActivity$k.d);
                                this.S.add(AdMarvelVideoActivity$k.e);
                            }
                        }
                    }
                }
            }
        }
        if (this.f.getChildren().containsKey("toolbar")) {
            final AdMarvelXMLElement adMarvelXMLElement3 = this.f.getChildren().get("toolbar").get(0);
            if (adMarvelXMLElement3 == null) {
                j = null;
            }
            else {
                j = (String)adMarvelXMLElement3.getAttributes().get("initiallyVisible");
            }
            if (j != null && j.equalsIgnoreCase("YES")) {
                this.t = true;
            }
            if (adMarvelXMLElement3 == null) {
                j = null;
            }
            else {
                j = (String)adMarvelXMLElement3.getAttributes().get("toggleToolbar");
            }
            if (j != null && j.equalsIgnoreCase("NO")) {
                this.u = false;
            }
            if (adMarvelXMLElement3 == null) {
                j = null;
            }
            else {
                j = (String)adMarvelXMLElement3.getAttributes().get("delayDisplayDoneButton");
            }
            if (j != null) {
                this.v = true;
                this.C = true;
                this.w = Integer.parseInt(j);
                j = (String)adMarvelXMLElement3.getAttributes().get("showSkipMessage");
                if (j != null && j.equalsIgnoreCase("NO")) {
                    this.C = false;
                }
                j = (String)adMarvelXMLElement3.getAttributes().get("skipText");
                if (j != null && j.length() > 0 && j.contains("@seconds")) {
                    this.J = j;
                }
            }
            if (adMarvelXMLElement3 != null && adMarvelXMLElement3.getChildren().containsKey("item") && ((ArrayList)adMarvelXMLElement3.getChildren().get("item")).size() > 0) {
                this.s = true;
            }
        }
        if (this.f.getChildren().containsKey("videoTrackingEvents")) {
            this.R = new ArrayList();
            this.Q = new HashMap();
            final AdMarvelXMLElement adMarvelXMLElement4 = this.f.getChildren().get("videoTrackingEvents").get(0);
            if (adMarvelXMLElement4 != null && adMarvelXMLElement4.getChildren().containsKey("videoTracking")) {
                final ArrayList list = adMarvelXMLElement4.getChildren().get("videoTracking");
                for (int k = 0; k < list.size(); ++k) {
                    final AdMarvelXMLElement adMarvelXMLElement5 = (AdMarvelXMLElement)list.get(k);
                    final String s6 = adMarvelXMLElement5.getAttributes().get("event");
                    if ("progress".equalsIgnoreCase(s6)) {
                        final String s7 = adMarvelXMLElement5.getAttributes().get("offset");
                        if (s7 != null) {
                            int int1;
                            if (s7.endsWith("%")) {
                                int1 = Integer.parseInt(s7.replace("%", "")) * this.k / 100;
                            }
                            else {
                                int1 = Integer.parseInt(s7);
                            }
                            final AdMarvelXMLElement adMarvelXMLElement6 = adMarvelXMLElement5.getChildren().get("pixels").get(0);
                            if (adMarvelXMLElement6 != null && adMarvelXMLElement6.getChildren().containsKey("pixel")) {
                                final ArrayList list2 = adMarvelXMLElement6.getChildren().get("pixel");
                                final ArrayList list3 = new ArrayList();
                                list3.clear();
                                for (int l = 0; l < list2.size(); ++l) {
                                    list3.add(((AdMarvelXMLElement)list2.get(l)).getData());
                                }
                                this.R.add(new AdMarvelVideoActivity$g(this, int1, list3));
                            }
                        }
                    }
                    else if ("firstQuartile".equalsIgnoreCase(s6) && this.k > 0) {
                        final int n = this.k / 4;
                        if (n > 0) {
                            final AdMarvelXMLElement adMarvelXMLElement7 = adMarvelXMLElement5.getChildren().get("pixels").get(0);
                            if (adMarvelXMLElement7 != null && adMarvelXMLElement7.getChildren().containsKey("pixel")) {
                                final ArrayList list4 = adMarvelXMLElement7.getChildren().get("pixel");
                                final ArrayList list5 = new ArrayList();
                                list5.clear();
                                for (int n2 = 0; n2 < list4.size(); ++n2) {
                                    list5.add(((AdMarvelXMLElement)list4.get(n2)).getData());
                                }
                                this.R.add(new AdMarvelVideoActivity$g(this, n, list5));
                            }
                        }
                    }
                    else if ("midpoint".equalsIgnoreCase(s6) && this.k > 0) {
                        final int n3 = this.k / 2;
                        if (n3 > 0) {
                            final AdMarvelXMLElement adMarvelXMLElement8 = adMarvelXMLElement5.getChildren().get("pixels").get(0);
                            if (adMarvelXMLElement8 != null && adMarvelXMLElement8.getChildren().containsKey("pixel")) {
                                final ArrayList list6 = adMarvelXMLElement8.getChildren().get("pixel");
                                final ArrayList list7 = new ArrayList();
                                list7.clear();
                                for (int n4 = 0; n4 < list6.size(); ++n4) {
                                    list7.add(((AdMarvelXMLElement)list6.get(n4)).getData());
                                }
                                this.R.add(new AdMarvelVideoActivity$g(this, n3, list7));
                            }
                        }
                    }
                    else if ("thirdQuartile".equalsIgnoreCase(s6) && this.k > 0) {
                        final int n5 = this.k / 4 * 3;
                        if (n5 > 0) {
                            final AdMarvelXMLElement adMarvelXMLElement9 = adMarvelXMLElement5.getChildren().get("pixels").get(0);
                            if (adMarvelXMLElement9 != null && adMarvelXMLElement9.getChildren().containsKey("pixel")) {
                                final ArrayList list8 = adMarvelXMLElement9.getChildren().get("pixel");
                                final ArrayList list9 = new ArrayList();
                                list9.clear();
                                for (int n6 = 0; n6 < list8.size(); ++n6) {
                                    list9.add(((AdMarvelXMLElement)list8.get(n6)).getData());
                                }
                                this.R.add(new AdMarvelVideoActivity$g(this, n5, list9));
                            }
                        }
                    }
                    else if ("start".equalsIgnoreCase(s6)) {
                        this.a(((ArrayList<AdMarvelXMLElement>)adMarvelXMLElement5.getChildren().get("pixels")).get(0), AdMarvelVideoActivity$l.a);
                    }
                    else if ("complete".equalsIgnoreCase(s6)) {
                        this.a(((ArrayList<AdMarvelXMLElement>)adMarvelXMLElement5.getChildren().get("pixels")).get(0), AdMarvelVideoActivity$l.b);
                    }
                    else if ("pause".equalsIgnoreCase(s6)) {
                        this.a(((ArrayList<AdMarvelXMLElement>)adMarvelXMLElement5.getChildren().get("pixels")).get(0), AdMarvelVideoActivity$l.c);
                    }
                    else if ("resume".equalsIgnoreCase(s6)) {
                        this.a(((ArrayList<AdMarvelXMLElement>)adMarvelXMLElement5.getChildren().get("pixels")).get(0), AdMarvelVideoActivity$l.d);
                    }
                    else if ("close".equalsIgnoreCase(s6)) {
                        this.a(((ArrayList<AdMarvelXMLElement>)adMarvelXMLElement5.getChildren().get("pixels")).get(0), AdMarvelVideoActivity$l.e);
                    }
                    else if ("stop".equalsIgnoreCase(s6)) {
                        this.a(((ArrayList<AdMarvelXMLElement>)adMarvelXMLElement5.getChildren().get("pixels")).get(0), AdMarvelVideoActivity$l.f);
                    }
                }
            }
        }
    }
    
    public void b(final boolean b) {
        final LinearLayout linearLayout = (LinearLayout)this.findViewById(AdMarvelVideoActivity.b);
        if (this.s && linearLayout != null) {
            if (linearLayout.getVisibility() != 0) {
                if (b) {
                    this.a(linearLayout, b);
                    linearLayout.setVisibility(0);
                    linearLayout.bringToFront();
                    linearLayout.requestLayout();
                    if (this.Y != null && !this.Y.c()) {
                        this.aa = System.currentTimeMillis();
                        this.Y.b();
                        this.Y.a();
                    }
                }
            }
            else if (!b) {
                this.a(linearLayout, b);
                linearLayout.setVisibility(4);
            }
        }
    }
    
    boolean b() {
        return this.r;
    }
    
    public void c() {
        this.s();
        this.a(AdMarvelVideoActivity$l.e);
        if (this.R != null && this.R.size() > 0) {
            this.R.clear();
        }
        if (this.Q != null && this.Q.size() > 0) {
            this.Q.clear();
        }
        if (this.b()) {
            if (AdMarvelInterstitialAds.getListener() != null) {
                AdMarvelInterstitialAds.getListener().b();
                ++this.ad;
            }
            if (this.ad <= 2) {
                this.finish();
                return;
            }
        }
        this.finish();
    }
    
    public void c(final String s) {
        if (this.L == null) {
            return;
        }
        if (this.L.isPlaying()) {
            this.L.a();
            this.i = AdMarvelVideoActivity$k.d;
        }
        if (this.L.getVisibility() != 0) {
            this.L.setVisibility(0);
            this.L.requestFocus();
        }
        if (this.z && this.K != null && (this.S == null || this.S.size() <= 0 || this.S.contains(AdMarvelVideoActivity$k.a))) {
            this.K.setVisibility(0);
        }
        if (this.R != null && this.R.size() > 0) {
            this.R.clear();
        }
        if (this.Q != null && this.Q.size() > 0) {
            final HashMap hashMap = new HashMap();
            hashMap.putAll(this.Q);
            for (final AdMarvelVideoActivity$l adMarvelVideoActivity$l : hashMap.keySet()) {
                if (adMarvelVideoActivity$l != AdMarvelVideoActivity$l.e) {
                    this.Q.remove(adMarvelVideoActivity$l);
                }
            }
        }
        this.a("Loading Next Video...");
        if (this.B) {
            this.B = false;
        }
        this.A = true;
        if (this.T != null) {
            this.T.setVisibility(4);
        }
        this.L.a(Uri.parse(s));
        this.L.requestFocus();
        this.i = AdMarvelVideoActivity$k.a;
    }
    
    public void c(final boolean b) {
        if (this.M != null) {
            final s s = (s)this.M.get();
            if (s != null && s instanceof LinearLayout) {
                for (int i = 0; i < s.getChildCount(); ++i) {
                    if (s.getChildAt(i) instanceof ViewSwitcher) {
                        final ViewSwitcher viewSwitcher = (ViewSwitcher)s.getChildAt(i);
                        final s$d s$d = (s$d)viewSwitcher.getCurrentView();
                        if (!b && s$d != null && s$d.c.equalsIgnoreCase("pause")) {
                            if (viewSwitcher.getDisplayedChild() == 0) {
                                viewSwitcher.showNext();
                            }
                            else {
                                viewSwitcher.showPrevious();
                            }
                        }
                        else if (!b && s$d != null && s$d.c.equalsIgnoreCase("stop")) {
                            if (viewSwitcher.getDisplayedChild() == 0) {
                                viewSwitcher.showNext();
                            }
                            else {
                                viewSwitcher.showPrevious();
                            }
                        }
                        else if (b && s$d != null && s$d.c.equalsIgnoreCase("replay")) {
                            if (viewSwitcher.getDisplayedChild() == 0) {
                                viewSwitcher.showNext();
                            }
                            else {
                                viewSwitcher.showPrevious();
                            }
                        }
                        else if (b && s$d != null && s$d.c.equalsIgnoreCase("resume")) {
                            if (viewSwitcher.getDisplayedChild() == 0) {
                                viewSwitcher.showNext();
                            }
                            else {
                                viewSwitcher.showPrevious();
                            }
                        }
                    }
                }
            }
        }
    }
    
    String d(final String s) {
        String s2 = s;
        if (s != null) {
            s2 = s;
            if (s.length() > 0) {
                String headerField = s;
                try {
                    while (true) {
                        final r r = new r((Context)this);
                        final HttpURLConnection httpURLConnection = (HttpURLConnection)new URL(headerField).openConnection();
                        httpURLConnection.setRequestMethod("GET");
                        httpURLConnection.setDoInput(true);
                        httpURLConnection.setUseCaches(false);
                        httpURLConnection.setRequestProperty("User-Agent", r.a());
                        httpURLConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
                        httpURLConnection.setRequestProperty("Content-Length", "0");
                        httpURLConnection.setConnectTimeout(4000);
                        httpURLConnection.setReadTimeout(5000);
                        httpURLConnection.setInstanceFollowRedirects(false);
                        httpURLConnection.connect();
                        final int responseCode = httpURLConnection.getResponseCode();
                        if (responseCode != 301 && responseCode != 302) {
                            break;
                        }
                        headerField = httpURLConnection.getHeaderField("Location");
                    }
                }
                catch (Exception ex) {}
                s2 = s;
                if (headerField != null) {
                    s2 = s;
                    if (headerField.length() > 0) {
                        s2 = headerField;
                    }
                }
            }
        }
        return s2;
    }
    
    public void d() {
        if (this.L == null) {
            return;
        }
        this.L.a();
        this.i = AdMarvelVideoActivity$k.d;
    }
    
    public void e() {
        if (this.L != null) {
            if (this.i == AdMarvelVideoActivity$k.f || this.i == AdMarvelVideoActivity$k.c) {
                this.a("Resuming Video...");
                this.L.e();
                this.i = AdMarvelVideoActivity$k.b;
                return;
            }
            if (this.i == AdMarvelVideoActivity$k.d || this.i == AdMarvelVideoActivity$k.e) {
                this.f();
            }
        }
    }
    
    public void f() {
        if (this.L != null && (this.i == AdMarvelVideoActivity$k.e || this.i == AdMarvelVideoActivity$k.d || this.i == AdMarvelVideoActivity$k.c || this.i == AdMarvelVideoActivity$k.f)) {
            if (this.i == AdMarvelVideoActivity$k.c || this.i == AdMarvelVideoActivity$k.f) {
                this.L.a();
                this.i = AdMarvelVideoActivity$k.d;
            }
            if (this.L.getVisibility() != 0) {
                this.L.setVisibility(0);
            }
            if (this.z && this.K != null && (this.S == null || this.S.size() <= 0 || this.S.contains(AdMarvelVideoActivity$k.a))) {
                this.K.setVisibility(0);
            }
            if (this.R != null && this.R.size() > 0) {
                this.R.clear();
            }
            if (this.Q != null && this.Q.size() > 0) {
                final HashMap hashMap = new HashMap();
                hashMap.putAll(this.Q);
                for (final AdMarvelVideoActivity$l adMarvelVideoActivity$l : hashMap.keySet()) {
                    if (adMarvelVideoActivity$l != AdMarvelVideoActivity$l.e) {
                        this.Q.remove(adMarvelVideoActivity$l);
                    }
                }
            }
            if (this.B) {
                this.B = false;
            }
            this.a("Replaying Video...");
            if (this.x != null && this.x.length() > 0) {
                this.L.a(Uri.parse(this.x));
                this.i = AdMarvelVideoActivity$k.a;
            }
            this.A = false;
            this.L.requestFocus();
        }
    }
    
    public void g() {
        this.N.postDelayed((Runnable)new AdMarvelVideoActivity$e(this.n, (Context)this), 3000L);
    }
    
    public void h() {
        this.a(AdMarvelVideoActivity$l.c);
    }
    
    public void i() {
        this.a(AdMarvelVideoActivity$l.f);
        if (this.W != null) {
            this.W.b();
        }
        if (this.Y != null) {
            this.Y.b();
        }
        if (this.z && this.K != null && (this.S == null || this.S.size() <= 0 || this.S.contains(AdMarvelVideoActivity$k.d))) {
            this.K.setVisibility(0);
        }
        if (this.L != null) {
            this.L.setVisibility(4);
        }
        final LinearLayout linearLayout = (LinearLayout)this.findViewById(AdMarvelVideoActivity.b);
        if (this.s && linearLayout != null && linearLayout.getVisibility() != 0) {
            this.a(linearLayout, true);
            linearLayout.setVisibility(0);
            linearLayout.bringToFront();
            linearLayout.requestLayout();
        }
        if (this.k > 0 && this.T != null && this.T.getVisibility() == 0) {
            this.a(0, this.T);
        }
        this.c(false);
    }
    
    public void j() {
        this.a(AdMarvelVideoActivity$l.d);
        this.i = AdMarvelVideoActivity$k.b;
    }
    
    public void k() {
        if (this.N != null) {
            this.N.post(this.ag);
        }
        if (this.W != null && !this.A && this.i != AdMarvelVideoActivity$k.e && this.i != AdMarvelVideoActivity$k.d) {
            this.W.a();
        }
        if (this.z && this.K != null && this.K.getVisibility() == 0) {
            this.K.setVisibility(4);
        }
    }
    
    public void l() {
        if (this.N != null) {
            this.N.post(this.ag);
        }
        Toast.makeText((Context)this, (CharSequence)"Network Connection Unavailable", 0).show();
    }
    
    public void m() {
        this.c();
    }
    
    public void n() {
    }
    
    public void onCompletion(final MediaPlayer mediaPlayer) {
        this.i = AdMarvelVideoActivity$k.e;
        this.a(AdMarvelVideoActivity$l.b);
        this.s();
        final LinearLayout linearLayout = (LinearLayout)this.findViewById(AdMarvelVideoActivity.b);
        Logging.log("Video onCompletion is called");
        if (this.z && this.K != null && (this.S == null || this.S.size() <= 0 || this.S.contains(AdMarvelVideoActivity$k.d))) {
            this.K.setVisibility(0);
        }
        if (this.L != null) {
            this.L.setVisibility(4);
        }
        if (this.s && linearLayout != null && linearLayout.getVisibility() != 0) {
            this.a(linearLayout, true);
            linearLayout.setVisibility(0);
            linearLayout.bringToFront();
            linearLayout.requestLayout();
        }
        if (this.k > 0 && this.T != null && this.T.getVisibility() == 0) {
            this.a(0, this.T);
        }
        this.c(false);
        while (true) {
            Label_0246: {
                if (this.M == null) {
                    break Label_0246;
                }
                final s s = (s)this.M.get();
                if (s == null) {
                    break Label_0246;
                }
                final int b = s.b() ? 1 : 0;
                if (!this.s || b == 0 || this.B) {
                    if (this.L != null) {
                        this.L.a(true);
                    }
                    this.c();
                }
                return;
            }
            final int b = 0;
            continue;
        }
    }
    
    protected void onCreate(final Bundle p0) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: aload_1        
        //     2: invokespecial   android/app/Activity.onCreate:(Landroid/os/Bundle;)V
        //     5: getstatic       com/admarvel/android/ads/AdMarvelVideoActivity.l:Landroid/app/Activity;
        //     8: ifnonnull       912
        //    11: aload_0        
        //    12: putstatic       com/admarvel/android/ads/AdMarvelVideoActivity.l:Landroid/app/Activity;
        //    15: getstatic       android/os/Build.MODEL:Ljava/lang/String;
        //    18: ldc_w           "Kindle"
        //    21: invokevirtual   java/lang/String.contains:(Ljava/lang/CharSequence;)Z
        //    24: ifne            39
        //    27: getstatic       android/os/Build.PRODUCT:Ljava/lang/String;
        //    30: ldc_w           "Kindle"
        //    33: invokevirtual   java/lang/String.contains:(Ljava/lang/CharSequence;)Z
        //    36: ifeq            925
        //    39: aload_0        
        //    40: invokevirtual   com/admarvel/android/ads/AdMarvelVideoActivity.getWindow:()Landroid/view/Window;
        //    43: sipush          256
        //    46: invokevirtual   android/view/Window.addFlags:(I)V
        //    49: aload_0        
        //    50: invokevirtual   com/admarvel/android/ads/AdMarvelVideoActivity.getWindow:()Landroid/view/Window;
        //    53: sipush          1024
        //    56: invokevirtual   android/view/Window.clearFlags:(I)V
        //    59: invokestatic    com/admarvel/android/ads/Version.getAndroidSDKVersion:()I
        //    62: bipush          11
        //    64: if_icmplt       71
        //    67: aload_0        
        //    68: invokestatic    com/admarvel/android/ads/AdMarvelVideoActivity$f.a:(Landroid/app/Activity;)V
        //    71: aload_0        
        //    72: invokevirtual   com/admarvel/android/ads/AdMarvelVideoActivity.getIntent:()Landroid/content/Intent;
        //    75: invokevirtual   android/content/Intent.getExtras:()Landroid/os/Bundle;
        //    78: astore_1       
        //    79: aload_1        
        //    80: ifnull          183
        //    83: aload_1        
        //    84: ldc_w           "serialized_admarvelad"
        //    87: invokevirtual   android/os/Bundle.getByteArray:(Ljava/lang/String;)[B
        //    90: astore_3       
        //    91: aload_3        
        //    92: ifnull          142
        //    95: aload_0        
        //    96: new             Ljava/io/ObjectInputStream;
        //    99: dup            
        //   100: new             Ljava/io/ByteArrayInputStream;
        //   103: dup            
        //   104: aload_3        
        //   105: invokespecial   java/io/ByteArrayInputStream.<init>:([B)V
        //   108: invokespecial   java/io/ObjectInputStream.<init>:(Ljava/io/InputStream;)V
        //   111: invokevirtual   java/io/ObjectInputStream.readObject:()Ljava/lang/Object;
        //   114: checkcast       Lcom/admarvel/android/ads/AdMarvelAd;
        //   117: putfield        com/admarvel/android/ads/AdMarvelVideoActivity.n:Lcom/admarvel/android/ads/AdMarvelAd;
        //   120: aload_0        
        //   121: getfield        com/admarvel/android/ads/AdMarvelVideoActivity.n:Lcom/admarvel/android/ads/AdMarvelAd;
        //   124: ifnull          142
        //   127: aload_0        
        //   128: new             Ljava/lang/ref/WeakReference;
        //   131: dup            
        //   132: aload_0        
        //   133: getfield        com/admarvel/android/ads/AdMarvelVideoActivity.n:Lcom/admarvel/android/ads/AdMarvelAd;
        //   136: invokespecial   java/lang/ref/WeakReference.<init>:(Ljava/lang/Object;)V
        //   139: putfield        com/admarvel/android/ads/AdMarvelVideoActivity.m:Ljava/lang/ref/WeakReference;
        //   142: aload_1        
        //   143: ldc_w           "isCustomUrl"
        //   146: invokevirtual   android/os/Bundle.getBoolean:(Ljava/lang/String;)Z
        //   149: ifeq            952
        //   152: aload_0        
        //   153: aload_0        
        //   154: aload_1        
        //   155: ldc_w           "url"
        //   158: invokevirtual   android/os/Bundle.getString:(Ljava/lang/String;)Ljava/lang/String;
        //   161: invokespecial   com/admarvel/android/ads/AdMarvelVideoActivity.f:(Ljava/lang/String;)Ljava/lang/String;
        //   164: putfield        com/admarvel/android/ads/AdMarvelVideoActivity.p:Ljava/lang/String;
        //   167: aload_0        
        //   168: aload_1        
        //   169: ldc_w           "GUID"
        //   172: invokevirtual   android/os/Bundle.getString:(Ljava/lang/String;)Ljava/lang/String;
        //   175: putfield        com/admarvel/android/ads/AdMarvelVideoActivity.P:Ljava/lang/String;
        //   178: aload_0        
        //   179: iconst_0       
        //   180: putfield        com/admarvel/android/ads/AdMarvelVideoActivity.r:Z
        //   183: aload_0        
        //   184: getstatic       com/admarvel/android/ads/AdMarvelVideoActivity$k.a:Lcom/admarvel/android/ads/AdMarvelVideoActivity$k;
        //   187: putfield        com/admarvel/android/ads/AdMarvelVideoActivity.i:Lcom/admarvel/android/ads/AdMarvelVideoActivity$k;
        //   190: new             Landroid/widget/RelativeLayout;
        //   193: dup            
        //   194: aload_0        
        //   195: invokespecial   android/widget/RelativeLayout.<init>:(Landroid/content/Context;)V
        //   198: astore_1       
        //   199: aload_1        
        //   200: getstatic       com/admarvel/android/ads/AdMarvelVideoActivity.a:I
        //   203: invokevirtual   android/widget/RelativeLayout.setId:(I)V
        //   206: aload_1        
        //   207: new             Landroid/view/ViewGroup$LayoutParams;
        //   210: dup            
        //   211: iconst_m1      
        //   212: iconst_m1      
        //   213: invokespecial   android/view/ViewGroup$LayoutParams.<init>:(II)V
        //   216: invokevirtual   android/widget/RelativeLayout.setLayoutParams:(Landroid/view/ViewGroup$LayoutParams;)V
        //   219: aload_0        
        //   220: aload_1        
        //   221: invokevirtual   com/admarvel/android/ads/AdMarvelVideoActivity.setContentView:(Landroid/view/View;)V
        //   224: new             Landroid/widget/LinearLayout;
        //   227: dup            
        //   228: aload_0        
        //   229: invokespecial   android/widget/LinearLayout.<init>:(Landroid/content/Context;)V
        //   232: astore_3       
        //   233: aload_3        
        //   234: getstatic       com/admarvel/android/ads/AdMarvelVideoActivity.c:I
        //   237: invokevirtual   android/widget/LinearLayout.setId:(I)V
        //   240: new             Landroid/widget/LinearLayout$LayoutParams;
        //   243: dup            
        //   244: iconst_m1      
        //   245: iconst_m1      
        //   246: invokespecial   android/widget/LinearLayout$LayoutParams.<init>:(II)V
        //   249: astore          4
        //   251: aload           4
        //   253: ldc_w           10.0
        //   256: putfield        android/widget/LinearLayout$LayoutParams.weight:F
        //   259: aload_3        
        //   260: aload           4
        //   262: invokevirtual   android/widget/LinearLayout.setLayoutParams:(Landroid/view/ViewGroup$LayoutParams;)V
        //   265: aload_3        
        //   266: aload_0        
        //   267: getfield        com/admarvel/android/ads/AdMarvelVideoActivity.ak:Landroid/view/View$OnTouchListener;
        //   270: invokevirtual   android/widget/LinearLayout.setOnTouchListener:(Landroid/view/View$OnTouchListener;)V
        //   273: aload_3        
        //   274: ldc_w           -16777216
        //   277: invokevirtual   android/widget/LinearLayout.setBackgroundColor:(I)V
        //   280: new             Landroid/widget/RelativeLayout;
        //   283: dup            
        //   284: aload_0        
        //   285: invokespecial   android/widget/RelativeLayout.<init>:(Landroid/content/Context;)V
        //   288: astore          4
        //   290: aload           4
        //   292: new             Landroid/widget/RelativeLayout$LayoutParams;
        //   295: dup            
        //   296: iconst_m1      
        //   297: iconst_m1      
        //   298: invokespecial   android/widget/RelativeLayout$LayoutParams.<init>:(II)V
        //   301: invokevirtual   android/widget/RelativeLayout.setLayoutParams:(Landroid/view/ViewGroup$LayoutParams;)V
        //   304: aload_3        
        //   305: aload           4
        //   307: invokevirtual   android/widget/LinearLayout.addView:(Landroid/view/View;)V
        //   310: new             Landroid/widget/RelativeLayout$LayoutParams;
        //   313: dup            
        //   314: iconst_m1      
        //   315: iconst_m1      
        //   316: invokespecial   android/widget/RelativeLayout$LayoutParams.<init>:(II)V
        //   319: astore          5
        //   321: aload           5
        //   323: bipush          13
        //   325: invokevirtual   android/widget/RelativeLayout$LayoutParams.addRule:(I)V
        //   328: aload_0        
        //   329: new             Lcom/admarvel/android/ads/j;
        //   332: dup            
        //   333: aload_0        
        //   334: aload_0        
        //   335: invokespecial   com/admarvel/android/ads/j.<init>:(Lcom/admarvel/android/ads/AdMarvelVideoActivity;Landroid/content/Context;)V
        //   338: putfield        com/admarvel/android/ads/AdMarvelVideoActivity.L:Lcom/admarvel/android/ads/j;
        //   341: aload_0        
        //   342: getfield        com/admarvel/android/ads/AdMarvelVideoActivity.L:Lcom/admarvel/android/ads/j;
        //   345: aload           5
        //   347: invokevirtual   com/admarvel/android/ads/j.setLayoutParams:(Landroid/view/ViewGroup$LayoutParams;)V
        //   350: aload_0        
        //   351: getfield        com/admarvel/android/ads/AdMarvelVideoActivity.L:Lcom/admarvel/android/ads/j;
        //   354: aload_0        
        //   355: invokevirtual   com/admarvel/android/ads/j.a:(Lcom/admarvel/android/ads/j$a;)V
        //   358: aload           4
        //   360: aload_0        
        //   361: getfield        com/admarvel/android/ads/AdMarvelVideoActivity.L:Lcom/admarvel/android/ads/j;
        //   364: invokevirtual   android/widget/RelativeLayout.addView:(Landroid/view/View;)V
        //   367: aload_0        
        //   368: new             Landroid/os/Handler;
        //   371: dup            
        //   372: invokespecial   android/os/Handler.<init>:()V
        //   375: putfield        com/admarvel/android/ads/AdMarvelVideoActivity.N:Landroid/os/Handler;
        //   378: aload_0        
        //   379: new             Lcom/admarvel/android/ads/r;
        //   382: dup            
        //   383: aload_0        
        //   384: invokespecial   com/admarvel/android/ads/r.<init>:(Landroid/content/Context;)V
        //   387: putfield        com/admarvel/android/ads/AdMarvelVideoActivity.O:Lcom/admarvel/android/ads/r;
        //   390: aload_0        
        //   391: aload_0        
        //   392: getfield        com/admarvel/android/ads/AdMarvelVideoActivity.p:Ljava/lang/String;
        //   395: invokevirtual   com/admarvel/android/ads/AdMarvelVideoActivity.b:(Ljava/lang/String;)V
        //   398: aload_0        
        //   399: getfield        com/admarvel/android/ads/AdMarvelVideoActivity.s:Z
        //   402: ifeq            426
        //   405: aload_0        
        //   406: aload_0        
        //   407: aload_0        
        //   408: getfield        com/admarvel/android/ads/AdMarvelVideoActivity.p:Ljava/lang/String;
        //   411: invokespecial   com/admarvel/android/ads/AdMarvelVideoActivity.e:(Ljava/lang/String;)Landroid/widget/LinearLayout;
        //   414: putfield        com/admarvel/android/ads/AdMarvelVideoActivity.g:Landroid/widget/LinearLayout;
        //   417: aload_0        
        //   418: getfield        com/admarvel/android/ads/AdMarvelVideoActivity.g:Landroid/widget/LinearLayout;
        //   421: bipush          8
        //   423: invokevirtual   android/widget/LinearLayout.setVisibility:(I)V
        //   426: aload_1        
        //   427: aload_3        
        //   428: invokevirtual   android/widget/RelativeLayout.addView:(Landroid/view/View;)V
        //   431: aload_0        
        //   432: getfield        com/admarvel/android/ads/AdMarvelVideoActivity.x:Ljava/lang/String;
        //   435: ifnull          1067
        //   438: aload_0        
        //   439: getfield        com/admarvel/android/ads/AdMarvelVideoActivity.x:Ljava/lang/String;
        //   442: invokevirtual   java/lang/String.length:()I
        //   445: istore_2       
        //   446: iload_2        
        //   447: ifle            1067
        //   450: aload_0        
        //   451: getfield        com/admarvel/android/ads/AdMarvelVideoActivity.L:Lcom/admarvel/android/ads/j;
        //   454: aload_0        
        //   455: getfield        com/admarvel/android/ads/AdMarvelVideoActivity.x:Ljava/lang/String;
        //   458: invokestatic    android/net/Uri.parse:(Ljava/lang/String;)Landroid/net/Uri;
        //   461: invokevirtual   com/admarvel/android/ads/j.a:(Landroid/net/Uri;)V
        //   464: aload_0        
        //   465: getfield        com/admarvel/android/ads/AdMarvelVideoActivity.L:Lcom/admarvel/android/ads/j;
        //   468: aload_0        
        //   469: invokevirtual   com/admarvel/android/ads/j.a:(Landroid/media/MediaPlayer$OnCompletionListener;)V
        //   472: aload_0        
        //   473: getfield        com/admarvel/android/ads/AdMarvelVideoActivity.L:Lcom/admarvel/android/ads/j;
        //   476: aload_0        
        //   477: invokevirtual   com/admarvel/android/ads/j.a:(Landroid/media/MediaPlayer$OnPreparedListener;)V
        //   480: aload_0        
        //   481: getfield        com/admarvel/android/ads/AdMarvelVideoActivity.L:Lcom/admarvel/android/ads/j;
        //   484: aload_0        
        //   485: invokevirtual   com/admarvel/android/ads/j.a:(Landroid/media/MediaPlayer$OnErrorListener;)V
        //   488: aload_0        
        //   489: getfield        com/admarvel/android/ads/AdMarvelVideoActivity.L:Lcom/admarvel/android/ads/j;
        //   492: invokevirtual   com/admarvel/android/ads/j.requestFocus:()Z
        //   495: pop            
        //   496: aload_0        
        //   497: getfield        com/admarvel/android/ads/AdMarvelVideoActivity.r:Z
        //   500: iconst_1       
        //   501: if_icmpne       517
        //   504: invokestatic    com/admarvel/android/ads/AdMarvelInterstitialAds.getListener:()Lcom/admarvel/android/ads/e;
        //   507: ifnull          517
        //   510: invokestatic    com/admarvel/android/ads/AdMarvelInterstitialAds.getListener:()Lcom/admarvel/android/ads/e;
        //   513: aload_0        
        //   514: invokevirtual   com/admarvel/android/ads/e.a:(Lcom/admarvel/android/ads/AdMarvelVideoActivity;)V
        //   517: aload_0        
        //   518: getfield        com/admarvel/android/ads/AdMarvelVideoActivity.z:Z
        //   521: ifeq            546
        //   524: aload_0        
        //   525: getfield        com/admarvel/android/ads/AdMarvelVideoActivity.y:Ljava/lang/String;
        //   528: ifnull          546
        //   531: aload_0        
        //   532: getfield        com/admarvel/android/ads/AdMarvelVideoActivity.y:Ljava/lang/String;
        //   535: invokevirtual   java/lang/String.length:()I
        //   538: ifle            546
        //   541: aload_0        
        //   542: aload_1        
        //   543: invokespecial   com/admarvel/android/ads/AdMarvelVideoActivity.b:(Landroid/widget/RelativeLayout;)V
        //   546: aload_0        
        //   547: getfield        com/admarvel/android/ads/AdMarvelVideoActivity.s:Z
        //   550: ifeq            568
        //   553: aload_0        
        //   554: getfield        com/admarvel/android/ads/AdMarvelVideoActivity.g:Landroid/widget/LinearLayout;
        //   557: ifnull          568
        //   560: aload_1        
        //   561: aload_0        
        //   562: getfield        com/admarvel/android/ads/AdMarvelVideoActivity.g:Landroid/widget/LinearLayout;
        //   565: invokevirtual   android/widget/RelativeLayout.addView:(Landroid/view/View;)V
        //   568: aload_0        
        //   569: getfield        com/admarvel/android/ads/AdMarvelVideoActivity.M:Ljava/lang/ref/WeakReference;
        //   572: ifnull          727
        //   575: aload_0        
        //   576: getfield        com/admarvel/android/ads/AdMarvelVideoActivity.M:Ljava/lang/ref/WeakReference;
        //   579: invokevirtual   java/lang/ref/WeakReference.get:()Ljava/lang/Object;
        //   582: checkcast       Lcom/admarvel/android/ads/s;
        //   585: astore_3       
        //   586: aload_3        
        //   587: ifnull          727
        //   590: aload_0        
        //   591: new             Landroid/widget/RelativeLayout;
        //   594: dup            
        //   595: aload_0        
        //   596: invokespecial   android/widget/RelativeLayout.<init>:(Landroid/content/Context;)V
        //   599: putfield        com/admarvel/android/ads/AdMarvelVideoActivity.o:Landroid/widget/RelativeLayout;
        //   602: new             Landroid/widget/RelativeLayout$LayoutParams;
        //   605: dup            
        //   606: bipush          -2
        //   608: bipush          -2
        //   610: invokespecial   android/widget/RelativeLayout$LayoutParams.<init>:(II)V
        //   613: astore          4
        //   615: aload           4
        //   617: bipush          10
        //   619: invokevirtual   android/widget/RelativeLayout$LayoutParams.addRule:(I)V
        //   622: aload           4
        //   624: bipush          11
        //   626: invokevirtual   android/widget/RelativeLayout$LayoutParams.addRule:(I)V
        //   629: aload_0        
        //   630: getfield        com/admarvel/android/ads/AdMarvelVideoActivity.o:Landroid/widget/RelativeLayout;
        //   633: aload           4
        //   635: invokevirtual   android/widget/RelativeLayout.setLayoutParams:(Landroid/view/ViewGroup$LayoutParams;)V
        //   638: aload_0        
        //   639: getfield        com/admarvel/android/ads/AdMarvelVideoActivity.o:Landroid/widget/RelativeLayout;
        //   642: iconst_0       
        //   643: invokevirtual   android/widget/RelativeLayout.setBackgroundColor:(I)V
        //   646: new             Landroid/widget/RelativeLayout$LayoutParams;
        //   649: dup            
        //   650: bipush          -2
        //   652: bipush          -2
        //   654: invokespecial   android/widget/RelativeLayout$LayoutParams.<init>:(II)V
        //   657: astore          4
        //   659: iconst_1       
        //   660: ldc_w           20.0
        //   663: aload_0        
        //   664: invokevirtual   com/admarvel/android/ads/AdMarvelVideoActivity.getResources:()Landroid/content/res/Resources;
        //   667: invokevirtual   android/content/res/Resources.getDisplayMetrics:()Landroid/util/DisplayMetrics;
        //   670: invokestatic    android/util/TypedValue.applyDimension:(IFLandroid/util/DisplayMetrics;)F
        //   673: f2i            
        //   674: istore_2       
        //   675: aload           4
        //   677: iload_2        
        //   678: iload_2        
        //   679: iload_2        
        //   680: iload_2        
        //   681: invokevirtual   android/widget/RelativeLayout$LayoutParams.setMargins:(IIII)V
        //   684: aload           4
        //   686: bipush          11
        //   688: invokevirtual   android/widget/RelativeLayout$LayoutParams.addRule:(I)V
        //   691: aload_3        
        //   692: invokevirtual   com/admarvel/android/ads/s.a:()Lcom/admarvel/android/ads/s$d;
        //   695: ifnull          727
        //   698: aload_0        
        //   699: getfield        com/admarvel/android/ads/AdMarvelVideoActivity.o:Landroid/widget/RelativeLayout;
        //   702: aload_3        
        //   703: invokevirtual   com/admarvel/android/ads/s.a:()Lcom/admarvel/android/ads/s$d;
        //   706: aload           4
        //   708: invokevirtual   android/widget/RelativeLayout.addView:(Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)V
        //   711: aload_0        
        //   712: getfield        com/admarvel/android/ads/AdMarvelVideoActivity.o:Landroid/widget/RelativeLayout;
        //   715: iconst_1       
        //   716: invokevirtual   android/widget/RelativeLayout.setClickable:(Z)V
        //   719: aload_1        
        //   720: aload_0        
        //   721: getfield        com/admarvel/android/ads/AdMarvelVideoActivity.o:Landroid/widget/RelativeLayout;
        //   724: invokevirtual   android/widget/RelativeLayout.addView:(Landroid/view/View;)V
        //   727: aload_0        
        //   728: getfield        com/admarvel/android/ads/AdMarvelVideoActivity.C:Z
        //   731: ifeq            743
        //   734: aload_0        
        //   735: aload_1        
        //   736: invokespecial   com/admarvel/android/ads/AdMarvelVideoActivity.a:(Landroid/widget/RelativeLayout;)V
        //   739: aload_0        
        //   740: invokespecial   com/admarvel/android/ads/AdMarvelVideoActivity.p:()V
        //   743: aload_0        
        //   744: getfield        com/admarvel/android/ads/AdMarvelVideoActivity.v:Z
        //   747: ifeq            1231
        //   750: aload_0        
        //   751: getfield        com/admarvel/android/ads/AdMarvelVideoActivity.w:I
        //   754: ifle            1231
        //   757: aload_0        
        //   758: getfield        com/admarvel/android/ads/AdMarvelVideoActivity.M:Ljava/lang/ref/WeakReference;
        //   761: ifnull          1231
        //   764: aload_0        
        //   765: getfield        com/admarvel/android/ads/AdMarvelVideoActivity.M:Ljava/lang/ref/WeakReference;
        //   768: invokevirtual   java/lang/ref/WeakReference.get:()Ljava/lang/Object;
        //   771: checkcast       Lcom/admarvel/android/ads/s;
        //   774: astore_3       
        //   775: aload_3        
        //   776: ifnull          1231
        //   779: aload_3        
        //   780: instanceof      Landroid/widget/LinearLayout;
        //   783: ifeq            1231
        //   786: aload_3        
        //   787: ifnull          1231
        //   790: aload_0        
        //   791: getfield        com/admarvel/android/ads/AdMarvelVideoActivity.s:Z
        //   794: ifeq            1231
        //   797: iconst_0       
        //   798: istore_2       
        //   799: iload_2        
        //   800: aload_3        
        //   801: invokevirtual   android/widget/LinearLayout.getChildCount:()I
        //   804: if_icmpge       1146
        //   807: aload_3        
        //   808: iload_2        
        //   809: invokevirtual   android/widget/LinearLayout.getChildAt:(I)Landroid/view/View;
        //   812: instanceof      Lcom/admarvel/android/ads/s$d;
        //   815: ifeq            905
        //   818: aload_3        
        //   819: iload_2        
        //   820: invokevirtual   android/widget/LinearLayout.getChildAt:(I)Landroid/view/View;
        //   823: checkcast       Lcom/admarvel/android/ads/s$d;
        //   826: astore          4
        //   828: aload           4
        //   830: ifnull          905
        //   833: aload           4
        //   835: getfield        com/admarvel/android/ads/s$d.c:Ljava/lang/String;
        //   838: ldc_w           "done"
        //   841: invokevirtual   java/lang/String.equalsIgnoreCase:(Ljava/lang/String;)Z
        //   844: ifeq            905
        //   847: aload           4
        //   849: iconst_0       
        //   850: invokevirtual   com/admarvel/android/ads/s$d.setClickable:(Z)V
        //   853: aload           4
        //   855: iconst_0       
        //   856: invokevirtual   com/admarvel/android/ads/s$d.setEnabled:(Z)V
        //   859: aload           4
        //   861: iconst_0       
        //   862: invokevirtual   com/admarvel/android/ads/s$d.getChildAt:(I)Landroid/view/View;
        //   865: instanceof      Landroid/widget/ImageView;
        //   868: ifeq            905
        //   871: aload           4
        //   873: iconst_0       
        //   874: invokevirtual   com/admarvel/android/ads/s$d.getChildAt:(I)Landroid/view/View;
        //   877: checkcast       Landroid/widget/ImageView;
        //   880: astore          4
        //   882: aload           4
        //   884: ifnull          1083
        //   887: aload           4
        //   889: invokevirtual   android/widget/ImageView.getDrawable:()Landroid/graphics/drawable/Drawable;
        //   892: ifnull          1083
        //   895: aload           4
        //   897: invokevirtual   android/widget/ImageView.getDrawable:()Landroid/graphics/drawable/Drawable;
        //   900: bipush          25
        //   902: invokevirtual   android/graphics/drawable/Drawable.setAlpha:(I)V
        //   905: iload_2        
        //   906: iconst_1       
        //   907: iadd           
        //   908: istore_2       
        //   909: goto            799
        //   912: getstatic       com/admarvel/android/ads/AdMarvelVideoActivity.l:Landroid/app/Activity;
        //   915: invokevirtual   android/app/Activity.finish:()V
        //   918: aload_0        
        //   919: putstatic       com/admarvel/android/ads/AdMarvelVideoActivity.l:Landroid/app/Activity;
        //   922: goto            15
        //   925: aload_0        
        //   926: invokevirtual   com/admarvel/android/ads/AdMarvelVideoActivity.getWindow:()Landroid/view/Window;
        //   929: sipush          512
        //   932: sipush          512
        //   935: invokevirtual   android/view/Window.setFlags:(II)V
        //   938: goto            59
        //   941: astore_3       
        //   942: aload_3        
        //   943: invokestatic    android/util/Log.getStackTraceString:(Ljava/lang/Throwable;)Ljava/lang/String;
        //   946: invokestatic    com/admarvel/android/util/Logging.log:(Ljava/lang/String;)V
        //   949: goto            142
        //   952: aload_1        
        //   953: ldc_w           "html"
        //   956: invokevirtual   android/os/Bundle.containsKey:(Ljava/lang/String;)Z
        //   959: ifeq            1017
        //   962: aload_0        
        //   963: aload_1        
        //   964: ldc_w           "html"
        //   967: invokevirtual   android/os/Bundle.getString:(Ljava/lang/String;)Ljava/lang/String;
        //   970: putfield        com/admarvel/android/ads/AdMarvelVideoActivity.p:Ljava/lang/String;
        //   973: aload_0        
        //   974: aload_1        
        //   975: ldc_w           "GUID"
        //   978: invokevirtual   android/os/Bundle.getString:(Ljava/lang/String;)Ljava/lang/String;
        //   981: putfield        com/admarvel/android/ads/AdMarvelVideoActivity.P:Ljava/lang/String;
        //   984: aload_0        
        //   985: getfield        com/admarvel/android/ads/AdMarvelVideoActivity.p:Ljava/lang/String;
        //   988: ifnull          1009
        //   991: aload_0        
        //   992: getfield        com/admarvel/android/ads/AdMarvelVideoActivity.p:Ljava/lang/String;
        //   995: invokevirtual   java/lang/String.length:()I
        //   998: ifle            1009
        //  1001: aload_0        
        //  1002: iconst_1       
        //  1003: putfield        com/admarvel/android/ads/AdMarvelVideoActivity.r:Z
        //  1006: goto            183
        //  1009: aload_0        
        //  1010: iconst_0       
        //  1011: putfield        com/admarvel/android/ads/AdMarvelVideoActivity.r:Z
        //  1014: goto            183
        //  1017: aload_0        
        //  1018: invokevirtual   com/admarvel/android/ads/AdMarvelVideoActivity.finish:()V
        //  1021: goto            183
        //  1024: astore          4
        //  1026: aload           4
        //  1028: invokevirtual   java/lang/Exception.printStackTrace:()V
        //  1031: goto            398
        //  1034: astore_1       
        //  1035: aload_1        
        //  1036: invokevirtual   javax/xml/parsers/ParserConfigurationException.getMessage:()Ljava/lang/String;
        //  1039: invokestatic    com/admarvel/android/util/Logging.log:(Ljava/lang/String;)V
        //  1042: return         
        //  1043: astore_3       
        //  1044: new             Ljava/lang/StringBuilder;
        //  1047: dup            
        //  1048: ldc_w           "Exception in setting URI on videoView "
        //  1051: invokespecial   java/lang/StringBuilder.<init>:(Ljava/lang/String;)V
        //  1054: aload_3        
        //  1055: invokevirtual   java/lang/Exception.getMessage:()Ljava/lang/String;
        //  1058: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //  1061: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //  1064: invokestatic    com/admarvel/android/util/Logging.log:(Ljava/lang/String;)V
        //  1067: aload_0        
        //  1068: invokevirtual   com/admarvel/android/ads/AdMarvelVideoActivity.finish:()V
        //  1071: goto            464
        //  1074: astore_1       
        //  1075: aload_1        
        //  1076: invokevirtual   org/xml/sax/SAXException.getMessage:()Ljava/lang/String;
        //  1079: invokestatic    com/admarvel/android/util/Logging.log:(Ljava/lang/String;)V
        //  1082: return         
        //  1083: aload           4
        //  1085: ifnull          905
        //  1088: aload_0        
        //  1089: getfield        com/admarvel/android/ads/AdMarvelVideoActivity.Z:Lcom/admarvel/android/ads/AdMarvelVideoActivity$i;
        //  1092: ifnonnull       905
        //  1095: new             Lcom/admarvel/android/ads/AdMarvelVideoActivity$a;
        //  1098: dup            
        //  1099: aload_0        
        //  1100: aload           4
        //  1102: invokespecial   com/admarvel/android/ads/AdMarvelVideoActivity$a.<init>:(Lcom/admarvel/android/ads/AdMarvelVideoActivity;Landroid/widget/ImageView;)V
        //  1105: astore          4
        //  1107: aload_0        
        //  1108: new             Lcom/admarvel/android/ads/AdMarvelVideoActivity$i;
        //  1111: dup            
        //  1112: aload_0        
        //  1113: getfield        com/admarvel/android/ads/AdMarvelVideoActivity.N:Landroid/os/Handler;
        //  1116: aload           4
        //  1118: sipush          1000
        //  1121: invokespecial   com/admarvel/android/ads/AdMarvelVideoActivity$i.<init>:(Landroid/os/Handler;Ljava/lang/Runnable;I)V
        //  1124: putfield        com/admarvel/android/ads/AdMarvelVideoActivity.Z:Lcom/admarvel/android/ads/AdMarvelVideoActivity$i;
        //  1127: aload_0        
        //  1128: getfield        com/admarvel/android/ads/AdMarvelVideoActivity.Z:Lcom/admarvel/android/ads/AdMarvelVideoActivity$i;
        //  1131: invokevirtual   com/admarvel/android/ads/AdMarvelVideoActivity$i.a:()V
        //  1134: goto            905
        //  1137: astore_1       
        //  1138: aload_1        
        //  1139: invokevirtual   java/io/IOException.getMessage:()Ljava/lang/String;
        //  1142: invokestatic    com/admarvel/android/util/Logging.log:(Ljava/lang/String;)V
        //  1145: return         
        //  1146: aload_0        
        //  1147: new             Lcom/admarvel/android/ads/AdMarvelVideoActivity$i;
        //  1150: dup            
        //  1151: aload_0        
        //  1152: getfield        com/admarvel/android/ads/AdMarvelVideoActivity.N:Landroid/os/Handler;
        //  1155: aload_0        
        //  1156: getfield        com/admarvel/android/ads/AdMarvelVideoActivity.af:Ljava/lang/Runnable;
        //  1159: aload_0        
        //  1160: getfield        com/admarvel/android/ads/AdMarvelVideoActivity.w:I
        //  1163: sipush          1000
        //  1166: imul           
        //  1167: invokespecial   com/admarvel/android/ads/AdMarvelVideoActivity$i.<init>:(Landroid/os/Handler;Ljava/lang/Runnable;I)V
        //  1170: putfield        com/admarvel/android/ads/AdMarvelVideoActivity.V:Lcom/admarvel/android/ads/AdMarvelVideoActivity$i;
        //  1173: aload_0        
        //  1174: getfield        com/admarvel/android/ads/AdMarvelVideoActivity.V:Lcom/admarvel/android/ads/AdMarvelVideoActivity$i;
        //  1177: invokevirtual   com/admarvel/android/ads/AdMarvelVideoActivity$i.a:()V
        //  1180: aload_0        
        //  1181: getfield        com/admarvel/android/ads/AdMarvelVideoActivity.C:Z
        //  1184: ifeq            1231
        //  1187: aload_0        
        //  1188: getfield        com/admarvel/android/ads/AdMarvelVideoActivity.X:Lcom/admarvel/android/ads/AdMarvelVideoActivity$i;
        //  1191: ifnonnull       1231
        //  1194: aload_0        
        //  1195: invokestatic    java/lang/System.currentTimeMillis:()J
        //  1198: putfield        com/admarvel/android/ads/AdMarvelVideoActivity.E:J
        //  1201: aload_0        
        //  1202: new             Lcom/admarvel/android/ads/AdMarvelVideoActivity$i;
        //  1205: dup            
        //  1206: aload_0        
        //  1207: getfield        com/admarvel/android/ads/AdMarvelVideoActivity.N:Landroid/os/Handler;
        //  1210: aload_0        
        //  1211: getfield        com/admarvel/android/ads/AdMarvelVideoActivity.ah:Ljava/lang/Runnable;
        //  1214: sipush          500
        //  1217: iconst_0       
        //  1218: invokespecial   com/admarvel/android/ads/AdMarvelVideoActivity$i.<init>:(Landroid/os/Handler;Ljava/lang/Runnable;IZ)V
        //  1221: putfield        com/admarvel/android/ads/AdMarvelVideoActivity.X:Lcom/admarvel/android/ads/AdMarvelVideoActivity$i;
        //  1224: aload_0        
        //  1225: getfield        com/admarvel/android/ads/AdMarvelVideoActivity.X:Lcom/admarvel/android/ads/AdMarvelVideoActivity$i;
        //  1228: invokevirtual   com/admarvel/android/ads/AdMarvelVideoActivity$i.a:()V
        //  1231: aload_1        
        //  1232: aload_0        
        //  1233: getfield        com/admarvel/android/ads/AdMarvelVideoActivity.aj:Landroid/view/View$OnTouchListener;
        //  1236: invokevirtual   android/widget/RelativeLayout.setOnTouchListener:(Landroid/view/View$OnTouchListener;)V
        //  1239: aload_0        
        //  1240: ldc_w           "Loading Video..."
        //  1243: invokevirtual   com/admarvel/android/ads/AdMarvelVideoActivity.a:(Ljava/lang/String;)V
        //  1246: new             Landroid/content/IntentFilter;
        //  1249: dup            
        //  1250: ldc_w           "android.intent.action.SCREEN_ON"
        //  1253: invokespecial   android/content/IntentFilter.<init>:(Ljava/lang/String;)V
        //  1256: astore_1       
        //  1257: aload_1        
        //  1258: ldc_w           "android.intent.action.SCREEN_OFF"
        //  1261: invokevirtual   android/content/IntentFilter.addAction:(Ljava/lang/String;)V
        //  1264: aload_0        
        //  1265: new             Lcom/admarvel/android/ads/AdMarvelVideoActivity$h;
        //  1268: dup            
        //  1269: aload_0        
        //  1270: invokespecial   com/admarvel/android/ads/AdMarvelVideoActivity$h.<init>:(Lcom/admarvel/android/ads/AdMarvelVideoActivity;)V
        //  1273: putfield        com/admarvel/android/ads/AdMarvelVideoActivity.ac:Landroid/content/BroadcastReceiver;
        //  1276: aload_0        
        //  1277: aload_0        
        //  1278: getfield        com/admarvel/android/ads/AdMarvelVideoActivity.ac:Landroid/content/BroadcastReceiver;
        //  1281: aload_1        
        //  1282: invokevirtual   com/admarvel/android/ads/AdMarvelVideoActivity.registerReceiver:(Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;)Landroid/content/Intent;
        //  1285: pop            
        //  1286: return         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                                            
        //  -----  -----  -----  -----  ------------------------------------------------
        //  95     142    941    952    Ljava/lang/Exception;
        //  390    398    1024   1034   Ljava/lang/Exception;
        //  390    398    1034   1043   Ljavax/xml/parsers/ParserConfigurationException;
        //  390    398    1074   1083   Lorg/xml/sax/SAXException;
        //  390    398    1137   1146   Ljava/io/IOException;
        //  398    426    1034   1043   Ljavax/xml/parsers/ParserConfigurationException;
        //  398    426    1074   1083   Lorg/xml/sax/SAXException;
        //  398    426    1137   1146   Ljava/io/IOException;
        //  426    446    1034   1043   Ljavax/xml/parsers/ParserConfigurationException;
        //  426    446    1074   1083   Lorg/xml/sax/SAXException;
        //  426    446    1137   1146   Ljava/io/IOException;
        //  450    464    1043   1067   Ljava/lang/Exception;
        //  450    464    1034   1043   Ljavax/xml/parsers/ParserConfigurationException;
        //  450    464    1074   1083   Lorg/xml/sax/SAXException;
        //  450    464    1137   1146   Ljava/io/IOException;
        //  464    517    1034   1043   Ljavax/xml/parsers/ParserConfigurationException;
        //  464    517    1074   1083   Lorg/xml/sax/SAXException;
        //  464    517    1137   1146   Ljava/io/IOException;
        //  517    546    1034   1043   Ljavax/xml/parsers/ParserConfigurationException;
        //  517    546    1074   1083   Lorg/xml/sax/SAXException;
        //  517    546    1137   1146   Ljava/io/IOException;
        //  546    568    1034   1043   Ljavax/xml/parsers/ParserConfigurationException;
        //  546    568    1074   1083   Lorg/xml/sax/SAXException;
        //  546    568    1137   1146   Ljava/io/IOException;
        //  568    586    1034   1043   Ljavax/xml/parsers/ParserConfigurationException;
        //  568    586    1074   1083   Lorg/xml/sax/SAXException;
        //  568    586    1137   1146   Ljava/io/IOException;
        //  590    727    1034   1043   Ljavax/xml/parsers/ParserConfigurationException;
        //  590    727    1074   1083   Lorg/xml/sax/SAXException;
        //  590    727    1137   1146   Ljava/io/IOException;
        //  727    743    1034   1043   Ljavax/xml/parsers/ParserConfigurationException;
        //  727    743    1074   1083   Lorg/xml/sax/SAXException;
        //  727    743    1137   1146   Ljava/io/IOException;
        //  743    775    1034   1043   Ljavax/xml/parsers/ParserConfigurationException;
        //  743    775    1074   1083   Lorg/xml/sax/SAXException;
        //  743    775    1137   1146   Ljava/io/IOException;
        //  779    786    1034   1043   Ljavax/xml/parsers/ParserConfigurationException;
        //  779    786    1074   1083   Lorg/xml/sax/SAXException;
        //  779    786    1137   1146   Ljava/io/IOException;
        //  790    797    1034   1043   Ljavax/xml/parsers/ParserConfigurationException;
        //  790    797    1074   1083   Lorg/xml/sax/SAXException;
        //  790    797    1137   1146   Ljava/io/IOException;
        //  799    828    1034   1043   Ljavax/xml/parsers/ParserConfigurationException;
        //  799    828    1074   1083   Lorg/xml/sax/SAXException;
        //  799    828    1137   1146   Ljava/io/IOException;
        //  833    882    1034   1043   Ljavax/xml/parsers/ParserConfigurationException;
        //  833    882    1074   1083   Lorg/xml/sax/SAXException;
        //  833    882    1137   1146   Ljava/io/IOException;
        //  887    905    1034   1043   Ljavax/xml/parsers/ParserConfigurationException;
        //  887    905    1074   1083   Lorg/xml/sax/SAXException;
        //  887    905    1137   1146   Ljava/io/IOException;
        //  1026   1031   1034   1043   Ljavax/xml/parsers/ParserConfigurationException;
        //  1026   1031   1074   1083   Lorg/xml/sax/SAXException;
        //  1026   1031   1137   1146   Ljava/io/IOException;
        //  1044   1067   1034   1043   Ljavax/xml/parsers/ParserConfigurationException;
        //  1044   1067   1074   1083   Lorg/xml/sax/SAXException;
        //  1044   1067   1137   1146   Ljava/io/IOException;
        //  1067   1071   1034   1043   Ljavax/xml/parsers/ParserConfigurationException;
        //  1067   1071   1074   1083   Lorg/xml/sax/SAXException;
        //  1067   1071   1137   1146   Ljava/io/IOException;
        //  1088   1134   1034   1043   Ljavax/xml/parsers/ParserConfigurationException;
        //  1088   1134   1074   1083   Lorg/xml/sax/SAXException;
        //  1088   1134   1137   1146   Ljava/io/IOException;
        //  1146   1231   1034   1043   Ljavax/xml/parsers/ParserConfigurationException;
        //  1146   1231   1074   1083   Lorg/xml/sax/SAXException;
        //  1146   1231   1137   1146   Ljava/io/IOException;
        //  1231   1286   1034   1043   Ljavax/xml/parsers/ParserConfigurationException;
        //  1231   1286   1074   1083   Lorg/xml/sax/SAXException;
        //  1231   1286   1137   1146   Ljava/io/IOException;
        // 
        // The error that occurred was:
        // 
        // java.lang.IndexOutOfBoundsException: Index: 597, Size: 597
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
    
    protected void onDestroy() {
        super.onDestroy();
        this.s();
        if (this.ac != null) {
            this.unregisterReceiver(this.ac);
            this.ac = null;
        }
    }
    
    public boolean onError(final MediaPlayer mediaPlayer, final int n, final int n2) {
        this.c(false);
        this.i = AdMarvelVideoActivity$k.e;
        final LinearLayout linearLayout = (LinearLayout)this.findViewById(AdMarvelVideoActivity.b);
        if (this.s && linearLayout != null && linearLayout.getVisibility() != 0) {
            this.a(linearLayout, true);
            linearLayout.setVisibility(0);
        }
        if (mediaPlayer != null) {
            mediaPlayer.reset();
            mediaPlayer.release();
        }
        return false;
    }
    
    public boolean onKeyDown(final int n, final KeyEvent keyEvent) {
        if (keyEvent.getAction() == 0) {
            switch (n) {
                case 4: {
                    while (true) {
                        Label_0086: {
                            if (this.M == null) {
                                break Label_0086;
                            }
                            final s s = (s)this.M.get();
                            if (s == null) {
                                break Label_0086;
                            }
                            final int b = s.b() ? 1 : 0;
                            if (!this.s || b == 0 || !this.v) {
                                this.c();
                            }
                            return true;
                        }
                        final int b = 0;
                        continue;
                    }
                }
            }
        }
        return super.onKeyDown(n, keyEvent);
    }
    
    protected void onPause() {
        super.onPause();
        Label_0070: {
            if (this.isFinishing()) {
                break Label_0070;
            }
            while (true) {
                try {
                    AdMarvelAnalyticsAdapterInstances.getInstance("com.admarvel.android.admarvelmologiqadapter.AdMarvelMologiqAdapter", (Context)this).start();
                    Logging.log("Video Activity onPause is called");
                    if (this.i == AdMarvelVideoActivity$k.b) {
                        if (this.L != null) {
                            if (this.H) {
                                this.L.d();
                                this.F = true;
                                this.i = AdMarvelVideoActivity$k.g;
                            }
                            else if (this.I) {
                                this.L.d();
                                this.G = true;
                                this.i = AdMarvelVideoActivity$k.g;
                            }
                            else {
                                this.L.pause();
                                this.i = AdMarvelVideoActivity$k.c;
                            }
                        }
                    }
                    else if ((this.i == AdMarvelVideoActivity$k.d || this.i == AdMarvelVideoActivity$k.e) && this.L != null && !this.L.isPlaying()) {
                        this.L.a(true);
                    }
                    if (this.Y != null && this.Y.c()) {
                        this.Y.b();
                    }
                }
                catch (Exception ex) {
                    continue;
                }
                break;
            }
        }
    }
    
    public void onPrepared(final MediaPlayer mediaPlayer) {
        while (true) {
            try {
                if (this.h != null) {
                    final AdMarvelVideoActivity$b adMarvelVideoActivity$b = (AdMarvelVideoActivity$b)this.h.get();
                    if (adMarvelVideoActivity$b != null && adMarvelVideoActivity$b.a()) {
                        adMarvelVideoActivity$b.d();
                        adMarvelVideoActivity$b.e();
                    }
                }
                if (this.u) {
                    if (this.Y == null) {
                        this.Y = new AdMarvelVideoActivity$i(this.N, this.ai, 3100, true);
                    }
                    final LinearLayout linearLayout = (LinearLayout)this.findViewById(AdMarvelVideoActivity.b);
                    if (this.s && linearLayout != null && linearLayout.getVisibility() == 0) {
                        this.Y.a();
                        this.aa = System.currentTimeMillis();
                    }
                }
                if (this.j == AdMarvelVideoActivity$m.a) {
                    this.L.b();
                }
                if (this.ab) {
                    if (this.q()) {
                        this.L.b();
                        this.j = AdMarvelVideoActivity$m.a;
                        this.r();
                    }
                    this.ab = false;
                }
                this.c(true);
                if (this.L != null) {
                    this.a(this.L);
                    this.a(AdMarvelVideoActivity$l.a);
                }
            }
            catch (Exception ex) {
                Logging.log(Log.getStackTraceString((Throwable)ex));
                continue;
            }
            break;
        }
    }
    
    protected void onResume() {
        super.onResume();
        while (true) {
            try {
                AdMarvelAnalyticsAdapterInstances.getInstance("com.admarvel.android.admarvelmologiqadapter.AdMarvelMologiqAdapter", (Context)this).start();
                if (this.L != null && (this.i == AdMarvelVideoActivity$k.c || (!this.L.isPlaying() && this.i == AdMarvelVideoActivity$k.g))) {
                    this.a("Resuming Video...");
                    this.L.e();
                    if (this.Y != null) {
                        this.Y.a();
                    }
                }
                this.F = false;
                this.d = false;
            }
            catch (Exception ex) {
                continue;
            }
            break;
        }
    }
    
    protected void onStart() {
        super.onStart();
        try {
            AdMarvelAnalyticsAdapterInstances.getInstance("com.admarvel.android.admarvelmologiqadapter.AdMarvelMologiqAdapter", (Context)this).start();
        }
        catch (Exception ex) {}
    }
    
    protected void onStop() {
        super.onStop();
        while (true) {
            try {
                AdMarvelAnalyticsAdapterInstances.getInstance("com.admarvel.android.admarvelmologiqadapter.AdMarvelMologiqAdapter", (Context)this).start();
                Logging.log("Video Activity onStop is called");
                if (this.L != null && !this.L.isPlaying() && this.i == AdMarvelVideoActivity$k.g && !this.I) {
                    this.a(AdMarvelVideoActivity$l.c);
                }
                final PowerManager powerManager = (PowerManager)this.getSystemService("power");
                final StringBuilder sb = new StringBuilder("Video Activity onStop isScreenOn: ");
                Serializable value;
                if (powerManager != null) {
                    value = powerManager.isScreenOn();
                }
                else {
                    value = "powermanager null";
                }
                Logging.log(sb.append(value).toString());
                if (!this.isFinishing() && this.F && this.i == AdMarvelVideoActivity$k.g && this.L != null && this.L.isPlaying() && powerManager != null && !powerManager.isScreenOn()) {
                    this.i = AdMarvelVideoActivity$k.b;
                    this.F = false;
                }
                else if (!this.isFinishing() && this.I && !this.d) {
                    this.c();
                }
                if (this.W != null && (!this.H || !this.L.isPlaying() || powerManager.isScreenOn())) {
                    this.W.b();
                }
                AdMarvelVideoActivity$b adMarvelVideoActivity$b;
                if (this.h != null) {
                    adMarvelVideoActivity$b = (AdMarvelVideoActivity$b)this.h.get();
                }
                else {
                    adMarvelVideoActivity$b = null;
                }
                if (adMarvelVideoActivity$b != null) {
                    adMarvelVideoActivity$b.c();
                    adMarvelVideoActivity$b.e();
                }
            }
            catch (Exception ex) {
                continue;
            }
            break;
        }
    }
    
    public void onUserInteraction() {
        final LinearLayout linearLayout = (LinearLayout)this.findViewById(AdMarvelVideoActivity.b);
        if (this.s && linearLayout != null) {
            if (linearLayout.getVisibility() != 0) {
                this.b(true);
                return;
            }
            this.aa = System.currentTimeMillis();
            if (this.Y != null && this.Y.c()) {
                this.Y.b();
                this.Y.a();
            }
        }
    }
}
