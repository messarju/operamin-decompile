// 
// Decompiled by Procyon v0.6-prerelease
// 

package com.admarvel.android.ads;

import java.util.Map;
import android.content.Intent;
import android.annotation.SuppressLint;
import com.admarvel.android.util.Logging;
import android.widget.ViewSwitcher;
import android.graphics.drawable.StateListDrawable;
import android.graphics.Shader;
import android.graphics.LinearGradient;
import android.graphics.Shader$TileMode;
import android.graphics.drawable.BitmapDrawable;
import android.widget.ImageView;
import com.admarvel.android.util.AdMarvelBitmapDrawableUtils;
import android.graphics.Typeface;
import android.widget.TextView;
import android.widget.RelativeLayout$LayoutParams;
import android.util.TypedValue;
import android.view.ViewGroup;
import android.graphics.drawable.Drawable;
import android.graphics.Color;
import android.graphics.drawable.shapes.Shape;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RectShape;
import java.util.ArrayList;
import android.widget.FrameLayout$LayoutParams;
import android.view.View;
import android.widget.HorizontalScrollView;
import android.view.ViewGroup$LayoutParams;
import android.widget.LinearLayout$LayoutParams;
import android.content.Context;
import java.lang.ref.WeakReference;
import android.widget.LinearLayout;

class s extends LinearLayout
{
    static int a;
    public boolean b;
    s$d c;
    final String d;
    AdMarvelXMLReader e;
    AdMarvelXMLElement f;
    private final WeakReference g;
    private final WeakReference h;
    private boolean i;
    private boolean j;
    
    static {
        s.a = 100001;
    }
    
    s(final j j, final AdMarvelVideoActivity adMarvelVideoActivity, final Context context, final String s, final String d) {
        final String s2 = null;
        final int n = 0;
        super(context);
        this.b = false;
        this.j = false;
        this.g = new WeakReference((T)adMarvelVideoActivity);
        this.h = new WeakReference((T)j);
        this.i = false;
        this.d = d;
        this.setId(s.a);
        final LinearLayout$LayoutParams layoutParams = new LinearLayout$LayoutParams(-1, -1);
        layoutParams.gravity = 16;
        this.setLayoutParams((ViewGroup$LayoutParams)layoutParams);
        this.setGravity(16);
        final HorizontalScrollView horizontalScrollView = new HorizontalScrollView(context);
        horizontalScrollView.setHorizontalScrollBarEnabled(false);
        horizontalScrollView.setVerticalScrollBarEnabled(false);
        final LinearLayout$LayoutParams layoutParams2 = new LinearLayout$LayoutParams(0, -1);
        layoutParams2.weight = 1.0f;
        horizontalScrollView.setLayoutParams((ViewGroup$LayoutParams)layoutParams2);
        this.addView((View)horizontalScrollView);
        final LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setLayoutParams((ViewGroup$LayoutParams)new FrameLayout$LayoutParams(-2, -1));
        horizontalScrollView.addView((View)linearLayout);
        (this.e = new AdMarvelXMLReader()).parseXMLString(s);
        this.f = this.e.getParsedXMLData();
        if (this.f != null && this.f.getChildren().containsKey("toolbar")) {
            final AdMarvelXMLElement adMarvelXMLElement = this.f.getChildren().get("toolbar").get(0);
            String s3;
            if (adMarvelXMLElement == null) {
                s3 = null;
            }
            else {
                s3 = adMarvelXMLElement.getAttributes().get("background");
            }
            final ShapeDrawable backgroundDrawable = new ShapeDrawable((Shape)new RectShape());
            if (s3 != null) {
                backgroundDrawable.getPaint().setColor(Color.parseColor(s3));
            }
            else {
                backgroundDrawable.getPaint().setColor(Color.parseColor("#3E3E3E"));
            }
            String s4;
            if (adMarvelXMLElement == null) {
                s4 = s2;
            }
            else {
                s4 = adMarvelXMLElement.getAttributes().get("alpha");
            }
            int int1;
            if (s4 != null) {
                int1 = Integer.parseInt(s4);
            }
            else {
                int1 = 175;
            }
            backgroundDrawable.setAlpha(int1);
            this.setBackgroundDrawable((Drawable)backgroundDrawable);
            if (adMarvelXMLElement != null && adMarvelXMLElement.getChildren().containsKey("item")) {
                final ArrayList list = adMarvelXMLElement.getChildren().get("item");
                for (int i = n; i < list.size(); ++i) {
                    final AdMarvelXMLElement adMarvelXMLElement2 = (AdMarvelXMLElement)list.get(i);
                    final String s5 = adMarvelXMLElement2.getAttributes().get("type");
                    if ("SystemItem".equalsIgnoreCase(s5)) {
                        this.a(context, adMarvelXMLElement2, (ViewGroup)linearLayout);
                    }
                    else if ("Title".equalsIgnoreCase(s5)) {
                        this.b(context, adMarvelXMLElement2, (ViewGroup)linearLayout);
                    }
                    else if ("Image".equalsIgnoreCase(s5)) {
                        this.c(context, adMarvelXMLElement2, (ViewGroup)linearLayout);
                    }
                    else if ("Timer".equalsIgnoreCase(s5) && adMarvelVideoActivity.k > 0) {
                        this.j = true;
                    }
                    else if ("Toggle".equalsIgnoreCase(s5)) {
                        this.d(context, adMarvelXMLElement2, (ViewGroup)linearLayout);
                    }
                }
            }
        }
        final RelativeLayout$LayoutParams layoutParams3 = new RelativeLayout$LayoutParams(-1, (int)TypedValue.applyDimension(1, 40.0f, this.getResources().getDisplayMetrics()));
        layoutParams3.addRule(12);
        layoutParams3.addRule(3, com.admarvel.android.ads.d.a);
        this.setLayoutParams((ViewGroup$LayoutParams)layoutParams3);
        if (this.j) {
            this.a(context);
        }
    }
    
