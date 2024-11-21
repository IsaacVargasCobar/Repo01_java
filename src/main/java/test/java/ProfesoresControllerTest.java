package test.java;

import View.ConsoleView;
import controller.ControllerProfesor;
import da.ProfesoresDao;
import models.ModelProfesor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.sql.SQLException;

import static org.mockito.Mockito.*;
import static org.mockito.Mockito.verify;

public class ProfesoresControllerTest {
    @Mock
    private ProfesoresDao mockProfesoresDao;

    @Mock
    private ConsoleView mockView;

    @InjectMocks
    private ControllerProfesor controllerProfesor;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testObtenerProfesores() throws SQLException {
        when(mockProfesoresDao.obtenerProfesores()).thenReturn(null);

        controllerProfesor.obtenerProfesores();

        verify(mockView).mostrarMensaje("id:1 | nombre:Mario | identificacion:2000 | email:Emial.com | estado:Inactivo | departamento:Informatica");

    }



    @Test
    public void testModificarProfesores() throws SQLException {

        String id = "1";
        String nombre = "Mario";
        String identificacion = "2000";
        String email = "Emial.com";
        String estado = "Inactivo";
        String departamento = "Informatica";

        ModelProfesor mockProfesor = new ModelProfesor(nombre, identificacion, email, estado,departamento);
        mockProfesor.setId(id);

        doNothing().when(mockProfesoresDao).modificarProfesores(mockProfesor);


        controllerProfesor.modificarProfesores(nombre, identificacion, email, estado,departamento,id);


        verify(mockView).mostrarMensaje("Datos actualizados");
    }


    @Test
    public void testEliminarProfesores() throws SQLException {

        String id = "1";

        doNothing().when(mockProfesoresDao).eliminarProfesores(id);

        controllerProfesor.eliminarProfesores(id);
        verify(mockView).mostrarMensaje("Profesor eliminado correctamente");
    }
    @Test
    public void testCrearEstudiantes() throws SQLException {



        String nombre = "Moises";
        String identificacion = "8000";
        String email = "MoisesEmial.com";
        String estado = "Activo";
        String departamento = "Informatica";

        ModelProfesor mockProfesor = new ModelProfesor(nombre, identificacion, email, estado,departamento);


        doNothing().when(mockProfesoresDao).agregarProfesores(mockProfesor);


        controllerProfesor.agregarProfesores(nombre, identificacion, email, estado,departamento);


        verify(mockView).mostrarMensaje("Datos insertados");

    }
}
