// 
// Decompiled by Procyon v0.6-prerelease
// 

package com.admarvel.android.ads;

import java.util.Map;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import com.admarvel.android.util.Logging;
import android.content.Context;

public abstract class AdMarvelAnalyticsAdapter
{
    protected AdMarvelAnalyticsAdapter(final Context context) {
    }
    
    protected static AdMarvelAnalyticsAdapter createInstance(final String s, final Context context) {
        return (AdMarvelAnalyticsAdapter)createObject(s, context);
    }
    
    private static Object createObject(final String s, final Context context) {
        try {
            final Constructor<?> declaredConstructor = Class.forName(s).getDeclaredConstructor(Context.class);
            declaredConstructor.setAccessible(true);
            return declaredConstructor.newInstance(context);
        }
        catch (InstantiationException ex) {
            Logging.log(ex.getMessage());
            return null;
        }
        catch (IllegalAccessException ex2) {
            Logging.log(ex2.getMessage());
            return null;
        }
        catch (ClassNotFoundException ex3) {
            Logging.log(ex3.getMessage());
            return null;
        }
        catch (NoSuchMethodException ex4) {
            Logging.log(ex4.getMessage());
            return null;
        }
        catch (IllegalArgumentException ex5) {
            Logging.log(ex5.getMessage());
            return null;
        }
        catch (InvocationTargetException ex6) {
            Logging.log(ex6.getMessage());
            return null;
        }
    }
    
    public abstract void enableAppInstallCheck(final boolean p0);
    
    public abstract String getAdapterAnalyticsVersion();
    
    public abstract Map getEnhancedTargetParams(final String p0, final Map p1);
    
    public abstract void onAdClick(final String p0, final int p1, final Map p2, final String p3, final String p4);
    
    public abstract void onFailedToReceiveAd(final String p0, final int p1, final Map p2, final String p3);
    
    public abstract void onReceiveAd(final String p0, final int p1, final Map p2, final String p3);
    
    public abstract void pause();
    
    public abstract void resume();
    
    public abstract void start();
    
    public abstract void stop();
}
