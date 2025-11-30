package com.selimhorri.app.config.cors;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;
import java.util.List;

@Configuration
public class CorsConfig {

	@Value("${cors.allowed-origins:*}")
	private String allowedOrigins;

	@Value("${cors.allowed-methods:GET,POST,PUT,DELETE,PATCH,OPTIONS}")
	private String allowedMethods;

	@Value("${cors.allowed-headers:*}")
	private String allowedHeaders;

	@Value("${cors.exposed-headers:}")
	private String exposedHeaders;

	@Value("${cors.allow-credentials:true}")
	private boolean allowCredentials;

	@Value("${cors.max-age:3600}")
	private long maxAge;

	@Bean
	public CorsConfigurationSource corsConfigurationSource() {
		CorsConfiguration configuration = new CorsConfiguration();
		
		// Parse allowed origins
		if ("*".equals(allowedOrigins)) {
			configuration.addAllowedOriginPattern("*");
		} else {
			List<String> origins = Arrays.asList(allowedOrigins.split(","));
			origins.forEach(origin -> {
				if (origin.trim().startsWith("*")) {
					configuration.addAllowedOriginPattern(origin.trim());
				} else {
					configuration.addAllowedOrigin(origin.trim());
				}
			});
		}
		
		// Parse allowed methods
		List<String> methods = Arrays.asList(allowedMethods.split(","));
		methods.forEach(method -> configuration.addAllowedMethod(method.trim()));
		
		// Parse allowed headers
		if ("*".equals(allowedHeaders)) {
			configuration.addAllowedHeader("*");
		} else {
			List<String> headers = Arrays.asList(allowedHeaders.split(","));
			headers.forEach(header -> configuration.addAllowedHeader(header.trim()));
		}
		
		// Parse exposed headers
		if (exposedHeaders != null && !exposedHeaders.trim().isEmpty()) {
			List<String> exposed = Arrays.asList(exposedHeaders.split(","));
			exposed.forEach(header -> configuration.addExposedHeader(header.trim()));
		}
		
		configuration.setAllowCredentials(allowCredentials);
		configuration.setMaxAge(maxAge);
		
		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		source.registerCorsConfiguration("/**", configuration);
		
		return source;
	}

}

