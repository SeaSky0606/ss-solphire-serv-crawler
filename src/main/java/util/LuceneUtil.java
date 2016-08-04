package util;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field.Store;
import org.apache.lucene.document.StringField;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.*;
import org.apache.lucene.search.BooleanClause.Occur;
import org.apache.lucene.search.*;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.util.Version;

import java.io.*;
import java.util.*;


public class LuceneUtil {
    static char[] illegalChars = new char[Character.MAX_VALUE];

    static {
        Arrays.fill(illegalChars, (char) 0);
        String illegalString = "～！@#￥%……&*（）——+·-=：“？》《｛｝｜【】、；‘，。、~!@$^()_+`{}|[]\\:\"<>?;',./";
        for (int i = 0; i < illegalString.length(); i++) {
            illegalChars[illegalString.charAt(i)] = (char) 1;
        }
    }

    public static String pretreatment(String sentence) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < sentence.length(); i++) {
            char c = sentence.charAt(i);
            if (illegalChars[c] != 1) {
                sb.append(c);
            }
        }
        return sb.toString().toLowerCase();
    }

    private String indexPath = "";
    private static Double THRESHOLD_LEVEL_1 = 0.5;
    private static Double THRESHOLD_LEVEL_2 = 0.45;
    private static Double THRESHOLD_LEVEL_3 = 0.4;

    private Analyzer analyzer = new StandardAnalyzer();

    static Directory dir = null;

    public LuceneUtil() {

    }

    public LuceneUtil(String indexPath) {
        this.indexPath = indexPath;
    }

    public void initDir() {
        try {
            dir = FSDirectory.open(new File(this.indexPath));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void index(String dataPath) {
        try {
            IndexWriterConfig indexWriterConfig = new IndexWriterConfig(Version.LATEST, analyzer);
            IndexWriter indexWriter = new IndexWriter(dir, indexWriterConfig);
            Document doc = null;
            IndexableField qField = null;
            IndexableField aField = null;
            BufferedReader br = getBr(dataPath, "utf-8");
            String temp = "";
            while ((temp = br.readLine()) != null) {
                String[] temps = temp.split("\t");
                String[] questiones = temps[0].split("\\|");
                for (String question : questiones) {
                    String questionDeal = pretreatment(question);
                    doc = new Document();
                    qField = new TextField("question", questionDeal, Store.YES);
                    aField = new StringField("answer", temps[1], Store.YES);
                    doc.add(qField);
                    doc.add(aField);
                    indexWriter.addDocument(doc);
                }
            }
            indexWriter.commit();
            indexWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void index(List<String[]> indexList) {
        try {
            IndexWriterConfig indexWriterConfig = new IndexWriterConfig(Version.LATEST, analyzer);
            IndexWriter indexWriter = new IndexWriter(dir, indexWriterConfig);
            Document doc = null;
            IndexableField qField = null;
            IndexableField aField = null;
            for (String[] strs : indexList) {
                String questionDeal = pretreatment(strs[0]);
                doc = new Document();
                qField = new TextField("question", questionDeal, Store.YES);
                aField = new StringField("answer", strs[1], Store.YES);
                doc.add(qField);
                doc.add(aField);
                indexWriter.addDocument(doc);
            }
            indexWriter.commit();
            indexWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String search(String sentence) {
        String deel = pretreatment(sentence);
        String[] words = deel.split("|");
        Double similaryResult = 0.0;
        String answer = "";
        int questionLen = 0;
        IndexSearcher is = null;
        try {
            IndexReader indexReader = DirectoryReader.open(dir);
            is = new IndexSearcher(indexReader);
            BooleanQuery bq = new BooleanQuery();
            TermQuery tm = null;
            for (String word : words) {
                if (word != null && !"".equals(word)) {
                    tm = new TermQuery(new Term("question", word));
                    bq.add(tm, Occur.SHOULD);
                }
            }
            TopDocs topDocs = is.search(bq, 3);
            ScoreDoc[] sds = topDocs.scoreDocs;
            for (ScoreDoc sd : sds) {
                Document doc = is.doc(sd.doc);
                String question = doc.get("question");
                Double similary = getJaccard(question, deel);
                if (similary > similaryResult) {
                    similaryResult = similary;
                    answer = doc.get("answer");
                    questionLen = question.length();
                }
            }
            if (questionLen < 5) {
                if (similaryResult > THRESHOLD_LEVEL_1) {
                    return answer;
                }
            } else if (questionLen < 20) {
                if (similaryResult > THRESHOLD_LEVEL_2) {
                    return answer;
                }
            } else {
                if (similaryResult > THRESHOLD_LEVEL_3) {
                    return answer;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }

    /**
     * @param inputPath
     * @param code
     * @return
     */
    public static BufferedReader getBr(String inputPath, String code) {
        File inputFile = null;
        InputStreamReader isr = null;
        InputStream is = null;
        BufferedReader br = null;
        try {
            inputFile = new File(inputPath);
            if (!inputFile.exists()) {
                inputFile = new File(LuceneUtil.class.getClassLoader().getResource("") + inputPath);
            }
            is = new FileInputStream(inputFile);
            isr = new InputStreamReader(is, code);
            br = new BufferedReader(isr);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return br;
    }

    /**
     * jaccard 距离
     */
    public static double getJaccard(String str1, String str2) {
        double result = 0.0;
        try {
            //分词
            Set<String> set1 = getNGramSet(str1, 2);
            Set<String> set2 = getNGramSet(str2, 2);
            double andCount = 0.0;
            Iterator<String> iter1 = set1.iterator();
            while (iter1.hasNext()) {
                String value1 = iter1.next();
                if (set2.contains(value1)) {
                    ++andCount;
                }
            }
            result = (andCount + 0.001) / (set1.size() + set2.size() - andCount + 0.001);
            set1.clear();
            set2.clear();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public static Set<String> getNGramSet(String content, int n) {
        Set<String> result = new TreeSet<String>();
        char[] buf = content.toCharArray();
        for (int i = 0; i < content.length() - n + 1; i++) {
            result.add(new String(buf, i, n));
        }
        return result;
    }
}
