package org.example.controller;

import jakarta.validation.Valid;
import org.example.dto.ItemRequest;
import org.example.dto.ItemResponse;
import org.example.service.ItemService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/itens")
public class ItemController {

    private final ItemService service;

    public ItemController(ItemService service) {
        this.service = service;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ItemResponse insert(@Valid @RequestBody ItemRequest req) {
        return service.insert(req);
    }

    @PutMapping("/{id}")
    public ItemResponse update(@PathVariable Long id, @Valid @RequestBody ItemRequest req) {
        return service.update(id, req);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }

    @GetMapping("/{id}")
    public ItemResponse selectById(@PathVariable Long id) {
        return service.selectById(id);
    }

    @GetMapping
    public List<ItemResponse> selectAll() {
        return service.selectAll();
    }
}
