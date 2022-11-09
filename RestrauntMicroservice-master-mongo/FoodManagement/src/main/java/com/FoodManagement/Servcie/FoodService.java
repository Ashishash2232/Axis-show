package com.FoodManagement.Servcie;

import com.FoodManagement.Repository.FoodRepository;
import com.FoodManagement.model.FoodDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FoodService {

    @Autowired
    private FoodRepository repo;

    public FoodDetails addFood(FoodDetails details) {
        return repo.save(details);
    }

    public FoodDetails save(FoodDetails employee) {
        return repo.save(employee);
    }


//    public Optional<FoodDetails> findById(Integer fid) {
//        return repo.deleteById(fid);
//    }

public String delete(Integer fid){
         repo.deleteById(fid);
         return "user delete success fully";
    }
}
