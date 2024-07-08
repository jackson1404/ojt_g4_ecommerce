package com.group4.ecommerce_system.configuration;

import java.io.IOException;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import com.group4.ecommerce_system.security.UserDetailsServiceImpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

	@Autowired
	private UserDetailsServiceImpl userDetailsServiceImpl;

	@Bean
	static PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
		httpSecurity.csrf(AbstractHttpConfigurer::disable).cors(Customizer.withDefaults())
				.httpBasic(AbstractHttpConfigurer::disable)
				.authorizeHttpRequests(auth -> auth.requestMatchers("/auth/login").permitAll()
						.requestMatchers("/customer/**").hasAuthority("ROLE_USER")
						.requestMatchers("/admin/**").hasAuthority("ROLE_ADMIN").requestMatchers("/static/**").permitAll()
						.requestMatchers("/static/images/**").permitAll().anyRequest().authenticated())
				.exceptionHandling(exceptionHandling -> exceptionHandling.accessDeniedPage("/auth/accessDenied"))
				.formLogin(form -> form.loginPage("/auth/login").loginProcessingUrl("/signIn")
						.successHandler(customerAuthenticationSuccessHandler())
						.failureHandler(authenticationFailureHandler()).permitAll())
				.logout(logout -> logout.logoutUrl("/signOut").logoutSuccessUrl("/auth/login")
						.logoutSuccessHandler((request, response, authentication) -> {
							response.sendRedirect("/auth/login");
						}).invalidateHttpSession(true).deleteCookies("JSESSIONID", "remember-me").permitAll());

		return httpSecurity.build();
	}

	@Bean
	UserDetailsServiceImpl userDetailService() {
		return new UserDetailsServiceImpl();
	}

	@Bean
	UserDetailsService userDetailsService() {
		InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
		manager.createUser(
				User.withUsername("admin").password(passwordEncoder().encode("password")).roles("ADMIN").build());
		manager.createUser(
				User.withUsername("user").password(passwordEncoder().encode("password")).roles("USER").build());
		return manager;
	}

	@Bean
	AuthenticationEntryPoint authenticationEntryPoint() {
		return (request, response, authException) -> {
			response.sendRedirect("/auth/login");
		};
	}

	@Bean
	AuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
		daoAuthenticationProvider.setUserDetailsService(userDetailsServiceImpl);
		daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
		return daoAuthenticationProvider;
	}

	@Bean
	AuthenticationFailureHandler authenticationFailureHandler() {
		return (request, response, exception) -> {
			String errorMessageString = "Incorrect username or password.";
			request.getSession().setAttribute("errorMessage", errorMessageString);
			response.sendRedirect("/auth/login?error");
		};
	}

	@Bean
	AuthenticationSuccessHandler customerAuthenticationSuccessHandler() {
		return new AuthenticationSuccessHandler() {
			@Override
			public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
					Authentication authentication) throws IOException, ServletException {
				Set<String> authorities = AuthorityUtils.authorityListToSet(authentication.getAuthorities());
				System.out.println("User Roles: " + authorities);
				if (authorities.contains("ROLE_ADMIN")) {
					response.sendRedirect("/admin/dashboard");
				} else if (authorities.contains("ROLE_USER")) {
					response.sendRedirect("/customer/customerIndex");
				} else {
					response.sendRedirect("/customer");
				}
			}
		};
	}
}
