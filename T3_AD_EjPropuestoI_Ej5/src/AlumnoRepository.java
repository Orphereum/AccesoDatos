import javax.persistence.*;
import java.util.List;

public class AlumnoRepository {

    private EntityManagerFactory entityManagerFactory;
    private EntityManager entityManager;

    public AlumnoRepository() {
        // Crear el EntityManagerFactory que nos conecta con la base de datos
        entityManagerFactory = Persistence.createEntityManagerFactory("miUnidadDePersistencia"); // Aquí debes especificar el nombre de tu unidad de persistencia
        entityManager = entityManagerFactory.createEntityManager();
    }

    // Método para insertar un Alumno en la base de datos
    public void insertar(Alumno a) {
        EntityTransaction transaction = entityManager.getTransaction();

        try {
            // Iniciar una transacción
            transaction.begin();

            // Guardar el alumno
            entityManager.persist(a);

            // Confirmar la transacción
            transaction.commit();
        } catch (RuntimeException e) {
            if (transaction.isActive()) {
                transaction.rollback(); // Si hay error, deshacer la transacción
            }
            throw e; // Propagar la excepción
        }
    }

    // Método para listar todos los alumnos
    public List<Alumno> listar() {
        String jpql = "from Alumno"; // Consulta JPQL para obtener todos los alumnos
        TypedQuery<Alumno> query = entityManager.createQuery(jpql, Alumno.class);
        return query.getResultList();
    }

    // Cerrar la conexión cuando ya no se necesite
    public void cerrar() {
        entityManager.close();
        entityManagerFactory.close();
    }
}
