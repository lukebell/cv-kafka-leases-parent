package ar.com.cablevision;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

@SpringBootApplication
@PropertySources({
        @PropertySource("classpath:config/wd2k-db.properties")
})
public class LeasesWD2KApplication {

    public static void main(String[] args) {
        SpringApplication.run(LeasesWD2KApplication.class, args);
    }
}
