package seasky.solphire.crawler.util;

import org.apache.log4j.Logger;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

public class HtmlUtil {
    final static Logger LOG = Logger.getLogger(HtmlUtil.class);
    private final static int RETRY_TIME = 3;


    /**
     * @param urlPath
     * @return
     * @throws Exception
     */
    public String getJsonString(String urlPath) throws Exception {
        URL url = new URL(urlPath);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.connect();
        InputStream inputStream = connection.getInputStream();
        Reader reader = new InputStreamReader(inputStream, "gbk");
        BufferedReader bufferedReader = new BufferedReader(reader);
        String str = null;
        StringBuffer sb = new StringBuffer();
        while ((str = bufferedReader.readLine()) != null) {
            sb.append(str);
        }
        reader.close();
        connection.disconnect();
        return sb.toString();
    }

    public String getHtmlByUrl(String request) throws Exception {
        int retry = 0;
        while (retry < RETRY_TIME) {
            URL url = new URL(request);
            HttpURLConnection httpURL = (HttpURLConnection) url.openConnection();
            httpURL.setConnectTimeout(2000);
            httpURL.setReadTimeout(3000);
            httpURL.connect();
            InputStream input = httpURL.getInputStream();
            StringBuffer sb = new StringBuffer("");
            byte[] b = new byte[1024];
            while (input.read(b) != -1) {
                sb.append(new String(b));
            }
            if (!StringUtil.isNullOrEmpty(sb.toString())) {
                return sb.toString();
            }
            retry++;
            LOG.info("retry time:" + retry);
        }
        return null;
    }

    public boolean writePic2Native(String request) throws Exception {
        URL url = new URL(request);
        HttpURLConnection httpURL = (HttpURLConnection) url.openConnection();
        httpURL.connect();
        InputStream input = httpURL.getInputStream();
        @SuppressWarnings("resource")
		FileOutputStream output = new FileOutputStream(new File("G://p123.png"));
        byte[] b = new byte[1024];
        while (input.read(b) > 0) {
            output.write(b);
        }
        return true;
    }

    /**
     * 根据mysql的图片链接将图片按照原来格式存入本地
     *
     * @param id
     * @param request
     * @return
     * @throws Exception
     */
    public boolean writePic2NativeWithId(String id, String request) throws Exception {
        if (StringUtil.isNullOrEmpty(id) || StringUtil.isNullOrEmpty(request)) {
            return false;
        }
        String dir = "E:/dytt-images/";
        String type = request.substring(request.lastIndexOf(".") + 1, request.length());
        String newId = StringUtil.genMD5Val(id);
        if (!request.startsWith("http")) {
            request = "http://www.dytt.com" + request;
        }
        URL url = new URL(request);
        HttpURLConnection httpURL = (HttpURLConnection) url.openConnection();
        httpURL.connect();
        InputStream input = httpURL.getInputStream();
        @SuppressWarnings("resource")
		FileOutputStream output = new FileOutputStream(new File(dir + "" + newId + "." + type));
        byte[] b = new byte[1024];
        while (input.read(b) > 0) {
            output.write(b);
        }
        return true;
    }


}
