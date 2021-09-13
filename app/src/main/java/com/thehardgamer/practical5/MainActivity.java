package com.thehardgamer.practical5;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    public EditText input;
    public TextView output;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DecimalFormat form = new DecimalFormat("0.00");
        input = (EditText) findViewById(R.id.inputinr);
        output = (TextView) findViewById(R.id.result);
    }

    public void inrtodollar (View view) {
        int i;
        i = Integer.parseInt(input.getText().toString());
        double dollars;
        dollars = i / 73.00;
        DecimalFormat form = new DecimalFormat("0.00");
        output.setText(form.format(dollars) + "$");
    }
    @SuppressLint("SetTextI18n")
    public void inrtoeuro (View view) {
        int i;
        i = Integer.parseInt(input.getText().toString());
        double euro;
        euro = i / 86.77;
        DecimalFormat form = new DecimalFormat("0.00");
        output.setText(form.format(euro) + "€");
    }
}