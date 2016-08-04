package util;

import org.junit.Test;

public class TestLuceneUtil {

    static String indexPath = "./indexPath/";

    @Test
    public void testIndex() {
        String dataPath = "qa.txt";
        System.out.println("dataPath=" + dataPath);
        LuceneUtil lu = new LuceneUtil(indexPath);
        lu.initDir();
        lu.index(dataPath);
    }

    @Test
    public void testSearch() {
        LuceneUtil lu = new LuceneUtil(indexPath);
        lu.initDir();
        String sentence = "我长得帅吗？";
        String result = lu.search(sentence);
        System.out.println(result);
    }
}
