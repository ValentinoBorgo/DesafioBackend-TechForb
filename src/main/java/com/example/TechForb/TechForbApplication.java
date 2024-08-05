package com.example.TechForb;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class TechForbApplication {

	public static void main(String[] args) {
		System.out.println("TechForb------------------------->");
		SpringApplication.run(TechForbApplication.class, args);
	}

	@Value("${cors.allowed.origins}")
    private String[] allowedOrigins;

        @Bean
        public WebMvcConfigurer corsConfigurer() {
	return new WebMvcConfigurer() {
            @Override
		public void addCorsMappings(org.springframework.web.servlet.config.annotation.CorsRegistry registry) {
                    //we can provide other routes, further than the "/**".
			registry.addMapping("/**")
								.allowedOrigins(allowedOrigins)
                                .allowedMethods("GET","POST","PUT","DELETE","OPTIONS")
                                .allowedHeaders("Authorization","Content-Type","X-Requested-With", "multipart/form-data")
                                .allowCredentials(true);
		}
	};
}

}
