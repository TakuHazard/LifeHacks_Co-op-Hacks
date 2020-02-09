package videodemos.example.systemshack2020;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import videodemos.example.systemshack2020.MenuActivity.ApplicationActivity;
import videodemos.example.systemshack2020.WebScraping.Scraper;

public class JobMenu extends AppCompatActivity {

    private static final String CHANNEL_ID = "POSTING_ID";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_job_menu);

        // Toast.makeText(this, " Job Postings", Toast.LENGTH_LONG).show();
        String url = "https://myexperience.sfu.ca/myAccount/co-op/postings.htm";
        createNotificationChannel();

        String username = getIntent().getStringExtra("USERNAME");
        String password = getIntent().getStringExtra("PASSWORD");

        Scraper scraper = new Scraper();
        scraper.setup(url, username, password);

        String newPostingsValue = scraper.getNewPostingsValue();
        String applicationsDueTodayValue = scraper.getApplicationsDueTodayValue();
        String applicationsIn10DaysValue = scraper.getapplicationsIn10DaysValue();

        goToMenuActivity(R.id.btnAppliedTo, ApplicationActivity.class);
        setUpNumbers(R.id.btnAppliedTo, applicationsIn10DaysValue);
        goToMenuActivity(R.id.btnNewPostings, ApplicationActivity.class);
        setUpNumbers(R.id.btnNewPostings, newPostingsValue);
        goToMenuActivity(R.id.btnDueDate, ApplicationActivity.class);
        setUpNumbers(R.id.btnDueDate, applicationsDueTodayValue);

        NotificationManager nm = (NotificationManager) this.getSystemService(Context.NOTIFICATION_SERVICE);
        if (nm != null) {
            if (Integer.parseInt(applicationsDueTodayValue) > 0) {
                final NotificationCompat.Builder builder = new NotificationCompat.Builder(this, CHANNEL_ID)
                        .setSmallIcon(R.drawable.baseline_notifications_24)
                        .setContentTitle("Applications Due Today")
                        .setContentText("There are " + applicationsDueTodayValue + " applications due today!")
                        .setPriority(NotificationCompat.PRIORITY_DEFAULT);

                nm.notify(1, builder.build());
            }
        }
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

    private void setUpNumbers(final int activityId, String text) {
        final Button btn = findViewById(activityId);
        btn.setText(text);
    }

    private void createNotificationChannel() {
        // Create the NotificationChannel, but only on API 26+ because
        // the NotificationChannel class is new and not in the support library
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            CharSequence name = "Application due today";
            String description = "Application due today";
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channel = new NotificationChannel(CHANNEL_ID, name, importance);
            channel.setDescription(description);
            // Register the channel with the system; you can't change the importance
            // or other notification behaviors after this
            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
        }
    }
}
