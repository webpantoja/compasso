package br.com.compasso.interview.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.compasso.interview.entity.ClienteEntity;
import br.com.compasso.interview.exception.ItemNaoEncontradoException;
import br.com.compasso.interview.repository.ClienteRepository;
import br.com.compasso.interview.service.ClienteService;

@Service
public class ClienteServiceImpl implements ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;
	
	@Override
	public ClienteEntity getById(Integer id) {
		return clienteRepository.findById(id).orElseThrow(ItemNaoEncontradoException::new);
	}

	@Override
	public ClienteEntity salvar(ClienteEntity cliente) {
		return clienteRepository.save(cliente);
	}

	@Override
	public void remover(Integer id) {
		clienteRepository.deleteById(id);
		
	}

	@Override
	public List<ClienteEntity> getByNomeCompleto(String nomeCompleto) {
		return clienteRepository.getByNomeCompleto(nomeCompleto).orElseThrow(ItemNaoEncontradoException::new);
	}

}
