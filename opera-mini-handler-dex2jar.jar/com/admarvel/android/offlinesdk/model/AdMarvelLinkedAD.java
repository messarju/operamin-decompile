// 
// Decompiled by Procyon v0.6-prerelease
// 

package com.admarvel.android.offlinesdk.model;

import java.util.HashMap;
import java.io.Serializable;

public class AdMarvelLinkedAD implements Serializable
{
    private static final long serialVersionUID = 132198219871927192L;
    int adId;
    HashMap adTargetingOption;
    int adWeight;
    int campaignPriority;
    float deliveryPriority;
    HashMap deliveryPriorityBySite;
    int deliveryWeight;
    long endDate;
    long startDate;
    
    public int getAdId() {
        return this.adId;
    }
    
    public HashMap getAdTargetingOption() {
        return this.adTargetingOption;
    }
    
    public int getAdWeight() {
        return this.adWeight;
    }
    
    public int getCampaignPriority() {
        return this.campaignPriority;
    }
    
    public float getDeliveryPriority() {
        return this.deliveryPriority;
    }
    
    public HashMap getDeliveryPriorityBySite() {
        return this.deliveryPriorityBySite;
    }
    
    public int getDeliveryWeight() {
        return this.deliveryWeight;
    }
    
    public long getEndDate() {
        return this.endDate;
    }
    
    public long getStartDate() {
        return this.startDate;
    }
    
    public void setAdId(final int adId) {
        this.adId = adId;
    }
    
    public void setAdTargetingOption(final HashMap adTargetingOption) {
        this.adTargetingOption = adTargetingOption;
    }
    
    public void setAdWeight(final int adWeight) {
        this.adWeight = adWeight;
    }
    
    public void setCampaignPriority(final int campaignPriority) {
        this.campaignPriority = campaignPriority;
    }
    
    public void setDeliveryPriority(final float deliveryPriority) {
        this.deliveryPriority = deliveryPriority;
    }
    
    public void setDeliveryPriorityBySite(final HashMap deliveryPriorityBySite) {
        this.deliveryPriorityBySite = deliveryPriorityBySite;
    }
    
    public void setDeliveryWeight(final int deliveryWeight) {
        this.deliveryWeight = deliveryWeight;
    }
    
    public void setEndDate(final long endDate) {
        this.endDate = endDate;
    }
    
    public void setStartDate(final long startDate) {
        this.startDate = startDate;
    }
}
