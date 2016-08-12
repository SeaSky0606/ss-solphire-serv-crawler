package yeezhao.dolphin.commons.util;

import org.junit.Assert;
import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringOperationUtilTest {
	final static String test = "this is test";
	final static String passwd = "18320144201";
	final static String complicated_passwd = "this is a complicated password, not simple as 18320144201.";
	final static String[] arr = new String[] { "banana", "apple" };


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

	@Test
	public void testMatcherString() throws Exception {

		String str = "中华       人 民    共 和国   << hello Word >>";
		str = "特写美图2(15张)2015年年初，Angelaba";
		String reg = "[0-9a-zA-Z\u4E00-\u9FA5]+[(]\\d+张[)]";
		str = str.replaceAll(reg, "");
		System.out.println(str);

	}
	/*
     * HTML Samples: <sup>[1]</sup> <sup>[2-6]</sup>
     */
	public String removeNumberIndex(String source) {
		String regEx = "\\s*<sup>\\[.*?\\]</sup>&nbsp;\\s*";
		Pattern pattern = Pattern.compile(regEx);
		Matcher matcher = pattern.matcher(source);
		String result = matcher.replaceAll("");
		return result;
	}


	@Test
	public void testRemoveNumberIndex() {
		String source = "1234567890<sup>[1]</sup>&nbsp;1234567890<sup>[12-18]</sup>&nbsp;";
		String result = removeNumberIndex(source);
		System.out.println(result);
	}

	@Test
	public void fliterChinese(){
		String s = "Hi,中华人民共和国！";
		String regex="[\\u4E00-\\u9FA5]";
		System.out.println(s.replaceAll(regex,""));
	}

	@Test
	public void testSpace() throws Exception {
		String s = " ";
		Assert.assertEquals(true, s.trim().isEmpty());
	}

	@Test
	public void testIsNullOrEmpty() throws Exception {
		String str1 = null;
		String str2 = "";
		String str3 = " ";
		Assert.assertEquals(true, isNullOrEmpty(str1));
		Assert.assertEquals(true, isNullOrEmpty(str2));
		Assert.assertEquals(false, isNullOrEmpty(str3));
	}

	public boolean isNullOrEmpty(String s) {
		return s == null || s.isEmpty();
	}

}
