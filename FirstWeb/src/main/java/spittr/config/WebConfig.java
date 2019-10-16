package spittr.config;

import java.io.IOException;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration
@EnableWebMvc
@ComponentScan("spittr.web")
public class WebConfig extends WebMvcConfigurerAdapter {
	public WebConfig() {

	}

	@Bean
	public ViewResolver viewResolver() {
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/views/");
		resolver.setSuffix(".jsp");
		resolver.setViewClass(JstlView.class);
		return resolver;
	}
	
//	@Bean
//	public ViewResolver ViewResolver() {
//		return new TilesViewResolver();
//	}
//	
//	@Bean
//	public TilesConfigurer tilesConfigurer() {
//		TilesConfigurer tilesConfigurer = new TilesConfigurer();
//		tilesConfigurer.setDefinitions(new String[] {
//			"/WEB-INF/layout/tiles.xml"
//		});
//		tilesConfigurer.setCheckRefresh(true);
//		return tilesConfigurer;
//	}

	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		super.configureDefaultServletHandling(configurer);

		configurer.enable();
	}

	// MessageSource method 1
//	@Bean
//	public MessageSource mesasgeSource() {
//		ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
//		messageSource.setBasename("messages");
//		
//		return messageSource;
//	}

	// MessageSource method 2
	@Bean
	public MessageSource messageSource() {
		ReloadableResourceBundleMessageSource messageSource 
			= new ReloadableResourceBundleMessageSource();
		messageSource.setBasename("classpath:messages");
		messageSource.setCacheSeconds(10);
		return messageSource;
	}
	
	

//	@Bean
//	public ViewResolver ViewResolver(SpringTemplateEngine templateEngine) {
//		ThymeleafViewResolver thymeleafViewResolver = new ThymeleafViewResolver();
//		thymeleafViewResolver.setTemplateEngine(templateEngine);
//		
//		return thymeleafViewResolver;
//	}
//	
//	@Bean
//	public SpringTemplateEngine templateEngine(ITemplateResolver templateResolver) {
//		SpringTemplateEngine templateEngine = new SpringTemplateEngine();
//		templateEngine.setTemplateResolver(templateResolver);
//		return templateEngine;
//	}
//	
//	@Bean 
//	public ITemplateResolver templateResolver() {
//		SpringResourceTemplateResolver templateResolver = new SpringResourceTemplateResolver();
//		templateResolver.setPrefix("/WEB-INF/templates/");
//		templateResolver.setSuffix(".html");
//		templateResolver.setTemplateMode("HTML5");
//		return templateResolver;
//	}

	// 使用Servlet 3.0 解析multipart请求
	@Bean
	public MultipartResolver multipartResolver() throws IOException {
		return new StandardServletMultipartResolver();
	}
	
	// 配置Jakarta Commons FileUpload multipart解析器
//	@Bean
//	public MultipartResolver multipartResolver() throws IOException {
//		CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
//		multipartResolver.setUploadTempDir(new FileSystemResource("/tmp/spittr/uploads"));
//		multipartResolver.setMaxUploadSize(2097152);
//		multipartResolver.setMaxInMemorySize(0);
//		
//		return multipartResolver;
//	}
	
}
