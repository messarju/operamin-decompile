// 
// Decompiled by Procyon v0.6-prerelease
// 

package com.admarvel.android.ads;

import android.content.Context;
import java.util.Map;
import android.app.Activity;
import android.view.View;
import com.admarvel.android.util.Logging;

public abstract class AdMarvelAdapter
{
    protected static AdMarvelAdapter createInstance(final String s) {
        return (AdMarvelAdapter)createObject(s);
    }
    
    private static Object createObject(final String s) {
        try {
            return Class.forName(s).newInstance();
        }
        catch (InstantiationException ex) {
            Logging.log(ex.getMessage());
            return null;
        }
        catch (IllegalAccessException ex2) {
            Logging.log(ex2.getMessage());
            return null;
        }
        catch (ClassNotFoundException ex3) {
            Logging.log(ex3.getMessage());
            return null;
        }
    }
    
    protected abstract void cleanupView(final View p0);
    
    public abstract void destroy(final View p0);
    
    protected abstract void displayInterstitial(final Activity p0, final String p1);
    
    protected abstract void forceCloseFullScreenAd(final Activity p0);
    
    public abstract String getAdapterVersion();
    
    public abstract String getAdnetworkSDKVersionInfo();
    
    public abstract void handleClick();
    
    public abstract void handleImpression();
    
    public abstract void initialize(final Activity p0, final Map p1);
    
    protected abstract AdMarvelAd loadAd(final AdMarvelAd p0, final AdMarvelXMLReader p1);
    
    public abstract Object loadNativeAd(final Object p0, final AdMarvelXMLReader p1);
    
    public abstract void notifyAddedToListView(final View p0);
    
    public abstract void pause(final Activity p0, final View p1);
    
    public abstract void registerViewForInteraction(final View p0);
    
    protected abstract void requestIntersitialNewAd(final AdMarvelInterstitialAdapterListener p0, final Context p1, final AdMarvelAd p2, final Map p3, final int p4, final int p5);
    
    public abstract Object requestNativeAd(final AdMarvelAdapterListener p0, final Object p1);
    
    protected abstract View requestNewAd(final AdMarvelAdapterListener p0, final Context p1, final AdMarvelAd p2, final Map p3, final int p4, final int p5);
    
    public abstract void resume(final Activity p0, final View p1);
    
    public abstract void uninitialize(final Activity p0, final Map p1);
    
    public abstract void unregisterView();
}
