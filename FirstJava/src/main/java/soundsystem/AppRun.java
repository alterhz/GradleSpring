package soundsystem;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AppRun {

	public static void main(String[] args) throws Exception {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(TrackCounterConfig.class);
		
		CompactDisc compactDisc = (CompactDisc) ctx.getBean("blackDisc");
		compactDisc.playTrack(1);
		compactDisc.playTrack(2);
		compactDisc.playTrack(3);
		compactDisc.playTrack(3);
		compactDisc.playTrack(3);
		compactDisc.playTrack(3);
		compactDisc.playTrack(7);
		compactDisc.playTrack(7);
		
		TrackCounter trackCounter = ctx.getBean("trackCounter", TrackCounter.class);
		
		for (int i=1; i<=7; ++i) {
			int count = trackCounter.getPlayCount(i);
			System.out.println(i + " : " + count);
		}
		
		((AnnotationConfigApplicationContext)ctx).close();
	}

}
