// 
// Decompiled by Procyon v0.6-prerelease
// 

package com.admarvel.android.admarvelfacebookadapter;

import com.facebook.ads.AdError;
import com.admarvel.android.ads.AdMarvelUtils;
import com.admarvel.android.util.Logging;
import com.facebook.ads.Ad;
import com.facebook.ads.NativeAd;
import com.admarvel.android.ads.AdMarvelAdapterListener;
import com.facebook.ads.AdListener;

public class InternalFacebookNativeListener implements AdListener
{
    final Object adMarvelNativeAd;
    final AdMarvelAdapterListener adMarvelNativeAdAdapterListener;
    
    public InternalFacebookNativeListener(final AdMarvelAdapterListener adMarvelNativeAdAdapterListener, final Object adMarvelNativeAd) {
        this.adMarvelNativeAdAdapterListener = adMarvelNativeAdAdapterListener;
        this.adMarvelNativeAd = adMarvelNativeAd;
    }
    
    private boolean updateAdMarvelNatvieAd(final NativeAd p0) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     3: dup            
        //     4: invokespecial   java/util/HashMap.<init>:()V
        //     7: astore          9
        //     9: aload_0        
        //    10: getfield        com/admarvel/android/admarvelfacebookadapter/InternalFacebookNativeListener.adMarvelNativeAd:Ljava/lang/Object;
        //    13: ifnull          991
        //    16: aload_1        
        //    17: ifnull          991
        //    20: aload_1        
        //    21: invokevirtual   com/facebook/ads/NativeAd.getAdTitle:()Ljava/lang/String;
        //    24: ifnull          39
        //    27: aload           9
        //    29: ldc             "displayName"
        //    31: aload_1        
        //    32: invokevirtual   com/facebook/ads/NativeAd.getAdTitle:()Ljava/lang/String;
        //    35: invokevirtual   java/util/HashMap.put:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //    38: pop            
        //    39: aload_1        
        //    40: invokevirtual   com/facebook/ads/NativeAd.getAdBody:()Ljava/lang/String;
        //    43: ifnull          58
        //    46: aload           9
        //    48: ldc             "shortMessage"
        //    50: aload_1        
        //    51: invokevirtual   com/facebook/ads/NativeAd.getAdBody:()Ljava/lang/String;
        //    54: invokevirtual   java/util/HashMap.put:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //    57: pop            
        //    58: aload_1        
        //    59: invokevirtual   com/facebook/ads/NativeAd.getAdIcon:()Lcom/facebook/ads/NativeAd$Image;
        //    62: astore          8
        //    64: aload           8
        //    66: ifnull          233
        //    69: aload_1        
        //    70: invokevirtual   com/facebook/ads/NativeAd.getAdIcon:()Lcom/facebook/ads/NativeAd$Image;
        //    73: invokevirtual   com/facebook/ads/NativeAd$Image.getUrl:()Ljava/lang/String;
        //    76: astore          8
        //    78: aload_1        
        //    79: invokevirtual   com/facebook/ads/NativeAd.getAdIcon:()Lcom/facebook/ads/NativeAd$Image;
        //    82: invokevirtual   com/facebook/ads/NativeAd$Image.getHeight:()I
        //    85: istore          6
        //    87: aload_1        
        //    88: invokevirtual   com/facebook/ads/NativeAd.getAdIcon:()Lcom/facebook/ads/NativeAd$Image;
        //    91: invokevirtual   com/facebook/ads/NativeAd$Image.getWidth:()I
        //    94: istore          7
        //    96: ldc             "com.admarvel.android.nativeads.AdMarvelNativeImage"
        //    98: invokestatic    java/lang/Class.forName:(Ljava/lang/String;)Ljava/lang/Class;
        //   101: astore          10
        //   103: aload           10
        //   105: invokevirtual   java/lang/Class.newInstance:()Ljava/lang/Object;
        //   108: astore          11
        //   110: iconst_1       
        //   111: anewarray       Ljava/lang/Class;
        //   114: astore          12
        //   116: aload           12
        //   118: iconst_0       
        //   119: getstatic       java/lang/Integer.TYPE:Ljava/lang/Class;
        //   122: aastore        
        //   123: aload           8
        //   125: ifnull          159
        //   128: aload           10
        //   130: ldc             "setImageUrl"
        //   132: iconst_1       
        //   133: anewarray       Ljava/lang/Class;
        //   136: dup            
        //   137: iconst_0       
        //   138: ldc             Ljava/lang/String;.class
        //   140: aastore        
        //   141: invokevirtual   java/lang/Class.getMethod:(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
        //   144: aload           11
        //   146: iconst_1       
        //   147: anewarray       Ljava/lang/Object;
        //   150: dup            
        //   151: iconst_0       
        //   152: aload           8
        //   154: aastore        
        //   155: invokevirtual   java/lang/reflect/Method.invoke:(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
        //   158: pop            
        //   159: iload           6
        //   161: ifle            191
        //   164: aload           10
        //   166: ldc             "setHeight"
        //   168: aload           12
        //   170: invokevirtual   java/lang/Class.getMethod:(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
        //   173: aload           11
        //   175: iconst_1       
        //   176: anewarray       Ljava/lang/Object;
        //   179: dup            
        //   180: iconst_0       
        //   181: iload           6
        //   183: invokestatic    java/lang/Integer.valueOf:(I)Ljava/lang/Integer;
        //   186: aastore        
        //   187: invokevirtual   java/lang/reflect/Method.invoke:(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
        //   190: pop            
        //   191: iload           7
        //   193: ifle            223
        //   196: aload           10
        //   198: ldc             "setWidth"
        //   200: aload           12
        //   202: invokevirtual   java/lang/Class.getMethod:(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
        //   205: aload           11
        //   207: iconst_1       
        //   208: anewarray       Ljava/lang/Object;
        //   211: dup            
        //   212: iconst_0       
        //   213: iload           7
        //   215: invokestatic    java/lang/Integer.valueOf:(I)Ljava/lang/Integer;
        //   218: aastore        
        //   219: invokevirtual   java/lang/reflect/Method.invoke:(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
        //   222: pop            
        //   223: aload           9
        //   225: ldc             "icon"
        //   227: aload           11
        //   229: invokevirtual   java/util/HashMap.put:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   232: pop            
        //   233: aload_1        
        //   234: invokevirtual   com/facebook/ads/NativeAd.getAdCoverImage:()Lcom/facebook/ads/NativeAd$Image;
        //   237: astore          8
        //   239: aload           8
        //   241: ifnull          415
        //   244: aload_1        
        //   245: invokevirtual   com/facebook/ads/NativeAd.getAdCoverImage:()Lcom/facebook/ads/NativeAd$Image;
        //   248: invokevirtual   com/facebook/ads/NativeAd$Image.getUrl:()Ljava/lang/String;
        //   251: astore          8
        //   253: aload_1        
        //   254: invokevirtual   com/facebook/ads/NativeAd.getAdCoverImage:()Lcom/facebook/ads/NativeAd$Image;
        //   257: invokevirtual   com/facebook/ads/NativeAd$Image.getHeight:()I
        //   260: istore          6
        //   262: aload_1        
        //   263: invokevirtual   com/facebook/ads/NativeAd.getAdCoverImage:()Lcom/facebook/ads/NativeAd$Image;
        //   266: invokevirtual   com/facebook/ads/NativeAd$Image.getWidth:()I
        //   269: istore          7
        //   271: ldc             "com.admarvel.android.nativeads.AdMarvelNativeImage"
        //   273: invokestatic    java/lang/Class.forName:(Ljava/lang/String;)Ljava/lang/Class;
        //   276: astore          10
        //   278: aload           10
        //   280: invokevirtual   java/lang/Class.newInstance:()Ljava/lang/Object;
        //   283: astore          11
        //   285: iconst_1       
        //   286: anewarray       Ljava/lang/Class;
        //   289: astore          12
        //   291: aload           12
        //   293: iconst_0       
        //   294: getstatic       java/lang/Integer.TYPE:Ljava/lang/Class;
        //   297: aastore        
        //   298: aload           8
        //   300: ifnull          334
        //   303: aload           10
        //   305: ldc             "setImageUrl"
        //   307: iconst_1       
        //   308: anewarray       Ljava/lang/Class;
        //   311: dup            
        //   312: iconst_0       
        //   313: ldc             Ljava/lang/String;.class
        //   315: aastore        
        //   316: invokevirtual   java/lang/Class.getMethod:(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
        //   319: aload           11
        //   321: iconst_1       
        //   322: anewarray       Ljava/lang/Object;
        //   325: dup            
        //   326: iconst_0       
        //   327: aload           8
        //   329: aastore        
        //   330: invokevirtual   java/lang/reflect/Method.invoke:(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
        //   333: pop            
        //   334: iload           6
        //   336: ifle            366
        //   339: aload           10
        //   341: ldc             "setHeight"
        //   343: aload           12
        //   345: invokevirtual   java/lang/Class.getMethod:(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
        //   348: aload           11
        //   350: iconst_1       
        //   351: anewarray       Ljava/lang/Object;
        //   354: dup            
        //   355: iconst_0       
        //   356: iload           6
        //   358: invokestatic    java/lang/Integer.valueOf:(I)Ljava/lang/Integer;
        //   361: aastore        
        //   362: invokevirtual   java/lang/reflect/Method.invoke:(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
        //   365: pop            
        //   366: iload           7
        //   368: ifle            398
        //   371: aload           10
        //   373: ldc             "setWidth"
        //   375: aload           12
        //   377: invokevirtual   java/lang/Class.getMethod:(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
        //   380: aload           11
        //   382: iconst_1       
        //   383: anewarray       Ljava/lang/Object;
        //   386: dup            
        //   387: iconst_0       
        //   388: iload           7
        //   390: invokestatic    java/lang/Integer.valueOf:(I)Ljava/lang/Integer;
        //   393: aastore        
        //   394: invokevirtual   java/lang/reflect/Method.invoke:(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
        //   397: pop            
        //   398: aload           9
        //   400: ldc             "campaignImage"
        //   402: iconst_1       
        //   403: anewarray       Ljava/lang/Object;
        //   406: dup            
        //   407: iconst_0       
        //   408: aload           11
        //   410: aastore        
        //   411: invokevirtual   java/util/HashMap.put:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   414: pop            
        //   415: aload_1        
        //   416: invokevirtual   com/facebook/ads/NativeAd.getAdStarRating:()Lcom/facebook/ads/NativeAd$Rating;
        //   419: astore          8
        //   421: aload           8
        //   423: ifnull          528
        //   426: aload           8
        //   428: invokevirtual   com/facebook/ads/NativeAd$Rating.getScale:()D
        //   431: dstore_2       
        //   432: aload           8
        //   434: invokevirtual   com/facebook/ads/NativeAd$Rating.getValue:()D
        //   437: dstore          4
        //   439: ldc             "com.admarvel.android.nativeads.AdMarvelNativeRating"
        //   441: invokestatic    java/lang/Class.forName:(Ljava/lang/String;)Ljava/lang/Class;
        //   444: astore          8
        //   446: aload           8
        //   448: invokevirtual   java/lang/Class.newInstance:()Ljava/lang/Object;
        //   451: astore          10
        //   453: iconst_1       
        //   454: anewarray       Ljava/lang/Class;
        //   457: astore          11
        //   459: aload           11
        //   461: iconst_0       
        //   462: ldc             Ljava/lang/String;.class
        //   464: aastore        
        //   465: aload           8
        //   467: ldc             "setBase"
        //   469: aload           11
        //   471: invokevirtual   java/lang/Class.getMethod:(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
        //   474: aload           10
        //   476: iconst_1       
        //   477: anewarray       Ljava/lang/Object;
        //   480: dup            
        //   481: iconst_0       
        //   482: dload_2        
        //   483: invokestatic    java/lang/String.valueOf:(D)Ljava/lang/String;
        //   486: aastore        
        //   487: invokevirtual   java/lang/reflect/Method.invoke:(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
        //   490: pop            
        //   491: aload           8
        //   493: ldc             "setValue"
        //   495: aload           11
        //   497: invokevirtual   java/lang/Class.getMethod:(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
        //   500: aload           10
        //   502: iconst_1       
        //   503: anewarray       Ljava/lang/Object;
        //   506: dup            
        //   507: iconst_0       
        //   508: dload           4
        //   510: invokestatic    java/lang/String.valueOf:(D)Ljava/lang/String;
        //   513: aastore        
        //   514: invokevirtual   java/lang/reflect/Method.invoke:(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
        //   517: pop            
        //   518: aload           9
        //   520: ldc             "rating"
        //   522: aload           10
        //   524: invokevirtual   java/util/HashMap.put:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   527: pop            
        //   528: aload_1        
        //   529: invokevirtual   com/facebook/ads/NativeAd.getAdCallToAction:()Ljava/lang/String;
        //   532: astore          8
        //   534: aload           8
        //   536: ifnull          594
        //   539: ldc             "com.admarvel.android.nativeads.AdMarvelNativeCta"
        //   541: invokestatic    java/lang/Class.forName:(Ljava/lang/String;)Ljava/lang/Class;
        //   544: astore          10
        //   546: aload           10
        //   548: invokevirtual   java/lang/Class.newInstance:()Ljava/lang/Object;
        //   551: astore          11
        //   553: aload           10
        //   555: ldc             "setTitle"
        //   557: iconst_1       
        //   558: anewarray       Ljava/lang/Class;
        //   561: dup            
        //   562: iconst_0       
        //   563: ldc             Ljava/lang/String;.class
        //   565: aastore        
        //   566: invokevirtual   java/lang/Class.getMethod:(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
        //   569: aload           11
        //   571: iconst_1       
        //   572: anewarray       Ljava/lang/Object;
        //   575: dup            
        //   576: iconst_0       
        //   577: aload           8
        //   579: aastore        
        //   580: invokevirtual   java/lang/reflect/Method.invoke:(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
        //   583: pop            
        //   584: aload           9
        //   586: ldc             "cta"
        //   588: aload           11
        //   590: invokevirtual   java/util/HashMap.put:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   593: pop            
        //   594: aload_1        
        //   595: invokevirtual   com/facebook/ads/NativeAd.getAdSocialContext:()Ljava/lang/String;
        //   598: astore          8
        //   600: aload           8
        //   602: ifnull          706
        //   605: ldc             "com.admarvel.android.nativeads.AdMarvelNativeMetadata"
        //   607: invokestatic    java/lang/Class.forName:(Ljava/lang/String;)Ljava/lang/Class;
        //   610: astore          10
        //   612: aload           10
        //   614: invokevirtual   java/lang/Class.newInstance:()Ljava/lang/Object;
        //   617: astore_1       
        //   618: iconst_1       
        //   619: anewarray       Ljava/lang/Class;
        //   622: astore          11
        //   624: aload           11
        //   626: iconst_0       
        //   627: ldc             Ljava/lang/String;.class
        //   629: aastore        
        //   630: aload           10
        //   632: ldc             "setType"
        //   634: aload           11
        //   636: invokevirtual   java/lang/Class.getMethod:(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
        //   639: aload_1        
        //   640: iconst_1       
        //   641: anewarray       Ljava/lang/Object;
        //   644: dup            
        //   645: iconst_0       
        //   646: ldc             "string"
        //   648: aastore        
        //   649: invokevirtual   java/lang/reflect/Method.invoke:(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
        //   652: pop            
        //   653: aload           10
        //   655: ldc             "setValue"
        //   657: aload           11
        //   659: invokevirtual   java/lang/Class.getMethod:(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
        //   662: aload_1        
        //   663: iconst_1       
        //   664: anewarray       Ljava/lang/Object;
        //   667: dup            
        //   668: iconst_0       
        //   669: aload           8
        //   671: aastore        
        //   672: invokevirtual   java/lang/reflect/Method.invoke:(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
        //   675: pop            
        //   676: new             Ljava/util/HashMap;
        //   679: dup            
        //   680: invokespecial   java/util/HashMap.<init>:()V
        //   683: astore          8
        //   685: aload           8
        //   687: ldc             "availabilityString"
        //   689: aload_1        
        //   690: invokeinterface java/util/Map.put:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   695: pop            
        //   696: aload           9
        //   698: ldc             "metadatas"
        //   700: aload           8
        //   702: invokevirtual   java/util/HashMap.put:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   705: pop            
        //   706: ldc             "com.admarvel.android.nativeads.AdMarvelNativeMetadata"
        //   708: invokestatic    java/lang/Class.forName:(Ljava/lang/String;)Ljava/lang/Class;
        //   711: astore          11
        //   713: aload           11
        //   715: invokevirtual   java/lang/Class.newInstance:()Ljava/lang/Object;
        //   718: astore          12
        //   720: iconst_1       
        //   721: anewarray       Ljava/lang/Class;
        //   724: astore_1       
        //   725: aload_1        
        //   726: iconst_0       
        //   727: ldc             Ljava/lang/String;.class
        //   729: aastore        
        //   730: aload           11
        //   732: ldc             "setType"
        //   734: aload_1        
        //   735: invokevirtual   java/lang/Class.getMethod:(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
        //   738: astore          10
        //   740: aload           10
        //   742: aload           12
        //   744: iconst_1       
        //   745: anewarray       Ljava/lang/Object;
        //   748: dup            
        //   749: iconst_0       
        //   750: ldc             "string"
        //   752: aastore        
        //   753: invokevirtual   java/lang/reflect/Method.invoke:(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
        //   756: pop            
        //   757: aload           11
        //   759: ldc             "setValue"
        //   761: aload_1        
        //   762: invokevirtual   java/lang/Class.getMethod:(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
        //   765: astore          13
        //   767: aload           13
        //   769: aload           12
        //   771: iconst_1       
        //   772: anewarray       Ljava/lang/Object;
        //   775: dup            
        //   776: iconst_0       
        //   777: ldc             "true"
        //   779: aastore        
        //   780: invokevirtual   java/lang/reflect/Method.invoke:(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
        //   783: pop            
        //   784: aload           9
        //   786: ldc             "metadatas"
        //   788: invokevirtual   java/util/HashMap.get:(Ljava/lang/Object;)Ljava/lang/Object;
        //   791: checkcast       Ljava/util/Map;
        //   794: astore          8
        //   796: aload           8
        //   798: astore_1       
        //   799: aload           8
        //   801: ifnonnull       812
        //   804: new             Ljava/util/HashMap;
        //   807: dup            
        //   808: invokespecial   java/util/HashMap.<init>:()V
        //   811: astore_1       
        //   812: aload_1        
        //   813: ldc             "click_clientonly"
        //   815: aload           12
        //   817: invokeinterface java/util/Map.put:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   822: pop            
        //   823: aload_1        
        //   824: ldc             "impression_clientonly"
        //   826: aload           12
        //   828: invokeinterface java/util/Map.put:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   833: pop            
        //   834: aload           11
        //   836: invokevirtual   java/lang/Class.newInstance:()Ljava/lang/Object;
        //   839: astore          8
        //   841: aload           10
        //   843: aload           8
        //   845: iconst_1       
        //   846: anewarray       Ljava/lang/Object;
        //   849: dup            
        //   850: iconst_0       
        //   851: ldc             "string"
        //   853: aastore        
        //   854: invokevirtual   java/lang/reflect/Method.invoke:(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
        //   857: pop            
        //   858: aload           13
        //   860: aload           8
        //   862: iconst_1       
        //   863: anewarray       Ljava/lang/Object;
        //   866: dup            
        //   867: iconst_0       
        //   868: ldc             "3600000"
        //   870: aastore        
        //   871: invokevirtual   java/lang/reflect/Method.invoke:(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
        //   874: pop            
        //   875: aload_1        
        //   876: ldc             "ttl_in_ms"
        //   878: aload           8
        //   880: invokeinterface java/util/Map.put:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   885: pop            
        //   886: aload           9
        //   888: ldc             "metadatas"
        //   890: aload_1        
        //   891: invokevirtual   java/util/HashMap.put:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   894: pop            
        //   895: aload_0        
        //   896: getfield        com/admarvel/android/admarvelfacebookadapter/InternalFacebookNativeListener.adMarvelNativeAd:Ljava/lang/Object;
        //   899: invokevirtual   java/lang/Object.getClass:()Ljava/lang/Class;
        //   902: ldc             "updateNativeAdFromAdapter"
        //   904: iconst_1       
        //   905: anewarray       Ljava/lang/Class;
        //   908: dup            
        //   909: iconst_0       
        //   910: ldc             Ljava/util/Map;.class
        //   912: aastore        
        //   913: invokevirtual   java/lang/Class.getMethod:(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
        //   916: aload_0        
        //   917: getfield        com/admarvel/android/admarvelfacebookadapter/InternalFacebookNativeListener.adMarvelNativeAd:Ljava/lang/Object;
        //   920: iconst_1       
        //   921: anewarray       Ljava/lang/Object;
        //   924: dup            
        //   925: iconst_0       
        //   926: aload           9
        //   928: aastore        
        //   929: invokevirtual   java/lang/reflect/Method.invoke:(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
        //   932: pop            
        //   933: goto            991
        //   936: astore          8
        //   938: aload           8
        //   940: invokevirtual   java/lang/Exception.printStackTrace:()V
        //   943: goto            233
        //   946: astore_1       
        //   947: aload_1        
        //   948: invokevirtual   java/lang/Exception.printStackTrace:()V
        //   951: iconst_0       
        //   952: ireturn        
        //   953: astore          8
        //   955: aload           8
        //   957: invokevirtual   java/lang/Exception.printStackTrace:()V
        //   960: goto            415
        //   963: astore          8
        //   965: ldc             "Error in setting Rating fields"
        //   967: invokestatic    com/admarvel/android/util/Logging.log:(Ljava/lang/String;)V
        //   970: goto            528
        //   973: astore          8
        //   975: aload           8
        //   977: invokevirtual   java/lang/Exception.printStackTrace:()V
        //   980: goto            594
        //   983: astore_1       
        //   984: aload_1        
        //   985: invokevirtual   java/lang/Exception.printStackTrace:()V
        //   988: goto            706
        //   991: iconst_1       
        //   992: ireturn        
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                 
        //  -----  -----  -----  -----  ---------------------
        //  0      16     946    953    Ljava/lang/Exception;
        //  20     39     946    953    Ljava/lang/Exception;
        //  39     58     946    953    Ljava/lang/Exception;
        //  58     64     946    953    Ljava/lang/Exception;
        //  69     123    936    946    Ljava/lang/Exception;
        //  128    159    936    946    Ljava/lang/Exception;
        //  164    191    936    946    Ljava/lang/Exception;
        //  196    223    936    946    Ljava/lang/Exception;
        //  223    233    936    946    Ljava/lang/Exception;
        //  233    239    946    953    Ljava/lang/Exception;
        //  244    298    953    963    Ljava/lang/Exception;
        //  303    334    953    963    Ljava/lang/Exception;
        //  339    366    953    963    Ljava/lang/Exception;
        //  371    398    953    963    Ljava/lang/Exception;
        //  398    415    953    963    Ljava/lang/Exception;
        //  415    421    946    953    Ljava/lang/Exception;
        //  426    459    963    973    Ljava/lang/Exception;
        //  465    528    963    973    Ljava/lang/Exception;
        //  528    534    946    953    Ljava/lang/Exception;
        //  539    594    973    983    Ljava/lang/Exception;
        //  594    600    946    953    Ljava/lang/Exception;
        //  605    624    983    991    Ljava/lang/Exception;
        //  630    706    983    991    Ljava/lang/Exception;
        //  706    725    946    953    Ljava/lang/Exception;
        //  730    796    946    953    Ljava/lang/Exception;
        //  804    812    946    953    Ljava/lang/Exception;
        //  812    933    946    953    Ljava/lang/Exception;
        //  938    943    946    953    Ljava/lang/Exception;
        //  955    960    946    953    Ljava/lang/Exception;
        //  965    970    946    953    Ljava/lang/Exception;
        //  975    980    946    953    Ljava/lang/Exception;
        //  984    988    946    953    Ljava/lang/Exception;
        // 
        // The error that occurred was:
        // 
        // java.lang.IndexOutOfBoundsException: Index: 503, Size: 503
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
    
