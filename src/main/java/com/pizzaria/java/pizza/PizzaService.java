package com.pizzaria.java.pizza;

import jakarta.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PizzaService {
    private final PizzaRepository pizzaRepository;
    private final ModelMapper modelMapper;
    private PizzaModel pizzaModelId;

    public PizzaService(PizzaRepository repository, ModelMapper modelMapper){
        this.pizzaRepository = repository;
        this.modelMapper = modelMapper;
    }

    public PizzaDTO criarPizza(PizzaDTO pizzaDTO){
        PizzaModel pizzaModel = modelMapper.map(pizzaDTO, PizzaModel.class);
        pizzaModelId = pizzaRepository.save(pizzaModel);

        return modelMapper.map(pizzaModel, PizzaDTO.class);
    }

    public Long getPizzaId(){
        return pizzaModelId.getId();
    }

    public Page<PizzaDTO> listar(Pageable paginacao){
        return pizzaRepository.findAll(paginacao).map(p-> modelMapper.map(p, PizzaDTO.class));

//        return pizzaRepository.findAll().stream().
//                map(p-> modelMapper.map(p, PizzaDTO.class)).toList();

//        public List<PizzaDTO> listar() {
//            List<PizzaModel> pizzas = pizzaRepository.findAll();
//            List<PizzaDTO> dtos = new ArrayList<>();
//
//            for (PizzaModel p : pizzas) {
//                PizzaDTO dto = modelMapper.map(p, PizzaDTO.class);
//                dtos.add(dto);
//            }
//
//            return dtos;
//        }
    }

    public PizzaDTO buscarPorId(Long id){
         PizzaModel pizzaEncontrada = pizzaRepository.findById(id).orElseThrow(()->new EntityNotFoundException());
         return modelMapper.map(pizzaEncontrada, PizzaDTO.class);
    }

    public void deletarPorId(Long id){
        pizzaRepository.deleteById(id);
    }

    public PizzaDTO atualizarPizza(Long id, PizzaDTO dto){
        PizzaModel pizzaModel = modelMapper.map(dto, PizzaModel.class);
        pizzaModel.setId(id);
        pizzaModel = pizzaRepository.save(pizzaModel);

        return modelMapper.map(pizzaModel, PizzaDTO.class);
    }


}
