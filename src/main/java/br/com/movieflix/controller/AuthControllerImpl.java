package br.com.movieflix.controller;

import br.com.movieflix.config.TokenService;
import br.com.movieflix.controller.request.LoginRequest;
import br.com.movieflix.controller.request.UserRequest;
import br.com.movieflix.controller.response.LoginResponse;
import br.com.movieflix.controller.response.MovieResponse;
import br.com.movieflix.controller.response.UserResponse;
import br.com.movieflix.entity.User;
import br.com.movieflix.exception.UsernameOrPasswordInvalidException;
import br.com.movieflix.mapper.UserMapper;
import br.com.movieflix.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/movieflix/auth")
@RequiredArgsConstructor
@Tag(name = "Auth", description = "Recurso responsável pelo registro/login de usuarios.")
public class AuthControllerImpl implements AuthController {

    private final UserService userService;
    private final AuthenticationManager authenticationManager;
    private final TokenService tokenService;

    @PostMapping("/register")
    public ResponseEntity<UserResponse> register(@RequestBody UserRequest userRequest){
        User savedUser = userService.save(UserMapper.toUser(userRequest));
        return ResponseEntity.status(HttpStatus.CREATED).body(UserMapper.toUserResponse(savedUser));
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest loginRequest){
        try{
            UsernamePasswordAuthenticationToken userAndPass = new UsernamePasswordAuthenticationToken(loginRequest.email(), loginRequest.password());
            Authentication authenticate = authenticationManager.authenticate(userAndPass);

            User user = (User) authenticate.getPrincipal();

            String token = tokenService.generateToken(user);

            return ResponseEntity.ok(new LoginResponse(token));

        } catch (BadCredentialsException e){
            throw new UsernameOrPasswordInvalidException("Usuário ou senha inválido.");

        }

    }
}
