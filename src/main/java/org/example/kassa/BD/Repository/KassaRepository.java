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
    @Query("UPDATE Kassa k SET k.balance = :balance WHERE k.id = :id")
    void updateBalance(@Param("id") Long id, @Param("balance") BigDecimal balance);

    @Query("SELECT t FROM Translation t JOIN t.sourceKassa k WHERE k.name = :kassaName")
    List<Translation> findByName(@Param("kassaName") String kassaName);

    @Query("SELECT t FROM Translation t JOIN t.sourceKassa k WHERE k.name = :kassaName ORDER BY t.status")
    List<Translation> findByStatus(@Param("kassaName") String kassaName);

    @Query("SELECT t FROM Translation t WHERE t.sourceKassa.name = :kassaName ORDER BY t.createdAt")
    List<Translation> findByCreatedAt(@Param("kassaName") String kassaName);

    @Query(value = "SELECT * FROM translations WHERE source_kassa_id = :kassaId ORDER BY amount", nativeQuery = true)
    List<Translation> findByAmount(@Param("kassaId") Long kassaId);

    @Query(value = "SELECT * FROM translations", nativeQuery = true)
    List<Translation> findAllTranslations();
//    @Modifying
//    @Query("select t.id, t.amount, t.createdAt, t.curr, t.description, t.receiverName, t.senderName, t.soursNumber, t.status, t.targetNumber, t.updatedAt, t.sourceKassa, t.targetKassa from Translation t JOIN t.sourceKassa k where k.name = :kassaName order by t.amount")

}
