package com.anachaves.console.twitter.service;

import com.anachaves.console.twitter.builder.FakeClock;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(MockitoExtension.class)
class DiffTimeCalculatorTest {

	@InjectMocks
	private DiffTimeCalculator calculator;

	@Test
	void when_diff_less_than_minute_return_seconds() {
		LocalDateTime date1 = FakeClock.now();
		LocalDateTime date2 = FakeClock.now().plusSeconds(20);

		String result = calculator.execute(date1, date2);

		assertTrue(result.contains("seconds"));
		assertTrue(result.contains("20"));
	}

	@Test
	void when_diff_more_than_minute_return_minutes() {
		LocalDateTime date1 = FakeClock.now();
		LocalDateTime date2 = FakeClock.now().plusMinutes(2);

		String result = calculator.execute(date1, date2);

		assertTrue(result.contains("minutes"));
		assertTrue(result.contains("2"));
	}

}