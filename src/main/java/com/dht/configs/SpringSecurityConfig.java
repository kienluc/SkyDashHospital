package com.dht.configs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableWebSecurity
@EnableTransactionManagement
@ComponentScan(basePackages = "com.dht")
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsService userDetailsService;
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    @Override
    protected void configure(AuthenticationManagerBuilder auth)
            throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }

    protected void configure(HttpSecurity http)
            throws Exception {
        http.formLogin().loginPage("/login")
                .usernameParameter("username")
                .passwordParameter("password");
        http.formLogin().defaultSuccessUrl("/home")
                .failureUrl("/login?error");
        http.logout().logoutSuccessUrl("/login");
        http.exceptionHandling()
                .accessDeniedPage("/login?accessDenied");
        http.authorizeRequests().antMatchers("/").permitAll()
                .antMatchers("/home")
                .access("hasAnyRole('ROLE_ADMIN', 'ROLE_DOCTOR')")
        .antMatchers("/patients").access("hasAnyRole('ROLE_ADMIN', 'ROLE_DOCTOR')")
        .antMatchers("/doctors").access("hasAnyRole('ROLE_ADMIN', 'ROLE_DOCTOR')")
        .antMatchers("/accounts").access("hasAnyRole('ROLE_ADMIN', 'ROLE_DOCTOR')")
        .antMatchers("/doctorschedules").access("hasAnyRole('ROLE_ADMIN', 'ROLE_DOCTOR')")
        .antMatchers("/appointments").access("hasAnyRole('ROLE_ADMIN', 'ROLE_DOCTOR')")
        .antMatchers("/bills").access("hasAnyRole('ROLE_ADMIN', 'ROLE_DOCTOR')")
        .antMatchers("/drugs").access("hasAnyRole('ROLE_ADMIN', 'ROLE_DOCTOR')")
        .antMatchers("/**/delete/**/").access("hasAnyRole('ROLE_ADMIN')")
        .antMatchers("/**/patients/add-patient").access("hasAnyRole('ROLE_ADMIN', 'ROLE_DOCTOR')")
        .antMatchers("/patients/edit-patient").access("hasAnyRole('ROLE_ADMIN', 'ROLE_DOCTOR')")
        .antMatchers("/doctors/add-doctor").access("hasAnyRole('ROLE_ADMIN')")
        .antMatchers("/doctors/edit-doctor").access("hasAnyRole('ROLE_ADMIN')");
        http.csrf().disable();
    }

}
