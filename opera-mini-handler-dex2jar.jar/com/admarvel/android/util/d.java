// 
// Decompiled by Procyon v0.6-prerelease
// 

package com.admarvel.android.util;

import android.content.Context;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import java.lang.ref.WeakReference;
import android.hardware.SensorManager;
import android.hardware.Sensor;

public class d
{
    private static d m;
    private int a;
    private float b;
    private Sensor c;
    private Sensor d;
    private SensorManager e;
    private WeakReference f;
    private Boolean g;
    private boolean h;
    private String i;
    private String j;
    private String k;
    private boolean l;
    private SensorEventListener n;
    
    static {
        d.m = null;
    }
    
    private d() {
        this.a = 1000;
        this.b = 2.0f;
        this.h = false;
        this.i = null;
        this.j = null;
        this.k = null;
        this.l = false;
        this.n = (SensorEventListener)new SensorEventListener() {
            final float a = 0.8f;
            private long c = 0L;
            private long d = 0L;
            private long e = 0L;
            private long f = 0L;
            private float g = 0.0f;
            private float[] h;
            private float[] i;
            private float[] j;
            private final float[] k = { 0.0f, 0.0f, 0.0f };
            private final float[] l = { 0.0f, 0.0f, 0.0f };
            private final float[] m = { 0.0f, 0.0f, 0.0f };
            
            public void onAccuracyChanged(final Sensor sensor, final int n) {
            }
            
            public void onSensorChanged(final SensorEvent sensorEvent) {
                this.c = System.currentTimeMillis();
                if (sensorEvent.sensor.getType() == 1) {
                    this.h = sensorEvent.values.clone();
                }
                if (sensorEvent.sensor.getType() == 2) {
                    this.j = sensorEvent.values.clone();
                }
                if (this.h != null && this.j != null) {
                    final float[] array = new float[9];
                    if (SensorManager.getRotationMatrix(array, new float[9], this.h, this.j)) {
                        final float[] array2 = new float[3];
                        SensorManager.getOrientation(array, array2);
                        float n2;
                        final float n = n2 = Math.round(Math.toDegrees(array2[0]) * 2.0) / 2.0f;
                        if (n < 0.0) {
                            n2 = n + 360.0f;
                        }
                        com.admarvel.android.util.d.this.b(n2);
                    }
                }
                if (this.h != null) {
                    if (this.e == 0L) {
                        this.e = this.c;
                        this.f = this.c;
                        this.i = this.h.clone();
                    }
                    else {
                        this.d = this.c - this.e;
                        if (this.d > 0L) {
                            if (this.c - this.f >= com.admarvel.android.util.d.this.a) {
                                this.g = Math.abs(this.h[0] + this.h[1] + this.h[2] - this.i[0] - this.i[1] - this.i[2]) / (this.c - this.f) * 100.0f;
                                this.f = this.c;
                                if (this.g > com.admarvel.android.util.d.this.b) {
                                    com.admarvel.android.util.d.this.a(this.g);
                                }
                            }
                            this.m[0] = this.m[0] * 0.8f + this.h[0] * 0.19999999f;
                            this.m[1] = this.m[1] * 0.8f + this.h[1] * 0.19999999f;
                            this.m[2] = this.m[2] * 0.8f + this.h[2] * 0.19999999f;
                            this.k[0] = this.h[0] - this.m[0];
                            this.k[1] = this.h[1] - this.m[1];
                            this.k[2] = this.h[2] - this.m[2];
                            this.l[0] = this.h[0] - this.i[0];
                            this.l[1] = this.h[1] - this.i[1];
                            this.l[2] = this.h[2] - this.i[2];
                            com.admarvel.android.util.d.this.a(this.h[0], this.h[1], this.h[2], this.k[0], this.k[1], this.k[2], this.l[0], this.l[1], this.l[2]);
                            this.i = this.h.clone();
                            this.e = this.c;
                        }
                    }
                }
            }
        };
    }
    
    public static d a() {
        if (d.m == null) {
            d.m = new d();
        }
        return d.m;
    }
    
    private void a(final float n) {
        final com.admarvel.android.ads.d d = (com.admarvel.android.ads.d)this.f.get();
        if (d != null && this.i != null) {
            d.e(this.i + "()");
        }
    }
    
    private void a(final float n, final float n2, final float n3, final float n4, final float n5, final float n6, final float n7, final float n8, final float n9) {
        final com.admarvel.android.ads.d d = (com.admarvel.android.ads.d)this.f.get();
        if (d != null && this.j != null) {
            d.e(this.j + "(" + n + "," + n2 + "," + n3 + "," + n4 + "," + n5 + "," + n6 + "," + n7 + "," + n8 + "," + n9 + ")");
        }
    }
    
    private void b(final float n) {
        final com.admarvel.android.ads.d d = (com.admarvel.android.ads.d)this.f.get();
        if (d != null && this.k != null) {
            d.e(this.k + "(" + n + ")");
        }
    }
    
    private void d() {
        this.i = null;
        this.j = null;
        this.k = null;
    }
    
    public void a(final Context context, final com.admarvel.android.ads.d d) {
        this.f = new WeakReference((T)d);
        if (!this.h) {
            this.e = (SensorManager)context.getSystemService("sensor");
            this.c = this.e.getDefaultSensor(1);
            this.d = this.e.getDefaultSensor(2);
            this.h = this.e.registerListener(this.n, this.c, 3);
        }
        if (this.l) {
            this.e.registerListener(this.n, this.d, 3);
            this.l = false;
        }
    }
    
    public void a(final String i) {
        if (i != null) {
            this.i = i;
        }
    }
    
    public void a(final String s, final String s2) {
        if (s != null) {
            this.b = new Float(s);
        }
        if (s2 != null) {
            this.a = Integer.parseInt(s2) * 1000;
        }
    }
    
    public boolean a(final Context context) {
        if (this.g == null) {
            if (context != null) {
                this.e = (SensorManager)context.getSystemService("sensor");
                this.g = new Boolean(this.e.getSensorList(1).size() > 0);
            }
            else {
                this.g = Boolean.FALSE;
            }
        }
        return this.g;
    }
    
    public void b(final String j) {
        if (j != null) {
            this.j = j;
        }
    }
    
    public boolean b() {
        return this.h;
    }
    
    public boolean b(final Context context) {
        if (this.g == null) {
            if (context != null) {
                this.e = (SensorManager)context.getSystemService("sensor");
                this.g = new Boolean(this.e.getSensorList(2).size() > 0);
            }
            else {
                this.g = Boolean.FALSE;
            }
        }
        return this.g;
    }
    
    public void c() {
        this.h = false;
        while (true) {
            try {
                if (this.e != null && this.n != null) {
                    this.e.unregisterListener(this.n);
                }
                this.d();
            }
            catch (Exception ex) {
                continue;
            }
            break;
        }
    }
    
    public void c(final String k) {
        if (k != null) {
            this.l = true;
            this.k = k;
        }
    }
}
