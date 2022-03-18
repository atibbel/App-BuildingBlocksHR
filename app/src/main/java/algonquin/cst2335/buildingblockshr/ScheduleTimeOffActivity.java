package algonquin.cst2335.buildingblockshr;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ScheduleTimeOffActivity extends AppCompatActivity {

    private EditText EditTextTo;
    private EditText EditTextSubject;
    private EditText EditTextMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule_time_off);
        //EditTextTo = findViewById(R.id.edit_text_to);
        EditTextSubject = findViewById(R.id.edit_text_subject);
        EditTextMessage = findViewById(R.id.edit_text_message);

        Button buttonSend = findViewById(R.id.button_send);
        buttonSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendMail();
            }
        });
    }

    private void sendMail() {
        String recipientList = EditTextTo.getText().toString();
        String[] recipients = recipientList.split(",");

        String subject = EditTextSubject.getText().toString();
        String message = EditTextMessage.getText().toString();

        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setData(Uri.parse("mailto:default@recipient.com"));
        //intent.putExtra(Intent.EXTRA_EMAIL, new String[]{"recipient@example.com"});
        intent.putExtra(Intent.EXTRA_SUBJECT, "Time off request: " + subject);
        intent.putExtra(Intent.EXTRA_TEXT, message);
        intent.setType("message/rfc822");
        try {
            startActivity(Intent.createChooser(intent, "Choose an email client"));
        } catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(ScheduleTimeOffActivity.this, "There are no email clients installed.", Toast.LENGTH_SHORT).show();
        }

    }
}