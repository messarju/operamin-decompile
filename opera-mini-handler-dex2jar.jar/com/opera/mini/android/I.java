// 
// Decompiled by Procyon v0.6-prerelease
// 

package com.opera.mini.android;

import com.admarvel.android.nativeads.AdMarvelNativeImage;
import java.util.Iterator;
import com.admarvel.android.nativeads.AdMarvelNativeTracker;
import java.util.List;
import com.admarvel.android.nativeads.AdMarvelNativeRating;
import com.admarvel.android.nativeads.AdMarvelNativeCta;
import java.util.Collection;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import com.admarvel.android.nativeads.AdMarvelNativeAd;
import com.admarvel.android.ads.AdMarvelUtils$AdMArvelErrorReason;
import com.admarvel.android.nativeads.AdMarvelNativeMetadata;
import java.util.Map;
import com.admarvel.android.nativeads.AdMarvelNativeAd$AdMarvelNativeAdListener;

final class I implements AdMarvelNativeAd$AdMarvelNativeAdListener
{
    private String Code;
    private /* synthetic */ Code I;
    
    public I(final Code i, final String code) {
        this.I = i;
        this.Code = code;
    }
    
    private static String Code(final Map map, final String s) {
        if (map == null || map.get(s) == null) {
            return null;
        }
        return map.get(s).getValue();
    }
    
    @Override
    public final void onClickNativeAd(final String s) {
    }
    
    @Override
    public final void onFailedToReceiveNativeAd(final int n, AdMarvelUtils$AdMArvelErrorReason adMarvelUtils$AdMArvelErrorReason, final AdMarvelNativeAd adMarvelNativeAd) {
        adMarvelUtils$AdMArvelErrorReason = (AdMarvelUtils$AdMArvelErrorReason)new JSONObject();
        while (true) {
            try {
                ((JSONObject)adMarvelUtils$AdMArvelErrorReason).put("fail", n);
                this.I.I.put(this.Code, true);
                this.I.B.Code(this.Code, (JSONObject)adMarvelUtils$AdMArvelErrorReason);
            }
            catch (JSONException ex) {
                continue;
            }
            break;
        }
    }
    
