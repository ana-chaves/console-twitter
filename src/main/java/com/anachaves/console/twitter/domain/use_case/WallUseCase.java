package com.anachaves.console.twitter.domain.use_case;

import com.anachaves.console.twitter.domain.model.UserTimeline;
import com.anachaves.console.twitter.domain.repository.UserFollowedRepository;
import com.anachaves.console.twitter.domain.repository.UserTimelineRepository;
import com.anachaves.console.twitter.service.DiffTimeCalculator;

import java.time.LocalDateTime;
import java.util.List;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

public class WallUseCase {

	private final UserTimelineRepository userTimelineRepository;
	private final UserFollowedRepository userFollowedRepository;

	private final DiffTimeCalculator diffTimeCalculator;

	public WallUseCase(
		UserTimelineRepository userTimelineRepository,
		UserFollowedRepository userFollowedRepository,
		DiffTimeCalculator diffTimeCalculator
	) {
		this.userTimelineRepository = userTimelineRepository;
		this.userFollowedRepository = userFollowedRepository;
		this.diffTimeCalculator = diffTimeCalculator;
	}

	public void execute(String input) {
		String[] result = input.split("wall");
		List<UserTimeline> timelines = userTimelineRepository.find(result[0].trim());
		List<String> userFollowedList = userFollowedRepository.find(result[0].trim());
		for(UserTimeline userTimeline : timelines) {
			this.printMessage(
				result[0].trim(),
				userTimeline.getTimeline(),
				userTimeline.getCreatedDate()
			);
		}
		if(!isNull(userFollowedList)) {
			for(String userFollowed : userFollowedList) {
				List<UserTimeline> timelinesFollowedList = userTimelineRepository.find(userFollowed);
				if(nonNull(timelinesFollowedList)) {
					for(UserTimeline userTimelineFollowed : timelinesFollowedList) {
						this.printMessage(
							userTimelineFollowed.getUsername(),
							userTimelineFollowed.getTimeline(),
							userTimelineFollowed.getCreatedDate()
						);
					}
				}
			}
		}
	}

	private void printMessage(String username, String timeline, LocalDateTime createdDate) {
		System.out.println(username + " - " + timeline + " (" + diffTimeCalculator.execute(
			createdDate,
			LocalDateTime.now()
		) + ")");
	}
}
