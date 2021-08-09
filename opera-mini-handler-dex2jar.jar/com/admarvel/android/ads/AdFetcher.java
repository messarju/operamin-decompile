// 
// Decompiled by Procyon v0.6-prerelease
// 

package com.admarvel.android.ads;

import com.admarvel.android.util.OptionalUtils;
import com.admarvel.android.util.Logging;
import android.util.Log;
import com.admarvel.android.util.j;
import java.util.HashMap;
import android.os.Handler;
import com.admarvel.android.util.a.b;
import java.util.Map;
import android.content.Context;
import org.json.JSONObject;

public class AdFetcher
{
    private static final String ADMARVEL_ENDPOINT = "http://ads.admarvel.com/fam/androidGetAd.php";
    public static final String SDK_SUPPORTED;
    public static String lastAdRequestPostString;
    private String googleAdID;
    private JSONObject requestJson;
    private int userOptOutPreference;
    
    static {
        SDK_SUPPORTED = Version.getSDKSupported();
    }
    
    public AdFetcher() {
        this.googleAdID = "VALUE_NOT_DEFINED";
        this.userOptOutPreference = Integer.MIN_VALUE;
    }
    
    private String buildParamString(final AdFetcher$Adtype p0, final Context p1, final int p2, final String p3, final Map p4, final String p5, final String p6, final int p7, final String p8, final boolean p9, final boolean p10, final boolean p11) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     3: dup            
        //     4: invokespecial   java/lang/StringBuilder.<init>:()V
        //     7: astore          14
        //     9: aload           5
        //    11: ldc             "||"
        //    13: invokestatic    com/admarvel/android/ads/r.a:(Ljava/util/Map;Ljava/lang/String;)Ljava/lang/String;
        //    16: astore          15
        //    18: aload           14
        //    20: ldc             "site_id"
        //    22: aload           7
        //    24: invokestatic    com/admarvel/android/ads/r.a:(Ljava/lang/StringBuilder;Ljava/lang/String;Ljava/lang/String;)V
        //    27: aload           14
        //    29: ldc             "partner_id"
        //    31: aload           6
        //    33: invokestatic    com/admarvel/android/ads/r.a:(Ljava/lang/StringBuilder;Ljava/lang/String;Ljava/lang/String;)V
        //    36: aload           14
        //    38: ldc             "timeout"
        //    40: sipush          5000
        //    43: invokestatic    java/lang/String.valueOf:(I)Ljava/lang/String;
        //    46: invokestatic    com/admarvel/android/ads/r.a:(Ljava/lang/StringBuilder;Ljava/lang/String;Ljava/lang/String;)V
        //    49: aload           14
        //    51: ldc             "version"
        //    53: ldc             "1.5"
        //    55: invokestatic    com/admarvel/android/ads/r.a:(Ljava/lang/StringBuilder;Ljava/lang/String;Ljava/lang/String;)V
        //    58: aload           14
        //    60: ldc             "language"
        //    62: ldc             "java"
        //    64: invokestatic    com/admarvel/android/ads/r.a:(Ljava/lang/StringBuilder;Ljava/lang/String;Ljava/lang/String;)V
        //    67: aload           14
        //    69: ldc             "format"
        //    71: ldc             "android"
        //    73: invokestatic    com/admarvel/android/ads/r.a:(Ljava/lang/StringBuilder;Ljava/lang/String;Ljava/lang/String;)V
        //    76: aload           14
        //    78: ldc             "sdk_version"
        //    80: ldc             "2.4.6"
        //    82: invokestatic    com/admarvel/android/ads/r.a:(Ljava/lang/StringBuilder;Ljava/lang/String;Ljava/lang/String;)V
        //    85: aload           14
        //    87: ldc             "sdk_version_date"
        //    89: ldc             "2014-11-06"
        //    91: invokestatic    com/admarvel/android/ads/r.a:(Ljava/lang/StringBuilder;Ljava/lang/String;Ljava/lang/String;)V
        //    94: iload           12
        //    96: ifeq            761
        //    99: aload           14
        //   101: ldc             "sdk_supported"
        //   103: ldc             ""
        //   105: invokestatic    com/admarvel/android/ads/r.a:(Ljava/lang/StringBuilder;Ljava/lang/String;Ljava/lang/String;)V
        //   108: aload           14
        //   110: ldc             "device_model"
        //   112: getstatic       android/os/Build.MODEL:Ljava/lang/String;
        //   115: invokestatic    com/admarvel/android/ads/r.a:(Ljava/lang/StringBuilder;Ljava/lang/String;Ljava/lang/String;)V
        //   118: aload           14
        //   120: ldc             "device_name"
        //   122: getstatic       android/os/Build.ID:Ljava/lang/String;
        //   125: invokestatic    com/admarvel/android/ads/r.a:(Ljava/lang/StringBuilder;Ljava/lang/String;Ljava/lang/String;)V
        //   128: aload           14
        //   130: ldc             "device_systemversion"
        //   132: getstatic       android/os/Build$VERSION.RELEASE:Ljava/lang/String;
        //   135: invokestatic    com/admarvel/android/ads/r.a:(Ljava/lang/StringBuilder;Ljava/lang/String;Ljava/lang/String;)V
        //   138: aload           14
        //   140: ldc             "device_api_version"
        //   142: invokestatic    com/admarvel/android/ads/Version.getAndroidSDKVersion:()I
        //   145: invokestatic    java/lang/String.valueOf:(I)Ljava/lang/String;
        //   148: invokestatic    com/admarvel/android/ads/r.a:(Ljava/lang/StringBuilder;Ljava/lang/String;Ljava/lang/String;)V
        //   151: aload           14
        //   153: ldc             "retrynum"
        //   155: iload           8
        //   157: invokestatic    java/lang/String.valueOf:(I)Ljava/lang/String;
        //   160: invokestatic    com/admarvel/android/ads/r.a:(Ljava/lang/StringBuilder;Ljava/lang/String;Ljava/lang/String;)V
        //   163: aload           14
        //   165: ldc             "excluded_banners"
        //   167: aload           9
        //   169: invokestatic    com/admarvel/android/ads/r.a:(Ljava/lang/StringBuilder;Ljava/lang/String;Ljava/lang/String;)V
        //   172: iload_3        
        //   173: iconst_2       
        //   174: if_icmpne       784
        //   177: aload           14
        //   179: ldc             "device_orientation"
        //   181: ldc             "landscape"
        //   183: invokestatic    com/admarvel/android/ads/r.a:(Ljava/lang/StringBuilder;Ljava/lang/String;Ljava/lang/String;)V
        //   186: aload           14
        //   188: ldc             "device_connectivity"
        //   190: aload           4
        //   192: invokestatic    com/admarvel/android/ads/r.a:(Ljava/lang/StringBuilder;Ljava/lang/String;Ljava/lang/String;)V
        //   195: aload_2        
        //   196: invokestatic    com/admarvel/android/ads/r.g:(Landroid/content/Context;)I
        //   199: istore          8
        //   201: iload           8
        //   203: ifle            230
        //   206: aload           14
        //   208: ldc             "resolution_width"
        //   210: iload           8
        //   212: invokestatic    java/lang/String.valueOf:(I)Ljava/lang/String;
        //   215: invokestatic    com/admarvel/android/ads/r.a:(Ljava/lang/StringBuilder;Ljava/lang/String;Ljava/lang/String;)V
        //   218: aload           14
        //   220: ldc             "max_image_width"
        //   222: iload           8
        //   224: invokestatic    java/lang/String.valueOf:(I)Ljava/lang/String;
        //   227: invokestatic    com/admarvel/android/ads/r.a:(Ljava/lang/StringBuilder;Ljava/lang/String;Ljava/lang/String;)V
        //   230: aload_2        
        //   231: invokestatic    com/admarvel/android/ads/r.h:(Landroid/content/Context;)I
        //   234: istore          13
        //   236: iload           13
        //   238: ifle            265
        //   241: aload           14
        //   243: ldc             "resolution_height"
        //   245: iload           13
        //   247: invokestatic    java/lang/String.valueOf:(I)Ljava/lang/String;
        //   250: invokestatic    com/admarvel/android/ads/r.a:(Ljava/lang/StringBuilder;Ljava/lang/String;Ljava/lang/String;)V
        //   253: aload           14
        //   255: ldc             "max_image_height"
        //   257: iload           13
        //   259: invokestatic    java/lang/String.valueOf:(I)Ljava/lang/String;
        //   262: invokestatic    com/admarvel/android/ads/r.a:(Ljava/lang/StringBuilder;Ljava/lang/String;Ljava/lang/String;)V
        //   265: aload           14
        //   267: ldc             "device_density"
        //   269: new             Ljava/lang/StringBuilder;
        //   272: dup            
        //   273: invokespecial   java/lang/StringBuilder.<init>:()V
        //   276: aload_2        
        //   277: invokestatic    com/admarvel/android/ads/r.i:(Landroid/content/Context;)F
        //   280: invokevirtual   java/lang/StringBuilder.append:(F)Ljava/lang/StringBuilder;
        //   283: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   286: invokestatic    com/admarvel/android/ads/r.a:(Ljava/lang/StringBuilder;Ljava/lang/String;Ljava/lang/String;)V
        //   289: aload           14
        //   291: ldc             "device_os"
        //   293: ldc             "Android"
        //   295: invokestatic    com/admarvel/android/ads/r.a:(Ljava/lang/StringBuilder;Ljava/lang/String;Ljava/lang/String;)V
        //   298: aload_1        
        //   299: getstatic       com/admarvel/android/ads/AdFetcher$Adtype.BANNER:Lcom/admarvel/android/ads/AdFetcher$Adtype;
        //   302: invokevirtual   com/admarvel/android/ads/AdFetcher$Adtype.equals:(Ljava/lang/Object;)Z
        //   305: ifeq            797
        //   308: aload           14
        //   310: ldc             "adtype"
        //   312: ldc             "banner"
        //   314: invokestatic    com/admarvel/android/ads/r.a:(Ljava/lang/StringBuilder;Ljava/lang/String;Ljava/lang/String;)V
        //   317: iload_3        
        //   318: iconst_2       
        //   319: if_icmpne       843
        //   322: iload           13
        //   324: invokestatic    java/lang/String.valueOf:(I)Ljava/lang/String;
        //   327: astore          4
        //   329: iload_3        
        //   330: iconst_2       
        //   331: if_icmpne       853
        //   334: iload           8
        //   336: invokestatic    java/lang/String.valueOf:(I)Ljava/lang/String;
        //   339: astore          6
        //   341: new             Lcom/admarvel/android/ads/r;
        //   344: dup            
        //   345: aload_2        
        //   346: invokespecial   com/admarvel/android/ads/r.<init>:(Landroid/content/Context;)V
        //   349: astore          7
        //   351: aload           14
        //   353: ldc             "device_details"
        //   355: new             Ljava/lang/StringBuilder;
        //   358: dup            
        //   359: ldc             "brand:"
        //   361: invokespecial   java/lang/StringBuilder.<init>:(Ljava/lang/String;)V
        //   364: getstatic       android/os/Build.BRAND:Ljava/lang/String;
        //   367: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   370: ldc             ",model:"
        //   372: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   375: getstatic       android/os/Build.MODEL:Ljava/lang/String;
        //   378: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   381: ldc             ",width:"
        //   383: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   386: aload           4
        //   388: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   391: ldc             ",height:"
        //   393: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   396: aload           6
        //   398: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   401: ldc             ",os:"
        //   403: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   406: getstatic       android/os/Build$VERSION.RELEASE:Ljava/lang/String;
        //   409: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   412: ldc             ",ua:"
        //   414: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   417: aload           7
        //   419: invokevirtual   com/admarvel/android/ads/r.a:()Ljava/lang/String;
        //   422: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   425: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   428: invokestatic    com/admarvel/android/ads/r.a:(Ljava/lang/StringBuilder;Ljava/lang/String;Ljava/lang/String;)V
        //   431: aload_2        
        //   432: ifnull          938
        //   435: aload_2        
        //   436: invokevirtual   android/content/Context.getPackageName:()Ljava/lang/String;
        //   439: astore          4
        //   441: aload           4
        //   443: ifnull          463
        //   446: aload           4
        //   448: invokevirtual   java/lang/String.length:()I
        //   451: ifle            463
        //   454: aload           14
        //   456: ldc             "app_identifier"
        //   458: aload           4
        //   460: invokestatic    com/admarvel/android/ads/r.a:(Ljava/lang/StringBuilder;Ljava/lang/String;Ljava/lang/String;)V
        //   463: aload_2        
        //   464: instanceof      Landroid/app/Activity;
        //   467: ifeq            607
        //   470: aload_2        
        //   471: checkcast       Landroid/app/Activity;
        //   474: astore          4
        //   476: aload           4
        //   478: ifnull          607
        //   481: aload           4
        //   483: invokevirtual   android/app/Activity.getWindow:()Landroid/view/Window;
        //   486: ldc             16908290
        //   488: invokevirtual   android/view/Window.findViewById:(I)Landroid/view/View;
        //   491: checkcast       Landroid/view/ViewGroup;
        //   494: astore          7
        //   496: iconst_0       
        //   497: invokestatic    java/lang/Boolean.valueOf:(Z)Ljava/lang/Boolean;
        //   500: astore          6
        //   502: aload           6
        //   504: astore          4
        //   506: invokestatic    com/admarvel/android/ads/Version.getAndroidSDKVersion:()I
        //   509: bipush          11
        //   511: if_icmplt       595
        //   514: aload_1        
        //   515: getstatic       com/admarvel/android/ads/AdFetcher$Adtype.BANNER:Lcom/admarvel/android/ads/AdFetcher$Adtype;
        //   518: invokevirtual   com/admarvel/android/ads/AdFetcher$Adtype.equals:(Ljava/lang/Object;)Z
        //   521: istore          11
        //   523: iload           11
        //   525: ifeq            873
        //   528: ldc             Landroid/view/ViewGroup;.class
        //   530: ldc             "isHardwareAccelerated"
        //   532: iconst_0       
        //   533: anewarray       Ljava/lang/Class;
        //   536: invokevirtual   java/lang/Class.getMethod:(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
        //   539: aload           7
        //   541: aconst_null    
        //   542: invokevirtual   java/lang/reflect/Method.invoke:(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
        //   545: astore_1       
        //   546: aload_1        
        //   547: ifnull          932
        //   550: aload_1        
        //   551: instanceof      Ljava/lang/Boolean;
        //   554: ifeq            932
        //   557: aload_1        
        //   558: checkcast       Ljava/lang/Boolean;
        //   561: astore_1       
        //   562: aload_1        
        //   563: astore          4
        //   565: aload_1        
        //   566: invokevirtual   java/lang/Boolean.booleanValue:()Z
        //   569: ifeq            595
        //   572: aload_1        
        //   573: astore          4
        //   575: iload           10
        //   577: ifeq            595
        //   580: aload_1        
        //   581: astore          4
        //   583: invokestatic    com/admarvel/android/ads/r.c:()Z
        //   586: ifeq            595
        //   589: iconst_0       
        //   590: invokestatic    java/lang/Boolean.valueOf:(Z)Ljava/lang/Boolean;
        //   593: astore          4
        //   595: aload           14
        //   597: ldc             "hardware_accelerated"
        //   599: aload           4
        //   601: invokevirtual   java/lang/Boolean.toString:()Ljava/lang/String;
        //   604: invokestatic    com/admarvel/android/ads/r.a:(Ljava/lang/StringBuilder;Ljava/lang/String;Ljava/lang/String;)V
        //   607: aload           5
        //   609: ldc             "ANDROID_ADVERTISING_ID"
        //   611: invokeinterface java/util/Map.get:(Ljava/lang/Object;)Ljava/lang/Object;
        //   616: checkcast       Ljava/lang/String;
        //   619: astore_1       
        //   620: aload_1        
        //   621: ifnull          640
        //   624: aload_1        
        //   625: invokevirtual   java/lang/String.length:()I
        //   628: ifle            640
        //   631: aload           14
        //   633: ldc_w           "android_advertising_id"
        //   636: aload_1        
        //   637: invokestatic    com/admarvel/android/ads/r.a:(Ljava/lang/StringBuilder;Ljava/lang/String;Ljava/lang/String;)V
        //   640: aload_2        
        //   641: invokestatic    com/admarvel/android/ads/AdMarvelUtils.isTabletDevice:(Landroid/content/Context;)Z
        //   644: ifne            896
        //   647: aload           14
        //   649: ldc_w           "auto-scaling"
        //   652: ldc_w           "true"
        //   655: invokestatic    com/admarvel/android/ads/r.a:(Ljava/lang/StringBuilder;Ljava/lang/String;Ljava/lang/String;)V
        //   658: aload           14
        //   660: ldc_w           "is_tablet"
        //   663: ldc_w           "false"
        //   666: invokestatic    com/admarvel/android/ads/r.a:(Ljava/lang/StringBuilder;Ljava/lang/String;Ljava/lang/String;)V
        //   669: aload_2        
        //   670: invokestatic    com/admarvel/android/ads/r.c:(Landroid/content/Context;)Ljava/lang/String;
        //   673: astore_1       
        //   674: aload_1        
        //   675: ldc_w           "unknown-network"
        //   678: invokevirtual   java/lang/String.equals:(Ljava/lang/Object;)Z
        //   681: ifne            693
        //   684: aload           14
        //   686: ldc_w           "carriername"
        //   689: aload_1        
        //   690: invokestatic    com/admarvel/android/ads/r.a:(Ljava/lang/StringBuilder;Ljava/lang/String;Ljava/lang/String;)V
        //   693: aload_2        
        //   694: invokestatic    com/admarvel/android/ads/r.b:(Landroid/content/Context;)Ljava/lang/String;
        //   697: astore_2       
        //   698: aload_1        
        //   699: ldc             ""
        //   701: invokevirtual   java/lang/String.equals:(Ljava/lang/Object;)Z
        //   704: ifne            716
        //   707: aload           14
        //   709: ldc_w           "radiotech"
        //   712: aload_2        
        //   713: invokestatic    com/admarvel/android/ads/r.a:(Ljava/lang/StringBuilder;Ljava/lang/String;Ljava/lang/String;)V
        //   716: iload           12
        //   718: ifeq            732
        //   721: aload           14
        //   723: ldc_w           "force_pixel_track"
        //   726: ldc_w           "true"
        //   729: invokestatic    com/admarvel/android/ads/r.a:(Ljava/lang/StringBuilder;Ljava/lang/String;Ljava/lang/String;)V
        //   732: aload           15
        //   734: ifnull          755
        //   737: aload           15
        //   739: invokevirtual   java/lang/String.length:()I
        //   742: ifle            755
        //   745: aload           14
        //   747: ldc_w           "target_params"
        //   750: aload           15
        //   752: invokestatic    com/admarvel/android/ads/r.a:(Ljava/lang/StringBuilder;Ljava/lang/String;Ljava/lang/String;)V
        //   755: aload           14
        //   757: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   760: areturn        
        //   761: aload           14
        //   763: ldc             "sdk_supported"
        //   765: getstatic       com/admarvel/android/ads/AdFetcher.SDK_SUPPORTED:Ljava/lang/String;
        //   768: invokestatic    com/admarvel/android/ads/r.a:(Ljava/lang/StringBuilder;Ljava/lang/String;Ljava/lang/String;)V
        //   771: goto            108
        //   774: astore_1       
        //   775: aload_1        
        //   776: invokestatic    android/util/Log.getStackTraceString:(Ljava/lang/Throwable;)Ljava/lang/String;
        //   779: invokestatic    com/admarvel/android/util/Logging.log:(Ljava/lang/String;)V
        //   782: aconst_null    
        //   783: areturn        
        //   784: aload           14
        //   786: ldc             "device_orientation"
        //   788: ldc_w           "portrait"
        //   791: invokestatic    com/admarvel/android/ads/r.a:(Ljava/lang/StringBuilder;Ljava/lang/String;Ljava/lang/String;)V
        //   794: goto            186
        //   797: aload_1        
        //   798: getstatic       com/admarvel/android/ads/AdFetcher$Adtype.INTERSTITIAL:Lcom/admarvel/android/ads/AdFetcher$Adtype;
        //   801: invokevirtual   com/admarvel/android/ads/AdFetcher$Adtype.equals:(Ljava/lang/Object;)Z
        //   804: ifeq            820
        //   807: aload           14
        //   809: ldc             "adtype"
        //   811: ldc_w           "interstitial"
        //   814: invokestatic    com/admarvel/android/ads/r.a:(Ljava/lang/StringBuilder;Ljava/lang/String;Ljava/lang/String;)V
        //   817: goto            317
        //   820: aload_1        
        //   821: getstatic       com/admarvel/android/ads/AdFetcher$Adtype.NATIVE:Lcom/admarvel/android/ads/AdFetcher$Adtype;
        //   824: invokevirtual   com/admarvel/android/ads/AdFetcher$Adtype.equals:(Ljava/lang/Object;)Z
        //   827: ifeq            317
        //   830: aload           14
        //   832: ldc             "adtype"
        //   834: ldc_w           "native"
        //   837: invokestatic    com/admarvel/android/ads/r.a:(Ljava/lang/StringBuilder;Ljava/lang/String;Ljava/lang/String;)V
        //   840: goto            317
        //   843: iload           8
        //   845: invokestatic    java/lang/String.valueOf:(I)Ljava/lang/String;
        //   848: astore          4
        //   850: goto            329
        //   853: iload           13
        //   855: invokestatic    java/lang/String.valueOf:(I)Ljava/lang/String;
        //   858: astore          6
        //   860: goto            341
        //   863: aload_1        
        //   864: invokestatic    android/util/Log.getStackTraceString:(Ljava/lang/Throwable;)Ljava/lang/String;
        //   867: invokestatic    com/admarvel/android/util/Logging.log:(Ljava/lang/String;)V
        //   870: goto            595
        //   873: aload           6
        //   875: astore          4
        //   877: aload_1        
        //   878: getstatic       com/admarvel/android/ads/AdFetcher$Adtype.INTERSTITIAL:Lcom/admarvel/android/ads/AdFetcher$Adtype;
        //   881: invokevirtual   com/admarvel/android/ads/AdFetcher$Adtype.equals:(Ljava/lang/Object;)Z
        //   884: ifeq            595
        //   887: iconst_1       
        //   888: invokestatic    java/lang/Boolean.valueOf:(Z)Ljava/lang/Boolean;
        //   891: astore          4
        //   893: goto            595
        //   896: aload           14
        //   898: ldc_w           "auto-scaling"
        //   901: ldc_w           "false"
        //   904: invokestatic    com/admarvel/android/ads/r.a:(Ljava/lang/StringBuilder;Ljava/lang/String;Ljava/lang/String;)V
        //   907: aload           14
        //   909: ldc_w           "is_tablet"
        //   912: ldc_w           "true"
        //   915: invokestatic    com/admarvel/android/ads/r.a:(Ljava/lang/StringBuilder;Ljava/lang/String;Ljava/lang/String;)V
        //   918: goto            669
        //   921: astore          6
        //   923: aload_1        
        //   924: astore          4
        //   926: aload           6
        //   928: astore_1       
        //   929: goto            863
        //   932: aload           6
        //   934: astore_1       
        //   935: goto            562
        //   938: aconst_null    
        //   939: astore          4
        //   941: goto            441
        //   944: astore_1       
        //   945: aload           6
        //   947: astore          4
        //   949: goto            863
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                 
        //  -----  -----  -----  -----  ---------------------
        //  9      94     774    784    Ljava/lang/Exception;
        //  99     108    774    784    Ljava/lang/Exception;
        //  108    172    774    784    Ljava/lang/Exception;
        //  177    186    774    784    Ljava/lang/Exception;
        //  186    201    774    784    Ljava/lang/Exception;
        //  206    230    774    784    Ljava/lang/Exception;
        //  230    236    774    784    Ljava/lang/Exception;
        //  241    265    774    784    Ljava/lang/Exception;
        //  265    317    774    784    Ljava/lang/Exception;
        //  322    329    774    784    Ljava/lang/Exception;
        //  334    341    774    784    Ljava/lang/Exception;
        //  341    431    774    784    Ljava/lang/Exception;
        //  435    441    774    784    Ljava/lang/Exception;
        //  446    463    774    784    Ljava/lang/Exception;
        //  463    476    774    784    Ljava/lang/Exception;
        //  481    502    774    784    Ljava/lang/Exception;
        //  506    523    774    784    Ljava/lang/Exception;
        //  528    546    944    952    Ljava/lang/Exception;
        //  550    562    944    952    Ljava/lang/Exception;
        //  565    572    921    932    Ljava/lang/Exception;
        //  583    589    921    932    Ljava/lang/Exception;
        //  595    607    774    784    Ljava/lang/Exception;
        //  607    620    774    784    Ljava/lang/Exception;
        //  624    640    774    784    Ljava/lang/Exception;
        //  640    669    774    784    Ljava/lang/Exception;
        //  669    693    774    784    Ljava/lang/Exception;
        //  693    716    774    784    Ljava/lang/Exception;
        //  721    732    774    784    Ljava/lang/Exception;
        //  737    755    774    784    Ljava/lang/Exception;
        //  761    771    774    784    Ljava/lang/Exception;
        //  784    794    774    784    Ljava/lang/Exception;
        //  797    817    774    784    Ljava/lang/Exception;
        //  820    840    774    784    Ljava/lang/Exception;
        //  843    850    774    784    Ljava/lang/Exception;
        //  853    860    774    784    Ljava/lang/Exception;
        //  863    870    774    784    Ljava/lang/Exception;
        //  877    893    774    784    Ljava/lang/Exception;
        //  896    918    774    784    Ljava/lang/Exception;
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0562:
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
    
