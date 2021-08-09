// 
// Decompiled by Procyon v0.6-prerelease
// 

package com.admarvel.android.nativeads;

import org.json.JSONObject;
import com.admarvel.android.ads.AdMarvelAdapterListener;
import android.os.AsyncTask;
import android.location.Location;
import java.util.concurrent.ConcurrentHashMap;
import android.view.View;
import com.admarvel.android.ads.AdMarvelXMLReader;
import com.admarvel.android.ads.AdMarvelAdapter;
import android.content.SharedPreferences$Editor;
import android.content.pm.PackageManager$NameNotFoundException;
import android.content.SharedPreferences;
import com.admarvel.android.ads.AdMarvelUtils$AdMArvelErrorReason;
import java.util.Date;
import java.text.DateFormat;
import com.admarvel.android.util.Logging;
import android.util.Log;
import com.admarvel.android.ads.AdMarvelAd;
import com.admarvel.android.ads.AdMarvelRedirectRunnable;
import java.util.HashMap;
import java.util.ArrayList;
import com.admarvel.android.ads.Constants;
import com.admarvel.android.ads.AdMarvelXMLElement;
import java.util.Iterator;
import com.admarvel.android.ads.AdMarvelUtils;
import com.admarvel.android.ads.AdMarvelAdapterInstances;
import java.util.UUID;
import com.admarvel.android.ads.AdMarvelUtils$SDKAdNetwork;
import java.util.List;
import java.util.Map;
import android.content.Context;
import java.util.concurrent.atomic.AtomicLong;
import java.lang.ref.WeakReference;
import com.admarvel.android.ads.AdMarvelNetworkHandler;

public class AdMarvelNativeAd
{
    public static final String FIELD_CAMPAIGNIMAGE = "campaignImage";
    public static final String FIELD_CTA = "cta";
    public static final String FIELD_DISPLAYNAME = "displayName";
    public static final String FIELD_FULLMESSAGE = "fullMessage";
    public static final String FIELD_ICON = "icon";
    public static final String FIELD_RATING = "rating";
    public static final String FIELD_SHORTMESSAGE = "shortMessage";
    final String ADMARVEL_NATIVE_AD_GUID;
    private String adId;
    private AdMarvelNetworkHandler adMarvelNetworkHandler;
    private String adSponsoredMarker;
    private AdMarvelNativeAd$AdType adType;
    private AdMarvelNativeImage[] campaignImage;
    private boolean canRegisterViewForInteraction;
    private WeakReference contextReference;
    private AdMarvelNativeCta cta;
    private String deviceConnectivity;
    private String disableAdDuration;
    private boolean disableAdRequest;
    private String displayName;
    private int errorCode;
    private String errorReason;
    private String excluded;
    private String facebookChildDirectedFlag;
    private String[] facebookTestDeviceId;
    private String fullMessage;
    private AdMarvelNativeImage icon;
    private int id;
    private final AdMarvelNativeAd$InternalAdMarvelAdapterListener internalAdMarvelAdapterListener;
    private String ipAddress;
    private final a listenerImpl;
    private final AtomicLong lockTimestamp;
    private Context mContext;
    private int maxretries;
    private Map metadatas;
    private int orientation;
    private String partnerId;
    private List pixels;
    private String pubId;
    private AdMarvelNativeRating rating;
    private String requestJson;
    private String responseJson;
    private Boolean retry;
    private int retrynum;
    private AdMarvelUtils$SDKAdNetwork sdkAdNetwork;
    private String sdkNetwork;
    private String shortMessage;
    private String siteId;
    private String source;
    private Map targetParams;
    private AdMarvelNativeTracker[] trackers;
    private String xml;
    
    public AdMarvelNativeAd() {
        this.facebookChildDirectedFlag = null;
        this.canRegisterViewForInteraction = false;
        this.disableAdRequest = false;
        AdMarvelAdapterInstances.buildAdMarvelAdapterInstances(this.ADMARVEL_NATIVE_AD_GUID = UUID.randomUUID().toString());
        this.listenerImpl = new a();
        this.internalAdMarvelAdapterListener = new AdMarvelNativeAd$InternalAdMarvelAdapterListener(this);
        this.lockTimestamp = new AtomicLong(0L);
    }
    
    private void firePixel() {
        if (this.mContext != null) {
            final AdMarvelUtils adMarvelUtils = new AdMarvelUtils(this.mContext);
            final List pixels = this.getPixels();
            if (pixels != null) {
                for (final String s : pixels) {
                    if (s != null) {
                        adMarvelUtils.firePixelUsingHTTP(s);
                    }
                }
            }
        }
    }
    
    private void fireTrackerPixel(final String s) {
        if (this.mContext != null) {
            final AdMarvelUtils adMarvelUtils = new AdMarvelUtils(this.mContext);
            final AdMarvelNativeTracker[] trackers = this.getTrackers();
            if (trackers != null && trackers.length > 0) {
                for (int length = trackers.length, i = 0; i < length; ++i) {
                    final AdMarvelNativeTracker adMarvelNativeTracker = trackers[i];
                    if (adMarvelNativeTracker.getType().equals(s)) {
                        final String[] url = adMarvelNativeTracker.getUrl();
                        for (int length2 = url.length, j = 0; j < length2; ++j) {
                            final String s2 = url[j];
                            if (s2 != null) {
                                adMarvelUtils.firePixelUsingHTTP(s2);
                            }
                        }
                    }
                }
            }
        }
    }
    
