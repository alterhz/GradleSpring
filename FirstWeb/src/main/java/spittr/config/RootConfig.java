package spittr.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.context.annotation.ComponentScan.Filter;

@Configuration
@ComponentScan(basePackages = {"spittr.root"}, 
	excludeFilters = {
		@Filter(type=FilterType.ANNOTATION, value = EnableWebMvc.class)
	})
public class RootConfig {

}
