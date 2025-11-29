import java.util.List;

public class AlumnoService {

    private AlumnoDAO dao = new AlumnoDAO();
    private AlumnoFileRepository fileRepo = new AlumnoFileRepository();

    /**
     * Añade un alumno usando el DAO
     */
    public void agregarAlumno(String nombre, int edad) throws Exception {
        dao.insertar(nombre, edad);
        System.out.println("✔ Alumno agregado: " + nombre);
    }

    /**
     * Muestra los alumnos recuperados del DAO y los guarda en archivo
     */
    public void mostrarAlumnos() throws Exception {

        List<String> alumnos = dao.listar();

        System.out.println("\n📋 Lista de alumnos:");
        alumnos.forEach(System.out::println);

        fileRepo.guardar(alumnos);
        System.out.println("\n📁 Alumnos guardados en alumnos.json");
    }
}