    private AdMarvelNativeCta parseAndGetNativeAdCTA(final AdMarvelXMLElement adMarvelXMLElement) {
        try {
            final AdMarvelNativeCta adMarvelNativeCta = new AdMarvelNativeCta();
            final String action = adMarvelXMLElement.getAttributes().get("action");
            if (action != null) {
                adMarvelNativeCta.setAction(action);
            }
            final String andGetNativeAdStandardElement = this.parseAndGetNativeAdStandardElement(adMarvelXMLElement, "title", 0);
            if (andGetNativeAdStandardElement != null) {
                adMarvelNativeCta.setTitle(andGetNativeAdStandardElement);
            }
            final String andGetNativeAdStandardElement2 = this.parseAndGetNativeAdStandardElement(adMarvelXMLElement, "clickUrl", 0);
            if (andGetNativeAdStandardElement2 != null) {
                adMarvelNativeCta.setClickUrl(andGetNativeAdStandardElement2);
            }
            final AdMarvelNativeImage andGetNativeAdImageElement = this.parseAndGetNativeAdImageElement(adMarvelXMLElement, "image");
            if (andGetNativeAdImageElement != null) {
                adMarvelNativeCta.setImage(andGetNativeAdImageElement);
            }
            return adMarvelNativeCta;
        }
        catch (Exception ex) {
            return null;
        }
    }
    
    private AdMarvelNativeImage parseAndGetNativeAdImageElement(final AdMarvelXMLElement adMarvelXMLElement) {
        try {
            final AdMarvelNativeImage adMarvelNativeImage = new AdMarvelNativeImage();
            if (adMarvelXMLElement == null) {
                return adMarvelNativeImage;
            }
            final String data = adMarvelXMLElement.getData();
            if (data != null && data.length() > 0 && Constants.WEB_URL.matcher(data).matches()) {
                adMarvelNativeImage.setImageUrl(data);
            }
            final String s = adMarvelXMLElement.getAttributes().get("width");
            final String s2 = adMarvelXMLElement.getAttributes().get("height");
            Label_0093: {
                if (s == null) {
                    break Label_0093;
                }
                try {
                    if (s.length() > 0) {
                        adMarvelNativeImage.setWidth(Integer.parseInt(s));
                    }
                    if (s2 != null && s2.length() > 0) {
                        adMarvelNativeImage.setHeight(Integer.parseInt(s2));
                    }
                    return adMarvelNativeImage;
                }
                catch (Exception ex) {
                    return null;
                }
            }
        }
        catch (Exception ex2) {
            return null;
        }
    }
    
    private AdMarvelNativeImage parseAndGetNativeAdImageElement(final AdMarvelXMLElement adMarvelXMLElement, final String s) {
        try {
            if (adMarvelXMLElement.getChildren().containsKey(s)) {
                return this.parseAndGetNativeAdImageElement(adMarvelXMLElement.getChildren().get(s).get(0));
            }
        }
        catch (Exception ex) {
            return null;
        }
        return null;
    }
    
    private AdMarvelNativeMetadata parseAndGetNativeAdMetadata(final AdMarvelXMLElement adMarvelXMLElement) {
        try {
            final AdMarvelNativeMetadata adMarvelNativeMetadata = new AdMarvelNativeMetadata();
            final String type = adMarvelXMLElement.getAttributes().get("type");
            final String data = adMarvelXMLElement.getData();
            if (type != null) {
                adMarvelNativeMetadata.setType(type);
            }
            if (data != null) {
                adMarvelNativeMetadata.setValue(data);
            }
            return adMarvelNativeMetadata;
        }
        catch (Exception ex) {
            return null;
        }
    }
    
    private Map parseAndGetNativeAdMetadatas(final AdMarvelXMLElement adMarvelXMLElement) {
        try {
            final HashMap hashMap = new HashMap();
            if (adMarvelXMLElement.getChildren().containsKey("metadata")) {
                for (int size = adMarvelXMLElement.getChildren().get("metadata").size(), i = 0; i < size; ++i) {
                    final AdMarvelXMLElement adMarvelXMLElement2 = adMarvelXMLElement.getChildren().get("metadata").get(i);
                    final String s = adMarvelXMLElement2.getAttributes().get("key");
                    final AdMarvelNativeMetadata andGetNativeAdMetadata = this.parseAndGetNativeAdMetadata(adMarvelXMLElement2);
                    if (andGetNativeAdMetadata != null && s != null) {
                        hashMap.put(s, andGetNativeAdMetadata);
                    }
                }
            }
            return hashMap;
        }
        catch (Exception ex) {
            return null;
        }
    }
    
