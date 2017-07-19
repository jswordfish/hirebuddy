package com.hirebuddy.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Transient;

@Entity
@NamedQueries({
	@NamedQuery(name="Buddy.getBuddyByEmail", 
			query="SELECT b FROM Buddy b WHERE b.email=:email AND b.identityType=:identityType"),
	@NamedQuery(name="Buddy.getBuddyByMobile", 
			query="SELECT b FROM Buddy b WHERE b.mobile=:mobile AND b.identityType=:identityType")
})
public class Buddy extends Base{
	
	String firstName;
	
	String lastName;
	
	String education;
	
	String email;
	
	String oneTimePassword;
	
	Long oneTimePasswordTime;
	
	String password;
	
	
	String mobile;
	
	String address;
	
	String pinCode;
	
	String country;
	
	String city;
	
	String suite;
	
	String state;
	
	/**
	 * comma separated categories
	 */
	String categories;
	
	String packageSelected;
	//1 of email/mobile
	String identityType="mobile";
	
	String panURL;
	
	String aadharURL;
	
	String passportUrl;
	
	String cvURL;
	
	@Transient
	byte[] pan;
	
	@Transient
	String panExtension;
	
	@Transient
	byte[] aadhar;
	
	@Transient
	String aadharExtension;
	
	@Transient
	byte[] passport;

	@Transient
	String passportExtension;
	
	@Transient
	byte[] cv;

	@Transient
	String cvExtension;
	
	Boolean validated = false;
	
	@Embedded
	BuddyScheduleAndCostPreference buddyScheduleAndCostPreference = new BuddyScheduleAndCostPreference();

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getOneTimePassword() {
		return oneTimePassword;
	}

	public void setOneTimePassword(String oneTimePassword) {
		this.oneTimePassword = oneTimePassword;
	}

	public Long getOneTimePasswordTime() {
		return oneTimePasswordTime;
	}

	public void setOneTimePasswordTime(Long oneTimePasswordTime) {
		this.oneTimePasswordTime = oneTimePasswordTime;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getIdentityType() {
		return identityType;
	}

	public void setIdentityType(String identityType) {
		this.identityType = identityType;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPinCode() {
		return pinCode;
	}

	public void setPinCode(String pinCode) {
		this.pinCode = pinCode;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getSuite() {
		return suite;
	}

	public void setSuite(String suite) {
		this.suite = suite;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	

	public String getCategories() {
		return categories;
	}

	public void setCategories(String categories) {
		this.categories = categories;
	}

	public String getPackageSelected() {
		return packageSelected;
	}

	public void setPackageSelected(String packageSelected) {
		this.packageSelected = packageSelected;
	}

	public String getEducation() {
		return education;
	}

	public void setEducation(String education) {
		this.education = education;
	}

	public String getPanURL() {
		return panURL;
	}

	public void setPanURL(String panURL) {
		this.panURL = panURL;
	}

	public String getAadharURL() {
		return aadharURL;
	}

	public void setAadharURL(String aadharURL) {
		this.aadharURL = aadharURL;
	}

	public String getPassportUrl() {
		return passportUrl;
	}

	public void setPassportUrl(String passportUrl) {
		this.passportUrl = passportUrl;
	}

	public byte[] getPan() {
		return pan;
	}

	public void setPan(byte[] pan) {
		this.pan = pan;
	}

	public byte[] getAadhar() {
		return aadhar;
	}

	public void setAadhar(byte[] aadhar) {
		this.aadhar = aadhar;
	}

	public byte[] getPassport() {
		return passport;
	}

	public void setPassport(byte[] passport) {
		this.passport = passport;
	}

	public String getPanExtension() {
		return panExtension;
	}

	public void setPanExtension(String panExtension) {
		this.panExtension = panExtension;
	}

	public String getAadharExtension() {
		return aadharExtension;
	}

	public void setAadharExtension(String aadharExtension) {
		this.aadharExtension = aadharExtension;
	}

	public String getPassportExtension() {
		return passportExtension;
	}

	public void setPassportExtension(String passportExtension) {
		this.passportExtension = passportExtension;
	}

	public Boolean getValidated() {
		return validated;
	}

	public void setValidated(Boolean validated) {
		this.validated = validated;
	}

	public String getCvURL() {
		return cvURL;
	}

	public void setCvURL(String cvURL) {
		this.cvURL = cvURL;
	}

	public byte[] getCv() {
		return cv;
	}

	public void setCv(byte[] cv) {
		this.cv = cv;
	}

	public String getCvExtension() {
		return cvExtension;
	}

	public void setCvExtension(String cvExtension) {
		this.cvExtension = cvExtension;
	}

	public BuddyScheduleAndCostPreference getBuddyScheduleAndCostPreference() {
		return buddyScheduleAndCostPreference;
	}

	public void setBuddyScheduleAndCostPreference(
			BuddyScheduleAndCostPreference buddyScheduleAndCostPreference) {
		this.buddyScheduleAndCostPreference = buddyScheduleAndCostPreference;
	}
	
	
	
	

}
