// 
// Decompiled by Procyon v0.6-prerelease
// 

package com.opera.mini.android;

import android.view.MotionEvent;
import android.content.Context;
import android.view.ScaleGestureDetector;
import android.view.ScaleGestureDetector$OnScaleGestureListener;

public class bt extends bj implements ScaleGestureDetector$OnScaleGestureListener
{
    ScaleGestureDetector I;
    Context Z;
    
    public bt(final Context z) {
        this.Z = z;
        this.I = new ScaleGestureDetector(z, (ScaleGestureDetector$OnScaleGestureListener)this);
    }
    
    private void Code(final int n, final ScaleGestureDetector scaleGestureDetector) {
        this.Code(n, (int)scaleGestureDetector.getFocusX(), (int)scaleGestureDetector.getFocusY(), (int)(scaleGestureDetector.getCurrentSpan() * 16.0f));
    }
    
    @Override
    public boolean Code(final MotionEvent motionEvent) {
        this.Code = (int)motionEvent.getEventTime();
        final int pointerCount = motionEvent.getPointerCount();
        this.I.onTouchEvent(motionEvent);
        if (this.I.isInProgress() && pointerCount == 1) {
            this.onScaleEnd(this.I);
            this.I = new ScaleGestureDetector(this.Z, (ScaleGestureDetector$OnScaleGestureListener)this);
        }
        return pointerCount > 1;
    }
    
    public boolean onScale(final ScaleGestureDetector scaleGestureDetector) {
        this.Code(67, scaleGestureDetector);
        return true;
    }
    
    public boolean onScaleBegin(final ScaleGestureDetector scaleGestureDetector) {
        this.Code(66, scaleGestureDetector);
        return true;
    }
    
    public void onScaleEnd(final ScaleGestureDetector scaleGestureDetector) {
        this.Code(68, scaleGestureDetector);
    }
}
