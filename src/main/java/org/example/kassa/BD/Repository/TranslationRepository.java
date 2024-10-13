package org.example.kassa.BD.Repository;

import org.example.kassa.BD.DTO.DtoTransactionCaode;
import org.example.kassa.BD.Model.Translation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface TranslationRepository extends JpaRepository<Translation, Long> {
    Translation findByTransactionsCode(UUID id);
}
