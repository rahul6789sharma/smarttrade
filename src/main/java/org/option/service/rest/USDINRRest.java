package org.option.service.rest;

import java.util.Map;
import java.util.Set;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.option.currency.models.Columns;
import org.option.currency.models.USDINRData;
import org.option.currency.tasks.USDINRDataCollector;

@Path("/usdinrService")
public class USDINRRest {

	static{
	
		ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1);
		scheduledExecutorService.scheduleAtFixedRate(new USDINRDataCollector(), 1, 6000, TimeUnit.SECONDS);
	}

	
	@GET
	@Path("/currentMonthOptionChain")
	@Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
	public Columns getCurrentMonthOptionChain() {
		String currentMonthExpiry=null;
		if(USDINRData.getExpiryList().isEmpty()){
			try {
				while(true){
				     Thread.sleep(100);
				     if(!USDINRData.getExpiryList().isEmpty()){
				    	break; 
				     }
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			currentMonthExpiry=USDINRData.getExpiryList().get(0);
		}else{
			currentMonthExpiry=USDINRData.getExpiryList().get(0);	
			
		}
		
		Columns columns = USDINRData.getData().get(currentMonthExpiry);
		return columns;
				
	}
	
	
	@POST
	@Path("/optionChain")
	@Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
	@Consumes(MediaType.TEXT_PLAIN)
	public Columns getUSDINROptionChain(String expiryDt) {
		Columns columns = USDINRData.getData().get(expiryDt);
		return columns;
	}

	@GET
	@Path("/allData")
	@Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
	public Map<String, Columns> getAllData() {
		return USDINRData.getData();
				
	}
	
	
	@GET
	@Path("/expiries")
	@Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
	public Set<String> getExpiryList() {
		Set<String> expiry = USDINRData.getData().keySet();
		System.out.println("Getting expiry :" + expiry);
		return expiry;
	}
	
}