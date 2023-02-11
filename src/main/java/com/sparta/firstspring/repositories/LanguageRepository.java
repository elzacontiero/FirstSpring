package com.sparta.firstspring.repositories;
import com.sparta.firstspring.entities.Language;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LanguageRepository extends JpaRepository<Language, Short> {
}