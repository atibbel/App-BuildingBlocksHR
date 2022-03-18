package algonquin.cst2335.buildingblockshr;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

public class PerksActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perks);
    }

    public void form1(View view) {
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.pexels.com/photo/white-rabbit-wearing-yellow-eyeglasses-4588065/"));
        startActivity(browserIntent);
    }

    public void form2(View view) {
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.pexels.com/photo/portrait-of-shiba-inu-dog-4587979/"));
        startActivity(browserIntent);
    }

    public void form3(View view) {
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.pexels.com/photo/black-and-white-dairy-cow-s-head-2647053/"));
        startActivity(browserIntent);
    }

    public void form4(View view) {
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.pexels.com/photo/black-owner-with-adorable-boston-terrier-7533331/"));
        startActivity(browserIntent);
    }
}