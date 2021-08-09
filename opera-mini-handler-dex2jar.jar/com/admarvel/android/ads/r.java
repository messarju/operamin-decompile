// 
// Decompiled by Procyon v0.6-prerelease
// 

package com.admarvel.android.ads;

import android.os.Handler;
import android.os.Looper;
import java.lang.reflect.Constructor;
import android.webkit.WebView;
import android.webkit.WebSettings;
import java.util.zip.GZIPInputStream;
import java.io.InputStream;
import java.io.Reader;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Calendar;
import java.net.MalformedURLException;
import android.annotation.SuppressLint;
import android.graphics.Point;
import java.io.UnsupportedEncodingException;
import android.util.Log;
import com.admarvel.android.util.f;
import android.view.Display;
import android.location.LocationManager;
import com.admarvel.android.util.d;
import android.hardware.Camera;
import android.telephony.TelephonyManager;
import android.os.Build;
import java.util.Locale;
import android.os.Build$VERSION;
import android.content.ActivityNotFoundException;
import com.admarvel.android.util.Logging;
import java.net.URLDecoder;
import android.net.Uri;
import android.webkit.URLUtil;
import android.content.pm.PackageManager$NameNotFoundException;
import android.content.Intent;
import android.os.Vibrator;
import java.util.Iterator;
import java.net.URLEncoder;
import java.util.Map;
import java.net.URL;
import java.net.HttpURLConnection;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.File;
import android.os.Environment;
import java.io.FileInputStream;
import android.net.NetworkInfo;
import android.net.ConnectivityManager;
import android.app.Activity;
import android.util.TypedValue;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import android.content.Context;
import java.lang.ref.WeakReference;

public class r
{
    public static String a;
    public static boolean b;
    private WeakReference c;
    private String d;
    
    static {
        r.a = "";
    }
    
    public r(final Context context) {
        this.c = new WeakReference((T)context);
    }
    
    public static float a(final Context context, final int n, final int n2) {
        final WindowManager windowManager = (WindowManager)context.getApplicationContext().getSystemService("window");
        final DisplayMetrics displayMetrics = new DisplayMetrics();
        windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        return Math.min(displayMetrics.density, n / (float)n2);
    }
    
    public static int a(final float n, final Context context) {
        return (int)TypedValue.applyDimension(1, n, context.getResources().getDisplayMetrics());
    }
    
    public static int a(final AdMarvelUtils$ErrorReason adMarvelUtils$ErrorReason) {
        switch (r$5.a[adMarvelUtils$ErrorReason.ordinal()]) {
            default: {
                return -1;
            }
            case 1: {
                return 201;
            }
            case 2: {
                return 202;
            }
            case 3: {
                return 203;
            }
            case 4: {
                return 204;
            }
            case 5: {
                return 205;
            }
            case 6: {
                return 206;
            }
            case 7: {
                return 207;
            }
            case 8: {
                return 208;
            }
            case 9: {
                return 301;
            }
            case 10: {
                return 302;
            }
            case 11: {
                return 303;
            }
            case 12: {
                return 304;
            }
            case 13: {
                return 305;
            }
            case 14: {
                return 306;
            }
            case 15: {
                return 307;
            }
            case 16: {
                return 308;
            }
        }
    }
    
    public static AdMarvelUtils$ErrorReason a(final int n) {
        switch (n) {
            default: {
                return null;
            }
            case 201: {
                return AdMarvelUtils$ErrorReason.SITE_ID_OR_PARTNER_ID_NOT_PRESENT;
            }
            case 202: {
                return AdMarvelUtils$ErrorReason.SITE_ID_AND_PARTNER_ID_DO_NOT_MATCH;
            }
            case 203: {
                return AdMarvelUtils$ErrorReason.BOT_USER_AGENT_FOUND;
            }
            case 204: {
                return AdMarvelUtils$ErrorReason.NO_BANNER_FOUND;
            }
            case 205: {
                return AdMarvelUtils$ErrorReason.NO_AD_FOUND;
            }
            case 206: {
                return AdMarvelUtils$ErrorReason.NO_USER_AGENT_FOUND;
            }
            case 207: {
                return AdMarvelUtils$ErrorReason.SITE_ID_NOT_PRESENT;
            }
            case 208: {
                return AdMarvelUtils$ErrorReason.PARTNER_ID_NOT_PRESENT;
            }
            case 301: {
                return AdMarvelUtils$ErrorReason.NO_NETWORK_CONNECTIVITY;
            }
            case 302: {
                return AdMarvelUtils$ErrorReason.NETWORK_CONNECTIVITY_DISRUPTED;
            }
            case 303: {
                return AdMarvelUtils$ErrorReason.AD_REQUEST_XML_PARSING_EXCEPTION;
            }
            case 304: {
                return AdMarvelUtils$ErrorReason.AD_REQUEST_IN_PROCESS_EXCEPTION;
            }
            case 305: {
                return AdMarvelUtils$ErrorReason.AD_UNIT_NOT_ABLE_TO_RENDER;
            }
            case 306: {
                return AdMarvelUtils$ErrorReason.AD_REQUEST_MISSING_XML_ELEMENTS;
            }
            case 307: {
                return AdMarvelUtils$ErrorReason.AD_REQUEST_SDK_TYPE_UNSUPPORTED;
            }
            case 308: {
                return AdMarvelUtils$ErrorReason.AD_UNIT_NOT_ABLE_TO_LOAD;
            }
        }
    }
    
    public static r$j a(final String s, final String s2) {
        if (s.startsWith(s2 + "://")) {
            return r$j.a;
        }
        if (s.startsWith(s2)) {
            return r$j.b;
        }
        return r$j.c;
    }
    
    public static String a(final Activity activity) {
        final int requestedOrientation = activity.getRequestedOrientation();
        if (Version.getAndroidSDKVersion() < 9) {
            switch (requestedOrientation) {
                default: {
                    return "0";
                }
                case -1: {
                    return "0,90";
                }
                case 2: {
                    return "0,90";
                }
                case 3: {
                    return "0,90";
                }
                case 0: {
                    return "90";
                }
                case 1: {
                    return "0";
                }
                case 4: {
                    return "0,90";
                }
                case 5: {
                    return "0";
                }
            }
        }
        else {
            switch (requestedOrientation) {
                default: {
                    return "";
                }
                case -1: {
                    return "0,-90,90";
                }
                case 2: {
                    return "0,90,-90";
                }
                case 3: {
                    return "0,90,-90";
                }
                case 0: {
                    return "90";
                }
                case 1: {
                    return "0";
                }
                case 8: {
                    return "-90";
                }
                case 9: {
                    return "180";
                }
                case 6: {
                    return "90,-90";
                }
                case 7: {
                    return "180,-180";
                }
                case 4: {
                    return "0,-90,90";
                }
                case 10: {
                    return "0,-90,90,180";
                }
                case 5: {
                    return "0";
                }
            }
        }
    }
    
