import java.util.List;
import java.util.Map;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        AlumnoDocumental doc = new AlumnoDocumental();

        List<Map<String, Object>> Lista = List.of(
                Map.of("nombre", "alejandra", "edad", 27, "curso", "1DAM"),
                Map.of("nombre","jose", "edad", "24","curso","2DAM")
        );

        doc.guardar(Lista);

        List<Map<String, Object>> alumnosLeidos = doc.leer();
        System.out.println("Datos leídos del archivo:");
        for (Map<String, Object> alumno : alumnosLeidos) {
            System.out.println(alumno);
        }
    }
}
