package seasky.solphire.crawler.poem;

import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class PoemDataExtractTest {
	PoemDataExtract extract = new PoemDataExtract();

	@Test
	public void testAnalyze() {
	}

	@Test
	public void testJoin() {
		List<String> list = new ArrayList<String>() {
			{
				add("cat");
				add("dog");
				add("rabbit");
			}
		};
		System.out.println(list);
		System.out.println(extract.join(list, "#"));
	}

	@Test
	public void testClean() {
	}

	@Test
	public void testSave() {
		PoemDataExtract poem = new PoemDataExtract();
		System.out.println("----- 诗 -----");
		String ids[] = { "7722", "10835" }; // 诗： 将进酒|春望
		for (String id : ids) {
			System.out.println(poem.analyze(id));
		}

		System.out.println("----- 词 -----");
		String ids2[] = { "2077", "49394" }; // 词： 忆江南·江南好|念奴娇·赤壁怀古
		for (String id : ids2) {
			System.out.println(poem.analyze(id));
		}
		System.out.println("----- 曲-----");
		String ids3[] = { "71201", "69957" }; // 曲： 山坡羊·潼关怀古|天净沙·秋思
		for (String id : ids3) {
			System.out.println(poem.analyze(id));
		}
		System.out.println("----- 文言文 -----");
		String ids4[] = { "71139", "71137" }; // 文言文： 爱莲说|桃花源记
		for (String id : ids4) {
			System.out.println(poem.analyze(id));
		}
	}

}
