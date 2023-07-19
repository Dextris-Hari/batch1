package com.xworkz.logger;

import java.io.OutputStream;
import java.util.logging.Formatter;
import java.util.logging.LogRecord;
import java.util.logging.StreamHandler;

public class MyLoggers  extends StreamHandler{

	public MyLoggers() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MyLoggers(OutputStream out, Formatter formatter) {
		super(out, formatter);
		System.out.println(" running on publish");
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public  void publish(LogRecord record) {
		// TODO Auto-generated method stub
		super.publish(record);
	}
	@Override
	public  void flush() {
		System.out.println("runnning in flush");
		// TODO Auto-generated method stub
		super.flush();
	}
	@Override
	public  void close() throws SecurityException {
		System.out.println("running in close");
		// TODO Auto-generated method stub
		super.close();
	}

}
