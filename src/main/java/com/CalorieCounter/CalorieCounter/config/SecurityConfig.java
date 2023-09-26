package com.CalorieCounter.CalorieCounter.config;


import com.CalorieCounter.CalorieCounter.service.AccountUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    AccountUserDetailsService accountUserDetailsService;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        //Setting roles for endpoints, nothing should be accessible without a role,
        // except for the error endpoint which is where the user is redirected to when they try to access a page they don't have access to.
        http.authorizeHttpRequests(r -> r
                //.requestMatchers("/error").permitAll()
                .requestMatchers("/").hasAnyRole("ADMIN", "USER")
                .requestMatchers("/recipe/**").hasAnyRole("ADMIN", "USER")
                .requestMatchers("/admin/**").hasRole("ADMIN")
        );


        //Using Basic Auth just for simplicity for now.
        http.httpBasic(withDefaults());
        http.csrf().disable();

        //Disable csrf if needed for testing, should never be disabled in production.
        //http.csrf(AbstractHttpConfigurer::disable);

        return http.build();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth, PasswordEncoder passwordEncoder) throws Exception {
        auth.userDetailsService(accountUserDetailsService).passwordEncoder(passwordEncoder);
    }



}
