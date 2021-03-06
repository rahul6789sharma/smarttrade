package org.option.currency.tasks;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.jsoup.nodes.Document;
import org.option.currency.models.Columns;
import org.option.currency.models.USDINRData;
import org.option.currency.models.USDINRFuture;
import org.option.service.rest.DomainFacade;
import org.smarttrade.options.utils.APPConstant;
import org.smarttrade.options.utils.DocumentParser;

public class USDINRDataCollector implements Runnable {

	@Override
	public void run() {
		System.out.println(" ************ Start Featching Data @ " + new Date() + "**************");

		// String file =
		// "C:\\Users\\rahulksh\\Desktop\\nsedata\\nseCurrencyData.html";

		Document doc = DomainFacade.getInstance().getDocument(APPConstant.NSE_URL_INIT);

		List<String> lst = new ArrayList<String>();
		try {
			lst = DocumentParser.getInstance().getExpiryList(doc);
		} catch (Exception e) {
			e.printStackTrace();
		}

		USDINRData.getExpiryList().clear();
		USDINRData.setExpiryList(lst);

		getAllExpirOptionData(lst, doc);
		USDINRData.ClearOldData(lst);
		// System.out.println("new Data:" + USDINRData.getExpiryList());
		System.out.println(" ************ Completed Featching Data @ " + new Date() + "**************");
		System.out.println("" + USDINRData.getData());

	}

	public void getAllExpirOptionData(List<String> expiryList, Document firstExpiryDoc) {
		try {
			String firstExpiry = expiryList.get(0);
			String url1 = APPConstant.getUSDIINROptionChainURL(firstExpiry);
			Document firstDoc = DomainFacade.getInstance().getDocument(url1);
			// DocumentParser.getInstance().getOptionChainTable(firstDoc);
			Columns columns1 = DocumentParser.getInstance().getOptionData(firstDoc);

			columns1.setExpiryList(expiryList);
			columns1.setExpiry(expiryList.get(0));

			USDINRData.updateOptionData(expiryList.get(0), columns1);

			String futureUrl = APPConstant.getUSDINRFutureURL(expiryList.get(0));
			System.out.println(futureUrl);
			Document futureDc = DomainFacade.getInstance().getDocument(futureUrl);
			USDINRFuture futurePrice = DocumentParser.getInstance().getFuturePrice(futureDc);
			columns1.setuSDINRFuture(futurePrice);

			// leave first expiry
			for (int i = 1; i < expiryList.size(); i++) {

				String url = APPConstant.getUSDIINROptionChainURL(expiryList.get(i));
				Document doc = DomainFacade.getInstance().getDocument(url);
				// System.out.println("File URL " + url);
				Columns columns = DocumentParser.getInstance().getOptionData(doc);

				columns.setExpiryList(expiryList);
				columns.setExpiry(expiryList.get(i));

				// System.out.println("columns" + columns);
				USDINRData.updateOptionData(expiryList.get(i), columns);

				String futureUrl2 = APPConstant.getUSDINRFutureURL(expiryList.get(i));
				Document futureDc2 = DomainFacade.getInstance().getDocument(futureUrl2);
				USDINRFuture futurePrice2 = DocumentParser.getInstance().getFuturePrice(futureDc2);
				columns.setuSDINRFuture(futurePrice2);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}