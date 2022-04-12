package algonquin.cst2335.buildingblockshr;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
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
    String customUser= "custom@mail.com";
    String plusUser = "plus@mail.com";
    String standardUser = "standard@mail.com";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Button loginButton = findViewById(R.id.loginButton);

        edittext_email = findViewById(R.id.edittext_email);
        edittext_password = findViewById(R.id.edittext_password);


        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = edittext_email.getText().toString();
                String password = edittext_password.getText().toString();

                if(email.length()==0){
                    edittext_email.requestFocus();
                    edittext_email.setError("Email cannot be empty");

                }
                else if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
                    edittext_email.requestFocus();
                    edittext_email.setError("Email not valid");

                }
                else if(password.length()<=7){
                    edittext_password.requestFocus();
                    edittext_password.setError("Password must be at least 8 characters long.");

                }
                else {

                    if (email.equals(customUser)) {
                        Intent next = new Intent(LoginActivity.this, MainActivity_Custom.class);
                        next.putExtra("userName", edittext_email.getText().toString()); // used to get userinput for welcome screen
                        startActivity(next);
                    } else if (email.equals(plusUser)) {
                        Intent next2 = new Intent(LoginActivity.this, MainActivity_Plus.class);
                        next2.putExtra("userName", edittext_email.getText().toString()); // used to get userinput for welcome screen
                        startActivity(next2);
                    } else if (email.equals(standardUser)) {
                        Intent next3 = new Intent(LoginActivity.this, MainActivity_Standard.class);
                        next3.putExtra("userName", edittext_email.getText().toString()); // used to get userinput for welcome screen
                        startActivity(next3);
                    }
                }

            } // eof public void onClick
        }); // eof loginButton on click
    } //eof onCreate


    public void register(View view){
        //will redirect user to registration page when web site is completed
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://buildingblockshr.ca/"));
        startActivity(browserIntent);
    }

} //eof loginActivity
