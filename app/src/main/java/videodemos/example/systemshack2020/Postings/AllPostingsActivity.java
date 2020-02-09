package videodemos.example.systemshack2020.Postings;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

import videodemos.example.systemshack2020.Model.Posting;
import videodemos.example.systemshack2020.R;

public class AllPostingsActivity extends AppCompatActivity {
    private List<String> postingHeaders;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_postings);

        List<Posting> postingsList = (ArrayList<Posting>) getIntent().getSerializableExtra("Postings");
        postingHeaders = getPostingHeads(postingsList);

        setUpListView();
    }

    private void setUpListView () {
        // setup clickable patient list
        ArrayAdapter adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, postingHeaders);
        ListView listView = findViewById(R.id.postings_list);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
            }
        });
    }

    private List<String> getPostingHeads(List<Posting> postings) {
        List<String> res = new ArrayList<>();
        for (Posting posting : postings) {
            res.add(posting.getJobTitle() + " - " + posting.getOrganization());
        }
        return res;
    }
}
