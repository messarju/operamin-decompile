// 
// Decompiled by Procyon v0.6-prerelease
// 

package com.admarvel.android.ads;

import java.util.Map;

public class AdMarvelHttpPost
{
    private String a;
    private String b;
    private Map c;
    
    public String getEndpointUrl() {
        return this.a;
    }
    
    public Map getHttpHeaders() {
        return this.c;
    }
    
    public String getPostString() {
        return this.b;
    }
    
    public void setEndpointUrl(final String a) {
        this.a = a;
    }
    
    public void setHttpHeaders(final Map c) {
        this.c = c;
    }
    
    public void setPostString(final String b) {
        this.b = b;
    }
}
