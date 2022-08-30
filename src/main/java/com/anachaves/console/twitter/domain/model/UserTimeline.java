package com.anachaves.console.twitter.domain.model;

import java.time.LocalDateTime;
import java.util.StringJoiner;


public class UserTimeline {
	private final String username;
	private final String timeline;
	private final LocalDateTime createdDate;

	public UserTimeline(String username, String timeline, LocalDateTime createdDate) {
		this.username = username;
		this.timeline = timeline;
		this.createdDate = createdDate;
	}

	public String getUsername() {
		return username;
	}

	public String getTimeline() {
		return timeline;
	}

	public LocalDateTime getCreatedDate() {
		return createdDate;
	}

	@Override
	public String toString() {
		return new StringJoiner(", ", "[", "]")
			.add("username=" + username)
			.add("timeline=" + timeline)
			.toString();
	}
}
