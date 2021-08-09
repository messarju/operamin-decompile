// 
// Decompiled by Procyon v0.6-prerelease
// 

package com.facebook.ads.internal;

import java.util.Iterator;
import org.json.JSONArray;
import java.util.Collection;
import java.util.ArrayList;
import java.util.List;

public class AdClientEventManager
{
    private static List clientEvents;
    
    static {
        AdClientEventManager.clientEvents = new ArrayList();
    }
    
    public static void addClientEvent(final AdClientEvent adClientEvent) {
        synchronized (AdClientEventManager.clientEvents) {
            AdClientEventManager.clientEvents.add(adClientEvent);
        }
    }
    
    public static String dumpClientEventToJson() {
        Object clientEvents = AdClientEventManager.clientEvents;
        synchronized (clientEvents) {
            if (AdClientEventManager.clientEvents.isEmpty()) {
                return "";
            }
            final ArrayList list = new ArrayList(AdClientEventManager.clientEvents);
            AdClientEventManager.clientEvents.clear();
            monitorexit(clientEvents);
            clientEvents = new JSONArray();
            final Iterator iterator = list.iterator();
            while (iterator.hasNext()) {
                ((JSONArray)clientEvents).put((Object)((AdClientEvent)iterator.next()).getClientEventJson());
            }
        }
        return ((JSONArray)clientEvents).toString();
    }
}
