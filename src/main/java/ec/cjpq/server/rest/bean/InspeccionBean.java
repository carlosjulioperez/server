package ec.cjpq.server.rest.bean;

import lombok.Data;

/**
 * Inspección JavaBean
 * @author carper CARLOS JULIO PEREZ QUIZHPE carlosjulioperez@gmail.com claro 099 3208265
 * 2017-11-03
 * 2017-12-02 Ecxluir nulos del archivo JSON
 */
@Data
public class InspeccionBean{

    private String id;
    private String contenedor;
    private String tamano;
    private String chasis;
    private String placa;
    private String cliente;
    private String fecha;
    private String agencia;
    private String vapor;
    private String destino;
    private String factura;
    private String pta_izq;
    private String pta_der;
    private String pfi_izq;
    private String pfi_der;
    private String ur_izq;
    private String ur_der;
    private String le_izq;
    private String le_der;
    private String li_izq;
    private String li_der;
    private String techo;
    private String piso;
    private String est_inf;
    private String est_int;
    private String chasis_estado;
    private String observaciones;
    private String inspector;

}
