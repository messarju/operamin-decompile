// 
// Decompiled by Procyon v0.6-prerelease
// 

package com.opera.mini.android;

import android.text.Editable;
import android.text.Spannable;
import android.view.inputmethod.BaseInputConnection;

final class bv implements Runnable
{
    private final String Code;
    private final boolean I;
    private /* synthetic */ URLEditView J;
    private final int Z;
    
    bv(final URLEditView j, final String code, final int z, final boolean i) {
        this.J = j;
        this.Code = code;
        this.Z = z;
        this.I = i;
    }
    
    @Override
    public final void run() {
        this.J.beginBatchEdit();
        final Editable text = this.J.getText();
        boolean b;
        if (BaseInputConnection.getComposingSpanEnd((Spannable)text) - BaseInputConnection.getComposingSpanStart((Spannable)text) > 0) {
            b = true;
        }
        else {
            b = false;
        }
        if (b && !this.I) {
            this.J.endBatchEdit();
            return;
        }
        BaseInputConnection.removeComposingSpans((Spannable)text);
        if (this.I || this.Code.startsWith(this.J.Code((CharSequence)text))) {
            this.J.Z = true;
            this.J.setText((CharSequence)this.Code);
            this.J.setSelection(this.Z, this.Code.length());
        }
        this.J.endBatchEdit();
    }
}
