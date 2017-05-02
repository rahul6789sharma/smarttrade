package org.option.currency.tasks;

import org.option.currency.models.USDINRData;

public class TestThread  implements Runnable{

	@Override
	public void run() {
		while(true){
			try {
				Thread.sleep(1000);
				System.out.println("Reading Data:" + USDINRData.getData());
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
		}
		
	}

	
	
}
