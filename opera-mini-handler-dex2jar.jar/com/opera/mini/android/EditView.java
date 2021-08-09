// 
// Decompiled by Procyon v0.6-prerelease
// 

package com.opera.mini.android;

import android.view.MotionEvent;
import android.view.ContextMenu;
import android.view.KeyEvent;
import android.graphics.drawable.Drawable;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.content.Context;
import android.text.TextPaint;
import android.widget.RelativeLayout$LayoutParams;
import android.widget.EditText;

public class EditView extends EditText
{
    private RelativeLayout$LayoutParams B;
    private int C;
    protected String Code;
    protected boolean I;
    private boolean J;
    private TextPaint Z;
    private boolean a;
    private int b;
    
    public EditView(final Context context) {
        super(context);
        this.a = false;
        this.b = 0;
        this.Code();
    }
    
    public EditView(final Context context, final AttributeSet set) {
        super(context, set);
        this.a = false;
        this.b = 0;
        this.Code();
    }
    
    public EditView(final Context context, final AttributeSet set, final int n) {
        super(context, set, n);
        this.a = false;
        this.b = 0;
        this.Code();
    }
    
    private void Code() {
        this.setSelection(0, 0);
        (this.Z = new TextPaint(1)).setColor(-16777216);
        this.Z.setTypeface(Typeface.create(Typeface.DEFAULT, 0));
        final TextPaint z = this.Z;
        h.Code();
        z.setTextSize((float)h.I());
        this.setTypeface(this.Z.getTypeface());
        this.setTextSize(this.Z.getTextSize());
        this.setBackgroundDrawable((Drawable)null);
        this.setPadding(0, 0, 0, 0);
        this.setBackgroundColor(0);
        this.setHighlightColor(-5189377);
        this.setGravity(48);
        this.C = 1;
    }
    
    private static void Z(final int n) {
        u.I.h();
        u.Z.b(u.B(u.I.a));
        u.Z.c(n);
        u.I.Z(49);
    }
    
    protected final String Code(final CharSequence charSequence) {
        int n;
        if (this.hasSelection()) {
            n = Math.min(this.getSelectionStart(), this.getSelectionEnd());
        }
        else {
            n = charSequence.length();
        }
        return charSequence.subSequence(0, n).toString();
    }
    
    public final void Code(final int c) {
        this.C = c;
    }
    
    final void Code(final int leftMargin, final int topMargin, final int width, final int height) {
        if (this.B == null) {
            this.B = (RelativeLayout$LayoutParams)this.getLayoutParams();
        }
        this.B.width = width;
        this.B.height = height;
        this.B.leftMargin = leftMargin;
        this.B.topMargin = topMargin;
        this.requestLayout();
    }
    
    protected final void Code(final String code, final boolean b) {
        final int n = 1;
        if (!this.J || Browser.Code == null || !Browser.Code.C || u.I == null || u.I.a == 0) {
            return;
        }
        this.Code = code;
        u.I.h();
        u.Z.b(u.B(u.I.a));
        u.Z.b(u.Z.Code(code));
        final p z = u.Z;
        int n2;
        if (this.getSelectionStart() == code.length()) {
            n2 = 1;
        }
        else {
            n2 = 0;
        }
        z.c(n2);
        final p z2 = u.Z;
        int n3;
        if (b) {
            n3 = n;
        }
        else {
            n3 = 0;
        }
        z2.c(n3);
        u.I.Z(50);
    }
    
    final void Code(final boolean j) {
        this.J = j;
    }
    
    final void I(int n) {
        final int n2 = 131072;
        int n3 = 0;
        int n4 = 0;
        switch (n & 0xFFF) {
            default: {
                n3 = 0;
                n4 = 1;
                break;
            }
            case 3: {
                n3 = 0;
                n4 = 2;
                break;
            }
            case 4: {
                n3 = 32;
                n4 = 1;
                break;
            }
            case 5: {
                n3 = 0;
                n4 = 3;
                break;
            }
            case 6: {
                n3 = 16;
                n4 = 1;
                break;
            }
        }
        if ((n & 0x2000) != 0x0) {
            this.setEnabled(false);
        }
        int n5;
        if ((0x10000 & n) != 0x0) {
            n5 = 8192;
        }
        else {
            n5 = 0;
        }
        if ((n & 0x1000) != 0x0) {
            n3 = 128;
        }
        if ((0x20000 & n) != 0x0) {
            n5 = 16384;
        }
        if ((0x40000 & n) != 0x0) {
            this.setVerticalScrollBarEnabled(true);
            n = n2;
        }
        else {
            this.setIncludeFontPadding(false);
            this.setVerticalScrollBarEnabled(false);
            n = n5;
        }
        this.setInputType(n | (n4 | n3));
    }
    