    private AdMarvelNativeRating parseAndGetNativeAdRating(final AdMarvelXMLElement adMarvelXMLElement) {
        try {
            final AdMarvelNativeRating adMarvelNativeRating = new AdMarvelNativeRating();
            final String value = adMarvelXMLElement.getAttributes().get("value");
            final String base = adMarvelXMLElement.getAttributes().get("base");
            if (value != null) {
                adMarvelNativeRating.setValue(value);
            }
            if (base != null) {
                adMarvelNativeRating.setBase(base);
            }
            if (adMarvelXMLElement.getChildren().containsKey("complete")) {
                final AdMarvelNativeImage andGetNativeAdImageElement = this.parseAndGetNativeAdImageElement(adMarvelXMLElement.getChildren().get("complete").get(0), "image");
                if (andGetNativeAdImageElement != null) {
                    adMarvelNativeRating.setComplete(andGetNativeAdImageElement);
                }
            }
            if (adMarvelXMLElement.getChildren().containsKey("half")) {
                final AdMarvelNativeImage andGetNativeAdImageElement2 = this.parseAndGetNativeAdImageElement(adMarvelXMLElement.getChildren().get("half").get(0), "image");
                if (andGetNativeAdImageElement2 != null) {
                    adMarvelNativeRating.setHalf(andGetNativeAdImageElement2);
                }
            }
            if (adMarvelXMLElement.getChildren().containsKey("full")) {
                final AdMarvelNativeImage andGetNativeAdImageElement3 = this.parseAndGetNativeAdImageElement(adMarvelXMLElement.getChildren().get("full").get(0), "image");
                if (andGetNativeAdImageElement3 != null) {
                    adMarvelNativeRating.setFull(andGetNativeAdImageElement3);
                }
            }
            if (adMarvelXMLElement.getChildren().containsKey("blank")) {
                final AdMarvelNativeImage andGetNativeAdImageElement4 = this.parseAndGetNativeAdImageElement(adMarvelXMLElement.getChildren().get("blank").get(0), "image");
                if (andGetNativeAdImageElement4 != null) {
                    adMarvelNativeRating.setBlank(andGetNativeAdImageElement4);
                }
            }
            return adMarvelNativeRating;
        }
        catch (Exception ex) {
            return null;
        }
    }
    
    private String parseAndGetNativeAdStandardElement(AdMarvelXMLElement adMarvelXMLElement, final String s, int length) {
        try {
            if (adMarvelXMLElement.getChildren().containsKey(s)) {
                adMarvelXMLElement = adMarvelXMLElement.getChildren().get(s).get(length);
                if (adMarvelXMLElement != null) {
                    final String data = adMarvelXMLElement.getData();
                    if (data != null) {
                        length = data.length();
                        if (length > 0) {
                            return data;
                        }
                    }
                }
            }
            return "";
        }
        catch (Exception ex) {
            return "";
        }
    }
    
    private AdMarvelNativeTracker parseAndGetNativeAdTrackerElement(final AdMarvelXMLElement adMarvelXMLElement) {
        try {
            final AdMarvelNativeTracker adMarvelNativeTracker = new AdMarvelNativeTracker();
            final String type = adMarvelXMLElement.getAttributes().get("type");
            if (type != null) {
                adMarvelNativeTracker.setType(type);
            }
            adMarvelNativeTracker.setUrl(this.parseAndGetNativeAdTrackerUrlElement(adMarvelXMLElement));
            return adMarvelNativeTracker;
        }
        catch (Exception ex) {
            return null;
        }
    }
    
    private String[] parseAndGetNativeAdTrackerUrlElement(final AdMarvelXMLElement adMarvelXMLElement) {
        try {
            String[] array2;
            if (adMarvelXMLElement.getChildren().containsKey("url")) {
                final int size = adMarvelXMLElement.getChildren().get("url").size();
                final String[] array = new String[size];
                int n = 0;
                while (true) {
                    array2 = array;
                    if (n >= size) {
                        break;
                    }
                    array[n] = this.parseAndGetNativeAdStandardElement(adMarvelXMLElement, "url", n);
                    ++n;
                }
            }
            else {
                array2 = null;
            }
            return array2;
        }
        catch (Exception ex) {
            return null;
        }
    }
    
    private AdMarvelNativeTracker[] parseAndGetNativeAdTrackersElement(final AdMarvelXMLElement adMarvelXMLElement) {
        try {
            if (adMarvelXMLElement.getChildren().containsKey("tracker")) {
                final int size = adMarvelXMLElement.getChildren().get("tracker").size();
                final AdMarvelNativeTracker[] array = new AdMarvelNativeTracker[size];
                for (int i = 0; i < size; ++i) {
                    array[i] = this.parseAndGetNativeAdTrackerElement(adMarvelXMLElement.getChildren().get("tracker").get(i));
                }
                return array;
            }
            return null;
        }
        catch (Exception ex) {
            return null;
        }
    }
    
    private AdMarvelNativeImage[] parseAndGetNativeAdcampaignImageElement(final AdMarvelXMLElement adMarvelXMLElement, final String s) {
        AdMarvelNativeImage[] array;
        try {
            if (!adMarvelXMLElement.getChildren().containsKey(s)) {
                return null;
            }
            final int size = adMarvelXMLElement.getChildren().get(s).size();
            array = new AdMarvelNativeImage[size];
            for (int i = 0; i < size; ++i) {
                array[i] = this.parseAndGetNativeAdImageElement(adMarvelXMLElement.getChildren().get(s).get(i));
            }
        }
        catch (Exception ex) {
            return null;
        }
        return array;
    }
    
    private void redirectUrl(final String s) {
        Context context = null;
        if (s == null) {
            return;
        }
        try {
            if (s.length() > 0) {
                if (this.getContextReference() != null) {
                    context = (Context)this.getContextReference().get();
                }
                new Thread(new AdMarvelRedirectRunnable(s, context, null, "native", this.ADMARVEL_NATIVE_AD_GUID, true, false, false)).start();
            }
        }
        catch (Exception ex) {
            Logging.log(Log.getStackTraceString((Throwable)ex));
        }
    }
    
    private void setCampaignImage(final AdMarvelNativeImage[] campaignImage) {
        this.campaignImage = campaignImage;
    }
    
    private void setDisplayName(final String displayName) {
        this.displayName = displayName;
    }
    
