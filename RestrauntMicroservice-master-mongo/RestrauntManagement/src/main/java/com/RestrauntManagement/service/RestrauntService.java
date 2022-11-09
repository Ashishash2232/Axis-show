package com.RestrauntManagement.service;

import com.RestrauntManagement.dao.RestrauntRepository;
import com.RestrauntManagement.model.RestrauntDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RestrauntService {

    @Autowired
    RestrauntRepository repo;

    public RestrauntDetails addRestraunt(RestrauntDetails restrauntDetails){
        return repo.save(restrauntDetails);
    }

    public RestrauntDetails save(RestrauntDetails resto) {
        return repo.save(resto);
    }



    public String delete(Integer rid){
        repo.deleteById(rid);
        return "user delete success fully";
    }
}
