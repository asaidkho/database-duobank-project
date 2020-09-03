package com.automationpractice.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MortgageApplicationPage extends BasePage{
	
	@FindBy(xpath="//*[@id='main-menu-navigation']//span[.='Mortgage Application']")
	public WebElement mortgageApplication;
	
	//PreApproval Details
	
	@FindBy(id="steps-uid-0-t-0")
	public WebElement preApprovalDetailsTab;
	
	@FindBy(id="realtor1")
	public WebElement workingWithRealtorYes;
	
	@FindBy(id="realtor2")
	public WebElement workingWithRealtorNo;
	
	@FindBy(id="realtorinfo")
	public WebElement realtorInfoField;  //required
	
	@FindBy(id="loanofficer1")
	public WebElement workingWithLoanOfficerYes;
	
	@FindBy(id="loanofficer2")
	public WebElement workingWithLoanOfficerNo;
	
	@FindBy(id="estimatedprice")
	public WebElement estimatedPurchasePrice;   //required
	
	@FindBy(id="downpayment")
	public WebElement downPaymentAmount;  //required
	
	@FindBy(id="downpaymentpercentage")
	public WebElement downPaymentPercentage;   //?required
	
	@FindBy(id="select2-src_down_payment-72-container")
	public WebElement selectSourceOfDownPayment;
	
	@FindBy(id="additionalfunds")
	public WebElement additionalFundsField;
	
	@FindBy(xpath="//a[.='Next']")
	public WebElement nextButton;
	
	//Personal Information
	
	@FindBy(id="steps-uid-0-t-1")
	public WebElement personalInformationTab;
	
	@FindBy(id="coborrower1")
	public WebElement applyingWithCoborrowerYes;
	
	@FindBy(id="coborrower2")
	public WebElement applyingWithCoborrowerNo;
	
	@FindBy(id="b_firstName")
	public WebElement borrowerFirstName;  //required
	
	@FindBy(id="b_middleName")
	public WebElement borrowerMiddleName;
	
	@FindBy(id="b_lastName")
	public WebElement borrowerLastName;   //required
	
	@FindBy(id="select2-b_suffix-container")
	public WebElement borrowerSelectSuffixContainer;
	
	@FindBy(id="b_email")
	public WebElement borrowerEmail;  //required
	
	@FindBy(id="b_dob")
	public WebElement borrowerDOB;   
	
	@FindBy(id="b_ssn")
	public WebElement borrowerSSN;   //required
	
	@FindBy(id="select2-b_marital-container")
	public WebElement borrowerSelectMaritalStatusContainer;   //required
	
	@FindBy(id="b_cell")
	public WebElement borrowerCellPhone;  //required
	
	@FindBy(id="b_home")
	public WebElement borrowerHomePhone;
	
	@FindBy(id="c_firstName")
	public WebElement coborrowerFirstName;
	
	@FindBy(id="c_middleName")
	public WebElement coborrowerMiddleName;
	
	@FindBy(id="c_lastName")
	public WebElement coborrowerLastName;
	
	@FindBy(id="select2-c_suffix-container")
	public WebElement coborrowerSelectSuffixContainer;
	
	@FindBy(id="c_email")
	public WebElement coborrowerEmail;
	
	@FindBy(id="c_dob")
	public WebElement coborrowerDOB;
	
	@FindBy(id="c_ssn")
	public WebElement coborrowerSSN;
	
	@FindBy(id="select2-c_marital-container")
	public WebElement coborrowerSelectMaritalStatusContainer;
	
	@FindBy(id="c_cell")
	public WebElement coborrowerCellPhone;
	
	@FindBy(id="c_home")
	public WebElement coborrowerHomePhone;
	
	@FindBy(xpath="//a[.='Previous']")
	public WebElement previousButton;
	
	//Expenses
	
	@FindBy(id="steps-uid-0-t-2")
	public WebElement expensesTab;
	
	@FindBy(id="expense1")
	public WebElement rent;
	
	@FindBy(id="expense2")
	public WebElement own;
	
	@FindBy(id="monthlyrentalpayment")       //if rent
	public WebElement monthlyRentalPayment;   //required
	
	@FindBy(id="firtmortagagetotalpayment")  //if own
	public WebElement firtMortagageTotalPayment;
	
	//Employment and Income
	
	@FindBy(id="steps-uid-0-t-3")
	public WebElement employmentAndIncomeTab;
	
	@FindBy(id="employername1")
	public WebElement employerName;  //required
	
	@FindBy(id="position1")
	public WebElement position;
	
	@FindBy(id="city")
	public WebElement employmentCity;
	
	@FindBy(id="state1")
	public WebElement employmentState;
	
	@FindBy(id="start_date1")
	public WebElement employmentStartDate;
	
	@FindBy(id="grossmonthlyincome")
	public WebElement grossMonthlyIncome;    //required
	
	//eConsent
	
	@FindBy(id="steps-uid-0-t-4")
	public WebElement eConsentTab;
	
	@FindBy(id="eConsentdeclarerFirstName")
	public WebElement eConsentdeclarerFirstName; //required
	
	@FindBy(id="eConsentdeclarerLastName")
	public WebElement eConsentdeclarerLastName;  //required
	
	@FindBy(id="eConsentdeclarerEmail")
	public WebElement eConsentdeclarerEmail;  //required
	
	@FindBy(id="agree")
	public WebElement agree;  //required

	//Summary
	
	@FindBy(id="steps-uid-0-t-5")
	public WebElement summaryTab;
	
	@FindBy(xpath="//a[.='Save']")
	public WebElement saveButton;  //required

}
