// 
// Decompiled by Procyon v0.6-prerelease
// 

package com.admarvel.android.ads;

import java.util.StringTokenizer;
import java.util.List;
import java.util.ArrayList;

class AdMarvelVideoActivity$j
{
    final /* synthetic */ AdMarvelVideoActivity a;
    private final ArrayList b;
    
    public AdMarvelVideoActivity$j(final AdMarvelVideoActivity a) {
        this.a = a;
        this.b = new ArrayList();
    }
    
    public List a() {
        return this.b;
    }
    
    public void a(String substring) {
        final int index = substring.indexOf(63);
        if (index >= 0) {
            substring = substring.substring(index + 1);
        }
        else {
            substring = "";
        }
        this.b(substring);
    }
    
    protected void a(final String s, final String s2) {
        for (int i = 0; i < this.b.size(); ++i) {
            if (((AdMarvelVideoActivity$j$a)this.b.get(i)).a().equalsIgnoreCase(s)) {
                ((AdMarvelVideoActivity$j$a)this.b.get(i)).a(s2);
                return;
            }
        }
        this.b.add(new AdMarvelVideoActivity$j$a(this, s, s2));
    }
    
    public void b(final String s) {
        final StringTokenizer stringTokenizer = new StringTokenizer(s, "&");
        while (stringTokenizer.hasMoreElements()) {
            final String nextToken = stringTokenizer.nextToken();
            if (nextToken.length() > 0) {
                final int index = nextToken.indexOf(61);
                if (index < 0) {
                    this.a(nextToken, "");
                }
                else {
                    this.a(nextToken.substring(0, index), nextToken.substring(index + 1));
                }
            }
        }
    }
}
