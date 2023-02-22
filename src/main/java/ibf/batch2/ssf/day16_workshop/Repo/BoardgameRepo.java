package ibf.batch2.ssf.day16_workshop.Repo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import ibf.batch2.ssf.day16_workshop.model.Boardgame;

@Repository
public class BoardgameRepo {

    @Autowired
    private RedisTemplate redisTemplate; 

    public Boardgame save(Boardgame boardgame) {
        redisTemplate.opsForValue().set(boardgame.getId(), boardgame);
        return boardgame; 
    } 
    
    public Boardgame findBoardgameById(Integer id) {

        Boardgame bg = (Boardgame) redisTemplate.opsForValue().get(id); 
        return bg; 
    }

    public Boardgame update(Boardgame boardgame) {
        Boolean result = redisTemplate.opsForValue().setIfPresent(boardgame.getId(), boardgame); 
        return boardgame; 
    }

}
