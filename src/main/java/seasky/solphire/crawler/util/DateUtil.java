package seasky.solphire.crawler.util;

import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class DateUtil {

	public static long getCurrentTime() {
		return System.currentTimeMillis();
	}

	/*
	 * output= 23:44:27 -1
	 */
	public static void main(String[] args) {
		System.out.println(getDaysDelay(new Date(), 3, "yyyy-MM-dd"));
		 testDateCompare();

	}

	public static List<String> getDaysDelay(Date beginDay, int num,
			String pattern) {
		List<Date> dates = new ArrayList<Date>();
		Calendar calendar = Calendar.getInstance();
		while (true) {
			if (dates.size() >= num)
				break;
			calendar.add(Calendar.DAY_OF_MONTH, 1);
			dates.add(calendar.getTime());
		}
		List<String> list = new ArrayList<String>();
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		for (Date d : dates) {
			list.add(sdf.format(d));
		}
		return list;
	}



	private static void testDateCompare() {
		String s1 = "20:00:01";
		s1 = "00:01:16";
		String s2 = "23:59:01";
		Time now = new Time(System.currentTimeMillis());
		System.out.println("now=" + now);
		Time time1 = Time.valueOf(s1);
		Time time2 = Time.valueOf(s2);
		Time nn = Time.valueOf(now.toString()); // 替换引用
		System.out.println(time1.compareTo(time2));
		System.out.println(timeCompare(nn, time1));
		System.out.println(timeCompare(nn, time2));
		System.out.println(nn.compareTo(time2));
	}

	public static boolean dateCompare(Date d1, Date d2) {
		return d1.compareTo(d2) > 0;
	}

	public static boolean timeCompare(Time t1, Time t2) {
		System.out.println(t1 + "\t" + t2);
		return t1.compareTo(t2) > 0;
	}

}
