package com.hotel.helper;

public class ExceptionHelper {
	
	public static RuntimeException throwResourceNotFoundException() {
		return new RuntimeException("Resource you are looking for is not found !!!");
	}

}
