package ec.cjpq.server.rest.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

//import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import ec.cjpq.server.rest.model.entity.AgenciaNaviera;
import ec.cjpq.server.rest.model.entity.Cliente;
import ec.cjpq.server.rest.model.entity.Destino;

/**
 * Inspeccion Entity
 * @author carper CARLOS JULIO PEREZ QUIZHPE carlosjulioperez@gmail.com claro 099 3208265
 * 2018-ene-27
 */ 
//http://jvmhub.com/2014/10/25/hibernate-and-postgresql-configuration-using-persistence-xml-and-entitymanager/
@Entity
//@Table(name = "inspec")
//@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Inspeccion{

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY) @Getter @Setter
	private Integer id;

	@Column(length=11) @Getter @Setter
    private String contenedor;

	@Column(length=2) @Getter @Setter
    private String tamano;

	@Column(length=8) @Getter @Setter
    private String chasis;

	@Column(length=8) @Getter @Setter
    private String placa;
	
    @ManyToOne(fetch=FetchType.LAZY, optional=false) @Getter @Setter
    private Cliente cliente;

	@Getter @Setter
	private Date fecha;

    @ManyToOne(fetch=FetchType.LAZY, optional=false) @Getter @Setter
    private AgenciaNaviera agenciaNaviera;

	@Column(length=50) @Getter @Setter
    private String vapor;
    
    @ManyToOne(fetch=FetchType.LAZY, optional=false) @Getter @Setter
    private Destino destino;

	@Column(length=20) @Getter @Setter
    private String factura;
    
    @Getter @Setter
    private Boolean puertaIzquierda;

    @Getter @Setter
    private Boolean puertaDerecha;
    
    @Getter @Setter
    private Boolean paredFrontalInternaIzquierda;
    
    @Getter @Setter
    private Boolean paredFrontalInternaDerecha;
    
    @Getter @Setter
    private Boolean unidadRefrigeracionIzquierda;

    @Getter @Setter
    private Boolean unidadRefrigeracionDerecha;
    
    @Getter @Setter
    private Boolean ladosExternosIzquierda;

    @Getter @Setter
    private Boolean ladosExternosDerecha;
    
    @Getter @Setter
    private Boolean ladosInternosIzquierda;

    @Getter @Setter
    private Boolean ladosInternosDerecha;
    
    @Getter @Setter
    private Boolean techo;
    
    @Getter @Setter
    private Boolean piso;

    @Getter @Setter
    private Boolean estructuraInferior;

    @Getter @Setter
    private Boolean estructuraInterna;

    @Getter @Setter
    private Boolean chasisEstado;

	@Column(length=100) @Getter @Setter
    private String observaciones;
    
    @ManyToOne(fetch=FetchType.LAZY, optional=false) @Getter @Setter
    private Usuario usuario;

    @Getter @Setter
    private Boolean cerrado;

}
