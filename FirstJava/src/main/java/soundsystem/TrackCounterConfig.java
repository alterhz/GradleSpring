package soundsystem;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy
@ComponentScan
public class TrackCounterConfig {
	
	@Bean
	public CompactDisc blackDisc() {
		BlackDisc cd = new BlackDisc();
		cd.setTitle("Sgt. pepper's Lonely Hearts Club Band");
		cd.setArtist("The Beatles");
		return cd;
	}
	
}
