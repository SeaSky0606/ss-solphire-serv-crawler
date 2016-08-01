package restful.tuling123;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.logging.Logger;

/**
 * Created by Administrator on 2016/8/1.
 */
public class Tuling123Restful {
    final static Logger LOG = Logger.getLogger("" + Tuling123Restful.class);
    private static final int DEFAULT_LENGTH = 1024;
    //GET or POST

    //useProxy or not

    //HttpURLConnection

    public static String fecthResult(String request) throws Exception {

        URL url = new URL(request);
        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
        urlConnection.connect();
        LOG.info("== connected ==" + request);
        InputStream inputStream = urlConnection.getInputStream();
        byte[] b = new byte[DEFAULT_LENGTH];
        StringBuffer sb = new StringBuffer("");
        while (inputStream.read(b) != -1) {
            sb.append(new String(b));
        }
        return sb.toString();
    }
}
