// 
// Decompiled by Procyon v0.6-prerelease
// 

package com.google.analytics.tracking.android;

import java.util.HashMap;
import java.util.Map;

final class af
{
    private Map Code;
    
    af() {
        this.Code = new HashMap();
    }
    
    final ah Code(final String s) {
        if (s.startsWith("&")) {
            return new ah(s.substring(1), null, null);
        }
        String substring = s;
        if (s.contains("*")) {
            substring = s.substring(0, s.indexOf("*"));
        }
        return (ah)this.Code.get(substring);
    }
    
    public final void Code(final String s, final String s2, final String s3, final ag ag) {
        this.Code.put(s, new ah(s2, s3, ag));
    }
}
