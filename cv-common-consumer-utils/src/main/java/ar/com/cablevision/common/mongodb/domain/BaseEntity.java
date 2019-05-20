package ar.com.cablevision.common.mongodb.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@JsonIgnoreProperties(ignoreUnknown = true)
public interface BaseEntity extends Serializable {
}
