// 
// Decompiled by Procyon v0.6-prerelease
// 

package com.admarvel.android.ads;

import java.lang.ref.WeakReference;

class m$p implements Runnable
{
    private final String a;
    private final WeakReference b;
    private final WeakReference c;
    
    public m$p(final String a, final d d, final m m) {
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
        //     1: getfield        com/admarvel/android/ads/m$p.b:Ljava/lang/ref/WeakReference;
        //     4: invokevirtual   java/lang/ref/WeakReference.get:()Ljava/lang/Object;
        //     7: checkcast       Lcom/admarvel/android/ads/d;
        //    10: astore          15
        //    12: aload_0        
        //    13: getfield        com/admarvel/android/ads/m$p.c:Ljava/lang/ref/WeakReference;
        //    16: invokevirtual   java/lang/ref/WeakReference.get:()Ljava/lang/Object;
        //    19: checkcast       Lcom/admarvel/android/ads/m;
        //    22: astore          16
        //    24: aload           16
        //    26: ifnonnull       30
        //    29: return         
        //    30: aload           15
        //    32: ifnull          1167
        //    35: aload           16
        //    37: invokevirtual   com/admarvel/android/ads/m.getContext:()Landroid/content/Context;
        //    40: invokestatic    com/admarvel/android/ads/r.a:(Landroid/content/Context;)Ljava/lang/String;
        //    43: astore          17
        //    45: invokestatic    com/admarvel/android/ads/Version.getAndroidSDKVersion:()I
        //    48: bipush          9
        //    50: if_icmpge       956
        //    53: aload           16
        //    55: invokevirtual   com/admarvel/android/ads/m.getResources:()Landroid/content/res/Resources;
        //    58: invokevirtual   android/content/res/Resources.getConfiguration:()Landroid/content/res/Configuration;
        //    61: getfield        android/content/res/Configuration.orientation:I
        //    64: istore_2       
        //    65: iload_2        
        //    66: iconst_1       
        //    67: if_icmpne       945
        //    70: iconst_0       
        //    71: istore_2       
        //    72: aload           17
        //    74: ldc             "wifi"
        //    76: invokevirtual   java/lang/String.equals:(Ljava/lang/Object;)Z
        //    79: ifne            1168
        //    82: aload           17
        //    84: ldc             "mobile"
        //    86: invokevirtual   java/lang/String.equals:(Ljava/lang/Object;)Z
        //    89: ifeq            1222
        //    92: goto            1168
        //    95: aload           16
        //    97: invokevirtual   com/admarvel/android/ads/m.getContext:()Landroid/content/Context;
        //   100: ldc             "location"
        //   102: invokestatic    com/admarvel/android/ads/r.b:(Landroid/content/Context;Ljava/lang/String;)Z
        //   105: ifeq            1156
        //   108: invokestatic    com/admarvel/android/util/c.a:()Lcom/admarvel/android/util/c;
        //   111: aload           15
        //   113: invokevirtual   com/admarvel/android/util/c.a:(Lcom/admarvel/android/ads/d;)Landroid/location/Location;
        //   116: astore          13
        //   118: aload           13
        //   120: ifnull          1230
        //   123: new             Ljava/lang/StringBuilder;
        //   126: dup            
        //   127: ldc             "{lat:"
        //   129: invokespecial   java/lang/StringBuilder.<init>:(Ljava/lang/String;)V
        //   132: aload           13
        //   134: invokevirtual   android/location/Location.getLatitude:()D
        //   137: invokevirtual   java/lang/StringBuilder.append:(D)Ljava/lang/StringBuilder;
        //   140: ldc             ", lon:"
        //   142: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   145: aload           13
        //   147: invokevirtual   android/location/Location.getLongitude:()D
        //   150: invokevirtual   java/lang/StringBuilder.append:(D)Ljava/lang/StringBuilder;
        //   153: ldc             ", acc:"
        //   155: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   158: aload           13
        //   160: invokevirtual   android/location/Location.getAccuracy:()F
        //   163: invokevirtual   java/lang/StringBuilder.append:(F)Ljava/lang/StringBuilder;
        //   166: ldc             "}"
        //   168: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   171: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   174: astore          13
        //   176: new             Ljava/lang/StringBuilder;
        //   179: dup            
        //   180: ldc             "{screen: true, orientation: true, heading: "
        //   182: invokespecial   java/lang/StringBuilder.<init>:(Ljava/lang/String;)V
        //   185: aload           16
        //   187: invokevirtual   com/admarvel/android/ads/m.getContext:()Landroid/content/Context;
        //   190: ldc             "compass"
        //   192: invokestatic    com/admarvel/android/ads/r.b:(Landroid/content/Context;Ljava/lang/String;)Z
        //   195: invokevirtual   java/lang/StringBuilder.append:(Z)Ljava/lang/StringBuilder;
        //   198: ldc             ", location : "
        //   200: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   203: astore          14
        //   205: aload           16
        //   207: invokevirtual   com/admarvel/android/ads/m.getContext:()Landroid/content/Context;
        //   210: ldc             "android.permission.ACCESS_COARSE_LOCATION"
        //   212: invokestatic    com/admarvel/android/ads/r.c:(Landroid/content/Context;Ljava/lang/String;)Z
        //   215: ifne            1176
        //   218: aload           16
        //   220: invokevirtual   com/admarvel/android/ads/m.getContext:()Landroid/content/Context;
        //   223: ldc             "android.permission.ACCESS_FINE_LOCATION"
        //   225: invokestatic    com/admarvel/android/ads/r.c:(Landroid/content/Context;Ljava/lang/String;)Z
        //   228: ifeq            1238
        //   231: goto            1176
        //   234: aload           14
        //   236: iload           11
        //   238: invokevirtual   java/lang/StringBuilder.append:(Z)Ljava/lang/StringBuilder;
        //   241: ldc             ",shake: "
        //   243: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   246: aload           16
        //   248: invokevirtual   com/admarvel/android/ads/m.getContext:()Landroid/content/Context;
        //   251: ldc             "accelerometer"
        //   253: invokestatic    com/admarvel/android/ads/r.b:(Landroid/content/Context;Ljava/lang/String;)Z
        //   256: invokevirtual   java/lang/StringBuilder.append:(Z)Ljava/lang/StringBuilder;
        //   259: ldc             ",tilt: "
        //   261: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   264: aload           16
        //   266: invokevirtual   com/admarvel/android/ads/m.getContext:()Landroid/content/Context;
        //   269: ldc             "accelerometer"
        //   271: invokestatic    com/admarvel/android/ads/r.b:(Landroid/content/Context;Ljava/lang/String;)Z
        //   274: invokevirtual   java/lang/StringBuilder.append:(Z)Ljava/lang/StringBuilder;
        //   277: ldc             ", network: true, sms:"
        //   279: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   282: aload           16
        //   284: invokevirtual   com/admarvel/android/ads/m.getContext:()Landroid/content/Context;
        //   287: invokestatic    com/admarvel/android/ads/r.j:(Landroid/content/Context;)Z
        //   290: invokevirtual   java/lang/StringBuilder.append:(Z)Ljava/lang/StringBuilder;
        //   293: ldc             ", phone:"
        //   295: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   298: aload           16
        //   300: invokevirtual   com/admarvel/android/ads/m.getContext:()Landroid/content/Context;
        //   303: invokestatic    com/admarvel/android/ads/r.j:(Landroid/content/Context;)Z
        //   306: invokevirtual   java/lang/StringBuilder.append:(Z)Ljava/lang/StringBuilder;
        //   309: ldc             ", email:true,calendar:"
        //   311: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   314: astore          14
        //   316: aload           16
        //   318: invokevirtual   com/admarvel/android/ads/m.getContext:()Landroid/content/Context;
        //   321: ldc             "android.permission.READ_CALENDAR"
        //   323: invokestatic    com/admarvel/android/ads/r.c:(Landroid/content/Context;Ljava/lang/String;)Z
        //   326: ifeq            1244
        //   329: aload           16
        //   331: invokevirtual   com/admarvel/android/ads/m.getContext:()Landroid/content/Context;
        //   334: ldc             "android.permission.WRITE_CALENDAR"
        //   336: invokestatic    com/admarvel/android/ads/r.c:(Landroid/content/Context;Ljava/lang/String;)Z
        //   339: ifeq            1244
        //   342: iconst_1       
        //   343: istore          11
        //   345: aload           14
        //   347: iload           11
        //   349: invokevirtual   java/lang/StringBuilder.append:(Z)Ljava/lang/StringBuilder;
        //   352: ldc             ", camera: "
        //   354: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   357: aload           16
        //   359: invokevirtual   com/admarvel/android/ads/m.getContext:()Landroid/content/Context;
        //   362: ldc             "camera"
        //   364: invokestatic    com/admarvel/android/ads/r.b:(Landroid/content/Context;Ljava/lang/String;)Z
        //   367: invokevirtual   java/lang/StringBuilder.append:(Z)Ljava/lang/StringBuilder;
        //   370: ldc             ",map:true, audio:true, video:true, 'level-1':true,'level-2': true, 'level-3':false}"
        //   372: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   375: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   378: astore          18
        //   380: aload           15
        //   382: getfield        com/admarvel/android/ads/d.d:Ljava/lang/ref/WeakReference;
        //   385: invokevirtual   java/lang/ref/WeakReference.get:()Ljava/lang/Object;
        //   388: checkcast       Lcom/admarvel/android/ads/AdMarvelView;
        //   391: astore          14
        //   393: aload           14
        //   395: ifnull          1142
        //   398: iconst_2       
        //   399: newarray        I
        //   401: astore          19
        //   403: aload           15
        //   405: aload           19
        //   407: invokevirtual   com/admarvel/android/ads/d.getLocationOnScreen:([I)V
        //   410: aload           16
        //   412: invokevirtual   com/admarvel/android/ads/m.getContext:()Landroid/content/Context;
        //   415: instanceof      Landroid/app/Activity;
        //   418: ifeq            1137
        //   421: aload           16
        //   423: invokevirtual   com/admarvel/android/ads/m.getContext:()Landroid/content/Context;
        //   426: checkcast       Landroid/app/Activity;
        //   429: astore          20
        //   431: aload           20
        //   433: ifnull          1137
        //   436: aload           16
        //   438: getfield        com/admarvel/android/ads/m.v:I
        //   441: ldc             -2147483648
        //   443: if_icmpeq       1024
        //   446: aload           16
        //   448: getfield        com/admarvel/android/ads/m.v:I
        //   451: iflt            1024
        //   454: aload           16
        //   456: getfield        com/admarvel/android/ads/m.v:I
        //   459: istore_3       
        //   460: aload           19
        //   462: iconst_0       
        //   463: iaload         
        //   464: istore          6
        //   466: aload           19
        //   468: iconst_1       
        //   469: iaload         
        //   470: iload_3        
        //   471: isub           
        //   472: istore          5
        //   474: aload           16
        //   476: invokevirtual   com/admarvel/android/ads/m.getAdMarvelAd:()Lcom/admarvel/android/ads/AdMarvelAd;
        //   479: ifnull          1120
        //   482: aload           16
        //   484: invokevirtual   com/admarvel/android/ads/m.getAdMarvelAd:()Lcom/admarvel/android/ads/AdMarvelAd;
        //   487: invokevirtual   com/admarvel/android/ads/AdMarvelAd.getAdMarvelViewWidth:()F
        //   490: ldc             -1.0
        //   492: fcmpl          
        //   493: ifeq            1110
        //   496: aload           16
        //   498: invokevirtual   com/admarvel/android/ads/m.getAdMarvelAd:()Lcom/admarvel/android/ads/AdMarvelAd;
        //   501: invokevirtual   com/admarvel/android/ads/AdMarvelAd.getAdMarvelViewWidth:()F
        //   504: aload           16
        //   506: invokevirtual   com/admarvel/android/ads/m.getContext:()Landroid/content/Context;
        //   509: invokestatic    com/admarvel/android/ads/r.i:(Landroid/content/Context;)F
        //   512: fmul           
        //   513: fstore_1       
        //   514: goto            1182
        //   517: aload           14
        //   519: invokevirtual   com/admarvel/android/ads/AdMarvelView.getHeight:()I
        //   522: istore          7
        //   524: aload           15
        //   526: iload           6
        //   528: putfield        com/admarvel/android/ads/d.h:I
        //   531: aload           15
        //   533: iload           5
        //   535: putfield        com/admarvel/android/ads/d.i:I
        //   538: iload_3        
        //   539: istore          4
        //   541: iload           7
        //   543: istore_3       
        //   544: aload           16
        //   546: invokevirtual   com/admarvel/android/ads/m.getRootView:()Landroid/view/View;
        //   549: invokevirtual   android/view/View.getLeft:()I
        //   552: istore          9
        //   554: aload           16
        //   556: invokevirtual   com/admarvel/android/ads/m.getRootView:()Landroid/view/View;
        //   559: invokevirtual   android/view/View.getTop:()I
        //   562: istore          10
        //   564: aload           16
        //   566: invokevirtual   com/admarvel/android/ads/m.getRootView:()Landroid/view/View;
        //   569: invokevirtual   android/view/View.getWidth:()I
        //   572: istore          8
        //   574: aload           16
        //   576: invokevirtual   com/admarvel/android/ads/m.getRootView:()Landroid/view/View;
        //   579: invokevirtual   android/view/View.getHeight:()I
        //   582: istore          7
        //   584: aload           16
        //   586: invokevirtual   com/admarvel/android/ads/m.getContext:()Landroid/content/Context;
        //   589: instanceof      Landroid/app/Activity;
        //   592: ifeq            1129
        //   595: aload           16
        //   597: invokevirtual   com/admarvel/android/ads/m.getContext:()Landroid/content/Context;
        //   600: checkcast       Landroid/app/Activity;
        //   603: astore          19
        //   605: aload           19
        //   607: ifnull          1129
        //   610: aload           19
        //   612: invokestatic    com/admarvel/android/ads/r.a:(Landroid/app/Activity;)Ljava/lang/String;
        //   615: astore          14
        //   617: aload           19
        //   619: invokevirtual   android/app/Activity.getWindow:()Landroid/view/Window;
        //   622: ldc             16908290
        //   624: invokevirtual   android/view/Window.findViewById:(I)Landroid/view/View;
        //   627: checkcast       Landroid/view/ViewGroup;
        //   630: astore          19
        //   632: aload           19
        //   634: invokevirtual   android/view/ViewGroup.getLeft:()I
        //   637: istore          9
        //   639: aload           19
        //   641: invokevirtual   android/view/ViewGroup.getTop:()I
        //   644: istore          10
        //   646: aload           19
        //   648: invokevirtual   android/view/ViewGroup.getWidth:()I
        //   651: istore          8
        //   653: aload           19
        //   655: invokevirtual   android/view/ViewGroup.getHeight:()I
        //   658: istore          7
        //   660: new             Ljava/lang/StringBuilder;
        //   663: dup            
        //   664: invokespecial   java/lang/StringBuilder.<init>:()V
        //   667: aload_0        
        //   668: getfield        com/admarvel/android/ads/m$p.a:Ljava/lang/String;
        //   671: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   674: ldc             "({x:"
        //   676: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   679: iload           6
        //   681: invokevirtual   java/lang/StringBuilder.append:(I)Ljava/lang/StringBuilder;
        //   684: ldc_w           ",y:"
        //   687: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   690: iload           5
        //   692: invokevirtual   java/lang/StringBuilder.append:(I)Ljava/lang/StringBuilder;
        //   695: ldc_w           ",width:"
        //   698: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   701: iload           4
        //   703: invokevirtual   java/lang/StringBuilder.append:(I)Ljava/lang/StringBuilder;
        //   706: ldc_w           ",height:"
        //   709: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   712: iload_3        
        //   713: invokevirtual   java/lang/StringBuilder.append:(I)Ljava/lang/StringBuilder;
        //   716: ldc_w           ",appX:"
        //   719: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   722: iload           9
        //   724: invokevirtual   java/lang/StringBuilder.append:(I)Ljava/lang/StringBuilder;
        //   727: ldc_w           ",appY:"
        //   730: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   733: iload           10
        //   735: invokevirtual   java/lang/StringBuilder.append:(I)Ljava/lang/StringBuilder;
        //   738: ldc_w           ",appWidth:"
        //   741: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   744: iload           8
        //   746: invokevirtual   java/lang/StringBuilder.append:(I)Ljava/lang/StringBuilder;
        //   749: ldc_w           ",appHeight:"
        //   752: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   755: iload           7
        //   757: invokevirtual   java/lang/StringBuilder.append:(I)Ljava/lang/StringBuilder;
        //   760: ldc_w           ",orientation:"
        //   763: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   766: iload_2        
        //   767: invokevirtual   java/lang/StringBuilder.append:(I)Ljava/lang/StringBuilder;
        //   770: ldc_w           ",networkType:'"
        //   773: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   776: aload           17
        //   778: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   781: ldc_w           "',network:'"
        //   784: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   787: aload           12
        //   789: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   792: ldc_w           "',screenWidth:"
        //   795: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   798: aload           16
        //   800: invokevirtual   com/admarvel/android/ads/m.getContext:()Landroid/content/Context;
        //   803: invokestatic    com/admarvel/android/ads/r.g:(Landroid/content/Context;)I
        //   806: invokevirtual   java/lang/StringBuilder.append:(I)Ljava/lang/StringBuilder;
        //   809: ldc_w           ",screenHeight:"
        //   812: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   815: aload           16
        //   817: invokevirtual   com/admarvel/android/ads/m.getContext:()Landroid/content/Context;
        //   820: invokestatic    com/admarvel/android/ads/r.h:(Landroid/content/Context;)I
        //   823: invokevirtual   java/lang/StringBuilder.append:(I)Ljava/lang/StringBuilder;
        //   826: ldc_w           ",adType:'"
        //   829: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   832: ldc_w           "Banner"
        //   835: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   838: ldc_w           "',supportedFeatures:"
        //   841: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   844: aload           18
        //   846: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   849: ldc_w           ",sdkVersion:'"
        //   852: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   855: ldc_w           "2.4.6"
        //   858: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   861: ldc_w           "',location:"
        //   864: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   867: aload           13
        //   869: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   872: ldc_w           ",applicationSupportedOrientations:'"
        //   875: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   878: aload           14
        //   880: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   883: ldc_w           "'})"
        //   886: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   889: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   892: astore          12
        //   894: new             Ljava/lang/StringBuilder;
        //   897: dup            
        //   898: ldc_w           "Initial Frame Values : "
        //   901: invokespecial   java/lang/StringBuilder.<init>:(Ljava/lang/String;)V
        //   904: aload           12
        //   906: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   909: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   912: invokestatic    com/admarvel/android/util/Logging.log:(Ljava/lang/String;)V
        //   915: aload           15
        //   917: aload           12
        //   919: invokevirtual   com/admarvel/android/ads/d.e:(Ljava/lang/String;)V
        //   922: return         
        //   923: astore          12
        //   925: aload           12
        //   927: invokestatic    android/util/Log.getStackTraceString:(Ljava/lang/Throwable;)Ljava/lang/String;
        //   930: invokestatic    com/admarvel/android/util/Logging.log:(Ljava/lang/String;)V
        //   933: return         
        //   934: astore          12
        //   936: aload           12
        //   938: invokestatic    android/util/Log.getStackTraceString:(Ljava/lang/Throwable;)Ljava/lang/String;
        //   941: invokestatic    com/admarvel/android/util/Logging.log:(Ljava/lang/String;)V
        //   944: return         
        //   945: iload_2        
        //   946: iconst_2       
        //   947: if_icmpne       1162
        //   950: bipush          90
        //   952: istore_2       
        //   953: goto            72
        //   956: aload           16
        //   958: aload           16
        //   960: invokevirtual   com/admarvel/android/ads/m.getContext:()Landroid/content/Context;
        //   963: ldc_w           "window"
        //   966: invokevirtual   android/content/Context.getSystemService:(Ljava/lang/String;)Ljava/lang/Object;
        //   969: checkcast       Landroid/view/WindowManager;
        //   972: invokeinterface android/view/WindowManager.getDefaultDisplay:()Landroid/view/Display;
        //   977: invokevirtual   android/view/Display.getRotation:()I
        //   980: putfield        com/admarvel/android/ads/m.u:I
        //   983: aload           16
        //   985: getfield        com/admarvel/android/ads/m.u:I
        //   988: istore_2       
        //   989: iload_2        
        //   990: ifne            1188
        //   993: iconst_0       
        //   994: istore_2       
        //   995: goto            72
        //   998: astore          20
        //  1000: aload           19
        //  1002: iconst_0       
        //  1003: iconst_0       
        //  1004: iastore        
        //  1005: aload           19
        //  1007: iconst_1       
        //  1008: iconst_0       
        //  1009: iastore        
        //  1010: goto            410
        //  1013: astore          12
        //  1015: aload           12
        //  1017: invokestatic    android/util/Log.getStackTraceString:(Ljava/lang/Throwable;)Ljava/lang/String;
        //  1020: invokestatic    com/admarvel/android/util/Logging.log:(Ljava/lang/String;)V
        //  1023: return         
        //  1024: aload           20
        //  1026: invokevirtual   android/app/Activity.getWindow:()Landroid/view/Window;
        //  1029: ldc             16908290
        //  1031: invokevirtual   android/view/Window.findViewById:(I)Landroid/view/View;
        //  1034: checkcast       Landroid/view/ViewGroup;
        //  1037: astore          21
        //  1039: new             Landroid/util/DisplayMetrics;
        //  1042: dup            
        //  1043: invokespecial   android/util/DisplayMetrics.<init>:()V
        //  1046: astore          22
        //  1048: aload           20
        //  1050: invokevirtual   android/app/Activity.getWindowManager:()Landroid/view/WindowManager;
        //  1053: invokeinterface android/view/WindowManager.getDefaultDisplay:()Landroid/view/Display;
        //  1058: aload           22
        //  1060: invokevirtual   android/view/Display.getMetrics:(Landroid/util/DisplayMetrics;)V
        //  1063: aload           22
        //  1065: getfield        android/util/DisplayMetrics.heightPixels:I
        //  1068: aload           21
        //  1070: invokevirtual   android/view/ViewGroup.getMeasuredHeight:()I
        //  1073: isub           
        //  1074: istore          4
        //  1076: iload           4
        //  1078: istore_3       
        //  1079: iload           4
        //  1081: iflt            460
        //  1084: iload           4
        //  1086: istore_3       
        //  1087: aload           16
        //  1089: getfield        com/admarvel/android/ads/m.v:I
        //  1092: ldc             -2147483648
        //  1094: if_icmpne       460
        //  1097: aload           16
        //  1099: iload           4
        //  1101: putfield        com/admarvel/android/ads/m.v:I
        //  1104: iload           4
        //  1106: istore_3       
        //  1107: goto            460
        //  1110: aload           14
        //  1112: invokevirtual   com/admarvel/android/ads/AdMarvelView.getWidth:()I
        //  1115: i2f            
        //  1116: fstore_1       
        //  1117: goto            1182
        //  1120: aload           14
        //  1122: invokevirtual   com/admarvel/android/ads/AdMarvelView.getWidth:()I
        //  1125: istore_3       
        //  1126: goto            517
        //  1129: ldc_w           "0,90"
        //  1132: astore          14
        //  1134: goto            660
        //  1137: iconst_0       
        //  1138: istore_3       
        //  1139: goto            460
        //  1142: iconst_0       
        //  1143: istore_3       
        //  1144: iconst_0       
        //  1145: istore          4
        //  1147: iconst_0       
        //  1148: istore          5
        //  1150: iconst_0       
        //  1151: istore          6
        //  1153: goto            544
        //  1156: aconst_null    
        //  1157: astore          13
        //  1159: goto            118
        //  1162: iconst_m1      
        //  1163: istore_2       
        //  1164: goto            72
        //  1167: return         
        //  1168: ldc_w           "YES"
        //  1171: astore          12
        //  1173: goto            95
        //  1176: iconst_1       
        //  1177: istore          11
        //  1179: goto            234
        //  1182: fload_1        
        //  1183: f2i            
        //  1184: istore_3       
        //  1185: goto            517
        //  1188: iload_2        
        //  1189: iconst_1       
        //  1190: if_icmpne       1199
        //  1193: bipush          90
        //  1195: istore_2       
        //  1196: goto            72
        //  1199: iload_2        
        //  1200: iconst_2       
        //  1201: if_icmpne       1211
        //  1204: sipush          180
        //  1207: istore_2       
        //  1208: goto            72
        //  1211: iload_2        
        //  1212: iconst_3       
        //  1213: if_icmpne       1162
        //  1216: bipush          -90
        //  1218: istore_2       
        //  1219: goto            72
        //  1222: ldc_w           "NO"
        //  1225: astore          12
        //  1227: goto            95
        //  1230: ldc_w           "null"
        //  1233: astore          13
        //  1235: goto            176
        //  1238: iconst_0       
        //  1239: istore          11
        //  1241: goto            234
        //  1244: iconst_0       
        //  1245: istore          11
        //  1247: goto            345
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                            
        //  -----  -----  -----  -----  --------------------------------
        //  0      24     934    945    Ljava/lang/NullPointerException;
        //  0      24     1013   1024   Ljava/lang/Exception;
        //  35     65     934    945    Ljava/lang/NullPointerException;
        //  35     65     1013   1024   Ljava/lang/Exception;
        //  72     92     934    945    Ljava/lang/NullPointerException;
        //  72     92     1013   1024   Ljava/lang/Exception;
        //  95     118    934    945    Ljava/lang/NullPointerException;
        //  95     118    1013   1024   Ljava/lang/Exception;
        //  123    176    934    945    Ljava/lang/NullPointerException;
        //  123    176    1013   1024   Ljava/lang/Exception;
        //  176    231    934    945    Ljava/lang/NullPointerException;
        //  176    231    1013   1024   Ljava/lang/Exception;
        //  234    342    934    945    Ljava/lang/NullPointerException;
        //  234    342    1013   1024   Ljava/lang/Exception;
        //  345    393    934    945    Ljava/lang/NullPointerException;
        //  345    393    1013   1024   Ljava/lang/Exception;
        //  398    403    934    945    Ljava/lang/NullPointerException;
        //  398    403    1013   1024   Ljava/lang/Exception;
        //  403    410    998    1013   Ljava/lang/Exception;
        //  403    410    934    945    Ljava/lang/NullPointerException;
        //  410    431    934    945    Ljava/lang/NullPointerException;
        //  410    431    1013   1024   Ljava/lang/Exception;
        //  436    460    934    945    Ljava/lang/NullPointerException;
        //  436    460    1013   1024   Ljava/lang/Exception;
        //  474    514    934    945    Ljava/lang/NullPointerException;
        //  474    514    1013   1024   Ljava/lang/Exception;
        //  517    538    934    945    Ljava/lang/NullPointerException;
        //  517    538    1013   1024   Ljava/lang/Exception;
        //  544    605    934    945    Ljava/lang/NullPointerException;
        //  544    605    1013   1024   Ljava/lang/Exception;
        //  610    660    934    945    Ljava/lang/NullPointerException;
        //  610    660    1013   1024   Ljava/lang/Exception;
        //  660    922    923    934    Ljava/lang/Exception;
        //  660    922    934    945    Ljava/lang/NullPointerException;
        //  925    933    934    945    Ljava/lang/NullPointerException;
        //  925    933    1013   1024   Ljava/lang/Exception;
        //  956    989    934    945    Ljava/lang/NullPointerException;
        //  956    989    1013   1024   Ljava/lang/Exception;
        //  1024   1076   934    945    Ljava/lang/NullPointerException;
        //  1024   1076   1013   1024   Ljava/lang/Exception;
        //  1087   1104   934    945    Ljava/lang/NullPointerException;
        //  1087   1104   1013   1024   Ljava/lang/Exception;
        //  1110   1117   934    945    Ljava/lang/NullPointerException;
        //  1110   1117   1013   1024   Ljava/lang/Exception;
        //  1120   1126   934    945    Ljava/lang/NullPointerException;
        //  1120   1126   1013   1024   Ljava/lang/Exception;
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
