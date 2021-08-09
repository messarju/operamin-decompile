// 
// Decompiled by Procyon v0.6-prerelease
// 

package com.facebook.ads.internal.action;

import android.util.Log;
import com.facebook.ads.VideoAdActivity;
import java.util.Iterator;
import android.content.Intent;
import java.util.Map;
import android.net.Uri;
import android.content.Context;

public class VideoAppAdAction extends AppAdAction
{
    private static final String TAG;
    private final Context context;
    private final Uri uri;
    
    static {
        TAG = VideoAppAdAction.class.getSimpleName();
    }
    
    public VideoAppAdAction(final Context context, final Uri uri) {
        super(context, uri);
        this.context = context;
        this.uri = uri;
    }
    
    private static void addMapToIntentExtras(final Map map, final Intent intent) {
        for (final Map.Entry<String, V> entry : map.entrySet()) {
            intent.putExtra((String)entry.getKey(), (String)entry.getValue());
        }
    }
    
    @Override
    public void execute(final Map map) {
        this.logAdClick(this.context, this.uri);
        final String queryParameter = this.uri.getQueryParameter("video_url");
        final Intent intent = new Intent(this.context, (Class)VideoAdActivity.class);
        intent.putExtra("adUri", this.uri.toString());
        intent.putExtra("adVideoPath", queryParameter);
        intent.putExtra("adMarketUri", this.getMarketUri().toString());
        addMapToIntentExtras(map, intent);
        intent.addFlags(268435456);
        try {
            this.context.startActivity(intent);
        }
        catch (Exception ex) {
            Log.d(VideoAppAdAction.TAG, "Failed to start video", (Throwable)ex);
        }
    }
}
