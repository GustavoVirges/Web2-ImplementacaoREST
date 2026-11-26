
package org.example.controller;

import java.util.List;

import org.example.dto.ItemRequest;
import org.example.dto.ItemResponse;
import org.example.service.ItemService;
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
@RequestMapping("/itens")
public class ItemController {

    private final ItemService itemService;

    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ItemResponse insert(@Valid @RequestBody ItemRequest req) {
        return itemService.insert(req);
    }

    @PutMapping("/{id}")
    public ItemResponse update(
            @PathVariable Long id,
            @Valid @RequestBody ItemRequest req) {
        return itemService.update(id, req);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        itemService.delete(id);
    }

    @GetMapping("/{id}")
    public ItemResponse selectById(@PathVariable Long id) {
        return itemService.selectById(id);
    }

    @GetMapping
    public List<ItemResponse> selectAll() {
        return itemService.selectAll();
    }
}