    private void setFullMessage(final String fullMessage) {
        this.fullMessage = fullMessage;
    }
    
    private void setIcon(final AdMarvelNativeImage icon) {
        this.icon = icon;
    }
    
    private void setNativeAdFields(final String s, final Object o) {
        if (s != null && o != null) {
            if (s.equals("displayName") && o instanceof String) {
                this.displayName = (String)o;
                return;
            }
            if (s != null && s.equals("fullMessage") && o != null && o instanceof String) {
                this.fullMessage = (String)o;
                return;
            }
            if (s != null && s.equals("shortMessage") && o != null && o instanceof String) {
                this.shortMessage = (String)o;
                return;
            }
            if (s != null && s.equals("icon") && o != null && o instanceof AdMarvelNativeImage) {
                this.icon = (AdMarvelNativeImage)o;
                return;
            }
            if (s != null && s.equals("campaignImage") && (o instanceof AdMarvelNativeImage[] || o instanceof Object[])) {
                if (o instanceof Object[]) {
                    final AdMarvelNativeImage[] campaignImage = new AdMarvelNativeImage[((Object[])o).length];
                    for (int i = 0; i < ((Object[])o).length; ++i) {
                        campaignImage[i] = (AdMarvelNativeImage)((Object[])o)[i];
                    }
                    this.campaignImage = campaignImage;
                    return;
                }
                this.campaignImage = (AdMarvelNativeImage[])o;
            }
            else {
                if (s != null && s.equals("rating") && o instanceof AdMarvelNativeRating) {
                    this.rating = (AdMarvelNativeRating)o;
                    return;
                }
                if (s != null && s.equals("cta") && o instanceof AdMarvelNativeCta) {
                    this.setCta((AdMarvelNativeCta)o);
                    return;
                }
                if (s != null && s.equals("metadatas") && o instanceof Map) {
                    final HashMap metadatas = new HashMap();
                    for (final String s2 : ((Map)o).keySet()) {
                        metadatas.put(s2, ((Map)o).get(s2));
                    }
                    this.setMetadatas(metadatas);
                }
            }
        }
    }
    
    private void setRating(final AdMarvelNativeRating rating) {
        this.rating = rating;
    }
    
    private void setShortMessage(final String shortMessage) {
        this.shortMessage = shortMessage;
    }
    
    public boolean canRegisterViewForInteraction() {
        return this.canRegisterViewForInteraction;
    }
    
    public boolean checkForBlockedAd() {
        final Context context = (Context)this.contextReference.get();
        try {
            final SharedPreferences sharedPreferences = context.getSharedPreferences(AdMarvelUtils.encodeString("admarvel"), 0);
            final String versionName = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
            final int versionCode = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
            String s;
            if (versionName != null) {
                s = "duration" + versionName + versionCode + AdMarvelUtils.getSDKVersion();
            }
            else {
                s = "duration" + versionCode + AdMarvelUtils.getSDKVersion();
            }
            if (s != null) {
                final String string = sharedPreferences.getString(AdMarvelUtils.encodeString(s), (String)null);
                if (string != null && string.length() > 0 && DateFormat.getDateTimeInstance().parse(DateFormat.getDateTimeInstance().format(new Date(System.currentTimeMillis()))).before(DateFormat.getDateTimeInstance().parse(string))) {
                    Logging.log("requestNewAd: AD REQUEST BLOCKED, IGNORING REQUEST");
                    this.listenerImpl.a(this, AdMarvelUtils$AdMArvelErrorReason.AD_REQUEST_IN_PROCESS_EXCEPTION.getErrorCode(), AdMarvelUtils$AdMArvelErrorReason.AD_REQUEST_IN_PROCESS_EXCEPTION);
                    return true;
                }
            }
        }
        catch (Exception ex) {
            return false;
        }
        return false;
    }
    
    protected void disableAdRequest(String format) {
        if (this.mContext == null) {
            return;
        }
        while (true) {
            while (true) {
                try {
                    final String versionName = this.mContext.getPackageManager().getPackageInfo(this.mContext.getPackageName(), 0).versionName;
                    final int versionCode = this.mContext.getPackageManager().getPackageInfo(this.mContext.getPackageName(), 0).versionCode;
                    String s;
                    if (versionName != null) {
                        s = "duration" + versionName + versionCode + AdMarvelUtils.getSDKVersion();
                    }
                    else {
                        s = "duration" + versionCode + AdMarvelUtils.getSDKVersion();
                    }
                    if (s != null) {
                        final SharedPreferences$Editor edit = this.mContext.getSharedPreferences(AdMarvelUtils.encodeString("admarvel"), 0).edit();
                        format = DateFormat.getDateTimeInstance().format(new Date(System.currentTimeMillis() + Integer.parseInt(format) * 1000));
                        edit.putString(AdMarvelUtils.encodeString(s), format);
                        edit.commit();
                        Logging.log("requestNewAd: AD REQUEST BLOCKED, IGNORING REQUEST");
                        if (this.listenerImpl != null) {
                            this.listenerImpl.a(this, AdMarvelUtils$AdMArvelErrorReason.AD_REQUEST_IN_PROCESS_EXCEPTION.getErrorCode(), AdMarvelUtils$AdMArvelErrorReason.AD_REQUEST_IN_PROCESS_EXCEPTION);
                        }
                    }
                    return;
                }
                catch (PackageManager$NameNotFoundException ex) {
                    Logging.log(Log.getStackTraceString((Throwable)ex));
                    final String s = null;
                    continue;
                }
                continue;
            }
        }
    }
    
