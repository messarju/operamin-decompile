// 
// Decompiled by Procyon v0.6-prerelease
// 

package com.admarvel.android.ads;

import java.util.Date;
import java.util.Calendar;
import java.util.TimeZone;
import java.text.SimpleDateFormat;
import java.util.Iterator;
import android.location.Location;
import java.util.concurrent.ConcurrentHashMap;
import com.admarvel.android.util.a.c$a;
import com.admarvel.android.util.h;
import com.admarvel.android.util.a.a;
import java.util.ArrayList;
import android.content.Context;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.List;
import java.util.Map;
import java.io.Serializable;

public class AdMarvelAd implements Serializable
{
    private String A;
    private String B;
    private long C;
    private String D;
    private String E;
    private String F;
    private String G;
    private String H;
    private String I;
    private String J;
    private Boolean K;
    private String L;
    private int M;
    private String N;
    private int O;
    private boolean P;
    private String Q;
    private String R;
    private String S;
    private final String T;
    private final String U;
    private boolean V;
    private String W;
    private String X;
    private String Y;
    private String Z;
    private int a;
    private String aA;
    private boolean aa;
    private int ab;
    private float ac;
    private String ad;
    private String ae;
    private String af;
    private String ag;
    private AdMarvelAd$RhythmVideoAdType ah;
    private AdMarvelAd$HeyzapAdType ai;
    private boolean aj;
    private boolean ak;
    private String al;
    private String am;
    private String an;
    private String ao;
    private String ap;
    private String aq;
    private boolean ar;
    private Integer as;
    private String at;
    private final Map au;
    private final String av;
    private final String aw;
    private final String ax;
    private final int ay;
    private final String az;
    private String b;
    private String c;
    private String d;
    private String e;
    private int f;
    private int g;
    private String h;
    private String i;
    private AdMarvelAd$AdType j;
    private String k;
    private List l;
    private int m;
    private String n;
    private String o;
    private AdMarvelUtils$SDKAdNetwork p;
    private String q;
    private String r;
    private String s;
    private boolean t;
    private String u;
    private String[] v;
    private String[] w;
    private String x;
    private String y;
    private String z;
    
    public AdMarvelAd(final String u, final Map au, final String av, final String aw, final String ax, final int ay, final String az, final String t) {
        this.f = -1;
        this.g = -1;
        this.x = null;
        this.y = null;
        this.z = null;
        this.A = null;
        this.B = null;
        this.C = 0L;
        this.D = null;
        this.E = null;
        this.V = false;
        this.ac = -1.0f;
        this.ah = null;
        this.ai = null;
        this.as = 0;
        this.P = false;
        this.U = u;
        this.au = au;
        this.av = av;
        this.aw = aw;
        this.ax = ax;
        this.ay = ay;
        this.az = az;
        this.T = t;
        if (ax != null && au.get("UNIQUE_ID") == null) {
            au.put("UNIQUE_ID", ax);
        }
    }
    
    public String getAdColonyAppVersion() {
        return this.B;
    }
    
    public long getAdColonyDelayAfterInitInMs() {
        return this.C;
    }
    
    public String getAdFormat() {
        return this.E;
    }
    
    public int getAdHistoryCounter() {
        return this.as;
    }
    
    public String getAdHistoryDumpString() {
        try {
            final JSONObject jsonObject = new JSONObject();
            jsonObject.put("appname", (Object)this.T);
            jsonObject.put("partnerid", (Object)this.av);
            if (this.al != null) {
                jsonObject.put("request", (Object)new JSONObject(this.al));
            }
            if (this.am != null) {
                jsonObject.put("response", (Object)new JSONObject(this.am));
            }
            if (this.an != null) {
                jsonObject.put("html", (Object)new JSONObject(this.an));
            }
            this.ao = jsonObject.toString(1);
            return this.ao;
        }
        catch (JSONException ex) {
            ex.printStackTrace();
            return this.ao;
        }
        catch (Exception ex2) {
            ex2.printStackTrace();
            return this.ao;
        }
    }
    
    public String getAdId() {
        return this.Q;
    }
    
    public float getAdMarvelViewWidth() {
        return this.ac;
    }
    
    public String getAdMobExtras() {
        return this.z;
    }
    
    public AdMarvelAd$AdType getAdType() {
        return this.j;
    }
    
