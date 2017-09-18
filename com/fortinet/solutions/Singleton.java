package com.fortinet.solutions;

public class Singleton {

	// variable to hold single instance of class
	private static Singleton instace;

	// making constructor private so it cannot be instantiated
	private Singleton() {

	}

	/**
	 * Get instance of Class
	 * 
	 * @return return instance of class Singleton
	 */
	public static Singleton getInstance() {
		// check if instance is already created
		// if not create instance
		if (instace == null) {
			instace = new Singleton();
		}

		return instace;
	}

}
