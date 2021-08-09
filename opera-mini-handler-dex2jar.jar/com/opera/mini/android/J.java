// 
// Decompiled by Procyon v0.6-prerelease
// 

package com.opera.mini.android;

import android.text.ClipboardManager;
import android.util.DisplayMetrics;
import android.content.SharedPreferences;
import android.content.SharedPreferences$Editor;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.opera.mini.android.notifications.B;
import com.opera.mini.android.events.NotificationStatsAck;
import android.provider.Settings$Secure;
import java.util.Vector;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;
import android.content.Intent$ShortcutIconResource;
import android.os.Parcelable;
import java.util.List;
import android.content.ComponentName;
import android.content.pm.ResolveInfo;
import android.widget.EditText;
import android.content.ActivityNotFoundException;
import com.opera.mini.android.events.ServerNotificationSettingsEvent;
import java.io.DataInputStream;
import com.opera.mini.android.notifications.q;
import android.text.TextUtils;
import java.util.LinkedList;
import java.net.SocketAddress;
import java.net.URISyntaxException;
import java.net.InetSocketAddress;
import java.net.URI;
import java.net.ProxySelector;
import java.net.Proxy;
import java.io.FileNotFoundException;
import java.io.FileInputStream;
import java.io.File;
import java.io.InputStream;
import android.net.Uri$Builder;
import android.net.ConnectivityManager;
import java.io.IOException;
import android.text.TextPaint;
import android.graphics.Paint;
import android.graphics.PorterDuff$Mode;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Build;
import android.graphics.Bitmap;
import android.graphics.Bitmap$Config;
import com.admarvel.android.ads.AdMarvelUtils;
import java.util.HashMap;
import java.util.Iterator;
import java.io.OutputStream;
import java.io.DataOutputStream;
import java.io.ByteArrayOutputStream;
import android.content.pm.PackageManager;
import android.content.Intent;
import android.view.inputmethod.InputMethodManager;
import android.content.Context;
import com.opera.mini.android.events.EventDispatcher;
import org.json.JSONObject;
import java.util.concurrent.ConcurrentHashMap;
import java.util.Map;
import android.content.res.AssetManager;
import android.database.Cursor;
import android.view.View;
import android.net.Uri;
import android.os.ResultReceiver;

public class J implements bn
{
    protected static EditView Code;
    private static final r a;
    private static ResultReceiver b;
    private static ResultReceiver c;
    private static boolean d = false;
    private static int m = 0;
    private static String n;
    private static String r;
    private static String s;
    private static String u;
    private static final String v = "aid";
    private static final Uri w;
    private boolean B;
    private View C;
    public Code I;
    private MiniView J;
    private Browser Z;
    private int e;
    private int f;
    private Cursor g;
    private int h;
    private char i;
    private AssetManager j;
    private Map k;
    private J$Code l;
    private final String o;
    private String p;
    private boolean q;
    private final String t;
    
    static {
        a = new r();
        J.m = -1;
        J.n = "";
        J.r = "unique_device_id";
        J.s = "is_ad_tracking_limited";
        w = Uri.parse("content://com.facebook.katana.provider.AttributionIdProvider");
    }
    
    public J(final Browser z, final AssetManager j) {
        this.e = -1;
        this.f = -1;
        this.g = null;
        this.i = '-';
        this.j = null;
        this.k = new ConcurrentHashMap();
        this.l = new Object() {
            public final void Code(final String s, final JSONObject jsonObject) {
                com.opera.mini.android.J.this.k.put(s, jsonObject.toString());
                if (cg.D) {
                    u.I.h();
                    u.I.Z(44);
                }
            }
        };
        this.o = "market://details?id=com.opera.mini.android";
        this.q = false;
        this.t = "/";
        this.Z = z;
        this.J = (MiniView)z.findViewById(2131230720);
        this.C = z.findViewById(2131230721);
        EventDispatcher.Z(new com.opera.mini.android.u(this));
        ar.I((Context)z);
        this.j = j;
        if (x.am) {
            this.aD();
            this.I = new Code((Context)z, this.l);
        }
    }
    
    public static void B(final boolean b) {
        final InputMethodManager inputMethodManager = (InputMethodManager)Browser.Z.getSystemService("input_method");
        if (J.b == null) {
            J.b = new v(MiniView.Code.getHandler());
        }
        if (b && J.Code != null) {
            J.Code.requestFocus();
            MiniView.Code.Code(true);
            inputMethodManager.showSoftInput((View)J.Code, 0, J.b);
        }
        else if (J.Code != null) {
            MiniView.Code.Code(false);
            MiniView.Code.Code(0);
            Browser.Z.Code(true);
            u.I.h();
            u.I.Z(46);
            inputMethodManager.hideSoftInputFromWindow(J.Code.getWindowToken(), 0);
        }
    }
    
    private void Code(final Intent intent, final PackageManager packageManager) {
        if (x.Code("com.android.browser", packageManager)) {
            intent.setClassName("com.android.browser", "com.android.browser.BrowserActivity");
        }
        else {
            if (x.Code("com.android.chrome", packageManager)) {
                intent.setClassName("com.android.chrome", "com.google.android.apps.chrome.Main");
                return;
            }
            if (x.Code("com.google.android.browser", packageManager)) {
                intent.setClassName("com.google.android.browser", "com.android.browser.BrowserActivity");
            }
        }
    }
    
