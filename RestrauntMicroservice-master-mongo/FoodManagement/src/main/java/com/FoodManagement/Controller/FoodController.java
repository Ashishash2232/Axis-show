package com.FoodManagement.Controller;

import com.FoodManagement.Repository.FoodRepository;
import com.FoodManagement.Servcie.FoodService;
import com.FoodManagement.model.FoodDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/food")
public class FoodController {

    @Autowired
    private FoodService service;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private FoodRepository repo;

    @PostMapping("/add")
    public FoodDetails addFood(@RequestBody FoodDetails details){
        return service.addFood(details);
    }

    @GetMapping("/get")
    public ResponseEntity<List<FoodDetails>> getAll(){
        return ResponseEntity.ok(repo.findAll());
    }

    @GetMapping("/get/{rid}")
    public List<FoodDetails> getFood(@PathVariable int rid){
        return repo.findByRid(rid);
    }

    @PutMapping("/update")
    public ResponseEntity<FoodDetails> update(@RequestBody FoodDetails food) {
        return ResponseEntity.ok(service.save(food));
    }
//    @DeleteMapping("/{id}")
//    public ResponseEntity<FoodDetails> delete(@PathVariable Long id) {
//        service.findById(id).ifPresent(service::delete);
//        return ResponseEntity.ok().build();
//    }
    @DeleteMapping("/delete/{fid}")
    public ResponseEntity delete(@PathVariable Integer fid){

        return ResponseEntity.ok(service.delete(fid));
    }
}
