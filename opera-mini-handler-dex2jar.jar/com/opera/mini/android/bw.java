// 
// Decompiled by Procyon v0.6-prerelease
// 

package com.opera.mini.android;

import android.content.ActivityNotFoundException;
import android.content.DialogInterface$OnDismissListener;
import android.content.DialogInterface;
import android.content.DialogInterface$OnClickListener;
import android.content.Context;
import android.app.AlertDialog$Builder;
import android.content.Intent;
import android.app.Activity;
import android.app.AlertDialog;

public final class bw
{
    private static AlertDialog Code;
    private static Activity I;
    private static boolean J;
    private static boolean Z;
    
    static {
        bw.Z = false;
        bw.J = false;
    }
    
    public static void B() {
        bw.I.finishActivity(140627);
        if (bw.Code != null) {
            bw.Code.dismiss();
            bw.Code = null;
        }
    }
    
    public static int Code() {
        return 140627;
    }
    
    public static void Code(final Activity i) {
        bw.I = i;
    }
    
    public static void Code(final Intent intent) {
        final String[] array = intent.getStringArrayListExtra("android.speech.extra.RESULTS").toArray(new String[1]);
        if (array != null && array.length > 0) {
            if (array.length != 1) {
                final AlertDialog$Builder alertDialog$Builder = new AlertDialog$Builder((Context)bw.I);
                alertDialog$Builder.setItems((CharSequence[])array, (DialogInterface$OnClickListener)new DialogInterface$OnClickListener() {
                    public final void onClick(final DialogInterface dialogInterface, final int n) {
                        I(array[n]);
                    }
                });
                (bw.Code = alertDialog$Builder.create()).setOnDismissListener((DialogInterface$OnDismissListener)new DialogInterface$OnDismissListener() {
                    public final void onDismiss(final DialogInterface dialogInterface) {
                        bw.Code = null;
                    }
                });
                bw.Code.show();
                return;
            }
            I(array[0]);
        }
    }
    
    public static void Code(final boolean z) {
        bw.Z = z;
    }
    
    private static void I(final String s) {
        u.I.h();
        u.Z.b(u.Z.Code(s));
        u.I.Z(4);
    }
    
    public static boolean I() {
        boolean b = false;
        if (a()) {
            bw.Z = false;
            MiniView.Code.performHapticFeedback(0);
            b = true;
        }
        return b;
    }
    
    public static void J() {
        bw.J = true;
    }
    
    public static boolean Z() {
        return bw.Z;
    }
    
    private static boolean a() {
        if (!bw.J) {
            return false;
        }
        final Intent intent = new Intent("android.speech.action.RECOGNIZE_SPEECH");
        intent.putExtra("android.speech.extra.LANGUAGE_MODEL", "web_search");
        try {
            bw.I.startActivityForResult(intent, 140627);
            return true;
        }
        catch (ActivityNotFoundException ex) {
            return false;
        }
    }
}
