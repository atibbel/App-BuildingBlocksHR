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
import android.widget.Button;

import com.google.android.material.navigation.NavigationView;

public class PolicyActivity extends AppCompatActivity {

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();
        // need to create new action menu per package
        inflater.inflate(R.menu.main_activity_actions, menu); // inflate the xml object(menu) into the tool bar -- R.directory.file , object to inflate into
        return true;
        //return super.onCreateOptionsMenu(menu);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_policies);

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
                case R.id.popout_policies:
                    Intent nextPage = new Intent(PolicyActivity.this, PolicyActivity.class);
                    startActivity(nextPage);
                    break;

                case R.id.popout_benefits:
                    Intent nextPage1 = new Intent(PolicyActivity.this, BenefitsActivity_Custom.class);
                    startActivity(nextPage1);
                    break;

                case R.id.popout_vacation:
                    Intent nextPage2 = new Intent(PolicyActivity.this, VacationActivity.class);
                    startActivity(nextPage2);
                    break;

                case R.id.popout_other_leaves:
                    Intent nextPage3 = new Intent(PolicyActivity.this, OtherLeavesActivity.class);
                    startActivity(nextPage3);
                    break;
                case R.id.home:
                    Intent nextPage4 = new Intent(PolicyActivity.this, MainActivity_Custom.class);
                    startActivity(nextPage4);
            }

            onOptionsItemSelected(item);
            drawer.closeDrawer(GravityCompat.START);
            return false;
        });


    }
    // xml onClick method
    public void policy_violence(View view) {
            Intent nextPage = new Intent(PolicyActivity.this, ViolencePolicyActivity.class);
            startActivity(nextPage);
    }

    public void policy_harassment(View view) {
        Intent nextPage = new Intent(PolicyActivity.this, HarassmentPolicyActivity.class);
        startActivity(nextPage);
    }

    public void policy_Aoda(View view) {
        Intent nextPage = new Intent(PolicyActivity.this, AodaPolicyActivity.class);
        startActivity(nextPage);
    }

    public void policy_HealthSafety(View view) {
        Intent nextPage = new Intent(PolicyActivity.this, HealthAndSafetyActivity.class);
        startActivity(nextPage);
    }

    public void policyPrivacy(View view) {
        Intent nextPage = new Intent(PolicyActivity.this, PrivacyPolicyActivity.class);
        startActivity(nextPage);
    }
}