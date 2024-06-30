package pl.edu.wszib.jwd.jwd_colors;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;


@PropertySource("classpath:db.properties")
@SpringBootApplication
public class JwdColorsApplication {

    public static void main(String[] args) {
        SpringApplication.run(JwdColorsApplication.class, args);
    }

}
