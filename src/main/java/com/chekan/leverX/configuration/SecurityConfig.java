package com.chekan.leverX.configuration;

import com.chekan.leverX.dao.UserDAO;
import com.chekan.leverX.service.impl.UserSecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter{

    @Autowired
    private PasswordEncoder passwordEncoder;

    private UserDAO userDAO;

    @Autowired
    public void setUserDao(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http
                .cors().disable()
                .csrf().disable()
                .authorizeRequests()
                .antMatchers(HttpMethod.POST, "/games").hasAnyRole("TRADER", "ADMIN")
                .antMatchers(HttpMethod.PUT, "/games/{id}").hasAnyRole("TRADER", "ADMIN")
                .antMatchers(HttpMethod.POST, "/object").hasRole("TRADER")
                .antMatchers( "/admin/**").hasRole("ADMIN")
                .antMatchers( "/object/{id}").hasAnyRole("TRADER", "ADMIN")
                .antMatchers( "/my").authenticated()
                .antMatchers( "/object/approve/{id}").hasRole("ADMIN")
                .antMatchers(HttpMethod.DELETE, "/comments/{id}").authenticated()
                .antMatchers(HttpMethod.PUT, "/articles/{id}/comments").authenticated()
                .antMatchers(HttpMethod.PUT, "/comment/approve/{id}").hasRole("ADMIN")
                .and()
                .formLogin().permitAll().and().httpBasic()
                .and()
                .logout().logoutSuccessUrl("/");

    }

    @Bean
    public DaoAuthenticationProvider daoAuthenticationProvider() {
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setPasswordEncoder(passwordEncoder);
        authenticationProvider.setUserDetailsService(new UserSecurityService(userDAO));
        return authenticationProvider;
    }

}
