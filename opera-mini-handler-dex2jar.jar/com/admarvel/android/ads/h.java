// 
// Decompiled by Procyon v0.6-prerelease
// 

package com.admarvel.android.ads;

import java.util.HashMap;
import java.util.Map;

class h
{
    private static final Map a;
    
    static {
        a = a();
    }
    
    static Map a() {
        final HashMap hashMap = new HashMap();
        while (true) {
            try {
                hashMap.put("com.google.android.gms.ads.AdView", b("com.google.android.gms.ads.AdView"));
                try {
                    hashMap.put("com.rhythmnewmedia.sdk.display.RhythmDisplayAdView", b("com.rhythmnewmedia.sdk.display.RhythmDisplayAdView"));
                    try {
                        hashMap.put("com.millennialmedia.android.MMAdView", b("com.millennialmedia.android.MMAdView"));
                        try {
                            hashMap.put("com.amazon.device.ads.AdLayout", b("com.amazon.device.ads.AdLayout"));
                            try {
                                hashMap.put("com.jirbo.adcolony.AdColony", b("com.jirbo.adcolony.AdColony"));
                                try {
                                    hashMap.put("com.amobee.pulse3d.Pulse3DView", b("com.amobee.pulse3d.Pulse3DView"));
                                    try {
                                        hashMap.put("com.facebook.ads.AdView", b("com.facebook.ads.AdView"));
                                        try {
                                            hashMap.put("com.inmobi.monetization.IMBanner", b("com.inmobi.monetization.IMBanner"));
                                            try {
                                                hashMap.put("com.heyzap.sdk.ads.VideoAd", b("com.heyzap.sdk.ads.VideoAd"));
                                                return hashMap;
                                            }
                                            catch (Exception ex) {
                                                return hashMap;
                                            }
                                        }
                                        catch (Exception ex2) {}
                                    }
                                    catch (Exception ex3) {}
                                }
                                catch (Exception ex4) {}
                            }
                            catch (Exception ex5) {}
                        }
                        catch (Exception ex6) {}
                    }
                    catch (Exception ex7) {}
                }
                catch (Exception ex8) {}
            }
            catch (Exception ex9) {
                continue;
            }
            break;
        }
    }
    
    static boolean a(final String s) {
        return h.a.get(s);
    }
    
    public static boolean b(final String s) {
        try {
            Class.forName(s);
            return true;
        }
        catch (Exception ex) {
            return false;
        }
    }
}
