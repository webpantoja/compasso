package br.com.compasso.interview.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.compasso.interview.entity.CidadeEntity;
import br.com.compasso.interview.entity.EstadoEntity;
import br.com.compasso.interview.exception.ItemNaoEncontradoException;
import br.com.compasso.interview.repository.CidadeRepository;
import br.com.compasso.interview.service.CidadeService;

@Service
public class CidadeServiceImpl implements CidadeService {

	@Autowired
	private CidadeRepository cidadeRepository;

	@Override
	public CidadeEntity salvar(CidadeEntity cidade) {
		return cidadeRepository.save(cidade);
	}

	@Override
	public List<CidadeEntity> getByNome(String nome) {
		return cidadeRepository.getByNome(nome).orElseThrow(ItemNaoEncontradoException::new);
	}

	@Override
	public List<CidadeEntity> getByEstado(EstadoEntity estado) {
		return cidadeRepository.getByEstado(estado).orElseThrow(ItemNaoEncontradoException::new);
	}

}
