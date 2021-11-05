package com.example.dialogs;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import java.text.DateFormat;
import java.util.Calendar;

public class DateTimePicker extends AppCompatActivity implements DatePickerDialog.OnDateSetListener, TimePickerDialog.OnTimeSetListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.date_time_picker);
        Button btFecha = (Button) findViewById(R.id.datePicker);
        Button btHora = (Button) findViewById(R.id.timePicker);
        btFecha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogFragment datePicker = new DatePickerFragment();
                datePicker.show(getSupportFragmentManager(), "selector fecha");
            }
        });
        btHora.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            DialogFragment timepicker = new TimePickerFragment();
            timepicker.show(getSupportFragmentManager(), "Selector hora");
            }
        });
    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        Calendar c = Calendar.getInstance();
        c.set(Calendar.YEAR, year);
        c.set(Calendar.MONTH, month);
        c.set(Calendar.DAY_OF_MONTH, dayOfMonth);
        String currentDateString = DateFormat.getDateInstance(DateFormat.FULL).format(c.getTime());
        TextView fecha = (TextView) findViewById(R.id.fechaText);
        fecha.setText(currentDateString);
    }

    @Override
    public void onTimeSet(TimePicker view, int hour, int minute) {
        TextView hora = (TextView) findViewById(R.id.horaText);
        hora.setText(hour + ": " + minute);
    }
}