// 
// Decompiled by Procyon v0.6-prerelease
// 

package com.opera.mini.android;

import android.view.MotionEvent;
import android.view.KeyEvent;
import java.util.TimerTask;
import android.os.Build;
import android.util.AttributeSet;
import android.content.Context;
import java.util.Timer;

public class URLEditView extends EditView
{
    private static long C;
    private boolean B;
    private boolean J;
    private boolean Z;
    private Timer a;
    
    public URLEditView(final Context context) {
        super(context);
        this.J = false;
        this.B = false;
        I();
    }
    
    public URLEditView(final Context context, final AttributeSet set) {
        super(context, set);
        this.J = false;
        this.B = false;
        I();
    }
    
    public URLEditView(final Context context, final AttributeSet set, final int n) {
        super(context, set, n);
        this.J = false;
        this.B = false;
        I();
    }
    
    private void Code() {
        if (this.a != null) {
            this.a.cancel();
            this.a.purge();
            this.a = null;
        }
    }
    
    private static void I() {
        if (Build.DEVICE.indexOf("GT-I9000") >= 0) {
            URLEditView.C = 500L;
            return;
        }
        URLEditView.C = 0L;
    }
    
    public final void Code(final String s, final int n, final boolean b) {
        if (URLEditView.C > 0L) {
            this.Code();
            (this.a = new Timer()).schedule(new TimerTask() {
                @Override
                public final void run() {
                    URLEditView.this.post((Runnable)new bv(URLEditView.this, s, n, b));
                }
            }, URLEditView.C);
            return;
        }
        this.post((Runnable)new bv(this, s, n, b));
    }
    
    public boolean onKeyDown(final int n, final KeyEvent keyEvent) {
        return (this.getLineCount() == 1 && (n == 19 || n == 20 || n == 23)) || super.onKeyDown(n, keyEvent);
    }
    
    @Override
    public boolean onKeyUp(final int n, final KeyEvent keyEvent) {
        if (this.getLineCount() == 1 && (n == 21 || n == 22) && !this.hasSelection() && (this.Code == null || !this.Code.equals(this.Code((CharSequence)this.getText())))) {
            this.Code(this.Code((CharSequence)this.getText()), false);
        }
        return super.onKeyUp(n, keyEvent);
    }
    
    @Override
    protected void onSelectionChanged(final int n, final int n2) {
        if (n == n2 && n == this.getText().length() && this.B) {
            this.Code(this.Code((CharSequence)this.getText()), true);
        }
        super.onSelectionChanged(n, n2);
        this.B = false;
    }
    
    public void onTextChanged(final CharSequence charSequence, final int n, final int n2, final int n3) {
        if (this.Z) {
            this.Z = false;
            return;
        }
        this.Code();
        if (n3 == 4 && n > 0 && charSequence.charAt(n - 1) == '.' && charSequence.charAt(n) == '.') {
            this.setTextKeepState((CharSequence)new StringBuffer(charSequence.subSequence(0, n - 1)).append(charSequence.subSequence(n, n + n3)));
            return;
        }
        super.onTextChanged(charSequence, n, n2, n3);
    }
    
    @Override
    public boolean onTextContextMenuItem(final int n) {
        boolean onTextContextMenuItem = false;
        switch (n) {
            case 16908328: {
                this.J = true;
                break;
            }
            case 16908329: {
                if (this.J) {
                    this.J = false;
                    break;
                }
                return onTextContextMenuItem;
            }
        }
        onTextContextMenuItem = super.onTextContextMenuItem(n);
        return onTextContextMenuItem;
    }
    
    @Override
    public boolean onTouchEvent(final MotionEvent motionEvent) {
        this.B = true;
        return super.onTouchEvent(motionEvent);
    }
}