    public String getAdId() {
        return this.adId;
    }
    
    public AdMarvelNetworkHandler getAdMarvelNetworkHandler() {
        return this.adMarvelNetworkHandler;
    }
    
    public String getAdSponsoredMarker() {
        return this.adSponsoredMarker;
    }
    
    public AdMarvelNativeAd$AdType getAdType() {
        return this.adType;
    }
    
    public AdMarvelNativeImage[] getCampaignImage() {
        return this.campaignImage;
    }
    
    public WeakReference getContextReference() {
        return this.contextReference;
    }
    
    public AdMarvelNativeCta getCta() {
        return this.cta;
    }
    
    public String getDeviceConnectivity() {
        return this.deviceConnectivity;
    }
    
    public String getDisableAdDuration() {
        return this.disableAdDuration;
    }
    
    public String getDisplayName() {
        return this.displayName;
    }
    
    public int getErrorCode() {
        return this.errorCode;
    }
    
    public String getErrorReason() {
        return this.errorReason;
    }
    
    public String getExcluded() {
        return this.excluded;
    }
    
    public String getFacebookChildDirectedFlag() {
        return this.facebookChildDirectedFlag;
    }
    
    public String[] getFacebookTestDeviceId() {
        return this.facebookTestDeviceId;
    }
    
    public String getFullMessage() {
        return this.fullMessage;
    }
    
    public AdMarvelNativeImage getIcon() {
        return this.icon;
    }
    
    public int getId() {
        return this.id;
    }
    
    public String getIpAddress() {
        return this.ipAddress;
    }
    
    public a getListener() {
        return this.listenerImpl;
    }
    
    public int getMaxretries() {
        return this.maxretries;
    }
    
    public Map getMetadatas() {
        return this.metadatas;
    }
    
    public int getOrientation() {
        return this.orientation;
    }
    
    public String getPartnerId() {
        return this.partnerId;
    }
    
    public List getPixels() {
        return this.pixels;
    }
    
    public String getPubId() {
        return this.pubId;
    }
    
    public AdMarvelNativeRating getRating() {
        return this.rating;
    }
    
    public String getRequestJson() {
        return this.requestJson;
    }
    
    public String getResponseJson() {
        return this.responseJson;
    }
    
    public Boolean getRetry() {
        return this.retry;
    }
    
    public int getRetrynum() {
        return this.retrynum;
    }
    
    public AdMarvelUtils$SDKAdNetwork getSdkAdNetwork() {
        return this.sdkAdNetwork;
    }
    
    public String getSdkNetwork() {
        return this.sdkNetwork;
    }
    
    public String getShortMessage() {
        return this.shortMessage;
    }
    
    public String getSiteId() {
        return this.siteId;
    }
    
    public String getSource() {
        return this.source;
    }
    
    public Map getTargetParams() {
        return this.targetParams;
    }
    
    public AdMarvelNativeTracker[] getTrackers() {
        return this.trackers;
    }
    
    public String getXml() {
        return this.xml;
    }
    
    public Context getmContext() {
        return this.mContext;
    }
    
    public void handleClick() {
        if (this.getAdType() == AdMarvelNativeAd$AdType.SDKCALL) {
            final AdMarvelAdapter instance = AdMarvelAdapterInstances.getInstance(this.ADMARVEL_NATIVE_AD_GUID, this.getSdkNetwork());
            if (instance != null) {
                instance.handleClick();
            }
            return;
        }
        String clickUrl;
        if (this.getCta() != null) {
            clickUrl = this.getCta().getClickUrl();
        }
        else {
            clickUrl = null;
        }
        if (clickUrl != null) {
            this.redirectUrl(clickUrl);
        }
        this.fireTrackerPixel("click");
    }
    
    public void handleImpression() {
        this.firePixel();
        this.fireTrackerPixel("impression");
        if (this.getAdType() == AdMarvelNativeAd$AdType.SDKCALL) {
            final AdMarvelAdapter instance = AdMarvelAdapterInstances.getInstance(this.ADMARVEL_NATIVE_AD_GUID, this.getSdkNetwork());
            if (instance != null) {
                instance.handleImpression();
            }
        }
    }
    
    public boolean isDisableAdrequest() {
        return this.disableAdRequest;
    }
    
