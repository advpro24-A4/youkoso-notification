package id.ac.ui.cs.advprog.youkosonotification.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.ConsumerFactory;

@Configuration
public class KafkaConfig {

    @Bean
    public ConsumerFactory<String, String> consumerFactory() {
        return null;
    }
}
