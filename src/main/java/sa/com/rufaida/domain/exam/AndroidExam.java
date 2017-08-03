package sa.com.rufaida.domain.exam;

import java.io.Serializable;

public class AndroidExam implements Serializable {
	private static final long serialVersionUID = 1L;

	 String  project_name;
	 String  project_version_name;
	 String  project_version_code;
	 String  ip_address;
	 String  device_imei;
	 String  device_android_id;
	 String  country_iso;
	 String  device_manufacturer;
	 String  device_brand;
	 String  device_model;
	 
	public String getProject_name() {
		return project_name;
	}
	public void setProject_name(String project_name) {
		this.project_name = project_name;
	}
	public String getProject_version_name() {
		return project_version_name;
	}
	public void setProject_version_name(String project_version_name) {
		this.project_version_name = project_version_name;
	}
	public String getProject_version_code() {
		return project_version_code;
	}
	public void setProject_version_code(String project_version_code) {
		this.project_version_code = project_version_code;
	}
	public String getIp_address() {
		return ip_address;
	}
	public void setIp_address(String ip_address) {
		this.ip_address = ip_address;
	}
	public String getDevice_imei() {
		return device_imei;
	}
	public void setDevice_imei(String device_imei) {
		this.device_imei = device_imei;
	}
	public String getDevice_android_id() {
		return device_android_id;
	}
	public void setDevice_android_id(String device_android_id) {
		this.device_android_id = device_android_id;
	}
	public String getCountry_iso() {
		return country_iso;
	}
	public void setCountry_iso(String country_iso) {
		this.country_iso = country_iso;
	}
	public String getDevice_manufacturer() {
		return device_manufacturer;
	}
	public void setDevice_manufacturer(String device_manufacturer) {
		this.device_manufacturer = device_manufacturer;
	}
	public String getDevice_brand() {
		return device_brand;
	}
	public void setDevice_brand(String device_brand) {
		this.device_brand = device_brand;
	}
	public String getDevice_model() {
		return device_model;
	}
	public void setDevice_model(String device_model) {
		this.device_model = device_model;
	}

	
	 
	 
}
