package com.jsaddlercs.classapp.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

/**
 * Properties specific to aws client.
 * <p>
 * Properties are configured in the {@code application.yml} file.
 */
@Component
@ConfigurationProperties(prefix = "aws", ignoreUnknownFields = false)
public class AwsConfig {

	
	private static final String AWS_ACCESS_KEY_ENV = "AWS_ACCESS_KEY_ID";
	private static final String AWS_SECRET_KEY_ENV = "AWS_SECRET_ACCESS_KEY";
	
//	@Value("${amazon.access.key}")
	private String awsAccessKey;
	
//	@Value("${amazon.access.secret-key}")
	private String awsSecretKey;
	
    @Value("${amazon.endpoint}")
	private String awsDynamoDBEndpoint;
	
	@Value("${amazon.region}")
	private String region;


	public AwsConfig(Environment env) { 
		String accessKeyEnv = env.getProperty(AWS_ACCESS_KEY_ENV);
		String secretKeyEnv = env.getProperty(AWS_SECRET_KEY_ENV);
		awsAccessKey = accessKeyEnv;
		awsSecretKey = secretKeyEnv;
	}
	public String getAccessKey() { 
		return awsAccessKey; 
	}

	public void setAccessKey(String accessKey) { this.awsAccessKey = accessKey; }

	public String getSecretKey() { return awsSecretKey; }

	public void setSecretKey(String secretKey) { this.awsSecretKey = secretKey; }

	public String getRegion() { return region; }

	public void setRegion(String region) { this.region = region; }

	public String getEndpoint() { return awsDynamoDBEndpoint; }

	public void setEndpoint(String endpoint) { this.awsDynamoDBEndpoint = endpoint; }
	
	@Override
	public String toString() {
		return "AwsConfig [accessKey=" + awsAccessKey + ", secretKey=" + awsSecretKey + ", region=" + region + ", endpoint="
				+ awsDynamoDBEndpoint + "]";
	}

    
}