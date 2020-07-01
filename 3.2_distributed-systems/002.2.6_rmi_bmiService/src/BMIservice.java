/*
 *  Copyright (c) 2018 ZHAW School of Engineering. All rights are reserved.
 */
import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Interface for the bmi service methods.  
 *
 */
public interface BMIservice extends Remote {
	float calculateBMI(float mass, float heigth) throws RemoteException;
}
