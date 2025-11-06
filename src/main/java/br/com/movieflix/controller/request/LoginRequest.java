package br.com.movieflix.controller.request;

import io.swagger.v3.oas.annotations.media.Schema;

public record LoginRequest(@Schema(type = "string", description = "Email de login do usuário")
                           String email,
                           @Schema(type = "string", description = "Senha de login do usuário")
                           String password) {
}