    public boolean dispatchKeyEventPreIme(final KeyEvent keyEvent) {
        boolean b = false;
        if (keyEvent.getKeyCode() == 4) {
            if (!this.I) {
                com.opera.mini.android.J.B(false);
                this.setVisibility(8);
                u.I.h();
                u.Z.b(u.B(u.I.a));
                u.Z.c(0);
                u.Z.c(0);
                u.I.Z(48);
                u.C(u.I.a);
                u.I.a = 0;
                this.setText((CharSequence)"");
            }
            this.I = false;
            b = true;
        }
        return b;
    }
    
    protected void onCreateContextMenu(final ContextMenu contextMenu) {
        this.I = true;
        super.onCreateContextMenu(contextMenu);
    }
    
    public void onEditorAction(int n) {
        switch (n) {
            default: {
                n = 1;
                break;
            }
            case 2: {
                n = 3;
                break;
            }
            case 5: {
                n = 5;
                break;
            }
            case 3: {
                n = 4;
                break;
            }
        }
        Z(n);
    }
    
    public boolean onKeyLongPress(final int n, final KeyEvent keyEvent) {
        return 84 == n && bw.I();
    }
    
    public boolean onKeyUp(final int n, final KeyEvent keyEvent) {
        Label_0177: {
            if (this.getLineCount() != 1) {
                break Label_0177;
            }
            if (n == 66) {
                Z(this.C);
                return true;
            }
            if (n != 19 && n != 20 && n != 23) {
                break Label_0177;
            }
            this.cancelLongPress();
            Label_0165: {
                if (n != 20) {
                    break Label_0165;
                }
                int n2 = 6;
            Label_0128_Outer:
                while (true) {
                    u.I.h();
                    u.Z.c(n2);
                    u.Z.c(0);
                    u.Z.c(0);
                    u.Z.c(n);
                    u.Z.b(0);
                    u.Z.b(0);
                    u.Z.c((int)keyEvent.getEventTime());
                    u.Z.c(0);
                    while (true) {
                        try {
                            u.Z.C(60);
                            u.Z.c(n2);
                            u.Z.c(n);
                            u.Z.c((int)keyEvent.getEventTime() + 1);
                            u.I.Z(61);
                            return true;
                            return super.onKeyUp(n, keyEvent);
                            iftrue(Label_0189:)(n != 23);
                            n2 = 8;
                            continue Label_0128_Outer;
                        }
                        catch (Throwable t) {
                            continue;
                        }
                        break;
                    }
                    Label_0189: {
                        n2 = 1;
                    }
                }
            }
        }
    }
    
    protected void onSelectionChanged(final int n, int n2) {
        int b;
        if (n2 < n) {
            this.setSelection(n2, n);
            b = n2;
            n2 = n;
        }
        else {
            b = n;
        }
        super.onSelectionChanged(b, n2);
        if (this.a) {
            if (b != n2) {
                this.a = false;
                this.setSelection(this.b);
                return;
            }
            this.b = b;
        }
    }
    
    protected void onTextChanged(final CharSequence charSequence, final int n, final int n2, final int n3) {
        this.Code(this.Code(charSequence), !this.hasSelection() && n3 != -1);
    }
    
    public boolean onTextContextMenuItem(final int n) {
        this.I = false;
        return super.onTextContextMenuItem(n);
    }
    
    public boolean onTouchEvent(final MotionEvent motionEvent) {
        boolean a = true;
        if (motionEvent.getAction() != 1) {
            a = false;
        }
        this.a = a;
        final boolean onTouchEvent = super.onTouchEvent(motionEvent);
        this.a = false;
        return onTouchEvent;
    }
}
