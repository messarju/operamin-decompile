// 
// Decompiled by Procyon v0.6-prerelease
// 

package com.facebook.ads.internal.action;

import android.net.Uri;
import android.content.Context;

public class AdActionFactory
{
    private static final String AD_ACTION_APP_AD = "store";
    private static final String AD_ACTION_LINK_AD = "open_link";
    
    public static AdAction getAdAction(final Context context, final Uri uri) {
        final String authority = uri.getAuthority();
        final String queryParameter = uri.getQueryParameter("video_url");
        if ("store".equals(authority)) {
            if (queryParameter != null) {
                return new VideoAppAdAction(context, uri);
            }
            return new AppAdAction(context, uri);
        }
        else {
            if ("open_link".equals(authority)) {
                return new LinkAdAction(context, uri);
            }
            return null;
        }
    }
}
