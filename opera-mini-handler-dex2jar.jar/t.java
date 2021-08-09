// 
// Decompiled by Procyon v0.6-prerelease
// 

public abstract class t extends br
{
    public t(final String s, final String s2, final String s3) {
        super(s, s2, s3, 0);
    }
    
    @Override
    protected final void Code(final Object[] array, final int[] array2) {
        int n = 0;
        super.Code(array, array2);
        array[57] = ac.Z();
        array[41] = cg.i;
        array2[75] = ag.Code();
        array[115] = u.Code.ac();
        array2[25] = u.Code.C();
        array2[26] = u.Code.a();
        array2[20] = array2[25];
        array2[19] = array2[26];
        final int n2 = array2[85];
        int n3;
        if ((cg.W & 0x2) != 0x0) {
            n3 = 8;
        }
        else {
            n3 = 0;
        }
        int n4;
        if ((cg.W & 0x1) != 0x0) {
            n4 = 4;
        }
        else {
            n4 = 0;
        }
        array2[85] = (n3 | n4 | n2);
        final int n5 = array2[24];
        int n6;
        if (cg.h) {
            n6 = 1;
        }
        else {
            n6 = 2;
        }
        int n7;
        if (u.Code.m()) {
            n7 = 8;
        }
        else {
            n7 = 0;
        }
        int n8;
        if (u.Code.m()) {
            n8 = 32768;
        }
        else {
            n8 = 0;
        }
        array2[24] = (n8 | (0x1000000 | (n7 | (n6 | 0x4) | 0x20000 | 0x8000000 | 0x1000)) | 0x4000000 | 0x800000 | 0x100000 | 0x40000 | 0x10 | 0x40000000 | n5);
        int n9;
        if (u.Z.x(41) != 0) {
            n9 = 1;
        }
        else {
            n9 = 0;
        }
        final int n10 = array2[43];
        int n11;
        if (cg.o) {
            n11 = 512;
        }
        else {
            n11 = 0;
        }
        int n12;
        if (cg.p) {
            n12 = 2048;
        }
        else {
            n12 = 0;
        }
        int n13;
        if (cg.v) {
            n13 = 8388608;
        }
        else {
            n13 = 0;
        }
        int n14;
        if (u.Code.u() == 0) {
            n14 = 67108864;
        }
        else {
            n14 = 0;
        }
        int n15;
        if (n9 != 0) {
            n15 = 524288;
        }
        else {
            n15 = 0;
        }
        if (u.Code.S()) {
            n = 262144;
        }
        array2[43] = (n15 | (n14 | (0x200000 | (n12 | (n11 | 0x4030 | 0x0) | 0x8000 | 0x10000 | 0x1000000 | 0x40000000 | 0x20000 | 0x100000) | n13)) | n | n10);
        if (!u.I.l().equals("hqvga")) {
            array2[109] |= 0x60;
        }
        if (u.Code.ad()) {
            array2[109] |= 0x40000;
        }
        if (u.Code.aa()) {
            array2[109] |= 0x8;
        }
        array2[109] |= 0x2000;
        array2[109] |= 0x8000;
        array2[109] |= 0x800;
        if (u.Code.aj()) {
            array2[109] |= 0x800000;
        }
        final String p2 = cg.P;
        String code = null;
        Label_0512: {
            if (p2 != null) {
                code = p2;
                if (!p2.equals("")) {
                    break Label_0512;
                }
            }
            code = u.Code.Code("OM-Campaign");
        }
        if (code != null && !code.equals("") && !code.equals("debug")) {
            array[78] = code;
        }
    }
}
