package org.example.kassa.Service;

import lombok.RequiredArgsConstructor;
import org.example.kassa.BD.DTO.DtoTransactionCaode;
import org.example.kassa.BD.DTO.KassaDto;
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
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Transactional(propagation = Propagation.REQUIRES_NEW)
public class TransactionService {


    private final KassaRepository kassaRepository;
    private final TranslationRepository translationRepository;


    public DtoTransactionCaode getById(Long transactionCode) {
        Translation translation = translationRepository.findByTransactionsCode(transactionCode);
        if (transactionCode == null) {
            return new DtoTransactionCaode(StatusTransaction.TRANSACTION_NOT_FOUNT);
        }
        translation.setTargetKassa(kassaRepository.findById(2L).orElse(null));
        translation.setStatus(TranslationStatus.COMPLETED);
        BigDecimal balanceTargetKassa = kassaRepository.findById(2L).get().getBalance().subtract(translation.getAmount());
        kassaRepository.updateBalance(2L,balanceTargetKassa);
        translationRepository.save(translation);
        return new DtoTransactionCaode(StatusTransaction.PAYMENT_SUCCESSFUL,transactionCode);
    }

    public Translation save(TrnsactionDto transactionDto) {
        Translation translation = new Translation(transactionDto);
        translation.setSourceKassa(kassaRepository.findById(1L).orElse(null));
        BigDecimal balanceTargetKassa = kassaRepository.findById(1L).get().getBalance().add(translation.getAmount());
        kassaRepository.updateBalance(1L,balanceTargetKassa);
        return  translationRepository.save(translation);

    }

}
