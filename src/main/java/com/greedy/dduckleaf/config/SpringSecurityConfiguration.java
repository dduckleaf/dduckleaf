package com.greedy.dduckleaf.config;

import com.greedy.dduckleaf.authentication.model.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import java.util.List;
import java.util.Map;

@EnableWebSecurity
public class SpringSecurityConfiguration extends WebSecurityConfigurerAdapter {

    private final AuthenticationService authenticationService;

    @Autowired
    public SpringSecurityConfiguration(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {

        return new BCryptPasswordEncoder();
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/css/**", "/js/**", "/images/**", "/upload/**");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        Map<String, List<String>> permitListMap = authenticationService.getPermitListMap();
        List<String> adminPermitList = permitListMap.get("adminPermitList");
        List<String> memberPermitList = permitListMap.get("memberPermitList");

        http.csrf().disable()
                .authorizeHttpRequests()
                .antMatchers("/member/login").permitAll()

                .antMatchers(memberPermitList.toArray(new String[memberPermitList.size()])).hasAnyRole("MEMBER", "ADMIN")
                .antMatchers(adminPermitList.toArray(new String[adminPermitList.size()])).hasRole("ADMIN")
                .anyRequest().permitAll()
            .and()
                .formLogin()
                .loginPage("/member/login")
                .successForwardUrl("/member/loginSuccess")
                .failureForwardUrl("/error/login")
            .and()
                .logout()
                .logoutRequestMatcher(new AntPathRequestMatcher("/member/logout"))
                .deleteCookies("JSESSIONID")
                .logoutSuccessUrl("/member/login")
                .invalidateHttpSession(true)
            .and()
                .exceptionHandling()
                .accessDeniedPage("/error/denied");
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(authenticationService).passwordEncoder(passwordEncoder());
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
}
