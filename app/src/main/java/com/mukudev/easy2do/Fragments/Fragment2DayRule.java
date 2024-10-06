package com.mukudev.easy2do.Fragments;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CalendarView;
import android.widget.Toast;

import com.mukudev.easy2do.R;

public class Fragment2DayRule extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_2day_rule, container, false);

        // Initialize the CalendarView
        CalendarView calendarView = view.findViewById(R.id.calendarView);

        // Set OnDateChangeListener to capture date changes
        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(CalendarView view, int year, int month, int dayOfMonth) {

                String selectedDate = dayOfMonth + "/" + (month + 1) + "/" + year;

                // Add functionality to save the mark date and it should be asserted because it cannot change after its marked
                Toast.makeText(getContext(), "Selected Date: " + selectedDate, Toast.LENGTH_SHORT).show();

            }
        });

        return view;

    }

}
