package com.anachaves.console.twitter.domain.use_case;

import com.anachaves.console.twitter.domain.model.UserTimeline;
import com.anachaves.console.twitter.domain.repository.UserTimelineRepository;

import java.time.LocalDateTime;

public class PostingUseCase {

	private final UserTimelineRepository userTimelinesRepository;

	public PostingUseCase(UserTimelineRepository userTimelinesRepository) {
		this.userTimelinesRepository = userTimelinesRepository;
	}

	public void execute(String input) {
		String[] result = input.split("->");
		if(result.length > 1 && !result[1].isEmpty() && !result[1].trim().isEmpty()) {
			userTimelinesRepository.saveTimeline(new UserTimeline(
				result[0].trim(),
				result[1].trim(),
				LocalDateTime.now()
			));
		}
	}
}
