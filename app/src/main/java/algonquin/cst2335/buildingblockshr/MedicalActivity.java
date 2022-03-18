package algonquin.cst2335.buildingblockshr;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

public class MedicalActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medical);
    }


    public void form1(View view) {
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.pexels.com/photo/white-and-grey-kitten-on-brown-and-black-leopard-print-textile-45201/"));
        startActivity(browserIntent);
    }

    public void form2(View view) {
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.pexels.com/photo/close-up-photography-of-cat-1183434/"));
        startActivity(browserIntent);
    }

    public void form3(View view) {
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.pexels.com/photo/black-and-white-cat-with-tongue-out-1317844/"));
        startActivity(browserIntent);
    }

    public void form4(View view) {
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.pexels.com/photo/grey-fur-kitten-127028/"));
        startActivity(browserIntent);
    }
}