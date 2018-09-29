package com.zhengyuan.dialogshowinfo;

import android.app.Dialog;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

/**
 * Created by Administrator on 2018/9/29.
 */

public class MySweetAlertDialog extends Dialog {
    public MySweetAlertDialog(@NonNull Context context) {
        super(context);
    }

    public MySweetAlertDialog(@NonNull Context context, int themeResId) {
        super(context, themeResId);
    }

    protected MySweetAlertDialog(@NonNull Context context, boolean cancelable, @Nullable OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
    }
}
