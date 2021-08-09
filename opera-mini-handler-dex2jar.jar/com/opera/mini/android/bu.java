// 
// Decompiled by Procyon v0.6-prerelease
// 

package com.opera.mini.android;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.security.PublicKey;
import java.security.Signature;
import java.security.spec.KeySpec;
import java.security.spec.RSAPublicKeySpec;
import java.math.BigInteger;
import java.security.KeyFactory;
import java.security.interfaces.RSAPublicKey;
import java.io.Reader;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.InputStream;

public final class bu
{
    public static boolean Code(final InputStream inputStream, final String s, final String s2) {
        try {
            final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            final RSAPublicKey rsaPublicKey = (RSAPublicKey)KeyFactory.getInstance("RSA").generatePublic(new RSAPublicKeySpec(new BigInteger(bufferedReader.readLine()), new BigInteger(bufferedReader.readLine())));
            final Signature instance = Signature.getInstance("SHA1withRSA");
            instance.initVerify(rsaPublicKey);
            instance.update(s.getBytes());
            return instance.verify(Code(s2));
        }
        catch (GeneralSecurityException ex) {}
        catch (IOException ex2) {
            goto Label_0098;
        }
    }
    
    private static byte[] Code(final String s) {
        if (s.length() == 512) {
            final char[] charArray = s.toCharArray();
            final int n = charArray.length / 2;
            final byte[] array = new byte[n];
            for (int i = 0; i < n; ++i) {
                final int digit = Character.digit(charArray[i * 2], 16);
                final int digit2 = Character.digit(charArray[i * 2 + 1], 16);
                if (digit == -1 || digit2 == -1) {
                    return null;
                }
                array[i] = (byte)(digit << 4 | digit2);
            }
            return array;
        }
        return null;
    }
}
