package com.anachaves.console.twitter.service;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class DiffTimeCalculator {

	public String execute(LocalDateTime firstDate, LocalDateTime secondDate) {
		long secondsDiff = ChronoUnit.SECONDS.between(
			firstDate,
			secondDate
			);
		if(secondsDiff > 59) {
			return String.valueOf(secondsDiff / 60).concat(" minutes ago");
		}

		return String.valueOf(secondsDiff).concat(" seconds ago");

	}

}
