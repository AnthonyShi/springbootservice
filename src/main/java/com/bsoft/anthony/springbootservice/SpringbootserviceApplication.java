package com.bsoft.anthony.springbootservice;

import com.bsoft.anthony.springbootservice.config.ds.DBConfigHis;
import com.bsoft.anthony.springbootservice.config.ds.DBConfigSys;
import com.bsoft.anthony.springbootservice.config.security.VerifyServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@EnableConfigurationProperties(value = { DBConfigHis.class, DBConfigSys.class})
@SpringBootApplication(scanBasePackages = {"com.bsoft.anthony.springbootservice"},exclude = DataSourceAutoConfiguration.class)
public class SpringbootserviceApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootserviceApplication.class, args);
    }

    /**
     * 注入验证码servlet
     */
    @Bean
    public ServletRegistrationBean indexServletRegistration() {
        ServletRegistrationBean registration = new ServletRegistrationBean(new VerifyServlet());
        registration.addUrlMappings("/getVerifyCode");
        return registration;
    }
}
