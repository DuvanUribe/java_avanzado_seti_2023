package co.com.bancolombia.api;
import co.com.bancolombia.model.animales.Animales;
import co.com.bancolombia.usecase.animalescasos.AnimalesCasosUseCase;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@ResponseBody
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
@AllArgsConstructor
public class ApiRest {
    private final AnimalesCasosUseCase animalesCasosUseCase;


    @GetMapping(path = "/path")
    public String commandName() {
//      return useCase.doAction();
        return "Hello World";
    }
    @GetMapping(path = "/animal/{id}")
    public Animales read(@PathVariable String id) {
        return animalesCasosUseCase.read(id);
    }

    @PostMapping(path = "/create_animal")
    public Animales create(@RequestBody Animales animal) {
        System.out.println("creo registro");
        animalesCasosUseCase.create(animal);
        return animal;
    }

    @PutMapping(path = "/update/animal/{id}")

    public Animales update(@PathVariable String id, @RequestBody Animales animal) {
        System.out.println(id);
        System.out.println(animal);
        try {
            animalesCasosUseCase.update(id, animal);
            return animal;
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }

    }

    @DeleteMapping(path = "/delete/animal/{id}")
    public String delete(@PathVariable String id) {
        try {
            animalesCasosUseCase.delete(id);
            return "Eliminado exitosamente";
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    }

    @GetMapping(path = "/animals")
    public List<Animales> getAll() {
        return animalesCasosUseCase.getAll();
    }


}
