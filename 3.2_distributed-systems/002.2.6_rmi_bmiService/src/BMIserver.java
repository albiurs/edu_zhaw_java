/*
 *  Copyright (c) 2018 ZHAW School of Engineering. All rights are reserved.
 */
import java.rmi.Naming;
import java.rmi.Remote;

/**
 * Main program for starting the bmi server. 
 *
 */
public class BMIserver {
	public static void main(String args[]) throws Exception {
		Remote remote = new BMIserviceImpl();
		Naming.rebind("bmi", remote);
		System.out.println("BMI Server started ...");
	}
}
