package com.cauandev.budgeting.application.input;

import com.cauandev.budgeting.domain.Category;

public record PersistTransactionInput(String description, long amount, Category category) {
}
