package org.example;

import java.sql.*;

public class Main {
    public static void main(String[] args) {

        String url = "jdbc:oracle:thin:@localhost:1521:xe";
        String usuario = "RIBERA";
        String contraseña = "ribera";

        // INSERTAR DEPARTAMENTOS
        try (Connection conn = DriverManager.getConnection(url, usuario, contraseña)) {

            String sqlDep = "INSERT INTO DEPARTAMENTO (id, nombre) VALUES (?, ?)";

            try (PreparedStatement ps = conn.prepareStatement(sqlDep)) {
                // Dept 1
                ps.setInt(1, 10);
                ps.setString(2, "SISTEMAS");
                ps.executeUpdate();

                // Dept 2
                ps.setInt(1, 20);
                ps.setString(2, "CONTABILIDAD");
                ps.executeUpdate();

                System.out.println("Departamentos insertados correctamente.");
            }

            // INSERTAR EMPLEADOS
            String sqlEmp = "INSERT INTO EMPLEADO (id, nombre, salario, departamento_id) VALUES (?, ?, ?, ?)";

            try (PreparedStatement ps = conn.prepareStatement(sqlEmp)) {
                ps.setInt(1, 101);
                ps.setString(2, "Unai");
                ps.setDouble(3, 4500.0);
                ps.setInt(4, 10);
                ps.executeUpdate();

                ps.setInt(1, 201);
                ps.setString(2, "Chema");
                ps.setDouble(3, 3800.0);
                ps.setInt(4, 20);
                ps.executeUpdate();

                ps.setInt(1, 102);
                ps.setString(2, "Luz");
                ps.setDouble(3, 4200.0);
                ps.setInt(4, 10);
                ps.executeUpdate();

                System.out.println("Empleados asignados correctamente.");
            }

        } catch (SQLException e) {
            System.out.println("Error al insertar datos: " + e.getMessage());
        }
    }
}
