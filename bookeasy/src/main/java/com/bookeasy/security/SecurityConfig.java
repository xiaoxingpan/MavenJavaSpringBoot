package com.bookeasy.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
public class SecurityConfig {
    @Bean
    public UserDetailsManager userDetailsManager(DataSource dataSource) {
        return new JdbcUserDetailsManager(dataSource);
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(configurer ->
                        configurer
                                //use.hasAnyRole to handle multiple roles
                                .requestMatchers("/").hasAnyRole("USER", "ADMIN")
                                .requestMatchers("/books/list/**").hasAnyRole("USER", "ADMIN")
                                .requestMatchers("/books/save/**").hasRole("ADMIN")
                                .requestMatchers("/books/delete/**").hasRole("ADMIN")
                                .requestMatchers("/books/update/**").hasRole("ADMIN")
                                .requestMatchers("/adminManage/**").hasRole("ADMIN")
                                .requestMatchers("/orders/list/**").hasRole("ADMIN")
                                .requestMatchers("/newBookRegister/**").hasRole("ADMIN")

                                // any request must be authenticated
                                .anyRequest().authenticated()
                )
                .formLogin(form ->
                        form
                                .loginPage("/showLoginPage")
                                .loginProcessingUrl(("/authenticateTheUser"))
                                // everyone can access this without being logged in
                                .permitAll()
                )
                .logout(logout -> logout.permitAll()
                )
                .exceptionHandling(configurer ->
                        configurer
                                .accessDeniedPage("/access-denied")
                );
        return http.build();
    }
}
