package org.example.kassa.Rest;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.example.kassa.BD.DTO.DtoTransactionCaode;
import org.example.kassa.BD.DTO.TrnsactionDto;
import org.example.kassa.BD.Model.Translation;
import org.example.kassa.Service.TransactionService;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;
@RestController
@RequiredArgsConstructor
@RequestMapping("transaction/")
@Data
public class TransactionController {
    private final TransactionService transactionService;

//    @GetMapping("/{transactionCode}")
//    public UUID getById(@PathVariable UUID transactionCode) {
//        return transactionService.getById(transactionCode).getTransactionsCode();
//    }
    @PostMapping("/create")
    public UUID save(@RequestBody TrnsactionDto transaction) {
        return transactionService.save(transaction).getTransactionsCode();
    }
    @GetMapping("/{transactionCode}")
    public DtoTransactionCaode getById(@PathVariable UUID transactionCode) {
        return transactionService.getById(transactionCode);
    }


}
