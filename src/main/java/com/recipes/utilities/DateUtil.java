package com.recipes.utilities;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateUtil {
	
	public static String formatDate(LocalDateTime createdOn) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMM-yyyy HH:mm:ss");
		return createdOn.format(formatter);
	}
	
}
