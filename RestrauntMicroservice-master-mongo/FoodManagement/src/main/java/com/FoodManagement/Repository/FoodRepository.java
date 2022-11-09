package com.FoodManagement.Repository;

import com.FoodManagement.model.FoodDetails;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface FoodRepository extends MongoRepository<FoodDetails,Integer> {
    List<FoodDetails> findByRid(int rid);
}
