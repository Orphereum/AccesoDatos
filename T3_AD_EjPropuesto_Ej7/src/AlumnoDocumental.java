import com.google.gson.*;
import java.io.*;
import java.util.*;

public class AlumnoDocumental {
    private final Gson gson = new GsonBuilder().setPrettyPrinting().create();
    private final String file = "alumnos.json";
    public void guardar(List<Map<String,Object>> alumnos) throws IOException {
        try (Writer w = new FileWriter(file)) { gson.toJson(alumnos, w); }
    }
    public List<Map<String,Object>> leer() throws IOException {
        try (Reader r = new FileReader(file)) {
            return gson.fromJson(r, List.class);
        }
    }
