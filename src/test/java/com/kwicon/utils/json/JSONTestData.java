package com.kwicon.utils.json;

import java.io.InputStream;

import org.json.JSONObject;
import org.json.JSONTokener;

public class JSONTestData {
	
	private String fileName;
	private JSONObject jObj;
	
	public JSONTestData(String fileName)
	{
		this.fileName= fileName;
	}

	
	public String getData(String obj,String key)
	{
		InputStream data = getClass().getClassLoader().getResourceAsStream("JSONdata/"+fileName+".json");
		JSONTokener token = new JSONTokener(data);
		jObj =new JSONObject(token);
		return jObj.getJSONObject(obj).getString(key);
	}

	
	

	
 
	
	

}
