package com.sk.sheikhpura.utils;

import java.util.HashMap;

import org.json.JSONObject;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

public final class JsonUtil {
	
	/**
	 * Create JSON response.
	 * 
	 * @param hashMap
	 *            - convert it to json object.
	 * @return Return json data
	 */
	
	public static ResponseEntity<String> json(HashMap<String, String> hashMap) {
		HttpHeaders headers = new HttpHeaders();
		headers.set("Content-Type", "application/json");
		JSONObject oJSONObject = new JSONObject(hashMap);
		return new ResponseEntity<String>(oJSONObject.toString(), headers, HttpStatus.OK);
	}

	public static ResponseEntity<String> json(HashMap<String, String> hashMap, HttpStatus httpStatus) {
		HttpHeaders headers = new HttpHeaders();
		headers.set("Content-Type", "application/json");
		JSONObject oJSONObject = new JSONObject(hashMap);
		return new ResponseEntity<String>(oJSONObject.toString(), headers, httpStatus);
	}

	/**
	 * Create JSON response.
	 * 
	 * @param jObject
	 *            - pass the object to view as json data.
	 * @return Return json data
	 */
	public static ResponseEntity<String> json(JSONObject jObject) {
		HttpHeaders headers = new HttpHeaders();
		headers.set("Content-Type", "application/json");
		return new ResponseEntity<String>(jObject.toString(), headers, HttpStatus.CREATED);
	}

	public static HttpEntity<byte[]> httpEntity(final String contentType, final String fileName,
			final byte[] item) {
		HttpHeaders header = new HttpHeaders();
		header.setContentType(MediaType.valueOf(contentType));
		header.setCacheControl("must-revalidate, post-check=0, pre-check=0");
		header.set("Content-Disposition", "inline; filename=" + fileName);
		header.setContentLength(item.length);

		return new HttpEntity<byte[]>(item, header);
	}



}
