package com.example.school.configuration;
import com.example.school.utilities.PasswordManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
@EnableWebSecurity
@Order(SecurityProperties.BASIC_AUTH_ORDER)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private UserDetailsService userDetailsService;
	
	@Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authProvider());
    }
	
	 
	@Bean
	public DaoAuthenticationProvider authProvider() {
	    DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
	    authProvider.setUserDetailsService(userDetailsService);
	    //authProvider.setPasswordEncoder();
	    return authProvider;
	}
	

    @Override
    protected void configure (HttpSecurity http) throws Exception{
    	http.csrf().disable().authorizeRequests()
          .antMatchers("/admin/**").hasRole("ADMIN")
		  .anyRequest().permitAll().and().formLogin().loginProcessingUrl("/login")
		  .usernameParameter("email").passwordParameter("password")
		  .defaultSuccessUrl("/profile").failureUrl("/login")
		  .and().logout().and().exceptionHandling()
		  .accessDeniedPage("/error/403");
 
	
//	    	 http.authorizeRequests().antMatchers("/admin/**").hasRole("ADMIN")
//             .anyRequest().permitAll().and().formLogin().loginPage("/login")
//             .usernameParameter("email").passwordParameter("password")
//             //.defaultSuccessUrl("/profile").failureUrl("/login")
//             .and().logout()
//             .logoutSuccessUrl("/")  .and().exceptionHandling()
//             .accessDeniedPage("/error/403").and().csrf();

		  }
	    
	    

}
