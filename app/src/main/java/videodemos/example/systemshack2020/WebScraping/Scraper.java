package videodemos.example.systemshack2020.WebScraping;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    public static Map<String, String> getPostings() {
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
            MediaType mediaType = MediaType.parse("multipart/form-data; boundary=---------------------------816887477617");
            RequestBody body = RequestBody.create(mediaType, "-----------------------------816887477617\r\nContent-Disposition: form-data; name=\"action\"\r\n\r\n_-_-NP8nKSdim8fQDQ5Nq_GJkG3grbs2nEDc3ip4Zp55K7gD9Uf0eW7jL-1RYea2wCleWOmaXqe5R2h8FUSFLt_9_4eiWGvH1Y7KMUwB0gPDAw2EV4Hgx9r0Ckv7iZLi_3LAUrfDvUPivhLmVo1-RnPd1j-b0NeyBPj1qh_fZq165A\r\n-----------------------------816887477617\r\nContent-Disposition: form-data; name=\"performNewSearch\"\r\n\r\ntrue\r\n-----------------------------816887477617\r\nContent-Disposition: form-data; name=\"cpFilterType\"\r\n\r\nnone\r\n-----------------------------816887477617\r\nContent-Disposition: form-data; name=\"rand\"\r\n\r\n73819\r\n-----------------------------816887477617--\r\n");
            Request request = new Request.Builder()
                    .url("https://myexperience.sfu.ca/myAccount/co-op/postings.htm")
                    .post(body)
                    .addHeader("Host", "myexperience.sfu.ca")
                    .addHeader("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:72.0) Gecko/20100101 Firefox/72.0")
                    .addHeader("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8")
                    .addHeader("Accept-Language", "en-CA,en-US;q=0.7,en;q=0.3")
                    .addHeader("Accept-Encoding", "gzip, deflate, br")
                    .addHeader("Referer", "https://myexperience.sfu.ca/myAccount/co-op/postings.htm")
                    .addHeader("Content-Type", "multipart/form-data; boundary=---------------------------816887477617")
                    .addHeader("Content-Length", "622")
                    .addHeader("Origin", "https://myexperience.sfu.ca")
                    .addHeader("Connection", "keep-alive")
                    .addHeader("Cookie", "JSESSIONID=00C65315F6D72B7F0D6115D2F1BE5A82; __utma=242477888.846549046.1581203039.1581203039.1581203039.1; __utmc=242477888; __utmz=242477888.1581203039.1.1.utmcsr=(direct)|utmccn=(direct)|utmcmd=(none), JSESSIONID=00C65315F6D72B7F0D6115D2F1BE5A82; __utma=242477888.846549046.1581203039.1581203039.1581203039.1; __utmc=242477888; __utmz=242477888.1581203039.1.1.utmcsr=(direct)|utmccn=(direct)|utmcmd=(none); JSESSIONID=045E28363629FD0460E1E807CE86302A")
                    .addHeader("Upgrade-Insecure-Requests", "1")
                    .addHeader("Cache-Control", "max-age=0")
                    .addHeader("Postman-Token", "faff256d-f597-4bb9-99b8-f950c0376611,c91da4b9-c8fd-4da1-8b28-58e3316cc22b")
                    .addHeader("cache-control", "no-cache")
                    .build();
            Response response = client.newCall(request).execute();
//            System.out.println(response.body().string());
            String htmlString = response.body().string();

            Document doc = Jsoup.parse(htmlString);
            Elements elements = doc.getElementsByClass("orgDivTitleMaxWidth");

            List<String> temp = new ArrayList<>();
            for (Element elem: elements) {
                String text = elem.text();
                if (temp.size() == 0) {
                    if (!ignore.contains(text)) {
                        temp.add(text);
                    }
                }
                else if (!ignore.contains(text) && !text.equals(temp.get(temp.size() - 1))) {
                    temp.add(text);
                }
            }

            Map<String, String> postings = new HashMap<String, String>();
            for (int i = 0; i < temp.size(); i += 2) {
                postings.put(temp.get(i), temp.get(i+1));
            }

            return postings;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }


    public static void main(String[] args) {
//        connectToSite("https://myexperience.sfu.ca/myAccount/dashboard.htm");
        getPostings();
    }
}
