package videodemos.example.systemshack2020;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        setUpSubmitButton();

    }

    private void setUpSubmitButton() {
        Button btn = (Button) findViewById(R.id.submitButton);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(LoginActivity.this, "login button clicked", Toast.LENGTH_SHORT).show();

                Intent jobmenu_intent = new Intent(LoginActivity.this, JobMenu.class);
                startActivity(jobmenu_intent);
            }
        });
    }
}
