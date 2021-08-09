// 
// Decompiled by Procyon v0.6-prerelease
// 

package com.admarvel.android.ads;

import com.admarvel.android.util.l;
import android.os.Build$VERSION;

public class Version
{
    public static final String ADMARVEL_API_VERSION = "1.5";
    public static final String SDK_VERSION = "2.4.6";
    public static final String SDK_VERSION_DATE = "2014-11-06";
    
    public static int getAndroidSDKVersion() {
        if (Build$VERSION.RELEASE.contains("1.5")) {
            return 3;
        }
        return l.a();
    }
    
    static final String getSDKSupported() {
        String s2;
        String s = s2 = "";
        while (true) {
            try {
                if (AdMarvelAdapterInstances.getAdapterInstance("com.admarvel.android.admarvelgoogleplayadapter.AdMarvelGooglePlayAdapter") != null) {
                    s2 = s;
                    if (h.a("com.google.android.gms.ads.AdView")) {
                        s2 = s;
                        if (getAndroidSDKVersion() > 8) {
                            s2 = "" + "_googleplay_admob";
                        }
                    }
                }
                s = s2;
                try {
                    if (AdMarvelAdapterInstances.getAdapterInstance("com.admarvel.android.admarvelrhythmadapter.AdMarvelRhythmAdapter") != null) {
                        s = s2;
                        if (h.a("com.rhythmnewmedia.sdk.display.RhythmDisplayAdView")) {
                            s = s2;
                            if (getAndroidSDKVersion() > 9) {
                                s = s2 + "_rhythm";
                            }
                        }
                    }
                    s2 = s;
                    try {
                        if (AdMarvelAdapterInstances.getAdapterInstance("com.admarvel.android.admarvelmillennialadapter.AdMarvelMillennialAdapter") != null) {
                            s2 = s;
                            if (h.a("com.millennialmedia.android.MMAdView")) {
                                s2 = s;
                                if (getAndroidSDKVersion() > 8) {
                                    s2 = s + "_millennial";
                                }
                            }
                        }
                        s = s2;
                        try {
                            if (AdMarvelAdapterInstances.getAdapterInstance("com.admarvel.android.admarvelamazonadapter.AdMarvelAmazonAdapter") != null) {
                                s = s2;
                                if (h.a("com.amazon.device.ads.AdLayout")) {
                                    s = s2 + "_amazon";
                                }
                            }
                            s2 = s;
                            try {
                                if (AdMarvelAdapterInstances.getAdapterInstance("com.admarvel.android.admarveladcolonyadapter.AdMarvelAdColonyAdapter") != null) {
                                    s2 = s;
                                    if (h.a("com.jirbo.adcolony.AdColony")) {
                                        s2 = s;
                                        if (getAndroidSDKVersion() > 8) {
                                            s2 = s + "_adcolony";
                                        }
                                    }
                                }
                                s = s2;
                                try {
                                    if (AdMarvelAdapterInstances.getAdapterInstance("com.admarvel.android.admarvelpulse3dadapter.AdMarvelPulse3dAdapter") != null) {
                                        s = s2;
                                        if (h.a("com.amobee.pulse3d.Pulse3DView")) {
                                            s = s2;
                                            if (getAndroidSDKVersion() > 15) {
                                                s = s2 + "_pulse3d";
                                            }
                                        }
                                    }
                                    s2 = s;
                                    try {
                                        if (AdMarvelAdapterInstances.getAdapterInstance("com.admarvel.android.admarvelfacebookadapter.AdMarvelFacebookAdapter") != null) {
                                            s2 = s;
                                            if (h.a("com.facebook.ads.AdView")) {
                                                s2 = s;
                                                if (getAndroidSDKVersion() > 8) {
                                                    s2 = s + "_facebook";
                                                }
                                            }
                                        }
                                        s = s2;
                                        try {
                                            if (AdMarvelAdapterInstances.getAdapterInstance("com.admarvel.android.admarvelinmobiadapter.AdMarvelInmobiAdapter") != null) {
                                                s = s2;
                                                if (h.a("com.inmobi.monetization.IMBanner")) {
                                                    s = s2;
                                                    if (getAndroidSDKVersion() > 7) {
                                                        s = s2 + "_inmobi";
                                                    }
                                                }
                                            }
                                            s2 = s;
                                            try {
                                                if (AdMarvelAdapterInstances.getAdapterInstance("com.admarvel.android.admarvelheyzapadapter.AdMarvelHeyzapAdapter") != null) {
                                                    s2 = s;
                                                    if (Class.forName("com.heyzap.sdk.ads.VideoAd") != null) {
                                                        s2 = s;
                                                        if (getAndroidSDKVersion() > 7) {
                                                            s2 = s + "_heyzap";
                                                        }
                                                    }
                                                }
                                                return s2;
                                            }
                                            catch (Exception s2) {
                                                return s;
                                            }
                                        }
                                        catch (Exception s) {
                                            s = s2;
                                        }
                                    }
                                    catch (Exception s2) {
                                        s2 = s;
                                    }
                                }
                                catch (Exception s) {
                                    s = s2;
                                }
                            }
                            catch (Exception s2) {
                                s2 = s;
                            }
                        }
                        catch (Exception s) {
                            s = s2;
                        }
                    }
                    catch (Exception s2) {
                        s2 = s;
                    }
                }
                catch (Exception s) {
                    s = s2;
                }
            }
            catch (Exception ex) {
                s2 = s;
                continue;
            }
            break;
        }
    }
    
