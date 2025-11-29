import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AlumnoDAO {

    private static final String URL = "jdbc:mysql://localhost:3306/Escuela";
    private static final String USER = "root";
    private static final String PASS = "root";

    /**
     * Inserta un alumno en la tabla
     */
    public void insertar(String nombre, int edad) throws Exception {

        Connection con = DriverManager.getConnection(URL, USER, PASS);

        String sql = "INSERT INTO alumno(nombre, edad) VALUES (?, ?)";
        PreparedStatement ps = con.prepareStatement(sql);

        ps.setString(1, nombre);
        ps.setInt(2, edad);

        ps.executeUpdate();
        ps.close();
        con.close();
    }

    /**
     * Devuelve una lista de nombres de alumnos
     */
    public List<String> listar() throws Exception {

        Connection con = DriverManager.getConnection(URL, USER, PASS);

        String sql = "SELECT nombre, edad FROM alumno";
        PreparedStatement ps = con.prepareStatement(sql);

        ResultSet rs = ps.executeQuery();

        List<String> lista = new ArrayList<>();

        while (rs.next()) {
            lista.add(rs.getString("nombre") + " - " + rs.getInt("edad"));
        }

        rs.close();
        ps.close();
        con.close();

        return lista;
    }
}
