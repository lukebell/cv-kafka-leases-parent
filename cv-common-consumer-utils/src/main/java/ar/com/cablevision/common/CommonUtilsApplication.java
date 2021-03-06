package ar.com.cablevision.common;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableAutoConfiguration
@EnableConfigurationProperties
@Configuration
@ComponentScan(basePackages = "ar.com.cablevision.common")
@EnableMongoRepositories("ar.com.cablevision.common.mongodb")
@PropertySources({
        @PropertySource("classpath:config/wd2k-db.properties"),
        @PropertySource("classpath:config/mongo-db.properties")
})
public class CommonUtilsApplication {

    public static void main(String[] args) {
        SpringApplication.run(CommonUtilsApplication.class, args);
    }

}