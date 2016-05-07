package seasky.solphire.crawler.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by junhong on 2016/3/13.
 */
public class StringUtil {

    public static boolean isNullOrEmpty(String s) {
        if (s == null || s.isEmpty()) {
            return true;
        }
        return false;
    }

    public static String genMD5Val(String string) {
        String md5Val4RvCont = null;

        try {
            byte[] e = string.getBytes();
            MessageDigest md5Inst = MessageDigest.getInstance("MD5");
            md5Inst.update(e);
            byte[] md5Val = md5Inst.digest();
            StringBuilder sBuilder = new StringBuilder();

            for(int i = 0; i < md5Val.length; ++i) {
                int val = md5Val[i] & 255;
                if(val < 16) {
                    sBuilder.append("0");
                }

                sBuilder.append(Integer.toHexString(val));
            }

            md5Val4RvCont = sBuilder.toString();
        } catch (NoSuchAlgorithmException var8) {
            var8.printStackTrace();
        }

        return md5Val4RvCont;
    }


}
