package spittr.config;

import javax.servlet.Filter;
import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletRegistration.Dynamic;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class SpittrWebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class<?>[] { RootConfig.class };
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class<?>[] { WebConfig.class };
	}

	@Override
	protected void customizeRegistration(Dynamic registration) {
		super.customizeRegistration(registration);
		
		registration.setMultipartConfig(
				new MultipartConfigElement("/tmp/spittr/uploads"));
	}

	@Override
	protected String[] getServletMappings() {
		return new String[] {"/"};
	}

}
