package com.anachaves.console.twitter.domain.use_case;

import com.anachaves.console.twitter.domain.repository.UserFollowedRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class FollowingUseCaseTest {
	@InjectMocks
	private FollowingUseCase useCase;
	@Mock
	private UserFollowedRepository repository;

	@BeforeEach
	void init() {
		useCase = new FollowingUseCase(repository);
	}

	@Test
	void when_execute_user_followed_relation_save() {
		useCase.execute("user1 follows user2");

		verify(this.repository).save("user1", "user2");
	}

}