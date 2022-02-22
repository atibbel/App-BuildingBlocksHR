package algonquin.cst2335.buildingblockshr;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class UserDemoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_demo);

        Button button_standard = findViewById(R.id.button_standard);
        Button button_plus = findViewById(R.id.button_plus);
        Button button_custom = findViewById(R.id.button_custom);

        button_standard.setOnClickListener( clk-> {
            Intent nextPage = new Intent(UserDemoActivity.this, MainActivity_Standard.class);
            startActivity(nextPage);
        });
        button_plus.setOnClickListener( clk-> {
            Intent nextPage = new Intent(UserDemoActivity.this, MainActivity_Plus.class);
            startActivity(nextPage);
        });
        button_custom.setOnClickListener( clk-> {
            Intent nextPage = new Intent(UserDemoActivity.this, MainActivity_Custom.class);
            startActivity(nextPage);
        });
    }

}
