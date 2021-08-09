// 
// Decompiled by Procyon v0.6-prerelease
// 

package com.admarvel.android.admarvelfacebookadapter;

import com.facebook.ads.AdSize;
import com.admarvel.android.ads.AdMarvelAdapterListener;
import com.admarvel.android.ads.AdMarvelUtils$SDKAdNetwork;
import com.facebook.ads.InterstitialAdListener;
import com.facebook.ads.AdSettings;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import com.admarvel.android.ads.AdMarvelInterstitialAdapterListener;
import java.lang.reflect.InvocationTargetException;
import com.admarvel.android.ads.AdMarvelAd$AdType;
import com.admarvel.android.ads.AdMarvelXMLReader;
import com.admarvel.android.ads.AdMarvelAd;
import java.util.Map;
import android.content.Intent;
import android.support.v4.content.I;
import android.content.Context;
import com.admarvel.android.ads.AdMarvelUtils;
import android.app.Activity;
import com.admarvel.android.util.Logging;
import com.facebook.ads.AdListener;
import com.facebook.ads.AdView;
import android.view.View;
import com.admarvel.android.ads.AdMarvelXMLElement;
import com.facebook.ads.InterstitialAd;
import java.lang.ref.WeakReference;
import com.facebook.ads.NativeAd;
import com.admarvel.android.ads.AdMarvelAdapter;

public class AdMarvelFacebookAdapter extends AdMarvelAdapter
{
    public static NativeAd fbNativeAd;
    private WeakReference contextWeakReference;
    private InterstitialAd interstitialAd;
    
    private String getAdNetworkSDKDate() {
        return "2014-11-03";
    }
    
    private String getAdNetworkSDKVersion() {
        return "3.20.0";
    }
    
    private String[] getFacebookTestDeviceIdStr(final AdMarvelXMLElement adMarvelXMLElement) {
        final String s = adMarvelXMLElement.getAttributes().get("testdevices");
        if (s != null && s.length() > 0) {
            final String[] split = s.split(",");
            if (split != null && split.length > 0) {
                return split;
            }
        }
        return null;
    }
    
    public void cleanupView(final View view) {
        if (view instanceof AdView) {
            final AdView adView = (AdView)view;
            adView.setAdListener(null);
            adView.destroy();
            Logging.log("Facebook Adapter: cleanup current view");
        }
    }
    
    @Override
    public void destroy(final View view) {
        if (view instanceof AdView) {
            final AdView adView = (AdView)view;
            adView.setAdListener(null);
            adView.destroy();
            Logging.log("Facebook Adapter: destroy current view");
        }
    }
    
    @Override
    protected void displayInterstitial(final Activity activity, final String s) {
        if (this.interstitialAd != null) {
            Logging.log("Facebook Adapter: displayInterstitial");
            this.interstitialAd.show();
        }
    }
    
    @Override
    protected void forceCloseFullScreenAd(final Activity activity) {
    }
    
    @Override
    public String getAdapterVersion() {
        return b.a;
    }
    
    @Override
    public String getAdnetworkSDKVersionInfo() {
        return "admarvel_version: " + b.a + "; facebook_sdk_version: " + this.getAdNetworkSDKVersion() + "; date: " + this.getAdNetworkSDKDate();
    }
    
    @Override
    public void handleClick() {
        if (AdMarvelUtils.getAdMarvelOptionalFlags() != null && AdMarvelUtils.getAdMarvelOptionalFlags().containsKey("FACEBOOK_NO_VIEW_REGISTERED") && AdMarvelUtils.getAdMarvelOptionalFlags().get("FACEBOOK_NO_VIEW_REGISTERED").equals("true") && this.contextWeakReference != null && this.contextWeakReference.get() != null) {
            I.Code((Context)this.contextWeakReference.get()).Code(new Intent("com.facebook.ads.native.click:" + AdMarvelFacebookAdapter.fbNativeAd.getId()));
        }
    }
    
