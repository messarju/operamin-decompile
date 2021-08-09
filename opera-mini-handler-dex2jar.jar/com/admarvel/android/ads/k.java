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

class k extends AsyncTask
{
    private Map a;
    private WeakReference b;
    private final WeakReference c;
    
    public k(final Context context) {
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
        //     6: astore          14
        //     8: aload_1        
        //     9: iconst_1       
        //    10: aaload         
        //    11: checkcast       Ljava/lang/String;
        //    14: astore          5
        //    16: aload_1        
        //    17: iconst_2       
        //    18: aaload         
        //    19: checkcast       Ljava/lang/String;
        //    22: astore          7
        //    24: aload_1        
        //    25: iconst_3       
        //    26: aaload         
        //    27: checkcast       Ljava/lang/String;
        //    30: astore          8
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
        //    48: astore          9
        //    50: aload_0        
        //    51: new             Ljava/lang/ref/WeakReference;
        //    54: dup            
        //    55: aload_1        
        //    56: bipush          6
        //    58: aaload         
        //    59: checkcast       Lcom/admarvel/android/ads/AdMarvelView;
        //    62: invokespecial   java/lang/ref/WeakReference.<init>:(Ljava/lang/Object;)V
        //    65: putfield        com/admarvel/android/ads/k.b:Ljava/lang/ref/WeakReference;
        //    68: aload_1        
        //    69: bipush          7
        //    71: aaload         
        //    72: checkcast       Ljava/lang/Integer;
        //    75: invokevirtual   java/lang/Integer.intValue:()I
        //    78: istore_3       
        //    79: aload_1        
        //    80: bipush          8
        //    82: aaload         
        //    83: checkcast       Ljava/lang/String;
        //    86: astore          11
        //    88: aload_1        
        //    89: bipush          9
        //    91: aaload         
        //    92: checkcast       Ljava/lang/Boolean;
        //    95: astore          12
        //    97: aload_1        
        //    98: bipush          10
        //   100: aaload         
        //   101: checkcast       Ljava/lang/Boolean;
        //   104: astore          13
        //   106: new             Lcom/admarvel/android/ads/AdFetcher;
        //   109: dup            
        //   110: invokespecial   com/admarvel/android/ads/AdFetcher.<init>:()V
        //   113: astore          10
        //   115: aload_0        
        //   116: getfield        com/admarvel/android/ads/k.c:Ljava/lang/ref/WeakReference;
        //   119: invokevirtual   java/lang/ref/WeakReference.get:()Ljava/lang/Object;
        //   122: checkcast       Landroid/content/Context;
        //   125: astore          6
        //   127: aload           6
        //   129: ifnull          717
        //   132: aload           14
        //   134: ifnull          154
        //   137: aload           14
        //   139: monitorenter   
        //   140: aload_0        
        //   141: getfield        com/admarvel/android/ads/k.a:Ljava/util/Map;
        //   144: aload           14
        //   146: invokeinterface java/util/Map.putAll:(Ljava/util/Map;)V
        //   151: aload           14
        //   153: monitorexit    
        //   154: ldc             "com.admarvel.android.admarvelmologiqadapter.AdMarvelMologiqAdapter"
        //   156: aload           6
        //   158: invokestatic    com/admarvel/android/ads/AdMarvelAnalyticsAdapterInstances.getInstance:(Ljava/lang/String;Landroid/content/Context;)Lcom/admarvel/android/ads/AdMarvelAnalyticsAdapter;
        //   161: aload           7
        //   163: aload_0        
        //   164: getfield        com/admarvel/android/ads/k.a:Ljava/util/Map;
        //   167: invokevirtual   com/admarvel/android/ads/AdMarvelAnalyticsAdapter.getEnhancedTargetParams:(Ljava/lang/String;Ljava/util/Map;)Ljava/util/Map;
        //   170: astore_1       
        //   171: aload_1        
        //   172: ifnull          202
        //   175: aload_0        
        //   176: getfield        com/admarvel/android/ads/k.a:Ljava/util/Map;
        //   179: ifnull          538
        //   182: aload_1        
        //   183: aload_0        
        //   184: getfield        com/admarvel/android/ads/k.a:Ljava/util/Map;
        //   187: invokeinterface java/util/Map.putAll:(Ljava/util/Map;)V
        //   192: aload_0        
        //   193: getfield        com/admarvel/android/ads/k.a:Ljava/util/Map;
        //   196: aload_1        
        //   197: invokeinterface java/util/Map.putAll:(Ljava/util/Map;)V
        //   202: iconst_0       
        //   203: istore          4
        //   205: aload_0        
        //   206: getfield        com/admarvel/android/ads/k.b:Ljava/lang/ref/WeakReference;
        //   209: ifnull          557
        //   212: aload_0        
        //   213: getfield        com/admarvel/android/ads/k.b:Ljava/lang/ref/WeakReference;
        //   216: invokevirtual   java/lang/ref/WeakReference.get:()Ljava/lang/Object;
        //   219: checkcast       Lcom/admarvel/android/ads/AdMarvelView;
        //   222: astore_1       
        //   223: aload_1        
        //   224: ifnull          233
        //   227: aload_1        
        //   228: invokevirtual   com/admarvel/android/ads/AdMarvelView.b:()Z
        //   231: istore          4
        //   233: getstatic       com/admarvel/android/ads/AdMarvelView.a:Z
        //   236: ifeq            562
        //   239: aload           10
        //   241: getstatic       com/admarvel/android/ads/AdFetcher$Adtype.BANNER:Lcom/admarvel/android/ads/AdFetcher$Adtype;
        //   244: aload           6
        //   246: aload           8
        //   248: iload_2        
        //   249: aload           9
        //   251: aload_0        
        //   252: getfield        com/admarvel/android/ads/k.a:Ljava/util/Map;
        //   255: aload           5
        //   257: aload           7
        //   259: iload_3        
        //   260: aload           11
        //   262: aload           12
        //   264: invokevirtual   java/lang/Boolean.booleanValue:()Z
        //   267: aload           13
        //   269: invokevirtual   java/lang/Boolean.booleanValue:()Z
        //   272: invokevirtual   com/admarvel/android/ads/AdFetcher.fetchOfflineAd:(Lcom/admarvel/android/ads/AdFetcher$Adtype;Landroid/content/Context;Ljava/lang/String;ILjava/lang/String;Ljava/util/Map;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;ZZ)Ljava/lang/String;
        //   275: astore_1       
        //   276: new             Lcom/admarvel/android/ads/AdMarvelAd;
        //   279: dup            
        //   280: aload_1        
        //   281: aload_0        
        //   282: getfield        com/admarvel/android/ads/k.a:Ljava/util/Map;
        //   285: aload           5
        //   287: aload           7
        //   289: aload           8
        //   291: iload_2        
        //   292: aload           9
        //   294: aload           6
        //   296: invokevirtual   android/content/Context.getPackageName:()Ljava/lang/String;
        //   299: invokespecial   com/admarvel/android/ads/AdMarvelAd.<init>:(Ljava/lang/String;Ljava/util/Map;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V
        //   302: astore          5
        //   304: invokestatic    com/admarvel/android/ads/AdMarvelUtils.isLogDumpEnabled:()Z
        //   307: ifeq            320
        //   310: aload           5
        //   312: aload           10
        //   314: invokevirtual   com/admarvel/android/ads/AdFetcher.getRequestJson:()Lorg/json/JSONObject;
        //   317: invokevirtual   com/admarvel/android/ads/AdMarvelAd.setRequestJson:(Lorg/json/JSONObject;)V
        //   320: getstatic       com/admarvel/android/ads/AdMarvelView.a:Z
        //   323: ifeq            429
        //   326: aload           6
        //   328: ldc             "admarvel_preferences"
        //   330: iconst_0       
        //   331: invokevirtual   android/content/Context.getSharedPreferences:(Ljava/lang/String;I)Landroid/content/SharedPreferences;
        //   334: astore          7
        //   336: aload           7
        //   338: ldc             "banner_folder"
        //   340: ldc             "NULL"
        //   342: invokeinterface android/content/SharedPreferences.getString:(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
        //   347: astore          8
        //   349: aload           5
        //   351: new             Ljava/lang/StringBuilder;
        //   354: dup            
        //   355: ldc             "file://"
        //   357: invokespecial   java/lang/StringBuilder.<init>:(Ljava/lang/String;)V
        //   360: aload           7
        //   362: ldc             "childDirectory"
        //   364: ldc             "NULL"
        //   366: invokeinterface android/content/SharedPreferences.getString:(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
        //   371: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   374: ldc             "/"
        //   376: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   379: aload           8
        //   381: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   384: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   387: invokevirtual   com/admarvel/android/ads/AdMarvelAd.setOfflineBaseUrl:(Ljava/lang/String;)V
        //   390: aload           5
        //   392: new             Ljava/lang/StringBuilder;
        //   395: dup            
        //   396: invokespecial   java/lang/StringBuilder.<init>:()V
        //   399: aload           7
        //   401: ldc             "childDirectory"
        //   403: ldc             "NULL"
        //   405: invokeinterface android/content/SharedPreferences.getString:(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
        //   410: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   413: ldc             "/"
        //   415: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   418: aload           8
        //   420: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   423: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   426: invokevirtual   com/admarvel/android/ads/AdMarvelAd.setOfflinekeyUrl:(Ljava/lang/String;)V
        //   429: aload_1        
        //   430: ifnull          698
        //   433: aload           5
        //   435: aload           6
        //   437: invokevirtual   com/admarvel/android/ads/AdMarvelAd.loadAd:(Landroid/content/Context;)Lcom/admarvel/android/ads/AdMarvelXMLReader;
        //   440: astore          6
        //   442: aload           6
        //   444: ifnull          679
        //   447: aload           5
        //   449: astore_1       
        //   450: aload           5
        //   452: invokevirtual   com/admarvel/android/ads/AdMarvelAd.getSdkNetwork:()Ljava/lang/String;
        //   455: ifnull          515
        //   458: aload           5
        //   460: invokevirtual   com/admarvel/android/ads/AdMarvelAd.getSdkNetwork:()Ljava/lang/String;
        //   463: invokevirtual   java/lang/String.length:()I
        //   466: istore_2       
        //   467: aload           5
        //   469: astore_1       
        //   470: iload_2        
        //   471: ifle            515
        //   474: aload_0        
        //   475: getfield        com/admarvel/android/ads/k.b:Ljava/lang/ref/WeakReference;
        //   478: invokevirtual   java/lang/ref/WeakReference.get:()Ljava/lang/Object;
        //   481: checkcast       Lcom/admarvel/android/ads/AdMarvelView;
        //   484: astore          7
        //   486: aload           5
        //   488: astore_1       
        //   489: aload           7
        //   491: ifnull          515
        //   494: aload           7
        //   496: getfield        com/admarvel/android/ads/AdMarvelView.b:Ljava/lang/String;
        //   499: aload           5
        //   501: invokevirtual   com/admarvel/android/ads/AdMarvelAd.getSdkNetwork:()Ljava/lang/String;
        //   504: invokestatic    com/admarvel/android/ads/AdMarvelAdapterInstances.getInstance:(Ljava/lang/String;Ljava/lang/String;)Lcom/admarvel/android/ads/AdMarvelAdapter;
        //   507: aload           5
        //   509: aload           6
        //   511: invokevirtual   com/admarvel/android/ads/AdMarvelAdapter.loadAd:(Lcom/admarvel/android/ads/AdMarvelAd;Lcom/admarvel/android/ads/AdMarvelXMLReader;)Lcom/admarvel/android/ads/AdMarvelAd;
        //   514: astore_1       
        //   515: aload_1        
        //   516: areturn        
        //   517: astore_1       
        //   518: aload           14
        //   520: monitorexit    
        //   521: aload_1        
        //   522: athrow         
        //   523: astore_1       
        //   524: aload_0        
        //   525: aconst_null    
        //   526: putfield        com/admarvel/android/ads/k.a:Ljava/util/Map;
        //   529: goto            154
        //   532: astore_1       
        //   533: aconst_null    
        //   534: astore_1       
        //   535: goto            171
        //   538: aload_0        
        //   539: aload_1        
        //   540: putfield        com/admarvel/android/ads/k.a:Ljava/util/Map;
        //   543: goto            202
        //   546: astore_1       
        //   547: aload_1        
        //   548: invokestatic    android/util/Log.getStackTraceString:(Ljava/lang/Throwable;)Ljava/lang/String;
        //   551: invokestatic    com/admarvel/android/util/Logging.log:(Ljava/lang/String;)V
        //   554: goto            202
        //   557: aconst_null    
        //   558: astore_1       
        //   559: goto            223
        //   562: aload           10
        //   564: getstatic       com/admarvel/android/ads/AdFetcher$Adtype.BANNER:Lcom/admarvel/android/ads/AdFetcher$Adtype;
        //   567: aload           6
        //   569: aload           8
        //   571: iload_2        
        //   572: aload           9
        //   574: aload_0        
        //   575: getfield        com/admarvel/android/ads/k.a:Ljava/util/Map;
        //   578: aload           5
        //   580: aload           7
        //   582: iload_3        
        //   583: aload           11
        //   585: aload           12
        //   587: invokevirtual   java/lang/Boolean.booleanValue:()Z
        //   590: aload           13
        //   592: invokevirtual   java/lang/Boolean.booleanValue:()Z
        //   595: iload           4
        //   597: aconst_null    
        //   598: invokevirtual   com/admarvel/android/ads/AdFetcher.fetchAd:(Lcom/admarvel/android/ads/AdFetcher$Adtype;Landroid/content/Context;Ljava/lang/String;ILjava/lang/String;Ljava/util/Map;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;ZZZLcom/admarvel/android/ads/AdMarvelNetworkHandler;)Ljava/lang/String;
        //   601: astore_1       
        //   602: goto            276
        //   605: astore_1       
        //   606: aload_1        
        //   607: invokestatic    android/util/Log.getStackTraceString:(Ljava/lang/Throwable;)Ljava/lang/String;
        //   610: invokestatic    com/admarvel/android/util/Logging.log:(Ljava/lang/String;)V
        //   613: aload           5
        //   615: getstatic       com/admarvel/android/ads/AdMarvelAd$AdType.ERROR:Lcom/admarvel/android/ads/AdMarvelAd$AdType;
        //   618: invokevirtual   com/admarvel/android/ads/AdMarvelAd.setAdType:(Lcom/admarvel/android/ads/AdMarvelAd$AdType;)V
        //   621: aload           5
        //   623: sipush          303
        //   626: invokevirtual   com/admarvel/android/ads/AdMarvelAd.setErrorCode:(I)V
        //   629: aload           5
        //   631: areturn        
        //   632: astore_1       
        //   633: aload_1        
        //   634: invokestatic    android/util/Log.getStackTraceString:(Ljava/lang/Throwable;)Ljava/lang/String;
        //   637: invokestatic    com/admarvel/android/util/Logging.log:(Ljava/lang/String;)V
        //   640: aload           5
        //   642: getstatic       com/admarvel/android/ads/AdMarvelAd$AdType.ERROR:Lcom/admarvel/android/ads/AdMarvelAd$AdType;
        //   645: invokevirtual   com/admarvel/android/ads/AdMarvelAd.setAdType:(Lcom/admarvel/android/ads/AdMarvelAd$AdType;)V
        //   648: aload           5
        //   650: sipush          303
        //   653: invokevirtual   com/admarvel/android/ads/AdMarvelAd.setErrorCode:(I)V
        //   656: aload           5
        //   658: areturn        
        //   659: astore_1       
        //   660: aload           5
        //   662: getstatic       com/admarvel/android/ads/AdMarvelAd$AdType.ERROR:Lcom/admarvel/android/ads/AdMarvelAd$AdType;
        //   665: invokevirtual   com/admarvel/android/ads/AdMarvelAd.setAdType:(Lcom/admarvel/android/ads/AdMarvelAd$AdType;)V
        //   668: aload           5
        //   670: sipush          303
        //   673: invokevirtual   com/admarvel/android/ads/AdMarvelAd.setErrorCode:(I)V
        //   676: aload           5
        //   678: areturn        
        //   679: aload           5
        //   681: getstatic       com/admarvel/android/ads/AdMarvelAd$AdType.ERROR:Lcom/admarvel/android/ads/AdMarvelAd$AdType;
        //   684: invokevirtual   com/admarvel/android/ads/AdMarvelAd.setAdType:(Lcom/admarvel/android/ads/AdMarvelAd$AdType;)V
        //   687: aload           5
        //   689: sipush          303
        //   692: invokevirtual   com/admarvel/android/ads/AdMarvelAd.setErrorCode:(I)V
        //   695: aload           5
        //   697: areturn        
        //   698: aload           5
        //   700: getstatic       com/admarvel/android/ads/AdMarvelAd$AdType.ERROR:Lcom/admarvel/android/ads/AdMarvelAd$AdType;
        //   703: invokevirtual   com/admarvel/android/ads/AdMarvelAd.setAdType:(Lcom/admarvel/android/ads/AdMarvelAd$AdType;)V
        //   706: aload           5
        //   708: sipush          303
        //   711: invokevirtual   com/admarvel/android/ads/AdMarvelAd.setErrorCode:(I)V
        //   714: aload           5
        //   716: areturn        
        //   717: aconst_null    
        //   718: areturn        
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                 
        //  -----  -----  -----  -----  ---------------------
        //  137    140    523    532    Ljava/lang/Exception;
        //  140    154    517    523    Any
        //  154    171    532    538    Ljava/lang/Exception;
        //  175    202    546    557    Ljava/lang/Exception;
        //  433    442    632    659    Ljava/lang/Exception;
        //  450    467    632    659    Ljava/lang/Exception;
        //  474    486    605    632    Ljava/lang/Exception;
        //  494    515    605    632    Ljava/lang/Exception;
        //  518    523    523    532    Ljava/lang/Exception;
        //  538    543    546    557    Ljava/lang/Exception;
        //  606    629    632    659    Ljava/lang/Exception;
        //  633    656    659    679    Ljava/lang/Exception;
        //  679    695    632    659    Ljava/lang/Exception;
        //  698    714    659    679    Ljava/lang/Exception;
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
        try {
            super.onPostExecute((Object)adMarvelAd);
            if (adMarvelAd == null) {
                final AdMarvelView adMarvelView = (AdMarvelView)this.b.get();
                if (adMarvelView != null) {
                    final AdMarvelUtils$ErrorReason a = r.a(303);
                    adMarvelView.getListenerImpl().a(adMarvelView.getContext(), adMarvelView, r.a(a), a, null, 0, null, "");
                }
                return;
            }
            else if (adMarvelAd.getAdType() == AdMarvelAd$AdType.ERROR) {
                final AdMarvelView adMarvelView2 = (AdMarvelView)this.b.get();
                if (adMarvelView2 != null) {
                    final AdMarvelUtils$ErrorReason a2 = r.a(adMarvelAd.getErrorCode());
                    adMarvelView2.getListenerImpl().a(adMarvelView2.getContext(), adMarvelView2, r.a(a2), a2, adMarvelAd.getSiteId(), adMarvelAd.getId(), adMarvelAd.getTargetParams(), adMarvelAd.getIpAddress());
                }
                return;
            }
        }
        catch (Exception ex) {
            Logging.log(Log.getStackTraceString((Throwable)ex));
            final AdMarvelUtils$ErrorReason a3 = r.a(303);
            final int a4 = r.a(a3);
            final AdMarvelView adMarvelView3 = (AdMarvelView)this.b.get();
            if (adMarvelView3 != null) {
                adMarvelView3.getListenerImpl().a(adMarvelView3.getContext(), adMarvelView3, a4, a3, adMarvelAd.getSiteId(), adMarvelAd.getId(), adMarvelAd.getTargetParams(), adMarvelAd.getIpAddress());
            }
            return;
        }
        if (this.b.get() != null) {
            final AdMarvelView adMarvelView4 = (AdMarvelView)this.b.get();
            if (adMarvelView4 != null && adMarvelView4.b()) {
                if (adMarvelView4.getListenerImpl() != null) {
                    adMarvelView4.getListenerImpl().a(adMarvelView4, adMarvelAd);
                }
                return;
            }
        }
        if (adMarvelAd.getAdType() == AdMarvelAd$AdType.SDKCALL) {
            if (adMarvelAd.getSdkNetwork() != null) {
                final AdMarvelView adMarvelView5 = (AdMarvelView)this.b.get();
                final Context context = (Context)this.c.get();
                if (adMarvelView5 != null && context != null) {
                    adMarvelView5.a(this.a, adMarvelAd, adMarvelAd.getSdkNetwork(), context);
                }
                return;
            }
            else if (adMarvelAd.isDisableAdrequest()) {
                final String disableAdDuration = adMarvelAd.getDisableAdDuration();
                if (disableAdDuration != null) {
                    final AdMarvelView adMarvelView6 = (AdMarvelView)this.b.get();
                    final Context context2 = (Context)this.c.get();
                    if (adMarvelView6 != null && context2 != null) {
                        adMarvelView6.a(disableAdDuration, adMarvelAd, context2);
                    }
                    return;
                }
            }
        }
        final AdMarvelView adMarvelView7 = (AdMarvelView)this.b.get();
        if (adMarvelView7 != null) {
            adMarvelView7.a(adMarvelAd);
        }
    }
}
