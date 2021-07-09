package br.com.compasso.interview.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.compasso.interview.rest.assembler.EstadoModelAssembler;
import br.com.compasso.interview.rest.model.EstadoModel;
import br.com.compasso.interview.service.EstadoService;

@RestController
@RequestMapping("/estado")
public class EstadoRestService {
	
	@Autowired
	EstadoModelAssembler estadoModelAssembler;
	@Autowired
	EstadoService estadoService;

	@RequestMapping(value = "/estados", method = RequestMethod.GET)
	public ResponseEntity<List<EstadoModel>> getAll(){
		return new ResponseEntity<List<EstadoModel>>(estadoModelAssembler.toModel(estadoService.getAll()), HttpStatus.OK);
	}
}