    private String fetchAdFromLocal(final AdFetcher$Adtype adFetcher$Adtype, final Context context, final String s, final int n, final String s2, final Map map, final String s3, final String s4, final int n2, final String s5, final boolean b) {
        return new b().a(adFetcher$Adtype, context, s, n, s2, map, s3, s4, n2, s5, false, new Handler(), b);
    }
    
    public String fetchAd(final AdFetcher$Adtype p0, final Context p1, final String p2, final int p3, final String p4, final Map p5, final String p6, final String p7, final int p8, final String p9, final boolean p10, final boolean p11, final boolean p12, final AdMarvelNetworkHandler p13) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     3: dup            
        //     4: invokespecial   java/util/HashMap.<init>:()V
        //     7: astore_3       
        //     8: aload_2        
        //     9: ifnonnull       14
        //    12: aconst_null    
        //    13: areturn        
        //    14: aload           6
        //    16: ifnull          33
        //    19: aload           6
        //    21: monitorenter   
        //    22: aload_3        
        //    23: aload           6
        //    25: invokeinterface java/util/Map.putAll:(Ljava/util/Map;)V
        //    30: aload           6
        //    32: monitorexit    
        //    33: aload_3        
        //    34: ldc_w           "RESPONSE_TYPE"
        //    37: ldc_w           "xml_with_xhtml"
        //    40: invokeinterface java/util/Map.put:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //    45: pop            
        //    46: aload_2        
        //    47: invokestatic    com/admarvel/android/util/j.c:(Landroid/content/Context;)Lcom/admarvel/android/util/j;
        //    50: astore          6
        //    52: aload_0        
        //    53: aload           6
        //    55: aload_2        
        //    56: invokevirtual   com/admarvel/android/util/j.b:(Landroid/content/Context;)Ljava/lang/String;
        //    59: putfield        com/admarvel/android/ads/AdFetcher.googleAdID:Ljava/lang/String;
        //    62: aload_0        
        //    63: aload           6
        //    65: aload_2        
        //    66: invokevirtual   com/admarvel/android/util/j.a:(Landroid/content/Context;)I
        //    69: putfield        com/admarvel/android/ads/AdFetcher.userOptOutPreference:I
        //    72: aload_0        
        //    73: getfield        com/admarvel/android/ads/AdFetcher.googleAdID:Ljava/lang/String;
        //    76: ifnull          244
        //    79: aload_0        
        //    80: getfield        com/admarvel/android/ads/AdFetcher.googleAdID:Ljava/lang/String;
        //    83: ldc             "VALUE_NOT_DEFINED"
        //    85: invokevirtual   java/lang/String.equals:(Ljava/lang/Object;)Z
        //    88: ifne            244
        //    91: aload_3        
        //    92: ldc             "ANDROID_ADVERTISING_ID"
        //    94: aload_0        
        //    95: getfield        com/admarvel/android/ads/AdFetcher.googleAdID:Ljava/lang/String;
        //    98: invokeinterface java/util/Map.put:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   103: pop            
        //   104: aload_3        
        //   105: ldc_w           "ANDROID_ADVERTISING_ID_OPT_OUT"
        //   108: aload_0        
        //   109: getfield        com/admarvel/android/ads/AdFetcher.userOptOutPreference:I
        //   112: invokestatic    java/lang/Integer.toString:(I)Ljava/lang/String;
        //   115: invokeinterface java/util/Map.put:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   120: pop            
        //   121: aload_3        
        //   122: ldc_w           "UNIQUE_ID"
        //   125: invokeinterface java/util/Map.get:(Ljava/lang/Object;)Ljava/lang/Object;
        //   130: ifnonnull       166
        //   133: aload_0        
        //   134: getfield        com/admarvel/android/ads/AdFetcher.googleAdID:Ljava/lang/String;
        //   137: ifnull          261
        //   140: aload_0        
        //   141: getfield        com/admarvel/android/ads/AdFetcher.googleAdID:Ljava/lang/String;
        //   144: ldc             "VALUE_NOT_DEFINED"
        //   146: invokevirtual   java/lang/String.equals:(Ljava/lang/Object;)Z
        //   149: ifne            261
        //   152: aload_3        
        //   153: ldc_w           "UNIQUE_ID"
        //   156: aload_0        
        //   157: getfield        com/admarvel/android/ads/AdFetcher.googleAdID:Ljava/lang/String;
        //   160: invokeinterface java/util/Map.put:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   165: pop            
        //   166: aload_0        
        //   167: aload_1        
        //   168: aload_2        
        //   169: iload           4
        //   171: aload           5
        //   173: aload_3        
        //   174: aload           7
        //   176: aload           8
        //   178: iload           9
        //   180: aload           10
        //   182: iload           11
        //   184: iload           12
        //   186: iload           13
        //   188: invokespecial   com/admarvel/android/ads/AdFetcher.buildParamString:(Lcom/admarvel/android/ads/AdFetcher$Adtype;Landroid/content/Context;ILjava/lang/String;Ljava/util/Map;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;ZZZ)Ljava/lang/String;
        //   191: astore_1       
        //   192: new             Ljava/lang/StringBuilder;
        //   195: dup            
        //   196: ldc_w           "postString: "
        //   199: invokespecial   java/lang/StringBuilder.<init>:(Ljava/lang/String;)V
        //   202: aload_1        
        //   203: ldc_w           "UTF-8"
        //   206: invokestatic    java/net/URLDecoder.decode:(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
        //   209: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   212: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   215: invokestatic    com/admarvel/android/util/Logging.log:(Ljava/lang/String;)V
        //   218: aload_1        
        //   219: putstatic       com/admarvel/android/ads/AdFetcher.lastAdRequestPostString:Ljava/lang/String;
        //   222: aload_1        
        //   223: ifnonnull       302
        //   226: aconst_null    
        //   227: areturn        
        //   228: astore_1       
        //   229: aload           6
        //   231: monitorexit    
        //   232: aload_1        
        //   233: athrow         
        //   234: astore_1       
        //   235: aload_1        
        //   236: invokestatic    android/util/Log.getStackTraceString:(Ljava/lang/Throwable;)Ljava/lang/String;
        //   239: invokestatic    com/admarvel/android/util/Logging.log:(Ljava/lang/String;)V
        //   242: aconst_null    
        //   243: areturn        
        //   244: aload_3        
        //   245: ldc_w           "ANDROID_ID"
        //   248: aload_2        
        //   249: invokestatic    com/admarvel/android/util/OptionalUtils.getId:(Landroid/content/Context;)Ljava/lang/String;
        //   252: invokeinterface java/util/Map.put:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   257: pop            
        //   258: goto            121
        //   261: aload_3        
        //   262: ldc_w           "UNIQUE_ID"
        //   265: aload_2        
        //   266: invokestatic    com/admarvel/android/util/OptionalUtils.getId:(Landroid/content/Context;)Ljava/lang/String;
        //   269: invokeinterface java/util/Map.put:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   274: pop            
        //   275: goto            166
        //   278: astore_3       
        //   279: new             Ljava/lang/StringBuilder;
        //   282: dup            
        //   283: ldc_w           "postString: "
        //   286: invokespecial   java/lang/StringBuilder.<init>:(Ljava/lang/String;)V
        //   289: aload_1        
        //   290: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   293: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   296: invokestatic    com/admarvel/android/util/Logging.log:(Ljava/lang/String;)V
        //   299: goto            218
        //   302: aload_0        
        //   303: new             Lorg/json/JSONObject;
        //   306: dup            
        //   307: invokespecial   org/json/JSONObject.<init>:()V
        //   310: putfield        com/admarvel/android/ads/AdFetcher.requestJson:Lorg/json/JSONObject;
        //   313: new             Ljava/text/SimpleDateFormat;
        //   316: dup            
        //   317: ldc_w           "yyyy-MM-dd HH:mm:ss"
        //   320: invokespecial   java/text/SimpleDateFormat.<init>:(Ljava/lang/String;)V
        //   323: astore_3       
        //   324: aload_3        
        //   325: ldc_w           "GMT+00:00"
        //   328: invokestatic    java/util/TimeZone.getTimeZone:(Ljava/lang/String;)Ljava/util/TimeZone;
        //   331: invokevirtual   java/text/SimpleDateFormat.setTimeZone:(Ljava/util/TimeZone;)V
        //   334: new             Ljava/text/SimpleDateFormat;
        //   337: dup            
        //   338: ldc_w           "yyyy-MM-dd HH:mm:ss"
        //   341: invokespecial   java/text/SimpleDateFormat.<init>:(Ljava/lang/String;)V
        //   344: astore          5
        //   346: invokestatic    java/util/Calendar.getInstance:()Ljava/util/Calendar;
        //   349: invokevirtual   java/util/Calendar.getTime:()Ljava/util/Date;
        //   352: astore          6
        //   354: invokestatic    java/lang/System.currentTimeMillis:()J
        //   357: lstore          15
        //   359: aload_0        
        //   360: getfield        com/admarvel/android/ads/AdFetcher.requestJson:Lorg/json/JSONObject;
        //   363: ldc_w           "data"
        //   366: aload_1        
        //   367: invokevirtual   org/json/JSONObject.put:(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
        //   370: pop            
        //   371: aload_0        
        //   372: getfield        com/admarvel/android/ads/AdFetcher.requestJson:Lorg/json/JSONObject;
        //   375: ldc_w           "timestamp"
        //   378: lload           15
        //   380: invokestatic    java/lang/Long.valueOf:(J)Ljava/lang/Long;
        //   383: invokestatic    java/lang/String.valueOf:(Ljava/lang/Object;)Ljava/lang/String;
        //   386: invokevirtual   org/json/JSONObject.put:(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
        //   389: pop            
        //   390: aload_0        
        //   391: getfield        com/admarvel/android/ads/AdFetcher.requestJson:Lorg/json/JSONObject;
        //   394: ldc_w           "utc"
        //   397: aload_3        
        //   398: aload           6
        //   400: invokevirtual   java/text/SimpleDateFormat.format:(Ljava/util/Date;)Ljava/lang/String;
        //   403: invokevirtual   org/json/JSONObject.put:(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
        //   406: pop            
        //   407: aload_0        
        //   408: getfield        com/admarvel/android/ads/AdFetcher.requestJson:Lorg/json/JSONObject;
        //   411: ldc_w           "local"
        //   414: aload           5
        //   416: aload           6
        //   418: invokevirtual   java/text/SimpleDateFormat.format:(Ljava/util/Date;)Ljava/lang/String;
        //   421: invokevirtual   org/json/JSONObject.put:(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
        //   424: pop            
        //   425: new             Lcom/admarvel/android/ads/AdMarvelHttpPost;
        //   428: dup            
        //   429: invokespecial   com/admarvel/android/ads/AdMarvelHttpPost.<init>:()V
        //   432: astore_3       
        //   433: aload_3        
        //   434: ldc             "http://ads.admarvel.com/fam/androidGetAd.php"
        //   436: invokevirtual   com/admarvel/android/ads/AdMarvelHttpPost.setEndpointUrl:(Ljava/lang/String;)V
        //   439: aload_3        
        //   440: aload_1        
        //   441: invokevirtual   com/admarvel/android/ads/AdMarvelHttpPost.setPostString:(Ljava/lang/String;)V
        //   444: new             Ljava/util/HashMap;
        //   447: dup            
        //   448: invokespecial   java/util/HashMap.<init>:()V
        //   451: astore_1       
        //   452: aload_1        
        //   453: ldc_w           "User-Agent"
        //   456: new             Lcom/admarvel/android/ads/r;
        //   459: dup            
        //   460: aload_2        
        //   461: invokespecial   com/admarvel/android/ads/r.<init>:(Landroid/content/Context;)V
        //   464: invokevirtual   com/admarvel/android/ads/r.a:()Ljava/lang/String;
        //   467: invokeinterface java/util/Map.put:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   472: pop            
        //   473: aload_1        
        //   474: ldc_w           "Content-Type"
        //   477: ldc_w           "application/x-www-form-urlencoded"
        //   480: invokeinterface java/util/Map.put:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   485: pop            
        //   486: aload_3        
        //   487: aload_1        
        //   488: invokevirtual   com/admarvel/android/ads/AdMarvelHttpPost.setHttpHeaders:(Ljava/util/Map;)V
        //   491: aload           14
        //   493: astore_1       
        //   494: aload           14
        //   496: ifnonnull       507
        //   499: new             Lcom/admarvel/android/ads/g;
        //   502: dup            
        //   503: invokespecial   com/admarvel/android/ads/g.<init>:()V
        //   506: astore_1       
        //   507: aload_1        
        //   508: aload_3        
        //   509: invokeinterface com/admarvel/android/ads/AdMarvelNetworkHandler.executeNetworkCall:(Lcom/admarvel/android/ads/AdMarvelHttpPost;)Ljava/lang/String;
        //   514: astore_1       
        //   515: aload_1        
        //   516: ifnull          563
        //   519: aload_1        
        //   520: invokevirtual   java/lang/String.length:()I
        //   523: ifle            563
        //   526: new             Ljava/lang/StringBuilder;
        //   529: dup            
        //   530: ldc_w           "Admarvel XML Response:"
        //   533: invokespecial   java/lang/StringBuilder.<init>:(Ljava/lang/String;)V
        //   536: new             Ljava/lang/String;
        //   539: dup            
        //   540: aload_1        
        //   541: invokespecial   java/lang/String.<init>:(Ljava/lang/String;)V
        //   544: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   547: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   550: invokestatic    com/admarvel/android/util/Logging.log:(Ljava/lang/String;)V
        //   553: aload_1        
        //   554: areturn        
        //   555: astore_3       
        //   556: aload_3        
        //   557: invokevirtual   java/lang/Exception.printStackTrace:()V
        //   560: goto            425
        //   563: ldc_w           "Admarvel XML Response: Invalid response"
        //   566: invokestatic    com/admarvel/android/util/Logging.log:(Ljava/lang/String;)V
        //   569: aload_1        
        //   570: areturn        
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                 
        //  -----  -----  -----  -----  ---------------------
        //  19     22     234    244    Ljava/lang/Exception;
        //  22     33     228    234    Any
        //  33     121    234    244    Ljava/lang/Exception;
        //  121    166    234    244    Ljava/lang/Exception;
        //  192    218    278    302    Ljava/lang/Exception;
        //  229    234    234    244    Ljava/lang/Exception;
        //  244    258    234    244    Ljava/lang/Exception;
        //  261    275    234    244    Ljava/lang/Exception;
        //  302    425    555    563    Ljava/lang/Exception;
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0218:
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
    
