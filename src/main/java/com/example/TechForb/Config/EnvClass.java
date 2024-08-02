package com.example.TechForb.Config;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EnvClass {

    @Bean
    public Dotenv dotenv() {
        // String envFilePath = Paths.get("").toAbsolutePath().toString() + "/.env";
        // String envFilePath = Paths.get("/src/main/resources").toAbsolutePath().toString() + "/.env";
        // System.out.println("Ruta del archivo .env: " + envFilePath);
        // String envFilePath = "/src/main/resources/.env";
        return Dotenv.configure().load();
    }

}
