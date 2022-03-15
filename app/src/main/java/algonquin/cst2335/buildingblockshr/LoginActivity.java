package algonquin.cst2335.buildingblockshr;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    EditText edittext_password;
    EditText edittext_email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Button loginButton = findViewById(R.id.loginButton);
        Button button_standard = findViewById(R.id.button_standard);
        Button button_plus = findViewById(R.id.button_plus);
        Button button_custom = findViewById(R.id.button_custom);
        edittext_email = findViewById(R.id.edittext_email);
        edittext_password = findViewById(R.id.edittext_password);

        button_standard.setOnClickListener( clk-> {
            Intent nextPage = new Intent(LoginActivity.this, MainActivity_Standard.class);
            startActivity(nextPage);
        });
        button_plus.setOnClickListener( clk-> {
            Intent nextPage = new Intent(LoginActivity.this, MainActivity_Plus.class);
            startActivity(nextPage);
        });
        button_custom.setOnClickListener( clk-> {
            Intent nextPage = new Intent(LoginActivity.this, MainActivity_Custom.class);
            startActivity(nextPage);
        });

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(validateEmail(edittext_email)) {
                    Intent nextPage = new Intent(LoginActivity.this, MainActivity_Custom.class);
                    startActivity(nextPage);
                } // eof if
            }// eof onClick method
        }); //eof loginButton.onClick

    }
    private boolean validateEmail(EditText email){
        String emailInput = email.getText().toString();

        if (!emailInput.isEmpty() && Patterns.EMAIL_ADDRESS.matcher(emailInput).matches()){
            return true;
        } // eof if
        else{
            AlertDialog.Builder builder2 = new AlertDialog.Builder(LoginActivity.this);
            builder2.setMessage("Oops! That dosen't look right. Please enter a valid email address.")
                    .setPositiveButton(getString(R.string.OkMsg), (dialogue, click) -> {
                    }).create().show();
            return false;

        } //eof else
    }// eof validateEmail


}
