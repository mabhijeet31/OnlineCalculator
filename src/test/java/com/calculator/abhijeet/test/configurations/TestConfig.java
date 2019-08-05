package com.calculator.abhijeet.test.configurations;

import com.calculator.abhijeet.selenium.configurations.TypedProperties;

public class TestConfig {

	private TypedProperties typedProperties = new TypedProperties("/test_config.properties");

	public TestConfig() {
	}

	TestConfig(final TypedProperties typedProperties) {
		this.typedProperties = typedProperties;
	}

	public String getBrowser() {
		return this.typedProperties.getValue("browser.name");
	}

	public String getBaseUrl() {
		return this.typedProperties.getValue("base_url");
	}

	public String getProperty(String key) {
		return this.typedProperties.getValue(key);
	}
}