    private byte[] I(final Map map) {
        if (map.isEmpty()) {
            return null;
        }
        while (true) {
            try {
                final ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                final DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
                Label_0102: {
                    try {
                        for (final Map.Entry<String, V> entry : map.entrySet()) {
                            dataOutputStream.writeUTF(entry.getKey());
                            dataOutputStream.writeUTF((String)entry.getValue());
                        }
                        break Label_0102;
                    }
                    finally {}
                    if (dataOutputStream != null) {
                        dataOutputStream.close();
                    }
                    throw;
                }
                final byte[] byteArray = byteArrayOutputStream.toByteArray();
                dataOutputStream.close();
                return byteArray;
            }
            finally {
                final DataOutputStream dataOutputStream = null;
                continue;
            }
            break;
        }
    }
    
    private void aD() {
        final HashMap adMarvelOptionalFlags = new HashMap();
        adMarvelOptionalFlags.put("AP_TOOL_DISABLE_EXTERNAL_BROWSER_ICON", "true");
        adMarvelOptionalFlags.put("FACEBOOK_NO_VIEW_REGISTERED", "true");
        AdMarvelUtils.setAdMarvelOptionalFlags(adMarvelOptionalFlags);
    }
    
    private void aE() {
        final Bitmap bitmap = Bitmap.createBitmap(10, 16, Bitmap$Config.ARGB_8888);
        final Bitmap bitmap2 = Bitmap.createBitmap(10, 16, Bitmap$Config.ARGB_8888);
        boolean b;
        if ("GT-S5660".equals(Build.PRODUCT) || "GT-S5830".equals(Build.PRODUCT)) {
            b = true;
        }
        else {
            b = false;
        }
        final g g = (g)com.opera.mini.android.h.Code().Code(32, 8);
        final TextPaint g2 = g.g();
        final Rect rect = new Rect();
        final Canvas canvas = new Canvas();
        final boolean antiAlias = g2.isAntiAlias();
        g2.setAntiAlias(false);
        final String[] array = { "\u05e0\u05e1\u05e2", "\u0628\u062a\u062b", "\ufe91\ufef4\ufee6" };
        int n = 0;
        while (true) {
            int length;
            if (b) {
                length = 1;
            }
            else {
                length = array.length;
            }
            if (n >= length) {
                break;
            }
            g2.getTextBounds(array[n], 0, array[n].length(), rect);
            canvas.setBitmap(bitmap);
            canvas.drawColor(0, PorterDuff$Mode.SRC);
            canvas.drawText(array[n], (float)(-rect.left), (float)(-rect.top), (Paint)g2);
            canvas.setBitmap(bitmap2);
            canvas.drawColor(0, PorterDuff$Mode.SRC);
            canvas.drawText(array[n], 0, 1, (float)(-rect.left), (float)(-rect.top), (Paint)g2);
            final int max = Math.max(Math.min(g.Code(array[n].charAt(0)) / 2, 10), 4);
            final int min = Math.min(rect.height(), 16);
            int n2;
            int n3;
            int n5;
            for (n2 = 0, n3 = 1; n3 != 0 && n2 < max; ++n2, n3 = n5) {
                int n4 = 0;
                while (true) {
                    n5 = n3;
                    if (n4 >= min) {
                        break;
                    }
                    if (bitmap.getPixel(n2, n4) != bitmap2.getPixel(n2, n4)) {
                        n5 = 0;
                        break;
                    }
                    ++n4;
                }
            }
            if (n3 == 0) {
                cg.r |= 1 << n + 1;
                if (b) {
                    cg.r = ((cg.r |= 1 << n + 2) | 1 << n + 3);
                }
            }
            ++n;
        }
        bitmap.recycle();
        bitmap2.recycle();
        this.c(cg.r);
        g2.setAntiAlias(antiAlias);
    }
    
    private void aF() {
        if (!Browser.Z.Z()) {
            throw new IOException("Network usage is not allowed when app is in background.");
        }
    }
    
    private static String aG() {
        Label_0082: {
            if (J.u != null) {
                break Label_0082;
            }
            final Cursor query = Browser.Z.getContentResolver().query(J.w, new String[] { "aid" }, (String)null, (String[])null, (String)null);
            J.u = "";
            while (true) {
                if (query == null || !query.moveToFirst()) {
                    break Label_0072;
                }
                try {
                    final String string = query.getString(query.getColumnIndexOrThrow("aid"));
                    if (string != null) {
                        J.u = string;
                    }
                    if (query != null) {
                        query.close();
                    }
                    return J.u;
                }
                catch (Exception ex) {
                    continue;
                }
                break;
            }
        }
    }
    
    public static boolean aw() {
        return J.d;
    }
    
    private az e(final int n) {
        try {
            final r a = com.opera.mini.android.J.a;
            return com.opera.mini.android.r.Code(this.Z.getResources().openRawResource(n));
        }
        catch (IOException ex) {
            return null;
        }
    }
    
