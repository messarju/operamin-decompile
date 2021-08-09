// 
// Decompiled by Procyon v0.6-prerelease
// 

package com.facebook.ads.internal;

import android.hardware.SensorEvent;
import android.hardware.Sensor;
import android.hardware.SensorEventListener;

class AdAnalogData$AdSensorEventListener implements SensorEventListener
{
    private AdAnalogData$AdSensorEventListener() {
    }
    
    public void onAccuracyChanged(final Sensor sensor, final int n) {
    }
    
    public void onSensorChanged(final SensorEvent sensorEvent) {
        if (sensorEvent.sensor == AdAnalogData.accelerometer) {
            AdAnalogData.accelerometerValues = sensorEvent.values;
        }
        else if (sensorEvent.sensor == AdAnalogData.gyroscope) {
            AdAnalogData.gyroscopeValues = sensorEvent.values;
        }
        AdAnalogData.stopUpdate(this);
    }
}
