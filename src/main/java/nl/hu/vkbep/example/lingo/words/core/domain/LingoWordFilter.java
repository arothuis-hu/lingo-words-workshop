package nl.hu.vkbep.example.lingo.words.core.domain;

public class LingoWordFilter implements WordFilter {
	@Override
	public boolean verify(String word) {
		return word.length() == 5;
	}
}
