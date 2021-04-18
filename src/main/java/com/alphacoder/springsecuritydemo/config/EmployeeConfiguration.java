package com.alphacoder.springsecuritydemo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class EmployeeConfiguration {

    @Bean
    public UserDetailsService userDetailsService(){
        var userDetails= new InMemoryUserDetailsManager();

        var user= User.withUsername("rakambank")
                      .password("123456")
                      .authorities("read")
                      .build();

        userDetails.createUser(user);

        return userDetails;
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return NoOpPasswordEncoder.getInstance();
    }
}
