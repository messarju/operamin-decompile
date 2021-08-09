// 
// Decompiled by Procyon v0.6-prerelease
// 

package com.facebook.ads.internal;

import org.json.JSONException;
import org.json.JSONObject;
import java.util.HashMap;
import java.util.Map;

public class AdClientEvent
{
    private Map data;
    private String name;
    private int time;
    
    public AdClientEvent(final String name, final Map data, final int time) {
        this.name = name;
        this.data = data;
        this.time = time;
    }
    
    public static AdClientEvent newErrorEvent(final Exception ex) {
        final HashMap hashMap = new HashMap();
        hashMap.put("ex", ex.getClass().getSimpleName());
        hashMap.put("ex_msg", ex.getMessage());
        return new AdClientEvent("error", hashMap, (int)(System.currentTimeMillis() / 1000L));
    }
    
    public JSONObject getClientEventJson() {
        final JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("name", (Object)this.name);
            jsonObject.put("data", (Object)new JSONObject(this.data));
            jsonObject.put("time", this.time);
            return jsonObject;
        }
        catch (JSONException ex) {
            ex.printStackTrace();
            return jsonObject;
        }
    }
}
