package apache.commons.io;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.LinkedList;
import java.util.List;

import org.apache.commons.io.FileUtils;

/**
 * 
 * @author Administrator
 * @date 2016年7月3日
 */
public class FileIO {

	public List<String> getAttrs(String path) {
		List<String> attrs = new LinkedList<String>();
		try {
			for (String line : FileUtils.readLines(new File(path), "UTF-8")) {
				if (!line.startsWith("#")) {
					attrs.add(line.split("\\|")[0]);
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return attrs;
	}

	//文件写入
	@SuppressWarnings("deprecation")
	public boolean writeFile() throws Exception {
		String base = FileIO.class.getClassLoader().getResource("").getPath();
		File file = new File(base + "readme.txt");
		String data = "this is test.\nFine.";
		FileUtils.writeStringToFile(file, data, true);
		return true;
	}

	// 获取资源路径
	public static void main(String[] args) throws Exception {
		FileIO fileIO = new FileIO();
		// System.out.println(System.getProperty("user.dir"));
		// String basePath = FileIO.class.getClassLoader().getResource("")
		// .getPath();
		// System.out.println(fileIO.getAttrs(basePath + "people.txt"));
		fileIO.writeFile();
	}
}
