package com.gmail.shelkovich.anton.web.config.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    @Qualifier("appUserDetailsService")
    private UserDetailsService userDetailsService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/admin/users", "/admin/users/**").access("hasRole('SUPERADMIN')")
                .antMatchers("/admin/**", "/news/*/comments/*/**").access("hasRole('ADMIN') or hasRole('SUPERADMIN')")
                .antMatchers("/bucket/**", "/bucket", "/orders/**", "/orders", "/profile").access("hasRole('USER')")
                .antMatchers("/login", "/reg").anonymous()
                .antMatchers("/**").permitAll()
                .and()
                .formLogin()
                    .loginPage("/login")
                    .usernameParameter("email")
//                    .successHandler((req, resp, auth) -> {
//                        resp.sendRedirect(req.getSession().getAttribute("referURL").toString());
//                    })
                    .successHandler(new CustomSuccessHandler())
                    .failureUrl("/login?error=true")
                .and()
                .logout().logoutUrl("/logout").logoutSuccessUrl("/")
                .and().csrf().disable();

    }


    @Autowired
    public void configureGlobalSecurity(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService);
        auth.authenticationProvider(getAuthenticationProvider());
    }

    @Bean
    public DaoAuthenticationProvider getAuthenticationProvider() {
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(userDetailsService);
        authenticationProvider.setPasswordEncoder(passwordEncoder());
        return authenticationProvider;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
