package com.manoj.securityconfiguration;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

// step 1
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {


    @Override
    protected void configure(AuthenticationManagerBuilder  managerBuilder) throws Exception {
        // set your configuration on auth object

        managerBuilder.inMemoryAuthentication().withUser("m")
                .password("m")
                .roles("USER")
                .and().withUser("n").password("n").roles("ADMIN");
    }
    @Bean
    public PasswordEncoder passwordEncoder(){


        return NoOpPasswordEncoder.getInstance();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
http.authorizeRequests().antMatchers("/admin").hasRole("ADMIN")
       .antMatchers("/user").hasAnyRole("USER","ADMIN" +
                "") .antMatchers("/").permitAll()
        .and().formLogin();
    }
}
