import java.sql.*;

public class AlumnoDAO {

    private Connection connection;

    public AlumnoDAO() throws SQLException {
        // Establecer la conexión a la base de datos
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mi_base_de_datos", "usuario", "contraseña");
    }

    public void mostrarJSON() throws SQLException {
        // Crear la consulta SQL para obtener el nombre y el curso del alumno
        String query = "SELECT nombre, JSON_EXTRACT(datos, '$.curso') AS curso FROM alumnos";
        Statement stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery(query);

        // Procesar los resultados
        while (rs.next()) {
            String nombre = rs.getString("nombre");
            String curso = rs.getString("curso");

            // Mostrar los resultados
            System.out.println("Nombre: " + nombre + ", Curso: " + curso);
        }

        // Cerrar la conexión
        rs.close();
        stmt.close();
    }
}
