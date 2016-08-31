package com.yeezhao.dolphin.crawler.dbaction;

import com.yeezhao.commons.util.StringUtil;

public class RandomUtil {

	final static String summary = "北京故宫是中国明清两代的皇家宫殿，旧称为紫禁城，位于北京中轴线的中心，是中国古代宫廷建筑之精华。北京故宫以三大殿为中心，占地72万平方米，建筑面积约15万平方米，有大小宫殿七十多座，房屋九千余间。是世界上现存规模最大、保存最为完整的木质结构古建筑之一。"
			+ "北京故宫于明成祖永乐四年（1406年）开始建设，以南京故宫为蓝本营建，到永乐十八年（1420年）建成。它是一座长方形城池，南北长961米，东西宽753米，四面围有高10米的城墙，城外有宽52米的护城河。紫禁城内的建筑分为外朝和内廷两部分。外朝的中心为太和殿、中和殿、保和殿，统称三大殿，是国家举行大典礼的地方。"
			+ "的中心是乾清宫、交泰殿、坤宁宫，统称后三宫，是皇帝和皇后居住的正宫。";
	private static final int RAND_TOTAL = 100;

	public static int randIndex(int a) {
		return (int) (a * Math.random());
	}

	static StringBuffer summ = new StringBuffer();
	static int len = 0;
	static int summLen = 0;
	static {
		len = summary.length();
		summLen = summ.length();
		for (int i = 0; i < len; i++) {
			char ch = summary.charAt(i);
			if (StringUtil.isCnChar(ch)) {
				summ.append(ch);
			}
		}
	}

	public static String genName() {
		return summ.charAt(randIndex(summLen)) + "" + summ.charAt(randIndex(summLen));
	}
	
	public static void main(String[] args) {
		System.out.println(RandomUtil.genName());
		System.out.println(RandomUtil.genName());
	}
}
