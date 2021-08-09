// 
// Decompiled by Procyon v0.6-prerelease
// 

package com.facebook.ads.internal;

import android.hardware.SensorEventListener;
import android.app.ActivityManager;
import android.app.ActivityManager$MemoryInfo;
import android.os.StatFs;
import android.os.Environment;
import android.content.Intent;
import android.content.BroadcastReceiver;
import android.content.IntentFilter;
import android.content.Context;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import android.hardware.SensorManager;
import java.util.Map;
import android.hardware.Sensor;

public class AdAnalogData
{
    private static Sensor accelerometer;
    private static volatile float[] accelerometerValues;
    private static Map analogInfo;
    private static Sensor gyroscope;
    private static volatile float[] gyroscopeValues;
    private static String[] sensorDimensions;
    private static SensorManager sensorManager;
    
    static {
        AdAnalogData.sensorManager = null;
        AdAnalogData.accelerometer = null;
        AdAnalogData.gyroscope = null;
        AdAnalogData.analogInfo = new ConcurrentHashMap();
        AdAnalogData.sensorDimensions = new String[] { "x", "y", "z" };
    }
    
    public static Map getAnalogInfo() {
        final HashMap hashMap = new HashMap();
        hashMap.putAll(AdAnalogData.analogInfo);
        putSensorData(hashMap);
        return hashMap;
    }
    
    private static void putBatteryData(final Context context) {
        final Intent registerReceiver = context.registerReceiver((BroadcastReceiver)null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        if (registerReceiver == null) {
            return;
        }
        final int intExtra = registerReceiver.getIntExtra("level", -1);
        final int intExtra2 = registerReceiver.getIntExtra("scale", -1);
        final int intExtra3 = registerReceiver.getIntExtra("status", -1);
        int n;
        if (intExtra3 == 2 || intExtra3 == 5) {
            n = 1;
        }
        else {
            n = 0;
        }
        float n2 = 0.0f;
        if (intExtra2 > 0) {
            n2 = intExtra / (float)intExtra2 * 100.0f;
        }
        AdAnalogData.analogInfo.put("battery", n2);
        final Map analogInfo = AdAnalogData.analogInfo;
        int n3;
        if (n != 0) {
            n3 = 1;
        }
        else {
            n3 = 0;
        }
        analogInfo.put("charging", n3);
    }
    
    private static void putDiskInfo(final Context context) {
        final StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
        AdAnalogData.analogInfo.put("free_space", statFs.getAvailableBlocks() * (long)statFs.getBlockSize());
    }
    
    private static void putMemoryInfo(final Context context) {
        final ActivityManager$MemoryInfo activityManager$MemoryInfo = new ActivityManager$MemoryInfo();
        ((ActivityManager)context.getSystemService("activity")).getMemoryInfo(activityManager$MemoryInfo);
        AdAnalogData.analogInfo.put("available_memory", String.valueOf(activityManager$MemoryInfo.availMem));
    }
    
    private static void putSensorData(final Map map) {
        final int n = 0;
        final float[] accelerometerValues = AdAnalogData.accelerometerValues;
        final float[] gyroscopeValues = AdAnalogData.gyroscopeValues;
        if (accelerometerValues != null) {
            for (int min = Math.min(AdAnalogData.sensorDimensions.length, accelerometerValues.length), i = 0; i < min; ++i) {
                map.put("accelerometer_" + AdAnalogData.sensorDimensions[i], accelerometerValues[i]);
            }
        }
        if (gyroscopeValues != null) {
            for (int min2 = Math.min(AdAnalogData.sensorDimensions.length, gyroscopeValues.length), j = n; j < min2; ++j) {
                map.put("rotation_" + AdAnalogData.sensorDimensions[j], gyroscopeValues[j]);
            }
        }
    }
    
    public static void startUpdate(final Context context) {
        synchronized (AdAnalogData.class) {
            putMemoryInfo(context);
            putDiskInfo(context);
            putBatteryData(context);
            if (AdAnalogData.sensorManager != null || (AdAnalogData.sensorManager = (SensorManager)context.getSystemService("sensor")) != null) {
                if (AdAnalogData.accelerometer == null) {
                    AdAnalogData.accelerometer = AdAnalogData.sensorManager.getDefaultSensor(1);
                }
                if (AdAnalogData.gyroscope == null) {
                    AdAnalogData.gyroscope = AdAnalogData.sensorManager.getDefaultSensor(4);
                }
                if (AdAnalogData.accelerometer != null) {
                    AdAnalogData.sensorManager.registerListener((SensorEventListener)new AdAnalogData$AdSensorEventListener(null), AdAnalogData.accelerometer, 3);
                }
                if (AdAnalogData.gyroscope != null) {
                    AdAnalogData.sensorManager.registerListener((SensorEventListener)new AdAnalogData$AdSensorEventListener(null), AdAnalogData.gyroscope, 3);
                }
            }
        }
    }
    
    public static void stopUpdate(final AdAnalogData$AdSensorEventListener adAnalogData$AdSensorEventListener) {
        synchronized (AdAnalogData.class) {
            if (AdAnalogData.sensorManager != null) {
                AdAnalogData.sensorManager.unregisterListener((SensorEventListener)adAnalogData$AdSensorEventListener);
            }
        }
    }
}
