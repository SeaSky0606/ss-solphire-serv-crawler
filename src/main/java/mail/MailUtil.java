package mail;

import org.apache.log4j.Logger;

import javax.mail.*;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

/**
 * 采用java-mail发送邮件
 * Created by Administrator -> junhong
 * on 2016/9/4.
 */
public class MailUtil {
    final static Logger LOG = Logger.getLogger(MailUtil.class);

    public static void main(String[] args) throws Exception {
        LOG.info("-- start --");
        testSendMail();
        LOG.info("-- finish --");
    }

    public static boolean testSendMail() throws Exception {
        MailServer server = new MailServer("smtp.sina.com", "soft03_test", "soft03_test");
        MailMessage msg = new MailMessage("this is subject", "this is content", "soft03_test@sina.com");
        InternetAddress[] addresses = new InternetAddress[]{new InternetAddress("junhong@summba.com")};
        System.out.println(sendMail(server, msg, addresses));
        return true;
    }

    /**
     * @param subject
     * @param content
     * @param mailTo
     * @return true if mail sent successfully
     * Example:
     * sendMail("this is subject","this is content","junhong@summba.com")
     */
    public static boolean sendMail(String subject, String content, String mailTo) {
        MailServer server = new MailServer("smtp.sina.com", "soft03_test", "soft03_test");
        MailMessage msg = new MailMessage(subject, content, "soft03_test@sina.com");
        InternetAddress[] addresses = new InternetAddress[0];
        try {
            addresses = new InternetAddress[]{new InternetAddress(mailTo)};
        } catch (AddressException e) {
            e.printStackTrace();
        }
        return sendMail(server, msg, addresses);

    }

    public static boolean sendMail(MailServer server, MailMessage msg, Address... addresses) {
        Properties properties = new Properties();
        properties.setProperty("mail.transport.protocol", "smtp");
        properties.setProperty("mail.smtp.auth", "true"); //add 'auth' from overstack suggestion
        Session session = Session.getInstance(properties);
        //创建Message对象
        Message message = new MimeMessage(session);
        try {
            message.setSubject(msg.subject);
            message.setFrom(new InternetAddress(msg.from));
            message.setContent(msg.content + "\n----" + new java.util.Date(), "text/html;charset=utf-8");

            //创建接口，并连接（登录）
            Transport transport = session.getTransport();
            transport.connect(server.host, server.user, server.pass);
            //发送邮件
            transport.sendMessage(message, addresses);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
        return true;
    }

    static class MailServer {
        String host;
        String user;
        String pass;

        public MailServer(String host, String user, String pass) {
            this.host = host;
            this.user = user;
            this.pass = pass;
        }
    }

    static class MailMessage {
        String subject;
        String from;
        String content;

        public MailMessage(String subject, String content, String from) {
            this.subject = subject;
            this.content = content;
            this.from = from;
        }
    }


}