    public String getAdmobAdFormat() {
        return this.aA;
    }
    
    public String getAdmobTestAction() {
        return this.aA;
    }
    
    public String[] getAdmobTestDeviceId() {
        return this.v;
    }
    
    public String getAmazonAdRequestAdvancedOptions() {
        return this.Z;
    }
    
    public int getAmazonAdTimeOut() {
        return this.ab;
    }
    
    public String getAmazonAdvancedOptions() {
        return this.Y;
    }
    
    public String getAndroidId() {
        return this.ax;
    }
    
    public String getAppId() {
        return this.at;
    }
    
    public String getAppName() {
        return this.S;
    }
    
    public String getBannerid() {
        return this.L;
    }
    
    public String getChannelId() {
        return this.r;
    }
    
    public String getClickURL() {
        return this.i;
    }
    
    public String getCloseFunction() {
        return this.u;
    }
    
    public String getCompanyName() {
        return this.s;
    }
    
    public String getCountdowntext() {
        return this.ap;
    }
    
    public String getCreativeType() {
        return this.k;
    }
    
    public String getDeviceConnectivity() {
        return this.az;
    }
    
    public String getDisableAdDuration() {
        return this.W;
    }
    
    public int getErrorCode() {
        return this.m;
    }
    
    public String getErrorReason() {
        return this.n;
    }
    
    public String getExcluded() {
        return this.N;
    }
    
    public String getExpandDirection() {
        return this.D;
    }
    
    public String getFacebookAdSize() {
        return this.y;
    }
    
    public String getFacebookChildDirectedFlag() {
        return this.x;
    }
    
    public String[] getFacebookTestDeviceId() {
        return this.w;
    }
    
    public String getGooglePlayLocation() {
        return this.A;
    }
    
    public String getHeight() {
        return this.F;
    }
    
    public AdMarvelAd$HeyzapAdType getHeyzapAdType() {
        return this.ai;
    }
    
    public int getId() {
        return this.a;
    }
    
    public String getImageAlt() {
        return this.h;
    }
    
    public int getImageHeight() {
        return this.g;
    }
    
    public String getImageURL() {
        return this.e;
    }
    
    public int getImageWidth() {
        return this.f;
    }
    
    public String getInterstitialAction() {
        return this.I;
    }
    
    public String getIpAddress() {
        return this.b;
    }
    
    public String getKeywordsContentUrl() {
        return this.J;
    }
    
    public int getMaxretries() {
        return this.O;
    }
    
    public String getOfflineBaseUrl() {
        return this.ad;
    }
    
    public String getOfflinekeyUrl() {
        return this.ae;
    }
    
    public int getOrientation() {
        return this.ay;
    }
    
    public String getPartnerId() {
        return this.av;
    }
    
    public List getPixels() {
        return this.l;
    }
    
    public String getPubId() {
        return this.q;
    }
    
    public Boolean getRetry() {
        return this.K;
    }
    
    public int getRetrynum() {
        return this.M;
    }
    
    public AdMarvelAd$RhythmVideoAdType getRhythmVideoAdType() {
        return this.ah;
    }
    
    public String getRhythmVideoUrl() {
        return this.ag;
    }
    
    public String getScene() {
        return this.af;
    }
    
    public AdMarvelUtils$SDKAdNetwork getSdkAdNetwork() {
        return this.p;
    }
    
    public String getSdkNetwork() {
        return this.o;
    }
    
    public String getSiteId() {
        return this.aw;
    }
    
    public String getSlotName() {
        return this.R;
    }
    
    public String getSource() {
        return this.H;
    }
    
    public Map getTargetParams() {
        return this.au;
    }
    
    public String getText() {
        return this.d;
    }
    
    public String getVideoplacement() {
        return this.aq;
    }
    
    public String getWidth() {
        return this.G;
    }
    
    public String getXHTML() {
        return this.c;
    }
    
    public String getXhtml() {
        return this.c;
    }
    
    public String getXml() {
        return this.U;
    }
    
    public String getZoneId() {
        return this.X;
    }
    
    public boolean hasImage() {
        return this.e != null;
    }
    
    public boolean isAmazonEnableGeoLocation() {
        return this.aa;
    }
    
    public boolean isCachingEnabled() {
        return this.aj;
    }
    
    public boolean isDisableAdrequest() {
        return this.V;
    }
    
