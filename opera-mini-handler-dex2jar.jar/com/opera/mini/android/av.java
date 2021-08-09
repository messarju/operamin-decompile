// 
// Decompiled by Procyon v0.6-prerelease
// 

package com.opera.mini.android;

import com.google.analytics.tracking.android.l;

enum av
{
    B("PAGE_LOADS_LINK", 4, 5), 
    C("PAGE_LOADS_ENTERED_ADDRESS", 5, 6), 
    Code("PAGE_LOADS", 0, 1), 
    I("PAGE_LOADS_HISTORY", 1, 2), 
    J("PAGE_LOADS_SMART_PAGE", 3, 4), 
    Z("PAGE_LOADS_SPEEDDIAL", 2, 3), 
    a("PAGE_LOADS_SEARCH", 6, 7), 
    b("PAGE_LOADS_BOOKMARK", 7, 8), 
    c("PAGE_LOADS_EXTERNAL", 8, 9), 
    d("DOWNLOADS_FINISHED", 9, 10), 
    e("DOWNLOADS_ABORTED", 10, 11), 
    f("SHARE", 11, 12), 
    g("PAGE_LOADS_SAVED_PAGE", 12, 13), 
    h("RATE_DIALOG_SHOWN", 13, 14), 
    i("RATE_DIALOG_RATED", 14, 15), 
    j("ODP_RELOAD", 15, 16);
    
    private final int k;
    private long l;
    
    private av(final String s, final int n, final int k) {
        this.k = k;
    }
    
    public static void Code() {
        final av[] values = values();
        for (int length = values.length, i = 0; i < length; ++i) {
            final av av = values[i];
            if (av.l > 0L) {
                l.I().Code(av.k, av.l);
                av.l = 0L;
            }
        }
    }
    
    public final void Code(final Long n) {
        this.l += n;
    }
}
