package com.clinic.app.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import static com.clinic.app.security.ApplicationUserPermission.USER_READ;
import static com.clinic.app.security.ApplicationUserPermission.USER_WRITE;
import static com.clinic.app.security.ApplicationUserRole.ADMIN;
import static com.clinic.app.security.ApplicationUserRole.USER;


@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class ApplicationSecurityConfig extends WebSecurityConfigurerAdapter {
        private final PasswordEncoder passwordEncoder;

        @Autowired
        public ApplicationSecurityConfig(PasswordEncoder passwordEncoder) {
                this.passwordEncoder = passwordEncoder;
        }

        @Override
        protected void configure(HttpSecurity http) throws Exception {
                http
                        .csrf().disable()
                        .authorizeRequests()
                        .antMatchers("/", "index", "/css/*", "/js/*", "/departments").permitAll()
                        .antMatchers(HttpMethod.DELETE, "/api/**").hasAuthority(USER_WRITE.getPermission())
                        .antMatchers(HttpMethod.POST, "/api/**").hasAuthority(USER_WRITE.getPermission())
                        .antMatchers(HttpMethod.PUT, "/api/**").hasAuthority(USER_WRITE.getPermission())
                        .antMatchers(HttpMethod.GET, "/api/**").hasAuthority(USER_READ.getPermission())
                        .anyRequest()
                        .authenticated()
                        .and()
                        .httpBasic();
        }

        @Override
        @Bean
        protected UserDetailsService userDetailsService() {
                UserDetails gigelUser = User.builder()
                        .username("user")
                        .password(passwordEncoder.encode("password"))
                        .authorities(USER.getGrantedAuthorities())
                        .build();

                UserDetails cucuUser = User.builder()
                        .username("admin")
                        .password(passwordEncoder.encode("password"))
                        .authorities(ADMIN.getGrantedAuthorities())
                        .build();

                return new InMemoryUserDetailsManager(
                        gigelUser,
                        cucuUser
                );
        }

}
