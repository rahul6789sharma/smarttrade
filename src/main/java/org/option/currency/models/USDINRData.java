package org.option.currency.models;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public class USDINRData {

	private static List<String> expiryList = new CopyOnWriteArrayList<String>();
	private static ConcurrentHashMap<String, Columns> data = new ConcurrentHashMap<String, Columns>();

	public static List<String> getExpiryList() {
		return expiryList;
	}

	public static void setExpiryList(List<String> expiryList) {
		USDINRData.expiryList = expiryList;
	}

	public static ConcurrentHashMap<String, Columns> getData() {
		return data;
	}

	public static void updateOptionData(String expiryDate, Columns columns) {
		data.put(expiryDate, columns);
	}

	public static void ClearOldData(List<String> expiryDates) {
		Set<String> expiryDateSet = data.keySet();

		Set<String> oldentries = new HashSet<String>();

		for (String string : expiryDateSet) {
			if(!expiryDates.contains(string)){
				oldentries.add(string);
			}
			
		}

		for (String string : oldentries) {
			data.remove(string);
		}
	}
}
