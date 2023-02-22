package ibf.batch2.ssf.day16_workshop.model;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@RedisHash("boardgame")
public class Boardgame implements Serializable {
    
    @Id
    private Integer id; 

    private Integer count; 
    
}
