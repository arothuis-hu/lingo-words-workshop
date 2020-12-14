package nl.hu.vkbep.example.lingo;

import nl.hu.vkbep.example.lingo.words.core.application.WordImporter;
import nl.hu.vkbep.example.lingo.words.core.application.WordService;
import nl.hu.vkbep.example.lingo.words.core.domain.LingoWordFilter;
import nl.hu.vkbep.example.lingo.words.core.domain.WordFilter;
import nl.hu.vkbep.example.lingo.words.core.ports.WordWriter;
import nl.hu.vkbep.example.lingo.words.infrastructure.driven.file.TxtFileWordReader;
import nl.hu.vkbep.example.lingo.words.infrastructure.driven.file.TxtFileWordWriter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.nio.file.Path;
import java.util.Random;

@Configuration
public class AppConfig {
    @Value("${lingo.source}")
    private String inputSource;

    @Value("${lingo.target}")
    private String outputSource;

    @Bean
    public WordImporter wordImporter(WordFilter filter, WordWriter writer) {
        return new WordImporter(this.importWordReader(), filter, writer);
    }

    @Bean
    public WordService wordService() {
        return new WordService(new Random(), this.randomWordReader());
    }

    @Bean
    public WordFilter wordFilter() {
        return new LingoWordFilter();
    }

    @Bean
    public TxtFileWordReader importWordReader() {
        return new TxtFileWordReader(Path.of(inputSource));
    }

    @Bean
    public TxtFileWordWriter importWordWriter() {
        return new TxtFileWordWriter(Path.of(outputSource));
    }

    @Bean
    public TxtFileWordReader randomWordReader() {
        return new TxtFileWordReader(Path.of(outputSource));
    }
}
