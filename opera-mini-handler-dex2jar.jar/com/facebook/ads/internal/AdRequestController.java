// 
// Decompiled by Procyon v0.6-prerelease
// 

package com.facebook.ads.internal;

import com.facebook.ads.AdSettings;
import android.os.AsyncTask$Status;
import com.facebook.ads.AdError;
import android.content.BroadcastReceiver;
import android.content.IntentFilter;
import android.net.NetworkInfo;
import android.net.ConnectivityManager;
import java.util.concurrent.ConcurrentHashMap;
import android.os.AsyncTask;
import android.os.Handler;
import android.content.Context;
import com.facebook.ads.AdSize;
import java.util.Map;

public class AdRequestController
{
    private static final String ANDROID_PERMISSION_ACCESS_NETWORK_STATE = "android.permission.ACCESS_NETWORK_STATE";
    private static final int DEFAULT_REFRESH_THRESHOLD_MILLIS = 20000;
    private static final int MIN_REFRESH_INTERVAL_MILLIS = 30000;
    private static Map lastRequestTimes;
    private static Map refreshThresholds;
    private final AdSize adSize;
    private final AdType adType;
    private final AdRequest$Callback adViewRequestCallback;
    private final Context context;
    private int currentVisibility;
    private final Handler handler;
    private boolean initialLoadFinished;
    private AsyncTask lastRequest;
    private final String placementId;
    private int refreshInterval;
    private final Runnable refreshRunnable;
    private volatile boolean refreshScheduled;
    private final AdRequestController$ScreenStateReceiver screenStateReceiver;
    private boolean shouldRefresh;
    
    static {
        AdRequestController.lastRequestTimes = new ConcurrentHashMap();
        AdRequestController.refreshThresholds = new ConcurrentHashMap();
    }
    
    public AdRequestController(final Context context, final String placementId, final AdSize adSize, final boolean shouldRefresh, final AdType adType, final AdRequest$Callback adViewRequestCallback) {
        this.refreshInterval = 30000;
        this.initialLoadFinished = false;
        this.refreshScheduled = false;
        this.currentVisibility = 8;
        if (adViewRequestCallback == null) {
            throw new IllegalArgumentException("adViewRequestCallback");
        }
        this.context = context;
        this.placementId = placementId;
        this.adSize = adSize;
        this.shouldRefresh = shouldRefresh;
        this.adType = adType;
        this.adViewRequestCallback = adViewRequestCallback;
        this.screenStateReceiver = new AdRequestController$ScreenStateReceiver(this, null);
        this.handler = new Handler();
        this.refreshRunnable = new Runnable() {
            @Override
            public void run() {
                AdRequestController.this.refreshScheduled = false;
                AdRequestController.this.loadAd();
            }
        };
        this.registerScreenStateReceiver();
    }
    
    private void cancelRefresh(final String s) {
        synchronized (this) {
            if (this.refreshScheduled) {
                this.handler.removeCallbacks(this.refreshRunnable);
                this.refreshScheduled = false;
            }
        }
    }
    
    private AdRequestController$AdDisplayFormat getDisplayFormat() {
        if (AdType.NATIVE == this.adType) {
            return AdRequestController$AdDisplayFormat.NATIVE;
        }
        if (AdSize.INTERSTITIAL == this.adSize) {
            return AdRequestController$AdDisplayFormat.INTERSTITIAL;
        }
        return AdRequestController$AdDisplayFormat.BANNER;
    }
    
    private Integer getLastRefreshThreshold() {
        return AdRequestController.refreshThresholds.get(this.getPlacementKey());
    }
    
    private Long getLastRefreshTime() {
        return AdRequestController.lastRequestTimes.get(this.getPlacementKey());
    }
    
    private String getPlacementKey() {
        return this.placementId + ":" + this.getDisplayFormat().toString();
    }
    
    private int getRefreshThresholdMillis() {
        final Integer lastRefreshThreshold = this.getLastRefreshThreshold();
        if (lastRefreshThreshold != null) {
            return lastRefreshThreshold;
        }
        if (this.shouldRefresh) {
            return 20000;
        }
        return -1000;
    }
    
