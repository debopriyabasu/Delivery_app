package config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.delivery.user.login.serviceImpl.UserDetailImplementation;

@Configuration
@EnableWebSecurity
public class Config 
{
	 @Bean
	    public PasswordEncoder passwordEncoder(){
	        return new BCryptPasswordEncoder();
	    }
	 
	    
	    @Bean
	    public UserDetailsService userDetailsService(){
	        return new UserDetailImplementation();
	    }
	    
	    @Bean
	    public AuthenticationProvider authenticationProvider(){
	        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
	        provider.setUserDetailsService(this.userDetailsService());
	        provider.setPasswordEncoder(passwordEncoder());
	        return provider;
	    }
	 
	 	
	  @Bean
	    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
	        http
	            .csrf(csrf -> csrf.disable())
	            .authorizeHttpRequests(auth -> auth
	               // .requestMatchers("/**").permitAll()
	                .requestMatchers("/admin/**").hasRole("ADMIN")
	                .requestMatchers("/user/**").hasRole("USER")
	                .requestMatchers("/register").permitAll()
	                .anyRequest().authenticated()
	            )
	            .formLogin(Customizer.withDefaults());
	        
	        /*
	         *   .formLogin(form -> form
                .loginPage("/login")
                .loginProcessingUrl("/perform-login")
                .defaultSuccessUrl("/dashboard", true)
                .permitAll()
            )
            .logout(logout -> logout
                .logoutUrl("/logout")
                .logoutSuccessUrl("/logout-success")
                .permitAll()
            );
	         */

	        return http.build();
	    }

}