    public static String a(final Context context) {
        if (context == null) {
            throw new NullPointerException();
        }
        if (!c(context, "android.permission.ACCESS_NETWORK_STATE")) {
            return "unknown";
        }
        final ConnectivityManager connectivityManager = (ConnectivityManager)context.getSystemService("connectivity");
        final NetworkInfo networkInfo = connectivityManager.getNetworkInfo(1);
        final NetworkInfo networkInfo2 = connectivityManager.getNetworkInfo(0);
        if (networkInfo != null && networkInfo.isAvailable()) {
            return "wifi";
        }
        if (networkInfo2 != null && networkInfo2.isAvailable()) {
            return "mobile";
        }
        return "none";
    }
    
    public static String a(final FileInputStream fileInputStream, String s) {
        final File file = new File(Environment.getExternalStorageDirectory() + "/.admfiles");
        if (!file.exists()) {
            file.mkdirs();
        }
        s = (String)new File(file.getAbsolutePath() + "/" + s);
        if (((File)s).exists()) {
            goto Label_0132;
        }
        final byte[] array = new byte[16384];
        try {
            ((File)s).createNewFile();
            final FileOutputStream fileOutputStream = new FileOutputStream((File)s);
            while (true) {
                final int read = fileInputStream.read(array);
                if (read == -1) {
                    goto Label_0137;
                }
                fileOutputStream.write(array, 0, read);
            }
        }
        catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
        catch (IOException ex2) {
            ex2.printStackTrace();
            goto Label_0132;
        }
    }
    
    static String a(final String s, final Context context) {
        String s2 = s;
        if (s != null) {
            s2 = s;
            if (s.length() > 0) {
                String headerField = s;
                try {
                    while (true) {
                        final HttpURLConnection httpURLConnection = (HttpURLConnection)new URL(headerField).openConnection();
                        httpURLConnection.setRequestMethod("GET");
                        httpURLConnection.setDoInput(true);
                        httpURLConnection.setUseCaches(false);
                        httpURLConnection.setRequestProperty("User-Agent", new r(context).a());
                        httpURLConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
                        httpURLConnection.setRequestProperty("Content-Length", "0");
                        httpURLConnection.setConnectTimeout(4000);
                        httpURLConnection.setReadTimeout(5000);
                        httpURLConnection.setInstanceFollowRedirects(false);
                        httpURLConnection.connect();
                        final int responseCode = httpURLConnection.getResponseCode();
                        if (responseCode != 301 && responseCode != 302) {
                            break;
                        }
                        headerField = httpURLConnection.getHeaderField("Location");
                    }
                }
                catch (Exception ex) {}
                s2 = s;
                if (headerField != null) {
                    s2 = s;
                    if (headerField.length() > 0) {
                        s2 = headerField;
                    }
                }
            }
        }
        return s2;
    }
    
    public static String a(String replaceFirst, final String s, final String s2, final r$j r$j, final Context context) {
        String replace = replaceFirst;
        if (replaceFirst != null) {
            replace = replaceFirst;
            if (replaceFirst.length() > 0) {
                replace = replaceFirst.replace("content://" + context.getPackageName() + ".AdMarvelLocalFileContentProvider", "");
            }
        }
        replaceFirst = null;
        if (r$j == r$j.a) {
            replaceFirst = replace.replaceFirst(s + "://", s2);
        }
        else if (r$j == r$j.b) {
            return replace.replaceFirst(s, s2);
        }
        return replaceFirst;
    }
    
    public static String a(final Map map, final String s) {
        if (map == null) {
            return null;
        }
        final StringBuilder sb = new StringBuilder();
        for (final String s2 : map.keySet()) {
            String s3;
            if (map.get(s2) instanceof String) {
                s3 = map.get(s2);
            }
            else {
                s3 = null;
            }
            if (s3 != null && s3.length() > 0) {
                if (sb.length() > 0) {
                    sb.append(s);
                }
                sb.append(URLEncoder.encode(s2, "UTF-8")).append("=>").append(URLEncoder.encode(s3, "UTF-8"));
            }
        }
        return sb.toString();
    }
    
    public static void a(final StringBuilder sb, final String s, final String s2) {
        if (sb != null && s2 != null && s != null) {
            sb.append("&").append(s).append("=").append(URLEncoder.encode(s2, "UTF-8"));
        }
    }
    
    public static boolean a(final Context context, final int n) {
        if (context == null) {
            return true;
        }
        try {
            if (c(context, "android.permission.VIBRATE")) {
                ((Vibrator)context.getSystemService("vibrator")).vibrate((long)n);
            }
            return true;
        }
        catch (Exception ex) {
            return false;
        }
    }
    
    public static boolean a(final Context context, final Intent intent) {
        return context.getPackageManager().queryIntentActivities(intent, 65536).size() > 0;
    }
    
    static boolean a(final Context context, final String s) {
        try {
            context.getPackageManager().getApplicationInfo(s, 0);
            return true;
        }
        catch (PackageManager$NameNotFoundException ex) {
            return false;
        }
    }
    
