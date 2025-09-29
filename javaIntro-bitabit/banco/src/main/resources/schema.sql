CREATE TABLE IF NOT EXISTS empleados (
    id_empleado SERIAL PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL,
    apellido VARCHAR(50) NOT NULL,
    edad INT,
    correo VARCHAR(100) UNIQUE,
    telefono VARCHAR(20),
    sueldo INT,
    comision DECIMAL(10, 2)
    );

CREATE TABLE IF NOT EXISTS  clientes (
    id_cliente SERIAL PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL,
    apellido VARCHAR(50) NOT NULL,
    edad INT,
    correo VARCHAR(100) UNIQUE,
    telefono VARCHAR(20),
    domicilio VARCHAR(100),
    id_empleado INT,
    FOREIGN KEY (id_empleado) REFERENCES empleados(id_empleado)
    );

CREATE TABLE IF NOT EXISTS  cuentas (
    id SERIAL PRIMARY KEY,
    tipo_cuenta VARCHAR(20) NOT NULL,
    moneda VARCHAR(20) NOT NULL,
    saldo DECIMAL(15, 2) NOT NULL,
    cbu VARCHAR(22) UNIQUE NOT NULL,
    id_cliente INT,
    FOREIGN KEY (id_cliente) REFERENCES clientes(id_cliente)
);

CREATE TABLE IF NOT EXISTS transacciones (
   id SERIAL PRIMARY KEY,
   id_cliente INT,
   monto DECIMAL(15, 2) NOT NULL,
   fecha TIMESTAMP NOT NULL,
   cbu_cuenta_destino VARCHAR(22) NOT NULL,
   cbu_cuenta_origen VARCHAR(22),
   error_durante_transaccion VARCHAR(255),
   FOREIGN KEY (id_cliente) REFERENCES clientes(id_cliente)
);