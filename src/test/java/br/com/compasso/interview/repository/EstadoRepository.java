package br.com.compasso.interview.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.compasso.interview.entity.EstadoEntity;

@Repository
public interface EstadoRepository extends CrudRepository<EstadoEntity, Integer> {
}
