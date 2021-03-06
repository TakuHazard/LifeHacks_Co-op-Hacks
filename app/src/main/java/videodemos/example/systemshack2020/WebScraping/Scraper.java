package videodemos.example.systemshack2020.WebScraping;


import android.os.StrictMode;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class Scraper {
    private static Elements newPostingsValue;
    private static Elements applicationsDueTodayValue;
    private static Elements applicationsIn10DaysValue;

    private static void connectToSite(final String url) {
        connectToSite(url, null, null);
    }

    private static void connectToSite(final String url, final String username, final String password) {
        try {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();

            StrictMode.setThreadPolicy(policy);
            OkHttpClient client = new OkHttpClient().newBuilder()
                    .build();
            MediaType mediaType = MediaType.parse(" application/x-www-form-urlencoded; charset=UTF-8");
            RequestBody body = RequestBody.create(mediaType, "action=_-_-1Q1C3Batv5QjS3XmMgOwCZtDkU93Dunf0DxTZAittBoVxMjCqBYRMyQiDhBeR0CFNWW0-MnokmjzdwFSOPrHjTR1rlXdhW8l6X-uyaimdbEunz3peJkk_g-_VFL3jQ1V5EYCP7HOuwvBu2h-pSTqjd1fzXDDb2ZO-GHY73dGxgPzwtQ2rcLXbZ9LrilM3HXOu8JjXqtP&filterByProgram=false&filterByAppQualifier=false&termIds=");
            Request request = new Request.Builder()
                    .url("https://myexperience.sfu.ca/myAccount/co-op/postings.htm")
                    .method("POST", body)
                    .addHeader("Host", " myexperience.sfu.ca")
                    .addHeader("Connection", " keep-alive")
                    .addHeader("Content-Length", " 269")
                    .addHeader("Accept", " text/html, */*; q=0.01")
                    .addHeader("X-Requested-With", " XMLHttpRequest")
                    .addHeader("User-Agent", " Mozilla/5.0 (Macintosh; Intel Mac OS X 10_14_6) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/79.0.3945.130 Safari/537.36")
                    .addHeader("Content-Type", " application/x-www-form-urlencoded; charset=UTF-8")
                    .addHeader("Origin", " https://myexperience.sfu.ca")
                    .addHeader("Connection", " keep-alive")
                    .addHeader("Referer", " https://myexperience.sfu.ca/myAccount/co-op/postings.htm")
                    .addHeader("Cookie", " _ga=GA1.2.824960987.1575794095; __utma=242477888.824960987.1575794095.1580770467.1581190050.5; __utmz=242477888.1580770467.4.4.utmcsr=google|utmccn=(organic)|utmcmd=organic|utmctr=(not%20provided); PS_DEVICEFEATURES=width:1280 height:800 pixelratio:2 touch:0 geolocation:1 websockets:1 webworkers:1 datepicker:1 dtpicker:0 timepicker:1 dnd:1 sessionstorage:1 localstorage:1 history:1 canvas:1 svg:1 postmessage:1 hc:0 maf:0; JSESSIONID=0A03D734703EED812C01F129777F4C09; __utmc=242477888")
                    .addHeader("Authorization", "Basic eWNhMzE2QHNmdS5jYTpTQmRhbngyWDU=")
                    .build();
            Response response = client.newCall(request).execute();
            final String responseBody = response.body().string();
            postingsNumber(responseBody);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void postingsNumber(final String responseBody) {
        Document doc = Jsoup.parse(responseBody);
        final String newPostingsSelector = ".table > tbody:nth-child(1) > tr:nth-child(4) > td:nth-child(1) > span:nth-child(1)";
        final String applicationsDueToday = ".table > tbody:nth-child(1) > tr:nth-child(6) > td:nth-child(1) > span:nth-child(1)";
        final String applicationsIn10DaysSelector = ".table > tbody:nth-child(1) > tr:nth-child(7) > td:nth-child(1) > span:nth-child(1)";
        newPostingsValue = doc.select(newPostingsSelector);
        applicationsDueTodayValue = doc.select(applicationsDueToday);
        applicationsIn10DaysValue = doc.select(applicationsIn10DaysSelector);

        System.out.println(newPostingsValue.text());
        System.out.println(applicationsDueTodayValue.text());
        System.out.println(applicationsIn10DaysValue.text());
    }

    public static void main(String[] args) {
        connectToSite("https://myexperience.sfu.ca/myAccount/co-op/postings.htm");
    }

    public String getNewPostingsValue() {
        return newPostingsValue.text();
    }

    public String getApplicationsDueTodayValue() {
        return applicationsDueTodayValue.text();
    }

    public String getapplicationsIn10DaysValue() {
        return applicationsIn10DaysValue.text();
    }

    public void setup(String url, String userName, String passWord) {
        connectToSite(url, userName, passWord);
    }
}
