package com.dawm.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true, jsr250Enabled = true)
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers("/login*").permitAll()
            .antMatchers("/h2-console/**").hasRole("ADMIN")
            .antMatchers("/public/**").permitAll()
        	.anyRequest().authenticated()
            .and()
            .formLogin().loginPage("/login")
            .defaultSuccessUrl("/index")
            .permitAll()
        	
        	.and().httpBasic().disable()
            .csrf().disable()
            .headers().frameOptions().disable();
        
        http.formLogin().defaultSuccessUrl("/", true);

        return http.build();
    }
    
    @Bean
    public BCryptPasswordEncoder passwordEncoder() { 
        return new BCryptPasswordEncoder(); 
    }
    
    @Bean
    public UserDetailsService userDetailsService(BCryptPasswordEncoder passwordEncoder) {
        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();

        manager.createUser(User.withUsername("usuario")
            .password(passwordEncoder.encode("usuario"))
            .roles("USER")
            .build());

        manager.createUser(User.withUsername("admin")
            .password(passwordEncoder.encode("admin"))
            .roles("USER", "ADMIN")
            .build());

        return manager;
    }

}