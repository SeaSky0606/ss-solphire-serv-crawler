package restful.tuling123;

import org.junit.After;
import org.junit.Test;

/**
 * Created by Administrator
 * on 2016/8/1
 */
public class Tuling123RestfulTest {

    @After
    public void tearDown() throws Exception {
        System.out.println("--finish--");
    }

    @Test
    public void testFecthResult() throws Exception {
        String hostname = "http://www.tuling123.com/openapi/api";
        String key = "93bb4143af9044a2bb1f4718a270e8d4";
        String info = "范冰冰的图片";
//        info="你好";
        String request = hostname + "?key=" + key + "&info=" + info;
        String result = Tuling123Restful.fecthResult(request);
        System.out.println("result=" + result);
    }
}