// 
// Decompiled by Procyon v0.6-prerelease
// 

package com.admarvel.android.ads;

import com.admarvel.android.util.Logging;
import android.util.Log;
import java.util.HashMap;
import android.content.Context;
import java.lang.ref.WeakReference;
import java.util.Map;
import android.os.AsyncTask;

class f extends AsyncTask
{
    private Map a;
    private AdMarvelInterstitialAds b;
    private final WeakReference c;
    
    public f(final Context context) {
        this.a = new HashMap();
        this.c = new WeakReference((T)context);
    }
    
    protected AdMarvelAd a(final Object... p0) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: iconst_0       
        //     2: aaload         
        //     3: checkcast       Ljava/util/Map;
        //     6: astore          11
        //     8: aload_1        
        //     9: iconst_1       
        //    10: aaload         
        //    11: checkcast       Ljava/lang/String;
        //    14: astore          4
        //    16: aload_1        
        //    17: iconst_2       
        //    18: aaload         
        //    19: checkcast       Ljava/lang/String;
        //    22: astore          6
        //    24: aload_1        
        //    25: iconst_3       
        //    26: aaload         
        //    27: checkcast       Ljava/lang/String;
        //    30: astore          7
        //    32: aload_1        
        //    33: iconst_4       
        //    34: aaload         
        //    35: checkcast       Ljava/lang/Integer;
        //    38: invokevirtual   java/lang/Integer.intValue:()I
        //    41: istore_2       
        //    42: aload_1        
        //    43: iconst_5       
        //    44: aaload         
        //    45: checkcast       Ljava/lang/String;
        //    48: astore          8
        //    50: aload_0        
        //    51: aload_1        
        //    52: bipush          6
        //    54: aaload         
        //    55: checkcast       Lcom/admarvel/android/ads/AdMarvelInterstitialAds;
        //    58: putfield        com/admarvel/android/ads/f.b:Lcom/admarvel/android/ads/AdMarvelInterstitialAds;
        //    61: aload_1        
        //    62: bipush          7
        //    64: aaload         
        //    65: checkcast       Ljava/lang/Integer;
        //    68: invokevirtual   java/lang/Integer.intValue:()I
        //    71: istore_3       
        //    72: aload_1        
        //    73: bipush          8
        //    75: aaload         
        //    76: checkcast       Ljava/lang/String;
        //    79: astore          10
        //    81: aload_0        
        //    82: getfield        com/admarvel/android/ads/f.c:Ljava/lang/ref/WeakReference;
        //    85: invokevirtual   java/lang/ref/WeakReference.get:()Ljava/lang/Object;
        //    88: checkcast       Landroid/content/Context;
        //    91: astore          5
        //    93: new             Lcom/admarvel/android/ads/AdFetcher;
        //    96: dup            
        //    97: invokespecial   com/admarvel/android/ads/AdFetcher.<init>:()V
        //   100: astore          9
        //   102: aload           5
        //   104: ifnonnull       111
        //   107: aconst_null    
        //   108: astore_1       
        //   109: aload_1        
        //   110: areturn        
        //   111: aload           11
        //   113: ifnull          133
        //   116: aload           11
        //   118: monitorenter   
        //   119: aload_0        
        //   120: getfield        com/admarvel/android/ads/f.a:Ljava/util/Map;
        //   123: aload           11
        //   125: invokeinterface java/util/Map.putAll:(Ljava/util/Map;)V
        //   130: aload           11
        //   132: monitorexit    
        //   133: ldc             "com.admarvel.android.admarvelmologiqadapter.AdMarvelMologiqAdapter"
        //   135: aload           5
        //   137: invokestatic    com/admarvel/android/ads/AdMarvelAnalyticsAdapterInstances.getInstance:(Ljava/lang/String;Landroid/content/Context;)Lcom/admarvel/android/ads/AdMarvelAnalyticsAdapter;
        //   140: aload           6
        //   142: aload_0        
        //   143: getfield        com/admarvel/android/ads/f.a:Ljava/util/Map;
        //   146: invokevirtual   com/admarvel/android/ads/AdMarvelAnalyticsAdapter.getEnhancedTargetParams:(Ljava/lang/String;Ljava/util/Map;)Ljava/util/Map;
        //   149: astore_1       
        //   150: aload_1        
        //   151: ifnull          181
        //   154: aload_0        
        //   155: getfield        com/admarvel/android/ads/f.a:Ljava/util/Map;
        //   158: ifnull          455
        //   161: aload_1        
        //   162: aload_0        
        //   163: getfield        com/admarvel/android/ads/f.a:Ljava/util/Map;
        //   166: invokeinterface java/util/Map.putAll:(Ljava/util/Map;)V
        //   171: aload_0        
        //   172: getfield        com/admarvel/android/ads/f.a:Ljava/util/Map;
        //   175: aload_1        
        //   176: invokeinterface java/util/Map.putAll:(Ljava/util/Map;)V
        //   181: getstatic       com/admarvel/android/ads/AdMarvelInterstitialAds.enableOfflineSDK:Z
        //   184: ifeq            474
        //   187: aload           9
        //   189: getstatic       com/admarvel/android/ads/AdFetcher$Adtype.INTERSTITIAL:Lcom/admarvel/android/ads/AdFetcher$Adtype;
        //   192: aload           5
        //   194: aload           7
        //   196: iload_2        
        //   197: aload           8
        //   199: aload_0        
        //   200: getfield        com/admarvel/android/ads/f.a:Ljava/util/Map;
        //   203: aload           4
        //   205: aload           6
        //   207: iload_3        
        //   208: aload           10
        //   210: iconst_0       
        //   211: aload_0        
        //   212: getfield        com/admarvel/android/ads/f.b:Lcom/admarvel/android/ads/AdMarvelInterstitialAds;
        //   215: invokevirtual   com/admarvel/android/ads/AdMarvelInterstitialAds.isAutoScalingEnabled:()Z
        //   218: invokevirtual   com/admarvel/android/ads/AdFetcher.fetchOfflineAd:(Lcom/admarvel/android/ads/AdFetcher$Adtype;Landroid/content/Context;Ljava/lang/String;ILjava/lang/String;Ljava/util/Map;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;ZZ)Ljava/lang/String;
        //   221: astore_1       
        //   222: new             Lcom/admarvel/android/ads/AdMarvelAd;
        //   225: dup            
        //   226: aload_1        
        //   227: aload_0        
        //   228: getfield        com/admarvel/android/ads/f.a:Ljava/util/Map;
        //   231: aload           4
        //   233: aload           6
        //   235: aload           7
        //   237: iload_2        
        //   238: aload           8
        //   240: aload           5
        //   242: invokevirtual   android/content/Context.getPackageName:()Ljava/lang/String;
        //   245: invokespecial   com/admarvel/android/ads/AdMarvelAd.<init>:(Ljava/lang/String;Ljava/util/Map;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V
        //   248: astore          4
        //   250: aload           4
        //   252: aload           9
        //   254: invokevirtual   com/admarvel/android/ads/AdFetcher.getRequestJson:()Lorg/json/JSONObject;
        //   257: invokevirtual   com/admarvel/android/ads/AdMarvelAd.setRequestJson:(Lorg/json/JSONObject;)V
        //   260: getstatic       com/admarvel/android/ads/AdMarvelInterstitialAds.enableOfflineSDK:Z
        //   263: ifeq            369
        //   266: aload           5
        //   268: ldc             "admarvel_preferences"
        //   270: iconst_0       
        //   271: invokevirtual   android/content/Context.getSharedPreferences:(Ljava/lang/String;I)Landroid/content/SharedPreferences;
        //   274: astore          6
        //   276: aload           6
        //   278: ldc             "banner_folder"
        //   280: ldc             "NULL"
        //   282: invokeinterface android/content/SharedPreferences.getString:(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
        //   287: astore          7
        //   289: aload           4
        //   291: new             Ljava/lang/StringBuilder;
        //   294: dup            
        //   295: ldc             "file://"
        //   297: invokespecial   java/lang/StringBuilder.<init>:(Ljava/lang/String;)V
        //   300: aload           6
        //   302: ldc             "childDirectory"
        //   304: ldc             "NULL"
        //   306: invokeinterface android/content/SharedPreferences.getString:(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
        //   311: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   314: ldc             "/"
        //   316: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   319: aload           7
        //   321: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   324: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   327: invokevirtual   com/admarvel/android/ads/AdMarvelAd.setOfflineBaseUrl:(Ljava/lang/String;)V
        //   330: aload           4
        //   332: new             Ljava/lang/StringBuilder;
        //   335: dup            
        //   336: invokespecial   java/lang/StringBuilder.<init>:()V
        //   339: aload           6
        //   341: ldc             "childDirectory"
        //   343: ldc             "NULL"
        //   345: invokeinterface android/content/SharedPreferences.getString:(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
        //   350: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   353: ldc             "/"
        //   355: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   358: aload           7
        //   360: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   363: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   366: invokevirtual   com/admarvel/android/ads/AdMarvelAd.setOfflinekeyUrl:(Ljava/lang/String;)V
        //   369: aload_1        
        //   370: ifnull          607
        //   373: aload           4
        //   375: aload           5
        //   377: invokevirtual   com/admarvel/android/ads/AdMarvelAd.loadAd:(Landroid/content/Context;)Lcom/admarvel/android/ads/AdMarvelXMLReader;
        //   380: astore          5
        //   382: aload           5
        //   384: ifnull          588
        //   387: aload           4
        //   389: astore_1       
        //   390: aload           4
        //   392: invokevirtual   com/admarvel/android/ads/AdMarvelAd.getSdkNetwork:()Ljava/lang/String;
        //   395: ifnull          109
        //   398: aload           4
        //   400: invokevirtual   com/admarvel/android/ads/AdMarvelAd.getSdkNetwork:()Ljava/lang/String;
        //   403: invokevirtual   java/lang/String.length:()I
        //   406: istore_2       
        //   407: aload           4
        //   409: astore_1       
        //   410: iload_2        
        //   411: ifle            109
        //   414: ldc             "ADMARVELGUID"
        //   416: aload           4
        //   418: invokevirtual   com/admarvel/android/ads/AdMarvelAd.getSdkNetwork:()Ljava/lang/String;
        //   421: invokestatic    com/admarvel/android/ads/AdMarvelAdapterInstances.getInstance:(Ljava/lang/String;Ljava/lang/String;)Lcom/admarvel/android/ads/AdMarvelAdapter;
        //   424: aload           4
        //   426: aload           5
        //   428: invokevirtual   com/admarvel/android/ads/AdMarvelAdapter.loadAd:(Lcom/admarvel/android/ads/AdMarvelAd;Lcom/admarvel/android/ads/AdMarvelXMLReader;)Lcom/admarvel/android/ads/AdMarvelAd;
        //   431: astore_1       
        //   432: aload_1        
        //   433: areturn        
        //   434: astore_1       
        //   435: aload           11
        //   437: monitorexit    
        //   438: aload_1        
        //   439: athrow         
        //   440: astore_1       
        //   441: aload_0        
        //   442: aconst_null    
        //   443: putfield        com/admarvel/android/ads/f.a:Ljava/util/Map;
        //   446: goto            133
        //   449: astore_1       
        //   450: aconst_null    
        //   451: astore_1       
        //   452: goto            150
        //   455: aload_0        
        //   456: aload_1        
        //   457: putfield        com/admarvel/android/ads/f.a:Ljava/util/Map;
        //   460: goto            181
        //   463: astore_1       
        //   464: aload_1        
        //   465: invokestatic    android/util/Log.getStackTraceString:(Ljava/lang/Throwable;)Ljava/lang/String;
        //   468: invokestatic    com/admarvel/android/util/Logging.log:(Ljava/lang/String;)V
        //   471: goto            181
        //   474: aload           9
        //   476: getstatic       com/admarvel/android/ads/AdFetcher$Adtype.INTERSTITIAL:Lcom/admarvel/android/ads/AdFetcher$Adtype;
        //   479: aload           5
        //   481: aload           7
        //   483: iload_2        
        //   484: aload           8
        //   486: aload_0        
        //   487: getfield        com/admarvel/android/ads/f.a:Ljava/util/Map;
        //   490: aload           4
        //   492: aload           6
        //   494: iload_3        
        //   495: aload           10
        //   497: iconst_0       
        //   498: aload_0        
        //   499: getfield        com/admarvel/android/ads/f.b:Lcom/admarvel/android/ads/AdMarvelInterstitialAds;
        //   502: invokevirtual   com/admarvel/android/ads/AdMarvelInterstitialAds.isAutoScalingEnabled:()Z
        //   505: iconst_0       
        //   506: aconst_null    
        //   507: invokevirtual   com/admarvel/android/ads/AdFetcher.fetchAd:(Lcom/admarvel/android/ads/AdFetcher$Adtype;Landroid/content/Context;Ljava/lang/String;ILjava/lang/String;Ljava/util/Map;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;ZZZLcom/admarvel/android/ads/AdMarvelNetworkHandler;)Ljava/lang/String;
        //   510: astore_1       
        //   511: goto            222
        //   514: astore_1       
        //   515: aload_1        
        //   516: invokestatic    android/util/Log.getStackTraceString:(Ljava/lang/Throwable;)Ljava/lang/String;
        //   519: invokestatic    com/admarvel/android/util/Logging.log:(Ljava/lang/String;)V
        //   522: aload           4
        //   524: getstatic       com/admarvel/android/ads/AdMarvelAd$AdType.ERROR:Lcom/admarvel/android/ads/AdMarvelAd$AdType;
        //   527: invokevirtual   com/admarvel/android/ads/AdMarvelAd.setAdType:(Lcom/admarvel/android/ads/AdMarvelAd$AdType;)V
        //   530: aload           4
        //   532: sipush          303
        //   535: invokevirtual   com/admarvel/android/ads/AdMarvelAd.setErrorCode:(I)V
        //   538: aload           4
        //   540: areturn        
        //   541: astore_1       
        //   542: aload_1        
        //   543: invokestatic    android/util/Log.getStackTraceString:(Ljava/lang/Throwable;)Ljava/lang/String;
        //   546: invokestatic    com/admarvel/android/util/Logging.log:(Ljava/lang/String;)V
        //   549: aload           4
        //   551: getstatic       com/admarvel/android/ads/AdMarvelAd$AdType.ERROR:Lcom/admarvel/android/ads/AdMarvelAd$AdType;
        //   554: invokevirtual   com/admarvel/android/ads/AdMarvelAd.setAdType:(Lcom/admarvel/android/ads/AdMarvelAd$AdType;)V
        //   557: aload           4
        //   559: sipush          303
        //   562: invokevirtual   com/admarvel/android/ads/AdMarvelAd.setErrorCode:(I)V
        //   565: aload           4
        //   567: areturn        
        //   568: astore_1       
        //   569: aload           4
        //   571: getstatic       com/admarvel/android/ads/AdMarvelAd$AdType.ERROR:Lcom/admarvel/android/ads/AdMarvelAd$AdType;
        //   574: invokevirtual   com/admarvel/android/ads/AdMarvelAd.setAdType:(Lcom/admarvel/android/ads/AdMarvelAd$AdType;)V
        //   577: aload           4
        //   579: sipush          303
        //   582: invokevirtual   com/admarvel/android/ads/AdMarvelAd.setErrorCode:(I)V
        //   585: aload           4
        //   587: areturn        
        //   588: aload           4
        //   590: getstatic       com/admarvel/android/ads/AdMarvelAd$AdType.ERROR:Lcom/admarvel/android/ads/AdMarvelAd$AdType;
        //   593: invokevirtual   com/admarvel/android/ads/AdMarvelAd.setAdType:(Lcom/admarvel/android/ads/AdMarvelAd$AdType;)V
        //   596: aload           4
        //   598: sipush          303
        //   601: invokevirtual   com/admarvel/android/ads/AdMarvelAd.setErrorCode:(I)V
        //   604: aload           4
        //   606: areturn        
        //   607: aload           4
        //   609: getstatic       com/admarvel/android/ads/AdMarvelAd$AdType.ERROR:Lcom/admarvel/android/ads/AdMarvelAd$AdType;
        //   612: invokevirtual   com/admarvel/android/ads/AdMarvelAd.setAdType:(Lcom/admarvel/android/ads/AdMarvelAd$AdType;)V
        //   615: aload           4
        //   617: sipush          303
        //   620: invokevirtual   com/admarvel/android/ads/AdMarvelAd.setErrorCode:(I)V
        //   623: aload           4
        //   625: areturn        
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                 
        //  -----  -----  -----  -----  ---------------------
        //  116    119    440    449    Ljava/lang/Exception;
        //  119    133    434    440    Any
        //  133    150    449    455    Ljava/lang/Exception;
        //  154    181    463    474    Ljava/lang/Exception;
        //  373    382    541    568    Ljava/lang/Exception;
        //  390    407    541    568    Ljava/lang/Exception;
        //  414    432    514    541    Ljava/lang/Exception;
        //  435    440    440    449    Ljava/lang/Exception;
        //  455    460    463    474    Ljava/lang/Exception;
        //  515    538    541    568    Ljava/lang/Exception;
        //  542    565    568    588    Ljava/lang/Exception;
        //  588    604    541    568    Ljava/lang/Exception;
        //  607    623    568    588    Ljava/lang/Exception;
        // 
        // The error that occurred was:
        // 
        // java.lang.UnsupportedOperationException
        //     at java.util.Collections$1.remove(Collections.java:4686)
        //     at java.util.AbstractCollection.removeAll(AbstractCollection.java:376)
        //     at com.strobel.decompiler.ast.AstBuilder.convertLocalVariables(AstBuilder.java:3026)
        //     at com.strobel.decompiler.ast.AstBuilder.performStackAnalysis(AstBuilder.java:2503)
        //     at com.strobel.decompiler.ast.AstBuilder.build(AstBuilder.java:108)
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
    
