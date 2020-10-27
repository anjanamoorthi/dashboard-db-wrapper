/**
 * @author Moorthi Rajan
 * @version 0.0.1
 * @since 03/10/2020
 */

package com.invenco.dashboardAPIHandler.DBWrapper;

import com.invenco.dashboardAPIHandler.DBWrapper.rest.model.Importance;
import com.invenco.dashboardAPIHandler.DBWrapper.rest.model.Product;
import com.invenco.dashboardAPIHandler.DBWrapper.rest.model.ReleaseStatus;
import com.invenco.dashboardAPIHandler.DBWrapper.rest.repository.ProductRepository;
import com.invenco.dashboardAPIHandler.DBWrapper.rest.repository.ReleaseStatusRepository;
import com.invenco.dashboardAPIHandler.DBWrapper.rest.repository.TestImpRepository;
import org.modelmapper.ModelMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2WebMvc;

@SpringBootApplication
@EnableAutoConfiguration
public class DbWrapperApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(DbWrapperApplication.class, args);
    }

    @Bean
    public CommandLineRunner ProductData(ProductRepository repo) {
        return args -> {
            if (repo.findAll().isEmpty()) {
                repo.save(new Product("G6200"));
                repo.save(new Product("G7100-12inch"));
                repo.save(new Product("G7100-15inch"));
                repo.save(new Product("G7100-8inch"));
            }
        };
    }

    @Bean
    public CommandLineRunner ReleaseStatusData(ReleaseStatusRepository repo) {
        return args -> {
            if (repo.findAll().isEmpty()) {
                repo.save(new ReleaseStatus("INPROGRESS"));
                repo.save(new ReleaseStatus("COMPLETED"));
                repo.save(new ReleaseStatus("REJECTED"));
                repo.save(new ReleaseStatus("ONHOLD"));
            }
        };
    }

    @Bean
    public CommandLineRunner TestImportanceData(TestImpRepository repo) {
        return args -> {
            if (repo.findAll().isEmpty()) {
                repo.save(new Importance("UNDEFINED"));
                repo.save(new Importance("FATAL"));
                repo.save(new Importance("CRITICAL"));
                repo.save(new Importance("HIGH"));
                repo.save(new Importance("MEDIUM"));
                repo.save(new Importance("LOW"));
            }
        };
    }

    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }

}
