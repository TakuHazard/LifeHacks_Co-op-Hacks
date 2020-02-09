package videodemos.example.systemshack2020.WebScraping;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

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
            MediaType mediaType = MediaType.parse(" application/x-www-form-urlencoded");
            RequestBody body = RequestBody.create(mediaType, "-----------------------------5754573831593373640709689390\nContent-Disposition: form-data; name=\"action\"\n\n_-_-kv-PcE1oNfyamPhBO8syTdBkwhJ7JEiz8J0wKskNb-sUQzYBmJHeS-0LHdy7zK0PJULMpcWyhCONEXNupf9z3avPkskPHQ5jJteCpPLNi4Sj8TGjQnyupTV2B5LmKTt36IXqvDWjcdaYR9sEPwGMV4KVeUsmI9lcTg28_JoroAI8fA\n-----------------------------5754573831593373640709689390\nContent-Disposition: form-data; name=\"searchType\"\n\n\n-----------------------------5754573831593373640709689390\nContent-Disposition: form-data; name=\"id\"\n\n\n-----------------------------5754573831593373640709689390\nContent-Disposition: form-data; name=\"termIds\"\n\n\n-----------------------------5754573831593373640709689390\nContent-Disposition: form-data; name=\"filterByProgram\"\n\nfalse\n-----------------------------5754573831593373640709689390\nContent-Disposition: form-data; name=\"performNewSearch\"\n\ntrue\n-----------------------------5754573831593373640709689390\nContent-Disposition: form-data; name=\"rand\"\n\n3406\n-----------------------------5754573831593373640709689390--\n");
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
                    .addHeader("Cookie", " _ga=GA1.2.824960987.1575794095; __utma=242477888.824960987.1575794095.1580770467.1581190050.5; __utmz=242477888.1580770467.4.4.utmcsr=google|utmccn=(organic)|utmcmd=organic|utmctr=(not%20provided); PS_DEVICEFEATURES=width:1280 height:800 pixelratio:2 touch:0 geolocation:1 websockets:1 webworkers:1 datepicker:1 dtpicker:0 timepicker:1 dnd:1 sessionstorage:1 localstorage:1 history:1 canvas:1 svg:1 postmessage:1 hc:0 maf:0; JSESSIONID=AD8FF3F912344111E43D0B68DF27B786; __utmc=242477888")
                    .addHeader("Upgrade-Insecure-Requests", " 1")
                    .addHeader("Authorization", "Basic eWNhMzE2QHNmdS5jYTpTQmRhbngyWDU=")
                    .build();
            Response response = client.newCall(request).execute();
            final String responseBody = response.body().string();
            Document doc = Jsoup.parse(responseBody);
            System.out.println(doc.title());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        connectToSite("https://myexperience.sfu.ca/myAccount/dashboard.htm");
    }
}

