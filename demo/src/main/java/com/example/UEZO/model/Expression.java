package com.example.UEZO.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotBlank;
import java.util.UUID;

/**
 * VICTOR LIMA E MELLO DOS SANTOS
 * 152.333.2051
 */
public class Expression {

    private final UUID id;
    @NotBlank
    private final String expressao;

    public Expression(@JsonProperty("is") UUID id,
                      @JsonProperty("name") String expressao) {
        this.id = id;
        this.expressao = expressao;
    }

    public String getExpressao() {
        return expressao;
    }

    public UUID getId() {
        return id;
    }

}
