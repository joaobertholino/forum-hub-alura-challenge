package br.com.alura.forumhubalurachallenge.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum TopicStatus {
	ACTIVE("Active"),
	CLOSED("Closed");

	private final String status;
}
