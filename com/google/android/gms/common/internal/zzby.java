package com.google.android.gms.common.internal;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff.Mode;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.util.AttributeSet;
import android.widget.Button;
import com.google.android.gms.C0365R;
import com.google.android.gms.common.util.zzi;

public final class zzby extends Button {
    public zzby(Context context) {
        this(context, null);
    }

    private zzby(Context context, AttributeSet attributeSet) {
        super(context, null, 16842824);
    }

    private static int zzf(int i, int i2, int i3, int i4) {
        switch (i) {
            case 0:
                return i2;
            case 1:
                return i3;
            case 2:
                return i4;
            default:
                StringBuilder stringBuilder = new StringBuilder(33);
                stringBuilder.append("Unknown color scheme: ");
                stringBuilder.append(i);
                throw new IllegalStateException(stringBuilder.toString());
        }
    }

    public final void zza(Resources resources, int i, int i2) {
        setTypeface(Typeface.DEFAULT_BOLD);
        setTextSize(14.0f);
        int i3 = (int) ((resources.getDisplayMetrics().density * 48.0f) + 0.5f);
        setMinHeight(i3);
        setMinWidth(i3);
        i3 = zzf(i2, C0365R.drawable.common_google_signin_btn_icon_dark, C0365R.drawable.common_google_signin_btn_icon_light, C0365R.drawable.common_google_signin_btn_icon_light);
        int zzf = zzf(i2, C0365R.drawable.common_google_signin_btn_text_dark, C0365R.drawable.common_google_signin_btn_text_light, C0365R.drawable.common_google_signin_btn_text_light);
        switch (i) {
            case 0:
            case 1:
                i3 = zzf;
                break;
            case 2:
                break;
            default:
                StringBuilder stringBuilder = new StringBuilder(32);
                stringBuilder.append("Unknown button size: ");
                stringBuilder.append(i);
                throw new IllegalStateException(stringBuilder.toString());
        }
        Drawable wrap = DrawableCompat.wrap(resources.getDrawable(i3));
        DrawableCompat.setTintList(wrap, resources.getColorStateList(C0365R.color.common_google_signin_btn_tint));
        DrawableCompat.setTintMode(wrap, Mode.SRC_ATOP);
        setBackgroundDrawable(wrap);
        setTextColor((ColorStateList) zzbq.checkNotNull(resources.getColorStateList(zzf(i2, C0365R.color.common_google_signin_btn_text_dark, C0365R.color.common_google_signin_btn_text_light, C0365R.color.common_google_signin_btn_text_light))));
        switch (i) {
            case 0:
                i = C0365R.string.common_signin_button_text;
                break;
            case 1:
                i = C0365R.string.common_signin_button_text_long;
                break;
            case 2:
                setText(null);
                break;
            default:
                stringBuilder = new StringBuilder(32);
                stringBuilder.append("Unknown button size: ");
                stringBuilder.append(i);
                throw new IllegalStateException(stringBuilder.toString());
        }
        setText(resources.getString(i));
        setTransformationMethod(null);
        if (zzi.zzcs(getContext())) {
            setGravity(19);
        }
    }
}
