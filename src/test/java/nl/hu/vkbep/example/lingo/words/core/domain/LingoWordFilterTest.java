package nl.hu.vkbep.example.lingo.words.core.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LingoWordFilterTest {



	@Test
	void accepts_words_of_5_letters() {
		LingoWordFilter filter = new LingoWordFilter();
		String word = "pizza";

		boolean accepts = filter.verify(word);

		assertTrue(accepts);
	}
}
