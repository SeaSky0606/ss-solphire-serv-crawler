package restful.yeezhao;

import org.apache.commons.io.IOUtils;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.logging.Logger;

/**
 * Created by junhong on 2016/8/1.
 */
public class YeezhaoRestful {
    private static final Logger LOG = Logger.getLogger("" + YeezhaoRestful.class);
//    private static final int DEFAULT_LENGTH = 1024;

    /**
     * @param request
     * @return
     * @throws Exception
     */
    public static String fetchResult(String request) throws Exception {

        URL url = new URL(request);
        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
        LOG.info("requestMethod=" + urlConnection.getRequestMethod());
        urlConnection.connect();
        InputStream inputStream = urlConnection.getInputStream();
//
//        StringBuffer sb = new StringBuffer("");
//        byte[] b = new byte[DEFAULT_LENGTH];
//        while (in.read(b) != -1) {
//            sb.append(new String(b));
//        }
//        return sb.toString();
        return new String(IOUtils.toByteArray(inputStream));
    }
}
