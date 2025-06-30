package com.example.eTestCenter.configuaration;

import com.example.eTestCenter.entity.User;
import com.example.eTestCenter.enums.Role;
import com.example.eTestCenter.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.HashSet;

@Configuration
@Slf4j
public class ApplicationConfig {
    PasswordEncoder passwordEncoder;
    ApplicationConfig(PasswordEncoder passwordEncoder){
        this.passwordEncoder = passwordEncoder;
    }
    @Bean
    ApplicationRunner applicationRunner(UserRepository userRepository){
        return args -> {
            if(userRepository.findByEmail("tranquangthuan132@gmail.com").isEmpty()){
                var roles = new HashSet<String>();
                roles.add(Role.ADMIN.name());
                User user = User.builder()
                        .name("admin")
                        .phone("123456789")
                        .password(passwordEncoder.encode("12112004"))
                        .roles(roles)
                        .email("tranquangthuan132@gmail.com")
                        .build();
                userRepository.save(user);
                log.warn("admin user has been created with default password: admin, please change it");
            }
        };
    }
}
