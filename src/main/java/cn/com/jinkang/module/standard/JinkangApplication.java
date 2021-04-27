package cn.com.jinkang.module.standard;


import cn.com.jinkang.module.standard.config.ServerConfig;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.amqp.RabbitAutoConfiguration;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication(exclude = {
        RabbitAutoConfiguration.class
})
@MapperScan(basePackages = {"cn.com.jinkang.module.standard.dao"})
public class JinkangApplication {
    protected final static Logger logger = LoggerFactory.getLogger(JinkangApplication.class);
    public static void main(String[] args) {
        SpringApplication.run(JinkangApplication.class, args);
        new ServerConfig();
        logger.info("Application At {}", ServerConfig.getUrl());
        new ServerConfig();
        logger.info("Swagger At {}swagger-ui.html",  ServerConfig.getUrl());
    }

}
