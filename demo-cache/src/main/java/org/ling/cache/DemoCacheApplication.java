package org.ling.cache;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@MapperScan("org.ling.common.mapper")
@SpringBootApplication
//开启缓存
@EnableCaching
public class DemoCacheApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoCacheApplication.class, args);
    }

}