    private void e(final String s) {
        final int n = 0;
        boolean b = false;
        Object o = ((ConnectivityManager)this.Z.getSystemService("connectivity")).getActiveNetworkInfo();
        if (o == null) {
            return;
        }
        final int type = ((NetworkInfo)o).getType();
        if ((o = ((NetworkInfo)o).getExtraInfo()) == null) {
            o = "";
        }
        try {
            if (s.indexOf("10.0.0.172") >= 0) {
                if (type != 0 || !((String)o).equals("cmwap")) {
                    bx.C();
                }
            }
            else if (type == 0 && ((String)o).equals("cmwap")) {
                bx.C();
            }
            if (com.opera.mini.android.J.m != type || !com.opera.mini.android.J.n.equals(o)) {
                b = true;
            }
            com.opera.mini.android.J.m = type;
            com.opera.mini.android.J.n = (String)o;
            if (b) {
                cg.a("md");
            }
        }
        finally {
            int n2 = 0;
            Label_0171: {
                if (com.opera.mini.android.J.m == type) {
                    n2 = n;
                    if (com.opera.mini.android.J.n.equals(o)) {
                        break Label_0171;
                    }
                }
                n2 = 1;
            }
            com.opera.mini.android.J.m = type;
            com.opera.mini.android.J.n = (String)o;
            if (n2 != 0) {
                cg.a("md");
            }
        }
    }
    
    private boolean f(final String s) {
        final String[] split = s.split("\\.");
        if (split.length == 4) {
            int n = 0;
            while (true) {
                if (n >= split.length) {
                    return true;
                }
                final String s2 = split[n];
                try {
                    final int int1 = Integer.parseInt(s2);
                    if (int1 >= 0 && int1 <= 255) {
                        ++n;
                        continue;
                    }
                    break;
                }
                catch (NumberFormatException ex) {
                    return false;
                }
            }
        }
        return false;
    }
    
    private boolean g(final String s) {
        boolean b = false;
        if (this.Z.getPackageManager().queryIntentActivities(new Intent("android.intent.action.VIEW", Uri.parse(s)), 0).size() > 0) {
            b = true;
        }
        return b;
    }
    
    private boolean h(final String s) {
        boolean b = false;
        final Intent intent = new Intent("android.intent.action.VIEW", new Uri$Builder().scheme(s).authority("details").build());
        final PackageManager packageManager = this.Z.getPackageManager();
        try {
            if (packageManager.queryIntentActivities(intent, 0).size() > 0) {
                b = true;
            }
            return b;
        }
        catch (NullPointerException ex) {
            return false;
        }
    }
    
    @Override
    public void A() {
        this.g = this.Z.getContentResolver().query(android.provider.Browser.BOOKMARKS_URI, new String[] { "title", "url", "favicon" }, "bookmark = 1", (String[])null, (String)null);
        if (this.g != null) {
            this.g.moveToFirst();
        }
    }
    
    @Override
    public int B() {
        final MiniView j = this.J;
        return MiniView.d();
    }
    
    @Override
    public void B(final int n) {
    }
    
    @Override
    public void B(final String s) {
        x.f(s);
    }
    
    @Override
    public void B(final String s, final String s2) {
        if (x.am) {
            this.I.I(s, s2);
        }
    }
    
    @Override
    public int C() {
        return x.ag.widthPixels;
    }
    
    @Override
    public int C(final int n) {
        cg.Code(n, 0, 2);
        com.opera.mini.android.h.Code();
        return com.opera.mini.android.h.Z(n);
    }
    
    public int C(final String s) {
        return 0;
    }
    
    public InputStream C(String string, final String s) {
        string += s;
        if (string.equals("debuginfo")) {
            final File file = new File("/sdcard/debuginfo");
            try {
                return new FileInputStream(file);
            }
            catch (FileNotFoundException ex) {
                ex.printStackTrace();
            }
        }
        try {
            return this.Z.getResources().getAssets().open(string);
        }
        catch (IOException ex2) {
            return null;
        }
    }
    
    @Override
    public ah Code(final String s, final String s2) {
        this.aF();
        this.e(s);
        return new com.opera.mini.android.az(s);
    }
    
    @Override
    public ah Code(final String s, String s2, final String s3) {
        final int n = 80;
        this.aF();
        this.e(s);
        final Proxy no_PROXY = Proxy.NO_PROXY;
        Label_0242: {
            if (s.startsWith("http://10.0.0.172")) {
                break Label_0242;
            }
            final String s4 = null;
            int n2;
            if (x.ak < 11 && com.opera.mini.android.J.m == 0) {
                s2 = android.net.Proxy.getHost((Context)Browser.Z);
                n2 = android.net.Proxy.getPort((Context)Browser.Z);
            }
            else {
                while (true) {
                    s2 = s4;
                    while (true) {
                        Label_0248: {
                            try {
                                final Proxy proxy = ProxySelector.getDefault().select(new URI(s)).get(0);
                                if (proxy == null) {
                                    break Label_0248;
                                }
                                s2 = s4;
                                final SocketAddress address = proxy.address();
                                if (address == null) {
                                    break Label_0248;
                                }
                                s2 = s4;
                                if (!(address instanceof InetSocketAddress)) {
                                    break Label_0248;
                                }
                                s2 = s4;
                                final String s5 = s2 = ((InetSocketAddress)address).getHostName();
                                n2 = ((InetSocketAddress)address).getPort();
                                s2 = s5;
                            }
                            catch (URISyntaxException ex) {
                                n2 = -1;
                            }
                            break;
                        }
                        n2 = -1;
                        s2 = null;
                        continue;
                    }
                }
            }
            if (s2 == null) {
                break Label_0242;
            }
            InetSocketAddress unresolved;
            if (this.f(s2)) {
                int n3;
                if ((n3 = n2) == -1) {
                    n3 = 80;
                }
                unresolved = InetSocketAddress.createUnresolved(s2, n3);
            }
            else {
                if (n2 == -1) {
                    n2 = n;
                }
                unresolved = new InetSocketAddress(s2, n2);
            }
            final Proxy proxy2 = new Proxy(Proxy.Type.HTTP, unresolved);
            return new ay(s, s3, proxy2);
        }
        final Proxy proxy2 = no_PROXY;
        return new ay(s, s3, proxy2);
    }
    
