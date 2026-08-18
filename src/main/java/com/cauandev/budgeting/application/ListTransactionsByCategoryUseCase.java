package com.cauandev.budgeting.application;

import com.cauandev.budgeting.application.output.TransactionOutput;
import com.cauandev.budgeting.domain.Category;
import com.cauandev.budgeting.domain.TransactionRepository;
import com.cauandev.budgeting.infrastructure.http.response.TransactionResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListTransactionsByCategoryUseCase {
    private final TransactionRepository transactionRepository;

    public ListTransactionsByCategoryUseCase(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    public List<TransactionOutput> execute(Category category) {
        return transactionRepository.findAllByCategory(category)
                .stream()
                .map(TransactionOutput::from)
                .toList();
    }
}
