// 
// Decompiled by Procyon v0.6-prerelease
// 

package com.facebook.ads;

import java.lang.ref.WeakReference;
import android.util.Log;
import android.graphics.Rect;
import android.os.Build$VERSION;
import com.facebook.ads.internal.AdClientEventManager;
import com.facebook.ads.internal.AdClientEvent;
import com.facebook.ads.internal.DownloadImageTask;
import android.widget.ImageView;
import java.util.Iterator;
import android.view.ViewGroup;
import android.view.View$OnTouchListener;
import android.view.View$OnClickListener;
import com.facebook.ads.internal.AdHandler$ImpressionHelper;
import com.facebook.ads.internal.AdResponse;
import com.facebook.ads.internal.AdRequest$Callback;
import com.facebook.ads.internal.AdType;
import java.util.UUID;
import java.util.ArrayList;
import com.facebook.ads.internal.NativeAdHandler;
import android.content.Context;
import java.util.List;
import android.view.View;
import com.facebook.ads.internal.AdRequestController;
import com.facebook.ads.internal.NativeAdDataModel;
import java.util.WeakHashMap;

public class NativeAd implements Ad
{
    private static final String CLICK = "com.facebook.ads.native.click";
    private static final String IMPRESSION = "com.facebook.ads.native.impression";
    private static final String SEPARATOR = ":";
    private static final String TAG;
    private static WeakHashMap viewMapping;
    private NativeAdDataModel adDataModel;
    private AdListener adListener;
    private boolean adLoaded;
    private AdRequestController adRequestController;
    private View adView;
    private NativeAd$NativeAdBroadcastReceiver broadcastReceiver;
    private List clickListeners;
    private final Context context;
    private NativeAd$EventHandler eventHandler;
    private NativeAdHandler handler;
    private ImpressionListener impListener;
    private volatile boolean loadRequested;
    private final String uniqueId;
    private int viewabilityThreshold;
    
    static {
        TAG = NativeAd.class.getSimpleName();
        NativeAd.viewMapping = new WeakHashMap();
    }
    
    public NativeAd(final Context context, final String s) {
        this.context = context;
        this.clickListeners = new ArrayList();
        this.uniqueId = UUID.randomUUID().toString();
        this.adRequestController = new AdRequestController(this.context, s, AdSize.INTERSTITIAL, false, AdType.NATIVE, new AdRequest$Callback() {
            @Override
            public void onCompleted(final AdResponse adResponse) {
                if (adResponse.getDataModel() != null && !(adResponse.getDataModel() instanceof NativeAdDataModel)) {
                    if (NativeAd.this.adListener != null) {
                        NativeAd.this.adListener.onError(NativeAd.this, AdError.INTERNAL_ERROR);
                    }
                }
                else {
                    NativeAd.this.adDataModel = (NativeAdDataModel)adResponse.getDataModel();
                    if (NativeAd.this.adDataModel != null && NativeAd.this.adDataModel.isValid()) {
                        NativeAd.this.adLoaded = true;
                        if (NativeAd.this.adDataModel.canManuallyLog()) {
                            NativeAd.this.broadcastReceiver = new NativeAd$NativeAdBroadcastReceiver(NativeAd.this, null);
                            NativeAd.this.broadcastReceiver.register();
                            NativeAd.this.handler = new NativeAdHandler(new NativeAd$NativeAdImpressionHelper() {
                                @Override
                                public boolean shouldSendImpression() {
                                    return true;
                                }
                                
                                @Override
                                public boolean wasManual() {
                                    return true;
                                }
                            }, 1000L, NativeAd.this.adDataModel, NativeAd.this.context);
                        }
                        if (NativeAd.this.adListener != null) {
                            NativeAd.this.adListener.onAdLoaded(NativeAd.this);
                        }
                        NativeAd.this.viewabilityThreshold = adResponse.getViewabilityThreshold();
                        return;
                    }
                    if (NativeAd.this.adDataModel == null) {
                        NativeAd.this.adLoaded = false;
                        if (NativeAd.this.adListener != null) {
                            final AdListener access$000 = NativeAd.this.adListener;
                            final NativeAd this$0 = NativeAd.this;
                            AdError adError;
                            if (adResponse.getError() != null) {
                                adError = adResponse.getError();
                            }
                            else {
                                adError = AdError.INTERNAL_ERROR;
                            }
                            access$000.onError(this$0, adError);
                        }
                    }
                    else {
                        NativeAd.this.adLoaded = false;
                        NativeAd.this.adDataModel = null;
                        if (NativeAd.this.adListener != null) {
                            NativeAd.this.adListener.onError(NativeAd.this, AdError.MISSING_PROPERTIES);
                        }
                    }
                }
            }
            
            @Override
            public void onError(final AdError adError) {
                NativeAd.this.adLoaded = false;
                if (NativeAd.this.adListener != null) {
                    NativeAd.this.adListener.onError(NativeAd.this, adError);
                }
            }
        });
    }
    
    private void addListener(final View view) {
        this.clickListeners.add(view);
        view.setOnClickListener((View$OnClickListener)this.eventHandler);
        view.setOnTouchListener((View$OnTouchListener)this.eventHandler);
    }
    
    private void collectAllSubviews(final List list, final View view) {
        list.add(view);
        if (view instanceof ViewGroup) {
            final ViewGroup viewGroup = (ViewGroup)view;
            for (int i = 0; i < viewGroup.getChildCount(); ++i) {
                this.collectAllSubviews(list, viewGroup.getChildAt(i));
            }
        }
    }
    
    private void detachListeners() {
        for (final View view : this.clickListeners) {
            view.setOnClickListener((View$OnClickListener)null);
            view.setOnTouchListener((View$OnTouchListener)null);
        }
        this.clickListeners.clear();
    }
    