    @Override
    public bx Code(final int n, final byte b, final boolean b2, final boolean b3) {
        return new bx(n, b, b2, b3);
    }
    
    @Override
    public Object Code(int n, final int n2, final String s, final String s2, final int n3, final String s3, final String s4, final int n4, final int n5, final int n6, final int n7, final int n8, final int n9, final int n10, final int n11, final au au, final int n12, final int n13, final int n14) {
        if ((n3 & 0x6) != 0x0) {
            n = 1;
        }
        else {
            n = 0;
        }
        if (n != 0) {
            n = 2131230722;
        }
        else {
            n = 2131230723;
        }
        final EditView editView = com.opera.mini.android.J.Code = (EditView)this.Z.findViewById(n);
        this.C.post((Runnable)new Runnable() {
            @Override
            public final void run() {
                editView.Code(n4 + n8, n5 + n9, n6 - n8, n7 - n9);
                editView.setTextSize(0, (float)((g)au).f());
                editView.I(n3);
                editView.Code(false);
                editView.setText((CharSequence)s3.replace("\r\n", "\n"));
                if (n10 < 0) {
                    editView.setSelection(editView.getText().length());
                }
                else {
                    editView.setSelection(n10, n10 + n11);
                }
                editView.Code(n13);
                switch (n13) {
                    case 1: {
                        if ("Kindle Fire".equals(Build.MODEL)) {
                            editView.setImeOptions(2);
                            break;
                        }
                    }
                    case 2: {
                        editView.setImeOptions(6);
                        break;
                    }
                    case 3: {
                        editView.setImeOptions(2);
                        break;
                    }
                    case 5: {
                        editView.setImeOptions(5);
                        break;
                    }
                    case 4: {
                        editView.setImeOptions(3);
                        break;
                    }
                }
                editView.Code(n12 == 1);
                editView.setVisibility(0);
                com.opera.mini.android.J.B(true);
            }
        });
        return editView;
    }
    
    @Override
    public String Code(final String s) {
        if ("OM-Install-Referrer".equals(s)) {
            return OpMiniInstallReferrerReceiver.Code((Context)Browser.Z);
        }
        if ("OM-Facebook-Attribution-Id".equals(s)) {
            return aG();
        }
        return null;
    }
    
    @Override
    public String Code(final String[] array) {
        final LinkedList list = new LinkedList();
        for (int length = array.length, i = 0; i < length; ++i) {
            final String s = array[i];
            int n;
            if (s.indexOf(":") < 0) {
                n = 1;
            }
            else {
                n = 0;
            }
            if (n != 0) {
                if (!this.h(s)) {
                    continue;
                }
            }
            else if (!this.g(s)) {
                continue;
            }
            list.add("\"" + s + "\"");
        }
        return TextUtils.join((CharSequence)",", (Iterable)list);
    }
    
    @Override
    public void Code() {
        x.j();
        cg.b("mc");
        cg.b("md");
        cg.a();
        com.opera.mini.android.p.Code(this.j);
        this.aE();
    }
    
    @Override
    public void Code(final int n, final int n2) {
        x.Code(n, n2);
    }
    
    @Override
    public void Code(int min, int min2, final int n, final int n2) {
        final int max = Math.max(min, 0);
        final int max2 = Math.max(min2, 0);
        final MiniView j = this.J;
        min = Math.min(min + n, MiniView.c());
        final MiniView i = this.J;
        min2 = Math.min(min2 + n2, MiniView.d());
        this.J.Code(max, max2, min - max, min2 - max2);
    }
    
    @Override
    public void Code(final int n, final int n2, final String s, final String s2) {
        if (x.al) {
            com.opera.mini.android.notifications.q.Code((Context)this.Z).Code(n, n2, s, s2);
        }
    }
    
    @Override
    public void Code(final DataInputStream dataInputStream, final int n) {
        if (n >= 4) {
            com.opera.mini.android.J.m = dataInputStream.readInt();
            com.opera.mini.android.J.n = dataInputStream.readUTF();
        }
    }
    
    @Override
    public void Code(final DataOutputStream dataOutputStream) {
        dataOutputStream.writeInt(com.opera.mini.android.J.m);
        String n;
        if (com.opera.mini.android.J.n == null) {
            n = "";
        }
        else {
            n = com.opera.mini.android.J.n;
        }
        dataOutputStream.writeUTF(n);
    }
    
