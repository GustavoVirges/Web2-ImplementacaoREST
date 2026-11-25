package org.example.controller;

import jakarta.validation.Valid;
import org.example.dto.JogadorRequest;
import org.example.dto.JogadorResponse;
import org.example.service.JogadorService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jogadores")
public class JogadorController {

    private final JogadorService service;

    public JogadorController(JogadorService service) {
        this.service = service;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public JogadorResponse insert(@Valid @RequestBody JogadorRequest req) {
        return service.insert(req);
    }

    @PutMapping("/{id}")
    public JogadorResponse update(@PathVariable Long id, @Valid @RequestBody JogadorRequest req) {
        return service.update(id, req);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }

    @GetMapping("/{id}")
    public JogadorResponse selectById(@PathVariable Long id) {
        return service.selectById(id);
    }

    @GetMapping
    public List<JogadorResponse> selectAll() {
        return service.selectAll();
    }
}
