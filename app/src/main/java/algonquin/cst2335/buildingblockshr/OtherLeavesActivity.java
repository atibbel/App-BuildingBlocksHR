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

public class OtherLeavesActivity extends AppCompatActivity {

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
        setContentView(R.layout.activity_other_leaves);

        Button policyButton = findViewById(R.id.policyButton);
        Button benefitsButton = findViewById(R.id.benefitsButton);
        Button vacationButton = findViewById(R.id.vacationButton);

        Toolbar myToolbar = findViewById(R.id.toolbar);
        setSupportActionBar(myToolbar);// causes OnCreateOptionMenu() to be called

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, myToolbar, R.string.open, R.string.close); // create string open and close
        drawer.addDrawerListener(toggle); // listens to when it opens and closes
        toggle.syncState();
// pop out menu option. Must change to fit package
        NavigationView navigationView = findViewById(R.id.popout_menu); // popout menu options
        navigationView.setNavigationItemSelectedListener((item)->{
            switch(item.getItemId()) {
                case R.id.popout_policies:
                    Intent nextPage = new Intent(OtherLeavesActivity.this, PolicyActivity.class);
                    startActivity(nextPage);
                    break;

                case R.id.popout_benefits:
                    Intent nextPage1 = new Intent(OtherLeavesActivity.this, BenefitsActivity_Custom.class);
                    startActivity(nextPage1);
                    break;

                case R.id.popout_vacation:
                    Intent nextPage2 = new Intent(OtherLeavesActivity.this, VacationActivity.class);
                    startActivity(nextPage2);
                    break;
                case R.id.popout_other_leaves:
                    Intent nextPage3 = new Intent(OtherLeavesActivity.this, OtherLeavesActivity.class);
                    startActivity(nextPage3);
                    break;
                case R.id.home:
                    Intent nextPage4 = new Intent(OtherLeavesActivity.this, MainActivity_Custom.class);
                    startActivity(nextPage4);
            }

            onOptionsItemSelected(item);
            drawer.closeDrawer(GravityCompat.START);
            return false;
        });
    }

    public void sick_leave(View view) {
        Intent nextpage = new Intent(OtherLeavesActivity.this, SickLeaveActivity.class);
        startActivity(nextpage);
    }

    public void gov_leave(View view) {
        Intent nextpage = new Intent(OtherLeavesActivity.this, GovLeaveActivity.class);
        startActivity(nextpage);
    }

    public void others(View view) {
        Intent nextpage = new Intent(OtherLeavesActivity.this, OthersActivity.class);
        startActivity(nextpage);
    }


}