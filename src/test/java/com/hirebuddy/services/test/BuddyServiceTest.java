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

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hirebuddy.common.UserData;
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
		buddy.setPassword("password");
		buddy.setEmail("jatin.sutaria@thev2technologies.com");
		buddy.setFirstName("Jatin");
		buddy.setLastName("Sutaria");
		buddy.setCategories("Helper, Cleaner");
		buddy.setIdentityType("email");
		buddy.setValidated(true);
		buddyService.saveOrUpdate(buddy);
	}
	
	@Test
	@Rollback(value=false)
	public void testBuddyCreationByMobile() throws Exception{
		Buddy buddy = new Buddy();
		buddy.setMobile("9820087118");
		buddy.setFirstName("Jay");
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
		
		fi = new File("testImages/Jatin Profile_V2Tech.docx");
		fileContent = Files.readAllBytes(fi.toPath());
		buddy.setCvExtension("docx");
		buddy.setCv(fileContent);
		
		buddy.setPassword("password");
		//buddy.setValidated(tr);
		buddyService.saveOrUpdate(buddy);
	}
	
	public static void main(String args[]) throws Exception{
		Buddy buddy = new Buddy();
		buddy.setMobile("9930070660");
		buddy.setFirstName("Jatin");
		buddy.setLastName("Sutaria");
		buddy.setCategories("Painter, Carpenter, Electrican");
		buddy.setIdentityType("mobile");
		
		
		File fi = new File("testImages/jat.png");
		byte[] fileContent = Files.readAllBytes(fi.toPath());
		buddy.setPanExtension("png");
		//buddy.setPan(fileContent);
		
		fi = new File("testImages/jat1.JPG");
		fileContent = Files.readAllBytes(fi.toPath());
		buddy.setAadharExtension("JPG");
		//buddy.setAadhar(fileContent);
		
		fi = new File("testImages/jat2.JPG");
		fileContent = Files.readAllBytes(fi.toPath());
		buddy.setPassportExtension("JPG");
		//buddy.setPassport(fileContent);
		
		ObjectMapper mapper = new ObjectMapper();
		String str = mapper.writeValueAsString(buddy);
		System.out.println(str);
	}
	
	@Test
	public void testUserData() throws Exception{
		UserData data = new UserData();
		data.setIdentity("rrr");
		data.setIdentityType("eee");
		data.setToken("rrr");
		ObjectMapper mapper = new ObjectMapper();
		String str = mapper.writeValueAsString(data);
		System.out.println(str);
	}

}
