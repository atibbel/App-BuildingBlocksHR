package algonquin.cst2335.buildingblockshr;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CalendarView;
import android.widget.TextView;

public class VacationDaysRemainingActivity extends AppCompatActivity {

    CalendarView calendar;
    TextView date_view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vacation_days_remaining);

        calendar = findViewById(R.id.calendar);
        date_view = findViewById(R.id.date_view);

        // Add Listener in calendar
        calendar
                .setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
                            @Override
                            // and in this method will get the value of DAYS, MONTH, YEARS
                            public void onSelectedDayChange(
                                    @NonNull CalendarView view,
                                    int year,
                                    int month,
                                    int dayOfMonth)
                            {
                                // Store the value of date with format in String type Variable. Add 1 in month because month index is start with 0
                                String Date
                                        = dayOfMonth + "-" + (month + 1) + "-" + year;
                                // set this date in TextView for Display
                                date_view.setText(Date);
                            }
                        });
    }

    public void click_here(View view) {
        Intent nextpage = new Intent(VacationDaysRemainingActivity.this, ScheduleTimeOffActivity.class);
        startActivity(nextpage);

    }
}