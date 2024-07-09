package myApp.com.shared;

import java.security.SecureRandom;
import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class Utils {
	
	
	private final Random RANDOM  = new SecureRandom();

	private final String ALPHABT = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
	
	public String generateStringId(int length){
		
	   StringBuilder returnValue = new StringBuilder(length);
	   
	   for(int i = 0; i < length; i++)
		   returnValue.append(ALPHABT.charAt(RANDOM.nextInt(ALPHABT.length())));
	   return returnValue.toString();
	}

}
