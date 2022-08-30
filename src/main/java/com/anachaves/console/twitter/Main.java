package com.anachaves.console.twitter;

import com.anachaves.console.twitter.domain.repository.UserFollowedRepository;
import com.anachaves.console.twitter.domain.repository.UserTimelineRepository;
import com.anachaves.console.twitter.domain.use_case.FollowingUseCase;
import com.anachaves.console.twitter.domain.use_case.PostingUseCase;
import com.anachaves.console.twitter.domain.use_case.ReadingUseCase;
import com.anachaves.console.twitter.domain.use_case.WallUseCase;
import com.anachaves.console.twitter.infrastructure.memory.MemoryUserFollowedRepository;
import com.anachaves.console.twitter.infrastructure.memory.MemoryUserTimelineRepository;
import com.anachaves.console.twitter.service.DiffTimeCalculator;

import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		UserTimelineRepository userTimelineRepository = new MemoryUserTimelineRepository(new HashMap<>());
		UserFollowedRepository userFollowedRepository = new MemoryUserFollowedRepository(new HashMap<>());
		DiffTimeCalculator diffTimeCalculator = new DiffTimeCalculator();

		PostingUseCase postingUseCase = new PostingUseCase(userTimelineRepository);
		ReadingUseCase readingUseCase = new ReadingUseCase(userTimelineRepository, new DiffTimeCalculator());
		FollowingUseCase followingUseCase = new FollowingUseCase(userFollowedRepository);
		WallUseCase wallUseCase = new WallUseCase(userTimelineRepository, userFollowedRepository, diffTimeCalculator);

		Scanner scanner = new Scanner(System.in);
		boolean execute = true;

		System.out.println("Welcome to Twitter Console. To end the application, put exit");
		while(execute) {
			String input = checkInput(scanner);

			if(input.contains("->")) {
				postingUseCase.execute(input);
			}
			else if(input.contains(("follows"))) {
				followingUseCase.execute(input);
			}
			else if(input.contains("wall")) {
				wallUseCase.execute(input);
			}
			else if(input.contains("exit")) {
				execute = false;
			}
			else {
				readingUseCase.execute(input);
			}
		}
	}

	private static String checkInput(Scanner scanner) {
		String menuInput = "";
		try {
			menuInput = scanner.nextLine();
		} catch(InputMismatchException e) {
			System.out.print("Invalid value");
			scanner.nextLine();
		}

		return menuInput;
	}

}