    @Override
    public void Code(final Object o) {
        this.C.post((Runnable)new Runnable() {
            @Override
            public final void run() {
                if (o instanceof EditView) {
                    final EditView editView = (EditView)o;
                    editView.setVisibility(8);
                    editView.Code(false);
                    editView.setText((CharSequence)"");
                }
            }
        });
    }
    
    @Override
    public void Code(final Object o, final int n, final int n2, final int n3, final int n4, final int n5, final int n6) {
        if (n2 < 0) {
            return;
        }
        this.C.post((Runnable)new Runnable() {
            @Override
            public final void run() {
                if (o instanceof EditView) {
                    ((EditView)o).Code(n + n5, n2 + n6, n3 - n5, n4 - n6);
                }
            }
        });
    }
    
    @Override
    public void Code(final Object o, final String s) {
        if (o instanceof EditView) {
            final EditView editView = (EditView)o;
            editView.post((Runnable)new w(editView, s));
        }
    }
    
    @Override
    public void Code(final Object o, final String s, final int n, final boolean b) {
        if (o instanceof URLEditView) {
            ((URLEditView)o).Code(s, n, b);
        }
    }
    
    @Override
    public void Code(final Map map) {
        try {
            EventDispatcher.I(new ServerNotificationSettingsEvent(map));
        }
        catch (IllegalArgumentException ex) {}
    }
    
    @Override
    public void Code(final boolean b) {
        this.B = b;
    }
    
    @Override
    public boolean Code(final int n) {
        return true;
    }
    
    @Override
    public boolean Code(final int n, final String s, final String s2) {
        return x.am && this.I.Code(n, s);
    }
    
    @Override
    public boolean D() {
        if (this.g != null && this.g.isAfterLast()) {
            this.g.close();
            this.g = null;
        }
        if (this.g != null) {
            final int columnIndex = this.g.getColumnIndex("title");
            final int columnIndex2 = this.g.getColumnIndex("url");
            final int columnIndex3 = this.g.getColumnIndex("favicon");
            bo.I = null;
            while (bo.I == null && !this.g.isAfterLast()) {
                if ((bo.I = this.g.getString(columnIndex2)) != null) {
                    bo.Code = this.g.getString(columnIndex);
                    bo.Z = this.g.getBlob(columnIndex3);
                }
                this.g.moveToNext();
            }
            if (bo.I != null) {
                return true;
            }
        }
        return false;
    }
    
    @Override
    public boolean E() {
        return this.Z.B();
    }
    
    @Override
    public boolean F() {
        return false;
    }
    
    @Override
    public int G() {
        return 7;
    }
    
    @Override
    public int H() {
        return 1;
    }
    
    @Override
    public int I(final String s, final String s2) {
        try {
            final String b = com.opera.mini.android.d.b(s);
            final Intent intent = new Intent("android.intent.action.VIEW");
            final Uri fromFile = Uri.fromFile(new File(b));
            if (s2 != null) {
                intent.setDataAndType(fromFile, s2.toLowerCase());
            }
            else {
                intent.setData(fromFile);
            }
            this.Z.startActivity(intent);
            return 0;
        }
        catch (ActivityNotFoundException ex) {
            ex.printStackTrace();
            return 1;
        }
    }
    
    @Override
    public String I(final Object o) {
        if (o instanceof EditText) {
            return ((EditText)o).getText().toString();
        }
        return null;
    }
    
    @Override
    public String I(final String[] array) {
        final LinkedList list = new LinkedList();
        for (int length = array.length, i = 0; i < length; ++i) {
            final String s = array[i];
            String string = null;
            if ("install_non_market_apps".equals(s)) {
                string = Integer.toString(this.aA());
            }
            if (string != null) {
                list.add("\"" + s + "\":\"" + string + "\"");
            }
        }
        return TextUtils.join((CharSequence)",", (Iterable)list);
    }
    
    @Override
    public void I(final int n) {
    }
    
    @Override
    public void I(final int n, final int n2) {
        x.i();
    }
    
    @Override
    public void I(final boolean d) {
        com.opera.mini.android.J.d = d;
        this.J.getHandler().post((Runnable)new Runnable() {
            @Override
            public final void run() {
                Browser.Z.Code(d);
            }
        });
    }
    
    @Override
    public boolean I() {
        return false;
    }
    
