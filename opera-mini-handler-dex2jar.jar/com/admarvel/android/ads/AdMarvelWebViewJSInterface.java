// 
// Decompiled by Procyon v0.6-prerelease
// 

package com.admarvel.android.ads;

import android.os.Environment;
import com.admarvel.android.util.b;
import com.admarvel.android.util.c;
import android.content.DialogInterface;
import android.content.DialogInterface$OnClickListener;
import android.app.AlertDialog$Builder;
import android.os.Handler;
import android.os.Looper;
import com.admarvel.android.util.Logging;
import com.admarvel.android.util.e;
import java.util.HashMap;
import android.app.Activity;
import android.webkit.JavascriptInterface;
import android.content.Context;
import java.lang.ref.WeakReference;

public class AdMarvelWebViewJSInterface
{
    private final WeakReference adMarvelActivityReference;
    final AdMarvelAd adMarvelAd;
    final WeakReference adMarvelInternalWebViewReference;
    private final WeakReference adMarvelWebViewReference;
    private final WeakReference contextReference;
    private boolean isInterstitial;
    private int lastOrientation;
    private String lockedOrientation;
    private String videoUrl;
    
    public AdMarvelWebViewJSInterface(final d d, final AdMarvelAd adMarvelAd, final AdMarvelActivity adMarvelActivity) {
        this.lockedOrientation = null;
        this.isInterstitial = false;
        this.adMarvelInternalWebViewReference = new WeakReference((T)d);
        this.adMarvelWebViewReference = null;
        this.contextReference = new WeakReference((T)adMarvelActivity);
        this.adMarvelAd = adMarvelAd;
        this.adMarvelActivityReference = new WeakReference((T)adMarvelActivity);
        this.isInterstitial = true;
        this.lastOrientation = adMarvelActivity.getRequestedOrientation();
    }
    
    public AdMarvelWebViewJSInterface(final d d, final AdMarvelAd adMarvelAd, final m m, final Context context) {
        this.lockedOrientation = null;
        this.isInterstitial = false;
        this.adMarvelInternalWebViewReference = new WeakReference((T)d);
        this.adMarvelWebViewReference = new WeakReference((T)m);
        this.contextReference = new WeakReference((T)context);
        this.adMarvelAd = adMarvelAd;
        this.adMarvelActivityReference = null;
        this.isInterstitial = false;
    }
    
    @JavascriptInterface
    public void admarvelCheckFrameValues(final String s) {
    }
    
    @JavascriptInterface
    public void checkForApplicationSupportedOrientations(final String s) {
        final d d = (d)this.adMarvelInternalWebViewReference.get();
        if (d != null && (d == null || !d.b())) {
            final Context context = d.getContext();
            if (context != null && context instanceof Activity) {
                final String[] split = r.a((Activity)context).split(",");
                final HashMap hashMap = new HashMap();
                hashMap.put("portrait", "NO");
                hashMap.put("landscapeLeft", "NO");
                hashMap.put("landscapeRight", "NO");
                hashMap.put("portraitUpsideDown", "NO");
                for (int length = split.length, i = 0; i < length; ++i) {
                    final String s2 = split[i];
                    if (s2.equals("0")) {
                        hashMap.put("portrait", "YES");
                    }
                    else if (s2.equals("90")) {
                        hashMap.put("landscapeLeft", "YES");
                    }
                    else if (s2.equals("-90")) {
                        hashMap.put("landscapeRight", "YES");
                    }
                    else if (s2.equals("180")) {
                        hashMap.put("portraitUpsideDown", "YES");
                    }
                }
                final String string = "\"{portrait:" + hashMap.get("portrait") + ",landscapeLeft:" + hashMap.get("landscapeLeft") + ",landscapeRight:" + hashMap.get("landscapeRight") + ",portraitUpsideDown:" + hashMap.get("portraitUpsideDown") + "}\"";
                if (d != null) {
                    d.e(s + "(" + string + ")");
                }
            }
        }
    }
    
    @JavascriptInterface
    public void checkFrameValues(final String s) {
        final d d = (d)this.adMarvelInternalWebViewReference.get();
        if (d != null && !d.b() && !this.isInterstitial) {
            final m m = (m)this.adMarvelWebViewReference.get();
            if (m != null) {
                e.a().b().execute(new m$e(s, d, m));
            }
        }
    }
    
    @JavascriptInterface
    public void checkNetworkAvailable(final String s) {
        final d d = (d)this.adMarvelInternalWebViewReference.get();
        if (d != null && !d.b()) {
            e.a().b().execute(new r$c(d, s));
        }
    }
    
    @JavascriptInterface
    public void cleanup() {
        if (!this.isInterstitial) {
            if (Version.getAndroidSDKVersion() >= 14) {
                Logging.log("window.ADMARVEL.cleanup()");
                final m m = (m)this.adMarvelWebViewReference.get();
                if (m != null && this.adMarvelInternalWebViewReference.get() != null) {
                    new Handler(Looper.getMainLooper()).post((Runnable)new m$f(m));
                }
            }
        }
        else {
            Logging.log("window.ADMARVEL.cleanup()");
            final AdMarvelActivity adMarvelActivity = (AdMarvelActivity)this.adMarvelActivityReference.get();
            if (adMarvelActivity != null && this.adMarvelInternalWebViewReference.get() != null) {
                adMarvelActivity.g.post((Runnable)new AdMarvelActivity$d(adMarvelActivity));
            }
        }
    }
    
    @JavascriptInterface
    public void close() {
        final d d = (d)this.adMarvelInternalWebViewReference.get();
        if ((d == null || !d.b()) && !this.isInterstitial) {
            final m m = (m)this.adMarvelWebViewReference.get();
            if (m != null) {
                new Handler(Looper.getMainLooper()).post((Runnable)new m$h(m));
            }
        }
    }
    
    @JavascriptInterface
    public void closeinterstitialad() {
        if (this.isInterstitial) {
            final AdMarvelActivity adMarvelActivity = (AdMarvelActivity)this.adMarvelActivityReference.get();
            if (adMarvelActivity != null) {
                final d d = (d)this.adMarvelInternalWebViewReference.get();
                if (d == null || !d.b()) {
                    adMarvelActivity.g();
                }
            }
        }
    }
    