    public boolean isMustBeVisible() {
        return this.P;
    }
    
    public boolean isTest() {
        return this.t;
    }
    
    public boolean isTimercountdownEnabled() {
        return this.ar;
    }
    
    public boolean isTrackingIdSet() {
        return this.ak;
    }
    
    public AdMarvelXMLReader loadAd(Context ex) {
        if (this.U != null) {
            final AdMarvelXMLReader adMarvelXMLReader = new AdMarvelXMLReader();
            adMarvelXMLReader.parseXMLString(this.U);
            Object parsedXMLData = adMarvelXMLReader.getParsedXMLData();
            if (parsedXMLData != null) {
            Label_0297:
                while (true) {
                    if (!((AdMarvelXMLElement)parsedXMLData).getName().equals("ad")) {
                        this.j = AdMarvelAd$AdType.ERROR;
                        break Label_0297;
                    }
                    final String l = ((AdMarvelXMLElement)parsedXMLData).getAttributes().get("id");
                    if (l != null && l.length() > 0) {
                        this.a = Integer.parseInt(l);
                        this.L = l;
                    }
                    final String b = ((AdMarvelXMLElement)parsedXMLData).getAttributes().get("ip");
                    if (b != null && b.length() > 0) {
                        this.b = b;
                    }
                    final String s = ((AdMarvelXMLElement)parsedXMLData).getAttributes().get("dah");
                    if (s != null && s.length() > 0 && s.equalsIgnoreCase("true")) {
                        AdMarvelUtils.disableLogDump();
                    }
                    final String s2 = ((AdMarvelXMLElement)parsedXMLData).getAttributes().get("type");
                    while (true) {
                        Label_0209: {
                            if ("text".equals(s2)) {
                                this.j = AdMarvelAd$AdType.TEXT;
                                break Label_0209;
                            }
                            Label_0491: {
                                break Label_0491;
                            Block_36_Outer:
                                while (true) {
                                    try {
                                        ex = (Exception)AdMarvelAnalyticsAdapterInstances.getInstance("com.admarvel.android.admarvelmologiqadapter.AdMarvelMologiqAdapter", (Context)ex);
                                        final String s3;
                                        if (s3.equals("1")) {
                                            ((AdMarvelAnalyticsAdapter)ex).enableAppInstallCheck(true);
                                        }
                                        else if (s3.equals("0")) {
                                            ((AdMarvelAnalyticsAdapter)ex).enableAppInstallCheck(false);
                                        }
                                        if (!((AdMarvelXMLElement)parsedXMLData).getChildren().containsKey("pixels")) {
                                            break;
                                        }
                                        final AdMarvelXMLElement adMarvelXMLElement = ((AdMarvelXMLElement)parsedXMLData).getChildren().get("pixels").get(0);
                                        if (adMarvelXMLElement.getChildren().containsKey("pixel")) {
                                            for (int size = adMarvelXMLElement.getChildren().get("pixel").size(), i = 0; i < size; ++i) {
                                                ex = (Exception)adMarvelXMLElement.getChildren().get("pixel").get(i);
                                                if (ex != null) {
                                                    final Serializable data = ((AdMarvelXMLElement)ex).getData();
                                                    Label_0455: {
                                                        if (!AdMarvelView.a) {
                                                            ex = (Exception)data;
                                                            if (!AdMarvelInterstitialAds.enableOfflineSDK) {
                                                                break Label_0455;
                                                            }
                                                        }
                                                        ex = (Exception)((String)data).replaceAll("\\{siteid\\}", this.getSiteId()).replaceAll("\\{random\\}", String.valueOf(System.currentTimeMillis())).replaceAll("\\{uniqueid\\}", this.getAndroidId());
                                                    }
                                                    if (this.l == null) {
                                                        this.l = new ArrayList();
                                                    }
                                                    this.l.add(ex);
                                                }
                                            }
                                            break;
                                        }
                                        break;
                                        while (true) {
                                        Block_37_Outer:
                                            while (true) {
                                                this.j = AdMarvelAd$AdType.CUSTOM;
                                                break Label_0209;
                                            Block_38:
                                                while (true) {
                                                    this.j = AdMarvelAd$AdType.JAVASCRIPT;
                                                    break Label_0209;
                                                    this.j = AdMarvelAd$AdType.IMAGE;
                                                    break Label_0209;
                                                    Label_0533: {
                                                        iftrue(Label_0554:)(!"error".equals(s2));
                                                    }
                                                    break Block_38;
                                                    Label_0554:
                                                    iftrue(Label_0575:)(!"sdkcall".equals(s2));
                                                    this.j = AdMarvelAd$AdType.SDKCALL;
                                                    break Label_0209;
                                                    Label_0512:
                                                    iftrue(Label_0533:)(!"javascript".equals(s2));
                                                    continue Block_36_Outer;
                                                }
                                                this.j = AdMarvelAd$AdType.ERROR;
                                                break Label_0209;
                                                Label_0575: {
                                                    iftrue(Label_0209:)(!"custom".equals(s2));
                                                }
                                                continue Block_37_Outer;
                                            }
                                            iftrue(Label_0512:)(!"image".equals(s2));
                                            continue;
                                        }
                                    }
                                    catch (Exception ex) {
                                        continue Label_0297;
                                    }
                                    continue Label_0297;
                                }
                            }
                            Label_0801: {
                                if ((!AdMarvelView.a && !AdMarvelInterstitialAds.enableOfflineSDK) || !((AdMarvelXMLElement)parsedXMLData).getChildren().containsKey("file")) {
                                    break Label_0801;
                                }
                                ex = (Exception)((ArrayList<AdMarvelXMLElement>)((AdMarvelXMLElement)parsedXMLData).getChildren().get("file")).get(0).getData();
                                Label_0770: {
                                    if (!this.j.equals(AdMarvelAd$AdType.JAVASCRIPT)) {
                                        break Label_0770;
                                    }
                                    c$a a;
                                    Label_0932_Outer:Label_0962_Outer:Label_1104_Outer:
                                    while (true) {
                                        while (true) {
                                            Label_2198: {
                                            Label_2190:
                                                while (true) {
                                                Label_2179:
                                                    while (true) {
                                                        while (true) {
                                                            try {
                                                                a = com.admarvel.android.util.a.a.a(Class.forName("com.admarvel.android.offlinesdk.AdmarvelOfflineUtils").newInstance(), "readData");
                                                                a.a(String.class, this.ae);
                                                                a.a(String.class, ex);
                                                                this.c = (String)a.a();
                                                                if (this.c != null) {
                                                                    this.c = this.c.replaceAll("\\{siteid\\}", this.getSiteId());
                                                                }
                                                                this.ae = this.ae + "/" + (String)ex;
                                                                if (!this.j.equals(AdMarvelAd$AdType.SDKCALL) || !((AdMarvelXMLElement)parsedXMLData).getChildren().containsKey("xhtml")) {
                                                                    break Label_2198;
                                                                }
                                                                ex = (Exception)((ArrayList<AdMarvelXMLElement>)((AdMarvelXMLElement)parsedXMLData).getChildren().get("xhtml")).get(0);
                                                                if (ex == null) {
                                                                    break Label_2198;
                                                                }
                                                                ex = (Exception)((AdMarvelXMLElement)ex).getData();
                                                                adMarvelXMLReader.parseXMLString(new h().a((String)ex));
                                                                ex = (Exception)adMarvelXMLReader.getParsedXMLData();
                                                                parsedXMLData = ((AdMarvelXMLElement)ex).getAttributes().get("network");
                                                                if ("googleplay".equals(parsedXMLData) || "admob".equals(parsedXMLData)) {
                                                                    this.o = "com.admarvel.android.admarvelgoogleplayadapter.AdMarvelGooglePlayAdapter";
                                                                    this.p = AdMarvelUtils$SDKAdNetwork.GOOGLEPLAY;
                                                                    if (!"YES".equals(((AdMarvelXMLElement)ex).getAttributes().get("retry"))) {
                                                                        break Label_2179;
                                                                    }
                                                                    this.K = true;
                                                                    parsedXMLData = ((AdMarvelXMLElement)ex).getAttributes().get("bannerid");
                                                                    if (parsedXMLData != null && ((String)parsedXMLData).length() > 0) {
                                                                        this.L = (String)parsedXMLData;
                                                                    }
                                                                    parsedXMLData = ((AdMarvelXMLElement)ex).getAttributes().get("retrynum");
                                                                    if (parsedXMLData != null && ((String)parsedXMLData).length() > 0) {
                                                                        this.M = Integer.parseInt((String)parsedXMLData);
                                                                    }
                                                                    parsedXMLData = ((AdMarvelXMLElement)ex).getAttributes().get("excluded");
                                                                    if (parsedXMLData != null && ((String)parsedXMLData).length() > 0) {
                                                                        this.N = (String)parsedXMLData;
                                                                    }
                                                                    parsedXMLData = ((AdMarvelXMLElement)ex).getAttributes().get("maxretries");
                                                                    if (parsedXMLData != null && ((String)parsedXMLData).length() > 0) {
                                                                        this.O = Integer.parseInt((String)parsedXMLData);
                                                                        if (this.j.equals(AdMarvelAd$AdType.JAVASCRIPT) && ((AdMarvelXMLElement)ex).getChildren().containsKey("customdata")) {
                                                                            parsedXMLData = ((AdMarvelXMLElement)ex).getChildren().get("customdata").get(0);
                                                                            if (((AdMarvelXMLElement)parsedXMLData).getChildren().containsKey("close_func")) {
                                                                                this.u = ((ArrayList<AdMarvelXMLElement>)((AdMarvelXMLElement)parsedXMLData).getChildren().get("close_func")).get(0).getData();
                                                                            }
                                                                        }
                                                                        if (((AdMarvelXMLElement)ex).getChildren().containsKey("errorCode")) {
                                                                            parsedXMLData = ((AdMarvelXMLElement)ex).getChildren().get("errorCode").get(0);
                                                                            if (parsedXMLData != null) {
                                                                                this.m = Integer.parseInt(((AdMarvelXMLElement)parsedXMLData).getData());
                                                                            }
                                                                        }
                                                                        if (((AdMarvelXMLElement)ex).getChildren().containsKey("errorReason")) {
                                                                            parsedXMLData = ((AdMarvelXMLElement)ex).getChildren().get("errorReason").get(0);
                                                                            if (parsedXMLData != null) {
                                                                                this.n = ((AdMarvelXMLElement)parsedXMLData).getData();
                                                                            }
                                                                        }
                                                                        if (((AdMarvelXMLElement)ex).getChildren().containsKey("xhtml")) {
                                                                            parsedXMLData = ((AdMarvelXMLElement)ex).getChildren().get("xhtml").get(0);
                                                                            if (parsedXMLData != null) {
                                                                                this.c = ((AdMarvelXMLElement)parsedXMLData).getData();
                                                                            }
                                                                        }
                                                                        if (((AdMarvelXMLElement)ex).getChildren().containsKey("clickurl")) {
                                                                            parsedXMLData = ((AdMarvelXMLElement)ex).getChildren().get("clickurl").get(0);
                                                                            if (parsedXMLData != null) {
                                                                                this.i = ((AdMarvelXMLElement)parsedXMLData).getData();
                                                                                if ((AdMarvelView.a || AdMarvelInterstitialAds.enableOfflineSDK) && this.i != null) {
                                                                                    this.i = this.i.replaceAll("\\{siteid\\}", this.getSiteId());
                                                                                }
                                                                            }
                                                                        }
                                                                        if (((AdMarvelXMLElement)ex).getChildren().containsKey("image")) {
                                                                            if (((AdMarvelXMLElement)ex).getChildren().get("image").get(0).getChildren().containsKey("url")) {
                                                                                parsedXMLData = ((AdMarvelXMLElement)ex).getChildren().get("image").get(0).getChildren().get("url").get(0);
                                                                                if (parsedXMLData != null) {
                                                                                    this.e = ((AdMarvelXMLElement)parsedXMLData).getData();
                                                                                }
                                                                            }
                                                                            if (((AdMarvelXMLElement)ex).getChildren().get("image").get(0).getChildren().containsKey("alt")) {
                                                                                parsedXMLData = ((AdMarvelXMLElement)ex).getChildren().get("image").get(0).getChildren().get("alt").get(0);
                                                                                if (parsedXMLData != null) {
                                                                                    this.h = ((AdMarvelXMLElement)parsedXMLData).getData();
                                                                                }
                                                                            }
                                                                            if (((AdMarvelXMLElement)ex).getChildren().get("image").get(0).getChildren().containsKey("width")) {
                                                                                parsedXMLData = ((AdMarvelXMLElement)ex).getChildren().get("image").get(0).getChildren().get("width").get(0);
                                                                                if (parsedXMLData != null) {
                                                                                    this.f = Integer.parseInt(((AdMarvelXMLElement)parsedXMLData).getData());
                                                                                }
                                                                            }
                                                                            if (((AdMarvelXMLElement)ex).getChildren().get("image").get(0).getChildren().containsKey("height")) {
                                                                                parsedXMLData = ((AdMarvelXMLElement)ex).getChildren().get("image").get(0).getChildren().get("height").get(0);
                                                                                if (parsedXMLData != null) {
                                                                                    this.g = Integer.parseInt(((AdMarvelXMLElement)parsedXMLData).getData());
                                                                                }
                                                                            }
                                                                        }
                                                                        if (((AdMarvelXMLElement)ex).getChildren().containsKey("text")) {
                                                                            ex = (Exception)((AdMarvelXMLElement)ex).getChildren().get("text").get(0);
                                                                            if (ex != null) {
                                                                                this.d = ((AdMarvelXMLElement)ex).getData();
                                                                            }
                                                                        }
                                                                        return adMarvelXMLReader;
                                                                    }
                                                                    break Label_2190;
                                                                }
                                                            }
                                                            catch (InstantiationException ex2) {
                                                                ex2.printStackTrace();
                                                                continue Label_0932_Outer;
                                                            }
                                                            catch (IllegalAccessException ex3) {
                                                                ex3.printStackTrace();
                                                                continue Label_0932_Outer;
                                                            }
                                                            catch (ClassNotFoundException ex4) {
                                                                ex4.printStackTrace();
                                                                continue Label_0932_Outer;
                                                            }
                                                            catch (Exception ex5) {
                                                                ex5.printStackTrace();
                                                                continue Label_0932_Outer;
                                                            }
                                                            break;
                                                        }
                                                        if ("rhythm".equals(parsedXMLData)) {
                                                            this.o = "com.admarvel.android.admarvelrhythmadapter.AdMarvelRhythmAdapter";
                                                            this.p = AdMarvelUtils$SDKAdNetwork.RHYTHM;
                                                            continue Label_0962_Outer;
                                                        }
                                                        if ("millennial".equals(parsedXMLData)) {
                                                            this.o = "com.admarvel.android.admarvelmillennialadapter.AdMarvelMillennialAdapter";
                                                            this.p = AdMarvelUtils$SDKAdNetwork.MILLENNIAL;
                                                            continue Label_0962_Outer;
                                                        }
                                                        if ("amazon".equals(parsedXMLData)) {
                                                            this.o = "com.admarvel.android.admarvelamazonadapter.AdMarvelAmazonAdapter";
                                                            this.p = AdMarvelUtils$SDKAdNetwork.AMAZON;
                                                            continue Label_0962_Outer;
                                                        }
                                                        if ("adcolony".equals(parsedXMLData)) {
                                                            this.o = "com.admarvel.android.admarveladcolonyadapter.AdMarvelAdColonyAdapter";
                                                            this.p = AdMarvelUtils$SDKAdNetwork.ADCOLONY;
                                                            continue Label_0962_Outer;
                                                        }
                                                        if ("pulse3d".equals(parsedXMLData)) {
                                                            this.o = "com.admarvel.android.admarvelpulse3dadapter.AdMarvelPulse3dAdapter";
                                                            this.p = AdMarvelUtils$SDKAdNetwork.PULSE3D;
                                                            continue Label_0962_Outer;
                                                        }
                                                        if ("facebook".equals(parsedXMLData)) {
                                                            this.o = "com.admarvel.android.admarvelfacebookadapter.AdMarvelFacebookAdapter";
                                                            this.p = AdMarvelUtils$SDKAdNetwork.FACEBOOK;
                                                            continue Label_0962_Outer;
                                                        }
                                                        if ("inmobi".equals(parsedXMLData)) {
                                                            this.o = "com.admarvel.android.admarvelinmobiadapter.AdMarvelInmobiAdapter";
                                                            this.p = AdMarvelUtils$SDKAdNetwork.INMOBI;
                                                            continue Label_0962_Outer;
                                                        }
                                                        if ("heyzap".equals(parsedXMLData)) {
                                                            this.o = "com.admarvel.android.admarvelheyzapadapter.AdMarvelHeyzapAdapter";
                                                            this.p = AdMarvelUtils$SDKAdNetwork.HEYZAP;
                                                            continue Label_0962_Outer;
                                                        }
                                                        if (!"disable_ad_request".equals(parsedXMLData)) {
                                                            this.j = AdMarvelAd$AdType.ERROR;
                                                            this.m = 307;
                                                            this.n = "Missing SDK ad network";
                                                            continue Label_0962_Outer;
                                                        }
                                                        parsedXMLData = ((AdMarvelXMLElement)ex).getAttributes().get("durationinseconds");
                                                        if (parsedXMLData != null) {
                                                            this.V = true;
                                                            this.W = (String)parsedXMLData;
                                                            continue Label_0962_Outer;
                                                        }
                                                        continue Label_0962_Outer;
                                                    }
                                                    this.K = false;
                                                    continue Label_1104_Outer;
                                                }
                                                this.O = 1;
                                                continue;
                                            }
                                            ex = (Exception)parsedXMLData;
                                            continue;
                                        }
                                    }
                                }
                            }
                        }
                        final String h = ((AdMarvelXMLElement)parsedXMLData).getAttributes().get("source");
                        if (h != null && h.length() > 0) {
                            this.H = h;
                        }
                        final String s3 = ((AdMarvelXMLElement)parsedXMLData).getAttributes().get("ave");
                        if (s3 != null && s3.length() > 0) {
                            continue;
                        }
                        break;
                    }
                    continue Label_0297;
                }
            }
        }
        return null;
    }
    
