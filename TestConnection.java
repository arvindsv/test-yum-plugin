import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.params.HttpConnectionParams;

import java.io.IOException;

public class TestConnection {
    public static void main(String[] args) {
        HttpClient client = new HttpClient();
        client.getParams().setIntParameter(HttpConnectionParams.CONNECTION_TIMEOUT, 10 * 1000);
        client.getParams().setSoTimeout(5 * 60 * 1000);

        GetMethod method = new GetMethod("https://dl.go.cd/experimental/repodata/repomd.xml");
        method.setFollowRedirects(false);
        try {
            int returnCode = client.executeMethod(method);
            if (returnCode != HttpStatus.SC_OK) {
                throw new RuntimeException(method.getStatusLine().toString());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
