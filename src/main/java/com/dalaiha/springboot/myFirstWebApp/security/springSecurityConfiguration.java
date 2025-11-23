package com.dalaiha.springboot.myFirstWebApp.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import java.util.function.Function;
import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
public class springSecurityConfiguration {
    // Bean PasswordEncoder
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    // Bean InMemoryUserDetailsManager avec la fonction passwordEncoder
    @Bean
    public InMemoryUserDetailsManager userDetailsService() {

        UserDetails user1 = createNewUser("didi", "dummy");
        UserDetails user2 = createNewUser("momo", "ymmud");

        return new InMemoryUserDetailsManager(user1,user2);
    }

    private UserDetails createNewUser(String username, String password) {
        // Fonction pour encoder les mots de passe
        Function<String, String> passwordEncoder =
                input -> passwordEncoder().encode(input);

        UserDetails user = User.builder()
                .username(username)
                .passwordEncoder(passwordEncoder) // applique la fonction
                .password(password) // mot de passe clair à encoder
                .roles("USER", "ADMIN")
                .build();
        return user;
    }

    // Configuration minimale de sécurité
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(auth -> auth.anyRequest().authenticated())
                .formLogin(withDefaults())
                .httpBasic(withDefaults());

        http.csrf(csrf -> csrf.disable());
        http.headers(headers -> headers.frameOptions(frame -> frame.disable()));

        return http.build();
    }


}
