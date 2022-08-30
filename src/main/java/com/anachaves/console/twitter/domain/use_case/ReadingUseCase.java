package com.anachaves.console.twitter.domain.use_case;

import com.anachaves.console.twitter.domain.model.UserTimeline;
import com.anachaves.console.twitter.domain.repository.UserTimelineRepository;
import com.anachaves.console.twitter.service.DiffTimeCalculator;

import java.time.LocalDateTime;
import java.util.List;

import static java.util.Objects.isNull;

public class ReadingUseCase {

	private final UserTimelineRepository userTimelineRepository;
	private final DiffTimeCalculator diffTimeCalculator;

	public ReadingUseCase(UserTimelineRepository userTimelineRepository, DiffTimeCalculator diffTimeCalculator) {
		this.userTimelineRepository = userTimelineRepository;
		this.diffTimeCalculator = diffTimeCalculator;
	}

	public void execute(String input) {
		List<UserTimeline> result = userTimelineRepository.find(input.trim());
		if(!isNull(result)) {
			for(UserTimeline userTimeline : result) {
				System.out.println(userTimeline.getTimeline() + " (" + diffTimeCalculator.execute(
					userTimeline.getCreatedDate(),
					LocalDateTime.now()
				) + ")");
			}
		}
	}

}
