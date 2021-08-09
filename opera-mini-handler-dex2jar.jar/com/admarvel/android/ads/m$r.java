// 
// Decompiled by Procyon v0.6-prerelease
// 

package com.admarvel.android.ads;

class m$r
{
    public int a(final m m) {
        final a a = (a)m.findViewWithTag((Object)(m.s + "EMBEDDED_VIDEO"));
        if (a == null) {
            return 0;
        }
        if (a.b(a.a().toString())) {
            return 1;
        }
        return 0;
    }
}
