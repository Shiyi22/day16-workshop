package ibf.batch2.ssf.day16_workshop.model;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import lombok.Data;

@RedisHash("payload")
public class Payload implements Serializable {
    
    @Id
    private Integer id;
    
    private String itemName;

    public Payload() {
    }

    public Payload(Integer id, String itemName) {
        this.id = id;
        this.itemName = itemName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    } 
}
