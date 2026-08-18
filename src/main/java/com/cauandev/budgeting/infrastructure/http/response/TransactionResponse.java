package com.cauandev.budgeting.infrastructure.http.response;

import com.cauandev.budgeting.application.output.TransactionOutput;

public record TransactionResponse(String id, String category, String descriptiona, double amount) {
    public static TransactionResponse from(TransactionOutput output) {
        return new TransactionResponse(output.id(), output.category(), output.description(), output.value());
    }
}
