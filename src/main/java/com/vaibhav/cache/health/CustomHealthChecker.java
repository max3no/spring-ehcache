package com.vaibhav.cache.health;

import java.net.HttpURLConnection;
import java.net.URL;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

@Component
public class CustomHealthChecker implements HealthIndicator {

	@Override
	public Health health() {
		try{
			URL siteUrl = new URL("https://www.google.com");
			HttpURLConnection connection = (HttpURLConnection)siteUrl.openConnection();
			connection.connect();
			int code = connection.getResponseCode();
			if(code == 200) {
				return Health.up().build();
			}else {
				return Health.down().withDetail("Error", "Service is down").build();
			}
		}catch(Exception e) {
			return Health.down().withDetail("Error", e.getMessage()).build();
		}
	}

}
