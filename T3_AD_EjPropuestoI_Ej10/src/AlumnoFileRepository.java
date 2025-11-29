import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;
import java.util.List;

public class AlumnoFileRepository {

    private File archivo = new File("alumnos.json");

    /**
     * Guarda la lista de alumnos como JSON
     */
    public void guardar(List<String> alumnos) throws IOException {

        BufferedWriter bw = new BufferedWriter(new FileWriter(archivo));

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        bw.write(gson.toJson(alumnos));

        bw.close();
    }

    /**
     * Carga el JSON como lista de Strings
     */
    public List<String> leer() throws IOException {

        if (!archivo.exists()) return null;

        BufferedReader br = new BufferedReader(new FileReader(archivo));

        Gson gson = new Gson();
        List<String> lista = gson.fromJson(br, List.class);

        br.close();
        return lista;
    }
}
