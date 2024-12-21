package br.com.alura.forumhubalurachallenge.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum CourseCategory {
	GENERAL("General");

	private final String category;
}
