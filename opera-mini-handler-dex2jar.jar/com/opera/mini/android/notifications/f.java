// 
// Decompiled by Procyon v0.6-prerelease
// 

package com.opera.mini.android.notifications;

import com.google.analytics.tracking.android.e;
import com.google.analytics.tracking.android.g;
import com.google.analytics.tracking.android.an;
import com.google.analytics.tracking.android.l;
import android.content.Context;

public final class f
{
    private Context Code;
    
    public f(final Context code) {
        l.Code().Code(code);
        this.Code = code;
    }
    
    private an Code(final String s) {
        if (s == null) {
            return l.I();
        }
        return g.Code(this.Code).Code(s);
    }
    
    public final void Code(final String s, final String s2) {
        final an code = this.Code(s2);
        if (code != null) {
            code.Code("notifications", "show", s, null);
            e.Code().Z();
        }
    }
    
    public final void I(final String s, final String s2) {
        if (this.Code(s2) != null) {
            this.Code(s2).Code("notifications", "click", s, null);
            e.Code().Z();
        }
    }
}
