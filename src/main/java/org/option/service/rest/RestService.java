package org.option.service.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/message")
public class RestService {

	@GET
	@Path("/future")
	@Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
	public String getFuturePrice() {
		String nseUrl = "https://www.nseindia.com/live_market/dynaContent/live_watch/get_quote/GetQuoteCID.jsp?underlying=USDINR&instrument=FUTCUR&expiry=29MAY2017&key=FUTCURUSDINR29MAY2017--28APR2017";
		/*//HTMLParser HTMLParser = new HTMLParser();
		//String data=HTMLParser.getFuturePrice(nseUrl);
		System.out.println("Future price:" + data);
		Gson gson = new Gson();
		UsdInrFutureJson UsdInrFuture =gson.fromJson(data, UsdInrFutureJson.class);
		System.out.println("UsdInrFuture" + UsdInrFuture);
		System.out.println("UsdInrFuture" + UsdInrFuture.getData());
		for (Data d: UsdInrFuture.getData()) {
			System.out.println(d);
		}
		//getFutureObejctFromJson(data);
*/		
		return null;
	}
	
	
}
