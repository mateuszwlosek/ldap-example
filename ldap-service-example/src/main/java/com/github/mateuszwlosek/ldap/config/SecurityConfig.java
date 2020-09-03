package com.github.mateuszwlosek.ldap.config;

import com.github.mateuszwlosek.ldap.properties.LdapProperties;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@RequiredArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	private final LdapProperties ldapProperties;

	@Override
	protected void configure(final HttpSecurity http) throws Exception {
		http
			.authorizeRequests()
			.antMatchers("/*").hasRole("DEVELOPER")
			.anyRequest().fullyAuthenticated()
			.and()
			.formLogin();
	}

	@Override
	public void configure(final AuthenticationManagerBuilder auth) throws Exception {
		auth
			.ldapAuthentication()
			.contextSource()
			.url(ldapProperties.getUrl())
			.managerDn(ldapProperties.getManager().getDn())
			.managerPassword(ldapProperties.getManager().getPassword())
			.and()
			.userDnPatterns(ldapProperties.getUserDnPattern())
			.groupSearchBase(ldapProperties.getGroupSearchBase())
        .passwordCompare()
			.passwordEncoder(new BCryptPasswordEncoder())
			.passwordAttribute(ldapProperties.getPasswordAttribute());
	}
}