    @Override
    public void handleImpression() {
        if (AdMarvelUtils.getAdMarvelOptionalFlags() != null && AdMarvelUtils.getAdMarvelOptionalFlags().containsKey("FACEBOOK_NO_VIEW_REGISTERED") && AdMarvelUtils.getAdMarvelOptionalFlags().get("FACEBOOK_NO_VIEW_REGISTERED").equals("true") && this.contextWeakReference != null && this.contextWeakReference.get() != null) {
            I.Code((Context)this.contextWeakReference.get()).Code(new Intent("com.facebook.ads.native.impression:" + AdMarvelFacebookAdapter.fbNativeAd.getId()));
        }
    }
    
    @Override
    public void initialize(final Activity activity, final Map map) {
    }
    
    @Override
    protected AdMarvelAd loadAd(final AdMarvelAd adMarvelAd, final AdMarvelXMLReader adMarvelXMLReader) {
        Logging.log("Facebook SDK Adapter - loadAd");
        final AdMarvelXMLElement parsedXMLData = adMarvelXMLReader.getParsedXMLData();
        final String pubId = parsedXMLData.getAttributes().get("placementid");
        if (pubId != null && pubId.length() > 0) {
            adMarvelAd.setPubId(pubId);
        }
        else {
            adMarvelAd.setAdType(AdMarvelAd$AdType.ERROR);
            adMarvelAd.setErrorCode(306);
            adMarvelAd.setErrorReason("Missing SDK publisher id");
        }
        final String[] facebookTestDeviceIdStr = this.getFacebookTestDeviceIdStr(parsedXMLData);
        if (facebookTestDeviceIdStr != null && facebookTestDeviceIdStr.length > 0) {
            adMarvelAd.setFacebookTestDeviceId(facebookTestDeviceIdStr);
        }
        final String facebookChildDirectedFlag = parsedXMLData.getAttributes().get("childdirected");
        if (facebookChildDirectedFlag != null && facebookChildDirectedFlag.length() > 0) {
            adMarvelAd.setFacebookChildDirectedFlag(facebookChildDirectedFlag);
        }
        final String facebookAdSize = parsedXMLData.getAttributes().get("adsize");
        if (facebookAdSize != null && facebookAdSize.length() > 0) {
            adMarvelAd.setFacebookAdSize(facebookAdSize);
        }
        return adMarvelAd;
    }
    
    @Override
    public Object loadNativeAd(final Object o, final AdMarvelXMLReader adMarvelXMLReader) {
        Logging.log("Facebook SDK Adapter - loadNativeAd");
        try {
            final Class[] array = { String.class };
            final AdMarvelXMLElement parsedXMLData = adMarvelXMLReader.getParsedXMLData();
            final String s = parsedXMLData.getAttributes().get("placementid");
            if (s != null && s.length() > 0) {
                o.getClass().getMethod("setPubId", (Class<?>[])array).invoke(o, s);
            }
            else {
                o.getClass().getMethod("setNativeAdErrorTypeFromAdapter", (Class<?>[])array).invoke(o, "Missing SDK publisher id");
            }
            final String[] facebookTestDeviceIdStr = this.getFacebookTestDeviceIdStr(parsedXMLData);
            if (facebookTestDeviceIdStr != null && facebookTestDeviceIdStr.length > 0) {
                o.getClass().getMethod("setFacebookTestDeviceId", String[].class).invoke(o, facebookTestDeviceIdStr);
            }
            final String s2 = parsedXMLData.getAttributes().get("childdirected");
            if (s2 != null && s2.length() > 0) {
                o.getClass().getMethod("setFacebookChildDirectedFlag", (Class<?>[])array).invoke(o, s2);
                return o;
            }
        }
        catch (IllegalArgumentException ex) {
            ex.printStackTrace();
            return o;
        }
        catch (NoSuchMethodException ex2) {
            ex2.printStackTrace();
            return o;
        }
        catch (IllegalAccessException ex3) {
            ex3.printStackTrace();
            return o;
        }
        catch (InvocationTargetException ex4) {
            ex4.printStackTrace();
        }
        return o;
    }
    
    @Override
    public void notifyAddedToListView(final View view) {
    }
    
    @Override
    public void pause(final Activity activity, final View view) {
    }
    
