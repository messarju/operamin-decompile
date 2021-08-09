// 
// Decompiled by Procyon v0.6-prerelease
// 

package com.opera.mini.android;

import java.util.concurrent.RejectedExecutionException;
import android.os.AsyncTask;

public abstract class an
{
    public static boolean Code(final AsyncTask asyncTask, final Object... array) {
        try {
            if (x.ak < 11) {
                asyncTask.execute(array);
            }
            else {
                asyncTask.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, array);
            }
        }
        catch (RejectedExecutionException ex) {
            return false;
        }
        return true;
    }
}
