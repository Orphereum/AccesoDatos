//3. Crea un componente Java llamado AlumnoFileRepository que guarde y lea nombres de alumnos
// en un archivo de texto alumnos.txt. Sigue los siguientes pasos: crear una clase llamada AlumnoFileRepository
// y crear una variable privada final con el fichero alumnos.txt. Crear los siguientes métodos:
//
// a) public void guardar(List alumnos) throws IOException.
//Escribe en el fichero todos los nombres de alumnos, uno por línea, sobrescribiendo el archivo.
//
// b) public List cargar() throws IOException.
//Lee el fichero línea a línea y devuelve una lista con todos los nombres almacenados.
//
//c) public static void main(String[] args) throws IOException.
//Debe centralizar toda la lógica del ejercicio probando los métodos de la clase anterior.

import java.io.*;
import java.util.*;

public static void main(String[] args) throws IOException {
//centralizar lógica del ejercicio haciendo uso de los metodos
    AlumnoFileRepository alumno = new AlumnoFileRepository();
    alumno.guardar(List.of("Ana,20", "jose,24", "Alejandra, 27"));
    System.out.println("Datos leidos: " + alumno.cargar());
}
public static class AlumnoFileRepository {
    //variable privada final para el fichero alumnos.txt
    private final String fileName = "alumnos.txt";

    //metodo guardar
    public void guardar(List<String> alumnos) throws IOException {
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileName))) {
                for (String a : alumnos) {
                    bw.write(a);
                    bw.newLine();
                }
            }
    }
    //metodo cargar
    public List<String> cargar () throws IOException {
        List<String> lista = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                lista.add(linea);
            }
        }
        return lista;
    }
}
