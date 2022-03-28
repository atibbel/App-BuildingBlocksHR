package algonquin.cst2335.buildingblockshr;

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

import com.google.android.material.navigation.NavigationView;

public class BenefitsActivity_Plus extends AppCompatActivity {
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
        setContentView(R.layout.activity_benefits_plus);

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
                    Intent nextPage = new Intent(BenefitsActivity_Plus.this, PolicyActivity_Plus.class);
                    startActivity(nextPage);
                    break;

                case R.id.popout_violence:
                    Intent nextPage_1 = new Intent(BenefitsActivity_Plus.this, ViolencePolicyActivity.class);
                    startActivity(nextPage_1);
                    break;

                case R.id.popout_harassment:
                    Intent nextPage_2 = new Intent(BenefitsActivity_Plus.this, HarassmentPolicyActivity.class);
                    startActivity(nextPage_2);
                    break;

                case R.id.popout_aoda:
                    Intent nextPage_3 = new Intent(BenefitsActivity_Plus.this, AodaPolicyActivity.class);
                    startActivity(nextPage_3);
                    break;

                case R.id.popout_health_safety:
                    Intent nextPage_4 = new Intent(BenefitsActivity_Plus.this, HealthAndSafetyActivity.class);
                    startActivity(nextPage_4);
                    break;

                case R.id.popout_privacy:
                    Intent nextPage_5 = new Intent(BenefitsActivity_Plus.this, PrivacyPolicyActivity.class);
                    startActivity(nextPage_5);
                    break;

                //BENEFITS
                case R.id.popout_benefits:
                    Intent nextPage1 = new Intent(BenefitsActivity_Plus.this, BenefitsActivity_Plus.class);
                    startActivity(nextPage1);
                    break;

                case R.id.popout_medical:
                    Intent nextPage1_1 = new Intent(BenefitsActivity_Plus.this, MedicalActivity.class);
                    startActivity(nextPage1_1);
                    break;

                case R.id.popout_dental:
                    Intent nextPage1_2 = new Intent(BenefitsActivity_Plus.this, DentalActivity.class);
                    startActivity(nextPage1_2);
                    break;

                case R.id.popout_other_benefits:
                    Intent nextPage1_3 = new Intent(BenefitsActivity_Plus.this, OtherBenefitsActivity.class);
                    startActivity(nextPage1_3);
                    break;


                //VACATION
                case R.id.popout_vacation:
                    Intent nextPage2 = new Intent(BenefitsActivity_Plus.this, VacationActivity_Plus.class);
                    startActivity(nextPage2);
                    break;

                case R.id.popout_vacation_policy:
                    Intent nextPage2_1 = new Intent(BenefitsActivity_Plus.this, VacationPolicyActivity.class);
                    startActivity(nextPage2_1);
                    break;

                case R.id.popout_timeoff:
                    Intent nextPage2_2 = new Intent(BenefitsActivity_Plus.this, ScheduleTimeOffActivity.class);
                    startActivity(nextPage2_2);
                    break;

//                case R.id.popout_remaining_days:
//                    Intent nextPage2_3 = new Intent(BenefitsActivity_Plus.this, VacationDaysRemainingActivity.class);
//                    startActivity(nextPage2_3);
//                    break;


                case R.id.home:
                    Intent nextPage4 = new Intent(BenefitsActivity_Plus.this, MainActivity_Custom.class);
                    startActivity(nextPage4);
            }

            onOptionsItemSelected(item);
            drawer.closeDrawer(GravityCompat.START);
            return false;
        });


    }
    // xml onClick method
    public void medical(View view) {
        Intent nextPage = new Intent(BenefitsActivity_Plus.this, MedicalActivity.class);
        startActivity(nextPage);
    }

    public void dental(View view) {
        Intent nextPage = new Intent(BenefitsActivity_Plus.this, DentalActivity.class);
        startActivity(nextPage);
    }

    public void otherbenefits(View view) {
        Intent nextPage = new Intent(BenefitsActivity_Plus.this,OtherBenefitsActivity.class);
        startActivity(nextPage);
    }

} // eof BenefitsActivity class
