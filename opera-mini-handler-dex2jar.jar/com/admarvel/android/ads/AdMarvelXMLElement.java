// 
// Decompiled by Procyon v0.6-prerelease
// 

package com.admarvel.android.ads;

import java.util.Iterator;
import java.util.ArrayList;
import java.util.LinkedHashMap;

public class AdMarvelXMLElement
{
    private LinkedHashMap attributes;
    private LinkedHashMap children;
    private StringBuilder data;
    private String name;
    
    AdMarvelXMLElement(final String name) {
        this.name = null;
        this.attributes = null;
        this.data = new StringBuilder();
        this.children = new LinkedHashMap();
        this.name = name;
    }
    
    AdMarvelXMLElement(final String name, final LinkedHashMap attributes) {
        this.name = null;
        this.attributes = null;
        this.data = new StringBuilder();
        this.children = new LinkedHashMap();
        this.name = name;
        this.attributes = attributes;
    }
    
    public void appendData(final String s) {
        this.data.append(s);
    }
    
    public LinkedHashMap getAttributes() {
        return this.attributes;
    }
    
    public LinkedHashMap getChildren() {
        return this.children;
    }
    
    public String getData() {
        if (this.data == null) {
            return null;
        }
        return this.data.toString();
    }
    
    public String getName() {
        return this.name;
    }
    
    public void setChildren(final LinkedHashMap children) {
        this.children = children;
    }
    
    @Override
    public final String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("<");
        sb.append(this.name);
        if (this.attributes != null) {
            for (final String s : this.attributes.keySet()) {
                sb.append(" ");
                sb.append(s);
                sb.append("=");
                sb.append("\"");
                sb.append(AdMarvelXMLReader.xmlEncode((String)this.attributes.get(s)));
                sb.append("\"");
            }
        }
        sb.append(">");
        final Iterator iterator2 = this.children.values().iterator();
        while (iterator2.hasNext()) {
            final Iterator iterator3 = ((ArrayList)iterator2.next()).iterator();
            while (iterator3.hasNext()) {
                sb.append(((AdMarvelXMLElement)iterator3.next()).toString());
            }
        }
        sb.append(AdMarvelXMLReader.xmlEncode(this.data.toString()));
        sb.append("</");
        sb.append(this.name);
        sb.append(">");
        return sb.toString();
    }
}
