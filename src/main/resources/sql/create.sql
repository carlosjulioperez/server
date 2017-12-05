DROP TABLE IF EXISTS detalle_cajas;
DROP TABLE IF EXISTS clasificacion;
DROP TABLE IF EXISTS producto;
DROP TABLE IF EXISTS datos_contenedor;
DROP TABLE IF EXISTS control_embarque;
DROP TABLE IF EXISTS inspeccion;

CREATE TABLE inspeccion(
    id                  SERIAL PRIMARY KEY,
    contenedor          varchar(11),
    tamano              varchar(2),
    chasis              varchar(8),
    placa               varchar(8),
    cliente             varchar(100),
    fecha               date,
    agencia             varchar(50),
    vapor               varchar(50),
    destino             varchar(50),
    factura             varchar(50),
    pta_izq      	    boolean, --puertas
    pta_der      	    boolean,
    pfi_izq             boolean, --pared frontal interna
    pfi_der             boolean,
    ur_izq              boolean, --unidad de refrigeracion
    ur_der              boolean,
    le_izq              boolean, --lados externos
    le_der              boolean,
    li_izq              boolean, --lados internos
    li_der              boolean,
    techo               boolean,
    piso                boolean,
    est_inf             boolean, --estructura inferior
    est_int             boolean, --estructura interna
    chasis_estado       boolean,
    observaciones       varchar(100),
    inspector           varchar(30),
    cerrado             boolean
);

CREATE TABLE control_embarque(
    id                  SERIAL PRIMARY KEY,
    inspeccion_id       integer REFERENCES inspeccion,
    oin                 varchar(50),
    consignatario       varchar(50),
    cantidad_cajas      varchar(50),
    sello_sgs           varchar(50),
    sello_agencia       varchar(50),
    sello_exportador    varchar(50),
    sello_otros         varchar(50),
    numero_ryan         varchar(50),
    numero_sello_ryan   varchar(50),
    embalaje            varchar(200),
    temp_antes_estiba   boolean,
    temp_despues_estiba boolean,
    fecha_inicio        date,
    fecha_fin           date,
    observaciones       varchar(100),
    marca_master        varchar(50),
    marca_caja          varchar(50)
);

CREATE TABLE datos_contenedor(
    id                  SERIAL PRIMARY KEY,
    control_embarque_id integer REFERENCES control_embarque,
    lugar_inspeccion    varchar(100),
    preenfriado         boolean, --condicion contenedor
    drenaje             boolean,
    probado             boolean,
    sc_deteriorada      boolean,
    olor_extrano        boolean,
    marca_equipo        varchar(50),
    escarchados         smallint, --cartones
    mojados             smallint,
    rotos               smallint,
    manchados           smallint,
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
    estiba              varchar(100),
    tipo_estiba         char(1),
    numero_grafico      varchar(50),
    cartilla            boolean
);

CREATE TABLE producto(
    id                  SERIAL PRIMARY KEY,
    control_embarque_id integer REFERENCES control_embarque,
    marca               varchar(50),
    descripcion_pesos   varchar(50),
    presentacion        varchar(50),
    empaque             varchar(50),
    tipo_producto       varchar(50)
);

CREATE TABLE clasificacion(
    id                  SERIAL PRIMARY KEY,
    producto_id         integer REFERENCES producto,
    modelo              varchar(50)
);

CREATE TABLE detalle_cajas(
    id                  SERIAL PRIMARY KEY,
    clasificacion_id    integer REFERENCES clasificacion,
    fila                smallint,
    cantidad            smallint
);