    @JavascriptInterface
    public void createcalendarevent(final String s, final String s2, final String s3) {
        final Context context = (Context)this.contextReference.get();
        if (context != null) {
            final d d = (d)this.adMarvelInternalWebViewReference.get();
            if (d != null && !d.b() && r.c(context, "android.permission.READ_CALENDAR") && r.c(context, "android.permission.WRITE_CALENDAR") && context instanceof Activity) {
                final AlertDialog$Builder alertDialog$Builder = new AlertDialog$Builder((Context)context);
                alertDialog$Builder.setMessage((CharSequence)"Allow access to Calendar?").setCancelable(false).setPositiveButton((CharSequence)"Yes", (DialogInterface$OnClickListener)new DialogInterface$OnClickListener() {
                    public void onClick(final DialogInterface dialogInterface, final int n) {
                        if (Version.getAndroidSDKVersion() >= 14) {
                            com.admarvel.android.util.e.a().b().execute(new r$e(d, context, s, s2, s3));
                            return;
                        }
                        com.admarvel.android.util.e.a().b().execute(new r$d(d, context, s, s2, s3));
                    }
                }).setNegativeButton((CharSequence)"No", (DialogInterface$OnClickListener)new DialogInterface$OnClickListener() {
                    public void onClick(final DialogInterface dialogInterface, final int n) {
                        dialogInterface.cancel();
                    }
                });
                alertDialog$Builder.create().show();
            }
        }
    }
    
    @JavascriptInterface
    public void createcalendarevent(final String s, final String s2, final String s3, final String s4, final String s5, final String s6, final int n) {
        final Context context = (Context)this.contextReference.get();
        if (context != null) {
            final d d = (d)this.adMarvelInternalWebViewReference.get();
            if (d != null && !d.b() && r.c(context, "android.permission.READ_CALENDAR") && r.c(context, "android.permission.WRITE_CALENDAR") && context instanceof Activity) {
                final AlertDialog$Builder alertDialog$Builder = new AlertDialog$Builder((Context)context);
                alertDialog$Builder.setMessage((CharSequence)"Allow access to Calendar?").setCancelable(false).setPositiveButton((CharSequence)"Yes", (DialogInterface$OnClickListener)new DialogInterface$OnClickListener() {
                    public void onClick(final DialogInterface dialogInterface, final int n) {
                        if (Version.getAndroidSDKVersion() >= 14) {
                            com.admarvel.android.util.e.a().b().execute(new r$e(d, context, s, s2, s3, s4, s5, s6, n));
                            return;
                        }
                        com.admarvel.android.util.e.a().b().execute(new r$d(d, context, s, s2, s3, s4, s5, s6, n));
                    }
                }).setNegativeButton((CharSequence)"No", (DialogInterface$OnClickListener)new DialogInterface$OnClickListener() {
                    public void onClick(final DialogInterface dialogInterface, final int n) {
                        dialogInterface.cancel();
                    }
                });
                alertDialog$Builder.create().show();
            }
        }
    }
    
    @JavascriptInterface
    public void createcalendarevent(final String s, final String s2, final String s3, final String s4, final String s5, final String s6, final int n, final String s7, final String s8, final String s9, final String s10, final int n2, final int n3, final String s11) {
        final Context context = (Context)this.contextReference.get();
        if (context != null) {
            final d d = (d)this.adMarvelInternalWebViewReference.get();
            if (d != null && !d.b()) {
                if (!r.c(context, "android.permission.READ_CALENDAR") || !r.c(context, "android.permission.WRITE_CALENDAR")) {
                    if (s11 != null) {
                        d.e(s11 + "(NO)");
                    }
                }
                else {
                    if (context instanceof Activity) {
                        final AlertDialog$Builder alertDialog$Builder = new AlertDialog$Builder((Context)context);
                        alertDialog$Builder.setMessage((CharSequence)"Allow access to Calendar?").setCancelable(false).setPositiveButton((CharSequence)"Yes", (DialogInterface$OnClickListener)new DialogInterface$OnClickListener() {
                            public void onClick(final DialogInterface dialogInterface, final int n) {
                                if (Version.getAndroidSDKVersion() >= 14) {
                                    com.admarvel.android.util.e.a().b().execute(new r$e(d, context, s, s2, s3, s4, s5, s6, n, s7, s8, s9, s10, n2, n3, s11));
                                    return;
                                }
                                com.admarvel.android.util.e.a().b().execute(new r$d(d, context, s, s2, s3, s4, s5, s6, n, s7, s8, s9, s10, n2, n3, s11));
                            }
                        }).setNegativeButton((CharSequence)"No", (DialogInterface$OnClickListener)new DialogInterface$OnClickListener() {
                            public void onClick(final DialogInterface dialogInterface, final int n) {
                                if (s11 != null) {
                                    d.e(s11 + "(\"NO\")");
                                }
                                dialogInterface.cancel();
                            }
                        });
                        alertDialog$Builder.create().show();
                        return;
                    }
                    d.e(s11 + "(\"NO\")");
                }
            }
        }
    }
    
    @JavascriptInterface
    public void delaydisplay() {
        Label_0030: {
            if (this.adMarvelInternalWebViewReference == null) {
                break Label_0030;
            }
            final d d = (d)this.adMarvelInternalWebViewReference.get();
            if (d == null || !d.b()) {
                break Label_0030;
            }
            return;
        }
        if (this.isInterstitial) {
            return;
        }
        final m m = (m)this.adMarvelWebViewReference.get();
        if (m != null) {
            m.p.set(true);
        }
    }
    
    @JavascriptInterface
    public void detectlocation(final String s) {
        final d d = (d)this.adMarvelInternalWebViewReference.get();
        if (d != null && !d.b()) {
            final c a = c.a();
            if (a != null) {
                a.a(d, s);
            }
        }
    }
    
    @JavascriptInterface
    public void detectsizechange(final String n) {
        final d d = (d)this.adMarvelInternalWebViewReference.get();
        if (d != null && !d.b()) {
            d.n = n;
        }
    }
    
    @JavascriptInterface
    public void detectvisibility(final String j) {
        final d d = (d)this.adMarvelInternalWebViewReference.get();
        if (d != null && !d.b()) {
            d.j = j;
            if (this.isInterstitial && !d.k && d.m) {
                d.e(j + "(true)");
                d.k = true;
            }
        }
    }
    
    @JavascriptInterface
    public void disableRotationForExpand() {
        final d d = (d)this.adMarvelInternalWebViewReference.get();
        if ((d == null || !d.b()) && !this.isInterstitial) {
            final m m = (m)this.adMarvelWebViewReference.get();
            if (m != null) {
                m.w = true;
                this.lockedOrientation = null;
                if (m.x && m.y) {
                    this.disablerotations(this.lockedOrientation);
                }
            }
        }
    }
    
    @JavascriptInterface
    public void disableRotationForExpand(final String lockedOrientation) {
        final d d = (d)this.adMarvelInternalWebViewReference.get();
        if ((d == null || !d.b()) && !this.isInterstitial) {
            final m m = (m)this.adMarvelWebViewReference.get();
            if (m != null) {
                m.w = true;
                this.lockedOrientation = lockedOrientation;
                if (m.x && m.y) {
                    this.disablerotations(lockedOrientation);
                }
            }
        }
    }
    
    @JavascriptInterface
    public void disableautodetect() {
        final d d = (d)this.adMarvelInternalWebViewReference.get();
        if (d == null || !d.b()) {
            if (this.isInterstitial) {
                d.getEnableAutoDetect().set(false);
                return;
            }
            final m m = (m)this.adMarvelWebViewReference.get();
            if (m != null) {
                m.r.set(false);
            }
        }
    }
    
