package org.bitabit.classes;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DB_Connection {

    Connection conn ;
    String user = "postgres";
    String pass = "contrasena";
    String url = "jdbc:postgresql://localhost:5432/banco-bitabit";
    Statement stmt;
    public DB_Connection(){
        try {
            conn  = DriverManager.getConnection(url, user, pass);
            System.out.println("Conexion a DB exitosa");

        } catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
    public void printData() throws SQLException {
        DatabaseMetaData metaData = conn.getMetaData();
        System.out.println("DB url name: " + metaData.getURL());
        ResultSet rs = metaData.getTables(null, null, "%", new String[]{"TABLE"});
        System.out.println("TABLA TABLA: " + rs.next());
        List<String> tableNames = new ArrayList<>();
        while (rs.next()) {
            String tableName = rs.getString("TABLE_NAME");
            tableNames.add(tableName);
            System.out.println("Table name: " + tableName);
        }
    }
    public void addCliente_DB(Cliente cliente) {
        String sql = "INSERT INTO Clientes (nombre, apellido, edad, correo, telefono, domicilio, id_empleado) VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, cliente.getNombre());
            pstmt.setString(2, cliente.getApellido());
            pstmt.setInt(3, cliente.getEdad());
            pstmt.setString(4, cliente.getEmail());
            pstmt.setString(5, cliente.getTelefono());
            pstmt.setString(6, cliente.getDomicilio());
            pstmt.setInt(7, cliente.getEmpleado().getId_empleado());

            pstmt.executeUpdate();
            System.out.println("Cliente agregado a la base de datos.");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public void addEmpleado_DB(Empleado empleado) {
        String sql = "INSERT INTO empleados (nombre, apellido, edad, correo, telefono, sueldo) VALUES (?, ?, ?, ?, ?, ?)";

        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, empleado.getNombre());
            pstmt.setString(2, empleado.getApellido());
            pstmt.setInt(3, empleado.getEdad());
            pstmt.setString(4, empleado.getEmail());
            pstmt.setString(5, empleado.getTelefono());
            pstmt.setInt(6, empleado.getSueldo());

            pstmt.executeUpdate();
            System.out.println("Empleado agregado a la base de datos.");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Empleado> getAllEmpleados_DB(Banco banco) {
        String sql = "SELECT id_empleado, nombre, apellido, edad, correo, telefono, sueldo, comision FROM Empleados";
        List<Empleado> empleados = new ArrayList<>();

        try (PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                // Se crea un nuevo objeto Empleado por cada fila en el ResultSet
                int id = rs.getInt("id_empleado");
                String nombre = rs.getString("nombre");
                String apellido = rs.getString("apellido");
                int edad = rs.getInt("edad");
                String correo = rs.getString("correo");
                String telefono = rs.getString("telefono");
                int sueldo = rs.getInt("sueldo");
                double comision = rs.getDouble("comision");

                Empleado empleado = new Empleado(nombre, apellido, edad, correo, telefono, sueldo, banco);
                empleado.setId_empleado(id);
                empleado.setComisionTotal(comision);

                // Se añade el objeto a la lista
                empleados.add(empleado);
            }
            System.out.println("Total de empleados encontrados: " + empleados.size());
        } catch (SQLException e) {
            throw new RuntimeException("Error al obtener todos los empleados de la base de datos.", e);
        }
        return empleados;
    }
}
