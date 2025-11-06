package br.com.movieflix.controller.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;

@Builder
public record StreamingResponse(@Schema(type = "long", description = "Código do serviço de streaming")
                                Long id,
                                @Schema(type = "string", description = "Nome do serviço de streaming")
                                String name) {
}