    private float a(final float n) {
        return TypedValue.applyDimension(1, n, this.getResources().getDisplayMetrics());
    }
    
    private void a(final Context context) {
        new LinearLayout$LayoutParams(-2, -1).gravity = 3;
        final int n = (int)TypedValue.applyDimension(1, 5.0f, this.getResources().getDisplayMetrics());
        final RelativeLayout$LayoutParams layoutParams = new RelativeLayout$LayoutParams(-2, (int)TypedValue.applyDimension(1, 36.0f, this.getResources().getDisplayMetrics()));
        layoutParams.addRule(5);
        layoutParams.setMargins(n, 0, n, 0);
        final LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setVisibility(4);
        final LinearLayout$LayoutParams layoutParams2 = new LinearLayout$LayoutParams(-2, -1);
        layoutParams2.gravity = 5;
        linearLayout.setOrientation(0);
        layoutParams.addRule(15);
        linearLayout.setLayoutParams((ViewGroup$LayoutParams)layoutParams2);
        linearLayout.setTag((Object)(this.d + "TIMER_BUTTON_LAYOUT"));
        linearLayout.setClickable(false);
        linearLayout.addStatesFromChildren();
        linearLayout.setGravity(5);
        final TextView textView = new TextView(context);
        final LinearLayout$LayoutParams linearLayout$LayoutParams = new LinearLayout$LayoutParams(-2, -1);
        linearLayout$LayoutParams.setMargins((int)this.a(5.0f), 0, (int)this.a(5.0f), 0);
        textView.setTextColor(Color.parseColor("#0e78b9"));
        textView.setLayoutParams((ViewGroup$LayoutParams)layoutParams);
        textView.setGravity(16);
        textView.setTypeface(Typeface.DEFAULT_BOLD);
        textView.setSingleLine(true);
        final BitmapDrawable bitMapDrawable = AdMarvelBitmapDrawableUtils.getBitMapDrawable("time", this.getContext());
        final ImageView imageView = new ImageView(context);
        imageView.setImageDrawable((Drawable)bitMapDrawable);
        final LinearLayout$LayoutParams linearLayout$LayoutParams2 = new LinearLayout$LayoutParams((int)this.a(32.0f), (int)this.a(32.0f));
        linearLayout$LayoutParams2.gravity = 16;
        linearLayout.addView((View)textView, (ViewGroup$LayoutParams)linearLayout$LayoutParams);
        linearLayout.addView((View)imageView, (ViewGroup$LayoutParams)linearLayout$LayoutParams2);
        this.addView((View)linearLayout);
    }
    
