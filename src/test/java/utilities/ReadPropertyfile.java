package utilities;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ReadPropertyfile {

	public static void main(String[] args) throws IOException {
		FileReader F_reader = new FileReader(
				System.getProperty("user.dir") + "\\src\\test\\resources\\configfiles\\config.properties");
		Properties property = new Properties();
		property.load(F_reader);
		System.out.println(property.getProperty("browser"));
		System.out.println(property.getProperty("url"));
	}

}
