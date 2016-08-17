package seasky.solphire.crawler.util;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class HtmlUtilTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetHtmlByUrl() throws Exception{
		String request = "http://www.baike.com/wiki/毛东东";
		request = "http://so.gushiwen.org/view_71137.aspx";
		String html = new HtmlUtil().getHtmlByUrl(request);
		System.out.println(html);
	}
	

	@Test
	public void testGetPic() throws Exception{
		String request = "http://a0.att.hudong.com/57/31/20300543704290145308315306640_s.jpg";
		System.out.println(new HtmlUtil().writePic2Native(request));
	}
	

}
