package br.com.movieflix.controller;


import br.com.movieflix.controller.request.CategoryRequest;
import br.com.movieflix.controller.response.CategoryResponse;
import br.com.movieflix.controller.response.MovieResponse;
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

@Tag(name = "Category", description = "Recurso responsável pelo gerenciamento das categorias.")
public interface CategoryController {

    @Operation(summary = "Buscar categorias", description = "Método responsável por retornar todas as categorias cadastradas.",
            security = @SecurityRequirement(name = "bearerAuth"))
    @ApiResponse(responseCode = "200", description = "Retorna todas as categorias cadastradas.",
            content = @Content(array = @ArraySchema( schema = @Schema(implementation = MovieResponse.class))))
    ResponseEntity<List<CategoryResponse>> getAllCategories();


    @Operation(summary = "Salvar categoria", description = "Método responsável por salvar categoria.",
            security = @SecurityRequirement(name = "bearerAuth"))
    @ApiResponse(responseCode = "201", description = "Categoria salva com sucesso.",
            content = @Content( schema = @Schema(implementation = MovieResponse.class)))
    ResponseEntity<CategoryResponse> saveCategory(@Valid @RequestBody CategoryRequest request);



    @Operation(summary = "Buscar categoria por ID", description = "Método responsável por buscar categoria por ID.",
            security = @SecurityRequirement(name = "bearerAuth"))
    @ApiResponse(responseCode = "200", description = "Categorias encontradas com sucesso.",
            content = @Content(array = @ArraySchema( schema = @Schema(implementation = CategoryResponse.class))))
    ResponseEntity<CategoryResponse> getCategoryById(@PathVariable Long id);



    @Operation(summary = "Deletar categoria por ID", description = "Método responsável por deletar categoria por ID.",
            security = @SecurityRequirement(name = "bearerAuth"))
    @ApiResponse(responseCode = "204", description = "Categoria deletada com sucesso.", content = @Content())
    @ApiResponse(responseCode = "404", description = "Categoria não encontrada.", content = @Content())
    public ResponseEntity<Void> deleteCategoryById(@PathVariable Long id);






}