    private void a(final Context context, final AdMarvelXMLElement adMarvelXMLElement, final ViewGroup viewGroup) {
        final LinearLayout$LayoutParams linearLayout$LayoutParams = new LinearLayout$LayoutParams(-2, -1);
        linearLayout$LayoutParams.gravity = 3;
        final int n = (int)TypedValue.applyDimension(1, 5.0f, this.getResources().getDisplayMetrics());
        final float applyDimension = TypedValue.applyDimension(1, 32.0f, this.getResources().getDisplayMetrics());
        final RelativeLayout$LayoutParams layoutParams = new RelativeLayout$LayoutParams((int)applyDimension, (int)applyDimension);
        layoutParams.addRule(5);
        layoutParams.setMargins(n, 0, n, 0);
        final ShapeDrawable shapeDrawable = new ShapeDrawable((Shape)new RectShape());
        shapeDrawable.getPaint().setShader((Shader)new LinearGradient(0.0f, 0.0f, 0.0f, this.a(40.0f), Color.parseColor("#AAFFFFFF"), Color.parseColor("#AA3E3E3E"), Shader$TileMode.REPEAT));
        final StateListDrawable backgroundDrawable = new StateListDrawable();
        backgroundDrawable.addState(new int[] { 16842919 }, (Drawable)shapeDrawable);
        final s$d s$d = new s$d(this, context, adMarvelXMLElement, linearLayout$LayoutParams);
        if (s$d.c == null) {
            return;
        }
        final ImageView imageView = new ImageView(context);
        imageView.setLayoutParams((ViewGroup$LayoutParams)layoutParams);
        BitmapDrawable imageDrawable;
        if (s$d.c.equalsIgnoreCase("done")) {
            imageDrawable = AdMarvelBitmapDrawableUtils.getBitMapDrawable("close", this.getContext());
            final RelativeLayout$LayoutParams relativeLayout$LayoutParams = new RelativeLayout$LayoutParams((int)this.a(36.0f), (int)this.a(36.0f));
            linearLayout$LayoutParams.gravity = 53;
            s$d.addView((View)imageView, (ViewGroup$LayoutParams)relativeLayout$LayoutParams);
            imageView.setTag((Object)"ADM_VIDEO_SYSTEM_ICON_DONE_BUTTON");
            this.a(s$d);
        }
        else {
            s$d.setBackgroundDrawable((Drawable)backgroundDrawable);
            layoutParams.addRule(15);
            imageDrawable = AdMarvelBitmapDrawableUtils.getBitMapDrawable(s$d.c, this.getContext());
            s$d.addView((View)imageView);
            viewGroup.addView((View)s$d);
        }
        imageView.setImageDrawable((Drawable)imageDrawable);
    }
    
