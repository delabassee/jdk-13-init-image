package com.example.fn;
import java.util.logging.Level;
import java.util.logging.Logger;

public class HelloFunction {


	public String handleRequest(String input) {

		String name = (input == null || input.isEmpty()) ? "world"  : input;
		return "Hello, " + name + "!";
	}

}