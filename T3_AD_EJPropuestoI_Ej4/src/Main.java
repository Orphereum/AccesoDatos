//4. Desarrolla un componente AlumnoDAO que inserte
// y liste alumnos desde la base de datos escuela.
// Sigue los siguientes pasos: crear la clase AlumnoDAO y
// declarar en variables privadas y finales la url, el usuario y el password
// de la conexión a la base de datos. Implementar los siguientes métodos:
//
// a) public void insertar(String nombre, int edad) throws SQLException
//Inserta un nuevo alumno en la tabla alumno usando una sentencia SQL parametrizada.
//
// b) public List listar() throws SQLException.
// Consulta la tabla alumno y devuelve una lista con todos los nombres obtenidos de la base de datos.
//
//c) public static void main(String[] args) throws SQLException. Debe centralizar toda la lógica del ejercicio probando los métodos de la clase anterior.
import java.sql.*;
import java.util.*;
public  void main() throws SQLException {

//objeto de la clase
    AlumnoDAO alumno = new AlumnoDAO();

//insertamos usuarios
alumno.insertar("Alejandra", 27);
alumno.insertar("Jose", 24);
//listamos usuarios
    System.out.println(alumno.listar());
}
static class AlumnoDAO{
    //informacion para conectar con la bbdd
    private final String url = " jdbc:mysql://localhost:3306/clase";
    private final String user = "root";
    private final String pass = "root";
//metodo insertar
public void insertar(String nombre, int edad) throws SQLException {
    String sql = "INSERT INTO alumno(nombre, edad) VALUES (?, ?)";
    try (Connection conn = DriverManager.getConnection(url, user, pass);
    PreparedStatement ps = conn.prepareStatement(sql)) {
        ps.setString(1, nombre);
        ps.setInt(2, edad);
        ps.executeUpdate();
    }
}


//metodo listar
public List<String> listar() throws SQLException {
    List<String> alumnos = new ArrayList<>();
    try (Connection con = DriverManager.getConnection(url, user, pass);
         Statement st = con.createStatement();
         ResultSet rs = st.executeQuery("SELECT nombre FROM alumno")) {
        while (rs.next()) {
            alumnos.add(rs.getString("nombre"));
        }
    }
    return alumnos;
}
}
