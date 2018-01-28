package ec.cjpq.server.rest.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

import lombok.Getter;
import lombok.Setter;

@Entity
@NamedQueries({
    @NamedQuery(name="Usuario.getAll", query="SELECT o FROM Usuario o")
})
public class Usuario{

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY) @Getter @Setter
	private Integer id;

	@Column(length=100) @Getter @Setter
    private String nombre;
	
    @Column(length=30) @Getter @Setter
    private String login;

    @Column(length=30) @Getter @Setter
    private String password;

}
