package com.hirebuddy.services.test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.hirebuddy.domain.Buddy;
import com.hirebuddy.services.BuddyService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:appContext.xml"})
@Transactional
public class BuddyServiceTest {
	@Autowired
	BuddyService  buddyService;
	
	@Test
	@Rollback(value=false)
	public void testBuddyCreationByEmail(){
		Buddy buddy = new Buddy();
		buddy.setEmail("jatin.sutaria@thev2technologies.com");
		buddy.setFirstName("Jatin");
		buddy.setLastName("Sutaria");
		buddy.setCategories("Helper, Cleaner");
		buddy.setIdentityType("email");
		buddyService.saveOrUpdate(buddy);
	}
	
	@Test
	@Rollback(value=false)
	public void testBuddyCreationByMobile() throws Exception{
		Buddy buddy = new Buddy();
		buddy.setMobile("9930070660");
		buddy.setFirstName("Jatin");
		buddy.setLastName("Sutaria");
		buddy.setCategories("Painter, Carpenter, Electrican");
		buddy.setIdentityType("mobile");
		
		
		File fi = new File("testImages/jat.png");
		byte[] fileContent = Files.readAllBytes(fi.toPath());
		buddy.setPanExtension("png");
		buddy.setPan(fileContent);
		
		fi = new File("testImages/jat1.JPG");
		fileContent = Files.readAllBytes(fi.toPath());
		buddy.setAadharExtension("JPG");
		buddy.setAadhar(fileContent);
		
		fi = new File("testImages/jat2.JPG");
		fileContent = Files.readAllBytes(fi.toPath());
		buddy.setPassportExtension("JPG");
		buddy.setPassport(fileContent);
		
		buddyService.saveOrUpdate(buddy);
	}

}
