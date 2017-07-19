package com.hirebuddy.services.test;

import java.io.File;
import java.nio.file.Files;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import org.junit.Test;

import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;
import com.hirebuddy.domain.Buddy;

public class TestWebservicesClient {
	
	@Test
	public void testCreateBuddy() throws Exception{
		Client client = ClientBuilder.newBuilder().newClient().register(new JacksonJsonProvider());
		//client.
		WebTarget target = client.target("http://ec2-13-126-141-183.ap-south-1.compute.amazonaws.com/hirebuddy-1.0/ws/rest/buddyService/buddy/token/test");
		
		 
		Invocation.Builder builder = target.request();
		Buddy buddy = getBuddy();
		String res = builder.post(Entity.entity(buddy, MediaType.APPLICATION_JSON), String.class);
		System.out.println(res);		
	}
	
	private Buddy getBuddy() throws Exception{
		Buddy buddy = new Buddy();
		buddy.setMobile("9892905291");
		buddy.setFirstName("Sachin");
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
		return buddy;
	}

}
