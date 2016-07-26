package seasky.solphire.crawler.util;

import java.sql.Time;
import java.util.Date;

public class DateUtil {

	public static long getCurrentTime() {
		return System.currentTimeMillis();
	}
	/* output=
		23:44:27
		-1
	*/
	public static void main(String[] args) {
		String s1 = "20:00:01";
		String s2 = "22:00:01";
		System.out.println(new Time(System.currentTimeMillis()));
		Time time1 = Time.valueOf(s1);
		Time time2 = Time.valueOf(s2);
		System.out.println(time1.compareTo(time2));
		
	}

	public static boolean dateCompare(Date d1, Date d2) {
		return d1.compareTo(d2) > 0;
	}

	public static boolean timeCompare(Time t1, Time t2) {
		return t1.compareTo(t2) > 0;
	}

}
