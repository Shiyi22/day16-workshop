package ibf.batch2.ssf.day16_workshop.Repo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import ibf.batch2.ssf.day16_workshop.model.Payload;

@Repository
public class PayloadRepo {

    public static final String HASH_KEY_NAME = "Payload-Item"; 

    @Autowired
    private RedisTemplate redisTemplate; 

    public Payload save(Payload payload) {
        redisTemplate.opsForHash().put(HASH_KEY_NAME, payload.getId(), payload);
        return payload;  
    }

    public List<Payload> findAll() {
        List<Payload> payloads = new ArrayList<>(redisTemplate.opsForHash().entries(HASH_KEY_NAME).values()); 
        return payloads; 
    }

    public Payload findById(Integer id) {
        return (Payload) redisTemplate.opsForHash().get(HASH_KEY_NAME, id); 
    }

    public String deletePayloadbyId (Integer id) {
        Long result = redisTemplate.opsForHash().delete(HASH_KEY_NAME, id); 
        
        if (result >= 0) {
            return "Deleted"; 
        } else {
            return "Failed";    
        }
    }
}
