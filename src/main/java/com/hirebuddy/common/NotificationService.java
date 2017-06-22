package com.hirebuddy.common;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import com.hirebuddy.exceptions.HireBuddyException;

public class NotificationService {
	
static String url = "http://control.msg91.com/api/sendhttp.php?authkey=156202AXw3MQvEBm6b59410559&";	
	
	public static void sentOTPForNotification(String mobile, String otp){
		url=url + "mobiles=";
		if(mobile.trim().length() != 10){
			throw new HireBuddyException("INVALID_MOBILE");
		}
		mobile = "91"+mobile;
		String message=URLEncoder.encode("Your OTP for registering into Hire Buddy is "+otp);
		url = url + mobile+"&message="+message+"&sender=HireBuddy&route=otp&country=91";
		
		URL u;
		try {
			u = new URL(url);
			HttpURLConnection con = (HttpURLConnection)u.openConnection();
			con.setRequestMethod("GET");
			int responseCode = con.getResponseCode();
			System.out.println("\nSending 'GET' request to URL : " + url);
			System.out.println("Response Code : " + responseCode);

			BufferedReader in = new BufferedReader(
			        new InputStreamReader(con.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();

			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();

			//print result
			System.out.println(response.toString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			throw new HireBuddyException("OTP_MESSAGE_SEND_FAILS");
		}
	}

}
