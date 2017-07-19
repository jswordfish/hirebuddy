package com.hirebuddy.domain;

import javax.persistence.Embeddable;

@Embeddable
public class BuddyScheduleAndCostPreference {
	
	Boolean workOnMon = true;
	
	Boolean workOnTue = true;
	
	Boolean workOnWed = true;
	
	Boolean workOnThu = true;
	
	Boolean workOnFri = true;
	
	Boolean workOnSat = true;
	
	Boolean workOnSun = true;
	
	Boolean work8_10AM = true;
	
	Boolean work10_12AM = true;
	
	Boolean work12_14PM = true;
	
	Boolean work14_16PM = true;
	
	Boolean work16_18PM = true;
	
	Boolean work18_20PM = true;
	
	Boolean work20_22PM;
	
	Boolean work22_24PM;
	
	String baseCurr = "INR";
	
	Integer costPerHour = 100;
	
	Integer costPerTask = 200;
	
	Integer costPerDay = 500;
	
	Integer costPerWeek = 2500;
	
	Integer costPerMonth = 10000;
	
	Boolean workByHour = true;
	
	Boolean workByDay;
	
	Boolean workByWeek;
	
	Boolean workByMonth;
	
	Boolean workByTask = true;

	public Boolean getWorkOnMon() {
		return workOnMon;
	}

	public void setWorkOnMon(Boolean workOnMon) {
		this.workOnMon = workOnMon;
	}

	public Boolean getWorkOnTue() {
		return workOnTue;
	}

	public void setWorkOnTue(Boolean workOnTue) {
		this.workOnTue = workOnTue;
	}

	public Boolean getWorkOnWed() {
		return workOnWed;
	}

	public void setWorkOnWed(Boolean workOnWed) {
		this.workOnWed = workOnWed;
	}

	public Boolean getWorkOnThu() {
		return workOnThu;
	}

	public void setWorkOnThu(Boolean workOnThu) {
		this.workOnThu = workOnThu;
	}

	public Boolean getWorkOnFri() {
		return workOnFri;
	}

	public void setWorkOnFri(Boolean workOnFri) {
		this.workOnFri = workOnFri;
	}

	public Boolean getWorkOnSat() {
		return workOnSat;
	}

	public void setWorkOnSat(Boolean workOnSat) {
		this.workOnSat = workOnSat;
	}

	public Boolean getWorkOnSun() {
		return workOnSun;
	}

	public void setWorkOnSun(Boolean workOnSun) {
		this.workOnSun = workOnSun;
	}

	public Boolean getWork8_10AM() {
		return work8_10AM;
	}

	public void setWork8_10AM(Boolean work8_10am) {
		work8_10AM = work8_10am;
	}

	public Boolean getWork10_12AM() {
		return work10_12AM;
	}

	public void setWork10_12AM(Boolean work10_12am) {
		work10_12AM = work10_12am;
	}

	public Boolean getWork12_14PM() {
		return work12_14PM;
	}

	public void setWork12_14PM(Boolean work12_14pm) {
		work12_14PM = work12_14pm;
	}

	public Boolean getWork14_16PM() {
		return work14_16PM;
	}

	public void setWork14_16PM(Boolean work14_16pm) {
		work14_16PM = work14_16pm;
	}

	public Boolean getWork16_18PM() {
		return work16_18PM;
	}

	public void setWork16_18PM(Boolean work16_18pm) {
		work16_18PM = work16_18pm;
	}

	public Boolean getWork18_20PM() {
		return work18_20PM;
	}

	public void setWork18_20PM(Boolean work18_20pm) {
		work18_20PM = work18_20pm;
	}

	public Boolean getWork20_22PM() {
		return work20_22PM;
	}

	public void setWork20_22PM(Boolean work20_22pm) {
		work20_22PM = work20_22pm;
	}

	public Boolean getWork22_24PM() {
		return work22_24PM;
	}

	public void setWork22_24PM(Boolean work22_24pm) {
		work22_24PM = work22_24pm;
	}

	public String getBaseCurr() {
		return baseCurr;
	}

	public void setBaseCurr(String baseCurr) {
		this.baseCurr = baseCurr;
	}

	public Integer getCostPerHour() {
		return costPerHour;
	}

	public void setCostPerHour(Integer costPerHour) {
		this.costPerHour = costPerHour;
	}

	public Integer getCostPerTask() {
		return costPerTask;
	}

	public void setCostPerTask(Integer costPerTask) {
		this.costPerTask = costPerTask;
	}

	public Integer getCostPerDay() {
		return costPerDay;
	}

	public void setCostPerDay(Integer costPerDay) {
		this.costPerDay = costPerDay;
	}

	public Integer getCostPerWeek() {
		return costPerWeek;
	}

	public void setCostPerWeek(Integer costPerWeek) {
		this.costPerWeek = costPerWeek;
	}

	public Integer getCostPerMonth() {
		return costPerMonth;
	}

	public void setCostPerMonth(Integer costPerMonth) {
		this.costPerMonth = costPerMonth;
	}

	public Boolean getWorkByHour() {
		return workByHour;
	}

	public void setWorkByHour(Boolean workByHour) {
		this.workByHour = workByHour;
	}

	public Boolean getWorkByDay() {
		return workByDay;
	}

	public void setWorkByDay(Boolean workByDay) {
		this.workByDay = workByDay;
	}

	public Boolean getWorkByWeek() {
		return workByWeek;
	}

	public void setWorkByWeek(Boolean workByWeek) {
		this.workByWeek = workByWeek;
	}

	public Boolean getWorkByMonth() {
		return workByMonth;
	}

	public void setWorkByMonth(Boolean workByMonth) {
		this.workByMonth = workByMonth;
	}

	public Boolean getWorkByTask() {
		return workByTask;
	}

	public void setWorkByTask(Boolean workByTask) {
		this.workByTask = workByTask;
	}
	
	
}
