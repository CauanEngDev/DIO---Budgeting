package com.cauandev.budgeting.application;

import com.cauandev.budgeting.application.input.PersistTransactionInput;
import com.cauandev.budgeting.application.output.TransactionOutput;
import com.cauandev.budgeting.domain.Category;
import com.cauandev.budgeting.domain.Transaction;
import com.cauandev.budgeting.domain.TransactionRepository;
import org.springframework.stereotype.Service;

@Service
public class PersistTransactionUseCase {
    private final TransactionRepository transactionRepository;

    public PersistTransactionUseCase(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    public TransactionOutput execute(PersistTransactionInput input) {
        var transaction = new Transaction(input.description(), input.amount(), input.category());
        var saved = transactionRepository.save(transaction);

        return TransactionOutput.from(saved);
    }
}
