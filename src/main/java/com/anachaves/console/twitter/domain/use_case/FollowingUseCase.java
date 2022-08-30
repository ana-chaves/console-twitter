package com.anachaves.console.twitter.domain.use_case;

import com.anachaves.console.twitter.domain.repository.UserFollowedRepository;

public class FollowingUseCase {

	private final UserFollowedRepository userFollowedRepository;

	public FollowingUseCase(UserFollowedRepository userFollowedRepository) {
		this.userFollowedRepository = userFollowedRepository;
	}

	public void execute(String input) {
		String[] result = input.split("follows");
		userFollowedRepository.save(result[0].trim(), result[1].trim());
	}
}
