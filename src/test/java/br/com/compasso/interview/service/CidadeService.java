package br.com.compasso.interview.service;

import java.util.List;

import br.com.compasso.interview.entity.CidadeEntity;
import br.com.compasso.interview.entity.EstadoEntity;

public interface CidadeService {
	
	List<CidadeEntity> getByNome(String nome);
	List<CidadeEntity> getByEstado(EstadoEntity estado);
	CidadeEntity salvar(CidadeEntity cidade);
}
