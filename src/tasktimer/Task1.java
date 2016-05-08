package tasktimer;

import static java.lang.System.out;

import java.util.Scanner;

public class Task1 implements Runnable{

	@Override
	public void run() {
		Scanner in = new Scanner(tasktimer.Dictionary.getWordsAsStream());
        int count = 0;
        long totalsize = 0;
        while(in.hasNext()) {
            String word = in.next();
            totalsize += word.length();
            count++;
        }
        double averageLength = ((double)totalsize)/(count>0 ? count : 1);
        out.printf("Average length of %,d words is %.2f\n", count, averageLength);
		
	}
	
	@Override
	public String toString() {
		return "Starting task: read words using Scanner and a while loop";
	}

}
