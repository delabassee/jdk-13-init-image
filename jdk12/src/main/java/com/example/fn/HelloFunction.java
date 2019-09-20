package com.example.fn;
import java.util.logging.Level;
import java.util.logging.Logger;

public class HelloFunction {

    private final static Logger LOGGER = Logger.getLogger(HelloFunction.class.getName());



	public String handleRequest(String input) {

		LOGGER.info("Java 12 function called - " + input);

		var result =  
			switch (input.toUpperCase())
			{  
				case "MONDAY", "TUESDAY" -> "Get back to work! ";  
				case "WEDNESDAY" -> "Wait for the end of week. ";
				case "THURSDAY" -> "Almost there... wait till tomorrow... ";
				case "FRIDAY" -> "Prepare plan for the weekend! ";
				case "SATURDAY", "SUNDAY" -> "Enjoy the weekend! ";
				default -> "Please tell me which day... ";
			};

	 return result;

	}

}