import java.sql.SQLException;

public class Main {

    public static void main(String[] args) {
        try {
            AlumnoDAO alumnoDAO = new AlumnoDAO();
            alumnoDAO.mostrarJSON();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
