// 
// Decompiled by Procyon v0.6-prerelease
// 

package com.opera.mini.android;

import com.google.analytics.tracking.android.l;

enum au
{
    B("SAVED_PERCENT", 14, 15, ax.Code), 
    C("CONNECTIVITY", 15, 16, ax.I), 
    Code("TAB_COUNT", 1, 2, ax.Code), 
    I("UNIQUE_DEVICE_ID", 7, 8, ax.Code), 
    J("RECEIVED_MB", 13, 14, ax.Code), 
    Z("INSTALLATION_DATE", 12, 13, ax.Code), 
    a("DISTRIBUTION_SOURCE", 16, 17, ax.Code), 
    b("BRANDING", 17, 18, ax.Code), 
    c("FIRST_START_DATE", 18, 19, ax.Code), 
    d("BOOKMARKS_COUNT", 0, 1, ax.Code), 
    e("SPEED_DIALS_COUNT", 2, 3, ax.Code), 
    f("LOAD_IMAGES", 3, 4, ax.I), 
    g("TEXT_WRAP", 4, 5, ax.I), 
    h("FONT_SIZE", 5, 6, ax.I), 
    i("SINGLE_COLUMN_VIEW", 6, 7, ax.I), 
    j("NAVIGATION_BAR", 8, 9, ax.I), 
    k("OPERA_LINK", 9, 10, ax.Code), 
    l("EXIT_BUTTON", 10, 11, ax.Code), 
    m("HOME_PAGE", 11, 12, ax.Code), 
    n("IMAGE_QUALITY", 19, 20, ax.I);
    
    private final boolean o;
    private final int p;
    private String q;
    
    private au(final String s, final int n, final int n2, final ax ax) {
        this(s, n, n2, ax.Code.equals(ax));
    }
    
    private au(final String s, final int n, final int p4, final boolean o) {
        this.p = p4;
        this.o = o;
    }
    
    public static void Code() {
        final au[] values = values();
        for (int length = values.length, i = 0; i < length; ++i) {
            final au au = values[i];
            if (au.q != null) {
                com.google.analytics.tracking.android.l.I().Code(au.p, au.q);
                if (au.o) {
                    au.q = null;
                }
            }
        }
    }
    
    public final void Code(final String q) {
        this.q = q;
    }
}
