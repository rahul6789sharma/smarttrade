package org.option.currency.tasks;
import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;


public class FeachDataTaskatSpecifiedTime  extends TimerTask {
	

	public static void main(String[] args) {
		Calendar today = Calendar.getInstance();
		today.set(Calendar.HOUR_OF_DAY, 11);
		today.set(Calendar.MINUTE, 45);
		today.set(Calendar.SECOND, 0);

		// every night at 2am you run your task
		Timer timer = new Timer();
		timer.schedule(new FeachDataTaskatSpecifiedTime(), today.getTime(), TimeUnit.MILLISECONDS.convert(1, TimeUnit.DAYS)); // 60*60*24*100 = 8640000ms
	}

	@Override
	public void run() {
		System.out.println("Executing Task");
		
	}
}