    @Override
    public boolean I(String string) {
        final String d = cg.d(string);
        final Uri parse = Uri.parse(d);
        final Intent intent = new Intent("android.intent.action.VIEW", parse);
        Label_0152: {
            if (!d.startsWith("http:") && !d.startsWith("https:") && !d.startsWith("vnd.youtube:")) {
                break Label_0152;
            }
            final PackageManager packageManager = this.Z.getPackageManager();
            final List queryIntentActivities = packageManager.queryIntentActivities(intent, 65536);
            Label_0246: {
                if (!d.startsWith("http:") && !d.startsWith("https:")) {
                    break Label_0246;
                }
                int n = 0;
                while (true) {
                    Label_0239: {
                        if (n < queryIntentActivities.size()) {
                            if (!((ResolveInfo)queryIntentActivities.get(n)).activityInfo.packageName.equals(this.Z.getPackageName())) {
                                break Label_0239;
                            }
                            this.Code(intent, packageManager);
                        }
                        try {
                            final String scheme = parse.getScheme();
                            Label_0229: {
                                if (scheme.startsWith("vnd.opera.video")) {
                                    string = "video/mp4";
                                    if (scheme.length() > 16) {
                                        string = "video/" + scheme.substring(16);
                                    }
                                    intent.setDataAndType(Uri.parse(d.substring(scheme.length() + 1)), string);
                                }
                                else {
                                    if (x.am && scheme.equals("vnd.opera.native.ad")) {
                                        try {
                                            Browser.I.I.Code(Integer.parseInt(parse.getSchemeSpecificPart()));
                                            return false;
                                        }
                                        catch (NumberFormatException ex) {
                                            break Label_0229;
                                        }
                                    }
                                    if (!"mailto".equals(scheme)) {
                                        intent.addCategory("android.intent.category.BROWSABLE");
                                        intent.setComponent((ComponentName)null);
                                    }
                                }
                            }
                            Browser.Z.startActivity(intent);
                            return false;
                            iftrue(Label_0152:)(!d.startsWith("vnd.youtube:") || queryIntentActivities.size() != 0);
                            com.opera.mini.android.a.z().p();
                            return false;
                            ++n;
                            continue;
                        }
                        catch (ActivityNotFoundException ex2) {
                            throw new IOException("Scheme is not supported: " + d);
                        }
                    }
                    break;
                }
            }
        }
    }
    
    @Override
    public int J() {
        final MiniView j = this.J;
        return MiniView.c();
    }
    
    @Override
    public void J(String s, final String s2) {
        if (s2 == null) {
            return;
        }
        final Intent intent = new Intent("android.intent.action.MAIN");
        intent.setClass((Context)Browser.Z, (Class)Browser.class);
        intent.setData(Uri.parse(s2));
        final Intent intent2 = new Intent();
        intent2.putExtra("android.intent.extra.shortcut.INTENT", (Parcelable)intent);
        if (s == null) {
            s = s2;
        }
        intent2.putExtra("android.intent.extra.shortcut.NAME", s);
        final Browser z = Browser.Z;
        int n;
        if (x.ak >= 11) {
            n = 2130837506;
        }
        else {
            n = 2130837505;
        }
        intent2.putExtra("android.intent.extra.shortcut.ICON_RESOURCE", (Parcelable)Intent$ShortcutIconResource.fromContext((Context)z, n));
        intent2.setAction("com.android.launcher.action.INSTALL_SHORTCUT");
        Browser.Z.sendBroadcast(intent2);
    }
    
    @Override
    public void J(final boolean b) {
    }
    
    @Override
    public boolean J(final int n) {
        return false;
    }
    
    @Override
    public boolean J(final String s) {
        final Intent intent = new Intent("android.intent.action.VIEW");
        intent.setDataAndType(Uri.fromFile(new File("/dummy_file.txt")), s.toLowerCase());
        return intent.resolveActivity(this.Z.getPackageManager()) != null;
    }
    
    @Override
    public boolean K() {
        return false;
    }
    
    @Override
    public boolean L() {
        return this.M() == 460;
    }
    
    @Override
    public int M() {
        if (this.e == -1) {
            final TelephonyManager telephonyManager = (TelephonyManager)this.Z.getSystemService("phone");
            if (telephonyManager.getSimState() == 5) {
                final String simOperator = telephonyManager.getSimOperator();
                if (simOperator != null && simOperator != null && simOperator.length() >= 3) {
                    this.e = Integer.parseInt(simOperator.substring(0, 3));
                }
            }
        }
        return this.e;
    }
    
    @Override
    public int N() {
        if (this.f == -1) {
            final TelephonyManager telephonyManager = (TelephonyManager)this.Z.getSystemService("phone");
            if (telephonyManager.getSimState() == 5) {
                final String simOperator = telephonyManager.getSimOperator();
                if (simOperator != null && simOperator != null && simOperator.length() >= 3) {
                    this.f = Integer.parseInt(simOperator.substring(3));
                }
            }
        }
        return this.f;
    }
    
    @Override
    public int O() {
        return 1;
    }
    
    @Override
    public int P() {
        return 1;
    }
    
    @Override
    public void Q() {
        synchronized (this) {
            ++this.h;
        }
    }
    
    @Override
    public void R() {
        synchronized (this) {
            final int h = this.h - 1;
            this.h = h;
            if (h == 0) {
                Browser.Z.Code();
            }
        }
    }
    
    @Override
    public boolean S() {
        return true;
    }
    
    @Override
    public String T() {
        String string = "http://mini.bugs.opera.com?pl=Android&version=7.6";
        if (!"40234".startsWith("$")) {
            string = "http://mini.bugs.opera.com?pl=Android&version=7.6" + "&build=40234";
        }
        String model;
        if (Build.MODEL != null) {
            model = Build.MODEL;
        }
        else {
            model = "unknown";
        }
        return string + "&mo=" + model;
    }
    
    @Override
    public String U() {
        final String code = x.Code((Context)Browser.Z);
        x.o();
        return code;
    }
    
    @Override
    public String V() {
        final NetworkInfo activeNetworkInfo = ((ConnectivityManager)this.Z.getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo != null) {
            final String lowerCase = activeNetworkInfo.getTypeName().toLowerCase();
            final String lowerCase2 = activeNetworkInfo.getSubtypeName().toLowerCase();
            String string = lowerCase;
            if (!lowerCase2.equals("")) {
                string = lowerCase + "/" + lowerCase2;
            }
            return string;
        }
        return "";
    }
    
