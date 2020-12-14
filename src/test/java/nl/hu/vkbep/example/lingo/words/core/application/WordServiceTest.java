package nl.hu.vkbep.example.lingo.words.core.application;

import nl.hu.vkbep.example.lingo.words.core.ports.WordReader;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class WordServiceTest {
    @Test
    void get_random_word() {
        List<String> readWords = List.of(
            "bieren",
            "pizza",
            "baard"
        );
        int index = 1;
        String expected = readWords.get(index);

        var random = mock(Random.class);
        when(random.nextInt(anyInt())).thenReturn(index);

        var reader = mock(WordReader.class);
        when(reader.readWords()).thenReturn(readWords.stream());

        var service = new WordService(random, reader);

        String word = service.getRandomWord(5);

        assertEquals(expected, word);
    }
}