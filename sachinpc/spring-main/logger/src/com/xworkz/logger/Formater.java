package com.xworkz.logger;

import java.sql.Date;
import java.util.logging.Formatter;
import java.util.logging.LogRecord;

public class Formater extends Formatter {

	@Override
	public String format(LogRecord record) {
		return record.getThreadID() + "::" + record.getSourceClassName() + "::" + record.getSourceMethodName() + "::"
				+ new Date(record.getMillis()) + "::" + record.getMessage() + "\n";
	}
	public static void main(String[] args) {
		System.out.println("calling");
		Formater formater = new Formater();
		formater.format(null);
	}
}
