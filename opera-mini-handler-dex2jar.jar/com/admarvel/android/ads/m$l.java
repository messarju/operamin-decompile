// 
// Decompiled by Procyon v0.6-prerelease
// 

package com.admarvel.android.ads;

import java.io.IOException;
import java.io.OutputStream;
import java.io.ObjectOutputStream;
import java.io.ByteArrayOutputStream;
import android.content.Intent;
import android.webkit.URLUtil;
import java.lang.ref.WeakReference;

class m$l implements Runnable
{
    private String a;
    private final WeakReference b;
    private final AdMarvelAd c;
    
    public m$l(final m m, final String a, final AdMarvelAd c) {
        this.a = null;
        this.b = new WeakReference((T)m);
        this.a = a;
        this.c = c;
    }
    
    @Override
    public void run() {
        final m m = (m)this.b.get();
        if (m == null || (this.a != null && URLUtil.isNetworkUrl(this.a) && !r.f(m.getContext()))) {
            return;
        }
        d.a(m.s, (i)m.ai.get());
        Label_0290: {
            if (!m.R) {
                break Label_0290;
            }
            Intent intent = new Intent(m.getContext(), (Class)AdMarvelPostitialActivity.class);
        Label_0241_Outer:
            while (true) {
                intent.addFlags(268435456);
                if (m.R) {
                    intent.addFlags(8388608);
                }
                intent.putExtra("expand_url", this.a);
                intent.putExtra("closeBtnEnabled", m.i);
                intent.putExtra("closeAreaEnabled", m.h);
                if (m.w) {
                    intent.putExtra("orientationState", m.o);
                }
                intent.putExtra("isInterstitial", false);
                intent.putExtra("isInterstitialClick", false);
                intent.putExtra("source", m.ad);
                intent.putExtra("GUID", m.s);
                this.c.removeNonStringEntriesTargetParam();
                while (true) {
                    try {
                        final ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                        final ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
                        objectOutputStream.writeObject(this.c);
                        objectOutputStream.close();
                        intent.putExtra("serialized_admarvelad", byteArrayOutputStream.toByteArray());
                        m.getContext().startActivity(intent);
                        if (com.admarvel.android.ads.m.a(m.s) != null) {
                            com.admarvel.android.ads.m.a(m.s).a();
                        }
                        new r(m.getContext()).c(m.ah);
                        return;
                        intent = new Intent(m.getContext(), (Class)AdMarvelActivity.class);
                        continue Label_0241_Outer;
                    }
                    catch (IOException ex) {
                        ex.printStackTrace();
                        continue;
                    }
                    break;
                }
                break;
            }
        }
    }
}
