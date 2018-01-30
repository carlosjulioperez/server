package ec.cjpq.server.rest.model.dto;

import java.util.Date;

import lombok.Data;

/**
 * Inspeccion Dto (Data Transfer Object)
 * @author carper CARLOS JULIO PEREZ QUIZHPE carlosjulioperez@gmail.com claro 099 3208265
 * 2018-ene-29
 */ 
@Data
public class InspeccionDto{
	private Integer id;
    private String contenedor;
    private String tamano;
    private String chasis;
    private String placa;
    private Integer clienteId;
	private Date fecha;
    private Integer agenciaNavieraId;
    private String vapor;
    private Integer destinoId;
    private String factura;
    private Boolean puertaIzquierda;
    private Boolean puertaDerecha;
    private Boolean paredFrontalInternaIzquierda;
    private Boolean paredFrontalInternaDerecha;
    private Boolean unidadRefrigeracionIzquierda;
    private Boolean unidadRefrigeracionDerecha;
    private Boolean ladosExternosIzquierda;
    private Boolean ladosExternosDerecha;
    private Boolean ladosInternosIzquierda;
    private Boolean ladosInternosDerecha;
    private Boolean techo;
    private Boolean piso;
    private Boolean estructuraInferior;
    private Boolean estructuraInterna;
    private Boolean chasisEstado;
    private String observaciones;
    private Integer usuarioId;
    private Boolean cerrado;
}
