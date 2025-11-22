package com.dalaiha.springboot.myFirstWebApp.security;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import java.util.function.Function;

@Configuration
public class springSecurityConfiguration {

        // Fonction pour encoder les mots de passe
        private final Function<String, String> passwordEncoder = input -> passwordEncoder().encode(input);

        // Bean PasswordEncoder
        @Bean
        public PasswordEncoder passwordEncoder() {
            return new BCryptPasswordEncoder();
        }

        // Bean InMemoryUserDetailsManager avec la fonction passwordEncoder
        @Bean
        public InMemoryUserDetailsManager userDetailsService() {
            UserDetails user = User.builder()
                    .username("didi")
                    .passwordEncoder(passwordEncoder) // applique la fonction
                    .password("dummy") // mot de passe clair à encoder
                    .roles("USER", "ADMIN")
                    .build();

            return new InMemoryUserDetailsManager(user);
        }

        // Configuration minimale de sécurité
        @Bean
        public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
            http
                    .authorizeHttpRequests(auth -> auth.anyRequest().authenticated())
                    .formLogin(Customizer.withDefaults())
                    .httpBasic(Customizer.withDefaults());

            return http.build();
        }
    }
