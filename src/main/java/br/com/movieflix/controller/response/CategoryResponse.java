package br.com.movieflix.controller.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;

@Builder
public record CategoryResponse(@Schema(type = "long", description = "Código da categoria")
                               Long id,
                               @Schema(type = "string", description = "Nome da categoria")
                               String name) {
}
