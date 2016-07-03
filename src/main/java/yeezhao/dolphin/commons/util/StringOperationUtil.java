package yeezhao.dolphin.commons.util;

import com.yeezhao.commons.util.StringUtil;

public class StringOperationUtil {
	
	private static StringOperationUtil fUtil;
	
	
	private StringOperationUtil(){
		
	}
	public static StringOperationUtil getInstance(){
		if(fUtil==null){
				return new StringOperationUtil();
		}
		return fUtil;
	}
	
	//base 
	public static boolean isNullOrEmpty(String str){
		return StringUtil.isNullOrEmpty(str);
	}
	
	//append elements for array or List
	public static String genAppendString(char c,String ... args){
		return StringUtil.genDelimitedString(args, c);
	}
	
	//MD5 校验码
	public static String genMD5(String str){
		return StringUtil.genMD5Val(str);
	}
	
	//加密 解密
	public static String encrypt(String str){
		return StringUtil.encrypt(str);
	}
	
	public static String deEncrypt(String str){
		return StringUtil.decrypt(str);
	}
	//字符串判断
	public final static boolean judgeIsCh(String str){
		return StringUtil.isNumeric(str);
	}
	
	public static void main(String[] args) {
		System.out.println(StringOperationUtil.judgeIsCh("aa123"));
		String s="我来自广东财经大学";
		System.out.println("source:"+s);
		String encrypt = StringOperationUtil.encrypt(s);
		System.out.println("加密:"+ encrypt);
		System.out.println("加密后长度:"+ encrypt.length());
		System.out.println("解密:"+StringOperationUtil.deEncrypt(encrypt));
	}

}
