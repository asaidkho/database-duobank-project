package com.automationpractice.pojos;

public class MortgageApplication {

	private String realtor_info;
	private String est_purchase_price;
	private String down_payment;
	private String down_payment_percent;
	private String b_firstName;
	private String b_lastName;
	private String b_email;
	private String b_dob;
	private String b_ssn;
	private String b_marital;
	private String b_cell;
	private String monthly_rental_payment;
	private String employer_name;
	private String gross_monthly_income;
	private String eConsent_declarer_FirstName;
	private String eConsent_declarer_LastName;
	private String eConsent_declarer_Email;
	
	private int row;
	
	public MortgageApplication(int row) {
		super();
		this.row = row;
	}
	
	
	
	public int getRow() {
		return row;
	}



	public void setRow(int row) {
		this.row = row;
	}



	public MortgageApplication(String realtor_info, String est_purchase_price, String down_payment,
			String down_payment_percent, String b_firstName, String b_lastName, String b_email, String b_dob,
			String b_ssn, String b_marital, String b_cell, String monthly_rental_payment, String employer_name,
			String gross_monthly_income, String eConsent_declarer_FirstName, String eConsent_declarer_LastName,
			String eConsent_declarer_Email) {
		super();
		this.realtor_info = realtor_info;
		this.est_purchase_price = est_purchase_price;
		this.down_payment = down_payment;
		this.down_payment_percent = down_payment_percent;
		this.b_firstName = b_firstName;
		this.b_lastName = b_lastName;
		this.b_email = b_email;
		this.b_dob = b_dob;
		this.b_ssn = b_ssn;
		this.b_marital = b_marital;
		this.b_cell = b_cell;
		this.monthly_rental_payment = monthly_rental_payment;
		this.employer_name = employer_name;
		this.gross_monthly_income = gross_monthly_income;
		this.eConsent_declarer_FirstName = eConsent_declarer_FirstName;
		this.eConsent_declarer_LastName = eConsent_declarer_LastName;
		this.eConsent_declarer_Email = eConsent_declarer_Email;
	}
	public String getRealtor_info() {
		return realtor_info;
	}
	public void setRealtor_info(String realtor_info) {
		this.realtor_info = realtor_info;
	}
	public String getEst_purchase_price() {
		return est_purchase_price;
	}
	public void setEst_purchase_price(String est_purchase_price) {
		this.est_purchase_price = est_purchase_price;
	}
	public String getDown_payment() {
		return down_payment;
	}
	public void setDown_payment(String down_payment) {
		this.down_payment = down_payment;
	}
	public String getDown_payment_percent() {
		return down_payment_percent;
	}
	public void setDown_payment_percent(String down_payment_percent) {
		this.down_payment_percent = down_payment_percent;
	}
	public String getB_firstName() {
		return b_firstName;
	}
	public void setB_firstName(String b_firstName) {
		this.b_firstName = b_firstName;
	}
	public String getB_lastName() {
		return b_lastName;
	}
	public void setB_lastName(String b_lastName) {
		this.b_lastName = b_lastName;
	}
	public String getB_email() {
		return b_email;
	}
	public void setB_email(String b_email) {
		this.b_email = b_email;
	}
	public String getB_dob() {
		return b_dob;
	}
	public void setB_dob(String b_dob) {
		this.b_dob = b_dob;
	}
	public String getB_ssn() {
		return b_ssn;
	}
	public void setB_ssn(String b_ssn) {
		this.b_ssn = b_ssn;
	}
	public String getB_marital() {
		return b_marital;
	}
	public void setB_marital(String b_marital) {
		this.b_marital = b_marital;
	}
	public String getB_cell() {
		return b_cell;
	}
	public void setB_cell(String b_cell) {
		this.b_cell = b_cell;
	}
	public String getMonthly_rental_payment() {
		return monthly_rental_payment;
	}
	public void setMonthly_rental_payment(String monthly_rental_payment) {
		this.monthly_rental_payment = monthly_rental_payment;
	}
	public String getEmployer_name() {
		return employer_name;
	}
	public void setEmployer_name(String employer_name) {
		this.employer_name = employer_name;
	}
	public String getGross_monthly_income() {
		return gross_monthly_income;
	}
	public void setGross_monthly_income(String gross_monthly_income) {
		this.gross_monthly_income = gross_monthly_income;
	}
	public String geteConsent_declarer_FirstName() {
		return eConsent_declarer_FirstName;
	}
	public void seteConsent_declarer_FirstName(String eConsent_declarer_FirstName) {
		this.eConsent_declarer_FirstName = eConsent_declarer_FirstName;
	}
	public String geteConsent_declarer_LastName() {
		return eConsent_declarer_LastName;
	}
	public void seteConsent_declarer_LastName(String eConsent_declarer_LastName) {
		this.eConsent_declarer_LastName = eConsent_declarer_LastName;
	}
	public String geteConsent_declarer_Email() {
		return eConsent_declarer_Email;
	}
	public void seteConsent_declarer_Email(String eConsent_declarer_Email) {
		this.eConsent_declarer_Email = eConsent_declarer_Email;
	}
	
}
