package com.google.firebase.storage;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public final class zzu {
    private static zzu zzojx = new zzu();
    private static BlockingQueue<Runnable> zzojy = new LinkedBlockingQueue(128);
    private static final ThreadPoolExecutor zzojz = new ThreadPoolExecutor(5, 5, 5, TimeUnit.SECONDS, zzojy, new zzv("Command-"));
    private static BlockingQueue<Runnable> zzoka = new LinkedBlockingQueue(128);
    private static final ThreadPoolExecutor zzokb = new ThreadPoolExecutor(2, 2, 5, TimeUnit.SECONDS, zzoka, new zzv("Upload-"));
    private static BlockingQueue<Runnable> zzokc = new LinkedBlockingQueue(128);
    private static final ThreadPoolExecutor zzokd = new ThreadPoolExecutor(3, 3, 5, TimeUnit.SECONDS, zzokc, new zzv("Download-"));
    private static BlockingQueue<Runnable> zzoke = new LinkedBlockingQueue(128);
    private static final ThreadPoolExecutor zzokf = new ThreadPoolExecutor(1, 1, 5, TimeUnit.SECONDS, zzoke, new zzv("Callbacks-"));

    static {
        zzojz.allowCoreThreadTimeOut(true);
        zzokb.allowCoreThreadTimeOut(true);
        zzokd.allowCoreThreadTimeOut(true);
        zzokf.allowCoreThreadTimeOut(true);
    }

    public static void zzs(Runnable runnable) {
        zzojz.execute(runnable);
    }

    public static void zzt(Runnable runnable) {
        zzokb.execute(runnable);
    }

    public static void zzu(Runnable runnable) {
        zzokd.execute(runnable);
    }

    public static void zzv(Runnable runnable) {
        zzokf.execute(runnable);
    }
}
