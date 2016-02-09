import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.IOException;

public class TestConnection {
    public static void main(String[] args) throws IOException {
        CloseableHttpClient httpclient = HttpClients.createDefault();

        try {
            HttpGet httpget = new HttpGet("https://dl.go.cd/experimental/repodata/repomd.xml");
            CloseableHttpResponse response = httpclient.execute(httpget);
            System.err.println(response);
        } finally {
            httpclient.close();
        }
    }
}