    protected void a(final AdMarvelAd adMarvelAd) {
        Label_0238: {
            try {
                super.onPostExecute((Object)adMarvelAd);
                if (adMarvelAd.getAdType() == AdMarvelAd$AdType.ERROR) {
                    final AdMarvelUtils$ErrorReason a = r.a(adMarvelAd.getErrorCode());
                    final int a2 = r.a(a);
                    final Context context = (Context)this.c.get();
                    if (context != null) {
                        AdMarvelInterstitialAds.getListener().a(context, null, null, a2, a, adMarvelAd.getSiteId(), adMarvelAd.getId(), adMarvelAd.getTargetParams(), adMarvelAd.getIpAddress());
                    }
                    return;
                }
                else {
                    if (adMarvelAd.getAdType() != AdMarvelAd$AdType.SDKCALL) {
                        break Label_0238;
                    }
                    if (adMarvelAd.getSdkNetwork() != null) {
                        this.b.requestPendingAdapterAd(this.a, adMarvelAd, adMarvelAd.getSdkNetwork(), (Context)this.c.get());
                        return;
                    }
                }
            }
            catch (Exception ex) {
                Logging.log(Log.getStackTraceString((Throwable)ex));
                final AdMarvelUtils$ErrorReason a3 = r.a(303);
                final int a4 = r.a(a3);
                final Context context2 = (Context)this.c.get();
                if (context2 != null) {
                    AdMarvelInterstitialAds.getListener().a(context2, null, null, a4, a3, adMarvelAd.getSiteId(), adMarvelAd.getId(), adMarvelAd.getTargetParams(), adMarvelAd.getIpAddress());
                }
                return;
            }
            if (adMarvelAd.isDisableAdrequest()) {
                final String disableAdDuration = adMarvelAd.getDisableAdDuration();
                if (disableAdDuration != null) {
                    final Context context3 = (Context)this.c.get();
                    if (this.b != null && context3 != null) {
                        this.b.disableAdRequest(disableAdDuration, adMarvelAd, context3);
                    }
                    return;
                }
            }
        }
        Context context4;
        if (this.c != null) {
            context4 = (Context)this.c.get();
        }
        else {
            context4 = null;
        }
        this.b.requestPendingAdMarvelAd(adMarvelAd, context4);
    }
}