    @Override
    public void onAdClicked(final Ad ad) {
        if (this.adMarvelNativeAdAdapterListener != null) {
            this.adMarvelNativeAdAdapterListener.onClickAd("");
            Logging.log("Facebook SDK : onAdClicked");
            return;
        }
        Logging.log("Facebook SDK : onAdClicked .. No listener Found");
    }
    
    @Override
    public void onAdLoaded(final Ad ad) {
        if (ad != null && ad instanceof NativeAd) {
            final boolean updateAdMarvelNatvieAd = this.updateAdMarvelNatvieAd((NativeAd)ad);
            if (updateAdMarvelNatvieAd && this.adMarvelNativeAdAdapterListener != null) {
                this.adMarvelNativeAdAdapterListener.onReceiveNativeAd(this.adMarvelNativeAd);
                Logging.log("Facebook SDK : onAdLoaded");
            }
            else {
                if (!updateAdMarvelNatvieAd && this.adMarvelNativeAdAdapterListener != null) {
                    this.adMarvelNativeAdAdapterListener.onFailedToReceiveAd(205, AdMarvelUtils.getErrorReason(205));
                    Logging.log("Facebook SDK : onError");
                    return;
                }
                Logging.log("Facebook SDK : onAdLoaded No listenr found");
            }
        }
    }
    
    @Override
    public void onError(final Ad ad, final AdError adError) {
        if (this.adMarvelNativeAdAdapterListener != null) {
            this.adMarvelNativeAdAdapterListener.onFailedToReceiveAd(205, AdMarvelUtils.getErrorReason(205));
            Logging.log("Facebook SDK : onError");
            return;
        }
        Logging.log("Facebook SDK : onError .. No listener Found");
    }
}
