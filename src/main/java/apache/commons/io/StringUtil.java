package apache.commons.io;

import java.util.Arrays;
import java.util.Collection;

import org.apache.commons.lang.StringUtils;

/**
 * 
 * @author junhong
 * @date 2016年7月3日
 */
public class StringUtil {

	public static String genTotalStringByStr(Collection<String> coll) {
		return StringUtils.join(coll, "GOOD");
	}

	public static String genTotalStringByChar(Collection<String> coll) {
		return StringUtils.join(coll, '$');
	}
	
	//string reverse
	public static String getReverse(String str){
		return StringUtils.reverse(str);
	}
	
	//remove 'remove' from 'str'
	public static String getRemoveResult(String str,String remove){
		return StringUtils.remove(str, remove);
	}
	
	//delete 'space' for str
	public static String getDelete(String str){
		return StringUtils.deleteWhitespace(str);
	}
	
	//remove new from end of 'str'
	public static String getCleanStr(String str){
		return StringUtils.chomp(str);
	}

	public static void main(String[] args) {
		String[] tmp = new String[] { "cat", "dog", "pig" };
		Collection<String> coll = Arrays.asList(tmp);
		System.out.println(StringUtil.genTotalStringByChar(coll));
		System.out.println(StringUtil.genTotalStringByStr(coll));
		String s = "How do you do?\t\nFine!\n";
		System.out.println(s);
		s = StringUtil.getCleanStr(s);
		System.out.println(s);
		System.out.println(s);
		}
}
