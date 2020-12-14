package nl.hu.vkbep.example.lingo.words.infrastructure.driven.file;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class TxtFileWordReaderTest {
    public static final Path SOURCE_PATH = Path.of("src/test/resources/word-input.txt");

    @Test
    void reads_words() {
        var reader = new TxtFileWordReader(SOURCE_PATH);
        List<String> words = reader.readWords().collect(Collectors.toList());

        var expected = List.of(
                "hallo",
                "bier",
                "developer",
                "Den Haag",
                "Utrecht",
                "pizza"
        );

        assertEquals(expected, words);
    }

    @Test
    void cannot_read_words_from_non_existent_file() {
        var reader = new TxtFileWordReader(Path.of("src/test/resources/this-does-not-exist.txt"));
        assertThrows(RuntimeException.class, reader::readWords);
    }
}