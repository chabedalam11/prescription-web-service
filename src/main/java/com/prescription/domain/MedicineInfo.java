package com.prescription.domain;

import java.io.Serializable;
import java.util.ArrayList;

public class MedicineInfo implements Serializable {
	private static final long serialVersionUID = 1L;
	
	ArrayList<String> um = new ArrayList<>();
	ArrayList<String> trade = new ArrayList<>();
	ArrayList<String> frequency = new ArrayList<>();
	
	public ArrayList<String> getUm() {
		return um;
	}
	public void setUm(ArrayList<String> um) {
		this.um = um;
	}
	public ArrayList<String> getTrade() {
		return trade;
	}
	public void setTrade(ArrayList<String> trade) {
		this.trade = trade;
	}
	public ArrayList<String> getFrequency() {
		return frequency;
	}
	public void setFrequency(ArrayList<String> frequency) {
		this.frequency = frequency;
	}
	

}