    @JavascriptInterface
    public void disablebackbutton() {
        if (this.isInterstitial) {
            final AdMarvelActivity adMarvelActivity = (AdMarvelActivity)this.adMarvelActivityReference.get();
            if (adMarvelActivity != null) {
                final d d = (d)this.adMarvelInternalWebViewReference.get();
                if (d != null && !d.b()) {
                    if (adMarvelActivity.f != null) {
                        adMarvelActivity.g.removeCallbacks(adMarvelActivity.f);
                    }
                    adMarvelActivity.d = true;
                }
            }
        }
    }
    
    @JavascriptInterface
    public void disablebackbutton(final int n) {
        if (this.isInterstitial) {
            final AdMarvelActivity adMarvelActivity = (AdMarvelActivity)this.adMarvelActivityReference.get();
            if (adMarvelActivity != null) {
                final d d = (d)this.adMarvelInternalWebViewReference.get();
                if (d != null && !d.b() && n > 0) {
                    adMarvelActivity.d = true;
                    if (adMarvelActivity.f != null) {
                        adMarvelActivity.g.removeCallbacks(adMarvelActivity.f);
                    }
                    adMarvelActivity.g.postDelayed(adMarvelActivity.f, (long)n);
                }
            }
        }
    }
    
    @JavascriptInterface
    public void disableclosebutton(final String s) {
        final d d = (d)this.adMarvelInternalWebViewReference.get();
        if ((d == null || !d.b()) && s != null && s.equals("true")) {
            this.sdkclosebutton("false", "false");
        }
    }
    
    @JavascriptInterface
    public void disablerotations() {
        final d d = (d)this.adMarvelInternalWebViewReference.get();
        if (d == null || !d.b()) {
            if (this.isInterstitial) {
                this.disablerotations(null);
                return;
            }
            final m m = (m)this.adMarvelWebViewReference.get();
            if (m != null) {
                final Context context = m.getContext();
                Activity activity;
                if (context != null && context instanceof Activity) {
                    activity = (Activity)context;
                }
                else {
                    activity = null;
                }
                if (activity != null) {
                    final int orientation = m.getResources().getConfiguration().orientation;
                    if (orientation == 1) {
                        activity.setRequestedOrientation(1);
                        return;
                    }
                    if (orientation == 2) {
                        activity.setRequestedOrientation(0);
                    }
                }
            }
        }
    }
    
    @JavascriptInterface
    public void disablerotations(final String s) {
        final d d = (d)this.adMarvelInternalWebViewReference.get();
        if (d == null || !d.b()) {
            if (!this.isInterstitial) {
                final m m = (m)this.adMarvelWebViewReference.get();
                if (m != null) {
                    final Activity activity = null;
                    final Context context = m.getContext();
                    Activity activity2 = activity;
                    if (context != null) {
                        activity2 = activity;
                        if (context instanceof Activity) {
                            activity2 = (Activity)context;
                        }
                    }
                    if (activity2 != null) {
                        int orientation;
                        if (Version.getAndroidSDKVersion() < 9) {
                            orientation = m.getResources().getConfiguration().orientation;
                        }
                        else {
                            final m$o m$o = new m$o(m);
                            e.a().b().execute(m$o);
                            int a = Integer.MIN_VALUE;
                            while (true) {
                                orientation = a;
                                if (a != Integer.MIN_VALUE) {
                                    break;
                                }
                                a = m$o.a();
                            }
                        }
                        if (s != null) {
                            if (!m.w) {
                                if (Version.getAndroidSDKVersion() < 9) {
                                    if (s.equalsIgnoreCase("Portrait") && orientation == 1) {
                                        activity2.setRequestedOrientation(1);
                                        return;
                                    }
                                    if (s.equalsIgnoreCase("LandscapeLeft") && orientation == 2) {
                                        activity2.setRequestedOrientation(0);
                                    }
                                }
                                else {
                                    if (s.equalsIgnoreCase("Portrait") && orientation == 0) {
                                        activity2.setRequestedOrientation(1);
                                        return;
                                    }
                                    if (s.equalsIgnoreCase("LandscapeLeft") && orientation == 1) {
                                        activity2.setRequestedOrientation(0);
                                    }
                                }
                            }
                            else {
                                if (Version.getAndroidSDKVersion() >= 9) {
                                    e.a().b().execute(new AdMarvelActivity$r(activity2, s));
                                    return;
                                }
                                if (s.equalsIgnoreCase("Portrait")) {
                                    activity2.setRequestedOrientation(1);
                                    return;
                                }
                                if (s.equalsIgnoreCase("LandscapeLeft")) {
                                    activity2.setRequestedOrientation(0);
                                }
                            }
                        }
                        else if (Version.getAndroidSDKVersion() < 9) {
                            if (orientation == 1) {
                                activity2.setRequestedOrientation(1);
                                return;
                            }
                            if (orientation == 2) {
                                activity2.setRequestedOrientation(0);
                            }
                        }
                        else {
                            if (orientation == 0) {
                                e.a().b().execute(new AdMarvelActivity$r(activity2, "Portrait"));
                                return;
                            }
                            if (orientation == 1) {
                                e.a().b().execute(new AdMarvelActivity$r(activity2, "LandscapeLeft"));
                                return;
                            }
                            e.a().b().execute(new AdMarvelActivity$r(activity2, "none"));
                        }
                    }
                }
            }
            else {
                final AdMarvelActivity adMarvelActivity = (AdMarvelActivity)this.adMarvelActivityReference.get();
                if (adMarvelActivity != null) {
                    this.lastOrientation = adMarvelActivity.getRequestedOrientation();
                    int orientation2;
                    if (Version.getAndroidSDKVersion() < 9) {
                        orientation2 = adMarvelActivity.getResources().getConfiguration().orientation;
                    }
                    else {
                        final AdMarvelActivity$k adMarvelActivity$k = new AdMarvelActivity$k(adMarvelActivity);
                        adMarvelActivity.g.post((Runnable)adMarvelActivity$k);
                        int a2 = Integer.MIN_VALUE;
                        while (true) {
                            orientation2 = a2;
                            if (a2 != Integer.MIN_VALUE) {
                                break;
                            }
                            a2 = adMarvelActivity$k.a();
                        }
                    }
                    if (s != null) {
                        if (Version.getAndroidSDKVersion() < 9) {
                            if (s.equalsIgnoreCase("Portrait")) {
                                adMarvelActivity.setRequestedOrientation(1);
                                return;
                            }
                            if (s.equalsIgnoreCase("LandscapeLeft")) {
                                adMarvelActivity.setRequestedOrientation(0);
                            }
                        }
                        else {
                            if (s.equalsIgnoreCase("Portrait")) {
                                adMarvelActivity.setRequestedOrientation(1);
                                return;
                            }
                            if (s.equalsIgnoreCase("LandscapeLeft")) {
                                adMarvelActivity.setRequestedOrientation(0);
                                return;
                            }
                            adMarvelActivity.g.post((Runnable)new AdMarvelActivity$r(adMarvelActivity, s));
                        }
                    }
                    else if (Version.getAndroidSDKVersion() < 9) {
                        if (orientation2 == 1) {
                            adMarvelActivity.setRequestedOrientation(1);
                            return;
                        }
                        if (orientation2 == 2) {
                            adMarvelActivity.setRequestedOrientation(0);
                        }
                    }
                    else {
                        if (orientation2 == 0) {
                            adMarvelActivity.g.post((Runnable)new AdMarvelActivity$r(adMarvelActivity, "Portrait"));
                            return;
                        }
                        if (orientation2 == 1) {
                            adMarvelActivity.g.post((Runnable)new AdMarvelActivity$r(adMarvelActivity, "LandscapeLeft"));
                            return;
                        }
                        adMarvelActivity.g.post((Runnable)new AdMarvelActivity$r(adMarvelActivity, "none"));
                    }
                }
            }
        }
    }
    
