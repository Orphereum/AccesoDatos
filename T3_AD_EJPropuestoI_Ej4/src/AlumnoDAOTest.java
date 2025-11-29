import JUnit;

@Test
public class AlumnoDAOTest {

    AlumnoDao dao = new AlumnoDAO();
    //assert para prueba unitaria
    assert DoesNotThrow()->dao.insertar;

}
