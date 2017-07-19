package com.hirebuddy.services.impl;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.UUID;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.persistence.EntityManager;

import org.apache.commons.io.FileUtils;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.hirebuddy.common.ConfUtil;
import com.hirebuddy.common.NotificationService;
import com.hirebuddy.dao.BuddyDao;
import com.hirebuddy.dao.JPADAO;
import com.hirebuddy.domain.Buddy;
import com.hirebuddy.exceptions.HireBuddyException;
import com.hirebuddy.services.BuddyService;

@Service("buddyService")
@Transactional(propagation= Propagation.REQUIRED, rollbackFor=HireBuddyException.class)
public class BuddyServiceImpl extends HireBuddyServiceImpl<Long, Buddy> implements BuddyService{
	@Autowired
    protected BuddyDao dao;
	
	@Autowired
	private ConfUtil confUtilService;

	@PostConstruct
    public void init() throws Exception {
	 super.setDAO((JPADAO) dao);
    }
    
    @PreDestroy
    public void destroy() {
    }
    
    @Override
    public void setEntityManagerOnDao(EntityManager entityManager){
    	dao.setEntityManager(entityManager);
    }
    
    public void saveOrUpdate(Buddy buddy) throws HireBuddyException{
    	
    	if(buddy.getPassword() == null || buddy.getPassword().trim().length() < 4 ){
    		throw new HireBuddyException("Invalid_Password");
    	}
    	
    	if(buddy.getIdentityType() == null || buddy.getIdentityType().trim().length() == 0 || (!buddy.getIdentityType().equalsIgnoreCase("email") && !buddy.getIdentityType().equalsIgnoreCase("mobile"))){
    		throw new HireBuddyException("Buddy_Identity_Type_Invalid");
    	}
    	Buddy buddy2 = null;
    	if(buddy.getIdentityType().equals("email")){
    		if(buddy.getEmail() == null || buddy.getEmail().trim().length() == 0){
    			throw new HireBuddyException("Buddy_Email_Invalid");
    		}
    		buddy2 = getUniqueBuddyByEmail(buddy.getEmail());
     	}
    	
    	if(buddy.getIdentityType().equals("mobile")){
    		if(buddy.getMobile() == null || buddy.getMobile().trim().length() == 0){
    			throw new HireBuddyException("Buddy_Mobile_Invalid");
    		}
    		
    		buddy2 = getUniqueBuddyByMobile(buddy.getMobile());
     	}
    	if(buddy2 == null){
			//create
    		buddy = saveAndGenerateDocumentUrls(buddy);
    		//Generate and save otp
    		Random random = new Random();
    		String otp = (random.nextInt()+"");
    		otp = otp.substring(1, 5);
    		buddy.setOneTimePassword(otp);
    			if(buddy.getIdentityType().equals("mobile")){
    				NotificationService.sentOTPForNotification(buddy.getMobile(), otp);
    			}
    			
			dao.persist(buddy);
			
		}
		else{
			//update
			DozerBeanMapper beanMapper = new DozerBeanMapper();
			buddy.setId(buddy2.getId());
			beanMapper.map(buddy, buddy2);
			buddy2 = saveAndGenerateDocumentUrls(buddy2);
			dao.merge(buddy2);
		}
     }
    
