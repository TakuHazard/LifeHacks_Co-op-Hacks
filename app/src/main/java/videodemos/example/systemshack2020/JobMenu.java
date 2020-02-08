package videodemos.example.systemshack2020;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import videodemos.example.systemshack2020.MenuActivity.ApplicationActivity;

public class JobMenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_job_menu);

        Toast.makeText(this, " Job Postings", Toast.LENGTH_LONG).show();

        goToMenuActivity(R.id.btnAppliedTo, ApplicationActivity.class);
        goToMenuActivity(R.id.btnNewPostings, ApplicationActivity.class);
        goToMenuActivity(R.id.btnDueDate, ApplicationActivity.class);
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

}
