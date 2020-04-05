package com.projectrecipes.natashastojanova.foodrecipes;

import org.apache.coyote.http11.AbstractHttp11Protocol;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.embedded.tomcat.TomcatConnectorCustomizer;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.logging.Logger;

@SpringBootApplication
public class FoodrecipesApplication {

    public static void main(String[] args) {
        SpringApplication.run(FoodrecipesApplication.class, args);
    }

    @Bean
    public TomcatServletWebServerFactory tomcatEmbedded() {

        TomcatServletWebServerFactory tomcat = new TomcatServletWebServerFactory();

        tomcat.addConnectorCustomizers((TomcatConnectorCustomizer) connector -> {
            if ((connector.getProtocolHandler() instanceof AbstractHttp11Protocol<?>)) {
                //-1 means unlimited
                ((AbstractHttp11Protocol<?>) connector.getProtocolHandler()).setMaxSwallowSize(-1);
            }
        });
        return tomcat;
    }

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public Logger logger() {
        return Logger.getLogger(FoodrecipesApplication.class.getName());
    }

}
