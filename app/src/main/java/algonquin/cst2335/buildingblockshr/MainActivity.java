package algonquin.cst2335.buildingblockshr;

import androidx.annotation.NonNull;
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
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {

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
        setContentView(R.layout.activity_main);

        ImageButton policyButton = findViewById(R.id.policyButton);
        ImageButton benefitsButton = findViewById(R.id.benefitsButton);
        ImageButton vacationButton = findViewById(R.id.vacationButton);

        String gettingThatToast = "Getting that for you...";

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
                    Intent nextPage = new Intent(MainActivity.this, PolicyActivity.class);
                    startActivity(nextPage);
                    break;

                case R.id.popout_benefits:
                    Intent nextPage1 = new Intent(MainActivity.this, BenefitsActivity.class);
                    startActivity(nextPage1);
                    break;

                case R.id.popout_vacation:
                    Intent nextPage2 = new Intent(MainActivity.this, VacationActivity.class);
                    startActivity(nextPage2);
                    break;
            }

            onOptionsItemSelected(item);
            drawer.closeDrawer(GravityCompat.START);
            return false;
        });

        policyButton.setOnClickListener( clk-> {
            Intent nextPage = new Intent(MainActivity.this, PolicyActivity.class);
            startActivity(nextPage);
            Toast.makeText(MainActivity.this, gettingThatToast, Toast.LENGTH_LONG).show();
        });
        benefitsButton.setOnClickListener( clk-> {
            Intent nextPage = new Intent(MainActivity.this, BenefitsActivity.class);
            startActivity(nextPage);
            Toast.makeText(MainActivity.this, gettingThatToast, Toast.LENGTH_LONG).show();
        });
        vacationButton.setOnClickListener( clk-> {
            Intent nextPage = new Intent(MainActivity.this, VacationActivity.class);
            startActivity(nextPage);
            Toast.makeText(MainActivity.this, gettingThatToast, Toast.LENGTH_LONG).show();
        });
    }

    @Override
    public boolean onOptionsItemSelected( MenuItem item) {
        // what is the id of the item that was clicked
        switch (item.getItemId()) {
            case R.id.help:
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle(getString(R.string.hrHelpTitle))
                        .setMessage(getString(R.string.helpMsg))
                        .setPositiveButton(getString(R.string.OkMsg), (dialogue, click) -> {
                        }).create().show();
                break;
            case R.id.signUp: // edit to take to sign up page
                AlertDialog.Builder builder2 = new AlertDialog.Builder(MainActivity.this);
                builder2.setMessage("This will take you to the sign up page....when we create it.")
                        .setPositiveButton(getString(R.string.OkMsg), (dialogue, click) -> {
                        }).create().show();

        }
        return super.onOptionsItemSelected(item);
    }
}