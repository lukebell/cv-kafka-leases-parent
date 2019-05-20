package ar.com.cablevision;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

@SpringBootApplication
@PropertySources({
        @PropertySource("classpath:config/mongo-db.properties")
})
public class LeasesMongoDBApplication {

    public static void main(String[] args) {
        SpringApplication.run(LeasesMongoDBApplication.class, args);
    }
}
