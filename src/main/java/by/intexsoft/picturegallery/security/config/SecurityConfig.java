package by.intexsoft.picturegallery.security.config;

import by.intexsoft.picturegallery.security.filter.AuthenticationTokenFilter;
import by.intexsoft.picturegallery.security.service.TokenAuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * Configuration for Spring Security
 */
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private TokenAuthenticationService tokenAuthenticationService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/", "/picture/pictures/**", "user/register", "/login").permitAll()
                .antMatchers(HttpMethod.POST, "/picture/add").hasAuthority("ROLE_ADMIN")
                .antMatchers(HttpMethod.POST, "/picture/edit").hasAuthority("ROLE_ADMIN")
                .antMatchers(HttpMethod.POST, "/picture/delete").hasAuthority("ROLE_ADMIN")
                .antMatchers(HttpMethod.GET, "/user/users").hasAuthority("ROLE_ADMIN")
                .antMatchers(HttpMethod.GET, "/user/users/**").hasAuthority("ROLE_ADMIN")
                .antMatchers(HttpMethod.POST, "/user/edit").hasAuthority("ROLE_ADMIN")
                .antMatchers(HttpMethod.POST, "/user/delete").hasAuthority("ROLE_ADMIN")
                .and()
                .addFilterBefore(new AuthenticationTokenFilter(tokenAuthenticationService), UsernamePasswordAuthenticationFilter.class)
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .csrf().disable();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService()).passwordEncoder(new BCryptPasswordEncoder());
    }

    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Override
    public UserDetailsService userDetailsServiceBean() throws Exception {
        return super.userDetailsServiceBean();
    }
}
