package com.RestrauntManagement.controller;

import com.RestrauntManagement.dao.RestrauntRepository;
import com.RestrauntManagement.model.RestrauntDetails;
import com.RestrauntManagement.service.RestrauntService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/resto")
public class RestrauntController {

    @Autowired
    RestrauntService service;

    @Autowired
    RestrauntRepository repo;

    @Autowired
    private RestTemplate restTemplate;

    @PostMapping("/add")
    public RestrauntDetails addRestraunt(@RequestBody RestrauntDetails restrauntDetails){
        return service.addRestraunt(restrauntDetails);
    }

    @GetMapping("/get")
    public List<Optional<RestrauntDetails>> getAll() {
        Long size = repo.count();
        List<Optional<RestrauntDetails>> details;
        details = new ArrayList<>();
        for (int i = 1; i <= size; i++) {
            Optional<RestrauntDetails> restrauntDetails = repo.findById(i);
            List foodDetails = restTemplate.getForObject("http://food-service/get/" + i, List.class);
            restrauntDetails.get().setFoodDetails(foodDetails);
            details.add(restrauntDetails);
        }
        return details;
    }

    @GetMapping("/get/{rid}")
    public ResponseEntity<RestrauntDetails> findByRid(@PathVariable int rid){
        Optional<RestrauntDetails> restrauntDetails=repo.findById(rid);
        List foodDetails = restTemplate.getForObject("http://food-service/get/" + rid, List.class);
        restrauntDetails.get().setFoodDetails(foodDetails);
        return ResponseEntity.ok(restrauntDetails.get());
    }
    @PutMapping("/update")
    public ResponseEntity<RestrauntDetails> update(@RequestBody RestrauntDetails resto) {
        return ResponseEntity.ok(service.save(resto));
    }
    @DeleteMapping("/delete/{fid}")
    public ResponseEntity delete(@PathVariable Integer rid){

        return ResponseEntity.ok(service.delete(rid));
    }
}
