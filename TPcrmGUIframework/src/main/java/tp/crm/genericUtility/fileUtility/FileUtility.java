package tp.crm.genericUtility.fileUtility;

import java.io.FileInputStream;

import java.util.Properties;

public class FileUtility {
	public String getDataFromPropertiesFile(String key) throws Throwable {
	FileInputStream fis=new FileInputStream("./configuredata/commonData.properties");
	Properties prop=new Properties();
	prop.load(fis);
	String data = prop.getProperty(key);
	return data;
	}
	
}
