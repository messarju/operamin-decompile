// 
// Decompiled by Procyon v0.6-prerelease
// 

package com.facebook.ads;

import android.graphics.Rect;
import android.view.MotionEvent;
import android.util.Log;
import android.view.View;
import java.util.HashMap;
import java.util.Map;
import android.view.View$OnTouchListener;
import android.view.View$OnClickListener;

class NativeAd$EventHandler implements View$OnClickListener, View$OnTouchListener
{
    private float adPositionX;
    private float adPositionY;
    private int height;
    final /* synthetic */ NativeAd this$0;
    private boolean touchDataInitialized;
    private int visibleHeight;
    private int visibleWidth;
    private int width;
    private int xCoord;
    private int yCoord;
    
    private NativeAd$EventHandler(final NativeAd this$0) {
        this.this$0 = this$0;
    }
    
    public Map getData() {
        final HashMap hashMap = new HashMap();
        hashMap.put("clickX", this.xCoord);
        hashMap.put("clickY", this.yCoord);
        hashMap.put("width", this.width);
        hashMap.put("height", this.height);
        hashMap.put("adPositionX", this.adPositionX);
        hashMap.put("adPositionY", this.adPositionY);
        hashMap.put("visibleWidth", this.visibleWidth);
        hashMap.put("visibleHeight", this.visibleHeight);
        return hashMap;
    }
    
    public void onClick(final View view) {
        if (this.this$0.adListener != null) {
            this.this$0.adListener.onAdClicked(this.this$0);
        }
        if (!this.touchDataInitialized) {
            Log.e("FBAudienceNetworkLog", "No touch data recorded, please ensure touch events reach the ad View by returning false if you intercept the event.");
        }
        this.this$0.adDataModel.handleClick(this.this$0.context, this.getData(), false);
    }
    
    public boolean onTouch(final View view, final MotionEvent motionEvent) {
        if (!this.touchDataInitialized && motionEvent.getAction() == 0 && this.this$0.adView != null) {
            this.width = this.this$0.adView.getWidth();
            this.height = this.this$0.adView.getHeight();
            final int[] array = new int[2];
            this.this$0.adView.getLocationInWindow(array);
            this.adPositionX = (float)array[0];
            this.adPositionY = (float)array[1];
            final Rect rect = new Rect();
            this.this$0.adView.getGlobalVisibleRect(rect);
            this.visibleWidth = rect.width();
            this.visibleHeight = rect.height();
            final int[] array2 = new int[2];
            view.getLocationInWindow(array2);
            this.xCoord = (int)motionEvent.getX() + array2[0] - array[0];
            this.yCoord = array2[1] + (int)motionEvent.getY() - array[1];
            this.touchDataInitialized = true;
        }
        return false;
    }
}
