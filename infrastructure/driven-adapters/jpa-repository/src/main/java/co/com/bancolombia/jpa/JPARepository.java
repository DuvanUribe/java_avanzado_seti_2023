package co.com.bancolombia.jpa;

import co.com.bancolombia.jpa.entities.AnimalEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;

public interface JPARepository
        extends CrudRepository<AnimalEntity/* change for adapter model */,
        String>, QueryByExampleExecutor<AnimalEntity/* change for adapter model */> {
}
