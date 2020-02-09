package videodemos.example.systemshack2020.WebScraping;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class DeadlinesToday {

    private static Document doc;

    private static void connectToSite(final String url) {
        try {
            OkHttpClient client = new OkHttpClient().newBuilder()
                    .build();
            MediaType mediaType = MediaType.parse(" multipart/form-data; boundary=----WebKitFormBoundaryH1tJBVABkaGWnWlp");
            RequestBody body = RequestBody.create(mediaType, "------WebKitFormBoundaryH1tJBVABkaGWnWlp\r\nContent-Disposition: form-data; name=\"action\"\r\n\r\n_-_-G6DhJDHTfUTaPESAWleXwhHpG4sed4HXk48-huFyW0-qd-yZiYaAhVIjuKrRrx9hq4vT7Lti1vtK8HyxXf27UH3Grlfa3AR2n5YVzjKGcrGQop11jckKNrfyaRrKhWcRB9o-yfgtSXKb4i924B56XuzzvUYCrV8a9VgR5NYpLjm4aU0NiJCeL_g1ug\r\n------WebKitFormBoundaryH1tJBVABkaGWnWlp\r\nContent-Disposition: form-data; name=\"searchType\"\r\n\r\n\r\n------WebKitFormBoundaryH1tJBVABkaGWnWlp\r\nContent-Disposition: form-data; name=\"id\"\r\n\r\n\r\n------WebKitFormBoundaryH1tJBVABkaGWnWlp\r\nContent-Disposition: form-data; name=\"termIds\"\r\n\r\n\r\n------WebKitFormBoundaryH1tJBVABkaGWnWlp\r\nContent-Disposition: form-data; name=\"filterByProgram\"\r\n\r\nfalse\r\n------WebKitFormBoundaryH1tJBVABkaGWnWlp\r\nContent-Disposition: form-data; name=\"performNewSearch\"\r\n\r\ntrue\r\n------WebKitFormBoundaryH1tJBVABkaGWnWlp\r\nContent-Disposition: form-data; name=\"rand\"\r\n\r\n88817\r\n------WebKitFormBoundaryH1tJBVABkaGWnWlp--");
            Request request = new Request.Builder()
                    .url("https://myexperience.sfu.ca/myAccount/co-op/postings.htm")
                    .method("POST", body)
                    .addHeader("Host", " myexperience.sfu.ca")
                    .addHeader("Connection", " keep-alive")
                    .addHeader("Content-Length", " 917")
                    .addHeader("Cache-Control", " max-age=0")
                    .addHeader("Origin", " https://myexperience.sfu.ca")
                    .addHeader("Upgrade-Insecure-Requests", " 1")
                    .addHeader("Content-Type", " multipart/form-data; boundary=----WebKitFormBoundaryH1tJBVABkaGWnWlp")
                    .addHeader("User-Agent", " Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/79.0.3945.130 Safari/537.36")
                    .addHeader("Sec-Fetch-User", " ?1")
                    .addHeader("Accept", " text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.9")
                    .addHeader("Sec-Fetch-Site", " same-origin")
                    .addHeader("Sec-Fetch-Mode", " navigate")
                    .addHeader("Referer", " https://myexperience.sfu.ca/myAccount/co-op/postings.htm")
                    .addHeader("Accept-Encoding", " gzip, deflate, br")
                    .addHeader("Accept-Language", " en-US,en;q=0.9")
                    .addHeader("Cookie", " SignOnDefault=; HPTabName=SFU_STUDENT_CENTER; HPTabNameRemote=; LastActiveTab=SFU_STUDENT_CENTER; __utmc=242477888; _ga=GA1.2.1261917271.1560231175; PS_TokenSite=https://sims.sfu.ca/psp/csprd/?SIMS-PRD-PORTAL-PSJSESSIONID; __unam=6dca77a-16c3b10738f-7de4c66e-4; __gads=ID=3e50b325dda43392:T=1578519974:S=ALNI_MYtSVWGl4dTqpjp7uNBKmqTQGx5tA; connect.sid=s%3Ap8xx2huji7_f3J6Rzbnk0AjjGLqvkC2I.UgOgfxpe4OsPMUY2yTDS2p%2BaloAtXSGyzzKKJ0YQ1Ig; SIMS-PRD-PORTAL-PSJSESSIONID=gxf4TlCT7K0YINd7gOMkFUPZbElAFvU3!781653954; PS_LASTSITE=https://sims.sfu.ca/psp/csprd/; ExpirePage=https://sims.sfu.ca/psp/csprd/; PS_LOGINLIST=https://sims.sfu.ca/csprd; PS_TOKEN=oQAAAAQDAgEBAAAAvAIAAAAAAAAsAAAABABTaGRyAk4AbQg4AC4AMQAwABQc3oyoHTH3S07QewDf3/s6iq57OmEAAAAFAFNkYXRhVXicLYdJDkBQFATLEAsrFyH8T7A0BRuEOIYbOpwmXlLVry7A91zH0d4u30UtJzMTK422JRhYGAk7DjZ2enJDykssMtn+f0GizmVLLRtVKSoVD2YACy8=; ps_theme=node:SA portal:EMPLOYEE theme_id:SFU_THEME_TANGERINE_STUDENT css_f:SFU_FLUID_CSS accessibility:N formfactor:3 piamode:2; PS_DEVICEFEATURES=width:1280 height:720 pixelratio:1.5 touch:0 geolocation:1 websockets:1 webworkers:1 datepicker:1 dtpicker:1 timepicker:1 dnd:1 sessionstorage:1 localstorage:1 history:1 canvas:1 svg:1 postmessage:1 hc:0 maf:0; https%3a%2f%2fsims.sfu.ca%2fpsp%2fcsprd%2femployee%2fsa%2frefresh=list:%20%3Ftab%3Dremoteunifieddashboard%7C%3Frp%3Dremoteunifieddashboard%7C%7C%7C%7C%7C%7C%7C%7C%7C%7C%7C%7C%7C%7C%7C%7C%7C%7C%7C%7C%7C%7C%7C%7C%7C%7C%7C%7C%7C%7C; psback=%22%22url%22%3A%22https%3A%2F%2Fsims.sfu.ca%2Fpsp%2Fcsprd%2FEMPLOYEE%2FSA%2Fh%2F%3Ftab%3DSFU_STUDENT_CENTER%22%20%22label%22%3A%22Home%22%20%22origin%22%3A%22PIA%22%20%22layout%22%3A%220%22%20%22refurl%22%3A%22https%3A%2F%2Fsims.sfu.ca%2Fpsp%2Fcsprd%2FEMPLOYEE%2FSA%2Fh%2F%3Ftab%3DSFU_STUDENT_CENTER%22%22; PS_TOKENEXPIRE=30_Jan_2020_21:15:14_GMT; __utmz=242477888.1580705958.92.77.utmcsr=google|utmccn=(organic)|utmcmd=organic|utmctr=(not%20provided); __utma=242477888.1261917271.1560231175.1581190214.1581200819.94; JSESSIONID=2C18D8374CA0415507D481E972CC9D1A")
                    .build();
            Response response = client.newCall(request).execute();
            final String responseBody = response.body().string();
            doc = Jsoup.parse(responseBody);
            //System.out.println(doc.title());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        connectToSite("https://myexperience.sfu.ca/myAccount/dashboard.htm");
        updatePostings();
    }

    public static void updatePostings() {
        // get all postings
        Elements elements = doc.getElementsByClass("orgDivTitleMaxWidth");
        //Elements elements = doc.select("#postingsTable");
        //elements = elements.select("a[href]");
        int numOfJobs = elements.size();

        if (elements == null) {
            // ERROR message
        }

        // Printing out the job titles
        for (int i=0; i<numOfJobs; i++) {
            String jobName = elements.get(i).toString();
            //String jobName = elements.get(i);
            System.out.println(jobName);
            System.out.println();
        }
    }
}
