package br.com.movieflix.controller;

import br.com.movieflix.controller.request.LoginRequest;
import br.com.movieflix.controller.request.UserRequest;
import br.com.movieflix.controller.response.LoginResponse;
import br.com.movieflix.controller.response.MovieResponse;
import br.com.movieflix.controller.response.UserResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

@Tag(name = "Auth", description = "Recurso responsável pelo registro/login de usuarios.")
public interface AuthController {

    @Operation(summary = "Registrar usuário", description = "Método responsável por registrar usuário.",
            security = @SecurityRequirement(name = "bearerAuth"))
    @ApiResponse(responseCode = "201", description = "Usuário registrado com sucesso.",
            content = @Content( schema = @Schema(implementation = MovieResponse.class)))
    ResponseEntity<UserResponse> register(@RequestBody UserRequest userRequest);


    @Operation(summary = "Login usuário", description = "Método responsável por realizar login de usuário.",
            security = @SecurityRequirement(name = "bearerAuth"))
    @ApiResponse(responseCode = "200", description = "Login efetuado com sucesso.", content = @Content())
    @ApiResponse(responseCode = "401", description = "Login ou senha inválido.", content = @Content())
    ResponseEntity<LoginResponse> login(@RequestBody LoginRequest loginRequest);
}
