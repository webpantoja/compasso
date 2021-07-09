package br.com.compasso.interview.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.compasso.interview.entity.EstadoEntity;
import br.com.compasso.interview.repository.EstadoRepository;
import br.com.compasso.interview.service.EstadoService;

@Service
public class EstadoServiceImpl implements EstadoService {

	@Autowired
	private EstadoRepository estadoRepository;
	
	@Override
	public List<EstadoEntity> getAll() {
		List<EstadoEntity> estados = new ArrayList<EstadoEntity>();
		estadoRepository.findAll().forEach(estados::add);
		return estados;
	}

}
