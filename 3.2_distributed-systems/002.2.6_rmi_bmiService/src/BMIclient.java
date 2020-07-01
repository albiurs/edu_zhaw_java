/*
 *  Copyright (c) 2018 ZHAW School of Engineering. All rights are reserved.
 */
import java.rmi.Naming;

/**
 * 
 * @author eicw
 *
 */
public class BMIclient {
	public static void main(String args[]) throws Exception {
    if (args.length != 3) {
      System.out.println("Usage: java -cp bin BMIclient <ip address> <mass> <height>");
      System.exit(1);
    }	  
	  
		try {
			String host = args[0];
			float mass = Float.parseFloat(args[1]);
			float heigth = Float.parseFloat(args[2]);
			
			BMIservice remote = (BMIservice) Naming.lookup("//" + host + "/bmi");
			float bmi = remote.calculateBMI(mass, heigth);
			System.out.format("BMI=%f", bmi);
		} catch (Exception e) {
			System.err.println(e);
		}
	}
}
