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
            RequestBody body = RequestBody.create(mediaType, "action=_-_-uJT1-XDLpf5-Taqg7CdB1YOziYaCENgiGtRp6T0kb7bhm5Z1xmIqgq06IHLKo98JmZ7TRDevu7dixeAlZZ96iU8Bz5X-0itcpHCXMDsUSAmCEUbFXVsjq0DVy1VHBrqjsEzT0NoYHauTQkcCtdtVaVjxhWYUMJ-lO__f0kyqYblQSVvKBfML_GkDaoGwwZ74F4Qkreps&filterByProgram=false&filterByAppQualifier=false&termIds=");
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
                    .addHeader("Sec-Fetch-Site", " same-origin")
                    .addHeader("Sec-Fetch-Mode", " cors")
                    .addHeader("Referer", " https://myexperience.sfu.ca/myAccount/career/postings.htm")
                    .addHeader("Accept-Encoding", " gzip, deflate, br")
                    .addHeader("Accept-Language", " en-GB,en-US;q=0.9,en;q=0.8")
                    .addHeader("Cookie", " _ga=GA1.2.214377502.1579231293; __unam=6dca77a-16fe83dfe17-6dcb2ea7-2; _gid=GA1.2.1660404562.1581053259; __utmc=242477888; __utma=242477888.214377502.1579231293.1581202318.1581207458.54; __utmz=242477888.1581207458.54.52.utmcsr=google|utmccn=(organic)|utmcmd=organic|utmctr=(not%20provided); JSESSIONID=9A1699C37F4CD1548B56E4A6CE5D2DED")
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