    @Override
    public void W() {
        MiniView.Code.g();
    }
    
    @Override
    public void X() {
        try {
            Browser.Z.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=com.opera.mini.android")));
        }
        catch (Exception ex) {}
    }
    
    @Override
    public boolean Y() {
        return aq.Z() == 0L;
    }
    
    @Override
    public InputStream Z(final String s) {
        if (s != null) {
            String substring = s;
            if (s.length() > 1) {
                substring = s;
                if (s.charAt(0) == '/') {
                    substring = s.substring(1);
                }
            }
            if (substring.equals("v") || substring.equals("resources")) {
                InputStream inputStream;
                if ((inputStream = this.C(substring, "-" + x.ah + "-" + x.ai)) == null) {
                    inputStream = this.C(substring, "-" + x.ah);
                }
                final InputStream inputStream2;
                if ((inputStream2 = inputStream) != null) {
                    return inputStream2;
                }
            }
            return this.C(substring, "");
        }
        return null;
    }
    
    @Override
    public Vector Z(final int n) {
        return null;
    }
    
    @Override
    public void Z(final Object o) {
    }
    
    @Override
    public void Z(final String s, final String s2) {
        try {
            final Intent intent = new Intent("android.intent.action.SEND");
            intent.setType("text/plain");
            intent.putExtra("android.intent.extra.TEXT", s);
            intent.putExtra("android.intent.extra.SUBJECT", s2);
            Browser.Z.startActivity(Intent.createChooser(intent, (CharSequence)null));
        }
        catch (ActivityNotFoundException ex) {}
    }
    
    @Override
    public void Z(final boolean b) {
    }
    
    @Override
    public boolean Z() {
        return false;
    }
    
    @Override
    public int a() {
        return x.ag.heightPixels;
    }
    
    public int a(final String s) {
        return 0;
    }
    
    @Override
    public boolean a(final int n) {
        return com.opera.mini.android.h.I(n);
    }
    
    public int aA() {
        if (x.ak < 17) {
            return Settings$Secure.getInt(this.Z.getContentResolver(), "install_non_market_apps", 0);
        }
        return ag.Code(this.Z.getContentResolver(), "install_non_market_apps", 0);
    }
    
    @Override
    public boolean aa() {
        return false;
    }
    
    @Override
    public void ab() {
        if (x.s()) {
            as.I();
        }
        ap.Code();
    }
    
    @Override
    public String ac() {
        return this.p;
    }
    
    @Override
    public boolean ad() {
        return this.q;
    }
    
    @Override
    public void ae() {
        EventDispatcher.I(new NotificationStatsAck());
    }
    
    @Override
    public boolean af() {
        return x.al && com.opera.mini.android.notifications.g.Code((Context)Browser.Z).b();
    }
    
    @Override
    public byte[] ag() {
        return com.opera.mini.android.notifications.g.Code((Context)Browser.Z).a();
    }
    
    @Override
    public byte[] ah() {
        if (!com.opera.mini.android.notifications.B.Code((Context)Browser.Z)) {
            final com.opera.mini.android.notifications.a z = com.opera.mini.android.notifications.B.Z();
            if (z != null) {
                return new byte[] { z.Code, z.I };
            }
        }
        return null;
    }
    
    @Override
    public void ai() {
        if (!this.k.isEmpty()) {
            Browser.Z.runOnUiThread((Runnable)new Runnable() {
                @Override
                public final void run() {
                    if (!com.opera.mini.android.J.this.k.isEmpty()) {
                        u.I.h();
                        u.I.Z(44);
                    }
                }
            });
        }
    }
    
    @Override
    public boolean aj() {
        return x.am;
    }
    
    @Override
    public byte[] ak() {
        final Map k = this.k;
        this.k = new ConcurrentHashMap();
        return this.I(k);
    }
    
    @Override
    public az al() {
        return this.e(2130837510);
    }
    
    @Override
    public az am() {
        return this.e(2130837508);
    }
    
    @Override
    public az an() {
        return this.e(2130837509);
    }
    
    @Override
    public az ao() {
        return this.e(2130837507);
    }
    
    @Override
    public boolean ap() {
        return com.opera.mini.android.notifications.B.I((Context)this.Z);
    }
    
    @Override
    public String aq() {
        return x.p();
    }
    
    public boolean ar() {
        return this.Z.C();
    }
    
    public DataOutputStream as() {
        return null;
    }
    
    public DataInputStream at() {
        return null;
    }
    
    public boolean au() {
        return true;
    }
    
    public boolean av() {
        return false;
    }
    
    public boolean ax() {
        return false;
    }
    
