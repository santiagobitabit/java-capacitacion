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