// 
// Decompiled by Procyon v0.6-prerelease
// 

package com.admarvel.android.ads;

import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.Map;

public class AdMarvelAdapterInstances
{
    private static Map adMarvelAdapterInstances;
    
    static {
        (AdMarvelAdapterInstances.adMarvelAdapterInstances = new ConcurrentHashMap()).put("ADMARVELGUID", createInstances());
    }
    
    public static void buildAdMarvelAdapterInstances(final String s) {
        synchronized (AdMarvelAdapterInstances.class) {
            AdMarvelAdapterInstances.adMarvelAdapterInstances.put(s, createInstances());
        }
    }
    
    private static Map createInstances() {
        final HashMap hashMap = new HashMap();
        while (true) {
            try {
                hashMap.put("com.admarvel.android.admarvelrhythmadapter.AdMarvelRhythmAdapter", AdMarvelAdapter.createInstance("com.admarvel.android.admarvelrhythmadapter.AdMarvelRhythmAdapter"));
                try {
                    hashMap.put("com.admarvel.android.admarvelmillennialadapter.AdMarvelMillennialAdapter", AdMarvelAdapter.createInstance("com.admarvel.android.admarvelmillennialadapter.AdMarvelMillennialAdapter"));
                    try {
                        hashMap.put("com.admarvel.android.admarvelamazonadapter.AdMarvelAmazonAdapter", AdMarvelAdapter.createInstance("com.admarvel.android.admarvelamazonadapter.AdMarvelAmazonAdapter"));
                        try {
                            hashMap.put("com.admarvel.android.admarveladcolonyadapter.AdMarvelAdColonyAdapter", AdMarvelAdapter.createInstance("com.admarvel.android.admarveladcolonyadapter.AdMarvelAdColonyAdapter"));
                            try {
                                hashMap.put("com.admarvel.android.admarvelpulse3dadapter.AdMarvelPulse3dAdapter", AdMarvelAdapter.createInstance("com.admarvel.android.admarvelpulse3dadapter.AdMarvelPulse3dAdapter"));
                                try {
                                    hashMap.put("com.admarvel.android.admarvelgoogleplayadapter.AdMarvelGooglePlayAdapter", AdMarvelAdapter.createInstance("com.admarvel.android.admarvelgoogleplayadapter.AdMarvelGooglePlayAdapter"));
                                    try {
                                        hashMap.put("com.admarvel.android.admarvelfacebookadapter.AdMarvelFacebookAdapter", AdMarvelAdapter.createInstance("com.admarvel.android.admarvelfacebookadapter.AdMarvelFacebookAdapter"));
                                        try {
                                            hashMap.put("com.admarvel.android.admarvelinmobiadapter.AdMarvelInmobiAdapter", AdMarvelAdapter.createInstance("com.admarvel.android.admarvelinmobiadapter.AdMarvelInmobiAdapter"));
                                            try {
                                                hashMap.put("com.admarvel.android.admarvelheyzapadapter.AdMarvelHeyzapAdapter", AdMarvelAdapter.createInstance("com.admarvel.android.admarvelheyzapadapter.AdMarvelHeyzapAdapter"));
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
    
    protected static void destroyAdMarvelAdapterInstances(final String s) {
        synchronized (AdMarvelAdapterInstances.class) {
            AdMarvelAdapterInstances.adMarvelAdapterInstances.remove(s);
        }
    }
    
    public static Map getAdMarvelAdapterInstancesForAdMarvelView() {
        return AdMarvelAdapterInstances.adMarvelAdapterInstances;
    }
    
    public static AdMarvelAdapter getAdapterInstance(final String s) {
        final Map map = AdMarvelAdapterInstances.adMarvelAdapterInstances.get("ADMARVELGUID");
        if (map != null) {
            return (AdMarvelAdapter)map.get(s);
        }
        return null;
    }
    
    public static AdMarvelAdapter getInstance(final String s, final String s2) {
        final Map map = AdMarvelAdapterInstances.adMarvelAdapterInstances.get(s);
        if (map != null) {
            return (AdMarvelAdapter)map.get(s2);
        }
        return null;
    }
}