    @JavascriptInterface
    public void enableVideoCloseInBackground() {
        final AdMarvelActivity adMarvelActivity = (AdMarvelActivity)this.adMarvelActivityReference.get();
        if (adMarvelActivity == null) {
            return;
        }
        adMarvelActivity.t = true;
    }
    
    @JavascriptInterface
    public void enableautodetect() {
        final d d = (d)this.adMarvelInternalWebViewReference.get();
        if (d == null || !d.b()) {
            if (this.isInterstitial) {
                d.getEnableAutoDetect().set(true);
                return;
            }
            final m m = (m)this.adMarvelWebViewReference.get();
            if (m != null) {
                m.r.set(true);
            }
        }
    }
    
    @JavascriptInterface
    public void enablebackbutton() {
        if (this.isInterstitial) {
            final AdMarvelActivity adMarvelActivity = (AdMarvelActivity)this.adMarvelActivityReference.get();
            if (adMarvelActivity != null) {
                final d d = (d)this.adMarvelInternalWebViewReference.get();
                if (d != null && !d.b()) {
                    adMarvelActivity.d = false;
                }
            }
        }
    }
    
    @JavascriptInterface
    public void enablerotations() {
        final d d = (d)this.adMarvelInternalWebViewReference.get();
        if (d == null || !d.b()) {
            if (!this.isInterstitial) {
                final m m = (m)this.adMarvelWebViewReference.get();
                if (m != null) {
                    final Context context = m.getContext();
                    Activity activity;
                    if (context != null && context instanceof Activity) {
                        activity = (Activity)context;
                    }
                    else {
                        activity = null;
                    }
                    if (activity != null) {
                        activity.setRequestedOrientation(m.t);
                        m.w = false;
                    }
                }
            }
            else {
                final AdMarvelActivity adMarvelActivity = (AdMarvelActivity)this.adMarvelActivityReference.get();
                if (adMarvelActivity != null) {
                    adMarvelActivity.setRequestedOrientation(this.lastOrientation);
                }
            }
        }
    }
    
    @JavascriptInterface
    public void expandto(final int n, final int n2) {
        final d d = (d)this.adMarvelInternalWebViewReference.get();
        if ((d == null || !d.b()) && !this.isInterstitial) {
            final m m = (m)this.adMarvelWebViewReference.get();
            if (m != null) {
                final Context context = d.getContext();
                if (context != null && context instanceof Activity) {
                    final Activity activity = (Activity)context;
                    if (m.x) {
                        new Handler(Looper.getMainLooper()).post((Runnable)new m$j(m, activity, n, n2));
                        return;
                    }
                    new Handler(Looper.getMainLooper()).post((Runnable)new m$k(m, activity, n, n2, this.adMarvelAd));
                }
            }
        }
    }
    
    @JavascriptInterface
    public void expandto(final int n, final int n2, final int n3, final int n4, final String l, final String s) {
        final d d = (d)this.adMarvelInternalWebViewReference.get();
        if ((d == null || !d.b()) && !this.isInterstitial) {
            final m m = (m)this.adMarvelWebViewReference.get();
            if (m != null) {
                final Context context = d.getContext();
                if (context != null && context instanceof Activity) {
                    final Activity activity = (Activity)context;
                    if (s != null && s.length() > 0) {
                        this.expandtofullscreen(l, s);
                        return;
                    }
                    if (l != null) {
                        m.l = l;
                    }
                    if (m.x) {
                        new Handler(Looper.getMainLooper()).post((Runnable)new m$j(m, activity, n, n2, n3, n4));
                        return;
                    }
                    new Handler(Looper.getMainLooper()).post((Runnable)new m$k(m, activity, n, n2, n3, n4, this.adMarvelAd));
                }
            }
        }
    }
    
    @JavascriptInterface
    public void expandto(final int n, final int n2, final String l, final String s) {
        final d d = (d)this.adMarvelInternalWebViewReference.get();
        if ((d == null || !d.b()) && !this.isInterstitial) {
            final m m = (m)this.adMarvelWebViewReference.get();
            if (m != null) {
                final Context context = d.getContext();
                if (context != null && context instanceof Activity) {
                    final Activity activity = (Activity)context;
                    if (s != null && s.length() > 0) {
                        this.expandtofullscreen(l, s);
                        return;
                    }
                    if (l != null) {
                        m.l = l;
                    }
                    if (m.x) {
                        new Handler(Looper.getMainLooper()).post((Runnable)new m$j(m, activity, n, n2));
                        return;
                    }
                    new Handler(Looper.getMainLooper()).post((Runnable)new m$k(m, activity, n, n2, this.adMarvelAd));
                }
            }
        }
    }
    
    @JavascriptInterface
    public void expandtofullscreen() {
        final d d = (d)this.adMarvelInternalWebViewReference.get();
        if ((d == null || !d.b()) && !this.isInterstitial) {
            final m m = (m)this.adMarvelWebViewReference.get();
            if (m != null) {
                final Context context = d.getContext();
                if (context != null && context instanceof Activity) {
                    final Activity activity = (Activity)context;
                    m.y = true;
                    if (m.w) {
                        this.disablerotations(this.lockedOrientation);
                    }
                    if (m.x) {
                        new Handler(Looper.getMainLooper()).post((Runnable)new m$j(m, activity, 0, 0, -1, -1));
                        return;
                    }
                    new Handler(Looper.getMainLooper()).post((Runnable)new m$k(m, activity, 0, 0, -1, -1, this.adMarvelAd));
                }
            }
        }
    }
    
