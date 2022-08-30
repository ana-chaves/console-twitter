package com.anachaves.console.twitter.infrastructure.memory;

import com.anachaves.console.twitter.domain.model.UserTimeline;
import com.anachaves.console.twitter.domain.repository.UserTimelineRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static java.util.Objects.isNull;

public class MemoryUserTimelineRepository implements UserTimelineRepository {

	private Map<String, List<UserTimeline>> userTimelineRepository;

	public MemoryUserTimelineRepository(Map<String, List<UserTimeline>> userTimelineRepository) {
		this.userTimelineRepository = userTimelineRepository;
	}

	public void saveTimeline(UserTimeline userTimeline) {
		List<UserTimeline> timelines = this.find(userTimeline.getUsername());
		if(isNull(timelines)) {
			timelines = new ArrayList<>();
		}
		timelines.add(userTimeline);
		userTimelineRepository.put(userTimeline.getUsername(), timelines);
	}

	public List<UserTimeline> find(String username) {
		return userTimelineRepository.get(username);
	}
}
