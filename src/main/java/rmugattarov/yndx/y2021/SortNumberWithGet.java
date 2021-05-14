package rmugattarov.yndx.y2021;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class SortNumberWithGet {
    public static void main(String[] args) throws IOException {
        Scanner s = new Scanner(System.in);
        String targetURL = s.nextLine().trim() + ":" + s.nextLine().trim();
        String urlParameters = "a=" + s.nextInt() + "&b=" + s.nextInt();
        HttpURLConnection connection = null;
        try {
            //Create connection
            URL url = new URL(targetURL);
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            //Send request
            DataOutputStream wr = new DataOutputStream (
                    connection.getOutputStream());
            wr.writeBytes(urlParameters);
            wr.close();

            //Get Response
            InputStream is = connection.getInputStream();
            StringBuilder response;
            try (BufferedReader rd = new BufferedReader(new InputStreamReader(is))) {
                // or StringBuffer if Java version 5+
                response = new StringBuilder();
                String line;
                while ((line = rd.readLine()) != null) {
                    response.append(line);
                    response.append('\r');
                }
                rd.close();
            }
            String stringResponse = response.toString();

            JSONParser jsonParser = new JSONParser();
            JSONArray jsonArray = (JSONArray) jsonParser.parse(stringResponse);
            int[] arr = new int[jsonArray.size()];
            for (int i=0;i<jsonArray.size(); i++) {
                arr[i] = (int) jsonArray.get(i);
            }

            Arrays.sort(arr);
            for(int i: arr) {
                System.out.println(i);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                connection.disconnect();
            }
        }
    }
}
