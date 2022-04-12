package algonquin.cst2335.buildingblockshr;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.navigation.NavigationView;

public class VacationActivity extends AppCompatActivity {

    CalendarView calendar;
    TextView date_view;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_activity_actions, menu); // inflate the xml object(menu) into the tool bar -- R.directory.file , object to inflate into
        return true;
        //return super.onCreateOptionsMenu(menu);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vacation);

//        EditText editDays = findViewById(R.id.number_of_days);
//        String daysOff = editDays.getText().toString();


        Toolbar myToolbar = findViewById(R.id.toolbar);
        setSupportActionBar(myToolbar);// causes OnCreateOptionMenu() to be called

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, myToolbar, R.string.open, R.string.close); // create string open and close
        drawer.addDrawerListener(toggle); // listens to when it opens and closes
        toggle.syncState();

        NavigationView navigationView = findViewById(R.id.popout_menu); // popout menu options
        navigationView.setNavigationItemSelectedListener((item)->{
            switch(item.getItemId()) {
                //POLICIES
                case R.id.popout_policies:
                    Intent nextPage = new Intent(VacationActivity.this, PolicyActivity.class);
                    startActivity(nextPage);
                    break;
                case R.id.popout_violence:
                    Intent nextPage_1 = new Intent(VacationActivity.this, ViolencePolicyActivity.class);
                    startActivity(nextPage_1);
                    break;

                case R.id.popout_harassment:
                    Intent nextPage_2 = new Intent(VacationActivity.this, HarassmentPolicyActivity.class);
                    startActivity(nextPage_2);
                    break;

                case R.id.popout_aoda:
                    Intent nextPage_3 = new Intent(VacationActivity.this, AodaPolicyActivity.class);
                    startActivity(nextPage_3);
                    break;

                case R.id.popout_health_safety:
                    Intent nextPage_4 = new Intent(VacationActivity.this, HealthAndSafetyActivity.class);
                    startActivity(nextPage_4);
                    break;

                case R.id.popout_privacy:
                    Intent nextPage_5 = new Intent(VacationActivity.this, PrivacyPolicyActivity.class);
                    startActivity(nextPage_5);
                    break;

                //BENEFITS
                case R.id.popout_benefits:
                    Intent nextPage1 = new Intent(VacationActivity.this, BenefitsActivity_Custom.class);
                    startActivity(nextPage1);
                    break;

                case R.id.popout_medical:
                    Intent nextPage1_1 = new Intent(VacationActivity.this, MedicalActivity.class);
                    startActivity(nextPage1_1);
                    break;

                case R.id.popout_dental:
                    Intent nextPage1_2 = new Intent(VacationActivity.this, DentalActivity.class);
                    startActivity(nextPage1_2);
                    break;

                case R.id.popout_other_benefits:
                    Intent nextPage1_3 = new Intent(VacationActivity.this, OtherBenefitsActivity.class);
                    startActivity(nextPage1_3);
                    break;

                case R.id.popout_perks:
                    Intent nextPage1_4 = new Intent(VacationActivity.this, PerksActivity.class);
                    startActivity(nextPage1_4);
                    break;

                //VACATION
                case R.id.popout_vacation:
                    Intent nextPage2 = new Intent(VacationActivity.this, VacationActivity.class);
                    startActivity(nextPage2);
                    break;

                case R.id.popout_vacation_policy:
                    Intent nextPage2_1 = new Intent(VacationActivity.this, VacationPolicyActivity.class);
                    startActivity(nextPage2_1);
                    break;

                case R.id.popout_timeoff:
                    Intent nextPage2_2 = new Intent(VacationActivity.this, ScheduleTimeOffActivity.class);
                    startActivity(nextPage2_2);
                    break;

//                case R.id.popout_remaining_days:
//                    Intent nextPage2_3 = new Intent(VacationActivity.this, VacationDaysRemainingActivity.class);
//                    startActivity(nextPage2_3);
//                    break;

                //OTHER LEAVE
                case R.id.popout_other_leaves:
                    Intent nextPage3 = new Intent(VacationActivity.this, OtherLeavesActivity.class);
                    startActivity(nextPage3);
                    break;

                case R.id.popout_sick_leave:
                    Intent nextPage3_1 = new Intent(VacationActivity.this, SickLeaveActivity.class);
                    startActivity(nextPage3_1);
                    break;

                case R.id.popout_gov_leave:
                    Intent nextPage3_2 = new Intent(VacationActivity.this, GovLeaveActivity.class);
                    startActivity(nextPage3_2);
                    break;

                case R.id.popout_other:
                    Intent nextPage3_3 = new Intent(VacationActivity.this, OthersActivity.class);
                    startActivity(nextPage3_3);
                    break;

                case R.id.home:
                    Intent nextPage4 = new Intent(VacationActivity.this, MainActivity_Custom.class);
                    startActivity(nextPage4);
            }

            onOptionsItemSelected(item);
            drawer.closeDrawer(GravityCompat.START);
            return false;
        });

        calendar = findViewById(R.id.calendar);
        date_view = findViewById(R.id.date_view);

        // Add Listener in calendar
        calendar
                .setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
                    @Override
                    // get the value of DAYS, MONTH, YEARS
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
        Intent nextpage = new Intent(VacationActivity.this, ScheduleTimeOffActivity.class);
        startActivity(nextpage);

    }

    public void policy(View view) {
        Intent nextPage = new Intent(VacationActivity.this, VacationPolicyActivity.class);
        startActivity(nextPage);
    }

}