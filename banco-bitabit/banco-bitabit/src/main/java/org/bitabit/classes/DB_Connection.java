package org.bitabit.classes;

import java.sql.*;

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

            stmt = conn.createStatement();

        } catch (SQLException e){
            throw new RuntimeException(e);
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
        String sql = "INSERT INTO Empleados (nombre, apellido, edad, correo, telefono, sueldo) VALUES (?, ?, ?, ?, ?, ?)";

        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, empleado.getNombre());
            pstmt.setString(2, empleado.getApellido());
            pstmt.setInt(3, empleado.getEdad());
            pstmt.setString(4, empleado.getEmail());
            pstmt.setString(5, empleado.getTelefono());
            pstmt.setInt(6, empleado.getSueldo());

            pstmt.executeUpdate();
            System.out.println("Cliente agregado a la base de datos.");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void addEmpleado_DB(Empleado empleado) {
        String sql = "INSERT INTO Empleados (nombre, apellido, edad, correo, telefono, sueldo) VALUES (?, ?, ?, ?, ?, ?)";

        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, empleado.getNombre());
            pstmt.setString(2, empleado.getApellido());
            pstmt.setInt(3, empleado.getEdad());
            pstmt.setString(4, empleado.getEmail());
            pstmt.setString(5, empleado.getTelefono());
            pstmt.setInt(6, empleado.getSueldo());

            pstmt.executeUpdate();
            System.out.println("Cliente agregado a la base de datos.");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Empleado getEmpleado_DB(int id) {
        String sql = "SELECT id_empleado, nombre, apellido, edad, correo, telefono, sueldo FROM Empleados WHERE id_empleado = ?";
        Empleado empleado = null;

        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);

            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    // Si se encuentra un resultado, crea un nuevo objeto Empleado
                    String nombre = rs.getString("nombre");
                    String apellido = rs.getString("apellido");
                    int edad = rs.getInt("edad");
                    String correo = rs.getString("correo");
                    String telefono = rs.getString("telefono");
                    int sueldo = rs.getInt("sueldo");

                    // Asume que la clase Empleado tiene un constructor adecuado
                    empleado = new Empleado(nombre, apellido, edad, correo, telefono, sueldo);
                    empleado.setId_empleado(id); // Establece el ID del objeto

                    System.out.println("Empleado encontrado: " + nombre + " " + apellido);
                } else {
                    System.out.println("No se encontró ningún empleado con el ID: " + id);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error al obtener empleado de la base de datos.", e);
        }
        return empleado;
    }
}
