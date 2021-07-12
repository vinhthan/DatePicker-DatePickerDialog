package com.example.datepicker;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.icu.util.Calendar;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    DatePicker datePicker;
    DatePickerDialog datePickerDialog;
    TextView tvDay, tvMonth, tvYear, tvDatePickerDialog;
    Button btn;

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        datePicker = findViewById(R.id.date_picker);
        tvDay = findViewById(R.id.tv_day);
        tvMonth = findViewById(R.id.tv_month);
        tvYear = findViewById(R.id.tv_year);
        tvDatePickerDialog = findViewById(R.id.tv_date_picker_dialog);
        btn = findViewById(R.id.button);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvDay.setText(String.valueOf(datePicker.getDayOfMonth()));
                tvMonth.setText(String.valueOf(datePicker.getMonth() + 1));//0-11
                tvYear.setText(String.valueOf(datePicker.getYear()));
            }
        });

        tvDatePickerDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar calendar = Calendar.getInstance();
                int year = calendar.get(Calendar.YEAR);
                int month = calendar.get(Calendar.MONTH);
                int day = calendar.get(Calendar.DAY_OF_MONTH);
                datePickerDialog = new DatePickerDialog(MainActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @SuppressLint("SetTextI18n")
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        tvDatePickerDialog.setText(dayOfMonth + "/" + (month + 1)  +"/" + year);
                    }
                }, year, month, day);
                datePickerDialog.show();
            }
        });

    }
}