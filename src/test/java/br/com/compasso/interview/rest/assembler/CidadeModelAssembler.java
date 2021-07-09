package br.com.compasso.interview.rest.assembler;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;

import br.com.compasso.interview.entity.CidadeEntity;
import br.com.compasso.interview.rest.CidadeRestService;
import br.com.compasso.interview.rest.model.CidadeModel;

@Component
public class CidadeModelAssembler extends RepresentationModelAssemblerSupport<CidadeEntity, CidadeModel> {

	private EstadoModelAssembler estadoModelAssembler;
	
	public CidadeModelAssembler() {
		super(CidadeRestService.class, CidadeModel.class);
	}
	@Override
	public CidadeModel toModel(CidadeEntity entity) {
		CidadeModel cidadeModel = instantiateModel(entity);
		cidadeModel.setId(entity.getId());
		cidadeModel.setEstado(estadoModelAssembler.toModel(entity.getEstado()));
		cidadeModel.setNome(entity.getNome());
		return cidadeModel;
	}
	
	public CidadeEntity toEntity(CidadeModel model) {
		return CidadeEntity.builder()
				.id(model.getId())
				.estado(estadoModelAssembler.toEntity(model.getEstado()))
				.nome(model.getNome())
				.build();
	}
	
	public List<CidadeModel> toModel(List<CidadeEntity> entitys) {
		if(entitys.isEmpty()) {
			return Collections.emptyList();
		}
		return entitys.stream().map(entity -> toModel(entity)).collect(Collectors.toList());

	}
	
	public List<CidadeEntity> toEntity(List<CidadeModel> models) {
		if(models.isEmpty()) {
			return Collections.emptyList();
		}
		return models.stream().map(model -> toEntity(model)).collect(Collectors.toList());
	}

	
}
