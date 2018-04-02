package com.example.SSOdemo;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableOAuth2Sso
public class UiSecurityConfig extends WebSecurityConfigurerAdapter {
    private final Log logger = LogFactory.getLog(UiSecurityConfig.class);

    @Override
    public void configure(HttpSecurity http) throws Exception {
        logger.debug("SSOdemo -- Configuring HttpSecurity");
        http.antMatcher("/**")
            .authorizeRequests()
            .antMatchers("/", "/login**")
            .permitAll()
            .anyRequest()
            .authenticated();
    }
}