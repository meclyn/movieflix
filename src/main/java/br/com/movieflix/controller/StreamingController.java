package br.com.movieflix.controller;

import br.com.movieflix.controller.request.StreamingRequest;
import br.com.movieflix.controller.response.MovieResponse;
import br.com.movieflix.controller.response.StreamingResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Tag(name = "Streaming", description = "Recurso responsável pelo gerenciamento dos serviços de streaming.")
public interface StreamingController {

    @Operation(summary = "Buscar streamings", description = "Método responsável por retornar todos os streamings cadastrados.",
            security = @SecurityRequirement(name = "bearerAuth"))
    @ApiResponse(responseCode = "200", description = "Retorna todos os streamings cadastrados.",
            content = @Content(array = @ArraySchema( schema = @Schema(implementation = MovieResponse.class))))
    ResponseEntity<List<StreamingResponse>> getAll();


    @Operation(summary = "Salvar streaming", description = "Método responsável por salvar streaming.",
            security = @SecurityRequirement(name = "bearerAuth"))
    @ApiResponse(responseCode = "201", description = "Streaming salvo com sucesso.",
            content = @Content( schema = @Schema(implementation = MovieResponse.class)))
    ResponseEntity<StreamingResponse> save(@Valid @RequestBody StreamingRequest request);


    @Operation(summary = "Buscar streaming por ID", description = "Método responsável por buscar streaming por ID.",
            security = @SecurityRequirement(name = "bearerAuth"))
    @ApiResponse(responseCode = "200", description = "Streaming encontrado com sucesso.", content = @Content())
    @ApiResponse(responseCode = "404", description = "Streaming não encontrado.", content = @Content())
    ResponseEntity<StreamingResponse> getById(@PathVariable Long id);


    @Operation(summary = "Deletar streaming por ID", description = "Método responsável por deletar streaming por ID.",
            security = @SecurityRequirement(name = "bearerAuth"))
    @ApiResponse(responseCode = "204", description = "Streaming deletado com sucesso.", content = @Content())
    @ApiResponse(responseCode = "404", description = "Streaming não encontrado.", content = @Content())
    ResponseEntity<Void> deleteByd(@PathVariable Long id);
}
