package yeezhao.dolphin.commons.util;

import org.junit.Test;

public class StringOperationUtilTest {
	final static String test = "this is test";
	final static String passwd = "18320144201";
	final static String complicated_passwd = "this is a complicated password, not simple as 18320144201.";
	final static String[] arr = new String[] { "banana", "apple" };

	@Test
	public void testIsNullOrEmpty() {
		System.out.println(StringOperationUtil.isNullOrEmpty("hey"));
	}

	@Test
	public void testGenAppendString() {
		System.out.println(StringOperationUtil.genAppendString('|', arr));
	}

	@Test
	public void testGenMD5() {
		System.out.println(StringOperationUtil.genMD5(passwd));
		System.out.println(StringOperationUtil.genMD5(complicated_passwd));
	}

	@Test
	public void testEncrypt() {
		String s = StringOperationUtil.encrypt(passwd);
		System.out.println(s);
		String encrypt = StringOperationUtil.encrypt(complicated_passwd);
		System.out.println(encrypt);
		System.out.println(complicated_passwd.length() + "\t"
				+ encrypt.length());
	}

	@Test
	public void testDeEncrypt() {
		String s = StringOperationUtil.encrypt(passwd);
		System.out.println(StringOperationUtil.deEncrypt(s));
	}

	@Test
	public void testJudgeIsCh() {
		String s = "hao123";
		System.out.println(StringOperationUtil.judgeIsCh(s));
	}

}
