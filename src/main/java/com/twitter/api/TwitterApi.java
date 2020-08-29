package com.twitter.api;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class TwitterApi {
	
	/**
	 * API key: D9fsEmUIHpg9O93JNEY13EHiG
	 * API secret key: wPxH1ULhHKe91yiE18Omwh5dbfyFWk4fYGp9wZHVDPnQATlHbK
	 */
	
	@Bean
	RestTemplate apiTwitter (RestTemplateBuilder restTemplateBuilder) {
		return restTemplateBuilder
				.rootUri("https://api.twitter.com")
				.build();
	}
}
