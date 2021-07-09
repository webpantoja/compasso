package br.com.compasso.interview.rest.model;

import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.core.Relation;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Relation(value = "cidade", collectionRelation = "cidades")
public class CidadeModel extends RepresentationModel<CidadeModel> {

	private Integer id;
	private String nome;
	private EstadoModel estado;
}
