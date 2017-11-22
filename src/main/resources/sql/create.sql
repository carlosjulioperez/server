DROP TABLE IF EXISTS inspeccion;

CREATE TABLE inspeccion(
    id SERIAL PRIMARY KEY,
    contenedor      varchar(11),
    tamano          varchar(2),
    chasis          varchar(8),
    placa           varchar(8),
    cliente         varchar(100),
    fecha           date,
    agencia         varchar(30),
    vapor           varchar(30),
    destino         varchar(30),
    factura         varchar(30),
    pta_izq      	boolean, --puertas
    pta_der      	boolean,
    pfi_izq         boolean, --pared frontal interna
    pfi_der         boolean,
    ur_izq          boolean, --unidad de refrigeracion
    ur_der          boolean,
    le_izq          boolean, --lados externos
    le_der          boolean,
    li_izq          boolean, --lados internos
    li_der          boolean,
    techo           boolean,
    piso            boolean,
    est_inf         boolean, --estructura inferior
    est_int         boolean, --estructura interna
    chasis_estado   boolean,
    observaciones   varchar(100),
    inspector       varchar(20)
);

