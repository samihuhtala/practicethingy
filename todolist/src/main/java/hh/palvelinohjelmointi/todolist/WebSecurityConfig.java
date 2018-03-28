package hh.palvelinohjelmointi.todolist;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import hh.palvelinohjelmointi.todolist.webcontrol.UserDetailServiceImpl;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	private UserDetailServiceImpl userDetailsService;
	
@Override
protected void configure(HttpSecurity http) throws Exception {
	http
	.authorizeRequests().antMatchers("/css/**", "/nouserview").permitAll()
	.and()
	.authorizeRequests()
	.antMatchers("/delete/{id}", "/edit/{id}").hasAuthority("ADMIN")
	.anyRequest().authenticated()
	.and()
	.formLogin()
	.loginPage("/login")
	.defaultSuccessUrl("/objectlist")
	.permitAll()
	.and()
	.logout()
	.permitAll();
}

@Autowired
public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
	auth.userDetailsService(userDetailsService).passwordEncoder(new BCryptPasswordEncoder());
	
}
}
