// 
// Decompiled by Procyon v0.6-prerelease
// 

package com.opera.mini.android;

import java.net.UnknownHostException;
import java.net.InetAddress;
import android.os.AsyncTask;

final class bp extends AsyncTask
{
    private final String[] Code;
    private String I;
    private final String[] J;
    private final bo[] Z;
    
    public bp(final String s) {
        this.I = "";
        this.Code = s.split("\n");
        final int length = this.Code.length;
        this.Z = new bo[length];
        this.J = new String[length];
    }
    
    private Void Code() {
        while (true) {
            try {
                this.I = InetAddress.getByName("p" + System.nanoTime() % 65537L + ".dnsecho.opera.com").getHostAddress();
                int i = 0;
            Label_0104_Outer:
                while (i < this.Z.length) {
                    String[] split;
                    while (true) {
                        try {
                            final bo[] z = this.Z;
                            final String s = this.Code[i];
                            split = s.split(";");
                            final int int1 = Integer.parseInt(split[3]);
                            bm bm;
                            if (int1 == 0) {
                                bm = new bm(s);
                            }
                            else {
                                if (int1 != 1) {
                                    throw new IllegalArgumentException("Unknown test type " + split[3]);
                                }
                                bm = new bm(s, "HEAD");
                            }
                            z[i] = bm;
                            this.Z[i].I();
                            this.publishProgress((Object[])new Integer[] { i });
                            if (!this.isCancelled()) {
                                ++i;
                                continue Label_0104_Outer;
                            }
                            break;
                        }
                        catch (Exception ex) {
                            this.J[i] = ex.getMessage();
                            continue;
                        }
                        break;
                    }
                    throw new IllegalArgumentException("Unknown test type " + split[3]);
                }
                return null;
            }
            catch (UnknownHostException ex2) {
                continue;
            }
            break;
        }
    }
    
    private void Code(int i, String s, final boolean b, final String s2) {
        final String string = "probe:/send_result/" + i + "/" + s;
        final String[] array = { "X-Connection-Type", bk.I, "X-Signal-Quality", Integer.toString(bk.Code), "X-DNS-Resolver-IP", this.I, "X-Test-Type", Integer.toString(i), "X-Probe-Failure", null };
        if (b) {
            s = "1";
        }
        else {
            s = "0";
        }
        array[9] = s;
        if (u.Code.p()) {
            throw new IllegalStateException();
        }
        u.I.h();
        u.Z.b(u.Z.Code(string));
        u.Z.l(array.length);
        for (i = 0; i < array.length; ++i) {
            u.Z.m(u.Z.Code(array[i]));
        }
        u.Z.b(u.Z.n());
        u.Z.b(u.Z.Code(s2));
        u.I.Z(8);
    }
}
