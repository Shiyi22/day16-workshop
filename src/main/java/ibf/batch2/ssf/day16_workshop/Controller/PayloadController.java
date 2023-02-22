package ibf.batch2.ssf.day16_workshop.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ibf.batch2.ssf.day16_workshop.Repo.PayloadRepo;
import ibf.batch2.ssf.day16_workshop.model.Payload;

@RestController
@RequestMapping("/api/payload")
public class PayloadController {
    
    @Autowired
    private PayloadRepo payloadRepo; 

    @PostMapping
    public ResponseEntity<Payload> save(@RequestBody Payload payload) {
        Payload pLoad = payloadRepo.save(payload);
        return new ResponseEntity<Payload>(pLoad, HttpStatus.OK); 
    }

    @GetMapping
    public ResponseEntity<List<Payload>> findAll() {
        List<Payload> payloads = payloadRepo.findAll(); 
        return new ResponseEntity<>(payloads, HttpStatus.OK); 
    }

    @GetMapping("/{id}")
    public ResponseEntity<Payload> findById(@PathVariable int id) {
        Payload pLoad = payloadRepo.findById(id); 
        return new ResponseEntity<>(pLoad,HttpStatus.OK); 
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteById(@PathVariable int id) {
        String result = payloadRepo.deletePayloadbyId(id); 
        return new ResponseEntity<>(result, HttpStatus.OK);
    }


}
