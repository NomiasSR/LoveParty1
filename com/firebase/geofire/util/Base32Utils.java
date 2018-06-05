package com.firebase.geofire.util;

public final class Base32Utils {
    private static final String BASE32_CHARS = "0123456789bcdefghjkmnpqrstuvwxyz";
    public static final int BITS_PER_BASE32_CHAR = 5;

    private Base32Utils() {
        throw new AssertionError("No instances.");
    }

    public static char valueToBase32Char(int i) {
        if (i >= 0) {
            if (i < BASE32_CHARS.length()) {
                return BASE32_CHARS.charAt(i);
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Not a valid base32 value: ");
        stringBuilder.append(i);
        throw new IllegalArgumentException(stringBuilder.toString());
    }

    public static int base32CharToValue(char c) {
        int indexOf = BASE32_CHARS.indexOf(c);
        if (indexOf != -1) {
            return indexOf;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Not a valid base32 char: ");
        stringBuilder.append(c);
        throw new IllegalArgumentException(stringBuilder.toString());
    }

    public static boolean isValidBase32String(String str) {
        return str.matches("^[0123456789bcdefghjkmnpqrstuvwxyz]*$");
    }
}
