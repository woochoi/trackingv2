package com.member.tracking.config.mongo;

import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.MongoDatabaseFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.convert.MongoConverter;


//@Configuration
//@EnableMongoRepositories( // 아래 basePackages 하위에 있는 몽고레파지토리는 아래 mongoTemplate 를 사용하게 해라
//        basePackages = "com.member.tracking",
//        mongoTemplateRef = MongoTemplateConfig.MONGO_TEMPLATE
//)
public class MongoTemplateConfig {
    // 아래 @Bean 이름!
    public static final String MONGO_TEMPLATE = "members";

    @Bean(name = MONGO_TEMPLATE)
    public MongoTemplate memberTrackingMongoTemplate(
            MongoDatabaseFactory memberTrackingMongoFactory
            , MongoConverter mongoConverter
    ) {
        return new MongoTemplate(memberTrackingMongoFactory, mongoConverter);
    }
}