    public void removeNonStringEntriesTargetParam() {
        while (true) {
            ConcurrentHashMap<String, String> concurrentHashMap2 = null;
            Label_0223: {
                synchronized (this) {
                    while (true) {
                        final ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
                        concurrentHashMap.putAll(this.au);
                        while (true) {
                            Label_0203: {
                                try {
                                    concurrentHashMap2 = new ConcurrentHashMap<String, String>();
                                    concurrentHashMap2.putAll(this.au);
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
                                    this.au.clear();
                                    this.au.putAll(concurrentHashMap);
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
            this.au.clear();
            this.au.putAll(concurrentHashMap2);
        }
    }
    
    public void setAdColonyAppVersion(final String b) {
        this.B = b;
    }
    
    public void setAdColonyDelayAfterInitInMs(final long c) {
        this.C = c;
    }
    
    public void setAdFormat(final String e) {
        this.E = e;
    }
    
    public void setAdHistoryCounter(final int n) {
        this.as = n;
    }
    
    public void setAdId(final String q) {
        this.Q = q;
    }
    
    public void setAdMarvelViewWidth(final float ac) {
        this.ac = ac;
    }
    
    public void setAdMobExtras(final String z) {
        this.z = z;
    }
    
    public void setAdType(final AdMarvelAd$AdType j) {
        this.j = j;
    }
    
    public void setAdmobTestAction(final String aa) {
        this.aA = aa;
    }
    
    public void setAdmobTestDeviceId(final String[] v) {
        this.v = v;
    }
    
    public void setAmazonAdRequestAdvancedOptions(final String z) {
        this.Z = z;
    }
    
    public void setAmazonAdTimeOut(final int ab) {
        this.ab = ab;
    }
    
    public void setAmazonAdvancedOptions(final String y) {
        this.Y = y;
    }
    
    public void setAmazonEnableGeoLocation(final boolean aa) {
        this.aa = aa;
    }
    
    public void setAppId(final String at) {
        this.at = at;
    }
    
    public void setAppName(final String s) {
        this.S = s;
    }
    
    public void setBannerid(final String l) {
        this.L = l;
    }
    
    public void setCachingEnabled(final boolean aj) {
        this.aj = aj;
    }
    
    public void setChannelId(final String r) {
        this.r = r;
    }
    
    public void setClickURL(final String i) {
        this.i = i;
    }
    
    public void setCloseFunction(final String u) {
        this.u = u;
    }
    
    public void setCompanyName(final String s) {
        this.s = s;
    }
    
    public void setCountdowntext(final String ap) {
        this.ap = ap;
    }
    
    public void setCreativeType(final String k) {
        this.k = k;
    }
    
    public void setErrorCode(final int m) {
        this.m = m;
    }
    
    public void setErrorReason(final String n) {
        this.n = n;
    }
    
    public void setExcluded(final String n) {
        this.N = n;
    }
    
    public void setExpandDirection(final String d) {
        this.D = d;
    }
    
    public void setFacebookAdSize(final String y) {
        this.y = y;
    }
    
    public void setFacebookChildDirectedFlag(final String x) {
        this.x = x;
    }
    
    public void setFacebookTestDeviceId(final String[] w) {
        this.w = w;
    }
    
    public void setGooglePlayLocation(final String a) {
        this.A = a;
    }
    
    public void setHeight(final String f) {
        this.F = f;
    }
    
    public void setHeyzapAdType(final AdMarvelAd$HeyzapAdType ai) {
        this.ai = ai;
    }
    
    public void setHtmlJson(final String s) {
        try {
            final JSONObject jsonObject = new JSONObject();
            final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT+00:00"));
            final SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            final Date time = Calendar.getInstance().getTime();
            final long currentTimeMillis = System.currentTimeMillis();
            jsonObject.put("data", (Object)s);
            jsonObject.put("timestamp", (Object)String.valueOf((Object)currentTimeMillis));
            jsonObject.put("utc", (Object)simpleDateFormat.format(time));
            jsonObject.put("local", (Object)simpleDateFormat2.format(time));
            this.an = jsonObject.toString(1);
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    public void setId(final int a) {
        this.a = a;
    }
    
    public void setImageAlt(final String h) {
        this.h = h;
    }
    
    public void setImageHeight(final int g) {
        this.g = g;
    }
    
    public void setImageURL(final String e) {
        this.e = e;
    }
    
    public void setImageWidth(final int f) {
        this.f = f;
    }
    
    public void setInterstitialAction(final String i) {
        this.I = i;
    }
    
    public void setIpAddress(final String b) {
        this.b = b;
    }
    
    public void setKeywordsContentUrl(final String j) {
        this.J = j;
    }
    
    public void setMustBeVisible(final boolean p) {
        this.P = p;
    }
    
    public void setOfflineBaseUrl(final String ad) {
        this.ad = ad;
    }
    
    public void setOfflinekeyUrl(final String ae) {
        this.ae = ae;
    }
    
    public void setPixels(final List l) {
        this.l = l;
    }
    
    public void setPubId(final String q) {
        this.q = q;
    }
    
    public void setRequestJson(final JSONObject jsonObject) {
        if (jsonObject == null) {
            return;
        }
        try {
            this.al = jsonObject.toString(1);
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    public void setResponseJson() {
        try {
            final JSONObject jsonObject = new JSONObject();
            final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT+00:00"));
            final SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            final Date time = Calendar.getInstance().getTime();
            final long currentTimeMillis = System.currentTimeMillis();
            jsonObject.put("data", (Object)this.U);
            jsonObject.put("timestamp", (Object)String.valueOf((Object)currentTimeMillis));
            jsonObject.put("utc", (Object)simpleDateFormat.format(time));
            jsonObject.put("local", (Object)simpleDateFormat2.format(time));
            this.am = jsonObject.toString(1);
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    public void setRetry(final Boolean k) {
        this.K = k;
    }
    
    public void setRetrynum(final int m) {
        this.M = m;
    }
    
    public void setRhythmVideoAdType(final AdMarvelAd$RhythmVideoAdType ah) {
        this.ah = ah;
    }
    
    public void setRhythmVideoUrl(final String ag) {
        this.ag = ag;
    }
    
    public void setScene(final String af) {
        this.af = af;
    }
    
    public void setSdkNetwork(final String o) {
        this.o = o;
    }
    
    public void setSetTrackingId(final boolean ak) {
        this.ak = ak;
    }
    
    public void setSlotName(final String r) {
        this.R = r;
    }
    
    public void setSource(final String h) {
        this.H = h;
    }
    
    public void setTest(final boolean t) {
        this.t = t;
    }
    
    public void setText(final String d) {
        this.d = d;
    }
    
    public void setTimercountdown(final boolean ar) {
        this.ar = ar;
    }
    
    public void setVideoplacement(final String aq) {
        this.aq = aq;
    }
    
    public void setWidth(final String g) {
        this.G = g;
    }
    
    public void setXhtml(final String c) {
        this.c = c;
    }
    
    public void setZoneId(final String x) {
        this.X = x;
    }
}
