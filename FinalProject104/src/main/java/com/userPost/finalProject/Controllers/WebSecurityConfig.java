// package com.userPost.finalProject.Controllers;

// import org.springframework.context.annotation.*;
// import org.springframework.security.core.userdetails.*;
// import org.springframework.security.config.annotation.web.builders.HttpSecurity;
// import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
// import org.springframework.security.provisioning.InMemoryUserDetailsManager;
// import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

// @Configuration
// @EnableWebSecurity
// public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
//     @Override
//     protected void configure(HttpSecurity http) throws Exception {
//         http
//             .authorizeRequests()
//                 .antMatchers("/", "/home", "/post", "/posts").permitAll()
//                 .anyRequest().authenticated()
//                 .and()
//             .formLogin()
//                 .loginPage("/login")
//                 .permitAll()
//                 .and()
//             .logout()
//                 .permitAll();
//     }

//     @Bean
//     @Override
//     public UserDetailsService userDetailsService() {
//         UserDetails user =
//              User.withDefaultPasswordEncoder()
//                 .username("Coding Ninja Genius")
//                 .password("me")
//                 .roles("USER")
//                 .build();

//         return new InMemoryUserDetailsManager(user);
//     }
// }