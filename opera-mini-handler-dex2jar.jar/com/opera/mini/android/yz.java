// 
// Decompiled by Procyon v0.6-prerelease
// 

package com.opera.mini.android;

import android.content.Context;
import android.os.Bundle;
import android.content.Intent;
import android.app.Activity;

public class yz extends Activity
{
    protected void onActivityResult(final int n, final int n2, final Intent intent) {
        if (n == 88) {
            b$2.g = false;
        }
    }
    
    public void onCreate(final Bundle bundle) {
        super.onCreate(bundle);
        xy.H1 = new b$2(this);
        final String s = b$2.h[0];
        if (s == null || !s.equals("0")) {
            b$2.n();
            return;
        }
        try {
            this.startActivity(new Intent((Context)this, (Class)Class.forName("com.opera.mini.android.Browser")));
            this.finish();
        }
        catch (ClassNotFoundException ex) {
            throw new NoClassDefFoundError(ex.getMessage());
        }
    }
    
    public void onPause() {
        super.onPause();
    }
    
    public void onResume() {
        super.onResume();
        if (!b$2.g) {
            this.finish();
        }
    }
    
    public void onStart() {
        super.onStart();
    }
}
