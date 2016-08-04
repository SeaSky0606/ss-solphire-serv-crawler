package restful.yeezhao;

import org.junit.After;
import org.junit.Test;

/**
 * Created by Administrator on 2016/8/1.
 */
public class YeezhaoRestfulTest {

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testFetchResult() throws Exception {
        String request = "http://192.168.33.10:17575/getMovieDetailById?id=196613";
        System.out.println(YeezhaoRestful.fetchResult(request));
    }

    @Test
    public void testFetchResultLogoUrl() throws Exception {
        String request = "http://192.168.33.10:17575/getActorByMovieId?id=196613&pageNum=1&pageSize=10";
        String result = YeezhaoRestful.fetchResult(request);
        System.out.println("result=" + result);
//        Gson GSON = new Gson();
//        Map<String, Object> map = GSON.fromJson(result, Map.class);
//        for (Map.Entry<String, Object> entry : map.entrySet()) {
//            System.out.println(entry.getKey() + "\t" + entry.getValue());
//        }
//        System.out.println();

//        JSONObject jsonObject = JSON.parseObject(result);
//        String logoUrl = (String) jsonObject.get("logoUrl");
//        System.out.println("logoUrl" + logoUrl);

    }
}