    @Override
    public void registerViewForInteraction(final View view) {
        if (AdMarvelFacebookAdapter.fbNativeAd != null) {
            AdMarvelFacebookAdapter.fbNativeAd.registerViewForInteraction(view);
        }
    }
    
    @Override
    protected void requestIntersitialNewAd(final AdMarvelInterstitialAdapterListener adMarvelInterstitialAdapterListener, final Context context, final AdMarvelAd adMarvelAd, final Map map, final int n, final int n2) {
        Logging.log("Facebook SDK Adapter : requestIntersitialNewAd");
        final String pubId = adMarvelAd.getPubId();
        final String[] facebookTestDeviceId = adMarvelAd.getFacebookTestDeviceId();
        final String facebookChildDirectedFlag = adMarvelAd.getFacebookChildDirectedFlag();
        if (facebookTestDeviceId != null && facebookTestDeviceId.length > 0) {
            final HashSet set = new HashSet();
            Collections.addAll(set, facebookTestDeviceId);
            AdSettings.addTestDevices(set);
        }
        if (facebookChildDirectedFlag != null && facebookChildDirectedFlag.trim().length() > 0) {
            if (facebookChildDirectedFlag.equalsIgnoreCase("yes")) {
                AdSettings.setIsChildDirected(true);
            }
            else if (facebookChildDirectedFlag.equalsIgnoreCase("no")) {
                AdSettings.setIsChildDirected(false);
            }
        }
        if (pubId != null && pubId.trim().length() > 0) {
            if (this.interstitialAd != null) {
                this.interstitialAd.setAdListener(null);
                this.interstitialAd.destroy();
                this.interstitialAd = null;
            }
            (this.interstitialAd = new InterstitialAd(context, pubId)).setAdListener(new InternalFacebookInterstitialListener(adMarvelInterstitialAdapterListener, adMarvelAd, this.interstitialAd));
            this.interstitialAd.loadAd();
        }
        else if (adMarvelInterstitialAdapterListener != null) {
            adMarvelInterstitialAdapterListener.onFailedToReceiveInterstitialAd(AdMarvelUtils$SDKAdNetwork.FACEBOOK, adMarvelAd.getPubId(), 205, AdMarvelUtils.getErrorReason(205), adMarvelAd);
            Logging.log("Facebook Adapter : onFailedToReceiveInterstitialAd");
        }
    }
    
    @Override
    public Object requestNativeAd(final AdMarvelAdapterListener adMarvelAdapterListener, Object fbNativeAd) {
        Logging.log("Facebook Ads Adapter: requestNativeAd");
        Label_0207: {
            if (fbNativeAd == null) {
                break Label_0207;
            }
            try {
                final InternalFacebookNativeListener adListener = new InternalFacebookNativeListener(adMarvelAdapterListener, fbNativeAd);
                final String s = (String)fbNativeAd.getClass().getMethod("getPubId", (Class<?>[])null).invoke(fbNativeAd, (Object[])null);
                final String[] array = (String[])fbNativeAd.getClass().getMethod("getFacebookTestDeviceId", (Class<?>[])null).invoke(fbNativeAd, (Object[])null);
                final String s2 = (String)fbNativeAd.getClass().getMethod("getFacebookChildDirectedFlag", (Class<?>[])null).invoke(fbNativeAd, (Object[])null);
                if (array != null && array.length > 0) {
                    final HashSet set = new HashSet();
                    Collections.addAll(set, array);
                    AdSettings.addTestDevices(set);
                }
                if (s2 != null && s2.trim().length() > 0) {
                    if (s2.equalsIgnoreCase("yes")) {
                        AdSettings.setIsChildDirected(true);
                    }
                    else if (s2.equalsIgnoreCase("no")) {
                        AdSettings.setIsChildDirected(false);
                    }
                }
                final Context context = (Context)fbNativeAd.getClass().getMethod("getmContext", (Class<?>[])null).invoke(fbNativeAd, (Object[])null);
                if (context != null) {
                    this.contextWeakReference = new WeakReference(context);
                    fbNativeAd = new NativeAd(context, s);
                    (AdMarvelFacebookAdapter.fbNativeAd = (NativeAd)fbNativeAd).setAdListener(adListener);
                    AdMarvelFacebookAdapter.fbNativeAd.loadAd();
                }
                return AdMarvelFacebookAdapter.fbNativeAd;
            }
            catch (IllegalArgumentException ex) {
                ex.printStackTrace();
                return AdMarvelFacebookAdapter.fbNativeAd;
            }
            catch (NoSuchMethodException ex2) {
                ex2.printStackTrace();
                return AdMarvelFacebookAdapter.fbNativeAd;
            }
            catch (IllegalAccessException ex3) {
                ex3.printStackTrace();
                return AdMarvelFacebookAdapter.fbNativeAd;
            }
            catch (InvocationTargetException ex4) {
                ex4.printStackTrace();
                return AdMarvelFacebookAdapter.fbNativeAd;
            }
        }
    }
    