    private Buddy saveAndGenerateDocumentUrls(Buddy buddy){
    	try {
			if(buddy.getPan() != null && buddy.getPanExtension() != null && buddy.getPanExtension().trim().length() !=0){
				FileUtils.writeByteArrayToFile(new File(confUtilService.getDocumentsLocation()+File.separator+""+buddy.getFirstName()+"-"+buddy.getMobile()+"-PAN."+buddy.getPanExtension()), buddy.getPan());
				buddy.setPanURL(confUtilService.getDocumentsServerBaseUrl()+buddy.getFirstName()+"-"+buddy.getMobile()+"-PAN."+buddy.getPanExtension());
			}
			
			if(buddy.getAadhar() != null && buddy.getAadharExtension() != null && buddy.getAadharExtension().trim().length() !=0){
				FileUtils.writeByteArrayToFile(new File(confUtilService.getDocumentsLocation()+File.separator+""+buddy.getFirstName()+"-"+buddy.getMobile()+"-AADHAR."+buddy.getAadharExtension()), buddy.getAadhar());
				buddy.setAadharURL(confUtilService.getDocumentsServerBaseUrl()+buddy.getFirstName()+"-"+buddy.getMobile()+"-AADHAR."+buddy.getAadharExtension());
			}
			
			if(buddy.getPassport() != null && buddy.getPassportExtension() != null && buddy.getPassportExtension().trim().length() !=0){
				FileUtils.writeByteArrayToFile(new File(confUtilService.getDocumentsLocation()+File.separator+""+buddy.getFirstName()+"-"+buddy.getMobile()+"-PASSPORT."+buddy.getPassportExtension()), buddy.getPassport());
				buddy.setPassportUrl(confUtilService.getDocumentsServerBaseUrl()+buddy.getFirstName()+"-"+buddy.getMobile()+"-PASSPORT."+buddy.getAadharExtension());
			}
			
			if(buddy.getCv() != null && buddy.getCvExtension() != null && buddy.getCvExtension().trim().length() !=0){
				FileUtils.writeByteArrayToFile(new File(confUtilService.getDocumentsLocation()+File.separator+""+buddy.getFirstName()+"-"+buddy.getMobile()+"-CV."+buddy.getCvExtension()), buddy.getCv());
				buddy.setCvURL(confUtilService.getDocumentsServerBaseUrl()+buddy.getFirstName()+"-"+buddy.getMobile()+"-CV."+buddy.getCvExtension());
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			throw new HireBuddyException("CAN_NOT_CREATE_PAN_FILE", e);
		}
    	return buddy;
    }
    
    public Buddy getUniqueBuddyByEmail(String name) throws HireBuddyException{
    	Map<String, String> queryParams = new HashMap<String, String>();
		queryParams.put("email", name);
		queryParams.put("identityType", "email");
		
		List<Buddy> buddies = findByNamedQueryAndNamedParams(
				"Buddy.getBuddyByEmail", queryParams);
		
		if (buddies == null) {
			return null;
		} else if (buddies != null && buddies.size() == 0) {
			return null;
		}
		return buddies.get(0);
    }
    
    public Buddy getUniqueBuddyByMobile(String name) throws HireBuddyException{
    	Map<String, String> queryParams = new HashMap<String, String>();
		queryParams.put("mobile", name);
		queryParams.put("identityType", "mobile");
		
		List<Buddy> buddies = findByNamedQueryAndNamedParams(
				"Buddy.getBuddyByMobile", queryParams);
		
		if (buddies == null) {
			return null;
		} else if (buddies != null && buddies.size() == 0) {
			return null;
		}
		return buddies.get(0);
    }
    
    public void verifyOTP(String buddyIdentity, String identityType, String otp) throws HireBuddyException{
    	if(buddyIdentity == null || identityType == null || otp == null){
    		throw new HireBuddyException("INCOMPLETE_DATA");
    	}
    	
    	if(identityType.equalsIgnoreCase("mobile")){
    		Buddy buddy = getUniqueBuddyByMobile(buddyIdentity);
    		if(buddy == null){
    			throw new HireBuddyException("BUDDY_NOT_FOUND");
    		}
    		
    		if(buddy.getOneTimePassword().equalsIgnoreCase(otp)){
    			buddy.setValidated(true);
    			dao.merge(buddy);
    			//buddy.s
    		}
    	}
    	
    }
    
    public Boolean authenticate(String identity, String identityType, String password)throws HireBuddyException{
    	if(identityType.equalsIgnoreCase("mobile")){
    		Buddy buddy = getUniqueBuddyByMobile(identity);
    		if(buddy == null){
    			return false;
    		}
    		
    		if(buddy.getPassword().equals(password) && buddy.getValidated() == true){
    			return true;
    		}
    	}
    	
    	return false;
    }
 
}
