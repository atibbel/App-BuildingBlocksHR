package algonquin.cst2335.buildingblockshr;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

public class DentalActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dental);
    }

    public void form1(View view) {
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://buildingblockshr.ca/"));
        startActivity(browserIntent);
    }

    public void form2(View view) {
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://buildingblockshr.ca/"));
        startActivity(browserIntent);
    }

    public void form3(View view) {
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://buildingblockshr.ca/"));
        startActivity(browserIntent);
    }

    public void form4(View view) {
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://buildingblockshr.ca/"));
        startActivity(browserIntent);
    }

}