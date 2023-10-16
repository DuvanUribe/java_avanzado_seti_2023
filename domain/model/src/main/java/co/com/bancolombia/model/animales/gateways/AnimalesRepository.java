package co.com.bancolombia.model.animales.gateways;

import co.com.bancolombia.model.animales.Animales;
import reactor.core.publisher.Mono;

import java.util.List;

public interface AnimalesRepository {
    Animales create(Animales animal);

    Animales read(String idAnimal);
    default Animales update(String idAnimal, Animales animal) throws Exception{
        return animal;
    }

    void delete(String animal);

    List<Animales> getAll();

}
