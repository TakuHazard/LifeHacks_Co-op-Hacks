package videodemos.example.systemshack2020.WebScraping;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

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

    private static void postingsNumber(final String responseBody) {
        Document doc = Jsoup.parse(responseBody);
        final String newPostingsSelector = ".table > tbody:nth-child(1) > tr:nth-child(4) > td:nth-child(1) > span:nth-child(1)";
        final String applicationsIn10DaysSelector = ".table > tbody:nth-child(1) > tr:nth-child(5) > td:nth-child(1) > span:nth-child(1)";
        Elements newPostingsValue = doc.select(newPostingsSelector);
        Elements applicationsIn10DaysValue = doc.select(applicationsIn10DaysSelector);

        System.out.println(newPostingsValue.text());
        System.out.println(applicationsIn10DaysValue.text());
    }
    public static void main(String[] args) {
        connectToSite("https://myexperience.sfu.ca/myAccount/dashboard.htm");
    }
}
