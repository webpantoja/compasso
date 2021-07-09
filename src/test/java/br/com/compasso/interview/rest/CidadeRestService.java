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

import br.com.compasso.interview.rest.assembler.CidadeModelAssembler;
import br.com.compasso.interview.rest.assembler.EstadoModelAssembler;
import br.com.compasso.interview.rest.model.CidadeModel;
import br.com.compasso.interview.rest.model.EstadoModel;
import br.com.compasso.interview.service.CidadeService;

@RestController
@RequestMapping("/cidade")
public class CidadeRestService {
	
	@Autowired
	private CidadeService cidadeService;
	@Autowired
	private CidadeModelAssembler cidadeModelAssembler;
	@Autowired
	private EstadoModelAssembler estadoModelAssembler;

	@RequestMapping(value = "/{nome}", method = RequestMethod.GET)
	public ResponseEntity<List<CidadeModel>> getCidadeById(@PathVariable("nome") String nome){
		return new ResponseEntity<List<CidadeModel>>(cidadeModelAssembler.toModel(cidadeService.getByNome(nome)), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{estado}", method = RequestMethod.GET)
	public ResponseEntity<List<CidadeModel>> getCidadeByEstado(@RequestBody EstadoModel estado){
		return new ResponseEntity<List<CidadeModel>>(cidadeModelAssembler.toModel(
				cidadeService.getByEstado(estadoModelAssembler.toEntity(estado))), HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<CidadeModel> salvar(@RequestBody CidadeModel cidadeModel) {
		return new ResponseEntity<CidadeModel>(cidadeModelAssembler.toModel(
				cidadeService.salvar(cidadeModelAssembler.toEntity(cidadeModel))), HttpStatus.CREATED);
	}
}
