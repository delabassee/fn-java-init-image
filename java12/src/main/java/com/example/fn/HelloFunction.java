package com.example.fn;

public class HelloFunction {

	public String handleRequest(String input) {

		var result =  
			switch (input.toUpperCase())
			{  
				case "MONDAY", "TUESDAY" -> `Get back to work! The Life and Times of ¯\_(ツ)_/¯`;  
				case "WEDNESDAY" -> "Wait for the end of week.";
				case "THURSDAY" -> "Almost there... wait till tomorrow...";
				case "FRIDAY" -> ` \o/ Prepare plan for the weekend!`;
				case "SATURDAY", "SUNDAY" -> ` \o/ Enjoy the weekend!`;
				default -> "Please tell me which day...";
			};

	 return result;

	}

}