    @JavascriptInterface
    public void expandtofullscreen(final String l) {
        final d d = (d)this.adMarvelInternalWebViewReference.get();
        if ((d == null || !d.b()) && !this.isInterstitial) {
            final m m = (m)this.adMarvelWebViewReference.get();
            if (m != null) {
                final Context context = d.getContext();
                if (context != null && context instanceof Activity) {
                    final Activity activity = (Activity)context;
                    m.y = true;
                    if (l != null) {
                        m.l = l;
                    }
                    if (m.w) {
                        this.disablerotations(this.lockedOrientation);
                    }
                    if (m.x) {
                        new Handler(Looper.getMainLooper()).post((Runnable)new m$j(m, activity, 0, 0, -1, -1));
                        return;
                    }
                    new Handler(Looper.getMainLooper()).post((Runnable)new m$k(m, activity, 0, 0, -1, -1, this.adMarvelAd));
                }
            }
        }
    }
    
    @JavascriptInterface
    public void expandtofullscreen(final String l, final String m) {
        final d d = (d)this.adMarvelInternalWebViewReference.get();
        if ((d == null || !d.b()) && !this.isInterstitial) {
            final m i = (m)this.adMarvelWebViewReference.get();
            if (i != null) {
                final Context context = d.getContext();
                Activity activity = null;
                if (context != null && context instanceof Activity) {
                    activity = (Activity)context;
                }
                else {
                    if (m == null) {
                        return;
                    }
                    if (m.length() == 0) {
                        return;
                    }
                }
                if (l != null) {
                    i.l = l;
                }
                i.y = true;
                if (m != null && m.length() > 0) {
                    i.m = m;
                    i.n = true;
                }
                if (i.w) {
                    if (i.n) {
                        if (this.lockedOrientation != null && this.lockedOrientation.length() > 0) {
                            i.o = this.lockedOrientation;
                        }
                        else {
                            i.o = "Current";
                        }
                    }
                    else {
                        this.disablerotations(this.lockedOrientation);
                    }
                }
                if (m != null && m.length() > 0) {
                    new Handler(Looper.getMainLooper()).post((Runnable)new m$l(i, m, this.adMarvelAd));
                    return;
                }
                if (i.x) {
                    new Handler(Looper.getMainLooper()).post((Runnable)new m$j(i, activity, 0, 0, -1, -1));
                    return;
                }
                new Handler(Looper.getMainLooper()).post((Runnable)new m$k(i, activity, 0, 0, -1, -1, this.adMarvelAd));
            }
        }
    }
    
    @JavascriptInterface
    public void fetchWebViewHtmlContent(final String htmlJson) {
        if (this.adMarvelAd != null) {
            this.adMarvelAd.setHtmlJson(htmlJson);
        }
    }
    
    @JavascriptInterface
    public void finishVideo() {
        if (!this.isInterstitial && Version.getAndroidSDKVersion() >= 14) {
            Logging.log("window.ADMARVEL.finishVideo()");
            final m m = (m)this.adMarvelWebViewReference.get();
            if (m != null && this.adMarvelInternalWebViewReference.get() != null) {
                new Handler(Looper.getMainLooper()).post((Runnable)new m$m(m));
            }
        }
    }
    
    @JavascriptInterface
    public void firePixel(final String s) {
        final d d = (d)this.adMarvelInternalWebViewReference.get();
        if (d != null && !d.b()) {
            if (!this.isInterstitial) {
                final m m = (m)this.adMarvelWebViewReference.get();
                if (m != null) {
                    e.a().b().execute(new m$n(d, m, s));
                }
            }
            else {
                final AdMarvelActivity adMarvelActivity = (AdMarvelActivity)this.adMarvelActivityReference.get();
                if (adMarvelActivity != null) {
                    adMarvelActivity.g.post((Runnable)new AdMarvelActivity$j(d, adMarvelActivity, s));
                }
            }
        }
    }
    
    @JavascriptInterface
    public int getAndroidOSVersionAPI() {
        return Version.getAndroidSDKVersion();
    }
    
    @JavascriptInterface
    public void getLocation(final String s) {
        final d d = (d)this.adMarvelInternalWebViewReference.get();
        if (d != null && !d.b()) {
            e.a().b().execute(new r$i(d, s));
        }
    }
    
    @JavascriptInterface
    public void initAdMarvel(final String s) {
        final d d = (d)this.adMarvelInternalWebViewReference.get();
        if (d != null && !d.b()) {
            if (!this.isInterstitial) {
                final m m = (m)this.adMarvelWebViewReference.get();
                if (m != null) {
                    e.a().b().execute(new m$p(s, d, m));
                }
            }
            else {
                final AdMarvelActivity adMarvelActivity = (AdMarvelActivity)this.adMarvelActivityReference.get();
                if (adMarvelActivity != null) {
                    adMarvelActivity.g.post((Runnable)new AdMarvelActivity$m(s, d, adMarvelActivity));
                }
            }
        }
    }
    
    @JavascriptInterface
    public void initVideo(final String z) {
        if (!this.isInterstitial && Version.getAndroidSDKVersion() >= 14) {
            Logging.log("window.ADMARVEL.setVideoUrl(\"" + z + "\")");
            final m m = (m)this.adMarvelWebViewReference.get();
            if (m != null) {
                m.z = z;
                final d d = (d)this.adMarvelInternalWebViewReference.get();
                if (d != null && !d.b() && m.z != null && m.z.length() > 0) {
                    new Handler(Looper.getMainLooper()).post((Runnable)new m$q(z, m, d));
                }
            }
        }
    }
    
    @JavascriptInterface
    public int isInterstitial() {
        if (this.isInterstitial) {
            return 1;
        }
        return 0;
    }
    
    @JavascriptInterface
    public int isinitialload() {
        return 1;
    }
    
    @JavascriptInterface
    public int isinstalled(final String s) {
        final d d = (d)this.adMarvelInternalWebViewReference.get();
        if (d == null) {
            return 0;
        }
        if (d != null && d.b()) {
            return 0;
        }
        if (r.a(d.getContext(), s)) {
            return 1;
        }
        return 0;
    }
    
    @JavascriptInterface
    public int isvideocached() {
        if (this.isInterstitial) {
            return 0;
        }
        if (Version.getAndroidSDKVersion() < 14) {
            return 0;
        }
        Logging.log("window.ADMARVEL.isvideocached()");
        final m m = (m)this.adMarvelWebViewReference.get();
        if (m == null) {
            return 0;
        }
        if (Version.getAndroidSDKVersion() >= 14) {
            return new m$r().a(m);
        }
        return 0;
    }
    
    @JavascriptInterface
    public void loadVideo() {
        if (!this.isInterstitial) {
            if (Version.getAndroidSDKVersion() >= 14) {
                Logging.log("window.ADMARVEL.loadVideo()");
                final m m = (m)this.adMarvelWebViewReference.get();
                if (m != null) {
                    final d d = (d)this.adMarvelInternalWebViewReference.get();
                    if (d != null && !d.b() && m.z != null && m.z.length() > 0) {
                        new Handler(Looper.getMainLooper()).post((Runnable)new m$s(m.z, m, d));
                    }
                }
            }
        }
        else {
            Logging.log("window.ADMARVEL.loadVideo()");
            final AdMarvelActivity adMarvelActivity = (AdMarvelActivity)this.adMarvelActivityReference.get();
            if (adMarvelActivity != null) {
                final d d2 = (d)this.adMarvelInternalWebViewReference.get();
                if (d2 != null) {
                    adMarvelActivity.j = true;
                    if (this.videoUrl != null && this.videoUrl.length() > 0) {
                        adMarvelActivity.g.post((Runnable)new AdMarvelActivity$n(this.videoUrl, adMarvelActivity, d2));
                    }
                }
            }
        }
    }
    
