//package com.example.asm.config;
//
//import com.example.asm.entities.Role;
//import com.example.asm.entities.User;
//import com.example.asm.entities.UserRole;
//import com.example.asm.service.IRoleService;
//import com.example.asm.service.IUserService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.provisioning.InMemoryUserDetailsManager;
//import org.springframework.security.web.SecurityFilterChain;
//
//
//@Configuration
//@EnableWebSecurity
//public class WebSecurityConfig {
//
//    @Autowired
//    IUserService userService;
//
//    @Autowired
//    IUserRoleService userRoleService;
//
//    @Autowired
//    IRoleService roleService;
//
//
//    @Bean
//    public UserDetailsService userDetailsService(PasswordEncoder encoder) {
//        //get User
//        Role roleUser = roleService.getById(1);
//        UserRole ur = userRoleService.getByRole(roleUser);
//        User useru = userService.getById(ur.getUser().getId());
//
//        //get Admin
//        Role roleAdmin = roleService.getById(2);
//        UserRole urA = userRoleService.getByRole(roleAdmin);
//        User adminu = userService.getById(urA.getUser().getId());
//
//        UserDetails admin = org.springframework.security.core.userdetails.User.withUsername(adminu.getEmail())
//                .password(encoder.encode(adminu.getMatKhau())).authorities(new SimpleGrantedAuthority("ADMIN"))
//                .build();
//        UserDetails user = org.springframework.security.core.userdetails.User.withUsername(useru.getEmail())
//                .password(encoder.encode(useru.getMatKhau())).authorities(new SimpleGrantedAuthority("USER"))
//                .build();
//        return new InMemoryUserDetailsManager(admin,user);
//    }
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        return http.csrf().disable()
//                .authorizeHttpRequests()
//                .requestMatchers("/login", "/", "/js/*").permitAll()
//                .and()
//                .authorizeHttpRequests()
//                .requestMatchers("/client", "/cart", "/cart/**", "/sign-up-view",
//                        "/edit-user-view", "/sign-up-user", "/update-user/**").hasAnyAuthority("USER")
//                .requestMatchers("/admin", "/admin/**", "/ASM/quan-ly-tai-nghe", "/ASM/quan-ly-tai-nghe/**")
//                        .hasAnyAuthority("ADMIN")
//                .and().formLogin().loginProcessingUrl("/client")
//                .and().formLogin().loginProcessingUrl("/admin")
//                .and().build();
//    }
//
//}