    static final String getVersionDump() {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     2: astore_1       
        //     3: ldc             "com.admarvel.android.admarvelgoogleplayadapter.AdMarvelGooglePlayAdapter"
        //     5: invokestatic    com/admarvel/android/ads/AdMarvelAdapterInstances.getAdapterInstance:(Ljava/lang/String;)Lcom/admarvel/android/ads/AdMarvelAdapter;
        //     8: astore_2       
        //     9: aload_1        
        //    10: astore_0       
        //    11: aload_2        
        //    12: ifnull          68
        //    15: aload_1        
        //    16: astore_0       
        //    17: ldc             "com.google.android.gms.ads.AdView"
        //    19: invokestatic    com/admarvel/android/ads/h.a:(Ljava/lang/String;)Z
        //    22: ifeq            68
        //    25: aload_1        
        //    26: astore_0       
        //    27: invokestatic    com/admarvel/android/ads/Version.getAndroidSDKVersion:()I
        //    30: bipush          8
        //    32: if_icmple       68
        //    35: new             Ljava/lang/StringBuilder;
        //    38: dup            
        //    39: invokespecial   java/lang/StringBuilder.<init>:()V
        //    42: ldc             ""
        //    44: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //    47: ldc             "googleplay: found, "
        //    49: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //    52: aload_2        
        //    53: invokevirtual   com/admarvel/android/ads/AdMarvelAdapter.getAdnetworkSDKVersionInfo:()Ljava/lang/String;
        //    56: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //    59: ldc             "\n"
        //    61: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //    64: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //    67: astore_0       
        //    68: ldc             "com.admarvel.android.admarvelrhythmadapter.AdMarvelRhythmAdapter"
        //    70: invokestatic    com/admarvel/android/ads/AdMarvelAdapterInstances.getAdapterInstance:(Ljava/lang/String;)Lcom/admarvel/android/ads/AdMarvelAdapter;
        //    73: astore_2       
        //    74: aload_0        
        //    75: astore_1       
        //    76: aload_2        
        //    77: ifnull          132
        //    80: aload_0        
        //    81: astore_1       
        //    82: ldc             "com.rhythmnewmedia.sdk.display.RhythmDisplayAdView"
        //    84: invokestatic    com/admarvel/android/ads/h.a:(Ljava/lang/String;)Z
        //    87: ifeq            132
        //    90: aload_0        
        //    91: astore_1       
        //    92: invokestatic    com/admarvel/android/ads/Version.getAndroidSDKVersion:()I
        //    95: bipush          9
        //    97: if_icmple       132
        //   100: new             Ljava/lang/StringBuilder;
        //   103: dup            
        //   104: invokespecial   java/lang/StringBuilder.<init>:()V
        //   107: aload_0        
        //   108: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   111: ldc             "rhythm: found, "
        //   113: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   116: aload_2        
        //   117: invokevirtual   com/admarvel/android/ads/AdMarvelAdapter.getAdnetworkSDKVersionInfo:()Ljava/lang/String;
        //   120: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   123: ldc             "\n"
        //   125: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   128: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   131: astore_1       
        //   132: ldc             "com.admarvel.android.admarvelmillennialadapter.AdMarvelMillennialAdapter"
        //   134: invokestatic    com/admarvel/android/ads/AdMarvelAdapterInstances.getAdapterInstance:(Ljava/lang/String;)Lcom/admarvel/android/ads/AdMarvelAdapter;
        //   137: astore_2       
        //   138: aload_1        
        //   139: astore_0       
        //   140: aload_2        
        //   141: ifnull          196
        //   144: aload_1        
        //   145: astore_0       
        //   146: ldc             "com.millennialmedia.android.MMAdView"
        //   148: invokestatic    com/admarvel/android/ads/h.a:(Ljava/lang/String;)Z
        //   151: ifeq            196
        //   154: aload_1        
        //   155: astore_0       
        //   156: invokestatic    com/admarvel/android/ads/Version.getAndroidSDKVersion:()I
        //   159: bipush          9
        //   161: if_icmple       196
        //   164: new             Ljava/lang/StringBuilder;
        //   167: dup            
        //   168: invokespecial   java/lang/StringBuilder.<init>:()V
        //   171: aload_1        
        //   172: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   175: ldc             "millennial: found, "
        //   177: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   180: aload_2        
        //   181: invokevirtual   com/admarvel/android/ads/AdMarvelAdapter.getAdnetworkSDKVersionInfo:()Ljava/lang/String;
        //   184: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   187: ldc             "\n"
        //   189: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   192: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   195: astore_0       
        //   196: ldc             "com.admarvel.android.admarvelamazonadapter.AdMarvelAmazonAdapter"
        //   198: invokestatic    com/admarvel/android/ads/AdMarvelAdapterInstances.getAdapterInstance:(Ljava/lang/String;)Lcom/admarvel/android/ads/AdMarvelAdapter;
        //   201: astore_2       
        //   202: aload_0        
        //   203: astore_1       
        //   204: aload_2        
        //   205: ifnull          250
        //   208: aload_0        
        //   209: astore_1       
        //   210: ldc             "com.amazon.device.ads.AdLayout"
        //   212: invokestatic    com/admarvel/android/ads/h.a:(Ljava/lang/String;)Z
        //   215: ifeq            250
        //   218: new             Ljava/lang/StringBuilder;
        //   221: dup            
        //   222: invokespecial   java/lang/StringBuilder.<init>:()V
        //   225: aload_0        
        //   226: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   229: ldc             "amazon: found, "
        //   231: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   234: aload_2        
        //   235: invokevirtual   com/admarvel/android/ads/AdMarvelAdapter.getAdnetworkSDKVersionInfo:()Ljava/lang/String;
        //   238: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   241: ldc             "\n"
        //   243: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   246: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   249: astore_1       
        //   250: ldc             "com.admarvel.android.admarveladcolonyadapter.AdMarvelAdColonyAdapter"
        //   252: invokestatic    com/admarvel/android/ads/AdMarvelAdapterInstances.getAdapterInstance:(Ljava/lang/String;)Lcom/admarvel/android/ads/AdMarvelAdapter;
        //   255: astore_2       
        //   256: aload_1        
        //   257: astore_0       
        //   258: aload_2        
        //   259: ifnull          314
        //   262: aload_1        
        //   263: astore_0       
        //   264: ldc             "com.jirbo.adcolony.AdColony"
        //   266: invokestatic    com/admarvel/android/ads/h.a:(Ljava/lang/String;)Z
        //   269: ifeq            314
        //   272: aload_1        
        //   273: astore_0       
        //   274: invokestatic    com/admarvel/android/ads/Version.getAndroidSDKVersion:()I
        //   277: bipush          9
        //   279: if_icmple       314
        //   282: new             Ljava/lang/StringBuilder;
        //   285: dup            
        //   286: invokespecial   java/lang/StringBuilder.<init>:()V
        //   289: aload_1        
        //   290: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   293: ldc             "adcolony: found, "
        //   295: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   298: aload_2        
        //   299: invokevirtual   com/admarvel/android/ads/AdMarvelAdapter.getAdnetworkSDKVersionInfo:()Ljava/lang/String;
        //   302: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   305: ldc             "\n"
        //   307: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   310: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   313: astore_0       
        //   314: ldc             "com.admarvel.android.admarvelpulse3dadapter.AdMarvelPulse3dAdapter"
        //   316: invokestatic    com/admarvel/android/ads/AdMarvelAdapterInstances.getAdapterInstance:(Ljava/lang/String;)Lcom/admarvel/android/ads/AdMarvelAdapter;
        //   319: astore_2       
        //   320: aload_0        
        //   321: astore_1       
        //   322: aload_2        
        //   323: ifnull          378
        //   326: aload_0        
        //   327: astore_1       
        //   328: ldc             "com.amobee.pulse3d.Pulse3DView"
        //   330: invokestatic    com/admarvel/android/ads/h.a:(Ljava/lang/String;)Z
        //   333: ifeq            378
        //   336: aload_0        
        //   337: astore_1       
        //   338: invokestatic    com/admarvel/android/ads/Version.getAndroidSDKVersion:()I
        //   341: bipush          15
        //   343: if_icmple       378
        //   346: new             Ljava/lang/StringBuilder;
        //   349: dup            
        //   350: invokespecial   java/lang/StringBuilder.<init>:()V
        //   353: aload_0        
        //   354: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   357: ldc             "pulse3d: found, "
        //   359: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   362: aload_2        
        //   363: invokevirtual   com/admarvel/android/ads/AdMarvelAdapter.getAdnetworkSDKVersionInfo:()Ljava/lang/String;
        //   366: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   369: ldc             "\n"
        //   371: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   374: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   377: astore_1       
        //   378: ldc             "com.admarvel.android.admarvelfacebookadapter.AdMarvelFacebookAdapter"
        //   380: invokestatic    com/admarvel/android/ads/AdMarvelAdapterInstances.getAdapterInstance:(Ljava/lang/String;)Lcom/admarvel/android/ads/AdMarvelAdapter;
        //   383: astore_2       
        //   384: aload_1        
        //   385: astore_0       
        //   386: aload_2        
        //   387: ifnull          442
        //   390: aload_1        
        //   391: astore_0       
        //   392: ldc             "com.facebook.ads.AdView"
        //   394: invokestatic    com/admarvel/android/ads/h.a:(Ljava/lang/String;)Z
        //   397: ifeq            442
        //   400: aload_1        
        //   401: astore_0       
        //   402: invokestatic    com/admarvel/android/ads/Version.getAndroidSDKVersion:()I
        //   405: bipush          8
        //   407: if_icmple       442
        //   410: new             Ljava/lang/StringBuilder;
        //   413: dup            
        //   414: invokespecial   java/lang/StringBuilder.<init>:()V
        //   417: aload_1        
        //   418: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   421: ldc             "facebook: found, "
        //   423: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   426: aload_2        
        //   427: invokevirtual   com/admarvel/android/ads/AdMarvelAdapter.getAdnetworkSDKVersionInfo:()Ljava/lang/String;
        //   430: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   433: ldc             "\n"
        //   435: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   438: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   441: astore_0       
        //   442: ldc             "com.admarvel.android.admarvelinmobiadapter.AdMarvelInmobiAdapter"
        //   444: invokestatic    com/admarvel/android/ads/AdMarvelAdapterInstances.getAdapterInstance:(Ljava/lang/String;)Lcom/admarvel/android/ads/AdMarvelAdapter;
        //   447: astore_2       
        //   448: aload_0        
        //   449: astore_1       
        //   450: aload_2        
        //   451: ifnull          506
        //   454: aload_0        
        //   455: astore_1       
        //   456: ldc             "com.inmobi.monetization.IMBanner"
        //   458: invokestatic    com/admarvel/android/ads/h.a:(Ljava/lang/String;)Z
        //   461: ifeq            506
        //   464: aload_0        
        //   465: astore_1       
        //   466: invokestatic    com/admarvel/android/ads/Version.getAndroidSDKVersion:()I
        //   469: bipush          7
        //   471: if_icmple       506
        //   474: new             Ljava/lang/StringBuilder;
        //   477: dup            
        //   478: invokespecial   java/lang/StringBuilder.<init>:()V
        //   481: aload_0        
        //   482: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   485: ldc             "inmobi: found, "
        //   487: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   490: aload_2        
        //   491: invokevirtual   com/admarvel/android/ads/AdMarvelAdapter.getAdnetworkSDKVersionInfo:()Ljava/lang/String;
        //   494: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   497: ldc             "\n"
        //   499: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   502: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   505: astore_1       
        //   506: ldc             "com.admarvel.android.admarvelheyzapadapter.AdMarvelHeyzapAdapter"
        //   508: invokestatic    com/admarvel/android/ads/AdMarvelAdapterInstances.getAdapterInstance:(Ljava/lang/String;)Lcom/admarvel/android/ads/AdMarvelAdapter;
        //   511: astore_2       
        //   512: aload_1        
        //   513: astore_0       
        //   514: aload_2        
        //   515: ifnull          570
        //   518: aload_1        
        //   519: astore_0       
        //   520: ldc             "com.heyzap.sdk.ads.VideoAd"
        //   522: invokestatic    java/lang/Class.forName:(Ljava/lang/String;)Ljava/lang/Class;
        //   525: ifnull          570
        //   528: aload_1        
        //   529: astore_0       
        //   530: invokestatic    com/admarvel/android/ads/Version.getAndroidSDKVersion:()I
        //   533: bipush          7
        //   535: if_icmple       570
        //   538: new             Ljava/lang/StringBuilder;
        //   541: dup            
        //   542: invokespecial   java/lang/StringBuilder.<init>:()V
        //   545: aload_1        
        //   546: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   549: ldc             "heyzap: found, "
        //   551: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   554: aload_2        
        //   555: invokevirtual   com/admarvel/android/ads/AdMarvelAdapter.getAdnetworkSDKVersionInfo:()Ljava/lang/String;
        //   558: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   561: ldc             "\n"
        //   563: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   566: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   569: astore_0       
        //   570: aload_0        
        //   571: areturn        
        //   572: astore_0       
        //   573: new             Ljava/lang/StringBuilder;
        //   576: dup            
        //   577: invokespecial   java/lang/StringBuilder.<init>:()V
        //   580: ldc             ""
        //   582: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   585: ldc             "googleplay: NOT found, admarvel-android-sdk-googleplay-adapter.jar NOT in classpath\n"
        //   587: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   590: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   593: astore_0       
        //   594: goto            68
        //   597: astore_1       
        //   598: new             Ljava/lang/StringBuilder;
        //   601: dup            
        //   602: invokespecial   java/lang/StringBuilder.<init>:()V
        //   605: aload_0        
        //   606: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   609: ldc             "rhythm: NOT found, admarvel-android-sdk-rhythm-adapter.jar NOT in classpath\n"
        //   611: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   614: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   617: astore_1       
        //   618: goto            132
        //   621: astore_0       
        //   622: new             Ljava/lang/StringBuilder;
        //   625: dup            
        //   626: invokespecial   java/lang/StringBuilder.<init>:()V
        //   629: aload_1        
        //   630: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   633: ldc             "millennial: NOT found, admarvel-android-sdk-millennial-adapter.jar NOT in classpath\n"
        //   635: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   638: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   641: astore_0       
        //   642: goto            196
        //   645: astore_1       
        //   646: new             Ljava/lang/StringBuilder;
        //   649: dup            
        //   650: invokespecial   java/lang/StringBuilder.<init>:()V
        //   653: aload_0        
        //   654: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   657: ldc             "amazon: NOT found, admarvel-android-sdk-amazon-adapter.jar NOT in classpath\n"
        //   659: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   662: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   665: astore_1       
        //   666: goto            250
        //   669: astore_0       
        //   670: new             Ljava/lang/StringBuilder;
        //   673: dup            
        //   674: invokespecial   java/lang/StringBuilder.<init>:()V
        //   677: aload_1        
        //   678: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   681: ldc             "adcolony: NOT found, admarvel-android-sdk-adcolony-adapter.jar NOT in classpath\n"
        //   683: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   686: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   689: astore_0       
        //   690: goto            314
        //   693: astore_1       
        //   694: new             Ljava/lang/StringBuilder;
        //   697: dup            
        //   698: invokespecial   java/lang/StringBuilder.<init>:()V
        //   701: aload_0        
        //   702: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   705: ldc             "pulse3d: NOT found, admarvel-android-sdk-pulse3d-adapter.jar NOT in classpath\n"
        //   707: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   710: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   713: astore_1       
        //   714: goto            378
        //   717: astore_0       
        //   718: new             Ljava/lang/StringBuilder;
        //   721: dup            
        //   722: invokespecial   java/lang/StringBuilder.<init>:()V
        //   725: aload_1        
        //   726: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   729: ldc             "facebook: NOT found, admarvel-android-sdk-facebook-adapter.jar NOT in classpath\n"
        //   731: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   734: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   737: astore_0       
        //   738: goto            442
        //   741: astore_1       
        //   742: new             Ljava/lang/StringBuilder;
        //   745: dup            
        //   746: invokespecial   java/lang/StringBuilder.<init>:()V
        //   749: aload_0        
        //   750: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   753: ldc             "inmobi: NOT found, admarvel-android-sdk-inmobi-adapter.jar NOT in classpath\n"
        //   755: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   758: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   761: astore_1       
        //   762: goto            506
        //   765: astore_0       
        //   766: new             Ljava/lang/StringBuilder;
        //   769: dup            
        //   770: invokespecial   java/lang/StringBuilder.<init>:()V
        //   773: aload_1        
        //   774: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   777: ldc             "heyzap: NOT found, admarvel-android-sdk-heyzap-adapter.jar NOT in classpath\n"
        //   779: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   782: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   785: areturn        
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                 
        //  -----  -----  -----  -----  ---------------------
        //  3      9      572    597    Ljava/lang/Exception;
        //  17     25     572    597    Ljava/lang/Exception;
        //  27     68     572    597    Ljava/lang/Exception;
        //  68     74     597    621    Ljava/lang/Exception;
        //  82     90     597    621    Ljava/lang/Exception;
        //  92     132    597    621    Ljava/lang/Exception;
        //  132    138    621    645    Ljava/lang/Exception;
        //  146    154    621    645    Ljava/lang/Exception;
        //  156    196    621    645    Ljava/lang/Exception;
        //  196    202    645    669    Ljava/lang/Exception;
        //  210    250    645    669    Ljava/lang/Exception;
        //  250    256    669    693    Ljava/lang/Exception;
        //  264    272    669    693    Ljava/lang/Exception;
        //  274    314    669    693    Ljava/lang/Exception;
        //  314    320    693    717    Ljava/lang/Exception;
        //  328    336    693    717    Ljava/lang/Exception;
        //  338    378    693    717    Ljava/lang/Exception;
        //  378    384    717    741    Ljava/lang/Exception;
        //  392    400    717    741    Ljava/lang/Exception;
        //  402    442    717    741    Ljava/lang/Exception;
        //  442    448    741    765    Ljava/lang/Exception;
        //  456    464    741    765    Ljava/lang/Exception;
        //  466    506    741    765    Ljava/lang/Exception;
        //  506    512    765    786    Ljava/lang/Exception;
        //  520    528    765    786    Ljava/lang/Exception;
        //  530    570    765    786    Ljava/lang/Exception;
        // 
        // The error that occurred was:
        // 
        // java.lang.IndexOutOfBoundsException: Index: 376, Size: 376
        //     at java.util.ArrayList.rangeCheck(ArrayList.java:659)
        //     at java.util.ArrayList.get(ArrayList.java:435)
        //     at com.strobel.decompiler.ast.AstBuilder.convertToAst(AstBuilder.java:3379)
        //     at com.strobel.decompiler.ast.AstBuilder.build(AstBuilder.java:113)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:206)
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
