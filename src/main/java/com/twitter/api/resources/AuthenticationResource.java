package com.twitter.api.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.twitter.api.models.TokenModel;

@RestController
@RequestMapping("/authentication")
public class AuthenticationResource {

	@Autowired
	RestTemplate apiTwitter;

	@GetMapping
	public TokenModel authentication() {

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
		// TODO: Isso deve ser um BASE_64 de D9fsEmUIHpg9O93JNEY13EHiG:wPxH1ULhHKe91yiE18Omwh5dbfyFWk4fYGp9wZHVDPnQATlHbK
		headers.setBasicAuth("RDlmc0VtVUlIcGc5TzkzSk5FWTEzRUhpRzp3UHhIMVVMaEhLZTkxeWlFMThPbXdoNWRiZnlGV2s0ZllHcDl3WkhWRFBuUUFUbEhiSw==");
		headers.set("grant_type", "client_credentials");

		MultiValueMap<String, String> map= new LinkedMultiValueMap<String, String>();
		map.add("grant_type", "client_credentials");
		
		HttpEntity<MultiValueMap<String, String>> requestEntity = new HttpEntity<MultiValueMap<String, String>>(map, headers);

		ResponseEntity<TokenModel> response = apiTwitter.exchange("/oauth2/token", HttpMethod.POST, requestEntity,
				TokenModel.class);
		
		return response.getBody();
	}
}
