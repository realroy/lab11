package tasktimer;

import static java.lang.System.out;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import tasktimer.TaskTimer.IntCounter;

public class Task3 implements Runnable {

	@Override
	public void run() {
		BufferedReader br = null;
        try {
            br = new BufferedReader( new InputStreamReader(tasktimer.Dictionary.getWordsAsStream()) );
        } catch (Exception ex) {
            out.println("Could not open dictionary: "+ex.getMessage());
            return;
        }
        long totalsize = 0;
        long count = 0;
        // This code uses Java's IntStream.average() method.
        // But there is no way to also get the count of items.
        // averageLength = br.lines().mapToInt( (word) -> word.length() )
        //                         .average().getAsDouble();
        // So instead we write out own IntConsumer to count and average the stream,
        // and use our IntConsumer to "consume" the stream.
        IntCounter counter = new IntCounter();
        br.lines().mapToInt( word -> word.length() ).forEach( counter );
        // close the input
        out.printf("Average length of %,d words is %.2f\n",
                counter.getCount(), counter.average() );
        try {
            br.close();
        } catch(IOException ex) { /* ignore it */ }
		
	}
	
	@Override 
	public String toString() {
		return "Starting task: read words using BufferedReader and Stream";
		
	}

}
