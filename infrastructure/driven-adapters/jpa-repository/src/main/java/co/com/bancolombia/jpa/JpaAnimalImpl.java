package co.com.bancolombia.jpa;

import co.com.bancolombia.model.animales.Animales;
import co.com.bancolombia.model.animales.gateways.AnimalesRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
@AllArgsConstructor
public class JpaAnimalImpl implements AnimalesRepository {

    private JPARepositoryAdapter jpaRepositoryAdapter;

    @Override
    public Animales create(Animales animal) {
        String idAnimal = UUID.randomUUID().toString();
        animal.setIdanimal(idAnimal);
        jpaRepositoryAdapter.save(animal);
        return jpaRepositoryAdapter.findById(idAnimal);
    }

    @Override
    public Animales read(String idAnimal) {
        return jpaRepositoryAdapter.findById(idAnimal);
    }

    @Override
    public Animales update(String idAnimal, Animales animal) throws Exception {
        Animales animalDb = jpaRepositoryAdapter.findById(idAnimal);

        if(animalDb == null) throw new Exception("Animal not find");

        animalDb.setNumPatas(animal.getNumPatas());
        animalDb.setGenero(animal.getGenero());
        animalDb.setEspecie(animal.getEspecie());
        animalDb.setHabitad(animal.getHabitad());
        animalDb.setDomestico(animal.isDomestico());

        jpaRepositoryAdapter.save(animalDb);
        return animalDb;
    }

    @Override
    public void delete(String idAnimal) {
       jpaRepositoryAdapter.deleteById(idAnimal);
    }

    @Override
    public List<Animales> getAll() {
        return jpaRepositoryAdapter.findAll();
    }
}
