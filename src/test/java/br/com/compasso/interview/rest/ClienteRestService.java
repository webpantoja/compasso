package br.com.compasso.interview.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.compasso.interview.rest.assembler.ClienteModelAssembler;
import br.com.compasso.interview.rest.model.ClienteModel;
import br.com.compasso.interview.service.ClienteService;

@RestController
@RequestMapping("/cliente")
public class ClienteRestService {
	
	@Autowired
	private ClienteService clienteService;
	@Autowired
	private ClienteModelAssembler clienteModelAssembler;
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<ClienteModel> getClienteById(@PathVariable("id") Integer id){
		return new ResponseEntity<ClienteModel>(clienteModelAssembler.toModel(clienteService.getById(id)), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{nomeCompleto}", method = RequestMethod.GET)
	public ResponseEntity<List<ClienteModel>> getClienteByNomeCompleto(@PathVariable("nomeCompleto") String nomeCompleto){
		return new ResponseEntity<List<ClienteModel>>(clienteModelAssembler.toModel(clienteService.getByNomeCompleto(nomeCompleto)), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void remover(@PathVariable("id") Integer id) {
		clienteService.remover(id);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<ClienteModel> salvar(@RequestBody ClienteModel clienteModel) {
		return new ResponseEntity<ClienteModel>(clienteModelAssembler.toModel(
				clienteService.salvar(clienteModelAssembler.toEntity(clienteModel))), HttpStatus.CREATED);
	}
	

}
