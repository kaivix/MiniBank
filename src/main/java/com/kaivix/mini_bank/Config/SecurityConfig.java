package com.kaivix.mini_bank.Config;

import com.kaivix.mini_bank.Service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.HttpStatusEntryPoint;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

// @Configuration говорит Spring, что этот класс является источником определения бинов.
@Configuration
// @EnableWebSecurity включает поддержку веб-безопасности.
@EnableWebSecurity
// @RequiredArgsConstructor генерирует конструктор для всех final полей.
@RequiredArgsConstructor
// @EnableGlobalMethodSecurity включает защиту на уровне метода.
@EnableGlobalMethodSecurity(securedEnabled = true)
public class SecurityConfig {
    // Объявление сервиса пользователей.
    private final UserService userService;
     private final JwtRequestFilter jwtRequestFilter;
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        http
                .csrf(csrf -> csrf.disable())
                .cors(cors -> cors.disable())
                .authorizeHttpRequests((requests) -> requests
                        .requestMatchers("/user/log").permitAll()
                        .requestMatchers("/user/reg").permitAll()
                        .requestMatchers("/admin").hasAuthority("ROLE_ADMIN")
                        .anyRequest().authenticated())
                         .sessionManagement(session -> session
                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                        .exceptionHandling(exceptions -> exceptions
                                .authenticationEntryPoint(new HttpStatusEntryPoint(HttpStatus.UNAUTHORIZED))
                        )
                        .httpBasic(Customizer.withDefaults())
                        .addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }

    // @Bean говорит Spring, что следующий метод генерирует бин, который должен быть управляем Spring.
    @Bean
    public DaoAuthenticationProvider daoAuthenticationProvider(){
        // Создание нового экземпляра DaoAuthenticationProvider.
        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
        // Установка кодировщика паролей.
        daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
        // Установка сервиса пользователей.
        daoAuthenticationProvider.setUserDetailsService(userService);
        // Возвращение экземпляра DaoAuthenticationProvider.
        return daoAuthenticationProvider;
    }

    // Создание бина BCryptPasswordEncoder.
    @Bean
    public BCryptPasswordEncoder passwordEncoder(){
        // Возвращение нового экземпляра BCryptPasswordEncoder.
        return  new BCryptPasswordEncoder();
    }

    // Создание бина AuthenticationManager.
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception{
        // Возвращение AuthenticationManager из AuthenticationConfiguration.
        return authenticationConfiguration.getAuthenticationManager();
    }
}
