package com.cauandev.budgeting.infrastructure.http.request;

import com.cauandev.budgeting.application.input.PersistTransactionInput;
import com.cauandev.budgeting.domain.Category;

public record TransactionRequest(String description, Category category, long amount) {
    public PersistTransactionInput toInput() {
        return new PersistTransactionInput(description, amount, category);
    }
}
