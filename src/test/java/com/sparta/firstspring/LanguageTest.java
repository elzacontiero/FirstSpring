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

/*
The annotation @Transactional below fixes error
    [ERROR] testStaffAddress  Time elapsed: 3.46 s  <<< ERROR!
    org.hibernate.LazyInitializationException: could not initialize proxy [com.sparta.firstspring.entities.Address#3] - no Session
            at com.sparta.firstspring.StaffTests.testStaffAddress(StaffTests.java:22)
Got the anwer from
    https://stackoverflow.com/questions/21574236/how-to-fix-org-hibernate-lazyinitializationexception-could-not-initialize-prox#32276916
 */
@Transactional
@SpringBootTest
public class LanguageTest {

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
