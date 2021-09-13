package com.thehardgamer.practical6;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {
    final Calendar calendar = Calendar.getInstance();
    final String myFormat = "dd/MM/yy";
    final SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);
    String fieldCalled = "issueDate";
    EditText book, issue, due, submit, overdue;
    TextView result;
    Button button;
    DatePickerDialog.OnDateSetListener dateSetListener = (view, year, month,
                                                          dayOfMonth) -> {
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH, month);
        calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
        updatetexts();
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        book = findViewById(R.id.book);
        issue = findViewById(R.id.issue);
        due = findViewById(R.id.due);
        submit = findViewById(R.id.submit);
        overdue = findViewById(R.id.overdue);
        button = findViewById(R.id.button);
        result = findViewById(R.id.result);
        issue.setOnClickListener(v -> {
            new DatePickerDialog(MainActivity.this,
                    dateSetListener, calendar.get(Calendar.YEAR),
                    calendar.get(Calendar.MONTH),
                    calendar.get(Calendar.DAY_OF_MONTH)).show();
            fieldCalled = "issue";
        });
        due.setOnClickListener(v -> {
            new DatePickerDialog(MainActivity.this,
                    dateSetListener, calendar.get(Calendar.YEAR),
                    calendar.get(Calendar.MONTH),
                    calendar.get(Calendar.DAY_OF_MONTH)).show();
            fieldCalled = "due";
        });
        submit.setOnClickListener(v -> {
            new DatePickerDialog(MainActivity.this,
                    dateSetListener, calendar.get(Calendar.YEAR),
                    calendar.get(Calendar.MONTH),
                    calendar.get(Calendar.DAY_OF_MONTH)).show();
            fieldCalled = "submit";
        });
        button.setOnClickListener(v -> overdue());
    }

    public void updatetexts() {
        switch(fieldCalled) {
            case "issue":
                issue.setText(sdf.format(calendar.getTime()));
                break;
            case "due":
                due.setText(sdf.format(calendar.getTime()));
                break;
            case "submit":
                submit.setText(sdf.format(calendar.getTime()));
                break;
        }
    }

    public void overdue() {
        String issuedatestr = issue.getText().toString().trim();
        String duedatestr = due.getText().toString().trim();
        String submitdatestr = submit.getText().toString().trim();
        String overduestr = overdue.getText().toString().trim();
        if (issuedatestr.isEmpty() || duedatestr.isEmpty() || submitdatestr.isEmpty()){
            Toast.makeText(this, "Please enter proper dates.", Toast.LENGTH_SHORT).show();
        }

        try {
            Date issuedate = sdf.parse(issuedatestr);
            Date duedate = sdf.parse(duedatestr);
            Date submitdate = sdf.parse(submitdatestr);
            long diff = submitdate.getTime() - duedate.getTime();
            if (diff > 0) {
                int days = (int) TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
                double overdueCharge = Double.parseDouble(overduestr);
                double totalOverdueCharge = days * overdueCharge;
                String displayText = "Total Overdue Charge : ₹ " +
                        String.format("%.2f", totalOverdueCharge) + "/-";
                result.setText(displayText);
            } else {
                String displayText = "Nothing is overdue!";
                result.setText(displayText);
            }
        } catch (ParseException e) {
            System.out.println(e);
        }
    }
}