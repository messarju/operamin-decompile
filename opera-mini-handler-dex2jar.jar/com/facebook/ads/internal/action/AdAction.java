// 
// Decompiled by Procyon v0.6-prerelease
// 

package com.facebook.ads.internal.action;

import com.facebook.ads.internal.AdUtilities;
import com.facebook.ads.internal.OpenUrlTask;
import com.facebook.ads.internal.StringUtils;
import android.net.Uri;
import android.content.Context;
import java.util.Map;

public abstract class AdAction
{
    public abstract void execute(final Map p0);
    
    protected void logAdClick(final Context context, final Uri uri) {
        final String queryParameter = uri.getQueryParameter("native_click_report_url");
        if (StringUtils.isNullOrEmpty(queryParameter)) {
            return;
        }
        new OpenUrlTask().execute((Object[])new String[] { queryParameter });
        AdUtilities.displayDebugMessage(context, "Click logged");
    }
}
