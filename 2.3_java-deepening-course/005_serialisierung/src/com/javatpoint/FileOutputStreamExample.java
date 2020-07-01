package com.javatpoint;

import java.io.FileOutputStream;

/**
 * https://www.javatpoint.com/java-fileoutputstream-class
 */
public class FileOutputStreamExample {
	public static void main(String args[]){
		try{
			FileOutputStream fout=new FileOutputStream("src/com/publicept/testout.txt");
			fout.write(65);
			fout.close();
			System.out.println("success...");
		}catch(Exception e){System.out.println(e);}
	}
}