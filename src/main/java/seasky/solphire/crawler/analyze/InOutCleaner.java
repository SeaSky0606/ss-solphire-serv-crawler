package seasky.solphire.crawler.analyze;

import seasky.solphire.crawler.dao.MysqlDao;
import seasky.solphire.crawler.pojo.History;

import java.io.File;
import java.util.Scanner;

/**
 * Created by junhong on 2016/4/23.
 */
public class InOutCleaner {
    final static int MAXLINE = 1000000;

    public static void main(String[] args) throws Exception {
        System.out.println("---output:----");
        System.out.println("当前工作路径：" + System.getProperty("user.dir"));
        Scanner input = new Scanner(new File("data-m.txt"));
        long start = System.currentTimeMillis();
        System.out.println(InOutCleaner.clean(input));
        System.out.println("total time used:" + (System.currentTimeMillis() - start));
    }

    public static int clean(Scanner input) throws Exception {
        int count = 0;
        while (input.hasNext()) {
            String s = input.nextLine();
            History history = new History();
            String[] strings = s.split("\\t");
            history.setUid(Integer.parseInt(strings[0]));
            history.setGid(Integer.parseInt(strings[1]));
            history.setScore(Float.parseFloat(strings[2]));
            new MysqlDao().addHistory(history);
            count++;
            if (count > MAXLINE) break;
        }
        return count;
    }
}
