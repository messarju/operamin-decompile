// 
// Decompiled by Procyon v0.6-prerelease
// 

package com.google.analytics.tracking.android;

import java.util.Collection;
import java.util.ArrayList;
import android.content.Context;

public final class p implements UncaughtExceptionHandler
{
    private final UncaughtExceptionHandler Code;
    private final an I;
    private o J;
    private final al Z;
    
    public p(final an i, final al z, final UncaughtExceptionHandler code, final Context context) {
        if (i == null) {
            throw new NullPointerException("tracker cannot be null");
        }
        if (z == null) {
            throw new NullPointerException("serviceManager cannot be null");
        }
        this.Code = code;
        this.I = i;
        this.Z = z;
        this.J = new o(context, new ArrayList());
        final StringBuilder sb = new StringBuilder("ExceptionReporter created, original handler is ");
        String name;
        if (code == null) {
            name = "null";
        }
        else {
            name = code.getClass().getName();
        }
        ae.J(sb.append(name).toString());
    }
    
    @Override
    public final void uncaughtException(final Thread thread, final Throwable t) {
        String code = "UncaughtException";
        if (this.J != null) {
            String name;
            if (thread != null) {
                name = thread.getName();
            }
            else {
                name = null;
            }
            code = this.J.Code(name, t);
        }
        ae.J("Tracking Exception: " + code);
        this.I.J(code);
        this.Z.Z();
        if (this.Code != null) {
            ae.J("Passing exception to original handler.");
            this.Code.uncaughtException(thread, t);
        }
    }
}
