package com.anachaves.console.twitter.domain.use_case;

import com.anachaves.console.twitter.builder.FakeClock;
import com.anachaves.console.twitter.domain.model.UserTimeline;
import com.anachaves.console.twitter.domain.repository.UserTimelineRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyZeroInteractions;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PostingUseCaseTest {
	@InjectMocks
	private PostingUseCase useCase;
	@Mock
	private UserTimelineRepository repository;

	@BeforeEach
	void init() {
		useCase = new PostingUseCase(repository);
	}

	@Test
	void when_execute_user_post_is_saved() {
		useCase.execute("user -> timeline");

		verify(this.repository, times(1)).saveTimeline(any());
	}

	@Test
	void when_execute_user_post_empty_then_post_is_not_saved() {
		useCase.execute("user -> ");

		verifyZeroInteractions(this.repository);
	}

}