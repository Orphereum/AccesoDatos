package org.example;

import java.sql.*;

public class AlumnoDAO {

    private Connection conexion;

    public AlumnoDAO() {
        try {
            conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/mi_base_de_datos", "usuario", "contraseña");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insertar(String nombre, int edad) {
        String sql = "INSERT INTO alumnos (nombre, edad) VALUES (?, ?)";

        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setString(1, nombre);
            stmt.setInt(2, edad);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Error al insertar alumno", e);
        }
    }
}
