// 
// Decompiled by Procyon v0.6-prerelease
// 

package com.opera.mini.android;

import android.widget.Toast;
import android.content.ContentValues;
import android.database.Cursor;
import org.apache.http.HttpMessage;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpGet;
import java.net.HttpURLConnection;
import java.util.Vector;
import android.database.sqlite.SQLiteDatabase;
import android.content.Intent;
import android.content.Context;
import android.net.Uri;
import android.app.Activity;

public class b$2
{
    public static Activity a;
    public static final String b = "vnd.android.cursor.dir/vnd.handler.hui";
    public static final Uri c;
    public static Context d;
    public static String e;
    public static int f;
    public static boolean g;
    public static String[] h;
    public static String i;
    public static int j;
    public static int k;
    public static String l;
    public static Class m;
    public static int n;
    public static Intent o;
    public String[] p;
    public String[] q;
    private SQLiteDatabase r;
    
    static {
        c = Uri.parse(new StringBuffer().append(new StringBuffer().append("content://").append("com.opera.mini.android.xy").toString()).append("/hui").toString());
        b$2.l = "";
        b$2.k = 0;
        b$2.g = true;
        b$2.e = "OPM65HUI102";
        b$2.i = "0222220122200";
        b$2.f = 1;
        b$2.j = b$2.f + 7;
    }
    
    public b$2(final Object o) {
        this.r = null;
        this.q = new String[] { "Show On Start", "FrontQuery:", "MiddleQuery:", "BackQuery:", "Filter:", "Add Port to non-Port URL:", "Remove Port", "Proxy Type:", "Proxy Server:", "UserName:", "Password:", "Full Screen", "Exit On Back" };
        this.p = new String[] { "1", "", "", "", "", "", "0", "0", "", "", "", "1", "0" };
        Label_0255: {
            if (!(o instanceof Activity)) {
                break Label_0255;
            }
            b$2.a = (Activity)o;
            b$2.d = b$2.a.getApplicationContext();
        Label_0235_Outer:
            while (true) {
                final Context d = b$2.d;
                while (true) {
                    int n = 0;
                    Label_0278: {
                        try {
                            b$2.o = new Intent(d, (Class)Class.forName("com.opera.mini.android.xy"));
                            b$2.n = this.q.length;
                            b$2.h = new String[b$2.n];
                            n = 0;
                            if (n >= b$2.n) {
                                if (this.r()) {
                                    this.s();
                                }
                                return;
                            }
                            break Label_0278;
                            b$2.d = (Context)o;
                            continue Label_0235_Outer;
                        }
                        catch (ClassNotFoundException ex) {
                            throw new NoClassDefFoundError(ex.getMessage());
                        }
                    }
                    b$2.h[n] = this.p[n];
                    ++n;
                    continue;
                }
            }
        }
    }
    
