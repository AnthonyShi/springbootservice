package com.bsoft.anthony.springbootservice;

import com.bsoft.anthony.springbootservice.config.ds.DBConfigHis;
import com.bsoft.anthony.springbootservice.config.ds.DBConfigSys;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@EnableConfigurationProperties(value = { DBConfigHis.class, DBConfigSys.class})
@SpringBootApplication(scanBasePackages = {"com.bsoft.anthony.springbootservice"},exclude = DataSourceAutoConfiguration.class)
public class SpringbootserviceApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootserviceApplication.class, args);
    }

}
