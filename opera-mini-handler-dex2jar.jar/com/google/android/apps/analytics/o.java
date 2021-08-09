// 
// Decompiled by Procyon v0.6-prerelease
// 

package com.google.android.apps.analytics;

import org.apache.http.HttpEntityEnclosingRequest;
import org.apache.http.HttpException;
import java.io.IOException;
import android.util.Log;
import org.apache.http.message.BasicHttpEntityEnclosingRequest;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;

final class o implements Runnable
{
    private final LinkedList Code;
    private /* synthetic */ n I;
    
    public o(final n i, final f[] array) {
        this.I = i;
        Collections.addAll(this.Code = new LinkedList(), array);
    }
    
    public final f Code() {
        return this.Code.poll();
    }
    
    @Override
    public final void run() {
        this.I.a = this;
        if (0 >= 5 || this.Code.size() <= 0) {
            goto Label_0379;
        }
        while (true) {
            long n = 0L;
            int n2 = 0;
            String code;
            String s;
            BasicHttpEntityEnclosingRequest basicHttpEntityEnclosingRequest;
            String s2;
            Block_11_Outer:Label_0190_Outer:
            while (true) {
            Label_0625:
                while (true) {
                    Label_0617: {
                        try {
                            if (this.I.J == 500 || this.I.J == 503) {
                                n = (long)(Math.random() * this.I.C);
                                if (this.I.C < 256L) {
                                    this.I.C *= 2L;
                                    n = n;
                                }
                            }
                            else {
                                this.I.C = 2L;
                            }
                            Thread.sleep(n * 1000L);
                            this.I.d;
                            d.Code();
                            d.B();
                            n2 = 0;
                            if (n2 >= this.Code.size() || n2 >= this.I.B) {
                                goto Label_0584;
                            }
                            code = w.Code(this.Code.get(n2).Code, System.currentTimeMillis());
                            if (code.indexOf(63) < 0) {
                                break Label_0617;
                            }
                            goto Label_0429;
                            while (true) {
                                Label_0289: {
                                    while (true) {
                                        while (true) {
                                            s = s + ":" + this.I.d.I.getPort();
                                            break Label_0289;
                                            basicHttpEntityEnclosingRequest = new BasicHttpEntityEnclosingRequest("GET", code);
                                            s = this.I.d.I.getHostName();
                                            iftrue(Label_0289:)(this.I.d.I.getPort() == 80);
                                            continue Block_11_Outer;
                                        }
                                        iftrue(Label_0478:)(s2.length() >= 2036);
                                        continue Label_0190_Outer;
                                    }
                                    Log.w("GoogleAnalyticsTracker", "Hit too long (> 8192 bytes)--not sent");
                                    this.I.c.I();
                                    break Label_0625;
                                }
                                ((HttpEntityEnclosingRequest)basicHttpEntityEnclosingRequest).addHeader("Host", s);
                                ((HttpEntityEnclosingRequest)basicHttpEntityEnclosingRequest).addHeader("User-Agent", this.I.Z);
                                d.Code();
                                d.B();
                                iftrue(Label_0553:)(s2.length() <= 8192);
                                continue;
                            }
                        }
                        catch (InterruptedException ex) {
                            Log.w("GoogleAnalyticsTracker", "Couldn't sleep.", (Throwable)ex);
                        }
                        catch (IOException ex2) {
                            Log.w("GoogleAnalyticsTracker", "Problem with socket or streams.", (Throwable)ex2);
                            goto Label_0379;
                        }
                        catch (HttpException ex3) {
                            Log.w("GoogleAnalyticsTracker", "Problem with http streams.", (Throwable)ex3);
                            goto Label_0379;
                        }
                    }
                    s2 = "";
                    continue;
                }
                ++n2;
                continue Label_0190_Outer;
            }
        }
    }
}
