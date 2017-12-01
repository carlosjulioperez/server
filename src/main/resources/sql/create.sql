DROP TABLE IF EXISTS datos_contenedor;
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

CREATE TABLE datos_contenedor(
    id SERIAL PRIMARY KEY,
    contenedor_id       integer REFERENCES inspeccion,
    lugar_inspeccion    varchar(100),
    oin                 varchar(100),
    consignatario       varchar(100),
    cantidad_cajas      varchar(100),
    sello_sgs           varchar(20),
    otro_sello          varchar(20),
    sello_agencia       varchar(20),
    sello_exportador    varchar(20),
    preenfriado         boolean, --condicion contenedor
    drenaje             boolean,
    probado             boolean,
    sc_deteriorada      boolean,
    olor_extrano        boolean,
    marca_equipo        varchar(20),
    escarchados         smallint, --cartones
    mojados             smallint,
    rotos               smallint,
    manchados           smallint,
    marca_cajeta        varchar(20),
    marca_master        varchar(20),
    temperatura1        numeric(4,2), --99.99
    temperatura2        numeric(4,2), --99.99
    temperatura3        numeric(4,2), --99.99
    temperatura4        numeric(4,2), --99.99
    temperatura5        numeric(4,2), --99.99
    temperatura6        numeric(4,2), --99.99
    temperatura7        numeric(4,2), --99.99
    temperatura8        numeric(4,2), --99.99
    temperatura9        numeric(4,2), --99.99
    temperatura10       numeric(4,2), --99.99
    temperatura_prom    numeric(4,2), --99.99
    embalaje            varchar(200),
    estiba              varchar(100),
    tipo_estiba         char(1),
    temp_antes_estiba   boolean,
    temp_despues_estiba boolean,
    numero_ryan         varchar(20),
    numero_sello_ryan   varchar(20),
    numero_grafico      varchar(20),
    cartilla            boolean
);

