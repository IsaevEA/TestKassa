package org.example.kassa.Rest;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.example.kassa.BD.DTO.DtoTransactionCode;
import org.example.kassa.BD.DTO.TrnsactionDto;
import org.example.kassa.Service.TransactionService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:63342")
@RequestMapping("transactions/")
@Data
public class TransactionController {
    private final TransactionService transactionService;

//    @GetMapping("/{transactionCode}")
//    public UUID getById(@PathVariable UUID transactionCode) {
//        return transactionService.getById(transactionCode).getTransactionsCode();
//    }
    @PostMapping("/create")
    public DtoTransactionCode save(@RequestBody TrnsactionDto transaction) {
        return transactionService.save(transaction);
    }
    @GetMapping("/{transactionCode}")
    public DtoTransactionCode getById(@PathVariable String transactionCode) {
        return transactionService.getById(transactionCode);
    }


}
