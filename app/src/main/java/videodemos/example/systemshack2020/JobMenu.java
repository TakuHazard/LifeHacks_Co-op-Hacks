package videodemos.example.systemshack2020;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

import videodemos.example.systemshack2020.MenuActivity.ApplicationActivity;
import videodemos.example.systemshack2020.Model.Posting;
import videodemos.example.systemshack2020.Postings.AllPostingsActivity;
import videodemos.example.systemshack2020.WebScraping.Scraper;

public class JobMenu extends AppCompatActivity {
    ArrayList<Posting> postings = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_job_menu);

        // Toast.makeText(this, " Job Postings", Toast.LENGTH_LONG).show();
        String url = "https://myexperience.sfu.ca/myAccount/co-op/postings.htm";


        String username = getIntent().getStringExtra("USERNAME");
        String password = getIntent().getStringExtra("PASSWORD");

        Scraper scraper = new Scraper();
        scraper.setup(url, username, password);


        String newPostingsValue = scraper.getNewPostingsValue();
        String applicationsDueTodayValue = scraper.getApplicationsDueTodayValue();
        String applicationsIn10DaysValue = scraper.getapplicationsIn10DaysValue();

        postings = scraper.getPostings();

        goToMenuActivity(R.id.btnAppliedTo, ApplicationActivity.class);
        setUpNumbers(R.id.btnAppliedTo, applicationsIn10DaysValue);
        goToMenuActivity(R.id.btnNewPostings, ApplicationActivity.class);
        setUpNumbers(R.id.btnNewPostings, newPostingsValue);
        goToMenuActivity(R.id.btnDueDate, ApplicationActivity.class);
        setUpNumbers(R.id.btnDueDate, applicationsDueTodayValue);

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
                allPostingsIntent.putExtra("Postings", postings);
                startActivity(allPostingsIntent);
            }
        });
    }

    private void setUpNumbers(final int activityId, String text) {
        final Button btn = findViewById(activityId);
        btn.setText(text);
    }

}
