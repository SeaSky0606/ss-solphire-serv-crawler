package mail;

import org.junit.After;
import org.junit.Test;

/**
 * Created by Administrator -> junhong
 * on 2016/9/4.
 */
public class MailUtilTest {

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testSendMail() throws Exception {
        String subject = "hello";
        String content = "this is content!";
        String mailTo = "847421525@qq.com";
        System.out.println(MailUtil.sendMail(subject, content, mailTo));

    }
}