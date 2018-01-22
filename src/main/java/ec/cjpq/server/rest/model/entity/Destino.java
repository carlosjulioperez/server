package ec.cjpq.server.rest.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Entity
public class Destino{

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY) @Getter @Setter
	private Integer id;

	@Column(length=50) @Getter @Setter
    private String nombre;

}
