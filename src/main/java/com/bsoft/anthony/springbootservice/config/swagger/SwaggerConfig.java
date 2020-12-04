package com.bsoft.anthony.springbootservice.config.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

/**访问地址
 * http://10.0.38.90:8080/swagger-ui.html#/
 *项目名称：exchange-framework  <br>
 *类名称：SwaggerConfig <br>
 *类描述：<br>
 *创建人：ZQ <br>  
 *创建时间：2019年6月3日 下午2:43:54  <br> 
 *@version：    <br>
 *
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig extends WebMvcConfigurationSupport {

	@Bean
	public Docket createRestApi() {
		// 添加请求参数，我们这里把token作为请求头部参数传入后端
		ParameterBuilder parameterBuilder = new ParameterBuilder();
		List<Parameter> parameters = new ArrayList<Parameter>();
		parameterBuilder.name("Authorization").description("令牌").modelRef(new ModelRef("string")).parameterType("header")
				.required(false).build();
		parameters.add(parameterBuilder.build());

		return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo()).select()
				// api扫包
				.apis(RequestHandlerSelectors.basePackage("com.bsoft.anthony.springbootservice.controller")).paths(PathSelectors.any()).build().globalOperationParameters(parameters);
		// return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo()).select().apis(RequestHandlerSelectors.any())
		// 		.paths(PathSelectors.any()).build().globalOperationParameters(parameters);
	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("SpringBoot API Doc").description("This is a restful api document of Spring Boot.")
				.termsOfServiceUrl("")
				// .contact(contact)
				.version("1.0").build();
	}
	
	@Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/statics/**").addResourceLocations("classpath:/statics/");
        // 解决 SWAGGER 404报错
        registry.addResourceHandler("/swagger-ui.html").addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
        super.addResourceHandlers(registry);
    }

	

}