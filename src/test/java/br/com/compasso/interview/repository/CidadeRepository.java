package br.com.compasso.interview.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.compasso.interview.entity.CidadeEntity;
import br.com.compasso.interview.entity.EstadoEntity;

@Repository
public interface CidadeRepository extends CrudRepository<CidadeEntity, Integer> {

	Optional<List<CidadeEntity>> getByNome(String nome);
	Optional<List<CidadeEntity>> getByEstado(EstadoEntity estado);
}
