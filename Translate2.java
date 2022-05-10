import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.io.BufferedReader;
import java.util.Scanner;
import javax.swing.*;

public class Translate2 {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        String text = sc.next();
        System.out.println("Translated text: " + translate("en", "de", text));
    }

    private static String translate(String langFrom, String langTo, String text) throws IOException {
        String urlStr = "https://script.google.com/macros/s/AKfycbzoj2X4Xav3CawDQYo57pY-lEUH20aU6r8JxtiIGl6H4BrEzjw/exec" +
                "?q=" + URLEncoder.encode(text, "UTF-8") +
                "&target=" + langTo +
                "&source=" + langFrom;
        URL url = new URL(urlStr);
        StringBuilder response = new StringBuilder();
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestProperty("User-Agent", "Mozilla/5.0");
        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String inputLine;
        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();
        return response.toString();
    }

}