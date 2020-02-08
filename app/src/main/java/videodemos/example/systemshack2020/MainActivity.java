package videodemos.example.systemshack2020;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent jobmenu_intent = new Intent(MainActivity.this,JobMenu.class);
        startActivity(jobmenu_intent);
    }
}
