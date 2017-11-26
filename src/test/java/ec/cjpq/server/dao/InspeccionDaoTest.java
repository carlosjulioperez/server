package ec.cjpq.server.rest.dao;

import org.junit.Test;

import ec.cjpq.server.rest.bean.InspeccionBean;
import ec.cjpq.server.rest.dao.InspeccionDao;

public class InspeccionDaoTest{

    private InspeccionBean getInspeccion(){
        InspeccionBean inspeccion = new InspeccionBean();

        inspeccion.setContenedor("contenedor");
        inspeccion.setTamano("12");
        inspeccion.setChasis("chasis");
        inspeccion.setPlaca("placa");
        inspeccion.setCliente("Cliente 1");
        inspeccion.setFecha("2017/11/26");
        inspeccion.setAgencia("agencia");
        inspeccion.setVapor("vapor");
        inspeccion.setDestino("destino");
        inspeccion.setFactura("fac0012");
        inspeccion.setPta_izq("true");
        inspeccion.setPta_der("true");
        inspeccion.setPfi_izq("true");
        inspeccion.setPfi_der("true");
        inspeccion.setUr_izq("true");
        inspeccion.setUr_der("true");
        inspeccion.setLe_izq("true");
        inspeccion.setLe_der("true");
        inspeccion.setLi_izq("true");
        inspeccion.setLi_der("true");
        inspeccion.setTecho("true");
        inspeccion.setPiso("true");
        inspeccion.setEst_inf("true");
        inspeccion.setEst_int("true");
        inspeccion.setChasis_estado("true");

        inspeccion.setObservaciones("Observaciones");
        inspeccion.setInspector("carper");
        
        return inspeccion;
    }

    @Test
    public void testCreate(){
        try{
            Long secuencial = new InspeccionDao().create(getInspeccion());
            System.out.println(secuencial);

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
