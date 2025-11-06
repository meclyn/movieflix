package br.com.movieflix.controller;

import br.com.movieflix.controller.request.StreamingRequest;
import br.com.movieflix.controller.response.MovieResponse;
import br.com.movieflix.controller.response.StreamingResponse;
import br.com.movieflix.entity.Streaming;
import br.com.movieflix.mapper.StreamingMapper;
import br.com.movieflix.service.StreamingService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movieflix/streaming")
@Tag(name = "Streaming", description = "Recurso responsável pelo gerenciamento dos serviços de streaming.")
@RequiredArgsConstructor
public class StreamingControllerImpl {

    private final StreamingService streamingService;

    @GetMapping
    public ResponseEntity<List<StreamingResponse>> getAll() {
        List<Streaming> streamings = streamingService.findAll();
        List<StreamingResponse> list = streamings.stream()
                .map(StreamingMapper::toStreamingResponse)
                .toList();
        return ResponseEntity.ok(list);
    }

    @PostMapping
    public ResponseEntity<StreamingResponse> save(@Valid @RequestBody StreamingRequest request){
        Streaming newStreaming = StreamingMapper.toStreaming(request);
        Streaming savedStreaming = streamingService.save(newStreaming);
        return ResponseEntity.status(HttpStatus.CREATED).body(StreamingMapper.toStreamingResponse(savedStreaming));
    }

    @GetMapping("/{id}")
    public ResponseEntity<StreamingResponse> getById(@PathVariable Long id) {
        return streamingService.findById(id)
                .map(streaming -> ResponseEntity.ok().body(StreamingMapper.toStreamingResponse(streaming)))
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteByd(@PathVariable Long id){
        streamingService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
