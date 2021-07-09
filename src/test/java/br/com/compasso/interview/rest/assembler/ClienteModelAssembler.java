package br.com.compasso.interview.rest.assembler;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;

import br.com.compasso.interview.entity.ClienteEntity;
import br.com.compasso.interview.rest.ClienteRestService;
import br.com.compasso.interview.rest.model.ClienteModel;
 
@Component
public class ClienteModelAssembler extends RepresentationModelAssemblerSupport<ClienteEntity, ClienteModel> {

	private CidadeModelAssembler cidadeModelAssembler;
	
	public ClienteModelAssembler() {
		super(ClienteRestService.class, ClienteModel.class);
	}

	@Override
	public ClienteModel toModel(ClienteEntity entity) {
		ClienteModel clienteModel = instantiateModel(entity);
		clienteModel.setId(entity.getId());
		clienteModel.setCidade(cidadeModelAssembler.toModel(entity.getCidade()));
		clienteModel.setDataNascimento(entity.getDataNascimento());
		clienteModel.setId(entity.getIdade());
		clienteModel.setNomeCompleto(entity.getNomeCompleto());
		clienteModel.setSexo(entity.getSexo());
		return clienteModel;
	}

	public ClienteEntity toEntity(ClienteModel model) {
		return ClienteEntity.builder()
				.id(model.getId())
				.cidade(cidadeModelAssembler.toEntity(model.getCidade()))
				.dataNascimento(model.getDataNascimento())
				.idade(model.getIdade())
				.nomeCompleto(model.getNomeCompleto())
				.sexo(model.getSexo())
				.build();
	}
	
	public List<ClienteModel> toModel(List<ClienteEntity> entitys) {
		if(entitys.isEmpty()) {
			return Collections.emptyList();
		}
		return entitys.stream().map(entity -> toModel(entity)).collect(Collectors.toList());

	}
	
	public List<ClienteEntity> toEntity(List<ClienteModel> models) {
		if(models.isEmpty()) {
			return Collections.emptyList();
		}
		return models.stream().map(model -> toEntity(model)).collect(Collectors.toList());
	}
}