    @JavascriptInterface
    public void notifyInAppBrowserCloseAction(final String u) {
        final d d = (d)this.adMarvelInternalWebViewReference.get();
        if (d != null && !d.b()) {
            d.u = u;
        }
    }
    
    @JavascriptInterface
    public void notifyInterstitialBackgroundState(final String s) {
        if (s != null && s.length() > 0) {
            final AdMarvelActivity adMarvelActivity = (AdMarvelActivity)this.adMarvelActivityReference.get();
            if (adMarvelActivity != null) {
                adMarvelActivity.s = s;
            }
        }
    }
    
    @JavascriptInterface
    public void pauseVideo() {
        if (!this.isInterstitial) {
            if (Version.getAndroidSDKVersion() >= 14) {
                Logging.log("window.ADMARVEL.pauseVideo()");
                final m m = (m)this.adMarvelWebViewReference.get();
                if (m != null) {
                    final d d = (d)this.adMarvelInternalWebViewReference.get();
                    if (d != null) {
                        new Handler(Looper.getMainLooper()).post((Runnable)new m$v(m, d));
                    }
                }
            }
        }
        else {
            Logging.log("window.ADMARVEL.pauseVideo()");
            final AdMarvelActivity adMarvelActivity = (AdMarvelActivity)this.adMarvelActivityReference.get();
            if (adMarvelActivity != null) {
                final d d2 = (d)this.adMarvelInternalWebViewReference.get();
                if (d2 != null) {
                    adMarvelActivity.g.post((Runnable)new AdMarvelActivity$o(adMarvelActivity, d2));
                }
            }
        }
    }
    
    @JavascriptInterface
    public void playVideo() {
        if (!this.isInterstitial) {
            if (Version.getAndroidSDKVersion() >= 14) {
                Logging.log("window.ADMARVEL.playVideo()");
                final m m = (m)this.adMarvelWebViewReference.get();
                if (m != null) {
                    final d d = (d)this.adMarvelInternalWebViewReference.get();
                    if (d != null && m.z != null && m.z.length() > 0) {
                        new Handler(Looper.getMainLooper()).post((Runnable)new m$w(m, d));
                    }
                }
            }
        }
        else {
            Logging.log("window.ADMARVEL.playVideo()");
            final AdMarvelActivity adMarvelActivity = (AdMarvelActivity)this.adMarvelActivityReference.get();
            if (adMarvelActivity != null) {
                final d d2 = (d)this.adMarvelInternalWebViewReference.get();
                if (d2 != null && this.videoUrl != null && this.videoUrl.length() > 0) {
                    adMarvelActivity.g.post((Runnable)new AdMarvelActivity$p(adMarvelActivity, d2));
                }
            }
        }
    }
    
    @JavascriptInterface
    public void readyfordisplay() {
        Label_0030: {
            if (this.adMarvelInternalWebViewReference == null) {
                break Label_0030;
            }
            final d d = (d)this.adMarvelInternalWebViewReference.get();
            if (d == null || !d.b()) {
                break Label_0030;
            }
            return;
        }
        if (this.isInterstitial) {
            return;
        }
        final m m = (m)this.adMarvelWebViewReference.get();
        if (m == null) {
            return;
        }
        if (!m.q.get()) {
            m.p.set(false);
            return;
        }
        if (m.b.compareAndSet(true, false) && com.admarvel.android.ads.m.a(m.s) != null) {
            com.admarvel.android.ads.m.a(m.s).a(m, this.adMarvelAd);
        }
    }
    
    @JavascriptInterface
    public void redirect(final String s) {
        final d d = (d)this.adMarvelInternalWebViewReference.get();
        if (d == null || !d.b()) {
            if (!this.isInterstitial) {
                final m m = (m)this.adMarvelWebViewReference.get();
                if (m != null && d != null && (d.c() || (s != null && s.length() > 0 && (s.startsWith("admarvelsdk") || s.startsWith("admarvelinternal"))))) {
                    m.c(s);
                }
            }
            else {
                final AdMarvelActivity adMarvelActivity = (AdMarvelActivity)this.adMarvelActivityReference.get();
                if (adMarvelActivity != null && s != null && s.length() > 0) {
                    adMarvelActivity.g.post((Runnable)new AdMarvelRedirectRunnable(s, (Context)adMarvelActivity, this.adMarvelAd, "interstitial", adMarvelActivity.h, AdMarvelInterstitialAds.getEnableClickRedirect(), AdMarvelInterstitialAds.enableOfflineSDK, false));
                }
            }
        }
    }
    
    @JavascriptInterface
    public void registerEventsForAdMarvelVideo(final String s, final String s2) {
        if (!this.isInterstitial) {
            if (Version.getAndroidSDKVersion() >= 14 && s != null && s.length() != 0 && s2 != null && s2.length() != 0) {
                final m m = (m)this.adMarvelWebViewReference.get();
                if (m != null) {
                    if (s.equals("loadeddata")) {
                        m.F = s2;
                        return;
                    }
                    if (s.equals("play")) {
                        m.G = s2;
                        return;
                    }
                    if (s.equals("canplay")) {
                        m.H = s2;
                        return;
                    }
                    if (s.equals("timeupdate")) {
                        m.I = s2;
                        return;
                    }
                    if (s.equals("ended")) {
                        m.J = s2;
                        return;
                    }
                    if (s.equals("pause")) {
                        m.K = s2;
                        return;
                    }
                    if (s.equals("resume")) {
                        m.L = s2;
                        return;
                    }
                    if (s.equals("stop")) {
                        m.M = s2;
                        return;
                    }
                    if (s.equals("error")) {
                        m.N = s2;
                    }
                }
            }
        }
        else if (s != null && s.length() != 0 && s2 != null && s2.length() != 0) {
            final AdMarvelActivity adMarvelActivity = (AdMarvelActivity)this.adMarvelActivityReference.get();
            if (adMarvelActivity != null) {
                if (s.equals("loadeddata")) {
                    adMarvelActivity.k = s2;
                    return;
                }
                if (s.equals("play")) {
                    adMarvelActivity.l = s2;
                    return;
                }
                if (s.equals("canplay")) {
                    adMarvelActivity.m = s2;
                    return;
                }
                if (s.equals("timeupdate")) {
                    adMarvelActivity.n = s2;
                    return;
                }
                if (s.equals("ended")) {
                    adMarvelActivity.o = s2;
                    return;
                }
                if (s.equals("pause")) {
                    adMarvelActivity.p = s2;
                    return;
                }
                if (s.equals("error")) {
                    adMarvelActivity.q = s2;
                }
            }
        }
    }
    
