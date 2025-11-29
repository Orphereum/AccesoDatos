import java.util.List;

public class Main {

    public static void main(String[] args) {
        AlumnoRepository repo = new AlumnoRepository();

        // Insertar un alumno
        Alumno alumno = new Alumno("Alejandra", 27);
        repo.insertar(alumno);
        System.out.println("Alumno insertado: " + alumno.getNombre());

        // Listar todos los alumnos
        List<Alumno> alumnos = repo.listar();
        for (Alumno a : alumnos) {
            System.out.println("Nombre: " + a.getNombre() + ", Edad: " + a.getEdad());
        }

        // Cerrar la conexión
        repo.cerrar();
    }
}
