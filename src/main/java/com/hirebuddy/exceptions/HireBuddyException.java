package com.hirebuddy.exceptions;

public class HireBuddyException extends RuntimeException{

	public HireBuddyException(){
		super();
	}
	
	public HireBuddyException(String message){
		super(message);
	}
	
	public HireBuddyException(String message, Throwable t){
		super(message, t);
	}

}
