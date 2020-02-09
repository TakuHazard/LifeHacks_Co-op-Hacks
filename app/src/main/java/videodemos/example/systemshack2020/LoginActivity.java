package videodemos.example.systemshack2020;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

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
                //Toast.makeText(LoginActivity.this, "login button clicked", Toast.LENGTH_SHORT).show();

                EditText usernameView = (EditText) findViewById(R.id.username);

                EditText passwordView = (EditText) findViewById(R.id.password);

                final String username = usernameView.getText().toString();
                final String password = passwordView.getText().toString();
                Intent jobmenu_intent = new Intent(LoginActivity.this, JobMenu.class);

                jobmenu_intent.putExtra("USERNAME", username);
                jobmenu_intent.putExtra("PASSWORD", password);


                startActivity(jobmenu_intent);
            }
        });
    }
}
