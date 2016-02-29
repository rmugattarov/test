package rmugattarov.http;

import org.apache.commons.io.IOUtils;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by rmugattarov on 29.02.2016.
 */
public class GetApache {
    @Test
    public void test() throws IOException {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet("http://www.google.com/");
        CloseableHttpResponse httpResponse = httpClient.execute(httpGet);
        int statusCode = httpResponse.getStatusLine().getStatusCode();
        System.out.printf("Status code : %d\n", statusCode);

        InputStream content = httpResponse.getEntity().getContent();
        System.out.printf("Response :\n%s\n", IOUtils.toString(content));
    }
}
