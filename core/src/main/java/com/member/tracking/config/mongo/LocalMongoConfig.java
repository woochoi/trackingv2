package com.member.tracking.config.mongo;

import com.mongodb.ConnectionString;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDatabaseFactory;
import org.springframework.data.mongodb.core.SimpleMongoClientDatabaseFactory;

//@Profile("test")
//@Slf4j
//@RequiredArgsConstructor
//@Configuration
public class LocalMongoConfig {

    @Value("${spring.data.mongodb.uri}")
    private String mongoUri;

    @Bean(name = "memberTrackingMongoFactory") // MongoTemplateConfig 에서 가져다 사용한다
    //@Bean
    public MongoDatabaseFactory memberTrackingMongoFactory() {
        return new SimpleMongoClientDatabaseFactory(connectionString());
    }

    private ConnectionString connectionString() {
        return new ConnectionString(mongoUri);
    }
}
