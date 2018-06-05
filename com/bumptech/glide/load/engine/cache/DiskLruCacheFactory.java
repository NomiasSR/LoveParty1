package com.bumptech.glide.load.engine.cache;

import com.bumptech.glide.load.engine.cache.DiskCache.Factory;
import java.io.File;

public class DiskLruCacheFactory implements Factory {
    private final CacheDirectoryGetter cacheDirectoryGetter;
    private final int diskCacheSize;

    public interface CacheDirectoryGetter {
        File getCacheDirectory();
    }

    class C04931 implements CacheDirectoryGetter {
        final /* synthetic */ String val$diskCacheFolder;

        C04931(String str) {
            this.val$diskCacheFolder = str;
        }

        public File getCacheDirectory() {
            return new File(this.val$diskCacheFolder);
        }
    }

    class C04942 implements CacheDirectoryGetter {
        final /* synthetic */ String val$diskCacheFolder;
        final /* synthetic */ String val$diskCacheName;

        C04942(String str, String str2) {
            this.val$diskCacheFolder = str;
            this.val$diskCacheName = str2;
        }

        public File getCacheDirectory() {
            return new File(this.val$diskCacheFolder, this.val$diskCacheName);
        }
    }

    public DiskLruCacheFactory(String str, int i) {
        this(new C04931(str), i);
    }

    public DiskLruCacheFactory(String str, String str2, int i) {
        this(new C04942(str, str2), i);
    }

    public DiskLruCacheFactory(CacheDirectoryGetter cacheDirectoryGetter, int i) {
        this.diskCacheSize = i;
        this.cacheDirectoryGetter = cacheDirectoryGetter;
    }

    public DiskCache build() {
        File cacheDirectory = this.cacheDirectoryGetter.getCacheDirectory();
        if (cacheDirectory == null) {
            return null;
        }
        if (cacheDirectory.mkdirs() || (cacheDirectory.exists() && cacheDirectory.isDirectory())) {
            return DiskLruCacheWrapper.get(cacheDirectory, this.diskCacheSize);
        }
        return null;
    }
}
