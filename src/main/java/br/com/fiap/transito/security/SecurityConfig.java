package br.com.fiap.transito.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    private TokenVerify tokenVerify;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        return http
                .csrf(csrf -> csrf.disable())
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authorizeHttpRequests(authorize -> authorize
                        // Rotas públicas
                        .requestMatchers(HttpMethod.POST, "/central/registro").permitAll()
                        .requestMatchers(HttpMethod.POST, "/central/login").permitAll()

                        // Camera
                        .requestMatchers(HttpMethod.GET, "/api/camera").hasAnyRole("USER", "ADMIN")
                        .requestMatchers(HttpMethod.POST, "/api/camera").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.PUT, "/api/camera/**").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.DELETE, "/api/camera/**").hasRole("ADMIN")

                        // Veículo
                        .requestMatchers(HttpMethod.GET, "/api/veiculo").hasAnyRole("USER", "ADMIN")
                        .requestMatchers(HttpMethod.POST, "/api/veiculo").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.PUT, "/api/veiculo/**").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.DELETE, "/api/veiculo/**").hasRole("ADMIN")

                        // Qualquer outra rota precisa de autenticação
                        .anyRequest().authenticated()
                )
                .addFilterBefore(tokenVerify, UsernamePasswordAuthenticationFilter.class)
                .build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authConfig) throws Exception {
        return authConfig.getAuthenticationManager();
    }
}
