package com.anachaves.console.twitter.domain.repository;

import com.anachaves.console.twitter.domain.model.UserTimeline;

import java.util.List;

public interface UserTimelineRepository {

	void saveTimeline(UserTimeline userTimeline);

	List<UserTimeline> find(String username);
}
