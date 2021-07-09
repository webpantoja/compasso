package br.com.compasso.interview.service;

import java.util.List;

import br.com.compasso.interview.entity.ClienteEntity;

public interface ClienteService {

	List<ClienteEntity> getByNomeCompleto(String nomeCompleto);
	ClienteEntity getById(Integer id);
	ClienteEntity salvar(ClienteEntity cliente);
	void remover(Integer id);
}
