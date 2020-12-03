package nl.hu.vkbep.example.lingo.words.core.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class LingoWordFilterTest {

	private LingoWordFilter filter;

	@BeforeEach
	void beforeEach() {
		filter = new LingoWordFilter();
	}

	static Stream<Arguments> provideWordsOfVaryingLength() {
		return Stream.of(
				Arguments.of("pizza", true),
				Arguments.of("pizzas", true),
				Arguments.of("backend", true),
				Arguments.of("beer", false),
				Arguments.of("software", false),
				Arguments.of("developer", false)
		);
	}

	@ParameterizedTest
	@MethodSource("provideWordsOfVaryingLength")
	void accepts_words_of_5_6_7_letters(String word, boolean shouldAccept) {
		boolean accepts = filter.verify(word);
		assertEquals(shouldAccept, accepts);
	}

	static Stream<Arguments> provideWordsOfVaryingCase() {
		return Stream.of(
				Arguments.of("pizza", true),
				Arguments.of("Pizza", false),
				Arguments.of("PiZZa", false),
				Arguments.of("PIZZA", false),
				Arguments.of("pizzA", false),
				Arguments.of("piZza", false)
		);
	}

	@ParameterizedTest
	@MethodSource("provideWordsOfVaryingCase")
	void accepts_words_of_lowercase_only(String word, boolean shouldAccept) {
		boolean accepts = filter.verify(word);
		assertEquals(shouldAccept, accepts);
	}
}