    public static boolean a(final Context context, String decode, final boolean b) {
        Label_0742: {
            Label_0713: {
                String substring = null;
                FileInputStream e = null;
                Label_0348: {
                    while (true) {
                        while (true) {
                            Uri parse;
                            Intent intent2;
                            try {
                                if ((!AdMarvelView.a && !AdMarvelInterstitialAds.enableOfflineSDK) || decode == null || !decode.contains("/") || URLUtil.isNetworkUrl(decode)) {
                                    break Label_0742;
                                }
                                substring = decode.substring(decode.lastIndexOf("/") + 1);
                                if (!l(substring)) {
                                    break;
                                }
                                parse = Uri.parse(substring);
                                if (Version.getAndroidSDKVersion() > 18) {
                                    String decode2 = null;
                                    if (decode.contains("?body=")) {
                                        decode2 = URLDecoder.decode(decode.split("\\?body=")[1]);
                                    }
                                    final Intent intent = new Intent("android.intent.action.SENDTO", Uri.parse(decode));
                                    if (decode2 != null && decode2.trim().length() > 0) {
                                        intent.putExtra("sms_body", decode2);
                                    }
                                    if (a(context, intent)) {
                                        context.startActivity(intent);
                                        return true;
                                    }
                                    break Label_0348;
                                }
                                else {
                                    intent2 = new Intent("android.intent.action.VIEW");
                                    if (decode.contains("?body=")) {
                                        final String[] split = decode.split("\\?body=");
                                        intent2.putExtra("address", URLDecoder.decode(split[0]).substring(4));
                                        intent2.putExtra("sms_body", URLDecoder.decode(split[1]));
                                        intent2.setType("vnd.android-dir/mms-sms");
                                        intent2.addFlags(268435456);
                                        if (b) {
                                            intent2.addFlags(8388608);
                                        }
                                        if (a(context, intent2)) {
                                            context.startActivity(intent2);
                                            return true;
                                        }
                                        break Label_0348;
                                    }
                                }
                            }
                            catch (Exception ex) {
                                Logging.log(" Exception in handling special intents");
                                return false;
                            }
                            intent2.putExtra("address", parse.toString().substring(4));
                            continue;
                        }
                    }
                    if (k(substring)) {
                        final Intent intent3 = new Intent("android.intent.action.DIAL", Uri.parse(substring));
                        intent3.addFlags(268435456);
                        if (b) {
                            intent3.addFlags(8388608);
                        }
                        if (a(context, intent3)) {
                            context.startActivity(intent3);
                            return true;
                        }
                    }
                    try {
                        e = e(decode);
                        if (e == null || substring == null) {
                            break Label_0713;
                        }
                        if (r(decode)) {
                            final String a = a(e, substring);
                            if (a == null) {
                                break Label_0742;
                            }
                            final Intent intent4 = new Intent("android.intent.action.VIEW");
                            intent4.addFlags(268435456);
                            if (b) {
                                intent4.addFlags(8388608);
                            }
                            intent4.setDataAndType(Uri.fromFile(new File(a)), "video/*");
                            if (a(context, intent4)) {
                                context.startActivity(intent4);
                                return true;
                            }
                            return true;
                        }
                    }
                    catch (Exception ex2) {
                        if (r(decode) || t(decode) || s(decode)) {
                            Logging.log(" ");
                            return true;
                        }
                        break Label_0742;
                    }
                }
                if (s(decode)) {
                    final String a2 = a(e, substring);
                    if (a2 == null) {
                        break Label_0742;
                    }
                    final Intent intent5 = new Intent("android.intent.action.VIEW");
                    intent5.addFlags(268435456);
                    if (b) {
                        intent5.addFlags(8388608);
                    }
                    intent5.setDataAndType(Uri.fromFile(new File(a2)), "audio/*");
                    if (a(context, intent5)) {
                        context.startActivity(intent5);
                        return true;
                    }
                    return true;
                }
                else {
                    if (!t(decode)) {
                        break Label_0742;
                    }
                    final String a3 = a(e, substring);
                    if (a3 == null) {
                        return true;
                    }
                    final Intent intent6 = new Intent("android.intent.action.VIEW", Uri.parse(a3));
                    intent6.setDataAndType(Uri.fromFile(new File(a3)), "application/pdf");
                    intent6.setFlags(268435456);
                    if (b) {
                        intent6.addFlags(8388608);
                    }
                    if (a(context, intent6)) {
                        context.startActivity(intent6);
                        return true;
                    }
                    final Intent intent7 = new Intent("android.intent.action.VIEW", Uri.parse(decode));
                    intent7.addFlags(268435456);
                    if (b) {
                        intent7.addFlags(8388608);
                    }
                    if (a(context, intent7)) {
                        context.startActivity(intent7);
                        return true;
                    }
                    return true;
                }
            }
            if (r(decode) || t(decode) || s(decode)) {
                Logging.log(" ");
                return true;
            }
        }
        String replace;
        if ((replace = decode) != null) {
            replace = decode;
            if (decode.length() > 0) {
                replace = decode.replace("content://" + context.getPackageName() + ".AdMarvelLocalFileContentProvider", "");
            }
        }
        Label_0898: {
            try {
                if (!f(context) || !h(replace)) {
                    break Label_0898;
                }
                final Intent intent8 = new Intent("android.intent.action.VIEW");
                intent8.addFlags(268435456);
                if (b) {
                    intent8.addFlags(8388608);
                }
                intent8.setDataAndType(Uri.parse(replace), "video/*");
                if (a(context, intent8)) {
                    context.startActivity(intent8);
                    return true;
                }
            }
            catch (ActivityNotFoundException ex3) {
                Logging.log(" ActivityNotFoundException");
                r.b = g(replace);
                if (AdMarvelView.a || AdMarvelInterstitialAds.enableOfflineSDK) {
                    if (!r.b) {
                        return true;
                    }
                }
            }
            return false;
        }
        if (f(context) && i(replace)) {
            final Intent intent9 = new Intent("android.intent.action.VIEW");
            intent9.addFlags(268435456);
            if (b) {
                intent9.addFlags(8388608);
            }
            intent9.setDataAndType(Uri.parse(replace), "audio/*");
            if (a(context, intent9)) {
                context.startActivity(intent9);
                return true;
            }
            return false;
        }
        else if (f(context) && o(replace)) {
            final Intent intent10 = new Intent("android.intent.action.VIEW", Uri.parse(replace));
            intent10.setDataAndType(Uri.parse(replace), "application/pdf");
            intent10.setFlags(268435456);
            if (b) {
                intent10.addFlags(8388608);
            }
            if (a(context, intent10)) {
                context.startActivity(intent10);
                return true;
            }
            final Intent intent11 = new Intent("android.intent.action.VIEW", Uri.parse(replace));
            intent11.addFlags(268435456);
            if (a(context, intent11)) {
                context.startActivity(intent11);
                return true;
            }
        }
        else if (l(replace)) {
            if (Version.getAndroidSDKVersion() >= 19) {
                decode = null;
                if (replace.contains("?body=")) {
                    decode = URLDecoder.decode(replace.split("\\?body=")[1]);
                }
                final Intent intent12 = new Intent("android.intent.action.SENDTO", Uri.parse(replace));
                if (decode != null && decode.trim().length() > 0) {
                    intent12.putExtra("sms_body", decode);
                }
                if (a(context, intent12)) {
                    context.startActivity(intent12);
                    return true;
                }
                return false;
            }
            else {
                final Uri parse2 = Uri.parse(replace);
                final Intent intent13 = new Intent("android.intent.action.VIEW");
                if (replace.contains("?body=")) {
                    final String[] split2 = replace.split("\\?body=");
                    intent13.putExtra("address", URLDecoder.decode(split2[0]).substring(4));
                    intent13.putExtra("sms_body", URLDecoder.decode(split2[1]));
                }
                else {
                    intent13.putExtra("address", parse2.toString().substring(4));
                }
                intent13.setType("vnd.android-dir/mms-sms");
                intent13.addFlags(268435456);
                if (b) {
                    intent13.addFlags(8388608);
                }
                if (a(context, intent13)) {
                    context.startActivity(intent13);
                    return true;
                }
                return false;
            }
        }
        else if (k(replace)) {
            final Intent intent14 = new Intent("android.intent.action.DIAL", Uri.parse(replace));
            intent14.addFlags(268435456);
            if (b) {
                intent14.addFlags(8388608);
            }
            if (a(context, intent14)) {
                context.startActivity(intent14);
                return true;
            }
            return false;
        }
        else {
            if (!n(replace) && !j(replace) && !p(replace) && !q(replace) && !m(replace)) {
                return false;
            }
            final Intent intent15 = new Intent("android.intent.action.VIEW", Uri.parse(replace));
            intent15.addFlags(268435456);
            if (b) {
                intent15.addFlags(8388608);
            }
            if (!a(context, intent15)) {
                return false;
            }
            context.startActivity(intent15);
        }
        return true;
    }
    
