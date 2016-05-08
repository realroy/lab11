package tasktimer;

public class StopWatch {
	private long 	startTime,
					stopTime;
	
	private boolean running;

	public StopWatch() {
		this.startTime = 0;
		this.stopTime  = 0;
		this.running   = false;
	}
	public void start() {
		if(!this.running){
			this.running = true;
			this.startTime = System.nanoTime();
		}
	}
	
	public void stop() {
		if(this.running){
		this.running = false;
		this.stopTime = System.nanoTime();
		}
	}

	public double getElapsed() {
		double result = ((stopTime-startTime) * 1.0E-9);
		return result;
	}
}
