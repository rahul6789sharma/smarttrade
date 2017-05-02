package org.option.currency.models;

import java.util.ArrayList;
import java.util.List;

public class Columns {


	private int total_ce_oi;
	private int total_pe_oi;
	private int max_ce_oi;
	private int max_pe_oi;
	private String expiry;
	private String interestRate;
	private USDINRFuture uSDINRFuture;
	private List<String> expiryList = new ArrayList<String>();
	private List<Column> dataset = new ArrayList<Column>();

	public USDINRFuture getuSDINRFuture() {
		return uSDINRFuture;
	}

	public void setuSDINRFuture(USDINRFuture uSDINRFuture) {
		this.uSDINRFuture = uSDINRFuture;
	}

	public List<Column> getDataset() {
		return dataset;
	}

	public void setDataset(List<Column> dataset) {
		this.dataset = dataset;
	}
	
	public int getTotal_ce_oi() {
		return total_ce_oi;
	}

	public void setTotal_ce_oi(int total_ce_oi) {
		this.total_ce_oi = total_ce_oi;
	}

	public int getTotal_pe_oi() {
		return total_pe_oi;
	}

	public void setTotal_pe_oi(int total_pe_oi) {
		this.total_pe_oi = total_pe_oi;
	}

	public int getMax_ce_oi() {
		return max_ce_oi;
	}

	public void setMax_ce_oi(int max_ce_oi) {
		this.max_ce_oi = max_ce_oi;
	}

	public int getMax_pe_oi() {
		return max_pe_oi;
	}

	public void setMax_pe_oi(int max_pe_oi) {
		this.max_pe_oi = max_pe_oi;
	}

	public List<String> getExpiryList() {
		return expiryList;
	}

	public void setExpiryList(List<String> expiryList) {
		this.expiryList = expiryList;
	}

	public String getExpiry() {
		return expiry;
	}

	public void setExpiry(String expiry) {
		this.expiry = expiry;
	}

	public String getInterestRate() {
		return interestRate;
	}

	public void setInterestRate(String interestRate) {
		this.interestRate = interestRate;
	}

	@Override
	public String toString() {
		return "Columns [total_ce_oi=" + total_ce_oi + ", total_pe_oi=" + total_pe_oi + ", max_ce_oi=" + max_ce_oi + ", max_pe_oi=" + max_pe_oi
				+ ", expiry=" + expiry + ", interestRate=" + interestRate + ", uSDINRFuture=" + uSDINRFuture + ", expiryList=" + expiryList
				+ ", dataset=" + dataset + "]";
	}

}