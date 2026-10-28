package com.pizzaria.java.pizza;

import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/pizzas")
public class PizzaController {
    private final PizzaService service;

    public PizzaController(PizzaService service){
        this.service = service;
    }


    @PostMapping
    public ResponseEntity<PizzaDTO> cadastrar(@RequestBody @Valid PizzaDTO pizzaDTO, UriComponentsBuilder uri){
        PizzaDTO pizzaDto = service.criarPizza(pizzaDTO);
        URI endereco = uri.path("/pizzas/{id}").buildAndExpand(service.getPizzaId()).toUri();
        return ResponseEntity.created(endereco).body(pizzaDto);
    }

    @GetMapping
    public ResponseEntity<Page<PizzaDTO>> listar(@PageableDefault(size=10)Pageable paginacao){
         Page<PizzaDTO> pizzaDto = service.listar(paginacao);
         return ResponseEntity.ok(pizzaDto);
    }

    @GetMapping("/{id}")
    public ResponseEntity <PizzaDTO> buscarPorId(@PathVariable Long id){
        PizzaDTO pizzaDto = service.buscarPorId(id);
        return ResponseEntity.ok(pizzaDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity <Void> deletarPizza(@PathVariable Long id){
        service.deletarPorId(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity <PizzaDTO> atualizar(@PathVariable Long id, @RequestBody PizzaDTO dto ){
        PizzaDTO pizzaAtualizada = service.atualizarPizza(id, dto);
        return ResponseEntity.ok(pizzaAtualizada);
    }
}
