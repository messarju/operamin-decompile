import android.os.Parcel;
import android.os.Parcelable$Creator;
import android.os.Parcelable;

// 
// Decompiled by Procyon v0.6-prerelease
// 

public final class B implements Parcelable
{
    public static final Parcelable$Creator Code;
    private String I;
    private String J;
    private String Z;
    
    static {
        Code = (Parcelable$Creator)new Parcelable$Creator() {};
    }
    
    public B() {
    }
    
    B(final Parcel parcel) {
        this.I = parcel.readString();
        this.Z = parcel.readString();
        this.J = parcel.readString();
    }
    
    public B(final String i, final String z, final String j) {
        this.I = i;
        this.Z = z;
        this.J = j;
    }
    
    public final String Code() {
        return this.I;
    }
    
    public final String I() {
        return this.Z;
    }
    
    public final String Z() {
        return this.J;
    }
    
    public final int describeContents() {
        return 0;
    }
    
    public final void writeToParcel(final Parcel parcel, final int n) {
        parcel.writeString(this.I);
        parcel.writeString(this.Z);
        parcel.writeString(this.J);
    }
}
