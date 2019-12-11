package com.softwareComedians.ClinicalCenterApp.config;

import com.softwareComedians.ClinicalCenterApp.security.TokenUtils;
import com.softwareComedians.ClinicalCenterApp.security.auth.RestAuthenticationEntryPoint;
import com.softwareComedians.ClinicalCenterApp.security.auth.TokenAuthenticationFilter;
import com.softwareComedians.ClinicalCenterApp.service.impl.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private TokenUtils tokenUtils;

    @Autowired
    private CustomUserDetailsService jwtUserDetailsService;

    @Autowired
    private RestAuthenticationEntryPoint restAuthenticationEntryPoint;

    // Define the way of authentication
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(jwtUserDetailsService).passwordEncoder(passwordEncoder());
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public CorsFilter corsFilter() {
        final CorsConfiguration config = new CorsConfiguration();
        config.setAllowCredentials(true);
        config.addAllowedOrigin("*");
        config.addAllowedHeader("*");
        config.addAllowedMethod("*");
        config.setMaxAge(1800L);

        final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", config);

        return new CorsFilter(source);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
            .exceptionHandling().authenticationEntryPoint(restAuthenticationEntryPoint).and()
            .cors().and()

            // Allow all users to access URLs that have 'public' in them
            // Allow auth
            .authorizeRequests()
            .antMatchers("**/public/**").permitAll()
            .antMatchers("/auth/**").permitAll()
            .antMatchers("/api/**").permitAll()
            .antMatchers("**/api/**").permitAll()

                // All other requests must be authorized
            .anyRequest().authenticated().and()

            // Intercept every request with filter
            .addFilterBefore(new TokenAuthenticationFilter(tokenUtils, jwtUserDetailsService), BasicAuthenticationFilter.class);

        http.csrf().disable();
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        // TokenAuthenticationFilter will ignore all URLs below
        web.ignoring().antMatchers(HttpMethod.GET, "/", "/webjars/**", "/*.html", "/favicon.ico", "/**/*.html", "/**/*.css", "/**/*.js");
        web.ignoring().antMatchers(HttpMethod.POST, "/auth/login");
        web.ignoring().antMatchers(HttpMethod.POST, "/api/rooms");
        web.ignoring().antMatchers(HttpMethod.POST, "/api/ConsultType");
        web.ignoring().antMatchers(HttpMethod.GET, "/api/rooms/getAll");
        web.ignoring().antMatchers(HttpMethod.DELETE, "/api/rooms/del/{id}");
        web.ignoring().antMatchers(HttpMethod.DELETE, "/api/ConsultType/del/{id}");
        web.ignoring().antMatchers(HttpMethod.PUT, "/api/rooms/edit");
        web.ignoring().antMatchers(HttpMethod.POST, "/api/clinics");
        web.ignoring().antMatchers(HttpMethod.POST, "/api/RqForPatientReg");
        web.ignoring().antMatchers(HttpMethod.PUT, "/api/users/edit");

        // TokenAuthenticationFilter will ignore all paths that have 'public' in them
        web.ignoring().antMatchers(HttpMethod.GET, "/**/public/**");
        web.ignoring().antMatchers(HttpMethod.POST, "/**/public/**");
        web.ignoring().antMatchers(HttpMethod.PUT, "/**/public/**");
        web.ignoring().antMatchers(HttpMethod.DELETE, "/**/public/**");

        web.ignoring().antMatchers(HttpMethod.GET, "/**/api/**");
        web.ignoring().antMatchers(HttpMethod.POST, "/**/api/**");
        web.ignoring().antMatchers(HttpMethod.PUT, "/**/api/**");
        web.ignoring().antMatchers(HttpMethod.DELETE, "/**/api/**");


    }
}
