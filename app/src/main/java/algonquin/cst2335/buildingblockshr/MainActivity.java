package algonquin.cst2335.buildingblockshr;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.landing_page);

        Button button_standard = findViewById(R.id.button_standard);
        Button button_plus = findViewById(R.id.button_plus);
        Button button_custom = findViewById(R.id.button_custom);

        String gettingThatToast = "Getting that for you...";

        button_standard.setOnClickListener( clk-> {
        Intent nextPage = new Intent(MainActivity.this, MainActivity_Standard.class);
        startActivity(nextPage);
        Toast.makeText(MainActivity.this, gettingThatToast, Toast.LENGTH_LONG).show();
        });
        button_plus.setOnClickListener( clk-> {
        Intent nextPage = new Intent(MainActivity.this, MainActivity_Plus.class);
        startActivity(nextPage);
        Toast.makeText(MainActivity.this, gettingThatToast, Toast.LENGTH_LONG).show();
        });
        button_custom.setOnClickListener( clk-> {
        Intent nextPage = new Intent(MainActivity.this, MainActivity_Custom.class);
        startActivity(nextPage);
        Toast.makeText(MainActivity.this, gettingThatToast, Toast.LENGTH_LONG).show();
        });
  }

}