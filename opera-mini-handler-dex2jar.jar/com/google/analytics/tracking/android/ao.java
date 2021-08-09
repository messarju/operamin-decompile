// 
// Decompiled by Procyon v0.6-prerelease
// 

package com.google.analytics.tracking.android;

import java.util.HashMap;
import java.util.Map;

final class ao
{
    private Map Code;
    private Map I;
    
    private ao() {
        this.Code = new HashMap();
        this.I = new HashMap();
    }
    
    public final void Code() {
        synchronized (this) {
            this.Code.clear();
        }
    }
    
    public final void Code(final String s, final String s2) {
        synchronized (this) {
            this.Code.put(s, s2);
        }
    }
    
    public final void Code(final Map map, final Boolean b) {
        synchronized (this) {
            if (b) {
                this.Code.putAll(map);
            }
            else {
                this.I.putAll(map);
            }
        }
    }
    
    public final Map I() {
        synchronized (this) {
            final HashMap hashMap = new HashMap(this.I);
            hashMap.putAll(this.Code);
            return hashMap;
        }
    }
    
    public final void I(final String s, final String s2) {
        synchronized (this) {
            this.I.put(s, s2);
        }
    }
}
