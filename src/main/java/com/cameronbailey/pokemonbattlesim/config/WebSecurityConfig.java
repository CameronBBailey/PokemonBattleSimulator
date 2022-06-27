package com.cameronbailey.pokemonbattlesim.config;

import javax.sql.DataSource;

import com.cameronbailey.pokemonbattlesim.service.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
//    @Autowired
//    private DataSource dataSource;

    @Bean /* Creates a new instance of our customUserDetailsService */
    public UserDetailsService userDetailsService() {
        return new CustomUserDetailsService();
    }

    @Bean /* Creates a new new instance of our password encoder */
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService());
        authProvider.setPasswordEncoder(passwordEncoder());

        return authProvider;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authenticationProvider());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/team", "/team/{userId}", "/team/new", "/team/edit/{teamId}", "/team/edit/editTeamMember/{teamId}/{teamMemberId}").authenticated()/* Sets what pages you need to be authenticated to view */
                .anyRequest().permitAll()
                .and()
                .formLogin()
                .loginPage("/login")
                .permitAll()
                    .usernameParameter("email")/* Sets which param userd to log in */
                    .defaultSuccessUrl("/team")/* Redirects after a successful login */
                    .permitAll()
                .and()
                .logout().logoutSuccessUrl("/").permitAll();/* Redirects after a successful logout */
    }


}