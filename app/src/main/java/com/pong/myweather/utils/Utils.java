package com.pong.myweather.utils;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;

/**
 * Created by USER on 26/2/2560.
 */

public class Utils {
    public static String capitalize(final String str){
        return str.substring(0,1).toUpperCase() + str.substring(1);
    }

    public static void showAlertPopup(Context context, String message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setMessage(message);
        builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        builder.show();
    }
}
