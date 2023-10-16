package co.com.bancolombia.usecase.animalescasos;

import co.com.bancolombia.model.animales.Animales;
import co.com.bancolombia.model.animales.gateways.AnimalesRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

import java.util.List;

@AllArgsConstructor
public class AnimalesCasosUseCase {
    private AnimalesRepository animalesRepository;

    public Animales create(Animales animal){
        System.out.println(animal);
        animalesRepository.create(animal);
        return animal;
    }

    public Animales read(String idAnimal){return animalesRepository.read(idAnimal);}
    public Animales update(String idAnimal,Animales animales) throws Exception{
        Animales update = animalesRepository.update(idAnimal, animales);
        return animales;
    }
    public void delete(String idAnimal){ animalesRepository.delete(idAnimal);}

    public List<Animales> getAll(){return animalesRepository.getAll();}
}