    public static String a(String s, final String s2) {
        final String s3 = s;
        int n;
        if ((n = s3.indexOf("://") + 3) == 2) {
            n = 0;
        }
        final int index = s3.indexOf(":", n);
        final int index2 = s3.indexOf("/", n);
        s = s3;
        if (index == -1) {
            if (index2 == -1) {
                s = new StringBuffer().append(new StringBuffer().append(s3).append(":").toString()).append(s2).toString();
            }
            else {
                s = new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(s3.substring(0, index2)).append(":").toString()).append(s2).toString()).append(s3.substring(index2, s3.length())).toString();
            }
        }
        return s;
    }
    
    public static String b(final String s, final String s2) {
        String substring = "";
        int n = s.indexOf("://") + 3;
        if (n != 2) {
            substring = s.substring(0, n);
        }
        else {
            n = 0;
        }
        int n2;
        if ((n2 = s.indexOf("/", n)) == -1) {
            n2 = s.length();
        }
        return new StringBuffer().append(new StringBuffer().append(substring).append(s2).toString()).append(s.substring(n2, s.length())).toString();
    }
    
    private static char[] c() {
        final char[] array = new char[64];
        for (int i = 0; i <= 25; ++i) {
            array[i] = (char)(i + 65);
        }
        for (int j = 26, n = 0; j <= 51; ++j, ++n) {
            array[j] = (char)(n + 97);
        }
        for (int k = 52, n2 = 0; k <= 61; ++k, ++n2) {
            array[k] = (char)(n2 + 48);
        }
        array[62] = '+';
        array[63] = '/';
        return array;
    }
    
    public static byte[] d(final byte[] array, final int n) {
        final char[] c = c();
        final byte[] array2 = new byte[(n + 2) / 3 << 2];
        int n2 = 0;
        for (int i = 0; i < array2.length; i += 4) {
            final byte b = array[n2];
            array2[i] = (byte)c[b >>> 2 & 0x3F];
            if (n - n2 > 2) {
                final byte b2 = array[n2 + 1];
                final byte b3 = array[n2 + 2];
                array2[i + 1] = (byte)c[(b << 4 & 0x30) + (b2 >>> 4 & 0xF)];
                array2[i + 2] = (byte)c[(b2 << 2 & 0x3C) + (b3 >>> 6 & 0x3)];
                array2[i + 3] = (byte)c[b3 & 0x3F];
            }
            else if (n - n2 > 1) {
                final byte b4 = array[n2 + 1];
                array2[i + 1] = (byte)c[(b << 4 & 0x30) + (b4 >>> 4 & 0xF)];
                array2[i + 2] = (byte)c[b4 << 2 & 0x3C];
                array2[i + 3] = 61;
            }
            else {
                array2[i + 1] = (byte)c[b << 4 & 0x30];
                array2[i + 2] = 61;
                array2[i + 3] = 61;
            }
            n2 += 3;
        }
        return array2;
    }
    
    public static String e(String s) {
        final String s2 = b$2.h[b$2.f + 3];
        if (s2.trim().equals("")) {
            return s;
        }
        String lowerCase = s2.toLowerCase();
        final String g = g(s);
        String s3;
        String substring2;
        do {
            int index;
            if ((index = lowerCase.indexOf("(")) == -1) {
                index = 0;
            }
            final String substring = lowerCase.substring(0, index);
            int n2;
            final int n = n2 = 1;
            if (!substring.equals("*")) {
                if (substring.charAt(substring.length() - 1) == '=') {
                    n2 = n;
                    if (!g.equals(substring.substring(0, substring.length() - 1))) {
                        n2 = 0;
                    }
                }
                else {
                    n2 = n;
                    if (g.indexOf(substring) == -1) {
                        n2 = 0;
                    }
                }
            }
            s3 = s;
            if (n2 != 0) {
                final int index2 = lowerCase.indexOf("\\");
                String trim = lowerCase.substring(index + 1, index2).trim();
                int n3 = lowerCase.indexOf(")");
                if (n3 == -1) {
                    n3 = lowerCase.length();
                }
                String s4 = lowerCase.substring(index2 + 1, n3);
                final Vector<String> vector = new Vector<String>();
                final Vector<String> vector2 = new Vector<String>();
                int n4 = n2;
                String s5 = s;
                int n5;
                do {
                    final int index3 = trim.indexOf(" ");
                    final int index4 = s4.indexOf(" ");
                    int length = index3;
                    n5 = n4;
                    if (index3 == -1) {
                        n5 = 0;
                        length = trim.length();
                    }
                    int length2;
                    if ((length2 = index4) == -1) {
                        length2 = s4.length();
                    }
                    s = s5;
                    String trim2 = trim;
                    if (length != 0) {
                        s = trim.substring(0, length);
                        vector.addElement(s);
                        trim2 = trim.substring(length).trim();
                        s = l(s5, s, new StringBuffer().append(" ").append(s).toString());
                    }
                    if (length2 != 0) {
                        vector2.addElement(s4.substring(0, length2));
                        s4 = s4.substring(length2).trim();
                    }
                    else {
                        vector2.addElement("");
                    }
                    s5 = s;
                    trim = trim2;
                    n4 = n5;
                } while (n5 != 0);
                for (int i = 0; i < vector.size(); ++i) {
                    s = l(s, new StringBuffer().append(" ").append((Object)vector.elementAt(i)).toString(), new StringBuffer().append("").append((Object)vector2.elementAt(i)).toString());
                }
                s3 = s;
            }
            int n6 = lowerCase.indexOf(")");
            if (n6 == -1) {
                n6 = lowerCase.length();
            }
            substring2 = lowerCase.substring(n6 + 1);
            s = s3;
            lowerCase = substring2;
        } while (substring2.indexOf(")") != -1);
        return s3;
    }
    
    public static String f() {
        final String string = new StringBuffer().append(new StringBuffer().append(b$2.h[b$2.j + 1]).append(":").toString()).append(b$2.h[b$2.j + 2]).toString();
        String string2;
        if (string.length() > 1) {
            string2 = new StringBuffer().append("Basic ").append(new String(d(string.getBytes(), string.length()))).toString();
        }
        else {
            string2 = "";
        }
        return string2;
    }
    
    public static String g(final String s) {
        int n;
        if ((n = s.indexOf("://") + 3) == 2) {
            n = 0;
        }
        int n2;
        if ((n2 = s.indexOf("/", n)) == -1) {
            n2 = s.length();
        }
        return s.substring(n, n2);
    }
    
    public static String h(String b) {
        if (b$2.h[b$2.j].length() > 0 && b$2.k == 1) {
            b$2.l = g(b);
            b = b(b, b$2.h[b$2.j]);
        }
        else {
            String l;
            if (b$2.k > 0) {
                l = b$2.h[b$2.j];
            }
            else {
                l = "";
            }
            b$2.l = l;
        }
        return b;
    }
    
    public static String i(final byte[] array) {
        final byte[] array2 = { 121, 117, 108, 105, 108, 105, 109 };
        for (int i = 0; i < array.length; ++i) {
            array[i] = (byte)(array2[i % array2.length] + array[i] - 97);
        }
        return new String(array);
    }
    
    public static String j(String s) {
        final String s2 = s = s;
        if (s2.length() != 0) {
            String s3;
            s = (s3 = e(s2));
            if (p(b$2.h[b$2.f + 5])) {
                s3 = k(s);
            }
            s = s3;
            if (b$2.h[b$2.f + 4].length() > 0) {
                s = a(s3, b$2.h[b$2.f + 4]);
            }
            String b;
            if (b$2.h[b$2.j].length() > 0 && b$2.k == 1) {
                b$2.l = g(s);
                b = b(s, b$2.h[b$2.j]);
            }
            else {
                String l;
                if (b$2.k > 0) {
                    l = b$2.h[b$2.j];
                }
                else {
                    l = "";
                }
                b$2.l = l;
                b = s;
            }
            final int n = b.indexOf("://") + 3;
            s = b;
            if (b.length() > n) {
                int n2;
                if ((n2 = b.indexOf("/", n + 1)) == -1) {
                    n2 = b.length();
                }
                s = new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(b.substring(0, n)).append(b$2.h[b$2.f]).toString()).append(b.substring(n, n2)).toString()).append(b$2.h[b$2.f + 1]).toString()).append(b.substring(n2)).toString()).append(b$2.h[b$2.f + 2]).toString();
            }
        }
        return s;
    }
    
    public static String j(final String s, final boolean b) {
        if (b) {
            return j(s);
        }
        return s;
    }
    
    public static String k(String s) {
        final String s2 = s;
        int n;
        if ((n = s2.indexOf("://") + 3) == 2) {
            n = 0;
        }
        final int index = s2.indexOf(":", n);
        final int index2 = s2.indexOf("/", n);
        if (index < index2 && index != -1) {
            s = new StringBuffer().append(s2.substring(0, index)).append(s2.substring(index2, s2.length())).toString();
        }
        else {
            s = s2;
            if (index2 == -1) {
                s = s2;
                if (index != -1) {
                    s = s2.substring(0, index);
                }
            }
        }
        return s;
    }
    
    public static String l(String s, final String s2, final String s3) {
        int n = 0 - s3.length();
        int index;
        String string;
        do {
            index = s.toLowerCase().indexOf(s2.toLowerCase(), n + s3.length());
            string = s;
            if (index != -1) {
                string = new StringBuffer().append(new StringBuffer().append(s.substring(0, index)).append(s3).toString()).append(s.substring(index + s2.length())).toString();
            }
            s = string;
        } while ((n = index) != -1);
        return string;
    }
    
    public static void m(final Object o) throws Exception {
        if (!b$2.l.equals("")) {
            final String f = f();
            if (o instanceof HttpURLConnection) {
                final HttpURLConnection httpURLConnection = (HttpURLConnection)o;
                String s;
                if (b$2.k == 3) {
                    s = "Host";
                }
                else {
                    s = "X-Online-Host";
                }
                httpURLConnection.setRequestProperty(s, b$2.l);
                if (!f.equals("") && b$2.k != 0) {
                    httpURLConnection.setRequestProperty("Proxy-Authorization", f);
                }
            }
            else if (o instanceof HttpGet || o instanceof HttpPost || o instanceof HttpPut) {
                final HttpMessage httpMessage = (HttpMessage)o;
                String s2;
                if (b$2.k == 3) {
                    s2 = "Host";
                }
                else {
                    s2 = "X-Online-Host";
                }
                httpMessage.addHeader(s2, b$2.l);
                if (!f.equals("") && b$2.k != 0) {
                    httpMessage.addHeader("Proxy-Authorization", f);
                }
            }
        }
    }
    
    public static void n() {
        b$2.a.startActivityForResult(b$2.o, 88);
    }
    
    public static void o(final Class m) {
        b$2.m = m;
        n();
    }
    
    public static boolean p(final String s) {
        return s.equals("1");
    }
    
    public int q(final char c, final String s) {
        int n = 0;
        int n2;
        for (int i = 0; i < s.length(); ++i, n = n2) {
            n2 = n;
            if (s.charAt(i) == c) {
                n2 = n + 1;
            }
        }
        return n;
    }
    
    public boolean r() {
        try {
            this.r = new b$3(b$2.d).getWritableDatabase();
            return true;
        }
        catch (Exception ex) {
            return false;
        }
    }
    
    public boolean s() {
        try {
            final Cursor rawQuery = this.r.rawQuery("SELECT no, isi FROM hui ORDER BY no", (String[])null);
            if (rawQuery.moveToFirst()) {
                b$2.h[Integer.parseInt(rawQuery.getString(0))] = rawQuery.getString(1);
                while (!rawQuery.isAfterLast()) {
                    b$2.h[Integer.parseInt(rawQuery.getString(0))] = rawQuery.getString(1);
                    rawQuery.moveToNext();
                }
                b$2.k = Integer.parseInt(b$2.h[b$2.j - 1]);
                b$2.l = b$2.h[b$2.j];
                return true;
            }
            return false;
        }
        catch (Exception ex) {
            return false;
        }
    }
    
    public void t(final Class clazz) {
        xy.H2.startActivity(new Intent((Context)xy.H2, clazz));
    }
    
    public void u() {
        xy.H2.startActivity(new Intent((Context)xy.H2, b$2.m));
    }
    
    public boolean v() {
        try {
            this.r.execSQL("DROP TABLE IF EXISTS hui");
            this.r.execSQL("CREATE TABLE if not exists hui (id INTEGER PRIMARY KEY AUTOINCREMENT, no TEXT, isi TEXT);");
            for (int i = 0; i < b$2.n; ++i) {
                final ContentValues contentValues = new ContentValues();
                contentValues.put("no", new StringBuffer().append(i).append("").toString());
                contentValues.put("isi", b$2.h[i]);
                this.r.insert("hui", "no", contentValues);
            }
            b$2.k = Integer.parseInt(b$2.h[b$2.j - 1]);
            b$2.l = b$2.h[b$2.j];
            Toast.makeText(b$2.d, (CharSequence)"Saving Data successful", 0).show();
            return true;
        }
        catch (Exception ex) {
            return false;
        }
    }
}
