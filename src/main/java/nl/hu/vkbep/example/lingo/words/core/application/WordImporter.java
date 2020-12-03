package nl.hu.vkbep.example.lingo.words.core.application;

import nl.hu.vkbep.example.lingo.words.core.domain.WordFilter;
import nl.hu.vkbep.example.lingo.words.core.ports.WordReader;
import nl.hu.vkbep.example.lingo.words.core.ports.WordWriter;

public class WordImporter {
	private final WordReader reader;
	private final WordFilter filter;
	private final WordWriter writer;

	public WordImporter(WordReader reader, WordFilter filter, WordWriter writer) {
		this.reader = reader;
		this.filter = filter;
		this.writer = writer;
	}

	public void importWords() {
		// TODO: implement
	}
}
