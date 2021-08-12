package com.varun.calculator;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import org.mariuszgromada.math.mxparser.*;

public class MainActivity extends AppCompatActivity {

    private EditText calc;
    public static String result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        calc = findViewById(R.id.display);

        //To avoid keyboard popup on touching the display area
        calc.setShowSoftInputOnFocus(false);
    }

    private void calcViewUpdate(String insert) {
        String curr = calc.getText().toString();
        int cursor = calc.getSelectionStart();
        String left = curr.substring(0, cursor);
        String right = curr.substring(cursor);
        if (getString(R.string.display).equals(calc.getText().toString())) {
            calc.setText(insert);
        }
        else {
            calc.setText(String.format("%s%s%s", left, insert, right));
        }
        calc.setSelection(cursor + 1);

    }

    //Numbers And Symbols
    public void zero(View view) {
            calcViewUpdate("0");
    }
    public void one(View view) {
        calcViewUpdate("1");
    }
    public void two(View view) {
        calcViewUpdate("2");
    }
    public void three(View view) {
        calcViewUpdate("3");
    }
    public void four(View view) {
        calcViewUpdate("4");
    }
    public void five(View view) {
        calcViewUpdate("5");
    }
    public void six(View view) {
        calcViewUpdate("6");
    }
    public void seven(View view) {
        calcViewUpdate("7");
    }
    public void eight(View view) {
        calcViewUpdate("8");
    }
    public void nine(View view) {
        calcViewUpdate("9");
    }
    public void dot(View view) {
        calcViewUpdate(".");
    }
    public void add(View view) {
        calcViewUpdate("+");
    }
    public void sub(View view) {
        calcViewUpdate("-");
    }
    public void div(View view) {
        calcViewUpdate("/");
    }
    public void multiply(View view) {
        calcViewUpdate("*");
    }

    //Clear
    public void clear(View view) {
        calc.setText("");
    }

    //Math Function
    public void equal(View view) {
        String currentmafs = calc.getText().toString();
        Expression exp = new Expression(currentmafs);
        result = String.valueOf(exp.calculate());
        calc.setText(result);
        calc.setSelection(result.length());
    }

}