package id.ac.ui.cs.advprog.youkosonotification.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import id.ac.ui.cs.advprog.youkosonotification.model.factory.INotificationFactory;
import id.ac.ui.cs.advprog.youkosonotification.model.factory.NotificationFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public ObjectMapper objectMapper() {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        return objectMapper;
    }

    @Bean
    public INotificationFactory notificationFactory(){
        return new NotificationFactory();
    }
}
