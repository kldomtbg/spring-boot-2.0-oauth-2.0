package com.ywsoftware.oa.authServer.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

@Configuration
@EnableResourceServer
@EnableWebSecurity
public class ResourceServerConfiguration extends ResourceServerConfigurerAdapter {

//    private static final String RESOURCE_ID = "restservice";
//
//    @Override
//    public void configure(ResourceServerSecurityConfigurer resources) {
//        resources.resourceId(RESOURCE_ID);
//    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.headers().frameOptions().disable();
        http
                .authorizeRequests().antMatchers("/static/**", "/druid/**").permitAll()
                .antMatchers("/swagger**", "/swagger-resources/**", "/webjars/**").permitAll()
                .anyRequest().authenticated()
                .and().formLogin().permitAll()
                .and().csrf().disable();

        //    http.headers().contentTypeOptions().disable();
    }

}
