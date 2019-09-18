package soundsystem;

import java.util.HashMap;
import java.util.Map;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component("trackCounter")
@Aspect
public class TrackCounter {
	private Map<Integer, Integer> trackCounts = new HashMap<Integer, Integer>();
	
	private static int allocId = 0;
	private int id = 0;
	
	public TrackCounter() {
		this.id = ++allocId;
		System.out.println("create TrackCounter " + this.id);
	}
	
	@Pointcut("execution(* soundsystem.CompactDisc.playTrack(int)) " 
			+ "&& args(trackNumber)")
	public void trackPlayed(int trackNumber) {}
	
	@Before("trackPlayed(trackNumber)")
	public void countTrack(int trackNumber) {
		int currentCount = getPlayCount(trackNumber);
		trackCounts.put(trackNumber, currentCount+1);
	}
	
	@Before("execution(* soundsystem.CompactDisc.play(..))")
	public void countPlay() {
		System.out.println("countPlay");
	}
	
	public int getPlayCount(int trackNumber) {
		return trackCounts.containsKey(trackNumber) ? trackCounts.get(trackNumber) : 0;
	}
}
