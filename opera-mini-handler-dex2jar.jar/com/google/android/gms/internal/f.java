// 
// Decompiled by Procyon v0.6-prerelease
// 

package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.IBinder;

final class f implements d
{
    private IBinder Code;
    
    f(final IBinder code) {
        this.Code = code;
    }
    
    @Override
    public final String Code() {
        final Parcel obtain = Parcel.obtain();
        final Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
            this.Code.transact(1, obtain, obtain2, 0);
            obtain2.readException();
            return obtain2.readString();
        }
        finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }
    
    @Override
    public final String Code(String string) {
        final Parcel obtain = Parcel.obtain();
        final Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
            obtain.writeString(string);
            this.Code.transact(3, obtain, obtain2, 0);
            obtain2.readException();
            string = obtain2.readString();
            return string;
        }
        finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }
    
    @Override
    public final void Code(final String s, final boolean b) {
        int n = 0;
        final Parcel obtain = Parcel.obtain();
        final Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
            obtain.writeString(s);
            if (b) {
                n = 1;
            }
            obtain.writeInt(n);
            this.Code.transact(4, obtain, obtain2, 0);
            obtain2.readException();
        }
        finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }
    
    @Override
    public final boolean Code(final boolean b) {
        final boolean b2 = true;
        final Parcel obtain = Parcel.obtain();
        final Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
            int n;
            if (b) {
                n = 1;
            }
            else {
                n = 0;
            }
            obtain.writeInt(n);
            this.Code.transact(2, obtain, obtain2, 0);
            obtain2.readException();
            return obtain2.readInt() != 0 && b2;
        }
        finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }
    
    public final IBinder asBinder() {
        return this.Code;
    }
}
