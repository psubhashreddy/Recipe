package com.recipes.utilities;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class FilterUtility {
	
	public static LocalDateTime formatDate(LocalDateTime createdOn) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
		String formatDateTime = createdOn.format(formatter);
		return LocalDateTime.parse(formatDateTime, formatter);
	}
	
}
