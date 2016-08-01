package restful.juhe;

import com.yeezhao.commons.util.StringUtil;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.logging.Logger;

/**
 * Created by junhong
 * on 2016/8/1
 */
public class JuheRestful {
    final static Logger LOG = Logger.getLogger(JuheRestful.class + "");

    public static String fetchResult(String request) throws Exception {
        return fetchResult(request, "GET");
    }

    public static String fetchResult(String request, String method) throws Exception {
        URL url = new URL(request);
        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
        if (!StringUtil.isNullOrEmpty(method)) {
            urlConnection.setRequestMethod(method);
        }
        urlConnection.connect();
        LOG.info("request method=" + urlConnection.getRequestMethod());
        InputStream inputStream = urlConnection.getInputStream();
        StringBuffer sb = new StringBuffer("");
        byte[] bytes = new byte[1024];
        while (inputStream.read(bytes) != -1) {
            sb.append(new String(bytes));
        }
        return sb.toString();
    }
}
