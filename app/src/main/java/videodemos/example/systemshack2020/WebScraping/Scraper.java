package videodemos.example.systemshack2020.WebScraping;


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
    private static void connectToSite(final String url) {
        try {
            OkHttpClient client = new OkHttpClient().newBuilder()
                    .build();
            MediaType mediaType = MediaType.parse(" application/x-www-form-urlencoded; charset=UTF-8");
            RequestBody body = RequestBody.create(mediaType, "action=_-_-FPKUQmHnOooTImKGqhRkZonqpz6Br0NRjtJFoUSIYH-rW71K1CZoXTeWw2wyhifsjzp4F4c_s_2IrlF6wKUsWzLI2j782RwT04VM2uiijOl1kZXQXbjDC7oSN3FwQbkQ9sDmubgX6cx-OF5V45GV_rjd4DAkY0vmELlYuvngG2DOZ6wdBOkJ0EjXfYitWv8M4SLiW2W_&filterByProgram=false&filterByAppQualifier=false&termIds=");
            Request request = new Request.Builder()
                    .url("https://myexperience.sfu.ca/myAccount/co-op/postings.htm")
                    .method("POST", body)
                    .addHeader("Host", " myexperience.sfu.ca")
                    .addHeader("User-Agent", " Mozilla/5.0 (Macintosh; Intel Mac OS X 10.15; rv:72.0) Gecko/20100101 Firefox/72.0")
                    .addHeader("Accept", " text/html, */*; q=0.01")
                    .addHeader("Accept-Language", " en-US,en;q=0.5")
                    .addHeader("Accept-Encoding", " gzip, deflate, br")
                    .addHeader("Content-Type", " application/x-www-form-urlencoded; charset=UTF-8")
                    .addHeader("X-Requested-With", " XMLHttpRequest")
                    .addHeader("Content-Length", " 269")
                    .addHeader("Origin", " https://myexperience.sfu.ca")
                    .addHeader("Connection", " keep-alive")
                    .addHeader("Referer", " https://myexperience.sfu.ca/myAccount/co-op/postings.htm")
                    .addHeader("Cookie", " _ga=GA1.2.824960987.1575794095; __utma=242477888.824960987.1575794095.1580770467.1581190050.5; __utmz=242477888.1580770467.4.4.utmcsr=google|utmccn=(organic)|utmcmd=organic|utmctr=(not%20provided); PS_DEVICEFEATURES=width:1280 height:800 pixelratio:2 touch:0 geolocation:1 websockets:1 webworkers:1 datepicker:1 dtpicker:0 timepicker:1 dnd:1 sessionstorage:1 localstorage:1 history:1 canvas:1 svg:1 postmessage:1 hc:0 maf:0; JSESSIONID=AD8FF3F912344111E43D0B68DF27B786; __utmc=242477888")
                    .addHeader("Authorization", "Basic eWNhMzE2QHNmdS5jYTpTQmRhbngyWDU=")
                    .build();
            Response response = client.newCall(request).execute();
            final String responseBody = response.body().string();
            postingsNumber(responseBody);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static List<Posting> getPostings() {
        String jobTitle = "Job Title";
        String organization = "Organization";
        String division = "Division";
        List<String> ignore = new ArrayList<String>();
        ignore.add(jobTitle);
        ignore.add(organization);
        ignore.add(division);

        try {
            OkHttpClient client = new OkHttpClient().newBuilder()
                    .build();
            MediaType mediaType = MediaType.parse("multipart/form-data; boundary=---------------------------2898415012228");
            RequestBody body = RequestBody.create(mediaType, "-----------------------------2898415012228\r\nContent-Disposition: form-data; name=\"action\"\r\n\r\n_-_-6wlBpIT-89sVFJeqXm6M4I0xgsEmhgZNmXRIH_zs-n2T_47FxMx-MnVvfGwDfvDS2O9XUXiHqqH5l_EgmjAjwkz5E9xzOesw1nyPrnSfofpju8W_n3ke6IIgA2Kd7JViVFBFAZTR8LQxP1YRqeMzeDuVEzWgGHvCQm3U0H3quw\r\n-----------------------------2898415012228\r\nContent-Disposition: form-data; name=\"performNewSearch\"\r\n\r\ntrue\r\n-----------------------------2898415012228\r\nContent-Disposition: form-data; name=\"cpFilterType\"\r\n\r\nnone\r\n-----------------------------2898415012228\r\nContent-Disposition: form-data; name=\"rand\"\r\n\r\n97808\r\n-----------------------------2898415012228--\r\n");
            Request request = new Request.Builder()
                    .url("https://myexperience.sfu.ca/myAccount/co-op/postings.htm")
                    .post(body)
                    .addHeader("Host", "myexperience.sfu.ca")
                    .addHeader("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:72.0) Gecko/20100101 Firefox/72.0")
                    .addHeader("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8")
                    .addHeader("Accept-Language", "en-CA,en-US;q=0.7,en;q=0.3")
                    .addHeader("Accept-Encoding", "gzip, deflate, br")
                    .addHeader("Referer", "https://myexperience.sfu.ca/myAccount/co-op/postings.htm")
                    .addHeader("Content-Type", "multipart/form-data; boundary=---------------------------2898415012228")
                    .addHeader("Content-Length", "627")
                    .addHeader("Origin", "https://myexperience.sfu.ca")
                    .addHeader("Connection", "keep-alive")
                    .addHeader("Cookie", "JSESSIONID=5B7922013421892FD82B8CA1472F93EC; __utma=242477888.846549046.1581203039.1581203039.1581203039.1; __utmc=242477888; __utmz=242477888.1581203039.1.1.utmcsr=(direct)|utmccn=(direct)|utmcmd=(none), JSESSIONID=5B7922013421892FD82B8CA1472F93EC; __utma=242477888.846549046.1581203039.1581203039.1581203039.1; __utmc=242477888; __utmz=242477888.1581203039.1.1.utmcsr=(direct)|utmccn=(direct)|utmcmd=(none); JSESSIONID=045E28363629FD0460E1E807CE86302A")
                    .addHeader("Upgrade-Insecure-Requests", "1")
                    .addHeader("Cache-Control", "max-age=0")
                    .addHeader("Postman-Token", "2b241874-ed32-4a0d-9ff9-bcade8c9a5c2,9f5ce3f9-8fe9-4557-a239-92691e013f98")
                    .addHeader("cache-control", "no-cache")
                    .build();
            Response response = client.newCall(request).execute();
            String htmlString = response.body().string();
            Document doc = Jsoup.parse(htmlString);

            List<Posting> postings = new ArrayList<>();
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
        Elements newPostingsValue = doc.select(newPostingsSelector);
        Elements applicationsDueTodayValue = doc.select(applicationsDueToday);
        Elements applicationsIn10DaysValue = doc.select(applicationsIn10DaysSelector);

        System.out.println(newPostingsValue.text());
        System.out.println(applicationsDueTodayValue.text());
        System.out.println(applicationsIn10DaysValue.text());
    }
    public static void main(String[] args) {
//        connectToSite("https://myexperience.sfu.ca/myAccount/dashboard.htm");
        getPostings();
    }
}
