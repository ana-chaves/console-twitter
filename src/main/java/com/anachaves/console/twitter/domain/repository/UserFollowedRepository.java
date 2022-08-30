package com.anachaves.console.twitter.domain.repository;

import java.util.List;

public interface UserFollowedRepository {

	void save(String username, String usernameFollowed);

	List<String> find(String username);
}
