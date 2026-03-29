package net.mochinekoserver.unbillie_karotterbot.manager;

import javax.net.ssl.HttpsURLConnection;
import java.io.*;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class KarotterManager {

    private static final String API_POSTURL = "https://api.karotter.com/api/developer/posts";
    private static final String API_KEY = System.getenv("KAROTTER_BOT_TOKEN");

    public static String sendKarotter(String message) {
        try {
            URL url = new URL(API_POSTURL);
            HttpsURLConnection con = (HttpsURLConnection)url.openConnection();
            con.setRequestMethod("POST");
            con.setDoOutput(true);
            con.setDoInput(true);
            con.addRequestProperty("Authorization", "Bearer " + API_KEY);
            con.addRequestProperty("Content-Type", "application/json");
            con.connect();
            OutputStreamWriter os = new OutputStreamWriter(con.getOutputStream());
            os.write("{\"content\": \"" + message + "\",\"visibility\": \"PUBLIC\", \"replyRestriction\": \"EVERYONE\"}");
            os.close();

            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream(), StandardCharsets.UTF_8));
            StringBuilder content = new StringBuilder();

            String inputLine;
            while((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }

            in.close();
            con.disconnect();
            return content.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
