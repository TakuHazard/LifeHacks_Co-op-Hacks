package videodemos.example.systemshack2020;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

public class JobMenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_job_menu);

        Toast.makeText(this," Job Postings", Toast.LENGTH_LONG).show();
    }
}
