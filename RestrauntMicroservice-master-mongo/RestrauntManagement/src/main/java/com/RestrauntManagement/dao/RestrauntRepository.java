package com.RestrauntManagement.dao;

import com.RestrauntManagement.model.RestrauntDetails;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RestrauntRepository extends MongoRepository<RestrauntDetails,Integer> {
}
