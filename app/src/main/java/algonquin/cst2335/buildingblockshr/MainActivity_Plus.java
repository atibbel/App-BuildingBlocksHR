package algonquin.cst2335.buildingblockshr;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

public class MainActivity_Plus extends AppCompatActivity {

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
        setContentView(R.layout.activity_main_plus);

        Button policyButton = findViewById(R.id.policyButton);
        Button benefitsButton = findViewById(R.id.benefitsButton);
        Button vacationButton = findViewById(R.id.vacationButton);

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
                    Intent nextPage = new Intent(MainActivity_Plus.this, PolicyActivity_Plus.class);
                    startActivity(nextPage);
                    break;
                case R.id.popout_violence:
                    Intent nextPage_1 = new Intent(MainActivity_Plus.this, ViolencePolicyActivity.class);
                    startActivity(nextPage_1);
                    break;

                case R.id.popout_harassment:
                    Intent nextPage_2 = new Intent(MainActivity_Plus.this, HarassmentPolicyActivity.class);
                    startActivity(nextPage_2);
                    break;

                case R.id.popout_aoda:
                    Intent nextPage_3 = new Intent(MainActivity_Plus.this, AodaPolicyActivity.class);
                    startActivity(nextPage_3);
                    break;

                case R.id.popout_health_safety:
                    Intent nextPage_4 = new Intent(MainActivity_Plus.this, HealthAndSafetyActivity.class);
                    startActivity(nextPage_4);
                    break;

                case R.id.popout_privacy:
                    Intent nextPage_5 = new Intent(MainActivity_Plus.this, PrivacyPolicyActivity.class);
                    startActivity(nextPage_5);
                    break;

                //BENEFITS
                case R.id.popout_benefits:
                    Intent nextPage1 = new Intent(MainActivity_Plus.this, BenefitsActivity_Plus.class);
                    startActivity(nextPage1);
                    break;

                case R.id.popout_medical:
                    Intent nextPage1_1 = new Intent(MainActivity_Plus.this, MedicalActivity.class);
                    startActivity(nextPage1_1);
                    break;

                case R.id.popout_dental:
                    Intent nextPage1_2 = new Intent(MainActivity_Plus.this, DentalActivity.class);
                    startActivity(nextPage1_2);
                    break;

                case R.id.popout_other_benefits:
                    Intent nextPage1_3 = new Intent(MainActivity_Plus.this, OtherBenefitsActivity.class);
                    startActivity(nextPage1_3);
                    break;

                //VACATION
                case R.id.popout_vacation:
                    Intent nextPage2 = new Intent(MainActivity_Plus.this, VacationActivity_Plus.class);
                    startActivity(nextPage2);
                    break;

                case R.id.popout_vacation_policy:
                    Intent nextPage2_1 = new Intent(MainActivity_Plus.this, VacationPolicyActivity.class);
                    startActivity(nextPage2_1);
                    break;

                case R.id.popout_timeoff:
                    Intent nextPage2_2 = new Intent(MainActivity_Plus.this, ScheduleTimeOffActivity.class);
                    startActivity(nextPage2_2);
                    break;

//                case R.id.popout_remaining_days:
//                    Intent nextPage2_3 = new Intent(MainActivity_Plus.this, VacationDaysRemainingActivity.class);
//                    startActivity(nextPage2_3);
//                    break;

                case R.id.home:
                    Intent nextPage3 = new Intent(MainActivity_Plus.this, MainActivity_Plus.class);
                    startActivity(nextPage3);
            }

            onOptionsItemSelected(item);
            drawer.closeDrawer(GravityCompat.START);
            return false;
        });

        policyButton.setOnClickListener( clk-> {
            Intent nextPage = new Intent(MainActivity_Plus.this, PolicyActivity_Plus.class);
            startActivity(nextPage);
            Toast.makeText(MainActivity_Plus.this, R.string.loading, Toast.LENGTH_SHORT).show();
        });
        benefitsButton.setOnClickListener( clk-> {
            Intent nextPage = new Intent(MainActivity_Plus.this, BenefitsActivity_Plus.class);
            startActivity(nextPage);
            Toast.makeText(MainActivity_Plus.this, R.string.loading, Toast.LENGTH_SHORT).show();
        });
        vacationButton.setOnClickListener( clk-> {
            Intent nextPage = new Intent(MainActivity_Plus.this, VacationActivity_Plus.class);
            startActivity(nextPage);
            Toast.makeText(MainActivity_Plus.this, R.string.loading, Toast.LENGTH_SHORT).show();
        });

        // displays user name on main page.
        // will change after we get a database connection.
        Intent welcome = getIntent();
        String userName = welcome.getStringExtra("userName");
        TextView name = findViewById(R.id.username);
        name.setText("Welcome Back " + userName);
        // Shared prefs will be(?) needed

    }

    @Override
    public boolean onOptionsItemSelected( MenuItem item) {
        // what is the id of the item that was clicked
        switch (item.getItemId()) {
            case R.id.help:
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity_Plus.this);
                builder.setTitle(getString(R.string.hrHelpTitle))
                        .setMessage(getString(R.string.helpMsg))
                        .setPositiveButton(getString(R.string.OkMsg), (dialogue, click) -> {
                        }).create().show();
                break;
            case R.id.logOut: // edit to take to sign up page
                AlertDialog.Builder builder2 = new AlertDialog.Builder(MainActivity_Plus.this);
                builder2.setMessage("This will log you out....when we create it.")
                        .setPositiveButton(getString(R.string.OkMsg), (dialogue, click) -> {
                        }).create().show();

        }
        return super.onOptionsItemSelected(item);
    }

}