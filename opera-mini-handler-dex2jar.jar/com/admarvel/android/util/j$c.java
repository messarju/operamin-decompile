// 
// Decompiled by Procyon v0.6-prerelease
// 

package com.admarvel.android.util;

import android.content.Context;
import android.os.Parcel;
import android.os.IBinder;
import android.os.IInterface;

final class j$c implements IInterface
{
    private IBinder a;
    
    public j$c(final IBinder a) {
        this.a = a;
    }
    
    public final String a() {
        final Parcel obtain = Parcel.obtain();
        final Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
            this.a.transact(1, obtain, obtain2, 0);
            obtain2.readException();
            final String string = obtain2.readString();
            obtain2.readInt();
            return string;
        }
        finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }
    
    public final boolean a(final boolean b, Context obtain) {
        final int n = 1;
        obtain = (Context)Parcel.obtain();
        final Parcel obtain2 = Parcel.obtain();
        try {
            ((Parcel)obtain).writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
            int n2;
            if (b) {
                n2 = 1;
            }
            else {
                n2 = 0;
            }
            ((Parcel)obtain).writeInt(n2);
            this.a.transact(2, (Parcel)obtain, obtain2, 0);
            obtain2.readException();
            final boolean b2 = obtain2.readInt() != 0;
            final j a = j.a;
            int n3;
            if (b2) {
                n3 = n;
            }
            else {
                n3 = 0;
            }
            a.c = n3;
            return b2;
        }
        finally {
            obtain2.recycle();
            ((Parcel)obtain).recycle();
        }
    }
    
    public final IBinder asBinder() {
        return this.a;
    }
}
