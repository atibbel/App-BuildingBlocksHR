package algonquin.cst2335.buildingblockshr;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageButton policyButton = findViewById(R.id.policyButton);
        ImageButton benefitsButton = findViewById(R.id.benefitsButton);
        ImageButton vacationButton = findViewById(R.id.vacationButton);

        String gettingThatToast = "Getting that for you...";

        Toolbar myToolbar = findViewById(R.id.toolbar);
        setSupportActionBar(myToolbar);

//        DrawerLayout drawer = findViewById(R.id.drawer_layout);
//        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, myToolbar, R.string.open, R.string.close);
//        drawer.addDrawerListener(toggle);
//        toggle.syncState();
//
//        NavigationView navigationView = findViewById(R.id.popout_menu);
//        navigationView.setNavigationItemSelectedListener((item)->{
//            switch(item.getItemId())
//            {
//                case R.id.policy:
//
//                case R.id.benefits:
//
//                case R.id.vacation://
//
//                    onOptionsItemSelected(item);
//                    drawer.closeDrawer(GravityCompat.START);
//                    break;
//            }
//            return false;
//        });

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
}