package org.example.kassa.BD.Repository;

import org.example.kassa.BD.Model.Translation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TranslationRepository extends JpaRepository<Translation, Long> {
    Translation findByTransactionsCode(Long id);
}
