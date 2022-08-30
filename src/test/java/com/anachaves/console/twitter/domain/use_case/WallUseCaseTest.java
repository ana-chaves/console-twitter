package com.anachaves.console.twitter.domain.use_case;

import com.anachaves.console.twitter.domain.repository.UserFollowedRepository;
import com.anachaves.console.twitter.domain.repository.UserTimelineRepository;
import com.anachaves.console.twitter.service.DiffTimeCalculator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class WallUseCaseTest {
	@InjectMocks
	private WallUseCase useCase;
	@Mock
	private UserTimelineRepository userTimelineRepository;
	@Mock
	private UserFollowedRepository userFollowedRepository;
	@Mock
	private DiffTimeCalculator diffTimeCalculator;

	@BeforeEach
	void init() {
		useCase = new WallUseCase(userTimelineRepository, userFollowedRepository, diffTimeCalculator);
	}

	@Test
	void when_execute_then_user_followed_list_are_found() {
		this.useCase.execute("user1 wall");

		verify(this.userFollowedRepository).find("user1");
	}

	@Test
	void when_user_followed_others_then_timelines_retrieve() {
		when(this.userFollowedRepository.find(any())).thenReturn(Arrays.asList("user2", "user3"));

		this.useCase.execute("user1 wall");

		verify(this.userTimelineRepository).find("user2");
		verify(this.userTimelineRepository).find("user3");
	}

}