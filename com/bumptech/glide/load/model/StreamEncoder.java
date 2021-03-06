package com.bumptech.glide.load.model;

import android.util.Log;
import com.bumptech.glide.load.Encoder;
import com.bumptech.glide.util.ByteArrayPool;
import java.io.InputStream;
import java.io.OutputStream;

public class StreamEncoder implements Encoder<InputStream> {
    private static final String TAG = "StreamEncoder";

    public String getId() {
        return "";
    }

    public boolean encode(InputStream inputStream, OutputStream outputStream) {
        byte[] bytes = ByteArrayPool.get().getBytes();
        while (true) {
            try {
                int read = inputStream.read(bytes);
                if (read != -1) {
                    outputStream.write(bytes, 0, read);
                } else {
                    ByteArrayPool.get().releaseBytes(bytes);
                    return true;
                }
            } catch (InputStream inputStream2) {
                if (Log.isLoggable(TAG, 3) != null) {
                    Log.d(TAG, "Failed to encode data onto the OutputStream", inputStream2);
                }
                ByteArrayPool.get().releaseBytes(bytes);
                return false;
            } catch (Throwable th) {
                ByteArrayPool.get().releaseBytes(bytes);
            }
        }
    }
}
