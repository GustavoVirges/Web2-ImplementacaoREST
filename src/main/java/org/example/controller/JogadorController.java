
package org.example.controller;

import java.util.List;

import org.example.dto.JogadorRequest;
import org.example.dto.JogadorResponse;
import org.example.service.JogadorService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/jogadores")
public class JogadorController {

    private final JogadorService jogadorService;

    public JogadorController(JogadorService jogadorService) {
        this.jogadorService = jogadorService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public JogadorResponse insert(@Valid @RequestBody JogadorRequest req) {
        return jogadorService.insert(req);
    }

    @PutMapping("/{id}")
    public JogadorResponse update(
            @PathVariable Long id,
            @Valid @RequestBody JogadorRequest req) {
        return jogadorService.update(id, req);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        jogadorService.delete(id);
    }

    @GetMapping("/{id}")
    public JogadorResponse selectById(@PathVariable Long id) {
        return jogadorService.selectById(id);
    }

    @GetMapping
    public List<JogadorResponse> selectAll() {
        return jogadorService.selectAll();
    }
}
