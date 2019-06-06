package com.qa.util;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JSONUtil {

	private ObjectMapper om;

	public JSONUtil() {
		om = new ObjectMapper();
	}

	public String getJSONForObject(Object obj) {

		try {
			return om.writeValueAsString(obj);
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public String messageToJSON(String s) {
		return "{\"message\": \"" + s + "\"}";
	}

	public <T> T getObjectForJSON(String jsonString, Class<T> clazz) {


			try {
				return om.readValue(jsonString, clazz);
			} catch (JsonParseException e) {
				e.printStackTrace();
				return null;
			} catch (JsonMappingException e) {
				e.printStackTrace();
				return null;
			} catch (IOException e) {
				e.printStackTrace();
				return null;
			}
	}

}