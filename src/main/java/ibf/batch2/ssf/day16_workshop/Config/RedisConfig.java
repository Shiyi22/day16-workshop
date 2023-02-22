package ibf.batch2.ssf.day16_workshop.Config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@Configuration
@EnableRedisRepositories
public class RedisConfig {

    @Value("${redis.host}")
    private String redisHost; 

    @Value("${redis.port}")
    private Integer redisPort; 
    
    // configure database part is split into separate function (slide 19)
    @Bean
    public JedisConnectionFactory jedisConnectionFactory() {
        RedisStandaloneConfiguration config = new RedisStandaloneConfiguration(); 
        config.setHostName(redisHost);
        config.setPort(redisPort);
        return new JedisConnectionFactory(config); 

    }

    // @Bean
    // @Scope("singleton")
    public RedisTemplate<String, Object> redisTemplate() {

        // create template (without jedisClient)
        RedisTemplate<String, Object> redisTemplate = new RedisTemplate<>(); 
        redisTemplate.setConnectionFactory(jedisConnectionFactory());
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.setHashKeySerializer(new StringRedisSerializer());
        redisTemplate.setHashKeySerializer(new JdkSerializationRedisSerializer());
        redisTemplate.setHashValueSerializer(new JdkSerializationRedisSerializer());
        redisTemplate.setEnableTransactionSupport(true); // if one pass, all will save, if one fail, all will not be written
        redisTemplate.afterPropertiesSet();
        return redisTemplate; 
    }
}