    @JavascriptInterface
    public void registerInterstitialCloseCallback(final String r) {
        if (r != null && r.length() > 0) {
            final AdMarvelActivity adMarvelActivity = (AdMarvelActivity)this.adMarvelActivityReference.get();
            if (adMarvelActivity != null) {
                adMarvelActivity.r = r;
            }
        }
    }
    
    @JavascriptInterface
    public void registeraccelerationevent(final String s) {
        final Context context = (Context)this.contextReference.get();
        if (context != null) {
            final d d = (d)this.adMarvelInternalWebViewReference.get();
            if (d != null && !d.b()) {
                final com.admarvel.android.util.d a = com.admarvel.android.util.d.a();
                if (a != null && a.a(context)) {
                    a.b(s);
                    a.a(context, d);
                }
            }
        }
    }
    
    @JavascriptInterface
    public void registerheadingevent(final String s) {
        final Context context = (Context)this.contextReference.get();
        if (context != null) {
            final d d = (d)this.adMarvelInternalWebViewReference.get();
            if (d != null && !d.b()) {
                final com.admarvel.android.util.d a = com.admarvel.android.util.d.a();
                if (a != null && a.a(context)) {
                    a.c(s);
                    a.a(context, d);
                }
            }
        }
    }
    
    @JavascriptInterface
    public void registernetworkchangeevent(final String s) {
        final d d = (d)this.adMarvelInternalWebViewReference.get();
        if (d != null && !d.b()) {
            b.a(d, s);
        }
    }
    
    @JavascriptInterface
    public void registershakeevent(final String s, final String s2, final String s3) {
        final Context context = (Context)this.contextReference.get();
        if (context != null) {
            final d d = (d)this.adMarvelInternalWebViewReference.get();
            if (d != null && !d.b()) {
                final com.admarvel.android.util.d a = com.admarvel.android.util.d.a();
                if (a != null && a.a(context)) {
                    a.a(s);
                    a.a(s2, s3);
                    a.a(context, d);
                }
            }
        }
    }
    
    @JavascriptInterface
    public void reportAdMarvelAdHistory() {
        final Context context = (Context)this.contextReference.get();
        if (context != null) {
            AdMarvelUtils.reportAdMarvelAdHistory(context);
        }
    }
    
    @JavascriptInterface
    public void reportAdMarvelAdHistory(final int n) {
        final Context context = (Context)this.contextReference.get();
        if (context != null) {
            AdMarvelUtils.reportAdMarvelAdHistory(n, context);
        }
    }
    
    @JavascriptInterface
    public void resumeVideo() {
        if (!this.isInterstitial && Version.getAndroidSDKVersion() >= 14) {
            Logging.log("window.ADMARVEL.resumeVideo()");
            final m m = (m)this.adMarvelWebViewReference.get();
            if (m != null) {
                final d d = (d)this.adMarvelInternalWebViewReference.get();
                if (d != null) {
                    new Handler(Looper.getMainLooper()).post((Runnable)new m$y(m, d));
                }
            }
        }
    }
    
    @JavascriptInterface
    public void sdkclosebutton(final String s, final String s2) {
        final d d = (d)this.adMarvelInternalWebViewReference.get();
        if (d == null || !d.b()) {
            if (!this.isInterstitial) {
                final m m = (m)this.adMarvelWebViewReference.get();
                if (m != null) {
                    m.g = false;
                    m.h = false;
                    m.i = false;
                    if (s != null && s.equals("true")) {
                        m.g = true;
                        m.i = true;
                        return;
                    }
                    if (s != null && s.equals("false") && s2 != null && s2.equals("true")) {
                        m.g = true;
                        m.h = true;
                        m.i = false;
                    }
                }
            }
            else if (s != null && s.equals("false")) {
                if (s2 != null && s2.equals("true")) {
                    if (d != null) {
                        d.a(true);
                    }
                }
                else if (d != null) {
                    d.a(false);
                }
            }
            else if (s != null && s.equals("true")) {
                d.m();
            }
        }
    }
    
    @JavascriptInterface
    public void sdkclosebutton(final String s, final String s2, final String j) {
        final d d = (d)this.adMarvelInternalWebViewReference.get();
        if ((d == null || !d.b()) && !this.isInterstitial) {
            final m m = (m)this.adMarvelWebViewReference.get();
            if (m != null) {
                m.g = false;
                m.h = false;
                m.i = false;
                if (s != null && s.equals("true")) {
                    m.g = true;
                    m.i = true;
                }
                else if (s != null && s.equals("false") && s2 != null && s2.equals("true")) {
                    m.g = true;
                    m.h = true;
                    m.i = false;
                }
                if (j != null && j.length() > 0) {
                    m.j = j;
                }
            }
        }
    }
    
    @JavascriptInterface
    public void seekVideoTo(final float n) {
        if (!this.isInterstitial) {
            if (Version.getAndroidSDKVersion() >= 14) {
                Logging.log("window.ADMARVEL.seekToVideo()");
                final m m = (m)this.adMarvelWebViewReference.get();
                if (m != null) {
                    final d d = (d)this.adMarvelInternalWebViewReference.get();
                    if (d != null && m.z != null && m.z.length() > 0) {
                        new Handler(Looper.getMainLooper()).post((Runnable)new m$z(m, d, n));
                    }
                }
            }
        }
        else {
            Logging.log("window.ADMARVEL.seekToVideo()");
            final AdMarvelActivity adMarvelActivity = (AdMarvelActivity)this.adMarvelActivityReference.get();
            if (adMarvelActivity != null) {
                final d d2 = (d)this.adMarvelInternalWebViewReference.get();
                if (d2 != null && this.videoUrl != null && this.videoUrl.length() > 0) {
                    adMarvelActivity.g.post((Runnable)new AdMarvelActivity$q(adMarvelActivity, d2, n));
                }
            }
        }
    }
    
    @JavascriptInterface
    public void setInitialAudioState(final String s) {
        if (!this.isInterstitial && Version.getAndroidSDKVersion() >= 14) {
            Logging.log("window.ADMARVEL.setInitialAudioState()");
            final m m = (m)this.adMarvelWebViewReference.get();
            if (m != null && s != null && s.trim().length() > 0) {
                if (s.equalsIgnoreCase("mute")) {
                    m.P = true;
                    return;
                }
                if (s.equalsIgnoreCase("unmute")) {
                    m.P = false;
                }
            }
        }
    }
    
    @JavascriptInterface
    public void setVideoContainerHeight(final int e) {
        if (!this.isInterstitial && Version.getAndroidSDKVersion() >= 14) {
            Logging.log("ADMARVEL.setVideoContainerHeight " + e);
            final m m = (m)this.adMarvelWebViewReference.get();
            if (m != null) {
                m.E = e;
            }
        }
    }
    
