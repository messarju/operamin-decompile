// 
// Decompiled by Procyon v0.6-prerelease
// 

package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.IInterface;
import android.os.IBinder;
import android.os.Binder;

public abstract class e extends Binder implements d
{
    public static d Code(final IBinder binder) {
        if (binder == null) {
            return null;
        }
        final IInterface queryLocalInterface = binder.queryLocalInterface("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
        if (queryLocalInterface != null && queryLocalInterface instanceof d) {
            return (d)queryLocalInterface;
        }
        return new f(binder);
    }
    
    public boolean onTransact(int n, final Parcel parcel, final Parcel parcel2, final int n2) {
        boolean b = false;
        final int n3 = 0;
        switch (n) {
            default: {
                return super.onTransact(n, parcel, parcel2, n2);
            }
            case 1598968902: {
                parcel2.writeString("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                return true;
            }
            case 1: {
                parcel.enforceInterface("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                final String code = this.Code();
                parcel2.writeNoException();
                parcel2.writeString(code);
                return true;
            }
            case 2: {
                parcel.enforceInterface("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                final boolean code2 = this.Code(parcel.readInt() != 0);
                parcel2.writeNoException();
                n = n3;
                if (code2) {
                    n = 1;
                }
                parcel2.writeInt(n);
                return true;
            }
            case 3: {
                parcel.enforceInterface("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                final String code3 = this.Code(parcel.readString());
                parcel2.writeNoException();
                parcel2.writeString(code3);
                return true;
            }
            case 4: {
                parcel.enforceInterface("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                final String string = parcel.readString();
                if (parcel.readInt() != 0) {
                    b = true;
                }
                this.Code(string, b);
                parcel2.writeNoException();
                return true;
            }
        }
    }
}
