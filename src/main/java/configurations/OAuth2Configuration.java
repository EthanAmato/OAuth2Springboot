package configurations;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.HttpStatusEntryPoint;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@SuppressWarnings(value = {"deprecation" })
@Configuration
@EnableWebSecurity //tells springsec that this is our web security config file
public class OAuth2Configuration extends WebSecurityConfigurerAdapter{
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		 http
         .authorizeRequests(a -> a //lets us make a lambda expression that takes obj 2 config
        		 				   //and modify it. We don't need to use .and() if we use this
             .antMatchers("/", "/index.html", "/error").permitAll()
             .anyRequest().authenticated()
         )
         .exceptionHandling(e -> e
             .authenticationEntryPoint(new HttpStatusEntryPoint(HttpStatus.UNAUTHORIZED))
         )
         .oauth2Login().defaultSuccessUrl("/", true)
		 .and()
         .logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
         .logoutSuccessUrl("/").deleteCookies("JSESSIONID")
         .invalidateHttpSession(true);
 }
	
}
