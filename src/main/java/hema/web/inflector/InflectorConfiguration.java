package hema.web.inflector;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

@Configuration
public class InflectorConfiguration {

    @Bean
    @Lazy
    public Inflector inflector() {
        return new Inflector(wordInflector());
    }

    @Bean
    @Lazy
    public WordInflector wordInflector() {
        return new Pluralizer();
    }
}