    public static void downloadAndDisplayImage(final NativeAd$Image nativeAd$Image, final ImageView imageView) {
        new DownloadImageTask(imageView).execute((Object[])new String[] { nativeAd$Image.getUrl() });
    }
    
    private void ensureAdRequestController() {
        if (this.adRequestController == null) {
            final RuntimeException ex = new RuntimeException("No request controller available, has the NativeAd been destroyed?");
            AdClientEventManager.addClientEvent(AdClientEvent.newErrorEvent(ex));
            throw ex;
        }
    }
    
    private boolean isValidAlpha() {
        return Build$VERSION.SDK_INT < 11 || this.adView.getAlpha() > 0.9f;
    }
    
    private boolean isViewOnScreen() {
        if (this.adView != null && this.adLoaded && this.adView.getVisibility() == 0 && this.adView.getParent() != null && this.isValidAlpha()) {
            final Rect rect = new Rect();
            if (this.adView.getGlobalVisibleRect(rect) && rect.height() * rect.width() >= this.adView.getWidth() * this.adView.getHeight() * (double)this.viewabilityThreshold / 100.0) {
                return true;
            }
        }
        return false;
    }
    
    @Override
    public void destroy() {
        if (this.adRequestController != null) {
            this.adRequestController.destroy();
            this.adRequestController = null;
        }
        this.detachListeners();
        if (this.handler != null) {
            this.handler.cancelImpressionRetry();
            this.handler = null;
        }
        if (this.adView != null) {
            NativeAd.viewMapping.remove(this.adView);
            this.adView = null;
        }
        if (this.broadcastReceiver != null) {
            this.broadcastReceiver.unregister();
            this.broadcastReceiver = null;
        }
    }
    
    public String getAdBody() {
        if (!this.adLoaded) {
            return null;
        }
        return this.adDataModel.getBody();
    }
    
    public String getAdCallToAction() {
        if (!this.adLoaded) {
            return null;
        }
        return this.adDataModel.getCallToAction();
    }
    
    public NativeAd$Image getAdCoverImage() {
        if (!this.adLoaded) {
            return null;
        }
        return this.adDataModel.getImage();
    }
    
    public NativeAd$Image getAdIcon() {
        if (!this.adLoaded) {
            return null;
        }
        return this.adDataModel.getIcon();
    }
    
    public String getAdSocialContext() {
        if (!this.adLoaded) {
            return null;
        }
        return this.adDataModel.getSocialContext();
    }
    
    public NativeAd$Rating getAdStarRating() {
        if (!this.adLoaded) {
            return null;
        }
        return this.adDataModel.getStarRating();
    }
    
    public String getAdTitle() {
        if (!this.adLoaded) {
            return null;
        }
        return this.adDataModel.getTitle();
    }
    
    public String getId() {
        return this.uniqueId;
    }
    
    public boolean isAdLoaded() {
        return this.adLoaded;
    }
    
    @Override
    public void loadAd() {
        if (this.loadRequested) {
            final IllegalStateException ex = new IllegalStateException("Ad already loaded");
            AdClientEventManager.addClientEvent(AdClientEvent.newErrorEvent(ex));
            throw ex;
        }
        this.loadRequested = true;
        this.ensureAdRequestController();
        this.adRequestController.loadAd();
    }
    
    public void registerViewForInteraction(final View view) {
        final ArrayList list = new ArrayList();
        this.collectAllSubviews(list, view);
        this.registerViewForInteraction(view, list);
    }
    
    public void registerViewForInteraction(final View adView, final List list) {
        if (adView == null) {
            final IllegalArgumentException ex = new IllegalArgumentException("Must provide a View");
            AdClientEventManager.addClientEvent(AdClientEvent.newErrorEvent(ex));
            throw ex;
        }
        if (list == null || list.size() == 0) {
            final IllegalArgumentException ex2 = new IllegalArgumentException("Invalid set of clickable views");
            AdClientEventManager.addClientEvent(AdClientEvent.newErrorEvent(ex2));
            throw ex2;
        }
        if (!this.adLoaded) {
            Log.e(NativeAd.TAG, "Ad not loaded");
            return;
        }
        if (this.adView != null) {
            Log.w(NativeAd.TAG, "Native Ad was already registered with a View. Auto unregistering and proceeding.");
            this.unregisterView();
        }
        if (NativeAd.viewMapping.containsKey(adView)) {
            Log.w(NativeAd.TAG, "View already registered with a NativeAd. Auto unregistering and proceeding.");
            NativeAd.viewMapping.get(adView).get().unregisterView();
        }
        this.eventHandler = new NativeAd$EventHandler(this, null);
        this.adView = adView;
        final Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            this.addListener((View)iterator.next());
        }
        (this.handler = new NativeAdHandler(new NativeAd$NativeAdImpressionHelper(this, null), 1000L, this.adDataModel, this.context)).trySendImpression();
        NativeAd.viewMapping.put(adView, new WeakReference(this));
    }
    
    public void setAdListener(final AdListener adListener) {
        this.adListener = adListener;
    }
    
    public void setImpressionListener(final ImpressionListener impListener) {
        this.impListener = impListener;
    }
    
    public void unregisterView() {
        if (this.adView == null) {
            return;
        }
        if (!NativeAd.viewMapping.containsKey(this.adView) || NativeAd.viewMapping.get(this.adView).get() != this) {
            final IllegalStateException ex = new IllegalStateException("View not registered with this NativeAd");
            AdClientEventManager.addClientEvent(AdClientEvent.newErrorEvent(ex));
            throw ex;
        }
        NativeAd.viewMapping.remove(this.adView);
        this.detachListeners();
        this.handler.cancelImpressionRetry();
        this.handler = null;
        this.adView = null;
    }
}
