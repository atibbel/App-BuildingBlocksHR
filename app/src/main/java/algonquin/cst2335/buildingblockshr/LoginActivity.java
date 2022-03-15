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
                String email = edittext_email.getText().toString();
                String password = edittext_password.getText().toString();

                boolean validate = validateLogin(email, password);
                if(validate){
                    Intent nextPage = new Intent(LoginActivity.this, MainActivity_Custom.class);
                    startActivity(nextPage);
                }
            }
        });


    } //eof onCreate
    // method to validate the users login
    private boolean validateLogin(String email, String password){
        if(email.length()==0){
            edittext_email.requestFocus();
            edittext_email.setError("Email cannot be empty");
            return false;
        }
        else if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            edittext_email.requestFocus();
            edittext_email.setError("Email not valid");
            return false;
        }
        else if(password.length()<=8){
            edittext_password.requestFocus();
            edittext_password.setError("Password must be at least 8 characters long.");
            return false;
        }
        else{
            return true;
        }
    }//eof validateLogin




}