    public AdMarvelXMLReader loadAd(String data) {
        if (data != null) {
            final AdMarvelXMLReader adMarvelXMLReader = new AdMarvelXMLReader();
            adMarvelXMLReader.parseXMLString(data);
            AdMarvelXMLElement adMarvelXMLElement = adMarvelXMLReader.getParsedXMLData();
            if (adMarvelXMLElement != null) {
                this.pixels = null;
                this.trackers = null;
                if (adMarvelXMLElement.getName().equals("ad")) {
                    final String adId = adMarvelXMLElement.getAttributes().get("id");
                    if (adId != null && adId.length() > 0) {
                        this.id = Integer.parseInt(adId);
                        this.adId = adId;
                    }
                    final String ipAddress = adMarvelXMLElement.getAttributes().get("ip");
                    if (ipAddress != null && ipAddress.length() > 0) {
                        this.ipAddress = ipAddress;
                    }
                    final String s = adMarvelXMLElement.getAttributes().get("type");
                    if ("error".equals(s)) {
                        this.adType = AdMarvelNativeAd$AdType.ERROR;
                    }
                    else if ("sdkcall".equals(s)) {
                        this.adType = AdMarvelNativeAd$AdType.SDKCALL;
                    }
                    else if ("native".equals(s)) {
                        this.adType = AdMarvelNativeAd$AdType.NATIVE;
                    }
                    final String source = adMarvelXMLElement.getAttributes().get("source");
                    if (source != null && source.length() > 0) {
                        this.source = source;
                    }
                }
                else {
                    this.adType = AdMarvelNativeAd$AdType.ERROR;
                }
                if (adMarvelXMLElement.getChildren().containsKey("pixels")) {
                    final AdMarvelXMLElement adMarvelXMLElement2 = adMarvelXMLElement.getChildren().get("pixels").get(0);
                    if (adMarvelXMLElement2.getChildren().containsKey("pixel")) {
                        for (int size = adMarvelXMLElement2.getChildren().get("pixel").size(), i = 0; i < size; ++i) {
                            final AdMarvelXMLElement adMarvelXMLElement3 = adMarvelXMLElement2.getChildren().get("pixel").get(i);
                            if (adMarvelXMLElement3 != null) {
                                final String data2 = adMarvelXMLElement3.getData();
                                if (this.pixels == null) {
                                    this.pixels = new ArrayList();
                                }
                                this.pixels.add(data2);
                            }
                        }
                    }
                }
                if (this.adType.equals(AdMarvelNativeAd$AdType.SDKCALL)) {
                    final AdMarvelXMLElement adMarvelXMLElement4 = adMarvelXMLElement.getChildren().get("xhtml").get(0);
                    if (adMarvelXMLElement4 != null) {
                        data = adMarvelXMLElement4.getData();
                        adMarvelXMLReader.parseXMLString(new d().a(data));
                        adMarvelXMLElement = adMarvelXMLReader.getParsedXMLData();
                        final String s2 = adMarvelXMLElement.getAttributes().get("network");
                        if ("facebook".equals(s2)) {
                            this.sdkNetwork = "com.admarvel.android.admarvelfacebookadapter.AdMarvelFacebookAdapter";
                            this.sdkAdNetwork = AdMarvelUtils$SDKAdNetwork.FACEBOOK;
                            this.canRegisterViewForInteraction = true;
                        }
                        else if ("heyzap".equals(s2)) {
                            this.sdkNetwork = "com.admarvel.android.admarvelheyzapadapter.AdMarvelHeyzapAdapter";
                            this.sdkAdNetwork = AdMarvelUtils$SDKAdNetwork.HEYZAP;
                        }
                        else if ("disable_ad_request".equals(s2)) {
                            final String disableAdDuration = adMarvelXMLElement.getAttributes().get("durationinseconds");
                            if (disableAdDuration != null) {
                                this.disableAdRequest = true;
                                this.disableAdDuration = disableAdDuration;
                            }
                        }
                        else {
                            this.adType = AdMarvelNativeAd$AdType.ERROR;
                            this.errorCode = AdMarvelUtils$AdMArvelErrorReason.AD_REQUEST_SDK_TYPE_UNSUPPORTED.getErrorCode();
                            this.errorReason = "Missing SDK ad network";
                        }
                        if ("YES".equals(adMarvelXMLElement.getAttributes().get("retry"))) {
                            this.retry = true;
                        }
                        else {
                            this.retry = false;
                        }
                        final String s3 = adMarvelXMLElement.getAttributes().get("retrynum");
                        if (s3 != null && s3.length() > 0) {
                            this.retrynum = Integer.parseInt(s3);
                        }
                        final String excluded = adMarvelXMLElement.getAttributes().get("excluded");
                        if (excluded != null && excluded.length() > 0) {
                            this.excluded = excluded;
                        }
                        final String s4 = adMarvelXMLElement.getAttributes().get("maxretries");
                        if (s4 != null && s4.length() > 0) {
                            this.maxretries = Integer.parseInt(s4);
                        }
                        else {
                            this.maxretries = 1;
                        }
                    }
                }
                while (true) {
                    if (adMarvelXMLElement.getChildren().containsKey("errorCode")) {
                        final AdMarvelXMLElement adMarvelXMLElement5 = adMarvelXMLElement.getChildren().get("errorCode").get(0);
                        if (adMarvelXMLElement5 != null) {
                            this.errorCode = Integer.parseInt(adMarvelXMLElement5.getData());
                        }
                    }
                    if (adMarvelXMLElement.getChildren().containsKey("errorReason")) {
                        final AdMarvelXMLElement adMarvelXMLElement6 = adMarvelXMLElement.getChildren().get("errorReason").get(0);
                        if (adMarvelXMLElement6 != null) {
                            this.errorReason = adMarvelXMLElement6.getData();
                        }
                    }
                    if (this.adType.equals(AdMarvelNativeAd$AdType.NATIVE) && adMarvelXMLElement != null) {
                        this.displayName = this.parseAndGetNativeAdStandardElement(adMarvelXMLElement, "displayName", 0);
                        this.shortMessage = this.parseAndGetNativeAdStandardElement(adMarvelXMLElement, "shortMessage", 0);
                        this.fullMessage = this.parseAndGetNativeAdStandardElement(adMarvelXMLElement, "fullMessage", 0);
                        this.adSponsoredMarker = this.parseAndGetNativeAdStandardElement(adMarvelXMLElement, "adSponsoredMarker", 0);
                        if (adMarvelXMLElement.getChildren().get("icon") != null) {
                            this.icon = this.parseAndGetNativeAdImageElement(((ArrayList<AdMarvelXMLElement>)adMarvelXMLElement.getChildren().get("icon")).get(0), "image");
                        }
                        if (adMarvelXMLElement.getChildren().get("campaignImage") != null) {
                            this.campaignImage = this.parseAndGetNativeAdcampaignImageElement(((ArrayList<AdMarvelXMLElement>)adMarvelXMLElement.getChildren().get("campaignImage")).get(0), "image");
                        }
                        if (adMarvelXMLElement.getChildren().get("cta") != null) {
                            this.cta = this.parseAndGetNativeAdCTA(((ArrayList<AdMarvelXMLElement>)adMarvelXMLElement.getChildren().get("cta")).get(0));
                        }
                        if (adMarvelXMLElement.getChildren().get("metadatas") != null) {
                            this.metadatas = this.parseAndGetNativeAdMetadatas(((ArrayList<AdMarvelXMLElement>)adMarvelXMLElement.getChildren().get("metadatas")).get(0));
                            if (this.metadatas.containsKey("rating")) {
                                final AdMarvelNativeMetadata adMarvelNativeMetadata = this.metadatas.get("rating");
                                if (adMarvelNativeMetadata.getType() != null && adMarvelNativeMetadata.getType().equals("xml")) {
                                    final String value = adMarvelNativeMetadata.getValue();
                                    if (value != null) {
                                        final AdMarvelXMLReader adMarvelXMLReader2 = new AdMarvelXMLReader();
                                        adMarvelXMLReader2.parseXMLString(value);
                                        final AdMarvelXMLElement parsedXMLData = adMarvelXMLReader2.getParsedXMLData();
                                        if (parsedXMLData != null) {
                                            this.rating = this.parseAndGetNativeAdRating(parsedXMLData);
                                        }
                                    }
                                }
                                if (adMarvelXMLElement.getChildren().get("rating") != null) {
                                    this.rating = this.parseAndGetNativeAdRating(((ArrayList<AdMarvelXMLElement>)adMarvelXMLElement.getChildren().get("rating")).get(0));
                                }
                            }
                        }
                        if (adMarvelXMLElement.getChildren().get("trackers") != null) {
                            this.trackers = this.parseAndGetNativeAdTrackersElement(((ArrayList<AdMarvelXMLElement>)adMarvelXMLElement.getChildren().get("trackers")).get(0));
                        }
                    }
                    return adMarvelXMLReader;
                    continue;
                }
            }
        }
        return null;
    }
    
