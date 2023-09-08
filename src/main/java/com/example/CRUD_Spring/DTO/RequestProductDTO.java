package com.example.CRUD_Spring.DTO;

import jakarta.validation.constraints.NotNull;

public record RequestProductDTO(
        @NotNull
        String name,
        @NotNull
        int price_in_cents) {

}
