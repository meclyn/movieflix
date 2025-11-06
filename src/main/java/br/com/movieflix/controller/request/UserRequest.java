package br.com.movieflix.controller.request;

import io.swagger.v3.oas.annotations.media.Schema;

public record UserRequest(@Schema(type = "string", description = "Nome do usuário")
                          String name,
                          @Schema(type = "string", description = "Email do usuário")
                          String email,
                          @Schema(type = "string", description = "Senha do usuário")
                          String password) {
}
