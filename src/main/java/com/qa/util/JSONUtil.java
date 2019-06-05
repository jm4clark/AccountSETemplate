package com.qa.util;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
//import com.google.gson.Gson;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JSONUtil {

	// private Gson gson;
	private ObjectMapper om;
	private File file = new File("target/accounts.json");

	public JSONUtil() {
		// this.gson = new Gson();
		om = new ObjectMapper();

	}

	public String getJSONForObject(Object obj) {

		try {
			return om.writeValueAsString(obj);
		} catch (IOException e) {
			System.out.println("ioexception");
			// e.printStackTrace();
			return null;
		}

		// return gson.toJson(obj);
	}

	public <T> T getObjectForJSON(String jsonString, Class<T> clazz) {


			try {
				return om.readValue(jsonString, clazz);
			} catch (JsonParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return null;
			} catch (JsonMappingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return null;
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return null;
			}

	}

}