    private void a(final View view) {
        if (view != null && view instanceof s$d) {
            final s$d s$d = (s$d)view;
            final AdMarvelVideoActivity adMarvelVideoActivity = (AdMarvelVideoActivity)this.g.get();
            if (adMarvelVideoActivity != null) {
                adMarvelVideoActivity.onUserInteraction();
                if (s$d.e != null) {
                    adMarvelVideoActivity.a(s$d.e);
                }
            }
            if (view.getParent() instanceof ViewSwitcher) {
                final ViewSwitcher viewSwitcher = (ViewSwitcher)view.getParent();
                if (viewSwitcher != null) {
                    if (viewSwitcher.getDisplayedChild() == 0) {
                        viewSwitcher.showNext();
                    }
                    else {
                        viewSwitcher.showPrevious();
                    }
                }
            }
            if (s$d.c != null && s$d.c.equalsIgnoreCase("open_url")) {
                this.b(s$d);
                return;
            }
            if (s$d.c != null && s$d.c.equalsIgnoreCase("play_movie")) {
                if (s$d.b != null) {
                    this.a(s$d.b);
                }
            }
            else if (s$d.c != null && s$d.c.equalsIgnoreCase("done")) {
                if (adMarvelVideoActivity != null) {
                    adMarvelVideoActivity.c();
                }
            }
            else {
                if (s$d.c != null && s$d.c.equalsIgnoreCase("stop")) {
                    this.d();
                    return;
                }
                if (s$d.c != null && s$d.c.equalsIgnoreCase("replay")) {
                    this.c();
                    return;
                }
                if (s$d.c != null && s$d.c.equalsIgnoreCase("pause")) {
                    this.a(true);
                    return;
                }
                if (s$d.c != null && s$d.c.equalsIgnoreCase("resume")) {
                    this.e();
                    return;
                }
                if (s$d.c != null && s$d.c.equalsIgnoreCase("mute")) {
                    this.f();
                    return;
                }
                if (s$d.c != null && s$d.c.equalsIgnoreCase("unmute")) {
                    this.g();
                }
            }
        }
    }
    
    private void a(final String s) {
        if (s != null) {
            final AdMarvelVideoActivity adMarvelVideoActivity = (AdMarvelVideoActivity)this.g.get();
            if (adMarvelVideoActivity != null) {
                adMarvelVideoActivity.c(s);
            }
        }
    }
    
    private void a(final boolean b) {
        final AdMarvelVideoActivity adMarvelVideoActivity = (AdMarvelVideoActivity)this.g.get();
        if (adMarvelVideoActivity != null) {
            adMarvelVideoActivity.a(b);
        }
    }
    
