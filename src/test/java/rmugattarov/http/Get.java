package rmugattarov.http;

import org.apache.commons.io.IOUtils;
import org.junit.Test;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by rmugattarov on 29.02.2016.
 */
public class Get {
    @Test
    public void test() throws IOException {
        URL url = new URL("http", "en.wikipedia.org", "/");
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        httpURLConnection.setRequestMethod("GET");
        System.out.printf("Response code : %d\n", httpURLConnection.getResponseCode());
        System.out.printf("Response :\n%s\n", IOUtils.toString(httpURLConnection.getInputStream()));
    }
}