    public View requestNewAd(final AdMarvelAdapterListener adMarvelAdapterListener, final Context context, final AdMarvelAd adMarvelAd, final Map map, final int n, final int n2) {
        final View view = null;
        Logging.log("Facebook Ads Adapter: requestNewAd");
        Object o = view;
        if (adMarvelAd != null) {
            final InternalFacebookListener adListener = new InternalFacebookListener(adMarvelAdapterListener);
            final String pubId = adMarvelAd.getPubId();
            final String[] facebookTestDeviceId = adMarvelAd.getFacebookTestDeviceId();
            final String facebookChildDirectedFlag = adMarvelAd.getFacebookChildDirectedFlag();
            if (facebookTestDeviceId != null && facebookTestDeviceId.length > 0) {
                final HashSet set = new HashSet();
                Collections.addAll(set, facebookTestDeviceId);
                AdSettings.addTestDevices(set);
            }
            if (facebookChildDirectedFlag != null && facebookChildDirectedFlag.trim().length() > 0) {
                if (facebookChildDirectedFlag.equalsIgnoreCase("yes")) {
                    AdSettings.setIsChildDirected(true);
                }
                else if (facebookChildDirectedFlag.equalsIgnoreCase("no")) {
                    AdSettings.setIsChildDirected(false);
                }
            }
            final AdSize banner_HEIGHT_50 = AdSize.BANNER_HEIGHT_50;
            final String facebookAdSize = adMarvelAd.getFacebookAdSize();
            AdSize adSize = banner_HEIGHT_50;
            if (facebookAdSize != null) {
                adSize = banner_HEIGHT_50;
                if (facebookAdSize.length() > 0) {
                    if (facebookAdSize.equalsIgnoreCase("BANNER_HEIGHT_50")) {
                        adSize = AdSize.BANNER_HEIGHT_50;
                    }
                    else if (facebookAdSize.equalsIgnoreCase("BANNER_320_50")) {
                        adSize = AdSize.BANNER_320_50;
                    }
                    else {
                        adSize = banner_HEIGHT_50;
                        if (facebookAdSize.equalsIgnoreCase("BANNER_HEIGHT_90")) {
                            adSize = AdSize.BANNER_HEIGHT_90;
                        }
                    }
                }
            }
            if (pubId != null && pubId.trim().length() > 0) {
                o = new AdView(context, pubId, adSize);
                ((AdView)o).setAdListener(adListener);
                ((AdView)o).loadAd();
            }
            else {
                o = view;
                if (adMarvelAdapterListener != null) {
                    adMarvelAdapterListener.onFailedToReceiveAd(205, AdMarvelUtils.getErrorReason(205));
                    return null;
                }
            }
        }
        return (View)o;
    }
    
    @Override
    public void resume(final Activity activity, final View view) {
    }
    
    @Override
    public void uninitialize(final Activity activity, final Map map) {
        if (this.interstitialAd != null) {
            this.interstitialAd.setAdListener(null);
            this.interstitialAd.destroy();
            this.interstitialAd = null;
        }
    }
    
    @Override
    public void unregisterView() {
        if (AdMarvelFacebookAdapter.fbNativeAd != null) {
            AdMarvelFacebookAdapter.fbNativeAd.unregisterView();
        }
    }
}
