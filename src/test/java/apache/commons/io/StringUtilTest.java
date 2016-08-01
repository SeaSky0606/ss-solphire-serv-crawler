package apache.commons.io;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;

public class StringUtilTest {
	final static String str1 = "How do you do ?";
	final static String str2 = "do";

	@Test
	public void testGenTotalStringByStr() {
		String[] tmp = new String[] { "cat", "dog", "pig" };
		Collection<String> coll = Arrays.asList(tmp);
		System.out.println(StringUtil.genTotalStringByStr(coll));

	}

	@Test
	public void testGenTotalStringByChar() {
		String[] tmp = new String[] { "cat", "dog", "pig" };
		Collection<String> coll = Arrays.asList(tmp);
		System.out.println(StringUtil.genTotalStringByChar(coll));

	}


	@Test
	public void testGetReverse() {
		System.out.println(StringUtil.getReverse(str2));
	}

	@Test
	public void testGetRemoveResult() {
		System.out.println(StringUtil.getRemoveResult(str1, str2));
	}

	@Test
	public void testGetDelete() {
		System.out.println(StringUtil.getDelete(str1));
	}

}
