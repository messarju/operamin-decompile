// 
// Decompiled by Procyon v0.6-prerelease
// 

package com.facebook.ads.internal;

import android.os.Handler;
import android.content.Context;

public abstract class AdHandler
{
    protected AdDataModel adDataModel;
    private Context context;
    private final Handler handler;
    protected final AdHandler$ImpressionHelper impressionHelper;
    private volatile boolean impressionRetryScheduled;
    private volatile boolean impressionSent;
    private final long sendImpressionDelay;
    private final Runnable sendImpressionRunnable;
    
    public AdHandler(final AdHandler$ImpressionHelper impressionHelper, final long sendImpressionDelay, final Context context) {
        this.sendImpressionRunnable = new Runnable() {
            @Override
            public void run() {
                AdHandler.this.impressionRetryScheduled = false;
                AdHandler.this.trySendImpression();
            }
        };
        this.context = context;
        this.impressionHelper = impressionHelper;
        this.sendImpressionDelay = sendImpressionDelay;
        this.handler = new Handler();
    }
    
    public void cancelImpressionRetry() {
        synchronized (this) {
            if (this.impressionRetryScheduled) {
                this.handler.removeCallbacks(this.sendImpressionRunnable);
                this.impressionRetryScheduled = false;
            }
        }
    }
    
    public AdDataModel getAdDataModel() {
        return this.adDataModel;
    }
    
    public void scheduleImpressionRetry() {
        synchronized (this) {
            if ((this.impressionSent || this.impressionRetryScheduled) && this.adDataModel != null) {
                this.handler.postDelayed(this.sendImpressionRunnable, this.sendImpressionDelay);
                this.impressionRetryScheduled = true;
            }
        }
    }
    
    protected abstract void sendImpression();
    
    public void setAdDataModel(final AdDataModel adDataModel) {
        this.adDataModel = adDataModel;
        this.impressionSent = false;
        this.impressionRetryScheduled = false;
    }
    
    public void trySendImpression() {
        while (true) {
            Label_0052: {
                synchronized (this) {
                    if (this.adDataModel != null && !this.impressionSent) {
                        if (this.impressionHelper == null || this.impressionHelper.shouldSendImpression()) {
                            break Label_0052;
                        }
                        this.scheduleImpressionRetry();
                    }
                    return;
                }
            }
            if (this.impressionHelper != null) {
                this.impressionHelper.onLoggingImpression();
            }
            this.sendImpression();
            this.impressionSent = true;
            AdUtilities.displayDebugMessage(this.context, "Impression logged");
        }
    }
}
