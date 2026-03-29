package net.mochinekoserver.unbillie_karotterbot.manager;

import net.mochinekoserver.unbillie_karotterbot.Main;

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
            HttpsURLConnection connection = (HttpsURLConnection)url.openConnection();
            connection.setRequestMethod("POST");
            connection.setDoOutput(true);
            connection.setDoInput(true);
            connection.addRequestProperty("Authorization", "Bearer " + API_KEY);
            connection.addRequestProperty("Content-Type", "application/json");
            connection.connect();
            OutputStreamWriter os = new OutputStreamWriter(connection.getOutputStream());
            os.write("{\"content\": \"" + message + "\",\"visibility\": \"PUBLIC\", \"replyRestriction\": \"EVERYONE\"}");
            os.close();

            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream(), StandardCharsets.UTF_8));
            StringBuilder content = new StringBuilder();

            String inputLine;
            while((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }

            in.close();
            connection.disconnect();
            Main.BOT_LOGGER.info("Karotterに正常に送信されました。");
            Main.BOT_LOGGER.info("status:" + connection.getResponseCode() + "result:" + content.toString());
            return content.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