    public void nativeAdCleanup() {
        if (this.contextReference != null) {
            this.contextReference.clear();
        }
        if (this.targetParams != null) {
            this.targetParams.clear();
        }
        this.partnerId = null;
        this.siteId = null;
        this.deviceConnectivity = null;
        this.pixels = null;
        this.id = 0;
        this.ipAddress = null;
        this.source = null;
        this.canRegisterViewForInteraction = false;
        this.disableAdRequest = false;
        this.disableAdDuration = null;
        this.retrynum = -1;
        this.displayName = null;
        this.shortMessage = null;
        this.fullMessage = null;
        this.adSponsoredMarker = null;
        this.icon = null;
        this.campaignImage = null;
        this.cta = null;
        this.metadatas = null;
        this.rating = null;
        this.trackers = null;
    }
    
    public void registerViewForInteraction(final View view) {
        if (this.getAdType() == AdMarvelNativeAd$AdType.SDKCALL && this.getSdkAdNetwork() == AdMarvelUtils$SDKAdNetwork.FACEBOOK) {
            this.unregisterView();
            final AdMarvelAdapter instance = AdMarvelAdapterInstances.getInstance(this.ADMARVEL_NATIVE_AD_GUID, this.getSdkNetwork());
            if (instance != null) {
                instance.registerViewForInteraction(view);
            }
        }
    }
    
    public void removeNonStringEntriesTargetParam() {
        while (true) {
            ConcurrentHashMap<String, String> concurrentHashMap2 = null;
            Label_0223: {
                synchronized (this) {
                    while (true) {
                        final ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
                        concurrentHashMap.putAll(this.targetParams);
                        while (true) {
                            Label_0203: {
                                try {
                                    concurrentHashMap2 = new ConcurrentHashMap<String, String>();
                                    concurrentHashMap2.putAll(this.targetParams);
                                    for (final Map.Entry<Object, V> entry : concurrentHashMap2.entrySet()) {
                                        if (!(entry.getValue() instanceof String)) {
                                            if (!(entry.getValue() instanceof Location) || !entry.getKey().equals("LOCATION_OBJECT")) {
                                                break Label_0203;
                                            }
                                            final Location location = (Location)entry.getValue();
                                            concurrentHashMap2.put("GEOLOCATION", String.format("%f,%f", location.getLatitude(), location.getLongitude()));
                                            concurrentHashMap2.remove(entry.getKey());
                                        }
                                    }
                                    break Label_0223;
                                }
                                catch (Exception concurrentHashMap2) {
                                    this.targetParams.clear();
                                    this.targetParams.putAll(concurrentHashMap);
                                    ((Throwable)concurrentHashMap2).printStackTrace();
                                }
                                break;
                            }
                            final Map.Entry<Object, V> entry;
                            concurrentHashMap2.remove(entry.getKey());
                            continue;
                        }
                    }
                    return;
                }
            }
            this.targetParams.clear();
            this.targetParams.putAll(concurrentHashMap2);
        }
    }
    
