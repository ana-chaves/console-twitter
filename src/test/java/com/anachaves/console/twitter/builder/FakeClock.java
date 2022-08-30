package com.anachaves.console.twitter.builder;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static java.util.Objects.isNull;

public class FakeClock {

	private static LocalDateTime now;
	private static LocalDateTime future;
	private static LocalDate localDateNow;

	public static LocalDateTime now() {
		checkMoments();
		return now;
	}

	public static LocalDateTime future() {
		checkMoments();
		return future;
	}

	private static void checkMoments() {
		LocalDateTime seed = LocalDateTime.now();

		if(isNull(now)) {
			now = LocalDateTime.of(
				seed.getYear(),
				seed.getMonthValue(),
				seed.getDayOfMonth(),
				seed.getHour(),
				seed.getMinute(),
				seed.getSecond()
			);
		}

		if(isNull(future)) {
			future = LocalDateTime.of(
				seed.getYear(),
				seed.getMonthValue(),
				seed.getDayOfMonth(),
				seed.getHour(),
				seed.getMinute(),
				seed.getSecond()
			).plusMonths(2);
		}
		if(isNull(localDateNow)) {
			localDateNow = LocalDate.of(
				seed.getYear(),
				seed.getMonthValue(),
				seed.getDayOfMonth()
			);
		}
	}
}
