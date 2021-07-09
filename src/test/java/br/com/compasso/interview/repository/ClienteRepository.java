package br.com.compasso.interview.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.compasso.interview.entity.ClienteEntity;

@Repository
public interface ClienteRepository extends CrudRepository<ClienteEntity, Integer>{

	Optional<List<ClienteEntity>> getByNomeCompleto(String nomeCompleto);
}
