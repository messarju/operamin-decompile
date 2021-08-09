// 
// Decompiled by Procyon v0.6-prerelease
// 

package com.facebook.ads.internal.action;

import android.util.Log;
import android.content.Intent;
import java.util.Map;
import android.net.Uri;
import android.content.Context;

public class LinkAdAction extends AdAction
{
    private static final String TAG;
    private final Context context;
    private final Uri uri;
    
    static {
        TAG = LinkAdAction.class.getSimpleName();
    }
    
    public LinkAdAction(final Context context, final Uri uri) {
        this.context = context;
        this.uri = uri;
    }
    
    @Override
    public void execute(final Map map) {
        this.logAdClick(this.context, this.uri);
        final Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(this.uri.getQueryParameter("link")));
        intent.addFlags(268435456);
        try {
            this.context.startActivity(intent);
        }
        catch (Exception ex) {
            Log.d(LinkAdAction.TAG, "Failed to open market url: " + this.uri.toString(), (Throwable)ex);
        }
    }
}