    public static String b() {
        final StringBuffer sb = new StringBuffer();
        final String release = Build$VERSION.RELEASE;
        if (release.length() > 0) {
            sb.append(release);
        }
        else {
            sb.append("1.0");
        }
        sb.append("; ");
        final Locale default1 = Locale.getDefault();
        final String language = default1.getLanguage();
        if (language != null) {
            sb.append(language.toLowerCase());
            final String country = default1.getCountry();
            if (country != null) {
                sb.append("-");
                sb.append(country.toLowerCase());
            }
        }
        else {
            sb.append("en");
        }
        final String model = Build.MODEL;
        if (model.length() > 0) {
            sb.append("; ");
            sb.append(model);
        }
        final String id = Build.ID;
        if (id.length() > 0) {
            sb.append(" Build/");
            sb.append(id);
        }
        return String.format("Mozilla/5.0 (Linux; U; Android %s) AppleWebKit/525.10+ (KHTML, like Gecko) Version/3.0.4 Mobile Safari/523.12.2", sb);
    }
    
    static String b(final Context context) {
        if (context != null) {
            final ConnectivityManager connectivityManager = (ConnectivityManager)context.getSystemService("connectivity");
            final TelephonyManager telephonyManager = (TelephonyManager)context.getSystemService("phone");
            final NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            if (activeNetworkInfo != null) {
                Label_0064: {
                    switch (activeNetworkInfo.getType()) {
                        case 1: {
                            return "wifi";
                        }
                        case 0: {
                            switch (telephonyManager.getNetworkType()) {
                                default: {
                                    break Label_0064;
                                }
                                case 1: {
                                    return "GPRS";
                                }
                                case 13: {
                                    return "lte";
                                }
                                case 15: {
                                    return "HSPAP";
                                }
                                case 2: {
                                    return "EDGE";
                                }
                                case 7: {
                                    return "1xRTT";
                                }
                                case 4: {
                                    return "CDMA";
                                }
                                case 14: {
                                    return "EHRPD";
                                }
                                case 5: {
                                    return "EVDO_0";
                                }
                                case 6: {
                                    return "EVDO_A";
                                }
                                case 12: {
                                    return "EVDO_B";
                                }
                                case 8: {
                                    return "HSDPA";
                                }
                                case 10: {
                                    return "HSPA";
                                }
                                case 9: {
                                    return "HSUPA";
                                }
                                case 11: {
                                    return "IDEN";
                                }
                                case 3: {
                                    return "UMTS";
                                }
                            }
                            break;
                        }
                    }
                }
                return "";
            }
        }
        return "";
    }
    
    public static boolean b(Context context, final String s) {
        final Object value = false;
        if (Version.getAndroidSDKVersion() >= 7 && s.equals("camera")) {
            return (boolean)r$f.a(context, s);
        }
        if (Version.getAndroidSDKVersion() >= 8) {
            return (boolean)r$f.a(context, s);
        }
        Label_0089: {
            if (!s.equals("camera")) {
                break Label_0089;
            }
        Label_0082_Outer:
            while (true) {
                context = null;
                while (true) {
                    Object o;
                    Label_0188:Block_13_Outer:Block_8_Outer:
                    while (true) {
                        try {
                            context = (Context)Camera.open();
                            if (context != null) {
                                context = (Context)Boolean.valueOf(true);
                                o = context;
                                Label_0084: {
                                    return (boolean)o;
                                }
                            }
                            break Label_0188;
                            Block_11: {
                                while (true) {
                                    while (true) {
                                        Block_12: {
                                            while (true) {
                                                o = value;
                                                iftrue(Label_0084:)(!d.a().a(context));
                                                break Block_11;
                                                o = true;
                                                return (boolean)o;
                                                Label_0152: {
                                                    o = value;
                                                }
                                                iftrue(Label_0084:)(!s.equals("compass"));
                                                break Block_12;
                                                Label_0122:
                                                iftrue(Label_0152:)(!s.equals("accelerometer"));
                                                continue Block_13_Outer;
                                            }
                                            o = value;
                                            iftrue(Label_0084:)(context.getSystemService("location") == null);
                                            o = true;
                                            return (boolean)o;
                                        }
                                        o = value;
                                        iftrue(Label_0084:)(!d.a().b(context));
                                        continue Block_8_Outer;
                                    }
                                    iftrue(Label_0122:)(!s.equals("location"));
                                    continue;
                                }
                            }
                            o = true;
                            return (boolean)o;
                        }
                        catch (RuntimeException ex) {
                            continue Label_0082_Outer;
                        }
                        break;
                    }
                    context = (Context)value;
                    continue;
                }
            }
        }
    }
    
