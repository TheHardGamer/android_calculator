package com.thehardgamer.practical4;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    AlertDialog.Builder builder;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void openalert(View view) {
        builder = new AlertDialog.Builder(this);
        builder.setTitle(R.string.dialogmessage).setMessage(R.string.dialogtitle)
                .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int i) {}
                });
        AlertDialog alert = builder.create();
        alert.show();
    }
}