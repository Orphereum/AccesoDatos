public class MainApp {

    public static void main(String[] args) throws Exception {

        AlumnoService service = new AlumnoService();

        // Inserción de ejemplo
        service.agregarAlumno("Lucía", 20);
        service.agregarAlumno("Carlos", 22);

        // Mostrar y guardar los alumnos
        service.mostrarAlumnos();

        System.out.println("\nPrograma finalizado.");
    }
}
