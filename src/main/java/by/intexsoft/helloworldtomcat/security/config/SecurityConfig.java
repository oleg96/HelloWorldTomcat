package by.intexsoft.helloworldtomcat.security.config;

import by.intexsoft.helloworldtomcat.security.auth.*;
import by.intexsoft.helloworldtomcat.service.impl.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.logout.HttpStatusReturningLogoutSuccessHandler;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;

@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    public TokenAuthenticationFilter jwtAuthenticationTokenFilter() throws Exception {
        return new TokenAuthenticationFilter();
    }

    @Bean
    public JwtLogoutHandler jwtLogoutHandler() {
        return new JwtLogoutHandler();
    }

    @Autowired
    CustomUserDetailsService jwtUserDetailsService;

    @Autowired
    RestAuthenticationEntryPoint restAuthenticationEntryPoint;

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(jwtUserDetailsService);
    }

    @Autowired
    private AuthenticationSuccessHandler authenticationSuccessHandler;

    @Autowired
    private AuthenticationFailureHandler authenticationFailureHandler;


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf()
                .csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse()).and()
                .sessionManagement().sessionCreationPolicy( SessionCreationPolicy.STATELESS ).and()
                .exceptionHandling().authenticationEntryPoint( restAuthenticationEntryPoint ).and()
                .addFilterBefore(jwtAuthenticationTokenFilter(), BasicAuthenticationFilter.class)
                .authorizeRequests()
                .antMatchers("/", "/index.html").permitAll()
                  .anyRequest()
                    .authenticated().and()
                .formLogin()
                    .successHandler(authenticationSuccessHandler)
                    .failureHandler(authenticationFailureHandler).and()
                .logout()
                    .addLogoutHandler(jwtLogoutHandler())
                    .logoutSuccessHandler((new HttpStatusReturningLogoutSuccessHandler(HttpStatus.OK))) ;
    }

}
