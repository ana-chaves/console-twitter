package com.anachaves.console.twitter.domain.use_case;

import com.anachaves.console.twitter.domain.repository.UserTimelineRepository;
import com.anachaves.console.twitter.service.DiffTimeCalculator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class ReadingUseCaseTest {
	@InjectMocks
	private ReadingUseCase useCase;
	@Mock
	private UserTimelineRepository repository;
	@Mock
	private DiffTimeCalculator calculator;

	@BeforeEach
	void init() {
		useCase = new ReadingUseCase(repository, calculator);
	}

	@Test
	void when_execute_user_followed_relation_save() {
		useCase.execute("user1");

		verify(this.repository).find("user1");
	}

}