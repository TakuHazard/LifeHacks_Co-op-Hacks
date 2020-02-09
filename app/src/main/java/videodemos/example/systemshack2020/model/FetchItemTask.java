package videodemos.example.systemshack2020.model;

import android.os.AsyncTask;
import android.widget.Toast;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

import videodemos.example.systemshack2020.R;

import static android.provider.Settings.System.getString;

public class FetchItemTask extends AsyncTask<String, Integer, String> {

    @Override
    protected String doInBackground(String... params) {
        try {
            String[] user = params[0].split(".",2);
            String username = user[0];
            String password = user[1];

            Connection.Response loginForm = Jsoup.connect(
                    "https://cas.sfu.ca/cas/login?message=Welcome+to+SFU+myExperience.%20Please+login+with+your+SFU+computing+ID.&allow=student,alumni&renew=true&service=https://myexperience.sfu.ca/sfuLogin.htm%3Faction%3Dlogin")
                    .method(Connection.Method.GET)
                    .timeout(10000)
                    .execute();

            Document doc = loginForm.parse();
            String ltValue = doc.select("input[name=lt]").attr("value");
            String executionValue = doc.select("input[name=execution]").attr("value");

            doc = Jsoup.connect("https://cas.sfu.ca/cas/login?message=Welcome+to+SFU+myExperience.%20Please+login+with+your+SFU+computing+ID.&allow=student,alumni&renew=true&service=https://myexperience.sfu.ca/sfuLogin.htm%3Faction%3Dlogin")
                    .data("username", username)
                    .data("password", password)
                    .data("lt", ltValue)
                    .data("execution", executionValue)
                    .data("_eventId", "submit")
                    .data("submit", "Log in")
                    .cookies(loginForm.cookies())
                    .post();
            System.out.println("----------------------------------------------------------");

            // Welcome message if success
            String mWelcomeMessage = doc.select("div[class=span8]").html();
            System.out.println("--------------------"+ mWelcomeMessage +"--------------------");
            if (mWelcomeMessage.length() > 0) {
                // This shortens the contents of Pipeline's #welcome div-tag to display only
                // the user’s name
                mWelcomeMessage = mWelcomeMessage.substring(8, mWelcomeMessage.length() - 67);
                System.out.println("LOGIN OK LOGIN OK LOGIN OK LOGIN OK LOGIN OK LOGIN OK");
            } else {
                // This displays if the user was unable to log in successfully
                // mWelcomeMessage = getString(R.string.login_failed);
                System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return "Goodbye";
    }

}
