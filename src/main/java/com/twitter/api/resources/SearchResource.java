package com.twitter.api.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.twitter.api.models.RulesModel;

@RestController
@RequestMapping("/search")
public class SearchResource {
	
	// TODO: Isso deve ser coletado do request
	private static String BEARER_TOKEN = "AAAAAAAAAAAAAAAAAAAAADfGHAEAAAAA8y3LfshaJO%2Bu%2BG8RgSoTMgGUfdU%3DendYq4WF0N8pjnh8JWUp3riDYaJCs9sbgucfe6ggZmAuKk827y";
	
	@Autowired
	RestTemplate apiTwitter;
	
	@GetMapping
	public void search () {
		
		System.out.println("getRules");
		getRules();
		
		System.out.println("setRules");
		setRules();
		
		System.out.println("getRules");
		getRules();
		
		System.out.println("getStream");
		getStream();

	}
	
	private void getRules () {
		
		HttpHeaders headers = new HttpHeaders();
		headers.setBearerAuth(BEARER_TOKEN);

		HttpEntity<MultiValueMap<String, String>> requestEntity = new HttpEntity<MultiValueMap<String, String>>(null, headers);

		ResponseEntity<String> response = apiTwitter.exchange("/2/tweets/search/stream/rules", HttpMethod.GET, requestEntity,
				String.class);
		
		System.out.println(response.getBody());
		
	}
	
	private void setRules () {
		
		HttpHeaders headers = new HttpHeaders();
		headers.setBearerAuth(BEARER_TOKEN);
		headers.setContentType(MediaType.APPLICATION_JSON);
		
		RulesModel rulesModel = new RulesModel("tostones recipe");
		
		String rulesJson = rulesModel.toString();
		System.out.println(rulesJson);
		
		HttpEntity<String> requestEntity = new HttpEntity<String>(rulesJson, headers);

		ResponseEntity<String> response = apiTwitter.exchange("/2/tweets/search/stream/rules", HttpMethod.POST, requestEntity,
				String.class);
		
		System.out.println(response.getBody());
	}
	
	private void getStream () {

		HttpHeaders headers = new HttpHeaders();
		headers.setBearerAuth(BEARER_TOKEN);

		HttpEntity<MultiValueMap<String, String>> requestEntity = new HttpEntity<MultiValueMap<String, String>>(null, headers);

		ResponseEntity<String> response = apiTwitter.exchange("/2/tweets/search/stream", HttpMethod.GET, requestEntity,
				String.class);
		
		System.out.println(response.getBody());
		
	}
}
