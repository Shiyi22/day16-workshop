package ibf.batch2.ssf.day16_workshop.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ibf.batch2.ssf.day16_workshop.Repo.BoardgameRepo;
import ibf.batch2.ssf.day16_workshop.model.Boardgame;

@RestController
@RequestMapping("/api/boardgame")
public class BoardgameController {

    @Autowired
    private BoardgameRepo boardgameRepo; 

    @PostMapping
    public ResponseEntity<Boardgame> save(@RequestBody Boardgame boardgame) {
        Boardgame bg = boardgameRepo.save(boardgame); 
        return new ResponseEntity<>(bg, HttpStatus.OK);
    }    

    @GetMapping("/{id}")
    public ResponseEntity<Boardgame> findById(@PathVariable Integer id) {
        Boardgame bg = boardgameRepo.findBoardgameById(id); 
        return new ResponseEntity<Boardgame>(bg, HttpStatus.OK); 
    }

    @PutMapping
    public ResponseEntity<Boardgame> update(@RequestBody Boardgame boardgame) {
        Boardgame bg = boardgameRepo.update(boardgame); 
        return new ResponseEntity<Boardgame>(bg, HttpStatus.OK); 
    }
}
