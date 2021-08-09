// 
// Decompiled by Procyon v0.6-prerelease
// 

package com.admarvel.android.ads;

import android.view.View;
import android.view.View$OnClickListener;
import android.view.ViewGroup$LayoutParams;
import java.util.ArrayList;
import android.widget.LinearLayout$LayoutParams;
import android.content.Context;
import java.util.List;
import android.widget.RelativeLayout;

class s$d extends RelativeLayout
{
    public String a;
    public String b;
    public String c;
    public s$c d;
    public List e;
    final /* synthetic */ s f;
    
    public s$d(final s f, final Context context, AdMarvelXMLElement adMarvelXMLElement, final LinearLayout$LayoutParams layoutParams) {
        this.f = f;
        super(context);
        this.a = null;
        this.b = null;
        this.c = null;
        this.d = s$c.a;
        AdMarvelXMLElement adMarvelXMLElement2;
        if (adMarvelXMLElement.getChildren().get("action") != null) {
            adMarvelXMLElement2 = adMarvelXMLElement.getChildren().get("action").get(0);
        }
        else {
            adMarvelXMLElement2 = null;
        }
        if (adMarvelXMLElement2 != null) {
            final String c = adMarvelXMLElement2.getAttributes().get("type");
            this.c = c;
            if ("open_url".equalsIgnoreCase(c)) {
                this.a = adMarvelXMLElement2.getData();
                final String s = adMarvelXMLElement2.getAttributes().get("videoOpenUrlBehavior");
                if (s != null) {
                    if (s.equalsIgnoreCase("pauseVideo")) {
                        this.d = s$c.a;
                    }
                    else if (s.equalsIgnoreCase("stopVideo")) {
                        this.d = s$c.b;
                    }
                    else if (s.equalsIgnoreCase("closeVideo")) {
                        this.d = s$c.c;
                    }
                }
            }
            else if ("done".equalsIgnoreCase(c)) {
                f.i = true;
            }
            else if ("play_movie".equalsIgnoreCase(c)) {
                this.b = adMarvelXMLElement2.getData();
            }
        }
        AdMarvelXMLElement adMarvelXMLElement3;
        if (adMarvelXMLElement.getChildren().get("clickTracking") != null) {
            adMarvelXMLElement3 = adMarvelXMLElement.getChildren().get("clickTracking").get(0);
        }
        else {
            adMarvelXMLElement3 = null;
        }
        if (adMarvelXMLElement3 != null) {
            final AdMarvelXMLElement adMarvelXMLElement4 = adMarvelXMLElement3.getChildren().get("pixels").get(0);
            if (adMarvelXMLElement4 != null && adMarvelXMLElement4.getChildren().containsKey("pixel")) {
                final ArrayList list = adMarvelXMLElement4.getChildren().get("pixel");
                (this.e = new ArrayList()).clear();
                for (int i = 0; i < list.size(); ++i) {
                    adMarvelXMLElement = (AdMarvelXMLElement)list.get(i);
                    this.e.add(adMarvelXMLElement.getData());
                }
            }
        }
        this.setLayoutParams((ViewGroup$LayoutParams)layoutParams);
        this.setClickable(true);
        this.addStatesFromChildren();
        this.setGravity(17);
        this.setOnClickListener((View$OnClickListener)new View$OnClickListener() {
            public void onClick(final View view) {
                s$d.this.f.a(view);
            }
        });
    }
}
