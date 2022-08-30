package com.anachaves.console.twitter.infrastructure.memory;

import com.anachaves.console.twitter.domain.repository.UserFollowedRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static java.util.Objects.isNull;

public class MemoryUserFollowedRepository implements UserFollowedRepository {

	Map<String, List<String>> userFollowedRepository;

	public MemoryUserFollowedRepository(Map<String, List<String>> userFollowedRepository) {
		this.userFollowedRepository = userFollowedRepository;
	}

	public void save(String username, String usernameFollowed) {
		List<String> userFollowedList = this.find(username);
		if(isNull(userFollowedList)) {
			userFollowedList = new ArrayList<>();
		}
		userFollowedList.add(usernameFollowed);
		userFollowedRepository.put(username, userFollowedList);
	}

	public List<String> find(String username) {
		return userFollowedRepository.get(username);
	}

}
