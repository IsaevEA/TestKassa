package org.example.kassa.Service;

import lombok.RequiredArgsConstructor;
import org.example.kassa.BD.DTO.DtoTransactionCode;
import org.example.kassa.BD.DTO.TrnsactionDto;
import org.example.kassa.BD.Model.Kassa;
import org.example.kassa.BD.Model.Translation;
import org.example.kassa.BD.Repository.KassaRepository;
import org.example.kassa.BD.Repository.TranslationRepository;
import org.example.kassa.Enum.StatusTransaction;
import org.example.kassa.Enum.TranslationStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(propagation = Propagation.REQUIRES_NEW)
public class TransactionService {


    private final KassaRepository kassaRepository;
    private final TranslationRepository translationRepository;


    public DtoTransactionCode getById(String transactionCode) {
        if (transactionCode == null) {
            return new DtoTransactionCode(StatusTransaction.TRANSACTION_NOT_FOUNT);
        }
        Long transactionId = Long.valueOf(transactionCode);
        Translation translation = getTranslationByCode(transactionId);
        if (translation == null) {
            return new DtoTransactionCode(StatusTransaction.TRANSACTION_NOT_FOUNT);
        }
        return processTranslation(translation);
    }

    private Translation getTranslationByCode(Long transactionCode) {
        return translationRepository.findByTransactionsCode(transactionCode);
    }

    private DtoTransactionCode processTranslation(Translation translation) {
        if (translation.getStatus().equals(TranslationStatus.CREATED)) {
            completeTransaction(translation);
            return new DtoTransactionCode(StatusTransaction.PAYMENT_SUCCESSFUL, translation.getTransactionsCode());
        } else {
            return new DtoTransactionCode(StatusTransaction.TRANSACTION_CLOSED);
        }
    }

    private void completeTransaction(Translation translation) {
        Kassa targetKassa = kassaRepository.findById(2L).orElse(null);
        translation.setTargetKassa(targetKassa);
        translation.setStatus(TranslationStatus.COMPLETED);

        BigDecimal balanceTargetKassa = targetKassa.getBalance().subtract(translation.getAmount());
        kassaRepository.updateBalance(2L, balanceTargetKassa);

        translationRepository.save(translation);
    }


    public DtoTransactionCode save(TrnsactionDto transactionDto) {
        Translation translation = new Translation(transactionDto);
        Optional<Kassa> optionalKassa = kassaRepository.findById(1L);
        if (!optionalKassa.isPresent()) {
            return new DtoTransactionCode(StatusTransaction.KASSA_NOT_FOUND);
        }
        Kassa sourceKassa = optionalKassa.get();
        translation.setSourceKassa(sourceKassa);
        BigDecimal balanceTargetKassa = sourceKassa.getBalance().add(translation.getAmount());
        kassaRepository.updateBalance(1L, balanceTargetKassa);
        translationRepository.save(translation);
        return new DtoTransactionCode(StatusTransaction.TRANSACTION_SUCCESSFUL, translation.getTransactionsCode());
    }


}