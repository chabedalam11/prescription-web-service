package com.prescription.domain;

import java.io.Serializable;

public class Frequency implements Serializable {
	private static final long serialVersionUID = 1L;
	
	
	String t_frequency_code; 
	String t_entry_user;
	String t_entry_date; 
	String t_lang1_name;
	String t_lang2_name;
	
	
	public String getT_frequency_code() {
		return t_frequency_code;
	}
	public void setT_frequency_code(String t_frequency_code) {
		this.t_frequency_code = t_frequency_code;
	}
	public String getT_entry_user() {
		return t_entry_user;
	}
	public void setT_entry_user(String t_entry_user) {
		this.t_entry_user = t_entry_user;
	}
	public String getT_entry_date() {
		return t_entry_date;
	}
	public void setT_entry_date(String t_entry_date) {
		this.t_entry_date = t_entry_date;
	}
	public String getT_lang1_name() {
		return t_lang1_name;
	}
	public void setT_lang1_name(String t_lang1_name) {
		this.t_lang1_name = t_lang1_name;
	}
	public String getT_lang2_name() {
		return t_lang2_name;
	}
	public void setT_lang2_name(String t_lang2_name) {
		this.t_lang2_name = t_lang2_name;
	}
	
	
	
	
	
	

}
