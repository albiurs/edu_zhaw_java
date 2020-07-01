/*
 *  Copyright (c) 2018 ZHAW School of Engineering. All rights are reserved.
 */
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

@SuppressWarnings("serial")
/**
 * Implements the bmi service methods. 
 *
 */
public class BMIserviceImpl extends UnicastRemoteObject implements BMIservice {

	public BMIserviceImpl() throws RemoteException {};
	
	public float calculateBMI(float mass, float height) {
		return mass/(height*height);
	}
}
