// 
// Decompiled by Procyon v0.6-prerelease
// 

package com.admarvel.android.ads;

import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;

public class AdMarvelVideoActivity$j$a
{
    public String a;
    public List b;
    final /* synthetic */ AdMarvelVideoActivity$j c;
    
    public AdMarvelVideoActivity$j$a(final AdMarvelVideoActivity$j c, final String a, final String s) {
        this.c = c;
        this.a = a;
        (this.b = new ArrayList()).add(URLDecoder.decode(s));
    }
    
    public String a() {
        return this.a;
    }
    
    public void a(final String s) {
        this.b.add(URLDecoder.decode(s));
    }
}