    @JavascriptInterface
    public void setVideoDimensions(final int c, final int d, final int a, final int b) {
        if (!this.isInterstitial) {
            Logging.log("ADMARVEL.setVideoDimensions " + c + " " + d + " " + a + " " + b);
            final m m = (m)this.adMarvelWebViewReference.get();
            if (m != null && Version.getAndroidSDKVersion() >= 14) {
                m.A = a;
                m.B = b;
                m.C = c;
                m.D = d;
                final d d2 = (d)this.adMarvelInternalWebViewReference.get();
                if (d2 != null && !d2.b()) {
                    new Handler(Looper.getMainLooper()).post((Runnable)new m$x(m, d2, c, d, a, b));
                }
            }
        }
    }
    
    @JavascriptInterface
    public void setVideoUrl(final String videoUrl) {
        if (this.isInterstitial) {
            Logging.log("window.ADMARVEL.setVideoUrl(\"" + videoUrl + "\")");
            final AdMarvelActivity adMarvelActivity = (AdMarvelActivity)this.adMarvelActivityReference.get();
            if (adMarvelActivity != null) {
                this.videoUrl = videoUrl;
                adMarvelActivity.j = true;
            }
        }
    }
    
    @JavascriptInterface
    public void setbackgroundcolor(final String s) {
        final d d = (d)this.adMarvelInternalWebViewReference.get();
        if (d != null && !d.b()) {
            int n;
            if ("0".equals(s)) {
                n = 0;
            }
            else {
                final long long1 = Long.parseLong(s.replace("#", ""), 16);
                long n2 = 0L;
                Label_0110: {
                    if (s.length() != 7) {
                        n2 = long1;
                        if (s.length() != 6) {
                            break Label_0110;
                        }
                    }
                    n2 = (long1 | 0xFFFFFFFFFF000000L);
                }
                n = (int)n2;
            }
            d.setBackgroundColor(n);
            if (!this.isInterstitial) {
                final m m = (m)this.adMarvelWebViewReference.get();
                if (m != null) {
                    m.c = n;
                    new Handler(Looper.getMainLooper()).post((Runnable)new m$aa(m));
                }
            }
        }
    }
    
    @JavascriptInterface
    public void setsoftwarelayer() {
        final d d = (d)this.adMarvelInternalWebViewReference.get();
        if (d == null || d.b() || Version.getAndroidSDKVersion() < 11 || this.isInterstitial || this.adMarvelWebViewReference.get() == null) {
            return;
        }
        new Handler(Looper.getMainLooper()).post((Runnable)new m$af(d));
    }
    
    @JavascriptInterface
    public void stopVideo() {
        if (!this.isInterstitial) {
            if (Version.getAndroidSDKVersion() >= 14) {
                Logging.log("window.ADMARVEL.stopVideo()");
                final m m = (m)this.adMarvelWebViewReference.get();
                if (m != null) {
                    final d d = (d)this.adMarvelInternalWebViewReference.get();
                    if (d != null) {
                        new Handler(Looper.getMainLooper()).post((Runnable)new m$ab(m, d));
                    }
                }
            }
        }
        else {
            Logging.log("window.ADMARVEL.stopVideo()");
            final AdMarvelActivity adMarvelActivity = (AdMarvelActivity)this.adMarvelActivityReference.get();
            if (adMarvelActivity != null) {
                final d d2 = (d)this.adMarvelInternalWebViewReference.get();
                if (d2 != null) {
                    adMarvelActivity.g.post((Runnable)new AdMarvelActivity$s(adMarvelActivity, d2));
                }
            }
        }
    }
    
    @JavascriptInterface
    public void storepicture(String a, final String s) {
        final Context context = (Context)this.contextReference.get();
        if (context != null) {
            final d d = (d)this.adMarvelInternalWebViewReference.get();
            if (d != null && !d.b()) {
                a = r.a(a, context);
                if (!r.c(d.getContext(), "android.permission.WRITE_EXTERNAL_STORAGE") || !"mounted".equals(Environment.getExternalStorageState())) {
                    if (s != null) {
                        d.e(s + "(NO)");
                    }
                }
                else {
                    if (context instanceof Activity) {
                        final AlertDialog$Builder alertDialog$Builder = new AlertDialog$Builder((Context)context);
                        alertDialog$Builder.setMessage((CharSequence)"Allow storing image in your Gallery?").setCancelable(false).setPositiveButton((CharSequence)"Yes", (DialogInterface$OnClickListener)new DialogInterface$OnClickListener() {
                            public void onClick(final DialogInterface dialogInterface, final int n) {
                                if (Version.getAndroidSDKVersion() < 8) {
                                    e.a().b().execute(new r$l(d, a, s));
                                    return;
                                }
                                e.a().b().execute(new r$k(d, a, s));
                            }
                        }).setNegativeButton((CharSequence)"No", (DialogInterface$OnClickListener)new DialogInterface$OnClickListener() {
                            public void onClick(final DialogInterface dialogInterface, final int n) {
                                if (s != null) {
                                    d.e(s + "(\"NO\")");
                                }
                                dialogInterface.cancel();
                            }
                        });
                        alertDialog$Builder.create().show();
                        return;
                    }
                    d.e(s + "(\"NO\")");
                }
            }
        }
    }
    
    @JavascriptInterface
    public void triggerVibration(final String s) {
        int n = 10000;
    Label_0036:
        while (true) {
            Label_0059: {
                if (s == null || s.trim().length() <= 0) {
                    break Label_0059;
                }
                while (true) {
                    int int1 = 0;
                    Label_0066: {
                        try {
                            int1 = Integer.parseInt(s);
                            if (int1 > 10000) {
                                Logging.log("Time mentioned is greater than Max duration ");
                                r.a((Context)this.contextReference.get(), n);
                                return;
                            }
                            break Label_0066;
                        }
                        catch (NumberFormatException ex) {
                            Logging.log("NumberFormatException so setting vibrate time to 500 Milli Sec");
                        }
                        break;
                    }
                    n = int1;
                    continue Label_0036;
                }
            }
            n = 500;
            continue Label_0036;
        }
    }
    
    @JavascriptInterface
    public void updateAudioState(final String s) {
        if (!this.isInterstitial && Version.getAndroidSDKVersion() >= 14) {
            Logging.log("window.ADMARVEL.updateAudioState()");
            final m m = (m)this.adMarvelWebViewReference.get();
            if (m != null) {
                new Handler(Looper.getMainLooper()).post((Runnable)new m$ad(m, s));
            }
        }
    }
    
    @JavascriptInterface
    public void updatestate(final String s) {
        final d d = (d)this.adMarvelInternalWebViewReference.get();
        if ((d == null || !d.b()) && !this.isInterstitial) {
            final m m = (m)this.adMarvelWebViewReference.get();
            if (m != null) {
                new Handler(Looper.getMainLooper()).post((Runnable)new m$ae(s, m));
            }
        }
    }
}
