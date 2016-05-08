package tasktimer;

import static java.lang.System.out;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.function.Consumer;

public class Task4 implements Runnable {

	@Override
	public void run() {
		// initialize
        BufferedReader br = null;
        try {
            br = new BufferedReader( new InputStreamReader(tasktimer.Dictionary.getWordsAsStream()) );
        } catch (Exception ex) {
            out.println("Could not open dictionary: "+ex.getMessage());
            return;
        }
        out.println("Starting task: read words using BufferedReader and Stream with Collector");
        final AtomicLong total = new AtomicLong();
        final AtomicInteger counter = new AtomicInteger();
        //TODO Use a Collector instead of Consumer
        Consumer<String> consumer = new Consumer<String>() {
            public void accept(String word) {
                total.getAndAdd( word.length() );
                counter.incrementAndGet();
            }
        };
                
        br.lines().forEach( consumer );  // Ha! No loop.
        // close the input
        try { br.close(); } catch(IOException ex) { /* ignore it */ }
        
        int count = counter.intValue();
        double averageLength = (count > 0) ? total.doubleValue()/count : 0.0;
            
		
	}
	
	@Override 
	public String toString() {
		return "Starting task: read words using BufferedReader and Stream with Collector";
	}

}