    @SuppressLint({ "NewApi" })
    private void b(Context context, final AdMarvelXMLElement adMarvelXMLElement, final ViewGroup viewGroup) {
        final LinearLayout$LayoutParams linearLayout$LayoutParams = new LinearLayout$LayoutParams(-2, -1);
        linearLayout$LayoutParams.gravity = 3;
        final int n = (int)TypedValue.applyDimension(1, 5.0f, this.getResources().getDisplayMetrics());
        final RelativeLayout$LayoutParams relativeLayout$LayoutParams = new RelativeLayout$LayoutParams(-2, (int)TypedValue.applyDimension(1, 36.0f, this.getResources().getDisplayMetrics()));
        relativeLayout$LayoutParams.addRule(5);
        relativeLayout$LayoutParams.setMargins(n, 0, n, 0);
        final s$d s$d = new s$d(this, context, adMarvelXMLElement, linearLayout$LayoutParams);
        relativeLayout$LayoutParams.addRule(15);
        final ShapeDrawable shapeDrawable = new ShapeDrawable((Shape)new RectShape());
        final ShapeDrawable shapeDrawable2 = new ShapeDrawable((Shape)new RectShape());
        shapeDrawable2.getPaint().setColor(Color.parseColor("#000000FF"));
        shapeDrawable.getPaint().setColor(Color.parseColor("#AA3E3E3E"));
        final StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[] { 16842919 }, (Drawable)shapeDrawable);
        stateListDrawable.addState(new int[] { -16842913 }, (Drawable)shapeDrawable2);
        stateListDrawable.addState(new int[] { 16842913 }, (Drawable)shapeDrawable);
        final StateListDrawable backgroundDrawable = new StateListDrawable();
        backgroundDrawable.addState(new int[] { 16842919 }, (Drawable)shapeDrawable);
        if (s$d.c == null) {
            return;
        }
        final String text = adMarvelXMLElement.getAttributes().get("title");
        context = (Context)new TextView(context);
        ((TextView)context).setLayoutParams((ViewGroup$LayoutParams)relativeLayout$LayoutParams);
        ((TextView)context).setBackgroundColor(-16776961);
        ((TextView)context).setGravity(17);
        relativeLayout$LayoutParams.addRule(15);
        ((TextView)context).setDuplicateParentStateEnabled(true);
        ((TextView)context).setClickable(false);
        ((TextView)context).setSingleLine();
        ((TextView)context).setTextColor(Color.parseColor("#84c043"));
        ((TextView)context).setTypeface(Typeface.DEFAULT_BOLD);
        ((TextView)context).setTextSize(17.0f);
        final String s = adMarvelXMLElement.getAttributes().get("color");
        final String s2 = adMarvelXMLElement.getAttributes().get("textSize");
    Label_0407:
        while (true) {
            if (s == null || s.length() <= 0) {
                break Label_0407;
            }
            ((TextView)context).setTextColor(Color.parseColor(s));
            ((TextView)context).setTypeface(Typeface.DEFAULT_BOLD);
            if (s2 == null) {
                break Label_0407;
            }
            while (true) {
                while (true) {
                    try {
                        ((TextView)context).setTextSize((float)Integer.parseInt(s2));
                        if (text != null && text.length() > 0) {
                            ((TextView)context).setText((CharSequence)text);
                        }
                        if (Version.getAndroidSDKVersion() >= 16) {
                            ((TextView)context).setBackground((Drawable)stateListDrawable);
                            s$d.setBackgroundDrawable((Drawable)backgroundDrawable);
                            if (s$d.c.equalsIgnoreCase("done")) {
                                relativeLayout$LayoutParams.setMargins(0, 0, 0, 0);
                                ((TextView)context).setLayoutParams((ViewGroup$LayoutParams)relativeLayout$LayoutParams);
                                ((TextView)context).setTag((Object)"ADM_VIDEO_CUSTOM_DONE_BUTTON");
                                s$d.addView((View)context);
                                this.a(s$d);
                                return;
                            }
                            break;
                        }
                    }
                    catch (Exception ex) {
                        ((TextView)context).setTextSize(18.0f);
                        Logging.log("Exception in setting Done button text size" + ex.getMessage());
                        continue Label_0407;
                    }
                    ((TextView)context).setBackgroundDrawable((Drawable)stateListDrawable);
                    continue;
                }
            }
            break;
        }
        s$d.addView((View)context);
        viewGroup.addView((View)s$d, (ViewGroup$LayoutParams)relativeLayout$LayoutParams);
    }
    
    private void b(final s$d s$d) {
        if (s$d != null) {
            final AdMarvelVideoActivity adMarvelVideoActivity = (AdMarvelVideoActivity)this.g.get();
            if (adMarvelVideoActivity != null) {
                if (s$d.d == s$c.a) {
                    this.a(false);
                }
                else if (s$d.d == s$c.b) {
                    this.d();
                }
                else if (s$d.d == s$c.c) {
                    adMarvelVideoActivity.c();
                }
                if (s$d.a != null && s$d.a.length() > 0) {
                    if (AdMarvelInterstitialAds.getEnableClickRedirect()) {
                        adMarvelVideoActivity.d = true;
                        final Intent intent = new Intent((Context)adMarvelVideoActivity, (Class)AdMarvelActivity.class);
                        intent.addFlags(268435456);
                        intent.putExtra("url", s$d.a);
                        intent.putExtra("isInterstitial", false);
                        intent.putExtra("isInterstitialClick", false);
                        intent.putExtra("GUID", this.d);
                        adMarvelVideoActivity.startActivity(intent);
                    }
                    AdMarvelInterstitialAds.getListener().a((Context)adMarvelVideoActivity, s$d.a, "", 0, null, "");
                }
            }
        }
    }
    
    private void c() {
        final AdMarvelVideoActivity adMarvelVideoActivity = (AdMarvelVideoActivity)this.g.get();
        if (adMarvelVideoActivity != null) {
            adMarvelVideoActivity.f();
        }
    }
    
    private void c(final Context context, final AdMarvelXMLElement adMarvelXMLElement, final ViewGroup viewGroup) {
        final LinearLayout$LayoutParams linearLayout$LayoutParams = new LinearLayout$LayoutParams(-2, -1);
        linearLayout$LayoutParams.gravity = 3;
        final int n = (int)TypedValue.applyDimension(1, 5.0f, this.getResources().getDisplayMetrics());
        final float applyDimension = TypedValue.applyDimension(1, 32.0f, this.getResources().getDisplayMetrics());
        final RelativeLayout$LayoutParams layoutParams = new RelativeLayout$LayoutParams((int)applyDimension, (int)applyDimension);
        layoutParams.addRule(5);
        layoutParams.setMargins(n, 0, n, 0);
        final ShapeDrawable shapeDrawable = new ShapeDrawable((Shape)new RectShape());
        shapeDrawable.getPaint().setShader((Shader)new LinearGradient(0.0f, 0.0f, 0.0f, this.a(40.0f), Color.parseColor("#AAFFFFFF"), Color.parseColor("#AA3E3E3E"), Shader$TileMode.REPEAT));
        final StateListDrawable backgroundDrawable = new StateListDrawable();
        backgroundDrawable.addState(new int[] { 16842919 }, (Drawable)shapeDrawable);
        final s$d s$d = new s$d(this, context, adMarvelXMLElement, linearLayout$LayoutParams);
        if (s$d.c != null) {
            final String s = adMarvelXMLElement.getAttributes().get("image");
            final String s2 = adMarvelXMLElement.getAttributes().get("image_high");
            final String s3 = adMarvelXMLElement.getAttributes().get("image_retina");
            final AdMarvelVideoActivity adMarvelVideoActivity = (AdMarvelVideoActivity)this.g.get();
            if (adMarvelVideoActivity != null) {
                final float i = r.i((Context)adMarvelVideoActivity);
                String s4 = s;
                if (i > 1.0f) {
                    if (i > 1.0f && i < 2.0f) {
                        s4 = s;
                        if (s2 != null) {
                            s4 = s;
                            if (s2.length() > 0) {
                                s4 = s2;
                            }
                        }
                    }
                    else {
                        s4 = s;
                        if (s3 != null) {
                            s4 = s;
                            if (s3.length() > 0) {
                                s4 = s3;
                            }
                        }
                    }
                }
                layoutParams.width = (int)this.a(32.0f);
                layoutParams.height = (int)this.a(32.0f);
                layoutParams.addRule(13);
                final ImageView imageView = new ImageView(context);
                imageView.setLayoutParams((ViewGroup$LayoutParams)layoutParams);
                if (Version.getAndroidSDKVersion() >= 11) {
                    adMarvelVideoActivity.a().post((Runnable)new s$b(this, imageView, s4));
                }
                else {
                    new s$a(this, imageView).execute((Object[])new String[] { s4 });
                }
                if (s$d.c.equalsIgnoreCase("done")) {
                    final RelativeLayout$LayoutParams relativeLayout$LayoutParams = new RelativeLayout$LayoutParams((int)this.a(36.0f), (int)this.a(36.0f));
                    linearLayout$LayoutParams.gravity = 53;
                    s$d.addView((View)imageView, (ViewGroup$LayoutParams)relativeLayout$LayoutParams);
                    imageView.setTag((Object)"ADM_VIDEO_IMAGE_ICON_DONE_BUTTON");
                    this.a(s$d);
                    return;
                }
                s$d.setBackgroundDrawable((Drawable)backgroundDrawable);
                s$d.addView((View)imageView);
                viewGroup.addView((View)s$d);
            }
        }
    }
    
    private void d() {
        final AdMarvelVideoActivity adMarvelVideoActivity = (AdMarvelVideoActivity)this.g.get();
        if (adMarvelVideoActivity != null) {
            adMarvelVideoActivity.d();
        }
    }
    
    private void d(final Context context, final AdMarvelXMLElement adMarvelXMLElement, final ViewGroup viewGroup) {
        ViewSwitcher viewSwitcher = null;
        Label_0206: {
            while (true) {
                while (true) {
                    int n = 0;
                    Label_0222: {
                        AdMarvelXMLElement adMarvelXMLElement2 = null;
                        String s = null;
                        Label_0184: {
                            try {
                                final LinearLayout$LayoutParams layoutParams = new LinearLayout$LayoutParams(-2, -1);
                                layoutParams.gravity = 3;
                                viewSwitcher = new ViewSwitcher(context);
                                viewSwitcher.setLayoutParams((ViewGroup$LayoutParams)layoutParams);
                                viewSwitcher.addStatesFromChildren();
                                if (adMarvelXMLElement == null || !adMarvelXMLElement.getChildren().containsKey("subitem")) {
                                    break Label_0206;
                                }
                                this.b = true;
                                final ArrayList list = adMarvelXMLElement.getChildren().get("subitem");
                                n = 0;
                                if (n >= list.size()) {
                                    break Label_0206;
                                }
                                adMarvelXMLElement2 = (AdMarvelXMLElement)list.get(n);
                                s = adMarvelXMLElement2.getAttributes().get("type");
                                if ("SystemItem".equalsIgnoreCase(s)) {
                                    this.a(context, adMarvelXMLElement2, (ViewGroup)viewSwitcher);
                                    break Label_0222;
                                }
                                if ("Title".equalsIgnoreCase(s)) {
                                    this.b(context, adMarvelXMLElement2, (ViewGroup)viewSwitcher);
                                    break Label_0222;
                                }
                                break Label_0184;
                            }
                            catch (Exception ex) {
                                Logging.log("Exception in addToggleButton API" + ex.getMessage());
                            }
                            break;
                        }
                        if ("Image".equalsIgnoreCase(s)) {
                            this.c(context, adMarvelXMLElement2, (ViewGroup)viewSwitcher);
                        }
                    }
                    ++n;
                    continue;
                }
            }
            return;
        }
        if (viewSwitcher.getChildCount() == 2) {
            viewGroup.addView((View)viewSwitcher);
        }
    }
    
    private void e() {
        final AdMarvelVideoActivity adMarvelVideoActivity = (AdMarvelVideoActivity)this.g.get();
        if (adMarvelVideoActivity != null) {
            adMarvelVideoActivity.e();
        }
    }
    
    private void f() {
        final AdMarvelVideoActivity adMarvelVideoActivity = (AdMarvelVideoActivity)this.g.get();
        final j j = (j)this.h.get();
        if (j != null) {
            j.b();
        }
        if (adMarvelVideoActivity != null) {
            adMarvelVideoActivity.j = AdMarvelVideoActivity$m.a;
        }
    }
    
    private void g() {
        final AdMarvelVideoActivity adMarvelVideoActivity = (AdMarvelVideoActivity)this.g.get();
        final j j = (j)this.h.get();
        if (j != null) {
            j.c();
        }
        if (adMarvelVideoActivity != null) {
            adMarvelVideoActivity.j = AdMarvelVideoActivity$m.b;
        }
    }
    
    public s$d a() {
        return this.c;
    }
    
    public void a(final s$d c) {
        this.c = c;
    }
    
    public boolean b() {
        return this.i;
    }
}
