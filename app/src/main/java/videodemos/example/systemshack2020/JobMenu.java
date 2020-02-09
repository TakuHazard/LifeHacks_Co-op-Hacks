package videodemos.example.systemshack2020;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import videodemos.example.systemshack2020.MenuActivity.ApplicationActivity;
import videodemos.example.systemshack2020.Postings.AllPostingsActivity;

public class JobMenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_job_menu);

        // Toast.makeText(this, " Job Postings", Toast.LENGTH_LONG).show();
        String url = "https://cas.sfu.ca/cas/login?message=Welcome+to+SFU+myExperience.%20Please+login+with+your+SFU+computing+ID.&allow=student," +
                "alumni&renew=true&service=https://myexperience.sfu.ca/sfuLogin.htm%3Faction%3Dlogin";


        String username = getIntent().getStringExtra("USERNAME");
        String password = getIntent().getStringExtra("PASSWORD");


        goToMenuActivity(R.id.btnAppliedTo, ApplicationActivity.class);
        goToMenuActivity(R.id.btnNewPostings, ApplicationActivity.class);
        goToMenuActivity(R.id.btnDueDate, ApplicationActivity.class);

        setUpAllPostingsBtn();
    }

    private void goToMenuActivity(final int activityId, final Class activityClass) {
        final Button newPostingsButton = findViewById(activityId);
        newPostingsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Intent intent = new Intent(view.getContext(), activityClass);
                view.getContext().startActivity(intent);
            }
        });
    }

    private void setUpAllPostingsBtn() {
        Button btn = (Button) findViewById(R.id.btnAllPostings);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent allPostingsIntent = new Intent(JobMenu.this, AllPostingsActivity.class);
                Toast.makeText(JobMenu.this, "Button clicked", Toast.LENGTH_SHORT).show();
                startActivity(allPostingsIntent);
            }
        });
    }

}