    @Override
    public final void onReceiveNativeAd(final AdMarvelNativeAd adMarvelNativeAd) {
        final Map metadatas = adMarvelNativeAd.getMetadatas();
        boolean b;
        if ("true".equals(Code(metadatas, "click_clientonly")) || "true".equals(Code(metadatas, "impression_clientonly"))) {
            b = true;
        }
        else {
            b = false;
        }
        int code;
        if (b) {
            code = com.opera.mini.android.Code.Code(this.I);
        }
        else {
            code = -1;
        }
        while (true) {
            JSONObject jsonObject = null;
            Label_0866: {
                JSONObject jsonObject4 = null;
                Label_0855: {
                    while (true) {
                        jsonObject = new JSONObject();
                        while (true) {
                            int n = 0;
                            Label_0958: {
                                try {
                                    jsonObject.put("adId", code);
                                    jsonObject.put("sdkAdId", (Object)adMarvelNativeAd.getAdId());
                                    jsonObject.put("sdkAdNetwork", (Object)adMarvelNativeAd.getSdkAdNetwork());
                                    jsonObject.put("adSponsoredMarker", (Object)adMarvelNativeAd.getAdSponsoredMarker());
                                    jsonObject.put("displayName", (Object)adMarvelNativeAd.getDisplayName());
                                    jsonObject.put("shortMessage", (Object)adMarvelNativeAd.getShortMessage());
                                    jsonObject.put("fullMessage", (Object)adMarvelNativeAd.getFullMessage());
                                    final AdMarvelNativeCta cta = adMarvelNativeAd.getCta();
                                    String s;
                                    if (b || cta == null) {
                                        s = "vnd.opera.native.ad:" + code;
                                    }
                                    else {
                                        s = cta.getClickUrl();
                                    }
                                    jsonObject.put("clickUrl", (Object)s);
                                    if (cta != null) {
                                        final JSONObject jsonObject2 = new JSONObject();
                                        jsonObject2.put("clickUrl", (Object)cta.getClickUrl());
                                        jsonObject2.put("action", (Object)cta.getAction());
                                        jsonObject2.put("title", (Object)cta.getTitle());
                                        final Code i = this.I;
                                        jsonObject2.put("image", com.opera.mini.android.Code.Code(cta.getImage()));
                                        jsonObject.put("cta", (Object)jsonObject2);
                                    }
                                    final AdMarvelNativeRating rating = adMarvelNativeAd.getRating();
                                    if (rating != null) {
                                        final JSONObject jsonObject3 = new JSONObject();
                                        jsonObject3.put("base", (Object)rating.getBase());
                                        jsonObject3.put("value", (Object)rating.getValue());
                                        final Code j = this.I;
                                        jsonObject3.put("blank", com.opera.mini.android.Code.Code(rating.getBlank()));
                                        final Code k = this.I;
                                        jsonObject3.put("half", com.opera.mini.android.Code.Code(rating.getHalf()));
                                        final Code l = this.I;
                                        jsonObject3.put("full", com.opera.mini.android.Code.Code(rating.getFull()));
                                        final Code m = this.I;
                                        jsonObject3.put("complete", com.opera.mini.android.Code.Code(rating.getComplete()));
                                        jsonObject.put("rating", (Object)jsonObject3);
                                    }
                                    if (!b) {
                                        final List pixels = adMarvelNativeAd.getPixels();
                                        if (pixels != null && !pixels.isEmpty()) {
                                            jsonObject.put("pixels", (Object)new JSONArray((Collection)pixels));
                                        }
                                        if (adMarvelNativeAd.getTrackers() != null) {
                                            final JSONArray jsonArray = new JSONArray();
                                            final JSONArray jsonArray2 = new JSONArray();
                                            final AdMarvelNativeTracker[] trackers = adMarvelNativeAd.getTrackers();
                                            final int length = trackers.length;
                                            n = 0;
                                            if (n < length) {
                                                final AdMarvelNativeTracker adMarvelNativeTracker = trackers[n];
                                                if ("click".equals(adMarvelNativeTracker.getType())) {
                                                    final String[] url = adMarvelNativeTracker.getUrl();
                                                    for (int length2 = url.length, n2 = 0; n2 < length2; ++n2) {
                                                        jsonArray.put((Object)url[n2]);
                                                    }
                                                    break Label_0958;
                                                }
                                                if ("impression".equals(adMarvelNativeTracker.getType())) {
                                                    final String[] url2 = adMarvelNativeTracker.getUrl();
                                                    for (int length3 = url2.length, n3 = 0; n3 < length3; ++n3) {
                                                        jsonArray2.put((Object)url2[n3]);
                                                    }
                                                }
                                                break Label_0958;
                                            }
                                            else {
                                                if (jsonArray.length() > 0) {
                                                    jsonObject.put("clickTrackers", (Object)jsonArray);
                                                }
                                                if (jsonArray2.length() > 0) {
                                                    jsonObject.put("impressionTrackers", (Object)jsonArray2);
                                                }
                                            }
                                        }
                                    }
                                    final Code i2 = this.I;
                                    jsonObject.put("icon", com.opera.mini.android.Code.Code(adMarvelNativeAd.getIcon()));
                                    if (metadatas != null) {
                                        jsonObject.put("operaAdType", (Object)Code(metadatas, "opera_type"));
                                        jsonObject4 = new JSONObject();
                                        for (final String s2 : metadatas.keySet()) {
                                            jsonObject4.put(s2, (Object)Code(metadatas, s2));
                                        }
                                        break Label_0855;
                                    }
                                    break Label_0866;
                                }
                                catch (JSONException ex) {}
                                break;
                            }
                            ++n;
                            continue;
                        }
                    }
                    this.I.B.Code(this.Code, jsonObject);
                    this.I.I.put(this.Code, true);
                    if (b) {
                        this.I.Z.put(code, adMarvelNativeAd);
                        this.I.J.put(this.Code, code);
                    }
                    return;
                }
                jsonObject.put("metadatas", (Object)jsonObject4);
            }
            final AdMarvelNativeImage[] campaignImage = adMarvelNativeAd.getCampaignImage();
            if (campaignImage != null) {
                final JSONArray jsonArray3 = new JSONArray();
                for (int length4 = campaignImage.length, n4 = 0; n4 < length4; ++n4) {
                    final AdMarvelNativeImage adMarvelNativeImage = campaignImage[n4];
                    final Code i3 = this.I;
                    jsonArray3.put(com.opera.mini.android.Code.Code(adMarvelNativeImage));
                }
                jsonObject.put("campaignImages", (Object)jsonArray3);
            }
            continue;
        }
    }
    
    @Override
    public final void onRequestNativeAd() {
    }
}
