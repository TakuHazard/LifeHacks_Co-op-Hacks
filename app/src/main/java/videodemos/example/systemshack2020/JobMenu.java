package videodemos.example.systemshack2020;

import androidx.appcompat.app.AppCompatActivity;
import videodemos.example.systemshack2020.MenuActivity.JobPostingActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import videodemos.example.systemshack2020.MenuActivity.ApplicationActivity;
import videodemos.example.systemshack2020.MenuActivity.AppliedToPostings;

public class JobMenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_job_menu);

        Toast.makeText(this, " Job Postings", Toast.LENGTH_LONG).show();

        goToNewPostings();
        Button appliedPostings = (Button) findViewById(R.id.btnAppliedTo);
        appliedPostings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent applied_to = new Intent(JobMenu.this, AppliedToPostings.class);
                startActivity(applied_to);
            }
        });

        Button dueDate = (Button) findViewById(R.id.btnDueDate);
        dueDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent due_date_activity = new Intent(JobMenu.this, ApplicationActivity.class);
                startActivity(due_date_activity);
            }
        });
    }

    private void goToNewPostings() {
        final Button newPostingsButton = findViewById(R.id.btnNewPostings);
        newPostingsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Intent intent = new Intent(view.getContext(), JobPostingActivity.class);
                view.getContext().startActivity(intent);
            }
        });
    }
}
