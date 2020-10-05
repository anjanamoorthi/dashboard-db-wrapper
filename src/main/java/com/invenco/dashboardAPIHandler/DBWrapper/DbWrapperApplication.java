/**
 * @author Moorthi Rajan
 * @version 0.0.1
 * @since 03/10/2020
 */

package com.invenco.dashboardAPIHandler.DBWrapper;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2WebMvc;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

@SpringBootApplication
@EnableSwagger2WebMvc
@EnableAutoConfiguration
public class DbWrapperApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(DbWrapperApplication.class, args);
    }


    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build()
                .apiInfo(apiInfo());
    }

    ApiInfo apiInfo() {
        // version from version.properties
        String version = "2.0";
		/*try {
			InputStream stream = ClassLoader.getSystemResourceAsStream("version.properties");
			Properties p = new Properties();
			p.load(stream);
			version = p.getProperty("version");
		} catch (IOException e) {
			// do nothing
		} */

        return new ApiInfoBuilder().title("DB-Wrapper for Dashboard")
                .version(version)
                .build();
    }

}
