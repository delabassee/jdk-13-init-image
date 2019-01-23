package com.example.fn;

public class HelloFunction {

	public String handleRequest(String input) {

		var result =  
			switch (input.toUpperCase())
			{  
				case "MONDAY", "TUESDAY" -> "Get back to work :(";  
				case "WEDNESDAY" -> "Wait for the end of week.";
				case "THURSDAY" -> "Almost there... wait till tomorrow...";
				case "FRIDAY" -> "Prepare plan for the weekend!";
				case "SATURDAY", "SUNDAY" -> "Enjoy the weekend! :-)";
				default -> "Please tell which day...";
			};

	 return result;

	}

}