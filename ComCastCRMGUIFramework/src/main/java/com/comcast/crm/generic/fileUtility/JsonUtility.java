package com.comcast.crm.generic.fileUtility;

import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JsonUtility {
	
	public String getDataFromJsonFile(String key) throws IOException, ParseException {
		FileReader FileR=new FileReader("./configurAppData/AppCommonData.json");
		JSONParser parser=new JSONParser();
		Object obj = parser.parse(FileR);
		
		JSONObject map= (JSONObject)obj;
		String Data=(String) map.get(key);
		
		return Data;
		
	
		
		
		
		
		
	}
}
