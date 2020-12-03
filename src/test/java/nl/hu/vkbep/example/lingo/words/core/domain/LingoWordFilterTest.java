package nl.hu.vkbep.example.lingo.words.core.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LingoWordFilterTest {

	private LingoWordFilter filter;

	@BeforeEach
	void beforeEach() {
		filter = new LingoWordFilter();
	}

	@Test
	void accepts_words_of_5_letters() {
		String word = "pizza";

		boolean accepts = filter.verify(word);

		assertTrue(accepts);
	}

	@Test
	void accepts_words_of_6_letters() {
		String word = "pizzas";

		boolean accepts = filter.verify(word);

		assertTrue(accepts);
	}

	@Test
	void rejects_words_of_4_letters() {
		String word = "bier";

		boolean accepts = filter.verify(word);

		assertFalse(accepts);
	}

}
