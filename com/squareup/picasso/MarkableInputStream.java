package com.squareup.picasso;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;

final class MarkableInputStream extends InputStream {
    private static final int DEFAULT_BUFFER_SIZE = 4096;
    private long defaultMark;
    private final InputStream in;
    private long limit;
    private long offset;
    private long reset;

    public MarkableInputStream(InputStream inputStream) {
        this(inputStream, 4096);
    }

    public MarkableInputStream(InputStream inputStream, int i) {
        this.defaultMark = -1;
        if (!inputStream.markSupported()) {
            inputStream = new BufferedInputStream(inputStream, i);
        }
        this.in = inputStream;
    }

    public void mark(int i) {
        this.defaultMark = savePosition(i);
    }

    public long savePosition(int i) {
        long j = this.offset + ((long) i);
        if (this.limit < j) {
            setLimit(j);
        }
        return this.offset;
    }

    private void setLimit(long j) {
        try {
            if (this.reset >= this.offset || this.offset > this.limit) {
                this.reset = this.offset;
                this.in.mark((int) (j - this.offset));
            } else {
                this.in.reset();
                this.in.mark((int) (j - this.reset));
                skip(this.reset, this.offset);
            }
            this.limit = j;
        } catch (long j2) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Unable to mark: ");
            stringBuilder.append(j2);
            throw new IllegalStateException(stringBuilder.toString());
        }
    }

    public void reset() throws IOException {
        reset(this.defaultMark);
    }

    public void reset(long j) throws IOException {
        if (this.offset <= this.limit) {
            if (j >= this.reset) {
                this.in.reset();
                skip(this.reset, j);
                this.offset = j;
                return;
            }
        }
        throw new IOException("Cannot reset");
    }

    private void skip(long j, long j2) throws IOException {
        while (j < j2) {
            long skip = this.in.skip(j2 - j);
            if (skip == 0) {
                if (read() != -1) {
                    skip = 1;
                } else {
                    return;
                }
            }
            j += skip;
        }
    }

    public int read() throws IOException {
        int read = this.in.read();
        if (read != -1) {
            this.offset++;
        }
        return read;
    }

    public int read(byte[] bArr) throws IOException {
        bArr = this.in.read(bArr);
        if (bArr != -1) {
            this.offset += (long) bArr;
        }
        return bArr;
    }

    public int read(byte[] bArr, int i, int i2) throws IOException {
        bArr = this.in.read(bArr, i, i2);
        if (bArr != -1) {
            this.offset += (long) bArr;
        }
        return bArr;
    }

    public long skip(long j) throws IOException {
        j = this.in.skip(j);
        this.offset += j;
        return j;
    }

    public int available() throws IOException {
        return this.in.available();
    }

    public void close() throws IOException {
        this.in.close();
    }

    public boolean markSupported() {
        return this.in.markSupported();
    }
}
