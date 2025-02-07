/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.TechForb.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;

import static org.springframework.security.config.http.SessionCreationPolicy.*;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.example.TechForb.Filter.*;

import lombok.RequiredArgsConstructor;

/**
 *
 * @author Usuario
 */

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class WebSecurity extends WebSecurityConfigurerAdapter{
    private final UserDetailsService userDetailsService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }
    

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        CustomAthenticationFilter customAthenticationFilter = new CustomAthenticationFilter(authenticationManager());
        customAthenticationFilter.setFilterProcessesUrl("/api/users/login");
        http.csrf().disable();
        http.sessionManagement().sessionCreationPolicy(STATELESS);
        http.authorizeRequests().antMatchers(HttpMethod.OPTIONS).permitAll();
        http.authorizeRequests().antMatchers("/api/users/login/**", "/api/users/token/refresh/**").permitAll();
        http.authorizeRequests().antMatchers(HttpMethod.POST, "/api/users/registrar/newUser").permitAll();
        http.authorizeRequests().antMatchers(HttpMethod.GET, "/**").authenticated();
        http.authorizeRequests().antMatchers(HttpMethod.POST, "/**").authenticated();
        http.authorizeRequests().antMatchers(HttpMethod.PUT, "/**").authenticated();
        http.authorizeRequests().antMatchers(HttpMethod.DELETE, "/**").authenticated();
        http.authorizeRequests().anyRequest().authenticated();
        http.addFilter(customAthenticationFilter);
        http.addFilterBefore(new CustomAthorizationFilter(), UsernamePasswordAuthenticationFilter.class);
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
    
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
    
}