    static String c(final Context context) {
        if (context == null) {
            try {
                throw new NullPointerException();
            }
            catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        else {
            final String networkOperatorName = ((TelephonyManager)context.getSystemService("phone")).getNetworkOperatorName();
            if (networkOperatorName.length() > 0) {
                return networkOperatorName;
            }
        }
        return "unknown-network";
    }
    
    public static boolean c() {
        return Version.getAndroidSDKVersion() == 16;
    }
    
    public static boolean c(final Context context, final String s) {
        return context.checkCallingOrSelfPermission(s) == 0;
    }
    
    static int d(final Context context) {
        if (context == null) {
            throw new NullPointerException();
        }
        final Display defaultDisplay = ((WindowManager)context.getSystemService("window")).getDefaultDisplay();
        if (defaultDisplay.getWidth() > defaultDisplay.getHeight()) {
            return 2;
        }
        return 1;
    }
    
    static String d(String encode) {
        try {
            encode = URLEncoder.encode(f.a(encode.getBytes(), 8), "UTF-8");
            return encode;
        }
        catch (UnsupportedEncodingException ex) {
            Logging.log(Log.getStackTraceString((Throwable)ex));
            return "";
        }
    }
    
    public static FileInputStream e(final String s) {
        final File file = new File(s);
        try {
            return new FileInputStream(file);
        }
        catch (FileNotFoundException ex) {
            Logging.log("read file" + ex.getMessage());
        }
        catch (NullPointerException ex2) {
            Logging.log("read file" + ex2.getMessage());
            goto Label_0044;
        }
        catch (Exception ex3) {
            Logging.log("read file" + ex3.getMessage());
            goto Label_0044;
        }
    }
    
    public static Integer e(final Context context) {
        if (context == null) {
            return null;
        }
        if (d(context) == 1) {
            return 1;
        }
        return 0;
    }
    
    public static final boolean f(final Context context) {
        if (c(context, "android.permission.ACCESS_NETWORK_STATE")) {
            final ConnectivityManager connectivityManager = (ConnectivityManager)context.getSystemService("connectivity");
            if (connectivityManager.getActiveNetworkInfo() != null && connectivityManager.getActiveNetworkInfo().isAvailable() && connectivityManager.getActiveNetworkInfo().isConnected()) {
                return true;
            }
        }
        return false;
    }
    
    static boolean f(final String s) {
        return s != null && s.length() > 0 && (s.equals("admarvelsdk://noclick") || s.equals("admarvelsdk://nothing"));
    }
    
    @SuppressLint({ "NewApi" })
    public static int g(final Context context) {
        final WindowManager windowManager = (WindowManager)context.getApplicationContext().getSystemService("window");
        if (Version.getAndroidSDKVersion() >= 13) {
            final Point point = new Point();
            windowManager.getDefaultDisplay().getSize(point);
            return point.x;
        }
        return windowManager.getDefaultDisplay().getWidth();
    }
    
    public static boolean g(final String s) {
        return a(s, "admarvelsdk") != r$j.c || a(s, "admarvelinternal") != r$j.c || a(s, "admarvelvideo") != r$j.c || a(s, "admarvelexternal") != r$j.c || a(s, "admarvelcustomvideo") != r$j.c;
    }
    
    @SuppressLint({ "NewApi" })
    public static int h(final Context context) {
        final WindowManager windowManager = (WindowManager)context.getApplicationContext().getSystemService("window");
        if (Version.getAndroidSDKVersion() >= 13) {
            final Point point = new Point();
            windowManager.getDefaultDisplay().getSize(point);
            return point.y;
        }
        return windowManager.getDefaultDisplay().getHeight();
    }
    
    private static boolean h(String path) {
        boolean b2;
        final boolean b = b2 = false;
        if (path == null) {
            return b2;
        }
        b2 = b;
        if (path.length() <= 0) {
            return b2;
        }
        if (!path.toLowerCase().endsWith(".mp4") && !path.toLowerCase().endsWith(".3gp") && !path.toLowerCase().endsWith(".webm")) {
            b2 = b;
            if (!path.toLowerCase().endsWith(".mkv")) {
                return b2;
            }
        }
        try {
            path = new URL(path).getPath();
            b2 = b;
            if (path != null) {
                b2 = b;
                if (path.length() > 0) {
                    if (!path.toLowerCase().endsWith(".mp4") && !path.toLowerCase().endsWith(".3gp") && !path.toLowerCase().endsWith(".webm")) {
                        b2 = b;
                        if (!path.toLowerCase().endsWith(".mkv")) {
                            return b2;
                        }
                    }
                    b2 = true;
                }
            }
            return b2;
        }
        catch (MalformedURLException ex) {
            return false;
        }
    }
    
    public static float i(final Context context) {
        final WindowManager windowManager = (WindowManager)context.getApplicationContext().getSystemService("window");
        final DisplayMetrics displayMetrics = new DisplayMetrics();
        windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics.density;
    }
    
    private static boolean i(String path) {
        boolean b2;
        final boolean b = b2 = false;
        if (path == null) {
            return b2;
        }
        b2 = b;
        if (path.length() <= 0) {
            return b2;
        }
        if (!path.toLowerCase().endsWith(".flac") && !path.toLowerCase().endsWith(".mp3") && !path.toLowerCase().endsWith(".mid") && !path.toLowerCase().endsWith(".xmf") && !path.toLowerCase().endsWith(".mxmf") && !path.toLowerCase().endsWith(".rtttl") && !path.toLowerCase().endsWith(".rtx") && !path.toLowerCase().endsWith(".ota")) {
            b2 = b;
            if (!path.toLowerCase().endsWith(".imy")) {
                return b2;
            }
        }
        try {
            path = new URL(path).getPath();
            b2 = b;
            if (path != null) {
                b2 = b;
                if (path.length() > 0) {
                    if (!path.toLowerCase().endsWith(".flac") && !path.toLowerCase().endsWith(".mp3") && !path.toLowerCase().endsWith(".mid") && !path.toLowerCase().endsWith(".xmf") && !path.toLowerCase().endsWith(".mxmf") && !path.toLowerCase().endsWith(".rtttl") && !path.toLowerCase().endsWith(".rtx") && !path.toLowerCase().endsWith(".ota")) {
                        b2 = b;
                        if (!path.toLowerCase().endsWith(".imy")) {
                            return b2;
                        }
                    }
                    b2 = true;
                }
            }
            return b2;
        }
        catch (MalformedURLException ex) {
            return false;
        }
    }
    
    public static boolean j(final Context context) {
        return ((TelephonyManager)context.getSystemService("phone")).getPhoneType() != 0;
    }
    
    private static boolean j(final String s) {
        return s != null && s.length() > 0 && s.toLowerCase().startsWith("google.streetview:");
    }
    
    public static boolean k(final Context context) {
        final ConnectivityManager connectivityManager = (ConnectivityManager)context.getSystemService("connectivity");
        return connectivityManager.getActiveNetworkInfo() != null && connectivityManager.getActiveNetworkInfo().isAvailable() && connectivityManager.getActiveNetworkInfo().isConnected();
    }
    
    private static boolean k(final String s) {
        return s != null && s.length() > 0 && (s.toLowerCase().startsWith("tel:") || s.toLowerCase().startsWith("voicemail:"));
    }
    
    public static void l(final Context context) {
        final long timeInMillis = Calendar.getInstance().getTimeInMillis();
        long preferenceValueLong;
        if ((preferenceValueLong = AdMarvelUtils.getPreferenceValueLong(context, "adm_viewport", "adm_viewport_timestamp")) == -2147483648L) {
            preferenceValueLong = 0L;
        }
        if (timeInMillis - preferenceValueLong < 86400000L) {
            goto Label_0144;
        }
        final StringBuilder sb = new StringBuilder();
        try {
            final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new URL("http://admarvel.s3.amazonaws.com/sdk/admarvel_android_sdk_dynamic_viewport.js").openConnection().getInputStream()));
            while (true) {
                final String line = bufferedReader.readLine();
                if (line == null) {
                    goto Label_0181;
                }
                sb.append(line);
            }
        }
        catch (MalformedURLException ex) {
            ex.printStackTrace();
        }
        catch (IOException ex2) {
            ex2.printStackTrace();
            goto Label_0113;
        }
    }
    
    private static boolean l(final String s) {
        return s != null && s.length() > 0 && s.toLowerCase().startsWith("sms:");
    }
    
    public static void m(final Context context) {
        try {
            final File file = new File(context.getDir("Admarvel", 0), "admarvel_adHistory");
            if (file.isDirectory()) {
                new Thread(new Runnable() {
                    @Override
                    public final void run() {
                        try {
                            final File[] listFiles = file.listFiles();
                            for (int length = listFiles.length, i = 0; i < length; ++i) {
                                listFiles[i].delete();
                            }
                            file.delete();
                        }
                        catch (Exception ex) {
                            ex.printStackTrace();
                        }
                    }
                }).start();
            }
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    private static boolean m(final String s) {
        return s != null && s.length() > 0 && s.toLowerCase().startsWith("mailto:");
    }
    
    public static void n(final Context context) {
        final long timeInMillis = Calendar.getInstance().getTimeInMillis();
        long preferenceValueLong;
        if ((preferenceValueLong = AdMarvelUtils.getPreferenceValueLong(context, "adm_viewport", "adm_video_cleanup_timestamp")) == -2147483648L) {
            preferenceValueLong = 0L;
        }
        if (timeInMillis - preferenceValueLong >= 900000L) {
            new Thread(new Runnable() {
                @Override
                public final void run() {
                    int i = 0;
                    final File dir = context.getDir("adm_cache_files", 0);
                    if (dir.isDirectory()) {
                        try {
                            for (File[] listFiles = dir.listFiles(); i < listFiles.length; ++i) {
                                final File file = listFiles[i];
                                if (System.currentTimeMillis() - file.lastModified() > 840000L) {
                                    file.delete();
                                }
                            }
                        }
                        catch (Exception ex) {}
                        AdMarvelUtils.setPreferenceValueLong(context, "adm_viewport", "adm_video_cleanup_timestamp", Calendar.getInstance().getTimeInMillis());
                    }
                }
            }).start();
        }
    }
    
    private static boolean n(final String s) {
        return s != null && s.length() > 0 && (s.toLowerCase().startsWith("geo:") || s.toLowerCase().startsWith("http://maps.google") || s.toLowerCase().startsWith("https://maps.google"));
    }
    
    public static void o(final Context context) {
        final long timeInMillis = Calendar.getInstance().getTimeInMillis();
        long preferenceValueLong;
        if ((preferenceValueLong = AdMarvelUtils.getPreferenceValueLong(context, "adm_viewport", "adm_mraid_download_timestamp")) == -2147483648L) {
            preferenceValueLong = 0L;
        }
        if (timeInMillis - preferenceValueLong >= 86400000L) {
            final String string = context.getDir("adm_mraid_file", 0).getAbsolutePath() + "/mraid.js";
            File file = null;
            InputStream inputStream2 = null;
            FileOutputStream fileOutputStream = null;
            Label_0359: {
                try {
                    file = new File(string + ".PROCESSING");
                    final HttpURLConnection httpURLConnection = (HttpURLConnection)new URL("http://admarvel.s3.amazonaws.com/js/admarvel_mraid_v2_complete.js").openConnection();
                    httpURLConnection.setRequestMethod("GET");
                    httpURLConnection.setDoOutput(false);
                    httpURLConnection.setDoInput(true);
                    httpURLConnection.setUseCaches(false);
                    httpURLConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
                    httpURLConnection.setRequestProperty("Content-Length", "0");
                    httpURLConnection.setConnectTimeout(2000);
                    httpURLConnection.setReadTimeout(10000);
                    final int responseCode = httpURLConnection.getResponseCode();
                    final int contentLength = httpURLConnection.getContentLength();
                    Logging.log("Mraid Connection Status Code: " + responseCode);
                    Logging.log("Mraid Content Length: " + contentLength);
                    if (responseCode == 200) {
                        final InputStream inputStream = inputStream2 = (InputStream)httpURLConnection.getContent();
                        if ("gzip".equals(httpURLConnection.getContentEncoding())) {
                            inputStream2 = inputStream;
                            if (Version.getAndroidSDKVersion() < 9) {
                                inputStream2 = new GZIPInputStream(inputStream);
                            }
                        }
                        if (inputStream2 != null) {
                            fileOutputStream = new FileOutputStream(file);
                            final byte[] array = new byte[4096];
                            while (true) {
                                final int read = inputStream2.read(array);
                                if (read == -1) {
                                    break Label_0359;
                                }
                                fileOutputStream.write(array, 0, read);
                            }
                        }
                    }
                }
                catch (Exception ex) {
                    Logging.log(Log.getStackTraceString((Throwable)ex));
                }
                return;
            }
            final File file2 = new File(string);
            if (file2.exists()) {
                file2.delete();
            }
            file.renameTo(file2);
            if (file.exists()) {
                file.delete();
            }
            inputStream2.close();
            fileOutputStream.flush();
            Logging.log("Mraid File updated ");
            AdMarvelUtils.setPreferenceValueLong(context, "adm_viewport", "adm_mraid_download_timestamp", Calendar.getInstance().getTimeInMillis());
        }
    }
    
    private static boolean o(String path) {
        boolean b2;
        final boolean b = b2 = false;
        if (path == null) {
            return b2;
        }
        b2 = b;
        if (path.length() <= 0) {
            return b2;
        }
        if (!path.toLowerCase().endsWith(".pdf")) {
            b2 = b;
            if (!path.toLowerCase().endsWith(".pdf")) {
                return b2;
            }
        }
        try {
            path = new URL(path).getPath();
            b2 = b;
            if (path != null) {
                b2 = b;
                if (path.length() > 0) {
                    if (!path.toLowerCase().endsWith(".pdf")) {
                        b2 = b;
                        if (!path.toLowerCase().endsWith(".pdf")) {
                            return b2;
                        }
                    }
                    b2 = true;
                }
            }
            return b2;
        }
        catch (MalformedURLException ex) {
            return false;
        }
    }
    
    private static boolean p(final String s) {
        return s != null && s.length() > 0 && (s.toLowerCase().startsWith("market://") || s.toLowerCase().startsWith("https://play.google.com") || s.toLowerCase().startsWith("https://play.google.com"));
    }
    
    private static boolean q(final String s) {
        return s != null && s.length() > 0 && s.toLowerCase().startsWith("vzw://");
    }
    
    private static boolean r(final String s) {
        return s != null && s.length() > 0 && (s.toLowerCase().endsWith(".mp4") || s.toLowerCase().endsWith(".3gp"));
    }
    
    private static boolean s(final String s) {
        return s != null && s.length() > 0 && (s.toLowerCase().endsWith(".flac") || s.toLowerCase().endsWith(".mp3") || s.toLowerCase().endsWith(".mid") || s.toLowerCase().endsWith(".xmf") || s.toLowerCase().endsWith(".mxmf") || s.toLowerCase().endsWith(".rtttl") || s.toLowerCase().endsWith(".rtx") || s.toLowerCase().endsWith(".ota") || s.toLowerCase().endsWith(".imy"));
    }
    
    private static boolean t(final String s) {
        return s != null && s.length() > 0 && (s.toLowerCase().endsWith(".pdf") || s.toLowerCase().endsWith(".pdf"));
    }
    
    public String a() {
        try {
            if (this.c != null) {
                final Context context = (Context)this.c.get();
                if (context != null) {
                    final Constructor<WebSettings> declaredConstructor = WebSettings.class.getDeclaredConstructor(Context.class, WebView.class);
                    declaredConstructor.setAccessible(true);
                    try {
                        return declaredConstructor.newInstance(context.getApplicationContext(), null).getUserAgentString();
                    }
                    finally {
                        declaredConstructor.setAccessible(false);
                    }
                }
            }
        }
        catch (Exception ex) {
            if (!Thread.currentThread().getName().equalsIgnoreCase("main") || this.c == null) {
                return b();
            }
            final Context context2 = (Context)this.c.get();
            if (context2 != null) {
                return new WebView(context2).getSettings().getUserAgentString();
            }
            return b();
        }
        return b();
    }
    
    public void a(final AdMarvelAd adMarvelAd) {
        final StringBuilder sb = new StringBuilder();
        if (adMarvelAd != null && adMarvelAd.getPixels() != null) {
            final Iterator iterator = adMarvelAd.getPixels().iterator();
            while (iterator.hasNext()) {
                sb.append("<img src=\"").append((String)iterator.next()).append("\" />");
            }
        }
        if (sb.length() > 0) {
            if (!Thread.currentThread().getName().equalsIgnoreCase("main")) {
                this.d = sb.toString();
                new Handler(Looper.getMainLooper()).post((Runnable)new Runnable() {
                    @Override
                    public void run() {
                        if (r.this.c != null) {
                            final Context context = (Context)r.this.c.get();
                            if (context != null) {
                                new WebView(context).loadDataWithBaseURL((String)null, r.this.d, "text/html", "utf-8", (String)null);
                            }
                        }
                    }
                });
                return;
            }
            if (this.c != null) {
                final Context context = (Context)this.c.get();
                if (context != null) {
                    new WebView(context).loadDataWithBaseURL((String)null, sb.toString(), "text/html", "utf-8", (String)null);
                }
            }
        }
    }
    
    public void a(final String s) {
        try {
            if (Version.getAndroidSDKVersion() >= 11) {
                new Thread(new r$h(this, s)).start();
                return;
            }
            new r$g(this, s).execute((Object[])new Void[0]);
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    public void a(final String s, final Handler handler) {
        try {
            if (Version.getAndroidSDKVersion() >= 11 && handler != null) {
                handler.post((Runnable)new r$h(this, s));
                return;
            }
            new r$g(this, s).execute((Object[])new Void[0]);
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    public void b(final String s) {
        if (s != null && s.length() > 0) {
            final StringBuilder sb = new StringBuilder();
            sb.append("<img src=\"").append(s).append("\" />");
            if (sb.length() > 0) {
                if (!Thread.currentThread().getName().equalsIgnoreCase("main")) {
                    this.d = sb.toString();
                    new Handler(Looper.getMainLooper()).post((Runnable)new Runnable() {
                        @Override
                        public void run() {
                            if (r.this.c != null) {
                                final Context context = (Context)r.this.c.get();
                                if (context != null) {
                                    new WebView(context).loadDataWithBaseURL((String)null, r.this.d, "text/html", "utf-8", (String)null);
                                }
                            }
                        }
                    });
                    return;
                }
                if (this.c != null) {
                    final Context context = (Context)this.c.get();
                    if (context != null) {
                        new WebView(context).loadDataWithBaseURL((String)null, sb.toString(), "text/html", "utf-8", (String)null);
                    }
                }
            }
        }
    }
    
    void c(final String p0) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     4: return         
        //     5: invokestatic    com/admarvel/android/ads/Version.getAndroidSDKVersion:()I
        //     8: bipush          11
        //    10: if_icmplt       217
        //    13: invokestatic    com/admarvel/android/util/e.a:()Lcom/admarvel/android/util/e;
        //    16: invokevirtual   com/admarvel/android/util/e.b:()Ljava/util/concurrent/ExecutorService;
        //    19: new             Lcom/admarvel/android/ads/r$b;
        //    22: dup            
        //    23: aconst_null    
        //    24: invokespecial   com/admarvel/android/ads/r$b.<init>:(Lcom/admarvel/android/ads/r$1;)V
        //    27: invokeinterface java/util/concurrent/ExecutorService.execute:(Ljava/lang/Runnable;)V
        //    32: new             Lcom/admarvel/android/ads/AdMarvelXMLReader;
        //    35: dup            
        //    36: invokespecial   com/admarvel/android/ads/AdMarvelXMLReader.<init>:()V
        //    39: astore          4
        //    41: aload           4
        //    43: aload_1        
        //    44: invokevirtual   com/admarvel/android/ads/AdMarvelXMLReader.parseXMLString:(Ljava/lang/String;)V
        //    47: aload           4
        //    49: invokevirtual   com/admarvel/android/ads/AdMarvelXMLReader.getParsedXMLData:()Lcom/admarvel/android/ads/AdMarvelXMLElement;
        //    52: astore_1       
        //    53: aload_1        
        //    54: invokevirtual   com/admarvel/android/ads/AdMarvelXMLElement.getChildren:()Ljava/util/LinkedHashMap;
        //    57: ldc_w           "trackers"
        //    60: invokevirtual   java/util/LinkedHashMap.containsKey:(Ljava/lang/Object;)Z
        //    63: ifeq            470
        //    66: aload_1        
        //    67: invokevirtual   com/admarvel/android/ads/AdMarvelXMLElement.getChildren:()Ljava/util/LinkedHashMap;
        //    70: ldc_w           "trackers"
        //    73: invokevirtual   java/util/LinkedHashMap.get:(Ljava/lang/Object;)Ljava/lang/Object;
        //    76: checkcast       Ljava/util/ArrayList;
        //    79: iconst_0       
        //    80: invokevirtual   java/util/ArrayList.get:(I)Ljava/lang/Object;
        //    83: checkcast       Lcom/admarvel/android/ads/AdMarvelXMLElement;
        //    86: astore          7
        //    88: aload           7
        //    90: invokevirtual   com/admarvel/android/ads/AdMarvelXMLElement.getAttributes:()Ljava/util/LinkedHashMap;
        //    93: ldc_w           "id"
        //    96: invokevirtual   java/util/LinkedHashMap.get:(Ljava/lang/Object;)Ljava/lang/Object;
        //    99: checkcast       Ljava/lang/String;
        //   102: astore          6
        //   104: aload           7
        //   106: invokevirtual   com/admarvel/android/ads/AdMarvelXMLElement.getChildren:()Ljava/util/LinkedHashMap;
        //   109: ldc_w           "tracker"
        //   112: invokevirtual   java/util/LinkedHashMap.containsKey:(Ljava/lang/Object;)Z
        //   115: ifeq            460
        //   118: aload           7
        //   120: invokevirtual   com/admarvel/android/ads/AdMarvelXMLElement.getChildren:()Ljava/util/LinkedHashMap;
        //   123: ldc_w           "tracker"
        //   126: invokevirtual   java/util/LinkedHashMap.get:(Ljava/lang/Object;)Ljava/lang/Object;
        //   129: checkcast       Ljava/util/ArrayList;
        //   132: invokevirtual   java/util/ArrayList.size:()I
        //   135: istore_3       
        //   136: iconst_0       
        //   137: istore_2       
        //   138: aconst_null    
        //   139: astore_1       
        //   140: aload           6
        //   142: astore          5
        //   144: aload_1        
        //   145: astore          4
        //   147: iload_2        
        //   148: iload_3        
        //   149: if_icmpge       260
        //   152: aload           7
        //   154: invokevirtual   com/admarvel/android/ads/AdMarvelXMLElement.getChildren:()Ljava/util/LinkedHashMap;
        //   157: ldc_w           "tracker"
        //   160: invokevirtual   java/util/LinkedHashMap.get:(Ljava/lang/Object;)Ljava/lang/Object;
        //   163: checkcast       Ljava/util/ArrayList;
        //   166: iload_2        
        //   167: invokevirtual   java/util/ArrayList.get:(I)Ljava/lang/Object;
        //   170: checkcast       Lcom/admarvel/android/ads/AdMarvelXMLElement;
        //   173: astore          4
        //   175: aload           4
        //   177: ifnull          457
        //   180: aload           4
        //   182: invokevirtual   com/admarvel/android/ads/AdMarvelXMLElement.getData:()Ljava/lang/String;
        //   185: astore          5
        //   187: aload_1        
        //   188: ifnonnull       454
        //   191: new             Ljava/util/ArrayList;
        //   194: dup            
        //   195: invokespecial   java/util/ArrayList.<init>:()V
        //   198: astore          4
        //   200: aload           4
        //   202: astore_1       
        //   203: aload_1        
        //   204: aload           5
        //   206: invokevirtual   java/util/ArrayList.add:(Ljava/lang/Object;)Z
        //   209: pop            
        //   210: iload_2        
        //   211: iconst_1       
        //   212: iadd           
        //   213: istore_2       
        //   214: goto            140
        //   217: new             Landroid/os/Handler;
        //   220: dup            
        //   221: invokestatic    android/os/Looper.getMainLooper:()Landroid/os/Looper;
        //   224: invokespecial   android/os/Handler.<init>:(Landroid/os/Looper;)V
        //   227: new             Lcom/admarvel/android/ads/r$a;
        //   230: dup            
        //   231: aconst_null    
        //   232: invokespecial   com/admarvel/android/ads/r$a.<init>:(Lcom/admarvel/android/ads/r$1;)V
        //   235: invokevirtual   android/os/Handler.post:(Ljava/lang/Runnable;)Z
        //   238: pop            
        //   239: goto            32
        //   242: astore          4
        //   244: aconst_null    
        //   245: astore_1       
        //   246: aconst_null    
        //   247: astore          5
        //   249: aload           4
        //   251: invokestatic    android/util/Log.getStackTraceString:(Ljava/lang/Throwable;)Ljava/lang/String;
        //   254: invokestatic    com/admarvel/android/util/Logging.log:(Ljava/lang/String;)V
        //   257: aload_1        
        //   258: astore          4
        //   260: aload           5
        //   262: ifnull          4
        //   265: aload           5
        //   267: invokevirtual   java/lang/String.length:()I
        //   270: ifle            4
        //   273: aload_0        
        //   274: getfield        com/admarvel/android/ads/r.c:Ljava/lang/ref/WeakReference;
        //   277: ifnull          449
        //   280: aload_0        
        //   281: getfield        com/admarvel/android/ads/r.c:Ljava/lang/ref/WeakReference;
        //   284: invokevirtual   java/lang/ref/WeakReference.get:()Ljava/lang/Object;
        //   287: checkcast       Landroid/content/Context;
        //   290: astore_1       
        //   291: aload_1        
        //   292: ifnull          4
        //   295: aload_1        
        //   296: aload           5
        //   298: invokestatic    com/admarvel/android/ads/r.a:(Landroid/content/Context;Ljava/lang/String;)Z
        //   301: ifne            4
        //   304: aload           4
        //   306: ifnull          4
        //   309: aload           4
        //   311: invokevirtual   java/util/ArrayList.isEmpty:()Z
        //   314: ifne            4
        //   317: ldc_w           "mounted"
        //   320: invokestatic    android/os/Environment.getExternalStorageState:()Ljava/lang/String;
        //   323: invokevirtual   java/lang/String.equals:(Ljava/lang/Object;)Z
        //   326: ifeq            4
        //   329: new             Ljava/io/File;
        //   332: dup            
        //   333: invokestatic    android/os/Environment.getExternalStorageDirectory:()Ljava/io/File;
        //   336: new             Ljava/lang/StringBuilder;
        //   339: dup            
        //   340: ldc_w           "/"
        //   343: invokespecial   java/lang/StringBuilder.<init>:(Ljava/lang/String;)V
        //   346: ldc_w           "adm_tracker_dir"
        //   349: invokestatic    com/admarvel/android/ads/r.d:(Ljava/lang/String;)Ljava/lang/String;
        //   352: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   355: ldc_w           "/"
        //   358: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   361: aload           5
        //   363: invokestatic    com/admarvel/android/ads/r.d:(Ljava/lang/String;)Ljava/lang/String;
        //   366: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   369: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   372: invokespecial   java/io/File.<init>:(Ljava/io/File;Ljava/lang/String;)V
        //   375: astore_1       
        //   376: aload_1        
        //   377: invokevirtual   java/io/File.getParentFile:()Ljava/io/File;
        //   380: invokevirtual   java/io/File.mkdirs:()Z
        //   383: pop            
        //   384: new             Ljava/io/ObjectOutputStream;
        //   387: dup            
        //   388: new             Ljava/io/FileOutputStream;
        //   391: dup            
        //   392: aload_1        
        //   393: invokespecial   java/io/FileOutputStream.<init>:(Ljava/io/File;)V
        //   396: invokespecial   java/io/ObjectOutputStream.<init>:(Ljava/io/OutputStream;)V
        //   399: astore_1       
        //   400: aload_1        
        //   401: aload           4
        //   403: invokevirtual   java/io/ObjectOutputStream.writeObject:(Ljava/lang/Object;)V
        //   406: aload_1        
        //   407: invokevirtual   java/io/ObjectOutputStream.close:()V
        //   410: return         
        //   411: astore_1       
        //   412: aload_1        
        //   413: invokestatic    android/util/Log.getStackTraceString:(Ljava/lang/Throwable;)Ljava/lang/String;
        //   416: invokestatic    com/admarvel/android/util/Logging.log:(Ljava/lang/String;)V
        //   419: return         
        //   420: astore          4
        //   422: aconst_null    
        //   423: astore_1       
        //   424: aload           6
        //   426: astore          5
        //   428: goto            249
        //   431: astore          4
        //   433: aload           6
        //   435: astore          5
        //   437: goto            249
        //   440: astore          4
        //   442: aload           6
        //   444: astore          5
        //   446: goto            249
        //   449: aconst_null    
        //   450: astore_1       
        //   451: goto            291
        //   454: goto            203
        //   457: goto            210
        //   460: aconst_null    
        //   461: astore          4
        //   463: aload           6
        //   465: astore          5
        //   467: goto            260
        //   470: aconst_null    
        //   471: astore          4
        //   473: aconst_null    
        //   474: astore          5
        //   476: goto            260
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                 
        //  -----  -----  -----  -----  ---------------------
        //  5      32     242    249    Ljava/lang/Exception;
        //  32     104    242    249    Ljava/lang/Exception;
        //  104    136    420    431    Ljava/lang/Exception;
        //  152    175    440    449    Ljava/lang/Exception;
        //  180    187    440    449    Ljava/lang/Exception;
        //  191    200    440    449    Ljava/lang/Exception;
        //  203    210    431    440    Ljava/lang/Exception;
        //  217    239    242    249    Ljava/lang/Exception;
        //  309    410    411    420    Ljava/lang/Exception;
        // 
        // The error that occurred was:
        // 
        // java.lang.IndexOutOfBoundsException: Index: 216, Size: 216
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
