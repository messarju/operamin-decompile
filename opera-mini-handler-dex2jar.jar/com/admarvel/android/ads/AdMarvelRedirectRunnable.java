// 
// Decompiled by Procyon v0.6-prerelease
// 

package com.admarvel.android.ads;

import android.content.Context;
import java.lang.ref.WeakReference;

public class AdMarvelRedirectRunnable implements Runnable
{
    private final String GUID;
    private final AdMarvelAd adMarvelAd;
    private final String adType;
    private final boolean isClickRedirectEnabled;
    private final boolean isOfflineSDK;
    private final boolean isPostitialView;
    private final WeakReference mContextReference;
    private final String url;
    
    public AdMarvelRedirectRunnable(final String url, final Context context, final AdMarvelAd adMarvelAd, final String adType, final String guid, final boolean isClickRedirectEnabled, final boolean isOfflineSDK, final boolean isPostitialView) {
        this.url = url;
        this.mContextReference = new WeakReference((T)context);
        this.adMarvelAd = adMarvelAd;
        this.adType = adType;
        this.GUID = guid;
        this.isClickRedirectEnabled = isClickRedirectEnabled;
        this.isOfflineSDK = isOfflineSDK;
        this.isPostitialView = isPostitialView;
    }
    
    @Override
    public void run() {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: getfield        com/admarvel/android/ads/AdMarvelRedirectRunnable.mContextReference:Ljava/lang/ref/WeakReference;
        //     4: invokevirtual   java/lang/ref/WeakReference.get:()Ljava/lang/Object;
        //     7: checkcast       Landroid/content/Context;
        //    10: astore_2       
        //    11: aload_2        
        //    12: ifnonnull       16
        //    15: return         
        //    16: aload_0        
        //    17: getfield        com/admarvel/android/ads/AdMarvelRedirectRunnable.isClickRedirectEnabled:Z
        //    20: ifeq            141
        //    23: aload_0        
        //    24: getfield        com/admarvel/android/ads/AdMarvelRedirectRunnable.url:Ljava/lang/String;
        //    27: ifnull          386
        //    30: aload_0        
        //    31: getfield        com/admarvel/android/ads/AdMarvelRedirectRunnable.isOfflineSDK:Z
        //    34: ifeq            386
        //    37: aload_0        
        //    38: getfield        com/admarvel/android/ads/AdMarvelRedirectRunnable.url:Ljava/lang/String;
        //    41: invokestatic    com/admarvel/android/ads/r.g:(Ljava/lang/String;)Z
        //    44: ifne            386
        //    47: aload_0        
        //    48: getfield        com/admarvel/android/ads/AdMarvelRedirectRunnable.url:Ljava/lang/String;
        //    51: invokestatic    android/webkit/URLUtil.isNetworkUrl:(Ljava/lang/String;)Z
        //    54: ifeq            236
        //    57: aload_2        
        //    58: aload_0        
        //    59: getfield        com/admarvel/android/ads/AdMarvelRedirectRunnable.url:Ljava/lang/String;
        //    62: aload_0        
        //    63: getfield        com/admarvel/android/ads/AdMarvelRedirectRunnable.isPostitialView:Z
        //    66: invokestatic    com/admarvel/android/ads/r.a:(Landroid/content/Context;Ljava/lang/String;Z)Z
        //    69: ifeq            236
        //    72: aload_0        
        //    73: getfield        com/admarvel/android/ads/AdMarvelRedirectRunnable.adType:Ljava/lang/String;
        //    76: ldc             "banner"
        //    78: invokevirtual   java/lang/String.equals:(Ljava/lang/Object;)Z
        //    81: ifeq            184
        //    84: aload_0        
        //    85: getfield        com/admarvel/android/ads/AdMarvelRedirectRunnable.GUID:Ljava/lang/String;
        //    88: invokestatic    com/admarvel/android/ads/m.a:(Ljava/lang/String;)Lcom/admarvel/android/ads/n;
        //    91: ifnull          15
        //    94: aload_0        
        //    95: getfield        com/admarvel/android/ads/AdMarvelRedirectRunnable.GUID:Ljava/lang/String;
        //    98: invokestatic    com/admarvel/android/ads/m.a:(Ljava/lang/String;)Lcom/admarvel/android/ads/n;
        //   101: aload_0        
        //   102: getfield        com/admarvel/android/ads/AdMarvelRedirectRunnable.adMarvelAd:Lcom/admarvel/android/ads/AdMarvelAd;
        //   105: aload_0        
        //   106: getfield        com/admarvel/android/ads/AdMarvelRedirectRunnable.url:Ljava/lang/String;
        //   109: invokeinterface com/admarvel/android/ads/n.a:(Lcom/admarvel/android/ads/AdMarvelAd;Ljava/lang/String;)V
        //   114: return         
        //   115: astore_1       
        //   116: new             Ljava/lang/StringBuilder;
        //   119: dup            
        //   120: invokespecial   java/lang/StringBuilder.<init>:()V
        //   123: aload_1        
        //   124: invokevirtual   java/lang/Exception.getMessage:()Ljava/lang/String;
        //   127: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   130: ldc             "Exception in RedirectRunnable "
        //   132: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   135: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   138: invokestatic    com/admarvel/android/util/Logging.log:(Ljava/lang/String;)V
        //   141: aload_0        
        //   142: getfield        com/admarvel/android/ads/AdMarvelRedirectRunnable.adType:Ljava/lang/String;
        //   145: ldc             "banner"
        //   147: invokevirtual   java/lang/String.equals:(Ljava/lang/Object;)Z
        //   150: ifeq            1768
        //   153: aload_0        
        //   154: getfield        com/admarvel/android/ads/AdMarvelRedirectRunnable.GUID:Ljava/lang/String;
        //   157: invokestatic    com/admarvel/android/ads/m.a:(Ljava/lang/String;)Lcom/admarvel/android/ads/n;
        //   160: ifnull          15
        //   163: aload_0        
        //   164: getfield        com/admarvel/android/ads/AdMarvelRedirectRunnable.GUID:Ljava/lang/String;
        //   167: invokestatic    com/admarvel/android/ads/m.a:(Ljava/lang/String;)Lcom/admarvel/android/ads/n;
        //   170: aload_0        
        //   171: getfield        com/admarvel/android/ads/AdMarvelRedirectRunnable.adMarvelAd:Lcom/admarvel/android/ads/AdMarvelAd;
        //   174: aload_0        
        //   175: getfield        com/admarvel/android/ads/AdMarvelRedirectRunnable.url:Ljava/lang/String;
        //   178: invokeinterface com/admarvel/android/ads/n.a:(Lcom/admarvel/android/ads/AdMarvelAd;Ljava/lang/String;)V
        //   183: return         
        //   184: aload_0        
        //   185: getfield        com/admarvel/android/ads/AdMarvelRedirectRunnable.adType:Ljava/lang/String;
        //   188: ldc             "interstitial"
        //   190: invokevirtual   java/lang/String.equals:(Ljava/lang/Object;)Z
        //   193: ifeq            236
        //   196: invokestatic    com/admarvel/android/ads/AdMarvelInterstitialAds.getListener:()Lcom/admarvel/android/ads/e;
        //   199: aload_2        
        //   200: aload_0        
        //   201: getfield        com/admarvel/android/ads/AdMarvelRedirectRunnable.url:Ljava/lang/String;
        //   204: aload_0        
        //   205: getfield        com/admarvel/android/ads/AdMarvelRedirectRunnable.adMarvelAd:Lcom/admarvel/android/ads/AdMarvelAd;
        //   208: invokevirtual   com/admarvel/android/ads/AdMarvelAd.getSiteId:()Ljava/lang/String;
        //   211: aload_0        
        //   212: getfield        com/admarvel/android/ads/AdMarvelRedirectRunnable.adMarvelAd:Lcom/admarvel/android/ads/AdMarvelAd;
        //   215: invokevirtual   com/admarvel/android/ads/AdMarvelAd.getId:()I
        //   218: aload_0        
        //   219: getfield        com/admarvel/android/ads/AdMarvelRedirectRunnable.adMarvelAd:Lcom/admarvel/android/ads/AdMarvelAd;
        //   222: invokevirtual   com/admarvel/android/ads/AdMarvelAd.getTargetParams:()Ljava/util/Map;
        //   225: aload_0        
        //   226: getfield        com/admarvel/android/ads/AdMarvelRedirectRunnable.adMarvelAd:Lcom/admarvel/android/ads/AdMarvelAd;
        //   229: invokevirtual   com/admarvel/android/ads/AdMarvelAd.getIpAddress:()Ljava/lang/String;
        //   232: invokevirtual   com/admarvel/android/ads/e.a:(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;ILjava/util/Map;Ljava/lang/String;)V
        //   235: return         
        //   236: aload_0        
        //   237: getfield        com/admarvel/android/ads/AdMarvelRedirectRunnable.adMarvelAd:Lcom/admarvel/android/ads/AdMarvelAd;
        //   240: invokevirtual   com/admarvel/android/ads/AdMarvelAd.getOfflinekeyUrl:()Ljava/lang/String;
        //   243: astore_1       
        //   244: aload_2        
        //   245: new             Ljava/lang/StringBuilder;
        //   248: dup            
        //   249: invokespecial   java/lang/StringBuilder.<init>:()V
        //   252: aload_1        
        //   253: iconst_0       
        //   254: aload_1        
        //   255: ldc             "/"
        //   257: invokevirtual   java/lang/String.lastIndexOf:(Ljava/lang/String;)I
        //   260: invokevirtual   java/lang/String.substring:(II)Ljava/lang/String;
        //   263: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   266: ldc             "/"
        //   268: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   271: aload_0        
        //   272: getfield        com/admarvel/android/ads/AdMarvelRedirectRunnable.url:Ljava/lang/String;
        //   275: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   278: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   281: aload_0        
        //   282: getfield        com/admarvel/android/ads/AdMarvelRedirectRunnable.isPostitialView:Z
        //   285: invokestatic    com/admarvel/android/ads/r.a:(Landroid/content/Context;Ljava/lang/String;Z)Z
        //   288: ifeq            543
        //   291: aload_0        
        //   292: getfield        com/admarvel/android/ads/AdMarvelRedirectRunnable.adType:Ljava/lang/String;
        //   295: ldc             "banner"
        //   297: invokevirtual   java/lang/String.equals:(Ljava/lang/Object;)Z
        //   300: ifeq            334
        //   303: aload_0        
        //   304: getfield        com/admarvel/android/ads/AdMarvelRedirectRunnable.GUID:Ljava/lang/String;
        //   307: invokestatic    com/admarvel/android/ads/m.a:(Ljava/lang/String;)Lcom/admarvel/android/ads/n;
        //   310: ifnull          15
        //   313: aload_0        
        //   314: getfield        com/admarvel/android/ads/AdMarvelRedirectRunnable.GUID:Ljava/lang/String;
        //   317: invokestatic    com/admarvel/android/ads/m.a:(Ljava/lang/String;)Lcom/admarvel/android/ads/n;
        //   320: aload_0        
        //   321: getfield        com/admarvel/android/ads/AdMarvelRedirectRunnable.adMarvelAd:Lcom/admarvel/android/ads/AdMarvelAd;
        //   324: aload_0        
        //   325: getfield        com/admarvel/android/ads/AdMarvelRedirectRunnable.url:Ljava/lang/String;
        //   328: invokeinterface com/admarvel/android/ads/n.a:(Lcom/admarvel/android/ads/AdMarvelAd;Ljava/lang/String;)V
        //   333: return         
        //   334: aload_0        
        //   335: getfield        com/admarvel/android/ads/AdMarvelRedirectRunnable.adType:Ljava/lang/String;
        //   338: ldc             "interstitial"
        //   340: invokevirtual   java/lang/String.equals:(Ljava/lang/Object;)Z
        //   343: ifeq            543
        //   346: invokestatic    com/admarvel/android/ads/AdMarvelInterstitialAds.getListener:()Lcom/admarvel/android/ads/e;
        //   349: aload_2        
        //   350: aload_0        
        //   351: getfield        com/admarvel/android/ads/AdMarvelRedirectRunnable.url:Ljava/lang/String;
        //   354: aload_0        
        //   355: getfield        com/admarvel/android/ads/AdMarvelRedirectRunnable.adMarvelAd:Lcom/admarvel/android/ads/AdMarvelAd;
        //   358: invokevirtual   com/admarvel/android/ads/AdMarvelAd.getSiteId:()Ljava/lang/String;
        //   361: aload_0        
        //   362: getfield        com/admarvel/android/ads/AdMarvelRedirectRunnable.adMarvelAd:Lcom/admarvel/android/ads/AdMarvelAd;
        //   365: invokevirtual   com/admarvel/android/ads/AdMarvelAd.getId:()I
        //   368: aload_0        
        //   369: getfield        com/admarvel/android/ads/AdMarvelRedirectRunnable.adMarvelAd:Lcom/admarvel/android/ads/AdMarvelAd;
        //   372: invokevirtual   com/admarvel/android/ads/AdMarvelAd.getTargetParams:()Ljava/util/Map;
        //   375: aload_0        
        //   376: getfield        com/admarvel/android/ads/AdMarvelRedirectRunnable.adMarvelAd:Lcom/admarvel/android/ads/AdMarvelAd;
        //   379: invokevirtual   com/admarvel/android/ads/AdMarvelAd.getIpAddress:()Ljava/lang/String;
        //   382: invokevirtual   com/admarvel/android/ads/e.a:(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;ILjava/util/Map;Ljava/lang/String;)V
        //   385: return         
        //   386: aload_0        
        //   387: getfield        com/admarvel/android/ads/AdMarvelRedirectRunnable.url:Ljava/lang/String;
        //   390: ifnull          543
        //   393: aload_0        
        //   394: getfield        com/admarvel/android/ads/AdMarvelRedirectRunnable.url:Ljava/lang/String;
        //   397: invokestatic    com/admarvel/android/ads/r.g:(Ljava/lang/String;)Z
        //   400: ifne            543
        //   403: aload_2        
        //   404: aload_0        
        //   405: getfield        com/admarvel/android/ads/AdMarvelRedirectRunnable.url:Ljava/lang/String;
        //   408: aload_0        
        //   409: getfield        com/admarvel/android/ads/AdMarvelRedirectRunnable.isPostitialView:Z
        //   412: invokestatic    com/admarvel/android/ads/r.a:(Landroid/content/Context;Ljava/lang/String;Z)Z
        //   415: ifeq            543
        //   418: aload_0        
        //   419: getfield        com/admarvel/android/ads/AdMarvelRedirectRunnable.adType:Ljava/lang/String;
        //   422: ldc             "native"
        //   424: invokevirtual   java/lang/String.equals:(Ljava/lang/Object;)Z
        //   427: ifne            448
        //   430: new             Lcom/admarvel/android/ads/r;
        //   433: dup            
        //   434: aload_2        
        //   435: invokespecial   com/admarvel/android/ads/r.<init>:(Landroid/content/Context;)V
        //   438: aload_0        
        //   439: getfield        com/admarvel/android/ads/AdMarvelRedirectRunnable.adMarvelAd:Lcom/admarvel/android/ads/AdMarvelAd;
        //   442: invokevirtual   com/admarvel/android/ads/AdMarvelAd.getXml:()Ljava/lang/String;
        //   445: invokevirtual   com/admarvel/android/ads/r.c:(Ljava/lang/String;)V
        //   448: aload_0        
        //   449: getfield        com/admarvel/android/ads/AdMarvelRedirectRunnable.adType:Ljava/lang/String;
        //   452: ldc             "banner"
        //   454: invokevirtual   java/lang/String.equals:(Ljava/lang/Object;)Z
        //   457: ifeq            491
        //   460: aload_0        
        //   461: getfield        com/admarvel/android/ads/AdMarvelRedirectRunnable.GUID:Ljava/lang/String;
        //   464: invokestatic    com/admarvel/android/ads/m.a:(Ljava/lang/String;)Lcom/admarvel/android/ads/n;
        //   467: ifnull          15
        //   470: aload_0        
        //   471: getfield        com/admarvel/android/ads/AdMarvelRedirectRunnable.GUID:Ljava/lang/String;
        //   474: invokestatic    com/admarvel/android/ads/m.a:(Ljava/lang/String;)Lcom/admarvel/android/ads/n;
        //   477: aload_0        
        //   478: getfield        com/admarvel/android/ads/AdMarvelRedirectRunnable.adMarvelAd:Lcom/admarvel/android/ads/AdMarvelAd;
        //   481: aload_0        
        //   482: getfield        com/admarvel/android/ads/AdMarvelRedirectRunnable.url:Ljava/lang/String;
        //   485: invokeinterface com/admarvel/android/ads/n.a:(Lcom/admarvel/android/ads/AdMarvelAd;Ljava/lang/String;)V
        //   490: return         
        //   491: aload_0        
        //   492: getfield        com/admarvel/android/ads/AdMarvelRedirectRunnable.adType:Ljava/lang/String;
        //   495: ldc             "interstitial"
        //   497: invokevirtual   java/lang/String.equals:(Ljava/lang/Object;)Z
        //   500: ifeq            543
        //   503: invokestatic    com/admarvel/android/ads/AdMarvelInterstitialAds.getListener:()Lcom/admarvel/android/ads/e;
        //   506: aload_2        
        //   507: aload_0        
        //   508: getfield        com/admarvel/android/ads/AdMarvelRedirectRunnable.url:Ljava/lang/String;
        //   511: aload_0        
        //   512: getfield        com/admarvel/android/ads/AdMarvelRedirectRunnable.adMarvelAd:Lcom/admarvel/android/ads/AdMarvelAd;
        //   515: invokevirtual   com/admarvel/android/ads/AdMarvelAd.getSiteId:()Ljava/lang/String;
        //   518: aload_0        
        //   519: getfield        com/admarvel/android/ads/AdMarvelRedirectRunnable.adMarvelAd:Lcom/admarvel/android/ads/AdMarvelAd;
        //   522: invokevirtual   com/admarvel/android/ads/AdMarvelAd.getId:()I
        //   525: aload_0        
        //   526: getfield        com/admarvel/android/ads/AdMarvelRedirectRunnable.adMarvelAd:Lcom/admarvel/android/ads/AdMarvelAd;
        //   529: invokevirtual   com/admarvel/android/ads/AdMarvelAd.getTargetParams:()Ljava/util/Map;
        //   532: aload_0        
        //   533: getfield        com/admarvel/android/ads/AdMarvelRedirectRunnable.adMarvelAd:Lcom/admarvel/android/ads/AdMarvelAd;
        //   536: invokevirtual   com/admarvel/android/ads/AdMarvelAd.getIpAddress:()Ljava/lang/String;
        //   539: invokevirtual   com/admarvel/android/ads/e.a:(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;ILjava/util/Map;Ljava/lang/String;)V
        //   542: return         
        //   543: aload_0        
        //   544: getfield        com/admarvel/android/ads/AdMarvelRedirectRunnable.url:Ljava/lang/String;
        //   547: ifnull          726
        //   550: aload_0        
        //   551: getfield        com/admarvel/android/ads/AdMarvelRedirectRunnable.url:Ljava/lang/String;
        //   554: ldc             "admarvelsdk"
        //   556: invokestatic    com/admarvel/android/ads/r.a:(Ljava/lang/String;Ljava/lang/String;)Lcom/admarvel/android/ads/r$j;
        //   559: getstatic       com/admarvel/android/ads/r$j.c:Lcom/admarvel/android/ads/r$j;
        //   562: if_acmpeq       726
        //   565: aload_0        
        //   566: getfield        com/admarvel/android/ads/AdMarvelRedirectRunnable.adType:Ljava/lang/String;
        //   569: ldc             "banner"
        //   571: invokevirtual   java/lang/String.equals:(Ljava/lang/Object;)Z
        //   574: ifeq            655
        //   577: aload_0        
        //   578: getfield        com/admarvel/android/ads/AdMarvelRedirectRunnable.GUID:Ljava/lang/String;
        //   581: invokestatic    com/admarvel/android/ads/m.a:(Ljava/lang/String;)Lcom/admarvel/android/ads/n;
        //   584: ifnull          624
        //   587: aload_0        
        //   588: getfield        com/admarvel/android/ads/AdMarvelRedirectRunnable.GUID:Ljava/lang/String;
        //   591: invokestatic    com/admarvel/android/ads/m.a:(Ljava/lang/String;)Lcom/admarvel/android/ads/n;
        //   594: aload_0        
        //   595: getfield        com/admarvel/android/ads/AdMarvelRedirectRunnable.adMarvelAd:Lcom/admarvel/android/ads/AdMarvelAd;
        //   598: aload_0        
        //   599: getfield        com/admarvel/android/ads/AdMarvelRedirectRunnable.url:Ljava/lang/String;
        //   602: ldc             "admarvelsdk"
        //   604: ldc             ""
        //   606: aload_0        
        //   607: getfield        com/admarvel/android/ads/AdMarvelRedirectRunnable.url:Ljava/lang/String;
        //   610: ldc             "admarvelsdk"
        //   612: invokestatic    com/admarvel/android/ads/r.a:(Ljava/lang/String;Ljava/lang/String;)Lcom/admarvel/android/ads/r$j;
        //   615: aload_2        
        //   616: invokestatic    com/admarvel/android/ads/r.a:(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/admarvel/android/ads/r$j;Landroid/content/Context;)Ljava/lang/String;
        //   619: invokeinterface com/admarvel/android/ads/n.a:(Lcom/admarvel/android/ads/AdMarvelAd;Ljava/lang/String;)V
        //   624: aload_0        
        //   625: getfield        com/admarvel/android/ads/AdMarvelRedirectRunnable.adType:Ljava/lang/String;
        //   628: ldc             "native"
        //   630: invokevirtual   java/lang/String.equals:(Ljava/lang/Object;)Z
        //   633: ifne            15
        //   636: new             Lcom/admarvel/android/ads/r;
        //   639: dup            
        //   640: aload_2        
        //   641: invokespecial   com/admarvel/android/ads/r.<init>:(Landroid/content/Context;)V
        //   644: aload_0        
        //   645: getfield        com/admarvel/android/ads/AdMarvelRedirectRunnable.adMarvelAd:Lcom/admarvel/android/ads/AdMarvelAd;
        //   648: invokevirtual   com/admarvel/android/ads/AdMarvelAd.getXml:()Ljava/lang/String;
        //   651: invokevirtual   com/admarvel/android/ads/r.c:(Ljava/lang/String;)V
        //   654: return         
        //   655: aload_0        
        //   656: getfield        com/admarvel/android/ads/AdMarvelRedirectRunnable.adType:Ljava/lang/String;
        //   659: ldc             "interstitial"
        //   661: invokevirtual   java/lang/String.equals:(Ljava/lang/Object;)Z
        //   664: ifeq            624
        //   667: invokestatic    com/admarvel/android/ads/AdMarvelInterstitialAds.getListener:()Lcom/admarvel/android/ads/e;
        //   670: aload_2        
        //   671: aload_0        
        //   672: getfield        com/admarvel/android/ads/AdMarvelRedirectRunnable.url:Ljava/lang/String;
        //   675: ldc             "admarvelsdk"
        //   677: ldc             ""
        //   679: aload_0        
        //   680: getfield        com/admarvel/android/ads/AdMarvelRedirectRunnable.url:Ljava/lang/String;
        //   683: ldc             "admarvelsdk"
        //   685: invokestatic    com/admarvel/android/ads/r.a:(Ljava/lang/String;Ljava/lang/String;)Lcom/admarvel/android/ads/r$j;
        //   688: aload_2        
        //   689: invokestatic    com/admarvel/android/ads/r.a:(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/admarvel/android/ads/r$j;Landroid/content/Context;)Ljava/lang/String;
        //   692: aload_0        
        //   693: getfield        com/admarvel/android/ads/AdMarvelRedirectRunnable.adMarvelAd:Lcom/admarvel/android/ads/AdMarvelAd;
        //   696: invokevirtual   com/admarvel/android/ads/AdMarvelAd.getSiteId:()Ljava/lang/String;
        //   699: aload_0        
        //   700: getfield        com/admarvel/android/ads/AdMarvelRedirectRunnable.adMarvelAd:Lcom/admarvel/android/ads/AdMarvelAd;
        //   703: invokevirtual   com/admarvel/android/ads/AdMarvelAd.getId:()I
        //   706: aload_0        
        //   707: getfield        com/admarvel/android/ads/AdMarvelRedirectRunnable.adMarvelAd:Lcom/admarvel/android/ads/AdMarvelAd;
        //   710: invokevirtual   com/admarvel/android/ads/AdMarvelAd.getTargetParams:()Ljava/util/Map;
        //   713: aload_0        
        //   714: getfield        com/admarvel/android/ads/AdMarvelRedirectRunnable.adMarvelAd:Lcom/admarvel/android/ads/AdMarvelAd;
        //   717: invokevirtual   com/admarvel/android/ads/AdMarvelAd.getIpAddress:()Ljava/lang/String;
        //   720: invokevirtual   com/admarvel/android/ads/e.a:(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;ILjava/util/Map;Ljava/lang/String;)V
        //   723: goto            624
        //   726: aload_0        
        //   727: getfield        com/admarvel/android/ads/AdMarvelRedirectRunnable.url:Ljava/lang/String;
        //   730: ifnull          909
        //   733: aload_0        
        //   734: getfield        com/admarvel/android/ads/AdMarvelRedirectRunnable.url:Ljava/lang/String;
        //   737: ldc             "admarvelinternal"
        //   739: invokestatic    com/admarvel/android/ads/r.a:(Ljava/lang/String;Ljava/lang/String;)Lcom/admarvel/android/ads/r$j;
        //   742: getstatic       com/admarvel/android/ads/r$j.c:Lcom/admarvel/android/ads/r$j;
        //   745: if_acmpeq       909
        //   748: aload_0        
        //   749: getfield        com/admarvel/android/ads/AdMarvelRedirectRunnable.adType:Ljava/lang/String;
        //   752: ldc             "banner"
        //   754: invokevirtual   java/lang/String.equals:(Ljava/lang/Object;)Z
        //   757: ifeq            838
        //   760: aload_0        
        //   761: getfield        com/admarvel/android/ads/AdMarvelRedirectRunnable.GUID:Ljava/lang/String;
        //   764: invokestatic    com/admarvel/android/ads/m.a:(Ljava/lang/String;)Lcom/admarvel/android/ads/n;
        //   767: ifnull          807
        //   770: aload_0        
        //   771: getfield        com/admarvel/android/ads/AdMarvelRedirectRunnable.GUID:Ljava/lang/String;
        //   774: invokestatic    com/admarvel/android/ads/m.a:(Ljava/lang/String;)Lcom/admarvel/android/ads/n;
        //   777: aload_0        
        //   778: getfield        com/admarvel/android/ads/AdMarvelRedirectRunnable.adMarvelAd:Lcom/admarvel/android/ads/AdMarvelAd;
        //   781: aload_0        
        //   782: getfield        com/admarvel/android/ads/AdMarvelRedirectRunnable.url:Ljava/lang/String;
        //   785: ldc             "admarvelinternal"
        //   787: ldc             ""
        //   789: aload_0        
        //   790: getfield        com/admarvel/android/ads/AdMarvelRedirectRunnable.url:Ljava/lang/String;
        //   793: ldc             "admarvelinternal"
        //   795: invokestatic    com/admarvel/android/ads/r.a:(Ljava/lang/String;Ljava/lang/String;)Lcom/admarvel/android/ads/r$j;
        //   798: aload_2        
        //   799: invokestatic    com/admarvel/android/ads/r.a:(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/admarvel/android/ads/r$j;Landroid/content/Context;)Ljava/lang/String;
        //   802: invokeinterface com/admarvel/android/ads/n.a:(Lcom/admarvel/android/ads/AdMarvelAd;Ljava/lang/String;)V
        //   807: aload_0        
        //   808: getfield        com/admarvel/android/ads/AdMarvelRedirectRunnable.adType:Ljava/lang/String;
        //   811: ldc             "native"
        //   813: invokevirtual   java/lang/String.equals:(Ljava/lang/Object;)Z
        //   816: ifne            15
        //   819: new             Lcom/admarvel/android/ads/r;
        //   822: dup            
        //   823: aload_2        
        //   824: invokespecial   com/admarvel/android/ads/r.<init>:(Landroid/content/Context;)V
        //   827: aload_0        
        //   828: getfield        com/admarvel/android/ads/AdMarvelRedirectRunnable.adMarvelAd:Lcom/admarvel/android/ads/AdMarvelAd;
        //   831: invokevirtual   com/admarvel/android/ads/AdMarvelAd.getXml:()Ljava/lang/String;
        //   834: invokevirtual   com/admarvel/android/ads/r.c:(Ljava/lang/String;)V
        //   837: return         
        //   838: aload_0        
        //   839: getfield        com/admarvel/android/ads/AdMarvelRedirectRunnable.adType:Ljava/lang/String;
        //   842: ldc             "interstitial"
        //   844: invokevirtual   java/lang/String.equals:(Ljava/lang/Object;)Z
        //   847: ifeq            807
        //   850: invokestatic    com/admarvel/android/ads/AdMarvelInterstitialAds.getListener:()Lcom/admarvel/android/ads/e;
        //   853: aload_2        
        //   854: aload_0        
        //   855: getfield        com/admarvel/android/ads/AdMarvelRedirectRunnable.url:Ljava/lang/String;
        //   858: ldc             "admarvelinternal"
        //   860: ldc             ""
        //   862: aload_0        
        //   863: getfield        com/admarvel/android/ads/AdMarvelRedirectRunnable.url:Ljava/lang/String;
        //   866: ldc             "admarvelinternal"
        //   868: invokestatic    com/admarvel/android/ads/r.a:(Ljava/lang/String;Ljava/lang/String;)Lcom/admarvel/android/ads/r$j;
        //   871: aload_2        
        //   872: invokestatic    com/admarvel/android/ads/r.a:(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/admarvel/android/ads/r$j;Landroid/content/Context;)Ljava/lang/String;
        //   875: aload_0        
        //   876: getfield        com/admarvel/android/ads/AdMarvelRedirectRunnable.adMarvelAd:Lcom/admarvel/android/ads/AdMarvelAd;
        //   879: invokevirtual   com/admarvel/android/ads/AdMarvelAd.getSiteId:()Ljava/lang/String;
        //   882: aload_0        
        //   883: getfield        com/admarvel/android/ads/AdMarvelRedirectRunnable.adMarvelAd:Lcom/admarvel/android/ads/AdMarvelAd;
        //   886: invokevirtual   com/admarvel/android/ads/AdMarvelAd.getId:()I
        //   889: aload_0        
        //   890: getfield        com/admarvel/android/ads/AdMarvelRedirectRunnable.adMarvelAd:Lcom/admarvel/android/ads/AdMarvelAd;
        //   893: invokevirtual   com/admarvel/android/ads/AdMarvelAd.getTargetParams:()Ljava/util/Map;
        //   896: aload_0        
        //   897: getfield        com/admarvel/android/ads/AdMarvelRedirectRunnable.adMarvelAd:Lcom/admarvel/android/ads/AdMarvelAd;
        //   900: invokevirtual   com/admarvel/android/ads/AdMarvelAd.getIpAddress:()Ljava/lang/String;
        //   903: invokevirtual   com/admarvel/android/ads/e.a:(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;ILjava/util/Map;Ljava/lang/String;)V
        //   906: goto            807
        //   909: aload_2        
        //   910: invokestatic    com/admarvel/android/ads/r.f:(Landroid/content/Context;)Z
        //   913: ifeq            1034
        //   916: aload_0        
        //   917: getfield        com/admarvel/android/ads/AdMarvelRedirectRunnable.url:Ljava/lang/String;
        //   920: ifnull          1034
        //   923: aload_0        
        //   924: getfield        com/admarvel/android/ads/AdMarvelRedirectRunnable.url:Ljava/lang/String;
        //   927: ldc             "admarvelvideo"
        //   929: invokestatic    com/admarvel/android/ads/r.a:(Ljava/lang/String;Ljava/lang/String;)Lcom/admarvel/android/ads/r$j;
        //   932: getstatic       com/admarvel/android/ads/r$j.c:Lcom/admarvel/android/ads/r$j;
        //   935: if_acmpeq       1034
        //   938: aload_0        
        //   939: getfield        com/admarvel/android/ads/AdMarvelRedirectRunnable.url:Ljava/lang/String;
        //   942: ldc             "admarvelvideo"
        //   944: ldc             "http://"
        //   946: aload_0        
        //   947: getfield        com/admarvel/android/ads/AdMarvelRedirectRunnable.url:Ljava/lang/String;
        //   950: ldc             "admarvelvideo"
        //   952: invokestatic    com/admarvel/android/ads/r.a:(Ljava/lang/String;Ljava/lang/String;)Lcom/admarvel/android/ads/r$j;
        //   955: aload_2        
        //   956: invokestatic    com/admarvel/android/ads/r.a:(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/admarvel/android/ads/r$j;Landroid/content/Context;)Ljava/lang/String;
        //   959: astore_1       
        //   960: new             Landroid/content/Intent;
        //   963: dup            
        //   964: ldc             "android.intent.action.VIEW"
        //   966: invokespecial   android/content/Intent.<init>:(Ljava/lang/String;)V
        //   969: astore_3       
        //   970: aload_3        
        //   971: ldc             268435456
        //   973: invokevirtual   android/content/Intent.addFlags:(I)Landroid/content/Intent;
        //   976: pop            
        //   977: aload_3        
        //   978: aload_1        
        //   979: invokestatic    android/net/Uri.parse:(Ljava/lang/String;)Landroid/net/Uri;
        //   982: ldc             "video/*"
        //   984: invokevirtual   android/content/Intent.setDataAndType:(Landroid/net/Uri;Ljava/lang/String;)Landroid/content/Intent;
        //   987: pop            
        //   988: aload_2        
        //   989: aload_3        
        //   990: invokestatic    com/admarvel/android/ads/r.a:(Landroid/content/Context;Landroid/content/Intent;)Z
        //   993: ifeq            1001
        //   996: aload_2        
        //   997: aload_3        
        //   998: invokevirtual   android/content/Context.startActivity:(Landroid/content/Intent;)V
        //  1001: aload_0        
        //  1002: getfield        com/admarvel/android/ads/AdMarvelRedirectRunnable.adType:Ljava/lang/String;
        //  1005: ldc             "native"
        //  1007: invokevirtual   java/lang/String.equals:(Ljava/lang/Object;)Z
        //  1010: ifne            141
        //  1013: new             Lcom/admarvel/android/ads/r;
        //  1016: dup            
        //  1017: aload_2        
        //  1018: invokespecial   com/admarvel/android/ads/r.<init>:(Landroid/content/Context;)V
        //  1021: aload_0        
        //  1022: getfield        com/admarvel/android/ads/AdMarvelRedirectRunnable.adMarvelAd:Lcom/admarvel/android/ads/AdMarvelAd;
        //  1025: invokevirtual   com/admarvel/android/ads/AdMarvelAd.getXml:()Ljava/lang/String;
        //  1028: invokevirtual   com/admarvel/android/ads/r.c:(Ljava/lang/String;)V
        //  1031: goto            141
        //  1034: aload_2        
        //  1035: invokestatic    com/admarvel/android/ads/r.f:(Landroid/content/Context;)Z
        //  1038: ifeq            1150
        //  1041: aload_0        
        //  1042: getfield        com/admarvel/android/ads/AdMarvelRedirectRunnable.url:Ljava/lang/String;
        //  1045: ifnull          1150
        //  1048: aload_0        
        //  1049: getfield        com/admarvel/android/ads/AdMarvelRedirectRunnable.url:Ljava/lang/String;
        //  1052: ldc             "admarvelexternal"
        //  1054: invokestatic    com/admarvel/android/ads/r.a:(Ljava/lang/String;Ljava/lang/String;)Lcom/admarvel/android/ads/r$j;
        //  1057: getstatic       com/admarvel/android/ads/r$j.c:Lcom/admarvel/android/ads/r$j;
        //  1060: if_acmpeq       1150
        //  1063: new             Landroid/content/Intent;
        //  1066: dup            
        //  1067: ldc             "android.intent.action.VIEW"
        //  1069: aload_0        
        //  1070: getfield        com/admarvel/android/ads/AdMarvelRedirectRunnable.url:Ljava/lang/String;
        //  1073: ldc             "admarvelexternal"
        //  1075: ldc             ""
        //  1077: aload_0        
        //  1078: getfield        com/admarvel/android/ads/AdMarvelRedirectRunnable.url:Ljava/lang/String;
        //  1081: ldc             "admarvelexternal"
        //  1083: invokestatic    com/admarvel/android/ads/r.a:(Ljava/lang/String;Ljava/lang/String;)Lcom/admarvel/android/ads/r$j;
        //  1086: aload_2        
        //  1087: invokestatic    com/admarvel/android/ads/r.a:(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/admarvel/android/ads/r$j;Landroid/content/Context;)Ljava/lang/String;
        //  1090: invokestatic    android/net/Uri.parse:(Ljava/lang/String;)Landroid/net/Uri;
        //  1093: invokespecial   android/content/Intent.<init>:(Ljava/lang/String;Landroid/net/Uri;)V
        //  1096: astore_1       
        //  1097: aload_1        
        //  1098: ldc             268435456
        //  1100: invokevirtual   android/content/Intent.addFlags:(I)Landroid/content/Intent;
        //  1103: pop            
        //  1104: aload_2        
        //  1105: aload_1        
        //  1106: invokestatic    com/admarvel/android/ads/r.a:(Landroid/content/Context;Landroid/content/Intent;)Z
        //  1109: ifeq            1117
        //  1112: aload_2        
        //  1113: aload_1        
        //  1114: invokevirtual   android/content/Context.startActivity:(Landroid/content/Intent;)V
        //  1117: aload_0        
        //  1118: getfield        com/admarvel/android/ads/AdMarvelRedirectRunnable.adType:Ljava/lang/String;
        //  1121: ldc             "native"
        //  1123: invokevirtual   java/lang/String.equals:(Ljava/lang/Object;)Z
        //  1126: ifne            141
        //  1129: new             Lcom/admarvel/android/ads/r;
        //  1132: dup            
        //  1133: aload_2        
        //  1134: invokespecial   com/admarvel/android/ads/r.<init>:(Landroid/content/Context;)V
        //  1137: aload_0        
        //  1138: getfield        com/admarvel/android/ads/AdMarvelRedirectRunnable.adMarvelAd:Lcom/admarvel/android/ads/AdMarvelAd;
        //  1141: invokevirtual   com/admarvel/android/ads/AdMarvelAd.getXml:()Ljava/lang/String;
        //  1144: invokevirtual   com/admarvel/android/ads/r.c:(Ljava/lang/String;)V
        //  1147: goto            141
        //  1150: aload_2        
        //  1151: invokestatic    com/admarvel/android/ads/r.f:(Landroid/content/Context;)Z
        //  1154: ifeq            1395
        //  1157: aload_0        
        //  1158: getfield        com/admarvel/android/ads/AdMarvelRedirectRunnable.url:Ljava/lang/String;
        //  1161: ifnull          1395
        //  1164: aload_0        
        //  1165: getfield        com/admarvel/android/ads/AdMarvelRedirectRunnable.url:Ljava/lang/String;
        //  1168: ldc             "admarvelcustomvideo"
        //  1170: invokestatic    com/admarvel/android/ads/r.a:(Ljava/lang/String;Ljava/lang/String;)Lcom/admarvel/android/ads/r$j;
        //  1173: getstatic       com/admarvel/android/ads/r$j.c:Lcom/admarvel/android/ads/r$j;
        //  1176: if_acmpeq       1395
        //  1179: new             Landroid/content/Intent;
        //  1182: dup            
        //  1183: aload_2        
        //  1184: ldc             Lcom/admarvel/android/ads/AdMarvelVideoActivity;.class
        //  1186: invokespecial   android/content/Intent.<init>:(Landroid/content/Context;Ljava/lang/Class;)V
        //  1189: astore_1       
        //  1190: aload_1        
        //  1191: ldc             268435456
        //  1193: invokevirtual   android/content/Intent.addFlags:(I)Landroid/content/Intent;
        //  1196: pop            
        //  1197: aload_0        
        //  1198: getfield        com/admarvel/android/ads/AdMarvelRedirectRunnable.adType:Ljava/lang/String;
        //  1201: ldc             "native"
        //  1203: invokevirtual   java/lang/String.equals:(Ljava/lang/Object;)Z
        //  1206: ifne            1289
        //  1209: aload_0        
        //  1210: getfield        com/admarvel/android/ads/AdMarvelRedirectRunnable.adMarvelAd:Lcom/admarvel/android/ads/AdMarvelAd;
        //  1213: invokevirtual   com/admarvel/android/ads/AdMarvelAd.removeNonStringEntriesTargetParam:()V
        //  1216: new             Ljava/io/ByteArrayOutputStream;
        //  1219: dup            
        //  1220: invokespecial   java/io/ByteArrayOutputStream.<init>:()V
        //  1223: astore_3       
        //  1224: new             Ljava/io/ObjectOutputStream;
        //  1227: dup            
        //  1228: aload_3        
        //  1229: invokespecial   java/io/ObjectOutputStream.<init>:(Ljava/io/OutputStream;)V
        //  1232: astore          4
        //  1234: aload           4
        //  1236: aload_0        
        //  1237: getfield        com/admarvel/android/ads/AdMarvelRedirectRunnable.adMarvelAd:Lcom/admarvel/android/ads/AdMarvelAd;
        //  1240: invokevirtual   java/io/ObjectOutputStream.writeObject:(Ljava/lang/Object;)V
        //  1243: aload           4
        //  1245: invokevirtual   java/io/ObjectOutputStream.close:()V
        //  1248: aload_1        
        //  1249: ldc             "serialized_admarvelad"
        //  1251: aload_3        
        //  1252: invokevirtual   java/io/ByteArrayOutputStream.toByteArray:()[B
        //  1255: invokevirtual   android/content/Intent.putExtra:(Ljava/lang/String;[B)Landroid/content/Intent;
        //  1258: pop            
        //  1259: aload_1        
        //  1260: ldc_w           "xml"
        //  1263: aload_0        
        //  1264: getfield        com/admarvel/android/ads/AdMarvelRedirectRunnable.adMarvelAd:Lcom/admarvel/android/ads/AdMarvelAd;
        //  1267: invokevirtual   com/admarvel/android/ads/AdMarvelAd.getXml:()Ljava/lang/String;
        //  1270: invokevirtual   android/content/Intent.putExtra:(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
        //  1273: pop            
        //  1274: aload_1        
        //  1275: ldc_w           "source"
        //  1278: aload_0        
        //  1279: getfield        com/admarvel/android/ads/AdMarvelRedirectRunnable.adMarvelAd:Lcom/admarvel/android/ads/AdMarvelAd;
        //  1282: invokevirtual   com/admarvel/android/ads/AdMarvelAd.getSource:()Ljava/lang/String;
        //  1285: invokevirtual   android/content/Intent.putExtra:(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
        //  1288: pop            
        //  1289: aload_1        
        //  1290: ldc_w           "url"
        //  1293: aload_0        
        //  1294: getfield        com/admarvel/android/ads/AdMarvelRedirectRunnable.url:Ljava/lang/String;
        //  1297: invokevirtual   android/content/Intent.putExtra:(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
        //  1300: pop            
        //  1301: aload_1        
        //  1302: ldc_w           "isCustomUrl"
        //  1305: iconst_1       
        //  1306: invokevirtual   android/content/Intent.putExtra:(Ljava/lang/String;Z)Landroid/content/Intent;
        //  1309: pop            
        //  1310: aload_1        
        //  1311: ldc_w           "GUID"
        //  1314: aload_0        
        //  1315: getfield        com/admarvel/android/ads/AdMarvelRedirectRunnable.GUID:Ljava/lang/String;
        //  1318: invokevirtual   android/content/Intent.putExtra:(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
        //  1321: pop            
        //  1322: new             Landroid/os/Handler;
        //  1325: dup            
        //  1326: invokestatic    android/os/Looper.getMainLooper:()Landroid/os/Looper;
        //  1329: invokespecial   android/os/Handler.<init>:(Landroid/os/Looper;)V
        //  1332: new             Lcom/admarvel/android/ads/AdMarvelRedirectRunnable$1;
        //  1335: dup            
        //  1336: aload_0        
        //  1337: aload_2        
        //  1338: aload_1        
        //  1339: invokespecial   com/admarvel/android/ads/AdMarvelRedirectRunnable$1.<init>:(Lcom/admarvel/android/ads/AdMarvelRedirectRunnable;Landroid/content/Context;Landroid/content/Intent;)V
        //  1342: invokevirtual   android/os/Handler.post:(Ljava/lang/Runnable;)Z
        //  1345: pop            
        //  1346: aload_0        
        //  1347: getfield        com/admarvel/android/ads/AdMarvelRedirectRunnable.adType:Ljava/lang/String;
        //  1350: ldc             "native"
        //  1352: invokevirtual   java/lang/String.equals:(Ljava/lang/Object;)Z
        //  1355: ifne            141
        //  1358: new             Lcom/admarvel/android/ads/r;
        //  1361: dup            
        //  1362: aload_2        
        //  1363: invokespecial   com/admarvel/android/ads/r.<init>:(Landroid/content/Context;)V
        //  1366: aload_0        
        //  1367: getfield        com/admarvel/android/ads/AdMarvelRedirectRunnable.adMarvelAd:Lcom/admarvel/android/ads/AdMarvelAd;
        //  1370: invokevirtual   com/admarvel/android/ads/AdMarvelAd.getXml:()Ljava/lang/String;
        //  1373: invokevirtual   com/admarvel/android/ads/r.c:(Ljava/lang/String;)V
        //  1376: goto            141
        //  1379: astore_3       
        //  1380: aload_3        
        //  1381: invokevirtual   java/io/IOException.printStackTrace:()V
        //  1384: goto            1259
        //  1387: astore_1       
        //  1388: aload_1        
        //  1389: invokevirtual   java/lang/Exception.printStackTrace:()V
        //  1392: goto            1346
        //  1395: aload_2        
        //  1396: invokestatic    com/admarvel/android/ads/r.f:(Landroid/content/Context;)Z
        //  1399: ifeq            141
        //  1402: aload_0        
        //  1403: getfield        com/admarvel/android/ads/AdMarvelRedirectRunnable.url:Ljava/lang/String;
        //  1406: ifnull          141
        //  1409: aload_0        
        //  1410: getfield        com/admarvel/android/ads/AdMarvelRedirectRunnable.url:Ljava/lang/String;
        //  1413: invokevirtual   java/lang/String.length:()I
        //  1416: ifle            141
        //  1419: aload_0        
        //  1420: getfield        com/admarvel/android/ads/AdMarvelRedirectRunnable.adType:Ljava/lang/String;
        //  1423: ldc             "banner"
        //  1425: invokevirtual   java/lang/String.equals:(Ljava/lang/Object;)Z
        //  1428: ifeq            1669
        //  1431: aload_0        
        //  1432: getfield        com/admarvel/android/ads/AdMarvelRedirectRunnable.isPostitialView:Z
        //  1435: ifeq            1654
        //  1438: new             Landroid/content/Intent;
        //  1441: dup            
        //  1442: aload_2        
        //  1443: ldc_w           Lcom/admarvel/android/ads/AdMarvelPostitialActivity;.class
        //  1446: invokespecial   android/content/Intent.<init>:(Landroid/content/Context;Ljava/lang/Class;)V
        //  1449: astore_1       
        //  1450: aload_1        
        //  1451: ldc             268435456
        //  1453: invokevirtual   android/content/Intent.addFlags:(I)Landroid/content/Intent;
        //  1456: pop            
        //  1457: aload_0        
        //  1458: getfield        com/admarvel/android/ads/AdMarvelRedirectRunnable.isPostitialView:Z
        //  1461: ifeq            1472
        //  1464: aload_1        
        //  1465: ldc_w           8388608
        //  1468: invokevirtual   android/content/Intent.addFlags:(I)Landroid/content/Intent;
        //  1471: pop            
        //  1472: aload_1        
        //  1473: ldc_w           "url"
        //  1476: aload_0        
        //  1477: getfield        com/admarvel/android/ads/AdMarvelRedirectRunnable.url:Ljava/lang/String;
        //  1480: invokevirtual   android/content/Intent.putExtra:(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
        //  1483: pop            
        //  1484: aload_1        
        //  1485: ldc_w           "isInterstitial"
        //  1488: iconst_0       
        //  1489: invokevirtual   android/content/Intent.putExtra:(Ljava/lang/String;Z)Landroid/content/Intent;
        //  1492: pop            
        //  1493: aload_1        
        //  1494: ldc_w           "isInterstitialClick"
        //  1497: iconst_0       
        //  1498: invokevirtual   android/content/Intent.putExtra:(Ljava/lang/String;Z)Landroid/content/Intent;
        //  1501: pop            
        //  1502: aload_1        
        //  1503: ldc_w           "xml"
        //  1506: aload_0        
        //  1507: getfield        com/admarvel/android/ads/AdMarvelRedirectRunnable.adMarvelAd:Lcom/admarvel/android/ads/AdMarvelAd;
        //  1510: invokevirtual   com/admarvel/android/ads/AdMarvelAd.getXml:()Ljava/lang/String;
        //  1513: invokevirtual   android/content/Intent.putExtra:(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
        //  1516: pop            
        //  1517: aload_1        
        //  1518: ldc_w           "GUID"
        //  1521: aload_0        
        //  1522: getfield        com/admarvel/android/ads/AdMarvelRedirectRunnable.GUID:Ljava/lang/String;
        //  1525: invokevirtual   android/content/Intent.putExtra:(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
        //  1528: pop            
        //  1529: aload_0        
        //  1530: getfield        com/admarvel/android/ads/AdMarvelRedirectRunnable.adType:Ljava/lang/String;
        //  1533: ldc             "native"
        //  1535: invokevirtual   java/lang/String.equals:(Ljava/lang/Object;)Z
        //  1538: ifne            1616
        //  1541: aload_0        
        //  1542: getfield        com/admarvel/android/ads/AdMarvelRedirectRunnable.adMarvelAd:Lcom/admarvel/android/ads/AdMarvelAd;
        //  1545: invokevirtual   com/admarvel/android/ads/AdMarvelAd.removeNonStringEntriesTargetParam:()V
        //  1548: new             Ljava/io/ByteArrayOutputStream;
        //  1551: dup            
        //  1552: invokespecial   java/io/ByteArrayOutputStream.<init>:()V
        //  1555: astore_3       
        //  1556: new             Ljava/io/ObjectOutputStream;
        //  1559: dup            
        //  1560: aload_3        
        //  1561: invokespecial   java/io/ObjectOutputStream.<init>:(Ljava/io/OutputStream;)V
        //  1564: astore          4
        //  1566: aload           4
        //  1568: aload_0        
        //  1569: getfield        com/admarvel/android/ads/AdMarvelRedirectRunnable.adMarvelAd:Lcom/admarvel/android/ads/AdMarvelAd;
        //  1572: invokevirtual   java/io/ObjectOutputStream.writeObject:(Ljava/lang/Object;)V
        //  1575: aload           4
        //  1577: invokevirtual   java/io/ObjectOutputStream.close:()V
        //  1580: aload_1        
        //  1581: ldc             "serialized_admarvelad"
        //  1583: aload_3        
        //  1584: invokevirtual   java/io/ByteArrayOutputStream.toByteArray:()[B
        //  1587: invokevirtual   android/content/Intent.putExtra:(Ljava/lang/String;[B)Landroid/content/Intent;
        //  1590: pop            
        //  1591: aload_0        
        //  1592: getfield        com/admarvel/android/ads/AdMarvelRedirectRunnable.adMarvelAd:Lcom/admarvel/android/ads/AdMarvelAd;
        //  1595: invokevirtual   com/admarvel/android/ads/AdMarvelAd.getSource:()Ljava/lang/String;
        //  1598: ifnull          1616
        //  1601: aload_1        
        //  1602: ldc_w           "source"
        //  1605: aload_0        
        //  1606: getfield        com/admarvel/android/ads/AdMarvelRedirectRunnable.adMarvelAd:Lcom/admarvel/android/ads/AdMarvelAd;
        //  1609: invokevirtual   com/admarvel/android/ads/AdMarvelAd.getSource:()Ljava/lang/String;
        //  1612: invokevirtual   android/content/Intent.putExtra:(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
        //  1615: pop            
        //  1616: aload_2        
        //  1617: aload_1        
        //  1618: invokevirtual   android/content/Context.startActivity:(Landroid/content/Intent;)V
        //  1621: aload_0        
        //  1622: getfield        com/admarvel/android/ads/AdMarvelRedirectRunnable.adType:Ljava/lang/String;
        //  1625: ldc             "native"
        //  1627: invokevirtual   java/lang/String.equals:(Ljava/lang/Object;)Z
        //  1630: ifne            141
        //  1633: new             Lcom/admarvel/android/ads/r;
        //  1636: dup            
        //  1637: aload_2        
        //  1638: invokespecial   com/admarvel/android/ads/r.<init>:(Landroid/content/Context;)V
        //  1641: aload_0        
        //  1642: getfield        com/admarvel/android/ads/AdMarvelRedirectRunnable.adMarvelAd:Lcom/admarvel/android/ads/AdMarvelAd;
        //  1645: invokevirtual   com/admarvel/android/ads/AdMarvelAd.getXml:()Ljava/lang/String;
        //  1648: invokevirtual   com/admarvel/android/ads/r.c:(Ljava/lang/String;)V
        //  1651: goto            141
        //  1654: new             Landroid/content/Intent;
        //  1657: dup            
        //  1658: aload_2        
        //  1659: ldc_w           Lcom/admarvel/android/ads/AdMarvelActivity;.class
        //  1662: invokespecial   android/content/Intent.<init>:(Landroid/content/Context;Ljava/lang/Class;)V
        //  1665: astore_1       
        //  1666: goto            1450
        //  1669: new             Landroid/content/Intent;
        //  1672: dup            
        //  1673: aload_2        
        //  1674: ldc_w           Lcom/admarvel/android/ads/AdMarvelActivity;.class
        //  1677: invokespecial   android/content/Intent.<init>:(Landroid/content/Context;Ljava/lang/Class;)V
        //  1680: astore_1       
        //  1681: aload_1        
        //  1682: ldc             268435456
        //  1684: invokevirtual   android/content/Intent.addFlags:(I)Landroid/content/Intent;
        //  1687: pop            
        //  1688: aload_1        
        //  1689: ldc_w           "url"
        //  1692: aload_0        
        //  1693: getfield        com/admarvel/android/ads/AdMarvelRedirectRunnable.url:Ljava/lang/String;
        //  1696: invokevirtual   android/content/Intent.putExtra:(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
        //  1699: pop            
        //  1700: aload_1        
        //  1701: ldc_w           "isInterstitial"
        //  1704: iconst_0       
        //  1705: invokevirtual   android/content/Intent.putExtra:(Ljava/lang/String;Z)Landroid/content/Intent;
        //  1708: pop            
        //  1709: aload_0        
        //  1710: getfield        com/admarvel/android/ads/AdMarvelRedirectRunnable.adType:Ljava/lang/String;
        //  1713: ldc             "native"
        //  1715: invokevirtual   java/lang/String.equals:(Ljava/lang/Object;)Z
        //  1718: ifeq            1733
        //  1721: aload_1        
        //  1722: ldc_w           "isInterstitialClick"
        //  1725: iconst_0       
        //  1726: invokevirtual   android/content/Intent.putExtra:(Ljava/lang/String;Z)Landroid/content/Intent;
        //  1729: pop            
        //  1730: goto            1517
        //  1733: aload_1        
        //  1734: ldc_w           "isInterstitialClick"
        //  1737: iconst_1       
        //  1738: invokevirtual   android/content/Intent.putExtra:(Ljava/lang/String;Z)Landroid/content/Intent;
        //  1741: pop            
        //  1742: aload_1        
        //  1743: ldc_w           "xml"
        //  1746: aload_0        
        //  1747: getfield        com/admarvel/android/ads/AdMarvelRedirectRunnable.adMarvelAd:Lcom/admarvel/android/ads/AdMarvelAd;
        //  1750: invokevirtual   com/admarvel/android/ads/AdMarvelAd.getXml:()Ljava/lang/String;
        //  1753: invokevirtual   android/content/Intent.putExtra:(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
        //  1756: pop            
        //  1757: goto            1517
        //  1760: astore_3       
        //  1761: aload_3        
        //  1762: invokevirtual   java/io/IOException.printStackTrace:()V
        //  1765: goto            1591
        //  1768: aload_0        
        //  1769: getfield        com/admarvel/android/ads/AdMarvelRedirectRunnable.adType:Ljava/lang/String;
        //  1772: ldc             "interstitial"
        //  1774: invokevirtual   java/lang/String.equals:(Ljava/lang/Object;)Z
        //  1777: ifeq            15
        //  1780: invokestatic    com/admarvel/android/ads/AdMarvelInterstitialAds.getListener:()Lcom/admarvel/android/ads/e;
        //  1783: aload_2        
        //  1784: aload_0        
        //  1785: getfield        com/admarvel/android/ads/AdMarvelRedirectRunnable.url:Ljava/lang/String;
        //  1788: aload_0        
        //  1789: getfield        com/admarvel/android/ads/AdMarvelRedirectRunnable.adMarvelAd:Lcom/admarvel/android/ads/AdMarvelAd;
        //  1792: invokevirtual   com/admarvel/android/ads/AdMarvelAd.getSiteId:()Ljava/lang/String;
        //  1795: aload_0        
        //  1796: getfield        com/admarvel/android/ads/AdMarvelRedirectRunnable.adMarvelAd:Lcom/admarvel/android/ads/AdMarvelAd;
        //  1799: invokevirtual   com/admarvel/android/ads/AdMarvelAd.getId:()I
        //  1802: aload_0        
        //  1803: getfield        com/admarvel/android/ads/AdMarvelRedirectRunnable.adMarvelAd:Lcom/admarvel/android/ads/AdMarvelAd;
        //  1806: invokevirtual   com/admarvel/android/ads/AdMarvelAd.getTargetParams:()Ljava/util/Map;
        //  1809: aload_0        
        //  1810: getfield        com/admarvel/android/ads/AdMarvelRedirectRunnable.adMarvelAd:Lcom/admarvel/android/ads/AdMarvelAd;
        //  1813: invokevirtual   com/admarvel/android/ads/AdMarvelAd.getIpAddress:()Ljava/lang/String;
        //  1816: invokevirtual   com/admarvel/android/ads/e.a:(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;ILjava/util/Map;Ljava/lang/String;)V
        //  1819: return         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                 
        //  -----  -----  -----  -----  ---------------------
        //  23     114    115    141    Ljava/lang/Exception;
        //  184    235    115    141    Ljava/lang/Exception;
        //  236    333    115    141    Ljava/lang/Exception;
        //  334    385    115    141    Ljava/lang/Exception;
        //  386    448    115    141    Ljava/lang/Exception;
        //  448    490    115    141    Ljava/lang/Exception;
        //  491    542    115    141    Ljava/lang/Exception;
        //  543    624    115    141    Ljava/lang/Exception;
        //  624    654    115    141    Ljava/lang/Exception;
        //  655    723    115    141    Ljava/lang/Exception;
        //  726    807    115    141    Ljava/lang/Exception;
        //  807    837    115    141    Ljava/lang/Exception;
        //  838    906    115    141    Ljava/lang/Exception;
        //  909    1001   115    141    Ljava/lang/Exception;
        //  1001   1031   115    141    Ljava/lang/Exception;
        //  1034   1117   115    141    Ljava/lang/Exception;
        //  1117   1147   115    141    Ljava/lang/Exception;
        //  1150   1216   115    141    Ljava/lang/Exception;
        //  1216   1259   1379   1387   Ljava/io/IOException;
        //  1216   1259   115    141    Ljava/lang/Exception;
        //  1259   1289   115    141    Ljava/lang/Exception;
        //  1289   1322   115    141    Ljava/lang/Exception;
        //  1322   1346   1387   1395   Ljava/lang/Exception;
        //  1346   1376   115    141    Ljava/lang/Exception;
        //  1380   1384   115    141    Ljava/lang/Exception;
        //  1388   1392   115    141    Ljava/lang/Exception;
        //  1395   1450   115    141    Ljava/lang/Exception;
        //  1450   1472   115    141    Ljava/lang/Exception;
        //  1472   1517   115    141    Ljava/lang/Exception;
        //  1517   1548   115    141    Ljava/lang/Exception;
        //  1548   1591   1760   1768   Ljava/io/IOException;
        //  1548   1591   115    141    Ljava/lang/Exception;
        //  1591   1616   115    141    Ljava/lang/Exception;
        //  1616   1651   115    141    Ljava/lang/Exception;
        //  1654   1666   115    141    Ljava/lang/Exception;
        //  1669   1730   115    141    Ljava/lang/Exception;
        //  1733   1757   115    141    Ljava/lang/Exception;
        //  1761   1765   115    141    Ljava/lang/Exception;
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_1346:
        //     at com.strobel.decompiler.ast.Error.expressionLinkedFromMultipleLocations(Error.java:27)
        //     at com.strobel.decompiler.ast.AstOptimizer.mergeDisparateObjectInitializations(AstOptimizer.java:2604)
        //     at com.strobel.decompiler.ast.AstOptimizer.optimize(AstOptimizer.java:235)
        //     at com.strobel.decompiler.ast.AstOptimizer.optimize(AstOptimizer.java:42)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:209)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:94)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethodBody(AstBuilder.java:840)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethod(AstBuilder.java:733)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addTypeMembers(AstBuilder.java:610)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeCore(AstBuilder.java:577)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeNoCache(AstBuilder.java:193)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createType(AstBuilder.java:160)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addType(AstBuilder.java:135)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.buildAst(JavaLanguage.java:71)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.decompileType(JavaLanguage.java:59)
        //     at com.strobel.decompiler.DecompilerDriver.decompileType(DecompilerDriver.java:333)
        //     at com.strobel.decompiler.DecompilerDriver.decompileJar(DecompilerDriver.java:254)
        //     at com.strobel.decompiler.DecompilerDriver.main(DecompilerDriver.java:144)
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
}
