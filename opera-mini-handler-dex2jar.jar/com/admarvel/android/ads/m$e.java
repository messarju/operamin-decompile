// 
// Decompiled by Procyon v0.6-prerelease
// 

package com.admarvel.android.ads;

import java.lang.ref.WeakReference;

class m$e implements Runnable
{
    private final String a;
    private final WeakReference b;
    private final WeakReference c;
    
    public m$e(final String a, final d d, final m m) {
        this.a = a;
        this.b = new WeakReference((T)d);
        this.c = new WeakReference((T)m);
    }
    
    @Override
    public void run() {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: getfield        com/admarvel/android/ads/m$e.b:Ljava/lang/ref/WeakReference;
        //     4: invokevirtual   java/lang/ref/WeakReference.get:()Ljava/lang/Object;
        //     7: checkcast       Lcom/admarvel/android/ads/d;
        //    10: astore          19
        //    12: aload_0        
        //    13: getfield        com/admarvel/android/ads/m$e.c:Ljava/lang/ref/WeakReference;
        //    16: invokevirtual   java/lang/ref/WeakReference.get:()Ljava/lang/Object;
        //    19: checkcast       Lcom/admarvel/android/ads/m;
        //    22: astore          20
        //    24: aload           20
        //    26: ifnonnull       30
        //    29: return         
        //    30: aload           19
        //    32: ifnull          1258
        //    35: invokestatic    com/admarvel/android/ads/Version.getAndroidSDKVersion:()I
        //    38: bipush          9
        //    40: if_icmpge       1034
        //    43: aload           20
        //    45: invokevirtual   com/admarvel/android/ads/m.getResources:()Landroid/content/res/Resources;
        //    48: invokevirtual   android/content/res/Resources.getConfiguration:()Landroid/content/res/Configuration;
        //    51: getfield        android/content/res/Configuration.orientation:I
        //    54: istore_2       
        //    55: iload_2        
        //    56: iconst_1       
        //    57: if_icmpne       1023
        //    60: iconst_0       
        //    61: istore_2       
        //    62: aload           20
        //    64: invokevirtual   com/admarvel/android/ads/m.getContext:()Landroid/content/Context;
        //    67: invokestatic    com/admarvel/android/ads/r.a:(Landroid/content/Context;)Ljava/lang/String;
        //    70: astore          21
        //    72: aload           21
        //    74: ldc             "wifi"
        //    76: invokevirtual   java/lang/String.equals:(Ljava/lang/Object;)Z
        //    79: ifne            1259
        //    82: aload           21
        //    84: ldc             "mobile"
        //    86: invokevirtual   java/lang/String.equals:(Ljava/lang/Object;)Z
        //    89: ifeq            1314
        //    92: goto            1259
        //    95: aload           20
        //    97: invokevirtual   com/admarvel/android/ads/m.getContext:()Landroid/content/Context;
        //   100: ldc             "location"
        //   102: invokestatic    com/admarvel/android/ads/r.b:(Landroid/content/Context;Ljava/lang/String;)Z
        //   105: ifeq            1247
        //   108: invokestatic    com/admarvel/android/util/c.a:()Lcom/admarvel/android/util/c;
        //   111: aload           19
        //   113: invokevirtual   com/admarvel/android/util/c.a:(Lcom/admarvel/android/ads/d;)Landroid/location/Location;
        //   116: astore          17
        //   118: aload           17
        //   120: ifnull          1322
        //   123: new             Ljava/lang/StringBuilder;
        //   126: dup            
        //   127: ldc             "{lat:"
        //   129: invokespecial   java/lang/StringBuilder.<init>:(Ljava/lang/String;)V
        //   132: aload           17
        //   134: invokevirtual   android/location/Location.getLatitude:()D
        //   137: invokevirtual   java/lang/StringBuilder.append:(D)Ljava/lang/StringBuilder;
        //   140: ldc             ", lon:"
        //   142: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   145: aload           17
        //   147: invokevirtual   android/location/Location.getLongitude:()D
        //   150: invokevirtual   java/lang/StringBuilder.append:(D)Ljava/lang/StringBuilder;
        //   153: ldc             ", acc:"
        //   155: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   158: aload           17
        //   160: invokevirtual   android/location/Location.getAccuracy:()F
        //   163: invokevirtual   java/lang/StringBuilder.append:(F)Ljava/lang/StringBuilder;
        //   166: ldc             "}"
        //   168: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   171: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   174: astore          17
        //   176: new             Ljava/lang/StringBuilder;
        //   179: dup            
        //   180: ldc             "{screen: true, orientation: true, heading: "
        //   182: invokespecial   java/lang/StringBuilder.<init>:(Ljava/lang/String;)V
        //   185: aload           20
        //   187: invokevirtual   com/admarvel/android/ads/m.getContext:()Landroid/content/Context;
        //   190: ldc             "compass"
        //   192: invokestatic    com/admarvel/android/ads/r.b:(Landroid/content/Context;Ljava/lang/String;)Z
        //   195: invokevirtual   java/lang/StringBuilder.append:(Z)Ljava/lang/StringBuilder;
        //   198: ldc             ", location : "
        //   200: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   203: astore          18
        //   205: aload           20
        //   207: invokevirtual   com/admarvel/android/ads/m.getContext:()Landroid/content/Context;
        //   210: ldc             "android.permission.ACCESS_COARSE_LOCATION"
        //   212: invokestatic    com/admarvel/android/ads/r.c:(Landroid/content/Context;Ljava/lang/String;)Z
        //   215: ifne            1267
        //   218: aload           20
        //   220: invokevirtual   com/admarvel/android/ads/m.getContext:()Landroid/content/Context;
        //   223: ldc             "android.permission.ACCESS_FINE_LOCATION"
        //   225: invokestatic    com/admarvel/android/ads/r.c:(Landroid/content/Context;Ljava/lang/String;)Z
        //   228: ifeq            1330
        //   231: goto            1267
        //   234: aload           18
        //   236: iload           15
        //   238: invokevirtual   java/lang/StringBuilder.append:(Z)Ljava/lang/StringBuilder;
        //   241: ldc             ",shake: "
        //   243: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   246: aload           20
        //   248: invokevirtual   com/admarvel/android/ads/m.getContext:()Landroid/content/Context;
        //   251: ldc             "accelerometer"
        //   253: invokestatic    com/admarvel/android/ads/r.b:(Landroid/content/Context;Ljava/lang/String;)Z
        //   256: invokevirtual   java/lang/StringBuilder.append:(Z)Ljava/lang/StringBuilder;
        //   259: ldc             ",tilt: "
        //   261: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   264: aload           20
        //   266: invokevirtual   com/admarvel/android/ads/m.getContext:()Landroid/content/Context;
        //   269: ldc             "accelerometer"
        //   271: invokestatic    com/admarvel/android/ads/r.b:(Landroid/content/Context;Ljava/lang/String;)Z
        //   274: invokevirtual   java/lang/StringBuilder.append:(Z)Ljava/lang/StringBuilder;
        //   277: ldc             ", network: true, sms:"
        //   279: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   282: aload           20
        //   284: invokevirtual   com/admarvel/android/ads/m.getContext:()Landroid/content/Context;
        //   287: invokestatic    com/admarvel/android/ads/r.j:(Landroid/content/Context;)Z
        //   290: invokevirtual   java/lang/StringBuilder.append:(Z)Ljava/lang/StringBuilder;
        //   293: ldc             ", phone:"
        //   295: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   298: aload           20
        //   300: invokevirtual   com/admarvel/android/ads/m.getContext:()Landroid/content/Context;
        //   303: invokestatic    com/admarvel/android/ads/r.j:(Landroid/content/Context;)Z
        //   306: invokevirtual   java/lang/StringBuilder.append:(Z)Ljava/lang/StringBuilder;
        //   309: ldc             ", email:true,calendar:"
        //   311: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   314: astore          18
        //   316: aload           20
        //   318: invokevirtual   com/admarvel/android/ads/m.getContext:()Landroid/content/Context;
        //   321: ldc             "android.permission.READ_CALENDAR"
        //   323: invokestatic    com/admarvel/android/ads/r.c:(Landroid/content/Context;Ljava/lang/String;)Z
        //   326: ifeq            1336
        //   329: aload           20
        //   331: invokevirtual   com/admarvel/android/ads/m.getContext:()Landroid/content/Context;
        //   334: ldc             "android.permission.WRITE_CALENDAR"
        //   336: invokestatic    com/admarvel/android/ads/r.c:(Landroid/content/Context;Ljava/lang/String;)Z
        //   339: ifeq            1336
        //   342: iconst_1       
        //   343: istore          15
        //   345: aload           18
        //   347: iload           15
        //   349: invokevirtual   java/lang/StringBuilder.append:(Z)Ljava/lang/StringBuilder;
        //   352: ldc             ", camera: "
        //   354: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   357: aload           20
        //   359: invokevirtual   com/admarvel/android/ads/m.getContext:()Landroid/content/Context;
        //   362: ldc             "camera"
        //   364: invokestatic    com/admarvel/android/ads/r.b:(Landroid/content/Context;Ljava/lang/String;)Z
        //   367: invokevirtual   java/lang/StringBuilder.append:(Z)Ljava/lang/StringBuilder;
        //   370: ldc             ",map:true, audio:true, video:true, 'level-1':true,'level-2': true, 'level-3':false}"
        //   372: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   375: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   378: astore          22
        //   380: aload           19
        //   382: getfield        com/admarvel/android/ads/d.d:Ljava/lang/ref/WeakReference;
        //   385: invokevirtual   java/lang/ref/WeakReference.get:()Ljava/lang/Object;
        //   388: checkcast       Lcom/admarvel/android/ads/AdMarvelView;
        //   391: astore          18
        //   393: aload           18
        //   395: ifnull          1221
        //   398: iconst_2       
        //   399: newarray        I
        //   401: astore          23
        //   403: aload           19
        //   405: aload           23
        //   407: invokevirtual   com/admarvel/android/ads/d.getLocationOnScreen:([I)V
        //   410: aload           20
        //   412: invokevirtual   com/admarvel/android/ads/m.getContext:()Landroid/content/Context;
        //   415: instanceof      Landroid/app/Activity;
        //   418: ifeq            1216
        //   421: aload           20
        //   423: invokevirtual   com/admarvel/android/ads/m.getContext:()Landroid/content/Context;
        //   426: checkcast       Landroid/app/Activity;
        //   429: astore          24
        //   431: aload           24
        //   433: ifnull          1216
        //   436: aload           20
        //   438: getfield        com/admarvel/android/ads/m.v:I
        //   441: ldc             -2147483648
        //   443: if_icmpeq       1102
        //   446: aload           20
        //   448: getfield        com/admarvel/android/ads/m.v:I
        //   451: iflt            1102
        //   454: aload           20
        //   456: getfield        com/admarvel/android/ads/m.v:I
        //   459: istore_3       
        //   460: aload           23
        //   462: iconst_0       
        //   463: iaload         
        //   464: istore          10
        //   466: aload           23
        //   468: iconst_1       
        //   469: iaload         
        //   470: istore          11
        //   472: aload           19
        //   474: invokevirtual   com/admarvel/android/ads/d.getWidth:()I
        //   477: istore          8
        //   479: aload           19
        //   481: invokevirtual   com/admarvel/android/ads/d.getHeight:()I
        //   484: istore          7
        //   486: iconst_2       
        //   487: newarray        I
        //   489: astore          23
        //   491: aload           18
        //   493: aload           23
        //   495: invokevirtual   com/admarvel/android/ads/AdMarvelView.getLocationOnScreen:([I)V
        //   498: aload           23
        //   500: iconst_0       
        //   501: iaload         
        //   502: istore          6
        //   504: aload           23
        //   506: iconst_1       
        //   507: iaload         
        //   508: istore          5
        //   510: aload           20
        //   512: invokevirtual   com/admarvel/android/ads/m.getAdMarvelAd:()Lcom/admarvel/android/ads/AdMarvelAd;
        //   515: ifnull          1198
        //   518: aload           20
        //   520: invokevirtual   com/admarvel/android/ads/m.getAdMarvelAd:()Lcom/admarvel/android/ads/AdMarvelAd;
        //   523: invokevirtual   com/admarvel/android/ads/AdMarvelAd.getAdMarvelViewWidth:()F
        //   526: ldc             -1.0
        //   528: fcmpl          
        //   529: ifeq            1188
        //   532: aload           20
        //   534: invokevirtual   com/admarvel/android/ads/m.getAdMarvelAd:()Lcom/admarvel/android/ads/AdMarvelAd;
        //   537: invokevirtual   com/admarvel/android/ads/AdMarvelAd.getAdMarvelViewWidth:()F
        //   540: aload           20
        //   542: invokevirtual   com/admarvel/android/ads/m.getContext:()Landroid/content/Context;
        //   545: invokestatic    com/admarvel/android/ads/r.i:(Landroid/content/Context;)F
        //   548: fmul           
        //   549: fstore_1       
        //   550: goto            1273
        //   553: aload           18
        //   555: invokevirtual   com/admarvel/android/ads/AdMarvelView.getHeight:()I
        //   558: istore          9
        //   560: iload           5
        //   562: iload_3        
        //   563: isub           
        //   564: istore          5
        //   566: iload           11
        //   568: iload_3        
        //   569: isub           
        //   570: istore          11
        //   572: iload           9
        //   574: istore_3       
        //   575: iload           11
        //   577: istore          9
        //   579: aload           20
        //   581: invokevirtual   com/admarvel/android/ads/m.getRootView:()Landroid/view/View;
        //   584: invokevirtual   android/view/View.getLeft:()I
        //   587: istore          13
        //   589: aload           20
        //   591: invokevirtual   com/admarvel/android/ads/m.getRootView:()Landroid/view/View;
        //   594: invokevirtual   android/view/View.getTop:()I
        //   597: istore          14
        //   599: aload           20
        //   601: invokevirtual   com/admarvel/android/ads/m.getRootView:()Landroid/view/View;
        //   604: invokevirtual   android/view/View.getWidth:()I
        //   607: istore          12
        //   609: aload           20
        //   611: invokevirtual   com/admarvel/android/ads/m.getRootView:()Landroid/view/View;
        //   614: invokevirtual   android/view/View.getHeight:()I
        //   617: istore          11
        //   619: aload           20
        //   621: invokevirtual   com/admarvel/android/ads/m.getContext:()Landroid/content/Context;
        //   624: instanceof      Landroid/app/Activity;
        //   627: ifeq            1208
        //   630: aload           20
        //   632: invokevirtual   com/admarvel/android/ads/m.getContext:()Landroid/content/Context;
        //   635: checkcast       Landroid/app/Activity;
        //   638: astore          23
        //   640: aload           23
        //   642: ifnull          1208
        //   645: aload           23
        //   647: invokestatic    com/admarvel/android/ads/r.a:(Landroid/app/Activity;)Ljava/lang/String;
        //   650: astore          18
        //   652: aload           23
        //   654: invokevirtual   android/app/Activity.getWindow:()Landroid/view/Window;
        //   657: ldc             16908290
        //   659: invokevirtual   android/view/Window.findViewById:(I)Landroid/view/View;
        //   662: checkcast       Landroid/view/ViewGroup;
        //   665: astore          23
        //   667: aload           23
        //   669: invokevirtual   android/view/ViewGroup.getLeft:()I
        //   672: istore          13
        //   674: aload           23
        //   676: invokevirtual   android/view/ViewGroup.getTop:()I
        //   679: istore          14
        //   681: aload           23
        //   683: invokevirtual   android/view/ViewGroup.getWidth:()I
        //   686: istore          12
        //   688: aload           23
        //   690: invokevirtual   android/view/ViewGroup.getHeight:()I
        //   693: istore          11
        //   695: new             Ljava/lang/StringBuilder;
        //   698: dup            
        //   699: invokespecial   java/lang/StringBuilder.<init>:()V
        //   702: aload_0        
        //   703: getfield        com/admarvel/android/ads/m$e.a:Ljava/lang/String;
        //   706: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   709: ldc             "({x:"
        //   711: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   714: iload           10
        //   716: invokevirtual   java/lang/StringBuilder.append:(I)Ljava/lang/StringBuilder;
        //   719: ldc             ",y:"
        //   721: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   724: iload           9
        //   726: invokevirtual   java/lang/StringBuilder.append:(I)Ljava/lang/StringBuilder;
        //   729: ldc_w           ",width:"
        //   732: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   735: iload           8
        //   737: invokevirtual   java/lang/StringBuilder.append:(I)Ljava/lang/StringBuilder;
        //   740: ldc_w           ",height:"
        //   743: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   746: iload           7
        //   748: invokevirtual   java/lang/StringBuilder.append:(I)Ljava/lang/StringBuilder;
        //   751: ldc_w           ",appX:"
        //   754: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   757: iload           13
        //   759: invokevirtual   java/lang/StringBuilder.append:(I)Ljava/lang/StringBuilder;
        //   762: ldc_w           ",appY:"
        //   765: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   768: iload           14
        //   770: invokevirtual   java/lang/StringBuilder.append:(I)Ljava/lang/StringBuilder;
        //   773: ldc_w           ",appWidth:"
        //   776: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   779: iload           12
        //   781: invokevirtual   java/lang/StringBuilder.append:(I)Ljava/lang/StringBuilder;
        //   784: ldc_w           ",appHeight:"
        //   787: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   790: iload           11
        //   792: invokevirtual   java/lang/StringBuilder.append:(I)Ljava/lang/StringBuilder;
        //   795: ldc_w           ",orientation:"
        //   798: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   801: iload_2        
        //   802: invokevirtual   java/lang/StringBuilder.append:(I)Ljava/lang/StringBuilder;
        //   805: ldc_w           ",defaultX:"
        //   808: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   811: iload           6
        //   813: invokevirtual   java/lang/StringBuilder.append:(I)Ljava/lang/StringBuilder;
        //   816: ldc_w           ",defaultY:"
        //   819: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   822: iload           5
        //   824: invokevirtual   java/lang/StringBuilder.append:(I)Ljava/lang/StringBuilder;
        //   827: ldc_w           ",defaultWidth:"
        //   830: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   833: iload           4
        //   835: invokevirtual   java/lang/StringBuilder.append:(I)Ljava/lang/StringBuilder;
        //   838: ldc_w           ",defaultHeight:"
        //   841: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   844: iload_3        
        //   845: invokevirtual   java/lang/StringBuilder.append:(I)Ljava/lang/StringBuilder;
        //   848: ldc_w           ",networkType:'"
        //   851: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   854: aload           21
        //   856: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   859: ldc_w           "',network:'"
        //   862: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   865: aload           16
        //   867: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   870: ldc_w           "',screenWidth:"
        //   873: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   876: aload           20
        //   878: invokevirtual   com/admarvel/android/ads/m.getContext:()Landroid/content/Context;
        //   881: invokestatic    com/admarvel/android/ads/r.g:(Landroid/content/Context;)I
        //   884: invokevirtual   java/lang/StringBuilder.append:(I)Ljava/lang/StringBuilder;
        //   887: ldc_w           ",screenHeight:"
        //   890: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   893: aload           20
        //   895: invokevirtual   com/admarvel/android/ads/m.getContext:()Landroid/content/Context;
        //   898: invokestatic    com/admarvel/android/ads/r.h:(Landroid/content/Context;)I
        //   901: invokevirtual   java/lang/StringBuilder.append:(I)Ljava/lang/StringBuilder;
        //   904: ldc_w           ",adType:'"
        //   907: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   910: ldc_w           "Banner"
        //   913: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   916: ldc_w           "',supportedFeatures:"
        //   919: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   922: aload           22
        //   924: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   927: ldc_w           ",sdkVersion:'"
        //   930: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   933: ldc_w           "2.4.6"
        //   936: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   939: ldc_w           "',location:"
        //   942: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   945: aload           17
        //   947: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   950: ldc_w           ",applicationSupportedOrientations:'"
        //   953: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   956: aload           18
        //   958: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   961: ldc_w           "'})"
        //   964: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   967: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   970: astore          16
        //   972: aload           19
        //   974: aload           16
        //   976: invokevirtual   com/admarvel/android/ads/d.e:(Ljava/lang/String;)V
        //   979: new             Ljava/lang/StringBuilder;
        //   982: dup            
        //   983: ldc_w           "Updating Frame values : "
        //   986: invokespecial   java/lang/StringBuilder.<init>:(Ljava/lang/String;)V
        //   989: aload           16
        //   991: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   994: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   997: invokestatic    com/admarvel/android/util/Logging.log:(Ljava/lang/String;)V
        //  1000: return         
        //  1001: astore          16
        //  1003: aload           16
        //  1005: invokestatic    android/util/Log.getStackTraceString:(Ljava/lang/Throwable;)Ljava/lang/String;
        //  1008: invokestatic    com/admarvel/android/util/Logging.log:(Ljava/lang/String;)V
        //  1011: return         
        //  1012: astore          16
        //  1014: aload           16
        //  1016: invokestatic    android/util/Log.getStackTraceString:(Ljava/lang/Throwable;)Ljava/lang/String;
        //  1019: invokestatic    com/admarvel/android/util/Logging.log:(Ljava/lang/String;)V
        //  1022: return         
        //  1023: iload_2        
        //  1024: iconst_2       
        //  1025: if_icmpne       1253
        //  1028: bipush          90
        //  1030: istore_2       
        //  1031: goto            62
        //  1034: aload           20
        //  1036: aload           20
        //  1038: invokevirtual   com/admarvel/android/ads/m.getContext:()Landroid/content/Context;
        //  1041: ldc_w           "window"
        //  1044: invokevirtual   android/content/Context.getSystemService:(Ljava/lang/String;)Ljava/lang/Object;
        //  1047: checkcast       Landroid/view/WindowManager;
        //  1050: invokeinterface android/view/WindowManager.getDefaultDisplay:()Landroid/view/Display;
        //  1055: invokevirtual   android/view/Display.getRotation:()I
        //  1058: putfield        com/admarvel/android/ads/m.u:I
        //  1061: aload           20
        //  1063: getfield        com/admarvel/android/ads/m.u:I
        //  1066: istore_2       
        //  1067: iload_2        
        //  1068: ifne            1280
        //  1071: iconst_0       
        //  1072: istore_2       
        //  1073: goto            62
        //  1076: astore          24
        //  1078: aload           23
        //  1080: iconst_0       
        //  1081: iconst_0       
        //  1082: iastore        
        //  1083: aload           23
        //  1085: iconst_1       
        //  1086: iconst_0       
        //  1087: iastore        
        //  1088: goto            410
        //  1091: astore          16
        //  1093: aload           16
        //  1095: invokestatic    android/util/Log.getStackTraceString:(Ljava/lang/Throwable;)Ljava/lang/String;
        //  1098: invokestatic    com/admarvel/android/util/Logging.log:(Ljava/lang/String;)V
        //  1101: return         
        //  1102: aload           24
        //  1104: invokevirtual   android/app/Activity.getWindow:()Landroid/view/Window;
        //  1107: ldc             16908290
        //  1109: invokevirtual   android/view/Window.findViewById:(I)Landroid/view/View;
        //  1112: checkcast       Landroid/view/ViewGroup;
        //  1115: astore          25
        //  1117: new             Landroid/util/DisplayMetrics;
        //  1120: dup            
        //  1121: invokespecial   android/util/DisplayMetrics.<init>:()V
        //  1124: astore          26
        //  1126: aload           24
        //  1128: invokevirtual   android/app/Activity.getWindowManager:()Landroid/view/WindowManager;
        //  1131: invokeinterface android/view/WindowManager.getDefaultDisplay:()Landroid/view/Display;
        //  1136: aload           26
        //  1138: invokevirtual   android/view/Display.getMetrics:(Landroid/util/DisplayMetrics;)V
        //  1141: aload           26
        //  1143: getfield        android/util/DisplayMetrics.heightPixels:I
        //  1146: aload           25
        //  1148: invokevirtual   android/view/ViewGroup.getMeasuredHeight:()I
        //  1151: isub           
        //  1152: istore          4
        //  1154: iload           4
        //  1156: istore_3       
        //  1157: iload           4
        //  1159: iflt            460
        //  1162: iload           4
        //  1164: istore_3       
        //  1165: aload           20
        //  1167: getfield        com/admarvel/android/ads/m.v:I
        //  1170: ldc             -2147483648
        //  1172: if_icmpne       460
        //  1175: aload           20
        //  1177: iload           4
        //  1179: putfield        com/admarvel/android/ads/m.v:I
        //  1182: iload           4
        //  1184: istore_3       
        //  1185: goto            460
        //  1188: aload           18
        //  1190: invokevirtual   com/admarvel/android/ads/AdMarvelView.getWidth:()I
        //  1193: i2f            
        //  1194: fstore_1       
        //  1195: goto            1273
        //  1198: aload           18
        //  1200: invokevirtual   com/admarvel/android/ads/AdMarvelView.getWidth:()I
        //  1203: istore          4
        //  1205: goto            553
        //  1208: ldc_w           "0,90"
        //  1211: astore          18
        //  1213: goto            695
        //  1216: iconst_0       
        //  1217: istore_3       
        //  1218: goto            460
        //  1221: iconst_0       
        //  1222: istore          6
        //  1224: iconst_0       
        //  1225: istore          7
        //  1227: iconst_0       
        //  1228: istore          8
        //  1230: iconst_0       
        //  1231: istore          9
        //  1233: iconst_0       
        //  1234: istore          10
        //  1236: iconst_0       
        //  1237: istore          5
        //  1239: iconst_0       
        //  1240: istore_3       
        //  1241: iconst_0       
        //  1242: istore          4
        //  1244: goto            579
        //  1247: aconst_null    
        //  1248: astore          17
        //  1250: goto            118
        //  1253: iconst_m1      
        //  1254: istore_2       
        //  1255: goto            62
        //  1258: return         
        //  1259: ldc_w           "YES"
        //  1262: astore          16
        //  1264: goto            95
        //  1267: iconst_1       
        //  1268: istore          15
        //  1270: goto            234
        //  1273: fload_1        
        //  1274: f2i            
        //  1275: istore          4
        //  1277: goto            553
        //  1280: iload_2        
        //  1281: iconst_1       
        //  1282: if_icmpne       1291
        //  1285: bipush          90
        //  1287: istore_2       
        //  1288: goto            62
        //  1291: iload_2        
        //  1292: iconst_2       
        //  1293: if_icmpne       1303
        //  1296: sipush          180
        //  1299: istore_2       
        //  1300: goto            62
        //  1303: iload_2        
        //  1304: iconst_3       
        //  1305: if_icmpne       1253
        //  1308: bipush          -90
        //  1310: istore_2       
        //  1311: goto            62
        //  1314: ldc_w           "NO"
        //  1317: astore          16
        //  1319: goto            95
        //  1322: ldc_w           "null"
        //  1325: astore          17
        //  1327: goto            176
        //  1330: iconst_0       
        //  1331: istore          15
        //  1333: goto            234
        //  1336: iconst_0       
        //  1337: istore          15
        //  1339: goto            345
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                            
        //  -----  -----  -----  -----  --------------------------------
        //  0      24     1012   1023   Ljava/lang/NullPointerException;
        //  0      24     1091   1102   Ljava/lang/Exception;
        //  35     55     1012   1023   Ljava/lang/NullPointerException;
        //  35     55     1091   1102   Ljava/lang/Exception;
        //  62     92     1012   1023   Ljava/lang/NullPointerException;
        //  62     92     1091   1102   Ljava/lang/Exception;
        //  95     118    1012   1023   Ljava/lang/NullPointerException;
        //  95     118    1091   1102   Ljava/lang/Exception;
        //  123    176    1012   1023   Ljava/lang/NullPointerException;
        //  123    176    1091   1102   Ljava/lang/Exception;
        //  176    231    1012   1023   Ljava/lang/NullPointerException;
        //  176    231    1091   1102   Ljava/lang/Exception;
        //  234    342    1012   1023   Ljava/lang/NullPointerException;
        //  234    342    1091   1102   Ljava/lang/Exception;
        //  345    393    1012   1023   Ljava/lang/NullPointerException;
        //  345    393    1091   1102   Ljava/lang/Exception;
        //  398    403    1012   1023   Ljava/lang/NullPointerException;
        //  398    403    1091   1102   Ljava/lang/Exception;
        //  403    410    1076   1091   Ljava/lang/Exception;
        //  403    410    1012   1023   Ljava/lang/NullPointerException;
        //  410    431    1012   1023   Ljava/lang/NullPointerException;
        //  410    431    1091   1102   Ljava/lang/Exception;
        //  436    460    1012   1023   Ljava/lang/NullPointerException;
        //  436    460    1091   1102   Ljava/lang/Exception;
        //  472    498    1012   1023   Ljava/lang/NullPointerException;
        //  472    498    1091   1102   Ljava/lang/Exception;
        //  510    550    1012   1023   Ljava/lang/NullPointerException;
        //  510    550    1091   1102   Ljava/lang/Exception;
        //  553    560    1012   1023   Ljava/lang/NullPointerException;
        //  553    560    1091   1102   Ljava/lang/Exception;
        //  579    640    1012   1023   Ljava/lang/NullPointerException;
        //  579    640    1091   1102   Ljava/lang/Exception;
        //  645    695    1012   1023   Ljava/lang/NullPointerException;
        //  645    695    1091   1102   Ljava/lang/Exception;
        //  695    1000   1001   1012   Ljava/lang/Exception;
        //  695    1000   1012   1023   Ljava/lang/NullPointerException;
        //  1003   1011   1012   1023   Ljava/lang/NullPointerException;
        //  1003   1011   1091   1102   Ljava/lang/Exception;
        //  1034   1067   1012   1023   Ljava/lang/NullPointerException;
        //  1034   1067   1091   1102   Ljava/lang/Exception;
        //  1102   1154   1012   1023   Ljava/lang/NullPointerException;
        //  1102   1154   1091   1102   Ljava/lang/Exception;
        //  1165   1182   1012   1023   Ljava/lang/NullPointerException;
        //  1165   1182   1091   1102   Ljava/lang/Exception;
        //  1188   1195   1012   1023   Ljava/lang/NullPointerException;
        //  1188   1195   1091   1102   Ljava/lang/Exception;
        //  1198   1205   1012   1023   Ljava/lang/NullPointerException;
        //  1198   1205   1091   1102   Ljava/lang/Exception;
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0460:
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
