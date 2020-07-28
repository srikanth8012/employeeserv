package com.paypal.bfs.test.employeeserv.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.lang.StringUtils;

public class FormateUtill {

	private DateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy");

	public Date toDate(String dateString) throws ParseException {

		Date date = null;
		if (StringUtils.isNotEmpty(dateString)) {
			try {
				date = dateFormat.parse(dateString);
			} catch (ParseException e) {
				throw e;
			}
		}
		return date;
	}

	public String toDateString(Date date) {
		String dateString = "";
		if (date != null) {
			dateString = dateFormat.format(date);
		}
		return dateString;
	}

}
