package com.prescription.domain;

import java.io.Serializable;

public class DocDesignation implements Serializable {
	private static final long serialVersionUID = 1L;
	
	String t_desig_id;
	String t_doc_id;
	String t_desig_name;
	String other;
	
	
	public String getT_desig_id() {
		return t_desig_id;
	}
	public void setT_desig_id(String t_desig_id) {
		this.t_desig_id = t_desig_id;
	}
	public String getT_doc_id() {
		return t_doc_id;
	}
	public void setT_doc_id(String t_doc_id) {
		this.t_doc_id = t_doc_id;
	}
	public String getT_desig_name() {
		return t_desig_name;
	}
	public void setT_desig_name(String t_desig_name) {
		this.t_desig_name = t_desig_name;
	}
	public String getOther() {
		return other;
	}
	public void setOther(String other) {
		this.other = other;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	

}
