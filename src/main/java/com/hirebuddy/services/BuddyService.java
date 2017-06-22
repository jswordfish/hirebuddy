package com.hirebuddy.services;

import com.hirebuddy.domain.Buddy;
import com.hirebuddy.exceptions.HireBuddyException;

public interface BuddyService extends HireBuddyService{

	public void saveOrUpdate(Buddy buddy) throws HireBuddyException;
	
	
	 public Buddy getUniqueBuddyByEmail(String name) throws HireBuddyException;
	 
	 public Buddy getUniqueBuddyByMobile(String name) throws HireBuddyException;
	 
	 public void verifyOTP(String buddyIdentity, String identityType) throws HireBuddyException;
}