    public void ay() {
        if (this.p == null) {
            final SharedPreferences preferences = Browser.Z.getPreferences(0);
            this.p = preferences.getString(com.opera.mini.android.J.r, (String)null);
            this.q = preferences.getBoolean(com.opera.mini.android.J.s, false);
        }
        new Thread(new Runnable() {
            @Override
            public final void run() {
                Label_0115: {
                    if (x.ak < 9 || GooglePlayServicesUtil.isGooglePlayServicesAvailable((Context)com.opera.mini.android.J.this.Z) != 0) {
                        break Label_0115;
                    }
                    while (true) {
                        try {
                            final com.google.android.gms.ads.identifier.Code advertisingIdInfo = AdvertisingIdClient.getAdvertisingIdInfo((Context)com.opera.mini.android.J.this.Z);
                            com.opera.mini.android.J.this.p = advertisingIdInfo.Code();
                            com.opera.mini.android.J.this.q = advertisingIdInfo.I();
                            final SharedPreferences$Editor edit = Browser.Z.getPreferences(0).edit();
                            edit.putString(com.opera.mini.android.J.r, com.opera.mini.android.J.this.p);
                            edit.putBoolean(com.opera.mini.android.J.s, com.opera.mini.android.J.this.q);
                            x.Code(edit);
                            com.opera.mini.android.J.this.p;
                            if (com.opera.mini.android.J.this.p == null) {
                                com.opera.mini.android.J.this.p = com.opera.mini.android.J.this.az();
                            }
                        }
                        catch (SecurityException ex) {
                            continue;
                        }
                        catch (GooglePlayServicesNotAvailableException ex2) {
                            continue;
                        }
                        catch (GooglePlayServicesRepairableException ex3) {
                            continue;
                        }
                        catch (IOException ex4) {
                            continue;
                        }
                        break;
                    }
                }
            }
        }).start();
    }
    
    public String az() {
        final String string = Settings$Secure.getString(Browser.Z.getContentResolver(), "android_id");
        if (string != null) {
            return string;
        }
        return "";
    }
    
    @Override
    public int b() {
        return (int)x.k();
    }
    
    @Override
    public void b(final int n) {
        if (x.al) {
            com.opera.mini.android.notifications.q.Code((Context)this.Z).Code(n);
        }
    }
    
    public void b(final String s) {
    }
    
    @Override
    public int c() {
        return (int)x.l();
    }
    
    public native void c(final int p0);
    
    public void c(final String s) {
    }
    
    public String d(final int n) {
        return null;
    }
    
    @Override
    public boolean d() {
        final boolean b = false;
        final float n = this.C() / x.k();
        final float n2 = this.a() / x.l();
        final double sqrt = Math.sqrt(n * n + n2 * n2);
        if (x.ak >= 4) {
            boolean b2 = b;
            switch (com.opera.mini.android.ah.I()) {
                case 1: {
                    return b2;
                }
                case 2:
                case 3: {
                    b2 = b;
                    if (sqrt >= 5.7) {
                        return true;
                    }
                    return b2;
                }
                case 4: {
                    return true;
                }
            }
        }
        boolean b2 = b;
        if (sqrt >= 5.7) {
            b2 = b;
            if (Math.min(this.a(), this.C()) >= 480) {
                b2 = true;
            }
        }
        return b2;
    }
    
    @Override
    public void e() {
        this.J.a();
    }
    
    @Override
    public boolean f() {
        return true;
    }
    
    @Override
    public boolean g() {
        return false;
    }
    
    @Override
    public int h() {
        if (Build.DEVICE.indexOf("SonyEricssonU20i") < 0) {
            if (Build.DEVICE.indexOf("SonyEricsson") >= 0) {
                final DisplayMetrics displayMetrics = new DisplayMetrics();
                Browser.Z.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
                if (((displayMetrics.heightPixels <= 320 && displayMetrics.widthPixels <= 240) || (displayMetrics.widthPixels <= 240 && displayMetrics.heightPixels <= 320)) && !Browser.Z.C()) {
                    return -1;
                }
            }
            return 0;
        }
        return -1;
    }
    
    @Override
    public void i() {
        this.C.post((Runnable)new Runnable() {
            @Override
            public final void run() {
                com.opera.mini.android.J.B(false);
            }
        });
    }
    
    @Override
    public int j() {
        return this.J.e();
    }
    
    @Override
    public boolean k() {
        return Browser.Z.a();
    }
    
    @Override
    public ap l() {
        return new ap(new d());
    }
    
    @Override
    public boolean m() {
        return true;
    }
    
    @Override
    public void n() {
    }
    
    @Override
    public void o() {
        if (!Browser.Z.J()) {
            this.Z.finish();
        }
        com.opera.mini.android.p.Code();
    }
    
    @Override
    public boolean p() {
        return this.B;
    }
    
    @Override
    public ba q() {
        return com.opera.mini.android.J.a;
    }
    
    @Override
    public ba r() {
        return com.opera.mini.android.J.a;
    }
    
    @Override
    public av s() {
        return com.opera.mini.android.h.Code();
    }
    
    @Override
    public boolean t() {
        return false;
    }
    
    @Override
    public int u() {
        return 4;
    }
    
    @Override
    public int v() {
        int n = 12;
        if (this.Z.getResources().getConfiguration().hardKeyboardHidden == 1) {
            n = 13;
        }
        return n;
    }
    
    @Override
    public af w() {
        return new af((ClipboardManager)this.Z.getSystemService("clipboard"));
    }
    
    @Override
    public bd x() {
        return new s();
    }
    
    @Override
    public void y() {
        System.gc();
    }
    
    @Override
    public void z() {
        this.Z.moveTaskToBack(true);
    }
}
