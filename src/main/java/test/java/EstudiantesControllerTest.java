package test.java;

import View.ConsoleView;
import controller.ControllerEstudiante;
import da.EstudiantesDao;
import models.ModelEstudiante;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.sql.SQLException;

import static org.mockito.Mockito.*;
import static org.mockito.Mockito.verify;

public class EstudiantesControllerTest {
    @Mock
    private EstudiantesDao mockEstudiantesDao;
    @Mock
    private ConsoleView mockView;
    @InjectMocks
    private ControllerEstudiante controllerEstudiante;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testObtenerEstudiantes() throws SQLException {
        when(mockEstudiantesDao.obtenerEstudiantes()).thenReturn(null);

        controllerEstudiante.obtenerEstudiantes();

        verify(mockView).mostrarMensaje("id:2 | nombre:20000 | identificacion:Email | email:Activo | estado:200802 | fechaNacimiento:200802");

    }


    @Test
    public void testModificarEstudiantes() throws SQLException {

        String id = "2";
        String nombre = "20000";
        String identificacion = "Email";
        String email = "Activo";
        String estado = "200802";
        String fechaNacimiento = "200802";

        ModelEstudiante mockEstudiante = new ModelEstudiante(nombre, identificacion, email, estado,fechaNacimiento);
        mockEstudiante.setId(id);

        doNothing().when(mockEstudiantesDao).modificarEstudiantes(mockEstudiante);


        controllerEstudiante.modificarEstudiantes(nombre, identificacion, email, estado,fechaNacimiento,id);


        verify(mockView).mostrarMensaje("Datos actualizados");
    }


    @Test
    public void testEliminarEstudiantes() throws SQLException {

        String id = "7";

        doNothing().when(mockEstudiantesDao).eliminarEstudiantes(id);

        controllerEstudiante.eliminarEstudiantes(id);
        verify(mockView).mostrarMensaje("Estudiante eliminado correctamente");
    }

}
