package com.github.mateuszwlosek.ldap.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties(prefix = "ldap")
public class LdapProperties {

	private String url;
	private ManagerProperties manager;
	private String userDnPattern;
	private String groupSearchBase;
	private String passwordAttribute;

	@Data
	public static class ManagerProperties {
		private String dn;
		private String password;
	}
}
