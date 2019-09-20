package com.example.fn;
import java.util.logging.Level;
import java.util.logging.Logger;

public class HelloFunction {

    private final static Logger LOGGER = Logger.getLogger(HelloFunction.class.getName());


	public String handleRequest(String input) {

		LOGGER.info("Java function called - " + input);

		String ver = System.getProperty("java.runtime.version");

	 return "Hello " + input  +" - " + ver;

	}

}