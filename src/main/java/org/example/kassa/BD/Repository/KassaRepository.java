package org.example.kassa.BD.Repository;

import org.example.kassa.BD.Model.Kassa;
import org.example.kassa.BD.Model.Translation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Repository
public interface KassaRepository extends JpaRepository<Kassa, Long> {
    Optional<Kassa> findById(Long id);

    @Modifying
    @Query("update Kassa set balance = :balance where id = :id")
    void updateBalance(@Param("id") Long id, @Param("balance") BigDecimal balance);


    @Query("SELECT t FROM Translation t JOIN t.sourceKassa k WHERE k.name = :kassaName")
    List<Translation> findByName(@Param("kassaName") String kassaName);



    @Modifying
    @Query("select t from Translation t")
    List<Translation> findAllTranslations();

}
