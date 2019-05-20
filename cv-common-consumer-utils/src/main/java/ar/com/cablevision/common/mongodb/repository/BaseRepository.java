package ar.com.cablevision.common.mongodb.repository;

import ar.com.cablevision.common.mongodb.domain.BaseEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BaseRepository <T extends BaseEntity> extends MongoRepository<T, String> {

}