    public String fetchOfflineAd(final AdFetcher$Adtype adFetcher$Adtype, final Context context, String googleAdID, final int n, final String s, final Map map, final String s2, final String s3, final int n2, final String s4, final boolean b, final boolean b2) {
        if (context == null) {
            return null;
        }
        final HashMap hashMap = new HashMap();
        Label_0035: {
            if (map == null) {
                break Label_0035;
            }
        Label_0135_Outer:
            while (true) {
            Label_0182_Outer:
                while (true) {
                Label_0258:
                    while (true) {
                    Label_0240:
                        while (true) {
                            Label_0222: {
                                try {
                                    synchronized (map) {
                                        hashMap.putAll(map);
                                        monitorexit(map);
                                        hashMap.put("RESPONSE_TYPE", "xml_with_xhtml");
                                        final j c = j.c(context);
                                        this.googleAdID = c.b(context);
                                        this.userOptOutPreference = c.a(context);
                                        if (this.googleAdID == null || this.googleAdID.equals("VALUE_NOT_DEFINED")) {
                                            break Label_0222;
                                        }
                                        hashMap.put("ANDROID_ADVERTISING_ID", this.googleAdID);
                                        hashMap.put("ANDROID_ADVERTISING_ID_OPT_OUT", Integer.toString(this.userOptOutPreference));
                                        if (googleAdID == null) {
                                            googleAdID = this.googleAdID;
                                            if (hashMap.get("UNIQUE_ID") == null) {
                                                if (this.googleAdID == null || this.googleAdID.equals("VALUE_NOT_DEFINED")) {
                                                    break Label_0240;
                                                }
                                                hashMap.put("UNIQUE_ID", this.googleAdID);
                                            }
                                            return this.fetchAdFromLocal(adFetcher$Adtype, context, googleAdID, n, s, map, s2, s3, n2, s4, b);
                                        }
                                        break Label_0258;
                                    }
                                }
                                catch (Exception ex) {
                                    Logging.log(Log.getStackTraceString((Throwable)ex));
                                    return null;
                                }
                            }
                            hashMap.put("ANDROID_ID", OptionalUtils.getId(context));
                            continue Label_0135_Outer;
                        }
                        hashMap.put("UNIQUE_ID", OptionalUtils.getId(context));
                        continue;
                    }
                    continue Label_0182_Outer;
                }
            }
        }
    }
    
    public JSONObject getRequestJson() {
        return this.requestJson;
    }
}
