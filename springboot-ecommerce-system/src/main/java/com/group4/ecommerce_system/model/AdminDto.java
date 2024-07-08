package com.group4.ecommerce_system.model;

public class AdminDto {
	
	private String adminEmail;
	private String adminPassword;
	
	public AdminDto() {
		
	}
	
	public AdminDto(String adminEmail, String adminPassword) {
		this.adminEmail = adminEmail;
		this.adminPassword = adminPassword;
	}
	public String getAdminEmail() {
		return adminEmail;
	}
	public void setAdminEmail(String adminEmail) {
		this.adminEmail = adminEmail;
	}
	public String getAdminPassword() {
		return adminPassword;
	}
	public void setAdminPassword(String adminPassword) {
		this.adminPassword = adminPassword;
	}
	
}