    public void requestNativeAd(final AdMarvelNativeAd$RequestParameters adMarvelNativeAd$RequestParameters) {
        this.contextReference = new WeakReference((T)adMarvelNativeAd$RequestParameters.mContext);
        this.partnerId = adMarvelNativeAd$RequestParameters.mPartnerId.trim();
        this.siteId = adMarvelNativeAd$RequestParameters.mSiteId.trim();
        this.mContext = (Context)this.contextReference.get();
        this.targetParams = adMarvelNativeAd$RequestParameters.mTargetParams;
        if (this.mContext != null) {
            this.orientation = AdMarvelUtils.getScreenOrientation(this.mContext);
            this.deviceConnectivity = AdMarvelUtils.getDeviceConnectivitiy(this.mContext);
            try {
                if (this.checkForBlockedAd()) {
                    if (this.listenerImpl != null) {
                        this.listenerImpl.a(this, AdMarvelUtils$AdMArvelErrorReason.AD_REQUEST_XML_PARSING_EXCEPTION.getErrorCode(), AdMarvelUtils$AdMArvelErrorReason.AD_REQUEST_XML_PARSING_EXCEPTION);
                    }
                    return;
                }
            }
            catch (Exception ex) {
                Logging.log(Log.getStackTraceString((Throwable)ex));
                final a listener = this.getListener();
                if (listener != null) {
                    listener.a(this, AdMarvelUtils$AdMArvelErrorReason.AD_REQUEST_IN_PROCESS_EXCEPTION.getErrorCode(), AdMarvelUtils$AdMArvelErrorReason.AD_REQUEST_IN_PROCESS_EXCEPTION);
                }
                return;
            }
            if (System.currentTimeMillis() - this.lockTimestamp.getAndSet(System.currentTimeMillis()) > 2000L) {
                this.listenerImpl.a();
                c.a(new b(), adMarvelNativeAd$RequestParameters, this, 0, "");
                return;
            }
            Logging.log("requestNewAd: AD REQUEST PENDING, IGNORING REQUEST");
            this.listenerImpl.a(this, AdMarvelUtils$AdMArvelErrorReason.AD_REQUEST_IN_PROCESS_EXCEPTION.getErrorCode(), AdMarvelUtils$AdMArvelErrorReason.AD_REQUEST_IN_PROCESS_EXCEPTION);
        }
    }
    
    protected void requestPendingAd() {
        final AdMarvelAdapter instance = AdMarvelAdapterInstances.getInstance(this.ADMARVEL_NATIVE_AD_GUID, this.getSdkNetwork());
        if (instance != null) {
            instance.requestNativeAd(this.internalAdMarvelAdapterListener, this);
        }
    }
    
    public void setAdMarvelNetworkHandler(final AdMarvelNetworkHandler adMarvelNetworkHandler) {
        this.adMarvelNetworkHandler = adMarvelNetworkHandler;
    }
    
    public void setAdType(final AdMarvelNativeAd$AdType adType) {
        this.adType = adType;
    }
    
    public void setCta(final AdMarvelNativeCta cta) {
        this.cta = cta;
    }
    
    public void setErrorCode(final int errorCode) {
        this.errorCode = errorCode;
    }
    
    public void setErrorReason(final String errorReason) {
        this.errorReason = errorReason;
    }
    
    public void setFacebookChildDirectedFlag(final String facebookChildDirectedFlag) {
        this.facebookChildDirectedFlag = facebookChildDirectedFlag;
    }
    
    public void setFacebookTestDeviceId(final String[] facebookTestDeviceId) {
        this.facebookTestDeviceId = facebookTestDeviceId;
    }
    
    public void setListener(final AdMarvelNativeAd$AdMarvelNativeAdListener adMarvelNativeAd$AdMarvelNativeAdListener) {
        this.listenerImpl.a(adMarvelNativeAd$AdMarvelNativeAdListener);
    }
    
    public void setMetadatas(final Map metadatas) {
        this.metadatas = metadatas;
    }
    
    public void setNativeAdErrorTypeFromAdapter(final String errorReason) {
        this.setAdType(AdMarvelNativeAd$AdType.ERROR);
        this.setErrorCode(AdMarvelUtils$AdMArvelErrorReason.AD_REQUEST_MISSING_XML_ELEMENTS.getErrorCode());
        this.setErrorReason(errorReason);
    }
    
    public void setPixels(final List pixels) {
        this.pixels = pixels;
    }
    
    public void setPubId(final String pubId) {
        this.pubId = pubId;
    }
    
    public void setRequestJson(final JSONObject jsonObject) {
        if (jsonObject == null) {
            return;
        }
        try {
            this.requestJson = jsonObject.toString(1);
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    public void unregisterView() {
        if (this.getAdType() == AdMarvelNativeAd$AdType.SDKCALL && this.getSdkAdNetwork() == AdMarvelUtils$SDKAdNetwork.FACEBOOK) {
            final AdMarvelAdapter instance = AdMarvelAdapterInstances.getInstance(this.ADMARVEL_NATIVE_AD_GUID, this.getSdkNetwork());
            if (instance != null) {
                instance.unregisterView();
            }
        }
    }
    
    public void updateNativeAdFromAdapter(final Map map) {
        for (final Map.Entry<String, V> entry : map.entrySet()) {
            if (entry.getKey() != null && entry.getValue() != null) {
                this.setNativeAdFields(entry.getKey(), entry.getValue());
            }
        }
    }
}
