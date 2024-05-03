package com.example.demo.data;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PostgresData {
    @Bean
    @ConfigurationProperties('app.data')
    public Data data() {
        return DataSourceBuilder.create().type(Data.class).build();
    }
}