    private boolean isNetworkConnected() {
        if (this.context.checkCallingOrSelfPermission("android.permission.ACCESS_NETWORK_STATE") != 0) {
            return true;
        }
        final NetworkInfo activeNetworkInfo = ((ConnectivityManager)this.context.getSystemService("connectivity")).getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }
    
    private void registerScreenStateReceiver() {
        if (!this.shouldRefresh) {
            return;
        }
        final IntentFilter intentFilter = new IntentFilter("android.intent.action.SCREEN_ON");
        intentFilter.addAction("android.intent.action.SCREEN_OFF");
        this.context.registerReceiver((BroadcastReceiver)this.screenStateReceiver, intentFilter);
    }
    
    private void setLastRefreshThreshold(final int n) {
        AdRequestController.refreshThresholds.put(this.getPlacementKey(), n);
    }
    
    private void setLastRefreshTime(final long n) {
        AdRequestController.lastRequestTimes.put(this.getPlacementKey(), n);
    }
    
    private void unregisterScreenStateReceiver() {
        if (!this.shouldRefresh) {
            return;
        }
        try {
            this.context.unregisterReceiver((BroadcastReceiver)this.screenStateReceiver);
        }
        catch (Exception ex) {
            AdClientEventManager.addClientEvent(AdClientEvent.newErrorEvent(ex));
        }
    }
    
    public void destroy() {
        this.unregisterScreenStateReceiver();
        this.cancelRefresh("destroy");
    }
    
    public void disableRefresh() {
        this.shouldRefresh = false;
    }
    
    public void loadAd() {
        while (true) {
            final long currentTimeMillis;
            Label_0135: {
                synchronized (this) {
                    currentTimeMillis = System.currentTimeMillis();
                    final Long lastRefreshTime = this.getLastRefreshTime();
                    if (lastRefreshTime != null && currentTimeMillis < lastRefreshTime + this.getRefreshThresholdMillis()) {
                        this.adViewRequestCallback.onError(AdError.LOAD_TOO_FREQUENTLY);
                    }
                    else {
                        if (this.refreshScheduled) {
                            this.cancelRefresh(null);
                        }
                        if (this.lastRequest != null && this.lastRequest.getStatus() != AsyncTask$Status.FINISHED) {
                            this.lastRequest.cancel(true);
                        }
                        if (this.isNetworkConnected()) {
                            break Label_0135;
                        }
                        this.refreshInterval = 30000;
                        this.adViewRequestCallback.onError(new AdError(-1, "network unavailable"));
                        this.scheduleRefresh("no network connection");
                    }
                    return;
                }
            }
            this.setLastRefreshTime(currentTimeMillis);
            this.lastRequest = new AdRequest(this.context, this.placementId, this.adSize, this.adType, AdSettings.isTestMode(this.context), new AdRequest$Callback() {
                @Override
                public void onCompleted(final AdResponse adResponse) {
                    AdRequestController.this.refreshInterval = adResponse.getRefreshIntervalMillis();
                    AdRequestController.this.setLastRefreshThreshold(adResponse.getRefreshThresholdMillis());
                    AdRequestController.this.adViewRequestCallback.onCompleted(adResponse);
                    AdRequestController.this.initialLoadFinished = true;
                }
                
                @Override
                public void onError(final AdError adError) {
                    AdRequestController.this.adViewRequestCallback.onError(adError);
                    AdRequestController.this.initialLoadFinished = true;
                    AdRequestController.this.scheduleRefresh("onError");
                }
            }).executeAsync();
        }
    }
    
    public void onWindowVisibilityChanged(final int currentVisibility) {
        this.currentVisibility = currentVisibility;
        if (currentVisibility == 0) {
            if (this.initialLoadFinished) {
                this.scheduleRefresh("onWindowVisibilityChanged");
            }
            return;
        }
        this.cancelRefresh("onWindowVisibilityChanged");
    }
    
    public void scheduleRefresh(final String s) {
        synchronized (this) {
            if (this.shouldRefresh && this.refreshInterval > 0 && !this.refreshScheduled) {
                this.handler.postDelayed(this.refreshRunnable, (long)this.refreshInterval);
                this.refreshScheduled = true;
            }
        }
    }
}
