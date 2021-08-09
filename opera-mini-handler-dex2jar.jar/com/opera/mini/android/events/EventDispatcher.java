// 
// Decompiled by Procyon v0.6-prerelease
// 

package com.opera.mini.android.events;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.EnumMap;
import android.os.Looper;
import java.util.List;
import android.os.Handler;

public class EventDispatcher
{
    private static Handler B;
    private static final EventDispatcher J;
    private final ck Code;
    private final List I;
    private int Z;
    
    static {
        J = new EventDispatcher();
        EventDispatcher.B = new Handler(Looper.getMainLooper());
    }
    
    private EventDispatcher() {
        new EnumMap(EventDispatcher$Group.class);
        this.I = new LinkedList();
        this.Code = new ck(cs.Code, "main-bus");
    }
    
    public static void Code(final Object o) {
        final EventDispatcher j = EventDispatcher.J;
        ++j.Z;
        if (o instanceof EventDispatcher$DisposableEvent) {
            j.I.add(o);
        }
        j.Code.I(o);
        if (--j.Z == 0) {
            final Iterator iterator = j.I.iterator();
            while (iterator.hasNext()) {
                ((EventDispatcher$DisposableEvent)iterator.next()).Code();
            }
            j.I.clear();
        }
    }
    
    public static void I(final Object o) {
        EventDispatcher.B.post((Runnable)new Runnable() {
            @Override
            public final void run() {
                EventDispatcher.Code(o);
            }
        });
    }
    
    public static void Z(final Object o) {
        EventDispatcher.J.Code.Code(o);
    }
}
