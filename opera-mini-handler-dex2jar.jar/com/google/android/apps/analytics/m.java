// 
// Decompiled by Procyon v0.6-prerelease
// 

package com.google.android.apps.analytics;

import android.os.Build;
import android.os.Build$VERSION;
import java.util.Locale;
import org.apache.http.HttpHost;

final class m implements B
{
    private final String Code;
    private final HttpHost I;
    private n Z;
    
    public m() {
        this("GoogleAnalytics", "1.4.2");
    }
    
    public m(final String s, final String s2) {
        this(s, s2, "www.google-analytics.com");
    }
    
    private m(final String s, final String s2, String lowerCase) {
        this.I = new HttpHost(lowerCase, 80);
        final Locale default1 = Locale.getDefault();
        final String release = Build$VERSION.RELEASE;
        if (default1.getLanguage() != null) {
            lowerCase = default1.getLanguage().toLowerCase();
        }
        else {
            lowerCase = "en";
        }
        String lowerCase2;
        if (default1.getCountry() != null) {
            lowerCase2 = default1.getCountry().toLowerCase();
        }
        else {
            lowerCase2 = "";
        }
        this.Code = String.format("%s/%s (Linux; U; Android %s; %s-%s; %s Build/%s)", s, s2, release, lowerCase, lowerCase2, Build.MODEL, Build.ID);
    }
    
    @Override
    public final void Code() {
        if (this.Z != null && this.Z.getLooper() != null) {
            this.Z.getLooper().quit();
            this.Z = null;
        }
    }
    
    @Override
    public final void Code(final C c) {
        this.Code();
        (this.Z = new n(c, this.Code, this, (byte)0)).start();
    }
    
    @Override
    public final void Code(final f[] array) {
        if (this.Z == null) {
            return;
        }
        this.Z.Code(array);
    }
}
