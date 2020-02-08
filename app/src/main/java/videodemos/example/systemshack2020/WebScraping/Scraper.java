package videodemos.example.systemshack2020.WebScraping;

import org.apache.commons.codec.binary.Base64;

import okhttp3.Call;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class Scraper {

    private static void connectToSite(final String url) {
        try {
//            Document doc = Jsoup.connect(url).get();
            String username = "Foo";
            String password = "Bar";
            String login = username + ":" + password;
            String base64login = new String(Base64.encodeBase64(login.getBytes()));

            OkHttpClient client = new OkHttpClient().newBuilder()
                    .build();
            MediaType mediaType = MediaType.parse(" application/x-www-form-urlencoded");
            RequestBody body = RequestBody.create(mediaType, "");
            Request request1 = new Request.Builder()
                    .url("https://myexperience.sfu.ca/myAccount/dashboard.htm")
                    .build();

            Call call = client.newCall(request1);
            Response response = call.execute();

            Request request = new Request.Builder()
                    .url("https://myexperience.sfu.ca/myAccount/dashboard.htm")
                    .method("POST", body)
                    .addHeader("Host", " myexperience.sfu.ca")
                    .addHeader("User-Agent", " Mozilla/5.0 (Macintosh; Intel Mac OS X 10.15; rv:72.0) Gecko/20100101 Firefox/72.0")
                    .addHeader("Accept", " text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8")
                    .addHeader("Accept-Language", " en-US,en;q=0.5")
                    .addHeader("Accept-Encoding", " gzip, deflate, br")
                    .addHeader("Content-Type", " application/x-www-form-urlencoded")
                    .addHeader("Content-Length", " 0")
                    .addHeader("Origin", " https://myexperience.sfu.ca")
                    .addHeader("Connection", " keep-alive")
                    .addHeader("Referer", " https://myexperience.sfu.ca/myAccount/dashboard.htm")
//                    .addHeader("Cookie", " _ga=GA1.2.824960987.1575794095; __utma=242477888.824960987.1575794095.1580770467.1581190050.5; __utmz=242477888.1580770467.4.4.utmcsr=google|utmccn=(organic)|utmcmd=organic|utmctr=(not%20provided); PS_DEVICEFEATURES=width:1280 height:800 pixelratio:2 touch:0 geolocation:1 websockets:1 webworkers:1 datepicker:1 dtpicker:0 timepicker:1 dnd:1 sessionstorage:1 localstorage:1 history:1 canvas:1 svg:1 postmessage:1 hc:0 maf:0; _gid=GA1.2.733464780.1580955507; JSESSIONID=1B31EFC609D0E17D878F458B3924C4BF; __utmc=242477888")
                    .addHeader("Upgrade-Insecure-Requests", " 1")
                    .addHeader("Authorization", "Basic eWNhMzE2QHNmdS5jYTpTQmRhbngyWDU=")
                    .build();
//            Response response = client.newCall(request).execute();
//
//            Response res = Jsoup
//                    .connect(url)
//                    .data("loginField", "login")
//                    .data("passwordField", "password")
//                    .method(Connection.Method.POST)
//                    .execute();
            System.out.println("tlskdjlkajflkdsa");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        connectToSite("https://myexperience.sfu.ca/myAccount/dashboard.htm");
    }
}
