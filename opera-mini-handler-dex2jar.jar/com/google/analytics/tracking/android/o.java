// 
// Decompiled by Procyon v0.6-prerelease
// 

package com.google.analytics.tracking.android;

import java.util.Iterator;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager$NameNotFoundException;
import java.util.HashSet;
import java.util.Collection;
import android.content.Context;
import java.util.TreeSet;

public final class o
{
    private final TreeSet Code;
    
    public o(final Context context, final Collection collection) {
        this.Code = new TreeSet();
        this.Code(context, collection);
    }
    
    private static Throwable Code(Throwable cause) {
        while (cause.getCause() != null) {
            cause = cause.getCause();
        }
        return cause;
    }
    
    private void Code(final Context context, final Collection collection) {
        this.Code.clear();
        final HashSet set = new HashSet();
        if (collection != null) {
            set.addAll(collection);
        }
        if (context != null) {
            try {
                final String packageName = context.getApplicationContext().getPackageName();
                this.Code.add(packageName);
                final ActivityInfo[] activities = context.getApplicationContext().getPackageManager().getPackageInfo(packageName, 15).activities;
                if (activities != null) {
                    for (int length = activities.length, i = 0; i < length; ++i) {
                        set.add(activities[i].packageName);
                    }
                }
            }
            catch (PackageManager$NameNotFoundException ex) {
                ae.Z("No package found");
            }
        }
        for (final String s : set) {
            final Iterator iterator2 = this.Code.iterator();
            int n = 1;
            while (iterator2.hasNext()) {
                final String s2 = (String)iterator2.next();
                if (!s.startsWith(s2)) {
                    if (s2.startsWith(s)) {
                        this.Code.remove(s2);
                        break;
                    }
                    break;
                }
                else {
                    n = 0;
                }
            }
            if (n != 0) {
                this.Code.add(s);
            }
        }
    }
    
    public final String Code(final String s, final Throwable t) {
        final Throwable code = Code(t);
        final StackTraceElement[] stackTrace = Code(t).getStackTrace();
        StackTraceElement stackTraceElement = null;
        Label_0028: {
            if (stackTrace == null || stackTrace.length == 0) {
                stackTraceElement = null;
            }
            else {
                for (int length = stackTrace.length, i = 0; i < length; ++i) {
                    stackTraceElement = stackTrace[i];
                    final String className = stackTraceElement.getClassName();
                    final Iterator iterator = this.Code.iterator();
                    while (iterator.hasNext()) {
                        if (className.startsWith((String)iterator.next())) {
                            break Label_0028;
                        }
                    }
                }
                stackTraceElement = stackTrace[0];
            }
        }
        final StringBuilder sb = new StringBuilder();
        sb.append(code.getClass().getSimpleName());
        if (stackTraceElement != null) {
            final String[] split = stackTraceElement.getClassName().split("\\.");
            String s2 = "unknown";
            if (split != null) {
                s2 = s2;
                if (split.length > 0) {
                    s2 = split[split.length - 1];
                }
            }
            sb.append(String.format(" (@%s:%s:%s)", s2, stackTraceElement.getMethodName(), stackTraceElement.getLineNumber()));
        }
        if (s != null) {
            sb.append(String.format(" {%s}", s));
        }
        return sb.toString();
    }
}
