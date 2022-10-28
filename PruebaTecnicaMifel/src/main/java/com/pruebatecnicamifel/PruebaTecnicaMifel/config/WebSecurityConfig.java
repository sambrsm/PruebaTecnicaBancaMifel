package com.pruebatecnicamifel.PruebaTecnicaMifel.config;

import static org.springframework.security.config.Customizer.withDefaults;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {



  @Override
  @Bean
  public AuthenticationManager authenticationManagerBean() throws Exception {
    return super.authenticationManagerBean();
  }

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http
        .httpBasic(withDefaults())  // (1)
        .csrf().disable() // (2)
        .authorizeRequests()
        .antMatchers("/cifrado/**").hasRole("ADMIN")
        .antMatchers("/pokemon/**").hasRole("ADMIN")
        .antMatchers("/productos/**").hasRole("ADMIN")

        .anyRequest().authenticated();
        
  }


  @Override
  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
  

    
    auth
        .inMemoryAuthentication()
     
        .withUser("mifel").password("{noop}" + "mifel").roles("ADMIN");
     
  }



  /*
  * (1) Spring Security’s HTTP Basic Authentication support in is enabled by default. However, as soon as any servlet
  * based configuration is provided, HTTP Basic must be explicitly provided.
  * (2) If our stateless API uses token-based authentication, such as JWT, we don't need CSRF protection
  *
  *
  * */
}