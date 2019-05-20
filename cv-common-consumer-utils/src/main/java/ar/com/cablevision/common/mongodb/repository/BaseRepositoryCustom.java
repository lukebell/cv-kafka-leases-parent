package ar.com.cablevision.common.mongodb.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;

public abstract class BaseRepositoryCustom {

    @Autowired
    protected MongoTemplate mongoTemplate;
}
