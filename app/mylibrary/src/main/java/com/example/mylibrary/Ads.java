package com.example.mylibrary;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;

public class Ads {
    Context context ;
    public Ads(Context context){
        this.context=context;
    }
    public void displayAds(){
        new AlertDialog.Builder(context)
                .setTitle("Ads")
                .setMessage("Thi is adddddddd")
                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                })
                .setIcon(android.R.drawable.ic_dialog_alert)
                .show();
    }
}
