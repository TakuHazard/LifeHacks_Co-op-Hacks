package videodemos.example.systemshack2020.WebScraping;


import android.os.StrictMode;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.jsoup.select.Elements;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import videodemos.example.systemshack2020.Model.Posting;

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
            OkHttpClient client = new OkHttpClient();

            MediaType mediaType = MediaType.parse("application/x-www-form-urlencoded; charset=UTF-8");
            RequestBody body = RequestBody.create(mediaType, "action=_-_-5Tlj7rIosBZPXMQEEJiQssROr46M0P2oOccxiXjQeNvD7YODHB2hW2aHAzcvoK5TmUd1Og0yI_9-aQBvhrSv1WcD4dIGH2t2yxE1hrYobTNUpV-OJxsfv2f43V03m3b8-FkSFq2rLkCkCkySGBGL3AcJdYZVTRgQSrKOwA-YJRZ2rtT9Mabd253jVsMwpyGg9KMIinCu&filterByProgram=false&filterByAppQualifier=false&termIds=");
            Request request = new Request.Builder()
                    .url("https://myexperience.sfu.ca/myAccount/co-op/postings.htm")
                    .post(body)
                    .addHeader("Host", "myexperience.sfu.ca")
                    .addHeader("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:72.0) Gecko/20100101 Firefox/72.0")
                    .addHeader("Accept", "text/html, */*; q=0.01")
                    .addHeader("Accept-Language", "en-CA,en-US;q=0.7,en;q=0.3")
                    .addHeader("Accept-Encoding", "gzip, deflate, br")
                    .addHeader("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8")
                    .addHeader("X-Requested-With", "XMLHttpRequest")
                    .addHeader("Content-Length", "269")
                    .addHeader("Origin", "https://myexperience.sfu.ca")
                    .addHeader("Connection", "keep-alive")
                    .addHeader("Referer", "https://myexperience.sfu.ca/myAccount/co-op/postings.htm")
                    .addHeader("Cookie", "JSESSIONID=5B7922013421892FD82B8CA1472F93EC; __utma=242477888.846549046.1581203039.1581203039.1581203039.1; __utmc=242477888; __utmz=242477888.1581203039.1.1.utmcsr=(direct)|utmccn=(direct)|utmcmd=(none), JSESSIONID=5B7922013421892FD82B8CA1472F93EC; __utma=242477888.846549046.1581203039.1581203039.1581203039.1; __utmc=242477888; __utmz=242477888.1581203039.1.1.utmcsr=(direct)|utmccn=(direct)|utmcmd=(none); JSESSIONID=045E28363629FD0460E1E807CE86302A")
                    .addHeader("Authorization", "Basic Y2xhMzQ1Om9tZ2loYXRldGhpc3NoaXQ=")
                    .addHeader("Cache-Control", "no-cache")
                    .addHeader("Postman-Token", "bc9d0d84-6b75-4954-a238-42d38e583edc,9895a45f-b701-4f9a-b22b-f4d355ad4d56")
                    .addHeader("cache-control", "no-cache")
                    .build();

            Response response = client.newCall(request).execute();
            final String responseBody = response.body().string();
            postingsNumber(responseBody);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<Posting> getPostings() {
        String jobTitle = "Job Title";
        String organization = "Organization";
        String division = "Division";
        List<String> ignore = new ArrayList<String>();
        ignore.add(jobTitle);
        ignore.add(organization);
        ignore.add(division);

        try {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();

            StrictMode.setThreadPolicy(policy);
            OkHttpClient client = new OkHttpClient().newBuilder()
                    .build();
            MediaType mediaType = MediaType.parse("multipart/form-data; boundary=---------------------------186381992520782");
            RequestBody body = RequestBody.create(mediaType, "-----------------------------186381992520782\r\nContent-Disposition: form-data; name=\"action\"\r\n\r\n_-_-01LkUTByi5ut1MIIBc1MV_2-73_ZxmkkoeXSBC8caE5jAhOHb9xIZ55-JJVYjBcb4R8Oe4Bxhiix2ce2Kj2UjP0H4HQ-LfZnZ_u5LFpyMLUqCmf9ncqa9V_wlSTao8CCHHxF5GpaWmGA115-qycHgL_0KRtL7RqoZ1vCoAFS2Q\r\n-----------------------------186381992520782\r\nContent-Disposition: form-data; name=\"performNewSearch\"\r\n\r\ntrue\r\n-----------------------------186381992520782\r\nContent-Disposition: form-data; name=\"cpFilterType\"\r\n\r\nnone\r\n-----------------------------186381992520782\r\nContent-Disposition: form-data; name=\"rand\"\r\n\r\n6460\r\n-----------------------------186381992520782--\r\n");
            Request request = new Request.Builder()
                    .url("https://myexperience.sfu.ca/myAccount/co-op/postings.htm")
                    .post(body)
                    .addHeader("Host", "myexperience.sfu.ca")
                    .addHeader("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:72.0) Gecko/20100101 Firefox/72.0")
                    .addHeader("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8")
                    .addHeader("Accept-Language", "en-CA,en-US;q=0.7,en;q=0.3")
                    .addHeader("Accept-Encoding", "gzip, deflate, br")
                    .addHeader("Content-Type", "multipart/form-data; boundary=---------------------------186381992520782")
                    .addHeader("Content-Length", "636")
                    .addHeader("Origin", "https://myexperience.sfu.ca")
                    .addHeader("Connection", "keep-alive")
                    .addHeader("Referer", "https://myexperience.sfu.ca/myAccount/co-op/postings.htm")
                    .addHeader("Cookie", "JSESSIONID=5B7922013421892FD82B8CA1472F93EC; __utma=242477888.846549046.1581203039.1581203039.1581203039.1; __utmc=242477888; __utmz=242477888.1581203039.1.1.utmcsr=(direct)|utmccn=(direct)|utmcmd=(none), JSESSIONID=5B7922013421892FD82B8CA1472F93EC; __utma=242477888.846549046.1581203039.1581203039.1581203039.1; __utmc=242477888; __utmz=242477888.1581203039.1.1.utmcsr=(direct)|utmccn=(direct)|utmcmd=(none); JSESSIONID=045E28363629FD0460E1E807CE86302A")
                    .addHeader("Upgrade-Insecure-Requests", "1")
                    .addHeader("Postman-Token", "032330ba-75a4-4290-88ec-f50b382a13b6,7903d656-f095-4b0a-a511-ec9c623378eb")
                    .addHeader("cache-control", "no-cache")
                    .build();
            Response response = client.newCall(request).execute();
            String htmlString = response.body().string();
            Document doc = Jsoup.parse(htmlString);

            ArrayList<Posting> postings = new ArrayList<>();
            Elements table = doc.getElementsByClass("table table-striped table-bordered table-hover gridTable");
            Elements rows = table.select("tr");
            for (int i = 1; i < rows.size(); i++) { //first row is the col names so skip it.
                Element row = rows.get(i);
                Elements cols = row.select("td");

                Posting newPosting = new Posting();
                newPosting.setApplicationStatus(cols.get(1).text());
                newPosting.setTags(cols.get(2).text());
                newPosting.setTerm(cols.get(3).text());
                newPosting.setId(cols.get(4).text());
                newPosting.setJobTitle(cols.get(5).text());
                newPosting.setOrganization(cols.get(6).text());
                newPosting.setDivision(cols.get(7).text());
                newPosting.setPositionType(cols.get(8).text());
                newPosting.setOpenings(cols.get(9).text());
                newPosting.setInternalStatus(cols.get(10).text());
                newPosting.setLocation(cols.get(11).text());
                newPosting.setAppDeadline(cols.get(12).text());

                postings.add(newPosting);
            }
            System.out.println(postings.size());

            return postings;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
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
        getPostings();
        connectToSite("https://myexperience.sfu.ca/myAccount/co-op/postings.htm");
    }

    public String getNewPostingsValue() {
        if (newPostingsValue == null) {
            return "";
        }
        else {
            return newPostingsValue.text();
        }
    }

    public String getApplicationsDueTodayValue() {
        if (applicationsDueTodayValue == null) {
            return "";
        }
        else {
            return applicationsDueTodayValue.text();
        }
    }

    public String getapplicationsIn10DaysValue() {
        if (applicationsIn10DaysValue == null) {
            return "";
        }
        else {
            return applicationsIn10DaysValue.text();
        }
    }

    public void setup(String url, String userName, String passWord) {
        connectToSite(url, userName, passWord);
    }
}
