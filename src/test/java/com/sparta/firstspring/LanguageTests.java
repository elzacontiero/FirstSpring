package com.sparta.firstspring;
import com.sparta.firstspring.entities.Language;
import com.sparta.firstspring.repositories.LanguageRepository;
import org.junit.jupiter.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.junit.jupiter.api.Test;

import java.time.Instant;
import java.util.Optional;
import jakarta.transaction.Transactional;


@Transactional
@SpringBootTest
public class LanguageTests {

    @Autowired
    private LanguageRepository repo;

    @Test
    public void staffTestOne() {
        Optional<Language> result = repo.findById((short) 1);
        Assertions.assertTrue(result.isPresent());
        Language language = result.get();
        Assertions.assertEquals("English", language.getName());
    }

    @Test
    public void staffTestInsert() {
        Language lang = new Language();
        lang.setName("Portuguese");
        lang.setId((short)0);
        lang.setLastUpdate(Instant.now());
        lang = repo.save(lang);

        Optional<Language> opt = repo.findById(lang.getId());
        Assertions.assertTrue(opt.isPresent());
        Language lang2 = opt.get();
        Assertions.assertEquals("Portuguese", lang2.getName());
    }

}
