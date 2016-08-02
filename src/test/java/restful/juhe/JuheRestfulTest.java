package restful.juhe;

import org.junit.After;
import org.junit.Test;

/**
 * Created by junhong
 * on 2016/8/1:22:28 @ 22:28
 */
public class JuheRestfulTest {

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testFetchResult() throws Exception {
        String request = "http://japi.juhe.cn/askanswer/getTypes?key=1ec691c914a6111e27f0b04cbaef5dd6";
        String result = JuheRestful.fetchResult(request);
        System.out.println("result=" + result);
    }

    @Test
    public void testFetchResultWithPost() throws Exception {
        String request = "http://japi.juhe.cn/askanswer/getTypes?key=1ec691c914a6111e27f0b04cbaef5dd6";
        request = "http://japi.juhe.cn/funny/search.from?st=0&count=10&term=wife&key=9fa7c5b46a6e8b2281cf0f6db2f6c1d0";
        request = "http://192.168.33.10:17575/getMovies?ids=196613_199602";
        String result = JuheRestful.fetchResult(request, "POST");
        System.out.println("result=" + result);
    }

    @Test
    public void testGetFetchResult3() throws Exception {
        String query = "wife";
        String key = "9fa7c5b46a6e8b2281cf0f6db2f6c1d0";
        String request = "http://japi.juhe.cn/funny/search.from?st=0&count=10&term=%s&key=%s";
        System.out.println(JuheRestful.fetchResult(String.format(request, query, key)));

    }

    @Test
    public void testGetFetchResultBytes() throws Exception {
        String query = "wife";
        String key = "9fa7c5b46a6e8b2281cf0f6db2f6c1d0";
        String url = "http://192.168.33.10:17575/getMovies?ids=196613_199602";
        System.out.println(new String(JuheRestful.fetchResultBytes(url)));

    }
}