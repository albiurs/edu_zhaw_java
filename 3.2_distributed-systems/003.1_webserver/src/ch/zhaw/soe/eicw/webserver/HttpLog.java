/*
 *  Copyright (c) 2019 ZHAW School of Engineering. All rights are reserved.
 */
package ch.zhaw.soe.eicw.webserver;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * A simple file logger. 
 */
public class HttpLog {
	public static HttpLog logger;
	private BufferedWriter logfileWriter;
	
	private HttpLog(File logfile) throws IOException {
		logfileWriter = new BufferedWriter(new FileWriter(logfile, true));
	}
	
	public static void initializeLogger(File logfile) throws IOException {
		if (logger == null)
			logger = new HttpLog(logfile);
	}
	
	public void log(String info) throws IOException {
		synchronized (logfileWriter) {
			logfileWriter.write(info);
			logfileWriter.newLine();
			logfileWriter.flush();
			System.out.println(info);
		}
	}
	
  public void close() {
    try {
      logfileWriter.flush();
      logfileWriter.close();
    } catch (IOException e) {
    }
  }
}
