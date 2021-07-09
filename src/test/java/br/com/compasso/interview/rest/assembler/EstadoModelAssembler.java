package br.com.compasso.interview.rest.assembler;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;

import br.com.compasso.interview.entity.EstadoEntity;
import br.com.compasso.interview.rest.EstadoRestService;
import br.com.compasso.interview.rest.model.EstadoModel;

@Component
public class EstadoModelAssembler extends RepresentationModelAssemblerSupport<EstadoEntity, EstadoModel> {

	public EstadoModelAssembler() {
		super(EstadoRestService.class, EstadoModel.class);
	}
	
	@Override
	public EstadoModel toModel(EstadoEntity entity) {
		EstadoModel estadoModel = instantiateModel(entity);
		estadoModel.setId(entity.getId());
		estadoModel.setNome(entity.getNome());
		estadoModel.setSigla(entity.getSigla());
		return estadoModel;
	}
	
	public EstadoEntity toEntity(EstadoModel model) {
		return EstadoEntity.builder()
				.id(model.getId())
				.nome(model.getNome())
				.sigla(model.getSigla())
				.build();
	}
	
	public List<EstadoModel> toModel(List<EstadoEntity> entitys) {
		if(entitys.isEmpty()) {
			return Collections.emptyList();
		}
		return entitys.stream().map(entity -> toModel(entity)).collect(Collectors.toList());

	}
	
	public List<EstadoEntity> toEntity(List<EstadoModel> models) {
		if(models.isEmpty()) {
			return Collections.emptyList();
		}
		return models.stream().map(model -> toEntity(model)).collect(Collectors.toList());
	}

}
