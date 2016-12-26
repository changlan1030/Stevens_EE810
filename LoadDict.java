import java.io.*;
import java.util.Properties;

public class LoadDict {
	public static void main(String[] args) throws Exception {
		Properties p = new Properties();
		FileReader r = new FileReader("dict.dat");
		p.load(r);
		System.out.println(p.getProperty("climb"));
		System.out.println(p.getProperty("mountain"));
		r.close();
	}
}