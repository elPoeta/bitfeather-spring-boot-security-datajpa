
package io.elpoeta.bitfeather.seguridad.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 *
 * @author elpoeta
 */
@Configuration
@EnableGlobalMethodSecurity (securedEnabled = true)
public class ConfiguracionSeguridad extends WebSecurityConfigurerAdapter{
	@Autowired
	private UserDetailsService userDetailsService;

	 @Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		 auth.userDetailsService(userDetailsService).passwordEncoder(encriptarPass());
	}

		@Override
		protected void configure(HttpSecurity http) throws Exception {
			http.csrf().disable();
//			http
//			.authorizeRequests()
//			.antMatchers("/a/**").permitAll()
//			.antMatchers("/admin/view/**").permitAll()
//			.antMatchers("/admin/view/rol/**").hasRole("ADMIN")
//			.anyRequest()
//			.authenticated()
//			.and().formLogin().usernameParameter("nombre")
//			.and().logout();
		}
	 @Bean
	 public BCryptPasswordEncoder encriptarPass() {
		return new BCryptPasswordEncoder();
	  }

}
