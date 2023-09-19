package lk.ijse.TechLeadManageSystem.config;

import lk.ijse.TechLeadManageSystem.WebAppInitializer;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebMvc
@ComponentScan(basePackageClasses = WebAppInitializer.class,basePackages = "lk.ijse.TechLeadManageSystem")
public class WebAppConfig {

    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }
}
