package com.example.cxfrj.rest;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import org.junit.Test;

import com.example.cxfrj.rest.model.RestModel;
import com.fasterxml.jackson.databind.ObjectMapper;

public class CxfRestJsonServiceTest {

	//@Test
	public void callPostRoute() throws Exception {
		
		RestModel model = new RestModel();
		model.setName("routeA");
//		model.setStartJmsComponentName("startcomp");
//		model.setStartDestinationType("queue");
//		model.setStartDestinationName("startname");
//		model.setStartUserName("user1");
//		model.setStartPassword("pass");
//		model.setEndCombinedFormattedOptions("?this=that");
//		model.setEndJmsComponentName("endcomp");
//		model.setEndDestinationType("topic");
//		model.setEndDestinationName("endname");
//		model.setEndUserName("user1");
//		model.setEndPassword("pass");
//		model.setEndCombinedFormattedOptions("?this=that");
		
		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(model);

		String urlString = "http://localhost:8181/cxf/rest/routes";
		callPost(json, urlString);
	}

	public void callPost(String json, String urlString) throws Exception {
		URL url = new URL(urlString);
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setDoOutput(true);
		conn.setRequestMethod("POST");
		conn.setRequestProperty("Content-Type", "application/json");

		String input = json;

		OutputStream os = conn.getOutputStream();
		os.write(input.getBytes());
		os.flush();

		BufferedReader br = new BufferedReader(new InputStreamReader(
				(conn.getInputStream())));

		StringBuilder sb = new StringBuilder();
		String line;
		while ((line = br.readLine()) != null) {
			sb.append(line);
		}
		conn.disconnect();
		System.out.println(sb.toString());
	}
}
