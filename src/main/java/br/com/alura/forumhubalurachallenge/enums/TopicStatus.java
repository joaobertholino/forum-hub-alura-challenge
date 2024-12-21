package br.com.alura.forumhubalurachallenge.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum TopicStatus {
	ACTIVE("Active"),
	NO_ACTIVE("No Active");

	private final String status;
}
