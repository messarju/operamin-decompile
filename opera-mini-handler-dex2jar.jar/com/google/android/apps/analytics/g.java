// 
// Decompiled by Procyon v0.6-prerelease
// 

package com.google.android.apps.analytics;

import java.util.Locale;

final class g
{
    private static String Code(final a a) {
        final StringBuilder sb = new StringBuilder();
        final J b = a.b;
        if (b == null) {
            return "";
        }
        if (!b.I()) {
            return "";
        }
        final Z[] code = b.Code();
        Code(code, sb, 8);
        Code(code, sb, 9);
        Code(code, sb, 11);
        return sb.toString();
    }
    
    public static String Code(final a a, final t t) {
        final StringBuilder sb = new StringBuilder();
        if ("__##GOOGLEPAGEVIEW##__".equals(a.I)) {
            String z = "";
            if (a.Z != null) {
                z = a.Z;
            }
            String string = z;
            if (!z.startsWith("/")) {
                string = "/" + z;
            }
            final String code = I.Code(string, "UTF-8");
            final String code2 = Code(a);
            final Locale default1 = Locale.getDefault();
            final StringBuilder sb2 = new StringBuilder();
            sb2.append("/__utm.gif");
            sb2.append("?utmwv=4.8.1ma");
            sb2.append("&utmn=").append(a.Code());
            if (code2.length() > 0) {
                sb2.append("&utme=").append(code2);
            }
            sb2.append("&utmcs=UTF-8");
            sb2.append(String.format("&utmsr=%dx%d", a.C, a.a));
            sb2.append(String.format("&utmul=%s-%s", default1.getLanguage(), default1.getCountry()));
            sb2.append("&utmp=").append(code);
            sb2.append("&utmac=").append(a.Code);
            sb2.append("&utmcc=").append(I(a, t));
            if (a.I() != 0) {
                sb2.append("&utmhid=").append(a.I());
            }
            sb.append(sb2.toString());
        }
        else if ("__##GOOGLEITEM##__".equals(a.I)) {
            final StringBuilder sb3 = new StringBuilder();
            sb3.append("/__utm.gif");
            sb3.append("?utmwv=4.8.1ma");
            sb3.append("&utmn=").append(a.Code());
            sb3.append("&utmt=item");
            final k f = a.f();
            if (f != null) {
                Code(sb3, "&utmtid", f.Code());
                Code(sb3, "&utmipc", f.I());
                Code(sb3, "&utmipn", f.Z());
                Code(sb3, "&utmiva", f.J());
                Code(sb3, "&utmipr", f.B());
                sb3.append("&utmiqt=");
                if (f.C() != 0L) {
                    sb3.append(f.C());
                }
            }
            sb3.append("&utmac=").append(a.Code);
            sb3.append("&utmcc=").append(I(a, t));
            sb.append(sb3.toString());
        }
        else if ("__##GOOGLETRANSACTION##__".equals(a.I)) {
            final StringBuilder sb4 = new StringBuilder();
            sb4.append("/__utm.gif");
            sb4.append("?utmwv=4.8.1ma");
            sb4.append("&utmn=").append(a.Code());
            sb4.append("&utmt=tran");
            final u e = a.e();
            if (e != null) {
                Code(sb4, "&utmtid", e.Code());
                Code(sb4, "&utmtst", e.I());
                Code(sb4, "&utmtto", e.Z());
                Code(sb4, "&utmttx", e.J());
                Code(sb4, "&utmtsp", e.B());
                Code(sb4, "&utmtci", "");
                Code(sb4, "&utmtrg", "");
                Code(sb4, "&utmtco", "");
            }
            sb4.append("&utmac=").append(a.Code);
            sb4.append("&utmcc=").append(I(a, t));
            sb.append(sb4.toString());
        }
        else {
            final Locale default2 = Locale.getDefault();
            final StringBuilder sb5 = new StringBuilder();
            final StringBuilder sb6 = new StringBuilder();
            sb6.append(String.format("5(%s*%s", I.Code(a.I, "UTF-8"), I.Code(a.Z, "UTF-8")));
            if (a.J != null) {
                sb6.append("*").append(I.Code(a.J, "UTF-8"));
            }
            sb6.append(")");
            if (a.B >= 0) {
                sb6.append(String.format("(%d)", a.B));
            }
            sb6.append(Code(a));
            sb5.append("/__utm.gif");
            sb5.append("?utmwv=4.8.1ma");
            sb5.append("&utmn=").append(a.Code());
            sb5.append("&utmt=event");
            sb5.append("&utme=").append(sb6.toString());
            sb5.append("&utmcs=UTF-8");
            sb5.append(String.format("&utmsr=%dx%d", a.C, a.a));
            sb5.append(String.format("&utmul=%s-%s", default2.getLanguage(), default2.getCountry()));
            sb5.append("&utmac=").append(a.Code);
            sb5.append("&utmcc=").append(I(a, t));
            if (a.I() != 0) {
                sb5.append("&utmhid=").append(a.I());
            }
            sb.append(sb5.toString());
        }
        if (a.c()) {
            sb.append("&aip=1");
        }
        if (!a.d()) {
            sb.append("&utmht=" + System.currentTimeMillis());
        }
        return sb.toString();
    }
    
    private static String Code(final String s) {
        return s.replace("'", "'0").replace(")", "'1").replace("*", "'2").replace("!", "'3");
    }
    
    private static void Code(final StringBuilder sb, final String s, double n) {
        sb.append(s).append("=");
        n = Math.floor(n * 1000000.0 + 0.5) / 1000000.0;
        if (n != 0.0) {
            sb.append(Double.toString(n));
        }
    }
    
    private static void Code(final StringBuilder sb, final String s, final String s2) {
        sb.append(s).append("=");
        if (s2 != null && s2.trim().length() > 0) {
            sb.append(I.Code(s2, "UTF-8"));
        }
    }
    
    private static void Code(final Z[] array, final StringBuilder sb, final int n) {
        sb.append(n).append("(");
        int n2 = 1;
        int n3;
        for (int i = 0; i < array.length; ++i, n2 = n3) {
            n3 = n2;
            if (array[i] != null) {
                final Z z = array[i];
                if (n2 == 0) {
                    sb.append("*");
                }
                else {
                    n2 = 0;
                }
                sb.append(z.J()).append("!");
                n3 = n2;
                switch (n) {
                    default: {
                        n3 = n2;
                        break;
                    }
                    case 11: {
                        sb.append(z.Code());
                        n3 = n2;
                        break;
                    }
                    case 9: {
                        sb.append(Code(I.Code(z.Z(), "UTF-8")));
                        n3 = n2;
                        break;
                    }
                    case 8: {
                        sb.append(Code(I.Code(z.I(), "UTF-8")));
                        n3 = n2;
                    }
                    case 10: {
                        break;
                    }
                }
            }
        }
        sb.append(")");
    }
    
    private static String I(final a a, final t t) {
        final StringBuilder sb = new StringBuilder();
        sb.append("__utma=");
        sb.append("1.");
        sb.append(a.a()).append(".");
        sb.append(a.Z()).append(".");
        sb.append(a.J()).append(".");
        sb.append(a.B()).append(".");
        sb.append(a.C()).append(";");
        if (t != null) {
            sb.append("+__utmz=");
            sb.append("1.");
            sb.append(t.I()).append(".");
            sb.append(Integer.valueOf(t.Z()).toString()).append(".");
            sb.append(Integer.valueOf(t.J()).toString()).append(".");
            sb.append(t.Code()).append(";");
        }
        return I.Code(sb.toString(), "UTF-8");
    }
}
